package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paisww_impl extends GXDataArea
{
   public paisww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paisww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisww_impl.class ));
   }

   public paisww_impl( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbPaiDiaHsPExt = new HTMLChoice();
      chkPaiFondoCese = UIFactory.getCheckbox(this);
      cmbPaiPerVacDes = new HTMLChoice();
      cmbPaiPerVacHas = new HTMLChoice();
      chkPaiExcVizzoti = UIFactory.getCheckbox(this);
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
            AV67MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67MenuOpcCod", AV67MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV67MenuOpcCod, ""))));
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
      AV78ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV19ColumnsSelector);
      AV91Pgmname = httpContext.GetPar( "Pgmname") ;
      AV67MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV22TFPaiCod = (short)(GXutil.lval( httpContext.GetPar( "TFPaiCod"))) ;
      AV23TFPaiCod_To = (short)(GXutil.lval( httpContext.GetPar( "TFPaiCod_To"))) ;
      AV25TFPaiNom = httpContext.GetPar( "TFPaiNom") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV26TFPaiNom_Sels);
      AV43TFPaiReligDefault = httpContext.GetPar( "TFPaiReligDefault") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV44TFPaiReligDefault_Sels);
      AV45TFPaiMesHsPExt = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiMesHsPExt"), ".") ;
      AV46TFPaiMesHsPExt_To = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiMesHsPExt_To"), ".") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV48TFPaiDiaHsPExt_Sels);
      AV49TFPaiFondoCese_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFPaiFondoCese_Sel"))) ;
      AV50TFPaiMaxHorNor = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiMaxHorNor"), ".") ;
      AV51TFPaiMaxHorNor_To = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiMaxHorNor_To"), ".") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV53TFPaiPerVacDes_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV55TFPaiPerVacHas_Sels);
      AV63TFPaiFracVacAnt = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiFracVacAnt"), ".") ;
      AV64TFPaiFracVacAnt_To = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiFracVacAnt_To"), ".") ;
      AV56TFPaiGuarEdadMin = (byte)(GXutil.lval( httpContext.GetPar( "TFPaiGuarEdadMin"))) ;
      AV57TFPaiGuarEdadMin_To = (byte)(GXutil.lval( httpContext.GetPar( "TFPaiGuarEdadMin_To"))) ;
      AV58TFPaiGuarEdadMax = (byte)(GXutil.lval( httpContext.GetPar( "TFPaiGuarEdadMax"))) ;
      AV59TFPaiGuarEdadMax_To = (byte)(GXutil.lval( httpContext.GetPar( "TFPaiGuarEdadMax_To"))) ;
      AV60TFPaiExcVizzoti_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFPaiExcVizzoti_Sel"))) ;
      AV61TFPaiVizzoti = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiVizzoti"), ".") ;
      AV62TFPaiVizzoti_To = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiVizzoti_To"), ".") ;
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV36CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV33IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV69WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV19ColumnsSelector, AV91Pgmname, AV67MenuOpcCod, AV12GridState, AV22TFPaiCod, AV23TFPaiCod_To, AV25TFPaiNom, AV26TFPaiNom_Sels, AV43TFPaiReligDefault, AV44TFPaiReligDefault_Sels, AV45TFPaiMesHsPExt, AV46TFPaiMesHsPExt_To, AV48TFPaiDiaHsPExt_Sels, AV49TFPaiFondoCese_Sel, AV50TFPaiMaxHorNor, AV51TFPaiMaxHorNor_To, AV53TFPaiPerVacDes_Sels, AV55TFPaiPerVacHas_Sels, AV63TFPaiFracVacAnt, AV64TFPaiFracVacAnt_To, AV56TFPaiGuarEdadMin, AV57TFPaiGuarEdadMin_To, AV58TFPaiGuarEdadMax, AV59TFPaiGuarEdadMax_To, AV60TFPaiExcVizzoti_Sel, AV61TFPaiVizzoti, AV62TFPaiVizzoti_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV33IsAuthorized_Update, AV69WelcomeMessage_NoMostrarMas) ;
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
      paCR2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startCR2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paisww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV67MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV91Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV67MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV33IsAuthorized_Update));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV27DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV27DDO_TitleSettingsIcons);
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV76ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV76ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV29GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV30GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV31GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV78ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV91Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV91Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV67MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV67MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAICOD", GXutil.ltrim( localUtil.ntoc( AV22TFPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAICOD_TO", GXutil.ltrim( localUtil.ntoc( AV23TFPaiCod_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAINOM", AV25TFPaiNom);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAINOM_SELS", AV26TFPaiNom_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAINOM_SELS", AV26TFPaiNom_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIRELIGDEFAULT", GXutil.rtrim( AV43TFPaiReligDefault));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAIRELIGDEFAULT_SELS", AV44TFPaiReligDefault_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAIRELIGDEFAULT_SELS", AV44TFPaiReligDefault_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIMESHSPEXT", GXutil.ltrim( localUtil.ntoc( AV45TFPaiMesHsPExt, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIMESHSPEXT_TO", GXutil.ltrim( localUtil.ntoc( AV46TFPaiMesHsPExt_To, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAIDIAHSPEXT_SELS", AV48TFPaiDiaHsPExt_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAIDIAHSPEXT_SELS", AV48TFPaiDiaHsPExt_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIFONDOCESE_SEL", GXutil.ltrim( localUtil.ntoc( AV49TFPaiFondoCese_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIMAXHORNOR", GXutil.ltrim( localUtil.ntoc( AV50TFPaiMaxHorNor, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIMAXHORNOR_TO", GXutil.ltrim( localUtil.ntoc( AV51TFPaiMaxHorNor_To, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAIPERVACDES_SELS", AV53TFPaiPerVacDes_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAIPERVACDES_SELS", AV53TFPaiPerVacDes_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAIPERVACHAS_SELS", AV55TFPaiPerVacHas_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAIPERVACHAS_SELS", AV55TFPaiPerVacHas_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIFRACVACANT", GXutil.ltrim( localUtil.ntoc( AV63TFPaiFracVacAnt, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIFRACVACANT_TO", GXutil.ltrim( localUtil.ntoc( AV64TFPaiFracVacAnt_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIGUAREDADMIN", GXutil.ltrim( localUtil.ntoc( AV56TFPaiGuarEdadMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIGUAREDADMIN_TO", GXutil.ltrim( localUtil.ntoc( AV57TFPaiGuarEdadMin_To, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIGUAREDADMAX", GXutil.ltrim( localUtil.ntoc( AV58TFPaiGuarEdadMax, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIGUAREDADMAX_TO", GXutil.ltrim( localUtil.ntoc( AV59TFPaiGuarEdadMax_To, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIEXCVIZZOTI_SEL", GXutil.ltrim( localUtil.ntoc( AV60TFPaiExcVizzoti_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIVIZZOTI", GXutil.ltrim( localUtil.ntoc( AV61TFPaiVizzoti, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIVIZZOTI_TO", GXutil.ltrim( localUtil.ntoc( AV62TFPaiVizzoti_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV36CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV33IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV33IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAINOM_SELSJSON", AV24TFPaiNom_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIRELIGDEFAULT_SELSJSON", AV42TFPaiReligDefault_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIDIAHSPEXT_SELSJSON", AV47TFPaiDiaHsPExt_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIPERVACDES_SELSJSON", AV52TFPaiPerVacDes_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIPERVACHAS_SELSJSON", AV54TFPaiPerVacHas_SelsJson);
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
         weCR2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtCR2( ) ;
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
      return formatLink("web.paisww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV67MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "PaisWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Pais", "") ;
   }

   public void wbCR0( )
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
         wb_table1_9_CR2( true) ;
      }
      else
      {
         wb_table1_9_CR2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_CR2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV27DDO_TitleSettingsIcons);
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

   public void startCR2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Pais", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupCR0( ) ;
   }

   public void wsCR2( )
   {
      startCR2( ) ;
      evtCR2( ) ;
   }

   public void evtCR2( )
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
                           e11CR2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12CR2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13CR2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14CR2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15CR2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e16CR2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17CR2 ();
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
                           A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A312PaiNom = GXutil.upper( httpContext.cgiGet( edtPaiNom_Internalname)) ;
                           A1252PaiReligDefault = httpContext.cgiGet( edtPaiReligDefault_Internalname) ;
                           n1252PaiReligDefault = false ;
                           A1271PaiMesHsPExt = localUtil.ctond( httpContext.cgiGet( edtPaiMesHsPExt_Internalname)) ;
                           cmbPaiDiaHsPExt.setName( cmbPaiDiaHsPExt.getInternalname() );
                           cmbPaiDiaHsPExt.setValue( httpContext.cgiGet( cmbPaiDiaHsPExt.getInternalname()) );
                           A1272PaiDiaHsPExt = httpContext.cgiGet( cmbPaiDiaHsPExt.getInternalname()) ;
                           A1402PaiFondoCese = GXutil.strtobool( httpContext.cgiGet( chkPaiFondoCese.getInternalname())) ;
                           A1405PaiMaxHorNor = localUtil.ctond( httpContext.cgiGet( edtPaiMaxHorNor_Internalname)) ;
                           cmbPaiPerVacDes.setName( cmbPaiPerVacDes.getInternalname() );
                           cmbPaiPerVacDes.setValue( httpContext.cgiGet( cmbPaiPerVacDes.getInternalname()) );
                           A1521PaiPerVacDes = (byte)(GXutil.lval( httpContext.cgiGet( cmbPaiPerVacDes.getInternalname()))) ;
                           cmbPaiPerVacHas.setName( cmbPaiPerVacHas.getInternalname() );
                           cmbPaiPerVacHas.setValue( httpContext.cgiGet( cmbPaiPerVacHas.getInternalname()) );
                           A1522PaiPerVacHas = (byte)(GXutil.lval( httpContext.cgiGet( cmbPaiPerVacHas.getInternalname()))) ;
                           A1814PaiFracVacAnt = localUtil.ctond( httpContext.cgiGet( edtPaiFracVacAnt_Internalname)) ;
                           A1625PaiGuarEdadMin = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiGuarEdadMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1626PaiGuarEdadMax = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiGuarEdadMax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1736PaiExcVizzoti = GXutil.strtobool( httpContext.cgiGet( chkPaiExcVizzoti.getInternalname())) ;
                           A1737PaiVizzoti = localUtil.ctond( httpContext.cgiGet( edtPaiVizzoti_Internalname)) ;
                           AV32Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV32Update);
                           AV38Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV38Display);
                           AV65VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV65VerSVG);
                           AV66ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV66ModificarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e18CR2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e19CR2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20CR2 ();
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

   public void weCR2( )
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

   public void paCR2( )
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
                                 byte AV78ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ,
                                 String AV91Pgmname ,
                                 String AV67MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 short AV22TFPaiCod ,
                                 short AV23TFPaiCod_To ,
                                 String AV25TFPaiNom ,
                                 GXSimpleCollection<String> AV26TFPaiNom_Sels ,
                                 String AV43TFPaiReligDefault ,
                                 GXSimpleCollection<String> AV44TFPaiReligDefault_Sels ,
                                 java.math.BigDecimal AV45TFPaiMesHsPExt ,
                                 java.math.BigDecimal AV46TFPaiMesHsPExt_To ,
                                 GXSimpleCollection<String> AV48TFPaiDiaHsPExt_Sels ,
                                 byte AV49TFPaiFondoCese_Sel ,
                                 java.math.BigDecimal AV50TFPaiMaxHorNor ,
                                 java.math.BigDecimal AV51TFPaiMaxHorNor_To ,
                                 GXSimpleCollection<Byte> AV53TFPaiPerVacDes_Sels ,
                                 GXSimpleCollection<Byte> AV55TFPaiPerVacHas_Sels ,
                                 java.math.BigDecimal AV63TFPaiFracVacAnt ,
                                 java.math.BigDecimal AV64TFPaiFracVacAnt_To ,
                                 byte AV56TFPaiGuarEdadMin ,
                                 byte AV57TFPaiGuarEdadMin_To ,
                                 byte AV58TFPaiGuarEdadMax ,
                                 byte AV59TFPaiGuarEdadMax_To ,
                                 byte AV60TFPaiExcVizzoti_Sel ,
                                 java.math.BigDecimal AV61TFPaiVizzoti ,
                                 java.math.BigDecimal AV62TFPaiVizzoti_To ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV36CliCod ,
                                 boolean AV33IsAuthorized_Update ,
                                 boolean AV69WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e19CR2 ();
      GRID_nCurrentRecord = 0 ;
      rfCR2( ) ;
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
      AV69WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV69WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69WelcomeMessage_NoMostrarMas", AV69WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfCR2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV91Pgmname = "PaisWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
   }

   public void rfCR2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(108) ;
      /* Execute user event: Refresh */
      e19CR2 ();
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
                                              A312PaiNom ,
                                              AV95Paiswwds_4_tfpainom_sels ,
                                              A1252PaiReligDefault ,
                                              AV97Paiswwds_6_tfpaireligdefault_sels ,
                                              A1272PaiDiaHsPExt ,
                                              AV100Paiswwds_9_tfpaidiahspext_sels ,
                                              Byte.valueOf(A1521PaiPerVacDes) ,
                                              AV104Paiswwds_13_tfpaipervacdes_sels ,
                                              Byte.valueOf(A1522PaiPerVacHas) ,
                                              AV105Paiswwds_14_tfpaipervachas_sels ,
                                              Short.valueOf(AV92Paiswwds_1_tfpaicod) ,
                                              Short.valueOf(AV93Paiswwds_2_tfpaicod_to) ,
                                              Integer.valueOf(AV95Paiswwds_4_tfpainom_sels.size()) ,
                                              AV94Paiswwds_3_tfpainom ,
                                              Integer.valueOf(AV97Paiswwds_6_tfpaireligdefault_sels.size()) ,
                                              AV96Paiswwds_5_tfpaireligdefault ,
                                              AV98Paiswwds_7_tfpaimeshspext ,
                                              AV99Paiswwds_8_tfpaimeshspext_to ,
                                              Integer.valueOf(AV100Paiswwds_9_tfpaidiahspext_sels.size()) ,
                                              Byte.valueOf(AV101Paiswwds_10_tfpaifondocese_sel) ,
                                              AV102Paiswwds_11_tfpaimaxhornor ,
                                              AV103Paiswwds_12_tfpaimaxhornor_to ,
                                              Integer.valueOf(AV104Paiswwds_13_tfpaipervacdes_sels.size()) ,
                                              Integer.valueOf(AV105Paiswwds_14_tfpaipervachas_sels.size()) ,
                                              AV106Paiswwds_15_tfpaifracvacant ,
                                              AV107Paiswwds_16_tfpaifracvacant_to ,
                                              Byte.valueOf(AV108Paiswwds_17_tfpaiguaredadmin) ,
                                              Byte.valueOf(AV109Paiswwds_18_tfpaiguaredadmin_to) ,
                                              Byte.valueOf(AV110Paiswwds_19_tfpaiguaredadmax) ,
                                              Byte.valueOf(AV111Paiswwds_20_tfpaiguaredadmax_to) ,
                                              Byte.valueOf(AV112Paiswwds_21_tfpaiexcvizzoti_sel) ,
                                              AV113Paiswwds_22_tfpaivizzoti ,
                                              AV114Paiswwds_23_tfpaivizzoti_to ,
                                              Short.valueOf(A46PaiCod) ,
                                              A1271PaiMesHsPExt ,
                                              Boolean.valueOf(A1402PaiFondoCese) ,
                                              A1405PaiMaxHorNor ,
                                              A1814PaiFracVacAnt ,
                                              Byte.valueOf(A1625PaiGuarEdadMin) ,
                                              Byte.valueOf(A1626PaiGuarEdadMax) ,
                                              Boolean.valueOf(A1736PaiExcVizzoti) ,
                                              A1737PaiVizzoti ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                              TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV94Paiswwds_3_tfpainom = GXutil.concat( GXutil.rtrim( AV94Paiswwds_3_tfpainom), "%", "") ;
         lV96Paiswwds_5_tfpaireligdefault = GXutil.padr( GXutil.rtrim( AV96Paiswwds_5_tfpaireligdefault), 20, "%") ;
         /* Using cursor H00CR2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV92Paiswwds_1_tfpaicod), Short.valueOf(AV93Paiswwds_2_tfpaicod_to), lV94Paiswwds_3_tfpainom, lV96Paiswwds_5_tfpaireligdefault, AV98Paiswwds_7_tfpaimeshspext, AV99Paiswwds_8_tfpaimeshspext_to, AV102Paiswwds_11_tfpaimaxhornor, AV103Paiswwds_12_tfpaimaxhornor_to, AV106Paiswwds_15_tfpaifracvacant, AV107Paiswwds_16_tfpaifracvacant_to, Byte.valueOf(AV108Paiswwds_17_tfpaiguaredadmin), Byte.valueOf(AV109Paiswwds_18_tfpaiguaredadmin_to), Byte.valueOf(AV110Paiswwds_19_tfpaiguaredadmax), Byte.valueOf(AV111Paiswwds_20_tfpaiguaredadmax_to), AV113Paiswwds_22_tfpaivizzoti, AV114Paiswwds_23_tfpaivizzoti_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_108_idx = 1 ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1737PaiVizzoti = H00CR2_A1737PaiVizzoti[0] ;
            A1736PaiExcVizzoti = H00CR2_A1736PaiExcVizzoti[0] ;
            A1626PaiGuarEdadMax = H00CR2_A1626PaiGuarEdadMax[0] ;
            A1625PaiGuarEdadMin = H00CR2_A1625PaiGuarEdadMin[0] ;
            A1814PaiFracVacAnt = H00CR2_A1814PaiFracVacAnt[0] ;
            A1522PaiPerVacHas = H00CR2_A1522PaiPerVacHas[0] ;
            A1521PaiPerVacDes = H00CR2_A1521PaiPerVacDes[0] ;
            A1405PaiMaxHorNor = H00CR2_A1405PaiMaxHorNor[0] ;
            A1402PaiFondoCese = H00CR2_A1402PaiFondoCese[0] ;
            A1272PaiDiaHsPExt = H00CR2_A1272PaiDiaHsPExt[0] ;
            A1271PaiMesHsPExt = H00CR2_A1271PaiMesHsPExt[0] ;
            A1252PaiReligDefault = H00CR2_A1252PaiReligDefault[0] ;
            n1252PaiReligDefault = H00CR2_n1252PaiReligDefault[0] ;
            A312PaiNom = H00CR2_A312PaiNom[0] ;
            A46PaiCod = H00CR2_A46PaiCod[0] ;
            e20CR2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(108) ;
         wbCR0( ) ;
      }
      bGXsfl_108_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesCR2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV91Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV91Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV67MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV67MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV36CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV33IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV33IsAuthorized_Update));
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
      AV92Paiswwds_1_tfpaicod = AV22TFPaiCod ;
      AV93Paiswwds_2_tfpaicod_to = AV23TFPaiCod_To ;
      AV94Paiswwds_3_tfpainom = AV25TFPaiNom ;
      AV95Paiswwds_4_tfpainom_sels = AV26TFPaiNom_Sels ;
      AV96Paiswwds_5_tfpaireligdefault = AV43TFPaiReligDefault ;
      AV97Paiswwds_6_tfpaireligdefault_sels = AV44TFPaiReligDefault_Sels ;
      AV98Paiswwds_7_tfpaimeshspext = AV45TFPaiMesHsPExt ;
      AV99Paiswwds_8_tfpaimeshspext_to = AV46TFPaiMesHsPExt_To ;
      AV100Paiswwds_9_tfpaidiahspext_sels = AV48TFPaiDiaHsPExt_Sels ;
      AV101Paiswwds_10_tfpaifondocese_sel = AV49TFPaiFondoCese_Sel ;
      AV102Paiswwds_11_tfpaimaxhornor = AV50TFPaiMaxHorNor ;
      AV103Paiswwds_12_tfpaimaxhornor_to = AV51TFPaiMaxHorNor_To ;
      AV104Paiswwds_13_tfpaipervacdes_sels = AV53TFPaiPerVacDes_Sels ;
      AV105Paiswwds_14_tfpaipervachas_sels = AV55TFPaiPerVacHas_Sels ;
      AV106Paiswwds_15_tfpaifracvacant = AV63TFPaiFracVacAnt ;
      AV107Paiswwds_16_tfpaifracvacant_to = AV64TFPaiFracVacAnt_To ;
      AV108Paiswwds_17_tfpaiguaredadmin = AV56TFPaiGuarEdadMin ;
      AV109Paiswwds_18_tfpaiguaredadmin_to = AV57TFPaiGuarEdadMin_To ;
      AV110Paiswwds_19_tfpaiguaredadmax = AV58TFPaiGuarEdadMax ;
      AV111Paiswwds_20_tfpaiguaredadmax_to = AV59TFPaiGuarEdadMax_To ;
      AV112Paiswwds_21_tfpaiexcvizzoti_sel = AV60TFPaiExcVizzoti_Sel ;
      AV113Paiswwds_22_tfpaivizzoti = AV61TFPaiVizzoti ;
      AV114Paiswwds_23_tfpaivizzoti_to = AV62TFPaiVizzoti_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A312PaiNom ,
                                           AV95Paiswwds_4_tfpainom_sels ,
                                           A1252PaiReligDefault ,
                                           AV97Paiswwds_6_tfpaireligdefault_sels ,
                                           A1272PaiDiaHsPExt ,
                                           AV100Paiswwds_9_tfpaidiahspext_sels ,
                                           Byte.valueOf(A1521PaiPerVacDes) ,
                                           AV104Paiswwds_13_tfpaipervacdes_sels ,
                                           Byte.valueOf(A1522PaiPerVacHas) ,
                                           AV105Paiswwds_14_tfpaipervachas_sels ,
                                           Short.valueOf(AV92Paiswwds_1_tfpaicod) ,
                                           Short.valueOf(AV93Paiswwds_2_tfpaicod_to) ,
                                           Integer.valueOf(AV95Paiswwds_4_tfpainom_sels.size()) ,
                                           AV94Paiswwds_3_tfpainom ,
                                           Integer.valueOf(AV97Paiswwds_6_tfpaireligdefault_sels.size()) ,
                                           AV96Paiswwds_5_tfpaireligdefault ,
                                           AV98Paiswwds_7_tfpaimeshspext ,
                                           AV99Paiswwds_8_tfpaimeshspext_to ,
                                           Integer.valueOf(AV100Paiswwds_9_tfpaidiahspext_sels.size()) ,
                                           Byte.valueOf(AV101Paiswwds_10_tfpaifondocese_sel) ,
                                           AV102Paiswwds_11_tfpaimaxhornor ,
                                           AV103Paiswwds_12_tfpaimaxhornor_to ,
                                           Integer.valueOf(AV104Paiswwds_13_tfpaipervacdes_sels.size()) ,
                                           Integer.valueOf(AV105Paiswwds_14_tfpaipervachas_sels.size()) ,
                                           AV106Paiswwds_15_tfpaifracvacant ,
                                           AV107Paiswwds_16_tfpaifracvacant_to ,
                                           Byte.valueOf(AV108Paiswwds_17_tfpaiguaredadmin) ,
                                           Byte.valueOf(AV109Paiswwds_18_tfpaiguaredadmin_to) ,
                                           Byte.valueOf(AV110Paiswwds_19_tfpaiguaredadmax) ,
                                           Byte.valueOf(AV111Paiswwds_20_tfpaiguaredadmax_to) ,
                                           Byte.valueOf(AV112Paiswwds_21_tfpaiexcvizzoti_sel) ,
                                           AV113Paiswwds_22_tfpaivizzoti ,
                                           AV114Paiswwds_23_tfpaivizzoti_to ,
                                           Short.valueOf(A46PaiCod) ,
                                           A1271PaiMesHsPExt ,
                                           Boolean.valueOf(A1402PaiFondoCese) ,
                                           A1405PaiMaxHorNor ,
                                           A1814PaiFracVacAnt ,
                                           Byte.valueOf(A1625PaiGuarEdadMin) ,
                                           Byte.valueOf(A1626PaiGuarEdadMax) ,
                                           Boolean.valueOf(A1736PaiExcVizzoti) ,
                                           A1737PaiVizzoti ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV94Paiswwds_3_tfpainom = GXutil.concat( GXutil.rtrim( AV94Paiswwds_3_tfpainom), "%", "") ;
      lV96Paiswwds_5_tfpaireligdefault = GXutil.padr( GXutil.rtrim( AV96Paiswwds_5_tfpaireligdefault), 20, "%") ;
      /* Using cursor H00CR3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV92Paiswwds_1_tfpaicod), Short.valueOf(AV93Paiswwds_2_tfpaicod_to), lV94Paiswwds_3_tfpainom, lV96Paiswwds_5_tfpaireligdefault, AV98Paiswwds_7_tfpaimeshspext, AV99Paiswwds_8_tfpaimeshspext_to, AV102Paiswwds_11_tfpaimaxhornor, AV103Paiswwds_12_tfpaimaxhornor_to, AV106Paiswwds_15_tfpaifracvacant, AV107Paiswwds_16_tfpaifracvacant_to, Byte.valueOf(AV108Paiswwds_17_tfpaiguaredadmin), Byte.valueOf(AV109Paiswwds_18_tfpaiguaredadmin_to), Byte.valueOf(AV110Paiswwds_19_tfpaiguaredadmax), Byte.valueOf(AV111Paiswwds_20_tfpaiguaredadmax_to), AV113Paiswwds_22_tfpaivizzoti, AV114Paiswwds_23_tfpaivizzoti_to});
      GRID_nRecordCount = H00CR3_AGRID_nRecordCount[0] ;
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
      AV92Paiswwds_1_tfpaicod = AV22TFPaiCod ;
      AV93Paiswwds_2_tfpaicod_to = AV23TFPaiCod_To ;
      AV94Paiswwds_3_tfpainom = AV25TFPaiNom ;
      AV95Paiswwds_4_tfpainom_sels = AV26TFPaiNom_Sels ;
      AV96Paiswwds_5_tfpaireligdefault = AV43TFPaiReligDefault ;
      AV97Paiswwds_6_tfpaireligdefault_sels = AV44TFPaiReligDefault_Sels ;
      AV98Paiswwds_7_tfpaimeshspext = AV45TFPaiMesHsPExt ;
      AV99Paiswwds_8_tfpaimeshspext_to = AV46TFPaiMesHsPExt_To ;
      AV100Paiswwds_9_tfpaidiahspext_sels = AV48TFPaiDiaHsPExt_Sels ;
      AV101Paiswwds_10_tfpaifondocese_sel = AV49TFPaiFondoCese_Sel ;
      AV102Paiswwds_11_tfpaimaxhornor = AV50TFPaiMaxHorNor ;
      AV103Paiswwds_12_tfpaimaxhornor_to = AV51TFPaiMaxHorNor_To ;
      AV104Paiswwds_13_tfpaipervacdes_sels = AV53TFPaiPerVacDes_Sels ;
      AV105Paiswwds_14_tfpaipervachas_sels = AV55TFPaiPerVacHas_Sels ;
      AV106Paiswwds_15_tfpaifracvacant = AV63TFPaiFracVacAnt ;
      AV107Paiswwds_16_tfpaifracvacant_to = AV64TFPaiFracVacAnt_To ;
      AV108Paiswwds_17_tfpaiguaredadmin = AV56TFPaiGuarEdadMin ;
      AV109Paiswwds_18_tfpaiguaredadmin_to = AV57TFPaiGuarEdadMin_To ;
      AV110Paiswwds_19_tfpaiguaredadmax = AV58TFPaiGuarEdadMax ;
      AV111Paiswwds_20_tfpaiguaredadmax_to = AV59TFPaiGuarEdadMax_To ;
      AV112Paiswwds_21_tfpaiexcvizzoti_sel = AV60TFPaiExcVizzoti_Sel ;
      AV113Paiswwds_22_tfpaivizzoti = AV61TFPaiVizzoti ;
      AV114Paiswwds_23_tfpaivizzoti_to = AV62TFPaiVizzoti_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV19ColumnsSelector, AV91Pgmname, AV67MenuOpcCod, AV12GridState, AV22TFPaiCod, AV23TFPaiCod_To, AV25TFPaiNom, AV26TFPaiNom_Sels, AV43TFPaiReligDefault, AV44TFPaiReligDefault_Sels, AV45TFPaiMesHsPExt, AV46TFPaiMesHsPExt_To, AV48TFPaiDiaHsPExt_Sels, AV49TFPaiFondoCese_Sel, AV50TFPaiMaxHorNor, AV51TFPaiMaxHorNor_To, AV53TFPaiPerVacDes_Sels, AV55TFPaiPerVacHas_Sels, AV63TFPaiFracVacAnt, AV64TFPaiFracVacAnt_To, AV56TFPaiGuarEdadMin, AV57TFPaiGuarEdadMin_To, AV58TFPaiGuarEdadMax, AV59TFPaiGuarEdadMax_To, AV60TFPaiExcVizzoti_Sel, AV61TFPaiVizzoti, AV62TFPaiVizzoti_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV33IsAuthorized_Update, AV69WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV92Paiswwds_1_tfpaicod = AV22TFPaiCod ;
      AV93Paiswwds_2_tfpaicod_to = AV23TFPaiCod_To ;
      AV94Paiswwds_3_tfpainom = AV25TFPaiNom ;
      AV95Paiswwds_4_tfpainom_sels = AV26TFPaiNom_Sels ;
      AV96Paiswwds_5_tfpaireligdefault = AV43TFPaiReligDefault ;
      AV97Paiswwds_6_tfpaireligdefault_sels = AV44TFPaiReligDefault_Sels ;
      AV98Paiswwds_7_tfpaimeshspext = AV45TFPaiMesHsPExt ;
      AV99Paiswwds_8_tfpaimeshspext_to = AV46TFPaiMesHsPExt_To ;
      AV100Paiswwds_9_tfpaidiahspext_sels = AV48TFPaiDiaHsPExt_Sels ;
      AV101Paiswwds_10_tfpaifondocese_sel = AV49TFPaiFondoCese_Sel ;
      AV102Paiswwds_11_tfpaimaxhornor = AV50TFPaiMaxHorNor ;
      AV103Paiswwds_12_tfpaimaxhornor_to = AV51TFPaiMaxHorNor_To ;
      AV104Paiswwds_13_tfpaipervacdes_sels = AV53TFPaiPerVacDes_Sels ;
      AV105Paiswwds_14_tfpaipervachas_sels = AV55TFPaiPerVacHas_Sels ;
      AV106Paiswwds_15_tfpaifracvacant = AV63TFPaiFracVacAnt ;
      AV107Paiswwds_16_tfpaifracvacant_to = AV64TFPaiFracVacAnt_To ;
      AV108Paiswwds_17_tfpaiguaredadmin = AV56TFPaiGuarEdadMin ;
      AV109Paiswwds_18_tfpaiguaredadmin_to = AV57TFPaiGuarEdadMin_To ;
      AV110Paiswwds_19_tfpaiguaredadmax = AV58TFPaiGuarEdadMax ;
      AV111Paiswwds_20_tfpaiguaredadmax_to = AV59TFPaiGuarEdadMax_To ;
      AV112Paiswwds_21_tfpaiexcvizzoti_sel = AV60TFPaiExcVizzoti_Sel ;
      AV113Paiswwds_22_tfpaivizzoti = AV61TFPaiVizzoti ;
      AV114Paiswwds_23_tfpaivizzoti_to = AV62TFPaiVizzoti_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV19ColumnsSelector, AV91Pgmname, AV67MenuOpcCod, AV12GridState, AV22TFPaiCod, AV23TFPaiCod_To, AV25TFPaiNom, AV26TFPaiNom_Sels, AV43TFPaiReligDefault, AV44TFPaiReligDefault_Sels, AV45TFPaiMesHsPExt, AV46TFPaiMesHsPExt_To, AV48TFPaiDiaHsPExt_Sels, AV49TFPaiFondoCese_Sel, AV50TFPaiMaxHorNor, AV51TFPaiMaxHorNor_To, AV53TFPaiPerVacDes_Sels, AV55TFPaiPerVacHas_Sels, AV63TFPaiFracVacAnt, AV64TFPaiFracVacAnt_To, AV56TFPaiGuarEdadMin, AV57TFPaiGuarEdadMin_To, AV58TFPaiGuarEdadMax, AV59TFPaiGuarEdadMax_To, AV60TFPaiExcVizzoti_Sel, AV61TFPaiVizzoti, AV62TFPaiVizzoti_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV33IsAuthorized_Update, AV69WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV92Paiswwds_1_tfpaicod = AV22TFPaiCod ;
      AV93Paiswwds_2_tfpaicod_to = AV23TFPaiCod_To ;
      AV94Paiswwds_3_tfpainom = AV25TFPaiNom ;
      AV95Paiswwds_4_tfpainom_sels = AV26TFPaiNom_Sels ;
      AV96Paiswwds_5_tfpaireligdefault = AV43TFPaiReligDefault ;
      AV97Paiswwds_6_tfpaireligdefault_sels = AV44TFPaiReligDefault_Sels ;
      AV98Paiswwds_7_tfpaimeshspext = AV45TFPaiMesHsPExt ;
      AV99Paiswwds_8_tfpaimeshspext_to = AV46TFPaiMesHsPExt_To ;
      AV100Paiswwds_9_tfpaidiahspext_sels = AV48TFPaiDiaHsPExt_Sels ;
      AV101Paiswwds_10_tfpaifondocese_sel = AV49TFPaiFondoCese_Sel ;
      AV102Paiswwds_11_tfpaimaxhornor = AV50TFPaiMaxHorNor ;
      AV103Paiswwds_12_tfpaimaxhornor_to = AV51TFPaiMaxHorNor_To ;
      AV104Paiswwds_13_tfpaipervacdes_sels = AV53TFPaiPerVacDes_Sels ;
      AV105Paiswwds_14_tfpaipervachas_sels = AV55TFPaiPerVacHas_Sels ;
      AV106Paiswwds_15_tfpaifracvacant = AV63TFPaiFracVacAnt ;
      AV107Paiswwds_16_tfpaifracvacant_to = AV64TFPaiFracVacAnt_To ;
      AV108Paiswwds_17_tfpaiguaredadmin = AV56TFPaiGuarEdadMin ;
      AV109Paiswwds_18_tfpaiguaredadmin_to = AV57TFPaiGuarEdadMin_To ;
      AV110Paiswwds_19_tfpaiguaredadmax = AV58TFPaiGuarEdadMax ;
      AV111Paiswwds_20_tfpaiguaredadmax_to = AV59TFPaiGuarEdadMax_To ;
      AV112Paiswwds_21_tfpaiexcvizzoti_sel = AV60TFPaiExcVizzoti_Sel ;
      AV113Paiswwds_22_tfpaivizzoti = AV61TFPaiVizzoti ;
      AV114Paiswwds_23_tfpaivizzoti_to = AV62TFPaiVizzoti_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV19ColumnsSelector, AV91Pgmname, AV67MenuOpcCod, AV12GridState, AV22TFPaiCod, AV23TFPaiCod_To, AV25TFPaiNom, AV26TFPaiNom_Sels, AV43TFPaiReligDefault, AV44TFPaiReligDefault_Sels, AV45TFPaiMesHsPExt, AV46TFPaiMesHsPExt_To, AV48TFPaiDiaHsPExt_Sels, AV49TFPaiFondoCese_Sel, AV50TFPaiMaxHorNor, AV51TFPaiMaxHorNor_To, AV53TFPaiPerVacDes_Sels, AV55TFPaiPerVacHas_Sels, AV63TFPaiFracVacAnt, AV64TFPaiFracVacAnt_To, AV56TFPaiGuarEdadMin, AV57TFPaiGuarEdadMin_To, AV58TFPaiGuarEdadMax, AV59TFPaiGuarEdadMax_To, AV60TFPaiExcVizzoti_Sel, AV61TFPaiVizzoti, AV62TFPaiVizzoti_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV33IsAuthorized_Update, AV69WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV92Paiswwds_1_tfpaicod = AV22TFPaiCod ;
      AV93Paiswwds_2_tfpaicod_to = AV23TFPaiCod_To ;
      AV94Paiswwds_3_tfpainom = AV25TFPaiNom ;
      AV95Paiswwds_4_tfpainom_sels = AV26TFPaiNom_Sels ;
      AV96Paiswwds_5_tfpaireligdefault = AV43TFPaiReligDefault ;
      AV97Paiswwds_6_tfpaireligdefault_sels = AV44TFPaiReligDefault_Sels ;
      AV98Paiswwds_7_tfpaimeshspext = AV45TFPaiMesHsPExt ;
      AV99Paiswwds_8_tfpaimeshspext_to = AV46TFPaiMesHsPExt_To ;
      AV100Paiswwds_9_tfpaidiahspext_sels = AV48TFPaiDiaHsPExt_Sels ;
      AV101Paiswwds_10_tfpaifondocese_sel = AV49TFPaiFondoCese_Sel ;
      AV102Paiswwds_11_tfpaimaxhornor = AV50TFPaiMaxHorNor ;
      AV103Paiswwds_12_tfpaimaxhornor_to = AV51TFPaiMaxHorNor_To ;
      AV104Paiswwds_13_tfpaipervacdes_sels = AV53TFPaiPerVacDes_Sels ;
      AV105Paiswwds_14_tfpaipervachas_sels = AV55TFPaiPerVacHas_Sels ;
      AV106Paiswwds_15_tfpaifracvacant = AV63TFPaiFracVacAnt ;
      AV107Paiswwds_16_tfpaifracvacant_to = AV64TFPaiFracVacAnt_To ;
      AV108Paiswwds_17_tfpaiguaredadmin = AV56TFPaiGuarEdadMin ;
      AV109Paiswwds_18_tfpaiguaredadmin_to = AV57TFPaiGuarEdadMin_To ;
      AV110Paiswwds_19_tfpaiguaredadmax = AV58TFPaiGuarEdadMax ;
      AV111Paiswwds_20_tfpaiguaredadmax_to = AV59TFPaiGuarEdadMax_To ;
      AV112Paiswwds_21_tfpaiexcvizzoti_sel = AV60TFPaiExcVizzoti_Sel ;
      AV113Paiswwds_22_tfpaivizzoti = AV61TFPaiVizzoti ;
      AV114Paiswwds_23_tfpaivizzoti_to = AV62TFPaiVizzoti_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV19ColumnsSelector, AV91Pgmname, AV67MenuOpcCod, AV12GridState, AV22TFPaiCod, AV23TFPaiCod_To, AV25TFPaiNom, AV26TFPaiNom_Sels, AV43TFPaiReligDefault, AV44TFPaiReligDefault_Sels, AV45TFPaiMesHsPExt, AV46TFPaiMesHsPExt_To, AV48TFPaiDiaHsPExt_Sels, AV49TFPaiFondoCese_Sel, AV50TFPaiMaxHorNor, AV51TFPaiMaxHorNor_To, AV53TFPaiPerVacDes_Sels, AV55TFPaiPerVacHas_Sels, AV63TFPaiFracVacAnt, AV64TFPaiFracVacAnt_To, AV56TFPaiGuarEdadMin, AV57TFPaiGuarEdadMin_To, AV58TFPaiGuarEdadMax, AV59TFPaiGuarEdadMax_To, AV60TFPaiExcVizzoti_Sel, AV61TFPaiVizzoti, AV62TFPaiVizzoti_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV33IsAuthorized_Update, AV69WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV92Paiswwds_1_tfpaicod = AV22TFPaiCod ;
      AV93Paiswwds_2_tfpaicod_to = AV23TFPaiCod_To ;
      AV94Paiswwds_3_tfpainom = AV25TFPaiNom ;
      AV95Paiswwds_4_tfpainom_sels = AV26TFPaiNom_Sels ;
      AV96Paiswwds_5_tfpaireligdefault = AV43TFPaiReligDefault ;
      AV97Paiswwds_6_tfpaireligdefault_sels = AV44TFPaiReligDefault_Sels ;
      AV98Paiswwds_7_tfpaimeshspext = AV45TFPaiMesHsPExt ;
      AV99Paiswwds_8_tfpaimeshspext_to = AV46TFPaiMesHsPExt_To ;
      AV100Paiswwds_9_tfpaidiahspext_sels = AV48TFPaiDiaHsPExt_Sels ;
      AV101Paiswwds_10_tfpaifondocese_sel = AV49TFPaiFondoCese_Sel ;
      AV102Paiswwds_11_tfpaimaxhornor = AV50TFPaiMaxHorNor ;
      AV103Paiswwds_12_tfpaimaxhornor_to = AV51TFPaiMaxHorNor_To ;
      AV104Paiswwds_13_tfpaipervacdes_sels = AV53TFPaiPerVacDes_Sels ;
      AV105Paiswwds_14_tfpaipervachas_sels = AV55TFPaiPerVacHas_Sels ;
      AV106Paiswwds_15_tfpaifracvacant = AV63TFPaiFracVacAnt ;
      AV107Paiswwds_16_tfpaifracvacant_to = AV64TFPaiFracVacAnt_To ;
      AV108Paiswwds_17_tfpaiguaredadmin = AV56TFPaiGuarEdadMin ;
      AV109Paiswwds_18_tfpaiguaredadmin_to = AV57TFPaiGuarEdadMin_To ;
      AV110Paiswwds_19_tfpaiguaredadmax = AV58TFPaiGuarEdadMax ;
      AV111Paiswwds_20_tfpaiguaredadmax_to = AV59TFPaiGuarEdadMax_To ;
      AV112Paiswwds_21_tfpaiexcvizzoti_sel = AV60TFPaiExcVizzoti_Sel ;
      AV113Paiswwds_22_tfpaivizzoti = AV61TFPaiVizzoti ;
      AV114Paiswwds_23_tfpaivizzoti_to = AV62TFPaiVizzoti_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV19ColumnsSelector, AV91Pgmname, AV67MenuOpcCod, AV12GridState, AV22TFPaiCod, AV23TFPaiCod_To, AV25TFPaiNom, AV26TFPaiNom_Sels, AV43TFPaiReligDefault, AV44TFPaiReligDefault_Sels, AV45TFPaiMesHsPExt, AV46TFPaiMesHsPExt_To, AV48TFPaiDiaHsPExt_Sels, AV49TFPaiFondoCese_Sel, AV50TFPaiMaxHorNor, AV51TFPaiMaxHorNor_To, AV53TFPaiPerVacDes_Sels, AV55TFPaiPerVacHas_Sels, AV63TFPaiFracVacAnt, AV64TFPaiFracVacAnt_To, AV56TFPaiGuarEdadMin, AV57TFPaiGuarEdadMin_To, AV58TFPaiGuarEdadMax, AV59TFPaiGuarEdadMax_To, AV60TFPaiExcVizzoti_Sel, AV61TFPaiVizzoti, AV62TFPaiVizzoti_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV33IsAuthorized_Update, AV69WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV91Pgmname = "PaisWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupCR0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18CR2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV27DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV19ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV76ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_108 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_108"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV29GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV30GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV31GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         AV75WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV69WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV69WelcomeMessage_NoMostrarMas", AV69WelcomeMessage_NoMostrarMas);
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
      e18CR2 ();
      if (returnInSub) return;
   }

   public void e18CR2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV67MenuOpcCod, "", "") ;
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
      Form.setCaption( httpContext.getMessage( " Pais", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV27DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV27DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char3[0] = AV70MenuBienveImgURL ;
      GXv_char4[0] = AV72MenuBienveTitulo ;
      GXv_char5[0] = AV73MenuBienveTexto ;
      GXv_boolean6[0] = AV74MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV67MenuOpcCod, GXv_char3, GXv_char4, GXv_char5, GXv_boolean6) ;
      paisww_impl.this.AV70MenuBienveImgURL = GXv_char3[0] ;
      paisww_impl.this.AV72MenuBienveTitulo = GXv_char4[0] ;
      paisww_impl.this.AV73MenuBienveTexto = GXv_char5[0] ;
      paisww_impl.this.AV74MenuBienveVisible = GXv_boolean6[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV74MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV74MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV72MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV73MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV75WelcomeMessage_Foto = AV70MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV75WelcomeMessage_Foto)==0) ? AV90Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV75WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV75WelcomeMessage_Foto), true);
         AV90Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV70MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV75WelcomeMessage_Foto)==0) ? AV90Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV75WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV75WelcomeMessage_Foto), true);
      }
      GXt_char7 = "" ;
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char5) ;
      paisww_impl.this.GXt_char8 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char8, GXv_char4) ;
      paisww_impl.this.GXt_char7 = GXv_char4[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char7 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV87observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV87observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV87observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV87observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e19CR2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext9[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext9) ;
      AV6WWPContext = GXv_SdtWWPContext9[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV78ManageFiltersExecutionStep == 1 )
      {
         AV78ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78ManageFiltersExecutionStep", GXutil.str( AV78ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV78ManageFiltersExecutionStep == 2 )
      {
         AV78ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78ManageFiltersExecutionStep", GXutil.str( AV78ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV21Session.getValue("PaisWWColumnsSelector"), "") != 0 )
      {
         AV17ColumnsSelectorXML = AV21Session.getValue("PaisWWColumnsSelector") ;
         AV19ColumnsSelector.fromxml(AV17ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtPaiCod_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtPaiNom_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiNom_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiNom_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtPaiReligDefault_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiReligDefault_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiReligDefault_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtPaiMesHsPExt_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiMesHsPExt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiMesHsPExt_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbPaiDiaHsPExt.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiDiaHsPExt.getInternalname(), "Visible", GXutil.ltrimstr( cmbPaiDiaHsPExt.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      chkPaiFondoCese.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiFondoCese.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiFondoCese.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtPaiMaxHorNor_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiMaxHorNor_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiMaxHorNor_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbPaiPerVacDes.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiPerVacDes.getInternalname(), "Visible", GXutil.ltrimstr( cmbPaiPerVacDes.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbPaiPerVacHas.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiPerVacHas.getInternalname(), "Visible", GXutil.ltrimstr( cmbPaiPerVacHas.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtPaiFracVacAnt_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiFracVacAnt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiFracVacAnt_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtPaiGuarEdadMin_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiGuarEdadMin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiGuarEdadMin_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtPaiGuarEdadMax_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiGuarEdadMax_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiGuarEdadMax_Visible), 5, 0), !bGXsfl_108_Refreshing);
      chkPaiExcVizzoti.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiExcVizzoti.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiExcVizzoti.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtPaiVizzoti_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiVizzoti_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiVizzoti_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      AV29GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29GridCurrentPage), 10, 0));
      AV30GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GridPageCount), 10, 0));
      GXt_char8 = AV31GridAppliedFilters ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV91Pgmname, GXv_char5) ;
      paisww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV31GridAppliedFilters = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31GridAppliedFilters", AV31GridAppliedFilters);
      GXt_char8 = AV83MenuOpcTitulo ;
      GXv_char5[0] = GXt_char8 ;
      new web.gettxtcount(remoteHandle, context).execute( AV67MenuOpcCod, GXv_char5) ;
      paisww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV83MenuOpcTitulo = GXt_char8 ;
      if ( (GXutil.strcmp("", AV83MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV83MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int10[0] = (short)(AV85filterCount) ;
      GXv_char5[0] = AV86filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int10, GXv_char5) ;
      paisww_impl.this.AV85filterCount = GXv_int10[0] ;
      paisww_impl.this.AV86filtrosTexto = GXv_char5[0] ;
      if ( AV85filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV85filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV86filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV92Paiswwds_1_tfpaicod = AV22TFPaiCod ;
      AV93Paiswwds_2_tfpaicod_to = AV23TFPaiCod_To ;
      AV94Paiswwds_3_tfpainom = AV25TFPaiNom ;
      AV95Paiswwds_4_tfpainom_sels = AV26TFPaiNom_Sels ;
      AV96Paiswwds_5_tfpaireligdefault = AV43TFPaiReligDefault ;
      AV97Paiswwds_6_tfpaireligdefault_sels = AV44TFPaiReligDefault_Sels ;
      AV98Paiswwds_7_tfpaimeshspext = AV45TFPaiMesHsPExt ;
      AV99Paiswwds_8_tfpaimeshspext_to = AV46TFPaiMesHsPExt_To ;
      AV100Paiswwds_9_tfpaidiahspext_sels = AV48TFPaiDiaHsPExt_Sels ;
      AV101Paiswwds_10_tfpaifondocese_sel = AV49TFPaiFondoCese_Sel ;
      AV102Paiswwds_11_tfpaimaxhornor = AV50TFPaiMaxHorNor ;
      AV103Paiswwds_12_tfpaimaxhornor_to = AV51TFPaiMaxHorNor_To ;
      AV104Paiswwds_13_tfpaipervacdes_sels = AV53TFPaiPerVacDes_Sels ;
      AV105Paiswwds_14_tfpaipervachas_sels = AV55TFPaiPerVacHas_Sels ;
      AV106Paiswwds_15_tfpaifracvacant = AV63TFPaiFracVacAnt ;
      AV107Paiswwds_16_tfpaifracvacant_to = AV64TFPaiFracVacAnt_To ;
      AV108Paiswwds_17_tfpaiguaredadmin = AV56TFPaiGuarEdadMin ;
      AV109Paiswwds_18_tfpaiguaredadmin_to = AV57TFPaiGuarEdadMin_To ;
      AV110Paiswwds_19_tfpaiguaredadmax = AV58TFPaiGuarEdadMax ;
      AV111Paiswwds_20_tfpaiguaredadmax_to = AV59TFPaiGuarEdadMax_To ;
      AV112Paiswwds_21_tfpaiexcvizzoti_sel = AV60TFPaiExcVizzoti_Sel ;
      AV113Paiswwds_22_tfpaivizzoti = AV61TFPaiVizzoti ;
      AV114Paiswwds_23_tfpaivizzoti_to = AV62TFPaiVizzoti_To ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76ManageFiltersData", AV76ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e13CR2( )
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
         AV28PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV28PageToGo) ;
      }
   }

   public void e14CR2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15CR2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiCod") == 0 )
         {
            AV22TFPaiCod = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TFPaiCod), 4, 0));
            AV23TFPaiCod_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFPaiCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23TFPaiCod_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiNom") == 0 )
         {
            AV25TFPaiNom = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFPaiNom", AV25TFPaiNom);
            AV24TFPaiNom_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFPaiNom_SelsJson", AV24TFPaiNom_SelsJson);
            AV26TFPaiNom_Sels.fromJSonString(AV24TFPaiNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiReligDefault") == 0 )
         {
            AV43TFPaiReligDefault = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFPaiReligDefault", AV43TFPaiReligDefault);
            AV42TFPaiReligDefault_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFPaiReligDefault_SelsJson", AV42TFPaiReligDefault_SelsJson);
            AV44TFPaiReligDefault_Sels.fromJSonString(AV42TFPaiReligDefault_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiMesHsPExt") == 0 )
         {
            AV45TFPaiMesHsPExt = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFPaiMesHsPExt", GXutil.ltrimstr( AV45TFPaiMesHsPExt, 5, 1));
            AV46TFPaiMesHsPExt_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPaiMesHsPExt_To", GXutil.ltrimstr( AV46TFPaiMesHsPExt_To, 5, 1));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiDiaHsPExt") == 0 )
         {
            AV47TFPaiDiaHsPExt_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFPaiDiaHsPExt_SelsJson", AV47TFPaiDiaHsPExt_SelsJson);
            AV48TFPaiDiaHsPExt_Sels.fromJSonString(AV47TFPaiDiaHsPExt_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiFondoCese") == 0 )
         {
            AV49TFPaiFondoCese_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFPaiFondoCese_Sel", GXutil.str( AV49TFPaiFondoCese_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiMaxHorNor") == 0 )
         {
            AV50TFPaiMaxHorNor = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFPaiMaxHorNor", GXutil.ltrimstr( AV50TFPaiMaxHorNor, 4, 1));
            AV51TFPaiMaxHorNor_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFPaiMaxHorNor_To", GXutil.ltrimstr( AV51TFPaiMaxHorNor_To, 4, 1));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiPerVacDes") == 0 )
         {
            AV52TFPaiPerVacDes_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFPaiPerVacDes_SelsJson", AV52TFPaiPerVacDes_SelsJson);
            AV53TFPaiPerVacDes_Sels.fromJSonString(GXutil.strReplace( AV52TFPaiPerVacDes_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiPerVacHas") == 0 )
         {
            AV54TFPaiPerVacHas_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFPaiPerVacHas_SelsJson", AV54TFPaiPerVacHas_SelsJson);
            AV55TFPaiPerVacHas_Sels.fromJSonString(GXutil.strReplace( AV54TFPaiPerVacHas_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiFracVacAnt") == 0 )
         {
            AV63TFPaiFracVacAnt = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFPaiFracVacAnt", GXutil.ltrimstr( AV63TFPaiFracVacAnt, 6, 4));
            AV64TFPaiFracVacAnt_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFPaiFracVacAnt_To", GXutil.ltrimstr( AV64TFPaiFracVacAnt_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiGuarEdadMin") == 0 )
         {
            AV56TFPaiGuarEdadMin = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFPaiGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFPaiGuarEdadMin), 2, 0));
            AV57TFPaiGuarEdadMin_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFPaiGuarEdadMin_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFPaiGuarEdadMin_To), 2, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiGuarEdadMax") == 0 )
         {
            AV58TFPaiGuarEdadMax = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFPaiGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58TFPaiGuarEdadMax), 2, 0));
            AV59TFPaiGuarEdadMax_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFPaiGuarEdadMax_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59TFPaiGuarEdadMax_To), 2, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiExcVizzoti") == 0 )
         {
            AV60TFPaiExcVizzoti_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFPaiExcVizzoti_Sel", GXutil.str( AV60TFPaiExcVizzoti_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiVizzoti") == 0 )
         {
            AV61TFPaiVizzoti = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFPaiVizzoti", GXutil.ltrimstr( AV61TFPaiVizzoti, 6, 4));
            AV62TFPaiVizzoti_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFPaiVizzoti_To", GXutil.ltrimstr( AV62TFPaiVizzoti_To, 6, 4));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV55TFPaiPerVacHas_Sels", AV55TFPaiPerVacHas_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53TFPaiPerVacDes_Sels", AV53TFPaiPerVacDes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV48TFPaiDiaHsPExt_Sels", AV48TFPaiDiaHsPExt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44TFPaiReligDefault_Sels", AV44TFPaiReligDefault_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV26TFPaiNom_Sels", AV26TFPaiNom_Sels);
   }

   private void e20CR2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV32Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV32Update);
      if ( AV33IsAuthorized_Update )
      {
         GXt_boolean11 = AV39TempBoolean ;
         GXv_boolean6[0] = GXt_boolean11 ;
         new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean6) ;
         paisww_impl.this.GXt_boolean11 = GXv_boolean6[0] ;
         AV39TempBoolean = (boolean)((GXt_boolean11)) ;
         if ( AV39TempBoolean )
         {
            edtavUpdate_Link = formatLink("web.pais", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0))}, new String[] {"Mode","PaiCod"})  ;
            edtavUpdate_Class = "Attribute" ;
         }
         else
         {
            edtavUpdate_Link = "" ;
            edtavUpdate_Class = "Invisible" ;
         }
      }
      AV38Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV38Display);
      edtavDisplay_Link = formatLink("web.paisview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PaiCod","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char8 = AV65VerSVG ;
      GXv_char5[0] = GXt_char8 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char5) ;
      paisww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV65VerSVG = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV65VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char8 = AV66ModificarSVG ;
      GXv_char5[0] = GXt_char8 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char5) ;
      paisww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV66ModificarSVG = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV66ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
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

   public void e11CR2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV17ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV19ColumnsSelector.fromJSonString(AV17ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "PaisWWColumnsSelector", ((GXutil.strcmp("", AV17ColumnsSelectorXML)==0) ? "" : AV19ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76ManageFiltersData", AV76ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e12CR2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("PaisWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV91Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV78ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78ManageFiltersExecutionStep", GXutil.str( AV78ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("PaisWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV78ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78ManageFiltersExecutionStep", GXutil.str( AV78ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char8 = AV77ManageFiltersXml ;
         GXv_char5[0] = GXt_char8 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "PaisWWFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         paisww_impl.this.GXt_char8 = GXv_char5[0] ;
         AV77ManageFiltersXml = GXt_char8 ;
         if ( (GXutil.strcmp("", AV77ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV91Pgmname+"GridState", AV77ManageFiltersXml) ;
            AV12GridState.fromxml(AV77ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV26TFPaiNom_Sels", AV26TFPaiNom_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44TFPaiReligDefault_Sels", AV44TFPaiReligDefault_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV48TFPaiDiaHsPExt_Sels", AV48TFPaiDiaHsPExt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53TFPaiPerVacDes_Sels", AV53TFPaiPerVacDes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV55TFPaiPerVacHas_Sels", AV55TFPaiPerVacHas_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76ManageFiltersData", AV76ManageFiltersData);
   }

   public void e16CR2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char5[0] = AV40ExcelFilename ;
      GXv_char4[0] = AV41ErrorMessage ;
      new web.paiswwexport(remoteHandle, context).execute( GXv_char5, GXv_char4) ;
      paisww_impl.this.AV40ExcelFilename = GXv_char5[0] ;
      paisww_impl.this.AV41ErrorMessage = GXv_char4[0] ;
      if ( GXutil.strcmp(AV40ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV40ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV41ErrorMessage);
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
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiCod", "", "Cod. Pais", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiNom", "", "Nom. Pais", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiReligDefault", "", "Relig Default", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiMesHsPExt", "", "Cantidad de horas del mes para cálculo 1 hora de trabajo para empleados de clase mensual", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiDiaHsPExt", "", "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiFondoCese", "", "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiMaxHorNor", "", "Máximo de horas normales por día", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiPerVacDes", "", "Periodo de vacaciones desde", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiPerVacHas", "", "Periodo de vacaciones hasta", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiFracVacAnt", "", "Proporción de días de vacaciones disponibles pendientes de goce del año anterior", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiGuarEdadMin", "", "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiGuarEdadMax", "", "Edad máxima del hijo/hija hasta la que puede gozar el beneficio de guardería", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiExcVizzoti", "", "Considerar excepción a uso de tope (fallo Vizzoti)", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PaiVizzoti", "", "Proporción de sueldo para evaluar tope (fallo Vizzoti)", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      if ( new web.esconceptosdefault(remoteHandle, context).executeUdp( ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "&VerSVG", "", "", true, "") ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "", "", "", false, "") ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
      GXv_SdtWWPColumnsSelector12[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "&ModificarSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXt_char8 = AV18UserCustomValue ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PaisWWColumnsSelector", GXv_char5) ;
      paisww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV18UserCustomValue = GXt_char8 ;
      if ( ! ( (GXutil.strcmp("", AV18UserCustomValue)==0) ) )
      {
         AV20ColumnsSelectorAux.fromxml(AV18UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector12[0] = AV20ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, GXv_SdtWWPColumnsSelector13) ;
         AV20ColumnsSelectorAux = GXv_SdtWWPColumnsSelector12[0] ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV36CliCod, GXv_SdtWWPColumnsSelector13) ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean11 = AV33IsAuthorized_Update ;
      GXv_boolean6[0] = GXt_boolean11 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais_Update", GXv_boolean6) ;
      paisww_impl.this.GXt_boolean11 = GXv_boolean6[0] ;
      AV33IsAuthorized_Update = GXt_boolean11 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33IsAuthorized_Update", AV33IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV33IsAuthorized_Update));
      if ( ! ( AV33IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_108_Refreshing);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 = AV76ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "PaisWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15[0] ;
      AV76ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV22TFPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22TFPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TFPaiCod), 4, 0));
      AV23TFPaiCod_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23TFPaiCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23TFPaiCod_To), 4, 0));
      AV25TFPaiNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25TFPaiNom", AV25TFPaiNom);
      AV26TFPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43TFPaiReligDefault = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFPaiReligDefault", AV43TFPaiReligDefault);
      AV44TFPaiReligDefault_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45TFPaiMesHsPExt = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFPaiMesHsPExt", GXutil.ltrimstr( AV45TFPaiMesHsPExt, 5, 1));
      AV46TFPaiMesHsPExt_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFPaiMesHsPExt_To", GXutil.ltrimstr( AV46TFPaiMesHsPExt_To, 5, 1));
      AV48TFPaiDiaHsPExt_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49TFPaiFondoCese_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFPaiFondoCese_Sel", GXutil.str( AV49TFPaiFondoCese_Sel, 1, 0));
      AV50TFPaiMaxHorNor = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TFPaiMaxHorNor", GXutil.ltrimstr( AV50TFPaiMaxHorNor, 4, 1));
      AV51TFPaiMaxHorNor_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51TFPaiMaxHorNor_To", GXutil.ltrimstr( AV51TFPaiMaxHorNor_To, 4, 1));
      AV53TFPaiPerVacDes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV55TFPaiPerVacHas_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV63TFPaiFracVacAnt = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63TFPaiFracVacAnt", GXutil.ltrimstr( AV63TFPaiFracVacAnt, 6, 4));
      AV64TFPaiFracVacAnt_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64TFPaiFracVacAnt_To", GXutil.ltrimstr( AV64TFPaiFracVacAnt_To, 6, 4));
      AV56TFPaiGuarEdadMin = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56TFPaiGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFPaiGuarEdadMin), 2, 0));
      AV57TFPaiGuarEdadMin_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57TFPaiGuarEdadMin_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFPaiGuarEdadMin_To), 2, 0));
      AV58TFPaiGuarEdadMax = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58TFPaiGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58TFPaiGuarEdadMax), 2, 0));
      AV59TFPaiGuarEdadMax_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59TFPaiGuarEdadMax_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59TFPaiGuarEdadMax_To), 2, 0));
      AV60TFPaiExcVizzoti_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60TFPaiExcVizzoti_Sel", GXutil.str( AV60TFPaiExcVizzoti_Sel, 1, 0));
      AV61TFPaiVizzoti = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61TFPaiVizzoti", GXutil.ltrimstr( AV61TFPaiVizzoti, 6, 4));
      AV62TFPaiVizzoti_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62TFPaiVizzoti_To", GXutil.ltrimstr( AV62TFPaiVizzoti_To, 6, 4));
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
      if ( GXutil.strcmp(AV21Session.getValue(AV91Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV91Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV21Session.getValue(AV91Pgmname+"GridState"), null, null);
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
      AV115GXV1 = 1 ;
      while ( AV115GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV115GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAICOD") == 0 )
         {
            AV22TFPaiCod = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TFPaiCod), 4, 0));
            AV23TFPaiCod_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFPaiCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23TFPaiCod_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAINOM") == 0 )
         {
            AV25TFPaiNom = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFPaiNom", AV25TFPaiNom);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAINOM_SEL") == 0 )
         {
            AV24TFPaiNom_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFPaiNom_SelsJson", AV24TFPaiNom_SelsJson);
            AV26TFPaiNom_Sels.fromJSonString(AV24TFPaiNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIRELIGDEFAULT") == 0 )
         {
            AV43TFPaiReligDefault = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFPaiReligDefault", AV43TFPaiReligDefault);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIRELIGDEFAULT_SEL") == 0 )
         {
            AV42TFPaiReligDefault_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFPaiReligDefault_SelsJson", AV42TFPaiReligDefault_SelsJson);
            AV44TFPaiReligDefault_Sels.fromJSonString(AV42TFPaiReligDefault_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIMESHSPEXT") == 0 )
         {
            AV45TFPaiMesHsPExt = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFPaiMesHsPExt", GXutil.ltrimstr( AV45TFPaiMesHsPExt, 5, 1));
            AV46TFPaiMesHsPExt_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPaiMesHsPExt_To", GXutil.ltrimstr( AV46TFPaiMesHsPExt_To, 5, 1));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIDIAHSPEXT_SEL") == 0 )
         {
            AV47TFPaiDiaHsPExt_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFPaiDiaHsPExt_SelsJson", AV47TFPaiDiaHsPExt_SelsJson);
            AV48TFPaiDiaHsPExt_Sels.fromJSonString(AV47TFPaiDiaHsPExt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIFONDOCESE_SEL") == 0 )
         {
            AV49TFPaiFondoCese_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFPaiFondoCese_Sel", GXutil.str( AV49TFPaiFondoCese_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIMAXHORNOR") == 0 )
         {
            AV50TFPaiMaxHorNor = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFPaiMaxHorNor", GXutil.ltrimstr( AV50TFPaiMaxHorNor, 4, 1));
            AV51TFPaiMaxHorNor_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFPaiMaxHorNor_To", GXutil.ltrimstr( AV51TFPaiMaxHorNor_To, 4, 1));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIPERVACDES_SEL") == 0 )
         {
            AV52TFPaiPerVacDes_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFPaiPerVacDes_SelsJson", AV52TFPaiPerVacDes_SelsJson);
            AV53TFPaiPerVacDes_Sels.fromJSonString(AV52TFPaiPerVacDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIPERVACHAS_SEL") == 0 )
         {
            AV54TFPaiPerVacHas_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFPaiPerVacHas_SelsJson", AV54TFPaiPerVacHas_SelsJson);
            AV55TFPaiPerVacHas_Sels.fromJSonString(AV54TFPaiPerVacHas_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIFRACVACANT") == 0 )
         {
            AV63TFPaiFracVacAnt = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFPaiFracVacAnt", GXutil.ltrimstr( AV63TFPaiFracVacAnt, 6, 4));
            AV64TFPaiFracVacAnt_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFPaiFracVacAnt_To", GXutil.ltrimstr( AV64TFPaiFracVacAnt_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIGUAREDADMIN") == 0 )
         {
            AV56TFPaiGuarEdadMin = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFPaiGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFPaiGuarEdadMin), 2, 0));
            AV57TFPaiGuarEdadMin_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFPaiGuarEdadMin_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFPaiGuarEdadMin_To), 2, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIGUAREDADMAX") == 0 )
         {
            AV58TFPaiGuarEdadMax = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFPaiGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58TFPaiGuarEdadMax), 2, 0));
            AV59TFPaiGuarEdadMax_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFPaiGuarEdadMax_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59TFPaiGuarEdadMax_To), 2, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIEXCVIZZOTI_SEL") == 0 )
         {
            AV60TFPaiExcVizzoti_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFPaiExcVizzoti_Sel", GXutil.str( AV60TFPaiExcVizzoti_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIVIZZOTI") == 0 )
         {
            AV61TFPaiVizzoti = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFPaiVizzoti", GXutil.ltrimstr( AV61TFPaiVizzoti, 6, 4));
            AV62TFPaiVizzoti_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFPaiVizzoti_To", GXutil.ltrimstr( AV62TFPaiVizzoti_To, 6, 4));
         }
         AV115GXV1 = (int)(AV115GXV1+1) ;
      }
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV26TFPaiNom_Sels.size()==0), AV24TFPaiNom_SelsJson, GXv_char5) ;
      paisww_impl.this.GXt_char8 = GXv_char5[0] ;
      GXt_char7 = "" ;
      GXv_char4[0] = GXt_char7 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV44TFPaiReligDefault_Sels.size()==0), AV42TFPaiReligDefault_SelsJson, GXv_char4) ;
      paisww_impl.this.GXt_char7 = GXv_char4[0] ;
      GXt_char16 = "" ;
      GXv_char3[0] = GXt_char16 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV48TFPaiDiaHsPExt_Sels.size()==0), AV47TFPaiDiaHsPExt_SelsJson, GXv_char3) ;
      paisww_impl.this.GXt_char16 = GXv_char3[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char8+"|"+GXt_char7+"||"+GXt_char16+"|"+((0==AV49TFPaiFondoCese_Sel) ? "" : GXutil.str( AV49TFPaiFondoCese_Sel, 1, 0))+"||"+((AV53TFPaiPerVacDes_Sels.size()==0) ? "" : AV52TFPaiPerVacDes_SelsJson)+"|"+((AV55TFPaiPerVacHas_Sels.size()==0) ? "" : AV54TFPaiPerVacHas_SelsJson)+"||||"+((0==AV60TFPaiExcVizzoti_Sel) ? "" : GXutil.str( AV60TFPaiExcVizzoti_Sel, 1, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char16 = "" ;
      GXv_char5[0] = GXt_char16 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV25TFPaiNom)==0), AV25TFPaiNom, GXv_char5) ;
      paisww_impl.this.GXt_char16 = GXv_char5[0] ;
      GXt_char8 = "" ;
      GXv_char4[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV43TFPaiReligDefault)==0), AV43TFPaiReligDefault, GXv_char4) ;
      paisww_impl.this.GXt_char8 = GXv_char4[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV22TFPaiCod) ? "" : GXutil.str( AV22TFPaiCod, 4, 0))+"|"+GXt_char16+"|"+GXt_char8+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFPaiMesHsPExt)==0) ? "" : GXutil.str( AV45TFPaiMesHsPExt, 5, 1))+"|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFPaiMaxHorNor)==0) ? "" : GXutil.str( AV50TFPaiMaxHorNor, 4, 1))+"|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFPaiFracVacAnt)==0) ? "" : GXutil.str( AV63TFPaiFracVacAnt, 6, 4))+"|"+((0==AV56TFPaiGuarEdadMin) ? "" : GXutil.str( AV56TFPaiGuarEdadMin, 2, 0))+"|"+((0==AV58TFPaiGuarEdadMax) ? "" : GXutil.str( AV58TFPaiGuarEdadMax, 2, 0))+"||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFPaiVizzoti)==0) ? "" : GXutil.str( AV61TFPaiVizzoti, 6, 4)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV23TFPaiCod_To) ? "" : GXutil.str( AV23TFPaiCod_To, 4, 0))+"|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFPaiMesHsPExt_To)==0) ? "" : GXutil.str( AV46TFPaiMesHsPExt_To, 5, 1))+"|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFPaiMaxHorNor_To)==0) ? "" : GXutil.str( AV51TFPaiMaxHorNor_To, 4, 1))+"|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFPaiFracVacAnt_To)==0) ? "" : GXutil.str( AV64TFPaiFracVacAnt_To, 6, 4))+"|"+((0==AV57TFPaiGuarEdadMin_To) ? "" : GXutil.str( AV57TFPaiGuarEdadMin_To, 2, 0))+"|"+((0==AV59TFPaiGuarEdadMax_To) ? "" : GXutil.str( AV59TFPaiGuarEdadMax_To, 2, 0))+"||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFPaiVizzoti_To)==0) ? "" : GXutil.str( AV62TFPaiVizzoti_To, 6, 4)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV21Session.getValue(AV91Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAICOD", httpContext.getMessage( "Cod. Pais", ""), !((0==AV22TFPaiCod)&&(0==AV23TFPaiCod_To)), (short)(0), GXutil.trim( GXutil.str( AV22TFPaiCod, 4, 0)), GXutil.trim( GXutil.str( AV23TFPaiCod_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAINOM", httpContext.getMessage( "Nom. Pais", ""), !(GXutil.strcmp("", AV25TFPaiNom)==0), (short)(0), AV25TFPaiNom, "", !(AV26TFPaiNom_Sels.size()==0), AV26TFPaiNom_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIRELIGDEFAULT", httpContext.getMessage( "Relig Default", ""), !(GXutil.strcmp("", AV43TFPaiReligDefault)==0), (short)(0), AV43TFPaiReligDefault, "", !(AV44TFPaiReligDefault_Sels.size()==0), AV44TFPaiReligDefault_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIMESHSPEXT", httpContext.getMessage( "Cantidad de horas del mes para cálculo 1 hora de trabajo para empleados de clase mensual", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFPaiMesHsPExt)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFPaiMesHsPExt_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV45TFPaiMesHsPExt, 5, 1)), GXutil.trim( GXutil.str( AV46TFPaiMesHsPExt_To, 5, 1))) ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIDIAHSPEXT_SEL", httpContext.getMessage( "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", ""), !(AV48TFPaiDiaHsPExt_Sels.size()==0), (short)(0), AV48TFPaiDiaHsPExt_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIFONDOCESE_SEL", httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", ""), !(0==AV49TFPaiFondoCese_Sel), (short)(0), GXutil.trim( GXutil.str( AV49TFPaiFondoCese_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIMAXHORNOR", httpContext.getMessage( "Máximo de horas normales por día", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFPaiMaxHorNor)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFPaiMaxHorNor_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV50TFPaiMaxHorNor, 4, 1)), GXutil.trim( GXutil.str( AV51TFPaiMaxHorNor_To, 4, 1))) ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIPERVACDES_SEL", httpContext.getMessage( "Periodo de vacaciones desde", ""), !(AV53TFPaiPerVacDes_Sels.size()==0), (short)(0), AV53TFPaiPerVacDes_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIPERVACHAS_SEL", httpContext.getMessage( "Periodo de vacaciones hasta", ""), !(AV55TFPaiPerVacHas_Sels.size()==0), (short)(0), AV55TFPaiPerVacHas_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIFRACVACANT", httpContext.getMessage( "Proporción de días de vacaciones disponibles pendientes de goce del año anterior", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFPaiFracVacAnt)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFPaiFracVacAnt_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV63TFPaiFracVacAnt, 6, 4)), GXutil.trim( GXutil.str( AV64TFPaiFracVacAnt_To, 6, 4))) ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIGUAREDADMIN", httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", ""), !((0==AV56TFPaiGuarEdadMin)&&(0==AV57TFPaiGuarEdadMin_To)), (short)(0), GXutil.trim( GXutil.str( AV56TFPaiGuarEdadMin, 2, 0)), GXutil.trim( GXutil.str( AV57TFPaiGuarEdadMin_To, 2, 0))) ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIGUAREDADMAX", httpContext.getMessage( "Edad máxima del hijo/hija hasta la que puede gozar el beneficio de guardería", ""), !((0==AV58TFPaiGuarEdadMax)&&(0==AV59TFPaiGuarEdadMax_To)), (short)(0), GXutil.trim( GXutil.str( AV58TFPaiGuarEdadMax, 2, 0)), GXutil.trim( GXutil.str( AV59TFPaiGuarEdadMax_To, 2, 0))) ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIEXCVIZZOTI_SEL", httpContext.getMessage( "Considerar excepción a uso de tope (fallo Vizzoti)", ""), !(0==AV60TFPaiExcVizzoti_Sel), (short)(0), GXutil.trim( GXutil.str( AV60TFPaiExcVizzoti_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFPAIVIZZOTI", httpContext.getMessage( "Proporción de sueldo para evaluar tope (fallo Vizzoti)", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFPaiVizzoti)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFPaiVizzoti_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV61TFPaiVizzoti, 6, 4)), GXutil.trim( GXutil.str( AV62TFPaiVizzoti_To, 6, 4))) ;
      AV12GridState = GXv_SdtWWPGridState17[0] ;
      if ( ! (GXutil.strcmp("", AV67MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV67MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV91Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV91Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Pais" );
      AV21Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e17CR2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV69WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean6[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV67MenuOpcCod, GXv_boolean6) ;
         GXv_char5[0] = AV71textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV36CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char5) ;
         paisww_impl.this.AV71textoNoMostrara = GXv_char5[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV71textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean6[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV67MenuOpcCod, GXv_boolean6) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_CR2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_CR2( true) ;
      }
      else
      {
         wb_table2_12_CR2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_CR2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_CR2e( true) ;
      }
      else
      {
         wb_table1_9_CR2e( false) ;
      }
   }

   public void wb_table2_12_CR2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e21cr1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_PaisWW.htm");
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
         AV75WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV75WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV90Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV75WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV75WelcomeMessage_Foto)==0) ? AV90Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV75WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV75WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_PaisWW.htm");
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
         wb_table3_30_CR2( true) ;
      }
      else
      {
         wb_table3_30_CR2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_CR2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_CR2( true) ;
      }
      else
      {
         wb_table4_35_CR2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_CR2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV69WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_PaisWW.htm");
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
         wb_table5_54_CR2( true) ;
      }
      else
      {
         wb_table5_54_CR2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_CR2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_CR2( true) ;
      }
      else
      {
         wb_table6_63_CR2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_CR2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV29GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV30GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV31GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_CR2e( true) ;
      }
      else
      {
         wb_table2_12_CR2e( false) ;
      }
   }

   public void wb_table6_63_CR2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_PaisWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_PaisWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV27DDO_TitleSettingsIcons);
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV76ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_PaisWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_PaisWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_97_CR2( true) ;
      }
      else
      {
         wb_table7_97_CR2( false) ;
      }
      return  ;
   }

   public void wb_table7_97_CR2e( boolean wbgen )
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
         wb_table6_63_CR2e( true) ;
      }
      else
      {
         wb_table6_63_CR2e( false) ;
      }
   }

   public void wb_table7_97_CR2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_PaisWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_97_CR2e( true) ;
      }
      else
      {
         wb_table7_97_CR2e( false) ;
      }
   }

   public void wb_table5_54_CR2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_PaisWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_PaisWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_CR2e( true) ;
      }
      else
      {
         wb_table5_54_CR2e( false) ;
      }
   }

   public void wb_table4_35_CR2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_PaisWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_CR2e( true) ;
      }
      else
      {
         wb_table4_35_CR2e( false) ;
      }
   }

   public void wb_table3_30_CR2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_PaisWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_CR2e( true) ;
      }
      else
      {
         wb_table3_30_CR2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV67MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67MenuOpcCod", AV67MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV67MenuOpcCod, ""))));
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
      paCR2( ) ;
      wsCR2( ) ;
      weCR2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025139531052", true, true);
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
      httpContext.AddJavascriptSource("paisww.js", "?2025139531053", false, true);
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
      edtPaiCod_Internalname = "PAICOD_"+sGXsfl_108_idx ;
      edtPaiNom_Internalname = "PAINOM_"+sGXsfl_108_idx ;
      edtPaiReligDefault_Internalname = "PAIRELIGDEFAULT_"+sGXsfl_108_idx ;
      edtPaiMesHsPExt_Internalname = "PAIMESHSPEXT_"+sGXsfl_108_idx ;
      cmbPaiDiaHsPExt.setInternalname( "PAIDIAHSPEXT_"+sGXsfl_108_idx );
      chkPaiFondoCese.setInternalname( "PAIFONDOCESE_"+sGXsfl_108_idx );
      edtPaiMaxHorNor_Internalname = "PAIMAXHORNOR_"+sGXsfl_108_idx ;
      cmbPaiPerVacDes.setInternalname( "PAIPERVACDES_"+sGXsfl_108_idx );
      cmbPaiPerVacHas.setInternalname( "PAIPERVACHAS_"+sGXsfl_108_idx );
      edtPaiFracVacAnt_Internalname = "PAIFRACVACANT_"+sGXsfl_108_idx ;
      edtPaiGuarEdadMin_Internalname = "PAIGUAREDADMIN_"+sGXsfl_108_idx ;
      edtPaiGuarEdadMax_Internalname = "PAIGUAREDADMAX_"+sGXsfl_108_idx ;
      chkPaiExcVizzoti.setInternalname( "PAIEXCVIZZOTI_"+sGXsfl_108_idx );
      edtPaiVizzoti_Internalname = "PAIVIZZOTI_"+sGXsfl_108_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_108_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_108_idx ;
   }

   public void subsflControlProps_fel_1082( )
   {
      edtPaiCod_Internalname = "PAICOD_"+sGXsfl_108_fel_idx ;
      edtPaiNom_Internalname = "PAINOM_"+sGXsfl_108_fel_idx ;
      edtPaiReligDefault_Internalname = "PAIRELIGDEFAULT_"+sGXsfl_108_fel_idx ;
      edtPaiMesHsPExt_Internalname = "PAIMESHSPEXT_"+sGXsfl_108_fel_idx ;
      cmbPaiDiaHsPExt.setInternalname( "PAIDIAHSPEXT_"+sGXsfl_108_fel_idx );
      chkPaiFondoCese.setInternalname( "PAIFONDOCESE_"+sGXsfl_108_fel_idx );
      edtPaiMaxHorNor_Internalname = "PAIMAXHORNOR_"+sGXsfl_108_fel_idx ;
      cmbPaiPerVacDes.setInternalname( "PAIPERVACDES_"+sGXsfl_108_fel_idx );
      cmbPaiPerVacHas.setInternalname( "PAIPERVACHAS_"+sGXsfl_108_fel_idx );
      edtPaiFracVacAnt_Internalname = "PAIFRACVACANT_"+sGXsfl_108_fel_idx ;
      edtPaiGuarEdadMin_Internalname = "PAIGUAREDADMIN_"+sGXsfl_108_fel_idx ;
      edtPaiGuarEdadMax_Internalname = "PAIGUAREDADMAX_"+sGXsfl_108_fel_idx ;
      chkPaiExcVizzoti.setInternalname( "PAIEXCVIZZOTI_"+sGXsfl_108_fel_idx );
      edtPaiVizzoti_Internalname = "PAIVIZZOTI_"+sGXsfl_108_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_108_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_fel_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_108_fel_idx ;
   }

   public void sendrow_1082( )
   {
      subsflControlProps_1082( ) ;
      wbCR0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPaiCod_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiCod_Internalname,GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiCod_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPaiNom_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiNom_Internalname,A312PaiNom,GXutil.rtrim( localUtil.format( A312PaiNom, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiNom_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiNom_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPaiReligDefault_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiReligDefault_Internalname,GXutil.rtrim( A1252PaiReligDefault),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiReligDefault_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiReligDefault_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPaiMesHsPExt_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiMesHsPExt_Internalname,GXutil.ltrim( localUtil.ntoc( A1271PaiMesHsPExt, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1271PaiMesHsPExt, "ZZ9.9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiMesHsPExt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiMesHsPExt_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbPaiDiaHsPExt.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPaiDiaHsPExt.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAIDIAHSPEXT_" + sGXsfl_108_idx ;
            cmbPaiDiaHsPExt.setName( GXCCtl );
            cmbPaiDiaHsPExt.setWebtags( "" );
            cmbPaiDiaHsPExt.addItem("", httpContext.getMessage( "(Default)", ""), (short)(0));
            cmbPaiDiaHsPExt.addItem("Promedio", httpContext.getMessage( "Promedio anual de días hábiles semanales por mes del empleado", ""), (short)(0));
            cmbPaiDiaHsPExt.addItem("diasSemanaX4", httpContext.getMessage( "Cantidad de días hábiles semanales del empleado multiplicados por 4", ""), (short)(0));
            cmbPaiDiaHsPExt.addItem("diasSemanaMes", httpContext.getMessage( "Cantidad de días hábiles del empleado en el mes específico de la liquidación", ""), (short)(0));
            if ( cmbPaiDiaHsPExt.getItemCount() > 0 )
            {
               A1272PaiDiaHsPExt = cmbPaiDiaHsPExt.getValidValue(A1272PaiDiaHsPExt) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPaiDiaHsPExt,cmbPaiDiaHsPExt.getInternalname(),GXutil.rtrim( A1272PaiDiaHsPExt),Integer.valueOf(1),cmbPaiDiaHsPExt.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbPaiDiaHsPExt.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbPaiDiaHsPExt.setValue( GXutil.rtrim( A1272PaiDiaHsPExt) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiDiaHsPExt.getInternalname(), "Values", cmbPaiDiaHsPExt.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkPaiFondoCese.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "PAIFONDOCESE_" + sGXsfl_108_idx ;
         chkPaiFondoCese.setName( GXCCtl );
         chkPaiFondoCese.setWebtags( "" );
         chkPaiFondoCese.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkPaiFondoCese.getInternalname(), "TitleCaption", chkPaiFondoCese.getCaption(), !bGXsfl_108_Refreshing);
         chkPaiFondoCese.setCheckedValue( "false" );
         A1402PaiFondoCese = GXutil.strtobool( GXutil.booltostr( A1402PaiFondoCese)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkPaiFondoCese.getInternalname(),GXutil.booltostr( A1402PaiFondoCese),"","",Integer.valueOf(chkPaiFondoCese.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPaiMaxHorNor_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiMaxHorNor_Internalname,GXutil.ltrim( localUtil.ntoc( A1405PaiMaxHorNor, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1405PaiMaxHorNor, "Z9.9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiMaxHorNor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiMaxHorNor_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbPaiPerVacDes.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPaiPerVacDes.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAIPERVACDES_" + sGXsfl_108_idx ;
            cmbPaiPerVacDes.setName( GXCCtl );
            cmbPaiPerVacDes.setWebtags( "" );
            cmbPaiPerVacDes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
            cmbPaiPerVacDes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
            cmbPaiPerVacDes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
            cmbPaiPerVacDes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
            cmbPaiPerVacDes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
            cmbPaiPerVacDes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
            cmbPaiPerVacDes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
            cmbPaiPerVacDes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
            cmbPaiPerVacDes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
            cmbPaiPerVacDes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
            cmbPaiPerVacDes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
            cmbPaiPerVacDes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
            if ( cmbPaiPerVacDes.getItemCount() > 0 )
            {
               A1521PaiPerVacDes = (byte)(GXutil.lval( cmbPaiPerVacDes.getValidValue(GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPaiPerVacDes,cmbPaiPerVacDes.getInternalname(),GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0)),Integer.valueOf(1),cmbPaiPerVacDes.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbPaiPerVacDes.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbPaiPerVacDes.setValue( GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiPerVacDes.getInternalname(), "Values", cmbPaiPerVacDes.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbPaiPerVacHas.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPaiPerVacHas.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAIPERVACHAS_" + sGXsfl_108_idx ;
            cmbPaiPerVacHas.setName( GXCCtl );
            cmbPaiPerVacHas.setWebtags( "" );
            cmbPaiPerVacHas.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
            cmbPaiPerVacHas.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
            cmbPaiPerVacHas.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
            cmbPaiPerVacHas.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
            cmbPaiPerVacHas.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
            cmbPaiPerVacHas.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
            cmbPaiPerVacHas.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
            cmbPaiPerVacHas.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
            cmbPaiPerVacHas.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
            cmbPaiPerVacHas.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
            cmbPaiPerVacHas.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
            cmbPaiPerVacHas.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
            if ( cmbPaiPerVacHas.getItemCount() > 0 )
            {
               A1522PaiPerVacHas = (byte)(GXutil.lval( cmbPaiPerVacHas.getValidValue(GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPaiPerVacHas,cmbPaiPerVacHas.getInternalname(),GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0)),Integer.valueOf(1),cmbPaiPerVacHas.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbPaiPerVacHas.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbPaiPerVacHas.setValue( GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiPerVacHas.getInternalname(), "Values", cmbPaiPerVacHas.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPaiFracVacAnt_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiFracVacAnt_Internalname,GXutil.ltrim( localUtil.ntoc( A1814PaiFracVacAnt, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1814PaiFracVacAnt, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiFracVacAnt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiFracVacAnt_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPaiGuarEdadMin_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiGuarEdadMin_Internalname,GXutil.ltrim( localUtil.ntoc( A1625PaiGuarEdadMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1625PaiGuarEdadMin), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiGuarEdadMin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiGuarEdadMin_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPaiGuarEdadMax_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiGuarEdadMax_Internalname,GXutil.ltrim( localUtil.ntoc( A1626PaiGuarEdadMax, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1626PaiGuarEdadMax), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiGuarEdadMax_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiGuarEdadMax_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkPaiExcVizzoti.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "PAIEXCVIZZOTI_" + sGXsfl_108_idx ;
         chkPaiExcVizzoti.setName( GXCCtl );
         chkPaiExcVizzoti.setWebtags( "" );
         chkPaiExcVizzoti.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkPaiExcVizzoti.getInternalname(), "TitleCaption", chkPaiExcVizzoti.getCaption(), !bGXsfl_108_Refreshing);
         chkPaiExcVizzoti.setCheckedValue( "false" );
         A1736PaiExcVizzoti = GXutil.strtobool( GXutil.booltostr( A1736PaiExcVizzoti)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkPaiExcVizzoti.getInternalname(),GXutil.booltostr( A1736PaiExcVizzoti),"","",Integer.valueOf(chkPaiExcVizzoti.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPaiVizzoti_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiVizzoti_Internalname,GXutil.ltrim( localUtil.ntoc( A1737PaiVizzoti, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1737PaiVizzoti, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiVizzoti_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiVizzoti_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = edtavUpdate_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV32Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),edtavUpdate_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV38Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV65VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV66ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesCR2( ) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiCod_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cod. Pais", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiNom_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nom. Pais", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiReligDefault_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Relig Default", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiMesHsPExt_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de horas del mes para cálculo 1 hora de trabajo para empleados de clase mensual", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPaiDiaHsPExt.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkPaiFondoCese.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiMaxHorNor_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Máximo de horas normales por día", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPaiPerVacDes.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Periodo de vacaciones desde", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPaiPerVacHas.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Periodo de vacaciones hasta", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiFracVacAnt_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Proporción de días de vacaciones disponibles pendientes de goce del año anterior", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiGuarEdadMin_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiGuarEdadMax_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Edad máxima del hijo/hija hasta la que puede gozar el beneficio de guardería", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkPaiExcVizzoti.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Considerar excepción a uso de tope (fallo Vizzoti)", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiVizzoti_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Proporción de sueldo para evaluar tope (fallo Vizzoti)", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavUpdate_Class+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiCod_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A312PaiNom);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiNom_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1252PaiReligDefault));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiReligDefault_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1271PaiMesHsPExt, (byte)(5), (byte)(1), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiMesHsPExt_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1272PaiDiaHsPExt));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPaiDiaHsPExt.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1402PaiFondoCese));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkPaiFondoCese.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1405PaiMaxHorNor, (byte)(4), (byte)(1), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiMaxHorNor_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1521PaiPerVacDes, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPaiPerVacDes.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1522PaiPerVacHas, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPaiPerVacHas.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1814PaiFracVacAnt, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiFracVacAnt_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1625PaiGuarEdadMin, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiGuarEdadMin_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1626PaiGuarEdadMax, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiGuarEdadMax_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1736PaiExcVizzoti));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkPaiExcVizzoti.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1737PaiVizzoti, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiVizzoti_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV32Update));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavUpdate_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV38Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV65VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV66ModificarSVG));
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
      edtPaiCod_Internalname = "PAICOD" ;
      edtPaiNom_Internalname = "PAINOM" ;
      edtPaiReligDefault_Internalname = "PAIRELIGDEFAULT" ;
      edtPaiMesHsPExt_Internalname = "PAIMESHSPEXT" ;
      cmbPaiDiaHsPExt.setInternalname( "PAIDIAHSPEXT" );
      chkPaiFondoCese.setInternalname( "PAIFONDOCESE" );
      edtPaiMaxHorNor_Internalname = "PAIMAXHORNOR" ;
      cmbPaiPerVacDes.setInternalname( "PAIPERVACDES" );
      cmbPaiPerVacHas.setInternalname( "PAIPERVACHAS" );
      edtPaiFracVacAnt_Internalname = "PAIFRACVACANT" ;
      edtPaiGuarEdadMin_Internalname = "PAIGUAREDADMIN" ;
      edtPaiGuarEdadMax_Internalname = "PAIGUAREDADMAX" ;
      chkPaiExcVizzoti.setInternalname( "PAIEXCVIZZOTI" );
      edtPaiVizzoti_Internalname = "PAIVIZZOTI" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG" ;
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
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Class = "Attribute" ;
      edtavUpdate_Enabled = 0 ;
      edtPaiVizzoti_Jsonclick = "" ;
      chkPaiExcVizzoti.setCaption( "" );
      edtPaiGuarEdadMax_Jsonclick = "" ;
      edtPaiGuarEdadMin_Jsonclick = "" ;
      edtPaiFracVacAnt_Jsonclick = "" ;
      cmbPaiPerVacHas.setJsonclick( "" );
      cmbPaiPerVacDes.setJsonclick( "" );
      edtPaiMaxHorNor_Jsonclick = "" ;
      chkPaiFondoCese.setCaption( "" );
      cmbPaiDiaHsPExt.setJsonclick( "" );
      edtPaiMesHsPExt_Jsonclick = "" ;
      edtPaiReligDefault_Jsonclick = "" ;
      edtPaiNom_Jsonclick = "" ;
      edtPaiCod_Jsonclick = "" ;
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
      edtPaiVizzoti_Visible = -1 ;
      chkPaiExcVizzoti.setVisible( -1 );
      edtPaiGuarEdadMax_Visible = -1 ;
      edtPaiGuarEdadMin_Visible = -1 ;
      edtPaiFracVacAnt_Visible = -1 ;
      cmbPaiPerVacHas.setVisible( -1 );
      cmbPaiPerVacDes.setVisible( -1 );
      edtPaiMaxHorNor_Visible = -1 ;
      chkPaiFondoCese.setVisible( -1 );
      cmbPaiDiaHsPExt.setVisible( -1 );
      edtPaiMesHsPExt_Visible = -1 ;
      edtPaiReligDefault_Visible = -1 ;
      edtPaiNom_Visible = -1 ;
      edtPaiCod_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "4.0|||5.1|||4.1|||6.4|2.0|2.0||6.4" ;
      Ddo_grid_Datalistproc = "PaisWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||Promedio:Promedio anual de días hábiles semanales por mes del empleado,diasSemanaX4:Cantidad de días hábiles semanales del empleado multiplicados por 4,diasSemanaMes:Cantidad de días hábiles del empleado en el mes específico de la liquidación|1:WWP_TSChecked,2:WWP_TSUnChecked||1:Enero,2:Febrero,3:Marzo,4:Abril,5:Mayo,6:Junio,7:Julio,8:Agosto,9:Septiembre,10:Octubre,11:Noviembre,12:Diciembre|1:Enero,2:Febrero,3:Marzo,4:Abril,5:Mayo,6:Junio,7:Julio,8:Agosto,9:Septiembre,10:Octubre,11:Noviembre,12:Diciembre||||1:WWP_TSChecked,2:WWP_TSUnChecked|" ;
      Ddo_grid_Allowmultipleselection = "|T|T||T|||T|T|||||" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic||FixedValues|FixedValues||FixedValues|FixedValues||||FixedValues|" ;
      Ddo_grid_Includedatalist = "|T|T||T|T||T|T||||T|" ;
      Ddo_grid_Filterisrange = "T|||T|||T|||T|T|T||T" ;
      Ddo_grid_Filtertype = "Numeric|Character|Character|Numeric|||Numeric|||Numeric|Numeric|Numeric||Numeric" ;
      Ddo_grid_Includefilter = "T|T|T|T|||T|||T|T|T||T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8|9|10|11|12|13|14" ;
      Ddo_grid_Columnids = "0:PaiCod|1:PaiNom|2:PaiReligDefault|3:PaiMesHsPExt|4:PaiDiaHsPExt|5:PaiFondoCese|6:PaiMaxHorNor|7:PaiPerVacDes|8:PaiPerVacHas|9:PaiFracVacAnt|10:PaiGuarEdadMin|11:PaiGuarEdadMax|12:PaiExcVizzoti|13:PaiVizzoti" ;
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
      Form.setCaption( httpContext.getMessage( " Pais", "") );
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
      AV69WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV69WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69WelcomeMessage_NoMostrarMas", AV69WelcomeMessage_NoMostrarMas);
      GXCCtl = "PAIDIAHSPEXT_" + sGXsfl_108_idx ;
      cmbPaiDiaHsPExt.setName( GXCCtl );
      cmbPaiDiaHsPExt.setWebtags( "" );
      cmbPaiDiaHsPExt.addItem("", httpContext.getMessage( "(Default)", ""), (short)(0));
      cmbPaiDiaHsPExt.addItem("Promedio", httpContext.getMessage( "Promedio anual de días hábiles semanales por mes del empleado", ""), (short)(0));
      cmbPaiDiaHsPExt.addItem("diasSemanaX4", httpContext.getMessage( "Cantidad de días hábiles semanales del empleado multiplicados por 4", ""), (short)(0));
      cmbPaiDiaHsPExt.addItem("diasSemanaMes", httpContext.getMessage( "Cantidad de días hábiles del empleado en el mes específico de la liquidación", ""), (short)(0));
      if ( cmbPaiDiaHsPExt.getItemCount() > 0 )
      {
         A1272PaiDiaHsPExt = cmbPaiDiaHsPExt.getValidValue(A1272PaiDiaHsPExt) ;
      }
      GXCCtl = "PAIFONDOCESE_" + sGXsfl_108_idx ;
      chkPaiFondoCese.setName( GXCCtl );
      chkPaiFondoCese.setWebtags( "" );
      chkPaiFondoCese.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiFondoCese.getInternalname(), "TitleCaption", chkPaiFondoCese.getCaption(), !bGXsfl_108_Refreshing);
      chkPaiFondoCese.setCheckedValue( "false" );
      A1402PaiFondoCese = GXutil.strtobool( GXutil.booltostr( A1402PaiFondoCese)) ;
      GXCCtl = "PAIPERVACDES_" + sGXsfl_108_idx ;
      cmbPaiPerVacDes.setName( GXCCtl );
      cmbPaiPerVacDes.setWebtags( "" );
      cmbPaiPerVacDes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbPaiPerVacDes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbPaiPerVacDes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbPaiPerVacDes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbPaiPerVacDes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbPaiPerVacDes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbPaiPerVacDes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbPaiPerVacDes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbPaiPerVacDes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbPaiPerVacDes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbPaiPerVacDes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbPaiPerVacDes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbPaiPerVacDes.getItemCount() > 0 )
      {
         A1521PaiPerVacDes = (byte)(GXutil.lval( cmbPaiPerVacDes.getValidValue(GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0))))) ;
      }
      GXCCtl = "PAIPERVACHAS_" + sGXsfl_108_idx ;
      cmbPaiPerVacHas.setName( GXCCtl );
      cmbPaiPerVacHas.setWebtags( "" );
      cmbPaiPerVacHas.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbPaiPerVacHas.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbPaiPerVacHas.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbPaiPerVacHas.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbPaiPerVacHas.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbPaiPerVacHas.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbPaiPerVacHas.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbPaiPerVacHas.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbPaiPerVacHas.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbPaiPerVacHas.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbPaiPerVacHas.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbPaiPerVacHas.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbPaiPerVacHas.getItemCount() > 0 )
      {
         A1522PaiPerVacHas = (byte)(GXutil.lval( cmbPaiPerVacHas.getValidValue(GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0))))) ;
      }
      GXCCtl = "PAIEXCVIZZOTI_" + sGXsfl_108_idx ;
      chkPaiExcVizzoti.setName( GXCCtl );
      chkPaiExcVizzoti.setWebtags( "" );
      chkPaiExcVizzoti.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiExcVizzoti.getInternalname(), "TitleCaption", chkPaiExcVizzoti.getCaption(), !bGXsfl_108_Refreshing);
      chkPaiExcVizzoti.setCheckedValue( "false" );
      A1736PaiExcVizzoti = GXutil.strtobool( GXutil.booltostr( A1736PaiExcVizzoti)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV67MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFPaiCod',fld:'vTFPAICOD',pic:'ZZZ9'},{av:'AV23TFPaiCod_To',fld:'vTFPAICOD_TO',pic:'ZZZ9'},{av:'AV25TFPaiNom',fld:'vTFPAINOM',pic:'@!'},{av:'AV26TFPaiNom_Sels',fld:'vTFPAINOM_SELS',pic:''},{av:'AV43TFPaiReligDefault',fld:'vTFPAIRELIGDEFAULT',pic:''},{av:'AV44TFPaiReligDefault_Sels',fld:'vTFPAIRELIGDEFAULT_SELS',pic:''},{av:'AV45TFPaiMesHsPExt',fld:'vTFPAIMESHSPEXT',pic:'ZZ9.9'},{av:'AV46TFPaiMesHsPExt_To',fld:'vTFPAIMESHSPEXT_TO',pic:'ZZ9.9'},{av:'AV48TFPaiDiaHsPExt_Sels',fld:'vTFPAIDIAHSPEXT_SELS',pic:''},{av:'AV49TFPaiFondoCese_Sel',fld:'vTFPAIFONDOCESE_SEL',pic:'9'},{av:'AV50TFPaiMaxHorNor',fld:'vTFPAIMAXHORNOR',pic:'Z9.9'},{av:'AV51TFPaiMaxHorNor_To',fld:'vTFPAIMAXHORNOR_TO',pic:'Z9.9'},{av:'AV53TFPaiPerVacDes_Sels',fld:'vTFPAIPERVACDES_SELS',pic:''},{av:'AV55TFPaiPerVacHas_Sels',fld:'vTFPAIPERVACHAS_SELS',pic:''},{av:'AV63TFPaiFracVacAnt',fld:'vTFPAIFRACVACANT',pic:'9.9999'},{av:'AV64TFPaiFracVacAnt_To',fld:'vTFPAIFRACVACANT_TO',pic:'9.9999'},{av:'AV56TFPaiGuarEdadMin',fld:'vTFPAIGUAREDADMIN',pic:'Z9'},{av:'AV57TFPaiGuarEdadMin_To',fld:'vTFPAIGUAREDADMIN_TO',pic:'Z9'},{av:'AV58TFPaiGuarEdadMax',fld:'vTFPAIGUAREDADMAX',pic:'Z9'},{av:'AV59TFPaiGuarEdadMax_To',fld:'vTFPAIGUAREDADMAX_TO',pic:'Z9'},{av:'AV60TFPaiExcVizzoti_Sel',fld:'vTFPAIEXCVIZZOTI_SEL',pic:'9'},{av:'AV61TFPaiVizzoti',fld:'vTFPAIVIZZOTI',pic:'9.9999'},{av:'AV62TFPaiVizzoti_To',fld:'vTFPAIVIZZOTI_TO',pic:'9.9999'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV33IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV69WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtPaiCod_Visible',ctrl:'PAICOD',prop:'Visible'},{av:'edtPaiNom_Visible',ctrl:'PAINOM',prop:'Visible'},{av:'edtPaiReligDefault_Visible',ctrl:'PAIRELIGDEFAULT',prop:'Visible'},{av:'edtPaiMesHsPExt_Visible',ctrl:'PAIMESHSPEXT',prop:'Visible'},{av:'cmbPaiDiaHsPExt'},{av:'chkPaiFondoCese.getVisible()',ctrl:'PAIFONDOCESE',prop:'Visible'},{av:'edtPaiMaxHorNor_Visible',ctrl:'PAIMAXHORNOR',prop:'Visible'},{av:'cmbPaiPerVacDes'},{av:'cmbPaiPerVacHas'},{av:'edtPaiFracVacAnt_Visible',ctrl:'PAIFRACVACANT',prop:'Visible'},{av:'edtPaiGuarEdadMin_Visible',ctrl:'PAIGUAREDADMIN',prop:'Visible'},{av:'edtPaiGuarEdadMax_Visible',ctrl:'PAIGUAREDADMAX',prop:'Visible'},{av:'chkPaiExcVizzoti.getVisible()',ctrl:'PAIEXCVIZZOTI',prop:'Visible'},{av:'edtPaiVizzoti_Visible',ctrl:'PAIVIZZOTI',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV29GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV30GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV31GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV33IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV76ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13CR2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV67MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFPaiCod',fld:'vTFPAICOD',pic:'ZZZ9'},{av:'AV23TFPaiCod_To',fld:'vTFPAICOD_TO',pic:'ZZZ9'},{av:'AV25TFPaiNom',fld:'vTFPAINOM',pic:'@!'},{av:'AV26TFPaiNom_Sels',fld:'vTFPAINOM_SELS',pic:''},{av:'AV43TFPaiReligDefault',fld:'vTFPAIRELIGDEFAULT',pic:''},{av:'AV44TFPaiReligDefault_Sels',fld:'vTFPAIRELIGDEFAULT_SELS',pic:''},{av:'AV45TFPaiMesHsPExt',fld:'vTFPAIMESHSPEXT',pic:'ZZ9.9'},{av:'AV46TFPaiMesHsPExt_To',fld:'vTFPAIMESHSPEXT_TO',pic:'ZZ9.9'},{av:'AV48TFPaiDiaHsPExt_Sels',fld:'vTFPAIDIAHSPEXT_SELS',pic:''},{av:'AV49TFPaiFondoCese_Sel',fld:'vTFPAIFONDOCESE_SEL',pic:'9'},{av:'AV50TFPaiMaxHorNor',fld:'vTFPAIMAXHORNOR',pic:'Z9.9'},{av:'AV51TFPaiMaxHorNor_To',fld:'vTFPAIMAXHORNOR_TO',pic:'Z9.9'},{av:'AV53TFPaiPerVacDes_Sels',fld:'vTFPAIPERVACDES_SELS',pic:''},{av:'AV55TFPaiPerVacHas_Sels',fld:'vTFPAIPERVACHAS_SELS',pic:''},{av:'AV63TFPaiFracVacAnt',fld:'vTFPAIFRACVACANT',pic:'9.9999'},{av:'AV64TFPaiFracVacAnt_To',fld:'vTFPAIFRACVACANT_TO',pic:'9.9999'},{av:'AV56TFPaiGuarEdadMin',fld:'vTFPAIGUAREDADMIN',pic:'Z9'},{av:'AV57TFPaiGuarEdadMin_To',fld:'vTFPAIGUAREDADMIN_TO',pic:'Z9'},{av:'AV58TFPaiGuarEdadMax',fld:'vTFPAIGUAREDADMAX',pic:'Z9'},{av:'AV59TFPaiGuarEdadMax_To',fld:'vTFPAIGUAREDADMAX_TO',pic:'Z9'},{av:'AV60TFPaiExcVizzoti_Sel',fld:'vTFPAIEXCVIZZOTI_SEL',pic:'9'},{av:'AV61TFPaiVizzoti',fld:'vTFPAIVIZZOTI',pic:'9.9999'},{av:'AV62TFPaiVizzoti_To',fld:'vTFPAIVIZZOTI_TO',pic:'9.9999'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV33IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV69WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14CR2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV67MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFPaiCod',fld:'vTFPAICOD',pic:'ZZZ9'},{av:'AV23TFPaiCod_To',fld:'vTFPAICOD_TO',pic:'ZZZ9'},{av:'AV25TFPaiNom',fld:'vTFPAINOM',pic:'@!'},{av:'AV26TFPaiNom_Sels',fld:'vTFPAINOM_SELS',pic:''},{av:'AV43TFPaiReligDefault',fld:'vTFPAIRELIGDEFAULT',pic:''},{av:'AV44TFPaiReligDefault_Sels',fld:'vTFPAIRELIGDEFAULT_SELS',pic:''},{av:'AV45TFPaiMesHsPExt',fld:'vTFPAIMESHSPEXT',pic:'ZZ9.9'},{av:'AV46TFPaiMesHsPExt_To',fld:'vTFPAIMESHSPEXT_TO',pic:'ZZ9.9'},{av:'AV48TFPaiDiaHsPExt_Sels',fld:'vTFPAIDIAHSPEXT_SELS',pic:''},{av:'AV49TFPaiFondoCese_Sel',fld:'vTFPAIFONDOCESE_SEL',pic:'9'},{av:'AV50TFPaiMaxHorNor',fld:'vTFPAIMAXHORNOR',pic:'Z9.9'},{av:'AV51TFPaiMaxHorNor_To',fld:'vTFPAIMAXHORNOR_TO',pic:'Z9.9'},{av:'AV53TFPaiPerVacDes_Sels',fld:'vTFPAIPERVACDES_SELS',pic:''},{av:'AV55TFPaiPerVacHas_Sels',fld:'vTFPAIPERVACHAS_SELS',pic:''},{av:'AV63TFPaiFracVacAnt',fld:'vTFPAIFRACVACANT',pic:'9.9999'},{av:'AV64TFPaiFracVacAnt_To',fld:'vTFPAIFRACVACANT_TO',pic:'9.9999'},{av:'AV56TFPaiGuarEdadMin',fld:'vTFPAIGUAREDADMIN',pic:'Z9'},{av:'AV57TFPaiGuarEdadMin_To',fld:'vTFPAIGUAREDADMIN_TO',pic:'Z9'},{av:'AV58TFPaiGuarEdadMax',fld:'vTFPAIGUAREDADMAX',pic:'Z9'},{av:'AV59TFPaiGuarEdadMax_To',fld:'vTFPAIGUAREDADMAX_TO',pic:'Z9'},{av:'AV60TFPaiExcVizzoti_Sel',fld:'vTFPAIEXCVIZZOTI_SEL',pic:'9'},{av:'AV61TFPaiVizzoti',fld:'vTFPAIVIZZOTI',pic:'9.9999'},{av:'AV62TFPaiVizzoti_To',fld:'vTFPAIVIZZOTI_TO',pic:'9.9999'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV33IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV69WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15CR2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV67MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFPaiCod',fld:'vTFPAICOD',pic:'ZZZ9'},{av:'AV23TFPaiCod_To',fld:'vTFPAICOD_TO',pic:'ZZZ9'},{av:'AV25TFPaiNom',fld:'vTFPAINOM',pic:'@!'},{av:'AV26TFPaiNom_Sels',fld:'vTFPAINOM_SELS',pic:''},{av:'AV43TFPaiReligDefault',fld:'vTFPAIRELIGDEFAULT',pic:''},{av:'AV44TFPaiReligDefault_Sels',fld:'vTFPAIRELIGDEFAULT_SELS',pic:''},{av:'AV45TFPaiMesHsPExt',fld:'vTFPAIMESHSPEXT',pic:'ZZ9.9'},{av:'AV46TFPaiMesHsPExt_To',fld:'vTFPAIMESHSPEXT_TO',pic:'ZZ9.9'},{av:'AV48TFPaiDiaHsPExt_Sels',fld:'vTFPAIDIAHSPEXT_SELS',pic:''},{av:'AV49TFPaiFondoCese_Sel',fld:'vTFPAIFONDOCESE_SEL',pic:'9'},{av:'AV50TFPaiMaxHorNor',fld:'vTFPAIMAXHORNOR',pic:'Z9.9'},{av:'AV51TFPaiMaxHorNor_To',fld:'vTFPAIMAXHORNOR_TO',pic:'Z9.9'},{av:'AV53TFPaiPerVacDes_Sels',fld:'vTFPAIPERVACDES_SELS',pic:''},{av:'AV55TFPaiPerVacHas_Sels',fld:'vTFPAIPERVACHAS_SELS',pic:''},{av:'AV63TFPaiFracVacAnt',fld:'vTFPAIFRACVACANT',pic:'9.9999'},{av:'AV64TFPaiFracVacAnt_To',fld:'vTFPAIFRACVACANT_TO',pic:'9.9999'},{av:'AV56TFPaiGuarEdadMin',fld:'vTFPAIGUAREDADMIN',pic:'Z9'},{av:'AV57TFPaiGuarEdadMin_To',fld:'vTFPAIGUAREDADMIN_TO',pic:'Z9'},{av:'AV58TFPaiGuarEdadMax',fld:'vTFPAIGUAREDADMAX',pic:'Z9'},{av:'AV59TFPaiGuarEdadMax_To',fld:'vTFPAIGUAREDADMAX_TO',pic:'Z9'},{av:'AV60TFPaiExcVizzoti_Sel',fld:'vTFPAIEXCVIZZOTI_SEL',pic:'9'},{av:'AV61TFPaiVizzoti',fld:'vTFPAIVIZZOTI',pic:'9.9999'},{av:'AV62TFPaiVizzoti_To',fld:'vTFPAIVIZZOTI_TO',pic:'9.9999'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV33IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV69WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV61TFPaiVizzoti',fld:'vTFPAIVIZZOTI',pic:'9.9999'},{av:'AV62TFPaiVizzoti_To',fld:'vTFPAIVIZZOTI_TO',pic:'9.9999'},{av:'AV60TFPaiExcVizzoti_Sel',fld:'vTFPAIEXCVIZZOTI_SEL',pic:'9'},{av:'AV58TFPaiGuarEdadMax',fld:'vTFPAIGUAREDADMAX',pic:'Z9'},{av:'AV59TFPaiGuarEdadMax_To',fld:'vTFPAIGUAREDADMAX_TO',pic:'Z9'},{av:'AV56TFPaiGuarEdadMin',fld:'vTFPAIGUAREDADMIN',pic:'Z9'},{av:'AV57TFPaiGuarEdadMin_To',fld:'vTFPAIGUAREDADMIN_TO',pic:'Z9'},{av:'AV63TFPaiFracVacAnt',fld:'vTFPAIFRACVACANT',pic:'9.9999'},{av:'AV64TFPaiFracVacAnt_To',fld:'vTFPAIFRACVACANT_TO',pic:'9.9999'},{av:'AV54TFPaiPerVacHas_SelsJson',fld:'vTFPAIPERVACHAS_SELSJSON',pic:''},{av:'AV55TFPaiPerVacHas_Sels',fld:'vTFPAIPERVACHAS_SELS',pic:''},{av:'AV52TFPaiPerVacDes_SelsJson',fld:'vTFPAIPERVACDES_SELSJSON',pic:''},{av:'AV53TFPaiPerVacDes_Sels',fld:'vTFPAIPERVACDES_SELS',pic:''},{av:'AV50TFPaiMaxHorNor',fld:'vTFPAIMAXHORNOR',pic:'Z9.9'},{av:'AV51TFPaiMaxHorNor_To',fld:'vTFPAIMAXHORNOR_TO',pic:'Z9.9'},{av:'AV49TFPaiFondoCese_Sel',fld:'vTFPAIFONDOCESE_SEL',pic:'9'},{av:'AV47TFPaiDiaHsPExt_SelsJson',fld:'vTFPAIDIAHSPEXT_SELSJSON',pic:''},{av:'AV48TFPaiDiaHsPExt_Sels',fld:'vTFPAIDIAHSPEXT_SELS',pic:''},{av:'AV45TFPaiMesHsPExt',fld:'vTFPAIMESHSPEXT',pic:'ZZ9.9'},{av:'AV46TFPaiMesHsPExt_To',fld:'vTFPAIMESHSPEXT_TO',pic:'ZZ9.9'},{av:'AV43TFPaiReligDefault',fld:'vTFPAIRELIGDEFAULT',pic:''},{av:'AV42TFPaiReligDefault_SelsJson',fld:'vTFPAIRELIGDEFAULT_SELSJSON',pic:''},{av:'AV44TFPaiReligDefault_Sels',fld:'vTFPAIRELIGDEFAULT_SELS',pic:''},{av:'AV25TFPaiNom',fld:'vTFPAINOM',pic:'@!'},{av:'AV24TFPaiNom_SelsJson',fld:'vTFPAINOM_SELSJSON',pic:''},{av:'AV26TFPaiNom_Sels',fld:'vTFPAINOM_SELS',pic:''},{av:'AV22TFPaiCod',fld:'vTFPAICOD',pic:'ZZZ9'},{av:'AV23TFPaiCod_To',fld:'vTFPAICOD_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e20CR2',iparms:[{av:'AV33IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV32Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'edtavUpdate_Class',ctrl:'vUPDATE',prop:'Class'},{av:'AV38Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV65VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV66ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11CR2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV67MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFPaiCod',fld:'vTFPAICOD',pic:'ZZZ9'},{av:'AV23TFPaiCod_To',fld:'vTFPAICOD_TO',pic:'ZZZ9'},{av:'AV25TFPaiNom',fld:'vTFPAINOM',pic:'@!'},{av:'AV26TFPaiNom_Sels',fld:'vTFPAINOM_SELS',pic:''},{av:'AV43TFPaiReligDefault',fld:'vTFPAIRELIGDEFAULT',pic:''},{av:'AV44TFPaiReligDefault_Sels',fld:'vTFPAIRELIGDEFAULT_SELS',pic:''},{av:'AV45TFPaiMesHsPExt',fld:'vTFPAIMESHSPEXT',pic:'ZZ9.9'},{av:'AV46TFPaiMesHsPExt_To',fld:'vTFPAIMESHSPEXT_TO',pic:'ZZ9.9'},{av:'AV48TFPaiDiaHsPExt_Sels',fld:'vTFPAIDIAHSPEXT_SELS',pic:''},{av:'AV49TFPaiFondoCese_Sel',fld:'vTFPAIFONDOCESE_SEL',pic:'9'},{av:'AV50TFPaiMaxHorNor',fld:'vTFPAIMAXHORNOR',pic:'Z9.9'},{av:'AV51TFPaiMaxHorNor_To',fld:'vTFPAIMAXHORNOR_TO',pic:'Z9.9'},{av:'AV53TFPaiPerVacDes_Sels',fld:'vTFPAIPERVACDES_SELS',pic:''},{av:'AV55TFPaiPerVacHas_Sels',fld:'vTFPAIPERVACHAS_SELS',pic:''},{av:'AV63TFPaiFracVacAnt',fld:'vTFPAIFRACVACANT',pic:'9.9999'},{av:'AV64TFPaiFracVacAnt_To',fld:'vTFPAIFRACVACANT_TO',pic:'9.9999'},{av:'AV56TFPaiGuarEdadMin',fld:'vTFPAIGUAREDADMIN',pic:'Z9'},{av:'AV57TFPaiGuarEdadMin_To',fld:'vTFPAIGUAREDADMIN_TO',pic:'Z9'},{av:'AV58TFPaiGuarEdadMax',fld:'vTFPAIGUAREDADMAX',pic:'Z9'},{av:'AV59TFPaiGuarEdadMax_To',fld:'vTFPAIGUAREDADMAX_TO',pic:'Z9'},{av:'AV60TFPaiExcVizzoti_Sel',fld:'vTFPAIEXCVIZZOTI_SEL',pic:'9'},{av:'AV61TFPaiVizzoti',fld:'vTFPAIVIZZOTI',pic:'9.9999'},{av:'AV62TFPaiVizzoti_To',fld:'vTFPAIVIZZOTI_TO',pic:'9.9999'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV33IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV69WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtPaiCod_Visible',ctrl:'PAICOD',prop:'Visible'},{av:'edtPaiNom_Visible',ctrl:'PAINOM',prop:'Visible'},{av:'edtPaiReligDefault_Visible',ctrl:'PAIRELIGDEFAULT',prop:'Visible'},{av:'edtPaiMesHsPExt_Visible',ctrl:'PAIMESHSPEXT',prop:'Visible'},{av:'cmbPaiDiaHsPExt'},{av:'chkPaiFondoCese.getVisible()',ctrl:'PAIFONDOCESE',prop:'Visible'},{av:'edtPaiMaxHorNor_Visible',ctrl:'PAIMAXHORNOR',prop:'Visible'},{av:'cmbPaiPerVacDes'},{av:'cmbPaiPerVacHas'},{av:'edtPaiFracVacAnt_Visible',ctrl:'PAIFRACVACANT',prop:'Visible'},{av:'edtPaiGuarEdadMin_Visible',ctrl:'PAIGUAREDADMIN',prop:'Visible'},{av:'edtPaiGuarEdadMax_Visible',ctrl:'PAIGUAREDADMAX',prop:'Visible'},{av:'chkPaiExcVizzoti.getVisible()',ctrl:'PAIEXCVIZZOTI',prop:'Visible'},{av:'edtPaiVizzoti_Visible',ctrl:'PAIVIZZOTI',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV29GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV30GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV31GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV33IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV76ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12CR2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV67MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFPaiCod',fld:'vTFPAICOD',pic:'ZZZ9'},{av:'AV23TFPaiCod_To',fld:'vTFPAICOD_TO',pic:'ZZZ9'},{av:'AV25TFPaiNom',fld:'vTFPAINOM',pic:'@!'},{av:'AV26TFPaiNom_Sels',fld:'vTFPAINOM_SELS',pic:''},{av:'AV43TFPaiReligDefault',fld:'vTFPAIRELIGDEFAULT',pic:''},{av:'AV44TFPaiReligDefault_Sels',fld:'vTFPAIRELIGDEFAULT_SELS',pic:''},{av:'AV45TFPaiMesHsPExt',fld:'vTFPAIMESHSPEXT',pic:'ZZ9.9'},{av:'AV46TFPaiMesHsPExt_To',fld:'vTFPAIMESHSPEXT_TO',pic:'ZZ9.9'},{av:'AV48TFPaiDiaHsPExt_Sels',fld:'vTFPAIDIAHSPEXT_SELS',pic:''},{av:'AV49TFPaiFondoCese_Sel',fld:'vTFPAIFONDOCESE_SEL',pic:'9'},{av:'AV50TFPaiMaxHorNor',fld:'vTFPAIMAXHORNOR',pic:'Z9.9'},{av:'AV51TFPaiMaxHorNor_To',fld:'vTFPAIMAXHORNOR_TO',pic:'Z9.9'},{av:'AV53TFPaiPerVacDes_Sels',fld:'vTFPAIPERVACDES_SELS',pic:''},{av:'AV55TFPaiPerVacHas_Sels',fld:'vTFPAIPERVACHAS_SELS',pic:''},{av:'AV63TFPaiFracVacAnt',fld:'vTFPAIFRACVACANT',pic:'9.9999'},{av:'AV64TFPaiFracVacAnt_To',fld:'vTFPAIFRACVACANT_TO',pic:'9.9999'},{av:'AV56TFPaiGuarEdadMin',fld:'vTFPAIGUAREDADMIN',pic:'Z9'},{av:'AV57TFPaiGuarEdadMin_To',fld:'vTFPAIGUAREDADMIN_TO',pic:'Z9'},{av:'AV58TFPaiGuarEdadMax',fld:'vTFPAIGUAREDADMAX',pic:'Z9'},{av:'AV59TFPaiGuarEdadMax_To',fld:'vTFPAIGUAREDADMAX_TO',pic:'Z9'},{av:'AV60TFPaiExcVizzoti_Sel',fld:'vTFPAIEXCVIZZOTI_SEL',pic:'9'},{av:'AV61TFPaiVizzoti',fld:'vTFPAIVIZZOTI',pic:'9.9999'},{av:'AV62TFPaiVizzoti_To',fld:'vTFPAIVIZZOTI_TO',pic:'9.9999'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV33IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV69WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV24TFPaiNom_SelsJson',fld:'vTFPAINOM_SELSJSON',pic:''},{av:'AV42TFPaiReligDefault_SelsJson',fld:'vTFPAIRELIGDEFAULT_SELSJSON',pic:''},{av:'AV47TFPaiDiaHsPExt_SelsJson',fld:'vTFPAIDIAHSPEXT_SELSJSON',pic:''},{av:'AV52TFPaiPerVacDes_SelsJson',fld:'vTFPAIPERVACDES_SELSJSON',pic:''},{av:'AV54TFPaiPerVacHas_SelsJson',fld:'vTFPAIPERVACHAS_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV22TFPaiCod',fld:'vTFPAICOD',pic:'ZZZ9'},{av:'AV23TFPaiCod_To',fld:'vTFPAICOD_TO',pic:'ZZZ9'},{av:'AV25TFPaiNom',fld:'vTFPAINOM',pic:'@!'},{av:'AV26TFPaiNom_Sels',fld:'vTFPAINOM_SELS',pic:''},{av:'AV43TFPaiReligDefault',fld:'vTFPAIRELIGDEFAULT',pic:''},{av:'AV44TFPaiReligDefault_Sels',fld:'vTFPAIRELIGDEFAULT_SELS',pic:''},{av:'AV45TFPaiMesHsPExt',fld:'vTFPAIMESHSPEXT',pic:'ZZ9.9'},{av:'AV46TFPaiMesHsPExt_To',fld:'vTFPAIMESHSPEXT_TO',pic:'ZZ9.9'},{av:'AV48TFPaiDiaHsPExt_Sels',fld:'vTFPAIDIAHSPEXT_SELS',pic:''},{av:'AV49TFPaiFondoCese_Sel',fld:'vTFPAIFONDOCESE_SEL',pic:'9'},{av:'AV50TFPaiMaxHorNor',fld:'vTFPAIMAXHORNOR',pic:'Z9.9'},{av:'AV51TFPaiMaxHorNor_To',fld:'vTFPAIMAXHORNOR_TO',pic:'Z9.9'},{av:'AV53TFPaiPerVacDes_Sels',fld:'vTFPAIPERVACDES_SELS',pic:''},{av:'AV55TFPaiPerVacHas_Sels',fld:'vTFPAIPERVACHAS_SELS',pic:''},{av:'AV63TFPaiFracVacAnt',fld:'vTFPAIFRACVACANT',pic:'9.9999'},{av:'AV64TFPaiFracVacAnt_To',fld:'vTFPAIFRACVACANT_TO',pic:'9.9999'},{av:'AV56TFPaiGuarEdadMin',fld:'vTFPAIGUAREDADMIN',pic:'Z9'},{av:'AV57TFPaiGuarEdadMin_To',fld:'vTFPAIGUAREDADMIN_TO',pic:'Z9'},{av:'AV58TFPaiGuarEdadMax',fld:'vTFPAIGUAREDADMAX',pic:'Z9'},{av:'AV59TFPaiGuarEdadMax_To',fld:'vTFPAIGUAREDADMAX_TO',pic:'Z9'},{av:'AV60TFPaiExcVizzoti_Sel',fld:'vTFPAIEXCVIZZOTI_SEL',pic:'9'},{av:'AV61TFPaiVizzoti',fld:'vTFPAIVIZZOTI',pic:'9.9999'},{av:'AV62TFPaiVizzoti_To',fld:'vTFPAIVIZZOTI_TO',pic:'9.9999'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV54TFPaiPerVacHas_SelsJson',fld:'vTFPAIPERVACHAS_SELSJSON',pic:''},{av:'AV52TFPaiPerVacDes_SelsJson',fld:'vTFPAIPERVACDES_SELSJSON',pic:''},{av:'AV47TFPaiDiaHsPExt_SelsJson',fld:'vTFPAIDIAHSPEXT_SELSJSON',pic:''},{av:'AV42TFPaiReligDefault_SelsJson',fld:'vTFPAIRELIGDEFAULT_SELSJSON',pic:''},{av:'AV24TFPaiNom_SelsJson',fld:'vTFPAINOM_SELSJSON',pic:''},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtPaiCod_Visible',ctrl:'PAICOD',prop:'Visible'},{av:'edtPaiNom_Visible',ctrl:'PAINOM',prop:'Visible'},{av:'edtPaiReligDefault_Visible',ctrl:'PAIRELIGDEFAULT',prop:'Visible'},{av:'edtPaiMesHsPExt_Visible',ctrl:'PAIMESHSPEXT',prop:'Visible'},{av:'cmbPaiDiaHsPExt'},{av:'chkPaiFondoCese.getVisible()',ctrl:'PAIFONDOCESE',prop:'Visible'},{av:'edtPaiMaxHorNor_Visible',ctrl:'PAIMAXHORNOR',prop:'Visible'},{av:'cmbPaiPerVacDes'},{av:'cmbPaiPerVacHas'},{av:'edtPaiFracVacAnt_Visible',ctrl:'PAIFRACVACANT',prop:'Visible'},{av:'edtPaiGuarEdadMin_Visible',ctrl:'PAIGUAREDADMIN',prop:'Visible'},{av:'edtPaiGuarEdadMax_Visible',ctrl:'PAIGUAREDADMAX',prop:'Visible'},{av:'chkPaiExcVizzoti.getVisible()',ctrl:'PAIEXCVIZZOTI',prop:'Visible'},{av:'edtPaiVizzoti_Visible',ctrl:'PAIVIZZOTI',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV29GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV30GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV31GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV33IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV76ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOEXPORT'","{handler:'e16CR2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17CR2',iparms:[{av:'AV69WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV67MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e21CR1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
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
      wcpOAV67MenuOpcCod = "" ;
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
      AV67MenuOpcCod = "" ;
      AV19ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV91Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25TFPaiNom = "" ;
      AV26TFPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFPaiReligDefault = "" ;
      AV44TFPaiReligDefault_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFPaiMesHsPExt = DecimalUtil.ZERO ;
      AV46TFPaiMesHsPExt_To = DecimalUtil.ZERO ;
      AV48TFPaiDiaHsPExt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50TFPaiMaxHorNor = DecimalUtil.ZERO ;
      AV51TFPaiMaxHorNor_To = DecimalUtil.ZERO ;
      AV53TFPaiPerVacDes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV55TFPaiPerVacHas_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV63TFPaiFracVacAnt = DecimalUtil.ZERO ;
      AV64TFPaiFracVacAnt_To = DecimalUtil.ZERO ;
      AV61TFPaiVizzoti = DecimalUtil.ZERO ;
      AV62TFPaiVizzoti_To = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV27DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV76ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV31GridAppliedFilters = "" ;
      AV24TFPaiNom_SelsJson = "" ;
      AV42TFPaiReligDefault_SelsJson = "" ;
      AV47TFPaiDiaHsPExt_SelsJson = "" ;
      AV52TFPaiPerVacDes_SelsJson = "" ;
      AV54TFPaiPerVacHas_SelsJson = "" ;
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
      A312PaiNom = "" ;
      A1252PaiReligDefault = "" ;
      A1271PaiMesHsPExt = DecimalUtil.ZERO ;
      A1272PaiDiaHsPExt = "" ;
      A1405PaiMaxHorNor = DecimalUtil.ZERO ;
      A1814PaiFracVacAnt = DecimalUtil.ZERO ;
      A1737PaiVizzoti = DecimalUtil.ZERO ;
      AV32Update = "" ;
      AV38Display = "" ;
      AV65VerSVG = "" ;
      AV66ModificarSVG = "" ;
      AV95Paiswwds_4_tfpainom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV97Paiswwds_6_tfpaireligdefault_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100Paiswwds_9_tfpaidiahspext_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV104Paiswwds_13_tfpaipervacdes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV105Paiswwds_14_tfpaipervachas_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      scmdbuf = "" ;
      lV94Paiswwds_3_tfpainom = "" ;
      lV96Paiswwds_5_tfpaireligdefault = "" ;
      AV94Paiswwds_3_tfpainom = "" ;
      AV96Paiswwds_5_tfpaireligdefault = "" ;
      AV98Paiswwds_7_tfpaimeshspext = DecimalUtil.ZERO ;
      AV99Paiswwds_8_tfpaimeshspext_to = DecimalUtil.ZERO ;
      AV102Paiswwds_11_tfpaimaxhornor = DecimalUtil.ZERO ;
      AV103Paiswwds_12_tfpaimaxhornor_to = DecimalUtil.ZERO ;
      AV106Paiswwds_15_tfpaifracvacant = DecimalUtil.ZERO ;
      AV107Paiswwds_16_tfpaifracvacant_to = DecimalUtil.ZERO ;
      AV113Paiswwds_22_tfpaivizzoti = DecimalUtil.ZERO ;
      AV114Paiswwds_23_tfpaivizzoti_to = DecimalUtil.ZERO ;
      H00CR2_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CR2_A1736PaiExcVizzoti = new boolean[] {false} ;
      H00CR2_A1626PaiGuarEdadMax = new byte[1] ;
      H00CR2_A1625PaiGuarEdadMin = new byte[1] ;
      H00CR2_A1814PaiFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CR2_A1522PaiPerVacHas = new byte[1] ;
      H00CR2_A1521PaiPerVacDes = new byte[1] ;
      H00CR2_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CR2_A1402PaiFondoCese = new boolean[] {false} ;
      H00CR2_A1272PaiDiaHsPExt = new String[] {""} ;
      H00CR2_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CR2_A1252PaiReligDefault = new String[] {""} ;
      H00CR2_n1252PaiReligDefault = new boolean[] {false} ;
      H00CR2_A312PaiNom = new String[] {""} ;
      H00CR2_A46PaiCod = new short[1] ;
      H00CR3_AGRID_nRecordCount = new long[1] ;
      AV75WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV70MenuBienveImgURL = "" ;
      AV72MenuBienveTitulo = "" ;
      AV73MenuBienveTexto = "" ;
      AV90Welcomemessage_foto_GXI = "" ;
      AV87observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext9 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV17ColumnsSelectorXML = "" ;
      AV83MenuOpcTitulo = "" ;
      GXv_int10 = new short[1] ;
      AV86filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV77ManageFiltersXml = "" ;
      AV40ExcelFilename = "" ;
      AV41ErrorMessage = "" ;
      AV18UserCustomValue = "" ;
      AV20ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector12 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char7 = "" ;
      GXv_char3 = new String[1] ;
      GXt_char16 = "" ;
      GXt_char8 = "" ;
      GXv_char4 = new String[1] ;
      GXv_SdtWWPGridState17 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV71textoNoMostrara = "" ;
      GXv_char5 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisww__default(),
         new Object[] {
             new Object[] {
            H00CR2_A1737PaiVizzoti, H00CR2_A1736PaiExcVizzoti, H00CR2_A1626PaiGuarEdadMax, H00CR2_A1625PaiGuarEdadMin, H00CR2_A1814PaiFracVacAnt, H00CR2_A1522PaiPerVacHas, H00CR2_A1521PaiPerVacDes, H00CR2_A1405PaiMaxHorNor, H00CR2_A1402PaiFondoCese, H00CR2_A1272PaiDiaHsPExt,
            H00CR2_A1271PaiMesHsPExt, H00CR2_A1252PaiReligDefault, H00CR2_n1252PaiReligDefault, H00CR2_A312PaiNom, H00CR2_A46PaiCod
            }
            , new Object[] {
            H00CR3_AGRID_nRecordCount
            }
         }
      );
      AV91Pgmname = "PaisWW" ;
      /* GeneXus formulas. */
      AV91Pgmname = "PaisWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV78ManageFiltersExecutionStep ;
   private byte AV49TFPaiFondoCese_Sel ;
   private byte AV56TFPaiGuarEdadMin ;
   private byte AV57TFPaiGuarEdadMin_To ;
   private byte AV58TFPaiGuarEdadMax ;
   private byte AV59TFPaiGuarEdadMax_To ;
   private byte AV60TFPaiExcVizzoti_Sel ;
   private byte gxajaxcallmode ;
   private byte A1521PaiPerVacDes ;
   private byte A1522PaiPerVacHas ;
   private byte A1625PaiGuarEdadMin ;
   private byte A1626PaiGuarEdadMax ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV101Paiswwds_10_tfpaifondocese_sel ;
   private byte AV108Paiswwds_17_tfpaiguaredadmin ;
   private byte AV109Paiswwds_18_tfpaiguaredadmin_to ;
   private byte AV110Paiswwds_19_tfpaiguaredadmax ;
   private byte AV111Paiswwds_20_tfpaiguaredadmax_to ;
   private byte AV112Paiswwds_21_tfpaiexcvizzoti_sel ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV22TFPaiCod ;
   private short AV23TFPaiCod_To ;
   private short AV14OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A46PaiCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV92Paiswwds_1_tfpaicod ;
   private short AV93Paiswwds_2_tfpaicod_to ;
   private short GXv_int10[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_108 ;
   private int nGXsfl_108_idx=1 ;
   private int AV36CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV95Paiswwds_4_tfpainom_sels_size ;
   private int AV97Paiswwds_6_tfpaireligdefault_sels_size ;
   private int AV100Paiswwds_9_tfpaidiahspext_sels_size ;
   private int AV104Paiswwds_13_tfpaipervacdes_sels_size ;
   private int AV105Paiswwds_14_tfpaipervachas_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int edtPaiCod_Visible ;
   private int edtPaiNom_Visible ;
   private int edtPaiReligDefault_Visible ;
   private int edtPaiMesHsPExt_Visible ;
   private int edtPaiMaxHorNor_Visible ;
   private int edtPaiFracVacAnt_Visible ;
   private int edtPaiGuarEdadMin_Visible ;
   private int edtPaiGuarEdadMax_Visible ;
   private int edtPaiVizzoti_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV85filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV28PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int AV115GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV29GridCurrentPage ;
   private long AV30GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV45TFPaiMesHsPExt ;
   private java.math.BigDecimal AV46TFPaiMesHsPExt_To ;
   private java.math.BigDecimal AV50TFPaiMaxHorNor ;
   private java.math.BigDecimal AV51TFPaiMaxHorNor_To ;
   private java.math.BigDecimal AV63TFPaiFracVacAnt ;
   private java.math.BigDecimal AV64TFPaiFracVacAnt_To ;
   private java.math.BigDecimal AV61TFPaiVizzoti ;
   private java.math.BigDecimal AV62TFPaiVizzoti_To ;
   private java.math.BigDecimal A1271PaiMesHsPExt ;
   private java.math.BigDecimal A1405PaiMaxHorNor ;
   private java.math.BigDecimal A1814PaiFracVacAnt ;
   private java.math.BigDecimal A1737PaiVizzoti ;
   private java.math.BigDecimal AV98Paiswwds_7_tfpaimeshspext ;
   private java.math.BigDecimal AV99Paiswwds_8_tfpaimeshspext_to ;
   private java.math.BigDecimal AV102Paiswwds_11_tfpaimaxhornor ;
   private java.math.BigDecimal AV103Paiswwds_12_tfpaimaxhornor_to ;
   private java.math.BigDecimal AV106Paiswwds_15_tfpaifracvacant ;
   private java.math.BigDecimal AV107Paiswwds_16_tfpaifracvacant_to ;
   private java.math.BigDecimal AV113Paiswwds_22_tfpaivizzoti ;
   private java.math.BigDecimal AV114Paiswwds_23_tfpaivizzoti_to ;
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
   private String AV91Pgmname ;
   private String AV43TFPaiReligDefault ;
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
   private String edtPaiCod_Internalname ;
   private String edtPaiNom_Internalname ;
   private String A1252PaiReligDefault ;
   private String edtPaiReligDefault_Internalname ;
   private String edtPaiMesHsPExt_Internalname ;
   private String A1272PaiDiaHsPExt ;
   private String edtPaiMaxHorNor_Internalname ;
   private String edtPaiFracVacAnt_Internalname ;
   private String edtPaiGuarEdadMin_Internalname ;
   private String edtPaiGuarEdadMax_Internalname ;
   private String edtPaiVizzoti_Internalname ;
   private String AV32Update ;
   private String edtavUpdate_Internalname ;
   private String AV38Display ;
   private String edtavDisplay_Internalname ;
   private String AV65VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV66ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String scmdbuf ;
   private String lV96Paiswwds_5_tfpaireligdefault ;
   private String AV96Paiswwds_5_tfpaireligdefault ;
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
   private String AV87observerPalabra ;
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
   private String edtavUpdate_Class ;
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String GXt_char7 ;
   private String GXv_char3[] ;
   private String GXt_char16 ;
   private String GXt_char8 ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
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
   private String edtPaiCod_Jsonclick ;
   private String edtPaiNom_Jsonclick ;
   private String edtPaiReligDefault_Jsonclick ;
   private String edtPaiMesHsPExt_Jsonclick ;
   private String GXCCtl ;
   private String edtPaiMaxHorNor_Jsonclick ;
   private String edtPaiFracVacAnt_Jsonclick ;
   private String edtPaiGuarEdadMin_Jsonclick ;
   private String edtPaiGuarEdadMax_Jsonclick ;
   private String edtPaiVizzoti_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV33IsAuthorized_Update ;
   private boolean AV69WelcomeMessage_NoMostrarMas ;
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
   private boolean n1252PaiReligDefault ;
   private boolean A1402PaiFondoCese ;
   private boolean A1736PaiExcVizzoti ;
   private boolean bGXsfl_108_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV74MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean AV39TempBoolean ;
   private boolean Cond_result ;
   private boolean GXt_boolean11 ;
   private boolean GXv_boolean6[] ;
   private boolean AV75WelcomeMessage_Foto_IsBlob ;
   private String AV24TFPaiNom_SelsJson ;
   private String AV42TFPaiReligDefault_SelsJson ;
   private String AV47TFPaiDiaHsPExt_SelsJson ;
   private String AV52TFPaiPerVacDes_SelsJson ;
   private String AV54TFPaiPerVacHas_SelsJson ;
   private String AV73MenuBienveTexto ;
   private String AV17ColumnsSelectorXML ;
   private String AV77ManageFiltersXml ;
   private String AV18UserCustomValue ;
   private String AV71textoNoMostrara ;
   private String wcpOAV67MenuOpcCod ;
   private String AV67MenuOpcCod ;
   private String AV25TFPaiNom ;
   private String AV31GridAppliedFilters ;
   private String A312PaiNom ;
   private String lV94Paiswwds_3_tfpainom ;
   private String AV94Paiswwds_3_tfpainom ;
   private String AV70MenuBienveImgURL ;
   private String AV72MenuBienveTitulo ;
   private String AV90Welcomemessage_foto_GXI ;
   private String AV83MenuOpcTitulo ;
   private String AV86filtrosTexto ;
   private String AV40ExcelFilename ;
   private String AV41ErrorMessage ;
   private String AV75WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV104Paiswwds_13_tfpaipervacdes_sels ;
   private GXSimpleCollection<Byte> AV105Paiswwds_14_tfpaipervachas_sels ;
   private GXSimpleCollection<Byte> AV53TFPaiPerVacDes_Sels ;
   private GXSimpleCollection<Byte> AV55TFPaiPerVacHas_Sels ;
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
   private GXSimpleCollection<String> AV97Paiswwds_6_tfpaireligdefault_sels ;
   private GXSimpleCollection<String> AV100Paiswwds_9_tfpaidiahspext_sels ;
   private GXSimpleCollection<String> AV95Paiswwds_4_tfpainom_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbPaiDiaHsPExt ;
   private ICheckbox chkPaiFondoCese ;
   private HTMLChoice cmbPaiPerVacDes ;
   private HTMLChoice cmbPaiPerVacHas ;
   private ICheckbox chkPaiExcVizzoti ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] H00CR2_A1737PaiVizzoti ;
   private boolean[] H00CR2_A1736PaiExcVizzoti ;
   private byte[] H00CR2_A1626PaiGuarEdadMax ;
   private byte[] H00CR2_A1625PaiGuarEdadMin ;
   private java.math.BigDecimal[] H00CR2_A1814PaiFracVacAnt ;
   private byte[] H00CR2_A1522PaiPerVacHas ;
   private byte[] H00CR2_A1521PaiPerVacDes ;
   private java.math.BigDecimal[] H00CR2_A1405PaiMaxHorNor ;
   private boolean[] H00CR2_A1402PaiFondoCese ;
   private String[] H00CR2_A1272PaiDiaHsPExt ;
   private java.math.BigDecimal[] H00CR2_A1271PaiMesHsPExt ;
   private String[] H00CR2_A1252PaiReligDefault ;
   private boolean[] H00CR2_n1252PaiReligDefault ;
   private String[] H00CR2_A312PaiNom ;
   private short[] H00CR2_A46PaiCod ;
   private long[] H00CR3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV44TFPaiReligDefault_Sels ;
   private GXSimpleCollection<String> AV48TFPaiDiaHsPExt_Sels ;
   private GXSimpleCollection<String> AV26TFPaiNom_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV76ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext9[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState17[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector12[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV27DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class paisww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00CR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A312PaiNom ,
                                          GXSimpleCollection<String> AV95Paiswwds_4_tfpainom_sels ,
                                          String A1252PaiReligDefault ,
                                          GXSimpleCollection<String> AV97Paiswwds_6_tfpaireligdefault_sels ,
                                          String A1272PaiDiaHsPExt ,
                                          GXSimpleCollection<String> AV100Paiswwds_9_tfpaidiahspext_sels ,
                                          byte A1521PaiPerVacDes ,
                                          GXSimpleCollection<Byte> AV104Paiswwds_13_tfpaipervacdes_sels ,
                                          byte A1522PaiPerVacHas ,
                                          GXSimpleCollection<Byte> AV105Paiswwds_14_tfpaipervachas_sels ,
                                          short AV92Paiswwds_1_tfpaicod ,
                                          short AV93Paiswwds_2_tfpaicod_to ,
                                          int AV95Paiswwds_4_tfpainom_sels_size ,
                                          String AV94Paiswwds_3_tfpainom ,
                                          int AV97Paiswwds_6_tfpaireligdefault_sels_size ,
                                          String AV96Paiswwds_5_tfpaireligdefault ,
                                          java.math.BigDecimal AV98Paiswwds_7_tfpaimeshspext ,
                                          java.math.BigDecimal AV99Paiswwds_8_tfpaimeshspext_to ,
                                          int AV100Paiswwds_9_tfpaidiahspext_sels_size ,
                                          byte AV101Paiswwds_10_tfpaifondocese_sel ,
                                          java.math.BigDecimal AV102Paiswwds_11_tfpaimaxhornor ,
                                          java.math.BigDecimal AV103Paiswwds_12_tfpaimaxhornor_to ,
                                          int AV104Paiswwds_13_tfpaipervacdes_sels_size ,
                                          int AV105Paiswwds_14_tfpaipervachas_sels_size ,
                                          java.math.BigDecimal AV106Paiswwds_15_tfpaifracvacant ,
                                          java.math.BigDecimal AV107Paiswwds_16_tfpaifracvacant_to ,
                                          byte AV108Paiswwds_17_tfpaiguaredadmin ,
                                          byte AV109Paiswwds_18_tfpaiguaredadmin_to ,
                                          byte AV110Paiswwds_19_tfpaiguaredadmax ,
                                          byte AV111Paiswwds_20_tfpaiguaredadmax_to ,
                                          byte AV112Paiswwds_21_tfpaiexcvizzoti_sel ,
                                          java.math.BigDecimal AV113Paiswwds_22_tfpaivizzoti ,
                                          java.math.BigDecimal AV114Paiswwds_23_tfpaivizzoti_to ,
                                          short A46PaiCod ,
                                          java.math.BigDecimal A1271PaiMesHsPExt ,
                                          boolean A1402PaiFondoCese ,
                                          java.math.BigDecimal A1405PaiMaxHorNor ,
                                          java.math.BigDecimal A1814PaiFracVacAnt ,
                                          byte A1625PaiGuarEdadMin ,
                                          byte A1626PaiGuarEdadMax ,
                                          boolean A1736PaiExcVizzoti ,
                                          java.math.BigDecimal A1737PaiVizzoti ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int18 = new byte[19];
      Object[] GXv_Object19 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " PaiVizzoti, PaiExcVizzoti, PaiGuarEdadMax, PaiGuarEdadMin, PaiFracVacAnt, PaiPerVacHas, PaiPerVacDes, PaiMaxHorNor, PaiFondoCese, PaiDiaHsPExt, PaiMesHsPExt, PaiReligDefault," ;
      sSelectString += " PaiNom, PaiCod" ;
      sFromString = " FROM Pais" ;
      sOrderString = "" ;
      if ( ! (0==AV92Paiswwds_1_tfpaicod) )
      {
         addWhere(sWhereString, "(PaiCod >= ?)");
      }
      else
      {
         GXv_int18[0] = (byte)(1) ;
      }
      if ( ! (0==AV93Paiswwds_2_tfpaicod_to) )
      {
         addWhere(sWhereString, "(PaiCod <= ?)");
      }
      else
      {
         GXv_int18[1] = (byte)(1) ;
      }
      if ( ( AV95Paiswwds_4_tfpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Paiswwds_3_tfpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int18[2] = (byte)(1) ;
      }
      if ( AV95Paiswwds_4_tfpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Paiswwds_4_tfpainom_sels, "PaiNom IN (", ")")+")");
      }
      if ( ( AV97Paiswwds_6_tfpaireligdefault_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Paiswwds_5_tfpaireligdefault)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiReligDefault) like LOWER(?))");
      }
      else
      {
         GXv_int18[3] = (byte)(1) ;
      }
      if ( AV97Paiswwds_6_tfpaireligdefault_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Paiswwds_6_tfpaireligdefault_sels, "PaiReligDefault IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV98Paiswwds_7_tfpaimeshspext)==0) )
      {
         addWhere(sWhereString, "(PaiMesHsPExt >= ?)");
      }
      else
      {
         GXv_int18[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Paiswwds_8_tfpaimeshspext_to)==0) )
      {
         addWhere(sWhereString, "(PaiMesHsPExt <= ?)");
      }
      else
      {
         GXv_int18[5] = (byte)(1) ;
      }
      if ( AV100Paiswwds_9_tfpaidiahspext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Paiswwds_9_tfpaidiahspext_sels, "PaiDiaHsPExt IN (", ")")+")");
      }
      if ( AV101Paiswwds_10_tfpaifondocese_sel == 1 )
      {
         addWhere(sWhereString, "(PaiFondoCese = TRUE)");
      }
      if ( AV101Paiswwds_10_tfpaifondocese_sel == 2 )
      {
         addWhere(sWhereString, "(PaiFondoCese = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Paiswwds_11_tfpaimaxhornor)==0) )
      {
         addWhere(sWhereString, "(PaiMaxHorNor >= ?)");
      }
      else
      {
         GXv_int18[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103Paiswwds_12_tfpaimaxhornor_to)==0) )
      {
         addWhere(sWhereString, "(PaiMaxHorNor <= ?)");
      }
      else
      {
         GXv_int18[7] = (byte)(1) ;
      }
      if ( AV104Paiswwds_13_tfpaipervacdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV104Paiswwds_13_tfpaipervacdes_sels, "PaiPerVacDes IN (", ")")+")");
      }
      if ( AV105Paiswwds_14_tfpaipervachas_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Paiswwds_14_tfpaipervachas_sels, "PaiPerVacHas IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Paiswwds_15_tfpaifracvacant)==0) )
      {
         addWhere(sWhereString, "(PaiFracVacAnt >= ?)");
      }
      else
      {
         GXv_int18[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Paiswwds_16_tfpaifracvacant_to)==0) )
      {
         addWhere(sWhereString, "(PaiFracVacAnt <= ?)");
      }
      else
      {
         GXv_int18[9] = (byte)(1) ;
      }
      if ( ! (0==AV108Paiswwds_17_tfpaiguaredadmin) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMin >= ?)");
      }
      else
      {
         GXv_int18[10] = (byte)(1) ;
      }
      if ( ! (0==AV109Paiswwds_18_tfpaiguaredadmin_to) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMin <= ?)");
      }
      else
      {
         GXv_int18[11] = (byte)(1) ;
      }
      if ( ! (0==AV110Paiswwds_19_tfpaiguaredadmax) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMax >= ?)");
      }
      else
      {
         GXv_int18[12] = (byte)(1) ;
      }
      if ( ! (0==AV111Paiswwds_20_tfpaiguaredadmax_to) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMax <= ?)");
      }
      else
      {
         GXv_int18[13] = (byte)(1) ;
      }
      if ( AV112Paiswwds_21_tfpaiexcvizzoti_sel == 1 )
      {
         addWhere(sWhereString, "(PaiExcVizzoti = TRUE)");
      }
      if ( AV112Paiswwds_21_tfpaiexcvizzoti_sel == 2 )
      {
         addWhere(sWhereString, "(PaiExcVizzoti = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV113Paiswwds_22_tfpaivizzoti)==0) )
      {
         addWhere(sWhereString, "(PaiVizzoti >= ?)");
      }
      else
      {
         GXv_int18[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV114Paiswwds_23_tfpaivizzoti_to)==0) )
      {
         addWhere(sWhereString, "(PaiVizzoti <= ?)");
      }
      else
      {
         GXv_int18[15] = (byte)(1) ;
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiNom, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiNom DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiReligDefault, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiReligDefault DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiMesHsPExt, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiMesHsPExt DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiDiaHsPExt, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiDiaHsPExt DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiFondoCese, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiFondoCese DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiMaxHorNor, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiMaxHorNor DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiPerVacDes, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiPerVacDes DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiPerVacHas, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiPerVacHas DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiFracVacAnt, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiFracVacAnt DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiGuarEdadMin, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiGuarEdadMin DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiGuarEdadMax, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiGuarEdadMax DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiExcVizzoti, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiExcVizzoti DESC, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiVizzoti, PaiCod" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiVizzoti DESC, PaiCod" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY PaiCod" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object19[0] = scmdbuf ;
      GXv_Object19[1] = GXv_int18 ;
      return GXv_Object19 ;
   }

   protected Object[] conditional_H00CR3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A312PaiNom ,
                                          GXSimpleCollection<String> AV95Paiswwds_4_tfpainom_sels ,
                                          String A1252PaiReligDefault ,
                                          GXSimpleCollection<String> AV97Paiswwds_6_tfpaireligdefault_sels ,
                                          String A1272PaiDiaHsPExt ,
                                          GXSimpleCollection<String> AV100Paiswwds_9_tfpaidiahspext_sels ,
                                          byte A1521PaiPerVacDes ,
                                          GXSimpleCollection<Byte> AV104Paiswwds_13_tfpaipervacdes_sels ,
                                          byte A1522PaiPerVacHas ,
                                          GXSimpleCollection<Byte> AV105Paiswwds_14_tfpaipervachas_sels ,
                                          short AV92Paiswwds_1_tfpaicod ,
                                          short AV93Paiswwds_2_tfpaicod_to ,
                                          int AV95Paiswwds_4_tfpainom_sels_size ,
                                          String AV94Paiswwds_3_tfpainom ,
                                          int AV97Paiswwds_6_tfpaireligdefault_sels_size ,
                                          String AV96Paiswwds_5_tfpaireligdefault ,
                                          java.math.BigDecimal AV98Paiswwds_7_tfpaimeshspext ,
                                          java.math.BigDecimal AV99Paiswwds_8_tfpaimeshspext_to ,
                                          int AV100Paiswwds_9_tfpaidiahspext_sels_size ,
                                          byte AV101Paiswwds_10_tfpaifondocese_sel ,
                                          java.math.BigDecimal AV102Paiswwds_11_tfpaimaxhornor ,
                                          java.math.BigDecimal AV103Paiswwds_12_tfpaimaxhornor_to ,
                                          int AV104Paiswwds_13_tfpaipervacdes_sels_size ,
                                          int AV105Paiswwds_14_tfpaipervachas_sels_size ,
                                          java.math.BigDecimal AV106Paiswwds_15_tfpaifracvacant ,
                                          java.math.BigDecimal AV107Paiswwds_16_tfpaifracvacant_to ,
                                          byte AV108Paiswwds_17_tfpaiguaredadmin ,
                                          byte AV109Paiswwds_18_tfpaiguaredadmin_to ,
                                          byte AV110Paiswwds_19_tfpaiguaredadmax ,
                                          byte AV111Paiswwds_20_tfpaiguaredadmax_to ,
                                          byte AV112Paiswwds_21_tfpaiexcvizzoti_sel ,
                                          java.math.BigDecimal AV113Paiswwds_22_tfpaivizzoti ,
                                          java.math.BigDecimal AV114Paiswwds_23_tfpaivizzoti_to ,
                                          short A46PaiCod ,
                                          java.math.BigDecimal A1271PaiMesHsPExt ,
                                          boolean A1402PaiFondoCese ,
                                          java.math.BigDecimal A1405PaiMaxHorNor ,
                                          java.math.BigDecimal A1814PaiFracVacAnt ,
                                          byte A1625PaiGuarEdadMin ,
                                          byte A1626PaiGuarEdadMax ,
                                          boolean A1736PaiExcVizzoti ,
                                          java.math.BigDecimal A1737PaiVizzoti ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[16];
      Object[] GXv_Object22 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Pais" ;
      if ( ! (0==AV92Paiswwds_1_tfpaicod) )
      {
         addWhere(sWhereString, "(PaiCod >= ?)");
      }
      else
      {
         GXv_int21[0] = (byte)(1) ;
      }
      if ( ! (0==AV93Paiswwds_2_tfpaicod_to) )
      {
         addWhere(sWhereString, "(PaiCod <= ?)");
      }
      else
      {
         GXv_int21[1] = (byte)(1) ;
      }
      if ( ( AV95Paiswwds_4_tfpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Paiswwds_3_tfpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int21[2] = (byte)(1) ;
      }
      if ( AV95Paiswwds_4_tfpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Paiswwds_4_tfpainom_sels, "PaiNom IN (", ")")+")");
      }
      if ( ( AV97Paiswwds_6_tfpaireligdefault_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Paiswwds_5_tfpaireligdefault)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiReligDefault) like LOWER(?))");
      }
      else
      {
         GXv_int21[3] = (byte)(1) ;
      }
      if ( AV97Paiswwds_6_tfpaireligdefault_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Paiswwds_6_tfpaireligdefault_sels, "PaiReligDefault IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV98Paiswwds_7_tfpaimeshspext)==0) )
      {
         addWhere(sWhereString, "(PaiMesHsPExt >= ?)");
      }
      else
      {
         GXv_int21[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Paiswwds_8_tfpaimeshspext_to)==0) )
      {
         addWhere(sWhereString, "(PaiMesHsPExt <= ?)");
      }
      else
      {
         GXv_int21[5] = (byte)(1) ;
      }
      if ( AV100Paiswwds_9_tfpaidiahspext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Paiswwds_9_tfpaidiahspext_sels, "PaiDiaHsPExt IN (", ")")+")");
      }
      if ( AV101Paiswwds_10_tfpaifondocese_sel == 1 )
      {
         addWhere(sWhereString, "(PaiFondoCese = TRUE)");
      }
      if ( AV101Paiswwds_10_tfpaifondocese_sel == 2 )
      {
         addWhere(sWhereString, "(PaiFondoCese = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Paiswwds_11_tfpaimaxhornor)==0) )
      {
         addWhere(sWhereString, "(PaiMaxHorNor >= ?)");
      }
      else
      {
         GXv_int21[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103Paiswwds_12_tfpaimaxhornor_to)==0) )
      {
         addWhere(sWhereString, "(PaiMaxHorNor <= ?)");
      }
      else
      {
         GXv_int21[7] = (byte)(1) ;
      }
      if ( AV104Paiswwds_13_tfpaipervacdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV104Paiswwds_13_tfpaipervacdes_sels, "PaiPerVacDes IN (", ")")+")");
      }
      if ( AV105Paiswwds_14_tfpaipervachas_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Paiswwds_14_tfpaipervachas_sels, "PaiPerVacHas IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Paiswwds_15_tfpaifracvacant)==0) )
      {
         addWhere(sWhereString, "(PaiFracVacAnt >= ?)");
      }
      else
      {
         GXv_int21[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Paiswwds_16_tfpaifracvacant_to)==0) )
      {
         addWhere(sWhereString, "(PaiFracVacAnt <= ?)");
      }
      else
      {
         GXv_int21[9] = (byte)(1) ;
      }
      if ( ! (0==AV108Paiswwds_17_tfpaiguaredadmin) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMin >= ?)");
      }
      else
      {
         GXv_int21[10] = (byte)(1) ;
      }
      if ( ! (0==AV109Paiswwds_18_tfpaiguaredadmin_to) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMin <= ?)");
      }
      else
      {
         GXv_int21[11] = (byte)(1) ;
      }
      if ( ! (0==AV110Paiswwds_19_tfpaiguaredadmax) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMax >= ?)");
      }
      else
      {
         GXv_int21[12] = (byte)(1) ;
      }
      if ( ! (0==AV111Paiswwds_20_tfpaiguaredadmax_to) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMax <= ?)");
      }
      else
      {
         GXv_int21[13] = (byte)(1) ;
      }
      if ( AV112Paiswwds_21_tfpaiexcvizzoti_sel == 1 )
      {
         addWhere(sWhereString, "(PaiExcVizzoti = TRUE)");
      }
      if ( AV112Paiswwds_21_tfpaiexcvizzoti_sel == 2 )
      {
         addWhere(sWhereString, "(PaiExcVizzoti = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV113Paiswwds_22_tfpaivizzoti)==0) )
      {
         addWhere(sWhereString, "(PaiVizzoti >= ?)");
      }
      else
      {
         GXv_int21[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV114Paiswwds_23_tfpaivizzoti_to)==0) )
      {
         addWhere(sWhereString, "(PaiVizzoti <= ?)");
      }
      else
      {
         GXv_int21[15] = (byte)(1) ;
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
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
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
                  return conditional_H00CR2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).byteValue() , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).byteValue() , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , ((Boolean) dynConstraints[35]).booleanValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Boolean) dynConstraints[40]).booleanValue() , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).shortValue() , ((Boolean) dynConstraints[43]).booleanValue() );
            case 1 :
                  return conditional_H00CR3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).byteValue() , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).byteValue() , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , ((Boolean) dynConstraints[35]).booleanValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Boolean) dynConstraints[40]).booleanValue() , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).shortValue() , ((Boolean) dynConstraints[43]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00CR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00CR3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,4);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,1);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(13);
               ((short[]) buf[14])[0] = rslt.getShort(14);
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
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[22], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 4);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[30]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[31]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[32]).byteValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 4);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 4);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[35]).intValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[36]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[37]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 4);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[28]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 4);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 4);
               }
               return;
      }
   }

}

