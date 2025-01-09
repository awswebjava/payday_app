package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresabase_calculoww_impl extends GXDataArea
{
   public empresabase_calculoww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresabase_calculoww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresabase_calculoww_impl.class ));
   }

   public empresabase_calculoww_impl( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbEmpBaseTipo = new HTMLChoice();
      cmbEmpBaseClaseLeg = new HTMLChoice();
      chkavDefault = UIFactory.getCheckbox(this);
      cmbEmpLicDMes = new HTMLChoice();
      chkEmpLicAdju = UIFactory.getCheckbox(this);
      chkEmpLicAdjuObl = UIFactory.getCheckbox(this);
      chkEmpLicNecAut = UIFactory.getCheckbox(this);
      chkEmpLicIngMot = UIFactory.getCheckbox(this);
      chkEmpLicMotObl = UIFactory.getCheckbox(this);
      cmbEmpBasePromTCnt = new HTMLChoice();
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
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV8EmpBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "EmpBaseClaseLeg"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8EmpBaseClaseLeg", GXutil.str( AV8EmpBaseClaseLeg, 1, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpBaseClaseLeg), "9")));
               AV9EmpBaseTipo = httpContext.GetPar( "EmpBaseTipo") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9EmpBaseTipo", AV9EmpBaseTipo);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9EmpBaseTipo, ""))));
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
      nRC_GXsfl_108 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_108"))) ;
      nGXsfl_108_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_108_idx"))) ;
      sGXsfl_108_idx = httpContext.GetPar( "sGXsfl_108_idx") ;
      edtavEmpbasec1txt_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec1txt_Internalname, "Title", edtavEmpbasec1txt_Title, !bGXsfl_108_Refreshing);
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
      AV101ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV22ColumnsSelector);
      AV114Pgmname = httpContext.GetPar( "Pgmname") ;
      AV90MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV13GridState);
      AV9EmpBaseTipo = httpContext.GetPar( "EmpBaseTipo") ;
      AV8EmpBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "EmpBaseClaseLeg"))) ;
      AV41TFEmpBasePlus = CommonUtil.decimalVal( httpContext.GetPar( "TFEmpBasePlus"), ".") ;
      AV42TFEmpBasePlus_To = CommonUtil.decimalVal( httpContext.GetPar( "TFEmpBasePlus_To"), ".") ;
      AV43TFEmpLicDMin = (byte)(GXutil.lval( httpContext.GetPar( "TFEmpLicDMin"))) ;
      AV44TFEmpLicDMin_To = (byte)(GXutil.lval( httpContext.GetPar( "TFEmpLicDMin_To"))) ;
      AV45TFEmpLicDLim = (short)(GXutil.lval( httpContext.GetPar( "TFEmpLicDLim"))) ;
      AV46TFEmpLicDLim_To = (short)(GXutil.lval( httpContext.GetPar( "TFEmpLicDLim_To"))) ;
      AV47TFEmpLicDSeman = (byte)(GXutil.lval( httpContext.GetPar( "TFEmpLicDSeman"))) ;
      AV48TFEmpLicDSeman_To = (byte)(GXutil.lval( httpContext.GetPar( "TFEmpLicDSeman_To"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV50TFEmpLicDMes_Sels);
      AV51TFEmpLicDSemes = (short)(GXutil.lval( httpContext.GetPar( "TFEmpLicDSemes"))) ;
      AV52TFEmpLicDSemes_To = (short)(GXutil.lval( httpContext.GetPar( "TFEmpLicDSemes_To"))) ;
      AV53TFEmpLicDAnual = (short)(GXutil.lval( httpContext.GetPar( "TFEmpLicDAnual"))) ;
      AV54TFEmpLicDAnual_To = (short)(GXutil.lval( httpContext.GetPar( "TFEmpLicDAnual_To"))) ;
      AV55TFEmpLicAdju_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFEmpLicAdju_Sel"))) ;
      AV56TFEmpLicAdjuObl_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFEmpLicAdjuObl_Sel"))) ;
      AV57TFEmpLicNecAut_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFEmpLicNecAut_Sel"))) ;
      AV58TFEmpLicIngMot_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFEmpLicIngMot_Sel"))) ;
      AV59TFEmpLicMotObl_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFEmpLicMotObl_Sel"))) ;
      AV62TFEmpBasePromCnt1 = (short)(GXutil.lval( httpContext.GetPar( "TFEmpBasePromCnt1"))) ;
      AV63TFEmpBasePromCnt1_To = (short)(GXutil.lval( httpContext.GetPar( "TFEmpBasePromCnt1_To"))) ;
      AV64TFEmpBasePromCnt2 = (short)(GXutil.lval( httpContext.GetPar( "TFEmpBasePromCnt2"))) ;
      AV65TFEmpBasePromCnt2_To = (short)(GXutil.lval( httpContext.GetPar( "TFEmpBasePromCnt2_To"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV67TFEmpBasePromTCnt_Sels);
      AV15OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV16OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV79CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      edtavEmpbasec1txt_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec1txt_Internalname, "Title", edtavEmpbasec1txt_Title, !bGXsfl_108_Refreshing);
      AV74IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV86PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV80EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV115Empresabase_calculowwds_1_empbaseclaseleg = (byte)(GXutil.lval( httpContext.GetPar( "Empresabase_calculowwds_1_empbaseclaseleg"))) ;
      AV116Empresabase_calculowwds_2_empbasetipo = httpContext.GetPar( "Empresabase_calculowwds_2_empbasetipo") ;
      AV92WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV101ManageFiltersExecutionStep, AV22ColumnsSelector, AV114Pgmname, AV90MenuOpcCod, AV13GridState, AV9EmpBaseTipo, AV8EmpBaseClaseLeg, AV41TFEmpBasePlus, AV42TFEmpBasePlus_To, AV43TFEmpLicDMin, AV44TFEmpLicDMin_To, AV45TFEmpLicDLim, AV46TFEmpLicDLim_To, AV47TFEmpLicDSeman, AV48TFEmpLicDSeman_To, AV50TFEmpLicDMes_Sels, AV51TFEmpLicDSemes, AV52TFEmpLicDSemes_To, AV53TFEmpLicDAnual, AV54TFEmpLicDAnual_To, AV55TFEmpLicAdju_Sel, AV56TFEmpLicAdjuObl_Sel, AV57TFEmpLicNecAut_Sel, AV58TFEmpLicIngMot_Sel, AV59TFEmpLicMotObl_Sel, AV62TFEmpBasePromCnt1, AV63TFEmpBasePromCnt1_To, AV64TFEmpBasePromCnt2, AV65TFEmpBasePromCnt2_To, AV67TFEmpBasePromTCnt_Sels, AV15OrderedBy, AV16OrderedDsc, AV79CliCod, AV74IsAuthorized_Update, AV86PaiCod, AV80EmpCod, AV115Empresabase_calculowwds_1_empbaseclaseleg, AV116Empresabase_calculowwds_2_empbasetipo, AV92WelcomeMessage_NoMostrarMas) ;
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
      paKC2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startKC2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empresabase_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV90MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV9EmpBaseTipo))}, new String[] {"MenuOpcCod","EmpBaseClaseLeg","EmpBaseTipo"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV114Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV90MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9EmpBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV79CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV74IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV86PaiCod), "ZZZ9")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV68DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV68DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV22ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV22ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV99ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV99ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV70GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV71GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV72GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV101ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV114Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV114Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV90MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV90MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV13GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV13GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASETIPO", GXutil.rtrim( AV9EmpBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9EmpBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECLASELEG", GXutil.ltrim( localUtil.ntoc( AV8EmpBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPBASEPLUS", GXutil.ltrim( localUtil.ntoc( AV41TFEmpBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPBASEPLUS_TO", GXutil.ltrim( localUtil.ntoc( AV42TFEmpBasePlus_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDMIN", GXutil.ltrim( localUtil.ntoc( AV43TFEmpLicDMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDMIN_TO", GXutil.ltrim( localUtil.ntoc( AV44TFEmpLicDMin_To, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDLIM", GXutil.ltrim( localUtil.ntoc( AV45TFEmpLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDLIM_TO", GXutil.ltrim( localUtil.ntoc( AV46TFEmpLicDLim_To, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDSEMAN", GXutil.ltrim( localUtil.ntoc( AV47TFEmpLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDSEMAN_TO", GXutil.ltrim( localUtil.ntoc( AV48TFEmpLicDSeman_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFEMPLICDMES_SELS", AV50TFEmpLicDMes_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFEMPLICDMES_SELS", AV50TFEmpLicDMes_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDSEMES", GXutil.ltrim( localUtil.ntoc( AV51TFEmpLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDSEMES_TO", GXutil.ltrim( localUtil.ntoc( AV52TFEmpLicDSemes_To, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDANUAL", GXutil.ltrim( localUtil.ntoc( AV53TFEmpLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDANUAL_TO", GXutil.ltrim( localUtil.ntoc( AV54TFEmpLicDAnual_To, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICADJU_SEL", GXutil.ltrim( localUtil.ntoc( AV55TFEmpLicAdju_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICADJUOBL_SEL", GXutil.ltrim( localUtil.ntoc( AV56TFEmpLicAdjuObl_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICNECAUT_SEL", GXutil.ltrim( localUtil.ntoc( AV57TFEmpLicNecAut_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICINGMOT_SEL", GXutil.ltrim( localUtil.ntoc( AV58TFEmpLicIngMot_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICMOTOBL_SEL", GXutil.ltrim( localUtil.ntoc( AV59TFEmpLicMotObl_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPBASEPROMCNT1", GXutil.ltrim( localUtil.ntoc( AV62TFEmpBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPBASEPROMCNT1_TO", GXutil.ltrim( localUtil.ntoc( AV63TFEmpBasePromCnt1_To, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPBASEPROMCNT2", GXutil.ltrim( localUtil.ntoc( AV64TFEmpBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPBASEPROMCNT2_TO", GXutil.ltrim( localUtil.ntoc( AV65TFEmpBasePromCnt2_To, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFEMPBASEPROMTCNT_SELS", AV67TFEmpBasePromTCnt_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFEMPBASEPROMTCNT_SELS", AV67TFEmpBasePromTCnt_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV15OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV16OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV79CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV79CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV74IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV74IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV86PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV86PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPLICDMES_SELSJSON", AV49TFEmpLicDMes_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPBASEPROMTCNT_SELSJSON", AV66TFEmpBasePromTCnt_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV80EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPRESABASE_CALCULOWWDS_1_EMPBASECLASELEG", GXutil.ltrim( localUtil.ntoc( AV115Empresabase_calculowwds_1_empbaseclaseleg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPRESABASE_CALCULOWWDS_2_EMPBASETIPO", GXutil.rtrim( AV116Empresabase_calculowwds_2_empbasetipo));
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
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASEC1TXT_Title", GXutil.rtrim( edtavEmpbasec1txt_Title));
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
         weKC2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtKC2( ) ;
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
      return formatLink("web.empresabase_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV90MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV9EmpBaseTipo))}, new String[] {"MenuOpcCod","EmpBaseClaseLeg","EmpBaseTipo"})  ;
   }

   public String getPgmname( )
   {
      return "Empresabase_calculoWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Base de cálculo", "") ;
   }

   public void wbKC0( )
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
         wb_table1_9_KC2( true) ;
      }
      else
      {
         wb_table1_9_KC2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_KC2e( boolean wbgen )
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
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV68DDO_TitleSettingsIcons);
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

   public void startKC2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Base de cálculo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupKC0( ) ;
   }

   public void wsKC2( )
   {
      startKC2( ) ;
      evtKC2( ) ;
   }

   public void evtKC2( )
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
                           e11KC2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12KC2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13KC2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14KC2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15KC2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e16KC2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17KC2 ();
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
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1430EmpBaseCod1 = httpContext.cgiGet( edtEmpBaseCod1_Internalname) ;
                           A1431EmpBaseCod2 = httpContext.cgiGet( edtEmpBaseCod2_Internalname) ;
                           cmbEmpBaseTipo.setName( cmbEmpBaseTipo.getInternalname() );
                           cmbEmpBaseTipo.setValue( httpContext.cgiGet( cmbEmpBaseTipo.getInternalname()) );
                           A1429EmpBaseTipo = httpContext.cgiGet( cmbEmpBaseTipo.getInternalname()) ;
                           cmbEmpBaseClaseLeg.setName( cmbEmpBaseClaseLeg.getInternalname() );
                           cmbEmpBaseClaseLeg.setValue( httpContext.cgiGet( cmbEmpBaseClaseLeg.getInternalname()) );
                           A1427EmpBaseClaseLeg = (byte)(GXutil.lval( httpContext.cgiGet( cmbEmpBaseClaseLeg.getInternalname()))) ;
                           AV81EmpBaseC1Txt = httpContext.cgiGet( edtavEmpbasec1txt_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEmpbasec1txt_Internalname, AV81EmpBaseC1Txt);
                           AV82EmpBaseC2Txt = httpContext.cgiGet( edtavEmpbasec2txt_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEmpbasec2txt_Internalname, AV82EmpBaseC2Txt);
                           AV85Default = GXutil.strtobool( httpContext.cgiGet( chkavDefault.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavDefault.getInternalname(), AV85Default);
                           A1432EmpBasePlus = localUtil.ctond( httpContext.cgiGet( edtEmpBasePlus_Internalname)) ;
                           A1517EmpLicDMin = (byte)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1517EmpLicDMin = false ;
                           A1502EmpLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1502EmpLicDLim = false ;
                           A1503EmpLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1503EmpLicDSeman = false ;
                           cmbEmpLicDMes.setName( cmbEmpLicDMes.getInternalname() );
                           cmbEmpLicDMes.setValue( httpContext.cgiGet( cmbEmpLicDMes.getInternalname()) );
                           A1504EmpLicDMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbEmpLicDMes.getInternalname()))) ;
                           n1504EmpLicDMes = false ;
                           A1505EmpLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1505EmpLicDSemes = false ;
                           A1506EmpLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1506EmpLicDAnual = false ;
                           A1507EmpLicAdju = GXutil.strtobool( httpContext.cgiGet( chkEmpLicAdju.getInternalname())) ;
                           n1507EmpLicAdju = false ;
                           A1508EmpLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( chkEmpLicAdjuObl.getInternalname())) ;
                           n1508EmpLicAdjuObl = false ;
                           A1509EmpLicNecAut = GXutil.strtobool( httpContext.cgiGet( chkEmpLicNecAut.getInternalname())) ;
                           n1509EmpLicNecAut = false ;
                           A1510EmpLicIngMot = GXutil.strtobool( httpContext.cgiGet( chkEmpLicIngMot.getInternalname())) ;
                           n1510EmpLicIngMot = false ;
                           A1511EmpLicMotObl = GXutil.strtobool( httpContext.cgiGet( chkEmpLicMotObl.getInternalname())) ;
                           n1511EmpLicMotObl = false ;
                           A1518EmpBaseOrd = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpBaseOrd_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1518EmpBaseOrd = false ;
                           A1437EmpBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1438EmpBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbEmpBasePromTCnt.setName( cmbEmpBasePromTCnt.getInternalname() );
                           cmbEmpBasePromTCnt.setValue( httpContext.cgiGet( cmbEmpBasePromTCnt.getInternalname()) );
                           A1439EmpBasePromTCnt = httpContext.cgiGet( cmbEmpBasePromTCnt.getInternalname()) ;
                           AV87VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV87VerSVG);
                           AV88ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV88ModificarSVG);
                           AV73Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV73Update);
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
                                 e18KC2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e19KC2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20KC2 ();
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

   public void weKC2( )
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

   public void paKC2( )
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
                                 byte AV101ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelector ,
                                 String AV114Pgmname ,
                                 String AV90MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV13GridState ,
                                 String AV9EmpBaseTipo ,
                                 byte AV8EmpBaseClaseLeg ,
                                 java.math.BigDecimal AV41TFEmpBasePlus ,
                                 java.math.BigDecimal AV42TFEmpBasePlus_To ,
                                 byte AV43TFEmpLicDMin ,
                                 byte AV44TFEmpLicDMin_To ,
                                 short AV45TFEmpLicDLim ,
                                 short AV46TFEmpLicDLim_To ,
                                 byte AV47TFEmpLicDSeman ,
                                 byte AV48TFEmpLicDSeman_To ,
                                 GXSimpleCollection<Byte> AV50TFEmpLicDMes_Sels ,
                                 short AV51TFEmpLicDSemes ,
                                 short AV52TFEmpLicDSemes_To ,
                                 short AV53TFEmpLicDAnual ,
                                 short AV54TFEmpLicDAnual_To ,
                                 byte AV55TFEmpLicAdju_Sel ,
                                 byte AV56TFEmpLicAdjuObl_Sel ,
                                 byte AV57TFEmpLicNecAut_Sel ,
                                 byte AV58TFEmpLicIngMot_Sel ,
                                 byte AV59TFEmpLicMotObl_Sel ,
                                 short AV62TFEmpBasePromCnt1 ,
                                 short AV63TFEmpBasePromCnt1_To ,
                                 short AV64TFEmpBasePromCnt2 ,
                                 short AV65TFEmpBasePromCnt2_To ,
                                 GXSimpleCollection<String> AV67TFEmpBasePromTCnt_Sels ,
                                 short AV15OrderedBy ,
                                 boolean AV16OrderedDsc ,
                                 int AV79CliCod ,
                                 boolean AV74IsAuthorized_Update ,
                                 short AV86PaiCod ,
                                 short AV80EmpCod ,
                                 byte AV115Empresabase_calculowwds_1_empbaseclaseleg ,
                                 String AV116Empresabase_calculowwds_2_empbasetipo ,
                                 boolean AV92WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e19KC2 ();
      GRID_nCurrentRecord = 0 ;
      rfKC2( ) ;
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
      rfKC2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV114Pgmname = "Empresabase_calculoWW" ;
      Gx_err = (short)(0) ;
      edtavEmpbasec1txt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec1txt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpbasec1txt_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavEmpbasec2txt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec2txt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpbasec2txt_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      chkavDefault.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavDefault.getInternalname(), "Enabled", GXutil.ltrimstr( chkavDefault.getEnabled(), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
   }

   public void rfKC2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(108) ;
      /* Execute user event: Refresh */
      e19KC2 ();
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
                                              Byte.valueOf(A1504EmpLicDMes) ,
                                              AV125Empresabase_calculowwds_11_tfemplicdmes_sels ,
                                              A1439EmpBasePromTCnt ,
                                              AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels ,
                                              AV117Empresabase_calculowwds_3_tfempbaseplus ,
                                              AV118Empresabase_calculowwds_4_tfempbaseplus_to ,
                                              Byte.valueOf(AV119Empresabase_calculowwds_5_tfemplicdmin) ,
                                              Byte.valueOf(AV120Empresabase_calculowwds_6_tfemplicdmin_to) ,
                                              Short.valueOf(AV121Empresabase_calculowwds_7_tfemplicdlim) ,
                                              Short.valueOf(AV122Empresabase_calculowwds_8_tfemplicdlim_to) ,
                                              Byte.valueOf(AV123Empresabase_calculowwds_9_tfemplicdseman) ,
                                              Byte.valueOf(AV124Empresabase_calculowwds_10_tfemplicdseman_to) ,
                                              Integer.valueOf(AV125Empresabase_calculowwds_11_tfemplicdmes_sels.size()) ,
                                              Short.valueOf(AV126Empresabase_calculowwds_12_tfemplicdsemes) ,
                                              Short.valueOf(AV127Empresabase_calculowwds_13_tfemplicdsemes_to) ,
                                              Short.valueOf(AV128Empresabase_calculowwds_14_tfemplicdanual) ,
                                              Short.valueOf(AV129Empresabase_calculowwds_15_tfemplicdanual_to) ,
                                              Byte.valueOf(AV130Empresabase_calculowwds_16_tfemplicadju_sel) ,
                                              Byte.valueOf(AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel) ,
                                              Byte.valueOf(AV132Empresabase_calculowwds_18_tfemplicnecaut_sel) ,
                                              Byte.valueOf(AV133Empresabase_calculowwds_19_tfemplicingmot_sel) ,
                                              Byte.valueOf(AV134Empresabase_calculowwds_20_tfemplicmotobl_sel) ,
                                              Short.valueOf(AV135Empresabase_calculowwds_21_tfempbasepromcnt1) ,
                                              Short.valueOf(AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to) ,
                                              Short.valueOf(AV137Empresabase_calculowwds_23_tfempbasepromcnt2) ,
                                              Short.valueOf(AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to) ,
                                              Integer.valueOf(AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels.size()) ,
                                              A1432EmpBasePlus ,
                                              Byte.valueOf(A1517EmpLicDMin) ,
                                              Short.valueOf(A1502EmpLicDLim) ,
                                              Byte.valueOf(A1503EmpLicDSeman) ,
                                              Short.valueOf(A1505EmpLicDSemes) ,
                                              Short.valueOf(A1506EmpLicDAnual) ,
                                              Boolean.valueOf(A1507EmpLicAdju) ,
                                              Boolean.valueOf(A1508EmpLicAdjuObl) ,
                                              Boolean.valueOf(A1509EmpLicNecAut) ,
                                              Boolean.valueOf(A1510EmpLicIngMot) ,
                                              Boolean.valueOf(A1511EmpLicMotObl) ,
                                              Short.valueOf(A1437EmpBasePromCnt1) ,
                                              Short.valueOf(A1438EmpBasePromCnt2) ,
                                              Short.valueOf(AV15OrderedBy) ,
                                              Boolean.valueOf(AV16OrderedDsc) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Short.valueOf(AV80EmpCod) ,
                                              Integer.valueOf(AV79CliCod) ,
                                              Byte.valueOf(AV115Empresabase_calculowwds_1_empbaseclaseleg) ,
                                              AV116Empresabase_calculowwds_2_empbasetipo ,
                                              Integer.valueOf(A3CliCod) ,
                                              Byte.valueOf(A1427EmpBaseClaseLeg) ,
                                              A1429EmpBaseTipo } ,
                                              new int[]{
                                              TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.SHORT,
                                              TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                              TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                              TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.STRING
                                              }
         });
         /* Using cursor H00KC2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV79CliCod), Short.valueOf(AV80EmpCod), Byte.valueOf(AV115Empresabase_calculowwds_1_empbaseclaseleg), AV116Empresabase_calculowwds_2_empbasetipo, Short.valueOf(AV80EmpCod), AV117Empresabase_calculowwds_3_tfempbaseplus, AV118Empresabase_calculowwds_4_tfempbaseplus_to, Byte.valueOf(AV119Empresabase_calculowwds_5_tfemplicdmin), Byte.valueOf(AV120Empresabase_calculowwds_6_tfemplicdmin_to), Short.valueOf(AV121Empresabase_calculowwds_7_tfemplicdlim), Short.valueOf(AV122Empresabase_calculowwds_8_tfemplicdlim_to), Byte.valueOf(AV123Empresabase_calculowwds_9_tfemplicdseman), Byte.valueOf(AV124Empresabase_calculowwds_10_tfemplicdseman_to), Short.valueOf(AV126Empresabase_calculowwds_12_tfemplicdsemes), Short.valueOf(AV127Empresabase_calculowwds_13_tfemplicdsemes_to), Short.valueOf(AV128Empresabase_calculowwds_14_tfemplicdanual), Short.valueOf(AV129Empresabase_calculowwds_15_tfemplicdanual_to), Short.valueOf(AV135Empresabase_calculowwds_21_tfempbasepromcnt1), Short.valueOf(AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to), Short.valueOf(AV137Empresabase_calculowwds_23_tfempbasepromcnt2), Short.valueOf(AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_108_idx = 1 ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1439EmpBasePromTCnt = H00KC2_A1439EmpBasePromTCnt[0] ;
            A1438EmpBasePromCnt2 = H00KC2_A1438EmpBasePromCnt2[0] ;
            A1437EmpBasePromCnt1 = H00KC2_A1437EmpBasePromCnt1[0] ;
            A1518EmpBaseOrd = H00KC2_A1518EmpBaseOrd[0] ;
            n1518EmpBaseOrd = H00KC2_n1518EmpBaseOrd[0] ;
            A1511EmpLicMotObl = H00KC2_A1511EmpLicMotObl[0] ;
            n1511EmpLicMotObl = H00KC2_n1511EmpLicMotObl[0] ;
            A1510EmpLicIngMot = H00KC2_A1510EmpLicIngMot[0] ;
            n1510EmpLicIngMot = H00KC2_n1510EmpLicIngMot[0] ;
            A1509EmpLicNecAut = H00KC2_A1509EmpLicNecAut[0] ;
            n1509EmpLicNecAut = H00KC2_n1509EmpLicNecAut[0] ;
            A1508EmpLicAdjuObl = H00KC2_A1508EmpLicAdjuObl[0] ;
            n1508EmpLicAdjuObl = H00KC2_n1508EmpLicAdjuObl[0] ;
            A1507EmpLicAdju = H00KC2_A1507EmpLicAdju[0] ;
            n1507EmpLicAdju = H00KC2_n1507EmpLicAdju[0] ;
            A1506EmpLicDAnual = H00KC2_A1506EmpLicDAnual[0] ;
            n1506EmpLicDAnual = H00KC2_n1506EmpLicDAnual[0] ;
            A1505EmpLicDSemes = H00KC2_A1505EmpLicDSemes[0] ;
            n1505EmpLicDSemes = H00KC2_n1505EmpLicDSemes[0] ;
            A1504EmpLicDMes = H00KC2_A1504EmpLicDMes[0] ;
            n1504EmpLicDMes = H00KC2_n1504EmpLicDMes[0] ;
            A1503EmpLicDSeman = H00KC2_A1503EmpLicDSeman[0] ;
            n1503EmpLicDSeman = H00KC2_n1503EmpLicDSeman[0] ;
            A1502EmpLicDLim = H00KC2_A1502EmpLicDLim[0] ;
            n1502EmpLicDLim = H00KC2_n1502EmpLicDLim[0] ;
            A1517EmpLicDMin = H00KC2_A1517EmpLicDMin[0] ;
            n1517EmpLicDMin = H00KC2_n1517EmpLicDMin[0] ;
            A1432EmpBasePlus = H00KC2_A1432EmpBasePlus[0] ;
            A1427EmpBaseClaseLeg = H00KC2_A1427EmpBaseClaseLeg[0] ;
            A1429EmpBaseTipo = H00KC2_A1429EmpBaseTipo[0] ;
            A1431EmpBaseCod2 = H00KC2_A1431EmpBaseCod2[0] ;
            A1430EmpBaseCod1 = H00KC2_A1430EmpBaseCod1[0] ;
            A1EmpCod = H00KC2_A1EmpCod[0] ;
            A3CliCod = H00KC2_A3CliCod[0] ;
            e20KC2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(108) ;
         wbKC0( ) ;
      }
      bGXsfl_108_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesKC2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV114Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV114Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV90MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV90MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASETIPO", GXutil.rtrim( AV9EmpBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9EmpBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECLASELEG", GXutil.ltrim( localUtil.ntoc( AV8EmpBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV79CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV79CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV74IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV74IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV86PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV86PaiCod), "ZZZ9")));
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
      AV115Empresabase_calculowwds_1_empbaseclaseleg = AV8EmpBaseClaseLeg ;
      AV116Empresabase_calculowwds_2_empbasetipo = AV9EmpBaseTipo ;
      AV117Empresabase_calculowwds_3_tfempbaseplus = AV41TFEmpBasePlus ;
      AV118Empresabase_calculowwds_4_tfempbaseplus_to = AV42TFEmpBasePlus_To ;
      AV119Empresabase_calculowwds_5_tfemplicdmin = AV43TFEmpLicDMin ;
      AV120Empresabase_calculowwds_6_tfemplicdmin_to = AV44TFEmpLicDMin_To ;
      AV121Empresabase_calculowwds_7_tfemplicdlim = AV45TFEmpLicDLim ;
      AV122Empresabase_calculowwds_8_tfemplicdlim_to = AV46TFEmpLicDLim_To ;
      AV123Empresabase_calculowwds_9_tfemplicdseman = AV47TFEmpLicDSeman ;
      AV124Empresabase_calculowwds_10_tfemplicdseman_to = AV48TFEmpLicDSeman_To ;
      AV125Empresabase_calculowwds_11_tfemplicdmes_sels = AV50TFEmpLicDMes_Sels ;
      AV126Empresabase_calculowwds_12_tfemplicdsemes = AV51TFEmpLicDSemes ;
      AV127Empresabase_calculowwds_13_tfemplicdsemes_to = AV52TFEmpLicDSemes_To ;
      AV128Empresabase_calculowwds_14_tfemplicdanual = AV53TFEmpLicDAnual ;
      AV129Empresabase_calculowwds_15_tfemplicdanual_to = AV54TFEmpLicDAnual_To ;
      AV130Empresabase_calculowwds_16_tfemplicadju_sel = AV55TFEmpLicAdju_Sel ;
      AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel = AV56TFEmpLicAdjuObl_Sel ;
      AV132Empresabase_calculowwds_18_tfemplicnecaut_sel = AV57TFEmpLicNecAut_Sel ;
      AV133Empresabase_calculowwds_19_tfemplicingmot_sel = AV58TFEmpLicIngMot_Sel ;
      AV134Empresabase_calculowwds_20_tfemplicmotobl_sel = AV59TFEmpLicMotObl_Sel ;
      AV135Empresabase_calculowwds_21_tfempbasepromcnt1 = AV62TFEmpBasePromCnt1 ;
      AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to = AV63TFEmpBasePromCnt1_To ;
      AV137Empresabase_calculowwds_23_tfempbasepromcnt2 = AV64TFEmpBasePromCnt2 ;
      AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to = AV65TFEmpBasePromCnt2_To ;
      AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels = AV67TFEmpBasePromTCnt_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Byte.valueOf(A1504EmpLicDMes) ,
                                           AV125Empresabase_calculowwds_11_tfemplicdmes_sels ,
                                           A1439EmpBasePromTCnt ,
                                           AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels ,
                                           AV117Empresabase_calculowwds_3_tfempbaseplus ,
                                           AV118Empresabase_calculowwds_4_tfempbaseplus_to ,
                                           Byte.valueOf(AV119Empresabase_calculowwds_5_tfemplicdmin) ,
                                           Byte.valueOf(AV120Empresabase_calculowwds_6_tfemplicdmin_to) ,
                                           Short.valueOf(AV121Empresabase_calculowwds_7_tfemplicdlim) ,
                                           Short.valueOf(AV122Empresabase_calculowwds_8_tfemplicdlim_to) ,
                                           Byte.valueOf(AV123Empresabase_calculowwds_9_tfemplicdseman) ,
                                           Byte.valueOf(AV124Empresabase_calculowwds_10_tfemplicdseman_to) ,
                                           Integer.valueOf(AV125Empresabase_calculowwds_11_tfemplicdmes_sels.size()) ,
                                           Short.valueOf(AV126Empresabase_calculowwds_12_tfemplicdsemes) ,
                                           Short.valueOf(AV127Empresabase_calculowwds_13_tfemplicdsemes_to) ,
                                           Short.valueOf(AV128Empresabase_calculowwds_14_tfemplicdanual) ,
                                           Short.valueOf(AV129Empresabase_calculowwds_15_tfemplicdanual_to) ,
                                           Byte.valueOf(AV130Empresabase_calculowwds_16_tfemplicadju_sel) ,
                                           Byte.valueOf(AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel) ,
                                           Byte.valueOf(AV132Empresabase_calculowwds_18_tfemplicnecaut_sel) ,
                                           Byte.valueOf(AV133Empresabase_calculowwds_19_tfemplicingmot_sel) ,
                                           Byte.valueOf(AV134Empresabase_calculowwds_20_tfemplicmotobl_sel) ,
                                           Short.valueOf(AV135Empresabase_calculowwds_21_tfempbasepromcnt1) ,
                                           Short.valueOf(AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to) ,
                                           Short.valueOf(AV137Empresabase_calculowwds_23_tfempbasepromcnt2) ,
                                           Short.valueOf(AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to) ,
                                           Integer.valueOf(AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels.size()) ,
                                           A1432EmpBasePlus ,
                                           Byte.valueOf(A1517EmpLicDMin) ,
                                           Short.valueOf(A1502EmpLicDLim) ,
                                           Byte.valueOf(A1503EmpLicDSeman) ,
                                           Short.valueOf(A1505EmpLicDSemes) ,
                                           Short.valueOf(A1506EmpLicDAnual) ,
                                           Boolean.valueOf(A1507EmpLicAdju) ,
                                           Boolean.valueOf(A1508EmpLicAdjuObl) ,
                                           Boolean.valueOf(A1509EmpLicNecAut) ,
                                           Boolean.valueOf(A1510EmpLicIngMot) ,
                                           Boolean.valueOf(A1511EmpLicMotObl) ,
                                           Short.valueOf(A1437EmpBasePromCnt1) ,
                                           Short.valueOf(A1438EmpBasePromCnt2) ,
                                           Short.valueOf(AV15OrderedBy) ,
                                           Boolean.valueOf(AV16OrderedDsc) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV80EmpCod) ,
                                           Integer.valueOf(AV79CliCod) ,
                                           Byte.valueOf(AV115Empresabase_calculowwds_1_empbaseclaseleg) ,
                                           AV116Empresabase_calculowwds_2_empbasetipo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Byte.valueOf(A1427EmpBaseClaseLeg) ,
                                           A1429EmpBaseTipo } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.STRING
                                           }
      });
      /* Using cursor H00KC3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV79CliCod), Short.valueOf(AV80EmpCod), Byte.valueOf(AV115Empresabase_calculowwds_1_empbaseclaseleg), AV116Empresabase_calculowwds_2_empbasetipo, Short.valueOf(AV80EmpCod), Short.valueOf(AV80EmpCod), Short.valueOf(AV80EmpCod), AV117Empresabase_calculowwds_3_tfempbaseplus, AV118Empresabase_calculowwds_4_tfempbaseplus_to, Byte.valueOf(AV119Empresabase_calculowwds_5_tfemplicdmin), Byte.valueOf(AV120Empresabase_calculowwds_6_tfemplicdmin_to), Short.valueOf(AV121Empresabase_calculowwds_7_tfemplicdlim), Short.valueOf(AV122Empresabase_calculowwds_8_tfemplicdlim_to), Byte.valueOf(AV123Empresabase_calculowwds_9_tfemplicdseman), Byte.valueOf(AV124Empresabase_calculowwds_10_tfemplicdseman_to), Short.valueOf(AV126Empresabase_calculowwds_12_tfemplicdsemes), Short.valueOf(AV127Empresabase_calculowwds_13_tfemplicdsemes_to), Short.valueOf(AV128Empresabase_calculowwds_14_tfemplicdanual), Short.valueOf(AV129Empresabase_calculowwds_15_tfemplicdanual_to), Short.valueOf(AV135Empresabase_calculowwds_21_tfempbasepromcnt1), Short.valueOf(AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to), Short.valueOf(AV137Empresabase_calculowwds_23_tfempbasepromcnt2), Short.valueOf(AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to)});
      GRID_nRecordCount = H00KC3_AGRID_nRecordCount[0] ;
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
      AV115Empresabase_calculowwds_1_empbaseclaseleg = AV8EmpBaseClaseLeg ;
      AV116Empresabase_calculowwds_2_empbasetipo = AV9EmpBaseTipo ;
      AV117Empresabase_calculowwds_3_tfempbaseplus = AV41TFEmpBasePlus ;
      AV118Empresabase_calculowwds_4_tfempbaseplus_to = AV42TFEmpBasePlus_To ;
      AV119Empresabase_calculowwds_5_tfemplicdmin = AV43TFEmpLicDMin ;
      AV120Empresabase_calculowwds_6_tfemplicdmin_to = AV44TFEmpLicDMin_To ;
      AV121Empresabase_calculowwds_7_tfemplicdlim = AV45TFEmpLicDLim ;
      AV122Empresabase_calculowwds_8_tfemplicdlim_to = AV46TFEmpLicDLim_To ;
      AV123Empresabase_calculowwds_9_tfemplicdseman = AV47TFEmpLicDSeman ;
      AV124Empresabase_calculowwds_10_tfemplicdseman_to = AV48TFEmpLicDSeman_To ;
      AV125Empresabase_calculowwds_11_tfemplicdmes_sels = AV50TFEmpLicDMes_Sels ;
      AV126Empresabase_calculowwds_12_tfemplicdsemes = AV51TFEmpLicDSemes ;
      AV127Empresabase_calculowwds_13_tfemplicdsemes_to = AV52TFEmpLicDSemes_To ;
      AV128Empresabase_calculowwds_14_tfemplicdanual = AV53TFEmpLicDAnual ;
      AV129Empresabase_calculowwds_15_tfemplicdanual_to = AV54TFEmpLicDAnual_To ;
      AV130Empresabase_calculowwds_16_tfemplicadju_sel = AV55TFEmpLicAdju_Sel ;
      AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel = AV56TFEmpLicAdjuObl_Sel ;
      AV132Empresabase_calculowwds_18_tfemplicnecaut_sel = AV57TFEmpLicNecAut_Sel ;
      AV133Empresabase_calculowwds_19_tfemplicingmot_sel = AV58TFEmpLicIngMot_Sel ;
      AV134Empresabase_calculowwds_20_tfemplicmotobl_sel = AV59TFEmpLicMotObl_Sel ;
      AV135Empresabase_calculowwds_21_tfempbasepromcnt1 = AV62TFEmpBasePromCnt1 ;
      AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to = AV63TFEmpBasePromCnt1_To ;
      AV137Empresabase_calculowwds_23_tfempbasepromcnt2 = AV64TFEmpBasePromCnt2 ;
      AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to = AV65TFEmpBasePromCnt2_To ;
      AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels = AV67TFEmpBasePromTCnt_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV101ManageFiltersExecutionStep, AV22ColumnsSelector, AV114Pgmname, AV90MenuOpcCod, AV13GridState, AV9EmpBaseTipo, AV8EmpBaseClaseLeg, AV41TFEmpBasePlus, AV42TFEmpBasePlus_To, AV43TFEmpLicDMin, AV44TFEmpLicDMin_To, AV45TFEmpLicDLim, AV46TFEmpLicDLim_To, AV47TFEmpLicDSeman, AV48TFEmpLicDSeman_To, AV50TFEmpLicDMes_Sels, AV51TFEmpLicDSemes, AV52TFEmpLicDSemes_To, AV53TFEmpLicDAnual, AV54TFEmpLicDAnual_To, AV55TFEmpLicAdju_Sel, AV56TFEmpLicAdjuObl_Sel, AV57TFEmpLicNecAut_Sel, AV58TFEmpLicIngMot_Sel, AV59TFEmpLicMotObl_Sel, AV62TFEmpBasePromCnt1, AV63TFEmpBasePromCnt1_To, AV64TFEmpBasePromCnt2, AV65TFEmpBasePromCnt2_To, AV67TFEmpBasePromTCnt_Sels, AV15OrderedBy, AV16OrderedDsc, AV79CliCod, AV74IsAuthorized_Update, AV86PaiCod, AV80EmpCod, AV115Empresabase_calculowwds_1_empbaseclaseleg, AV116Empresabase_calculowwds_2_empbasetipo, AV92WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV115Empresabase_calculowwds_1_empbaseclaseleg = AV8EmpBaseClaseLeg ;
      AV116Empresabase_calculowwds_2_empbasetipo = AV9EmpBaseTipo ;
      AV117Empresabase_calculowwds_3_tfempbaseplus = AV41TFEmpBasePlus ;
      AV118Empresabase_calculowwds_4_tfempbaseplus_to = AV42TFEmpBasePlus_To ;
      AV119Empresabase_calculowwds_5_tfemplicdmin = AV43TFEmpLicDMin ;
      AV120Empresabase_calculowwds_6_tfemplicdmin_to = AV44TFEmpLicDMin_To ;
      AV121Empresabase_calculowwds_7_tfemplicdlim = AV45TFEmpLicDLim ;
      AV122Empresabase_calculowwds_8_tfemplicdlim_to = AV46TFEmpLicDLim_To ;
      AV123Empresabase_calculowwds_9_tfemplicdseman = AV47TFEmpLicDSeman ;
      AV124Empresabase_calculowwds_10_tfemplicdseman_to = AV48TFEmpLicDSeman_To ;
      AV125Empresabase_calculowwds_11_tfemplicdmes_sels = AV50TFEmpLicDMes_Sels ;
      AV126Empresabase_calculowwds_12_tfemplicdsemes = AV51TFEmpLicDSemes ;
      AV127Empresabase_calculowwds_13_tfemplicdsemes_to = AV52TFEmpLicDSemes_To ;
      AV128Empresabase_calculowwds_14_tfemplicdanual = AV53TFEmpLicDAnual ;
      AV129Empresabase_calculowwds_15_tfemplicdanual_to = AV54TFEmpLicDAnual_To ;
      AV130Empresabase_calculowwds_16_tfemplicadju_sel = AV55TFEmpLicAdju_Sel ;
      AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel = AV56TFEmpLicAdjuObl_Sel ;
      AV132Empresabase_calculowwds_18_tfemplicnecaut_sel = AV57TFEmpLicNecAut_Sel ;
      AV133Empresabase_calculowwds_19_tfemplicingmot_sel = AV58TFEmpLicIngMot_Sel ;
      AV134Empresabase_calculowwds_20_tfemplicmotobl_sel = AV59TFEmpLicMotObl_Sel ;
      AV135Empresabase_calculowwds_21_tfempbasepromcnt1 = AV62TFEmpBasePromCnt1 ;
      AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to = AV63TFEmpBasePromCnt1_To ;
      AV137Empresabase_calculowwds_23_tfempbasepromcnt2 = AV64TFEmpBasePromCnt2 ;
      AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to = AV65TFEmpBasePromCnt2_To ;
      AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels = AV67TFEmpBasePromTCnt_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV101ManageFiltersExecutionStep, AV22ColumnsSelector, AV114Pgmname, AV90MenuOpcCod, AV13GridState, AV9EmpBaseTipo, AV8EmpBaseClaseLeg, AV41TFEmpBasePlus, AV42TFEmpBasePlus_To, AV43TFEmpLicDMin, AV44TFEmpLicDMin_To, AV45TFEmpLicDLim, AV46TFEmpLicDLim_To, AV47TFEmpLicDSeman, AV48TFEmpLicDSeman_To, AV50TFEmpLicDMes_Sels, AV51TFEmpLicDSemes, AV52TFEmpLicDSemes_To, AV53TFEmpLicDAnual, AV54TFEmpLicDAnual_To, AV55TFEmpLicAdju_Sel, AV56TFEmpLicAdjuObl_Sel, AV57TFEmpLicNecAut_Sel, AV58TFEmpLicIngMot_Sel, AV59TFEmpLicMotObl_Sel, AV62TFEmpBasePromCnt1, AV63TFEmpBasePromCnt1_To, AV64TFEmpBasePromCnt2, AV65TFEmpBasePromCnt2_To, AV67TFEmpBasePromTCnt_Sels, AV15OrderedBy, AV16OrderedDsc, AV79CliCod, AV74IsAuthorized_Update, AV86PaiCod, AV80EmpCod, AV115Empresabase_calculowwds_1_empbaseclaseleg, AV116Empresabase_calculowwds_2_empbasetipo, AV92WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV115Empresabase_calculowwds_1_empbaseclaseleg = AV8EmpBaseClaseLeg ;
      AV116Empresabase_calculowwds_2_empbasetipo = AV9EmpBaseTipo ;
      AV117Empresabase_calculowwds_3_tfempbaseplus = AV41TFEmpBasePlus ;
      AV118Empresabase_calculowwds_4_tfempbaseplus_to = AV42TFEmpBasePlus_To ;
      AV119Empresabase_calculowwds_5_tfemplicdmin = AV43TFEmpLicDMin ;
      AV120Empresabase_calculowwds_6_tfemplicdmin_to = AV44TFEmpLicDMin_To ;
      AV121Empresabase_calculowwds_7_tfemplicdlim = AV45TFEmpLicDLim ;
      AV122Empresabase_calculowwds_8_tfemplicdlim_to = AV46TFEmpLicDLim_To ;
      AV123Empresabase_calculowwds_9_tfemplicdseman = AV47TFEmpLicDSeman ;
      AV124Empresabase_calculowwds_10_tfemplicdseman_to = AV48TFEmpLicDSeman_To ;
      AV125Empresabase_calculowwds_11_tfemplicdmes_sels = AV50TFEmpLicDMes_Sels ;
      AV126Empresabase_calculowwds_12_tfemplicdsemes = AV51TFEmpLicDSemes ;
      AV127Empresabase_calculowwds_13_tfemplicdsemes_to = AV52TFEmpLicDSemes_To ;
      AV128Empresabase_calculowwds_14_tfemplicdanual = AV53TFEmpLicDAnual ;
      AV129Empresabase_calculowwds_15_tfemplicdanual_to = AV54TFEmpLicDAnual_To ;
      AV130Empresabase_calculowwds_16_tfemplicadju_sel = AV55TFEmpLicAdju_Sel ;
      AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel = AV56TFEmpLicAdjuObl_Sel ;
      AV132Empresabase_calculowwds_18_tfemplicnecaut_sel = AV57TFEmpLicNecAut_Sel ;
      AV133Empresabase_calculowwds_19_tfemplicingmot_sel = AV58TFEmpLicIngMot_Sel ;
      AV134Empresabase_calculowwds_20_tfemplicmotobl_sel = AV59TFEmpLicMotObl_Sel ;
      AV135Empresabase_calculowwds_21_tfempbasepromcnt1 = AV62TFEmpBasePromCnt1 ;
      AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to = AV63TFEmpBasePromCnt1_To ;
      AV137Empresabase_calculowwds_23_tfempbasepromcnt2 = AV64TFEmpBasePromCnt2 ;
      AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to = AV65TFEmpBasePromCnt2_To ;
      AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels = AV67TFEmpBasePromTCnt_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV101ManageFiltersExecutionStep, AV22ColumnsSelector, AV114Pgmname, AV90MenuOpcCod, AV13GridState, AV9EmpBaseTipo, AV8EmpBaseClaseLeg, AV41TFEmpBasePlus, AV42TFEmpBasePlus_To, AV43TFEmpLicDMin, AV44TFEmpLicDMin_To, AV45TFEmpLicDLim, AV46TFEmpLicDLim_To, AV47TFEmpLicDSeman, AV48TFEmpLicDSeman_To, AV50TFEmpLicDMes_Sels, AV51TFEmpLicDSemes, AV52TFEmpLicDSemes_To, AV53TFEmpLicDAnual, AV54TFEmpLicDAnual_To, AV55TFEmpLicAdju_Sel, AV56TFEmpLicAdjuObl_Sel, AV57TFEmpLicNecAut_Sel, AV58TFEmpLicIngMot_Sel, AV59TFEmpLicMotObl_Sel, AV62TFEmpBasePromCnt1, AV63TFEmpBasePromCnt1_To, AV64TFEmpBasePromCnt2, AV65TFEmpBasePromCnt2_To, AV67TFEmpBasePromTCnt_Sels, AV15OrderedBy, AV16OrderedDsc, AV79CliCod, AV74IsAuthorized_Update, AV86PaiCod, AV80EmpCod, AV115Empresabase_calculowwds_1_empbaseclaseleg, AV116Empresabase_calculowwds_2_empbasetipo, AV92WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV115Empresabase_calculowwds_1_empbaseclaseleg = AV8EmpBaseClaseLeg ;
      AV116Empresabase_calculowwds_2_empbasetipo = AV9EmpBaseTipo ;
      AV117Empresabase_calculowwds_3_tfempbaseplus = AV41TFEmpBasePlus ;
      AV118Empresabase_calculowwds_4_tfempbaseplus_to = AV42TFEmpBasePlus_To ;
      AV119Empresabase_calculowwds_5_tfemplicdmin = AV43TFEmpLicDMin ;
      AV120Empresabase_calculowwds_6_tfemplicdmin_to = AV44TFEmpLicDMin_To ;
      AV121Empresabase_calculowwds_7_tfemplicdlim = AV45TFEmpLicDLim ;
      AV122Empresabase_calculowwds_8_tfemplicdlim_to = AV46TFEmpLicDLim_To ;
      AV123Empresabase_calculowwds_9_tfemplicdseman = AV47TFEmpLicDSeman ;
      AV124Empresabase_calculowwds_10_tfemplicdseman_to = AV48TFEmpLicDSeman_To ;
      AV125Empresabase_calculowwds_11_tfemplicdmes_sels = AV50TFEmpLicDMes_Sels ;
      AV126Empresabase_calculowwds_12_tfemplicdsemes = AV51TFEmpLicDSemes ;
      AV127Empresabase_calculowwds_13_tfemplicdsemes_to = AV52TFEmpLicDSemes_To ;
      AV128Empresabase_calculowwds_14_tfemplicdanual = AV53TFEmpLicDAnual ;
      AV129Empresabase_calculowwds_15_tfemplicdanual_to = AV54TFEmpLicDAnual_To ;
      AV130Empresabase_calculowwds_16_tfemplicadju_sel = AV55TFEmpLicAdju_Sel ;
      AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel = AV56TFEmpLicAdjuObl_Sel ;
      AV132Empresabase_calculowwds_18_tfemplicnecaut_sel = AV57TFEmpLicNecAut_Sel ;
      AV133Empresabase_calculowwds_19_tfemplicingmot_sel = AV58TFEmpLicIngMot_Sel ;
      AV134Empresabase_calculowwds_20_tfemplicmotobl_sel = AV59TFEmpLicMotObl_Sel ;
      AV135Empresabase_calculowwds_21_tfempbasepromcnt1 = AV62TFEmpBasePromCnt1 ;
      AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to = AV63TFEmpBasePromCnt1_To ;
      AV137Empresabase_calculowwds_23_tfempbasepromcnt2 = AV64TFEmpBasePromCnt2 ;
      AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to = AV65TFEmpBasePromCnt2_To ;
      AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels = AV67TFEmpBasePromTCnt_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV101ManageFiltersExecutionStep, AV22ColumnsSelector, AV114Pgmname, AV90MenuOpcCod, AV13GridState, AV9EmpBaseTipo, AV8EmpBaseClaseLeg, AV41TFEmpBasePlus, AV42TFEmpBasePlus_To, AV43TFEmpLicDMin, AV44TFEmpLicDMin_To, AV45TFEmpLicDLim, AV46TFEmpLicDLim_To, AV47TFEmpLicDSeman, AV48TFEmpLicDSeman_To, AV50TFEmpLicDMes_Sels, AV51TFEmpLicDSemes, AV52TFEmpLicDSemes_To, AV53TFEmpLicDAnual, AV54TFEmpLicDAnual_To, AV55TFEmpLicAdju_Sel, AV56TFEmpLicAdjuObl_Sel, AV57TFEmpLicNecAut_Sel, AV58TFEmpLicIngMot_Sel, AV59TFEmpLicMotObl_Sel, AV62TFEmpBasePromCnt1, AV63TFEmpBasePromCnt1_To, AV64TFEmpBasePromCnt2, AV65TFEmpBasePromCnt2_To, AV67TFEmpBasePromTCnt_Sels, AV15OrderedBy, AV16OrderedDsc, AV79CliCod, AV74IsAuthorized_Update, AV86PaiCod, AV80EmpCod, AV115Empresabase_calculowwds_1_empbaseclaseleg, AV116Empresabase_calculowwds_2_empbasetipo, AV92WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV115Empresabase_calculowwds_1_empbaseclaseleg = AV8EmpBaseClaseLeg ;
      AV116Empresabase_calculowwds_2_empbasetipo = AV9EmpBaseTipo ;
      AV117Empresabase_calculowwds_3_tfempbaseplus = AV41TFEmpBasePlus ;
      AV118Empresabase_calculowwds_4_tfempbaseplus_to = AV42TFEmpBasePlus_To ;
      AV119Empresabase_calculowwds_5_tfemplicdmin = AV43TFEmpLicDMin ;
      AV120Empresabase_calculowwds_6_tfemplicdmin_to = AV44TFEmpLicDMin_To ;
      AV121Empresabase_calculowwds_7_tfemplicdlim = AV45TFEmpLicDLim ;
      AV122Empresabase_calculowwds_8_tfemplicdlim_to = AV46TFEmpLicDLim_To ;
      AV123Empresabase_calculowwds_9_tfemplicdseman = AV47TFEmpLicDSeman ;
      AV124Empresabase_calculowwds_10_tfemplicdseman_to = AV48TFEmpLicDSeman_To ;
      AV125Empresabase_calculowwds_11_tfemplicdmes_sels = AV50TFEmpLicDMes_Sels ;
      AV126Empresabase_calculowwds_12_tfemplicdsemes = AV51TFEmpLicDSemes ;
      AV127Empresabase_calculowwds_13_tfemplicdsemes_to = AV52TFEmpLicDSemes_To ;
      AV128Empresabase_calculowwds_14_tfemplicdanual = AV53TFEmpLicDAnual ;
      AV129Empresabase_calculowwds_15_tfemplicdanual_to = AV54TFEmpLicDAnual_To ;
      AV130Empresabase_calculowwds_16_tfemplicadju_sel = AV55TFEmpLicAdju_Sel ;
      AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel = AV56TFEmpLicAdjuObl_Sel ;
      AV132Empresabase_calculowwds_18_tfemplicnecaut_sel = AV57TFEmpLicNecAut_Sel ;
      AV133Empresabase_calculowwds_19_tfemplicingmot_sel = AV58TFEmpLicIngMot_Sel ;
      AV134Empresabase_calculowwds_20_tfemplicmotobl_sel = AV59TFEmpLicMotObl_Sel ;
      AV135Empresabase_calculowwds_21_tfempbasepromcnt1 = AV62TFEmpBasePromCnt1 ;
      AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to = AV63TFEmpBasePromCnt1_To ;
      AV137Empresabase_calculowwds_23_tfempbasepromcnt2 = AV64TFEmpBasePromCnt2 ;
      AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to = AV65TFEmpBasePromCnt2_To ;
      AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels = AV67TFEmpBasePromTCnt_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV101ManageFiltersExecutionStep, AV22ColumnsSelector, AV114Pgmname, AV90MenuOpcCod, AV13GridState, AV9EmpBaseTipo, AV8EmpBaseClaseLeg, AV41TFEmpBasePlus, AV42TFEmpBasePlus_To, AV43TFEmpLicDMin, AV44TFEmpLicDMin_To, AV45TFEmpLicDLim, AV46TFEmpLicDLim_To, AV47TFEmpLicDSeman, AV48TFEmpLicDSeman_To, AV50TFEmpLicDMes_Sels, AV51TFEmpLicDSemes, AV52TFEmpLicDSemes_To, AV53TFEmpLicDAnual, AV54TFEmpLicDAnual_To, AV55TFEmpLicAdju_Sel, AV56TFEmpLicAdjuObl_Sel, AV57TFEmpLicNecAut_Sel, AV58TFEmpLicIngMot_Sel, AV59TFEmpLicMotObl_Sel, AV62TFEmpBasePromCnt1, AV63TFEmpBasePromCnt1_To, AV64TFEmpBasePromCnt2, AV65TFEmpBasePromCnt2_To, AV67TFEmpBasePromTCnt_Sels, AV15OrderedBy, AV16OrderedDsc, AV79CliCod, AV74IsAuthorized_Update, AV86PaiCod, AV80EmpCod, AV115Empresabase_calculowwds_1_empbaseclaseleg, AV116Empresabase_calculowwds_2_empbasetipo, AV92WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV114Pgmname = "Empresabase_calculoWW" ;
      Gx_err = (short)(0) ;
      edtavEmpbasec1txt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec1txt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpbasec1txt_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavEmpbasec2txt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec2txt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpbasec2txt_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      chkavDefault.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavDefault.getInternalname(), "Enabled", GXutil.ltrimstr( chkavDefault.getEnabled(), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupKC0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18KC2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV68DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV22ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV99ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_108 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_108"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV70GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV71GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV72GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
      e18KC2 ();
      if (returnInSub) return;
   }

   public void e18KC2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV90MenuOpcCod, "", "") ;
      GXt_int1 = AV80EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      empresabase_calculoww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV80EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV80EmpCod), 4, 0));
      GXt_int3 = AV79CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      empresabase_calculoww_impl.this.GXt_int3 = GXv_int4[0] ;
      AV79CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV79CliCod), "ZZZZZ9")));
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
      Form.setCaption( httpContext.getMessage( " Base de cálculo", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV68DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
      AV68DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char7[0] = AV93MenuBienveImgURL ;
      GXv_char8[0] = AV95MenuBienveTitulo ;
      GXv_char9[0] = AV96MenuBienveTexto ;
      GXv_boolean10[0] = AV97MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV90MenuOpcCod, GXv_char7, GXv_char8, GXv_char9, GXv_boolean10) ;
      empresabase_calculoww_impl.this.AV93MenuBienveImgURL = GXv_char7[0] ;
      empresabase_calculoww_impl.this.AV95MenuBienveTitulo = GXv_char8[0] ;
      empresabase_calculoww_impl.this.AV96MenuBienveTexto = GXv_char9[0] ;
      empresabase_calculoww_impl.this.AV97MenuBienveVisible = GXv_boolean10[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV97MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV97MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV95MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV96MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV98WelcomeMessage_Foto = AV93MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV98WelcomeMessage_Foto)==0) ? AV113Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV98WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV98WelcomeMessage_Foto), true);
         AV113Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV93MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV98WelcomeMessage_Foto)==0) ? AV113Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV98WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV98WelcomeMessage_Foto), true);
      }
      GXt_char11 = "" ;
      GXt_char12 = "" ;
      GXv_char9[0] = GXt_char12 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char9) ;
      empresabase_calculoww_impl.this.GXt_char12 = GXv_char9[0] ;
      GXv_char8[0] = GXt_char11 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char12, GXv_char8) ;
      empresabase_calculoww_impl.this.GXt_char11 = GXv_char8[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char11 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV110observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV110observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV110observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV110observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      if ( GXutil.strcmp(AV9EmpBaseTipo, "feriado") != 0 )
      {
         if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
         {
            edtavEmpbasec1txt_Title = httpContext.getMessage( "Licencia", "") ;
            httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec1txt_Internalname, "Title", edtavEmpbasec1txt_Title, !bGXsfl_108_Refreshing);
         }
      }
      else
      {
         edtavEmpbasec1txt_Title = httpContext.getMessage( "Tipo", "") ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec1txt_Internalname, "Title", edtavEmpbasec1txt_Title, !bGXsfl_108_Refreshing);
      }
      GXv_int2[0] = AV86PaiCod ;
      new web.empresagetpais(remoteHandle, context).execute( AV79CliCod, AV80EmpCod, GXv_int2) ;
      empresabase_calculoww_impl.this.AV86PaiCod = GXv_int2[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV86PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV86PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV86PaiCod), "ZZZ9")));
   }

   public void e19KC2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV80EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      empresabase_calculoww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV80EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV80EmpCod), 4, 0));
      GXt_int3 = AV79CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      empresabase_calculoww_impl.this.GXt_int3 = GXv_int4[0] ;
      AV79CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV79CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext13[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext13) ;
      AV6WWPContext = GXv_SdtWWPContext13[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV101ManageFiltersExecutionStep == 1 )
      {
         AV101ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV101ManageFiltersExecutionStep", GXutil.str( AV101ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV101ManageFiltersExecutionStep == 2 )
      {
         AV101ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV101ManageFiltersExecutionStep", GXutil.str( AV101ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV24Session.getValue("Empresabase_calculoWWColumnsSelector"), "") != 0 )
      {
         AV20ColumnsSelectorXML = AV24Session.getValue("Empresabase_calculoWWColumnsSelector") ;
         AV22ColumnsSelector.fromxml(AV20ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtavEmpbasec1txt_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec1txt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpbasec1txt_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavEmpbasec2txt_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec2txt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpbasec2txt_Visible), 5, 0), !bGXsfl_108_Refreshing);
      chkavDefault.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkavDefault.getInternalname(), "Visible", GXutil.ltrimstr( chkavDefault.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtEmpBasePlus_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBasePlus_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBasePlus_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtEmpLicDMin_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDMin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDMin_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtEmpLicDLim_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDLim_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtEmpLicDSeman_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSeman_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbEmpLicDMes.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpLicDMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpLicDMes.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtEmpLicDSemes_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSemes_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtEmpLicDAnual_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDAnual_Visible), 5, 0), !bGXsfl_108_Refreshing);
      chkEmpLicAdju.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicAdju.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      chkEmpLicAdjuObl.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicAdjuObl.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      chkEmpLicNecAut.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicNecAut.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      chkEmpLicIngMot.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicIngMot.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      chkEmpLicMotObl.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicMotObl.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtEmpBasePromCnt1_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBasePromCnt1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBasePromCnt1_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtEmpBasePromCnt2_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBasePromCnt2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBasePromCnt2_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbEmpBasePromTCnt.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBasePromTCnt.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpBasePromTCnt.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      AV70GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV70GridCurrentPage), 10, 0));
      AV71GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71GridPageCount), 10, 0));
      GXt_char12 = AV72GridAppliedFilters ;
      GXv_char9[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV114Pgmname, GXv_char9) ;
      empresabase_calculoww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV72GridAppliedFilters = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72GridAppliedFilters", AV72GridAppliedFilters);
      GXt_char12 = AV106MenuOpcTitulo ;
      GXv_char9[0] = GXt_char12 ;
      new web.gettxtcount(remoteHandle, context).execute( AV90MenuOpcCod, GXv_char9) ;
      empresabase_calculoww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV106MenuOpcTitulo = GXt_char12 ;
      if ( (GXutil.strcmp("", AV106MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV106MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int2[0] = (short)(AV108filterCount) ;
      GXv_char9[0] = AV109filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV13GridState, GXv_int2, GXv_char9) ;
      empresabase_calculoww_impl.this.AV108filterCount = GXv_int2[0] ;
      empresabase_calculoww_impl.this.AV109filtrosTexto = GXv_char9[0] ;
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
      if ( GXutil.strcmp(AV9EmpBaseTipo, "feriado") != 0 )
      {
         edtavEmpbasec2txt_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmpbasec2txt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpbasec2txt_Visible), 5, 0), !bGXsfl_108_Refreshing);
      }
      AV115Empresabase_calculowwds_1_empbaseclaseleg = AV8EmpBaseClaseLeg ;
      AV116Empresabase_calculowwds_2_empbasetipo = AV9EmpBaseTipo ;
      AV117Empresabase_calculowwds_3_tfempbaseplus = AV41TFEmpBasePlus ;
      AV118Empresabase_calculowwds_4_tfempbaseplus_to = AV42TFEmpBasePlus_To ;
      AV119Empresabase_calculowwds_5_tfemplicdmin = AV43TFEmpLicDMin ;
      AV120Empresabase_calculowwds_6_tfemplicdmin_to = AV44TFEmpLicDMin_To ;
      AV121Empresabase_calculowwds_7_tfemplicdlim = AV45TFEmpLicDLim ;
      AV122Empresabase_calculowwds_8_tfemplicdlim_to = AV46TFEmpLicDLim_To ;
      AV123Empresabase_calculowwds_9_tfemplicdseman = AV47TFEmpLicDSeman ;
      AV124Empresabase_calculowwds_10_tfemplicdseman_to = AV48TFEmpLicDSeman_To ;
      AV125Empresabase_calculowwds_11_tfemplicdmes_sels = AV50TFEmpLicDMes_Sels ;
      AV126Empresabase_calculowwds_12_tfemplicdsemes = AV51TFEmpLicDSemes ;
      AV127Empresabase_calculowwds_13_tfemplicdsemes_to = AV52TFEmpLicDSemes_To ;
      AV128Empresabase_calculowwds_14_tfemplicdanual = AV53TFEmpLicDAnual ;
      AV129Empresabase_calculowwds_15_tfemplicdanual_to = AV54TFEmpLicDAnual_To ;
      AV130Empresabase_calculowwds_16_tfemplicadju_sel = AV55TFEmpLicAdju_Sel ;
      AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel = AV56TFEmpLicAdjuObl_Sel ;
      AV132Empresabase_calculowwds_18_tfemplicnecaut_sel = AV57TFEmpLicNecAut_Sel ;
      AV133Empresabase_calculowwds_19_tfemplicingmot_sel = AV58TFEmpLicIngMot_Sel ;
      AV134Empresabase_calculowwds_20_tfemplicmotobl_sel = AV59TFEmpLicMotObl_Sel ;
      AV135Empresabase_calculowwds_21_tfempbasepromcnt1 = AV62TFEmpBasePromCnt1 ;
      AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to = AV63TFEmpBasePromCnt1_To ;
      AV137Empresabase_calculowwds_23_tfempbasepromcnt2 = AV64TFEmpBasePromCnt2 ;
      AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to = AV65TFEmpBasePromCnt2_To ;
      AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels = AV67TFEmpBasePromTCnt_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV99ManageFiltersData", AV99ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFEmpLicDMes_Sels", AV50TFEmpLicDMes_Sels);
   }

   public void e13KC2( )
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
         AV69PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV69PageToGo) ;
      }
   }

   public void e14KC2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15KC2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpBasePlus") == 0 )
         {
            AV41TFEmpBasePlus = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFEmpBasePlus", GXutil.ltrimstr( AV41TFEmpBasePlus, 6, 4));
            AV42TFEmpBasePlus_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFEmpBasePlus_To", GXutil.ltrimstr( AV42TFEmpBasePlus_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicDMin") == 0 )
         {
            AV43TFEmpLicDMin = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFEmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43TFEmpLicDMin), 2, 0));
            AV44TFEmpLicDMin_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFEmpLicDMin_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44TFEmpLicDMin_To), 2, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicDLim") == 0 )
         {
            AV45TFEmpLicDLim = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFEmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFEmpLicDLim), 3, 0));
            AV46TFEmpLicDLim_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFEmpLicDLim_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFEmpLicDLim_To), 3, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicDSeman") == 0 )
         {
            AV47TFEmpLicDSeman = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFEmpLicDSeman", GXutil.str( AV47TFEmpLicDSeman, 1, 0));
            AV48TFEmpLicDSeman_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFEmpLicDSeman_To", GXutil.str( AV48TFEmpLicDSeman_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicDMes") == 0 )
         {
            AV49TFEmpLicDMes_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFEmpLicDMes_SelsJson", AV49TFEmpLicDMes_SelsJson);
            AV50TFEmpLicDMes_Sels.fromJSonString(GXutil.strReplace( AV49TFEmpLicDMes_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicDSemes") == 0 )
         {
            AV51TFEmpLicDSemes = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFEmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51TFEmpLicDSemes), 3, 0));
            AV52TFEmpLicDSemes_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFEmpLicDSemes_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TFEmpLicDSemes_To), 3, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicDAnual") == 0 )
         {
            AV53TFEmpLicDAnual = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFEmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFEmpLicDAnual), 3, 0));
            AV54TFEmpLicDAnual_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFEmpLicDAnual_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFEmpLicDAnual_To), 3, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicAdju") == 0 )
         {
            AV55TFEmpLicAdju_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFEmpLicAdju_Sel", GXutil.str( AV55TFEmpLicAdju_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicAdjuObl") == 0 )
         {
            AV56TFEmpLicAdjuObl_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFEmpLicAdjuObl_Sel", GXutil.str( AV56TFEmpLicAdjuObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicNecAut") == 0 )
         {
            AV57TFEmpLicNecAut_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFEmpLicNecAut_Sel", GXutil.str( AV57TFEmpLicNecAut_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicIngMot") == 0 )
         {
            AV58TFEmpLicIngMot_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFEmpLicIngMot_Sel", GXutil.str( AV58TFEmpLicIngMot_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpLicMotObl") == 0 )
         {
            AV59TFEmpLicMotObl_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFEmpLicMotObl_Sel", GXutil.str( AV59TFEmpLicMotObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpBasePromCnt1") == 0 )
         {
            AV62TFEmpBasePromCnt1 = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFEmpBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFEmpBasePromCnt1), 3, 0));
            AV63TFEmpBasePromCnt1_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFEmpBasePromCnt1_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63TFEmpBasePromCnt1_To), 3, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpBasePromCnt2") == 0 )
         {
            AV64TFEmpBasePromCnt2 = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFEmpBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV64TFEmpBasePromCnt2), 3, 0));
            AV65TFEmpBasePromCnt2_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFEmpBasePromCnt2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65TFEmpBasePromCnt2_To), 3, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpBasePromTCnt") == 0 )
         {
            AV66TFEmpBasePromTCnt_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFEmpBasePromTCnt_SelsJson", AV66TFEmpBasePromTCnt_SelsJson);
            AV67TFEmpBasePromTCnt_Sels.fromJSonString(AV66TFEmpBasePromTCnt_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV67TFEmpBasePromTCnt_Sels", AV67TFEmpBasePromTCnt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFEmpLicDMes_Sels", AV50TFEmpLicDMes_Sels);
   }

   private void e20KC2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV73Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV73Update);
      if ( AV74IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.empresabase_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1427EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(A1429EmpBaseTipo)),GXutil.URLEncode(GXutil.rtrim(A1430EmpBaseCod1)),GXutil.URLEncode(GXutil.rtrim(A1431EmpBaseCod2))}, new String[] {"Mode","CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2"})  ;
      }
      AV89Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV89Display);
      edtavDisplay_Link = formatLink("web.empresabase_calculoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1427EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(A1429EmpBaseTipo)),GXutil.URLEncode(GXutil.rtrim(A1430EmpBaseCod1)),GXutil.URLEncode(GXutil.rtrim(A1431EmpBaseCod2)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2","TabCode"})  ;
      GXt_char12 = AV81EmpBaseC1Txt ;
      GXv_char9[0] = GXt_char12 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( 0, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char9) ;
      empresabase_calculoww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV81EmpBaseC1Txt = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEmpbasec1txt_Internalname, AV81EmpBaseC1Txt);
      GXt_char12 = AV82EmpBaseC2Txt ;
      GXv_char9[0] = GXt_char12 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( 0, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char9) ;
      empresabase_calculoww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV82EmpBaseC2Txt = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEmpbasec2txt_Internalname, AV82EmpBaseC2Txt);
      edtavVersvg_Format = (short)(1) ;
      GXt_char12 = AV87VerSVG ;
      GXv_char9[0] = GXt_char12 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char9) ;
      empresabase_calculoww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV87VerSVG = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV87VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char12 = AV88ModificarSVG ;
      GXv_char9[0] = GXt_char12 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char9) ;
      empresabase_calculoww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV88ModificarSVG = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV88ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV114Pgmname, httpContext.getMessage( "&Update.link ", "")+edtavUpdate_Link) ;
      GXv_boolean10[0] = AV85Default ;
      new web.calculoesdefault(remoteHandle, context).execute( AV86PaiCod, A1427EmpBaseClaseLeg, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, A1432EmpBasePlus, A1502EmpLicDLim, A1503EmpLicDSeman, A1504EmpLicDMes, A1505EmpLicDSemes, A1506EmpLicDAnual, A1507EmpLicAdju, A1508EmpLicAdjuObl, A1509EmpLicNecAut, A1510EmpLicIngMot, A1511EmpLicMotObl, A1437EmpBasePromCnt1, A1438EmpBasePromCnt2, A1439EmpBasePromTCnt, GXv_boolean10) ;
      empresabase_calculoww_impl.this.AV85Default = GXv_boolean10[0] ;
      httpContext.ajax_rsp_assign_attri("", false, chkavDefault.getInternalname(), AV85Default);
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

   public void e11KC2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV20ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV22ColumnsSelector.fromJSonString(AV20ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "Empresabase_calculoWWColumnsSelector", ((GXutil.strcmp("", AV20ColumnsSelectorXML)==0) ? "" : AV22ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV99ManageFiltersData", AV99ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFEmpLicDMes_Sels", AV50TFEmpLicDMes_Sels);
   }

   public void e12KC2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("Empresabase_calculoWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV114Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV101ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV101ManageFiltersExecutionStep", GXutil.str( AV101ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("Empresabase_calculoWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV101ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV101ManageFiltersExecutionStep", GXutil.str( AV101ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char12 = AV100ManageFiltersXml ;
         GXv_char9[0] = GXt_char12 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "Empresabase_calculoWWFilters", Ddo_managefilters_Activeeventkey, GXv_char9) ;
         empresabase_calculoww_impl.this.GXt_char12 = GXv_char9[0] ;
         AV100ManageFiltersXml = GXt_char12 ;
         if ( (GXutil.strcmp("", AV100ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV114Pgmname+"GridState", AV100ManageFiltersXml) ;
            AV13GridState.fromxml(AV100ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFEmpLicDMes_Sels", AV50TFEmpLicDMes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV67TFEmpBasePromTCnt_Sels", AV67TFEmpBasePromTCnt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV99ManageFiltersData", AV99ManageFiltersData);
   }

   public void e16KC2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char9[0] = AV18ExcelFilename ;
      GXv_char8[0] = AV19ErrorMessage ;
      new web.empresabase_calculowwexport(remoteHandle, context).execute( GXv_char9, GXv_char8) ;
      empresabase_calculoww_impl.this.AV18ExcelFilename = GXv_char9[0] ;
      empresabase_calculoww_impl.this.AV19ErrorMessage = GXv_char8[0] ;
      if ( GXutil.strcmp(AV18ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV18ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV19ErrorMessage);
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
      AV22ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&EmpBaseC1Txt", "", "Código 1", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&EmpBaseC2Txt", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&Default", "", "Default", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpBasePlus", "", "Porcentaje para plus", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicDMin", "", "Cantidad mínima de días permitidos por licencia", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV43TFEmpLicDMin = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43TFEmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43TFEmpLicDMin), 2, 0));
         AV44TFEmpLicDMin_To = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44TFEmpLicDMin_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44TFEmpLicDMin_To), 2, 0));
      }
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicDLim", "", "Cantidad de días permitidos por licencia", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV45TFEmpLicDLim = (short)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45TFEmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFEmpLicDLim), 3, 0));
         AV46TFEmpLicDLim_To = (short)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46TFEmpLicDLim_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFEmpLicDLim_To), 3, 0));
      }
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicDSeman", "", "Cantidad de días permitidos por semana", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV47TFEmpLicDSeman = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47TFEmpLicDSeman", GXutil.str( AV47TFEmpLicDSeman, 1, 0));
         AV48TFEmpLicDSeman_To = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48TFEmpLicDSeman_To", GXutil.str( AV48TFEmpLicDSeman_To, 1, 0));
      }
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicDMes", "", "Cantidad de días permitidos por mes", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV50TFEmpLicDMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      }
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicDSemes", "", "Cantidad de días permitidos por semestre", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV51TFEmpLicDSemes = (short)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51TFEmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51TFEmpLicDSemes), 3, 0));
         AV52TFEmpLicDSemes_To = (short)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52TFEmpLicDSemes_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TFEmpLicDSemes_To), 3, 0));
      }
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicDAnual", "", "Cantidad de días permitidos por año", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV53TFEmpLicDAnual = (short)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53TFEmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFEmpLicDAnual), 3, 0));
         AV54TFEmpLicDAnual_To = (short)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV54TFEmpLicDAnual_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFEmpLicDAnual_To), 3, 0));
      }
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicAdju", "", "Permite adjuntar documento", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV55TFEmpLicAdju_Sel = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55TFEmpLicAdju_Sel", GXutil.str( AV55TFEmpLicAdju_Sel, 1, 0));
      }
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicAdjuObl", "", "Obliga a adjuntar documento", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV56TFEmpLicAdjuObl_Sel = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56TFEmpLicAdjuObl_Sel", GXutil.str( AV56TFEmpLicAdjuObl_Sel, 1, 0));
      }
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicNecAut", "", "Necesita autorización", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV57TFEmpLicNecAut_Sel = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV57TFEmpLicNecAut_Sel", GXutil.str( AV57TFEmpLicNecAut_Sel, 1, 0));
      }
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicIngMot", "", "Permite ingresar motivo", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV58TFEmpLicIngMot_Sel = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58TFEmpLicIngMot_Sel", GXutil.str( AV58TFEmpLicIngMot_Sel, 1, 0));
      }
      if ( GXutil.strcmp(AV9EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpLicMotObl", "", "Obliga a ingresar motivo", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV59TFEmpLicMotObl_Sel = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59TFEmpLicMotObl_Sel", GXutil.str( AV59TFEmpLicMotObl_Sel, 1, 0));
      }
      GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpBasePromCnt1", "", "Cantidad de días/meses a promediar", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpBasePromCnt2", "", "Cantidad de días/meses a promediar segunda alternativa", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmpBasePromTCnt", "", "Días o Meses", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&VerSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&ModificarSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXt_char12 = AV21UserCustomValue ;
      GXv_char9[0] = GXt_char12 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Empresabase_calculoWWColumnsSelector", GXv_char9) ;
      empresabase_calculoww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV21UserCustomValue = GXt_char12 ;
      if ( ! ( (GXutil.strcmp("", AV21UserCustomValue)==0) ) )
      {
         AV23ColumnsSelectorAux.fromxml(AV21UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector14[0] = AV23ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector15[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, GXv_SdtWWPColumnsSelector15) ;
         AV23ColumnsSelectorAux = GXv_SdtWWPColumnsSelector14[0] ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      }
      GXv_SdtWWPColumnsSelector15[0] = AV22ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV79CliCod, GXv_SdtWWPColumnsSelector15) ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean16 = AV74IsAuthorized_Update ;
      GXv_boolean10[0] = GXt_boolean16 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresabase_calculo_Update", GXv_boolean10) ;
      empresabase_calculoww_impl.this.GXt_boolean16 = GXv_boolean10[0] ;
      AV74IsAuthorized_Update = GXt_boolean16 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74IsAuthorized_Update", AV74IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV74IsAuthorized_Update));
      if ( ! ( AV74IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_108_Refreshing);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = AV99ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "Empresabase_calculoWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[0] ;
      AV99ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV41TFEmpBasePlus = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFEmpBasePlus", GXutil.ltrimstr( AV41TFEmpBasePlus, 6, 4));
      AV42TFEmpBasePlus_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFEmpBasePlus_To", GXutil.ltrimstr( AV42TFEmpBasePlus_To, 6, 4));
      AV43TFEmpLicDMin = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFEmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43TFEmpLicDMin), 2, 0));
      AV44TFEmpLicDMin_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFEmpLicDMin_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44TFEmpLicDMin_To), 2, 0));
      AV45TFEmpLicDLim = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFEmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFEmpLicDLim), 3, 0));
      AV46TFEmpLicDLim_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFEmpLicDLim_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFEmpLicDLim_To), 3, 0));
      AV47TFEmpLicDSeman = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47TFEmpLicDSeman", GXutil.str( AV47TFEmpLicDSeman, 1, 0));
      AV48TFEmpLicDSeman_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48TFEmpLicDSeman_To", GXutil.str( AV48TFEmpLicDSeman_To, 1, 0));
      AV50TFEmpLicDMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV51TFEmpLicDSemes = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51TFEmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51TFEmpLicDSemes), 3, 0));
      AV52TFEmpLicDSemes_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52TFEmpLicDSemes_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TFEmpLicDSemes_To), 3, 0));
      AV53TFEmpLicDAnual = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53TFEmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFEmpLicDAnual), 3, 0));
      AV54TFEmpLicDAnual_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54TFEmpLicDAnual_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFEmpLicDAnual_To), 3, 0));
      AV55TFEmpLicAdju_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFEmpLicAdju_Sel", GXutil.str( AV55TFEmpLicAdju_Sel, 1, 0));
      AV56TFEmpLicAdjuObl_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56TFEmpLicAdjuObl_Sel", GXutil.str( AV56TFEmpLicAdjuObl_Sel, 1, 0));
      AV57TFEmpLicNecAut_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57TFEmpLicNecAut_Sel", GXutil.str( AV57TFEmpLicNecAut_Sel, 1, 0));
      AV58TFEmpLicIngMot_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58TFEmpLicIngMot_Sel", GXutil.str( AV58TFEmpLicIngMot_Sel, 1, 0));
      AV59TFEmpLicMotObl_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59TFEmpLicMotObl_Sel", GXutil.str( AV59TFEmpLicMotObl_Sel, 1, 0));
      AV62TFEmpBasePromCnt1 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62TFEmpBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFEmpBasePromCnt1), 3, 0));
      AV63TFEmpBasePromCnt1_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63TFEmpBasePromCnt1_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63TFEmpBasePromCnt1_To), 3, 0));
      AV64TFEmpBasePromCnt2 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64TFEmpBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV64TFEmpBasePromCnt2), 3, 0));
      AV65TFEmpBasePromCnt2_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65TFEmpBasePromCnt2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65TFEmpBasePromCnt2_To), 3, 0));
      AV67TFEmpBasePromTCnt_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV24Session.getValue(AV114Pgmname+"GridState"), "") == 0 )
      {
         AV13GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV114Pgmname+"GridState"), null, null);
      }
      else
      {
         AV13GridState.fromxml(AV24Session.getValue(AV114Pgmname+"GridState"), null, null);
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
      AV140GXV1 = 1 ;
      while ( AV140GXV1 <= AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV140GXV1));
         if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBASEPLUS") == 0 )
         {
            AV41TFEmpBasePlus = CommonUtil.decimalVal( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFEmpBasePlus", GXutil.ltrimstr( AV41TFEmpBasePlus, 6, 4));
            AV42TFEmpBasePlus_To = CommonUtil.decimalVal( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFEmpBasePlus_To", GXutil.ltrimstr( AV42TFEmpBasePlus_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDMIN") == 0 )
         {
            AV43TFEmpLicDMin = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFEmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43TFEmpLicDMin), 2, 0));
            AV44TFEmpLicDMin_To = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFEmpLicDMin_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44TFEmpLicDMin_To), 2, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDLIM") == 0 )
         {
            AV45TFEmpLicDLim = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFEmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFEmpLicDLim), 3, 0));
            AV46TFEmpLicDLim_To = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFEmpLicDLim_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFEmpLicDLim_To), 3, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDSEMAN") == 0 )
         {
            AV47TFEmpLicDSeman = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFEmpLicDSeman", GXutil.str( AV47TFEmpLicDSeman, 1, 0));
            AV48TFEmpLicDSeman_To = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFEmpLicDSeman_To", GXutil.str( AV48TFEmpLicDSeman_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDMES_SEL") == 0 )
         {
            AV49TFEmpLicDMes_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFEmpLicDMes_SelsJson", AV49TFEmpLicDMes_SelsJson);
            AV50TFEmpLicDMes_Sels.fromJSonString(AV49TFEmpLicDMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDSEMES") == 0 )
         {
            AV51TFEmpLicDSemes = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFEmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51TFEmpLicDSemes), 3, 0));
            AV52TFEmpLicDSemes_To = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFEmpLicDSemes_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TFEmpLicDSemes_To), 3, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDANUAL") == 0 )
         {
            AV53TFEmpLicDAnual = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFEmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFEmpLicDAnual), 3, 0));
            AV54TFEmpLicDAnual_To = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFEmpLicDAnual_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFEmpLicDAnual_To), 3, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICADJU_SEL") == 0 )
         {
            AV55TFEmpLicAdju_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFEmpLicAdju_Sel", GXutil.str( AV55TFEmpLicAdju_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICADJUOBL_SEL") == 0 )
         {
            AV56TFEmpLicAdjuObl_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFEmpLicAdjuObl_Sel", GXutil.str( AV56TFEmpLicAdjuObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICNECAUT_SEL") == 0 )
         {
            AV57TFEmpLicNecAut_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFEmpLicNecAut_Sel", GXutil.str( AV57TFEmpLicNecAut_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICINGMOT_SEL") == 0 )
         {
            AV58TFEmpLicIngMot_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFEmpLicIngMot_Sel", GXutil.str( AV58TFEmpLicIngMot_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICMOTOBL_SEL") == 0 )
         {
            AV59TFEmpLicMotObl_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFEmpLicMotObl_Sel", GXutil.str( AV59TFEmpLicMotObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBASEPROMCNT1") == 0 )
         {
            AV62TFEmpBasePromCnt1 = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFEmpBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFEmpBasePromCnt1), 3, 0));
            AV63TFEmpBasePromCnt1_To = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFEmpBasePromCnt1_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63TFEmpBasePromCnt1_To), 3, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBASEPROMCNT2") == 0 )
         {
            AV64TFEmpBasePromCnt2 = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFEmpBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV64TFEmpBasePromCnt2), 3, 0));
            AV65TFEmpBasePromCnt2_To = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFEmpBasePromCnt2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65TFEmpBasePromCnt2_To), 3, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBASEPROMTCNT_SEL") == 0 )
         {
            AV66TFEmpBasePromTCnt_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFEmpBasePromTCnt_SelsJson", AV66TFEmpBasePromTCnt_SelsJson);
            AV67TFEmpBasePromTCnt_Sels.fromJSonString(AV66TFEmpBasePromTCnt_SelsJson, null);
         }
         AV140GXV1 = (int)(AV140GXV1+1) ;
      }
      GXt_char12 = "" ;
      GXv_char9[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV67TFEmpBasePromTCnt_Sels.size()==0), AV66TFEmpBasePromTCnt_SelsJson, GXv_char9) ;
      empresabase_calculoww_impl.this.GXt_char12 = GXv_char9[0] ;
      Ddo_grid_Selectedvalue_set = "|||||||"+((AV50TFEmpLicDMes_Sels.size()==0) ? "" : AV49TFEmpLicDMes_SelsJson)+"|||"+((0==AV55TFEmpLicAdju_Sel) ? "" : GXutil.str( AV55TFEmpLicAdju_Sel, 1, 0))+"|"+((0==AV56TFEmpLicAdjuObl_Sel) ? "" : GXutil.str( AV56TFEmpLicAdjuObl_Sel, 1, 0))+"|"+((0==AV57TFEmpLicNecAut_Sel) ? "" : GXutil.str( AV57TFEmpLicNecAut_Sel, 1, 0))+"|"+((0==AV58TFEmpLicIngMot_Sel) ? "" : GXutil.str( AV58TFEmpLicIngMot_Sel, 1, 0))+"|"+((0==AV59TFEmpLicMotObl_Sel) ? "" : GXutil.str( AV59TFEmpLicMotObl_Sel, 1, 0))+"|||"+GXt_char12 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFEmpBasePlus)==0) ? "" : GXutil.str( AV41TFEmpBasePlus, 6, 4))+"|"+((0==AV43TFEmpLicDMin) ? "" : GXutil.str( AV43TFEmpLicDMin, 2, 0))+"|"+((0==AV45TFEmpLicDLim) ? "" : GXutil.str( AV45TFEmpLicDLim, 3, 0))+"|"+((0==AV47TFEmpLicDSeman) ? "" : GXutil.str( AV47TFEmpLicDSeman, 1, 0))+"||"+((0==AV51TFEmpLicDSemes) ? "" : GXutil.str( AV51TFEmpLicDSemes, 3, 0))+"|"+((0==AV53TFEmpLicDAnual) ? "" : GXutil.str( AV53TFEmpLicDAnual, 3, 0))+"||||||"+((0==AV62TFEmpBasePromCnt1) ? "" : GXutil.str( AV62TFEmpBasePromCnt1, 3, 0))+"|"+((0==AV64TFEmpBasePromCnt2) ? "" : GXutil.str( AV64TFEmpBasePromCnt2, 3, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFEmpBasePlus_To)==0) ? "" : GXutil.str( AV42TFEmpBasePlus_To, 6, 4))+"|"+((0==AV44TFEmpLicDMin_To) ? "" : GXutil.str( AV44TFEmpLicDMin_To, 2, 0))+"|"+((0==AV46TFEmpLicDLim_To) ? "" : GXutil.str( AV46TFEmpLicDLim_To, 3, 0))+"|"+((0==AV48TFEmpLicDSeman_To) ? "" : GXutil.str( AV48TFEmpLicDSeman_To, 1, 0))+"||"+((0==AV52TFEmpLicDSemes_To) ? "" : GXutil.str( AV52TFEmpLicDSemes_To, 3, 0))+"|"+((0==AV54TFEmpLicDAnual_To) ? "" : GXutil.str( AV54TFEmpLicDAnual_To, 3, 0))+"||||||"+((0==AV63TFEmpBasePromCnt1_To) ? "" : GXutil.str( AV63TFEmpBasePromCnt1_To, 3, 0))+"|"+((0==AV65TFEmpBasePromCnt2_To) ? "" : GXutil.str( AV65TFEmpBasePromCnt2_To, 3, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV13GridState.fromxml(AV24Session.getValue(AV114Pgmname+"GridState"), null, null);
      AV13GridState.setgxTv_SdtWWPGridState_Orderedby( AV15OrderedBy );
      AV13GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV16OrderedDsc );
      AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPBASEPLUS", httpContext.getMessage( "Porcentaje para plus", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFEmpBasePlus)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFEmpBasePlus_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV41TFEmpBasePlus, 6, 4)), GXutil.trim( GXutil.str( AV42TFEmpBasePlus_To, 6, 4))) ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICDMIN", httpContext.getMessage( "Cantidad mínima de días permitidos por licencia", ""), !((0==AV43TFEmpLicDMin)&&(0==AV44TFEmpLicDMin_To)), (short)(0), GXutil.trim( GXutil.str( AV43TFEmpLicDMin, 2, 0)), GXutil.trim( GXutil.str( AV44TFEmpLicDMin_To, 2, 0))) ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICDLIM", httpContext.getMessage( "Cantidad de días permitidos por licencia", ""), !((0==AV45TFEmpLicDLim)&&(0==AV46TFEmpLicDLim_To)), (short)(0), GXutil.trim( GXutil.str( AV45TFEmpLicDLim, 3, 0)), GXutil.trim( GXutil.str( AV46TFEmpLicDLim_To, 3, 0))) ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICDSEMAN", httpContext.getMessage( "Cantidad de días permitidos por semana", ""), !((0==AV47TFEmpLicDSeman)&&(0==AV48TFEmpLicDSeman_To)), (short)(0), GXutil.trim( GXutil.str( AV47TFEmpLicDSeman, 1, 0)), GXutil.trim( GXutil.str( AV48TFEmpLicDSeman_To, 1, 0))) ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICDMES_SEL", httpContext.getMessage( "Cantidad de días permitidos por mes", ""), !(AV50TFEmpLicDMes_Sels.size()==0), (short)(0), AV50TFEmpLicDMes_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICDSEMES", httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), !((0==AV51TFEmpLicDSemes)&&(0==AV52TFEmpLicDSemes_To)), (short)(0), GXutil.trim( GXutil.str( AV51TFEmpLicDSemes, 3, 0)), GXutil.trim( GXutil.str( AV52TFEmpLicDSemes_To, 3, 0))) ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICDANUAL", httpContext.getMessage( "Cantidad de días permitidos por año", ""), !((0==AV53TFEmpLicDAnual)&&(0==AV54TFEmpLicDAnual_To)), (short)(0), GXutil.trim( GXutil.str( AV53TFEmpLicDAnual, 3, 0)), GXutil.trim( GXutil.str( AV54TFEmpLicDAnual_To, 3, 0))) ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICADJU_SEL", httpContext.getMessage( "Permite adjuntar documento", ""), !(0==AV55TFEmpLicAdju_Sel), (short)(0), GXutil.trim( GXutil.str( AV55TFEmpLicAdju_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICADJUOBL_SEL", httpContext.getMessage( "Obliga a adjuntar documento", ""), !(0==AV56TFEmpLicAdjuObl_Sel), (short)(0), GXutil.trim( GXutil.str( AV56TFEmpLicAdjuObl_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICNECAUT_SEL", httpContext.getMessage( "Necesita autorización", ""), !(0==AV57TFEmpLicNecAut_Sel), (short)(0), GXutil.trim( GXutil.str( AV57TFEmpLicNecAut_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICINGMOT_SEL", httpContext.getMessage( "Permite ingresar motivo", ""), !(0==AV58TFEmpLicIngMot_Sel), (short)(0), GXutil.trim( GXutil.str( AV58TFEmpLicIngMot_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPLICMOTOBL_SEL", httpContext.getMessage( "Obliga a ingresar motivo", ""), !(0==AV59TFEmpLicMotObl_Sel), (short)(0), GXutil.trim( GXutil.str( AV59TFEmpLicMotObl_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPBASEPROMCNT1", httpContext.getMessage( "Cantidad de días/meses a promediar", ""), !((0==AV62TFEmpBasePromCnt1)&&(0==AV63TFEmpBasePromCnt1_To)), (short)(0), GXutil.trim( GXutil.str( AV62TFEmpBasePromCnt1, 3, 0)), GXutil.trim( GXutil.str( AV63TFEmpBasePromCnt1_To, 3, 0))) ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPBASEPROMCNT2", httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", ""), !((0==AV64TFEmpBasePromCnt2)&&(0==AV65TFEmpBasePromCnt2_To)), (short)(0), GXutil.trim( GXutil.str( AV64TFEmpBasePromCnt2, 3, 0)), GXutil.trim( GXutil.str( AV65TFEmpBasePromCnt2_To, 3, 0))) ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      GXv_SdtWWPGridState19[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState19, "TFEMPBASEPROMTCNT_SEL", httpContext.getMessage( "Días o Meses", ""), !(AV67TFEmpBasePromTCnt_Sels.size()==0), (short)(0), AV67TFEmpBasePromTCnt_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState19[0] ;
      if ( ! (GXutil.strcmp("", AV90MenuOpcCod)==0) )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV90MenuOpcCod );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      if ( ! (0==AV8EmpBaseClaseLeg) )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&EMPBASECLASELEG" );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV8EmpBaseClaseLeg, 1, 0) );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      if ( ! (GXutil.strcmp("", AV9EmpBaseTipo)==0) )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&EMPBASETIPO" );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV9EmpBaseTipo );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      AV13GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV13GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV114Pgmname+"GridState", AV13GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV11TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV114Pgmname );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV10HTTPRequest.getScriptName()+"?"+AV10HTTPRequest.getQuerystring() );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Empresabase_calculo" );
      AV12TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpBaseClaseLeg" );
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8EmpBaseClaseLeg, 1, 0) );
      AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV12TrnContextAtt, 0);
      AV12TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpBaseTipo" );
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( AV9EmpBaseTipo );
      AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV12TrnContextAtt, 0);
      AV24Session.setValue("TrnContext", AV11TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e17KC2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV92WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean10[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV90MenuOpcCod, GXv_boolean10) ;
         GXv_char9[0] = AV94textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV79CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char9) ;
         empresabase_calculoww_impl.this.AV94textoNoMostrara = GXv_char9[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV94textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean10[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV90MenuOpcCod, GXv_boolean10) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_KC2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_KC2( true) ;
      }
      else
      {
         wb_table2_12_KC2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_KC2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_KC2e( true) ;
      }
      else
      {
         wb_table1_9_KC2e( false) ;
      }
   }

   public void wb_table2_12_KC2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e21kc1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_Empresabase_calculoWW.htm");
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
         AV98WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV98WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV113Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV98WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV98WelcomeMessage_Foto)==0) ? AV113Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV98WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV98WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Empresabase_calculoWW.htm");
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
         wb_table3_30_KC2( true) ;
      }
      else
      {
         wb_table3_30_KC2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_KC2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_KC2( true) ;
      }
      else
      {
         wb_table4_35_KC2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_KC2e( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_Empresabase_calculoWW.htm");
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
         wb_table5_54_KC2( true) ;
      }
      else
      {
         wb_table5_54_KC2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_KC2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_KC2( true) ;
      }
      else
      {
         wb_table6_63_KC2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_KC2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV70GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV71GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV72GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_KC2e( true) ;
      }
      else
      {
         wb_table2_12_KC2e( false) ;
      }
   }

   public void wb_table6_63_KC2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Empresabase_calculoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Empresabase_calculoWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV68DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV22ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV99ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Empresabase_calculoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Empresabase_calculoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Empresabase_calculoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_97_KC2( true) ;
      }
      else
      {
         wb_table7_97_KC2( false) ;
      }
      return  ;
   }

   public void wb_table7_97_KC2e( boolean wbgen )
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
         wb_table6_63_KC2e( true) ;
      }
      else
      {
         wb_table6_63_KC2e( false) ;
      }
   }

   public void wb_table7_97_KC2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_Empresabase_calculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_97_KC2e( true) ;
      }
      else
      {
         wb_table7_97_KC2e( false) ;
      }
   }

   public void wb_table5_54_KC2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_Empresabase_calculoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_Empresabase_calculoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_KC2e( true) ;
      }
      else
      {
         wb_table5_54_KC2e( false) ;
      }
   }

   public void wb_table4_35_KC2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_Empresabase_calculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_KC2e( true) ;
      }
      else
      {
         wb_table4_35_KC2e( false) ;
      }
   }

   public void wb_table3_30_KC2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_Empresabase_calculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_KC2e( true) ;
      }
      else
      {
         wb_table3_30_KC2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV90MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90MenuOpcCod", AV90MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV90MenuOpcCod, ""))));
      AV8EmpBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8EmpBaseClaseLeg", GXutil.str( AV8EmpBaseClaseLeg, 1, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpBaseClaseLeg), "9")));
      AV9EmpBaseTipo = (String)getParm(obj,2) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9EmpBaseTipo", AV9EmpBaseTipo);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9EmpBaseTipo, ""))));
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
      paKC2( ) ;
      wsKC2( ) ;
      weKC2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251316515188", true, true);
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
      httpContext.AddJavascriptSource("empresabase_calculoww.js", "?20251316515188", false, true);
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
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_108_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_108_idx ;
      edtEmpBaseCod1_Internalname = "EMPBASECOD1_"+sGXsfl_108_idx ;
      edtEmpBaseCod2_Internalname = "EMPBASECOD2_"+sGXsfl_108_idx ;
      cmbEmpBaseTipo.setInternalname( "EMPBASETIPO_"+sGXsfl_108_idx );
      cmbEmpBaseClaseLeg.setInternalname( "EMPBASECLASELEG_"+sGXsfl_108_idx );
      edtavEmpbasec1txt_Internalname = "vEMPBASEC1TXT_"+sGXsfl_108_idx ;
      edtavEmpbasec2txt_Internalname = "vEMPBASEC2TXT_"+sGXsfl_108_idx ;
      chkavDefault.setInternalname( "vDEFAULT_"+sGXsfl_108_idx );
      edtEmpBasePlus_Internalname = "EMPBASEPLUS_"+sGXsfl_108_idx ;
      edtEmpLicDMin_Internalname = "EMPLICDMIN_"+sGXsfl_108_idx ;
      edtEmpLicDLim_Internalname = "EMPLICDLIM_"+sGXsfl_108_idx ;
      edtEmpLicDSeman_Internalname = "EMPLICDSEMAN_"+sGXsfl_108_idx ;
      cmbEmpLicDMes.setInternalname( "EMPLICDMES_"+sGXsfl_108_idx );
      edtEmpLicDSemes_Internalname = "EMPLICDSEMES_"+sGXsfl_108_idx ;
      edtEmpLicDAnual_Internalname = "EMPLICDANUAL_"+sGXsfl_108_idx ;
      chkEmpLicAdju.setInternalname( "EMPLICADJU_"+sGXsfl_108_idx );
      chkEmpLicAdjuObl.setInternalname( "EMPLICADJUOBL_"+sGXsfl_108_idx );
      chkEmpLicNecAut.setInternalname( "EMPLICNECAUT_"+sGXsfl_108_idx );
      chkEmpLicIngMot.setInternalname( "EMPLICINGMOT_"+sGXsfl_108_idx );
      chkEmpLicMotObl.setInternalname( "EMPLICMOTOBL_"+sGXsfl_108_idx );
      edtEmpBaseOrd_Internalname = "EMPBASEORD_"+sGXsfl_108_idx ;
      edtEmpBasePromCnt1_Internalname = "EMPBASEPROMCNT1_"+sGXsfl_108_idx ;
      edtEmpBasePromCnt2_Internalname = "EMPBASEPROMCNT2_"+sGXsfl_108_idx ;
      cmbEmpBasePromTCnt.setInternalname( "EMPBASEPROMTCNT_"+sGXsfl_108_idx );
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_108_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_108_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_idx ;
   }

   public void subsflControlProps_fel_1082( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_108_fel_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_108_fel_idx ;
      edtEmpBaseCod1_Internalname = "EMPBASECOD1_"+sGXsfl_108_fel_idx ;
      edtEmpBaseCod2_Internalname = "EMPBASECOD2_"+sGXsfl_108_fel_idx ;
      cmbEmpBaseTipo.setInternalname( "EMPBASETIPO_"+sGXsfl_108_fel_idx );
      cmbEmpBaseClaseLeg.setInternalname( "EMPBASECLASELEG_"+sGXsfl_108_fel_idx );
      edtavEmpbasec1txt_Internalname = "vEMPBASEC1TXT_"+sGXsfl_108_fel_idx ;
      edtavEmpbasec2txt_Internalname = "vEMPBASEC2TXT_"+sGXsfl_108_fel_idx ;
      chkavDefault.setInternalname( "vDEFAULT_"+sGXsfl_108_fel_idx );
      edtEmpBasePlus_Internalname = "EMPBASEPLUS_"+sGXsfl_108_fel_idx ;
      edtEmpLicDMin_Internalname = "EMPLICDMIN_"+sGXsfl_108_fel_idx ;
      edtEmpLicDLim_Internalname = "EMPLICDLIM_"+sGXsfl_108_fel_idx ;
      edtEmpLicDSeman_Internalname = "EMPLICDSEMAN_"+sGXsfl_108_fel_idx ;
      cmbEmpLicDMes.setInternalname( "EMPLICDMES_"+sGXsfl_108_fel_idx );
      edtEmpLicDSemes_Internalname = "EMPLICDSEMES_"+sGXsfl_108_fel_idx ;
      edtEmpLicDAnual_Internalname = "EMPLICDANUAL_"+sGXsfl_108_fel_idx ;
      chkEmpLicAdju.setInternalname( "EMPLICADJU_"+sGXsfl_108_fel_idx );
      chkEmpLicAdjuObl.setInternalname( "EMPLICADJUOBL_"+sGXsfl_108_fel_idx );
      chkEmpLicNecAut.setInternalname( "EMPLICNECAUT_"+sGXsfl_108_fel_idx );
      chkEmpLicIngMot.setInternalname( "EMPLICINGMOT_"+sGXsfl_108_fel_idx );
      chkEmpLicMotObl.setInternalname( "EMPLICMOTOBL_"+sGXsfl_108_fel_idx );
      edtEmpBaseOrd_Internalname = "EMPBASEORD_"+sGXsfl_108_fel_idx ;
      edtEmpBasePromCnt1_Internalname = "EMPBASEPROMCNT1_"+sGXsfl_108_fel_idx ;
      edtEmpBasePromCnt2_Internalname = "EMPBASEPROMCNT2_"+sGXsfl_108_fel_idx ;
      cmbEmpBasePromTCnt.setInternalname( "EMPBASEPROMTCNT_"+sGXsfl_108_fel_idx );
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_fel_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_108_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_108_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_fel_idx ;
   }

   public void sendrow_1082( )
   {
      subsflControlProps_1082( ) ;
      wbKC0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpBaseCod1_Internalname,GXutil.rtrim( A1430EmpBaseCod1),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpBaseCod1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpBaseCod2_Internalname,GXutil.rtrim( A1431EmpBaseCod2),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpBaseCod2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbEmpBaseTipo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "EMPBASETIPO_" + sGXsfl_108_idx ;
            cmbEmpBaseTipo.setName( GXCCtl );
            cmbEmpBaseTipo.setWebtags( "" );
            cmbEmpBaseTipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
            cmbEmpBaseTipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
            cmbEmpBaseTipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
            if ( cmbEmpBaseTipo.getItemCount() > 0 )
            {
               A1429EmpBaseTipo = cmbEmpBaseTipo.getValidValue(A1429EmpBaseTipo) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbEmpBaseTipo,cmbEmpBaseTipo.getInternalname(),GXutil.rtrim( A1429EmpBaseTipo),Integer.valueOf(1),cmbEmpBaseTipo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbEmpBaseTipo.setValue( GXutil.rtrim( A1429EmpBaseTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseTipo.getInternalname(), "Values", cmbEmpBaseTipo.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbEmpBaseClaseLeg.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "EMPBASECLASELEG_" + sGXsfl_108_idx ;
            cmbEmpBaseClaseLeg.setName( GXCCtl );
            cmbEmpBaseClaseLeg.setWebtags( "" );
            cmbEmpBaseClaseLeg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
            cmbEmpBaseClaseLeg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
            cmbEmpBaseClaseLeg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
            cmbEmpBaseClaseLeg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
            if ( cmbEmpBaseClaseLeg.getItemCount() > 0 )
            {
               A1427EmpBaseClaseLeg = (byte)(GXutil.lval( cmbEmpBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbEmpBaseClaseLeg,cmbEmpBaseClaseLeg.getInternalname(),GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0)),Integer.valueOf(1),cmbEmpBaseClaseLeg.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbEmpBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseClaseLeg.getInternalname(), "Values", cmbEmpBaseClaseLeg.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEmpbasec1txt_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEmpbasec1txt_Internalname,AV81EmpBaseC1Txt,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavEmpbasec1txt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavEmpbasec1txt_Visible),Integer.valueOf(edtavEmpbasec1txt_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEmpbasec2txt_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEmpbasec2txt_Internalname,AV82EmpBaseC2Txt,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavEmpbasec2txt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavEmpbasec2txt_Visible),Integer.valueOf(edtavEmpbasec2txt_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkavDefault.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vDEFAULT_" + sGXsfl_108_idx ;
         chkavDefault.setName( GXCCtl );
         chkavDefault.setWebtags( "" );
         chkavDefault.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavDefault.getInternalname(), "TitleCaption", chkavDefault.getCaption(), !bGXsfl_108_Refreshing);
         chkavDefault.setCheckedValue( "false" );
         AV85Default = GXutil.strtobool( GXutil.booltostr( AV85Default)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavDefault.getInternalname(), AV85Default);
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavDefault.getInternalname(),GXutil.booltostr( AV85Default),"","",Integer.valueOf(chkavDefault.getVisible()),Integer.valueOf(chkavDefault.getEnabled()),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEmpBasePlus_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpBasePlus_Internalname,GXutil.ltrim( localUtil.ntoc( A1432EmpBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1432EmpBasePlus, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpBasePlus_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmpBasePlus_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEmpLicDMin_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpLicDMin_Internalname,GXutil.ltrim( localUtil.ntoc( A1517EmpLicDMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1517EmpLicDMin), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpLicDMin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmpLicDMin_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEmpLicDLim_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpLicDLim_Internalname,GXutil.ltrim( localUtil.ntoc( A1502EmpLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1502EmpLicDLim), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpLicDLim_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmpLicDLim_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEmpLicDSeman_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpLicDSeman_Internalname,GXutil.ltrim( localUtil.ntoc( A1503EmpLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1503EmpLicDSeman), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpLicDSeman_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmpLicDSeman_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbEmpLicDMes.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbEmpLicDMes.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "EMPLICDMES_" + sGXsfl_108_idx ;
            cmbEmpLicDMes.setName( GXCCtl );
            cmbEmpLicDMes.setWebtags( "" );
            if ( cmbEmpLicDMes.getItemCount() > 0 )
            {
               A1504EmpLicDMes = (byte)(GXutil.lval( cmbEmpLicDMes.getValidValue(GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0))))) ;
               n1504EmpLicDMes = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbEmpLicDMes,cmbEmpLicDMes.getInternalname(),GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0)),Integer.valueOf(1),cmbEmpLicDMes.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbEmpLicDMes.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbEmpLicDMes.setValue( GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpLicDMes.getInternalname(), "Values", cmbEmpLicDMes.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEmpLicDSemes_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpLicDSemes_Internalname,GXutil.ltrim( localUtil.ntoc( A1505EmpLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1505EmpLicDSemes), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpLicDSemes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmpLicDSemes_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEmpLicDAnual_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpLicDAnual_Internalname,GXutil.ltrim( localUtil.ntoc( A1506EmpLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1506EmpLicDAnual), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpLicDAnual_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmpLicDAnual_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkEmpLicAdju.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "EMPLICADJU_" + sGXsfl_108_idx ;
         chkEmpLicAdju.setName( GXCCtl );
         chkEmpLicAdju.setWebtags( "" );
         chkEmpLicAdju.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdju.getInternalname(), "TitleCaption", chkEmpLicAdju.getCaption(), !bGXsfl_108_Refreshing);
         chkEmpLicAdju.setCheckedValue( "false" );
         A1507EmpLicAdju = GXutil.strtobool( GXutil.booltostr( A1507EmpLicAdju)) ;
         n1507EmpLicAdju = false ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkEmpLicAdju.getInternalname(),GXutil.booltostr( A1507EmpLicAdju),"","",Integer.valueOf(chkEmpLicAdju.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkEmpLicAdjuObl.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "EMPLICADJUOBL_" + sGXsfl_108_idx ;
         chkEmpLicAdjuObl.setName( GXCCtl );
         chkEmpLicAdjuObl.setWebtags( "" );
         chkEmpLicAdjuObl.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdjuObl.getInternalname(), "TitleCaption", chkEmpLicAdjuObl.getCaption(), !bGXsfl_108_Refreshing);
         chkEmpLicAdjuObl.setCheckedValue( "false" );
         A1508EmpLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1508EmpLicAdjuObl)) ;
         n1508EmpLicAdjuObl = false ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkEmpLicAdjuObl.getInternalname(),GXutil.booltostr( A1508EmpLicAdjuObl),"","",Integer.valueOf(chkEmpLicAdjuObl.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkEmpLicNecAut.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "EMPLICNECAUT_" + sGXsfl_108_idx ;
         chkEmpLicNecAut.setName( GXCCtl );
         chkEmpLicNecAut.setWebtags( "" );
         chkEmpLicNecAut.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkEmpLicNecAut.getInternalname(), "TitleCaption", chkEmpLicNecAut.getCaption(), !bGXsfl_108_Refreshing);
         chkEmpLicNecAut.setCheckedValue( "false" );
         A1509EmpLicNecAut = GXutil.strtobool( GXutil.booltostr( A1509EmpLicNecAut)) ;
         n1509EmpLicNecAut = false ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkEmpLicNecAut.getInternalname(),GXutil.booltostr( A1509EmpLicNecAut),"","",Integer.valueOf(chkEmpLicNecAut.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkEmpLicIngMot.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "EMPLICINGMOT_" + sGXsfl_108_idx ;
         chkEmpLicIngMot.setName( GXCCtl );
         chkEmpLicIngMot.setWebtags( "" );
         chkEmpLicIngMot.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkEmpLicIngMot.getInternalname(), "TitleCaption", chkEmpLicIngMot.getCaption(), !bGXsfl_108_Refreshing);
         chkEmpLicIngMot.setCheckedValue( "false" );
         A1510EmpLicIngMot = GXutil.strtobool( GXutil.booltostr( A1510EmpLicIngMot)) ;
         n1510EmpLicIngMot = false ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkEmpLicIngMot.getInternalname(),GXutil.booltostr( A1510EmpLicIngMot),"","",Integer.valueOf(chkEmpLicIngMot.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkEmpLicMotObl.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "EMPLICMOTOBL_" + sGXsfl_108_idx ;
         chkEmpLicMotObl.setName( GXCCtl );
         chkEmpLicMotObl.setWebtags( "" );
         chkEmpLicMotObl.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkEmpLicMotObl.getInternalname(), "TitleCaption", chkEmpLicMotObl.getCaption(), !bGXsfl_108_Refreshing);
         chkEmpLicMotObl.setCheckedValue( "false" );
         A1511EmpLicMotObl = GXutil.strtobool( GXutil.booltostr( A1511EmpLicMotObl)) ;
         n1511EmpLicMotObl = false ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkEmpLicMotObl.getInternalname(),GXutil.booltostr( A1511EmpLicMotObl),"","",Integer.valueOf(chkEmpLicMotObl.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpBaseOrd_Internalname,GXutil.ltrim( localUtil.ntoc( A1518EmpBaseOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1518EmpBaseOrd), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpBaseOrd_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEmpBasePromCnt1_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpBasePromCnt1_Internalname,GXutil.ltrim( localUtil.ntoc( A1437EmpBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpBasePromCnt1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmpBasePromCnt1_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEmpBasePromCnt2_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpBasePromCnt2_Internalname,GXutil.ltrim( localUtil.ntoc( A1438EmpBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpBasePromCnt2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmpBasePromCnt2_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbEmpBasePromTCnt.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbEmpBasePromTCnt.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "EMPBASEPROMTCNT_" + sGXsfl_108_idx ;
            cmbEmpBasePromTCnt.setName( GXCCtl );
            cmbEmpBasePromTCnt.setWebtags( "" );
            cmbEmpBasePromTCnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
            cmbEmpBasePromTCnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
            if ( cmbEmpBasePromTCnt.getItemCount() > 0 )
            {
               A1439EmpBasePromTCnt = cmbEmpBasePromTCnt.getValidValue(A1439EmpBasePromTCnt) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbEmpBasePromTCnt,cmbEmpBasePromTCnt.getInternalname(),GXutil.rtrim( A1439EmpBasePromTCnt),Integer.valueOf(1),cmbEmpBasePromTCnt.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbEmpBasePromTCnt.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbEmpBasePromTCnt.setValue( GXutil.rtrim( A1439EmpBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBasePromTCnt.getInternalname(), "Values", cmbEmpBasePromTCnt.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV87VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV88ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV73Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV89Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesKC2( ) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavEmpbasec1txt_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( edtavEmpbasec1txt_Title) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavEmpbasec2txt_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkavDefault.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Default", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpBasePlus_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Porcentaje para plus", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpLicDMin_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad mínima de días permitidos por licencia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpLicDLim_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días permitidos por licencia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpLicDSeman_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días permitidos por semana", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbEmpLicDMes.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días permitidos por mes", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpLicDSemes_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días permitidos por semestre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpLicDAnual_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días permitidos por año", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkEmpLicAdju.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Permite adjuntar documento", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkEmpLicAdjuObl.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obliga a adjuntar documento", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkEmpLicNecAut.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Necesita autorización", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkEmpLicIngMot.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Permite ingresar motivo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkEmpLicMotObl.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obliga a ingresar motivo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpBasePromCnt1_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días/meses a promediar", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpBasePromCnt2_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbEmpBasePromTCnt.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Días o Meses", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1430EmpBaseCod1));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1431EmpBaseCod2));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1429EmpBaseTipo));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1427EmpBaseClaseLeg, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV81EmpBaseC1Txt);
         GridColumn.AddObjectProperty("Title", GXutil.rtrim( edtavEmpbasec1txt_Title));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEmpbasec1txt_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEmpbasec1txt_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV82EmpBaseC2Txt);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEmpbasec2txt_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEmpbasec2txt_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV85Default));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkavDefault.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkavDefault.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1432EmpBasePlus, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpBasePlus_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1517EmpLicDMin, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpLicDMin_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1502EmpLicDLim, (byte)(3), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpLicDLim_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1503EmpLicDSeman, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpLicDSeman_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1504EmpLicDMes, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbEmpLicDMes.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1505EmpLicDSemes, (byte)(3), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpLicDSemes_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1506EmpLicDAnual, (byte)(3), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpLicDAnual_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1507EmpLicAdju));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkEmpLicAdju.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1508EmpLicAdjuObl));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkEmpLicAdjuObl.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1509EmpLicNecAut));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkEmpLicNecAut.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1510EmpLicIngMot));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkEmpLicIngMot.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1511EmpLicMotObl));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkEmpLicMotObl.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1518EmpBaseOrd, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1437EmpBasePromCnt1, (byte)(3), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpBasePromCnt1_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1438EmpBasePromCnt2, (byte)(3), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpBasePromCnt2_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1439EmpBasePromTCnt));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbEmpBasePromTCnt.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV87VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV88ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV73Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
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
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtEmpBaseCod1_Internalname = "EMPBASECOD1" ;
      edtEmpBaseCod2_Internalname = "EMPBASECOD2" ;
      cmbEmpBaseTipo.setInternalname( "EMPBASETIPO" );
      cmbEmpBaseClaseLeg.setInternalname( "EMPBASECLASELEG" );
      edtavEmpbasec1txt_Internalname = "vEMPBASEC1TXT" ;
      edtavEmpbasec2txt_Internalname = "vEMPBASEC2TXT" ;
      chkavDefault.setInternalname( "vDEFAULT" );
      edtEmpBasePlus_Internalname = "EMPBASEPLUS" ;
      edtEmpLicDMin_Internalname = "EMPLICDMIN" ;
      edtEmpLicDLim_Internalname = "EMPLICDLIM" ;
      edtEmpLicDSeman_Internalname = "EMPLICDSEMAN" ;
      cmbEmpLicDMes.setInternalname( "EMPLICDMES" );
      edtEmpLicDSemes_Internalname = "EMPLICDSEMES" ;
      edtEmpLicDAnual_Internalname = "EMPLICDANUAL" ;
      chkEmpLicAdju.setInternalname( "EMPLICADJU" );
      chkEmpLicAdjuObl.setInternalname( "EMPLICADJUOBL" );
      chkEmpLicNecAut.setInternalname( "EMPLICNECAUT" );
      chkEmpLicIngMot.setInternalname( "EMPLICINGMOT" );
      chkEmpLicMotObl.setInternalname( "EMPLICMOTOBL" );
      edtEmpBaseOrd_Internalname = "EMPBASEORD" ;
      edtEmpBasePromCnt1_Internalname = "EMPBASEPROMCNT1" ;
      edtEmpBasePromCnt2_Internalname = "EMPBASEPROMCNT2" ;
      cmbEmpBasePromTCnt.setInternalname( "EMPBASEPROMTCNT" );
      edtavVersvg_Internalname = "vVERSVG" ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
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
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 0 ;
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
      cmbEmpBasePromTCnt.setJsonclick( "" );
      edtEmpBasePromCnt2_Jsonclick = "" ;
      edtEmpBasePromCnt1_Jsonclick = "" ;
      edtEmpBaseOrd_Jsonclick = "" ;
      chkEmpLicMotObl.setCaption( "" );
      chkEmpLicIngMot.setCaption( "" );
      chkEmpLicNecAut.setCaption( "" );
      chkEmpLicAdjuObl.setCaption( "" );
      chkEmpLicAdju.setCaption( "" );
      edtEmpLicDAnual_Jsonclick = "" ;
      edtEmpLicDSemes_Jsonclick = "" ;
      cmbEmpLicDMes.setJsonclick( "" );
      edtEmpLicDSeman_Jsonclick = "" ;
      edtEmpLicDLim_Jsonclick = "" ;
      edtEmpLicDMin_Jsonclick = "" ;
      edtEmpBasePlus_Jsonclick = "" ;
      chkavDefault.setCaption( "" );
      chkavDefault.setEnabled( 0 );
      edtavEmpbasec2txt_Jsonclick = "" ;
      edtavEmpbasec2txt_Enabled = 0 ;
      edtavEmpbasec1txt_Jsonclick = "" ;
      edtavEmpbasec1txt_Enabled = 0 ;
      cmbEmpBaseClaseLeg.setJsonclick( "" );
      cmbEmpBaseTipo.setJsonclick( "" );
      edtEmpBaseCod2_Jsonclick = "" ;
      edtEmpBaseCod1_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
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
      cmbEmpBasePromTCnt.setVisible( -1 );
      edtEmpBasePromCnt2_Visible = -1 ;
      edtEmpBasePromCnt1_Visible = -1 ;
      chkEmpLicMotObl.setVisible( -1 );
      chkEmpLicIngMot.setVisible( -1 );
      chkEmpLicNecAut.setVisible( -1 );
      chkEmpLicAdjuObl.setVisible( -1 );
      chkEmpLicAdju.setVisible( -1 );
      edtEmpLicDAnual_Visible = -1 ;
      edtEmpLicDSemes_Visible = -1 ;
      cmbEmpLicDMes.setVisible( -1 );
      edtEmpLicDSeman_Visible = -1 ;
      edtEmpLicDLim_Visible = -1 ;
      edtEmpLicDMin_Visible = -1 ;
      edtEmpBasePlus_Visible = -1 ;
      chkavDefault.setVisible( -1 );
      edtavEmpbasec2txt_Visible = -1 ;
      edtavEmpbasec1txt_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "|||6.4|2.0|3.0|1.0||3.0|3.0||||||3.0|3.0|" ;
      Ddo_grid_Datalistfixedvalues = "||||||||||1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|||dias:días,meses:meses" ;
      Ddo_grid_Allowmultipleselection = "|||||||T||||||||||T" ;
      Ddo_grid_Datalisttype = "|||||||FixedValues|||FixedValues|FixedValues|FixedValues|FixedValues|FixedValues|||FixedValues" ;
      Ddo_grid_Includedatalist = "|||||||T|||T|T|T|T|T|||T" ;
      Ddo_grid_Filterisrange = "|||T|T|T|T||T|T||||||T|T|" ;
      Ddo_grid_Filtertype = "|||Numeric|Numeric|Numeric|Numeric||Numeric|Numeric||||||Numeric|Numeric|" ;
      Ddo_grid_Includefilter = "|||T|T|T|T||T|T||||||T|T|" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "|||T|T|T|T|T|T|T|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "|||1|2|3|4|5|6|7|8|9|10|11|12|13|14|15" ;
      Ddo_grid_Columnids = "6:EmpBaseC1Txt|7:EmpBaseC2Txt|8:Default|9:EmpBasePlus|10:EmpLicDMin|11:EmpLicDLim|12:EmpLicDSeman|13:EmpLicDMes|14:EmpLicDSemes|15:EmpLicDAnual|16:EmpLicAdju|17:EmpLicAdjuObl|18:EmpLicNecAut|19:EmpLicIngMot|20:EmpLicMotObl|22:EmpBasePromCnt1|23:EmpBasePromCnt2|24:EmpBasePromTCnt" ;
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
      Form.setCaption( httpContext.getMessage( " Base de cálculo", "") );
      edtavEmpbasec1txt_Title = httpContext.getMessage( "Código 1", "") ;
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
      GXCCtl = "EMPBASETIPO_" + sGXsfl_108_idx ;
      cmbEmpBaseTipo.setName( GXCCtl );
      cmbEmpBaseTipo.setWebtags( "" );
      cmbEmpBaseTipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
      cmbEmpBaseTipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
      cmbEmpBaseTipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
      if ( cmbEmpBaseTipo.getItemCount() > 0 )
      {
         A1429EmpBaseTipo = cmbEmpBaseTipo.getValidValue(A1429EmpBaseTipo) ;
      }
      GXCCtl = "EMPBASECLASELEG_" + sGXsfl_108_idx ;
      cmbEmpBaseClaseLeg.setName( GXCCtl );
      cmbEmpBaseClaseLeg.setWebtags( "" );
      cmbEmpBaseClaseLeg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbEmpBaseClaseLeg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbEmpBaseClaseLeg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbEmpBaseClaseLeg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbEmpBaseClaseLeg.getItemCount() > 0 )
      {
         A1427EmpBaseClaseLeg = (byte)(GXutil.lval( cmbEmpBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0))))) ;
      }
      GXCCtl = "vDEFAULT_" + sGXsfl_108_idx ;
      chkavDefault.setName( GXCCtl );
      chkavDefault.setWebtags( "" );
      chkavDefault.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavDefault.getInternalname(), "TitleCaption", chkavDefault.getCaption(), !bGXsfl_108_Refreshing);
      chkavDefault.setCheckedValue( "false" );
      AV85Default = GXutil.strtobool( GXutil.booltostr( AV85Default)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavDefault.getInternalname(), AV85Default);
      GXCCtl = "EMPLICDMES_" + sGXsfl_108_idx ;
      cmbEmpLicDMes.setName( GXCCtl );
      cmbEmpLicDMes.setWebtags( "" );
      if ( cmbEmpLicDMes.getItemCount() > 0 )
      {
         A1504EmpLicDMes = (byte)(GXutil.lval( cmbEmpLicDMes.getValidValue(GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0))))) ;
         n1504EmpLicDMes = false ;
      }
      GXCCtl = "EMPLICADJU_" + sGXsfl_108_idx ;
      chkEmpLicAdju.setName( GXCCtl );
      chkEmpLicAdju.setWebtags( "" );
      chkEmpLicAdju.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdju.getInternalname(), "TitleCaption", chkEmpLicAdju.getCaption(), !bGXsfl_108_Refreshing);
      chkEmpLicAdju.setCheckedValue( "false" );
      A1507EmpLicAdju = GXutil.strtobool( GXutil.booltostr( A1507EmpLicAdju)) ;
      n1507EmpLicAdju = false ;
      GXCCtl = "EMPLICADJUOBL_" + sGXsfl_108_idx ;
      chkEmpLicAdjuObl.setName( GXCCtl );
      chkEmpLicAdjuObl.setWebtags( "" );
      chkEmpLicAdjuObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdjuObl.getInternalname(), "TitleCaption", chkEmpLicAdjuObl.getCaption(), !bGXsfl_108_Refreshing);
      chkEmpLicAdjuObl.setCheckedValue( "false" );
      A1508EmpLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1508EmpLicAdjuObl)) ;
      n1508EmpLicAdjuObl = false ;
      GXCCtl = "EMPLICNECAUT_" + sGXsfl_108_idx ;
      chkEmpLicNecAut.setName( GXCCtl );
      chkEmpLicNecAut.setWebtags( "" );
      chkEmpLicNecAut.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicNecAut.getInternalname(), "TitleCaption", chkEmpLicNecAut.getCaption(), !bGXsfl_108_Refreshing);
      chkEmpLicNecAut.setCheckedValue( "false" );
      A1509EmpLicNecAut = GXutil.strtobool( GXutil.booltostr( A1509EmpLicNecAut)) ;
      n1509EmpLicNecAut = false ;
      GXCCtl = "EMPLICINGMOT_" + sGXsfl_108_idx ;
      chkEmpLicIngMot.setName( GXCCtl );
      chkEmpLicIngMot.setWebtags( "" );
      chkEmpLicIngMot.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicIngMot.getInternalname(), "TitleCaption", chkEmpLicIngMot.getCaption(), !bGXsfl_108_Refreshing);
      chkEmpLicIngMot.setCheckedValue( "false" );
      A1510EmpLicIngMot = GXutil.strtobool( GXutil.booltostr( A1510EmpLicIngMot)) ;
      n1510EmpLicIngMot = false ;
      GXCCtl = "EMPLICMOTOBL_" + sGXsfl_108_idx ;
      chkEmpLicMotObl.setName( GXCCtl );
      chkEmpLicMotObl.setWebtags( "" );
      chkEmpLicMotObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicMotObl.getInternalname(), "TitleCaption", chkEmpLicMotObl.getCaption(), !bGXsfl_108_Refreshing);
      chkEmpLicMotObl.setCheckedValue( "false" );
      A1511EmpLicMotObl = GXutil.strtobool( GXutil.booltostr( A1511EmpLicMotObl)) ;
      n1511EmpLicMotObl = false ;
      GXCCtl = "EMPBASEPROMTCNT_" + sGXsfl_108_idx ;
      cmbEmpBasePromTCnt.setName( GXCCtl );
      cmbEmpBasePromTCnt.setWebtags( "" );
      cmbEmpBasePromTCnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
      cmbEmpBasePromTCnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbEmpBasePromTCnt.getItemCount() > 0 )
      {
         A1439EmpBasePromTCnt = cmbEmpBasePromTCnt.getValidValue(A1439EmpBasePromTCnt) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavEmpbasec1txt_Title',ctrl:'vEMPBASEC1TXT',prop:'Title'},{av:'AV80EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV115Empresabase_calculowwds_1_empbaseclaseleg',fld:'vEMPRESABASE_CALCULOWWDS_1_EMPBASECLASELEG',pic:'9'},{av:'AV116Empresabase_calculowwds_2_empbasetipo',fld:'vEMPRESABASE_CALCULOWWDS_2_EMPBASETIPO',pic:''},{av:'AV101ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV114Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV9EmpBaseTipo',fld:'vEMPBASETIPO',pic:'',hsh:true},{av:'AV8EmpBaseClaseLeg',fld:'vEMPBASECLASELEG',pic:'9',hsh:true},{av:'AV41TFEmpBasePlus',fld:'vTFEMPBASEPLUS',pic:'9.9999'},{av:'AV42TFEmpBasePlus_To',fld:'vTFEMPBASEPLUS_TO',pic:'9.9999'},{av:'AV43TFEmpLicDMin',fld:'vTFEMPLICDMIN',pic:'Z9'},{av:'AV44TFEmpLicDMin_To',fld:'vTFEMPLICDMIN_TO',pic:'Z9'},{av:'AV45TFEmpLicDLim',fld:'vTFEMPLICDLIM',pic:'ZZ9'},{av:'AV46TFEmpLicDLim_To',fld:'vTFEMPLICDLIM_TO',pic:'ZZ9'},{av:'AV47TFEmpLicDSeman',fld:'vTFEMPLICDSEMAN',pic:'9'},{av:'AV48TFEmpLicDSeman_To',fld:'vTFEMPLICDSEMAN_TO',pic:'9'},{av:'AV50TFEmpLicDMes_Sels',fld:'vTFEMPLICDMES_SELS',pic:''},{av:'AV51TFEmpLicDSemes',fld:'vTFEMPLICDSEMES',pic:'ZZ9'},{av:'AV52TFEmpLicDSemes_To',fld:'vTFEMPLICDSEMES_TO',pic:'ZZ9'},{av:'AV53TFEmpLicDAnual',fld:'vTFEMPLICDANUAL',pic:'ZZ9'},{av:'AV54TFEmpLicDAnual_To',fld:'vTFEMPLICDANUAL_TO',pic:'ZZ9'},{av:'AV55TFEmpLicAdju_Sel',fld:'vTFEMPLICADJU_SEL',pic:'9'},{av:'AV56TFEmpLicAdjuObl_Sel',fld:'vTFEMPLICADJUOBL_SEL',pic:'9'},{av:'AV57TFEmpLicNecAut_Sel',fld:'vTFEMPLICNECAUT_SEL',pic:'9'},{av:'AV58TFEmpLicIngMot_Sel',fld:'vTFEMPLICINGMOT_SEL',pic:'9'},{av:'AV59TFEmpLicMotObl_Sel',fld:'vTFEMPLICMOTOBL_SEL',pic:'9'},{av:'AV62TFEmpBasePromCnt1',fld:'vTFEMPBASEPROMCNT1',pic:'ZZ9'},{av:'AV63TFEmpBasePromCnt1_To',fld:'vTFEMPBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV64TFEmpBasePromCnt2',fld:'vTFEMPBASEPROMCNT2',pic:'ZZ9'},{av:'AV65TFEmpBasePromCnt2_To',fld:'vTFEMPBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV67TFEmpBasePromTCnt_Sels',fld:'vTFEMPBASEPROMTCNT_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV79CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV80EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV79CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV101ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavEmpbasec1txt_Visible',ctrl:'vEMPBASEC1TXT',prop:'Visible'},{av:'edtavEmpbasec2txt_Visible',ctrl:'vEMPBASEC2TXT',prop:'Visible'},{av:'chkavDefault.getVisible()',ctrl:'vDEFAULT',prop:'Visible'},{av:'edtEmpBasePlus_Visible',ctrl:'EMPBASEPLUS',prop:'Visible'},{av:'edtEmpLicDMin_Visible',ctrl:'EMPLICDMIN',prop:'Visible'},{av:'edtEmpLicDLim_Visible',ctrl:'EMPLICDLIM',prop:'Visible'},{av:'edtEmpLicDSeman_Visible',ctrl:'EMPLICDSEMAN',prop:'Visible'},{av:'cmbEmpLicDMes'},{av:'edtEmpLicDSemes_Visible',ctrl:'EMPLICDSEMES',prop:'Visible'},{av:'edtEmpLicDAnual_Visible',ctrl:'EMPLICDANUAL',prop:'Visible'},{av:'chkEmpLicAdju.getVisible()',ctrl:'EMPLICADJU',prop:'Visible'},{av:'chkEmpLicAdjuObl.getVisible()',ctrl:'EMPLICADJUOBL',prop:'Visible'},{av:'chkEmpLicNecAut.getVisible()',ctrl:'EMPLICNECAUT',prop:'Visible'},{av:'chkEmpLicIngMot.getVisible()',ctrl:'EMPLICINGMOT',prop:'Visible'},{av:'chkEmpLicMotObl.getVisible()',ctrl:'EMPLICMOTOBL',prop:'Visible'},{av:'edtEmpBasePromCnt1_Visible',ctrl:'EMPBASEPROMCNT1',prop:'Visible'},{av:'edtEmpBasePromCnt2_Visible',ctrl:'EMPBASEPROMCNT2',prop:'Visible'},{av:'cmbEmpBasePromTCnt'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV70GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV71GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV72GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV99ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV43TFEmpLicDMin',fld:'vTFEMPLICDMIN',pic:'Z9'},{av:'AV44TFEmpLicDMin_To',fld:'vTFEMPLICDMIN_TO',pic:'Z9'},{av:'AV45TFEmpLicDLim',fld:'vTFEMPLICDLIM',pic:'ZZ9'},{av:'AV46TFEmpLicDLim_To',fld:'vTFEMPLICDLIM_TO',pic:'ZZ9'},{av:'AV47TFEmpLicDSeman',fld:'vTFEMPLICDSEMAN',pic:'9'},{av:'AV48TFEmpLicDSeman_To',fld:'vTFEMPLICDSEMAN_TO',pic:'9'},{av:'AV50TFEmpLicDMes_Sels',fld:'vTFEMPLICDMES_SELS',pic:''},{av:'AV51TFEmpLicDSemes',fld:'vTFEMPLICDSEMES',pic:'ZZ9'},{av:'AV52TFEmpLicDSemes_To',fld:'vTFEMPLICDSEMES_TO',pic:'ZZ9'},{av:'AV53TFEmpLicDAnual',fld:'vTFEMPLICDANUAL',pic:'ZZ9'},{av:'AV54TFEmpLicDAnual_To',fld:'vTFEMPLICDANUAL_TO',pic:'ZZ9'},{av:'AV55TFEmpLicAdju_Sel',fld:'vTFEMPLICADJU_SEL',pic:'9'},{av:'AV56TFEmpLicAdjuObl_Sel',fld:'vTFEMPLICADJUOBL_SEL',pic:'9'},{av:'AV57TFEmpLicNecAut_Sel',fld:'vTFEMPLICNECAUT_SEL',pic:'9'},{av:'AV58TFEmpLicIngMot_Sel',fld:'vTFEMPLICINGMOT_SEL',pic:'9'},{av:'AV59TFEmpLicMotObl_Sel',fld:'vTFEMPLICMOTOBL_SEL',pic:'9'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13KC2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV101ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV114Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV9EmpBaseTipo',fld:'vEMPBASETIPO',pic:'',hsh:true},{av:'AV8EmpBaseClaseLeg',fld:'vEMPBASECLASELEG',pic:'9',hsh:true},{av:'AV41TFEmpBasePlus',fld:'vTFEMPBASEPLUS',pic:'9.9999'},{av:'AV42TFEmpBasePlus_To',fld:'vTFEMPBASEPLUS_TO',pic:'9.9999'},{av:'AV43TFEmpLicDMin',fld:'vTFEMPLICDMIN',pic:'Z9'},{av:'AV44TFEmpLicDMin_To',fld:'vTFEMPLICDMIN_TO',pic:'Z9'},{av:'AV45TFEmpLicDLim',fld:'vTFEMPLICDLIM',pic:'ZZ9'},{av:'AV46TFEmpLicDLim_To',fld:'vTFEMPLICDLIM_TO',pic:'ZZ9'},{av:'AV47TFEmpLicDSeman',fld:'vTFEMPLICDSEMAN',pic:'9'},{av:'AV48TFEmpLicDSeman_To',fld:'vTFEMPLICDSEMAN_TO',pic:'9'},{av:'AV50TFEmpLicDMes_Sels',fld:'vTFEMPLICDMES_SELS',pic:''},{av:'AV51TFEmpLicDSemes',fld:'vTFEMPLICDSEMES',pic:'ZZ9'},{av:'AV52TFEmpLicDSemes_To',fld:'vTFEMPLICDSEMES_TO',pic:'ZZ9'},{av:'AV53TFEmpLicDAnual',fld:'vTFEMPLICDANUAL',pic:'ZZ9'},{av:'AV54TFEmpLicDAnual_To',fld:'vTFEMPLICDANUAL_TO',pic:'ZZ9'},{av:'AV55TFEmpLicAdju_Sel',fld:'vTFEMPLICADJU_SEL',pic:'9'},{av:'AV56TFEmpLicAdjuObl_Sel',fld:'vTFEMPLICADJUOBL_SEL',pic:'9'},{av:'AV57TFEmpLicNecAut_Sel',fld:'vTFEMPLICNECAUT_SEL',pic:'9'},{av:'AV58TFEmpLicIngMot_Sel',fld:'vTFEMPLICINGMOT_SEL',pic:'9'},{av:'AV59TFEmpLicMotObl_Sel',fld:'vTFEMPLICMOTOBL_SEL',pic:'9'},{av:'AV62TFEmpBasePromCnt1',fld:'vTFEMPBASEPROMCNT1',pic:'ZZ9'},{av:'AV63TFEmpBasePromCnt1_To',fld:'vTFEMPBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV64TFEmpBasePromCnt2',fld:'vTFEMPBASEPROMCNT2',pic:'ZZ9'},{av:'AV65TFEmpBasePromCnt2_To',fld:'vTFEMPBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV67TFEmpBasePromTCnt_Sels',fld:'vTFEMPBASEPROMTCNT_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV79CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'edtavEmpbasec1txt_Title',ctrl:'vEMPBASEC1TXT',prop:'Title'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV80EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV115Empresabase_calculowwds_1_empbaseclaseleg',fld:'vEMPRESABASE_CALCULOWWDS_1_EMPBASECLASELEG',pic:'9'},{av:'AV116Empresabase_calculowwds_2_empbasetipo',fld:'vEMPRESABASE_CALCULOWWDS_2_EMPBASETIPO',pic:''},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14KC2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV101ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV114Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV9EmpBaseTipo',fld:'vEMPBASETIPO',pic:'',hsh:true},{av:'AV8EmpBaseClaseLeg',fld:'vEMPBASECLASELEG',pic:'9',hsh:true},{av:'AV41TFEmpBasePlus',fld:'vTFEMPBASEPLUS',pic:'9.9999'},{av:'AV42TFEmpBasePlus_To',fld:'vTFEMPBASEPLUS_TO',pic:'9.9999'},{av:'AV43TFEmpLicDMin',fld:'vTFEMPLICDMIN',pic:'Z9'},{av:'AV44TFEmpLicDMin_To',fld:'vTFEMPLICDMIN_TO',pic:'Z9'},{av:'AV45TFEmpLicDLim',fld:'vTFEMPLICDLIM',pic:'ZZ9'},{av:'AV46TFEmpLicDLim_To',fld:'vTFEMPLICDLIM_TO',pic:'ZZ9'},{av:'AV47TFEmpLicDSeman',fld:'vTFEMPLICDSEMAN',pic:'9'},{av:'AV48TFEmpLicDSeman_To',fld:'vTFEMPLICDSEMAN_TO',pic:'9'},{av:'AV50TFEmpLicDMes_Sels',fld:'vTFEMPLICDMES_SELS',pic:''},{av:'AV51TFEmpLicDSemes',fld:'vTFEMPLICDSEMES',pic:'ZZ9'},{av:'AV52TFEmpLicDSemes_To',fld:'vTFEMPLICDSEMES_TO',pic:'ZZ9'},{av:'AV53TFEmpLicDAnual',fld:'vTFEMPLICDANUAL',pic:'ZZ9'},{av:'AV54TFEmpLicDAnual_To',fld:'vTFEMPLICDANUAL_TO',pic:'ZZ9'},{av:'AV55TFEmpLicAdju_Sel',fld:'vTFEMPLICADJU_SEL',pic:'9'},{av:'AV56TFEmpLicAdjuObl_Sel',fld:'vTFEMPLICADJUOBL_SEL',pic:'9'},{av:'AV57TFEmpLicNecAut_Sel',fld:'vTFEMPLICNECAUT_SEL',pic:'9'},{av:'AV58TFEmpLicIngMot_Sel',fld:'vTFEMPLICINGMOT_SEL',pic:'9'},{av:'AV59TFEmpLicMotObl_Sel',fld:'vTFEMPLICMOTOBL_SEL',pic:'9'},{av:'AV62TFEmpBasePromCnt1',fld:'vTFEMPBASEPROMCNT1',pic:'ZZ9'},{av:'AV63TFEmpBasePromCnt1_To',fld:'vTFEMPBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV64TFEmpBasePromCnt2',fld:'vTFEMPBASEPROMCNT2',pic:'ZZ9'},{av:'AV65TFEmpBasePromCnt2_To',fld:'vTFEMPBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV67TFEmpBasePromTCnt_Sels',fld:'vTFEMPBASEPROMTCNT_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV79CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'edtavEmpbasec1txt_Title',ctrl:'vEMPBASEC1TXT',prop:'Title'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV80EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV115Empresabase_calculowwds_1_empbaseclaseleg',fld:'vEMPRESABASE_CALCULOWWDS_1_EMPBASECLASELEG',pic:'9'},{av:'AV116Empresabase_calculowwds_2_empbasetipo',fld:'vEMPRESABASE_CALCULOWWDS_2_EMPBASETIPO',pic:''},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15KC2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV101ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV114Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV9EmpBaseTipo',fld:'vEMPBASETIPO',pic:'',hsh:true},{av:'AV8EmpBaseClaseLeg',fld:'vEMPBASECLASELEG',pic:'9',hsh:true},{av:'AV41TFEmpBasePlus',fld:'vTFEMPBASEPLUS',pic:'9.9999'},{av:'AV42TFEmpBasePlus_To',fld:'vTFEMPBASEPLUS_TO',pic:'9.9999'},{av:'AV43TFEmpLicDMin',fld:'vTFEMPLICDMIN',pic:'Z9'},{av:'AV44TFEmpLicDMin_To',fld:'vTFEMPLICDMIN_TO',pic:'Z9'},{av:'AV45TFEmpLicDLim',fld:'vTFEMPLICDLIM',pic:'ZZ9'},{av:'AV46TFEmpLicDLim_To',fld:'vTFEMPLICDLIM_TO',pic:'ZZ9'},{av:'AV47TFEmpLicDSeman',fld:'vTFEMPLICDSEMAN',pic:'9'},{av:'AV48TFEmpLicDSeman_To',fld:'vTFEMPLICDSEMAN_TO',pic:'9'},{av:'AV50TFEmpLicDMes_Sels',fld:'vTFEMPLICDMES_SELS',pic:''},{av:'AV51TFEmpLicDSemes',fld:'vTFEMPLICDSEMES',pic:'ZZ9'},{av:'AV52TFEmpLicDSemes_To',fld:'vTFEMPLICDSEMES_TO',pic:'ZZ9'},{av:'AV53TFEmpLicDAnual',fld:'vTFEMPLICDANUAL',pic:'ZZ9'},{av:'AV54TFEmpLicDAnual_To',fld:'vTFEMPLICDANUAL_TO',pic:'ZZ9'},{av:'AV55TFEmpLicAdju_Sel',fld:'vTFEMPLICADJU_SEL',pic:'9'},{av:'AV56TFEmpLicAdjuObl_Sel',fld:'vTFEMPLICADJUOBL_SEL',pic:'9'},{av:'AV57TFEmpLicNecAut_Sel',fld:'vTFEMPLICNECAUT_SEL',pic:'9'},{av:'AV58TFEmpLicIngMot_Sel',fld:'vTFEMPLICINGMOT_SEL',pic:'9'},{av:'AV59TFEmpLicMotObl_Sel',fld:'vTFEMPLICMOTOBL_SEL',pic:'9'},{av:'AV62TFEmpBasePromCnt1',fld:'vTFEMPBASEPROMCNT1',pic:'ZZ9'},{av:'AV63TFEmpBasePromCnt1_To',fld:'vTFEMPBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV64TFEmpBasePromCnt2',fld:'vTFEMPBASEPROMCNT2',pic:'ZZ9'},{av:'AV65TFEmpBasePromCnt2_To',fld:'vTFEMPBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV67TFEmpBasePromTCnt_Sels',fld:'vTFEMPBASEPROMTCNT_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV79CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'edtavEmpbasec1txt_Title',ctrl:'vEMPBASEC1TXT',prop:'Title'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV80EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV115Empresabase_calculowwds_1_empbaseclaseleg',fld:'vEMPRESABASE_CALCULOWWDS_1_EMPBASECLASELEG',pic:'9'},{av:'AV116Empresabase_calculowwds_2_empbasetipo',fld:'vEMPRESABASE_CALCULOWWDS_2_EMPBASETIPO',pic:''},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV66TFEmpBasePromTCnt_SelsJson',fld:'vTFEMPBASEPROMTCNT_SELSJSON',pic:''},{av:'AV67TFEmpBasePromTCnt_Sels',fld:'vTFEMPBASEPROMTCNT_SELS',pic:''},{av:'AV64TFEmpBasePromCnt2',fld:'vTFEMPBASEPROMCNT2',pic:'ZZ9'},{av:'AV65TFEmpBasePromCnt2_To',fld:'vTFEMPBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV62TFEmpBasePromCnt1',fld:'vTFEMPBASEPROMCNT1',pic:'ZZ9'},{av:'AV63TFEmpBasePromCnt1_To',fld:'vTFEMPBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV59TFEmpLicMotObl_Sel',fld:'vTFEMPLICMOTOBL_SEL',pic:'9'},{av:'AV58TFEmpLicIngMot_Sel',fld:'vTFEMPLICINGMOT_SEL',pic:'9'},{av:'AV57TFEmpLicNecAut_Sel',fld:'vTFEMPLICNECAUT_SEL',pic:'9'},{av:'AV56TFEmpLicAdjuObl_Sel',fld:'vTFEMPLICADJUOBL_SEL',pic:'9'},{av:'AV55TFEmpLicAdju_Sel',fld:'vTFEMPLICADJU_SEL',pic:'9'},{av:'AV53TFEmpLicDAnual',fld:'vTFEMPLICDANUAL',pic:'ZZ9'},{av:'AV54TFEmpLicDAnual_To',fld:'vTFEMPLICDANUAL_TO',pic:'ZZ9'},{av:'AV51TFEmpLicDSemes',fld:'vTFEMPLICDSEMES',pic:'ZZ9'},{av:'AV52TFEmpLicDSemes_To',fld:'vTFEMPLICDSEMES_TO',pic:'ZZ9'},{av:'AV49TFEmpLicDMes_SelsJson',fld:'vTFEMPLICDMES_SELSJSON',pic:''},{av:'AV50TFEmpLicDMes_Sels',fld:'vTFEMPLICDMES_SELS',pic:''},{av:'AV47TFEmpLicDSeman',fld:'vTFEMPLICDSEMAN',pic:'9'},{av:'AV48TFEmpLicDSeman_To',fld:'vTFEMPLICDSEMAN_TO',pic:'9'},{av:'AV45TFEmpLicDLim',fld:'vTFEMPLICDLIM',pic:'ZZ9'},{av:'AV46TFEmpLicDLim_To',fld:'vTFEMPLICDLIM_TO',pic:'ZZ9'},{av:'AV43TFEmpLicDMin',fld:'vTFEMPLICDMIN',pic:'Z9'},{av:'AV44TFEmpLicDMin_To',fld:'vTFEMPLICDMIN_TO',pic:'Z9'},{av:'AV41TFEmpBasePlus',fld:'vTFEMPBASEPLUS',pic:'9.9999'},{av:'AV42TFEmpBasePlus_To',fld:'vTFEMPBASEPLUS_TO',pic:'9.9999'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e20KC2',iparms:[{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'cmbEmpBaseClaseLeg'},{av:'A1427EmpBaseClaseLeg',fld:'EMPBASECLASELEG',pic:'9'},{av:'cmbEmpBaseTipo'},{av:'A1429EmpBaseTipo',fld:'EMPBASETIPO',pic:''},{av:'A1430EmpBaseCod1',fld:'EMPBASECOD1',pic:''},{av:'A1431EmpBaseCod2',fld:'EMPBASECOD2',pic:''},{av:'AV114Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV86PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'A1432EmpBasePlus',fld:'EMPBASEPLUS',pic:'9.9999'},{av:'A1502EmpLicDLim',fld:'EMPLICDLIM',pic:'ZZ9'},{av:'A1503EmpLicDSeman',fld:'EMPLICDSEMAN',pic:'9'},{av:'cmbEmpLicDMes'},{av:'A1504EmpLicDMes',fld:'EMPLICDMES',pic:'Z9'},{av:'A1505EmpLicDSemes',fld:'EMPLICDSEMES',pic:'ZZ9'},{av:'A1506EmpLicDAnual',fld:'EMPLICDANUAL',pic:'ZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''},{av:'A1437EmpBasePromCnt1',fld:'EMPBASEPROMCNT1',pic:'ZZ9'},{av:'A1438EmpBasePromCnt2',fld:'EMPBASEPROMCNT2',pic:'ZZ9'},{av:'cmbEmpBasePromTCnt'},{av:'A1439EmpBasePromTCnt',fld:'EMPBASEPROMTCNT',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV73Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV89Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV81EmpBaseC1Txt',fld:'vEMPBASEC1TXT',pic:''},{av:'AV82EmpBaseC2Txt',fld:'vEMPBASEC2TXT',pic:''},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV87VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV88ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV85Default',fld:'vDEFAULT',pic:''}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11KC2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV101ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV114Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV9EmpBaseTipo',fld:'vEMPBASETIPO',pic:'',hsh:true},{av:'AV8EmpBaseClaseLeg',fld:'vEMPBASECLASELEG',pic:'9',hsh:true},{av:'AV41TFEmpBasePlus',fld:'vTFEMPBASEPLUS',pic:'9.9999'},{av:'AV42TFEmpBasePlus_To',fld:'vTFEMPBASEPLUS_TO',pic:'9.9999'},{av:'AV43TFEmpLicDMin',fld:'vTFEMPLICDMIN',pic:'Z9'},{av:'AV44TFEmpLicDMin_To',fld:'vTFEMPLICDMIN_TO',pic:'Z9'},{av:'AV45TFEmpLicDLim',fld:'vTFEMPLICDLIM',pic:'ZZ9'},{av:'AV46TFEmpLicDLim_To',fld:'vTFEMPLICDLIM_TO',pic:'ZZ9'},{av:'AV47TFEmpLicDSeman',fld:'vTFEMPLICDSEMAN',pic:'9'},{av:'AV48TFEmpLicDSeman_To',fld:'vTFEMPLICDSEMAN_TO',pic:'9'},{av:'AV50TFEmpLicDMes_Sels',fld:'vTFEMPLICDMES_SELS',pic:''},{av:'AV51TFEmpLicDSemes',fld:'vTFEMPLICDSEMES',pic:'ZZ9'},{av:'AV52TFEmpLicDSemes_To',fld:'vTFEMPLICDSEMES_TO',pic:'ZZ9'},{av:'AV53TFEmpLicDAnual',fld:'vTFEMPLICDANUAL',pic:'ZZ9'},{av:'AV54TFEmpLicDAnual_To',fld:'vTFEMPLICDANUAL_TO',pic:'ZZ9'},{av:'AV55TFEmpLicAdju_Sel',fld:'vTFEMPLICADJU_SEL',pic:'9'},{av:'AV56TFEmpLicAdjuObl_Sel',fld:'vTFEMPLICADJUOBL_SEL',pic:'9'},{av:'AV57TFEmpLicNecAut_Sel',fld:'vTFEMPLICNECAUT_SEL',pic:'9'},{av:'AV58TFEmpLicIngMot_Sel',fld:'vTFEMPLICINGMOT_SEL',pic:'9'},{av:'AV59TFEmpLicMotObl_Sel',fld:'vTFEMPLICMOTOBL_SEL',pic:'9'},{av:'AV62TFEmpBasePromCnt1',fld:'vTFEMPBASEPROMCNT1',pic:'ZZ9'},{av:'AV63TFEmpBasePromCnt1_To',fld:'vTFEMPBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV64TFEmpBasePromCnt2',fld:'vTFEMPBASEPROMCNT2',pic:'ZZ9'},{av:'AV65TFEmpBasePromCnt2_To',fld:'vTFEMPBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV67TFEmpBasePromTCnt_Sels',fld:'vTFEMPBASEPROMTCNT_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV79CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'edtavEmpbasec1txt_Title',ctrl:'vEMPBASEC1TXT',prop:'Title'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV80EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV115Empresabase_calculowwds_1_empbaseclaseleg',fld:'vEMPRESABASE_CALCULOWWDS_1_EMPBASECLASELEG',pic:'9'},{av:'AV116Empresabase_calculowwds_2_empbasetipo',fld:'vEMPRESABASE_CALCULOWWDS_2_EMPBASETIPO',pic:''},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV80EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV79CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV101ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtavEmpbasec1txt_Visible',ctrl:'vEMPBASEC1TXT',prop:'Visible'},{av:'edtavEmpbasec2txt_Visible',ctrl:'vEMPBASEC2TXT',prop:'Visible'},{av:'chkavDefault.getVisible()',ctrl:'vDEFAULT',prop:'Visible'},{av:'edtEmpBasePlus_Visible',ctrl:'EMPBASEPLUS',prop:'Visible'},{av:'edtEmpLicDMin_Visible',ctrl:'EMPLICDMIN',prop:'Visible'},{av:'edtEmpLicDLim_Visible',ctrl:'EMPLICDLIM',prop:'Visible'},{av:'edtEmpLicDSeman_Visible',ctrl:'EMPLICDSEMAN',prop:'Visible'},{av:'cmbEmpLicDMes'},{av:'edtEmpLicDSemes_Visible',ctrl:'EMPLICDSEMES',prop:'Visible'},{av:'edtEmpLicDAnual_Visible',ctrl:'EMPLICDANUAL',prop:'Visible'},{av:'chkEmpLicAdju.getVisible()',ctrl:'EMPLICADJU',prop:'Visible'},{av:'chkEmpLicAdjuObl.getVisible()',ctrl:'EMPLICADJUOBL',prop:'Visible'},{av:'chkEmpLicNecAut.getVisible()',ctrl:'EMPLICNECAUT',prop:'Visible'},{av:'chkEmpLicIngMot.getVisible()',ctrl:'EMPLICINGMOT',prop:'Visible'},{av:'chkEmpLicMotObl.getVisible()',ctrl:'EMPLICMOTOBL',prop:'Visible'},{av:'edtEmpBasePromCnt1_Visible',ctrl:'EMPBASEPROMCNT1',prop:'Visible'},{av:'edtEmpBasePromCnt2_Visible',ctrl:'EMPBASEPROMCNT2',prop:'Visible'},{av:'cmbEmpBasePromTCnt'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV70GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV71GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV72GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV99ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV43TFEmpLicDMin',fld:'vTFEMPLICDMIN',pic:'Z9'},{av:'AV44TFEmpLicDMin_To',fld:'vTFEMPLICDMIN_TO',pic:'Z9'},{av:'AV45TFEmpLicDLim',fld:'vTFEMPLICDLIM',pic:'ZZ9'},{av:'AV46TFEmpLicDLim_To',fld:'vTFEMPLICDLIM_TO',pic:'ZZ9'},{av:'AV47TFEmpLicDSeman',fld:'vTFEMPLICDSEMAN',pic:'9'},{av:'AV48TFEmpLicDSeman_To',fld:'vTFEMPLICDSEMAN_TO',pic:'9'},{av:'AV50TFEmpLicDMes_Sels',fld:'vTFEMPLICDMES_SELS',pic:''},{av:'AV51TFEmpLicDSemes',fld:'vTFEMPLICDSEMES',pic:'ZZ9'},{av:'AV52TFEmpLicDSemes_To',fld:'vTFEMPLICDSEMES_TO',pic:'ZZ9'},{av:'AV53TFEmpLicDAnual',fld:'vTFEMPLICDANUAL',pic:'ZZ9'},{av:'AV54TFEmpLicDAnual_To',fld:'vTFEMPLICDANUAL_TO',pic:'ZZ9'},{av:'AV55TFEmpLicAdju_Sel',fld:'vTFEMPLICADJU_SEL',pic:'9'},{av:'AV56TFEmpLicAdjuObl_Sel',fld:'vTFEMPLICADJUOBL_SEL',pic:'9'},{av:'AV57TFEmpLicNecAut_Sel',fld:'vTFEMPLICNECAUT_SEL',pic:'9'},{av:'AV58TFEmpLicIngMot_Sel',fld:'vTFEMPLICINGMOT_SEL',pic:'9'},{av:'AV59TFEmpLicMotObl_Sel',fld:'vTFEMPLICMOTOBL_SEL',pic:'9'}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12KC2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV101ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV114Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV9EmpBaseTipo',fld:'vEMPBASETIPO',pic:'',hsh:true},{av:'AV8EmpBaseClaseLeg',fld:'vEMPBASECLASELEG',pic:'9',hsh:true},{av:'AV41TFEmpBasePlus',fld:'vTFEMPBASEPLUS',pic:'9.9999'},{av:'AV42TFEmpBasePlus_To',fld:'vTFEMPBASEPLUS_TO',pic:'9.9999'},{av:'AV43TFEmpLicDMin',fld:'vTFEMPLICDMIN',pic:'Z9'},{av:'AV44TFEmpLicDMin_To',fld:'vTFEMPLICDMIN_TO',pic:'Z9'},{av:'AV45TFEmpLicDLim',fld:'vTFEMPLICDLIM',pic:'ZZ9'},{av:'AV46TFEmpLicDLim_To',fld:'vTFEMPLICDLIM_TO',pic:'ZZ9'},{av:'AV47TFEmpLicDSeman',fld:'vTFEMPLICDSEMAN',pic:'9'},{av:'AV48TFEmpLicDSeman_To',fld:'vTFEMPLICDSEMAN_TO',pic:'9'},{av:'AV50TFEmpLicDMes_Sels',fld:'vTFEMPLICDMES_SELS',pic:''},{av:'AV51TFEmpLicDSemes',fld:'vTFEMPLICDSEMES',pic:'ZZ9'},{av:'AV52TFEmpLicDSemes_To',fld:'vTFEMPLICDSEMES_TO',pic:'ZZ9'},{av:'AV53TFEmpLicDAnual',fld:'vTFEMPLICDANUAL',pic:'ZZ9'},{av:'AV54TFEmpLicDAnual_To',fld:'vTFEMPLICDANUAL_TO',pic:'ZZ9'},{av:'AV55TFEmpLicAdju_Sel',fld:'vTFEMPLICADJU_SEL',pic:'9'},{av:'AV56TFEmpLicAdjuObl_Sel',fld:'vTFEMPLICADJUOBL_SEL',pic:'9'},{av:'AV57TFEmpLicNecAut_Sel',fld:'vTFEMPLICNECAUT_SEL',pic:'9'},{av:'AV58TFEmpLicIngMot_Sel',fld:'vTFEMPLICINGMOT_SEL',pic:'9'},{av:'AV59TFEmpLicMotObl_Sel',fld:'vTFEMPLICMOTOBL_SEL',pic:'9'},{av:'AV62TFEmpBasePromCnt1',fld:'vTFEMPBASEPROMCNT1',pic:'ZZ9'},{av:'AV63TFEmpBasePromCnt1_To',fld:'vTFEMPBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV64TFEmpBasePromCnt2',fld:'vTFEMPBASEPROMCNT2',pic:'ZZ9'},{av:'AV65TFEmpBasePromCnt2_To',fld:'vTFEMPBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV67TFEmpBasePromTCnt_Sels',fld:'vTFEMPBASEPROMTCNT_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV79CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'edtavEmpbasec1txt_Title',ctrl:'vEMPBASEC1TXT',prop:'Title'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV80EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV115Empresabase_calculowwds_1_empbaseclaseleg',fld:'vEMPRESABASE_CALCULOWWDS_1_EMPBASECLASELEG',pic:'9'},{av:'AV116Empresabase_calculowwds_2_empbasetipo',fld:'vEMPRESABASE_CALCULOWWDS_2_EMPBASETIPO',pic:''},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV49TFEmpLicDMes_SelsJson',fld:'vTFEMPLICDMES_SELSJSON',pic:''},{av:'AV66TFEmpBasePromTCnt_SelsJson',fld:'vTFEMPBASEPROMTCNT_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV101ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41TFEmpBasePlus',fld:'vTFEMPBASEPLUS',pic:'9.9999'},{av:'AV42TFEmpBasePlus_To',fld:'vTFEMPBASEPLUS_TO',pic:'9.9999'},{av:'AV43TFEmpLicDMin',fld:'vTFEMPLICDMIN',pic:'Z9'},{av:'AV44TFEmpLicDMin_To',fld:'vTFEMPLICDMIN_TO',pic:'Z9'},{av:'AV45TFEmpLicDLim',fld:'vTFEMPLICDLIM',pic:'ZZ9'},{av:'AV46TFEmpLicDLim_To',fld:'vTFEMPLICDLIM_TO',pic:'ZZ9'},{av:'AV47TFEmpLicDSeman',fld:'vTFEMPLICDSEMAN',pic:'9'},{av:'AV48TFEmpLicDSeman_To',fld:'vTFEMPLICDSEMAN_TO',pic:'9'},{av:'AV50TFEmpLicDMes_Sels',fld:'vTFEMPLICDMES_SELS',pic:''},{av:'AV51TFEmpLicDSemes',fld:'vTFEMPLICDSEMES',pic:'ZZ9'},{av:'AV52TFEmpLicDSemes_To',fld:'vTFEMPLICDSEMES_TO',pic:'ZZ9'},{av:'AV53TFEmpLicDAnual',fld:'vTFEMPLICDANUAL',pic:'ZZ9'},{av:'AV54TFEmpLicDAnual_To',fld:'vTFEMPLICDANUAL_TO',pic:'ZZ9'},{av:'AV55TFEmpLicAdju_Sel',fld:'vTFEMPLICADJU_SEL',pic:'9'},{av:'AV56TFEmpLicAdjuObl_Sel',fld:'vTFEMPLICADJUOBL_SEL',pic:'9'},{av:'AV57TFEmpLicNecAut_Sel',fld:'vTFEMPLICNECAUT_SEL',pic:'9'},{av:'AV58TFEmpLicIngMot_Sel',fld:'vTFEMPLICINGMOT_SEL',pic:'9'},{av:'AV59TFEmpLicMotObl_Sel',fld:'vTFEMPLICMOTOBL_SEL',pic:'9'},{av:'AV62TFEmpBasePromCnt1',fld:'vTFEMPBASEPROMCNT1',pic:'ZZ9'},{av:'AV63TFEmpBasePromCnt1_To',fld:'vTFEMPBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV64TFEmpBasePromCnt2',fld:'vTFEMPBASEPROMCNT2',pic:'ZZ9'},{av:'AV65TFEmpBasePromCnt2_To',fld:'vTFEMPBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV67TFEmpBasePromTCnt_Sels',fld:'vTFEMPBASEPROMTCNT_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV66TFEmpBasePromTCnt_SelsJson',fld:'vTFEMPBASEPROMTCNT_SELSJSON',pic:''},{av:'AV49TFEmpLicDMes_SelsJson',fld:'vTFEMPLICDMES_SELSJSON',pic:''},{av:'AV80EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV79CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavEmpbasec1txt_Visible',ctrl:'vEMPBASEC1TXT',prop:'Visible'},{av:'edtavEmpbasec2txt_Visible',ctrl:'vEMPBASEC2TXT',prop:'Visible'},{av:'chkavDefault.getVisible()',ctrl:'vDEFAULT',prop:'Visible'},{av:'edtEmpBasePlus_Visible',ctrl:'EMPBASEPLUS',prop:'Visible'},{av:'edtEmpLicDMin_Visible',ctrl:'EMPLICDMIN',prop:'Visible'},{av:'edtEmpLicDLim_Visible',ctrl:'EMPLICDLIM',prop:'Visible'},{av:'edtEmpLicDSeman_Visible',ctrl:'EMPLICDSEMAN',prop:'Visible'},{av:'cmbEmpLicDMes'},{av:'edtEmpLicDSemes_Visible',ctrl:'EMPLICDSEMES',prop:'Visible'},{av:'edtEmpLicDAnual_Visible',ctrl:'EMPLICDANUAL',prop:'Visible'},{av:'chkEmpLicAdju.getVisible()',ctrl:'EMPLICADJU',prop:'Visible'},{av:'chkEmpLicAdjuObl.getVisible()',ctrl:'EMPLICADJUOBL',prop:'Visible'},{av:'chkEmpLicNecAut.getVisible()',ctrl:'EMPLICNECAUT',prop:'Visible'},{av:'chkEmpLicIngMot.getVisible()',ctrl:'EMPLICINGMOT',prop:'Visible'},{av:'chkEmpLicMotObl.getVisible()',ctrl:'EMPLICMOTOBL',prop:'Visible'},{av:'edtEmpBasePromCnt1_Visible',ctrl:'EMPBASEPROMCNT1',prop:'Visible'},{av:'edtEmpBasePromCnt2_Visible',ctrl:'EMPBASEPROMCNT2',prop:'Visible'},{av:'cmbEmpBasePromTCnt'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV70GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV71GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV72GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV99ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOEXPORT'","{handler:'e16KC2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17KC2',iparms:[{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV79CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e21KC1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
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
      wcpOAV9EmpBaseTipo = "" ;
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
      AV9EmpBaseTipo = "" ;
      AV22ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV114Pgmname = "" ;
      AV13GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV41TFEmpBasePlus = DecimalUtil.ZERO ;
      AV42TFEmpBasePlus_To = DecimalUtil.ZERO ;
      AV50TFEmpLicDMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV67TFEmpBasePromTCnt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV116Empresabase_calculowwds_2_empbasetipo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV68DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV99ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV72GridAppliedFilters = "" ;
      AV49TFEmpLicDMes_SelsJson = "" ;
      AV66TFEmpBasePromTCnt_SelsJson = "" ;
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
      A1430EmpBaseCod1 = "" ;
      A1431EmpBaseCod2 = "" ;
      A1429EmpBaseTipo = "" ;
      AV81EmpBaseC1Txt = "" ;
      AV82EmpBaseC2Txt = "" ;
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      A1439EmpBasePromTCnt = "" ;
      AV87VerSVG = "" ;
      AV88ModificarSVG = "" ;
      AV73Update = "" ;
      AV89Display = "" ;
      AV125Empresabase_calculowwds_11_tfemplicdmes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      AV117Empresabase_calculowwds_3_tfempbaseplus = DecimalUtil.ZERO ;
      AV118Empresabase_calculowwds_4_tfempbaseplus_to = DecimalUtil.ZERO ;
      H00KC2_A1439EmpBasePromTCnt = new String[] {""} ;
      H00KC2_A1438EmpBasePromCnt2 = new short[1] ;
      H00KC2_A1437EmpBasePromCnt1 = new short[1] ;
      H00KC2_A1518EmpBaseOrd = new short[1] ;
      H00KC2_n1518EmpBaseOrd = new boolean[] {false} ;
      H00KC2_A1511EmpLicMotObl = new boolean[] {false} ;
      H00KC2_n1511EmpLicMotObl = new boolean[] {false} ;
      H00KC2_A1510EmpLicIngMot = new boolean[] {false} ;
      H00KC2_n1510EmpLicIngMot = new boolean[] {false} ;
      H00KC2_A1509EmpLicNecAut = new boolean[] {false} ;
      H00KC2_n1509EmpLicNecAut = new boolean[] {false} ;
      H00KC2_A1508EmpLicAdjuObl = new boolean[] {false} ;
      H00KC2_n1508EmpLicAdjuObl = new boolean[] {false} ;
      H00KC2_A1507EmpLicAdju = new boolean[] {false} ;
      H00KC2_n1507EmpLicAdju = new boolean[] {false} ;
      H00KC2_A1506EmpLicDAnual = new short[1] ;
      H00KC2_n1506EmpLicDAnual = new boolean[] {false} ;
      H00KC2_A1505EmpLicDSemes = new short[1] ;
      H00KC2_n1505EmpLicDSemes = new boolean[] {false} ;
      H00KC2_A1504EmpLicDMes = new byte[1] ;
      H00KC2_n1504EmpLicDMes = new boolean[] {false} ;
      H00KC2_A1503EmpLicDSeman = new byte[1] ;
      H00KC2_n1503EmpLicDSeman = new boolean[] {false} ;
      H00KC2_A1502EmpLicDLim = new short[1] ;
      H00KC2_n1502EmpLicDLim = new boolean[] {false} ;
      H00KC2_A1517EmpLicDMin = new byte[1] ;
      H00KC2_n1517EmpLicDMin = new boolean[] {false} ;
      H00KC2_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00KC2_A1427EmpBaseClaseLeg = new byte[1] ;
      H00KC2_A1429EmpBaseTipo = new String[] {""} ;
      H00KC2_A1431EmpBaseCod2 = new String[] {""} ;
      H00KC2_A1430EmpBaseCod1 = new String[] {""} ;
      H00KC2_A1EmpCod = new short[1] ;
      H00KC2_A3CliCod = new int[1] ;
      H00KC3_AGRID_nRecordCount = new long[1] ;
      AV98WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV10HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV93MenuBienveImgURL = "" ;
      GXv_char7 = new String[1] ;
      AV95MenuBienveTitulo = "" ;
      AV96MenuBienveTexto = "" ;
      AV113Welcomemessage_foto_GXI = "" ;
      GXt_char11 = "" ;
      AV110observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int4 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext13 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV24Session = httpContext.getWebSession();
      AV20ColumnsSelectorXML = "" ;
      AV106MenuOpcTitulo = "" ;
      GXv_int2 = new short[1] ;
      AV109filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV100ManageFiltersXml = "" ;
      AV18ExcelFilename = "" ;
      AV19ErrorMessage = "" ;
      GXv_char8 = new String[1] ;
      AV21UserCustomValue = "" ;
      AV23ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector15 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = new GXBaseCollection[1] ;
      AV14GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char12 = "" ;
      GXv_SdtWWPGridState19 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV94textoNoMostrara = "" ;
      GXv_char9 = new String[1] ;
      GXv_boolean10 = new boolean[1] ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresabase_calculoww__default(),
         new Object[] {
             new Object[] {
            H00KC2_A1439EmpBasePromTCnt, H00KC2_A1438EmpBasePromCnt2, H00KC2_A1437EmpBasePromCnt1, H00KC2_A1518EmpBaseOrd, H00KC2_n1518EmpBaseOrd, H00KC2_A1511EmpLicMotObl, H00KC2_n1511EmpLicMotObl, H00KC2_A1510EmpLicIngMot, H00KC2_n1510EmpLicIngMot, H00KC2_A1509EmpLicNecAut,
            H00KC2_n1509EmpLicNecAut, H00KC2_A1508EmpLicAdjuObl, H00KC2_n1508EmpLicAdjuObl, H00KC2_A1507EmpLicAdju, H00KC2_n1507EmpLicAdju, H00KC2_A1506EmpLicDAnual, H00KC2_n1506EmpLicDAnual, H00KC2_A1505EmpLicDSemes, H00KC2_n1505EmpLicDSemes, H00KC2_A1504EmpLicDMes,
            H00KC2_n1504EmpLicDMes, H00KC2_A1503EmpLicDSeman, H00KC2_n1503EmpLicDSeman, H00KC2_A1502EmpLicDLim, H00KC2_n1502EmpLicDLim, H00KC2_A1517EmpLicDMin, H00KC2_n1517EmpLicDMin, H00KC2_A1432EmpBasePlus, H00KC2_A1427EmpBaseClaseLeg, H00KC2_A1429EmpBaseTipo,
            H00KC2_A1431EmpBaseCod2, H00KC2_A1430EmpBaseCod1, H00KC2_A1EmpCod, H00KC2_A3CliCod
            }
            , new Object[] {
            H00KC3_AGRID_nRecordCount
            }
         }
      );
      AV114Pgmname = "Empresabase_calculoWW" ;
      /* GeneXus formulas. */
      AV114Pgmname = "Empresabase_calculoWW" ;
      Gx_err = (short)(0) ;
      edtavEmpbasec1txt_Enabled = 0 ;
      edtavEmpbasec2txt_Enabled = 0 ;
      chkavDefault.setEnabled( 0 );
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
   }

   private byte wcpOAV8EmpBaseClaseLeg ;
   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV8EmpBaseClaseLeg ;
   private byte AV101ManageFiltersExecutionStep ;
   private byte AV43TFEmpLicDMin ;
   private byte AV44TFEmpLicDMin_To ;
   private byte AV47TFEmpLicDSeman ;
   private byte AV48TFEmpLicDSeman_To ;
   private byte AV55TFEmpLicAdju_Sel ;
   private byte AV56TFEmpLicAdjuObl_Sel ;
   private byte AV57TFEmpLicNecAut_Sel ;
   private byte AV58TFEmpLicIngMot_Sel ;
   private byte AV59TFEmpLicMotObl_Sel ;
   private byte AV115Empresabase_calculowwds_1_empbaseclaseleg ;
   private byte gxajaxcallmode ;
   private byte A1427EmpBaseClaseLeg ;
   private byte A1517EmpLicDMin ;
   private byte A1503EmpLicDSeman ;
   private byte A1504EmpLicDMes ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV119Empresabase_calculowwds_5_tfemplicdmin ;
   private byte AV120Empresabase_calculowwds_6_tfemplicdmin_to ;
   private byte AV123Empresabase_calculowwds_9_tfemplicdseman ;
   private byte AV124Empresabase_calculowwds_10_tfemplicdseman_to ;
   private byte AV130Empresabase_calculowwds_16_tfemplicadju_sel ;
   private byte AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel ;
   private byte AV132Empresabase_calculowwds_18_tfemplicnecaut_sel ;
   private byte AV133Empresabase_calculowwds_19_tfemplicingmot_sel ;
   private byte AV134Empresabase_calculowwds_20_tfemplicmotobl_sel ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV45TFEmpLicDLim ;
   private short AV46TFEmpLicDLim_To ;
   private short AV51TFEmpLicDSemes ;
   private short AV52TFEmpLicDSemes_To ;
   private short AV53TFEmpLicDAnual ;
   private short AV54TFEmpLicDAnual_To ;
   private short AV62TFEmpBasePromCnt1 ;
   private short AV63TFEmpBasePromCnt1_To ;
   private short AV64TFEmpBasePromCnt2 ;
   private short AV65TFEmpBasePromCnt2_To ;
   private short AV15OrderedBy ;
   private short AV86PaiCod ;
   private short AV80EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short A1502EmpLicDLim ;
   private short A1505EmpLicDSemes ;
   private short A1506EmpLicDAnual ;
   private short A1518EmpBaseOrd ;
   private short A1437EmpBasePromCnt1 ;
   private short A1438EmpBasePromCnt2 ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV121Empresabase_calculowwds_7_tfemplicdlim ;
   private short AV122Empresabase_calculowwds_8_tfemplicdlim_to ;
   private short AV126Empresabase_calculowwds_12_tfemplicdsemes ;
   private short AV127Empresabase_calculowwds_13_tfemplicdsemes_to ;
   private short AV128Empresabase_calculowwds_14_tfemplicdanual ;
   private short AV129Empresabase_calculowwds_15_tfemplicdanual_to ;
   private short AV135Empresabase_calculowwds_21_tfempbasepromcnt1 ;
   private short AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to ;
   private short AV137Empresabase_calculowwds_23_tfempbasepromcnt2 ;
   private short AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_108 ;
   private int nGXsfl_108_idx=1 ;
   private int AV79CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int subGrid_Islastpage ;
   private int edtavEmpbasec1txt_Enabled ;
   private int edtavEmpbasec2txt_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDisplay_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV125Empresabase_calculowwds_11_tfemplicdmes_sels_size ;
   private int AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int edtavEmpbasec1txt_Visible ;
   private int edtavEmpbasec2txt_Visible ;
   private int edtEmpBasePlus_Visible ;
   private int edtEmpLicDMin_Visible ;
   private int edtEmpLicDLim_Visible ;
   private int edtEmpLicDSeman_Visible ;
   private int edtEmpLicDSemes_Visible ;
   private int edtEmpLicDAnual_Visible ;
   private int edtEmpBasePromCnt1_Visible ;
   private int edtEmpBasePromCnt2_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV108filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV69PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int AV140GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV70GridCurrentPage ;
   private long AV71GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV41TFEmpBasePlus ;
   private java.math.BigDecimal AV42TFEmpBasePlus_To ;
   private java.math.BigDecimal A1432EmpBasePlus ;
   private java.math.BigDecimal AV117Empresabase_calculowwds_3_tfempbaseplus ;
   private java.math.BigDecimal AV118Empresabase_calculowwds_4_tfempbaseplus_to ;
   private String wcpOAV9EmpBaseTipo ;
   private String edtavEmpbasec1txt_Title ;
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
   private String AV9EmpBaseTipo ;
   private String sGXsfl_108_idx="0001" ;
   private String edtavEmpbasec1txt_Internalname ;
   private String AV114Pgmname ;
   private String AV116Empresabase_calculowwds_2_empbasetipo ;
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
   private String edtEmpCod_Internalname ;
   private String A1430EmpBaseCod1 ;
   private String edtEmpBaseCod1_Internalname ;
   private String A1431EmpBaseCod2 ;
   private String edtEmpBaseCod2_Internalname ;
   private String A1429EmpBaseTipo ;
   private String edtavEmpbasec2txt_Internalname ;
   private String edtEmpBasePlus_Internalname ;
   private String edtEmpLicDMin_Internalname ;
   private String edtEmpLicDLim_Internalname ;
   private String edtEmpLicDSeman_Internalname ;
   private String edtEmpLicDSemes_Internalname ;
   private String edtEmpLicDAnual_Internalname ;
   private String edtEmpBaseOrd_Internalname ;
   private String edtEmpBasePromCnt1_Internalname ;
   private String edtEmpBasePromCnt2_Internalname ;
   private String A1439EmpBasePromTCnt ;
   private String AV87VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV88ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV73Update ;
   private String edtavUpdate_Internalname ;
   private String AV89Display ;
   private String edtavDisplay_Internalname ;
   private String scmdbuf ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String GXv_char7[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String GXt_char11 ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String AV110observerPalabra ;
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
   private String GXv_char8[] ;
   private String GXt_char12 ;
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
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtEmpBaseCod1_Jsonclick ;
   private String edtEmpBaseCod2_Jsonclick ;
   private String GXCCtl ;
   private String edtavEmpbasec1txt_Jsonclick ;
   private String edtavEmpbasec2txt_Jsonclick ;
   private String edtEmpBasePlus_Jsonclick ;
   private String edtEmpLicDMin_Jsonclick ;
   private String edtEmpLicDLim_Jsonclick ;
   private String edtEmpLicDSeman_Jsonclick ;
   private String edtEmpLicDSemes_Jsonclick ;
   private String edtEmpLicDAnual_Jsonclick ;
   private String edtEmpBaseOrd_Jsonclick ;
   private String edtEmpBasePromCnt1_Jsonclick ;
   private String edtEmpBasePromCnt2_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_108_Refreshing=false ;
   private boolean AV16OrderedDsc ;
   private boolean AV74IsAuthorized_Update ;
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
   private boolean AV85Default ;
   private boolean n1517EmpLicDMin ;
   private boolean n1502EmpLicDLim ;
   private boolean n1503EmpLicDSeman ;
   private boolean n1504EmpLicDMes ;
   private boolean n1505EmpLicDSemes ;
   private boolean n1506EmpLicDAnual ;
   private boolean A1507EmpLicAdju ;
   private boolean n1507EmpLicAdju ;
   private boolean A1508EmpLicAdjuObl ;
   private boolean n1508EmpLicAdjuObl ;
   private boolean A1509EmpLicNecAut ;
   private boolean n1509EmpLicNecAut ;
   private boolean A1510EmpLicIngMot ;
   private boolean n1510EmpLicIngMot ;
   private boolean A1511EmpLicMotObl ;
   private boolean n1511EmpLicMotObl ;
   private boolean n1518EmpBaseOrd ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV97MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean16 ;
   private boolean GXv_boolean10[] ;
   private boolean AV98WelcomeMessage_Foto_IsBlob ;
   private String AV49TFEmpLicDMes_SelsJson ;
   private String AV66TFEmpBasePromTCnt_SelsJson ;
   private String AV96MenuBienveTexto ;
   private String AV20ColumnsSelectorXML ;
   private String AV100ManageFiltersXml ;
   private String AV21UserCustomValue ;
   private String AV94textoNoMostrara ;
   private String wcpOAV90MenuOpcCod ;
   private String AV90MenuOpcCod ;
   private String AV72GridAppliedFilters ;
   private String AV81EmpBaseC1Txt ;
   private String AV82EmpBaseC2Txt ;
   private String AV93MenuBienveImgURL ;
   private String AV95MenuBienveTitulo ;
   private String AV113Welcomemessage_foto_GXI ;
   private String AV106MenuOpcTitulo ;
   private String AV109filtrosTexto ;
   private String AV18ExcelFilename ;
   private String AV19ErrorMessage ;
   private String AV98WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV125Empresabase_calculowwds_11_tfemplicdmes_sels ;
   private GXSimpleCollection<Byte> AV50TFEmpLicDMes_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV10HTTPRequest ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbEmpBaseTipo ;
   private HTMLChoice cmbEmpBaseClaseLeg ;
   private ICheckbox chkavDefault ;
   private HTMLChoice cmbEmpLicDMes ;
   private ICheckbox chkEmpLicAdju ;
   private ICheckbox chkEmpLicAdjuObl ;
   private ICheckbox chkEmpLicNecAut ;
   private ICheckbox chkEmpLicIngMot ;
   private ICheckbox chkEmpLicMotObl ;
   private HTMLChoice cmbEmpBasePromTCnt ;
   private IDataStoreProvider pr_default ;
   private String[] H00KC2_A1439EmpBasePromTCnt ;
   private short[] H00KC2_A1438EmpBasePromCnt2 ;
   private short[] H00KC2_A1437EmpBasePromCnt1 ;
   private short[] H00KC2_A1518EmpBaseOrd ;
   private boolean[] H00KC2_n1518EmpBaseOrd ;
   private boolean[] H00KC2_A1511EmpLicMotObl ;
   private boolean[] H00KC2_n1511EmpLicMotObl ;
   private boolean[] H00KC2_A1510EmpLicIngMot ;
   private boolean[] H00KC2_n1510EmpLicIngMot ;
   private boolean[] H00KC2_A1509EmpLicNecAut ;
   private boolean[] H00KC2_n1509EmpLicNecAut ;
   private boolean[] H00KC2_A1508EmpLicAdjuObl ;
   private boolean[] H00KC2_n1508EmpLicAdjuObl ;
   private boolean[] H00KC2_A1507EmpLicAdju ;
   private boolean[] H00KC2_n1507EmpLicAdju ;
   private short[] H00KC2_A1506EmpLicDAnual ;
   private boolean[] H00KC2_n1506EmpLicDAnual ;
   private short[] H00KC2_A1505EmpLicDSemes ;
   private boolean[] H00KC2_n1505EmpLicDSemes ;
   private byte[] H00KC2_A1504EmpLicDMes ;
   private boolean[] H00KC2_n1504EmpLicDMes ;
   private byte[] H00KC2_A1503EmpLicDSeman ;
   private boolean[] H00KC2_n1503EmpLicDSeman ;
   private short[] H00KC2_A1502EmpLicDLim ;
   private boolean[] H00KC2_n1502EmpLicDLim ;
   private byte[] H00KC2_A1517EmpLicDMin ;
   private boolean[] H00KC2_n1517EmpLicDMin ;
   private java.math.BigDecimal[] H00KC2_A1432EmpBasePlus ;
   private byte[] H00KC2_A1427EmpBaseClaseLeg ;
   private String[] H00KC2_A1429EmpBaseTipo ;
   private String[] H00KC2_A1431EmpBaseCod2 ;
   private String[] H00KC2_A1430EmpBaseCod1 ;
   private short[] H00KC2_A1EmpCod ;
   private int[] H00KC2_A3CliCod ;
   private long[] H00KC3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV67TFEmpBasePromTCnt_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV99ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext13[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV12TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV13GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState19[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV14GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV23ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector15[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV68DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
}

final  class empresabase_calculoww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00KC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A1504EmpLicDMes ,
                                          GXSimpleCollection<Byte> AV125Empresabase_calculowwds_11_tfemplicdmes_sels ,
                                          String A1439EmpBasePromTCnt ,
                                          GXSimpleCollection<String> AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels ,
                                          java.math.BigDecimal AV117Empresabase_calculowwds_3_tfempbaseplus ,
                                          java.math.BigDecimal AV118Empresabase_calculowwds_4_tfempbaseplus_to ,
                                          byte AV119Empresabase_calculowwds_5_tfemplicdmin ,
                                          byte AV120Empresabase_calculowwds_6_tfemplicdmin_to ,
                                          short AV121Empresabase_calculowwds_7_tfemplicdlim ,
                                          short AV122Empresabase_calculowwds_8_tfemplicdlim_to ,
                                          byte AV123Empresabase_calculowwds_9_tfemplicdseman ,
                                          byte AV124Empresabase_calculowwds_10_tfemplicdseman_to ,
                                          int AV125Empresabase_calculowwds_11_tfemplicdmes_sels_size ,
                                          short AV126Empresabase_calculowwds_12_tfemplicdsemes ,
                                          short AV127Empresabase_calculowwds_13_tfemplicdsemes_to ,
                                          short AV128Empresabase_calculowwds_14_tfemplicdanual ,
                                          short AV129Empresabase_calculowwds_15_tfemplicdanual_to ,
                                          byte AV130Empresabase_calculowwds_16_tfemplicadju_sel ,
                                          byte AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel ,
                                          byte AV132Empresabase_calculowwds_18_tfemplicnecaut_sel ,
                                          byte AV133Empresabase_calculowwds_19_tfemplicingmot_sel ,
                                          byte AV134Empresabase_calculowwds_20_tfemplicmotobl_sel ,
                                          short AV135Empresabase_calculowwds_21_tfempbasepromcnt1 ,
                                          short AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to ,
                                          short AV137Empresabase_calculowwds_23_tfempbasepromcnt2 ,
                                          short AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to ,
                                          int AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels_size ,
                                          java.math.BigDecimal A1432EmpBasePlus ,
                                          byte A1517EmpLicDMin ,
                                          short A1502EmpLicDLim ,
                                          byte A1503EmpLicDSeman ,
                                          short A1505EmpLicDSemes ,
                                          short A1506EmpLicDAnual ,
                                          boolean A1507EmpLicAdju ,
                                          boolean A1508EmpLicAdjuObl ,
                                          boolean A1509EmpLicNecAut ,
                                          boolean A1510EmpLicIngMot ,
                                          boolean A1511EmpLicMotObl ,
                                          short A1437EmpBasePromCnt1 ,
                                          short A1438EmpBasePromCnt2 ,
                                          short AV15OrderedBy ,
                                          boolean AV16OrderedDsc ,
                                          short A1EmpCod ,
                                          short AV80EmpCod ,
                                          int AV79CliCod ,
                                          byte AV115Empresabase_calculowwds_1_empbaseclaseleg ,
                                          String AV116Empresabase_calculowwds_2_empbasetipo ,
                                          int A3CliCod ,
                                          byte A1427EmpBaseClaseLeg ,
                                          String A1429EmpBaseTipo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[24];
      Object[] GXv_Object21 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " EmpBasePromTCnt, EmpBasePromCnt2, EmpBasePromCnt1, EmpBaseOrd, EmpLicMotObl, EmpLicIngMot, EmpLicNecAut, EmpLicAdjuObl, EmpLicAdju, EmpLicDAnual, EmpLicDSemes," ;
      sSelectString += " EmpLicDMes, EmpLicDSeman, EmpLicDLim, EmpLicDMin, EmpBasePlus, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod2, EmpBaseCod1, EmpCod, CliCod" ;
      sFromString = " FROM Empresabase_calculo" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and EmpBaseClaseLeg = ? and EmpBaseTipo = ( ?))");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Empresabase_calculowwds_3_tfempbaseplus)==0) )
      {
         addWhere(sWhereString, "(EmpBasePlus >= ?)");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Empresabase_calculowwds_4_tfempbaseplus_to)==0) )
      {
         addWhere(sWhereString, "(EmpBasePlus <= ?)");
      }
      else
      {
         GXv_int20[6] = (byte)(1) ;
      }
      if ( ! (0==AV119Empresabase_calculowwds_5_tfemplicdmin) )
      {
         addWhere(sWhereString, "(EmpLicDMin >= ?)");
      }
      else
      {
         GXv_int20[7] = (byte)(1) ;
      }
      if ( ! (0==AV120Empresabase_calculowwds_6_tfemplicdmin_to) )
      {
         addWhere(sWhereString, "(EmpLicDMin <= ?)");
      }
      else
      {
         GXv_int20[8] = (byte)(1) ;
      }
      if ( ! (0==AV121Empresabase_calculowwds_7_tfemplicdlim) )
      {
         addWhere(sWhereString, "(EmpLicDLim >= ?)");
      }
      else
      {
         GXv_int20[9] = (byte)(1) ;
      }
      if ( ! (0==AV122Empresabase_calculowwds_8_tfemplicdlim_to) )
      {
         addWhere(sWhereString, "(EmpLicDLim <= ?)");
      }
      else
      {
         GXv_int20[10] = (byte)(1) ;
      }
      if ( ! (0==AV123Empresabase_calculowwds_9_tfemplicdseman) )
      {
         addWhere(sWhereString, "(EmpLicDSeman >= ?)");
      }
      else
      {
         GXv_int20[11] = (byte)(1) ;
      }
      if ( ! (0==AV124Empresabase_calculowwds_10_tfemplicdseman_to) )
      {
         addWhere(sWhereString, "(EmpLicDSeman <= ?)");
      }
      else
      {
         GXv_int20[12] = (byte)(1) ;
      }
      if ( AV125Empresabase_calculowwds_11_tfemplicdmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV125Empresabase_calculowwds_11_tfemplicdmes_sels, "EmpLicDMes IN (", ")")+")");
      }
      if ( ! (0==AV126Empresabase_calculowwds_12_tfemplicdsemes) )
      {
         addWhere(sWhereString, "(EmpLicDSemes >= ?)");
      }
      else
      {
         GXv_int20[13] = (byte)(1) ;
      }
      if ( ! (0==AV127Empresabase_calculowwds_13_tfemplicdsemes_to) )
      {
         addWhere(sWhereString, "(EmpLicDSemes <= ?)");
      }
      else
      {
         GXv_int20[14] = (byte)(1) ;
      }
      if ( ! (0==AV128Empresabase_calculowwds_14_tfemplicdanual) )
      {
         addWhere(sWhereString, "(EmpLicDAnual >= ?)");
      }
      else
      {
         GXv_int20[15] = (byte)(1) ;
      }
      if ( ! (0==AV129Empresabase_calculowwds_15_tfemplicdanual_to) )
      {
         addWhere(sWhereString, "(EmpLicDAnual <= ?)");
      }
      else
      {
         GXv_int20[16] = (byte)(1) ;
      }
      if ( AV130Empresabase_calculowwds_16_tfemplicadju_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicAdju = TRUE)");
      }
      if ( AV130Empresabase_calculowwds_16_tfemplicadju_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicAdju = FALSE)");
      }
      if ( AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicAdjuObl = TRUE)");
      }
      if ( AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicAdjuObl = FALSE)");
      }
      if ( AV132Empresabase_calculowwds_18_tfemplicnecaut_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicNecAut = TRUE)");
      }
      if ( AV132Empresabase_calculowwds_18_tfemplicnecaut_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicNecAut = FALSE)");
      }
      if ( AV133Empresabase_calculowwds_19_tfemplicingmot_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicIngMot = TRUE)");
      }
      if ( AV133Empresabase_calculowwds_19_tfemplicingmot_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicIngMot = FALSE)");
      }
      if ( AV134Empresabase_calculowwds_20_tfemplicmotobl_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicMotObl = TRUE)");
      }
      if ( AV134Empresabase_calculowwds_20_tfemplicmotobl_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicMotObl = FALSE)");
      }
      if ( ! (0==AV135Empresabase_calculowwds_21_tfempbasepromcnt1) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt1 >= ?)");
      }
      else
      {
         GXv_int20[17] = (byte)(1) ;
      }
      if ( ! (0==AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt1 <= ?)");
      }
      else
      {
         GXv_int20[18] = (byte)(1) ;
      }
      if ( ! (0==AV137Empresabase_calculowwds_23_tfempbasepromcnt2) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt2 >= ?)");
      }
      else
      {
         GXv_int20[19] = (byte)(1) ;
      }
      if ( ! (0==AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt2 <= ?)");
      }
      else
      {
         GXv_int20[20] = (byte)(1) ;
      }
      if ( AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels, "EmpBasePromTCnt IN (", ")")+")");
      }
      if ( ( AV15OrderedBy == 1 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpBasePlus, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 1 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpBasePlus DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDMin, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDMin DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDLim, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDLim DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDSeman, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDSeman DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDMes, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDMes DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDSemes, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDSemes DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDAnual, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDAnual DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicAdju, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicAdju DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicAdjuObl, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicAdjuObl DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicNecAut, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicNecAut DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicIngMot, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicIngMot DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 12 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicMotObl, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 12 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicMotObl DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 13 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpBasePromCnt1, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 13 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpBasePromCnt1 DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 14 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpBasePromCnt2, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 14 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpBasePromCnt2 DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 15 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpBasePromTCnt, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 15 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpBasePromTCnt DESC, CliCod, EmpCod, EmpBaseCod1, EmpBaseCod2" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
   }

   protected Object[] conditional_H00KC3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A1504EmpLicDMes ,
                                          GXSimpleCollection<Byte> AV125Empresabase_calculowwds_11_tfemplicdmes_sels ,
                                          String A1439EmpBasePromTCnt ,
                                          GXSimpleCollection<String> AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels ,
                                          java.math.BigDecimal AV117Empresabase_calculowwds_3_tfempbaseplus ,
                                          java.math.BigDecimal AV118Empresabase_calculowwds_4_tfempbaseplus_to ,
                                          byte AV119Empresabase_calculowwds_5_tfemplicdmin ,
                                          byte AV120Empresabase_calculowwds_6_tfemplicdmin_to ,
                                          short AV121Empresabase_calculowwds_7_tfemplicdlim ,
                                          short AV122Empresabase_calculowwds_8_tfemplicdlim_to ,
                                          byte AV123Empresabase_calculowwds_9_tfemplicdseman ,
                                          byte AV124Empresabase_calculowwds_10_tfemplicdseman_to ,
                                          int AV125Empresabase_calculowwds_11_tfemplicdmes_sels_size ,
                                          short AV126Empresabase_calculowwds_12_tfemplicdsemes ,
                                          short AV127Empresabase_calculowwds_13_tfemplicdsemes_to ,
                                          short AV128Empresabase_calculowwds_14_tfemplicdanual ,
                                          short AV129Empresabase_calculowwds_15_tfemplicdanual_to ,
                                          byte AV130Empresabase_calculowwds_16_tfemplicadju_sel ,
                                          byte AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel ,
                                          byte AV132Empresabase_calculowwds_18_tfemplicnecaut_sel ,
                                          byte AV133Empresabase_calculowwds_19_tfemplicingmot_sel ,
                                          byte AV134Empresabase_calculowwds_20_tfemplicmotobl_sel ,
                                          short AV135Empresabase_calculowwds_21_tfempbasepromcnt1 ,
                                          short AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to ,
                                          short AV137Empresabase_calculowwds_23_tfempbasepromcnt2 ,
                                          short AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to ,
                                          int AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels_size ,
                                          java.math.BigDecimal A1432EmpBasePlus ,
                                          byte A1517EmpLicDMin ,
                                          short A1502EmpLicDLim ,
                                          byte A1503EmpLicDSeman ,
                                          short A1505EmpLicDSemes ,
                                          short A1506EmpLicDAnual ,
                                          boolean A1507EmpLicAdju ,
                                          boolean A1508EmpLicAdjuObl ,
                                          boolean A1509EmpLicNecAut ,
                                          boolean A1510EmpLicIngMot ,
                                          boolean A1511EmpLicMotObl ,
                                          short A1437EmpBasePromCnt1 ,
                                          short A1438EmpBasePromCnt2 ,
                                          short AV15OrderedBy ,
                                          boolean AV16OrderedDsc ,
                                          short A1EmpCod ,
                                          short AV80EmpCod ,
                                          int AV79CliCod ,
                                          byte AV115Empresabase_calculowwds_1_empbaseclaseleg ,
                                          String AV116Empresabase_calculowwds_2_empbasetipo ,
                                          int A3CliCod ,
                                          byte A1427EmpBaseClaseLeg ,
                                          String A1429EmpBaseTipo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int23 = new byte[23];
      Object[] GXv_Object24 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Empresabase_calculo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and EmpBaseClaseLeg = ? and EmpBaseTipo = ( ?))");
      addWhere(sWhereString, "(EmpCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Empresabase_calculowwds_3_tfempbaseplus)==0) )
      {
         addWhere(sWhereString, "(EmpBasePlus >= ?)");
      }
      else
      {
         GXv_int23[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Empresabase_calculowwds_4_tfempbaseplus_to)==0) )
      {
         addWhere(sWhereString, "(EmpBasePlus <= ?)");
      }
      else
      {
         GXv_int23[8] = (byte)(1) ;
      }
      if ( ! (0==AV119Empresabase_calculowwds_5_tfemplicdmin) )
      {
         addWhere(sWhereString, "(EmpLicDMin >= ?)");
      }
      else
      {
         GXv_int23[9] = (byte)(1) ;
      }
      if ( ! (0==AV120Empresabase_calculowwds_6_tfemplicdmin_to) )
      {
         addWhere(sWhereString, "(EmpLicDMin <= ?)");
      }
      else
      {
         GXv_int23[10] = (byte)(1) ;
      }
      if ( ! (0==AV121Empresabase_calculowwds_7_tfemplicdlim) )
      {
         addWhere(sWhereString, "(EmpLicDLim >= ?)");
      }
      else
      {
         GXv_int23[11] = (byte)(1) ;
      }
      if ( ! (0==AV122Empresabase_calculowwds_8_tfemplicdlim_to) )
      {
         addWhere(sWhereString, "(EmpLicDLim <= ?)");
      }
      else
      {
         GXv_int23[12] = (byte)(1) ;
      }
      if ( ! (0==AV123Empresabase_calculowwds_9_tfemplicdseman) )
      {
         addWhere(sWhereString, "(EmpLicDSeman >= ?)");
      }
      else
      {
         GXv_int23[13] = (byte)(1) ;
      }
      if ( ! (0==AV124Empresabase_calculowwds_10_tfemplicdseman_to) )
      {
         addWhere(sWhereString, "(EmpLicDSeman <= ?)");
      }
      else
      {
         GXv_int23[14] = (byte)(1) ;
      }
      if ( AV125Empresabase_calculowwds_11_tfemplicdmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV125Empresabase_calculowwds_11_tfemplicdmes_sels, "EmpLicDMes IN (", ")")+")");
      }
      if ( ! (0==AV126Empresabase_calculowwds_12_tfemplicdsemes) )
      {
         addWhere(sWhereString, "(EmpLicDSemes >= ?)");
      }
      else
      {
         GXv_int23[15] = (byte)(1) ;
      }
      if ( ! (0==AV127Empresabase_calculowwds_13_tfemplicdsemes_to) )
      {
         addWhere(sWhereString, "(EmpLicDSemes <= ?)");
      }
      else
      {
         GXv_int23[16] = (byte)(1) ;
      }
      if ( ! (0==AV128Empresabase_calculowwds_14_tfemplicdanual) )
      {
         addWhere(sWhereString, "(EmpLicDAnual >= ?)");
      }
      else
      {
         GXv_int23[17] = (byte)(1) ;
      }
      if ( ! (0==AV129Empresabase_calculowwds_15_tfemplicdanual_to) )
      {
         addWhere(sWhereString, "(EmpLicDAnual <= ?)");
      }
      else
      {
         GXv_int23[18] = (byte)(1) ;
      }
      if ( AV130Empresabase_calculowwds_16_tfemplicadju_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicAdju = TRUE)");
      }
      if ( AV130Empresabase_calculowwds_16_tfemplicadju_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicAdju = FALSE)");
      }
      if ( AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicAdjuObl = TRUE)");
      }
      if ( AV131Empresabase_calculowwds_17_tfemplicadjuobl_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicAdjuObl = FALSE)");
      }
      if ( AV132Empresabase_calculowwds_18_tfemplicnecaut_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicNecAut = TRUE)");
      }
      if ( AV132Empresabase_calculowwds_18_tfemplicnecaut_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicNecAut = FALSE)");
      }
      if ( AV133Empresabase_calculowwds_19_tfemplicingmot_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicIngMot = TRUE)");
      }
      if ( AV133Empresabase_calculowwds_19_tfemplicingmot_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicIngMot = FALSE)");
      }
      if ( AV134Empresabase_calculowwds_20_tfemplicmotobl_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicMotObl = TRUE)");
      }
      if ( AV134Empresabase_calculowwds_20_tfemplicmotobl_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicMotObl = FALSE)");
      }
      if ( ! (0==AV135Empresabase_calculowwds_21_tfempbasepromcnt1) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt1 >= ?)");
      }
      else
      {
         GXv_int23[19] = (byte)(1) ;
      }
      if ( ! (0==AV136Empresabase_calculowwds_22_tfempbasepromcnt1_to) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt1 <= ?)");
      }
      else
      {
         GXv_int23[20] = (byte)(1) ;
      }
      if ( ! (0==AV137Empresabase_calculowwds_23_tfempbasepromcnt2) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt2 >= ?)");
      }
      else
      {
         GXv_int23[21] = (byte)(1) ;
      }
      if ( ! (0==AV138Empresabase_calculowwds_24_tfempbasepromcnt2_to) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt2 <= ?)");
      }
      else
      {
         GXv_int23[22] = (byte)(1) ;
      }
      if ( AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV139Empresabase_calculowwds_25_tfempbasepromtcnt_sels, "EmpBasePromTCnt IN (", ")")+")");
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
      GXv_Object24[0] = scmdbuf ;
      GXv_Object24[1] = GXv_int23 ;
      return GXv_Object24 ;
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
                  return conditional_H00KC2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).byteValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).byteValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).intValue() , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).byteValue() , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Boolean) dynConstraints[35]).booleanValue() , ((Boolean) dynConstraints[36]).booleanValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).shortValue() , ((Number) dynConstraints[40]).shortValue() , ((Boolean) dynConstraints[41]).booleanValue() , ((Number) dynConstraints[42]).shortValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).byteValue() , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).byteValue() , (String)dynConstraints[49] );
            case 1 :
                  return conditional_H00KC3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).byteValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).byteValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).intValue() , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).byteValue() , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Boolean) dynConstraints[35]).booleanValue() , ((Boolean) dynConstraints[36]).booleanValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).shortValue() , ((Number) dynConstraints[40]).shortValue() , ((Boolean) dynConstraints[41]).booleanValue() , ((Number) dynConstraints[42]).shortValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).byteValue() , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).byteValue() , (String)dynConstraints[49] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00KC2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KC3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((boolean[]) buf[11])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((boolean[]) buf[13])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(10);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((short[]) buf[17])[0] = rslt.getShort(11);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((byte[]) buf[19])[0] = rslt.getByte(12);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((byte[]) buf[21])[0] = rslt.getByte(13);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((short[]) buf[23])[0] = rslt.getShort(14);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((byte[]) buf[25])[0] = rslt.getByte(15);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(16,4);
               ((byte[]) buf[28])[0] = rslt.getByte(17);
               ((String[]) buf[29])[0] = rslt.getString(18, 20);
               ((String[]) buf[30])[0] = rslt.getString(19, 20);
               ((String[]) buf[31])[0] = rslt.getString(20, 20);
               ((short[]) buf[32])[0] = rslt.getShort(21);
               ((int[]) buf[33])[0] = rslt.getInt(22);
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
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[31]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[32]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[35]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[36]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[38]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[45]).intValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[46]).intValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
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
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[32]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[33]).byteValue());
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
                  stmt.setByte(sIdx, ((Number) parms[36]).byteValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[37]).byteValue());
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

