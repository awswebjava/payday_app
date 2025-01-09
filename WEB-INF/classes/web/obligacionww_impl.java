package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class obligacionww_impl extends GXDataArea
{
   public obligacionww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public obligacionww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obligacionww_impl.class ));
   }

   public obligacionww_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbOblEstado = new HTMLChoice();
      cmbOblOriPer = new HTMLChoice();
      chkOblNoRemu = UIFactory.getCheckbox(this);
      chkOblDescu = UIFactory.getCheckbox(this);
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
            AV68MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68MenuOpcCod", AV68MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV68MenuOpcCod, ""))));
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
      AV87ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV19ColumnsSelector);
      AV100Pgmname = httpContext.GetPar( "Pgmname") ;
      AV68MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV22TFOblSecuencial = (short)(GXutil.lval( httpContext.GetPar( "TFOblSecuencial"))) ;
      AV23TFOblSecuencial_To = (short)(GXutil.lval( httpContext.GetPar( "TFOblSecuencial_To"))) ;
      AV25TFLegIdNomApe = httpContext.GetPar( "TFLegIdNomApe") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV26TFLegIdNomApe_Sels);
      AV56TFTipoOblSec = (short)(GXutil.lval( httpContext.GetPar( "TFTipoOblSec"))) ;
      AV57TFTipoOblSec_To = (short)(GXutil.lval( httpContext.GetPar( "TFTipoOblSec_To"))) ;
      AV78TFTipoOblDescrip = httpContext.GetPar( "TFTipoOblDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV79TFTipoOblDescrip_Sels);
      AV81TFOblConcepto = httpContext.GetPar( "TFOblConcepto") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV82TFOblConcepto_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV28TFOblEstado_Sels);
      AV30TFOblObs = httpContext.GetPar( "TFOblObs") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV31TFOblObs_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV59TFOblOriPer_Sels);
      AV61TFOblConCodigo = httpContext.GetPar( "TFOblConCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV62TFOblConCodigo_Sels);
      AV32TFOblTotal = CommonUtil.decimalVal( httpContext.GetPar( "TFOblTotal"), ".") ;
      AV33TFOblTotal_To = CommonUtil.decimalVal( httpContext.GetPar( "TFOblTotal_To"), ".") ;
      AV34TFOblCanCuo = (short)(GXutil.lval( httpContext.GetPar( "TFOblCanCuo"))) ;
      AV35TFOblCanCuo_To = (short)(GXutil.lval( httpContext.GetPar( "TFOblCanCuo_To"))) ;
      AV36TFOblImpFij = CommonUtil.decimalVal( httpContext.GetPar( "TFOblImpFij"), ".") ;
      AV37TFOblImpFij_To = CommonUtil.decimalVal( httpContext.GetPar( "TFOblImpFij_To"), ".") ;
      AV38TFOblPorc = CommonUtil.decimalVal( httpContext.GetPar( "TFOblPorc"), ".") ;
      AV39TFOblPorc_To = CommonUtil.decimalVal( httpContext.GetPar( "TFOblPorc_To"), ".") ;
      AV41TFOblNoRemu_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFOblNoRemu_Sel"))) ;
      AV42TFOblDescu_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFOblDescu_Sel"))) ;
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV54CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV49IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV51IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV55EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV70WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV87ManageFiltersExecutionStep, AV19ColumnsSelector, AV100Pgmname, AV68MenuOpcCod, AV12GridState, AV22TFOblSecuencial, AV23TFOblSecuencial_To, AV25TFLegIdNomApe, AV26TFLegIdNomApe_Sels, AV56TFTipoOblSec, AV57TFTipoOblSec_To, AV78TFTipoOblDescrip, AV79TFTipoOblDescrip_Sels, AV81TFOblConcepto, AV82TFOblConcepto_Sels, AV28TFOblEstado_Sels, AV30TFOblObs, AV31TFOblObs_Sels, AV59TFOblOriPer_Sels, AV61TFOblConCodigo, AV62TFOblConCodigo_Sels, AV32TFOblTotal, AV33TFOblTotal_To, AV34TFOblCanCuo, AV35TFOblCanCuo_To, AV36TFOblImpFij, AV37TFOblImpFij_To, AV38TFOblPorc, AV39TFOblPorc_To, AV41TFOblNoRemu_Sel, AV42TFOblDescu_Sel, AV14OrderedBy, AV15OrderedDsc, AV54CliCod, AV49IsAuthorized_Update, AV51IsAuthorized_Delete, AV55EmpCod, AV70WelcomeMessage_NoMostrarMas) ;
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
      paCE2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startCE2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.obligacionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV68MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV68MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV54CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV49IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV51IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV55EmpCod), "ZZZ9")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV43DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV43DDO_TitleSettingsIcons);
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV85ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV85ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV45GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV46GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV47GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV87ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV100Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV68MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV68MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLSECUENCIAL", GXutil.ltrim( localUtil.ntoc( AV22TFOblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLSECUENCIAL_TO", GXutil.ltrim( localUtil.ntoc( AV23TFOblSecuencial_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGIDNOMAPE", AV25TFLegIdNomApe);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGIDNOMAPE_SELS", AV26TFLegIdNomApe_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGIDNOMAPE_SELS", AV26TFLegIdNomApe_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTIPOOBLSEC", GXutil.ltrim( localUtil.ntoc( AV56TFTipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTIPOOBLSEC_TO", GXutil.ltrim( localUtil.ntoc( AV57TFTipoOblSec_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTIPOOBLDESCRIP", AV78TFTipoOblDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFTIPOOBLDESCRIP_SELS", AV79TFTipoOblDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFTIPOOBLDESCRIP_SELS", AV79TFTipoOblDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLCONCEPTO", GXutil.rtrim( AV81TFOblConcepto));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFOBLCONCEPTO_SELS", AV82TFOblConcepto_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFOBLCONCEPTO_SELS", AV82TFOblConcepto_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFOBLESTADO_SELS", AV28TFOblEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFOBLESTADO_SELS", AV28TFOblEstado_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLOBS", AV30TFOblObs);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFOBLOBS_SELS", AV31TFOblObs_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFOBLOBS_SELS", AV31TFOblObs_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFOBLORIPER_SELS", AV59TFOblOriPer_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFOBLORIPER_SELS", AV59TFOblOriPer_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLCONCODIGO", GXutil.rtrim( AV61TFOblConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFOBLCONCODIGO_SELS", AV62TFOblConCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFOBLCONCODIGO_SELS", AV62TFOblConCodigo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLTOTAL", GXutil.ltrim( localUtil.ntoc( AV32TFOblTotal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLTOTAL_TO", GXutil.ltrim( localUtil.ntoc( AV33TFOblTotal_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLCANCUO", GXutil.ltrim( localUtil.ntoc( AV34TFOblCanCuo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLCANCUO_TO", GXutil.ltrim( localUtil.ntoc( AV35TFOblCanCuo_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLIMPFIJ", GXutil.ltrim( localUtil.ntoc( AV36TFOblImpFij, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLIMPFIJ_TO", GXutil.ltrim( localUtil.ntoc( AV37TFOblImpFij_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLPORC", GXutil.ltrim( localUtil.ntoc( AV38TFOblPorc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLPORC_TO", GXutil.ltrim( localUtil.ntoc( AV39TFOblPorc_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLNOREMU_SEL", GXutil.ltrim( localUtil.ntoc( AV41TFOblNoRemu_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLDESCU_SEL", GXutil.ltrim( localUtil.ntoc( AV42TFOblDescu_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV54CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV54CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV49IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV49IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV51IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV51IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGIDNOMAPE_SELSJSON", AV24TFLegIdNomApe_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTIPOOBLDESCRIP_SELSJSON", AV77TFTipoOblDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLCONCEPTO_SELSJSON", AV80TFOblConcepto_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLESTADO_SELSJSON", AV27TFOblEstado_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLOBS_SELSJSON", AV29TFOblObs_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLORIPER_SELSJSON", AV58TFOblOriPer_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOBLCONCODIGO_SELSJSON", AV60TFOblConCodigo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV55EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV55EmpCod), "ZZZ9")));
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
         weCE2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtCE2( ) ;
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
      return formatLink("web.obligacionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV68MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "ObligacionWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Obligacion", "") ;
   }

   public void wbCE0( )
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
         wb_table1_9_CE2( true) ;
      }
      else
      {
         wb_table1_9_CE2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_CE2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV43DDO_TitleSettingsIcons);
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

   public void startCE2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Obligacion", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupCE0( ) ;
   }

   public void wsCE2( )
   {
      startCE2( ) ;
      evtCE2( ) ;
   }

   public void evtCE2( )
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
                           e11CE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12CE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13CE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14CE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15CE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e16CE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17CE2 ();
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
                           A1172OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( edtOblSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A250LegIdNomApe = httpContext.cgiGet( edtLegIdNomApe_Internalname) ;
                           A1163TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( edtTipoOblSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1165TipoOblDescrip = httpContext.cgiGet( edtTipoOblDescrip_Internalname) ;
                           A2343OblConcepto = httpContext.cgiGet( edtOblConcepto_Internalname) ;
                           cmbOblEstado.setName( cmbOblEstado.getInternalname() );
                           cmbOblEstado.setValue( httpContext.cgiGet( cmbOblEstado.getInternalname()) );
                           A1173OblEstado = (byte)(GXutil.lval( httpContext.cgiGet( cmbOblEstado.getInternalname()))) ;
                           A1174OblObs = httpContext.cgiGet( edtOblObs_Internalname) ;
                           cmbOblOriPer.setName( cmbOblOriPer.getInternalname() );
                           cmbOblOriPer.setValue( httpContext.cgiGet( cmbOblOriPer.getInternalname()) );
                           A1175OblOriPer = (byte)(GXutil.lval( httpContext.cgiGet( cmbOblOriPer.getInternalname()))) ;
                           A1169OblConCodigo = httpContext.cgiGet( edtOblConCodigo_Internalname) ;
                           n1169OblConCodigo = false ;
                           A1176OblTotal = localUtil.ctond( httpContext.cgiGet( edtOblTotal_Internalname)) ;
                           A1177OblCanCuo = (short)(localUtil.ctol( httpContext.cgiGet( edtOblCanCuo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1178OblImpFij = localUtil.ctond( httpContext.cgiGet( edtOblImpFij_Internalname)) ;
                           A1179OblPorc = localUtil.ctond( httpContext.cgiGet( edtOblPorc_Internalname)) ;
                           A1181OblNoRemu = GXutil.strtobool( httpContext.cgiGet( chkOblNoRemu.getInternalname())) ;
                           A1182OblDescu = GXutil.strtobool( httpContext.cgiGet( chkOblDescu.getInternalname())) ;
                           AV48Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV48Update);
                           AV50Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV50Delete);
                           AV67Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV67Display);
                           AV64VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV64VerSVG);
                           AV65ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV65ModificarSVG);
                           AV66EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV66EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e18CE2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e19CE2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20CE2 ();
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

   public void weCE2( )
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

   public void paCE2( )
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
                                 byte AV87ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ,
                                 String AV100Pgmname ,
                                 String AV68MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 short AV22TFOblSecuencial ,
                                 short AV23TFOblSecuencial_To ,
                                 String AV25TFLegIdNomApe ,
                                 GXSimpleCollection<String> AV26TFLegIdNomApe_Sels ,
                                 short AV56TFTipoOblSec ,
                                 short AV57TFTipoOblSec_To ,
                                 String AV78TFTipoOblDescrip ,
                                 GXSimpleCollection<String> AV79TFTipoOblDescrip_Sels ,
                                 String AV81TFOblConcepto ,
                                 GXSimpleCollection<String> AV82TFOblConcepto_Sels ,
                                 GXSimpleCollection<Byte> AV28TFOblEstado_Sels ,
                                 String AV30TFOblObs ,
                                 GXSimpleCollection<String> AV31TFOblObs_Sels ,
                                 GXSimpleCollection<Byte> AV59TFOblOriPer_Sels ,
                                 String AV61TFOblConCodigo ,
                                 GXSimpleCollection<String> AV62TFOblConCodigo_Sels ,
                                 java.math.BigDecimal AV32TFOblTotal ,
                                 java.math.BigDecimal AV33TFOblTotal_To ,
                                 short AV34TFOblCanCuo ,
                                 short AV35TFOblCanCuo_To ,
                                 java.math.BigDecimal AV36TFOblImpFij ,
                                 java.math.BigDecimal AV37TFOblImpFij_To ,
                                 java.math.BigDecimal AV38TFOblPorc ,
                                 java.math.BigDecimal AV39TFOblPorc_To ,
                                 byte AV41TFOblNoRemu_Sel ,
                                 byte AV42TFOblDescu_Sel ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV54CliCod ,
                                 boolean AV49IsAuthorized_Update ,
                                 boolean AV51IsAuthorized_Delete ,
                                 short AV55EmpCod ,
                                 boolean AV70WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e19CE2 ();
      GRID_nCurrentRecord = 0 ;
      rfCE2( ) ;
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
      AV70WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV70WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70WelcomeMessage_NoMostrarMas", AV70WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfCE2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV100Pgmname = "ObligacionWW" ;
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

   public void rfCE2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e19CE2 ();
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
                                              A250LegIdNomApe ,
                                              AV104Obligacionwwds_4_tflegidnomape_sels ,
                                              A1165TipoOblDescrip ,
                                              AV108Obligacionwwds_8_tftipoobldescrip_sels ,
                                              A2343OblConcepto ,
                                              AV110Obligacionwwds_10_tfoblconcepto_sels ,
                                              Byte.valueOf(A1173OblEstado) ,
                                              AV111Obligacionwwds_11_tfoblestado_sels ,
                                              A1174OblObs ,
                                              AV113Obligacionwwds_13_tfoblobs_sels ,
                                              Byte.valueOf(A1175OblOriPer) ,
                                              AV114Obligacionwwds_14_tfobloriper_sels ,
                                              A1169OblConCodigo ,
                                              AV116Obligacionwwds_16_tfoblconcodigo_sels ,
                                              Short.valueOf(AV101Obligacionwwds_1_tfoblsecuencial) ,
                                              Short.valueOf(AV102Obligacionwwds_2_tfoblsecuencial_to) ,
                                              Integer.valueOf(AV104Obligacionwwds_4_tflegidnomape_sels.size()) ,
                                              AV103Obligacionwwds_3_tflegidnomape ,
                                              Short.valueOf(AV105Obligacionwwds_5_tftipooblsec) ,
                                              Short.valueOf(AV106Obligacionwwds_6_tftipooblsec_to) ,
                                              Integer.valueOf(AV108Obligacionwwds_8_tftipoobldescrip_sels.size()) ,
                                              AV107Obligacionwwds_7_tftipoobldescrip ,
                                              Integer.valueOf(AV110Obligacionwwds_10_tfoblconcepto_sels.size()) ,
                                              AV109Obligacionwwds_9_tfoblconcepto ,
                                              Integer.valueOf(AV111Obligacionwwds_11_tfoblestado_sels.size()) ,
                                              Integer.valueOf(AV113Obligacionwwds_13_tfoblobs_sels.size()) ,
                                              AV112Obligacionwwds_12_tfoblobs ,
                                              Integer.valueOf(AV114Obligacionwwds_14_tfobloriper_sels.size()) ,
                                              Integer.valueOf(AV116Obligacionwwds_16_tfoblconcodigo_sels.size()) ,
                                              AV115Obligacionwwds_15_tfoblconcodigo ,
                                              AV117Obligacionwwds_17_tfobltotal ,
                                              AV118Obligacionwwds_18_tfobltotal_to ,
                                              Short.valueOf(AV119Obligacionwwds_19_tfoblcancuo) ,
                                              Short.valueOf(AV120Obligacionwwds_20_tfoblcancuo_to) ,
                                              AV121Obligacionwwds_21_tfoblimpfij ,
                                              AV122Obligacionwwds_22_tfoblimpfij_to ,
                                              AV123Obligacionwwds_23_tfoblporc ,
                                              AV124Obligacionwwds_24_tfoblporc_to ,
                                              Byte.valueOf(AV125Obligacionwwds_25_tfoblnoremu_sel) ,
                                              Byte.valueOf(AV126Obligacionwwds_26_tfobldescu_sel) ,
                                              Short.valueOf(A1172OblSecuencial) ,
                                              Short.valueOf(A1163TipoOblSec) ,
                                              A1176OblTotal ,
                                              Short.valueOf(A1177OblCanCuo) ,
                                              A1178OblImpFij ,
                                              A1179OblPorc ,
                                              Boolean.valueOf(A1181OblNoRemu) ,
                                              Boolean.valueOf(A1182OblDescu) ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) ,
                                              Integer.valueOf(AV54CliCod) ,
                                              Short.valueOf(AV55EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV103Obligacionwwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV103Obligacionwwds_3_tflegidnomape), "%", "") ;
         lV107Obligacionwwds_7_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV107Obligacionwwds_7_tftipoobldescrip), "%", "") ;
         lV109Obligacionwwds_9_tfoblconcepto = GXutil.padr( GXutil.rtrim( AV109Obligacionwwds_9_tfoblconcepto), 10, "%") ;
         lV112Obligacionwwds_12_tfoblobs = GXutil.concat( GXutil.rtrim( AV112Obligacionwwds_12_tfoblobs), "%", "") ;
         lV115Obligacionwwds_15_tfoblconcodigo = GXutil.padr( GXutil.rtrim( AV115Obligacionwwds_15_tfoblconcodigo), 10, "%") ;
         /* Using cursor H00CE2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV54CliCod), Short.valueOf(AV55EmpCod), Short.valueOf(AV101Obligacionwwds_1_tfoblsecuencial), Short.valueOf(AV102Obligacionwwds_2_tfoblsecuencial_to), lV103Obligacionwwds_3_tflegidnomape, Short.valueOf(AV105Obligacionwwds_5_tftipooblsec), Short.valueOf(AV106Obligacionwwds_6_tftipooblsec_to), lV107Obligacionwwds_7_tftipoobldescrip, lV109Obligacionwwds_9_tfoblconcepto, lV112Obligacionwwds_12_tfoblobs, lV115Obligacionwwds_15_tfoblconcodigo, AV117Obligacionwwds_17_tfobltotal, AV118Obligacionwwds_18_tfobltotal_to, Short.valueOf(AV119Obligacionwwds_19_tfoblcancuo), Short.valueOf(AV120Obligacionwwds_20_tfoblcancuo_to), AV121Obligacionwwds_21_tfoblimpfij, AV122Obligacionwwds_22_tfoblimpfij_to, AV123Obligacionwwds_23_tfoblporc, AV124Obligacionwwds_24_tfoblporc_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1182OblDescu = H00CE2_A1182OblDescu[0] ;
            A1181OblNoRemu = H00CE2_A1181OblNoRemu[0] ;
            A1179OblPorc = H00CE2_A1179OblPorc[0] ;
            A1178OblImpFij = H00CE2_A1178OblImpFij[0] ;
            A1177OblCanCuo = H00CE2_A1177OblCanCuo[0] ;
            A1176OblTotal = H00CE2_A1176OblTotal[0] ;
            A1169OblConCodigo = H00CE2_A1169OblConCodigo[0] ;
            n1169OblConCodigo = H00CE2_n1169OblConCodigo[0] ;
            A1175OblOriPer = H00CE2_A1175OblOriPer[0] ;
            A1174OblObs = H00CE2_A1174OblObs[0] ;
            A1173OblEstado = H00CE2_A1173OblEstado[0] ;
            A2343OblConcepto = H00CE2_A2343OblConcepto[0] ;
            A1165TipoOblDescrip = H00CE2_A1165TipoOblDescrip[0] ;
            A1163TipoOblSec = H00CE2_A1163TipoOblSec[0] ;
            A250LegIdNomApe = H00CE2_A250LegIdNomApe[0] ;
            A6LegNumero = H00CE2_A6LegNumero[0] ;
            A1EmpCod = H00CE2_A1EmpCod[0] ;
            A3CliCod = H00CE2_A3CliCod[0] ;
            A1172OblSecuencial = H00CE2_A1172OblSecuencial[0] ;
            A1165TipoOblDescrip = H00CE2_A1165TipoOblDescrip[0] ;
            A250LegIdNomApe = H00CE2_A250LegIdNomApe[0] ;
            e20CE2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbCE0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesCE2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV100Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV68MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV68MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV54CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV54CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV49IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV49IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV51IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV51IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV55EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV55EmpCod), "ZZZ9")));
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
      AV101Obligacionwwds_1_tfoblsecuencial = AV22TFOblSecuencial ;
      AV102Obligacionwwds_2_tfoblsecuencial_to = AV23TFOblSecuencial_To ;
      AV103Obligacionwwds_3_tflegidnomape = AV25TFLegIdNomApe ;
      AV104Obligacionwwds_4_tflegidnomape_sels = AV26TFLegIdNomApe_Sels ;
      AV105Obligacionwwds_5_tftipooblsec = AV56TFTipoOblSec ;
      AV106Obligacionwwds_6_tftipooblsec_to = AV57TFTipoOblSec_To ;
      AV107Obligacionwwds_7_tftipoobldescrip = AV78TFTipoOblDescrip ;
      AV108Obligacionwwds_8_tftipoobldescrip_sels = AV79TFTipoOblDescrip_Sels ;
      AV109Obligacionwwds_9_tfoblconcepto = AV81TFOblConcepto ;
      AV110Obligacionwwds_10_tfoblconcepto_sels = AV82TFOblConcepto_Sels ;
      AV111Obligacionwwds_11_tfoblestado_sels = AV28TFOblEstado_Sels ;
      AV112Obligacionwwds_12_tfoblobs = AV30TFOblObs ;
      AV113Obligacionwwds_13_tfoblobs_sels = AV31TFOblObs_Sels ;
      AV114Obligacionwwds_14_tfobloriper_sels = AV59TFOblOriPer_Sels ;
      AV115Obligacionwwds_15_tfoblconcodigo = AV61TFOblConCodigo ;
      AV116Obligacionwwds_16_tfoblconcodigo_sels = AV62TFOblConCodigo_Sels ;
      AV117Obligacionwwds_17_tfobltotal = AV32TFOblTotal ;
      AV118Obligacionwwds_18_tfobltotal_to = AV33TFOblTotal_To ;
      AV119Obligacionwwds_19_tfoblcancuo = AV34TFOblCanCuo ;
      AV120Obligacionwwds_20_tfoblcancuo_to = AV35TFOblCanCuo_To ;
      AV121Obligacionwwds_21_tfoblimpfij = AV36TFOblImpFij ;
      AV122Obligacionwwds_22_tfoblimpfij_to = AV37TFOblImpFij_To ;
      AV123Obligacionwwds_23_tfoblporc = AV38TFOblPorc ;
      AV124Obligacionwwds_24_tfoblporc_to = AV39TFOblPorc_To ;
      AV125Obligacionwwds_25_tfoblnoremu_sel = AV41TFOblNoRemu_Sel ;
      AV126Obligacionwwds_26_tfobldescu_sel = AV42TFOblDescu_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV104Obligacionwwds_4_tflegidnomape_sels ,
                                           A1165TipoOblDescrip ,
                                           AV108Obligacionwwds_8_tftipoobldescrip_sels ,
                                           A2343OblConcepto ,
                                           AV110Obligacionwwds_10_tfoblconcepto_sels ,
                                           Byte.valueOf(A1173OblEstado) ,
                                           AV111Obligacionwwds_11_tfoblestado_sels ,
                                           A1174OblObs ,
                                           AV113Obligacionwwds_13_tfoblobs_sels ,
                                           Byte.valueOf(A1175OblOriPer) ,
                                           AV114Obligacionwwds_14_tfobloriper_sels ,
                                           A1169OblConCodigo ,
                                           AV116Obligacionwwds_16_tfoblconcodigo_sels ,
                                           Short.valueOf(AV101Obligacionwwds_1_tfoblsecuencial) ,
                                           Short.valueOf(AV102Obligacionwwds_2_tfoblsecuencial_to) ,
                                           Integer.valueOf(AV104Obligacionwwds_4_tflegidnomape_sels.size()) ,
                                           AV103Obligacionwwds_3_tflegidnomape ,
                                           Short.valueOf(AV105Obligacionwwds_5_tftipooblsec) ,
                                           Short.valueOf(AV106Obligacionwwds_6_tftipooblsec_to) ,
                                           Integer.valueOf(AV108Obligacionwwds_8_tftipoobldescrip_sels.size()) ,
                                           AV107Obligacionwwds_7_tftipoobldescrip ,
                                           Integer.valueOf(AV110Obligacionwwds_10_tfoblconcepto_sels.size()) ,
                                           AV109Obligacionwwds_9_tfoblconcepto ,
                                           Integer.valueOf(AV111Obligacionwwds_11_tfoblestado_sels.size()) ,
                                           Integer.valueOf(AV113Obligacionwwds_13_tfoblobs_sels.size()) ,
                                           AV112Obligacionwwds_12_tfoblobs ,
                                           Integer.valueOf(AV114Obligacionwwds_14_tfobloriper_sels.size()) ,
                                           Integer.valueOf(AV116Obligacionwwds_16_tfoblconcodigo_sels.size()) ,
                                           AV115Obligacionwwds_15_tfoblconcodigo ,
                                           AV117Obligacionwwds_17_tfobltotal ,
                                           AV118Obligacionwwds_18_tfobltotal_to ,
                                           Short.valueOf(AV119Obligacionwwds_19_tfoblcancuo) ,
                                           Short.valueOf(AV120Obligacionwwds_20_tfoblcancuo_to) ,
                                           AV121Obligacionwwds_21_tfoblimpfij ,
                                           AV122Obligacionwwds_22_tfoblimpfij_to ,
                                           AV123Obligacionwwds_23_tfoblporc ,
                                           AV124Obligacionwwds_24_tfoblporc_to ,
                                           Byte.valueOf(AV125Obligacionwwds_25_tfoblnoremu_sel) ,
                                           Byte.valueOf(AV126Obligacionwwds_26_tfobldescu_sel) ,
                                           Short.valueOf(A1172OblSecuencial) ,
                                           Short.valueOf(A1163TipoOblSec) ,
                                           A1176OblTotal ,
                                           Short.valueOf(A1177OblCanCuo) ,
                                           A1178OblImpFij ,
                                           A1179OblPorc ,
                                           Boolean.valueOf(A1181OblNoRemu) ,
                                           Boolean.valueOf(A1182OblDescu) ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) ,
                                           Integer.valueOf(AV54CliCod) ,
                                           Short.valueOf(AV55EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV103Obligacionwwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV103Obligacionwwds_3_tflegidnomape), "%", "") ;
      lV107Obligacionwwds_7_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV107Obligacionwwds_7_tftipoobldescrip), "%", "") ;
      lV109Obligacionwwds_9_tfoblconcepto = GXutil.padr( GXutil.rtrim( AV109Obligacionwwds_9_tfoblconcepto), 10, "%") ;
      lV112Obligacionwwds_12_tfoblobs = GXutil.concat( GXutil.rtrim( AV112Obligacionwwds_12_tfoblobs), "%", "") ;
      lV115Obligacionwwds_15_tfoblconcodigo = GXutil.padr( GXutil.rtrim( AV115Obligacionwwds_15_tfoblconcodigo), 10, "%") ;
      /* Using cursor H00CE3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV54CliCod), Short.valueOf(AV55EmpCod), Short.valueOf(AV101Obligacionwwds_1_tfoblsecuencial), Short.valueOf(AV102Obligacionwwds_2_tfoblsecuencial_to), lV103Obligacionwwds_3_tflegidnomape, Short.valueOf(AV105Obligacionwwds_5_tftipooblsec), Short.valueOf(AV106Obligacionwwds_6_tftipooblsec_to), lV107Obligacionwwds_7_tftipoobldescrip, lV109Obligacionwwds_9_tfoblconcepto, lV112Obligacionwwds_12_tfoblobs, lV115Obligacionwwds_15_tfoblconcodigo, AV117Obligacionwwds_17_tfobltotal, AV118Obligacionwwds_18_tfobltotal_to, Short.valueOf(AV119Obligacionwwds_19_tfoblcancuo), Short.valueOf(AV120Obligacionwwds_20_tfoblcancuo_to), AV121Obligacionwwds_21_tfoblimpfij, AV122Obligacionwwds_22_tfoblimpfij_to, AV123Obligacionwwds_23_tfoblporc, AV124Obligacionwwds_24_tfoblporc_to});
      GRID_nRecordCount = H00CE3_AGRID_nRecordCount[0] ;
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
      AV101Obligacionwwds_1_tfoblsecuencial = AV22TFOblSecuencial ;
      AV102Obligacionwwds_2_tfoblsecuencial_to = AV23TFOblSecuencial_To ;
      AV103Obligacionwwds_3_tflegidnomape = AV25TFLegIdNomApe ;
      AV104Obligacionwwds_4_tflegidnomape_sels = AV26TFLegIdNomApe_Sels ;
      AV105Obligacionwwds_5_tftipooblsec = AV56TFTipoOblSec ;
      AV106Obligacionwwds_6_tftipooblsec_to = AV57TFTipoOblSec_To ;
      AV107Obligacionwwds_7_tftipoobldescrip = AV78TFTipoOblDescrip ;
      AV108Obligacionwwds_8_tftipoobldescrip_sels = AV79TFTipoOblDescrip_Sels ;
      AV109Obligacionwwds_9_tfoblconcepto = AV81TFOblConcepto ;
      AV110Obligacionwwds_10_tfoblconcepto_sels = AV82TFOblConcepto_Sels ;
      AV111Obligacionwwds_11_tfoblestado_sels = AV28TFOblEstado_Sels ;
      AV112Obligacionwwds_12_tfoblobs = AV30TFOblObs ;
      AV113Obligacionwwds_13_tfoblobs_sels = AV31TFOblObs_Sels ;
      AV114Obligacionwwds_14_tfobloriper_sels = AV59TFOblOriPer_Sels ;
      AV115Obligacionwwds_15_tfoblconcodigo = AV61TFOblConCodigo ;
      AV116Obligacionwwds_16_tfoblconcodigo_sels = AV62TFOblConCodigo_Sels ;
      AV117Obligacionwwds_17_tfobltotal = AV32TFOblTotal ;
      AV118Obligacionwwds_18_tfobltotal_to = AV33TFOblTotal_To ;
      AV119Obligacionwwds_19_tfoblcancuo = AV34TFOblCanCuo ;
      AV120Obligacionwwds_20_tfoblcancuo_to = AV35TFOblCanCuo_To ;
      AV121Obligacionwwds_21_tfoblimpfij = AV36TFOblImpFij ;
      AV122Obligacionwwds_22_tfoblimpfij_to = AV37TFOblImpFij_To ;
      AV123Obligacionwwds_23_tfoblporc = AV38TFOblPorc ;
      AV124Obligacionwwds_24_tfoblporc_to = AV39TFOblPorc_To ;
      AV125Obligacionwwds_25_tfoblnoremu_sel = AV41TFOblNoRemu_Sel ;
      AV126Obligacionwwds_26_tfobldescu_sel = AV42TFOblDescu_Sel ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV87ManageFiltersExecutionStep, AV19ColumnsSelector, AV100Pgmname, AV68MenuOpcCod, AV12GridState, AV22TFOblSecuencial, AV23TFOblSecuencial_To, AV25TFLegIdNomApe, AV26TFLegIdNomApe_Sels, AV56TFTipoOblSec, AV57TFTipoOblSec_To, AV78TFTipoOblDescrip, AV79TFTipoOblDescrip_Sels, AV81TFOblConcepto, AV82TFOblConcepto_Sels, AV28TFOblEstado_Sels, AV30TFOblObs, AV31TFOblObs_Sels, AV59TFOblOriPer_Sels, AV61TFOblConCodigo, AV62TFOblConCodigo_Sels, AV32TFOblTotal, AV33TFOblTotal_To, AV34TFOblCanCuo, AV35TFOblCanCuo_To, AV36TFOblImpFij, AV37TFOblImpFij_To, AV38TFOblPorc, AV39TFOblPorc_To, AV41TFOblNoRemu_Sel, AV42TFOblDescu_Sel, AV14OrderedBy, AV15OrderedDsc, AV54CliCod, AV49IsAuthorized_Update, AV51IsAuthorized_Delete, AV55EmpCod, AV70WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV101Obligacionwwds_1_tfoblsecuencial = AV22TFOblSecuencial ;
      AV102Obligacionwwds_2_tfoblsecuencial_to = AV23TFOblSecuencial_To ;
      AV103Obligacionwwds_3_tflegidnomape = AV25TFLegIdNomApe ;
      AV104Obligacionwwds_4_tflegidnomape_sels = AV26TFLegIdNomApe_Sels ;
      AV105Obligacionwwds_5_tftipooblsec = AV56TFTipoOblSec ;
      AV106Obligacionwwds_6_tftipooblsec_to = AV57TFTipoOblSec_To ;
      AV107Obligacionwwds_7_tftipoobldescrip = AV78TFTipoOblDescrip ;
      AV108Obligacionwwds_8_tftipoobldescrip_sels = AV79TFTipoOblDescrip_Sels ;
      AV109Obligacionwwds_9_tfoblconcepto = AV81TFOblConcepto ;
      AV110Obligacionwwds_10_tfoblconcepto_sels = AV82TFOblConcepto_Sels ;
      AV111Obligacionwwds_11_tfoblestado_sels = AV28TFOblEstado_Sels ;
      AV112Obligacionwwds_12_tfoblobs = AV30TFOblObs ;
      AV113Obligacionwwds_13_tfoblobs_sels = AV31TFOblObs_Sels ;
      AV114Obligacionwwds_14_tfobloriper_sels = AV59TFOblOriPer_Sels ;
      AV115Obligacionwwds_15_tfoblconcodigo = AV61TFOblConCodigo ;
      AV116Obligacionwwds_16_tfoblconcodigo_sels = AV62TFOblConCodigo_Sels ;
      AV117Obligacionwwds_17_tfobltotal = AV32TFOblTotal ;
      AV118Obligacionwwds_18_tfobltotal_to = AV33TFOblTotal_To ;
      AV119Obligacionwwds_19_tfoblcancuo = AV34TFOblCanCuo ;
      AV120Obligacionwwds_20_tfoblcancuo_to = AV35TFOblCanCuo_To ;
      AV121Obligacionwwds_21_tfoblimpfij = AV36TFOblImpFij ;
      AV122Obligacionwwds_22_tfoblimpfij_to = AV37TFOblImpFij_To ;
      AV123Obligacionwwds_23_tfoblporc = AV38TFOblPorc ;
      AV124Obligacionwwds_24_tfoblporc_to = AV39TFOblPorc_To ;
      AV125Obligacionwwds_25_tfoblnoremu_sel = AV41TFOblNoRemu_Sel ;
      AV126Obligacionwwds_26_tfobldescu_sel = AV42TFOblDescu_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV87ManageFiltersExecutionStep, AV19ColumnsSelector, AV100Pgmname, AV68MenuOpcCod, AV12GridState, AV22TFOblSecuencial, AV23TFOblSecuencial_To, AV25TFLegIdNomApe, AV26TFLegIdNomApe_Sels, AV56TFTipoOblSec, AV57TFTipoOblSec_To, AV78TFTipoOblDescrip, AV79TFTipoOblDescrip_Sels, AV81TFOblConcepto, AV82TFOblConcepto_Sels, AV28TFOblEstado_Sels, AV30TFOblObs, AV31TFOblObs_Sels, AV59TFOblOriPer_Sels, AV61TFOblConCodigo, AV62TFOblConCodigo_Sels, AV32TFOblTotal, AV33TFOblTotal_To, AV34TFOblCanCuo, AV35TFOblCanCuo_To, AV36TFOblImpFij, AV37TFOblImpFij_To, AV38TFOblPorc, AV39TFOblPorc_To, AV41TFOblNoRemu_Sel, AV42TFOblDescu_Sel, AV14OrderedBy, AV15OrderedDsc, AV54CliCod, AV49IsAuthorized_Update, AV51IsAuthorized_Delete, AV55EmpCod, AV70WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV101Obligacionwwds_1_tfoblsecuencial = AV22TFOblSecuencial ;
      AV102Obligacionwwds_2_tfoblsecuencial_to = AV23TFOblSecuencial_To ;
      AV103Obligacionwwds_3_tflegidnomape = AV25TFLegIdNomApe ;
      AV104Obligacionwwds_4_tflegidnomape_sels = AV26TFLegIdNomApe_Sels ;
      AV105Obligacionwwds_5_tftipooblsec = AV56TFTipoOblSec ;
      AV106Obligacionwwds_6_tftipooblsec_to = AV57TFTipoOblSec_To ;
      AV107Obligacionwwds_7_tftipoobldescrip = AV78TFTipoOblDescrip ;
      AV108Obligacionwwds_8_tftipoobldescrip_sels = AV79TFTipoOblDescrip_Sels ;
      AV109Obligacionwwds_9_tfoblconcepto = AV81TFOblConcepto ;
      AV110Obligacionwwds_10_tfoblconcepto_sels = AV82TFOblConcepto_Sels ;
      AV111Obligacionwwds_11_tfoblestado_sels = AV28TFOblEstado_Sels ;
      AV112Obligacionwwds_12_tfoblobs = AV30TFOblObs ;
      AV113Obligacionwwds_13_tfoblobs_sels = AV31TFOblObs_Sels ;
      AV114Obligacionwwds_14_tfobloriper_sels = AV59TFOblOriPer_Sels ;
      AV115Obligacionwwds_15_tfoblconcodigo = AV61TFOblConCodigo ;
      AV116Obligacionwwds_16_tfoblconcodigo_sels = AV62TFOblConCodigo_Sels ;
      AV117Obligacionwwds_17_tfobltotal = AV32TFOblTotal ;
      AV118Obligacionwwds_18_tfobltotal_to = AV33TFOblTotal_To ;
      AV119Obligacionwwds_19_tfoblcancuo = AV34TFOblCanCuo ;
      AV120Obligacionwwds_20_tfoblcancuo_to = AV35TFOblCanCuo_To ;
      AV121Obligacionwwds_21_tfoblimpfij = AV36TFOblImpFij ;
      AV122Obligacionwwds_22_tfoblimpfij_to = AV37TFOblImpFij_To ;
      AV123Obligacionwwds_23_tfoblporc = AV38TFOblPorc ;
      AV124Obligacionwwds_24_tfoblporc_to = AV39TFOblPorc_To ;
      AV125Obligacionwwds_25_tfoblnoremu_sel = AV41TFOblNoRemu_Sel ;
      AV126Obligacionwwds_26_tfobldescu_sel = AV42TFOblDescu_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV87ManageFiltersExecutionStep, AV19ColumnsSelector, AV100Pgmname, AV68MenuOpcCod, AV12GridState, AV22TFOblSecuencial, AV23TFOblSecuencial_To, AV25TFLegIdNomApe, AV26TFLegIdNomApe_Sels, AV56TFTipoOblSec, AV57TFTipoOblSec_To, AV78TFTipoOblDescrip, AV79TFTipoOblDescrip_Sels, AV81TFOblConcepto, AV82TFOblConcepto_Sels, AV28TFOblEstado_Sels, AV30TFOblObs, AV31TFOblObs_Sels, AV59TFOblOriPer_Sels, AV61TFOblConCodigo, AV62TFOblConCodigo_Sels, AV32TFOblTotal, AV33TFOblTotal_To, AV34TFOblCanCuo, AV35TFOblCanCuo_To, AV36TFOblImpFij, AV37TFOblImpFij_To, AV38TFOblPorc, AV39TFOblPorc_To, AV41TFOblNoRemu_Sel, AV42TFOblDescu_Sel, AV14OrderedBy, AV15OrderedDsc, AV54CliCod, AV49IsAuthorized_Update, AV51IsAuthorized_Delete, AV55EmpCod, AV70WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV101Obligacionwwds_1_tfoblsecuencial = AV22TFOblSecuencial ;
      AV102Obligacionwwds_2_tfoblsecuencial_to = AV23TFOblSecuencial_To ;
      AV103Obligacionwwds_3_tflegidnomape = AV25TFLegIdNomApe ;
      AV104Obligacionwwds_4_tflegidnomape_sels = AV26TFLegIdNomApe_Sels ;
      AV105Obligacionwwds_5_tftipooblsec = AV56TFTipoOblSec ;
      AV106Obligacionwwds_6_tftipooblsec_to = AV57TFTipoOblSec_To ;
      AV107Obligacionwwds_7_tftipoobldescrip = AV78TFTipoOblDescrip ;
      AV108Obligacionwwds_8_tftipoobldescrip_sels = AV79TFTipoOblDescrip_Sels ;
      AV109Obligacionwwds_9_tfoblconcepto = AV81TFOblConcepto ;
      AV110Obligacionwwds_10_tfoblconcepto_sels = AV82TFOblConcepto_Sels ;
      AV111Obligacionwwds_11_tfoblestado_sels = AV28TFOblEstado_Sels ;
      AV112Obligacionwwds_12_tfoblobs = AV30TFOblObs ;
      AV113Obligacionwwds_13_tfoblobs_sels = AV31TFOblObs_Sels ;
      AV114Obligacionwwds_14_tfobloriper_sels = AV59TFOblOriPer_Sels ;
      AV115Obligacionwwds_15_tfoblconcodigo = AV61TFOblConCodigo ;
      AV116Obligacionwwds_16_tfoblconcodigo_sels = AV62TFOblConCodigo_Sels ;
      AV117Obligacionwwds_17_tfobltotal = AV32TFOblTotal ;
      AV118Obligacionwwds_18_tfobltotal_to = AV33TFOblTotal_To ;
      AV119Obligacionwwds_19_tfoblcancuo = AV34TFOblCanCuo ;
      AV120Obligacionwwds_20_tfoblcancuo_to = AV35TFOblCanCuo_To ;
      AV121Obligacionwwds_21_tfoblimpfij = AV36TFOblImpFij ;
      AV122Obligacionwwds_22_tfoblimpfij_to = AV37TFOblImpFij_To ;
      AV123Obligacionwwds_23_tfoblporc = AV38TFOblPorc ;
      AV124Obligacionwwds_24_tfoblporc_to = AV39TFOblPorc_To ;
      AV125Obligacionwwds_25_tfoblnoremu_sel = AV41TFOblNoRemu_Sel ;
      AV126Obligacionwwds_26_tfobldescu_sel = AV42TFOblDescu_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV87ManageFiltersExecutionStep, AV19ColumnsSelector, AV100Pgmname, AV68MenuOpcCod, AV12GridState, AV22TFOblSecuencial, AV23TFOblSecuencial_To, AV25TFLegIdNomApe, AV26TFLegIdNomApe_Sels, AV56TFTipoOblSec, AV57TFTipoOblSec_To, AV78TFTipoOblDescrip, AV79TFTipoOblDescrip_Sels, AV81TFOblConcepto, AV82TFOblConcepto_Sels, AV28TFOblEstado_Sels, AV30TFOblObs, AV31TFOblObs_Sels, AV59TFOblOriPer_Sels, AV61TFOblConCodigo, AV62TFOblConCodigo_Sels, AV32TFOblTotal, AV33TFOblTotal_To, AV34TFOblCanCuo, AV35TFOblCanCuo_To, AV36TFOblImpFij, AV37TFOblImpFij_To, AV38TFOblPorc, AV39TFOblPorc_To, AV41TFOblNoRemu_Sel, AV42TFOblDescu_Sel, AV14OrderedBy, AV15OrderedDsc, AV54CliCod, AV49IsAuthorized_Update, AV51IsAuthorized_Delete, AV55EmpCod, AV70WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV101Obligacionwwds_1_tfoblsecuencial = AV22TFOblSecuencial ;
      AV102Obligacionwwds_2_tfoblsecuencial_to = AV23TFOblSecuencial_To ;
      AV103Obligacionwwds_3_tflegidnomape = AV25TFLegIdNomApe ;
      AV104Obligacionwwds_4_tflegidnomape_sels = AV26TFLegIdNomApe_Sels ;
      AV105Obligacionwwds_5_tftipooblsec = AV56TFTipoOblSec ;
      AV106Obligacionwwds_6_tftipooblsec_to = AV57TFTipoOblSec_To ;
      AV107Obligacionwwds_7_tftipoobldescrip = AV78TFTipoOblDescrip ;
      AV108Obligacionwwds_8_tftipoobldescrip_sels = AV79TFTipoOblDescrip_Sels ;
      AV109Obligacionwwds_9_tfoblconcepto = AV81TFOblConcepto ;
      AV110Obligacionwwds_10_tfoblconcepto_sels = AV82TFOblConcepto_Sels ;
      AV111Obligacionwwds_11_tfoblestado_sels = AV28TFOblEstado_Sels ;
      AV112Obligacionwwds_12_tfoblobs = AV30TFOblObs ;
      AV113Obligacionwwds_13_tfoblobs_sels = AV31TFOblObs_Sels ;
      AV114Obligacionwwds_14_tfobloriper_sels = AV59TFOblOriPer_Sels ;
      AV115Obligacionwwds_15_tfoblconcodigo = AV61TFOblConCodigo ;
      AV116Obligacionwwds_16_tfoblconcodigo_sels = AV62TFOblConCodigo_Sels ;
      AV117Obligacionwwds_17_tfobltotal = AV32TFOblTotal ;
      AV118Obligacionwwds_18_tfobltotal_to = AV33TFOblTotal_To ;
      AV119Obligacionwwds_19_tfoblcancuo = AV34TFOblCanCuo ;
      AV120Obligacionwwds_20_tfoblcancuo_to = AV35TFOblCanCuo_To ;
      AV121Obligacionwwds_21_tfoblimpfij = AV36TFOblImpFij ;
      AV122Obligacionwwds_22_tfoblimpfij_to = AV37TFOblImpFij_To ;
      AV123Obligacionwwds_23_tfoblporc = AV38TFOblPorc ;
      AV124Obligacionwwds_24_tfoblporc_to = AV39TFOblPorc_To ;
      AV125Obligacionwwds_25_tfoblnoremu_sel = AV41TFOblNoRemu_Sel ;
      AV126Obligacionwwds_26_tfobldescu_sel = AV42TFOblDescu_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV87ManageFiltersExecutionStep, AV19ColumnsSelector, AV100Pgmname, AV68MenuOpcCod, AV12GridState, AV22TFOblSecuencial, AV23TFOblSecuencial_To, AV25TFLegIdNomApe, AV26TFLegIdNomApe_Sels, AV56TFTipoOblSec, AV57TFTipoOblSec_To, AV78TFTipoOblDescrip, AV79TFTipoOblDescrip_Sels, AV81TFOblConcepto, AV82TFOblConcepto_Sels, AV28TFOblEstado_Sels, AV30TFOblObs, AV31TFOblObs_Sels, AV59TFOblOriPer_Sels, AV61TFOblConCodigo, AV62TFOblConCodigo_Sels, AV32TFOblTotal, AV33TFOblTotal_To, AV34TFOblCanCuo, AV35TFOblCanCuo_To, AV36TFOblImpFij, AV37TFOblImpFij_To, AV38TFOblPorc, AV39TFOblPorc_To, AV41TFOblNoRemu_Sel, AV42TFOblDescu_Sel, AV14OrderedBy, AV15OrderedDsc, AV54CliCod, AV49IsAuthorized_Update, AV51IsAuthorized_Delete, AV55EmpCod, AV70WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV100Pgmname = "ObligacionWW" ;
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

   public void strupCE0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18CE2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV43DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV19ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV85ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV45GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV46GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV47GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV55EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV54CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         AV76WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV70WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV70WelcomeMessage_NoMostrarMas", AV70WelcomeMessage_NoMostrarMas);
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
      e18CE2 ();
      if (returnInSub) return;
   }

   public void e18CE2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV68MenuOpcCod, "", "") ;
      GXt_int1 = AV54CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      obligacionww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV54CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV54CliCod), "ZZZZZ9")));
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
      Form.setCaption( httpContext.getMessage( " Obligacion", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV43DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV43DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV71MenuBienveImgURL ;
      GXv_char6[0] = AV73MenuBienveTitulo ;
      GXv_char7[0] = AV74MenuBienveTexto ;
      GXv_boolean8[0] = AV75MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV68MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      obligacionww_impl.this.AV71MenuBienveImgURL = GXv_char5[0] ;
      obligacionww_impl.this.AV73MenuBienveTitulo = GXv_char6[0] ;
      obligacionww_impl.this.AV74MenuBienveTexto = GXv_char7[0] ;
      obligacionww_impl.this.AV75MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV75MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV75MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV73MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV74MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV76WelcomeMessage_Foto = AV71MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV76WelcomeMessage_Foto)==0) ? AV99Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV76WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV76WelcomeMessage_Foto), true);
         AV99Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV71MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV76WelcomeMessage_Foto)==0) ? AV99Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV76WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV76WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      obligacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      obligacionww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV96observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV96observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV96observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV96observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e19CE2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int11 = AV55EmpCod ;
      GXv_int12[0] = GXt_int11 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int12) ;
      obligacionww_impl.this.GXt_int11 = GXv_int12[0] ;
      AV55EmpCod = GXt_int11 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV55EmpCod), "ZZZ9")));
      GXt_int1 = AV54CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      obligacionww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV54CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV54CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext13[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext13) ;
      AV6WWPContext = GXv_SdtWWPContext13[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV87ManageFiltersExecutionStep == 1 )
      {
         AV87ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV87ManageFiltersExecutionStep", GXutil.str( AV87ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV87ManageFiltersExecutionStep == 2 )
      {
         AV87ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV87ManageFiltersExecutionStep", GXutil.str( AV87ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV21Session.getValue("ObligacionWWColumnsSelector"), "") != 0 )
      {
         AV17ColumnsSelectorXML = AV21Session.getValue("ObligacionWWColumnsSelector") ;
         AV19ColumnsSelector.fromxml(AV17ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtOblSecuencial_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblSecuencial_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblSecuencial_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtLegIdNomApe_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegIdNomApe_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegIdNomApe_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtTipoOblSec_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoOblSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblSec_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtTipoOblDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoOblDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblDescrip_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtOblConcepto_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblConcepto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblConcepto_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbOblEstado.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbOblEstado.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtOblObs_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblObs_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblObs_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbOblOriPer.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblOriPer.getInternalname(), "Visible", GXutil.ltrimstr( cmbOblOriPer.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtOblConCodigo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblConCodigo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtOblTotal_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblTotal_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtOblCanCuo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblCanCuo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblCanCuo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtOblImpFij_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblImpFij_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblImpFij_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtOblPorc_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblPorc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblPorc_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkOblNoRemu.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkOblNoRemu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblNoRemu.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkOblDescu.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkOblDescu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblDescu.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV45GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45GridCurrentPage), 10, 0));
      AV46GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46GridPageCount), 10, 0));
      GXt_char10 = AV47GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV100Pgmname, GXv_char7) ;
      obligacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV47GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47GridAppliedFilters", AV47GridAppliedFilters);
      GXt_char10 = AV92MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV68MenuOpcCod, GXv_char7) ;
      obligacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV92MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV92MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV92MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int12[0] = (short)(AV94filterCount) ;
      GXv_char7[0] = AV95filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int12, GXv_char7) ;
      obligacionww_impl.this.AV94filterCount = GXv_int12[0] ;
      obligacionww_impl.this.AV95filtrosTexto = GXv_char7[0] ;
      if ( AV94filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV94filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV95filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV101Obligacionwwds_1_tfoblsecuencial = AV22TFOblSecuencial ;
      AV102Obligacionwwds_2_tfoblsecuencial_to = AV23TFOblSecuencial_To ;
      AV103Obligacionwwds_3_tflegidnomape = AV25TFLegIdNomApe ;
      AV104Obligacionwwds_4_tflegidnomape_sels = AV26TFLegIdNomApe_Sels ;
      AV105Obligacionwwds_5_tftipooblsec = AV56TFTipoOblSec ;
      AV106Obligacionwwds_6_tftipooblsec_to = AV57TFTipoOblSec_To ;
      AV107Obligacionwwds_7_tftipoobldescrip = AV78TFTipoOblDescrip ;
      AV108Obligacionwwds_8_tftipoobldescrip_sels = AV79TFTipoOblDescrip_Sels ;
      AV109Obligacionwwds_9_tfoblconcepto = AV81TFOblConcepto ;
      AV110Obligacionwwds_10_tfoblconcepto_sels = AV82TFOblConcepto_Sels ;
      AV111Obligacionwwds_11_tfoblestado_sels = AV28TFOblEstado_Sels ;
      AV112Obligacionwwds_12_tfoblobs = AV30TFOblObs ;
      AV113Obligacionwwds_13_tfoblobs_sels = AV31TFOblObs_Sels ;
      AV114Obligacionwwds_14_tfobloriper_sels = AV59TFOblOriPer_Sels ;
      AV115Obligacionwwds_15_tfoblconcodigo = AV61TFOblConCodigo ;
      AV116Obligacionwwds_16_tfoblconcodigo_sels = AV62TFOblConCodigo_Sels ;
      AV117Obligacionwwds_17_tfobltotal = AV32TFOblTotal ;
      AV118Obligacionwwds_18_tfobltotal_to = AV33TFOblTotal_To ;
      AV119Obligacionwwds_19_tfoblcancuo = AV34TFOblCanCuo ;
      AV120Obligacionwwds_20_tfoblcancuo_to = AV35TFOblCanCuo_To ;
      AV121Obligacionwwds_21_tfoblimpfij = AV36TFOblImpFij ;
      AV122Obligacionwwds_22_tfoblimpfij_to = AV37TFOblImpFij_To ;
      AV123Obligacionwwds_23_tfoblporc = AV38TFOblPorc ;
      AV124Obligacionwwds_24_tfoblporc_to = AV39TFOblPorc_To ;
      AV125Obligacionwwds_25_tfoblnoremu_sel = AV41TFOblNoRemu_Sel ;
      AV126Obligacionwwds_26_tfobldescu_sel = AV42TFOblDescu_Sel ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV85ManageFiltersData", AV85ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e13CE2( )
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
         AV44PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV44PageToGo) ;
      }
   }

   public void e14CE2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15CE2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblSecuencial") == 0 )
         {
            AV22TFOblSecuencial = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFOblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TFOblSecuencial), 4, 0));
            AV23TFOblSecuencial_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFOblSecuencial_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23TFOblSecuencial_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegIdNomApe") == 0 )
         {
            AV25TFLegIdNomApe = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFLegIdNomApe", AV25TFLegIdNomApe);
            AV24TFLegIdNomApe_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFLegIdNomApe_SelsJson", AV24TFLegIdNomApe_SelsJson);
            AV26TFLegIdNomApe_Sels.fromJSonString(AV24TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "TipoOblSec") == 0 )
         {
            AV56TFTipoOblSec = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFTipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFTipoOblSec), 4, 0));
            AV57TFTipoOblSec_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFTipoOblSec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFTipoOblSec_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "TipoOblDescrip") == 0 )
         {
            AV78TFTipoOblDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFTipoOblDescrip", AV78TFTipoOblDescrip);
            AV77TFTipoOblDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFTipoOblDescrip_SelsJson", AV77TFTipoOblDescrip_SelsJson);
            AV79TFTipoOblDescrip_Sels.fromJSonString(AV77TFTipoOblDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblConcepto") == 0 )
         {
            AV81TFOblConcepto = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFOblConcepto", AV81TFOblConcepto);
            AV80TFOblConcepto_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFOblConcepto_SelsJson", AV80TFOblConcepto_SelsJson);
            AV82TFOblConcepto_Sels.fromJSonString(AV80TFOblConcepto_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblEstado") == 0 )
         {
            AV27TFOblEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFOblEstado_SelsJson", AV27TFOblEstado_SelsJson);
            AV28TFOblEstado_Sels.fromJSonString(GXutil.strReplace( AV27TFOblEstado_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblObs") == 0 )
         {
            AV30TFOblObs = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFOblObs", AV30TFOblObs);
            AV29TFOblObs_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFOblObs_SelsJson", AV29TFOblObs_SelsJson);
            AV31TFOblObs_Sels.fromJSonString(AV29TFOblObs_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblOriPer") == 0 )
         {
            AV58TFOblOriPer_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFOblOriPer_SelsJson", AV58TFOblOriPer_SelsJson);
            AV59TFOblOriPer_Sels.fromJSonString(GXutil.strReplace( AV58TFOblOriPer_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblConCodigo") == 0 )
         {
            AV61TFOblConCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFOblConCodigo", AV61TFOblConCodigo);
            AV60TFOblConCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFOblConCodigo_SelsJson", AV60TFOblConCodigo_SelsJson);
            AV62TFOblConCodigo_Sels.fromJSonString(AV60TFOblConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblTotal") == 0 )
         {
            AV32TFOblTotal = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFOblTotal", GXutil.ltrimstr( AV32TFOblTotal, 14, 2));
            AV33TFOblTotal_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFOblTotal_To", GXutil.ltrimstr( AV33TFOblTotal_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblCanCuo") == 0 )
         {
            AV34TFOblCanCuo = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFOblCanCuo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFOblCanCuo), 4, 0));
            AV35TFOblCanCuo_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFOblCanCuo_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFOblCanCuo_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblImpFij") == 0 )
         {
            AV36TFOblImpFij = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFOblImpFij", GXutil.ltrimstr( AV36TFOblImpFij, 14, 2));
            AV37TFOblImpFij_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFOblImpFij_To", GXutil.ltrimstr( AV37TFOblImpFij_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblPorc") == 0 )
         {
            AV38TFOblPorc = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFOblPorc", GXutil.ltrimstr( AV38TFOblPorc, 6, 4));
            AV39TFOblPorc_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFOblPorc_To", GXutil.ltrimstr( AV39TFOblPorc_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblNoRemu") == 0 )
         {
            AV41TFOblNoRemu_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFOblNoRemu_Sel", GXutil.str( AV41TFOblNoRemu_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OblDescu") == 0 )
         {
            AV42TFOblDescu_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFOblDescu_Sel", GXutil.str( AV42TFOblDescu_Sel, 1, 0));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV62TFOblConCodigo_Sels", AV62TFOblConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59TFOblOriPer_Sels", AV59TFOblOriPer_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31TFOblObs_Sels", AV31TFOblObs_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28TFOblEstado_Sels", AV28TFOblEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV82TFOblConcepto_Sels", AV82TFOblConcepto_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV79TFTipoOblDescrip_Sels", AV79TFTipoOblDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV26TFLegIdNomApe_Sels", AV26TFLegIdNomApe_Sels);
   }

   private void e20CE2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV48Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV48Update);
      if ( AV49IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.obligacion", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1172OblSecuencial,4,0))}, new String[] {"Mode","CliCod","EmpCod","LegNumero","OblSecuencial"})  ;
      }
      AV50Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV50Delete);
      if ( AV51IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.obligacion", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1172OblSecuencial,4,0))}, new String[] {"Mode","CliCod","EmpCod","LegNumero","OblSecuencial"})  ;
      }
      AV67Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV67Display);
      edtavDisplay_Link = formatLink("web.obligacionview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1172OblSecuencial,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","LegNumero","OblSecuencial","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV64VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      obligacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV64VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV64VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char10 = AV65ModificarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      obligacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV65ModificarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV65ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char10 = AV66EliminarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      obligacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV66EliminarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV66EliminarSVG);
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

   public void e11CE2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV17ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV19ColumnsSelector.fromJSonString(AV17ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "ObligacionWWColumnsSelector", ((GXutil.strcmp("", AV17ColumnsSelectorXML)==0) ? "" : AV19ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV85ManageFiltersData", AV85ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e12CE2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("ObligacionWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV100Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV87ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV87ManageFiltersExecutionStep", GXutil.str( AV87ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("ObligacionWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV87ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV87ManageFiltersExecutionStep", GXutil.str( AV87ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV86ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "ObligacionWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         obligacionww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV86ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV86ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV100Pgmname+"GridState", AV86ManageFiltersXml) ;
            AV12GridState.fromxml(AV86ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV26TFLegIdNomApe_Sels", AV26TFLegIdNomApe_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV79TFTipoOblDescrip_Sels", AV79TFTipoOblDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV82TFOblConcepto_Sels", AV82TFOblConcepto_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28TFOblEstado_Sels", AV28TFOblEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31TFOblObs_Sels", AV31TFOblObs_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59TFOblOriPer_Sels", AV59TFOblOriPer_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV62TFOblConCodigo_Sels", AV62TFOblConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV85ManageFiltersData", AV85ManageFiltersData);
   }

   public void e16CE2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV83ExcelFilename ;
      GXv_char6[0] = AV84ErrorMessage ;
      new web.obligacionwwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      obligacionww_impl.this.AV83ExcelFilename = GXv_char7[0] ;
      obligacionww_impl.this.AV84ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV83ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV83ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV84ErrorMessage);
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblSecuencial", "", "Nro.", false, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegIdNomApe", "", "Legajo", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "TipoOblSec", "", "Obligación", false, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "TipoOblDescrip", "", "Obligación", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblConcepto", "", "Concepto", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblEstado", "", "Estado", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblObs", "", "Observaciones", false, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblOriPer", "", "Origen Periodo", false, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblConCodigo", "", "Origen concepto", false, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblTotal", "", "Total", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblCanCuo", "", "Cantidad de cuotas", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblImpFij", "", "Importe de cuota fija", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblPorc", "", "Porcentaje", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblNoRemu", "", "No remunerativos", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OblDescu", "", "Retenciones", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&VerSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&ModificarSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&EliminarSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXt_char10 = AV18UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ObligacionWWColumnsSelector", GXv_char7) ;
      obligacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV18UserCustomValue = GXt_char10 ;
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
      new web.fixcolumnsselector(remoteHandle, context).execute( AV54CliCod, GXv_SdtWWPColumnsSelector15) ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean16 = AV49IsAuthorized_Update ;
      GXv_boolean8[0] = GXt_boolean16 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Update", GXv_boolean8) ;
      obligacionww_impl.this.GXt_boolean16 = GXv_boolean8[0] ;
      AV49IsAuthorized_Update = GXt_boolean16 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49IsAuthorized_Update", AV49IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV49IsAuthorized_Update));
      if ( ! ( AV49IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean16 = AV51IsAuthorized_Delete ;
      GXv_boolean8[0] = GXt_boolean16 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Delete", GXv_boolean8) ;
      obligacionww_impl.this.GXt_boolean16 = GXv_boolean8[0] ;
      AV51IsAuthorized_Delete = GXt_boolean16 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51IsAuthorized_Delete", AV51IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV51IsAuthorized_Delete));
      if ( ! ( AV51IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean16 = AV53TempBoolean ;
      GXv_boolean8[0] = GXt_boolean16 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Insert", GXv_boolean8) ;
      obligacionww_impl.this.GXt_boolean16 = GXv_boolean8[0] ;
      AV53TempBoolean = GXt_boolean16 ;
      if ( ! ( AV53TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = AV85ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "ObligacionWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[0] ;
      AV85ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV22TFOblSecuencial = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22TFOblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TFOblSecuencial), 4, 0));
      AV23TFOblSecuencial_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23TFOblSecuencial_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23TFOblSecuencial_To), 4, 0));
      AV25TFLegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25TFLegIdNomApe", AV25TFLegIdNomApe);
      AV26TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV56TFTipoOblSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56TFTipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFTipoOblSec), 4, 0));
      AV57TFTipoOblSec_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57TFTipoOblSec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFTipoOblSec_To), 4, 0));
      AV78TFTipoOblDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78TFTipoOblDescrip", AV78TFTipoOblDescrip);
      AV79TFTipoOblDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV81TFOblConcepto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81TFOblConcepto", AV81TFOblConcepto);
      AV82TFOblConcepto_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28TFOblEstado_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV30TFOblObs = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFOblObs", AV30TFOblObs);
      AV31TFOblObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59TFOblOriPer_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV61TFOblConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61TFOblConCodigo", AV61TFOblConCodigo);
      AV62TFOblConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV32TFOblTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFOblTotal", GXutil.ltrimstr( AV32TFOblTotal, 14, 2));
      AV33TFOblTotal_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFOblTotal_To", GXutil.ltrimstr( AV33TFOblTotal_To, 14, 2));
      AV34TFOblCanCuo = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFOblCanCuo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFOblCanCuo), 4, 0));
      AV35TFOblCanCuo_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFOblCanCuo_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFOblCanCuo_To), 4, 0));
      AV36TFOblImpFij = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFOblImpFij", GXutil.ltrimstr( AV36TFOblImpFij, 14, 2));
      AV37TFOblImpFij_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFOblImpFij_To", GXutil.ltrimstr( AV37TFOblImpFij_To, 14, 2));
      AV38TFOblPorc = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFOblPorc", GXutil.ltrimstr( AV38TFOblPorc, 6, 4));
      AV39TFOblPorc_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFOblPorc_To", GXutil.ltrimstr( AV39TFOblPorc_To, 6, 4));
      AV41TFOblNoRemu_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFOblNoRemu_Sel", GXutil.str( AV41TFOblNoRemu_Sel, 1, 0));
      AV42TFOblDescu_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFOblDescu_Sel", GXutil.str( AV42TFOblDescu_Sel, 1, 0));
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
      if ( GXutil.strcmp(AV21Session.getValue(AV100Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV100Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV21Session.getValue(AV100Pgmname+"GridState"), null, null);
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
      AV127GXV1 = 1 ;
      while ( AV127GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV127GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLSECUENCIAL") == 0 )
         {
            AV22TFOblSecuencial = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFOblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TFOblSecuencial), 4, 0));
            AV23TFOblSecuencial_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFOblSecuencial_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23TFOblSecuencial_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV25TFLegIdNomApe = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFLegIdNomApe", AV25TFLegIdNomApe);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV24TFLegIdNomApe_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFLegIdNomApe_SelsJson", AV24TFLegIdNomApe_SelsJson);
            AV26TFLegIdNomApe_Sels.fromJSonString(AV24TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLSEC") == 0 )
         {
            AV56TFTipoOblSec = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFTipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFTipoOblSec), 4, 0));
            AV57TFTipoOblSec_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFTipoOblSec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFTipoOblSec_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLDESCRIP") == 0 )
         {
            AV78TFTipoOblDescrip = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFTipoOblDescrip", AV78TFTipoOblDescrip);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLDESCRIP_SEL") == 0 )
         {
            AV77TFTipoOblDescrip_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFTipoOblDescrip_SelsJson", AV77TFTipoOblDescrip_SelsJson);
            AV79TFTipoOblDescrip_Sels.fromJSonString(AV77TFTipoOblDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCEPTO") == 0 )
         {
            AV81TFOblConcepto = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFOblConcepto", AV81TFOblConcepto);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCEPTO_SEL") == 0 )
         {
            AV80TFOblConcepto_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFOblConcepto_SelsJson", AV80TFOblConcepto_SelsJson);
            AV82TFOblConcepto_Sels.fromJSonString(AV80TFOblConcepto_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLESTADO_SEL") == 0 )
         {
            AV27TFOblEstado_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFOblEstado_SelsJson", AV27TFOblEstado_SelsJson);
            AV28TFOblEstado_Sels.fromJSonString(AV27TFOblEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLOBS") == 0 )
         {
            AV30TFOblObs = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFOblObs", AV30TFOblObs);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLOBS_SEL") == 0 )
         {
            AV29TFOblObs_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFOblObs_SelsJson", AV29TFOblObs_SelsJson);
            AV31TFOblObs_Sels.fromJSonString(AV29TFOblObs_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLORIPER_SEL") == 0 )
         {
            AV58TFOblOriPer_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFOblOriPer_SelsJson", AV58TFOblOriPer_SelsJson);
            AV59TFOblOriPer_Sels.fromJSonString(AV58TFOblOriPer_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCODIGO") == 0 )
         {
            AV61TFOblConCodigo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFOblConCodigo", AV61TFOblConCodigo);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCODIGO_SEL") == 0 )
         {
            AV60TFOblConCodigo_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFOblConCodigo_SelsJson", AV60TFOblConCodigo_SelsJson);
            AV62TFOblConCodigo_Sels.fromJSonString(AV60TFOblConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLTOTAL") == 0 )
         {
            AV32TFOblTotal = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFOblTotal", GXutil.ltrimstr( AV32TFOblTotal, 14, 2));
            AV33TFOblTotal_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFOblTotal_To", GXutil.ltrimstr( AV33TFOblTotal_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCANCUO") == 0 )
         {
            AV34TFOblCanCuo = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFOblCanCuo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFOblCanCuo), 4, 0));
            AV35TFOblCanCuo_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFOblCanCuo_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFOblCanCuo_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLIMPFIJ") == 0 )
         {
            AV36TFOblImpFij = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFOblImpFij", GXutil.ltrimstr( AV36TFOblImpFij, 14, 2));
            AV37TFOblImpFij_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFOblImpFij_To", GXutil.ltrimstr( AV37TFOblImpFij_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLPORC") == 0 )
         {
            AV38TFOblPorc = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFOblPorc", GXutil.ltrimstr( AV38TFOblPorc, 6, 4));
            AV39TFOblPorc_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFOblPorc_To", GXutil.ltrimstr( AV39TFOblPorc_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLNOREMU_SEL") == 0 )
         {
            AV41TFOblNoRemu_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFOblNoRemu_Sel", GXutil.str( AV41TFOblNoRemu_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLDESCU_SEL") == 0 )
         {
            AV42TFOblDescu_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFOblDescu_Sel", GXutil.str( AV42TFOblDescu_Sel, 1, 0));
         }
         AV127GXV1 = (int)(AV127GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV26TFLegIdNomApe_Sels.size()==0), AV24TFLegIdNomApe_SelsJson, GXv_char7) ;
      obligacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV79TFTipoOblDescrip_Sels.size()==0), AV77TFTipoOblDescrip_SelsJson, GXv_char6) ;
      obligacionww_impl.this.GXt_char9 = GXv_char6[0] ;
      GXt_char19 = "" ;
      GXv_char5[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV82TFOblConcepto_Sels.size()==0), AV80TFOblConcepto_SelsJson, GXv_char5) ;
      obligacionww_impl.this.GXt_char19 = GXv_char5[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV31TFOblObs_Sels.size()==0), AV29TFOblObs_SelsJson, GXv_char21) ;
      obligacionww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV62TFOblConCodigo_Sels.size()==0), AV60TFOblConCodigo_SelsJson, GXv_char23) ;
      obligacionww_impl.this.GXt_char22 = GXv_char23[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char10+"||"+GXt_char9+"|"+GXt_char19+"|"+((AV28TFOblEstado_Sels.size()==0) ? "" : AV27TFOblEstado_SelsJson)+"|"+GXt_char20+"|"+((AV59TFOblOriPer_Sels.size()==0) ? "" : AV58TFOblOriPer_SelsJson)+"|"+GXt_char22+"|||||"+((0==AV41TFOblNoRemu_Sel) ? "" : GXutil.str( AV41TFOblNoRemu_Sel, 1, 0))+"|"+((0==AV42TFOblDescu_Sel) ? "" : GXutil.str( AV42TFOblDescu_Sel, 1, 0)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV25TFLegIdNomApe)==0), AV25TFLegIdNomApe, GXv_char23) ;
      obligacionww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV78TFTipoOblDescrip)==0), AV78TFTipoOblDescrip, GXv_char21) ;
      obligacionww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char19 = "" ;
      GXv_char7[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV81TFOblConcepto)==0), AV81TFOblConcepto, GXv_char7) ;
      obligacionww_impl.this.GXt_char19 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char6[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFOblObs)==0), AV30TFOblObs, GXv_char6) ;
      obligacionww_impl.this.GXt_char10 = GXv_char6[0] ;
      GXt_char9 = "" ;
      GXv_char5[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV61TFOblConCodigo)==0), AV61TFOblConCodigo, GXv_char5) ;
      obligacionww_impl.this.GXt_char9 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV22TFOblSecuencial) ? "" : GXutil.str( AV22TFOblSecuencial, 4, 0))+"|"+GXt_char22+"|"+((0==AV56TFTipoOblSec) ? "" : GXutil.str( AV56TFTipoOblSec, 4, 0))+"|"+GXt_char20+"|"+GXt_char19+"||"+GXt_char10+"||"+GXt_char9+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFOblTotal)==0) ? "" : GXutil.str( AV32TFOblTotal, 14, 2))+"|"+((0==AV34TFOblCanCuo) ? "" : GXutil.str( AV34TFOblCanCuo, 4, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFOblImpFij)==0) ? "" : GXutil.str( AV36TFOblImpFij, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFOblPorc)==0) ? "" : GXutil.str( AV38TFOblPorc, 6, 4))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV23TFOblSecuencial_To) ? "" : GXutil.str( AV23TFOblSecuencial_To, 4, 0))+"||"+((0==AV57TFTipoOblSec_To) ? "" : GXutil.str( AV57TFTipoOblSec_To, 4, 0))+"|||||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFOblTotal_To)==0) ? "" : GXutil.str( AV33TFOblTotal_To, 14, 2))+"|"+((0==AV35TFOblCanCuo_To) ? "" : GXutil.str( AV35TFOblCanCuo_To, 4, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFOblImpFij_To)==0) ? "" : GXutil.str( AV37TFOblImpFij_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFOblPorc_To)==0) ? "" : GXutil.str( AV39TFOblPorc_To, 6, 4))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV21Session.getValue(AV100Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLSECUENCIAL", httpContext.getMessage( "Nro.", ""), !((0==AV22TFOblSecuencial)&&(0==AV23TFOblSecuencial_To)), (short)(0), GXutil.trim( GXutil.str( AV22TFOblSecuencial, 4, 0)), GXutil.trim( GXutil.str( AV23TFOblSecuencial_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFLEGIDNOMAPE", httpContext.getMessage( "Legajo", ""), !(GXutil.strcmp("", AV25TFLegIdNomApe)==0), (short)(0), AV25TFLegIdNomApe, "", !(AV26TFLegIdNomApe_Sels.size()==0), AV26TFLegIdNomApe_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFTIPOOBLSEC", httpContext.getMessage( "Obligación", ""), !((0==AV56TFTipoOblSec)&&(0==AV57TFTipoOblSec_To)), (short)(0), GXutil.trim( GXutil.str( AV56TFTipoOblSec, 4, 0)), GXutil.trim( GXutil.str( AV57TFTipoOblSec_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFTIPOOBLDESCRIP", httpContext.getMessage( "Obligación", ""), !(GXutil.strcmp("", AV78TFTipoOblDescrip)==0), (short)(0), AV78TFTipoOblDescrip, "", !(AV79TFTipoOblDescrip_Sels.size()==0), AV79TFTipoOblDescrip_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLCONCEPTO", httpContext.getMessage( "Concepto", ""), !(GXutil.strcmp("", AV81TFOblConcepto)==0), (short)(0), AV81TFOblConcepto, "", !(AV82TFOblConcepto_Sels.size()==0), AV82TFOblConcepto_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLESTADO_SEL", httpContext.getMessage( "Estado", ""), !(AV28TFOblEstado_Sels.size()==0), (short)(0), AV28TFOblEstado_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLOBS", httpContext.getMessage( "Observaciones", ""), !(GXutil.strcmp("", AV30TFOblObs)==0), (short)(0), AV30TFOblObs, "", !(AV31TFOblObs_Sels.size()==0), AV31TFOblObs_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLORIPER_SEL", httpContext.getMessage( "Origen Periodo", ""), !(AV59TFOblOriPer_Sels.size()==0), (short)(0), AV59TFOblOriPer_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLCONCODIGO", httpContext.getMessage( "Origen concepto", ""), !(GXutil.strcmp("", AV61TFOblConCodigo)==0), (short)(0), AV61TFOblConCodigo, "", !(AV62TFOblConCodigo_Sels.size()==0), AV62TFOblConCodigo_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLTOTAL", httpContext.getMessage( "Total", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFOblTotal)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFOblTotal_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV32TFOblTotal, 14, 2)), GXutil.trim( GXutil.str( AV33TFOblTotal_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLCANCUO", httpContext.getMessage( "Cantidad de cuotas", ""), !((0==AV34TFOblCanCuo)&&(0==AV35TFOblCanCuo_To)), (short)(0), GXutil.trim( GXutil.str( AV34TFOblCanCuo, 4, 0)), GXutil.trim( GXutil.str( AV35TFOblCanCuo_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLIMPFIJ", httpContext.getMessage( "Importe de cuota fija", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFOblImpFij)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFOblImpFij_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV36TFOblImpFij, 14, 2)), GXutil.trim( GXutil.str( AV37TFOblImpFij_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLPORC", httpContext.getMessage( "Porcentaje", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFOblPorc)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFOblPorc_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV38TFOblPorc, 6, 4)), GXutil.trim( GXutil.str( AV39TFOblPorc_To, 6, 4))) ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLNOREMU_SEL", httpContext.getMessage( "No remunerativos", ""), !(0==AV41TFOblNoRemu_Sel), (short)(0), GXutil.trim( GXutil.str( AV41TFOblNoRemu_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      GXv_SdtWWPGridState24[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState24, "TFOBLDESCU_SEL", httpContext.getMessage( "Retenciones", ""), !(0==AV42TFOblDescu_Sel), (short)(0), GXutil.trim( GXutil.str( AV42TFOblDescu_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState24[0] ;
      if ( ! (GXutil.strcmp("", AV68MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV68MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV100Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV100Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Obligacion" );
      AV21Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e17CE2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV70WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV68MenuOpcCod, GXv_boolean8) ;
         GXv_char23[0] = AV72textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV54CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char23) ;
         obligacionww_impl.this.AV72textoNoMostrara = GXv_char23[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV72textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV68MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_CE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_CE2( true) ;
      }
      else
      {
         wb_table2_12_CE2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_CE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_CE2e( true) ;
      }
      else
      {
         wb_table1_9_CE2e( false) ;
      }
   }

   public void wb_table2_12_CE2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e21ce1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_ObligacionWW.htm");
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
         AV76WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV76WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV99Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV76WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV76WelcomeMessage_Foto)==0) ? AV99Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV76WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV76WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ObligacionWW.htm");
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
         wb_table3_30_CE2( true) ;
      }
      else
      {
         wb_table3_30_CE2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_CE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_CE2( true) ;
      }
      else
      {
         wb_table4_35_CE2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_CE2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV70WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_ObligacionWW.htm");
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
         wb_table5_54_CE2( true) ;
      }
      else
      {
         wb_table5_54_CE2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_CE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_CE2( true) ;
      }
      else
      {
         wb_table6_63_CE2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_CE2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV45GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV46GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV47GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_CE2e( true) ;
      }
      else
      {
         wb_table2_12_CE2e( false) ;
      }
   }

   public void wb_table6_63_CE2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_ObligacionWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_ObligacionWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV43DDO_TitleSettingsIcons);
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV85ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 7, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e22ce1_client"+"'", TempTags, "", 2, "HLP_ObligacionWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ObligacionWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_ObligacionWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_ObligacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_CE2( true) ;
      }
      else
      {
         wb_table7_99_CE2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_CE2e( boolean wbgen )
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
         wb_table6_63_CE2e( true) ;
      }
      else
      {
         wb_table6_63_CE2e( false) ;
      }
   }

   public void wb_table7_99_CE2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_ObligacionWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_CE2e( true) ;
      }
      else
      {
         wb_table7_99_CE2e( false) ;
      }
   }

   public void wb_table5_54_CE2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_ObligacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_ObligacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_CE2e( true) ;
      }
      else
      {
         wb_table5_54_CE2e( false) ;
      }
   }

   public void wb_table4_35_CE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_ObligacionWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_CE2e( true) ;
      }
      else
      {
         wb_table4_35_CE2e( false) ;
      }
   }

   public void wb_table3_30_CE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_ObligacionWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_CE2e( true) ;
      }
      else
      {
         wb_table3_30_CE2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV68MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68MenuOpcCod", AV68MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV68MenuOpcCod, ""))));
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
      paCE2( ) ;
      wsCE2( ) ;
      weCE2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171356694", true, true);
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
      httpContext.AddJavascriptSource("obligacionww.js", "?2025171356695", false, true);
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
      edtOblSecuencial_Internalname = "OBLSECUENCIAL_"+sGXsfl_110_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_110_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_110_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_110_idx ;
      edtLegIdNomApe_Internalname = "LEGIDNOMAPE_"+sGXsfl_110_idx ;
      edtTipoOblSec_Internalname = "TIPOOBLSEC_"+sGXsfl_110_idx ;
      edtTipoOblDescrip_Internalname = "TIPOOBLDESCRIP_"+sGXsfl_110_idx ;
      edtOblConcepto_Internalname = "OBLCONCEPTO_"+sGXsfl_110_idx ;
      cmbOblEstado.setInternalname( "OBLESTADO_"+sGXsfl_110_idx );
      edtOblObs_Internalname = "OBLOBS_"+sGXsfl_110_idx ;
      cmbOblOriPer.setInternalname( "OBLORIPER_"+sGXsfl_110_idx );
      edtOblConCodigo_Internalname = "OBLCONCODIGO_"+sGXsfl_110_idx ;
      edtOblTotal_Internalname = "OBLTOTAL_"+sGXsfl_110_idx ;
      edtOblCanCuo_Internalname = "OBLCANCUO_"+sGXsfl_110_idx ;
      edtOblImpFij_Internalname = "OBLIMPFIJ_"+sGXsfl_110_idx ;
      edtOblPorc_Internalname = "OBLPORC_"+sGXsfl_110_idx ;
      chkOblNoRemu.setInternalname( "OBLNOREMU_"+sGXsfl_110_idx );
      chkOblDescu.setInternalname( "OBLDESCU_"+sGXsfl_110_idx );
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_110_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_110_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_110_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_110_idx ;
   }

   public void subsflControlProps_fel_1102( )
   {
      edtOblSecuencial_Internalname = "OBLSECUENCIAL_"+sGXsfl_110_fel_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_110_fel_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_110_fel_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_110_fel_idx ;
      edtLegIdNomApe_Internalname = "LEGIDNOMAPE_"+sGXsfl_110_fel_idx ;
      edtTipoOblSec_Internalname = "TIPOOBLSEC_"+sGXsfl_110_fel_idx ;
      edtTipoOblDescrip_Internalname = "TIPOOBLDESCRIP_"+sGXsfl_110_fel_idx ;
      edtOblConcepto_Internalname = "OBLCONCEPTO_"+sGXsfl_110_fel_idx ;
      cmbOblEstado.setInternalname( "OBLESTADO_"+sGXsfl_110_fel_idx );
      edtOblObs_Internalname = "OBLOBS_"+sGXsfl_110_fel_idx ;
      cmbOblOriPer.setInternalname( "OBLORIPER_"+sGXsfl_110_fel_idx );
      edtOblConCodigo_Internalname = "OBLCONCODIGO_"+sGXsfl_110_fel_idx ;
      edtOblTotal_Internalname = "OBLTOTAL_"+sGXsfl_110_fel_idx ;
      edtOblCanCuo_Internalname = "OBLCANCUO_"+sGXsfl_110_fel_idx ;
      edtOblImpFij_Internalname = "OBLIMPFIJ_"+sGXsfl_110_fel_idx ;
      edtOblPorc_Internalname = "OBLPORC_"+sGXsfl_110_fel_idx ;
      chkOblNoRemu.setInternalname( "OBLNOREMU_"+sGXsfl_110_fel_idx );
      chkOblDescu.setInternalname( "OBLDESCU_"+sGXsfl_110_fel_idx );
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
      wbCE0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtOblSecuencial_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOblSecuencial_Internalname,GXutil.ltrim( localUtil.ntoc( A1172OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1172OblSecuencial), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOblSecuencial_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOblSecuencial_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegIdNomApe_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegIdNomApe_Internalname,A250LegIdNomApe,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegIdNomApe_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegIdNomApe_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtTipoOblSec_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTipoOblSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1163TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1163TipoOblSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTipoOblSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtTipoOblSec_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtTipoOblDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTipoOblDescrip_Internalname,A1165TipoOblDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTipoOblDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtTipoOblDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtOblConcepto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOblConcepto_Internalname,GXutil.rtrim( A2343OblConcepto),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOblConcepto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtOblConcepto_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbOblEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbOblEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "OBLESTADO_" + sGXsfl_110_idx ;
            cmbOblEstado.setName( GXCCtl );
            cmbOblEstado.setWebtags( "" );
            cmbOblEstado.addItem("0", httpContext.getMessage( "Inactivo", ""), (short)(0));
            cmbOblEstado.addItem("1", httpContext.getMessage( "Activo", ""), (short)(0));
            if ( cmbOblEstado.getItemCount() > 0 )
            {
               A1173OblEstado = (byte)(GXutil.lval( cmbOblEstado.getValidValue(GXutil.trim( GXutil.str( A1173OblEstado, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbOblEstado,cmbOblEstado.getInternalname(),GXutil.trim( GXutil.str( A1173OblEstado, 1, 0)),Integer.valueOf(1),cmbOblEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbOblEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbOblEstado.setValue( GXutil.trim( GXutil.str( A1173OblEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblEstado.getInternalname(), "Values", cmbOblEstado.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtOblObs_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOblObs_Internalname,A1174OblObs,A1174OblObs,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOblObs_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOblObs_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"Obs","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbOblOriPer.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbOblOriPer.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "OBLORIPER_" + sGXsfl_110_idx ;
            cmbOblOriPer.setName( GXCCtl );
            cmbOblOriPer.setWebtags( "" );
            cmbOblOriPer.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
            cmbOblOriPer.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
            cmbOblOriPer.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
            cmbOblOriPer.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
            cmbOblOriPer.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
            cmbOblOriPer.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
            cmbOblOriPer.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
            cmbOblOriPer.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
            cmbOblOriPer.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
            cmbOblOriPer.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
            cmbOblOriPer.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
            cmbOblOriPer.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
            if ( cmbOblOriPer.getItemCount() > 0 )
            {
               A1175OblOriPer = (byte)(GXutil.lval( cmbOblOriPer.getValidValue(GXutil.trim( GXutil.str( A1175OblOriPer, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbOblOriPer,cmbOblOriPer.getInternalname(),GXutil.trim( GXutil.str( A1175OblOriPer, 2, 0)),Integer.valueOf(1),cmbOblOriPer.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbOblOriPer.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbOblOriPer.setValue( GXutil.trim( GXutil.str( A1175OblOriPer, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblOriPer.getInternalname(), "Values", cmbOblOriPer.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtOblConCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOblConCodigo_Internalname,GXutil.rtrim( A1169OblConCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOblConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOblConCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtOblTotal_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOblTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A1176OblTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1176OblTotal, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOblTotal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOblTotal_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtOblCanCuo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOblCanCuo_Internalname,GXutil.ltrim( localUtil.ntoc( A1177OblCanCuo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1177OblCanCuo), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOblCanCuo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOblCanCuo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtOblImpFij_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOblImpFij_Internalname,GXutil.ltrim( localUtil.ntoc( A1178OblImpFij, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1178OblImpFij, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOblImpFij_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOblImpFij_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtOblPorc_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOblPorc_Internalname,GXutil.ltrim( localUtil.ntoc( A1179OblPorc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1179OblPorc, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOblPorc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOblPorc_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkOblNoRemu.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "OBLNOREMU_" + sGXsfl_110_idx ;
         chkOblNoRemu.setName( GXCCtl );
         chkOblNoRemu.setWebtags( "" );
         chkOblNoRemu.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkOblNoRemu.getInternalname(), "TitleCaption", chkOblNoRemu.getCaption(), !bGXsfl_110_Refreshing);
         chkOblNoRemu.setCheckedValue( "false" );
         A1181OblNoRemu = GXutil.strtobool( GXutil.booltostr( A1181OblNoRemu)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkOblNoRemu.getInternalname(),GXutil.booltostr( A1181OblNoRemu),"","",Integer.valueOf(chkOblNoRemu.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkOblDescu.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "OBLDESCU_" + sGXsfl_110_idx ;
         chkOblDescu.setName( GXCCtl );
         chkOblDescu.setWebtags( "" );
         chkOblDescu.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkOblDescu.getInternalname(), "TitleCaption", chkOblDescu.getCaption(), !bGXsfl_110_Refreshing);
         chkOblDescu.setCheckedValue( "false" );
         A1182OblDescu = GXutil.strtobool( GXutil.booltostr( A1182OblDescu)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkOblDescu.getInternalname(),GXutil.booltostr( A1182OblDescu),"","",Integer.valueOf(chkOblDescu.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV48Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV50Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV67Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV64VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV65ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV66EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesCE2( ) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOblSecuencial_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nro.", "")) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtTipoOblSec_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obligación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtTipoOblDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obligación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOblConcepto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbOblEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Estado", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOblObs_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Observaciones", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbOblOriPer.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Origen Periodo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOblConCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Origen concepto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOblTotal_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOblCanCuo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de cuotas", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOblImpFij_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe de cuota fija", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOblPorc_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Porcentaje", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkOblNoRemu.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "No remunerativos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkOblDescu.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Retenciones", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1172OblSecuencial, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOblSecuencial_Visible, (byte)(5), (byte)(0), ".", "")));
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1163TipoOblSec, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtTipoOblSec_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1165TipoOblDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtTipoOblDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2343OblConcepto));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOblConcepto_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1173OblEstado, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbOblEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1174OblObs);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOblObs_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1175OblOriPer, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbOblOriPer.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1169OblConCodigo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOblConCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1176OblTotal, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOblTotal_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1177OblCanCuo, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOblCanCuo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1178OblImpFij, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOblImpFij_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1179OblPorc, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOblPorc_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1181OblNoRemu));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkOblNoRemu.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1182OblDescu));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkOblDescu.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV48Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV50Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV67Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV64VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV65ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV66EliminarSVG));
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
      edtOblSecuencial_Internalname = "OBLSECUENCIAL" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtLegIdNomApe_Internalname = "LEGIDNOMAPE" ;
      edtTipoOblSec_Internalname = "TIPOOBLSEC" ;
      edtTipoOblDescrip_Internalname = "TIPOOBLDESCRIP" ;
      edtOblConcepto_Internalname = "OBLCONCEPTO" ;
      cmbOblEstado.setInternalname( "OBLESTADO" );
      edtOblObs_Internalname = "OBLOBS" ;
      cmbOblOriPer.setInternalname( "OBLORIPER" );
      edtOblConCodigo_Internalname = "OBLCONCODIGO" ;
      edtOblTotal_Internalname = "OBLTOTAL" ;
      edtOblCanCuo_Internalname = "OBLCANCUO" ;
      edtOblImpFij_Internalname = "OBLIMPFIJ" ;
      edtOblPorc_Internalname = "OBLPORC" ;
      chkOblNoRemu.setInternalname( "OBLNOREMU" );
      chkOblDescu.setInternalname( "OBLDESCU" );
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
      chkOblDescu.setCaption( "" );
      chkOblNoRemu.setCaption( "" );
      edtOblPorc_Jsonclick = "" ;
      edtOblImpFij_Jsonclick = "" ;
      edtOblCanCuo_Jsonclick = "" ;
      edtOblTotal_Jsonclick = "" ;
      edtOblConCodigo_Jsonclick = "" ;
      cmbOblOriPer.setJsonclick( "" );
      edtOblObs_Jsonclick = "" ;
      cmbOblEstado.setJsonclick( "" );
      edtOblConcepto_Jsonclick = "" ;
      edtTipoOblDescrip_Jsonclick = "" ;
      edtTipoOblSec_Jsonclick = "" ;
      edtLegIdNomApe_Jsonclick = "" ;
      edtLegNumero_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      edtOblSecuencial_Jsonclick = "" ;
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
      chkOblDescu.setVisible( -1 );
      chkOblNoRemu.setVisible( -1 );
      edtOblPorc_Visible = -1 ;
      edtOblImpFij_Visible = -1 ;
      edtOblCanCuo_Visible = -1 ;
      edtOblTotal_Visible = -1 ;
      edtOblConCodigo_Visible = -1 ;
      cmbOblOriPer.setVisible( -1 );
      edtOblObs_Visible = -1 ;
      cmbOblEstado.setVisible( -1 );
      edtOblConcepto_Visible = -1 ;
      edtTipoOblDescrip_Visible = -1 ;
      edtTipoOblSec_Visible = -1 ;
      edtLegIdNomApe_Visible = -1 ;
      edtOblSecuencial_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "4.0||4.0|||||||-14.2|4.0|-14.2|6.4||" ;
      Ddo_grid_Datalistproc = "ObligacionWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||||0:Inactivo,1:Activo||1:Enero,2:Febrero,3:Marzo,4:Abril,5:Mayo,6:Junio,7:Julio,8:Agosto,9:Septiembre,10:Octubre,11:Noviembre,12:Diciembre||||||1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked" ;
      Ddo_grid_Allowmultipleselection = "|T||T|T|T|T|T|T||||||" ;
      Ddo_grid_Datalisttype = "|Dynamic||Dynamic|Dynamic|FixedValues|Dynamic|FixedValues|Dynamic|||||FixedValues|FixedValues" ;
      Ddo_grid_Includedatalist = "|T||T|T|T|T|T|T|||||T|T" ;
      Ddo_grid_Filterisrange = "T||T|||||||T|T|T|T||" ;
      Ddo_grid_Filtertype = "Numeric|Character|Numeric|Character|Character||Character||Character|Numeric|Numeric|Numeric|Numeric||" ;
      Ddo_grid_Includefilter = "T|T|T|T|T||T||T|T|T|T|T||" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T||T|T|T|T|T|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "1||2|3|4|5|6|7|8|9|10|11|12|13|14" ;
      Ddo_grid_Columnids = "0:OblSecuencial|4:LegIdNomApe|5:TipoOblSec|6:TipoOblDescrip|7:OblConcepto|8:OblEstado|9:OblObs|10:OblOriPer|11:OblConCodigo|12:OblTotal|13:OblCanCuo|14:OblImpFij|15:OblPorc|16:OblNoRemu|17:OblDescu" ;
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
      Form.setCaption( httpContext.getMessage( " Obligacion", "") );
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
      AV70WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV70WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70WelcomeMessage_NoMostrarMas", AV70WelcomeMessage_NoMostrarMas);
      GXCCtl = "OBLESTADO_" + sGXsfl_110_idx ;
      cmbOblEstado.setName( GXCCtl );
      cmbOblEstado.setWebtags( "" );
      cmbOblEstado.addItem("0", httpContext.getMessage( "Inactivo", ""), (short)(0));
      cmbOblEstado.addItem("1", httpContext.getMessage( "Activo", ""), (short)(0));
      if ( cmbOblEstado.getItemCount() > 0 )
      {
         A1173OblEstado = (byte)(GXutil.lval( cmbOblEstado.getValidValue(GXutil.trim( GXutil.str( A1173OblEstado, 1, 0))))) ;
      }
      GXCCtl = "OBLORIPER_" + sGXsfl_110_idx ;
      cmbOblOriPer.setName( GXCCtl );
      cmbOblOriPer.setWebtags( "" );
      cmbOblOriPer.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbOblOriPer.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbOblOriPer.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbOblOriPer.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbOblOriPer.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbOblOriPer.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbOblOriPer.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbOblOriPer.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbOblOriPer.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbOblOriPer.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbOblOriPer.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbOblOriPer.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbOblOriPer.getItemCount() > 0 )
      {
         A1175OblOriPer = (byte)(GXutil.lval( cmbOblOriPer.getValidValue(GXutil.trim( GXutil.str( A1175OblOriPer, 2, 0))))) ;
      }
      GXCCtl = "OBLNOREMU_" + sGXsfl_110_idx ;
      chkOblNoRemu.setName( GXCCtl );
      chkOblNoRemu.setWebtags( "" );
      chkOblNoRemu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOblNoRemu.getInternalname(), "TitleCaption", chkOblNoRemu.getCaption(), !bGXsfl_110_Refreshing);
      chkOblNoRemu.setCheckedValue( "false" );
      A1181OblNoRemu = GXutil.strtobool( GXutil.booltostr( A1181OblNoRemu)) ;
      GXCCtl = "OBLDESCU_" + sGXsfl_110_idx ;
      chkOblDescu.setName( GXCCtl );
      chkOblDescu.setWebtags( "" );
      chkOblDescu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOblDescu.getInternalname(), "TitleCaption", chkOblDescu.getCaption(), !bGXsfl_110_Refreshing);
      chkOblDescu.setCheckedValue( "false" );
      A1182OblDescu = GXutil.strtobool( GXutil.booltostr( A1182OblDescu)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV87ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV68MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFOblSecuencial',fld:'vTFOBLSECUENCIAL',pic:'ZZZ9'},{av:'AV23TFOblSecuencial_To',fld:'vTFOBLSECUENCIAL_TO',pic:'ZZZ9'},{av:'AV25TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV26TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV56TFTipoOblSec',fld:'vTFTIPOOBLSEC',pic:'ZZZ9'},{av:'AV57TFTipoOblSec_To',fld:'vTFTIPOOBLSEC_TO',pic:'ZZZ9'},{av:'AV78TFTipoOblDescrip',fld:'vTFTIPOOBLDESCRIP',pic:''},{av:'AV79TFTipoOblDescrip_Sels',fld:'vTFTIPOOBLDESCRIP_SELS',pic:''},{av:'AV81TFOblConcepto',fld:'vTFOBLCONCEPTO',pic:''},{av:'AV82TFOblConcepto_Sels',fld:'vTFOBLCONCEPTO_SELS',pic:''},{av:'AV28TFOblEstado_Sels',fld:'vTFOBLESTADO_SELS',pic:''},{av:'AV30TFOblObs',fld:'vTFOBLOBS',pic:''},{av:'AV31TFOblObs_Sels',fld:'vTFOBLOBS_SELS',pic:''},{av:'AV59TFOblOriPer_Sels',fld:'vTFOBLORIPER_SELS',pic:''},{av:'AV61TFOblConCodigo',fld:'vTFOBLCONCODIGO',pic:''},{av:'AV62TFOblConCodigo_Sels',fld:'vTFOBLCONCODIGO_SELS',pic:''},{av:'AV32TFOblTotal',fld:'vTFOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV33TFOblTotal_To',fld:'vTFOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFOblCanCuo',fld:'vTFOBLCANCUO',pic:'ZZZ9'},{av:'AV35TFOblCanCuo_To',fld:'vTFOBLCANCUO_TO',pic:'ZZZ9'},{av:'AV36TFOblImpFij',fld:'vTFOBLIMPFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFOblImpFij_To',fld:'vTFOBLIMPFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFOblPorc',fld:'vTFOBLPORC',pic:'9.9999'},{av:'AV39TFOblPorc_To',fld:'vTFOBLPORC_TO',pic:'9.9999'},{av:'AV41TFOblNoRemu_Sel',fld:'vTFOBLNOREMU_SEL',pic:'9'},{av:'AV42TFOblDescu_Sel',fld:'vTFOBLDESCU_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV51IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV70WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV55EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV87ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtOblSecuencial_Visible',ctrl:'OBLSECUENCIAL',prop:'Visible'},{av:'edtLegIdNomApe_Visible',ctrl:'LEGIDNOMAPE',prop:'Visible'},{av:'edtTipoOblSec_Visible',ctrl:'TIPOOBLSEC',prop:'Visible'},{av:'edtTipoOblDescrip_Visible',ctrl:'TIPOOBLDESCRIP',prop:'Visible'},{av:'edtOblConcepto_Visible',ctrl:'OBLCONCEPTO',prop:'Visible'},{av:'cmbOblEstado'},{av:'edtOblObs_Visible',ctrl:'OBLOBS',prop:'Visible'},{av:'cmbOblOriPer'},{av:'edtOblConCodigo_Visible',ctrl:'OBLCONCODIGO',prop:'Visible'},{av:'edtOblTotal_Visible',ctrl:'OBLTOTAL',prop:'Visible'},{av:'edtOblCanCuo_Visible',ctrl:'OBLCANCUO',prop:'Visible'},{av:'edtOblImpFij_Visible',ctrl:'OBLIMPFIJ',prop:'Visible'},{av:'edtOblPorc_Visible',ctrl:'OBLPORC',prop:'Visible'},{av:'chkOblNoRemu.getVisible()',ctrl:'OBLNOREMU',prop:'Visible'},{av:'chkOblDescu.getVisible()',ctrl:'OBLDESCU',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV45GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV46GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV47GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV51IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV85ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13CE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV68MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFOblSecuencial',fld:'vTFOBLSECUENCIAL',pic:'ZZZ9'},{av:'AV23TFOblSecuencial_To',fld:'vTFOBLSECUENCIAL_TO',pic:'ZZZ9'},{av:'AV25TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV26TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV56TFTipoOblSec',fld:'vTFTIPOOBLSEC',pic:'ZZZ9'},{av:'AV57TFTipoOblSec_To',fld:'vTFTIPOOBLSEC_TO',pic:'ZZZ9'},{av:'AV78TFTipoOblDescrip',fld:'vTFTIPOOBLDESCRIP',pic:''},{av:'AV79TFTipoOblDescrip_Sels',fld:'vTFTIPOOBLDESCRIP_SELS',pic:''},{av:'AV81TFOblConcepto',fld:'vTFOBLCONCEPTO',pic:''},{av:'AV82TFOblConcepto_Sels',fld:'vTFOBLCONCEPTO_SELS',pic:''},{av:'AV28TFOblEstado_Sels',fld:'vTFOBLESTADO_SELS',pic:''},{av:'AV30TFOblObs',fld:'vTFOBLOBS',pic:''},{av:'AV31TFOblObs_Sels',fld:'vTFOBLOBS_SELS',pic:''},{av:'AV59TFOblOriPer_Sels',fld:'vTFOBLORIPER_SELS',pic:''},{av:'AV61TFOblConCodigo',fld:'vTFOBLCONCODIGO',pic:''},{av:'AV62TFOblConCodigo_Sels',fld:'vTFOBLCONCODIGO_SELS',pic:''},{av:'AV32TFOblTotal',fld:'vTFOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV33TFOblTotal_To',fld:'vTFOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFOblCanCuo',fld:'vTFOBLCANCUO',pic:'ZZZ9'},{av:'AV35TFOblCanCuo_To',fld:'vTFOBLCANCUO_TO',pic:'ZZZ9'},{av:'AV36TFOblImpFij',fld:'vTFOBLIMPFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFOblImpFij_To',fld:'vTFOBLIMPFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFOblPorc',fld:'vTFOBLPORC',pic:'9.9999'},{av:'AV39TFOblPorc_To',fld:'vTFOBLPORC_TO',pic:'9.9999'},{av:'AV41TFOblNoRemu_Sel',fld:'vTFOBLNOREMU_SEL',pic:'9'},{av:'AV42TFOblDescu_Sel',fld:'vTFOBLDESCU_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV51IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV70WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14CE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV68MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFOblSecuencial',fld:'vTFOBLSECUENCIAL',pic:'ZZZ9'},{av:'AV23TFOblSecuencial_To',fld:'vTFOBLSECUENCIAL_TO',pic:'ZZZ9'},{av:'AV25TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV26TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV56TFTipoOblSec',fld:'vTFTIPOOBLSEC',pic:'ZZZ9'},{av:'AV57TFTipoOblSec_To',fld:'vTFTIPOOBLSEC_TO',pic:'ZZZ9'},{av:'AV78TFTipoOblDescrip',fld:'vTFTIPOOBLDESCRIP',pic:''},{av:'AV79TFTipoOblDescrip_Sels',fld:'vTFTIPOOBLDESCRIP_SELS',pic:''},{av:'AV81TFOblConcepto',fld:'vTFOBLCONCEPTO',pic:''},{av:'AV82TFOblConcepto_Sels',fld:'vTFOBLCONCEPTO_SELS',pic:''},{av:'AV28TFOblEstado_Sels',fld:'vTFOBLESTADO_SELS',pic:''},{av:'AV30TFOblObs',fld:'vTFOBLOBS',pic:''},{av:'AV31TFOblObs_Sels',fld:'vTFOBLOBS_SELS',pic:''},{av:'AV59TFOblOriPer_Sels',fld:'vTFOBLORIPER_SELS',pic:''},{av:'AV61TFOblConCodigo',fld:'vTFOBLCONCODIGO',pic:''},{av:'AV62TFOblConCodigo_Sels',fld:'vTFOBLCONCODIGO_SELS',pic:''},{av:'AV32TFOblTotal',fld:'vTFOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV33TFOblTotal_To',fld:'vTFOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFOblCanCuo',fld:'vTFOBLCANCUO',pic:'ZZZ9'},{av:'AV35TFOblCanCuo_To',fld:'vTFOBLCANCUO_TO',pic:'ZZZ9'},{av:'AV36TFOblImpFij',fld:'vTFOBLIMPFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFOblImpFij_To',fld:'vTFOBLIMPFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFOblPorc',fld:'vTFOBLPORC',pic:'9.9999'},{av:'AV39TFOblPorc_To',fld:'vTFOBLPORC_TO',pic:'9.9999'},{av:'AV41TFOblNoRemu_Sel',fld:'vTFOBLNOREMU_SEL',pic:'9'},{av:'AV42TFOblDescu_Sel',fld:'vTFOBLDESCU_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV51IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV70WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15CE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV68MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFOblSecuencial',fld:'vTFOBLSECUENCIAL',pic:'ZZZ9'},{av:'AV23TFOblSecuencial_To',fld:'vTFOBLSECUENCIAL_TO',pic:'ZZZ9'},{av:'AV25TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV26TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV56TFTipoOblSec',fld:'vTFTIPOOBLSEC',pic:'ZZZ9'},{av:'AV57TFTipoOblSec_To',fld:'vTFTIPOOBLSEC_TO',pic:'ZZZ9'},{av:'AV78TFTipoOblDescrip',fld:'vTFTIPOOBLDESCRIP',pic:''},{av:'AV79TFTipoOblDescrip_Sels',fld:'vTFTIPOOBLDESCRIP_SELS',pic:''},{av:'AV81TFOblConcepto',fld:'vTFOBLCONCEPTO',pic:''},{av:'AV82TFOblConcepto_Sels',fld:'vTFOBLCONCEPTO_SELS',pic:''},{av:'AV28TFOblEstado_Sels',fld:'vTFOBLESTADO_SELS',pic:''},{av:'AV30TFOblObs',fld:'vTFOBLOBS',pic:''},{av:'AV31TFOblObs_Sels',fld:'vTFOBLOBS_SELS',pic:''},{av:'AV59TFOblOriPer_Sels',fld:'vTFOBLORIPER_SELS',pic:''},{av:'AV61TFOblConCodigo',fld:'vTFOBLCONCODIGO',pic:''},{av:'AV62TFOblConCodigo_Sels',fld:'vTFOBLCONCODIGO_SELS',pic:''},{av:'AV32TFOblTotal',fld:'vTFOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV33TFOblTotal_To',fld:'vTFOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFOblCanCuo',fld:'vTFOBLCANCUO',pic:'ZZZ9'},{av:'AV35TFOblCanCuo_To',fld:'vTFOBLCANCUO_TO',pic:'ZZZ9'},{av:'AV36TFOblImpFij',fld:'vTFOBLIMPFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFOblImpFij_To',fld:'vTFOBLIMPFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFOblPorc',fld:'vTFOBLPORC',pic:'9.9999'},{av:'AV39TFOblPorc_To',fld:'vTFOBLPORC_TO',pic:'9.9999'},{av:'AV41TFOblNoRemu_Sel',fld:'vTFOBLNOREMU_SEL',pic:'9'},{av:'AV42TFOblDescu_Sel',fld:'vTFOBLDESCU_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV51IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV70WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV42TFOblDescu_Sel',fld:'vTFOBLDESCU_SEL',pic:'9'},{av:'AV41TFOblNoRemu_Sel',fld:'vTFOBLNOREMU_SEL',pic:'9'},{av:'AV38TFOblPorc',fld:'vTFOBLPORC',pic:'9.9999'},{av:'AV39TFOblPorc_To',fld:'vTFOBLPORC_TO',pic:'9.9999'},{av:'AV36TFOblImpFij',fld:'vTFOBLIMPFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFOblImpFij_To',fld:'vTFOBLIMPFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFOblCanCuo',fld:'vTFOBLCANCUO',pic:'ZZZ9'},{av:'AV35TFOblCanCuo_To',fld:'vTFOBLCANCUO_TO',pic:'ZZZ9'},{av:'AV32TFOblTotal',fld:'vTFOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV33TFOblTotal_To',fld:'vTFOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV61TFOblConCodigo',fld:'vTFOBLCONCODIGO',pic:''},{av:'AV60TFOblConCodigo_SelsJson',fld:'vTFOBLCONCODIGO_SELSJSON',pic:''},{av:'AV62TFOblConCodigo_Sels',fld:'vTFOBLCONCODIGO_SELS',pic:''},{av:'AV58TFOblOriPer_SelsJson',fld:'vTFOBLORIPER_SELSJSON',pic:''},{av:'AV59TFOblOriPer_Sels',fld:'vTFOBLORIPER_SELS',pic:''},{av:'AV30TFOblObs',fld:'vTFOBLOBS',pic:''},{av:'AV29TFOblObs_SelsJson',fld:'vTFOBLOBS_SELSJSON',pic:''},{av:'AV31TFOblObs_Sels',fld:'vTFOBLOBS_SELS',pic:''},{av:'AV27TFOblEstado_SelsJson',fld:'vTFOBLESTADO_SELSJSON',pic:''},{av:'AV28TFOblEstado_Sels',fld:'vTFOBLESTADO_SELS',pic:''},{av:'AV81TFOblConcepto',fld:'vTFOBLCONCEPTO',pic:''},{av:'AV80TFOblConcepto_SelsJson',fld:'vTFOBLCONCEPTO_SELSJSON',pic:''},{av:'AV82TFOblConcepto_Sels',fld:'vTFOBLCONCEPTO_SELS',pic:''},{av:'AV78TFTipoOblDescrip',fld:'vTFTIPOOBLDESCRIP',pic:''},{av:'AV77TFTipoOblDescrip_SelsJson',fld:'vTFTIPOOBLDESCRIP_SELSJSON',pic:''},{av:'AV79TFTipoOblDescrip_Sels',fld:'vTFTIPOOBLDESCRIP_SELS',pic:''},{av:'AV56TFTipoOblSec',fld:'vTFTIPOOBLSEC',pic:'ZZZ9'},{av:'AV57TFTipoOblSec_To',fld:'vTFTIPOOBLSEC_TO',pic:'ZZZ9'},{av:'AV25TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV24TFLegIdNomApe_SelsJson',fld:'vTFLEGIDNOMAPE_SELSJSON',pic:''},{av:'AV26TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV22TFOblSecuencial',fld:'vTFOBLSECUENCIAL',pic:'ZZZ9'},{av:'AV23TFOblSecuencial_To',fld:'vTFOBLSECUENCIAL_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e20CE2',iparms:[{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A1172OblSecuencial',fld:'OBLSECUENCIAL',pic:'ZZZ9'},{av:'AV51IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV48Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV50Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV67Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV64VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV65ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV66EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11CE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV68MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFOblSecuencial',fld:'vTFOBLSECUENCIAL',pic:'ZZZ9'},{av:'AV23TFOblSecuencial_To',fld:'vTFOBLSECUENCIAL_TO',pic:'ZZZ9'},{av:'AV25TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV26TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV56TFTipoOblSec',fld:'vTFTIPOOBLSEC',pic:'ZZZ9'},{av:'AV57TFTipoOblSec_To',fld:'vTFTIPOOBLSEC_TO',pic:'ZZZ9'},{av:'AV78TFTipoOblDescrip',fld:'vTFTIPOOBLDESCRIP',pic:''},{av:'AV79TFTipoOblDescrip_Sels',fld:'vTFTIPOOBLDESCRIP_SELS',pic:''},{av:'AV81TFOblConcepto',fld:'vTFOBLCONCEPTO',pic:''},{av:'AV82TFOblConcepto_Sels',fld:'vTFOBLCONCEPTO_SELS',pic:''},{av:'AV28TFOblEstado_Sels',fld:'vTFOBLESTADO_SELS',pic:''},{av:'AV30TFOblObs',fld:'vTFOBLOBS',pic:''},{av:'AV31TFOblObs_Sels',fld:'vTFOBLOBS_SELS',pic:''},{av:'AV59TFOblOriPer_Sels',fld:'vTFOBLORIPER_SELS',pic:''},{av:'AV61TFOblConCodigo',fld:'vTFOBLCONCODIGO',pic:''},{av:'AV62TFOblConCodigo_Sels',fld:'vTFOBLCONCODIGO_SELS',pic:''},{av:'AV32TFOblTotal',fld:'vTFOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV33TFOblTotal_To',fld:'vTFOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFOblCanCuo',fld:'vTFOBLCANCUO',pic:'ZZZ9'},{av:'AV35TFOblCanCuo_To',fld:'vTFOBLCANCUO_TO',pic:'ZZZ9'},{av:'AV36TFOblImpFij',fld:'vTFOBLIMPFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFOblImpFij_To',fld:'vTFOBLIMPFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFOblPorc',fld:'vTFOBLPORC',pic:'9.9999'},{av:'AV39TFOblPorc_To',fld:'vTFOBLPORC_TO',pic:'9.9999'},{av:'AV41TFOblNoRemu_Sel',fld:'vTFOBLNOREMU_SEL',pic:'9'},{av:'AV42TFOblDescu_Sel',fld:'vTFOBLDESCU_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV51IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV70WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV55EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV87ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtOblSecuencial_Visible',ctrl:'OBLSECUENCIAL',prop:'Visible'},{av:'edtLegIdNomApe_Visible',ctrl:'LEGIDNOMAPE',prop:'Visible'},{av:'edtTipoOblSec_Visible',ctrl:'TIPOOBLSEC',prop:'Visible'},{av:'edtTipoOblDescrip_Visible',ctrl:'TIPOOBLDESCRIP',prop:'Visible'},{av:'edtOblConcepto_Visible',ctrl:'OBLCONCEPTO',prop:'Visible'},{av:'cmbOblEstado'},{av:'edtOblObs_Visible',ctrl:'OBLOBS',prop:'Visible'},{av:'cmbOblOriPer'},{av:'edtOblConCodigo_Visible',ctrl:'OBLCONCODIGO',prop:'Visible'},{av:'edtOblTotal_Visible',ctrl:'OBLTOTAL',prop:'Visible'},{av:'edtOblCanCuo_Visible',ctrl:'OBLCANCUO',prop:'Visible'},{av:'edtOblImpFij_Visible',ctrl:'OBLIMPFIJ',prop:'Visible'},{av:'edtOblPorc_Visible',ctrl:'OBLPORC',prop:'Visible'},{av:'chkOblNoRemu.getVisible()',ctrl:'OBLNOREMU',prop:'Visible'},{av:'chkOblDescu.getVisible()',ctrl:'OBLDESCU',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV45GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV46GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV47GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV51IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV85ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12CE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV68MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFOblSecuencial',fld:'vTFOBLSECUENCIAL',pic:'ZZZ9'},{av:'AV23TFOblSecuencial_To',fld:'vTFOBLSECUENCIAL_TO',pic:'ZZZ9'},{av:'AV25TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV26TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV56TFTipoOblSec',fld:'vTFTIPOOBLSEC',pic:'ZZZ9'},{av:'AV57TFTipoOblSec_To',fld:'vTFTIPOOBLSEC_TO',pic:'ZZZ9'},{av:'AV78TFTipoOblDescrip',fld:'vTFTIPOOBLDESCRIP',pic:''},{av:'AV79TFTipoOblDescrip_Sels',fld:'vTFTIPOOBLDESCRIP_SELS',pic:''},{av:'AV81TFOblConcepto',fld:'vTFOBLCONCEPTO',pic:''},{av:'AV82TFOblConcepto_Sels',fld:'vTFOBLCONCEPTO_SELS',pic:''},{av:'AV28TFOblEstado_Sels',fld:'vTFOBLESTADO_SELS',pic:''},{av:'AV30TFOblObs',fld:'vTFOBLOBS',pic:''},{av:'AV31TFOblObs_Sels',fld:'vTFOBLOBS_SELS',pic:''},{av:'AV59TFOblOriPer_Sels',fld:'vTFOBLORIPER_SELS',pic:''},{av:'AV61TFOblConCodigo',fld:'vTFOBLCONCODIGO',pic:''},{av:'AV62TFOblConCodigo_Sels',fld:'vTFOBLCONCODIGO_SELS',pic:''},{av:'AV32TFOblTotal',fld:'vTFOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV33TFOblTotal_To',fld:'vTFOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFOblCanCuo',fld:'vTFOBLCANCUO',pic:'ZZZ9'},{av:'AV35TFOblCanCuo_To',fld:'vTFOBLCANCUO_TO',pic:'ZZZ9'},{av:'AV36TFOblImpFij',fld:'vTFOBLIMPFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFOblImpFij_To',fld:'vTFOBLIMPFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFOblPorc',fld:'vTFOBLPORC',pic:'9.9999'},{av:'AV39TFOblPorc_To',fld:'vTFOBLPORC_TO',pic:'9.9999'},{av:'AV41TFOblNoRemu_Sel',fld:'vTFOBLNOREMU_SEL',pic:'9'},{av:'AV42TFOblDescu_Sel',fld:'vTFOBLDESCU_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV51IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV70WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV24TFLegIdNomApe_SelsJson',fld:'vTFLEGIDNOMAPE_SELSJSON',pic:''},{av:'AV77TFTipoOblDescrip_SelsJson',fld:'vTFTIPOOBLDESCRIP_SELSJSON',pic:''},{av:'AV80TFOblConcepto_SelsJson',fld:'vTFOBLCONCEPTO_SELSJSON',pic:''},{av:'AV27TFOblEstado_SelsJson',fld:'vTFOBLESTADO_SELSJSON',pic:''},{av:'AV29TFOblObs_SelsJson',fld:'vTFOBLOBS_SELSJSON',pic:''},{av:'AV58TFOblOriPer_SelsJson',fld:'vTFOBLORIPER_SELSJSON',pic:''},{av:'AV60TFOblConCodigo_SelsJson',fld:'vTFOBLCONCODIGO_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV87ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV22TFOblSecuencial',fld:'vTFOBLSECUENCIAL',pic:'ZZZ9'},{av:'AV23TFOblSecuencial_To',fld:'vTFOBLSECUENCIAL_TO',pic:'ZZZ9'},{av:'AV25TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV26TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV56TFTipoOblSec',fld:'vTFTIPOOBLSEC',pic:'ZZZ9'},{av:'AV57TFTipoOblSec_To',fld:'vTFTIPOOBLSEC_TO',pic:'ZZZ9'},{av:'AV78TFTipoOblDescrip',fld:'vTFTIPOOBLDESCRIP',pic:''},{av:'AV79TFTipoOblDescrip_Sels',fld:'vTFTIPOOBLDESCRIP_SELS',pic:''},{av:'AV81TFOblConcepto',fld:'vTFOBLCONCEPTO',pic:''},{av:'AV82TFOblConcepto_Sels',fld:'vTFOBLCONCEPTO_SELS',pic:''},{av:'AV28TFOblEstado_Sels',fld:'vTFOBLESTADO_SELS',pic:''},{av:'AV30TFOblObs',fld:'vTFOBLOBS',pic:''},{av:'AV31TFOblObs_Sels',fld:'vTFOBLOBS_SELS',pic:''},{av:'AV59TFOblOriPer_Sels',fld:'vTFOBLORIPER_SELS',pic:''},{av:'AV61TFOblConCodigo',fld:'vTFOBLCONCODIGO',pic:''},{av:'AV62TFOblConCodigo_Sels',fld:'vTFOBLCONCODIGO_SELS',pic:''},{av:'AV32TFOblTotal',fld:'vTFOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV33TFOblTotal_To',fld:'vTFOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFOblCanCuo',fld:'vTFOBLCANCUO',pic:'ZZZ9'},{av:'AV35TFOblCanCuo_To',fld:'vTFOBLCANCUO_TO',pic:'ZZZ9'},{av:'AV36TFOblImpFij',fld:'vTFOBLIMPFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFOblImpFij_To',fld:'vTFOBLIMPFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFOblPorc',fld:'vTFOBLPORC',pic:'9.9999'},{av:'AV39TFOblPorc_To',fld:'vTFOBLPORC_TO',pic:'9.9999'},{av:'AV41TFOblNoRemu_Sel',fld:'vTFOBLNOREMU_SEL',pic:'9'},{av:'AV42TFOblDescu_Sel',fld:'vTFOBLDESCU_SEL',pic:'9'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV60TFOblConCodigo_SelsJson',fld:'vTFOBLCONCODIGO_SELSJSON',pic:''},{av:'AV58TFOblOriPer_SelsJson',fld:'vTFOBLORIPER_SELSJSON',pic:''},{av:'AV29TFOblObs_SelsJson',fld:'vTFOBLOBS_SELSJSON',pic:''},{av:'AV27TFOblEstado_SelsJson',fld:'vTFOBLESTADO_SELSJSON',pic:''},{av:'AV80TFOblConcepto_SelsJson',fld:'vTFOBLCONCEPTO_SELSJSON',pic:''},{av:'AV77TFTipoOblDescrip_SelsJson',fld:'vTFTIPOOBLDESCRIP_SELSJSON',pic:''},{av:'AV24TFLegIdNomApe_SelsJson',fld:'vTFLEGIDNOMAPE_SELSJSON',pic:''},{av:'AV55EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtOblSecuencial_Visible',ctrl:'OBLSECUENCIAL',prop:'Visible'},{av:'edtLegIdNomApe_Visible',ctrl:'LEGIDNOMAPE',prop:'Visible'},{av:'edtTipoOblSec_Visible',ctrl:'TIPOOBLSEC',prop:'Visible'},{av:'edtTipoOblDescrip_Visible',ctrl:'TIPOOBLDESCRIP',prop:'Visible'},{av:'edtOblConcepto_Visible',ctrl:'OBLCONCEPTO',prop:'Visible'},{av:'cmbOblEstado'},{av:'edtOblObs_Visible',ctrl:'OBLOBS',prop:'Visible'},{av:'cmbOblOriPer'},{av:'edtOblConCodigo_Visible',ctrl:'OBLCONCODIGO',prop:'Visible'},{av:'edtOblTotal_Visible',ctrl:'OBLTOTAL',prop:'Visible'},{av:'edtOblCanCuo_Visible',ctrl:'OBLCANCUO',prop:'Visible'},{av:'edtOblImpFij_Visible',ctrl:'OBLIMPFIJ',prop:'Visible'},{av:'edtOblPorc_Visible',ctrl:'OBLPORC',prop:'Visible'},{av:'chkOblNoRemu.getVisible()',ctrl:'OBLNOREMU',prop:'Visible'},{av:'chkOblDescu.getVisible()',ctrl:'OBLDESCU',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV45GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV46GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV47GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV51IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV85ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e22CE1',iparms:[{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV55EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e16CE2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17CE2',iparms:[{av:'AV70WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV68MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV54CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e21CE1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_TIPOOBLSEC","{handler:'valid_Tipooblsec',iparms:[]");
      setEventMetadata("VALID_TIPOOBLSEC",",oparms:[]}");
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
      wcpOAV68MenuOpcCod = "" ;
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
      AV68MenuOpcCod = "" ;
      AV19ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV100Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25TFLegIdNomApe = "" ;
      AV26TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78TFTipoOblDescrip = "" ;
      AV79TFTipoOblDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV81TFOblConcepto = "" ;
      AV82TFOblConcepto_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28TFOblEstado_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV30TFOblObs = "" ;
      AV31TFOblObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59TFOblOriPer_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV61TFOblConCodigo = "" ;
      AV62TFOblConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV32TFOblTotal = DecimalUtil.ZERO ;
      AV33TFOblTotal_To = DecimalUtil.ZERO ;
      AV36TFOblImpFij = DecimalUtil.ZERO ;
      AV37TFOblImpFij_To = DecimalUtil.ZERO ;
      AV38TFOblPorc = DecimalUtil.ZERO ;
      AV39TFOblPorc_To = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV43DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV85ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV47GridAppliedFilters = "" ;
      AV24TFLegIdNomApe_SelsJson = "" ;
      AV77TFTipoOblDescrip_SelsJson = "" ;
      AV80TFOblConcepto_SelsJson = "" ;
      AV27TFOblEstado_SelsJson = "" ;
      AV29TFOblObs_SelsJson = "" ;
      AV58TFOblOriPer_SelsJson = "" ;
      AV60TFOblConCodigo_SelsJson = "" ;
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
      A250LegIdNomApe = "" ;
      A1165TipoOblDescrip = "" ;
      A2343OblConcepto = "" ;
      A1174OblObs = "" ;
      A1169OblConCodigo = "" ;
      A1176OblTotal = DecimalUtil.ZERO ;
      A1178OblImpFij = DecimalUtil.ZERO ;
      A1179OblPorc = DecimalUtil.ZERO ;
      AV48Update = "" ;
      AV50Delete = "" ;
      AV67Display = "" ;
      AV64VerSVG = "" ;
      AV65ModificarSVG = "" ;
      AV66EliminarSVG = "" ;
      AV104Obligacionwwds_4_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV108Obligacionwwds_8_tftipoobldescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV110Obligacionwwds_10_tfoblconcepto_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV111Obligacionwwds_11_tfoblestado_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV113Obligacionwwds_13_tfoblobs_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV114Obligacionwwds_14_tfobloriper_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV116Obligacionwwds_16_tfoblconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV103Obligacionwwds_3_tflegidnomape = "" ;
      lV107Obligacionwwds_7_tftipoobldescrip = "" ;
      lV109Obligacionwwds_9_tfoblconcepto = "" ;
      lV112Obligacionwwds_12_tfoblobs = "" ;
      lV115Obligacionwwds_15_tfoblconcodigo = "" ;
      AV103Obligacionwwds_3_tflegidnomape = "" ;
      AV107Obligacionwwds_7_tftipoobldescrip = "" ;
      AV109Obligacionwwds_9_tfoblconcepto = "" ;
      AV112Obligacionwwds_12_tfoblobs = "" ;
      AV115Obligacionwwds_15_tfoblconcodigo = "" ;
      AV117Obligacionwwds_17_tfobltotal = DecimalUtil.ZERO ;
      AV118Obligacionwwds_18_tfobltotal_to = DecimalUtil.ZERO ;
      AV121Obligacionwwds_21_tfoblimpfij = DecimalUtil.ZERO ;
      AV122Obligacionwwds_22_tfoblimpfij_to = DecimalUtil.ZERO ;
      AV123Obligacionwwds_23_tfoblporc = DecimalUtil.ZERO ;
      AV124Obligacionwwds_24_tfoblporc_to = DecimalUtil.ZERO ;
      H00CE2_A1182OblDescu = new boolean[] {false} ;
      H00CE2_A1181OblNoRemu = new boolean[] {false} ;
      H00CE2_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CE2_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CE2_A1177OblCanCuo = new short[1] ;
      H00CE2_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CE2_A1169OblConCodigo = new String[] {""} ;
      H00CE2_n1169OblConCodigo = new boolean[] {false} ;
      H00CE2_A1175OblOriPer = new byte[1] ;
      H00CE2_A1174OblObs = new String[] {""} ;
      H00CE2_A1173OblEstado = new byte[1] ;
      H00CE2_A2343OblConcepto = new String[] {""} ;
      H00CE2_A1165TipoOblDescrip = new String[] {""} ;
      H00CE2_A1163TipoOblSec = new short[1] ;
      H00CE2_A250LegIdNomApe = new String[] {""} ;
      H00CE2_A6LegNumero = new int[1] ;
      H00CE2_A1EmpCod = new short[1] ;
      H00CE2_A3CliCod = new int[1] ;
      H00CE2_A1172OblSecuencial = new short[1] ;
      H00CE3_AGRID_nRecordCount = new long[1] ;
      AV76WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV71MenuBienveImgURL = "" ;
      AV73MenuBienveTitulo = "" ;
      AV74MenuBienveTexto = "" ;
      AV99Welcomemessage_foto_GXI = "" ;
      AV96observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext13 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV17ColumnsSelectorXML = "" ;
      AV92MenuOpcTitulo = "" ;
      GXv_int12 = new short[1] ;
      AV95filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV86ManageFiltersXml = "" ;
      AV83ExcelFilename = "" ;
      AV84ErrorMessage = "" ;
      AV18UserCustomValue = "" ;
      AV20ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector15 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char22 = "" ;
      GXt_char20 = "" ;
      GXv_char21 = new String[1] ;
      GXt_char19 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char10 = "" ;
      GXv_char6 = new String[1] ;
      GXt_char9 = "" ;
      GXv_char5 = new String[1] ;
      GXv_SdtWWPGridState24 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV72textoNoMostrara = "" ;
      GXv_char23 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obligacionww__default(),
         new Object[] {
             new Object[] {
            H00CE2_A1182OblDescu, H00CE2_A1181OblNoRemu, H00CE2_A1179OblPorc, H00CE2_A1178OblImpFij, H00CE2_A1177OblCanCuo, H00CE2_A1176OblTotal, H00CE2_A1169OblConCodigo, H00CE2_n1169OblConCodigo, H00CE2_A1175OblOriPer, H00CE2_A1174OblObs,
            H00CE2_A1173OblEstado, H00CE2_A2343OblConcepto, H00CE2_A1165TipoOblDescrip, H00CE2_A1163TipoOblSec, H00CE2_A250LegIdNomApe, H00CE2_A6LegNumero, H00CE2_A1EmpCod, H00CE2_A3CliCod, H00CE2_A1172OblSecuencial
            }
            , new Object[] {
            H00CE3_AGRID_nRecordCount
            }
         }
      );
      AV100Pgmname = "ObligacionWW" ;
      /* GeneXus formulas. */
      AV100Pgmname = "ObligacionWW" ;
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
   private byte AV87ManageFiltersExecutionStep ;
   private byte AV41TFOblNoRemu_Sel ;
   private byte AV42TFOblDescu_Sel ;
   private byte gxajaxcallmode ;
   private byte A1173OblEstado ;
   private byte A1175OblOriPer ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV125Obligacionwwds_25_tfoblnoremu_sel ;
   private byte AV126Obligacionwwds_26_tfobldescu_sel ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV22TFOblSecuencial ;
   private short AV23TFOblSecuencial_To ;
   private short AV56TFTipoOblSec ;
   private short AV57TFTipoOblSec_To ;
   private short AV34TFOblCanCuo ;
   private short AV35TFOblCanCuo_To ;
   private short AV14OrderedBy ;
   private short AV55EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1172OblSecuencial ;
   private short A1EmpCod ;
   private short A1163TipoOblSec ;
   private short A1177OblCanCuo ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV101Obligacionwwds_1_tfoblsecuencial ;
   private short AV102Obligacionwwds_2_tfoblsecuencial_to ;
   private short AV105Obligacionwwds_5_tftipooblsec ;
   private short AV106Obligacionwwds_6_tftipooblsec_to ;
   private short AV119Obligacionwwds_19_tfoblcancuo ;
   private short AV120Obligacionwwds_20_tfoblcancuo_to ;
   private short GXt_int11 ;
   private short GXv_int12[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV54CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV104Obligacionwwds_4_tflegidnomape_sels_size ;
   private int AV108Obligacionwwds_8_tftipoobldescrip_sels_size ;
   private int AV110Obligacionwwds_10_tfoblconcepto_sels_size ;
   private int AV111Obligacionwwds_11_tfoblestado_sels_size ;
   private int AV113Obligacionwwds_13_tfoblobs_sels_size ;
   private int AV114Obligacionwwds_14_tfobloriper_sels_size ;
   private int AV116Obligacionwwds_16_tfoblconcodigo_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtOblSecuencial_Visible ;
   private int edtLegIdNomApe_Visible ;
   private int edtTipoOblSec_Visible ;
   private int edtTipoOblDescrip_Visible ;
   private int edtOblConcepto_Visible ;
   private int edtOblObs_Visible ;
   private int edtOblConCodigo_Visible ;
   private int edtOblTotal_Visible ;
   private int edtOblCanCuo_Visible ;
   private int edtOblImpFij_Visible ;
   private int edtOblPorc_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV94filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV44PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtninsert_Visible ;
   private int AV127GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV45GridCurrentPage ;
   private long AV46GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV32TFOblTotal ;
   private java.math.BigDecimal AV33TFOblTotal_To ;
   private java.math.BigDecimal AV36TFOblImpFij ;
   private java.math.BigDecimal AV37TFOblImpFij_To ;
   private java.math.BigDecimal AV38TFOblPorc ;
   private java.math.BigDecimal AV39TFOblPorc_To ;
   private java.math.BigDecimal A1176OblTotal ;
   private java.math.BigDecimal A1178OblImpFij ;
   private java.math.BigDecimal A1179OblPorc ;
   private java.math.BigDecimal AV117Obligacionwwds_17_tfobltotal ;
   private java.math.BigDecimal AV118Obligacionwwds_18_tfobltotal_to ;
   private java.math.BigDecimal AV121Obligacionwwds_21_tfoblimpfij ;
   private java.math.BigDecimal AV122Obligacionwwds_22_tfoblimpfij_to ;
   private java.math.BigDecimal AV123Obligacionwwds_23_tfoblporc ;
   private java.math.BigDecimal AV124Obligacionwwds_24_tfoblporc_to ;
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
   private String AV100Pgmname ;
   private String AV81TFOblConcepto ;
   private String AV61TFOblConCodigo ;
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
   private String edtOblSecuencial_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtLegNumero_Internalname ;
   private String edtLegIdNomApe_Internalname ;
   private String edtTipoOblSec_Internalname ;
   private String edtTipoOblDescrip_Internalname ;
   private String A2343OblConcepto ;
   private String edtOblConcepto_Internalname ;
   private String edtOblObs_Internalname ;
   private String A1169OblConCodigo ;
   private String edtOblConCodigo_Internalname ;
   private String edtOblTotal_Internalname ;
   private String edtOblCanCuo_Internalname ;
   private String edtOblImpFij_Internalname ;
   private String edtOblPorc_Internalname ;
   private String AV48Update ;
   private String edtavUpdate_Internalname ;
   private String AV50Delete ;
   private String edtavDelete_Internalname ;
   private String AV67Display ;
   private String edtavDisplay_Internalname ;
   private String AV64VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV65ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV66EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String lV109Obligacionwwds_9_tfoblconcepto ;
   private String lV115Obligacionwwds_15_tfoblconcodigo ;
   private String AV109Obligacionwwds_9_tfoblconcepto ;
   private String AV115Obligacionwwds_15_tfoblconcodigo ;
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
   private String AV96observerPalabra ;
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
   private String GXt_char22 ;
   private String GXt_char20 ;
   private String GXv_char21[] ;
   private String GXt_char19 ;
   private String GXv_char7[] ;
   private String GXt_char10 ;
   private String GXv_char6[] ;
   private String GXt_char9 ;
   private String GXv_char5[] ;
   private String GXv_char23[] ;
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
   private String edtOblSecuencial_Jsonclick ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegIdNomApe_Jsonclick ;
   private String edtTipoOblSec_Jsonclick ;
   private String edtTipoOblDescrip_Jsonclick ;
   private String edtOblConcepto_Jsonclick ;
   private String GXCCtl ;
   private String edtOblObs_Jsonclick ;
   private String edtOblConCodigo_Jsonclick ;
   private String edtOblTotal_Jsonclick ;
   private String edtOblCanCuo_Jsonclick ;
   private String edtOblImpFij_Jsonclick ;
   private String edtOblPorc_Jsonclick ;
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
   private boolean AV49IsAuthorized_Update ;
   private boolean AV51IsAuthorized_Delete ;
   private boolean AV70WelcomeMessage_NoMostrarMas ;
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
   private boolean n1169OblConCodigo ;
   private boolean A1181OblNoRemu ;
   private boolean A1182OblDescu ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV75MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean AV53TempBoolean ;
   private boolean GXt_boolean16 ;
   private boolean GXv_boolean8[] ;
   private boolean AV76WelcomeMessage_Foto_IsBlob ;
   private String AV24TFLegIdNomApe_SelsJson ;
   private String AV77TFTipoOblDescrip_SelsJson ;
   private String AV80TFOblConcepto_SelsJson ;
   private String AV27TFOblEstado_SelsJson ;
   private String AV29TFOblObs_SelsJson ;
   private String AV58TFOblOriPer_SelsJson ;
   private String AV60TFOblConCodigo_SelsJson ;
   private String A1174OblObs ;
   private String AV74MenuBienveTexto ;
   private String AV17ColumnsSelectorXML ;
   private String AV86ManageFiltersXml ;
   private String AV18UserCustomValue ;
   private String AV72textoNoMostrara ;
   private String wcpOAV68MenuOpcCod ;
   private String AV68MenuOpcCod ;
   private String AV25TFLegIdNomApe ;
   private String AV78TFTipoOblDescrip ;
   private String AV30TFOblObs ;
   private String AV47GridAppliedFilters ;
   private String A250LegIdNomApe ;
   private String A1165TipoOblDescrip ;
   private String lV103Obligacionwwds_3_tflegidnomape ;
   private String lV107Obligacionwwds_7_tftipoobldescrip ;
   private String lV112Obligacionwwds_12_tfoblobs ;
   private String AV103Obligacionwwds_3_tflegidnomape ;
   private String AV107Obligacionwwds_7_tftipoobldescrip ;
   private String AV112Obligacionwwds_12_tfoblobs ;
   private String AV71MenuBienveImgURL ;
   private String AV73MenuBienveTitulo ;
   private String AV99Welcomemessage_foto_GXI ;
   private String AV92MenuOpcTitulo ;
   private String AV95filtrosTexto ;
   private String AV83ExcelFilename ;
   private String AV84ErrorMessage ;
   private String AV76WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV111Obligacionwwds_11_tfoblestado_sels ;
   private GXSimpleCollection<Byte> AV114Obligacionwwds_14_tfobloriper_sels ;
   private GXSimpleCollection<Byte> AV28TFOblEstado_Sels ;
   private GXSimpleCollection<Byte> AV59TFOblOriPer_Sels ;
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
   private GXSimpleCollection<String> AV110Obligacionwwds_10_tfoblconcepto_sels ;
   private GXSimpleCollection<String> AV116Obligacionwwds_16_tfoblconcodigo_sels ;
   private GXSimpleCollection<String> AV104Obligacionwwds_4_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV108Obligacionwwds_8_tftipoobldescrip_sels ;
   private GXSimpleCollection<String> AV113Obligacionwwds_13_tfoblobs_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbOblEstado ;
   private HTMLChoice cmbOblOriPer ;
   private ICheckbox chkOblNoRemu ;
   private ICheckbox chkOblDescu ;
   private IDataStoreProvider pr_default ;
   private boolean[] H00CE2_A1182OblDescu ;
   private boolean[] H00CE2_A1181OblNoRemu ;
   private java.math.BigDecimal[] H00CE2_A1179OblPorc ;
   private java.math.BigDecimal[] H00CE2_A1178OblImpFij ;
   private short[] H00CE2_A1177OblCanCuo ;
   private java.math.BigDecimal[] H00CE2_A1176OblTotal ;
   private String[] H00CE2_A1169OblConCodigo ;
   private boolean[] H00CE2_n1169OblConCodigo ;
   private byte[] H00CE2_A1175OblOriPer ;
   private String[] H00CE2_A1174OblObs ;
   private byte[] H00CE2_A1173OblEstado ;
   private String[] H00CE2_A2343OblConcepto ;
   private String[] H00CE2_A1165TipoOblDescrip ;
   private short[] H00CE2_A1163TipoOblSec ;
   private String[] H00CE2_A250LegIdNomApe ;
   private int[] H00CE2_A6LegNumero ;
   private short[] H00CE2_A1EmpCod ;
   private int[] H00CE2_A3CliCod ;
   private short[] H00CE2_A1172OblSecuencial ;
   private long[] H00CE3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV82TFOblConcepto_Sels ;
   private GXSimpleCollection<String> AV62TFOblConCodigo_Sels ;
   private GXSimpleCollection<String> AV26TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV79TFTipoOblDescrip_Sels ;
   private GXSimpleCollection<String> AV31TFOblObs_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV85ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext13[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState24[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector15[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV43DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class obligacionww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00CE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV104Obligacionwwds_4_tflegidnomape_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV108Obligacionwwds_8_tftipoobldescrip_sels ,
                                          String A2343OblConcepto ,
                                          GXSimpleCollection<String> AV110Obligacionwwds_10_tfoblconcepto_sels ,
                                          byte A1173OblEstado ,
                                          GXSimpleCollection<Byte> AV111Obligacionwwds_11_tfoblestado_sels ,
                                          String A1174OblObs ,
                                          GXSimpleCollection<String> AV113Obligacionwwds_13_tfoblobs_sels ,
                                          byte A1175OblOriPer ,
                                          GXSimpleCollection<Byte> AV114Obligacionwwds_14_tfobloriper_sels ,
                                          String A1169OblConCodigo ,
                                          GXSimpleCollection<String> AV116Obligacionwwds_16_tfoblconcodigo_sels ,
                                          short AV101Obligacionwwds_1_tfoblsecuencial ,
                                          short AV102Obligacionwwds_2_tfoblsecuencial_to ,
                                          int AV104Obligacionwwds_4_tflegidnomape_sels_size ,
                                          String AV103Obligacionwwds_3_tflegidnomape ,
                                          short AV105Obligacionwwds_5_tftipooblsec ,
                                          short AV106Obligacionwwds_6_tftipooblsec_to ,
                                          int AV108Obligacionwwds_8_tftipoobldescrip_sels_size ,
                                          String AV107Obligacionwwds_7_tftipoobldescrip ,
                                          int AV110Obligacionwwds_10_tfoblconcepto_sels_size ,
                                          String AV109Obligacionwwds_9_tfoblconcepto ,
                                          int AV111Obligacionwwds_11_tfoblestado_sels_size ,
                                          int AV113Obligacionwwds_13_tfoblobs_sels_size ,
                                          String AV112Obligacionwwds_12_tfoblobs ,
                                          int AV114Obligacionwwds_14_tfobloriper_sels_size ,
                                          int AV116Obligacionwwds_16_tfoblconcodigo_sels_size ,
                                          String AV115Obligacionwwds_15_tfoblconcodigo ,
                                          java.math.BigDecimal AV117Obligacionwwds_17_tfobltotal ,
                                          java.math.BigDecimal AV118Obligacionwwds_18_tfobltotal_to ,
                                          short AV119Obligacionwwds_19_tfoblcancuo ,
                                          short AV120Obligacionwwds_20_tfoblcancuo_to ,
                                          java.math.BigDecimal AV121Obligacionwwds_21_tfoblimpfij ,
                                          java.math.BigDecimal AV122Obligacionwwds_22_tfoblimpfij_to ,
                                          java.math.BigDecimal AV123Obligacionwwds_23_tfoblporc ,
                                          java.math.BigDecimal AV124Obligacionwwds_24_tfoblporc_to ,
                                          byte AV125Obligacionwwds_25_tfoblnoremu_sel ,
                                          byte AV126Obligacionwwds_26_tfobldescu_sel ,
                                          short A1172OblSecuencial ,
                                          short A1163TipoOblSec ,
                                          java.math.BigDecimal A1176OblTotal ,
                                          short A1177OblCanCuo ,
                                          java.math.BigDecimal A1178OblImpFij ,
                                          java.math.BigDecimal A1179OblPorc ,
                                          boolean A1181OblNoRemu ,
                                          boolean A1182OblDescu ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV54CliCod ,
                                          short AV55EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[22];
      Object[] GXv_Object26 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.OblDescu, T1.OblNoRemu, T1.OblPorc, T1.OblImpFij, T1.OblCanCuo, T1.OblTotal, T1.OblConCodigo, T1.OblOriPer, T1.OblObs, T1.OblEstado, T1.OblConcepto, T2.TipoOblDescrip," ;
      sSelectString += " T1.TipoOblSec, T3.LegIdNomApe, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.OblSecuencial" ;
      sFromString = " FROM ((Obligacion T1 INNER JOIN tipo_obligacion T2 ON T2.TipoOblSec = T1.TipoOblSec) INNER JOIN Legajo T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod = T1.EmpCod AND" ;
      sFromString += " T3.LegNumero = T1.LegNumero)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ! (0==AV101Obligacionwwds_1_tfoblsecuencial) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial >= ?)");
      }
      else
      {
         GXv_int25[2] = (byte)(1) ;
      }
      if ( ! (0==AV102Obligacionwwds_2_tfoblsecuencial_to) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial <= ?)");
      }
      else
      {
         GXv_int25[3] = (byte)(1) ;
      }
      if ( ( AV104Obligacionwwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV103Obligacionwwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int25[4] = (byte)(1) ;
      }
      if ( AV104Obligacionwwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV104Obligacionwwds_4_tflegidnomape_sels, "T3.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV105Obligacionwwds_5_tftipooblsec) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec >= ?)");
      }
      else
      {
         GXv_int25[5] = (byte)(1) ;
      }
      if ( ! (0==AV106Obligacionwwds_6_tftipooblsec_to) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec <= ?)");
      }
      else
      {
         GXv_int25[6] = (byte)(1) ;
      }
      if ( ( AV108Obligacionwwds_8_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV107Obligacionwwds_7_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int25[7] = (byte)(1) ;
      }
      if ( AV108Obligacionwwds_8_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV108Obligacionwwds_8_tftipoobldescrip_sels, "T2.TipoOblDescrip IN (", ")")+")");
      }
      if ( ( AV110Obligacionwwds_10_tfoblconcepto_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV109Obligacionwwds_9_tfoblconcepto)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConcepto) like LOWER(?))");
      }
      else
      {
         GXv_int25[8] = (byte)(1) ;
      }
      if ( AV110Obligacionwwds_10_tfoblconcepto_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110Obligacionwwds_10_tfoblconcepto_sels, "T1.OblConcepto IN (", ")")+")");
      }
      if ( AV111Obligacionwwds_11_tfoblestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV111Obligacionwwds_11_tfoblestado_sels, "T1.OblEstado IN (", ")")+")");
      }
      if ( ( AV113Obligacionwwds_13_tfoblobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV112Obligacionwwds_12_tfoblobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblObs) like LOWER(?))");
      }
      else
      {
         GXv_int25[9] = (byte)(1) ;
      }
      if ( AV113Obligacionwwds_13_tfoblobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV113Obligacionwwds_13_tfoblobs_sels, "T1.OblObs IN (", ")")+")");
      }
      if ( AV114Obligacionwwds_14_tfobloriper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Obligacionwwds_14_tfobloriper_sels, "T1.OblOriPer IN (", ")")+")");
      }
      if ( ( AV116Obligacionwwds_16_tfoblconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV115Obligacionwwds_15_tfoblconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int25[10] = (byte)(1) ;
      }
      if ( AV116Obligacionwwds_16_tfoblconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV116Obligacionwwds_16_tfoblconcodigo_sels, "T1.OblConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Obligacionwwds_17_tfobltotal)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal >= ?)");
      }
      else
      {
         GXv_int25[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Obligacionwwds_18_tfobltotal_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal <= ?)");
      }
      else
      {
         GXv_int25[12] = (byte)(1) ;
      }
      if ( ! (0==AV119Obligacionwwds_19_tfoblcancuo) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo >= ?)");
      }
      else
      {
         GXv_int25[13] = (byte)(1) ;
      }
      if ( ! (0==AV120Obligacionwwds_20_tfoblcancuo_to) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo <= ?)");
      }
      else
      {
         GXv_int25[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV121Obligacionwwds_21_tfoblimpfij)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij >= ?)");
      }
      else
      {
         GXv_int25[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV122Obligacionwwds_22_tfoblimpfij_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij <= ?)");
      }
      else
      {
         GXv_int25[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV123Obligacionwwds_23_tfoblporc)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc >= ?)");
      }
      else
      {
         GXv_int25[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV124Obligacionwwds_24_tfoblporc_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc <= ?)");
      }
      else
      {
         GXv_int25[18] = (byte)(1) ;
      }
      if ( AV125Obligacionwwds_25_tfoblnoremu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = TRUE)");
      }
      if ( AV125Obligacionwwds_25_tfoblnoremu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = FALSE)");
      }
      if ( AV126Obligacionwwds_26_tfobldescu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblDescu = TRUE)");
      }
      if ( AV126Obligacionwwds_26_tfobldescu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblDescu = FALSE)");
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblSecuencial, T1.CliCod, T1.EmpCod, T1.LegNumero" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblSecuencial DESC, T1.CliCod, T1.EmpCod, T1.LegNumero" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.TipoOblSec, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.TipoOblSec DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T2.TipoOblDescrip, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.TipoOblDescrip DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblConcepto, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblConcepto DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblEstado, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblEstado DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblObs, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblObs DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblOriPer, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblOriPer DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblConCodigo, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblConCodigo DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblTotal, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblTotal DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblCanCuo, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblCanCuo DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblImpFij, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblImpFij DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblPorc, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblPorc DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblNoRemu, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblNoRemu DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.OblDescu, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.OblDescu DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object26[0] = scmdbuf ;
      GXv_Object26[1] = GXv_int25 ;
      return GXv_Object26 ;
   }

   protected Object[] conditional_H00CE3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV104Obligacionwwds_4_tflegidnomape_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV108Obligacionwwds_8_tftipoobldescrip_sels ,
                                          String A2343OblConcepto ,
                                          GXSimpleCollection<String> AV110Obligacionwwds_10_tfoblconcepto_sels ,
                                          byte A1173OblEstado ,
                                          GXSimpleCollection<Byte> AV111Obligacionwwds_11_tfoblestado_sels ,
                                          String A1174OblObs ,
                                          GXSimpleCollection<String> AV113Obligacionwwds_13_tfoblobs_sels ,
                                          byte A1175OblOriPer ,
                                          GXSimpleCollection<Byte> AV114Obligacionwwds_14_tfobloriper_sels ,
                                          String A1169OblConCodigo ,
                                          GXSimpleCollection<String> AV116Obligacionwwds_16_tfoblconcodigo_sels ,
                                          short AV101Obligacionwwds_1_tfoblsecuencial ,
                                          short AV102Obligacionwwds_2_tfoblsecuencial_to ,
                                          int AV104Obligacionwwds_4_tflegidnomape_sels_size ,
                                          String AV103Obligacionwwds_3_tflegidnomape ,
                                          short AV105Obligacionwwds_5_tftipooblsec ,
                                          short AV106Obligacionwwds_6_tftipooblsec_to ,
                                          int AV108Obligacionwwds_8_tftipoobldescrip_sels_size ,
                                          String AV107Obligacionwwds_7_tftipoobldescrip ,
                                          int AV110Obligacionwwds_10_tfoblconcepto_sels_size ,
                                          String AV109Obligacionwwds_9_tfoblconcepto ,
                                          int AV111Obligacionwwds_11_tfoblestado_sels_size ,
                                          int AV113Obligacionwwds_13_tfoblobs_sels_size ,
                                          String AV112Obligacionwwds_12_tfoblobs ,
                                          int AV114Obligacionwwds_14_tfobloriper_sels_size ,
                                          int AV116Obligacionwwds_16_tfoblconcodigo_sels_size ,
                                          String AV115Obligacionwwds_15_tfoblconcodigo ,
                                          java.math.BigDecimal AV117Obligacionwwds_17_tfobltotal ,
                                          java.math.BigDecimal AV118Obligacionwwds_18_tfobltotal_to ,
                                          short AV119Obligacionwwds_19_tfoblcancuo ,
                                          short AV120Obligacionwwds_20_tfoblcancuo_to ,
                                          java.math.BigDecimal AV121Obligacionwwds_21_tfoblimpfij ,
                                          java.math.BigDecimal AV122Obligacionwwds_22_tfoblimpfij_to ,
                                          java.math.BigDecimal AV123Obligacionwwds_23_tfoblporc ,
                                          java.math.BigDecimal AV124Obligacionwwds_24_tfoblporc_to ,
                                          byte AV125Obligacionwwds_25_tfoblnoremu_sel ,
                                          byte AV126Obligacionwwds_26_tfobldescu_sel ,
                                          short A1172OblSecuencial ,
                                          short A1163TipoOblSec ,
                                          java.math.BigDecimal A1176OblTotal ,
                                          short A1177OblCanCuo ,
                                          java.math.BigDecimal A1178OblImpFij ,
                                          java.math.BigDecimal A1179OblPorc ,
                                          boolean A1181OblNoRemu ,
                                          boolean A1182OblDescu ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV54CliCod ,
                                          short AV55EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int28 = new byte[19];
      Object[] GXv_Object29 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((Obligacion T1 INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = T1.TipoOblSec) INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod" ;
      scmdbuf += " = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ! (0==AV101Obligacionwwds_1_tfoblsecuencial) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial >= ?)");
      }
      else
      {
         GXv_int28[2] = (byte)(1) ;
      }
      if ( ! (0==AV102Obligacionwwds_2_tfoblsecuencial_to) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial <= ?)");
      }
      else
      {
         GXv_int28[3] = (byte)(1) ;
      }
      if ( ( AV104Obligacionwwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV103Obligacionwwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int28[4] = (byte)(1) ;
      }
      if ( AV104Obligacionwwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV104Obligacionwwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV105Obligacionwwds_5_tftipooblsec) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec >= ?)");
      }
      else
      {
         GXv_int28[5] = (byte)(1) ;
      }
      if ( ! (0==AV106Obligacionwwds_6_tftipooblsec_to) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec <= ?)");
      }
      else
      {
         GXv_int28[6] = (byte)(1) ;
      }
      if ( ( AV108Obligacionwwds_8_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV107Obligacionwwds_7_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int28[7] = (byte)(1) ;
      }
      if ( AV108Obligacionwwds_8_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV108Obligacionwwds_8_tftipoobldescrip_sels, "T3.TipoOblDescrip IN (", ")")+")");
      }
      if ( ( AV110Obligacionwwds_10_tfoblconcepto_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV109Obligacionwwds_9_tfoblconcepto)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConcepto) like LOWER(?))");
      }
      else
      {
         GXv_int28[8] = (byte)(1) ;
      }
      if ( AV110Obligacionwwds_10_tfoblconcepto_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110Obligacionwwds_10_tfoblconcepto_sels, "T1.OblConcepto IN (", ")")+")");
      }
      if ( AV111Obligacionwwds_11_tfoblestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV111Obligacionwwds_11_tfoblestado_sels, "T1.OblEstado IN (", ")")+")");
      }
      if ( ( AV113Obligacionwwds_13_tfoblobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV112Obligacionwwds_12_tfoblobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblObs) like LOWER(?))");
      }
      else
      {
         GXv_int28[9] = (byte)(1) ;
      }
      if ( AV113Obligacionwwds_13_tfoblobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV113Obligacionwwds_13_tfoblobs_sels, "T1.OblObs IN (", ")")+")");
      }
      if ( AV114Obligacionwwds_14_tfobloriper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Obligacionwwds_14_tfobloriper_sels, "T1.OblOriPer IN (", ")")+")");
      }
      if ( ( AV116Obligacionwwds_16_tfoblconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV115Obligacionwwds_15_tfoblconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int28[10] = (byte)(1) ;
      }
      if ( AV116Obligacionwwds_16_tfoblconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV116Obligacionwwds_16_tfoblconcodigo_sels, "T1.OblConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Obligacionwwds_17_tfobltotal)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal >= ?)");
      }
      else
      {
         GXv_int28[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Obligacionwwds_18_tfobltotal_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal <= ?)");
      }
      else
      {
         GXv_int28[12] = (byte)(1) ;
      }
      if ( ! (0==AV119Obligacionwwds_19_tfoblcancuo) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo >= ?)");
      }
      else
      {
         GXv_int28[13] = (byte)(1) ;
      }
      if ( ! (0==AV120Obligacionwwds_20_tfoblcancuo_to) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo <= ?)");
      }
      else
      {
         GXv_int28[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV121Obligacionwwds_21_tfoblimpfij)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij >= ?)");
      }
      else
      {
         GXv_int28[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV122Obligacionwwds_22_tfoblimpfij_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij <= ?)");
      }
      else
      {
         GXv_int28[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV123Obligacionwwds_23_tfoblporc)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc >= ?)");
      }
      else
      {
         GXv_int28[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV124Obligacionwwds_24_tfoblporc_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc <= ?)");
      }
      else
      {
         GXv_int28[18] = (byte)(1) ;
      }
      if ( AV125Obligacionwwds_25_tfoblnoremu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = TRUE)");
      }
      if ( AV125Obligacionwwds_25_tfoblnoremu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = FALSE)");
      }
      if ( AV126Obligacionwwds_26_tfobldescu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblDescu = TRUE)");
      }
      if ( AV126Obligacionwwds_26_tfobldescu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblDescu = FALSE)");
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
      GXv_Object29[0] = scmdbuf ;
      GXv_Object29[1] = GXv_int28 ;
      return GXv_Object29 ;
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
                  return conditional_H00CE2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Boolean) dynConstraints[46]).booleanValue() , ((Boolean) dynConstraints[47]).booleanValue() , ((Number) dynConstraints[48]).shortValue() , ((Boolean) dynConstraints[49]).booleanValue() , ((Number) dynConstraints[50]).intValue() , ((Number) dynConstraints[51]).shortValue() , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).shortValue() );
            case 1 :
                  return conditional_H00CE3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Boolean) dynConstraints[46]).booleanValue() , ((Boolean) dynConstraints[47]).booleanValue() , ((Number) dynConstraints[48]).shortValue() , ((Boolean) dynConstraints[49]).booleanValue() , ((Number) dynConstraints[50]).intValue() , ((Number) dynConstraints[51]).shortValue() , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00CE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00CE3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((byte[]) buf[10])[0] = rslt.getByte(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 10);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((short[]) buf[13])[0] = rslt.getShort(13);
               ((String[]) buf[14])[0] = rslt.getVarchar(14);
               ((int[]) buf[15])[0] = rslt.getInt(15);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((int[]) buf[17])[0] = rslt.getInt(17);
               ((short[]) buf[18])[0] = rslt.getShort(18);
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
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[30], 10);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[32], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 4);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[40], 4);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[41]).intValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[42]).intValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[43]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 10);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 4);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 4);
               }
               return;
      }
   }

}

