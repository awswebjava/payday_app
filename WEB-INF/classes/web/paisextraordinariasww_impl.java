package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paisextraordinariasww_impl extends GXDataArea
{
   public paisextraordinariasww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paisextraordinariasww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisextraordinariasww_impl.class ));
   }

   public paisextraordinariasww_impl( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbPaiHsPDiaTipTra = new HTMLChoice();
      cmbPaiHsPDiaDia = new HTMLChoice();
      cmbPaiTarifaPDCri = new HTMLChoice();
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
            AV53MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53MenuOpcCod", AV53MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV53MenuOpcCod, ""))));
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
      AV47PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV67ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21ColumnsSelector);
      AV82Pgmname = httpContext.GetPar( "Pgmname") ;
      AV53MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV25TFPaiHsPDiaTipTra_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV27TFPaiHsPDiaDia_Sels);
      AV29TFPaiHsPDiaDesde = httpContext.GetPar( "TFPaiHsPDiaDesde") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30TFPaiHsPDiaDesde_Sels);
      AV31TFPaiTarifaPDia = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiTarifaPDia"), ".") ;
      AV32TFPaiTarifaPDia_To = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiTarifaPDia_To"), ".") ;
      AV33TFPaiTarifaPDRec = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiTarifaPDRec"), ".") ;
      AV34TFPaiTarifaPDRec_To = CommonUtil.decimalVal( httpContext.GetPar( "TFPaiTarifaPDRec_To"), ".") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV78TFPaiTarifaPDCri_Sels);
      AV63TFPaiExtraordRelRef = httpContext.GetPar( "TFPaiExtraordRelRef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV64TFPaiExtraordRelRef_Sels);
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV45CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV41IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV43IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV55WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV47PaiCod, AV67ManageFiltersExecutionStep, AV21ColumnsSelector, AV82Pgmname, AV53MenuOpcCod, AV12GridState, AV25TFPaiHsPDiaTipTra_Sels, AV27TFPaiHsPDiaDia_Sels, AV29TFPaiHsPDiaDesde, AV30TFPaiHsPDiaDesde_Sels, AV31TFPaiTarifaPDia, AV32TFPaiTarifaPDia_To, AV33TFPaiTarifaPDRec, AV34TFPaiTarifaPDRec_To, AV78TFPaiTarifaPDCri_Sels, AV63TFPaiExtraordRelRef, AV64TFPaiExtraordRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV55WelcomeMessage_NoMostrarMas) ;
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
      paJ92( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startJ92( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paisextraordinariasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV53MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV82Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV53MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV41IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV43IsAuthorized_Delete));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV65ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV65ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV37GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV38GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV39GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV67ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV82Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV82Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV53MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV53MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAIHSPDIATIPTRA_SELS", AV25TFPaiHsPDiaTipTra_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAIHSPDIATIPTRA_SELS", AV25TFPaiHsPDiaTipTra_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAIHSPDIADIA_SELS", AV27TFPaiHsPDiaDia_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAIHSPDIADIA_SELS", AV27TFPaiHsPDiaDia_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIHSPDIADESDE", GXutil.rtrim( AV29TFPaiHsPDiaDesde));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAIHSPDIADESDE_SELS", AV30TFPaiHsPDiaDesde_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAIHSPDIADESDE_SELS", AV30TFPaiHsPDiaDesde_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAITARIFAPDIA", GXutil.ltrim( localUtil.ntoc( AV31TFPaiTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAITARIFAPDIA_TO", GXutil.ltrim( localUtil.ntoc( AV32TFPaiTarifaPDia_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAITARIFAPDREC", GXutil.ltrim( localUtil.ntoc( AV33TFPaiTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAITARIFAPDREC_TO", GXutil.ltrim( localUtil.ntoc( AV34TFPaiTarifaPDRec_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAITARIFAPDCRI_SELS", AV78TFPaiTarifaPDCri_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAITARIFAPDCRI_SELS", AV78TFPaiTarifaPDCri_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIEXTRAORDRELREF", AV63TFPaiExtraordRelRef);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAIEXTRAORDRELREF_SELS", AV64TFPaiExtraordRelRef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAIEXTRAORDRELREF_SELS", AV64TFPaiExtraordRelRef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV45CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV41IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV41IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV43IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV43IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIHSPDIATIPTRA_SELSJSON", AV24TFPaiHsPDiaTipTra_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIHSPDIADIA_SELSJSON", AV26TFPaiHsPDiaDia_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIHSPDIADESDE_SELSJSON", AV28TFPaiHsPDiaDesde_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAITARIFAPDCRI_SELSJSON", AV77TFPaiTarifaPDCri_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAIEXTRAORDRELREF_SELSJSON", AV62TFPaiExtraordRelRef_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV47PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
         weJ92( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtJ92( ) ;
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
      return formatLink("web.paisextraordinariasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV53MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "PaisExtraordinariasWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Pais Extraordinarias", "") ;
   }

   public void wbJ90( )
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
         wb_table1_9_J92( true) ;
      }
      else
      {
         wb_table1_9_J92( false) ;
      }
      return  ;
   }

   public void wb_table1_9_J92e( boolean wbgen )
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

   public void startJ92( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Pais Extraordinarias", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupJ90( ) ;
   }

   public void wsJ92( )
   {
      startJ92( ) ;
      evtJ92( ) ;
   }

   public void evtJ92( )
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
                           e11J92 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12J92 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13J92 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14J92 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15J92 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e16J92 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e17J92 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18J92 ();
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
                           A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1332PaiHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbPaiHsPDiaTipTra.setName( cmbPaiHsPDiaTipTra.getInternalname() );
                           cmbPaiHsPDiaTipTra.setValue( httpContext.cgiGet( cmbPaiHsPDiaTipTra.getInternalname()) );
                           A1331PaiHsPDiaTipTra = httpContext.cgiGet( cmbPaiHsPDiaTipTra.getInternalname()) ;
                           cmbPaiHsPDiaDia.setName( cmbPaiHsPDiaDia.getInternalname() );
                           cmbPaiHsPDiaDia.setValue( httpContext.cgiGet( cmbPaiHsPDiaDia.getInternalname()) );
                           A1333PaiHsPDiaDia = (byte)(GXutil.lval( httpContext.cgiGet( cmbPaiHsPDiaDia.getInternalname()))) ;
                           A1334PaiHsPDiaDesde = httpContext.cgiGet( edtPaiHsPDiaDesde_Internalname) ;
                           n1334PaiHsPDiaDesde = false ;
                           A1335PaiTarifaPDia = localUtil.ctond( httpContext.cgiGet( edtPaiTarifaPDia_Internalname)) ;
                           A1348PaiTarifaPDRec = localUtil.ctond( httpContext.cgiGet( edtPaiTarifaPDRec_Internalname)) ;
                           cmbPaiTarifaPDCri.setName( cmbPaiTarifaPDCri.getInternalname() );
                           cmbPaiTarifaPDCri.setValue( httpContext.cgiGet( cmbPaiTarifaPDCri.getInternalname()) );
                           A2434PaiTarifaPDCri = httpContext.cgiGet( cmbPaiTarifaPDCri.getInternalname()) ;
                           A2058PaiExtraordRelRef = httpContext.cgiGet( edtPaiExtraordRelRef_Internalname) ;
                           AV40Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV40Update);
                           AV42Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV42Delete);
                           AV52Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV52Display);
                           AV49VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV49VerSVG);
                           AV50ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV50ModificarSVG);
                           AV51EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV51EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e19J92 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e20J92 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21J92 ();
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

   public void weJ92( )
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

   public void paJ92( )
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
                                 short AV47PaiCod ,
                                 byte AV67ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ,
                                 String AV82Pgmname ,
                                 String AV53MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 GXSimpleCollection<String> AV25TFPaiHsPDiaTipTra_Sels ,
                                 GXSimpleCollection<Byte> AV27TFPaiHsPDiaDia_Sels ,
                                 String AV29TFPaiHsPDiaDesde ,
                                 GXSimpleCollection<String> AV30TFPaiHsPDiaDesde_Sels ,
                                 java.math.BigDecimal AV31TFPaiTarifaPDia ,
                                 java.math.BigDecimal AV32TFPaiTarifaPDia_To ,
                                 java.math.BigDecimal AV33TFPaiTarifaPDRec ,
                                 java.math.BigDecimal AV34TFPaiTarifaPDRec_To ,
                                 GXSimpleCollection<String> AV78TFPaiTarifaPDCri_Sels ,
                                 String AV63TFPaiExtraordRelRef ,
                                 GXSimpleCollection<String> AV64TFPaiExtraordRelRef_Sels ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV45CliCod ,
                                 boolean AV41IsAuthorized_Update ,
                                 boolean AV43IsAuthorized_Delete ,
                                 boolean AV55WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20J92 ();
      GRID_nCurrentRecord = 0 ;
      rfJ92( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "PAICOD", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAIHSEXSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1332PaiHsExSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "PAIHSEXSEC", GXutil.ltrim( localUtil.ntoc( A1332PaiHsExSec, (byte)(4), (byte)(0), ".", "")));
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
      AV55WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV55WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55WelcomeMessage_NoMostrarMas", AV55WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfJ92( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV82Pgmname = "PaisExtraordinariasWW" ;
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

   public void rfJ92( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e20J92 ();
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
                                              A1331PaiHsPDiaTipTra ,
                                              AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ,
                                              Byte.valueOf(A1333PaiHsPDiaDia) ,
                                              AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels ,
                                              A1334PaiHsPDiaDesde ,
                                              AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ,
                                              A2434PaiTarifaPDCri ,
                                              AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ,
                                              A2058PaiExtraordRelRef ,
                                              AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ,
                                              Integer.valueOf(AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels.size()) ,
                                              Integer.valueOf(AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels.size()) ,
                                              Integer.valueOf(AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels.size()) ,
                                              AV85Paisextraordinariaswwds_3_tfpaihspdiadesde ,
                                              AV87Paisextraordinariaswwds_5_tfpaitarifapdia ,
                                              AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to ,
                                              AV89Paisextraordinariaswwds_7_tfpaitarifapdrec ,
                                              AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to ,
                                              Integer.valueOf(AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels.size()) ,
                                              Integer.valueOf(AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels.size()) ,
                                              AV92Paisextraordinariaswwds_10_tfpaiextraordrelref ,
                                              Short.valueOf(AV47PaiCod) ,
                                              A1335PaiTarifaPDia ,
                                              A1348PaiTarifaPDRec ,
                                              Short.valueOf(A46PaiCod) ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV85Paisextraordinariaswwds_3_tfpaihspdiadesde = GXutil.padr( GXutil.rtrim( AV85Paisextraordinariaswwds_3_tfpaihspdiadesde), 5, "%") ;
         lV92Paisextraordinariaswwds_10_tfpaiextraordrelref = GXutil.concat( GXutil.rtrim( AV92Paisextraordinariaswwds_10_tfpaiextraordrelref), "%", "") ;
         /* Using cursor H00J92 */
         pr_default.execute(0, new Object[] {lV85Paisextraordinariaswwds_3_tfpaihspdiadesde, AV87Paisextraordinariaswwds_5_tfpaitarifapdia, AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to, AV89Paisextraordinariaswwds_7_tfpaitarifapdrec, AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to, lV92Paisextraordinariaswwds_10_tfpaiextraordrelref, Short.valueOf(AV47PaiCod), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2058PaiExtraordRelRef = H00J92_A2058PaiExtraordRelRef[0] ;
            A2434PaiTarifaPDCri = H00J92_A2434PaiTarifaPDCri[0] ;
            A1348PaiTarifaPDRec = H00J92_A1348PaiTarifaPDRec[0] ;
            A1335PaiTarifaPDia = H00J92_A1335PaiTarifaPDia[0] ;
            A1334PaiHsPDiaDesde = H00J92_A1334PaiHsPDiaDesde[0] ;
            n1334PaiHsPDiaDesde = H00J92_n1334PaiHsPDiaDesde[0] ;
            A1333PaiHsPDiaDia = H00J92_A1333PaiHsPDiaDia[0] ;
            A1331PaiHsPDiaTipTra = H00J92_A1331PaiHsPDiaTipTra[0] ;
            A1332PaiHsExSec = H00J92_A1332PaiHsExSec[0] ;
            A46PaiCod = H00J92_A46PaiCod[0] ;
            e21J92 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbJ90( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesJ92( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV82Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV82Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV53MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV53MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV45CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV41IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV41IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV43IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV43IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAICOD"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAIHSEXSEC"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, localUtil.format( DecimalUtil.doubleToDec(A1332PaiHsExSec), "ZZZ9")));
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
      AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = AV25TFPaiHsPDiaTipTra_Sels ;
      AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels = AV27TFPaiHsPDiaDia_Sels ;
      AV85Paisextraordinariaswwds_3_tfpaihspdiadesde = AV29TFPaiHsPDiaDesde ;
      AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = AV30TFPaiHsPDiaDesde_Sels ;
      AV87Paisextraordinariaswwds_5_tfpaitarifapdia = AV31TFPaiTarifaPDia ;
      AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to = AV32TFPaiTarifaPDia_To ;
      AV89Paisextraordinariaswwds_7_tfpaitarifapdrec = AV33TFPaiTarifaPDRec ;
      AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to = AV34TFPaiTarifaPDRec_To ;
      AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = AV78TFPaiTarifaPDCri_Sels ;
      AV92Paisextraordinariaswwds_10_tfpaiextraordrelref = AV63TFPaiExtraordRelRef ;
      AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = AV64TFPaiExtraordRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1331PaiHsPDiaTipTra ,
                                           AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ,
                                           Byte.valueOf(A1333PaiHsPDiaDia) ,
                                           AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels ,
                                           A1334PaiHsPDiaDesde ,
                                           AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ,
                                           A2434PaiTarifaPDCri ,
                                           AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ,
                                           A2058PaiExtraordRelRef ,
                                           AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ,
                                           Integer.valueOf(AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels.size()) ,
                                           Integer.valueOf(AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels.size()) ,
                                           AV85Paisextraordinariaswwds_3_tfpaihspdiadesde ,
                                           AV87Paisextraordinariaswwds_5_tfpaitarifapdia ,
                                           AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to ,
                                           AV89Paisextraordinariaswwds_7_tfpaitarifapdrec ,
                                           AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to ,
                                           Integer.valueOf(AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels.size()) ,
                                           Integer.valueOf(AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels.size()) ,
                                           AV92Paisextraordinariaswwds_10_tfpaiextraordrelref ,
                                           Short.valueOf(AV47PaiCod) ,
                                           A1335PaiTarifaPDia ,
                                           A1348PaiTarifaPDRec ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV85Paisextraordinariaswwds_3_tfpaihspdiadesde = GXutil.padr( GXutil.rtrim( AV85Paisextraordinariaswwds_3_tfpaihspdiadesde), 5, "%") ;
      lV92Paisextraordinariaswwds_10_tfpaiextraordrelref = GXutil.concat( GXutil.rtrim( AV92Paisextraordinariaswwds_10_tfpaiextraordrelref), "%", "") ;
      /* Using cursor H00J93 */
      pr_default.execute(1, new Object[] {lV85Paisextraordinariaswwds_3_tfpaihspdiadesde, AV87Paisextraordinariaswwds_5_tfpaitarifapdia, AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to, AV89Paisextraordinariaswwds_7_tfpaitarifapdrec, AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to, lV92Paisextraordinariaswwds_10_tfpaiextraordrelref, Short.valueOf(AV47PaiCod)});
      GRID_nRecordCount = H00J93_AGRID_nRecordCount[0] ;
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
      AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = AV25TFPaiHsPDiaTipTra_Sels ;
      AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels = AV27TFPaiHsPDiaDia_Sels ;
      AV85Paisextraordinariaswwds_3_tfpaihspdiadesde = AV29TFPaiHsPDiaDesde ;
      AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = AV30TFPaiHsPDiaDesde_Sels ;
      AV87Paisextraordinariaswwds_5_tfpaitarifapdia = AV31TFPaiTarifaPDia ;
      AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to = AV32TFPaiTarifaPDia_To ;
      AV89Paisextraordinariaswwds_7_tfpaitarifapdrec = AV33TFPaiTarifaPDRec ;
      AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to = AV34TFPaiTarifaPDRec_To ;
      AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = AV78TFPaiTarifaPDCri_Sels ;
      AV92Paisextraordinariaswwds_10_tfpaiextraordrelref = AV63TFPaiExtraordRelRef ;
      AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = AV64TFPaiExtraordRelRef_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV47PaiCod, AV67ManageFiltersExecutionStep, AV21ColumnsSelector, AV82Pgmname, AV53MenuOpcCod, AV12GridState, AV25TFPaiHsPDiaTipTra_Sels, AV27TFPaiHsPDiaDia_Sels, AV29TFPaiHsPDiaDesde, AV30TFPaiHsPDiaDesde_Sels, AV31TFPaiTarifaPDia, AV32TFPaiTarifaPDia_To, AV33TFPaiTarifaPDRec, AV34TFPaiTarifaPDRec_To, AV78TFPaiTarifaPDCri_Sels, AV63TFPaiExtraordRelRef, AV64TFPaiExtraordRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV55WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = AV25TFPaiHsPDiaTipTra_Sels ;
      AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels = AV27TFPaiHsPDiaDia_Sels ;
      AV85Paisextraordinariaswwds_3_tfpaihspdiadesde = AV29TFPaiHsPDiaDesde ;
      AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = AV30TFPaiHsPDiaDesde_Sels ;
      AV87Paisextraordinariaswwds_5_tfpaitarifapdia = AV31TFPaiTarifaPDia ;
      AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to = AV32TFPaiTarifaPDia_To ;
      AV89Paisextraordinariaswwds_7_tfpaitarifapdrec = AV33TFPaiTarifaPDRec ;
      AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to = AV34TFPaiTarifaPDRec_To ;
      AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = AV78TFPaiTarifaPDCri_Sels ;
      AV92Paisextraordinariaswwds_10_tfpaiextraordrelref = AV63TFPaiExtraordRelRef ;
      AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = AV64TFPaiExtraordRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV47PaiCod, AV67ManageFiltersExecutionStep, AV21ColumnsSelector, AV82Pgmname, AV53MenuOpcCod, AV12GridState, AV25TFPaiHsPDiaTipTra_Sels, AV27TFPaiHsPDiaDia_Sels, AV29TFPaiHsPDiaDesde, AV30TFPaiHsPDiaDesde_Sels, AV31TFPaiTarifaPDia, AV32TFPaiTarifaPDia_To, AV33TFPaiTarifaPDRec, AV34TFPaiTarifaPDRec_To, AV78TFPaiTarifaPDCri_Sels, AV63TFPaiExtraordRelRef, AV64TFPaiExtraordRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV55WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = AV25TFPaiHsPDiaTipTra_Sels ;
      AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels = AV27TFPaiHsPDiaDia_Sels ;
      AV85Paisextraordinariaswwds_3_tfpaihspdiadesde = AV29TFPaiHsPDiaDesde ;
      AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = AV30TFPaiHsPDiaDesde_Sels ;
      AV87Paisextraordinariaswwds_5_tfpaitarifapdia = AV31TFPaiTarifaPDia ;
      AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to = AV32TFPaiTarifaPDia_To ;
      AV89Paisextraordinariaswwds_7_tfpaitarifapdrec = AV33TFPaiTarifaPDRec ;
      AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to = AV34TFPaiTarifaPDRec_To ;
      AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = AV78TFPaiTarifaPDCri_Sels ;
      AV92Paisextraordinariaswwds_10_tfpaiextraordrelref = AV63TFPaiExtraordRelRef ;
      AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = AV64TFPaiExtraordRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV47PaiCod, AV67ManageFiltersExecutionStep, AV21ColumnsSelector, AV82Pgmname, AV53MenuOpcCod, AV12GridState, AV25TFPaiHsPDiaTipTra_Sels, AV27TFPaiHsPDiaDia_Sels, AV29TFPaiHsPDiaDesde, AV30TFPaiHsPDiaDesde_Sels, AV31TFPaiTarifaPDia, AV32TFPaiTarifaPDia_To, AV33TFPaiTarifaPDRec, AV34TFPaiTarifaPDRec_To, AV78TFPaiTarifaPDCri_Sels, AV63TFPaiExtraordRelRef, AV64TFPaiExtraordRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV55WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = AV25TFPaiHsPDiaTipTra_Sels ;
      AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels = AV27TFPaiHsPDiaDia_Sels ;
      AV85Paisextraordinariaswwds_3_tfpaihspdiadesde = AV29TFPaiHsPDiaDesde ;
      AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = AV30TFPaiHsPDiaDesde_Sels ;
      AV87Paisextraordinariaswwds_5_tfpaitarifapdia = AV31TFPaiTarifaPDia ;
      AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to = AV32TFPaiTarifaPDia_To ;
      AV89Paisextraordinariaswwds_7_tfpaitarifapdrec = AV33TFPaiTarifaPDRec ;
      AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to = AV34TFPaiTarifaPDRec_To ;
      AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = AV78TFPaiTarifaPDCri_Sels ;
      AV92Paisextraordinariaswwds_10_tfpaiextraordrelref = AV63TFPaiExtraordRelRef ;
      AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = AV64TFPaiExtraordRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV47PaiCod, AV67ManageFiltersExecutionStep, AV21ColumnsSelector, AV82Pgmname, AV53MenuOpcCod, AV12GridState, AV25TFPaiHsPDiaTipTra_Sels, AV27TFPaiHsPDiaDia_Sels, AV29TFPaiHsPDiaDesde, AV30TFPaiHsPDiaDesde_Sels, AV31TFPaiTarifaPDia, AV32TFPaiTarifaPDia_To, AV33TFPaiTarifaPDRec, AV34TFPaiTarifaPDRec_To, AV78TFPaiTarifaPDCri_Sels, AV63TFPaiExtraordRelRef, AV64TFPaiExtraordRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV55WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = AV25TFPaiHsPDiaTipTra_Sels ;
      AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels = AV27TFPaiHsPDiaDia_Sels ;
      AV85Paisextraordinariaswwds_3_tfpaihspdiadesde = AV29TFPaiHsPDiaDesde ;
      AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = AV30TFPaiHsPDiaDesde_Sels ;
      AV87Paisextraordinariaswwds_5_tfpaitarifapdia = AV31TFPaiTarifaPDia ;
      AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to = AV32TFPaiTarifaPDia_To ;
      AV89Paisextraordinariaswwds_7_tfpaitarifapdrec = AV33TFPaiTarifaPDRec ;
      AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to = AV34TFPaiTarifaPDRec_To ;
      AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = AV78TFPaiTarifaPDCri_Sels ;
      AV92Paisextraordinariaswwds_10_tfpaiextraordrelref = AV63TFPaiExtraordRelRef ;
      AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = AV64TFPaiExtraordRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV47PaiCod, AV67ManageFiltersExecutionStep, AV21ColumnsSelector, AV82Pgmname, AV53MenuOpcCod, AV12GridState, AV25TFPaiHsPDiaTipTra_Sels, AV27TFPaiHsPDiaDia_Sels, AV29TFPaiHsPDiaDesde, AV30TFPaiHsPDiaDesde_Sels, AV31TFPaiTarifaPDia, AV32TFPaiTarifaPDia_To, AV33TFPaiTarifaPDRec, AV34TFPaiTarifaPDRec_To, AV78TFPaiTarifaPDCri_Sels, AV63TFPaiExtraordRelRef, AV64TFPaiExtraordRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV55WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV82Pgmname = "PaisExtraordinariasWW" ;
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

   public void strupJ90( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19J92 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV35DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV65ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV37GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV38GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV39GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         AV61WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV55WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55WelcomeMessage_NoMostrarMas", AV55WelcomeMessage_NoMostrarMas);
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
      e19J92 ();
      if (returnInSub) return;
   }

   public void e19J92( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV53MenuOpcCod, "", "") ;
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
      Form.setCaption( httpContext.getMessage( " Pais Extraordinarias", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV35DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV35DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char3[0] = AV56MenuBienveImgURL ;
      GXv_char4[0] = AV58MenuBienveTitulo ;
      GXv_char5[0] = AV59MenuBienveTexto ;
      GXv_boolean6[0] = AV60MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV53MenuOpcCod, GXv_char3, GXv_char4, GXv_char5, GXv_boolean6) ;
      paisextraordinariasww_impl.this.AV56MenuBienveImgURL = GXv_char3[0] ;
      paisextraordinariasww_impl.this.AV58MenuBienveTitulo = GXv_char4[0] ;
      paisextraordinariasww_impl.this.AV59MenuBienveTexto = GXv_char5[0] ;
      paisextraordinariasww_impl.this.AV60MenuBienveVisible = GXv_boolean6[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV60MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV60MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV58MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV59MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV61WelcomeMessage_Foto = AV56MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV61WelcomeMessage_Foto)==0) ? AV81Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV61WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV61WelcomeMessage_Foto), true);
         AV81Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV56MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV61WelcomeMessage_Foto)==0) ? AV81Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV61WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV61WelcomeMessage_Foto), true);
      }
      GXt_char7 = "" ;
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char5) ;
      paisextraordinariasww_impl.this.GXt_char8 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char8, GXv_char4) ;
      paisextraordinariasww_impl.this.GXt_char7 = GXv_char4[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char7 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV76observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV76observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV76observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV76observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXt_int9 = AV45CliCod ;
      GXv_int10[0] = GXt_int9 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int10) ;
      paisextraordinariasww_impl.this.GXt_int9 = GXv_int10[0] ;
      AV45CliCod = GXt_int9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45CliCod), "ZZZZZ9")));
      GXv_int11[0] = AV47PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV45CliCod, GXv_int11) ;
      paisextraordinariasww_impl.this.AV47PaiCod = GXv_int11[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47PaiCod), 4, 0));
   }

   public void e20J92( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext12[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext12) ;
      AV6WWPContext = GXv_SdtWWPContext12[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV67ManageFiltersExecutionStep == 1 )
      {
         AV67ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV67ManageFiltersExecutionStep", GXutil.str( AV67ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV67ManageFiltersExecutionStep == 2 )
      {
         AV67ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV67ManageFiltersExecutionStep", GXutil.str( AV67ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV23Session.getValue("PaisExtraordinariasWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("PaisExtraordinariasWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      cmbPaiHsPDiaTipTra.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiHsPDiaTipTra.getInternalname(), "Visible", GXutil.ltrimstr( cmbPaiHsPDiaTipTra.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbPaiHsPDiaDia.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiHsPDiaDia.getInternalname(), "Visible", GXutil.ltrimstr( cmbPaiHsPDiaDia.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtPaiHsPDiaDesde_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiHsPDiaDesde_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiHsPDiaDesde_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtPaiTarifaPDia_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiTarifaPDia_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiTarifaPDia_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtPaiTarifaPDRec_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiTarifaPDRec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiTarifaPDRec_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbPaiTarifaPDCri.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTarifaPDCri.getInternalname(), "Visible", GXutil.ltrimstr( cmbPaiTarifaPDCri.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtPaiExtraordRelRef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiExtraordRelRef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiExtraordRelRef_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV37GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37GridCurrentPage), 10, 0));
      AV38GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38GridPageCount), 10, 0));
      GXt_char8 = AV39GridAppliedFilters ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV82Pgmname, GXv_char5) ;
      paisextraordinariasww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV39GridAppliedFilters = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39GridAppliedFilters", AV39GridAppliedFilters);
      GXt_char8 = AV72MenuOpcTitulo ;
      GXv_char5[0] = GXt_char8 ;
      new web.gettxtcount(remoteHandle, context).execute( AV53MenuOpcCod, GXv_char5) ;
      paisextraordinariasww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV72MenuOpcTitulo = GXt_char8 ;
      if ( (GXutil.strcmp("", AV72MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV72MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int11[0] = (short)(AV74filterCount) ;
      GXv_char5[0] = AV75filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int11, GXv_char5) ;
      paisextraordinariasww_impl.this.AV74filterCount = GXv_int11[0] ;
      paisextraordinariasww_impl.this.AV75filtrosTexto = GXv_char5[0] ;
      if ( AV74filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV74filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV75filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = AV25TFPaiHsPDiaTipTra_Sels ;
      AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels = AV27TFPaiHsPDiaDia_Sels ;
      AV85Paisextraordinariaswwds_3_tfpaihspdiadesde = AV29TFPaiHsPDiaDesde ;
      AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = AV30TFPaiHsPDiaDesde_Sels ;
      AV87Paisextraordinariaswwds_5_tfpaitarifapdia = AV31TFPaiTarifaPDia ;
      AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to = AV32TFPaiTarifaPDia_To ;
      AV89Paisextraordinariaswwds_7_tfpaitarifapdrec = AV33TFPaiTarifaPDRec ;
      AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to = AV34TFPaiTarifaPDRec_To ;
      AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = AV78TFPaiTarifaPDCri_Sels ;
      AV92Paisextraordinariaswwds_10_tfpaiextraordrelref = AV63TFPaiExtraordRelRef ;
      AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = AV64TFPaiExtraordRelRef_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV65ManageFiltersData", AV65ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64TFPaiExtraordRelRef_Sels", AV64TFPaiExtraordRelRef_Sels);
   }

   public void e13J92( )
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

   public void e14J92( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15J92( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiHsPDiaTipTra") == 0 )
         {
            AV24TFPaiHsPDiaTipTra_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFPaiHsPDiaTipTra_SelsJson", AV24TFPaiHsPDiaTipTra_SelsJson);
            AV25TFPaiHsPDiaTipTra_Sels.fromJSonString(AV24TFPaiHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiHsPDiaDia") == 0 )
         {
            AV26TFPaiHsPDiaDia_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFPaiHsPDiaDia_SelsJson", AV26TFPaiHsPDiaDia_SelsJson);
            AV27TFPaiHsPDiaDia_Sels.fromJSonString(GXutil.strReplace( AV26TFPaiHsPDiaDia_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiHsPDiaDesde") == 0 )
         {
            AV29TFPaiHsPDiaDesde = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFPaiHsPDiaDesde", AV29TFPaiHsPDiaDesde);
            AV28TFPaiHsPDiaDesde_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFPaiHsPDiaDesde_SelsJson", AV28TFPaiHsPDiaDesde_SelsJson);
            AV30TFPaiHsPDiaDesde_Sels.fromJSonString(AV28TFPaiHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiTarifaPDia") == 0 )
         {
            AV31TFPaiTarifaPDia = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFPaiTarifaPDia", GXutil.ltrimstr( AV31TFPaiTarifaPDia, 6, 4));
            AV32TFPaiTarifaPDia_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFPaiTarifaPDia_To", GXutil.ltrimstr( AV32TFPaiTarifaPDia_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiTarifaPDRec") == 0 )
         {
            AV33TFPaiTarifaPDRec = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFPaiTarifaPDRec", GXutil.ltrimstr( AV33TFPaiTarifaPDRec, 6, 4));
            AV34TFPaiTarifaPDRec_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFPaiTarifaPDRec_To", GXutil.ltrimstr( AV34TFPaiTarifaPDRec_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiTarifaPDCri") == 0 )
         {
            AV77TFPaiTarifaPDCri_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFPaiTarifaPDCri_SelsJson", AV77TFPaiTarifaPDCri_SelsJson);
            AV78TFPaiTarifaPDCri_Sels.fromJSonString(AV77TFPaiTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiExtraordRelRef") == 0 )
         {
            AV63TFPaiExtraordRelRef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFPaiExtraordRelRef", AV63TFPaiExtraordRelRef);
            AV62TFPaiExtraordRelRef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFPaiExtraordRelRef_SelsJson", AV62TFPaiExtraordRelRef_SelsJson);
            AV64TFPaiExtraordRelRef_Sels.fromJSonString(AV62TFPaiExtraordRelRef_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64TFPaiExtraordRelRef_Sels", AV64TFPaiExtraordRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV78TFPaiTarifaPDCri_Sels", AV78TFPaiTarifaPDCri_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFPaiHsPDiaDesde_Sels", AV30TFPaiHsPDiaDesde_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27TFPaiHsPDiaDia_Sels", AV27TFPaiHsPDiaDia_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25TFPaiHsPDiaTipTra_Sels", AV25TFPaiHsPDiaTipTra_Sels);
   }

   private void e21J92( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV40Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV40Update);
      if ( AV41IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.paisextraordinarias", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1332PaiHsExSec,4,0))}, new String[] {"Mode","PaiCod","PaiHsExSec"})  ;
      }
      AV42Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV42Delete);
      if ( AV43IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.paisextraordinarias", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1332PaiHsExSec,4,0))}, new String[] {"Mode","PaiCod","PaiHsExSec"})  ;
      }
      AV52Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV52Display);
      edtavDisplay_Link = formatLink("web.paisextraordinariasview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1332PaiHsExSec,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PaiCod","PaiHsExSec","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char8 = AV49VerSVG ;
      GXv_char5[0] = GXt_char8 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char5) ;
      paisextraordinariasww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV49VerSVG = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV49VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char8 = AV50ModificarSVG ;
      GXv_char5[0] = GXt_char8 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char5) ;
      paisextraordinariasww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV50ModificarSVG = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV50ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char8 = AV51EliminarSVG ;
      GXv_char5[0] = GXt_char8 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char5) ;
      paisextraordinariasww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV51EliminarSVG = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV51EliminarSVG);
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

   public void e11J92( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "PaisExtraordinariasWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV65ManageFiltersData", AV65ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64TFPaiExtraordRelRef_Sels", AV64TFPaiExtraordRelRef_Sels);
   }

   public void e12J92( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("PaisExtraordinariasWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV82Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV67ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV67ManageFiltersExecutionStep", GXutil.str( AV67ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("PaisExtraordinariasWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV67ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV67ManageFiltersExecutionStep", GXutil.str( AV67ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char8 = AV66ManageFiltersXml ;
         GXv_char5[0] = GXt_char8 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "PaisExtraordinariasWWFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         paisextraordinariasww_impl.this.GXt_char8 = GXv_char5[0] ;
         AV66ManageFiltersXml = GXt_char8 ;
         if ( (GXutil.strcmp("", AV66ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV82Pgmname+"GridState", AV66ManageFiltersXml) ;
            AV12GridState.fromxml(AV66ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25TFPaiHsPDiaTipTra_Sels", AV25TFPaiHsPDiaTipTra_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27TFPaiHsPDiaDia_Sels", AV27TFPaiHsPDiaDia_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFPaiHsPDiaDesde_Sels", AV30TFPaiHsPDiaDesde_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV78TFPaiTarifaPDCri_Sels", AV78TFPaiTarifaPDCri_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64TFPaiExtraordRelRef_Sels", AV64TFPaiExtraordRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV65ManageFiltersData", AV65ManageFiltersData);
   }

   public void e16J92( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.paisextraordinarias", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","PaiCod","PaiHsExSec"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e17J92( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char5[0] = AV17ExcelFilename ;
      GXv_char4[0] = AV18ErrorMessage ;
      new web.paisextraordinariaswwexport(remoteHandle, context).execute( GXv_char5, GXv_char4) ;
      paisextraordinariasww_impl.this.AV17ExcelFilename = GXv_char5[0] ;
      paisextraordinariasww_impl.this.AV18ErrorMessage = GXv_char4[0] ;
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
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "PaiHsPDiaTipTra", "", "Tipo de trabajo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "PaiHsPDiaDia", "", "Día", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "PaiHsPDiaDesde", "", "Hora desde", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "PaiTarifaPDia", "", "Aumento de horas extras sobre hora normal", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "PaiTarifaPDRec", "", "Recargo a hora normal diurna", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "PaiTarifaPDCri", "", "Criterio", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
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
         GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "PaiExtraordRelRef", "", "Liberación", true, "") ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "", "", "", false, "") ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
         AV63TFPaiExtraordRelRef = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63TFPaiExtraordRelRef", AV63TFPaiExtraordRelRef);
         AV64TFPaiExtraordRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      }
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&VerSVG", "", "", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&ModificarSVG", "", "", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EliminarSVG", "", "", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXt_char8 = AV20UserCustomValue ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PaisExtraordinariasWWColumnsSelector", GXv_char5) ;
      paisextraordinariasww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV20UserCustomValue = GXt_char8 ;
      if ( ! ( (GXutil.strcmp("", AV20UserCustomValue)==0) ) )
      {
         AV22ColumnsSelectorAux.fromxml(AV20UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector13[0] = AV22ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, GXv_SdtWWPColumnsSelector14) ;
         AV22ColumnsSelectorAux = GXv_SdtWWPColumnsSelector13[0] ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV45CliCod, GXv_SdtWWPColumnsSelector14) ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean15 = AV41IsAuthorized_Update ;
      GXv_boolean6[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisExtraordinarias_Update", GXv_boolean6) ;
      paisextraordinariasww_impl.this.GXt_boolean15 = GXv_boolean6[0] ;
      AV41IsAuthorized_Update = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41IsAuthorized_Update", AV41IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV41IsAuthorized_Update));
      if ( ! ( AV41IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV43IsAuthorized_Delete ;
      GXv_boolean6[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisExtraordinarias_Delete", GXv_boolean6) ;
      paisextraordinariasww_impl.this.GXt_boolean15 = GXv_boolean6[0] ;
      AV43IsAuthorized_Delete = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43IsAuthorized_Delete", AV43IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV43IsAuthorized_Delete));
      if ( ! ( AV43IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV44TempBoolean ;
      GXv_boolean6[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisExtraordinarias_Insert", GXv_boolean6) ;
      paisextraordinariasww_impl.this.GXt_boolean15 = GXv_boolean6[0] ;
      AV44TempBoolean = GXt_boolean15 ;
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
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV65ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "PaisExtraordinariasWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV65ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV25TFPaiHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27TFPaiHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV29TFPaiHsPDiaDesde = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFPaiHsPDiaDesde", AV29TFPaiHsPDiaDesde);
      AV30TFPaiHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31TFPaiTarifaPDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFPaiTarifaPDia", GXutil.ltrimstr( AV31TFPaiTarifaPDia, 6, 4));
      AV32TFPaiTarifaPDia_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFPaiTarifaPDia_To", GXutil.ltrimstr( AV32TFPaiTarifaPDia_To, 6, 4));
      AV33TFPaiTarifaPDRec = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFPaiTarifaPDRec", GXutil.ltrimstr( AV33TFPaiTarifaPDRec, 6, 4));
      AV34TFPaiTarifaPDRec_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFPaiTarifaPDRec_To", GXutil.ltrimstr( AV34TFPaiTarifaPDRec_To, 6, 4));
      AV78TFPaiTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV63TFPaiExtraordRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63TFPaiExtraordRelRef", AV63TFPaiExtraordRelRef);
      AV64TFPaiExtraordRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV23Session.getValue(AV82Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV82Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV23Session.getValue(AV82Pgmname+"GridState"), null, null);
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
      AV94GXV1 = 1 ;
      while ( AV94GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV94GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIATIPTRA_SEL") == 0 )
         {
            AV24TFPaiHsPDiaTipTra_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFPaiHsPDiaTipTra_SelsJson", AV24TFPaiHsPDiaTipTra_SelsJson);
            AV25TFPaiHsPDiaTipTra_Sels.fromJSonString(AV24TFPaiHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIADIA_SEL") == 0 )
         {
            AV26TFPaiHsPDiaDia_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFPaiHsPDiaDia_SelsJson", AV26TFPaiHsPDiaDia_SelsJson);
            AV27TFPaiHsPDiaDia_Sels.fromJSonString(AV26TFPaiHsPDiaDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIADESDE") == 0 )
         {
            AV29TFPaiHsPDiaDesde = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFPaiHsPDiaDesde", AV29TFPaiHsPDiaDesde);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIADESDE_SEL") == 0 )
         {
            AV28TFPaiHsPDiaDesde_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFPaiHsPDiaDesde_SelsJson", AV28TFPaiHsPDiaDesde_SelsJson);
            AV30TFPaiHsPDiaDesde_Sels.fromJSonString(AV28TFPaiHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITARIFAPDIA") == 0 )
         {
            AV31TFPaiTarifaPDia = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFPaiTarifaPDia", GXutil.ltrimstr( AV31TFPaiTarifaPDia, 6, 4));
            AV32TFPaiTarifaPDia_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFPaiTarifaPDia_To", GXutil.ltrimstr( AV32TFPaiTarifaPDia_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITARIFAPDREC") == 0 )
         {
            AV33TFPaiTarifaPDRec = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFPaiTarifaPDRec", GXutil.ltrimstr( AV33TFPaiTarifaPDRec, 6, 4));
            AV34TFPaiTarifaPDRec_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFPaiTarifaPDRec_To", GXutil.ltrimstr( AV34TFPaiTarifaPDRec_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITARIFAPDCRI_SEL") == 0 )
         {
            AV77TFPaiTarifaPDCri_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFPaiTarifaPDCri_SelsJson", AV77TFPaiTarifaPDCri_SelsJson);
            AV78TFPaiTarifaPDCri_Sels.fromJSonString(AV77TFPaiTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIEXTRAORDRELREF") == 0 )
         {
            AV63TFPaiExtraordRelRef = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFPaiExtraordRelRef", AV63TFPaiExtraordRelRef);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIEXTRAORDRELREF_SEL") == 0 )
         {
            AV62TFPaiExtraordRelRef_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFPaiExtraordRelRef_SelsJson", AV62TFPaiExtraordRelRef_SelsJson);
            AV64TFPaiExtraordRelRef_Sels.fromJSonString(AV62TFPaiExtraordRelRef_SelsJson, null);
         }
         AV94GXV1 = (int)(AV94GXV1+1) ;
      }
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV25TFPaiHsPDiaTipTra_Sels.size()==0), AV24TFPaiHsPDiaTipTra_SelsJson, GXv_char5) ;
      paisextraordinariasww_impl.this.GXt_char8 = GXv_char5[0] ;
      GXt_char7 = "" ;
      GXv_char4[0] = GXt_char7 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV30TFPaiHsPDiaDesde_Sels.size()==0), AV28TFPaiHsPDiaDesde_SelsJson, GXv_char4) ;
      paisextraordinariasww_impl.this.GXt_char7 = GXv_char4[0] ;
      GXt_char18 = "" ;
      GXv_char3[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV78TFPaiTarifaPDCri_Sels.size()==0), AV77TFPaiTarifaPDCri_SelsJson, GXv_char3) ;
      paisextraordinariasww_impl.this.GXt_char18 = GXv_char3[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV64TFPaiExtraordRelRef_Sels.size()==0), AV62TFPaiExtraordRelRef_SelsJson, GXv_char20) ;
      paisextraordinariasww_impl.this.GXt_char19 = GXv_char20[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char8+"|"+((AV27TFPaiHsPDiaDia_Sels.size()==0) ? "" : AV26TFPaiHsPDiaDia_SelsJson)+"|"+GXt_char7+"|||"+GXt_char18+"|"+GXt_char19 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFPaiHsPDiaDesde)==0), AV29TFPaiHsPDiaDesde, GXv_char20) ;
      paisextraordinariasww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char18 = "" ;
      GXv_char5[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV63TFPaiExtraordRelRef)==0), AV63TFPaiExtraordRelRef, GXv_char5) ;
      paisextraordinariasww_impl.this.GXt_char18 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = "||"+GXt_char19+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFPaiTarifaPDia)==0) ? "" : GXutil.str( AV31TFPaiTarifaPDia, 6, 4))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFPaiTarifaPDRec)==0) ? "" : GXutil.str( AV33TFPaiTarifaPDRec, 6, 4))+"||"+GXt_char18 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFPaiTarifaPDia_To)==0) ? "" : GXutil.str( AV32TFPaiTarifaPDia_To, 6, 4))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFPaiTarifaPDRec_To)==0) ? "" : GXutil.str( AV34TFPaiTarifaPDRec_To, 6, 4))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV23Session.getValue(AV82Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFPAIHSPDIATIPTRA_SEL", httpContext.getMessage( "Tipo de trabajo", ""), !(AV25TFPaiHsPDiaTipTra_Sels.size()==0), (short)(0), AV25TFPaiHsPDiaTipTra_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFPAIHSPDIADIA_SEL", httpContext.getMessage( "Día", ""), !(AV27TFPaiHsPDiaDia_Sels.size()==0), (short)(0), AV27TFPaiHsPDiaDia_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFPAIHSPDIADESDE", httpContext.getMessage( "Hora desde", ""), !(GXutil.strcmp("", AV29TFPaiHsPDiaDesde)==0), (short)(0), AV29TFPaiHsPDiaDesde, "", !(AV30TFPaiHsPDiaDesde_Sels.size()==0), AV30TFPaiHsPDiaDesde_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFPAITARIFAPDIA", httpContext.getMessage( "Aumento de horas extras sobre hora normal", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFPaiTarifaPDia)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFPaiTarifaPDia_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV31TFPaiTarifaPDia, 6, 4)), GXutil.trim( GXutil.str( AV32TFPaiTarifaPDia_To, 6, 4))) ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFPAITARIFAPDREC", httpContext.getMessage( "Recargo a hora normal diurna", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFPaiTarifaPDRec)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFPaiTarifaPDRec_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV33TFPaiTarifaPDRec, 6, 4)), GXutil.trim( GXutil.str( AV34TFPaiTarifaPDRec_To, 6, 4))) ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFPAITARIFAPDCRI_SEL", httpContext.getMessage( "Criterio", ""), !(AV78TFPaiTarifaPDCri_Sels.size()==0), (short)(0), AV78TFPaiTarifaPDCri_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFPAIEXTRAORDRELREF", httpContext.getMessage( "Liberación", ""), !(GXutil.strcmp("", AV63TFPaiExtraordRelRef)==0), (short)(0), AV63TFPaiExtraordRelRef, "", !(AV64TFPaiExtraordRelRef_Sels.size()==0), AV64TFPaiExtraordRelRef_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      if ( ! (GXutil.strcmp("", AV53MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV53MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV82Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV82Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "PaisExtraordinarias" );
      AV23Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e18J92( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV55WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean6[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV53MenuOpcCod, GXv_boolean6) ;
         GXv_char20[0] = AV57textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV45CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char20) ;
         paisextraordinariasww_impl.this.AV57textoNoMostrara = GXv_char20[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV57textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean6[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV53MenuOpcCod, GXv_boolean6) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_J92( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_J92( true) ;
      }
      else
      {
         wb_table2_12_J92( false) ;
      }
      return  ;
   }

   public void wb_table2_12_J92e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_J92e( true) ;
      }
      else
      {
         wb_table1_9_J92e( false) ;
      }
   }

   public void wb_table2_12_J92( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e22j91_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_PaisExtraordinariasWW.htm");
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
         AV61WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV61WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV81Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV61WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV61WelcomeMessage_Foto)==0) ? AV81Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV61WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV61WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_PaisExtraordinariasWW.htm");
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
         wb_table3_30_J92( true) ;
      }
      else
      {
         wb_table3_30_J92( false) ;
      }
      return  ;
   }

   public void wb_table3_30_J92e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_J92( true) ;
      }
      else
      {
         wb_table4_35_J92( false) ;
      }
      return  ;
   }

   public void wb_table4_35_J92e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV55WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_PaisExtraordinariasWW.htm");
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
         wb_table5_54_J92( true) ;
      }
      else
      {
         wb_table5_54_J92( false) ;
      }
      return  ;
   }

   public void wb_table5_54_J92e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_J92( true) ;
      }
      else
      {
         wb_table6_63_J92( false) ;
      }
      return  ;
   }

   public void wb_table6_63_J92e( boolean wbgen )
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
         wb_table2_12_J92e( true) ;
      }
      else
      {
         wb_table2_12_J92e( false) ;
      }
   }

   public void wb_table6_63_J92( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_PaisExtraordinariasWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_PaisExtraordinariasWW.htm");
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV65ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisExtraordinariasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisExtraordinariasWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_PaisExtraordinariasWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_PaisExtraordinariasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_J92( true) ;
      }
      else
      {
         wb_table7_99_J92( false) ;
      }
      return  ;
   }

   public void wb_table7_99_J92e( boolean wbgen )
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
         wb_table6_63_J92e( true) ;
      }
      else
      {
         wb_table6_63_J92e( false) ;
      }
   }

   public void wb_table7_99_J92( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_PaisExtraordinariasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_J92e( true) ;
      }
      else
      {
         wb_table7_99_J92e( false) ;
      }
   }

   public void wb_table5_54_J92( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_PaisExtraordinariasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_PaisExtraordinariasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_J92e( true) ;
      }
      else
      {
         wb_table5_54_J92e( false) ;
      }
   }

   public void wb_table4_35_J92( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_PaisExtraordinariasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_J92e( true) ;
      }
      else
      {
         wb_table4_35_J92e( false) ;
      }
   }

   public void wb_table3_30_J92( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_PaisExtraordinariasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_J92e( true) ;
      }
      else
      {
         wb_table3_30_J92e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV53MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53MenuOpcCod", AV53MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV53MenuOpcCod, ""))));
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
      paJ92( ) ;
      wsJ92( ) ;
      weJ92( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251818314499", true, true);
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
      httpContext.AddJavascriptSource("paisextraordinariasww.js", "?20251818314499", false, true);
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
      edtPaiCod_Internalname = "PAICOD_"+sGXsfl_110_idx ;
      edtPaiHsExSec_Internalname = "PAIHSEXSEC_"+sGXsfl_110_idx ;
      cmbPaiHsPDiaTipTra.setInternalname( "PAIHSPDIATIPTRA_"+sGXsfl_110_idx );
      cmbPaiHsPDiaDia.setInternalname( "PAIHSPDIADIA_"+sGXsfl_110_idx );
      edtPaiHsPDiaDesde_Internalname = "PAIHSPDIADESDE_"+sGXsfl_110_idx ;
      edtPaiTarifaPDia_Internalname = "PAITARIFAPDIA_"+sGXsfl_110_idx ;
      edtPaiTarifaPDRec_Internalname = "PAITARIFAPDREC_"+sGXsfl_110_idx ;
      cmbPaiTarifaPDCri.setInternalname( "PAITARIFAPDCRI_"+sGXsfl_110_idx );
      edtPaiExtraordRelRef_Internalname = "PAIEXTRAORDRELREF_"+sGXsfl_110_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_110_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_110_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_110_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_110_idx ;
   }

   public void subsflControlProps_fel_1102( )
   {
      edtPaiCod_Internalname = "PAICOD_"+sGXsfl_110_fel_idx ;
      edtPaiHsExSec_Internalname = "PAIHSEXSEC_"+sGXsfl_110_fel_idx ;
      cmbPaiHsPDiaTipTra.setInternalname( "PAIHSPDIATIPTRA_"+sGXsfl_110_fel_idx );
      cmbPaiHsPDiaDia.setInternalname( "PAIHSPDIADIA_"+sGXsfl_110_fel_idx );
      edtPaiHsPDiaDesde_Internalname = "PAIHSPDIADESDE_"+sGXsfl_110_fel_idx ;
      edtPaiTarifaPDia_Internalname = "PAITARIFAPDIA_"+sGXsfl_110_fel_idx ;
      edtPaiTarifaPDRec_Internalname = "PAITARIFAPDREC_"+sGXsfl_110_fel_idx ;
      cmbPaiTarifaPDCri.setInternalname( "PAITARIFAPDCRI_"+sGXsfl_110_fel_idx );
      edtPaiExtraordRelRef_Internalname = "PAIEXTRAORDRELREF_"+sGXsfl_110_fel_idx ;
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
      wbJ90( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiCod_Internalname,GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiHsExSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1332PaiHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1332PaiHsExSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiHsExSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbPaiHsPDiaTipTra.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPaiHsPDiaTipTra.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAIHSPDIATIPTRA_" + sGXsfl_110_idx ;
            cmbPaiHsPDiaTipTra.setName( GXCCtl );
            cmbPaiHsPDiaTipTra.setWebtags( "" );
            cmbPaiHsPDiaTipTra.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
            cmbPaiHsPDiaTipTra.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
            cmbPaiHsPDiaTipTra.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
            if ( cmbPaiHsPDiaTipTra.getItemCount() > 0 )
            {
               A1331PaiHsPDiaTipTra = cmbPaiHsPDiaTipTra.getValidValue(A1331PaiHsPDiaTipTra) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPaiHsPDiaTipTra,cmbPaiHsPDiaTipTra.getInternalname(),GXutil.rtrim( A1331PaiHsPDiaTipTra),Integer.valueOf(1),cmbPaiHsPDiaTipTra.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbPaiHsPDiaTipTra.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbPaiHsPDiaTipTra.setValue( GXutil.rtrim( A1331PaiHsPDiaTipTra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiHsPDiaTipTra.getInternalname(), "Values", cmbPaiHsPDiaTipTra.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbPaiHsPDiaDia.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPaiHsPDiaDia.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAIHSPDIADIA_" + sGXsfl_110_idx ;
            cmbPaiHsPDiaDia.setName( GXCCtl );
            cmbPaiHsPDiaDia.setWebtags( "" );
            cmbPaiHsPDiaDia.addItem("1", httpContext.getMessage( "Domingo", ""), (short)(0));
            cmbPaiHsPDiaDia.addItem("2", httpContext.getMessage( "Lunes", ""), (short)(0));
            cmbPaiHsPDiaDia.addItem("3", httpContext.getMessage( "Martes", ""), (short)(0));
            cmbPaiHsPDiaDia.addItem("4", httpContext.getMessage( "Miércoles", ""), (short)(0));
            cmbPaiHsPDiaDia.addItem("5", httpContext.getMessage( "Jueves", ""), (short)(0));
            cmbPaiHsPDiaDia.addItem("6", httpContext.getMessage( "Viernes", ""), (short)(0));
            cmbPaiHsPDiaDia.addItem("7", httpContext.getMessage( "Sábado", ""), (short)(0));
            cmbPaiHsPDiaDia.addItem("8", httpContext.getMessage( "Feriado", ""), (short)(0));
            cmbPaiHsPDiaDia.addItem("9", httpContext.getMessage( "Día hábil no especificado", ""), (short)(0));
            if ( cmbPaiHsPDiaDia.getItemCount() > 0 )
            {
               A1333PaiHsPDiaDia = (byte)(GXutil.lval( cmbPaiHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPaiHsPDiaDia,cmbPaiHsPDiaDia.getInternalname(),GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0)),Integer.valueOf(1),cmbPaiHsPDiaDia.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbPaiHsPDiaDia.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbPaiHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiHsPDiaDia.getInternalname(), "Values", cmbPaiHsPDiaDia.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPaiHsPDiaDesde_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiHsPDiaDesde_Internalname,GXutil.rtrim( A1334PaiHsPDiaDesde),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiHsPDiaDesde_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiHsPDiaDesde_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPaiTarifaPDia_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiTarifaPDia_Internalname,GXutil.ltrim( localUtil.ntoc( A1335PaiTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1335PaiTarifaPDia, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiTarifaPDia_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiTarifaPDia_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPaiTarifaPDRec_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiTarifaPDRec_Internalname,GXutil.ltrim( localUtil.ntoc( A1348PaiTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1348PaiTarifaPDRec, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiTarifaPDRec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPaiTarifaPDRec_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbPaiTarifaPDCri.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPaiTarifaPDCri.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAITARIFAPDCRI_" + sGXsfl_110_idx ;
            cmbPaiTarifaPDCri.setName( GXCCtl );
            cmbPaiTarifaPDCri.setWebtags( "" );
            cmbPaiTarifaPDCri.addItem("exceso", httpContext.getMessage( "Por exceder las horas normales", ""), (short)(0));
            cmbPaiTarifaPDCri.addItem("horario", httpContext.getMessage( "Por fecha y horario determinado", ""), (short)(0));
            if ( cmbPaiTarifaPDCri.getItemCount() > 0 )
            {
               A2434PaiTarifaPDCri = cmbPaiTarifaPDCri.getValidValue(A2434PaiTarifaPDCri) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPaiTarifaPDCri,cmbPaiTarifaPDCri.getInternalname(),GXutil.rtrim( A2434PaiTarifaPDCri),Integer.valueOf(1),cmbPaiTarifaPDCri.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbPaiTarifaPDCri.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbPaiTarifaPDCri.setValue( GXutil.rtrim( A2434PaiTarifaPDCri) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTarifaPDCri.getInternalname(), "Values", cmbPaiTarifaPDCri.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPaiExtraordRelRef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaiExtraordRelRef_Internalname,A2058PaiExtraordRelRef,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaiExtraordRelRef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPaiExtraordRelRef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV52Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV49VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV50ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV51EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesJ92( ) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPaiHsPDiaTipTra.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de trabajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPaiHsPDiaDia.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Día", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiHsPDiaDesde_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Hora desde", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiTarifaPDia_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Aumento de horas extras sobre hora normal", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiTarifaPDRec_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Recargo a hora normal diurna", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPaiTarifaPDCri.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Criterio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaiExtraordRelRef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1332PaiHsExSec, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1331PaiHsPDiaTipTra));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPaiHsPDiaTipTra.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1333PaiHsPDiaDia, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPaiHsPDiaDia.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1334PaiHsPDiaDesde));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiHsPDiaDesde_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1335PaiTarifaPDia, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiTarifaPDia_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1348PaiTarifaPDRec, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiTarifaPDRec_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2434PaiTarifaPDCri));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPaiTarifaPDCri.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2058PaiExtraordRelRef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaiExtraordRelRef_Visible, (byte)(5), (byte)(0), ".", "")));
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV52Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV49VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV50ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV51EliminarSVG));
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
      edtPaiCod_Internalname = "PAICOD" ;
      edtPaiHsExSec_Internalname = "PAIHSEXSEC" ;
      cmbPaiHsPDiaTipTra.setInternalname( "PAIHSPDIATIPTRA" );
      cmbPaiHsPDiaDia.setInternalname( "PAIHSPDIADIA" );
      edtPaiHsPDiaDesde_Internalname = "PAIHSPDIADESDE" ;
      edtPaiTarifaPDia_Internalname = "PAITARIFAPDIA" ;
      edtPaiTarifaPDRec_Internalname = "PAITARIFAPDREC" ;
      cmbPaiTarifaPDCri.setInternalname( "PAITARIFAPDCRI" );
      edtPaiExtraordRelRef_Internalname = "PAIEXTRAORDRELREF" ;
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
      edtPaiExtraordRelRef_Jsonclick = "" ;
      cmbPaiTarifaPDCri.setJsonclick( "" );
      edtPaiTarifaPDRec_Jsonclick = "" ;
      edtPaiTarifaPDia_Jsonclick = "" ;
      edtPaiHsPDiaDesde_Jsonclick = "" ;
      cmbPaiHsPDiaDia.setJsonclick( "" );
      cmbPaiHsPDiaTipTra.setJsonclick( "" );
      edtPaiHsExSec_Jsonclick = "" ;
      edtPaiCod_Jsonclick = "" ;
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
      edtPaiExtraordRelRef_Visible = -1 ;
      cmbPaiTarifaPDCri.setVisible( -1 );
      edtPaiTarifaPDRec_Visible = -1 ;
      edtPaiTarifaPDia_Visible = -1 ;
      edtPaiHsPDiaDesde_Visible = -1 ;
      cmbPaiHsPDiaDia.setVisible( -1 );
      cmbPaiHsPDiaTipTra.setVisible( -1 );
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "|||6.4|6.4||" ;
      Ddo_grid_Datalistproc = "PaisExtraordinariasWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "diurno:Diurno,nocturno:Nocturno,insalubre:Insalubre|1:Domingo,2:Lunes,3:Martes,4:Miércoles,5:Jueves,6:Viernes,7:Sábado,8:Feriado,9:Día hábil no especificado||||exceso:Por exceder las horas normales,horario:Por fecha y horario determinado|" ;
      Ddo_grid_Allowmultipleselection = "T|T|T|||T|T" ;
      Ddo_grid_Datalisttype = "FixedValues|FixedValues|Dynamic|||FixedValues|Dynamic" ;
      Ddo_grid_Includedatalist = "T|T|T|||T|T" ;
      Ddo_grid_Filterisrange = "|||T|T||" ;
      Ddo_grid_Filtertype = "||Character|Numeric|Numeric||Character" ;
      Ddo_grid_Includefilter = "||T|T|T||T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7" ;
      Ddo_grid_Columnids = "2:PaiHsPDiaTipTra|3:PaiHsPDiaDia|4:PaiHsPDiaDesde|5:PaiTarifaPDia|6:PaiTarifaPDRec|7:PaiTarifaPDCri|8:PaiExtraordRelRef" ;
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
      Form.setCaption( httpContext.getMessage( " Pais Extraordinarias", "") );
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
      AV55WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV55WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55WelcomeMessage_NoMostrarMas", AV55WelcomeMessage_NoMostrarMas);
      GXCCtl = "PAIHSPDIATIPTRA_" + sGXsfl_110_idx ;
      cmbPaiHsPDiaTipTra.setName( GXCCtl );
      cmbPaiHsPDiaTipTra.setWebtags( "" );
      cmbPaiHsPDiaTipTra.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
      cmbPaiHsPDiaTipTra.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
      cmbPaiHsPDiaTipTra.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
      if ( cmbPaiHsPDiaTipTra.getItemCount() > 0 )
      {
         A1331PaiHsPDiaTipTra = cmbPaiHsPDiaTipTra.getValidValue(A1331PaiHsPDiaTipTra) ;
      }
      GXCCtl = "PAIHSPDIADIA_" + sGXsfl_110_idx ;
      cmbPaiHsPDiaDia.setName( GXCCtl );
      cmbPaiHsPDiaDia.setWebtags( "" );
      cmbPaiHsPDiaDia.addItem("1", httpContext.getMessage( "Domingo", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("2", httpContext.getMessage( "Lunes", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("3", httpContext.getMessage( "Martes", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("4", httpContext.getMessage( "Miércoles", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("5", httpContext.getMessage( "Jueves", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("6", httpContext.getMessage( "Viernes", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("7", httpContext.getMessage( "Sábado", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("8", httpContext.getMessage( "Feriado", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("9", httpContext.getMessage( "Día hábil no especificado", ""), (short)(0));
      if ( cmbPaiHsPDiaDia.getItemCount() > 0 )
      {
         A1333PaiHsPDiaDia = (byte)(GXutil.lval( cmbPaiHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0))))) ;
      }
      GXCCtl = "PAITARIFAPDCRI_" + sGXsfl_110_idx ;
      cmbPaiTarifaPDCri.setName( GXCCtl );
      cmbPaiTarifaPDCri.setWebtags( "" );
      cmbPaiTarifaPDCri.addItem("exceso", httpContext.getMessage( "Por exceder las horas normales", ""), (short)(0));
      cmbPaiTarifaPDCri.addItem("horario", httpContext.getMessage( "Por fecha y horario determinado", ""), (short)(0));
      if ( cmbPaiTarifaPDCri.getItemCount() > 0 )
      {
         A2434PaiTarifaPDCri = cmbPaiTarifaPDCri.getValidValue(A2434PaiTarifaPDCri) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV67ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV82Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV53MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFPaiHsPDiaTipTra_Sels',fld:'vTFPAIHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFPaiHsPDiaDia_Sels',fld:'vTFPAIHSPDIADIA_SELS',pic:''},{av:'AV29TFPaiHsPDiaDesde',fld:'vTFPAIHSPDIADESDE',pic:''},{av:'AV30TFPaiHsPDiaDesde_Sels',fld:'vTFPAIHSPDIADESDE_SELS',pic:''},{av:'AV31TFPaiTarifaPDia',fld:'vTFPAITARIFAPDIA',pic:'9.9999'},{av:'AV32TFPaiTarifaPDia_To',fld:'vTFPAITARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFPaiTarifaPDRec',fld:'vTFPAITARIFAPDREC',pic:'9.9999'},{av:'AV34TFPaiTarifaPDRec_To',fld:'vTFPAITARIFAPDREC_TO',pic:'9.9999'},{av:'AV78TFPaiTarifaPDCri_Sels',fld:'vTFPAITARIFAPDCRI_SELS',pic:''},{av:'AV63TFPaiExtraordRelRef',fld:'vTFPAIEXTRAORDRELREF',pic:''},{av:'AV64TFPaiExtraordRelRef_Sels',fld:'vTFPAIEXTRAORDRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV67ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'cmbPaiHsPDiaTipTra'},{av:'cmbPaiHsPDiaDia'},{av:'edtPaiHsPDiaDesde_Visible',ctrl:'PAIHSPDIADESDE',prop:'Visible'},{av:'edtPaiTarifaPDia_Visible',ctrl:'PAITARIFAPDIA',prop:'Visible'},{av:'edtPaiTarifaPDRec_Visible',ctrl:'PAITARIFAPDREC',prop:'Visible'},{av:'cmbPaiTarifaPDCri'},{av:'edtPaiExtraordRelRef_Visible',ctrl:'PAIEXTRAORDRELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV37GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV38GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV39GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV65ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV63TFPaiExtraordRelRef',fld:'vTFPAIEXTRAORDRELREF',pic:''},{av:'AV64TFPaiExtraordRelRef_Sels',fld:'vTFPAIEXTRAORDRELREF_SELS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13J92',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV67ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV82Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV53MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFPaiHsPDiaTipTra_Sels',fld:'vTFPAIHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFPaiHsPDiaDia_Sels',fld:'vTFPAIHSPDIADIA_SELS',pic:''},{av:'AV29TFPaiHsPDiaDesde',fld:'vTFPAIHSPDIADESDE',pic:''},{av:'AV30TFPaiHsPDiaDesde_Sels',fld:'vTFPAIHSPDIADESDE_SELS',pic:''},{av:'AV31TFPaiTarifaPDia',fld:'vTFPAITARIFAPDIA',pic:'9.9999'},{av:'AV32TFPaiTarifaPDia_To',fld:'vTFPAITARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFPaiTarifaPDRec',fld:'vTFPAITARIFAPDREC',pic:'9.9999'},{av:'AV34TFPaiTarifaPDRec_To',fld:'vTFPAITARIFAPDREC_TO',pic:'9.9999'},{av:'AV78TFPaiTarifaPDCri_Sels',fld:'vTFPAITARIFAPDCRI_SELS',pic:''},{av:'AV63TFPaiExtraordRelRef',fld:'vTFPAIEXTRAORDRELREF',pic:''},{av:'AV64TFPaiExtraordRelRef_Sels',fld:'vTFPAIEXTRAORDRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14J92',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV67ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV82Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV53MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFPaiHsPDiaTipTra_Sels',fld:'vTFPAIHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFPaiHsPDiaDia_Sels',fld:'vTFPAIHSPDIADIA_SELS',pic:''},{av:'AV29TFPaiHsPDiaDesde',fld:'vTFPAIHSPDIADESDE',pic:''},{av:'AV30TFPaiHsPDiaDesde_Sels',fld:'vTFPAIHSPDIADESDE_SELS',pic:''},{av:'AV31TFPaiTarifaPDia',fld:'vTFPAITARIFAPDIA',pic:'9.9999'},{av:'AV32TFPaiTarifaPDia_To',fld:'vTFPAITARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFPaiTarifaPDRec',fld:'vTFPAITARIFAPDREC',pic:'9.9999'},{av:'AV34TFPaiTarifaPDRec_To',fld:'vTFPAITARIFAPDREC_TO',pic:'9.9999'},{av:'AV78TFPaiTarifaPDCri_Sels',fld:'vTFPAITARIFAPDCRI_SELS',pic:''},{av:'AV63TFPaiExtraordRelRef',fld:'vTFPAIEXTRAORDRELREF',pic:''},{av:'AV64TFPaiExtraordRelRef_Sels',fld:'vTFPAIEXTRAORDRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15J92',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV67ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV82Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV53MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFPaiHsPDiaTipTra_Sels',fld:'vTFPAIHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFPaiHsPDiaDia_Sels',fld:'vTFPAIHSPDIADIA_SELS',pic:''},{av:'AV29TFPaiHsPDiaDesde',fld:'vTFPAIHSPDIADESDE',pic:''},{av:'AV30TFPaiHsPDiaDesde_Sels',fld:'vTFPAIHSPDIADESDE_SELS',pic:''},{av:'AV31TFPaiTarifaPDia',fld:'vTFPAITARIFAPDIA',pic:'9.9999'},{av:'AV32TFPaiTarifaPDia_To',fld:'vTFPAITARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFPaiTarifaPDRec',fld:'vTFPAITARIFAPDREC',pic:'9.9999'},{av:'AV34TFPaiTarifaPDRec_To',fld:'vTFPAITARIFAPDREC_TO',pic:'9.9999'},{av:'AV78TFPaiTarifaPDCri_Sels',fld:'vTFPAITARIFAPDCRI_SELS',pic:''},{av:'AV63TFPaiExtraordRelRef',fld:'vTFPAIEXTRAORDRELREF',pic:''},{av:'AV64TFPaiExtraordRelRef_Sels',fld:'vTFPAIEXTRAORDRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV63TFPaiExtraordRelRef',fld:'vTFPAIEXTRAORDRELREF',pic:''},{av:'AV62TFPaiExtraordRelRef_SelsJson',fld:'vTFPAIEXTRAORDRELREF_SELSJSON',pic:''},{av:'AV64TFPaiExtraordRelRef_Sels',fld:'vTFPAIEXTRAORDRELREF_SELS',pic:''},{av:'AV77TFPaiTarifaPDCri_SelsJson',fld:'vTFPAITARIFAPDCRI_SELSJSON',pic:''},{av:'AV78TFPaiTarifaPDCri_Sels',fld:'vTFPAITARIFAPDCRI_SELS',pic:''},{av:'AV33TFPaiTarifaPDRec',fld:'vTFPAITARIFAPDREC',pic:'9.9999'},{av:'AV34TFPaiTarifaPDRec_To',fld:'vTFPAITARIFAPDREC_TO',pic:'9.9999'},{av:'AV31TFPaiTarifaPDia',fld:'vTFPAITARIFAPDIA',pic:'9.9999'},{av:'AV32TFPaiTarifaPDia_To',fld:'vTFPAITARIFAPDIA_TO',pic:'9.9999'},{av:'AV29TFPaiHsPDiaDesde',fld:'vTFPAIHSPDIADESDE',pic:''},{av:'AV28TFPaiHsPDiaDesde_SelsJson',fld:'vTFPAIHSPDIADESDE_SELSJSON',pic:''},{av:'AV30TFPaiHsPDiaDesde_Sels',fld:'vTFPAIHSPDIADESDE_SELS',pic:''},{av:'AV26TFPaiHsPDiaDia_SelsJson',fld:'vTFPAIHSPDIADIA_SELSJSON',pic:''},{av:'AV27TFPaiHsPDiaDia_Sels',fld:'vTFPAIHSPDIADIA_SELS',pic:''},{av:'AV24TFPaiHsPDiaTipTra_SelsJson',fld:'vTFPAIHSPDIATIPTRA_SELSJSON',pic:''},{av:'AV25TFPaiHsPDiaTipTra_Sels',fld:'vTFPAIHSPDIATIPTRA_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21J92',iparms:[{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9',hsh:true},{av:'A1332PaiHsExSec',fld:'PAIHSEXSEC',pic:'ZZZ9',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV40Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV42Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV52Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV49VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV50ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV51EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11J92',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV67ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV82Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV53MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFPaiHsPDiaTipTra_Sels',fld:'vTFPAIHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFPaiHsPDiaDia_Sels',fld:'vTFPAIHSPDIADIA_SELS',pic:''},{av:'AV29TFPaiHsPDiaDesde',fld:'vTFPAIHSPDIADESDE',pic:''},{av:'AV30TFPaiHsPDiaDesde_Sels',fld:'vTFPAIHSPDIADESDE_SELS',pic:''},{av:'AV31TFPaiTarifaPDia',fld:'vTFPAITARIFAPDIA',pic:'9.9999'},{av:'AV32TFPaiTarifaPDia_To',fld:'vTFPAITARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFPaiTarifaPDRec',fld:'vTFPAITARIFAPDREC',pic:'9.9999'},{av:'AV34TFPaiTarifaPDRec_To',fld:'vTFPAITARIFAPDREC_TO',pic:'9.9999'},{av:'AV78TFPaiTarifaPDCri_Sels',fld:'vTFPAITARIFAPDCRI_SELS',pic:''},{av:'AV63TFPaiExtraordRelRef',fld:'vTFPAIEXTRAORDRELREF',pic:''},{av:'AV64TFPaiExtraordRelRef_Sels',fld:'vTFPAIEXTRAORDRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV67ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'cmbPaiHsPDiaTipTra'},{av:'cmbPaiHsPDiaDia'},{av:'edtPaiHsPDiaDesde_Visible',ctrl:'PAIHSPDIADESDE',prop:'Visible'},{av:'edtPaiTarifaPDia_Visible',ctrl:'PAITARIFAPDIA',prop:'Visible'},{av:'edtPaiTarifaPDRec_Visible',ctrl:'PAITARIFAPDREC',prop:'Visible'},{av:'cmbPaiTarifaPDCri'},{av:'edtPaiExtraordRelRef_Visible',ctrl:'PAIEXTRAORDRELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV37GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV38GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV39GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV65ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV63TFPaiExtraordRelRef',fld:'vTFPAIEXTRAORDRELREF',pic:''},{av:'AV64TFPaiExtraordRelRef_Sels',fld:'vTFPAIEXTRAORDRELREF_SELS',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12J92',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV67ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV82Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV53MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFPaiHsPDiaTipTra_Sels',fld:'vTFPAIHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFPaiHsPDiaDia_Sels',fld:'vTFPAIHSPDIADIA_SELS',pic:''},{av:'AV29TFPaiHsPDiaDesde',fld:'vTFPAIHSPDIADESDE',pic:''},{av:'AV30TFPaiHsPDiaDesde_Sels',fld:'vTFPAIHSPDIADESDE_SELS',pic:''},{av:'AV31TFPaiTarifaPDia',fld:'vTFPAITARIFAPDIA',pic:'9.9999'},{av:'AV32TFPaiTarifaPDia_To',fld:'vTFPAITARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFPaiTarifaPDRec',fld:'vTFPAITARIFAPDREC',pic:'9.9999'},{av:'AV34TFPaiTarifaPDRec_To',fld:'vTFPAITARIFAPDREC_TO',pic:'9.9999'},{av:'AV78TFPaiTarifaPDCri_Sels',fld:'vTFPAITARIFAPDCRI_SELS',pic:''},{av:'AV63TFPaiExtraordRelRef',fld:'vTFPAIEXTRAORDRELREF',pic:''},{av:'AV64TFPaiExtraordRelRef_Sels',fld:'vTFPAIEXTRAORDRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV55WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV24TFPaiHsPDiaTipTra_SelsJson',fld:'vTFPAIHSPDIATIPTRA_SELSJSON',pic:''},{av:'AV26TFPaiHsPDiaDia_SelsJson',fld:'vTFPAIHSPDIADIA_SELSJSON',pic:''},{av:'AV28TFPaiHsPDiaDesde_SelsJson',fld:'vTFPAIHSPDIADESDE_SELSJSON',pic:''},{av:'AV77TFPaiTarifaPDCri_SelsJson',fld:'vTFPAITARIFAPDCRI_SELSJSON',pic:''},{av:'AV62TFPaiExtraordRelRef_SelsJson',fld:'vTFPAIEXTRAORDRELREF_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV67ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV25TFPaiHsPDiaTipTra_Sels',fld:'vTFPAIHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFPaiHsPDiaDia_Sels',fld:'vTFPAIHSPDIADIA_SELS',pic:''},{av:'AV29TFPaiHsPDiaDesde',fld:'vTFPAIHSPDIADESDE',pic:''},{av:'AV30TFPaiHsPDiaDesde_Sels',fld:'vTFPAIHSPDIADESDE_SELS',pic:''},{av:'AV31TFPaiTarifaPDia',fld:'vTFPAITARIFAPDIA',pic:'9.9999'},{av:'AV32TFPaiTarifaPDia_To',fld:'vTFPAITARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFPaiTarifaPDRec',fld:'vTFPAITARIFAPDREC',pic:'9.9999'},{av:'AV34TFPaiTarifaPDRec_To',fld:'vTFPAITARIFAPDREC_TO',pic:'9.9999'},{av:'AV78TFPaiTarifaPDCri_Sels',fld:'vTFPAITARIFAPDCRI_SELS',pic:''},{av:'AV63TFPaiExtraordRelRef',fld:'vTFPAIEXTRAORDRELREF',pic:''},{av:'AV64TFPaiExtraordRelRef_Sels',fld:'vTFPAIEXTRAORDRELREF_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV62TFPaiExtraordRelRef_SelsJson',fld:'vTFPAIEXTRAORDRELREF_SELSJSON',pic:''},{av:'AV77TFPaiTarifaPDCri_SelsJson',fld:'vTFPAITARIFAPDCRI_SELSJSON',pic:''},{av:'AV28TFPaiHsPDiaDesde_SelsJson',fld:'vTFPAIHSPDIADESDE_SELSJSON',pic:''},{av:'AV26TFPaiHsPDiaDia_SelsJson',fld:'vTFPAIHSPDIADIA_SELSJSON',pic:''},{av:'AV24TFPaiHsPDiaTipTra_SelsJson',fld:'vTFPAIHSPDIATIPTRA_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'cmbPaiHsPDiaTipTra'},{av:'cmbPaiHsPDiaDia'},{av:'edtPaiHsPDiaDesde_Visible',ctrl:'PAIHSPDIADESDE',prop:'Visible'},{av:'edtPaiTarifaPDia_Visible',ctrl:'PAITARIFAPDIA',prop:'Visible'},{av:'edtPaiTarifaPDRec_Visible',ctrl:'PAITARIFAPDREC',prop:'Visible'},{av:'cmbPaiTarifaPDCri'},{av:'edtPaiExtraordRelRef_Visible',ctrl:'PAIEXTRAORDRELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV37GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV38GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV39GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV65ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e16J92',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9',hsh:true},{av:'A1332PaiHsExSec',fld:'PAIHSEXSEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17J92',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e18J92',iparms:[{av:'AV55WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV53MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e22J91',iparms:[]");
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
      wcpOAV53MenuOpcCod = "" ;
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
      AV53MenuOpcCod = "" ;
      AV21ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV82Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25TFPaiHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27TFPaiHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV29TFPaiHsPDiaDesde = "" ;
      AV30TFPaiHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFPaiTarifaPDia = DecimalUtil.ZERO ;
      AV32TFPaiTarifaPDia_To = DecimalUtil.ZERO ;
      AV33TFPaiTarifaPDRec = DecimalUtil.ZERO ;
      AV34TFPaiTarifaPDRec_To = DecimalUtil.ZERO ;
      AV78TFPaiTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63TFPaiExtraordRelRef = "" ;
      AV64TFPaiExtraordRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV35DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV65ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV39GridAppliedFilters = "" ;
      AV24TFPaiHsPDiaTipTra_SelsJson = "" ;
      AV26TFPaiHsPDiaDia_SelsJson = "" ;
      AV28TFPaiHsPDiaDesde_SelsJson = "" ;
      AV77TFPaiTarifaPDCri_SelsJson = "" ;
      AV62TFPaiExtraordRelRef_SelsJson = "" ;
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
      A1331PaiHsPDiaTipTra = "" ;
      A1334PaiHsPDiaDesde = "" ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      A2434PaiTarifaPDCri = "" ;
      A2058PaiExtraordRelRef = "" ;
      AV40Update = "" ;
      AV42Delete = "" ;
      AV52Display = "" ;
      AV49VerSVG = "" ;
      AV50ModificarSVG = "" ;
      AV51EliminarSVG = "" ;
      AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV85Paisextraordinariaswwds_3_tfpaihspdiadesde = "" ;
      lV92Paisextraordinariaswwds_10_tfpaiextraordrelref = "" ;
      AV85Paisextraordinariaswwds_3_tfpaihspdiadesde = "" ;
      AV87Paisextraordinariaswwds_5_tfpaitarifapdia = DecimalUtil.ZERO ;
      AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to = DecimalUtil.ZERO ;
      AV89Paisextraordinariaswwds_7_tfpaitarifapdrec = DecimalUtil.ZERO ;
      AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to = DecimalUtil.ZERO ;
      AV92Paisextraordinariaswwds_10_tfpaiextraordrelref = "" ;
      H00J92_A2058PaiExtraordRelRef = new String[] {""} ;
      H00J92_A2434PaiTarifaPDCri = new String[] {""} ;
      H00J92_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00J92_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00J92_A1334PaiHsPDiaDesde = new String[] {""} ;
      H00J92_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      H00J92_A1333PaiHsPDiaDia = new byte[1] ;
      H00J92_A1331PaiHsPDiaTipTra = new String[] {""} ;
      H00J92_A1332PaiHsExSec = new short[1] ;
      H00J92_A46PaiCod = new short[1] ;
      H00J93_AGRID_nRecordCount = new long[1] ;
      AV61WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV56MenuBienveImgURL = "" ;
      AV58MenuBienveTitulo = "" ;
      AV59MenuBienveTexto = "" ;
      AV81Welcomemessage_foto_GXI = "" ;
      AV76observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int10 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext12 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV19ColumnsSelectorXML = "" ;
      AV72MenuOpcTitulo = "" ;
      GXv_int11 = new short[1] ;
      AV75filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV66ManageFiltersXml = "" ;
      AV17ExcelFilename = "" ;
      AV18ErrorMessage = "" ;
      AV20UserCustomValue = "" ;
      AV22ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char8 = "" ;
      GXt_char7 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXt_char19 = "" ;
      GXt_char18 = "" ;
      GXv_char5 = new String[1] ;
      GXv_SdtWWPGridState21 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV57textoNoMostrara = "" ;
      GXv_char20 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisextraordinariasww__default(),
         new Object[] {
             new Object[] {
            H00J92_A2058PaiExtraordRelRef, H00J92_A2434PaiTarifaPDCri, H00J92_A1348PaiTarifaPDRec, H00J92_A1335PaiTarifaPDia, H00J92_A1334PaiHsPDiaDesde, H00J92_n1334PaiHsPDiaDesde, H00J92_A1333PaiHsPDiaDia, H00J92_A1331PaiHsPDiaTipTra, H00J92_A1332PaiHsExSec, H00J92_A46PaiCod
            }
            , new Object[] {
            H00J93_AGRID_nRecordCount
            }
         }
      );
      AV82Pgmname = "PaisExtraordinariasWW" ;
      /* GeneXus formulas. */
      AV82Pgmname = "PaisExtraordinariasWW" ;
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
   private byte AV67ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
   private byte A1333PaiHsPDiaDia ;
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
   private short AV14OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A46PaiCod ;
   private short A1332PaiHsExSec ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int11[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV45CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size ;
   private int AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size ;
   private int AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size ;
   private int AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size ;
   private int AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int9 ;
   private int GXv_int10[] ;
   private int edtPaiHsPDiaDesde_Visible ;
   private int edtPaiTarifaPDia_Visible ;
   private int edtPaiTarifaPDRec_Visible ;
   private int edtPaiExtraordRelRef_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV74filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV36PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtninsert_Visible ;
   private int AV94GXV1 ;
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
   private java.math.BigDecimal AV31TFPaiTarifaPDia ;
   private java.math.BigDecimal AV32TFPaiTarifaPDia_To ;
   private java.math.BigDecimal AV33TFPaiTarifaPDRec ;
   private java.math.BigDecimal AV34TFPaiTarifaPDRec_To ;
   private java.math.BigDecimal A1335PaiTarifaPDia ;
   private java.math.BigDecimal A1348PaiTarifaPDRec ;
   private java.math.BigDecimal AV87Paisextraordinariaswwds_5_tfpaitarifapdia ;
   private java.math.BigDecimal AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to ;
   private java.math.BigDecimal AV89Paisextraordinariaswwds_7_tfpaitarifapdrec ;
   private java.math.BigDecimal AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to ;
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
   private String AV82Pgmname ;
   private String AV29TFPaiHsPDiaDesde ;
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
   private String edtPaiHsExSec_Internalname ;
   private String A1331PaiHsPDiaTipTra ;
   private String A1334PaiHsPDiaDesde ;
   private String edtPaiHsPDiaDesde_Internalname ;
   private String edtPaiTarifaPDia_Internalname ;
   private String edtPaiTarifaPDRec_Internalname ;
   private String A2434PaiTarifaPDCri ;
   private String edtPaiExtraordRelRef_Internalname ;
   private String AV40Update ;
   private String edtavUpdate_Internalname ;
   private String AV42Delete ;
   private String edtavDelete_Internalname ;
   private String AV52Display ;
   private String edtavDisplay_Internalname ;
   private String AV49VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV50ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV51EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String lV85Paisextraordinariaswwds_3_tfpaihspdiadesde ;
   private String AV85Paisextraordinariaswwds_3_tfpaihspdiadesde ;
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
   private String AV76observerPalabra ;
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
   private String GXt_char8 ;
   private String GXt_char7 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXt_char19 ;
   private String GXt_char18 ;
   private String GXv_char5[] ;
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
   private String edtPaiCod_Jsonclick ;
   private String edtPaiHsExSec_Jsonclick ;
   private String GXCCtl ;
   private String edtPaiHsPDiaDesde_Jsonclick ;
   private String edtPaiTarifaPDia_Jsonclick ;
   private String edtPaiTarifaPDRec_Jsonclick ;
   private String edtPaiExtraordRelRef_Jsonclick ;
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
   private boolean AV55WelcomeMessage_NoMostrarMas ;
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
   private boolean n1334PaiHsPDiaDesde ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV60MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean Cond_result ;
   private boolean AV44TempBoolean ;
   private boolean GXt_boolean15 ;
   private boolean GXv_boolean6[] ;
   private boolean AV61WelcomeMessage_Foto_IsBlob ;
   private String AV24TFPaiHsPDiaTipTra_SelsJson ;
   private String AV26TFPaiHsPDiaDia_SelsJson ;
   private String AV28TFPaiHsPDiaDesde_SelsJson ;
   private String AV77TFPaiTarifaPDCri_SelsJson ;
   private String AV62TFPaiExtraordRelRef_SelsJson ;
   private String AV59MenuBienveTexto ;
   private String AV19ColumnsSelectorXML ;
   private String AV66ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV57textoNoMostrara ;
   private String wcpOAV53MenuOpcCod ;
   private String AV53MenuOpcCod ;
   private String AV63TFPaiExtraordRelRef ;
   private String AV39GridAppliedFilters ;
   private String A2058PaiExtraordRelRef ;
   private String lV92Paisextraordinariaswwds_10_tfpaiextraordrelref ;
   private String AV92Paisextraordinariaswwds_10_tfpaiextraordrelref ;
   private String AV56MenuBienveImgURL ;
   private String AV58MenuBienveTitulo ;
   private String AV81Welcomemessage_foto_GXI ;
   private String AV72MenuOpcTitulo ;
   private String AV75filtrosTexto ;
   private String AV17ExcelFilename ;
   private String AV18ErrorMessage ;
   private String AV61WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels ;
   private GXSimpleCollection<Byte> AV27TFPaiHsPDiaDia_Sels ;
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
   private GXSimpleCollection<String> AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ;
   private GXSimpleCollection<String> AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ;
   private GXSimpleCollection<String> AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ;
   private GXSimpleCollection<String> AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbPaiHsPDiaTipTra ;
   private HTMLChoice cmbPaiHsPDiaDia ;
   private HTMLChoice cmbPaiTarifaPDCri ;
   private IDataStoreProvider pr_default ;
   private String[] H00J92_A2058PaiExtraordRelRef ;
   private String[] H00J92_A2434PaiTarifaPDCri ;
   private java.math.BigDecimal[] H00J92_A1348PaiTarifaPDRec ;
   private java.math.BigDecimal[] H00J92_A1335PaiTarifaPDia ;
   private String[] H00J92_A1334PaiHsPDiaDesde ;
   private boolean[] H00J92_n1334PaiHsPDiaDesde ;
   private byte[] H00J92_A1333PaiHsPDiaDia ;
   private String[] H00J92_A1331PaiHsPDiaTipTra ;
   private short[] H00J92_A1332PaiHsExSec ;
   private short[] H00J92_A46PaiCod ;
   private long[] H00J93_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV25TFPaiHsPDiaTipTra_Sels ;
   private GXSimpleCollection<String> AV30TFPaiHsPDiaDesde_Sels ;
   private GXSimpleCollection<String> AV78TFPaiTarifaPDCri_Sels ;
   private GXSimpleCollection<String> AV64TFPaiExtraordRelRef_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV65ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext12[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState21[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV35DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class paisextraordinariasww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00J92( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1331PaiHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ,
                                          byte A1333PaiHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels ,
                                          String A1334PaiHsPDiaDesde ,
                                          GXSimpleCollection<String> AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ,
                                          String A2434PaiTarifaPDCri ,
                                          GXSimpleCollection<String> AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ,
                                          String A2058PaiExtraordRelRef ,
                                          GXSimpleCollection<String> AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ,
                                          int AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size ,
                                          int AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size ,
                                          int AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size ,
                                          String AV85Paisextraordinariaswwds_3_tfpaihspdiadesde ,
                                          java.math.BigDecimal AV87Paisextraordinariaswwds_5_tfpaitarifapdia ,
                                          java.math.BigDecimal AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to ,
                                          java.math.BigDecimal AV89Paisextraordinariaswwds_7_tfpaitarifapdrec ,
                                          java.math.BigDecimal AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to ,
                                          int AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size ,
                                          int AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size ,
                                          String AV92Paisextraordinariaswwds_10_tfpaiextraordrelref ,
                                          short AV47PaiCod ,
                                          java.math.BigDecimal A1335PaiTarifaPDia ,
                                          java.math.BigDecimal A1348PaiTarifaPDRec ,
                                          short A46PaiCod ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[10];
      Object[] GXv_Object23 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " PaiExtraordRelRef, PaiTarifaPDCri, PaiTarifaPDRec, PaiTarifaPDia, PaiHsPDiaDesde, PaiHsPDiaDia, PaiHsPDiaTipTra, PaiHsExSec, PaiCod" ;
      sFromString = " FROM Paishorasextras_pordia" ;
      sOrderString = "" ;
      if ( AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels, "PaiHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels, "PaiHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Paisextraordinariaswwds_3_tfpaihspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int22[0] = (byte)(1) ;
      }
      if ( AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels, "PaiHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Paisextraordinariaswwds_5_tfpaitarifapdia)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDia >= ?)");
      }
      else
      {
         GXv_int22[1] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDia <= ?)");
      }
      else
      {
         GXv_int22[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV89Paisextraordinariaswwds_7_tfpaitarifapdrec)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int22[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int22[4] = (byte)(1) ;
      }
      if ( AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels, "PaiTarifaPDCri IN (", ")")+")");
      }
      if ( ( AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Paisextraordinariaswwds_10_tfpaiextraordrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiExtraordRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int22[5] = (byte)(1) ;
      }
      if ( AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels, "PaiExtraordRelRef IN (", ")")+")");
      }
      if ( ! (0==AV47PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int22[6] = (byte)(1) ;
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiHsPDiaTipTra, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiHsPDiaTipTra DESC, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiHsPDiaDia, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiHsPDiaDia DESC, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiHsPDiaDesde, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiHsPDiaDesde DESC, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiTarifaPDia, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiTarifaPDia DESC, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiTarifaPDRec, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiTarifaPDRec DESC, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiTarifaPDCri, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiTarifaPDCri DESC, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiExtraordRelRef, PaiCod, PaiHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiExtraordRelRef DESC, PaiCod, PaiHsExSec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY PaiCod, PaiHsExSec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_H00J93( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1331PaiHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ,
                                          byte A1333PaiHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels ,
                                          String A1334PaiHsPDiaDesde ,
                                          GXSimpleCollection<String> AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ,
                                          String A2434PaiTarifaPDCri ,
                                          GXSimpleCollection<String> AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ,
                                          String A2058PaiExtraordRelRef ,
                                          GXSimpleCollection<String> AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ,
                                          int AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size ,
                                          int AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size ,
                                          int AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size ,
                                          String AV85Paisextraordinariaswwds_3_tfpaihspdiadesde ,
                                          java.math.BigDecimal AV87Paisextraordinariaswwds_5_tfpaitarifapdia ,
                                          java.math.BigDecimal AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to ,
                                          java.math.BigDecimal AV89Paisextraordinariaswwds_7_tfpaitarifapdrec ,
                                          java.math.BigDecimal AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to ,
                                          int AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size ,
                                          int AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size ,
                                          String AV92Paisextraordinariaswwds_10_tfpaiextraordrelref ,
                                          short AV47PaiCod ,
                                          java.math.BigDecimal A1335PaiTarifaPDia ,
                                          java.math.BigDecimal A1348PaiTarifaPDRec ,
                                          short A46PaiCod ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[7];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Paishorasextras_pordia" ;
      if ( AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels, "PaiHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Paisextraordinariaswwds_2_tfpaihspdiadia_sels, "PaiHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Paisextraordinariaswwds_3_tfpaihspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int25[0] = (byte)(1) ;
      }
      if ( AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Paisextraordinariaswwds_4_tfpaihspdiadesde_sels, "PaiHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Paisextraordinariaswwds_5_tfpaitarifapdia)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDia >= ?)");
      }
      else
      {
         GXv_int25[1] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88Paisextraordinariaswwds_6_tfpaitarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDia <= ?)");
      }
      else
      {
         GXv_int25[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV89Paisextraordinariaswwds_7_tfpaitarifapdrec)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int25[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV90Paisextraordinariaswwds_8_tfpaitarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int25[4] = (byte)(1) ;
      }
      if ( AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Paisextraordinariaswwds_9_tfpaitarifapdcri_sels, "PaiTarifaPDCri IN (", ")")+")");
      }
      if ( ( AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Paisextraordinariaswwds_10_tfpaiextraordrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiExtraordRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int25[5] = (byte)(1) ;
      }
      if ( AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Paisextraordinariaswwds_11_tfpaiextraordrelref_sels, "PaiExtraordRelRef IN (", ")")+")");
      }
      if ( ! (0==AV47PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int25[6] = (byte)(1) ;
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
                  return conditional_H00J92(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() );
            case 1 :
                  return conditional_H00J93(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00J92", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00J93", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[9])[0] = rslt.getShort(9);
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
                  stmt.setString(sIdx, (String)parms[10], 5);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[11], 4);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[12], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
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
                  stmt.setString(sIdx, (String)parms[7], 5);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 4);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[11], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
      }
   }

}

