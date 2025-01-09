package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class variable_listarww_impl extends GXDataArea
{
   public variable_listarww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public variable_listarww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variable_listarww_impl.class ));
   }

   public variable_listarww_impl( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      chkOpeCliEsCant = UIFactory.getCheckbox(this);
      chkOpeCliAliEs = UIFactory.getCheckbox(this);
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
            AV66MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66MenuOpcCod", AV66MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV66MenuOpcCod, ""))));
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
      AV82ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21ColumnsSelector);
      AV95Pgmname = httpContext.GetPar( "Pgmname") ;
      AV66MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV25TFOpeCliId = httpContext.GetPar( "TFOpeCliId") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV26TFOpeCliId_Sels);
      AV28TFOpeCliCodFormula = httpContext.GetPar( "TFOpeCliCodFormula") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29TFOpeCliCodFormula_Sels);
      AV31TFOpeCliDescrip = httpContext.GetPar( "TFOpeCliDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV32TFOpeCliDescrip_Sels);
      AV34TFOpeCliEsCant_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFOpeCliEsCant_Sel"))) ;
      AV35TFOpeCliAliEs_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFOpeCliAliEs_Sel"))) ;
      AV76TFVarRelRef = httpContext.GetPar( "TFVarRelRef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV77TFVarRelRef_Sels);
      AV78TFVarFrecAct = (byte)(GXutil.lval( httpContext.GetPar( "TFVarFrecAct"))) ;
      AV79TFVarFrecAct_To = (byte)(GXutil.lval( httpContext.GetPar( "TFVarFrecAct_To"))) ;
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV46CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV61IsAuthorized_Scrape = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Scrape")) ;
      AV51esSistemaConceptosDefault = GXutil.strtobool( httpContext.GetPar( "esSistemaConceptosDefault")) ;
      AV52ClienteConveniador = GXutil.strtobool( httpContext.GetPar( "ClienteConveniador")) ;
      AV43IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV45IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV68WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV82ManageFiltersExecutionStep, AV21ColumnsSelector, AV95Pgmname, AV66MenuOpcCod, AV12GridState, AV25TFOpeCliId, AV26TFOpeCliId_Sels, AV28TFOpeCliCodFormula, AV29TFOpeCliCodFormula_Sels, AV31TFOpeCliDescrip, AV32TFOpeCliDescrip_Sels, AV34TFOpeCliEsCant_Sel, AV35TFOpeCliAliEs_Sel, AV76TFVarRelRef, AV77TFVarRelRef_Sels, AV78TFVarFrecAct, AV79TFVarFrecAct_To, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV61IsAuthorized_Scrape, AV51esSistemaConceptosDefault, AV52ClienteConveniador, AV43IsAuthorized_Update, AV45IsAuthorized_Delete, AV68WelcomeMessage_NoMostrarMas) ;
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
      paJI2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startJI2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.variable_listarww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV66MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV95Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV66MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV46CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SCRAPE", getSecureSignedToken( "", AV61IsAuthorized_Scrape));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESSISTEMACONCEPTOSDEFAULT", getSecureSignedToken( "", AV51esSistemaConceptosDefault));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( "", AV52ClienteConveniador));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV43IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV45IsAuthorized_Delete));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV36DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV36DDO_TitleSettingsIcons);
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV80ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV80ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV38GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV39GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV40GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV82ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV95Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV95Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV66MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV66MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPECLIID", GXutil.rtrim( AV25TFOpeCliId));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFOPECLIID_SELS", AV26TFOpeCliId_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFOPECLIID_SELS", AV26TFOpeCliId_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPECLICODFORMULA", GXutil.rtrim( AV28TFOpeCliCodFormula));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFOPECLICODFORMULA_SELS", AV29TFOpeCliCodFormula_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFOPECLICODFORMULA_SELS", AV29TFOpeCliCodFormula_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPECLIDESCRIP", AV31TFOpeCliDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFOPECLIDESCRIP_SELS", AV32TFOpeCliDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFOPECLIDESCRIP_SELS", AV32TFOpeCliDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPECLIESCANT_SEL", GXutil.ltrim( localUtil.ntoc( AV34TFOpeCliEsCant_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPECLIALIES_SEL", GXutil.ltrim( localUtil.ntoc( AV35TFOpeCliAliEs_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFVARRELREF", AV76TFVarRelRef);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFVARRELREF_SELS", AV77TFVarRelRef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFVARRELREF_SELS", AV77TFVarRelRef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFVARFRECACT", GXutil.ltrim( localUtil.ntoc( AV78TFVarFrecAct, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFVARFRECACT_TO", GXutil.ltrim( localUtil.ntoc( AV79TFVarFrecAct_To, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV46CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV46CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_SCRAPE", AV61IsAuthorized_Scrape);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SCRAPE", getSecureSignedToken( "", AV61IsAuthorized_Scrape));
      web.GxWebStd.gx_hidden_field( httpContext, "VARBASEURL", A1910VarBaseURL);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESSISTEMACONCEPTOSDEFAULT", AV51esSistemaConceptosDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESSISTEMACONCEPTOSDEFAULT", getSecureSignedToken( "", AV51esSistemaConceptosDefault));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCLIENTECONVENIADOR", AV52ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( "", AV52ClienteConveniador));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV43IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV43IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV45IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV45IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "OPECLIIDPADRE", GXutil.rtrim( A1906OpeCliIdPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPECLIID_SELSJSON", AV24TFOpeCliId_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPECLICODFORMULA_SELSJSON", AV27TFOpeCliCodFormula_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPECLIDESCRIP_SELSJSON", AV30TFOpeCliDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFVARRELREF_SELSJSON", AV75TFVarRelRef_SelsJson);
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
         weJI2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtJI2( ) ;
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
      return formatLink("web.variable_listarww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV66MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "Variable_listarWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Variables", "") ;
   }

   public void wbJI0( )
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
         wb_table1_9_JI2( true) ;
      }
      else
      {
         wb_table1_9_JI2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_JI2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 136,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnvariablesvalores_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Valores grilla", ""), bttBtnvariablesvalores_Jsonclick, 7, httpContext.getMessage( "Valores grilla", ""), "", StyleString, ClassString, bttBtnvariablesvalores_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11ji1_client"+"'", TempTags, "", 2, "HLP_Variable_listarWW.htm");
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV36DDO_TitleSettingsIcons);
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

   public void startJI2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Variables", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupJI0( ) ;
   }

   public void wsJI2( )
   {
      startJI2( ) ;
      evtJI2( ) ;
   }

   public void evtJI2( )
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
                           e12JI2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13JI2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14JI2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15JI2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e16JI2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e17JI2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18JI2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "VSCRAPE.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "VSCRAPE.CLICK") == 0 ) )
                        {
                           nGXsfl_110_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1102( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A82OpeCliId = httpContext.cgiGet( edtOpeCliId_Internalname) ;
                           A549OpeCliCodFormula = httpContext.cgiGet( edtOpeCliCodFormula_Internalname) ;
                           A534OpeCliDescrip = httpContext.cgiGet( edtOpeCliDescrip_Internalname) ;
                           AV60Scrape = httpContext.cgiGet( edtavScrape_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavScrape_Internalname, AV60Scrape);
                           A931OpeCliEsCant = GXutil.strtobool( httpContext.cgiGet( chkOpeCliEsCant.getInternalname())) ;
                           A934OpeCliAliEs = GXutil.strtobool( httpContext.cgiGet( chkOpeCliAliEs.getInternalname())) ;
                           A1828OpeCliUltVal = httpContext.cgiGet( edtOpeCliUltVal_Internalname) ;
                           A1922VarFecProx = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtVarFecProx_Internalname), 0)) ;
                           A2011VarRelRef = httpContext.cgiGet( edtVarRelRef_Internalname) ;
                           A1913VarFrecAct = (byte)(localUtil.ctol( httpContext.cgiGet( edtVarFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           AV42Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV42Update);
                           AV44Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV44Delete);
                           AV65Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV65Display);
                           AV62VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV62VerSVG);
                           AV63ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV63ModificarSVG);
                           AV64EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV64EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e19JI2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e20JI2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21JI2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VSCRAPE.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e22JI2 ();
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

   public void weJI2( )
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

   public void paJI2( )
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
                                 byte AV82ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ,
                                 String AV95Pgmname ,
                                 String AV66MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 String AV25TFOpeCliId ,
                                 GXSimpleCollection<String> AV26TFOpeCliId_Sels ,
                                 String AV28TFOpeCliCodFormula ,
                                 GXSimpleCollection<String> AV29TFOpeCliCodFormula_Sels ,
                                 String AV31TFOpeCliDescrip ,
                                 GXSimpleCollection<String> AV32TFOpeCliDescrip_Sels ,
                                 byte AV34TFOpeCliEsCant_Sel ,
                                 byte AV35TFOpeCliAliEs_Sel ,
                                 String AV76TFVarRelRef ,
                                 GXSimpleCollection<String> AV77TFVarRelRef_Sels ,
                                 byte AV78TFVarFrecAct ,
                                 byte AV79TFVarFrecAct_To ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV46CliCod ,
                                 boolean AV61IsAuthorized_Scrape ,
                                 boolean AV51esSistemaConceptosDefault ,
                                 boolean AV52ClienteConveniador ,
                                 boolean AV43IsAuthorized_Update ,
                                 boolean AV45IsAuthorized_Delete ,
                                 boolean AV68WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20JI2 ();
      GRID_nCurrentRecord = 0 ;
      rfJI2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_OPECLIID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A82OpeCliId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "OPECLIID", GXutil.rtrim( A82OpeCliId));
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
      AV68WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV68WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68WelcomeMessage_NoMostrarMas", AV68WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfJI2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV95Pgmname = "Variable_listarWW" ;
      Gx_err = (short)(0) ;
      edtavScrape_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavScrape_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavScrape_Enabled), 5, 0), !bGXsfl_110_Refreshing);
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

   public void rfJI2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e20JI2 ();
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
                                              A82OpeCliId ,
                                              AV97Variable_listarwwds_2_tfopecliid_sels ,
                                              A549OpeCliCodFormula ,
                                              AV99Variable_listarwwds_4_tfopeclicodformula_sels ,
                                              A534OpeCliDescrip ,
                                              AV101Variable_listarwwds_6_tfopeclidescrip_sels ,
                                              A2011VarRelRef ,
                                              AV105Variable_listarwwds_10_tfvarrelref_sels ,
                                              Integer.valueOf(AV97Variable_listarwwds_2_tfopecliid_sels.size()) ,
                                              AV96Variable_listarwwds_1_tfopecliid ,
                                              Integer.valueOf(AV99Variable_listarwwds_4_tfopeclicodformula_sels.size()) ,
                                              AV98Variable_listarwwds_3_tfopeclicodformula ,
                                              Integer.valueOf(AV101Variable_listarwwds_6_tfopeclidescrip_sels.size()) ,
                                              AV100Variable_listarwwds_5_tfopeclidescrip ,
                                              Byte.valueOf(AV102Variable_listarwwds_7_tfopecliescant_sel) ,
                                              Byte.valueOf(AV103Variable_listarwwds_8_tfopeclialies_sel) ,
                                              Integer.valueOf(AV105Variable_listarwwds_10_tfvarrelref_sels.size()) ,
                                              AV104Variable_listarwwds_9_tfvarrelref ,
                                              Byte.valueOf(AV106Variable_listarwwds_11_tfvarfrecact) ,
                                              Byte.valueOf(AV107Variable_listarwwds_12_tfvarfrecact_to) ,
                                              Boolean.valueOf(A931OpeCliEsCant) ,
                                              Boolean.valueOf(A934OpeCliAliEs) ,
                                              Byte.valueOf(A1913VarFrecAct) ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) ,
                                              Integer.valueOf(AV46CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.SHORT,
                                              TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV96Variable_listarwwds_1_tfopecliid = GXutil.padr( GXutil.rtrim( AV96Variable_listarwwds_1_tfopecliid), 40, "%") ;
         lV98Variable_listarwwds_3_tfopeclicodformula = GXutil.padr( GXutil.rtrim( AV98Variable_listarwwds_3_tfopeclicodformula), 40, "%") ;
         lV100Variable_listarwwds_5_tfopeclidescrip = GXutil.concat( GXutil.rtrim( AV100Variable_listarwwds_5_tfopeclidescrip), "%", "") ;
         lV104Variable_listarwwds_9_tfvarrelref = GXutil.concat( GXutil.rtrim( AV104Variable_listarwwds_9_tfvarrelref), "%", "") ;
         /* Using cursor H00JI2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV46CliCod), lV96Variable_listarwwds_1_tfopecliid, lV98Variable_listarwwds_3_tfopeclicodformula, lV100Variable_listarwwds_5_tfopeclidescrip, lV104Variable_listarwwds_9_tfvarrelref, Byte.valueOf(AV106Variable_listarwwds_11_tfvarfrecact), Byte.valueOf(AV107Variable_listarwwds_12_tfvarfrecact_to), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1910VarBaseURL = H00JI2_A1910VarBaseURL[0] ;
            n1910VarBaseURL = H00JI2_n1910VarBaseURL[0] ;
            A1906OpeCliIdPadre = H00JI2_A1906OpeCliIdPadre[0] ;
            A1913VarFrecAct = H00JI2_A1913VarFrecAct[0] ;
            A2011VarRelRef = H00JI2_A2011VarRelRef[0] ;
            A934OpeCliAliEs = H00JI2_A934OpeCliAliEs[0] ;
            A931OpeCliEsCant = H00JI2_A931OpeCliEsCant[0] ;
            A534OpeCliDescrip = H00JI2_A534OpeCliDescrip[0] ;
            A549OpeCliCodFormula = H00JI2_A549OpeCliCodFormula[0] ;
            A82OpeCliId = H00JI2_A82OpeCliId[0] ;
            A3CliCod = H00JI2_A3CliCod[0] ;
            GXt_char1 = A1828OpeCliUltVal ;
            GXv_char2[0] = GXt_char1 ;
            new web.getopeclivaloryfecha(remoteHandle, context).execute( A3CliCod, A82OpeCliId, localUtil.ymdtod( 1900, 1, 1), GXv_char2) ;
            variable_listarww_impl.this.GXt_char1 = GXv_char2[0] ;
            A1828OpeCliUltVal = GXt_char1 ;
            GXt_date3 = A1922VarFecProx ;
            GXv_date4[0] = GXt_date3 ;
            new web.varfechaproxact(remoteHandle, context).execute( A3CliCod, A82OpeCliId, GXv_date4) ;
            variable_listarww_impl.this.GXt_date3 = GXv_date4[0] ;
            A1922VarFecProx = GXt_date3 ;
            e21JI2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbJI0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesJI2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV95Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV95Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV66MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV66MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV46CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV46CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_SCRAPE", AV61IsAuthorized_Scrape);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SCRAPE", getSecureSignedToken( "", AV61IsAuthorized_Scrape));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESSISTEMACONCEPTOSDEFAULT", AV51esSistemaConceptosDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESSISTEMACONCEPTOSDEFAULT", getSecureSignedToken( "", AV51esSistemaConceptosDefault));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCLIENTECONVENIADOR", AV52ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( "", AV52ClienteConveniador));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV43IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV43IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV45IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV45IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_OPECLIID"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, GXutil.rtrim( localUtil.format( A82OpeCliId, ""))));
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
      AV96Variable_listarwwds_1_tfopecliid = AV25TFOpeCliId ;
      AV97Variable_listarwwds_2_tfopecliid_sels = AV26TFOpeCliId_Sels ;
      AV98Variable_listarwwds_3_tfopeclicodformula = AV28TFOpeCliCodFormula ;
      AV99Variable_listarwwds_4_tfopeclicodformula_sels = AV29TFOpeCliCodFormula_Sels ;
      AV100Variable_listarwwds_5_tfopeclidescrip = AV31TFOpeCliDescrip ;
      AV101Variable_listarwwds_6_tfopeclidescrip_sels = AV32TFOpeCliDescrip_Sels ;
      AV102Variable_listarwwds_7_tfopecliescant_sel = AV34TFOpeCliEsCant_Sel ;
      AV103Variable_listarwwds_8_tfopeclialies_sel = AV35TFOpeCliAliEs_Sel ;
      AV104Variable_listarwwds_9_tfvarrelref = AV76TFVarRelRef ;
      AV105Variable_listarwwds_10_tfvarrelref_sels = AV77TFVarRelRef_Sels ;
      AV106Variable_listarwwds_11_tfvarfrecact = AV78TFVarFrecAct ;
      AV107Variable_listarwwds_12_tfvarfrecact_to = AV79TFVarFrecAct_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A82OpeCliId ,
                                           AV97Variable_listarwwds_2_tfopecliid_sels ,
                                           A549OpeCliCodFormula ,
                                           AV99Variable_listarwwds_4_tfopeclicodformula_sels ,
                                           A534OpeCliDescrip ,
                                           AV101Variable_listarwwds_6_tfopeclidescrip_sels ,
                                           A2011VarRelRef ,
                                           AV105Variable_listarwwds_10_tfvarrelref_sels ,
                                           Integer.valueOf(AV97Variable_listarwwds_2_tfopecliid_sels.size()) ,
                                           AV96Variable_listarwwds_1_tfopecliid ,
                                           Integer.valueOf(AV99Variable_listarwwds_4_tfopeclicodformula_sels.size()) ,
                                           AV98Variable_listarwwds_3_tfopeclicodformula ,
                                           Integer.valueOf(AV101Variable_listarwwds_6_tfopeclidescrip_sels.size()) ,
                                           AV100Variable_listarwwds_5_tfopeclidescrip ,
                                           Byte.valueOf(AV102Variable_listarwwds_7_tfopecliescant_sel) ,
                                           Byte.valueOf(AV103Variable_listarwwds_8_tfopeclialies_sel) ,
                                           Integer.valueOf(AV105Variable_listarwwds_10_tfvarrelref_sels.size()) ,
                                           AV104Variable_listarwwds_9_tfvarrelref ,
                                           Byte.valueOf(AV106Variable_listarwwds_11_tfvarfrecact) ,
                                           Byte.valueOf(AV107Variable_listarwwds_12_tfvarfrecact_to) ,
                                           Boolean.valueOf(A931OpeCliEsCant) ,
                                           Boolean.valueOf(A934OpeCliAliEs) ,
                                           Byte.valueOf(A1913VarFrecAct) ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) ,
                                           Integer.valueOf(AV46CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV96Variable_listarwwds_1_tfopecliid = GXutil.padr( GXutil.rtrim( AV96Variable_listarwwds_1_tfopecliid), 40, "%") ;
      lV98Variable_listarwwds_3_tfopeclicodformula = GXutil.padr( GXutil.rtrim( AV98Variable_listarwwds_3_tfopeclicodformula), 40, "%") ;
      lV100Variable_listarwwds_5_tfopeclidescrip = GXutil.concat( GXutil.rtrim( AV100Variable_listarwwds_5_tfopeclidescrip), "%", "") ;
      lV104Variable_listarwwds_9_tfvarrelref = GXutil.concat( GXutil.rtrim( AV104Variable_listarwwds_9_tfvarrelref), "%", "") ;
      /* Using cursor H00JI3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV46CliCod), lV96Variable_listarwwds_1_tfopecliid, lV98Variable_listarwwds_3_tfopeclicodformula, lV100Variable_listarwwds_5_tfopeclidescrip, lV104Variable_listarwwds_9_tfvarrelref, Byte.valueOf(AV106Variable_listarwwds_11_tfvarfrecact), Byte.valueOf(AV107Variable_listarwwds_12_tfvarfrecact_to)});
      GRID_nRecordCount = H00JI3_AGRID_nRecordCount[0] ;
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
      AV96Variable_listarwwds_1_tfopecliid = AV25TFOpeCliId ;
      AV97Variable_listarwwds_2_tfopecliid_sels = AV26TFOpeCliId_Sels ;
      AV98Variable_listarwwds_3_tfopeclicodformula = AV28TFOpeCliCodFormula ;
      AV99Variable_listarwwds_4_tfopeclicodformula_sels = AV29TFOpeCliCodFormula_Sels ;
      AV100Variable_listarwwds_5_tfopeclidescrip = AV31TFOpeCliDescrip ;
      AV101Variable_listarwwds_6_tfopeclidescrip_sels = AV32TFOpeCliDescrip_Sels ;
      AV102Variable_listarwwds_7_tfopecliescant_sel = AV34TFOpeCliEsCant_Sel ;
      AV103Variable_listarwwds_8_tfopeclialies_sel = AV35TFOpeCliAliEs_Sel ;
      AV104Variable_listarwwds_9_tfvarrelref = AV76TFVarRelRef ;
      AV105Variable_listarwwds_10_tfvarrelref_sels = AV77TFVarRelRef_Sels ;
      AV106Variable_listarwwds_11_tfvarfrecact = AV78TFVarFrecAct ;
      AV107Variable_listarwwds_12_tfvarfrecact_to = AV79TFVarFrecAct_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV82ManageFiltersExecutionStep, AV21ColumnsSelector, AV95Pgmname, AV66MenuOpcCod, AV12GridState, AV25TFOpeCliId, AV26TFOpeCliId_Sels, AV28TFOpeCliCodFormula, AV29TFOpeCliCodFormula_Sels, AV31TFOpeCliDescrip, AV32TFOpeCliDescrip_Sels, AV34TFOpeCliEsCant_Sel, AV35TFOpeCliAliEs_Sel, AV76TFVarRelRef, AV77TFVarRelRef_Sels, AV78TFVarFrecAct, AV79TFVarFrecAct_To, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV61IsAuthorized_Scrape, AV51esSistemaConceptosDefault, AV52ClienteConveniador, AV43IsAuthorized_Update, AV45IsAuthorized_Delete, AV68WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV96Variable_listarwwds_1_tfopecliid = AV25TFOpeCliId ;
      AV97Variable_listarwwds_2_tfopecliid_sels = AV26TFOpeCliId_Sels ;
      AV98Variable_listarwwds_3_tfopeclicodformula = AV28TFOpeCliCodFormula ;
      AV99Variable_listarwwds_4_tfopeclicodformula_sels = AV29TFOpeCliCodFormula_Sels ;
      AV100Variable_listarwwds_5_tfopeclidescrip = AV31TFOpeCliDescrip ;
      AV101Variable_listarwwds_6_tfopeclidescrip_sels = AV32TFOpeCliDescrip_Sels ;
      AV102Variable_listarwwds_7_tfopecliescant_sel = AV34TFOpeCliEsCant_Sel ;
      AV103Variable_listarwwds_8_tfopeclialies_sel = AV35TFOpeCliAliEs_Sel ;
      AV104Variable_listarwwds_9_tfvarrelref = AV76TFVarRelRef ;
      AV105Variable_listarwwds_10_tfvarrelref_sels = AV77TFVarRelRef_Sels ;
      AV106Variable_listarwwds_11_tfvarfrecact = AV78TFVarFrecAct ;
      AV107Variable_listarwwds_12_tfvarfrecact_to = AV79TFVarFrecAct_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV82ManageFiltersExecutionStep, AV21ColumnsSelector, AV95Pgmname, AV66MenuOpcCod, AV12GridState, AV25TFOpeCliId, AV26TFOpeCliId_Sels, AV28TFOpeCliCodFormula, AV29TFOpeCliCodFormula_Sels, AV31TFOpeCliDescrip, AV32TFOpeCliDescrip_Sels, AV34TFOpeCliEsCant_Sel, AV35TFOpeCliAliEs_Sel, AV76TFVarRelRef, AV77TFVarRelRef_Sels, AV78TFVarFrecAct, AV79TFVarFrecAct_To, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV61IsAuthorized_Scrape, AV51esSistemaConceptosDefault, AV52ClienteConveniador, AV43IsAuthorized_Update, AV45IsAuthorized_Delete, AV68WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV96Variable_listarwwds_1_tfopecliid = AV25TFOpeCliId ;
      AV97Variable_listarwwds_2_tfopecliid_sels = AV26TFOpeCliId_Sels ;
      AV98Variable_listarwwds_3_tfopeclicodformula = AV28TFOpeCliCodFormula ;
      AV99Variable_listarwwds_4_tfopeclicodformula_sels = AV29TFOpeCliCodFormula_Sels ;
      AV100Variable_listarwwds_5_tfopeclidescrip = AV31TFOpeCliDescrip ;
      AV101Variable_listarwwds_6_tfopeclidescrip_sels = AV32TFOpeCliDescrip_Sels ;
      AV102Variable_listarwwds_7_tfopecliescant_sel = AV34TFOpeCliEsCant_Sel ;
      AV103Variable_listarwwds_8_tfopeclialies_sel = AV35TFOpeCliAliEs_Sel ;
      AV104Variable_listarwwds_9_tfvarrelref = AV76TFVarRelRef ;
      AV105Variable_listarwwds_10_tfvarrelref_sels = AV77TFVarRelRef_Sels ;
      AV106Variable_listarwwds_11_tfvarfrecact = AV78TFVarFrecAct ;
      AV107Variable_listarwwds_12_tfvarfrecact_to = AV79TFVarFrecAct_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV82ManageFiltersExecutionStep, AV21ColumnsSelector, AV95Pgmname, AV66MenuOpcCod, AV12GridState, AV25TFOpeCliId, AV26TFOpeCliId_Sels, AV28TFOpeCliCodFormula, AV29TFOpeCliCodFormula_Sels, AV31TFOpeCliDescrip, AV32TFOpeCliDescrip_Sels, AV34TFOpeCliEsCant_Sel, AV35TFOpeCliAliEs_Sel, AV76TFVarRelRef, AV77TFVarRelRef_Sels, AV78TFVarFrecAct, AV79TFVarFrecAct_To, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV61IsAuthorized_Scrape, AV51esSistemaConceptosDefault, AV52ClienteConveniador, AV43IsAuthorized_Update, AV45IsAuthorized_Delete, AV68WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV96Variable_listarwwds_1_tfopecliid = AV25TFOpeCliId ;
      AV97Variable_listarwwds_2_tfopecliid_sels = AV26TFOpeCliId_Sels ;
      AV98Variable_listarwwds_3_tfopeclicodformula = AV28TFOpeCliCodFormula ;
      AV99Variable_listarwwds_4_tfopeclicodformula_sels = AV29TFOpeCliCodFormula_Sels ;
      AV100Variable_listarwwds_5_tfopeclidescrip = AV31TFOpeCliDescrip ;
      AV101Variable_listarwwds_6_tfopeclidescrip_sels = AV32TFOpeCliDescrip_Sels ;
      AV102Variable_listarwwds_7_tfopecliescant_sel = AV34TFOpeCliEsCant_Sel ;
      AV103Variable_listarwwds_8_tfopeclialies_sel = AV35TFOpeCliAliEs_Sel ;
      AV104Variable_listarwwds_9_tfvarrelref = AV76TFVarRelRef ;
      AV105Variable_listarwwds_10_tfvarrelref_sels = AV77TFVarRelRef_Sels ;
      AV106Variable_listarwwds_11_tfvarfrecact = AV78TFVarFrecAct ;
      AV107Variable_listarwwds_12_tfvarfrecact_to = AV79TFVarFrecAct_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV82ManageFiltersExecutionStep, AV21ColumnsSelector, AV95Pgmname, AV66MenuOpcCod, AV12GridState, AV25TFOpeCliId, AV26TFOpeCliId_Sels, AV28TFOpeCliCodFormula, AV29TFOpeCliCodFormula_Sels, AV31TFOpeCliDescrip, AV32TFOpeCliDescrip_Sels, AV34TFOpeCliEsCant_Sel, AV35TFOpeCliAliEs_Sel, AV76TFVarRelRef, AV77TFVarRelRef_Sels, AV78TFVarFrecAct, AV79TFVarFrecAct_To, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV61IsAuthorized_Scrape, AV51esSistemaConceptosDefault, AV52ClienteConveniador, AV43IsAuthorized_Update, AV45IsAuthorized_Delete, AV68WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV96Variable_listarwwds_1_tfopecliid = AV25TFOpeCliId ;
      AV97Variable_listarwwds_2_tfopecliid_sels = AV26TFOpeCliId_Sels ;
      AV98Variable_listarwwds_3_tfopeclicodformula = AV28TFOpeCliCodFormula ;
      AV99Variable_listarwwds_4_tfopeclicodformula_sels = AV29TFOpeCliCodFormula_Sels ;
      AV100Variable_listarwwds_5_tfopeclidescrip = AV31TFOpeCliDescrip ;
      AV101Variable_listarwwds_6_tfopeclidescrip_sels = AV32TFOpeCliDescrip_Sels ;
      AV102Variable_listarwwds_7_tfopecliescant_sel = AV34TFOpeCliEsCant_Sel ;
      AV103Variable_listarwwds_8_tfopeclialies_sel = AV35TFOpeCliAliEs_Sel ;
      AV104Variable_listarwwds_9_tfvarrelref = AV76TFVarRelRef ;
      AV105Variable_listarwwds_10_tfvarrelref_sels = AV77TFVarRelRef_Sels ;
      AV106Variable_listarwwds_11_tfvarfrecact = AV78TFVarFrecAct ;
      AV107Variable_listarwwds_12_tfvarfrecact_to = AV79TFVarFrecAct_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV82ManageFiltersExecutionStep, AV21ColumnsSelector, AV95Pgmname, AV66MenuOpcCod, AV12GridState, AV25TFOpeCliId, AV26TFOpeCliId_Sels, AV28TFOpeCliCodFormula, AV29TFOpeCliCodFormula_Sels, AV31TFOpeCliDescrip, AV32TFOpeCliDescrip_Sels, AV34TFOpeCliEsCant_Sel, AV35TFOpeCliAliEs_Sel, AV76TFVarRelRef, AV77TFVarRelRef_Sels, AV78TFVarFrecAct, AV79TFVarFrecAct_To, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV61IsAuthorized_Scrape, AV51esSistemaConceptosDefault, AV52ClienteConveniador, AV43IsAuthorized_Update, AV45IsAuthorized_Delete, AV68WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV95Pgmname = "Variable_listarWW" ;
      Gx_err = (short)(0) ;
      edtavScrape_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavScrape_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavScrape_Enabled), 5, 0), !bGXsfl_110_Refreshing);
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

   public void strupJI0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19JI2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV36DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV80ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV38GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV39GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV40GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV46CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV66MenuOpcCod = httpContext.cgiGet( "vMENUOPCCOD") ;
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
         AV74WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV68WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV68WelcomeMessage_NoMostrarMas", AV68WelcomeMessage_NoMostrarMas);
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
      e19JI2 ();
      if (returnInSub) return;
   }

   public void e19JI2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV66MenuOpcCod, "", "") ;
      GXt_int5 = AV46CliCod ;
      GXv_int6[0] = GXt_int5 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
      variable_listarww_impl.this.GXt_int5 = GXv_int6[0] ;
      AV46CliCod = GXt_int5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV46CliCod), "ZZZZZ9")));
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
      Form.setCaption( httpContext.getMessage( "Variables", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7 = AV36DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8[0] ;
      AV36DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char2[0] = AV69MenuBienveImgURL ;
      GXv_char9[0] = AV71MenuBienveTitulo ;
      GXv_char10[0] = AV72MenuBienveTexto ;
      GXv_boolean11[0] = AV73MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV66MenuOpcCod, GXv_char2, GXv_char9, GXv_char10, GXv_boolean11) ;
      variable_listarww_impl.this.AV69MenuBienveImgURL = GXv_char2[0] ;
      variable_listarww_impl.this.AV71MenuBienveTitulo = GXv_char9[0] ;
      variable_listarww_impl.this.AV72MenuBienveTexto = GXv_char10[0] ;
      variable_listarww_impl.this.AV73MenuBienveVisible = GXv_boolean11[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV73MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV73MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV71MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV72MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV74WelcomeMessage_Foto = AV69MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV74WelcomeMessage_Foto)==0) ? AV94Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV74WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV74WelcomeMessage_Foto), true);
         AV94Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV69MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV74WelcomeMessage_Foto)==0) ? AV94Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV74WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV74WelcomeMessage_Foto), true);
      }
      GXt_char1 = "" ;
      GXt_char12 = "" ;
      GXv_char10[0] = GXt_char12 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char10) ;
      variable_listarww_impl.this.GXt_char12 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char1 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char12, GXv_char9) ;
      variable_listarww_impl.this.GXt_char1 = GXv_char9[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char1 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV91observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV91observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV91observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV91observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXt_boolean13 = AV51esSistemaConceptosDefault ;
      GXv_boolean11[0] = GXt_boolean13 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean11) ;
      variable_listarww_impl.this.GXt_boolean13 = GXv_boolean11[0] ;
      AV51esSistemaConceptosDefault = GXt_boolean13 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51esSistemaConceptosDefault", AV51esSistemaConceptosDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESSISTEMACONCEPTOSDEFAULT", getSecureSignedToken( "", AV51esSistemaConceptosDefault));
      GXv_boolean11[0] = AV52ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV46CliCod, GXv_boolean11) ;
      variable_listarww_impl.this.AV52ClienteConveniador = GXv_boolean11[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52ClienteConveniador", AV52ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( "", AV52ClienteConveniador));
   }

   public void e20JI2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int5 = AV46CliCod ;
      GXv_int6[0] = GXt_int5 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
      variable_listarww_impl.this.GXt_int5 = GXv_int6[0] ;
      AV46CliCod = GXt_int5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV46CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext14[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext14) ;
      AV6WWPContext = GXv_SdtWWPContext14[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV82ManageFiltersExecutionStep == 1 )
      {
         AV82ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV82ManageFiltersExecutionStep", GXutil.str( AV82ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV82ManageFiltersExecutionStep == 2 )
      {
         AV82ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV82ManageFiltersExecutionStep", GXutil.str( AV82ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV23Session.getValue("Variable_listarWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("Variable_listarWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtOpeCliId_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtOpeCliCodFormula_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliCodFormula_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliCodFormula_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtOpeCliDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliDescrip_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkOpeCliEsCant.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "Visible", GXutil.ltrimstr( chkOpeCliEsCant.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkOpeCliAliEs.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "Visible", GXutil.ltrimstr( chkOpeCliAliEs.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtOpeCliUltVal_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliUltVal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliUltVal_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtVarFecProx_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtVarFecProx_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVarFecProx_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtVarRelRef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtVarRelRef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVarRelRef_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtVarFrecAct_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtVarFrecAct_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVarFrecAct_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV38GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38GridCurrentPage), 10, 0));
      AV39GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39GridPageCount), 10, 0));
      GXt_char12 = AV40GridAppliedFilters ;
      GXv_char10[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV95Pgmname, GXv_char10) ;
      variable_listarww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV40GridAppliedFilters = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40GridAppliedFilters", AV40GridAppliedFilters);
      GXt_char12 = AV87MenuOpcTitulo ;
      GXv_char10[0] = GXt_char12 ;
      new web.gettxtcount(remoteHandle, context).execute( AV66MenuOpcCod, GXv_char10) ;
      variable_listarww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV87MenuOpcTitulo = GXt_char12 ;
      if ( (GXutil.strcmp("", AV87MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV87MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int15[0] = (short)(AV89filterCount) ;
      GXv_char10[0] = AV90filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int15, GXv_char10) ;
      variable_listarww_impl.this.AV89filterCount = GXv_int15[0] ;
      variable_listarww_impl.this.AV90filtrosTexto = GXv_char10[0] ;
      if ( AV89filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV89filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV90filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV96Variable_listarwwds_1_tfopecliid = AV25TFOpeCliId ;
      AV97Variable_listarwwds_2_tfopecliid_sels = AV26TFOpeCliId_Sels ;
      AV98Variable_listarwwds_3_tfopeclicodformula = AV28TFOpeCliCodFormula ;
      AV99Variable_listarwwds_4_tfopeclicodformula_sels = AV29TFOpeCliCodFormula_Sels ;
      AV100Variable_listarwwds_5_tfopeclidescrip = AV31TFOpeCliDescrip ;
      AV101Variable_listarwwds_6_tfopeclidescrip_sels = AV32TFOpeCliDescrip_Sels ;
      AV102Variable_listarwwds_7_tfopecliescant_sel = AV34TFOpeCliEsCant_Sel ;
      AV103Variable_listarwwds_8_tfopeclialies_sel = AV35TFOpeCliAliEs_Sel ;
      AV104Variable_listarwwds_9_tfvarrelref = AV76TFVarRelRef ;
      AV105Variable_listarwwds_10_tfvarrelref_sels = AV77TFVarRelRef_Sels ;
      AV106Variable_listarwwds_11_tfvarfrecact = AV78TFVarFrecAct ;
      AV107Variable_listarwwds_12_tfvarfrecact_to = AV79TFVarFrecAct_To ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80ManageFiltersData", AV80ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV77TFVarRelRef_Sels", AV77TFVarRelRef_Sels);
   }

   public void e14JI2( )
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
         AV37PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV37PageToGo) ;
      }
   }

   public void e15JI2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e16JI2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OpeCliId") == 0 )
         {
            AV25TFOpeCliId = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFOpeCliId", AV25TFOpeCliId);
            AV24TFOpeCliId_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFOpeCliId_SelsJson", AV24TFOpeCliId_SelsJson);
            AV26TFOpeCliId_Sels.fromJSonString(AV24TFOpeCliId_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OpeCliCodFormula") == 0 )
         {
            AV28TFOpeCliCodFormula = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFOpeCliCodFormula", AV28TFOpeCliCodFormula);
            AV27TFOpeCliCodFormula_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFOpeCliCodFormula_SelsJson", AV27TFOpeCliCodFormula_SelsJson);
            AV29TFOpeCliCodFormula_Sels.fromJSonString(AV27TFOpeCliCodFormula_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OpeCliDescrip") == 0 )
         {
            AV31TFOpeCliDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFOpeCliDescrip", AV31TFOpeCliDescrip);
            AV30TFOpeCliDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFOpeCliDescrip_SelsJson", AV30TFOpeCliDescrip_SelsJson);
            AV32TFOpeCliDescrip_Sels.fromJSonString(AV30TFOpeCliDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OpeCliEsCant") == 0 )
         {
            AV34TFOpeCliEsCant_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFOpeCliEsCant_Sel", GXutil.str( AV34TFOpeCliEsCant_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OpeCliAliEs") == 0 )
         {
            AV35TFOpeCliAliEs_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFOpeCliAliEs_Sel", GXutil.str( AV35TFOpeCliAliEs_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "VarRelRef") == 0 )
         {
            AV76TFVarRelRef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TFVarRelRef", AV76TFVarRelRef);
            AV75TFVarRelRef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFVarRelRef_SelsJson", AV75TFVarRelRef_SelsJson);
            AV77TFVarRelRef_Sels.fromJSonString(AV75TFVarRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "VarFrecAct") == 0 )
         {
            AV78TFVarFrecAct = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFVarFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFVarFrecAct), 2, 0));
            AV79TFVarFrecAct_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFVarFrecAct_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79TFVarFrecAct_To), 2, 0));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV77TFVarRelRef_Sels", AV77TFVarRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV32TFOpeCliDescrip_Sels", AV32TFOpeCliDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV29TFOpeCliCodFormula_Sels", AV29TFOpeCliCodFormula_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV26TFOpeCliId_Sels", AV26TFOpeCliId_Sels);
   }

   private void e21JI2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV60Scrape = "<i class=\"fab fa-google fab fa-google\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavScrape_Internalname, AV60Scrape);
      if ( AV61IsAuthorized_Scrape )
      {
         if ( ! (GXutil.strcmp("", A1910VarBaseURL)==0) && ! A934OpeCliAliEs && ( ( AV51esSistemaConceptosDefault ) || ( AV52ClienteConveniador ) ) )
         {
            edtavScrape_Class = "Attribute" ;
         }
         else
         {
            edtavScrape_Class = "Invisible" ;
         }
      }
      AV42Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV42Update);
      if ( AV43IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.variable_listar", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A82OpeCliId))}, new String[] {"Mode","CliCod","OpeCliId"})  ;
      }
      AV44Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV44Delete);
      if ( AV45IsAuthorized_Delete )
      {
         if ( (GXutil.strcmp("", A1906OpeCliIdPadre)==0) || (GXutil.strcmp("", A1906OpeCliIdPadre)==0) )
         {
            edtavDelete_Link = formatLink("web.variable_listar", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A82OpeCliId))}, new String[] {"Mode","CliCod","OpeCliId"})  ;
            edtavDelete_Class = "Attribute" ;
         }
         else
         {
            edtavDelete_Link = "" ;
            edtavDelete_Class = "Invisible" ;
         }
      }
      AV65Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV65Display);
      edtavDisplay_Link = formatLink("web.variable_listarview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A82OpeCliId)),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "variable_valores", "")))}, new String[] {"CliCod","OpeCliId","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char12 = AV62VerSVG ;
      GXv_char10[0] = GXt_char12 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char10) ;
      variable_listarww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV62VerSVG = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV62VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char12 = AV63ModificarSVG ;
      GXv_char10[0] = GXt_char12 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char10) ;
      variable_listarww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV63ModificarSVG = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV63ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char12 = AV64EliminarSVG ;
      GXv_char10[0] = GXt_char12 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char10) ;
      variable_listarww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV64EliminarSVG = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV64EliminarSVG);
      edtavEliminarsvg_Link = edtavDelete_Link ;
      edtavDelete_Visible = 0 ;
      if ( (GXutil.strcmp("", A1906OpeCliIdPadre)==0) || (GXutil.strcmp("", A1906OpeCliIdPadre)==0) )
      {
         edtavEliminarsvg_Visible = 1 ;
      }
      else
      {
         edtavEliminarsvg_Visible = 0 ;
      }
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

   public void e12JI2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "Variable_listarWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80ManageFiltersData", AV80ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV77TFVarRelRef_Sels", AV77TFVarRelRef_Sels);
   }

   public void e13JI2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("Variable_listarWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV95Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV82ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV82ManageFiltersExecutionStep", GXutil.str( AV82ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("Variable_listarWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV82ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV82ManageFiltersExecutionStep", GXutil.str( AV82ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char12 = AV81ManageFiltersXml ;
         GXv_char10[0] = GXt_char12 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "Variable_listarWWFilters", Ddo_managefilters_Activeeventkey, GXv_char10) ;
         variable_listarww_impl.this.GXt_char12 = GXv_char10[0] ;
         AV81ManageFiltersXml = GXt_char12 ;
         if ( (GXutil.strcmp("", AV81ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV95Pgmname+"GridState", AV81ManageFiltersXml) ;
            AV12GridState.fromxml(AV81ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV26TFOpeCliId_Sels", AV26TFOpeCliId_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV29TFOpeCliCodFormula_Sels", AV29TFOpeCliCodFormula_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV32TFOpeCliDescrip_Sels", AV32TFOpeCliDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV77TFVarRelRef_Sels", AV77TFVarRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80ManageFiltersData", AV80ManageFiltersData);
   }

   public void e22JI2( )
   {
      /* Scrape_Click Routine */
      returnInSub = false ;
      httpContext.popup(formatLink("web.variablescrape", new String[] {GXutil.URLEncode(GXutil.rtrim(A82OpeCliId))}, new String[] {"OpeCliId"}) , new Object[] {});
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80ManageFiltersData", AV80ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV77TFVarRelRef_Sels", AV77TFVarRelRef_Sels);
   }

   public void e17JI2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char10[0] = AV17ExcelFilename ;
      GXv_char9[0] = AV18ErrorMessage ;
      new web.variable_listarwwexport(remoteHandle, context).execute( GXv_char10, GXv_char9) ;
      variable_listarww_impl.this.AV17ExcelFilename = GXv_char10[0] ;
      variable_listarww_impl.this.AV18ErrorMessage = GXv_char9[0] ;
      if ( GXutil.strcmp(AV17ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV17ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV18ErrorMessage);
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
      AV21ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "OpeCliId", "", "Código", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "OpeCliCodFormula", "", "Código", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "OpeCliDescrip", "", "Descripción", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "OpeCliEsCant", "", "Es cantidad", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "OpeCliAliEs", "", "Es alicuota", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "OpeCliUltVal", "", "Ultimo valor", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "VarFecProx", "", "Fecha próx. act.", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV46CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "VarRelRef", "", "Release", true, "") ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "", "", "", false, "") ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
         AV76TFVarRelRef = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76TFVarRelRef", AV76TFVarRelRef);
         AV77TFVarRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      }
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "VarFrecAct", "", "Frecuencia de actualizaciòn", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&VerSVG", "", "", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&ModificarSVG", "", "", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&EliminarSVG", "", "", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXt_char12 = AV20UserCustomValue ;
      GXv_char10[0] = GXt_char12 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Variable_listarWWColumnsSelector", GXv_char10) ;
      variable_listarww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV20UserCustomValue = GXt_char12 ;
      if ( ! ( (GXutil.strcmp("", AV20UserCustomValue)==0) ) )
      {
         AV22ColumnsSelectorAux.fromxml(AV20UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector17[0] = AV21ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, GXv_SdtWWPColumnsSelector17) ;
         AV22ColumnsSelectorAux = GXv_SdtWWPColumnsSelector16[0] ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector17[0] ;
      }
      GXv_SdtWWPColumnsSelector17[0] = AV21ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV46CliCod, GXv_SdtWWPColumnsSelector17) ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector17[0] ;
      GXv_SdtWWPColumnsSelector17[0] = AV21ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV46CliCod, GXv_SdtWWPColumnsSelector17) ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector17[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean13 = AV41TempBoolean ;
      GXv_boolean11[0] = GXt_boolean13 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariableValores", GXv_boolean11) ;
      variable_listarww_impl.this.GXt_boolean13 = GXv_boolean11[0] ;
      AV41TempBoolean = GXt_boolean13 ;
      if ( AV41TempBoolean )
      {
         GXt_boolean13 = AV41TempBoolean ;
         GXv_boolean11[0] = GXt_boolean13 ;
         new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean11) ;
         variable_listarww_impl.this.GXt_boolean13 = GXv_boolean11[0] ;
         AV41TempBoolean = GXt_boolean13 ;
         if ( ! ( AV41TempBoolean ) )
         {
            bttBtnvariablesvalores_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnvariablesvalores_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnvariablesvalores_Visible), 5, 0), true);
         }
      }
      else
      {
         bttBtnvariablesvalores_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnvariablesvalores_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnvariablesvalores_Visible), 5, 0), true);
      }
      GXt_boolean13 = AV61IsAuthorized_Scrape ;
      GXv_boolean11[0] = GXt_boolean13 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "VariableScrape", GXv_boolean11) ;
      variable_listarww_impl.this.GXt_boolean13 = GXv_boolean11[0] ;
      AV61IsAuthorized_Scrape = GXt_boolean13 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61IsAuthorized_Scrape", AV61IsAuthorized_Scrape);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SCRAPE", getSecureSignedToken( "", AV61IsAuthorized_Scrape));
      if ( ! ( AV61IsAuthorized_Scrape ) )
      {
         edtavScrape_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavScrape_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavScrape_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean13 = AV43IsAuthorized_Update ;
      GXv_boolean11[0] = GXt_boolean13 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariable_listar_Update", GXv_boolean11) ;
      variable_listarww_impl.this.GXt_boolean13 = GXv_boolean11[0] ;
      AV43IsAuthorized_Update = GXt_boolean13 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43IsAuthorized_Update", AV43IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV43IsAuthorized_Update));
      if ( ! ( AV43IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean13 = AV45IsAuthorized_Delete ;
      GXv_boolean11[0] = GXt_boolean13 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariable_listar_Delete", GXv_boolean11) ;
      variable_listarww_impl.this.GXt_boolean13 = GXv_boolean11[0] ;
      AV45IsAuthorized_Delete = GXt_boolean13 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45IsAuthorized_Delete", AV45IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV45IsAuthorized_Delete));
      if ( ! ( AV45IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean13 = AV41TempBoolean ;
      GXv_boolean11[0] = GXt_boolean13 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariable_listar_Insert", GXv_boolean11) ;
      variable_listarww_impl.this.GXt_boolean13 = GXv_boolean11[0] ;
      AV41TempBoolean = GXt_boolean13 ;
      if ( ! ( AV41TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = AV80ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "Variable_listarWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19[0] ;
      AV80ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV25TFOpeCliId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25TFOpeCliId", AV25TFOpeCliId);
      AV26TFOpeCliId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28TFOpeCliCodFormula = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFOpeCliCodFormula", AV28TFOpeCliCodFormula);
      AV29TFOpeCliCodFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31TFOpeCliDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFOpeCliDescrip", AV31TFOpeCliDescrip);
      AV32TFOpeCliDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV34TFOpeCliEsCant_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFOpeCliEsCant_Sel", GXutil.str( AV34TFOpeCliEsCant_Sel, 1, 0));
      AV35TFOpeCliAliEs_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFOpeCliAliEs_Sel", GXutil.str( AV35TFOpeCliAliEs_Sel, 1, 0));
      AV76TFVarRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76TFVarRelRef", AV76TFVarRelRef);
      AV77TFVarRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV78TFVarFrecAct = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78TFVarFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFVarFrecAct), 2, 0));
      AV79TFVarFrecAct_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79TFVarFrecAct_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79TFVarFrecAct_To), 2, 0));
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
      if ( GXutil.strcmp(AV23Session.getValue(AV95Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV95Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV23Session.getValue(AV95Pgmname+"GridState"), null, null);
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
      AV108GXV1 = 1 ;
      while ( AV108GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV108GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIID") == 0 )
         {
            AV25TFOpeCliId = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFOpeCliId", AV25TFOpeCliId);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIID_SEL") == 0 )
         {
            AV24TFOpeCliId_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFOpeCliId_SelsJson", AV24TFOpeCliId_SelsJson);
            AV26TFOpeCliId_Sels.fromJSonString(AV24TFOpeCliId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLICODFORMULA") == 0 )
         {
            AV28TFOpeCliCodFormula = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFOpeCliCodFormula", AV28TFOpeCliCodFormula);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLICODFORMULA_SEL") == 0 )
         {
            AV27TFOpeCliCodFormula_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFOpeCliCodFormula_SelsJson", AV27TFOpeCliCodFormula_SelsJson);
            AV29TFOpeCliCodFormula_Sels.fromJSonString(AV27TFOpeCliCodFormula_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIDESCRIP") == 0 )
         {
            AV31TFOpeCliDescrip = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFOpeCliDescrip", AV31TFOpeCliDescrip);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIDESCRIP_SEL") == 0 )
         {
            AV30TFOpeCliDescrip_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFOpeCliDescrip_SelsJson", AV30TFOpeCliDescrip_SelsJson);
            AV32TFOpeCliDescrip_Sels.fromJSonString(AV30TFOpeCliDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIESCANT_SEL") == 0 )
         {
            AV34TFOpeCliEsCant_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFOpeCliEsCant_Sel", GXutil.str( AV34TFOpeCliEsCant_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIALIES_SEL") == 0 )
         {
            AV35TFOpeCliAliEs_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFOpeCliAliEs_Sel", GXutil.str( AV35TFOpeCliAliEs_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFVARRELREF") == 0 )
         {
            AV76TFVarRelRef = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TFVarRelRef", AV76TFVarRelRef);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFVARRELREF_SEL") == 0 )
         {
            AV75TFVarRelRef_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFVarRelRef_SelsJson", AV75TFVarRelRef_SelsJson);
            AV77TFVarRelRef_Sels.fromJSonString(AV75TFVarRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFVARFRECACT") == 0 )
         {
            AV78TFVarFrecAct = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFVarFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFVarFrecAct), 2, 0));
            AV79TFVarFrecAct_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFVarFrecAct_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79TFVarFrecAct_To), 2, 0));
         }
         AV108GXV1 = (int)(AV108GXV1+1) ;
      }
      GXt_char12 = "" ;
      GXv_char10[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV26TFOpeCliId_Sels.size()==0), AV24TFOpeCliId_SelsJson, GXv_char10) ;
      variable_listarww_impl.this.GXt_char12 = GXv_char10[0] ;
      GXt_char1 = "" ;
      GXv_char9[0] = GXt_char1 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV29TFOpeCliCodFormula_Sels.size()==0), AV27TFOpeCliCodFormula_SelsJson, GXv_char9) ;
      variable_listarww_impl.this.GXt_char1 = GXv_char9[0] ;
      GXt_char20 = "" ;
      GXv_char2[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV32TFOpeCliDescrip_Sels.size()==0), AV30TFOpeCliDescrip_SelsJson, GXv_char2) ;
      variable_listarww_impl.this.GXt_char20 = GXv_char2[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV77TFVarRelRef_Sels.size()==0), AV75TFVarRelRef_SelsJson, GXv_char22) ;
      variable_listarww_impl.this.GXt_char21 = GXv_char22[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char12+"|"+GXt_char1+"|"+GXt_char20+"|"+((0==AV34TFOpeCliEsCant_Sel) ? "" : GXutil.str( AV34TFOpeCliEsCant_Sel, 1, 0))+"|"+((0==AV35TFOpeCliAliEs_Sel) ? "" : GXutil.str( AV35TFOpeCliAliEs_Sel, 1, 0))+"|||"+GXt_char21+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV25TFOpeCliId)==0), AV25TFOpeCliId, GXv_char22) ;
      variable_listarww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char20 = "" ;
      GXv_char10[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV28TFOpeCliCodFormula)==0), AV28TFOpeCliCodFormula, GXv_char10) ;
      variable_listarww_impl.this.GXt_char20 = GXv_char10[0] ;
      GXt_char12 = "" ;
      GXv_char9[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFOpeCliDescrip)==0), AV31TFOpeCliDescrip, GXv_char9) ;
      variable_listarww_impl.this.GXt_char12 = GXv_char9[0] ;
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV76TFVarRelRef)==0), AV76TFVarRelRef, GXv_char2) ;
      variable_listarww_impl.this.GXt_char1 = GXv_char2[0] ;
      Ddo_grid_Filteredtext_set = GXt_char21+"|"+GXt_char20+"|"+GXt_char12+"|||||"+GXt_char1+"|"+((0==AV78TFVarFrecAct) ? "" : GXutil.str( AV78TFVarFrecAct, 2, 0)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "||||||||"+((0==AV79TFVarFrecAct_To) ? "" : GXutil.str( AV79TFVarFrecAct_To, 2, 0)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV23Session.getValue(AV95Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState23[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState23, "TFOPECLIID", httpContext.getMessage( "Código", ""), !(GXutil.strcmp("", AV25TFOpeCliId)==0), (short)(0), AV25TFOpeCliId, "", !(AV26TFOpeCliId_Sels.size()==0), AV26TFOpeCliId_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState23[0] ;
      GXv_SdtWWPGridState23[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState23, "TFOPECLICODFORMULA", httpContext.getMessage( "Código", ""), !(GXutil.strcmp("", AV28TFOpeCliCodFormula)==0), (short)(0), AV28TFOpeCliCodFormula, "", !(AV29TFOpeCliCodFormula_Sels.size()==0), AV29TFOpeCliCodFormula_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState23[0] ;
      GXv_SdtWWPGridState23[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState23, "TFOPECLIDESCRIP", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV31TFOpeCliDescrip)==0), (short)(0), AV31TFOpeCliDescrip, "", !(AV32TFOpeCliDescrip_Sels.size()==0), AV32TFOpeCliDescrip_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState23[0] ;
      GXv_SdtWWPGridState23[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState23, "TFOPECLIESCANT_SEL", httpContext.getMessage( "Es cantidad", ""), !(0==AV34TFOpeCliEsCant_Sel), (short)(0), GXutil.trim( GXutil.str( AV34TFOpeCliEsCant_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState23[0] ;
      GXv_SdtWWPGridState23[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState23, "TFOPECLIALIES_SEL", httpContext.getMessage( "Es alicuota", ""), !(0==AV35TFOpeCliAliEs_Sel), (short)(0), GXutil.trim( GXutil.str( AV35TFOpeCliAliEs_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState23[0] ;
      GXv_SdtWWPGridState23[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState23, "TFVARRELREF", httpContext.getMessage( "Release", ""), !(GXutil.strcmp("", AV76TFVarRelRef)==0), (short)(0), AV76TFVarRelRef, "", !(AV77TFVarRelRef_Sels.size()==0), AV77TFVarRelRef_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState23[0] ;
      GXv_SdtWWPGridState23[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState23, "TFVARFRECACT", httpContext.getMessage( "Frecuencia de actualizaciòn", ""), !((0==AV78TFVarFrecAct)&&(0==AV79TFVarFrecAct_To)), (short)(0), GXutil.trim( GXutil.str( AV78TFVarFrecAct, 2, 0)), GXutil.trim( GXutil.str( AV79TFVarFrecAct_To, 2, 0))) ;
      AV12GridState = GXv_SdtWWPGridState23[0] ;
      if ( ! (GXutil.strcmp("", AV66MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV66MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV95Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV95Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Variable_listar" );
      AV23Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e18JI2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV68WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean11[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV66MenuOpcCod, GXv_boolean11) ;
         GXv_char22[0] = AV70textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV46CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char22) ;
         variable_listarww_impl.this.AV70textoNoMostrara = GXv_char22[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV70textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean11[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV66MenuOpcCod, GXv_boolean11) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_JI2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_JI2( true) ;
      }
      else
      {
         wb_table2_12_JI2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_JI2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_JI2e( true) ;
      }
      else
      {
         wb_table1_9_JI2e( false) ;
      }
   }

   public void wb_table2_12_JI2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e23ji1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_Variable_listarWW.htm");
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
         AV74WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV74WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV94Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV74WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV74WelcomeMessage_Foto)==0) ? AV94Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV74WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV74WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Variable_listarWW.htm");
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
         wb_table3_30_JI2( true) ;
      }
      else
      {
         wb_table3_30_JI2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_JI2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_JI2( true) ;
      }
      else
      {
         wb_table4_35_JI2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_JI2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV68WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_Variable_listarWW.htm");
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
         wb_table5_54_JI2( true) ;
      }
      else
      {
         wb_table5_54_JI2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_JI2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_JI2( true) ;
      }
      else
      {
         wb_table6_63_JI2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_JI2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV38GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV39GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV40GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_JI2e( true) ;
      }
      else
      {
         wb_table2_12_JI2e( false) ;
      }
   }

   public void wb_table6_63_JI2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Variable_listarWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Variable_listarWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV36DDO_TitleSettingsIcons);
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV80ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 7, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e24ji1_client"+"'", TempTags, "", 2, "HLP_Variable_listarWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Variable_listarWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Variable_listarWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Variable_listarWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_JI2( true) ;
      }
      else
      {
         wb_table7_99_JI2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_JI2e( boolean wbgen )
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
         wb_table6_63_JI2e( true) ;
      }
      else
      {
         wb_table6_63_JI2e( false) ;
      }
   }

   public void wb_table7_99_JI2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_Variable_listarWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_JI2e( true) ;
      }
      else
      {
         wb_table7_99_JI2e( false) ;
      }
   }

   public void wb_table5_54_JI2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_Variable_listarWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_Variable_listarWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_JI2e( true) ;
      }
      else
      {
         wb_table5_54_JI2e( false) ;
      }
   }

   public void wb_table4_35_JI2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_Variable_listarWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_JI2e( true) ;
      }
      else
      {
         wb_table4_35_JI2e( false) ;
      }
   }

   public void wb_table3_30_JI2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_Variable_listarWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_JI2e( true) ;
      }
      else
      {
         wb_table3_30_JI2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV66MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66MenuOpcCod", AV66MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV66MenuOpcCod, ""))));
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
      paJI2( ) ;
      wsJI2( ) ;
      weJI2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020442387", true, true);
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
      httpContext.AddJavascriptSource("variable_listarww.js", "?2024122020442388", false, true);
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
      edtOpeCliId_Internalname = "OPECLIID_"+sGXsfl_110_idx ;
      edtOpeCliCodFormula_Internalname = "OPECLICODFORMULA_"+sGXsfl_110_idx ;
      edtOpeCliDescrip_Internalname = "OPECLIDESCRIP_"+sGXsfl_110_idx ;
      edtavScrape_Internalname = "vSCRAPE_"+sGXsfl_110_idx ;
      chkOpeCliEsCant.setInternalname( "OPECLIESCANT_"+sGXsfl_110_idx );
      chkOpeCliAliEs.setInternalname( "OPECLIALIES_"+sGXsfl_110_idx );
      edtOpeCliUltVal_Internalname = "OPECLIULTVAL_"+sGXsfl_110_idx ;
      edtVarFecProx_Internalname = "VARFECPROX_"+sGXsfl_110_idx ;
      edtVarRelRef_Internalname = "VARRELREF_"+sGXsfl_110_idx ;
      edtVarFrecAct_Internalname = "VARFRECACT_"+sGXsfl_110_idx ;
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
      edtOpeCliId_Internalname = "OPECLIID_"+sGXsfl_110_fel_idx ;
      edtOpeCliCodFormula_Internalname = "OPECLICODFORMULA_"+sGXsfl_110_fel_idx ;
      edtOpeCliDescrip_Internalname = "OPECLIDESCRIP_"+sGXsfl_110_fel_idx ;
      edtavScrape_Internalname = "vSCRAPE_"+sGXsfl_110_fel_idx ;
      chkOpeCliEsCant.setInternalname( "OPECLIESCANT_"+sGXsfl_110_fel_idx );
      chkOpeCliAliEs.setInternalname( "OPECLIALIES_"+sGXsfl_110_fel_idx );
      edtOpeCliUltVal_Internalname = "OPECLIULTVAL_"+sGXsfl_110_fel_idx ;
      edtVarFecProx_Internalname = "VARFECPROX_"+sGXsfl_110_fel_idx ;
      edtVarRelRef_Internalname = "VARRELREF_"+sGXsfl_110_fel_idx ;
      edtVarFrecAct_Internalname = "VARFRECACT_"+sGXsfl_110_fel_idx ;
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
      wbJI0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtOpeCliId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOpeCliId_Internalname,GXutil.rtrim( A82OpeCliId),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOpeCliId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOpeCliId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtOpeCliCodFormula_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOpeCliCodFormula_Internalname,GXutil.rtrim( A549OpeCliCodFormula),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOpeCliCodFormula_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOpeCliCodFormula_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtOpeCliDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOpeCliDescrip_Internalname,A534OpeCliDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOpeCliDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOpeCliDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Descrip","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavScrape_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavScrape_Enabled!=0)&&(edtavScrape_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 115,'',false,'"+sGXsfl_110_idx+"',110)\"" : " ") ;
         ROClassString = edtavScrape_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavScrape_Internalname,GXutil.rtrim( AV60Scrape),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavScrape_Enabled!=0)&&(edtavScrape_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,115);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVSCRAPE.CLICK."+sGXsfl_110_idx+"'","","","","",edtavScrape_Jsonclick,Integer.valueOf(5),edtavScrape_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavScrape_Visible),Integer.valueOf(edtavScrape_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkOpeCliEsCant.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "OPECLIESCANT_" + sGXsfl_110_idx ;
         chkOpeCliEsCant.setName( GXCCtl );
         chkOpeCliEsCant.setWebtags( "" );
         chkOpeCliEsCant.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "TitleCaption", chkOpeCliEsCant.getCaption(), !bGXsfl_110_Refreshing);
         chkOpeCliEsCant.setCheckedValue( "false" );
         A931OpeCliEsCant = GXutil.strtobool( GXutil.booltostr( A931OpeCliEsCant)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkOpeCliEsCant.getInternalname(),GXutil.booltostr( A931OpeCliEsCant),"","",Integer.valueOf(chkOpeCliEsCant.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkOpeCliAliEs.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "OPECLIALIES_" + sGXsfl_110_idx ;
         chkOpeCliAliEs.setName( GXCCtl );
         chkOpeCliAliEs.setWebtags( "" );
         chkOpeCliAliEs.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "TitleCaption", chkOpeCliAliEs.getCaption(), !bGXsfl_110_Refreshing);
         chkOpeCliAliEs.setCheckedValue( "false" );
         A934OpeCliAliEs = GXutil.strtobool( GXutil.booltostr( A934OpeCliAliEs)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkOpeCliAliEs.getInternalname(),GXutil.booltostr( A934OpeCliAliEs),"","",Integer.valueOf(chkOpeCliAliEs.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtOpeCliUltVal_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOpeCliUltVal_Internalname,A1828OpeCliUltVal,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOpeCliUltVal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtOpeCliUltVal_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtVarFecProx_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVarFecProx_Internalname,localUtil.format(A1922VarFecProx, "99/99/99"),localUtil.format( A1922VarFecProx, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVarFecProx_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtVarFecProx_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtVarRelRef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVarRelRef_Internalname,A2011VarRelRef,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVarRelRef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtVarRelRef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtVarFrecAct_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVarFrecAct_Internalname,GXutil.ltrim( localUtil.ntoc( A1913VarFrecAct, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1913VarFrecAct), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVarFrecAct_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtVarFrecAct_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 122,'',false,'"+sGXsfl_110_idx+"',110)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV42Update),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,122);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 123,'',false,'"+sGXsfl_110_idx+"',110)\"" : " ") ;
         ROClassString = edtavDelete_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV44Delete),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,123);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),edtavDelete_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 124,'',false,'"+sGXsfl_110_idx+"',110)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV65Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,124);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 125,'',false,'"+sGXsfl_110_idx+"',110)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV62VerSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,125);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavModificarsvg_Enabled!=0)&&(edtavModificarsvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 126,'',false,'"+sGXsfl_110_idx+"',110)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV63ModificarSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavModificarsvg_Enabled!=0)&&(edtavModificarsvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,126);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminarsvg_Enabled!=0)&&(edtavEliminarsvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 127,'',false,'"+sGXsfl_110_idx+"',110)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV64EliminarSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminarsvg_Enabled!=0)&&(edtavEliminarsvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,127);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesJI2( ) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOpeCliId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOpeCliCodFormula_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOpeCliDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavScrape_Class+"\" "+" style=\""+((edtavScrape_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkOpeCliEsCant.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Es cantidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkOpeCliAliEs.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Es alicuota", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOpeCliUltVal_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Ultimo valor", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtVarFecProx_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha próx. act.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtVarRelRef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Release", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtVarFrecAct_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Frecuencia de actualizaciòn", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavDelete_Class+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A82OpeCliId));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOpeCliId_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A549OpeCliCodFormula));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOpeCliCodFormula_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A534OpeCliDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOpeCliDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV60Scrape));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavScrape_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavScrape_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavScrape_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A931OpeCliEsCant));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkOpeCliEsCant.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A934OpeCliAliEs));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkOpeCliAliEs.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1828OpeCliUltVal);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOpeCliUltVal_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A1922VarFecProx, "99/99/99"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtVarFecProx_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2011VarRelRef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtVarRelRef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1913VarFrecAct, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtVarFrecAct_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV42Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV44Delete));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavDelete_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV65Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV62VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV63ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV64EliminarSVG));
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
      edtOpeCliId_Internalname = "OPECLIID" ;
      edtOpeCliCodFormula_Internalname = "OPECLICODFORMULA" ;
      edtOpeCliDescrip_Internalname = "OPECLIDESCRIP" ;
      edtavScrape_Internalname = "vSCRAPE" ;
      chkOpeCliEsCant.setInternalname( "OPECLIESCANT" );
      chkOpeCliAliEs.setInternalname( "OPECLIALIES" );
      edtOpeCliUltVal_Internalname = "OPECLIULTVAL" ;
      edtVarFecProx_Internalname = "VARFECPROX" ;
      edtVarRelRef_Internalname = "VARRELREF" ;
      edtVarFrecAct_Internalname = "VARFRECACT" ;
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
      bttBtnvariablesvalores_Internalname = "BTNVARIABLESVALORES" ;
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
      edtavEliminarsvg_Enabled = 1 ;
      edtavEliminarsvg_Format = (short)(0) ;
      edtavModificarsvg_Jsonclick = "" ;
      edtavModificarsvg_Columnclass = "WWColumn" ;
      edtavModificarsvg_Link = "" ;
      edtavModificarsvg_Enabled = 1 ;
      edtavModificarsvg_Format = (short)(0) ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 1 ;
      edtavVersvg_Format = (short)(0) ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 1 ;
      edtavDisplay_Visible = -1 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Class = "Attribute" ;
      edtavDelete_Enabled = 1 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 1 ;
      edtVarFrecAct_Jsonclick = "" ;
      edtVarRelRef_Jsonclick = "" ;
      edtVarFecProx_Jsonclick = "" ;
      edtOpeCliUltVal_Jsonclick = "" ;
      chkOpeCliAliEs.setCaption( "" );
      chkOpeCliEsCant.setCaption( "" );
      edtavScrape_Jsonclick = "" ;
      edtavScrape_Class = "Attribute" ;
      edtavScrape_Enabled = 1 ;
      edtOpeCliDescrip_Jsonclick = "" ;
      edtOpeCliCodFormula_Jsonclick = "" ;
      edtOpeCliId_Jsonclick = "" ;
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
      edtavScrape_Visible = -1 ;
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
      edtVarFrecAct_Visible = -1 ;
      edtVarRelRef_Visible = -1 ;
      edtVarFecProx_Visible = -1 ;
      edtOpeCliUltVal_Visible = -1 ;
      chkOpeCliAliEs.setVisible( -1 );
      chkOpeCliEsCant.setVisible( -1 );
      edtOpeCliDescrip_Visible = -1 ;
      edtOpeCliCodFormula_Visible = -1 ;
      edtOpeCliId_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      bttBtnvariablesvalores_Visible = 1 ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "||||||||2.0" ;
      Ddo_grid_Datalistproc = "Variable_listarWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked||||" ;
      Ddo_grid_Allowmultipleselection = "T|T|T|||||T|" ;
      Ddo_grid_Datalisttype = "Dynamic|Dynamic|Dynamic|FixedValues|FixedValues|||Dynamic|" ;
      Ddo_grid_Includedatalist = "T|T|T|T|T|||T|" ;
      Ddo_grid_Filterisrange = "||||||||T" ;
      Ddo_grid_Filtertype = "Character|Character|Character|||||Character|Numeric" ;
      Ddo_grid_Includefilter = "T|T|T|||||T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|||T|T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|||6|7" ;
      Ddo_grid_Columnids = "1:OpeCliId|2:OpeCliCodFormula|3:OpeCliDescrip|5:OpeCliEsCant|6:OpeCliAliEs|7:OpeCliUltVal|8:VarFecProx|9:VarRelRef|10:VarFrecAct" ;
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
      Form.setCaption( httpContext.getMessage( "Variables", "") );
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
      AV68WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV68WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68WelcomeMessage_NoMostrarMas", AV68WelcomeMessage_NoMostrarMas);
      GXCCtl = "OPECLIESCANT_" + sGXsfl_110_idx ;
      chkOpeCliEsCant.setName( GXCCtl );
      chkOpeCliEsCant.setWebtags( "" );
      chkOpeCliEsCant.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "TitleCaption", chkOpeCliEsCant.getCaption(), !bGXsfl_110_Refreshing);
      chkOpeCliEsCant.setCheckedValue( "false" );
      A931OpeCliEsCant = GXutil.strtobool( GXutil.booltostr( A931OpeCliEsCant)) ;
      GXCCtl = "OPECLIALIES_" + sGXsfl_110_idx ;
      chkOpeCliAliEs.setName( GXCCtl );
      chkOpeCliAliEs.setWebtags( "" );
      chkOpeCliAliEs.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "TitleCaption", chkOpeCliAliEs.getCaption(), !bGXsfl_110_Refreshing);
      chkOpeCliAliEs.setCheckedValue( "false" );
      A934OpeCliAliEs = GXutil.strtobool( GXutil.booltostr( A934OpeCliAliEs)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV95Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFOpeCliId',fld:'vTFOPECLIID',pic:''},{av:'AV26TFOpeCliId_Sels',fld:'vTFOPECLIID_SELS',pic:''},{av:'AV28TFOpeCliCodFormula',fld:'vTFOPECLICODFORMULA',pic:''},{av:'AV29TFOpeCliCodFormula_Sels',fld:'vTFOPECLICODFORMULA_SELS',pic:''},{av:'AV31TFOpeCliDescrip',fld:'vTFOPECLIDESCRIP',pic:''},{av:'AV32TFOpeCliDescrip_Sels',fld:'vTFOPECLIDESCRIP_SELS',pic:''},{av:'AV34TFOpeCliEsCant_Sel',fld:'vTFOPECLIESCANT_SEL',pic:'9'},{av:'AV35TFOpeCliAliEs_Sel',fld:'vTFOPECLIALIES_SEL',pic:'9'},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''},{av:'AV78TFVarFrecAct',fld:'vTFVARFRECACT',pic:'Z9'},{av:'AV79TFVarFrecAct_To',fld:'vTFVARFRECACT_TO',pic:'Z9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'AV51esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV52ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV68WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtOpeCliId_Visible',ctrl:'OPECLIID',prop:'Visible'},{av:'edtOpeCliCodFormula_Visible',ctrl:'OPECLICODFORMULA',prop:'Visible'},{av:'edtOpeCliDescrip_Visible',ctrl:'OPECLIDESCRIP',prop:'Visible'},{av:'chkOpeCliEsCant.getVisible()',ctrl:'OPECLIESCANT',prop:'Visible'},{av:'chkOpeCliAliEs.getVisible()',ctrl:'OPECLIALIES',prop:'Visible'},{av:'edtOpeCliUltVal_Visible',ctrl:'OPECLIULTVAL',prop:'Visible'},{av:'edtVarFecProx_Visible',ctrl:'VARFECPROX',prop:'Visible'},{av:'edtVarRelRef_Visible',ctrl:'VARRELREF',prop:'Visible'},{av:'edtVarFrecAct_Visible',ctrl:'VARFRECACT',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV38GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV39GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV40GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNVARIABLESVALORES',prop:'Visible'},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'edtavScrape_Visible',ctrl:'vSCRAPE',prop:'Visible'},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV80ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e14JI2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV95Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFOpeCliId',fld:'vTFOPECLIID',pic:''},{av:'AV26TFOpeCliId_Sels',fld:'vTFOPECLIID_SELS',pic:''},{av:'AV28TFOpeCliCodFormula',fld:'vTFOPECLICODFORMULA',pic:''},{av:'AV29TFOpeCliCodFormula_Sels',fld:'vTFOPECLICODFORMULA_SELS',pic:''},{av:'AV31TFOpeCliDescrip',fld:'vTFOPECLIDESCRIP',pic:''},{av:'AV32TFOpeCliDescrip_Sels',fld:'vTFOPECLIDESCRIP_SELS',pic:''},{av:'AV34TFOpeCliEsCant_Sel',fld:'vTFOPECLIESCANT_SEL',pic:'9'},{av:'AV35TFOpeCliAliEs_Sel',fld:'vTFOPECLIALIES_SEL',pic:'9'},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''},{av:'AV78TFVarFrecAct',fld:'vTFVARFRECACT',pic:'Z9'},{av:'AV79TFVarFrecAct_To',fld:'vTFVARFRECACT_TO',pic:'Z9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'AV51esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV52ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV68WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e15JI2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV95Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFOpeCliId',fld:'vTFOPECLIID',pic:''},{av:'AV26TFOpeCliId_Sels',fld:'vTFOPECLIID_SELS',pic:''},{av:'AV28TFOpeCliCodFormula',fld:'vTFOPECLICODFORMULA',pic:''},{av:'AV29TFOpeCliCodFormula_Sels',fld:'vTFOPECLICODFORMULA_SELS',pic:''},{av:'AV31TFOpeCliDescrip',fld:'vTFOPECLIDESCRIP',pic:''},{av:'AV32TFOpeCliDescrip_Sels',fld:'vTFOPECLIDESCRIP_SELS',pic:''},{av:'AV34TFOpeCliEsCant_Sel',fld:'vTFOPECLIESCANT_SEL',pic:'9'},{av:'AV35TFOpeCliAliEs_Sel',fld:'vTFOPECLIALIES_SEL',pic:'9'},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''},{av:'AV78TFVarFrecAct',fld:'vTFVARFRECACT',pic:'Z9'},{av:'AV79TFVarFrecAct_To',fld:'vTFVARFRECACT_TO',pic:'Z9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'AV51esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV52ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV68WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e16JI2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV95Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFOpeCliId',fld:'vTFOPECLIID',pic:''},{av:'AV26TFOpeCliId_Sels',fld:'vTFOPECLIID_SELS',pic:''},{av:'AV28TFOpeCliCodFormula',fld:'vTFOPECLICODFORMULA',pic:''},{av:'AV29TFOpeCliCodFormula_Sels',fld:'vTFOPECLICODFORMULA_SELS',pic:''},{av:'AV31TFOpeCliDescrip',fld:'vTFOPECLIDESCRIP',pic:''},{av:'AV32TFOpeCliDescrip_Sels',fld:'vTFOPECLIDESCRIP_SELS',pic:''},{av:'AV34TFOpeCliEsCant_Sel',fld:'vTFOPECLIESCANT_SEL',pic:'9'},{av:'AV35TFOpeCliAliEs_Sel',fld:'vTFOPECLIALIES_SEL',pic:'9'},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''},{av:'AV78TFVarFrecAct',fld:'vTFVARFRECACT',pic:'Z9'},{av:'AV79TFVarFrecAct_To',fld:'vTFVARFRECACT_TO',pic:'Z9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'AV51esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV52ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV68WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV78TFVarFrecAct',fld:'vTFVARFRECACT',pic:'Z9'},{av:'AV79TFVarFrecAct_To',fld:'vTFVARFRECACT_TO',pic:'Z9'},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV75TFVarRelRef_SelsJson',fld:'vTFVARRELREF_SELSJSON',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''},{av:'AV35TFOpeCliAliEs_Sel',fld:'vTFOPECLIALIES_SEL',pic:'9'},{av:'AV34TFOpeCliEsCant_Sel',fld:'vTFOPECLIESCANT_SEL',pic:'9'},{av:'AV31TFOpeCliDescrip',fld:'vTFOPECLIDESCRIP',pic:''},{av:'AV30TFOpeCliDescrip_SelsJson',fld:'vTFOPECLIDESCRIP_SELSJSON',pic:''},{av:'AV32TFOpeCliDescrip_Sels',fld:'vTFOPECLIDESCRIP_SELS',pic:''},{av:'AV28TFOpeCliCodFormula',fld:'vTFOPECLICODFORMULA',pic:''},{av:'AV27TFOpeCliCodFormula_SelsJson',fld:'vTFOPECLICODFORMULA_SELSJSON',pic:''},{av:'AV29TFOpeCliCodFormula_Sels',fld:'vTFOPECLICODFORMULA_SELS',pic:''},{av:'AV25TFOpeCliId',fld:'vTFOPECLIID',pic:''},{av:'AV24TFOpeCliId_SelsJson',fld:'vTFOPECLIID_SELSJSON',pic:''},{av:'AV26TFOpeCliId_Sels',fld:'vTFOPECLIID_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21JI2',iparms:[{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'A1910VarBaseURL',fld:'VARBASEURL',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'AV51esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV52ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:'',hsh:true},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A1906OpeCliIdPadre',fld:'OPECLIIDPADRE',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV60Scrape',fld:'vSCRAPE',pic:''},{av:'edtavScrape_Class',ctrl:'vSCRAPE',prop:'Class'},{av:'AV42Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV44Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtavDelete_Class',ctrl:'vDELETE',prop:'Class'},{av:'AV65Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV62VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV63ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV64EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e12JI2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV95Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFOpeCliId',fld:'vTFOPECLIID',pic:''},{av:'AV26TFOpeCliId_Sels',fld:'vTFOPECLIID_SELS',pic:''},{av:'AV28TFOpeCliCodFormula',fld:'vTFOPECLICODFORMULA',pic:''},{av:'AV29TFOpeCliCodFormula_Sels',fld:'vTFOPECLICODFORMULA_SELS',pic:''},{av:'AV31TFOpeCliDescrip',fld:'vTFOPECLIDESCRIP',pic:''},{av:'AV32TFOpeCliDescrip_Sels',fld:'vTFOPECLIDESCRIP_SELS',pic:''},{av:'AV34TFOpeCliEsCant_Sel',fld:'vTFOPECLIESCANT_SEL',pic:'9'},{av:'AV35TFOpeCliAliEs_Sel',fld:'vTFOPECLIALIES_SEL',pic:'9'},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''},{av:'AV78TFVarFrecAct',fld:'vTFVARFRECACT',pic:'Z9'},{av:'AV79TFVarFrecAct_To',fld:'vTFVARFRECACT_TO',pic:'Z9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'AV51esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV52ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV68WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtOpeCliId_Visible',ctrl:'OPECLIID',prop:'Visible'},{av:'edtOpeCliCodFormula_Visible',ctrl:'OPECLICODFORMULA',prop:'Visible'},{av:'edtOpeCliDescrip_Visible',ctrl:'OPECLIDESCRIP',prop:'Visible'},{av:'chkOpeCliEsCant.getVisible()',ctrl:'OPECLIESCANT',prop:'Visible'},{av:'chkOpeCliAliEs.getVisible()',ctrl:'OPECLIALIES',prop:'Visible'},{av:'edtOpeCliUltVal_Visible',ctrl:'OPECLIULTVAL',prop:'Visible'},{av:'edtVarFecProx_Visible',ctrl:'VARFECPROX',prop:'Visible'},{av:'edtVarRelRef_Visible',ctrl:'VARRELREF',prop:'Visible'},{av:'edtVarFrecAct_Visible',ctrl:'VARFRECACT',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV38GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV39GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV40GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNVARIABLESVALORES',prop:'Visible'},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'edtavScrape_Visible',ctrl:'vSCRAPE',prop:'Visible'},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV80ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e13JI2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV95Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFOpeCliId',fld:'vTFOPECLIID',pic:''},{av:'AV26TFOpeCliId_Sels',fld:'vTFOPECLIID_SELS',pic:''},{av:'AV28TFOpeCliCodFormula',fld:'vTFOPECLICODFORMULA',pic:''},{av:'AV29TFOpeCliCodFormula_Sels',fld:'vTFOPECLICODFORMULA_SELS',pic:''},{av:'AV31TFOpeCliDescrip',fld:'vTFOPECLIDESCRIP',pic:''},{av:'AV32TFOpeCliDescrip_Sels',fld:'vTFOPECLIDESCRIP_SELS',pic:''},{av:'AV34TFOpeCliEsCant_Sel',fld:'vTFOPECLIESCANT_SEL',pic:'9'},{av:'AV35TFOpeCliAliEs_Sel',fld:'vTFOPECLIALIES_SEL',pic:'9'},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''},{av:'AV78TFVarFrecAct',fld:'vTFVARFRECACT',pic:'Z9'},{av:'AV79TFVarFrecAct_To',fld:'vTFVARFRECACT_TO',pic:'Z9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'AV51esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV52ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV68WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV24TFOpeCliId_SelsJson',fld:'vTFOPECLIID_SELSJSON',pic:''},{av:'AV27TFOpeCliCodFormula_SelsJson',fld:'vTFOPECLICODFORMULA_SELSJSON',pic:''},{av:'AV30TFOpeCliDescrip_SelsJson',fld:'vTFOPECLIDESCRIP_SELSJSON',pic:''},{av:'AV75TFVarRelRef_SelsJson',fld:'vTFVARRELREF_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV25TFOpeCliId',fld:'vTFOPECLIID',pic:''},{av:'AV26TFOpeCliId_Sels',fld:'vTFOPECLIID_SELS',pic:''},{av:'AV28TFOpeCliCodFormula',fld:'vTFOPECLICODFORMULA',pic:''},{av:'AV29TFOpeCliCodFormula_Sels',fld:'vTFOPECLICODFORMULA_SELS',pic:''},{av:'AV31TFOpeCliDescrip',fld:'vTFOPECLIDESCRIP',pic:''},{av:'AV32TFOpeCliDescrip_Sels',fld:'vTFOPECLIDESCRIP_SELS',pic:''},{av:'AV34TFOpeCliEsCant_Sel',fld:'vTFOPECLIESCANT_SEL',pic:'9'},{av:'AV35TFOpeCliAliEs_Sel',fld:'vTFOPECLIALIES_SEL',pic:'9'},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''},{av:'AV78TFVarFrecAct',fld:'vTFVARFRECACT',pic:'Z9'},{av:'AV79TFVarFrecAct_To',fld:'vTFVARFRECACT_TO',pic:'Z9'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV75TFVarRelRef_SelsJson',fld:'vTFVARRELREF_SELSJSON',pic:''},{av:'AV30TFOpeCliDescrip_SelsJson',fld:'vTFOPECLIDESCRIP_SELSJSON',pic:''},{av:'AV27TFOpeCliCodFormula_SelsJson',fld:'vTFOPECLICODFORMULA_SELSJSON',pic:''},{av:'AV24TFOpeCliId_SelsJson',fld:'vTFOPECLIID_SELSJSON',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtOpeCliId_Visible',ctrl:'OPECLIID',prop:'Visible'},{av:'edtOpeCliCodFormula_Visible',ctrl:'OPECLICODFORMULA',prop:'Visible'},{av:'edtOpeCliDescrip_Visible',ctrl:'OPECLIDESCRIP',prop:'Visible'},{av:'chkOpeCliEsCant.getVisible()',ctrl:'OPECLIESCANT',prop:'Visible'},{av:'chkOpeCliAliEs.getVisible()',ctrl:'OPECLIALIES',prop:'Visible'},{av:'edtOpeCliUltVal_Visible',ctrl:'OPECLIULTVAL',prop:'Visible'},{av:'edtVarFecProx_Visible',ctrl:'VARFECPROX',prop:'Visible'},{av:'edtVarRelRef_Visible',ctrl:'VARRELREF',prop:'Visible'},{av:'edtVarFrecAct_Visible',ctrl:'VARFRECACT',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV38GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV39GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV40GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNVARIABLESVALORES',prop:'Visible'},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'edtavScrape_Visible',ctrl:'vSCRAPE',prop:'Visible'},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV80ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOVARIABLESVALORES'","{handler:'e11JI1',iparms:[{av:'AV66MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("'DOVARIABLESVALORES'",",oparms:[]}");
      setEventMetadata("VSCRAPE.CLICK","{handler:'e22JI2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV95Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFOpeCliId',fld:'vTFOPECLIID',pic:''},{av:'AV26TFOpeCliId_Sels',fld:'vTFOPECLIID_SELS',pic:''},{av:'AV28TFOpeCliCodFormula',fld:'vTFOPECLICODFORMULA',pic:''},{av:'AV29TFOpeCliCodFormula_Sels',fld:'vTFOPECLICODFORMULA_SELS',pic:''},{av:'AV31TFOpeCliDescrip',fld:'vTFOPECLIDESCRIP',pic:''},{av:'AV32TFOpeCliDescrip_Sels',fld:'vTFOPECLIDESCRIP_SELS',pic:''},{av:'AV34TFOpeCliEsCant_Sel',fld:'vTFOPECLIESCANT_SEL',pic:'9'},{av:'AV35TFOpeCliAliEs_Sel',fld:'vTFOPECLIALIES_SEL',pic:'9'},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''},{av:'AV78TFVarFrecAct',fld:'vTFVARFRECACT',pic:'Z9'},{av:'AV79TFVarFrecAct_To',fld:'vTFVARFRECACT_TO',pic:'Z9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'AV51esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV52ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV68WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'A82OpeCliId',fld:'OPECLIID',pic:'',hsh:true}]");
      setEventMetadata("VSCRAPE.CLICK",",oparms:[{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV82ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtOpeCliId_Visible',ctrl:'OPECLIID',prop:'Visible'},{av:'edtOpeCliCodFormula_Visible',ctrl:'OPECLICODFORMULA',prop:'Visible'},{av:'edtOpeCliDescrip_Visible',ctrl:'OPECLIDESCRIP',prop:'Visible'},{av:'chkOpeCliEsCant.getVisible()',ctrl:'OPECLIESCANT',prop:'Visible'},{av:'chkOpeCliAliEs.getVisible()',ctrl:'OPECLIALIES',prop:'Visible'},{av:'edtOpeCliUltVal_Visible',ctrl:'OPECLIULTVAL',prop:'Visible'},{av:'edtVarFecProx_Visible',ctrl:'VARFECPROX',prop:'Visible'},{av:'edtVarRelRef_Visible',ctrl:'VARRELREF',prop:'Visible'},{av:'edtVarFrecAct_Visible',ctrl:'VARFRECACT',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV38GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV39GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV40GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNVARIABLESVALORES',prop:'Visible'},{av:'AV61IsAuthorized_Scrape',fld:'vISAUTHORIZED_SCRAPE',pic:'',hsh:true},{av:'edtavScrape_Visible',ctrl:'vSCRAPE',prop:'Visible'},{av:'AV43IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV45IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV80ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV76TFVarRelRef',fld:'vTFVARRELREF',pic:''},{av:'AV77TFVarRelRef_Sels',fld:'vTFVARRELREF_SELS',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e24JI1',iparms:[{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17JI2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e18JI2',iparms:[{av:'AV68WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV66MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e23JI1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_OPECLIID","{handler:'valid_Opecliid',iparms:[]");
      setEventMetadata("VALID_OPECLIID",",oparms:[]}");
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
      wcpOAV66MenuOpcCod = "" ;
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
      AV66MenuOpcCod = "" ;
      AV21ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV95Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25TFOpeCliId = "" ;
      AV26TFOpeCliId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28TFOpeCliCodFormula = "" ;
      AV29TFOpeCliCodFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFOpeCliDescrip = "" ;
      AV32TFOpeCliDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76TFVarRelRef = "" ;
      AV77TFVarRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV36DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV80ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV40GridAppliedFilters = "" ;
      A1910VarBaseURL = "" ;
      A1906OpeCliIdPadre = "" ;
      AV24TFOpeCliId_SelsJson = "" ;
      AV27TFOpeCliCodFormula_SelsJson = "" ;
      AV30TFOpeCliDescrip_SelsJson = "" ;
      AV75TFVarRelRef_SelsJson = "" ;
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
      bttBtnvariablesvalores_Jsonclick = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A82OpeCliId = "" ;
      A549OpeCliCodFormula = "" ;
      A534OpeCliDescrip = "" ;
      AV60Scrape = "" ;
      A1828OpeCliUltVal = "" ;
      A1922VarFecProx = GXutil.nullDate() ;
      A2011VarRelRef = "" ;
      AV42Update = "" ;
      AV44Delete = "" ;
      AV65Display = "" ;
      AV62VerSVG = "" ;
      AV63ModificarSVG = "" ;
      AV64EliminarSVG = "" ;
      AV97Variable_listarwwds_2_tfopecliid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV99Variable_listarwwds_4_tfopeclicodformula_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV101Variable_listarwwds_6_tfopeclidescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV105Variable_listarwwds_10_tfvarrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV96Variable_listarwwds_1_tfopecliid = "" ;
      lV98Variable_listarwwds_3_tfopeclicodformula = "" ;
      lV100Variable_listarwwds_5_tfopeclidescrip = "" ;
      lV104Variable_listarwwds_9_tfvarrelref = "" ;
      AV96Variable_listarwwds_1_tfopecliid = "" ;
      AV98Variable_listarwwds_3_tfopeclicodformula = "" ;
      AV100Variable_listarwwds_5_tfopeclidescrip = "" ;
      AV104Variable_listarwwds_9_tfvarrelref = "" ;
      H00JI2_A1910VarBaseURL = new String[] {""} ;
      H00JI2_n1910VarBaseURL = new boolean[] {false} ;
      H00JI2_A1906OpeCliIdPadre = new String[] {""} ;
      H00JI2_A1913VarFrecAct = new byte[1] ;
      H00JI2_A2011VarRelRef = new String[] {""} ;
      H00JI2_A934OpeCliAliEs = new boolean[] {false} ;
      H00JI2_A931OpeCliEsCant = new boolean[] {false} ;
      H00JI2_A534OpeCliDescrip = new String[] {""} ;
      H00JI2_A549OpeCliCodFormula = new String[] {""} ;
      H00JI2_A82OpeCliId = new String[] {""} ;
      H00JI2_A3CliCod = new int[1] ;
      GXt_date3 = GXutil.nullDate() ;
      GXv_date4 = new java.util.Date[1] ;
      H00JI3_AGRID_nRecordCount = new long[1] ;
      AV74WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV69MenuBienveImgURL = "" ;
      AV71MenuBienveTitulo = "" ;
      AV72MenuBienveTexto = "" ;
      AV94Welcomemessage_foto_GXI = "" ;
      AV91observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int6 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext14 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV19ColumnsSelectorXML = "" ;
      AV87MenuOpcTitulo = "" ;
      GXv_int15 = new short[1] ;
      AV90filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV81ManageFiltersXml = "" ;
      AV17ExcelFilename = "" ;
      AV18ErrorMessage = "" ;
      AV20UserCustomValue = "" ;
      AV22ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector16 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector17 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char21 = "" ;
      GXt_char20 = "" ;
      GXv_char10 = new String[1] ;
      GXt_char12 = "" ;
      GXv_char9 = new String[1] ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_SdtWWPGridState23 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV70textoNoMostrara = "" ;
      GXv_char22 = new String[1] ;
      GXv_boolean11 = new boolean[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variable_listarww__default(),
         new Object[] {
             new Object[] {
            H00JI2_A1910VarBaseURL, H00JI2_n1910VarBaseURL, H00JI2_A1906OpeCliIdPadre, H00JI2_A1913VarFrecAct, H00JI2_A2011VarRelRef, H00JI2_A934OpeCliAliEs, H00JI2_A931OpeCliEsCant, H00JI2_A534OpeCliDescrip, H00JI2_A549OpeCliCodFormula, H00JI2_A82OpeCliId,
            H00JI2_A3CliCod
            }
            , new Object[] {
            H00JI3_AGRID_nRecordCount
            }
         }
      );
      AV95Pgmname = "Variable_listarWW" ;
      /* GeneXus formulas. */
      AV95Pgmname = "Variable_listarWW" ;
      Gx_err = (short)(0) ;
      edtavScrape_Enabled = 0 ;
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
   private byte AV82ManageFiltersExecutionStep ;
   private byte AV34TFOpeCliEsCant_Sel ;
   private byte AV35TFOpeCliAliEs_Sel ;
   private byte AV78TFVarFrecAct ;
   private byte AV79TFVarFrecAct_To ;
   private byte gxajaxcallmode ;
   private byte A1913VarFrecAct ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV102Variable_listarwwds_7_tfopecliescant_sel ;
   private byte AV103Variable_listarwwds_8_tfopeclialies_sel ;
   private byte AV106Variable_listarwwds_11_tfvarfrecact ;
   private byte AV107Variable_listarwwds_12_tfvarfrecact_to ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV14OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int15[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV46CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtnvariablesvalores_Visible ;
   private int A3CliCod ;
   private int subGrid_Islastpage ;
   private int edtavScrape_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV97Variable_listarwwds_2_tfopecliid_sels_size ;
   private int AV99Variable_listarwwds_4_tfopeclicodformula_sels_size ;
   private int AV101Variable_listarwwds_6_tfopeclidescrip_sels_size ;
   private int AV105Variable_listarwwds_10_tfvarrelref_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int5 ;
   private int GXv_int6[] ;
   private int edtOpeCliId_Visible ;
   private int edtOpeCliCodFormula_Visible ;
   private int edtOpeCliDescrip_Visible ;
   private int edtOpeCliUltVal_Visible ;
   private int edtVarFecProx_Visible ;
   private int edtVarRelRef_Visible ;
   private int edtVarFrecAct_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV89filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV37PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtavScrape_Visible ;
   private int bttBtninsert_Visible ;
   private int AV108GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV38GridCurrentPage ;
   private long AV39GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
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
   private String AV95Pgmname ;
   private String AV25TFOpeCliId ;
   private String AV28TFOpeCliCodFormula ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String A1906OpeCliIdPadre ;
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
   private String bttBtnvariablesvalores_Internalname ;
   private String bttBtnvariablesvalores_Jsonclick ;
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
   private String A82OpeCliId ;
   private String edtOpeCliId_Internalname ;
   private String A549OpeCliCodFormula ;
   private String edtOpeCliCodFormula_Internalname ;
   private String edtOpeCliDescrip_Internalname ;
   private String AV60Scrape ;
   private String edtavScrape_Internalname ;
   private String edtOpeCliUltVal_Internalname ;
   private String edtVarFecProx_Internalname ;
   private String edtVarRelRef_Internalname ;
   private String edtVarFrecAct_Internalname ;
   private String AV42Update ;
   private String edtavUpdate_Internalname ;
   private String AV44Delete ;
   private String edtavDelete_Internalname ;
   private String AV65Display ;
   private String edtavDisplay_Internalname ;
   private String AV62VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV63ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV64EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String lV96Variable_listarwwds_1_tfopecliid ;
   private String lV98Variable_listarwwds_3_tfopeclicodformula ;
   private String AV96Variable_listarwwds_1_tfopecliid ;
   private String AV98Variable_listarwwds_3_tfopeclicodformula ;
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
   private String AV91observerPalabra ;
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
   private String edtavScrape_Class ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtavDelete_Class ;
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String bttBtninsert_Internalname ;
   private String GXt_char21 ;
   private String GXt_char20 ;
   private String GXv_char10[] ;
   private String GXt_char12 ;
   private String GXv_char9[] ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String GXv_char22[] ;
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
   private String edtOpeCliId_Jsonclick ;
   private String edtOpeCliCodFormula_Jsonclick ;
   private String edtOpeCliDescrip_Jsonclick ;
   private String edtavScrape_Jsonclick ;
   private String GXCCtl ;
   private String edtOpeCliUltVal_Jsonclick ;
   private String edtVarFecProx_Jsonclick ;
   private String edtVarRelRef_Jsonclick ;
   private String edtVarFrecAct_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date A1922VarFecProx ;
   private java.util.Date GXt_date3 ;
   private java.util.Date GXv_date4[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV61IsAuthorized_Scrape ;
   private boolean AV51esSistemaConceptosDefault ;
   private boolean AV52ClienteConveniador ;
   private boolean AV43IsAuthorized_Update ;
   private boolean AV45IsAuthorized_Delete ;
   private boolean AV68WelcomeMessage_NoMostrarMas ;
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
   private boolean A931OpeCliEsCant ;
   private boolean A934OpeCliAliEs ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1910VarBaseURL ;
   private boolean returnInSub ;
   private boolean AV73MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean Cond_result ;
   private boolean AV41TempBoolean ;
   private boolean GXt_boolean13 ;
   private boolean GXv_boolean11[] ;
   private boolean AV74WelcomeMessage_Foto_IsBlob ;
   private String AV24TFOpeCliId_SelsJson ;
   private String AV27TFOpeCliCodFormula_SelsJson ;
   private String AV30TFOpeCliDescrip_SelsJson ;
   private String AV75TFVarRelRef_SelsJson ;
   private String AV72MenuBienveTexto ;
   private String AV19ColumnsSelectorXML ;
   private String AV81ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV70textoNoMostrara ;
   private String wcpOAV66MenuOpcCod ;
   private String AV66MenuOpcCod ;
   private String AV31TFOpeCliDescrip ;
   private String AV76TFVarRelRef ;
   private String AV40GridAppliedFilters ;
   private String A1910VarBaseURL ;
   private String A534OpeCliDescrip ;
   private String A1828OpeCliUltVal ;
   private String A2011VarRelRef ;
   private String lV100Variable_listarwwds_5_tfopeclidescrip ;
   private String lV104Variable_listarwwds_9_tfvarrelref ;
   private String AV100Variable_listarwwds_5_tfopeclidescrip ;
   private String AV104Variable_listarwwds_9_tfvarrelref ;
   private String AV69MenuBienveImgURL ;
   private String AV71MenuBienveTitulo ;
   private String AV94Welcomemessage_foto_GXI ;
   private String AV87MenuOpcTitulo ;
   private String AV90filtrosTexto ;
   private String AV17ExcelFilename ;
   private String AV18ErrorMessage ;
   private String AV74WelcomeMessage_Foto ;
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
   private GXSimpleCollection<String> AV97Variable_listarwwds_2_tfopecliid_sels ;
   private GXSimpleCollection<String> AV99Variable_listarwwds_4_tfopeclicodformula_sels ;
   private GXSimpleCollection<String> AV101Variable_listarwwds_6_tfopeclidescrip_sels ;
   private GXSimpleCollection<String> AV105Variable_listarwwds_10_tfvarrelref_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private ICheckbox chkOpeCliEsCant ;
   private ICheckbox chkOpeCliAliEs ;
   private IDataStoreProvider pr_default ;
   private String[] H00JI2_A1910VarBaseURL ;
   private boolean[] H00JI2_n1910VarBaseURL ;
   private String[] H00JI2_A1906OpeCliIdPadre ;
   private byte[] H00JI2_A1913VarFrecAct ;
   private String[] H00JI2_A2011VarRelRef ;
   private boolean[] H00JI2_A934OpeCliAliEs ;
   private boolean[] H00JI2_A931OpeCliEsCant ;
   private String[] H00JI2_A534OpeCliDescrip ;
   private String[] H00JI2_A549OpeCliCodFormula ;
   private String[] H00JI2_A82OpeCliId ;
   private int[] H00JI2_A3CliCod ;
   private long[] H00JI3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV26TFOpeCliId_Sels ;
   private GXSimpleCollection<String> AV29TFOpeCliCodFormula_Sels ;
   private GXSimpleCollection<String> AV32TFOpeCliDescrip_Sels ;
   private GXSimpleCollection<String> AV77TFVarRelRef_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV80ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext14[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState23[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector16[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector17[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV36DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8[] ;
}

final  class variable_listarww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00JI2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A82OpeCliId ,
                                          GXSimpleCollection<String> AV97Variable_listarwwds_2_tfopecliid_sels ,
                                          String A549OpeCliCodFormula ,
                                          GXSimpleCollection<String> AV99Variable_listarwwds_4_tfopeclicodformula_sels ,
                                          String A534OpeCliDescrip ,
                                          GXSimpleCollection<String> AV101Variable_listarwwds_6_tfopeclidescrip_sels ,
                                          String A2011VarRelRef ,
                                          GXSimpleCollection<String> AV105Variable_listarwwds_10_tfvarrelref_sels ,
                                          int AV97Variable_listarwwds_2_tfopecliid_sels_size ,
                                          String AV96Variable_listarwwds_1_tfopecliid ,
                                          int AV99Variable_listarwwds_4_tfopeclicodformula_sels_size ,
                                          String AV98Variable_listarwwds_3_tfopeclicodformula ,
                                          int AV101Variable_listarwwds_6_tfopeclidescrip_sels_size ,
                                          String AV100Variable_listarwwds_5_tfopeclidescrip ,
                                          byte AV102Variable_listarwwds_7_tfopecliescant_sel ,
                                          byte AV103Variable_listarwwds_8_tfopeclialies_sel ,
                                          int AV105Variable_listarwwds_10_tfvarrelref_sels_size ,
                                          String AV104Variable_listarwwds_9_tfvarrelref ,
                                          byte AV106Variable_listarwwds_11_tfvarfrecact ,
                                          byte AV107Variable_listarwwds_12_tfvarfrecact_to ,
                                          boolean A931OpeCliEsCant ,
                                          boolean A934OpeCliAliEs ,
                                          byte A1913VarFrecAct ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV46CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int24 = new byte[10];
      Object[] GXv_Object25 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " VarBaseURL, OpeCliIdPadre, VarFrecAct, VarRelRef, OpeCliAliEs, OpeCliEsCant, OpeCliDescrip, OpeCliCodFormula, OpeCliId, CliCod" ;
      sFromString = " FROM Variable" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV97Variable_listarwwds_2_tfopecliid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Variable_listarwwds_1_tfopecliid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliId) like LOWER(?))");
      }
      else
      {
         GXv_int24[1] = (byte)(1) ;
      }
      if ( AV97Variable_listarwwds_2_tfopecliid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Variable_listarwwds_2_tfopecliid_sels, "OpeCliId IN (", ")")+")");
      }
      if ( ( AV99Variable_listarwwds_4_tfopeclicodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98Variable_listarwwds_3_tfopeclicodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int24[2] = (byte)(1) ;
      }
      if ( AV99Variable_listarwwds_4_tfopeclicodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Variable_listarwwds_4_tfopeclicodformula_sels, "OpeCliCodFormula IN (", ")")+")");
      }
      if ( ( AV101Variable_listarwwds_6_tfopeclidescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Variable_listarwwds_5_tfopeclidescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int24[3] = (byte)(1) ;
      }
      if ( AV101Variable_listarwwds_6_tfopeclidescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Variable_listarwwds_6_tfopeclidescrip_sels, "OpeCliDescrip IN (", ")")+")");
      }
      if ( AV102Variable_listarwwds_7_tfopecliescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = TRUE)");
      }
      if ( AV102Variable_listarwwds_7_tfopecliescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = FALSE)");
      }
      if ( AV103Variable_listarwwds_8_tfopeclialies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = TRUE)");
      }
      if ( AV103Variable_listarwwds_8_tfopeclialies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = FALSE)");
      }
      if ( ( AV105Variable_listarwwds_10_tfvarrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV104Variable_listarwwds_9_tfvarrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(VarRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int24[4] = (byte)(1) ;
      }
      if ( AV105Variable_listarwwds_10_tfvarrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Variable_listarwwds_10_tfvarrelref_sels, "VarRelRef IN (", ")")+")");
      }
      if ( ! (0==AV106Variable_listarwwds_11_tfvarfrecact) )
      {
         addWhere(sWhereString, "(VarFrecAct >= ?)");
      }
      else
      {
         GXv_int24[5] = (byte)(1) ;
      }
      if ( ! (0==AV107Variable_listarwwds_12_tfvarfrecact_to) )
      {
         addWhere(sWhereString, "(VarFrecAct <= ?)");
      }
      else
      {
         GXv_int24[6] = (byte)(1) ;
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY OpeCliId, CliCod" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY OpeCliId DESC, CliCod" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY OpeCliCodFormula, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY OpeCliCodFormula DESC, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY OpeCliDescrip, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY OpeCliDescrip DESC, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY OpeCliEsCant, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY OpeCliEsCant DESC, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY OpeCliAliEs, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY OpeCliAliEs DESC, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY VarRelRef, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY VarRelRef DESC, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY VarFrecAct, CliCod, OpeCliId" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY VarFrecAct DESC, CliCod, OpeCliId" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, OpeCliId" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object25[0] = scmdbuf ;
      GXv_Object25[1] = GXv_int24 ;
      return GXv_Object25 ;
   }

   protected Object[] conditional_H00JI3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A82OpeCliId ,
                                          GXSimpleCollection<String> AV97Variable_listarwwds_2_tfopecliid_sels ,
                                          String A549OpeCliCodFormula ,
                                          GXSimpleCollection<String> AV99Variable_listarwwds_4_tfopeclicodformula_sels ,
                                          String A534OpeCliDescrip ,
                                          GXSimpleCollection<String> AV101Variable_listarwwds_6_tfopeclidescrip_sels ,
                                          String A2011VarRelRef ,
                                          GXSimpleCollection<String> AV105Variable_listarwwds_10_tfvarrelref_sels ,
                                          int AV97Variable_listarwwds_2_tfopecliid_sels_size ,
                                          String AV96Variable_listarwwds_1_tfopecliid ,
                                          int AV99Variable_listarwwds_4_tfopeclicodformula_sels_size ,
                                          String AV98Variable_listarwwds_3_tfopeclicodformula ,
                                          int AV101Variable_listarwwds_6_tfopeclidescrip_sels_size ,
                                          String AV100Variable_listarwwds_5_tfopeclidescrip ,
                                          byte AV102Variable_listarwwds_7_tfopecliescant_sel ,
                                          byte AV103Variable_listarwwds_8_tfopeclialies_sel ,
                                          int AV105Variable_listarwwds_10_tfvarrelref_sels_size ,
                                          String AV104Variable_listarwwds_9_tfvarrelref ,
                                          byte AV106Variable_listarwwds_11_tfvarfrecact ,
                                          byte AV107Variable_listarwwds_12_tfvarfrecact_to ,
                                          boolean A931OpeCliEsCant ,
                                          boolean A934OpeCliAliEs ,
                                          byte A1913VarFrecAct ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV46CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int27 = new byte[7];
      Object[] GXv_Object28 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV97Variable_listarwwds_2_tfopecliid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Variable_listarwwds_1_tfopecliid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliId) like LOWER(?))");
      }
      else
      {
         GXv_int27[1] = (byte)(1) ;
      }
      if ( AV97Variable_listarwwds_2_tfopecliid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Variable_listarwwds_2_tfopecliid_sels, "OpeCliId IN (", ")")+")");
      }
      if ( ( AV99Variable_listarwwds_4_tfopeclicodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98Variable_listarwwds_3_tfopeclicodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int27[2] = (byte)(1) ;
      }
      if ( AV99Variable_listarwwds_4_tfopeclicodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Variable_listarwwds_4_tfopeclicodformula_sels, "OpeCliCodFormula IN (", ")")+")");
      }
      if ( ( AV101Variable_listarwwds_6_tfopeclidescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Variable_listarwwds_5_tfopeclidescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int27[3] = (byte)(1) ;
      }
      if ( AV101Variable_listarwwds_6_tfopeclidescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Variable_listarwwds_6_tfopeclidescrip_sels, "OpeCliDescrip IN (", ")")+")");
      }
      if ( AV102Variable_listarwwds_7_tfopecliescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = TRUE)");
      }
      if ( AV102Variable_listarwwds_7_tfopecliescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = FALSE)");
      }
      if ( AV103Variable_listarwwds_8_tfopeclialies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = TRUE)");
      }
      if ( AV103Variable_listarwwds_8_tfopeclialies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = FALSE)");
      }
      if ( ( AV105Variable_listarwwds_10_tfvarrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV104Variable_listarwwds_9_tfvarrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(VarRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int27[4] = (byte)(1) ;
      }
      if ( AV105Variable_listarwwds_10_tfvarrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Variable_listarwwds_10_tfvarrelref_sels, "VarRelRef IN (", ")")+")");
      }
      if ( ! (0==AV106Variable_listarwwds_11_tfvarfrecact) )
      {
         addWhere(sWhereString, "(VarFrecAct >= ?)");
      }
      else
      {
         GXv_int27[5] = (byte)(1) ;
      }
      if ( ! (0==AV107Variable_listarwwds_12_tfvarfrecact_to) )
      {
         addWhere(sWhereString, "(VarFrecAct <= ?)");
      }
      else
      {
         GXv_int27[6] = (byte)(1) ;
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
      else if ( true )
      {
         scmdbuf += "" ;
      }
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
                  return conditional_H00JI2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() );
            case 1 :
                  return conditional_H00JI3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00JI2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00JI3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 40);
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 40);
               ((String[]) buf[9])[0] = rslt.getString(9, 40);
               ((int[]) buf[10])[0] = rslt.getInt(10);
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[16]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[13]).byteValue());
               }
               return;
      }
   }

}

