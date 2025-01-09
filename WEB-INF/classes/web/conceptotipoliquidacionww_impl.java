package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptotipoliquidacionww_impl extends GXDataArea
{
   public conceptotipoliquidacionww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptotipoliquidacionww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptotipoliquidacionww_impl.class ));
   }

   public conceptotipoliquidacionww_impl( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbConTLVigencia = new HTMLChoice();
      cmbConTLCondicion = new HTMLChoice();
      cmbConTLTipoCon = new HTMLChoice();
      cmbCONTLSegPla = new HTMLChoice();
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
            AV54MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54MenuOpcCod", AV54MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV54MenuOpcCod, ""))));
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
      AV65ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21ColumnsSelector);
      AV78Pgmname = httpContext.GetPar( "Pgmname") ;
      AV54MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV24TFCliCod = (int)(GXutil.lval( httpContext.GetPar( "TFCliCod"))) ;
      AV25TFCliCod_To = (int)(GXutil.lval( httpContext.GetPar( "TFCliCod_To"))) ;
      AV27TFConCodigo = httpContext.GetPar( "TFConCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV28TFConCodigo_Sels);
      AV30TFTLiqCod = httpContext.GetPar( "TFTLiqCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV31TFTLiqCod_Sels);
      AV32TFConTLOrdejec = GXutil.lval( httpContext.GetPar( "TFConTLOrdejec")) ;
      AV33TFConTLOrdejec_To = GXutil.lval( httpContext.GetPar( "TFConTLOrdejec_To")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV37TFConTLCondicion_Sels);
      AV38TFConTLConHab = (byte)(GXutil.lval( httpContext.GetPar( "TFConTLConHab"))) ;
      AV39TFConTLConHab_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConTLConHab_To"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV49TFConTLTipoCon_Sels);
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV46CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV56WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV21ColumnsSelector, AV78Pgmname, AV54MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFTLiqCod, AV31TFTLiqCod_Sels, AV32TFConTLOrdejec, AV33TFConTLOrdejec_To, AV37TFConTLCondicion_Sels, AV38TFConTLConHab, AV39TFConTLConHab_To, AV49TFConTLTipoCon_Sels, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV56WelcomeMessage_NoMostrarMas) ;
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
      paIQ2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startIQ2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptotipoliquidacionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV54MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV78Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV54MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV46CliCod), "ZZZZZ9")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV40DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV40DDO_TitleSettingsIcons);
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV63ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV63ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV42GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV43GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV44GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV65ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV78Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV78Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV54MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV54MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICOD", GXutil.ltrim( localUtil.ntoc( AV24TFCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICOD_TO", GXutil.ltrim( localUtil.ntoc( AV25TFCliCod_To, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODIGO", GXutil.rtrim( AV27TFConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCODIGO_SELS", AV28TFConCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCODIGO_SELS", AV28TFConCodigo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTLIQCOD", GXutil.rtrim( AV30TFTLiqCod));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFTLIQCOD_SELS", AV31TFTLiqCod_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFTLIQCOD_SELS", AV31TFTLiqCod_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONTLORDEJEC", GXutil.ltrim( localUtil.ntoc( AV32TFConTLOrdejec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONTLORDEJEC_TO", GXutil.ltrim( localUtil.ntoc( AV33TFConTLOrdejec_To, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONTLCONDICION_SELS", AV37TFConTLCondicion_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONTLCONDICION_SELS", AV37TFConTLCondicion_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONTLCONHAB", GXutil.ltrim( localUtil.ntoc( AV38TFConTLConHab, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONTLCONHAB_TO", GXutil.ltrim( localUtil.ntoc( AV39TFConTLConHab_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONTLTIPOCON_SELS", AV49TFConTLTipoCon_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONTLTIPOCON_SELS", AV49TFConTLTipoCon_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV46CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV46CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODIGO_SELSJSON", AV26TFConCodigo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTLIQCOD_SELSJSON", AV29TFTLiqCod_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONTLCONDICION_SELSJSON", AV36TFConTLCondicion_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONTLTIPOCON_SELSJSON", AV48TFConTLTipoCon_SelsJson);
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
         weIQ2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtIQ2( ) ;
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
      return formatLink("web.conceptotipoliquidacionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV54MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "ConceptoTipoLiquidacionWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Concepto Tipo Liquidacion", "") ;
   }

   public void wbIQ0( )
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
         wb_table1_9_IQ2( true) ;
      }
      else
      {
         wb_table1_9_IQ2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_IQ2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV40DDO_TitleSettingsIcons);
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

   public void startIQ2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Concepto Tipo Liquidacion", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupIQ0( ) ;
   }

   public void wsIQ2( )
   {
      startIQ2( ) ;
      evtIQ2( ) ;
   }

   public void evtIQ2( )
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
                           e11IQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12IQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13IQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14IQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15IQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e16IQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17IQ2 ();
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
                           A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
                           A32TLiqCod = httpContext.cgiGet( edtTLiqCod_Internalname) ;
                           A1406ConTLOrdejec = localUtil.ctol( httpContext.cgiGet( edtConTLOrdejec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           cmbConTLVigencia.setName( cmbConTLVigencia.getInternalname() );
                           cmbConTLVigencia.setValue( httpContext.cgiGet( cmbConTLVigencia.getInternalname()) );
                           A1409ConTLVigencia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConTLVigencia.getInternalname()))) ;
                           n1409ConTLVigencia = false ;
                           cmbConTLCondicion.setName( cmbConTLCondicion.getInternalname() );
                           cmbConTLCondicion.setValue( httpContext.cgiGet( cmbConTLCondicion.getInternalname()) );
                           A1410ConTLCondicion = httpContext.cgiGet( cmbConTLCondicion.getInternalname()) ;
                           n1410ConTLCondicion = false ;
                           A1470ConTLConHab = (byte)(localUtil.ctol( httpContext.cgiGet( edtConTLConHab_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbConTLTipoCon.setName( cmbConTLTipoCon.getInternalname() );
                           cmbConTLTipoCon.setValue( httpContext.cgiGet( cmbConTLTipoCon.getInternalname()) );
                           A1788ConTLTipoCon = httpContext.cgiGet( cmbConTLTipoCon.getInternalname()) ;
                           n1788ConTLTipoCon = false ;
                           cmbCONTLSegPla.setName( cmbCONTLSegPla.getInternalname() );
                           cmbCONTLSegPla.setValue( httpContext.cgiGet( cmbCONTLSegPla.getInternalname()) );
                           A1789CONTLSegPla = (byte)(GXutil.lval( httpContext.cgiGet( cmbCONTLSegPla.getInternalname()))) ;
                           n1789CONTLSegPla = false ;
                           AV53Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV53Display);
                           AV52VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV52VerSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e18IQ2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e19IQ2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20IQ2 ();
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

   public void weIQ2( )
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

   public void paIQ2( )
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
                                 byte AV65ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ,
                                 String AV78Pgmname ,
                                 String AV54MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 int AV24TFCliCod ,
                                 int AV25TFCliCod_To ,
                                 String AV27TFConCodigo ,
                                 GXSimpleCollection<String> AV28TFConCodigo_Sels ,
                                 String AV30TFTLiqCod ,
                                 GXSimpleCollection<String> AV31TFTLiqCod_Sels ,
                                 long AV32TFConTLOrdejec ,
                                 long AV33TFConTLOrdejec_To ,
                                 GXSimpleCollection<String> AV37TFConTLCondicion_Sels ,
                                 byte AV38TFConTLConHab ,
                                 byte AV39TFConTLConHab_To ,
                                 GXSimpleCollection<String> AV49TFConTLTipoCon_Sels ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV46CliCod ,
                                 boolean AV56WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e19IQ2 ();
      GRID_nCurrentRecord = 0 ;
      rfIQ2( ) ;
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
      AV56WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV56WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56WelcomeMessage_NoMostrarMas", AV56WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfIQ2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV78Pgmname = "ConceptoTipoLiquidacionWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
   }

   public void rfIQ2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(108) ;
      /* Execute user event: Refresh */
      e19IQ2 ();
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
                                              A26ConCodigo ,
                                              AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                              A32TLiqCod ,
                                              AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                              A1410ConTLCondicion ,
                                              AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                              A1788ConTLTipoCon ,
                                              AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                              Integer.valueOf(AV79Conceptotipoliquidacionwwds_1_tfclicod) ,
                                              Integer.valueOf(AV80Conceptotipoliquidacionwwds_2_tfclicod_to) ,
                                              Integer.valueOf(AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels.size()) ,
                                              AV81Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                              Integer.valueOf(AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels.size()) ,
                                              AV83Conceptotipoliquidacionwwds_5_tftliqcod ,
                                              Long.valueOf(AV85Conceptotipoliquidacionwwds_7_tfcontlordejec) ,
                                              Long.valueOf(AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to) ,
                                              Integer.valueOf(AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels.size()) ,
                                              Byte.valueOf(AV88Conceptotipoliquidacionwwds_10_tfcontlconhab) ,
                                              Byte.valueOf(AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to) ,
                                              Integer.valueOf(AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels.size()) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Long.valueOf(A1406ConTLOrdejec) ,
                                              Byte.valueOf(A1470ConTLConHab) ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG,
                                              TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV81Conceptotipoliquidacionwwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV81Conceptotipoliquidacionwwds_3_tfconcodigo), 10, "%") ;
         lV83Conceptotipoliquidacionwwds_5_tftliqcod = GXutil.padr( GXutil.rtrim( AV83Conceptotipoliquidacionwwds_5_tftliqcod), 20, "%") ;
         /* Using cursor H00IQ2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV79Conceptotipoliquidacionwwds_1_tfclicod), Integer.valueOf(AV80Conceptotipoliquidacionwwds_2_tfclicod_to), lV81Conceptotipoliquidacionwwds_3_tfconcodigo, lV83Conceptotipoliquidacionwwds_5_tftliqcod, Long.valueOf(AV85Conceptotipoliquidacionwwds_7_tfcontlordejec), Long.valueOf(AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to), Byte.valueOf(AV88Conceptotipoliquidacionwwds_10_tfcontlconhab), Byte.valueOf(AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_108_idx = 1 ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1789CONTLSegPla = H00IQ2_A1789CONTLSegPla[0] ;
            n1789CONTLSegPla = H00IQ2_n1789CONTLSegPla[0] ;
            A1788ConTLTipoCon = H00IQ2_A1788ConTLTipoCon[0] ;
            n1788ConTLTipoCon = H00IQ2_n1788ConTLTipoCon[0] ;
            A1470ConTLConHab = H00IQ2_A1470ConTLConHab[0] ;
            A1410ConTLCondicion = H00IQ2_A1410ConTLCondicion[0] ;
            n1410ConTLCondicion = H00IQ2_n1410ConTLCondicion[0] ;
            A1409ConTLVigencia = H00IQ2_A1409ConTLVigencia[0] ;
            n1409ConTLVigencia = H00IQ2_n1409ConTLVigencia[0] ;
            A1406ConTLOrdejec = H00IQ2_A1406ConTLOrdejec[0] ;
            A32TLiqCod = H00IQ2_A32TLiqCod[0] ;
            A26ConCodigo = H00IQ2_A26ConCodigo[0] ;
            A3CliCod = H00IQ2_A3CliCod[0] ;
            e20IQ2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(108) ;
         wbIQ0( ) ;
      }
      bGXsfl_108_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesIQ2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV78Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV78Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV54MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV54MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV46CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV46CliCod), "ZZZZZ9")));
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
      AV79Conceptotipoliquidacionwwds_1_tfclicod = AV24TFCliCod ;
      AV80Conceptotipoliquidacionwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV81Conceptotipoliquidacionwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Conceptotipoliquidacionwwds_5_tftliqcod = AV30TFTLiqCod ;
      AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV31TFTLiqCod_Sels ;
      AV85Conceptotipoliquidacionwwds_7_tfcontlordejec = AV32TFConTLOrdejec ;
      AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV33TFConTLOrdejec_To ;
      AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV37TFConTLCondicion_Sels ;
      AV88Conceptotipoliquidacionwwds_10_tfcontlconhab = AV38TFConTLConHab ;
      AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV39TFConTLConHab_To ;
      AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                           A32TLiqCod ,
                                           AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                           A1410ConTLCondicion ,
                                           AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                           A1788ConTLTipoCon ,
                                           AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                           Integer.valueOf(AV79Conceptotipoliquidacionwwds_1_tfclicod) ,
                                           Integer.valueOf(AV80Conceptotipoliquidacionwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels.size()) ,
                                           AV81Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                           Integer.valueOf(AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels.size()) ,
                                           AV83Conceptotipoliquidacionwwds_5_tftliqcod ,
                                           Long.valueOf(AV85Conceptotipoliquidacionwwds_7_tfcontlordejec) ,
                                           Long.valueOf(AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to) ,
                                           Integer.valueOf(AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels.size()) ,
                                           Byte.valueOf(AV88Conceptotipoliquidacionwwds_10_tfcontlconhab) ,
                                           Byte.valueOf(AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to) ,
                                           Integer.valueOf(AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels.size()) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Long.valueOf(A1406ConTLOrdejec) ,
                                           Byte.valueOf(A1470ConTLConHab) ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV81Conceptotipoliquidacionwwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV81Conceptotipoliquidacionwwds_3_tfconcodigo), 10, "%") ;
      lV83Conceptotipoliquidacionwwds_5_tftliqcod = GXutil.padr( GXutil.rtrim( AV83Conceptotipoliquidacionwwds_5_tftliqcod), 20, "%") ;
      /* Using cursor H00IQ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV79Conceptotipoliquidacionwwds_1_tfclicod), Integer.valueOf(AV80Conceptotipoliquidacionwwds_2_tfclicod_to), lV81Conceptotipoliquidacionwwds_3_tfconcodigo, lV83Conceptotipoliquidacionwwds_5_tftliqcod, Long.valueOf(AV85Conceptotipoliquidacionwwds_7_tfcontlordejec), Long.valueOf(AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to), Byte.valueOf(AV88Conceptotipoliquidacionwwds_10_tfcontlconhab), Byte.valueOf(AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to)});
      GRID_nRecordCount = H00IQ3_AGRID_nRecordCount[0] ;
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
      AV79Conceptotipoliquidacionwwds_1_tfclicod = AV24TFCliCod ;
      AV80Conceptotipoliquidacionwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV81Conceptotipoliquidacionwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Conceptotipoliquidacionwwds_5_tftliqcod = AV30TFTLiqCod ;
      AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV31TFTLiqCod_Sels ;
      AV85Conceptotipoliquidacionwwds_7_tfcontlordejec = AV32TFConTLOrdejec ;
      AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV33TFConTLOrdejec_To ;
      AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV37TFConTLCondicion_Sels ;
      AV88Conceptotipoliquidacionwwds_10_tfcontlconhab = AV38TFConTLConHab ;
      AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV39TFConTLConHab_To ;
      AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV21ColumnsSelector, AV78Pgmname, AV54MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFTLiqCod, AV31TFTLiqCod_Sels, AV32TFConTLOrdejec, AV33TFConTLOrdejec_To, AV37TFConTLCondicion_Sels, AV38TFConTLConHab, AV39TFConTLConHab_To, AV49TFConTLTipoCon_Sels, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV56WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV79Conceptotipoliquidacionwwds_1_tfclicod = AV24TFCliCod ;
      AV80Conceptotipoliquidacionwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV81Conceptotipoliquidacionwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Conceptotipoliquidacionwwds_5_tftliqcod = AV30TFTLiqCod ;
      AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV31TFTLiqCod_Sels ;
      AV85Conceptotipoliquidacionwwds_7_tfcontlordejec = AV32TFConTLOrdejec ;
      AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV33TFConTLOrdejec_To ;
      AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV37TFConTLCondicion_Sels ;
      AV88Conceptotipoliquidacionwwds_10_tfcontlconhab = AV38TFConTLConHab ;
      AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV39TFConTLConHab_To ;
      AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV21ColumnsSelector, AV78Pgmname, AV54MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFTLiqCod, AV31TFTLiqCod_Sels, AV32TFConTLOrdejec, AV33TFConTLOrdejec_To, AV37TFConTLCondicion_Sels, AV38TFConTLConHab, AV39TFConTLConHab_To, AV49TFConTLTipoCon_Sels, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV56WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV79Conceptotipoliquidacionwwds_1_tfclicod = AV24TFCliCod ;
      AV80Conceptotipoliquidacionwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV81Conceptotipoliquidacionwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Conceptotipoliquidacionwwds_5_tftliqcod = AV30TFTLiqCod ;
      AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV31TFTLiqCod_Sels ;
      AV85Conceptotipoliquidacionwwds_7_tfcontlordejec = AV32TFConTLOrdejec ;
      AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV33TFConTLOrdejec_To ;
      AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV37TFConTLCondicion_Sels ;
      AV88Conceptotipoliquidacionwwds_10_tfcontlconhab = AV38TFConTLConHab ;
      AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV39TFConTLConHab_To ;
      AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV21ColumnsSelector, AV78Pgmname, AV54MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFTLiqCod, AV31TFTLiqCod_Sels, AV32TFConTLOrdejec, AV33TFConTLOrdejec_To, AV37TFConTLCondicion_Sels, AV38TFConTLConHab, AV39TFConTLConHab_To, AV49TFConTLTipoCon_Sels, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV56WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV79Conceptotipoliquidacionwwds_1_tfclicod = AV24TFCliCod ;
      AV80Conceptotipoliquidacionwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV81Conceptotipoliquidacionwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Conceptotipoliquidacionwwds_5_tftliqcod = AV30TFTLiqCod ;
      AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV31TFTLiqCod_Sels ;
      AV85Conceptotipoliquidacionwwds_7_tfcontlordejec = AV32TFConTLOrdejec ;
      AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV33TFConTLOrdejec_To ;
      AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV37TFConTLCondicion_Sels ;
      AV88Conceptotipoliquidacionwwds_10_tfcontlconhab = AV38TFConTLConHab ;
      AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV39TFConTLConHab_To ;
      AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV21ColumnsSelector, AV78Pgmname, AV54MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFTLiqCod, AV31TFTLiqCod_Sels, AV32TFConTLOrdejec, AV33TFConTLOrdejec_To, AV37TFConTLCondicion_Sels, AV38TFConTLConHab, AV39TFConTLConHab_To, AV49TFConTLTipoCon_Sels, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV56WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV79Conceptotipoliquidacionwwds_1_tfclicod = AV24TFCliCod ;
      AV80Conceptotipoliquidacionwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV81Conceptotipoliquidacionwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Conceptotipoliquidacionwwds_5_tftliqcod = AV30TFTLiqCod ;
      AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV31TFTLiqCod_Sels ;
      AV85Conceptotipoliquidacionwwds_7_tfcontlordejec = AV32TFConTLOrdejec ;
      AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV33TFConTLOrdejec_To ;
      AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV37TFConTLCondicion_Sels ;
      AV88Conceptotipoliquidacionwwds_10_tfcontlconhab = AV38TFConTLConHab ;
      AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV39TFConTLConHab_To ;
      AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV21ColumnsSelector, AV78Pgmname, AV54MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFTLiqCod, AV31TFTLiqCod_Sels, AV32TFConTLOrdejec, AV33TFConTLOrdejec_To, AV37TFConTLCondicion_Sels, AV38TFConTLConHab, AV39TFConTLConHab_To, AV49TFConTLTipoCon_Sels, AV14OrderedBy, AV15OrderedDsc, AV46CliCod, AV56WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV78Pgmname = "ConceptoTipoLiquidacionWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupIQ0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18IQ2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV40DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV63ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_108 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_108"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV42GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV43GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV44GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         AV62WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV56WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56WelcomeMessage_NoMostrarMas", AV56WelcomeMessage_NoMostrarMas);
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
      e18IQ2 ();
      if (returnInSub) return;
   }

   public void e18IQ2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV54MenuOpcCod, "", "") ;
      GXt_int1 = AV46CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptotipoliquidacionww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV46CliCod = GXt_int1 ;
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
      Form.setCaption( httpContext.getMessage( " Concepto Tipo Liquidacion", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV40DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV40DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV57MenuBienveImgURL ;
      GXv_char6[0] = AV59MenuBienveTitulo ;
      GXv_char7[0] = AV60MenuBienveTexto ;
      GXv_boolean8[0] = AV61MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV54MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      conceptotipoliquidacionww_impl.this.AV57MenuBienveImgURL = GXv_char5[0] ;
      conceptotipoliquidacionww_impl.this.AV59MenuBienveTitulo = GXv_char6[0] ;
      conceptotipoliquidacionww_impl.this.AV60MenuBienveTexto = GXv_char7[0] ;
      conceptotipoliquidacionww_impl.this.AV61MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV61MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV61MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV59MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV60MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV62WelcomeMessage_Foto = AV57MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV62WelcomeMessage_Foto)==0) ? AV77Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV62WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV62WelcomeMessage_Foto), true);
         AV77Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV57MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV62WelcomeMessage_Foto)==0) ? AV77Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV62WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV62WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      conceptotipoliquidacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      conceptotipoliquidacionww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV74observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV74observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV74observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV74observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e19IQ2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV46CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptotipoliquidacionww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV46CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV46CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext11[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext11) ;
      AV6WWPContext = GXv_SdtWWPContext11[0] ;
      if ( AV65ManageFiltersExecutionStep == 1 )
      {
         AV65ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ManageFiltersExecutionStep", GXutil.str( AV65ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV65ManageFiltersExecutionStep == 2 )
      {
         AV65ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ManageFiltersExecutionStep", GXutil.str( AV65ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV23Session.getValue("ConceptoTipoLiquidacionWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("ConceptoTipoLiquidacionWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S162 ();
         if (returnInSub) return;
      }
      edtCliCod_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtConCodigo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtTLiqCod_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtTLiqCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCod_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtConTLOrdejec_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConTLOrdejec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConTLOrdejec_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbConTLVigencia.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConTLVigencia.getInternalname(), "Visible", GXutil.ltrimstr( cmbConTLVigencia.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConTLCondicion.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConTLCondicion.getInternalname(), "Visible", GXutil.ltrimstr( cmbConTLCondicion.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtConTLConHab_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConTLConHab_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConTLConHab_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbConTLTipoCon.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConTLTipoCon.getInternalname(), "Visible", GXutil.ltrimstr( cmbConTLTipoCon.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbCONTLSegPla.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCONTLSegPla.getInternalname(), "Visible", GXutil.ltrimstr( cmbCONTLSegPla.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      AV42GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42GridCurrentPage), 10, 0));
      AV43GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43GridPageCount), 10, 0));
      GXt_char10 = AV44GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV78Pgmname, GXv_char7) ;
      conceptotipoliquidacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV44GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44GridAppliedFilters", AV44GridAppliedFilters);
      GXt_char10 = AV70MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV54MenuOpcCod, GXv_char7) ;
      conceptotipoliquidacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV70MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV70MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV70MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int12[0] = (short)(AV72filterCount) ;
      GXv_char7[0] = AV73filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int12, GXv_char7) ;
      conceptotipoliquidacionww_impl.this.AV72filterCount = GXv_int12[0] ;
      conceptotipoliquidacionww_impl.this.AV73filtrosTexto = GXv_char7[0] ;
      if ( AV72filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV72filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV73filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV79Conceptotipoliquidacionwwds_1_tfclicod = AV24TFCliCod ;
      AV80Conceptotipoliquidacionwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV81Conceptotipoliquidacionwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Conceptotipoliquidacionwwds_5_tftliqcod = AV30TFTLiqCod ;
      AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV31TFTLiqCod_Sels ;
      AV85Conceptotipoliquidacionwwds_7_tfcontlordejec = AV32TFConTLOrdejec ;
      AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV33TFConTLOrdejec_To ;
      AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV37TFConTLCondicion_Sels ;
      AV88Conceptotipoliquidacionwwds_10_tfcontlconhab = AV38TFConTLConHab ;
      AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV39TFConTLConHab_To ;
      AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV63ManageFiltersData", AV63ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e13IQ2( )
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

   public void e14IQ2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15IQ2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliCod") == 0 )
         {
            AV24TFCliCod = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24TFCliCod), 6, 0));
            AV25TFCliCod_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFCliCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFCliCod_To), 6, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConCodigo") == 0 )
         {
            AV27TFConCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFConCodigo", AV27TFConCodigo);
            AV26TFConCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFConCodigo_SelsJson", AV26TFConCodigo_SelsJson);
            AV28TFConCodigo_Sels.fromJSonString(AV26TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "TLiqCod") == 0 )
         {
            AV30TFTLiqCod = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFTLiqCod", AV30TFTLiqCod);
            AV29TFTLiqCod_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFTLiqCod_SelsJson", AV29TFTLiqCod_SelsJson);
            AV31TFTLiqCod_Sels.fromJSonString(AV29TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConTLOrdejec") == 0 )
         {
            AV32TFConTLOrdejec = GXutil.lval( Ddo_grid_Filteredtext_get) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFConTLOrdejec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFConTLOrdejec), 12, 0));
            AV33TFConTLOrdejec_To = GXutil.lval( Ddo_grid_Filteredtextto_get) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFConTLOrdejec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFConTLOrdejec_To), 12, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConTLVigencia") == 0 )
         {
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConTLCondicion") == 0 )
         {
            AV36TFConTLCondicion_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFConTLCondicion_SelsJson", AV36TFConTLCondicion_SelsJson);
            AV37TFConTLCondicion_Sels.fromJSonString(AV36TFConTLCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConTLConHab") == 0 )
         {
            AV38TFConTLConHab = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFConTLConHab", GXutil.str( AV38TFConTLConHab, 1, 0));
            AV39TFConTLConHab_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFConTLConHab_To", GXutil.str( AV39TFConTLConHab_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConTLTipoCon") == 0 )
         {
            AV48TFConTLTipoCon_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFConTLTipoCon_SelsJson", AV48TFConTLTipoCon_SelsJson);
            AV49TFConTLTipoCon_Sels.fromJSonString(AV48TFConTLTipoCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CONTLSegPla") == 0 )
         {
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV49TFConTLTipoCon_Sels", AV49TFConTLTipoCon_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV37TFConTLCondicion_Sels", AV37TFConTLCondicion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31TFTLiqCod_Sels", AV31TFTLiqCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28TFConCodigo_Sels", AV28TFConCodigo_Sels);
   }

   private void e20IQ2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV53Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV53Display);
      edtavDisplay_Link = formatLink("web.conceptotipoliquidacionview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A26ConCodigo)),GXutil.URLEncode(GXutil.rtrim(A32TLiqCod)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","ConCodigo","TLiqCod","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV52VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      conceptotipoliquidacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV52VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV52VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
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

   public void e11IQ2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "ConceptoTipoLiquidacionWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV63ManageFiltersData", AV63ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e12IQ2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("ConceptoTipoLiquidacionWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV78Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV65ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ManageFiltersExecutionStep", GXutil.str( AV65ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("ConceptoTipoLiquidacionWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV65ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ManageFiltersExecutionStep", GXutil.str( AV65ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV64ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "ConceptoTipoLiquidacionWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         conceptotipoliquidacionww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV64ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV64ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S172 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV78Pgmname+"GridState", AV64ManageFiltersXml) ;
            AV12GridState.fromxml(AV64ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28TFConCodigo_Sels", AV28TFConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31TFTLiqCod_Sels", AV31TFTLiqCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV37TFConTLCondicion_Sels", AV37TFConTLCondicion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV49TFConTLTipoCon_Sels", AV49TFConTLTipoCon_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV63ManageFiltersData", AV63ManageFiltersData);
   }

   public void e16IQ2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char6[0] = AV18ErrorMessage ;
      new web.conceptotipoliquidacionwwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      conceptotipoliquidacionww_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      conceptotipoliquidacionww_impl.this.AV18ErrorMessage = GXv_char6[0] ;
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

   public void S162( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV21ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliCod", "", "Cod", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConCodigo", "", "Código", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "TLiqCod", "", "Tipo de Liquidación", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConTLOrdejec", "", "TLOrdejec", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConTLVigencia", "", "TLVigencia", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConTLCondicion", "", "TLCondicion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConTLConHab", "", "TLCon Hab", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConTLTipoCon", "", "TLTipo Con", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CONTLSegPla", "", "Pla", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&VerSVG", "", "", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXt_char10 = AV20UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ConceptoTipoLiquidacionWWColumnsSelector", GXv_char7) ;
      conceptotipoliquidacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV20UserCustomValue = GXt_char10 ;
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
      new web.fixcolumnsselector(remoteHandle, context).execute( AV46CliCod, GXv_SdtWWPColumnsSelector14) ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 = AV63ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item16[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "ConceptoTipoLiquidacionWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item16) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item16[0] ;
      AV63ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 ;
   }

   public void S172( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV24TFCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24TFCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24TFCliCod), 6, 0));
      AV25TFCliCod_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25TFCliCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFCliCod_To), 6, 0));
      AV27TFConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFConCodigo", AV27TFConCodigo);
      AV28TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV30TFTLiqCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFTLiqCod", AV30TFTLiqCod);
      AV31TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV32TFConTLOrdejec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFConTLOrdejec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFConTLOrdejec), 12, 0));
      AV33TFConTLOrdejec_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFConTLOrdejec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFConTLOrdejec_To), 12, 0));
      AV37TFConTLCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV38TFConTLConHab = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFConTLConHab", GXutil.str( AV38TFConTLConHab, 1, 0));
      AV39TFConTLConHab_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFConTLConHab_To", GXutil.str( AV39TFConTLConHab_To, 1, 0));
      AV49TFConTLTipoCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV23Session.getValue(AV78Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV78Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV23Session.getValue(AV78Pgmname+"GridState"), null, null);
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
      AV91GXV1 = 1 ;
      while ( AV91GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV91GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV24TFCliCod = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24TFCliCod), 6, 0));
            AV25TFCliCod_To = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFCliCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFCliCod_To), 6, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV27TFConCodigo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFConCodigo", AV27TFConCodigo);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV26TFConCodigo_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFConCodigo_SelsJson", AV26TFConCodigo_SelsJson);
            AV28TFConCodigo_Sels.fromJSonString(AV26TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD") == 0 )
         {
            AV30TFTLiqCod = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFTLiqCod", AV30TFTLiqCod);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD_SEL") == 0 )
         {
            AV29TFTLiqCod_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFTLiqCod_SelsJson", AV29TFTLiqCod_SelsJson);
            AV31TFTLiqCod_Sels.fromJSonString(AV29TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLORDEJEC") == 0 )
         {
            AV32TFConTLOrdejec = GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFConTLOrdejec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFConTLOrdejec), 12, 0));
            AV33TFConTLOrdejec_To = GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFConTLOrdejec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFConTLOrdejec_To), 12, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLCONDICION_SEL") == 0 )
         {
            AV36TFConTLCondicion_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFConTLCondicion_SelsJson", AV36TFConTLCondicion_SelsJson);
            AV37TFConTLCondicion_Sels.fromJSonString(AV36TFConTLCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLCONHAB") == 0 )
         {
            AV38TFConTLConHab = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFConTLConHab", GXutil.str( AV38TFConTLConHab, 1, 0));
            AV39TFConTLConHab_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFConTLConHab_To", GXutil.str( AV39TFConTLConHab_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLTIPOCON_SEL") == 0 )
         {
            AV48TFConTLTipoCon_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFConTLTipoCon_SelsJson", AV48TFConTLTipoCon_SelsJson);
            AV49TFConTLTipoCon_Sels.fromJSonString(AV48TFConTLTipoCon_SelsJson, null);
         }
         AV91GXV1 = (int)(AV91GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV28TFConCodigo_Sels.size()==0), AV26TFConCodigo_SelsJson, GXv_char7) ;
      conceptotipoliquidacionww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV31TFTLiqCod_Sels.size()==0), AV29TFTLiqCod_SelsJson, GXv_char6) ;
      conceptotipoliquidacionww_impl.this.GXt_char9 = GXv_char6[0] ;
      GXt_char17 = "" ;
      GXv_char5[0] = GXt_char17 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV37TFConTLCondicion_Sels.size()==0), AV36TFConTLCondicion_SelsJson, GXv_char5) ;
      conceptotipoliquidacionww_impl.this.GXt_char17 = GXv_char5[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV49TFConTLTipoCon_Sels.size()==0), AV48TFConTLTipoCon_SelsJson, GXv_char19) ;
      conceptotipoliquidacionww_impl.this.GXt_char18 = GXv_char19[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char10+"|"+GXt_char9+"|||"+GXt_char17+"||"+GXt_char18+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV27TFConCodigo)==0), AV27TFConCodigo, GXv_char19) ;
      conceptotipoliquidacionww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char17 = "" ;
      GXv_char7[0] = GXt_char17 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFTLiqCod)==0), AV30TFTLiqCod, GXv_char7) ;
      conceptotipoliquidacionww_impl.this.GXt_char17 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV24TFCliCod) ? "" : GXutil.str( AV24TFCliCod, 6, 0))+"|"+GXt_char18+"|"+GXt_char17+"|"+((0==AV32TFConTLOrdejec) ? "" : GXutil.str( AV32TFConTLOrdejec, 12, 0))+"|||"+((0==AV38TFConTLConHab) ? "" : GXutil.str( AV38TFConTLConHab, 1, 0))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV25TFCliCod_To) ? "" : GXutil.str( AV25TFCliCod_To, 6, 0))+"|||"+((0==AV33TFConTLOrdejec_To) ? "" : GXutil.str( AV33TFConTLOrdejec_To, 12, 0))+"|||"+((0==AV39TFConTLConHab_To) ? "" : GXutil.str( AV39TFConTLConHab_To, 1, 0))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV23Session.getValue(AV78Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState20[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFCLICOD", httpContext.getMessage( "Cod", ""), !((0==AV24TFCliCod)&&(0==AV25TFCliCod_To)), (short)(0), GXutil.trim( GXutil.str( AV24TFCliCod, 6, 0)), GXutil.trim( GXutil.str( AV25TFCliCod_To, 6, 0))) ;
      AV12GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFCONCODIGO", httpContext.getMessage( "Código", ""), !(GXutil.strcmp("", AV27TFConCodigo)==0), (short)(0), AV27TFConCodigo, "", !(AV28TFConCodigo_Sels.size()==0), AV28TFConCodigo_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFTLIQCOD", httpContext.getMessage( "Tipo de Liquidación", ""), !(GXutil.strcmp("", AV30TFTLiqCod)==0), (short)(0), AV30TFTLiqCod, "", !(AV31TFTLiqCod_Sels.size()==0), AV31TFTLiqCod_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFCONTLORDEJEC", httpContext.getMessage( "TLOrdejec", ""), !((0==AV32TFConTLOrdejec)&&(0==AV33TFConTLOrdejec_To)), (short)(0), GXutil.trim( GXutil.str( AV32TFConTLOrdejec, 12, 0)), GXutil.trim( GXutil.str( AV33TFConTLOrdejec_To, 12, 0))) ;
      AV12GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFCONTLCONDICION_SEL", httpContext.getMessage( "TLCondicion", ""), !(AV37TFConTLCondicion_Sels.size()==0), (short)(0), AV37TFConTLCondicion_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFCONTLCONHAB", httpContext.getMessage( "TLCon Hab", ""), !((0==AV38TFConTLConHab)&&(0==AV39TFConTLConHab_To)), (short)(0), GXutil.trim( GXutil.str( AV38TFConTLConHab, 1, 0)), GXutil.trim( GXutil.str( AV39TFConTLConHab_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFCONTLTIPOCON_SEL", httpContext.getMessage( "TLTipo Con", ""), !(AV49TFConTLTipoCon_Sels.size()==0), (short)(0), AV49TFConTLTipoCon_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState20[0] ;
      if ( ! (GXutil.strcmp("", AV54MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV54MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV78Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV78Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "ConceptoTipoLiquidacion" );
      AV23Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e17IQ2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV56WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV54MenuOpcCod, GXv_boolean8) ;
         GXv_char19[0] = AV58textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV46CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char19) ;
         conceptotipoliquidacionww_impl.this.AV58textoNoMostrara = GXv_char19[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV58textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV54MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_IQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_IQ2( true) ;
      }
      else
      {
         wb_table2_12_IQ2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_IQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_IQ2e( true) ;
      }
      else
      {
         wb_table1_9_IQ2e( false) ;
      }
   }

   public void wb_table2_12_IQ2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e21iq1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_ConceptoTipoLiquidacionWW.htm");
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
         AV62WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV62WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV77Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV62WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV62WelcomeMessage_Foto)==0) ? AV77Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV62WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV62WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ConceptoTipoLiquidacionWW.htm");
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
         wb_table3_30_IQ2( true) ;
      }
      else
      {
         wb_table3_30_IQ2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_IQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_IQ2( true) ;
      }
      else
      {
         wb_table4_35_IQ2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_IQ2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV56WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacionWW.htm");
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
         wb_table5_54_IQ2( true) ;
      }
      else
      {
         wb_table5_54_IQ2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_IQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_IQ2( true) ;
      }
      else
      {
         wb_table6_63_IQ2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_IQ2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV42GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV43GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV44GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_IQ2e( true) ;
      }
      else
      {
         wb_table2_12_IQ2e( false) ;
      }
   }

   public void wb_table6_63_IQ2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_ConceptoTipoLiquidacionWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacionWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV40DDO_TitleSettingsIcons);
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV63ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoTipoLiquidacionWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_ConceptoTipoLiquidacionWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_97_IQ2( true) ;
      }
      else
      {
         wb_table7_97_IQ2( false) ;
      }
      return  ;
   }

   public void wb_table7_97_IQ2e( boolean wbgen )
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
         wb_table6_63_IQ2e( true) ;
      }
      else
      {
         wb_table6_63_IQ2e( false) ;
      }
   }

   public void wb_table7_97_IQ2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacionWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_97_IQ2e( true) ;
      }
      else
      {
         wb_table7_97_IQ2e( false) ;
      }
   }

   public void wb_table5_54_IQ2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_IQ2e( true) ;
      }
      else
      {
         wb_table5_54_IQ2e( false) ;
      }
   }

   public void wb_table4_35_IQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacionWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_IQ2e( true) ;
      }
      else
      {
         wb_table4_35_IQ2e( false) ;
      }
   }

   public void wb_table3_30_IQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacionWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_IQ2e( true) ;
      }
      else
      {
         wb_table3_30_IQ2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV54MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54MenuOpcCod", AV54MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV54MenuOpcCod, ""))));
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
      paIQ2( ) ;
      wsIQ2( ) ;
      weIQ2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713303980", true, true);
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
      httpContext.AddJavascriptSource("conceptotipoliquidacionww.js", "?20251713303981", false, true);
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
      edtConCodigo_Internalname = "CONCODIGO_"+sGXsfl_108_idx ;
      edtTLiqCod_Internalname = "TLIQCOD_"+sGXsfl_108_idx ;
      edtConTLOrdejec_Internalname = "CONTLORDEJEC_"+sGXsfl_108_idx ;
      cmbConTLVigencia.setInternalname( "CONTLVIGENCIA_"+sGXsfl_108_idx );
      cmbConTLCondicion.setInternalname( "CONTLCONDICION_"+sGXsfl_108_idx );
      edtConTLConHab_Internalname = "CONTLCONHAB_"+sGXsfl_108_idx ;
      cmbConTLTipoCon.setInternalname( "CONTLTIPOCON_"+sGXsfl_108_idx );
      cmbCONTLSegPla.setInternalname( "CONTLSEGPLA_"+sGXsfl_108_idx );
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_idx ;
   }

   public void subsflControlProps_fel_1082( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_108_fel_idx ;
      edtConCodigo_Internalname = "CONCODIGO_"+sGXsfl_108_fel_idx ;
      edtTLiqCod_Internalname = "TLIQCOD_"+sGXsfl_108_fel_idx ;
      edtConTLOrdejec_Internalname = "CONTLORDEJEC_"+sGXsfl_108_fel_idx ;
      cmbConTLVigencia.setInternalname( "CONTLVIGENCIA_"+sGXsfl_108_fel_idx );
      cmbConTLCondicion.setInternalname( "CONTLCONDICION_"+sGXsfl_108_fel_idx );
      edtConTLConHab_Internalname = "CONTLCONHAB_"+sGXsfl_108_fel_idx ;
      cmbConTLTipoCon.setInternalname( "CONTLTIPOCON_"+sGXsfl_108_fel_idx );
      cmbCONTLSegPla.setInternalname( "CONTLSEGPLA_"+sGXsfl_108_fel_idx );
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_fel_idx ;
   }

   public void sendrow_1082( )
   {
      subsflControlProps_1082( ) ;
      wbIQ0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCliCod_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCliCod_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCodigo_Internalname,GXutil.rtrim( A26ConCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtTLiqCod_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTLiqCod_Internalname,GXutil.rtrim( A32TLiqCod),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTLiqCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtTLiqCod_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConTLOrdejec_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConTLOrdejec_Internalname,GXutil.ltrim( localUtil.ntoc( A1406ConTLOrdejec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1406ConTLOrdejec), "ZZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConTLOrdejec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConTLOrdejec_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConTLVigencia.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConTLVigencia.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONTLVIGENCIA_" + sGXsfl_108_idx ;
            cmbConTLVigencia.setName( GXCCtl );
            cmbConTLVigencia.setWebtags( "" );
            cmbConTLVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
            cmbConTLVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
            if ( cmbConTLVigencia.getItemCount() > 0 )
            {
               A1409ConTLVigencia = (byte)(GXutil.lval( cmbConTLVigencia.getValidValue(GXutil.trim( GXutil.str( A1409ConTLVigencia, 1, 0))))) ;
               n1409ConTLVigencia = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConTLVigencia,cmbConTLVigencia.getInternalname(),GXutil.trim( GXutil.str( A1409ConTLVigencia, 1, 0)),Integer.valueOf(1),cmbConTLVigencia.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConTLVigencia.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConTLVigencia.setValue( GXutil.trim( GXutil.str( A1409ConTLVigencia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConTLVigencia.getInternalname(), "Values", cmbConTLVigencia.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbConTLCondicion.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConTLCondicion.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONTLCONDICION_" + sGXsfl_108_idx ;
            cmbConTLCondicion.setName( GXCCtl );
            cmbConTLCondicion.setWebtags( "" );
            cmbConTLCondicion.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
            cmbConTLCondicion.addItem("A0", httpContext.getMessage( "Siempre", ""), (short)(0));
            cmbConTLCondicion.addItem("A1", httpContext.getMessage( "Se ingresó por novedad el concepto de código relacionado a la condición", ""), (short)(0));
            cmbConTLCondicion.addItem("A3", httpContext.getMessage( "Trabajador no es Jubilado y aplica a liquidación de aportes", ""), (short)(0));
            cmbConTLCondicion.addItem("A4", httpContext.getMessage( "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto", ""), (short)(0));
            cmbConTLCondicion.addItem("A5", httpContext.getMessage( "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)", ""), (short)(0));
            cmbConTLCondicion.addItem("A8", httpContext.getMessage( "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior", ""), (short)(0));
            cmbConTLCondicion.addItem("A9", httpContext.getMessage( "Tiene familiares adherentes a la obra social", ""), (short)(0));
            cmbConTLCondicion.addItem("A10", httpContext.getMessage( "Tiene Sindicato", ""), (short)(0));
            cmbConTLCondicion.addItem("A11", httpContext.getMessage( "Tiene jornada parcial", ""), (short)(0));
            cmbConTLCondicion.addItem("A12", httpContext.getMessage( "Obra social tiene aporte adicional", ""), (short)(0));
            cmbConTLCondicion.addItem("A13", httpContext.getMessage( "Empleador es agente de retención", ""), (short)(0));
            cmbConTLCondicion.addItem("A14", httpContext.getMessage( "El empleador es agente de retención y el empleado es alcanzado por ganancias", ""), (short)(0));
            cmbConTLCondicion.addItem("B1", httpContext.getMessage( "Legajo tiene cargado licencia igual al código  relacionado a la condición", ""), (short)(0));
            cmbConTLCondicion.addItem("B2", httpContext.getMessage( "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición", ""), (short)(0));
            cmbConTLCondicion.addItem("B3", httpContext.getMessage( "Tiene obligación activa de igual al código relacionado a la condición", ""), (short)(0));
            cmbConTLCondicion.addItem("B4", httpContext.getMessage( "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
            cmbConTLCondicion.addItem("B5", httpContext.getMessage( "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados", ""), (short)(0));
            cmbConTLCondicion.addItem("B6", httpContext.getMessage( "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados", ""), (short)(0));
            cmbConTLCondicion.addItem("B7", httpContext.getMessage( "El legajo es empleado mensual y hay licencia sin goce de sueldo", ""), (short)(0));
            cmbConTLCondicion.addItem("B9", httpContext.getMessage( "Es egreso y no maneja fondo de cese laboral", ""), (short)(0));
            cmbConTLCondicion.addItem("B10", httpContext.getMessage( "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.", ""), (short)(0));
            cmbConTLCondicion.addItem("B11", httpContext.getMessage( "Liquida sac o alcanza ganancias", ""), (short)(0));
            cmbConTLCondicion.addItem("B12", httpContext.getMessage( "Empresa o convenio liquidan antiguedad", ""), (short)(0));
            cmbConTLCondicion.addItem("B13", httpContext.getMessage( "Empresa o convenio liquidan presentismo", ""), (short)(0));
            cmbConTLCondicion.addItem("B14", httpContext.getMessage( "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición", ""), (short)(0));
            cmbConTLCondicion.addItem("B15", httpContext.getMessage( "Legajo tiene cargado hijo o hija con asignación de servicio de guardería", ""), (short)(0));
            cmbConTLCondicion.addItem("N01", httpContext.getMessage( "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)", ""), (short)(0));
            cmbConTLCondicion.addItem("B16", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo", ""), (short)(0));
            cmbConTLCondicion.addItem("B19", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
            cmbConTLCondicion.addItem("B20", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
            cmbConTLCondicion.addItem("B21", httpContext.getMessage( "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo", ""), (short)(0));
            cmbConTLCondicion.addItem("B22", httpContext.getMessage( "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo", ""), (short)(0));
            cmbConTLCondicion.addItem("B23", httpContext.getMessage( "Legajo tiene asignado tìtulo igual al código relacionado a la condición", ""), (short)(0));
            cmbConTLCondicion.addItem("B24", httpContext.getMessage( "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable", ""), (short)(0));
            cmbConTLCondicion.addItem("VP", httpContext.getMessage( "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
            cmbConTLCondicion.addItem("AI", httpContext.getMessage( "Legajo es de clase mensual y tiene cargadas ausencias injustificadas", ""), (short)(0));
            cmbConTLCondicion.addItem("R1", httpContext.getMessage( "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo", ""), (short)(0));
            cmbConTLCondicion.addItem("MI", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes", ""), (short)(0));
            cmbConTLCondicion.addItem("H1", httpContext.getMessage( "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano", ""), (short)(0));
            cmbConTLCondicion.addItem("LA", httpContext.getMessage( "Legajo aplica a liquidación de aportes", ""), (short)(0));
            cmbConTLCondicion.addItem("GU", httpContext.getMessage( "Legajo tiene configurado grossing up", ""), (short)(0));
            if ( cmbConTLCondicion.getItemCount() > 0 )
            {
               A1410ConTLCondicion = cmbConTLCondicion.getValidValue(A1410ConTLCondicion) ;
               n1410ConTLCondicion = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConTLCondicion,cmbConTLCondicion.getInternalname(),GXutil.rtrim( A1410ConTLCondicion),Integer.valueOf(1),cmbConTLCondicion.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbConTLCondicion.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConTLCondicion.setValue( GXutil.rtrim( A1410ConTLCondicion) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConTLCondicion.getInternalname(), "Values", cmbConTLCondicion.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConTLConHab_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConTLConHab_Internalname,GXutil.ltrim( localUtil.ntoc( A1470ConTLConHab, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1470ConTLConHab), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConTLConHab_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConTLConHab_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbConTLTipoCon.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConTLTipoCon.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONTLTIPOCON_" + sGXsfl_108_idx ;
            cmbConTLTipoCon.setName( GXCCtl );
            cmbConTLTipoCon.setWebtags( "" );
            cmbConTLTipoCon.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
            cmbConTLTipoCon.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
            cmbConTLTipoCon.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
            cmbConTLTipoCon.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
            if ( cmbConTLTipoCon.getItemCount() > 0 )
            {
               A1788ConTLTipoCon = cmbConTLTipoCon.getValidValue(A1788ConTLTipoCon) ;
               n1788ConTLTipoCon = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConTLTipoCon,cmbConTLTipoCon.getInternalname(),GXutil.rtrim( A1788ConTLTipoCon),Integer.valueOf(1),cmbConTLTipoCon.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbConTLTipoCon.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConTLTipoCon.setValue( GXutil.rtrim( A1788ConTLTipoCon) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConTLTipoCon.getInternalname(), "Values", cmbConTLTipoCon.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbCONTLSegPla.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbCONTLSegPla.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONTLSEGPLA_" + sGXsfl_108_idx ;
            cmbCONTLSegPla.setName( GXCCtl );
            cmbCONTLSegPla.setWebtags( "" );
            cmbCONTLSegPla.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbCONTLSegPla.addItem("1", httpContext.getMessage( "Sì", ""), (short)(0));
            cmbCONTLSegPla.addItem("2", httpContext.getMessage( "Si la empresa es agente de retención de ganancias", ""), (short)(0));
            cmbCONTLSegPla.addItem("3", httpContext.getMessage( "Si se liquida SAC o si la empresa es agente de retención de ganancias", ""), (short)(0));
            if ( cmbCONTLSegPla.getItemCount() > 0 )
            {
               A1789CONTLSegPla = (byte)(GXutil.lval( cmbCONTLSegPla.getValidValue(GXutil.trim( GXutil.str( A1789CONTLSegPla, 1, 0))))) ;
               n1789CONTLSegPla = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCONTLSegPla,cmbCONTLSegPla.getInternalname(),GXutil.trim( GXutil.str( A1789CONTLSegPla, 1, 0)),Integer.valueOf(1),cmbCONTLSegPla.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbCONTLSegPla.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbCONTLSegPla.setValue( GXutil.trim( GXutil.str( A1789CONTLSegPla, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCONTLSegPla.getInternalname(), "Values", cmbCONTLSegPla.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV53Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV52VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesIQ2( ) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCliCod_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cod", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtTLiqCod_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de Liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConTLOrdejec_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "TLOrdejec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConTLVigencia.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "TLVigencia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConTLCondicion.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "TLCondicion", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConTLConHab_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "TLCon Hab", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConTLTipoCon.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "TLTipo Con", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbCONTLSegPla.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Pla", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCliCod_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A26ConCodigo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A32TLiqCod));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtTLiqCod_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1406ConTLOrdejec, (byte)(12), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConTLOrdejec_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1409ConTLVigencia, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConTLVigencia.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1410ConTLCondicion));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConTLCondicion.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1470ConTLConHab, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConTLConHab_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1788ConTLTipoCon));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConTLTipoCon.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1789CONTLSegPla, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbCONTLSegPla.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV53Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV52VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
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
      edtConCodigo_Internalname = "CONCODIGO" ;
      edtTLiqCod_Internalname = "TLIQCOD" ;
      edtConTLOrdejec_Internalname = "CONTLORDEJEC" ;
      cmbConTLVigencia.setInternalname( "CONTLVIGENCIA" );
      cmbConTLCondicion.setInternalname( "CONTLCONDICION" );
      edtConTLConHab_Internalname = "CONTLCONHAB" ;
      cmbConTLTipoCon.setInternalname( "CONTLTIPOCON" );
      cmbCONTLSegPla.setInternalname( "CONTLSEGPLA" );
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavVersvg_Internalname = "vVERSVG" ;
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
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 0 ;
      edtavVersvg_Format = (short)(0) ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 0 ;
      edtavDisplay_Visible = -1 ;
      cmbCONTLSegPla.setJsonclick( "" );
      cmbConTLTipoCon.setJsonclick( "" );
      edtConTLConHab_Jsonclick = "" ;
      cmbConTLCondicion.setJsonclick( "" );
      cmbConTLVigencia.setJsonclick( "" );
      edtConTLOrdejec_Jsonclick = "" ;
      edtTLiqCod_Jsonclick = "" ;
      edtConCodigo_Jsonclick = "" ;
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
      edtavDisplay_Link = "" ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      edtavVersvg_Visible = -1 ;
      cmbCONTLSegPla.setVisible( -1 );
      cmbConTLTipoCon.setVisible( -1 );
      edtConTLConHab_Visible = -1 ;
      cmbConTLCondicion.setVisible( -1 );
      cmbConTLVigencia.setVisible( -1 );
      edtConTLOrdejec_Visible = -1 ;
      edtTLiqCod_Visible = -1 ;
      edtConCodigo_Visible = -1 ;
      edtCliCod_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "6.0|||12.0|1.0||1.0||1.0" ;
      Ddo_grid_Datalistproc = "ConceptoTipoLiquidacionWWGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "|T|T|||T||T|" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic|||Dynamic (with fixedValues)||Dynamic (with fixedValues)|" ;
      Ddo_grid_Includedatalist = "|T|T|||T||T|" ;
      Ddo_grid_Filterisrange = "T|||T|T||T||T" ;
      Ddo_grid_Filtertype = "Numeric|Character|Character|Numeric|Numeric|Character|Numeric|Character|Numeric" ;
      Ddo_grid_Includefilter = "T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8|9" ;
      Ddo_grid_Columnids = "0:CliCod|1:ConCodigo|2:TLiqCod|3:ConTLOrdejec|4:ConTLVigencia|5:ConTLCondicion|6:ConTLConHab|7:ConTLTipoCon|8:CONTLSegPla" ;
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
      Form.setCaption( httpContext.getMessage( " Concepto Tipo Liquidacion", "") );
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
      AV56WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV56WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56WelcomeMessage_NoMostrarMas", AV56WelcomeMessage_NoMostrarMas);
      GXCCtl = "CONTLVIGENCIA_" + sGXsfl_108_idx ;
      cmbConTLVigencia.setName( GXCCtl );
      cmbConTLVigencia.setWebtags( "" );
      cmbConTLVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
      cmbConTLVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
      if ( cmbConTLVigencia.getItemCount() > 0 )
      {
         A1409ConTLVigencia = (byte)(GXutil.lval( cmbConTLVigencia.getValidValue(GXutil.trim( GXutil.str( A1409ConTLVigencia, 1, 0))))) ;
         n1409ConTLVigencia = false ;
      }
      GXCCtl = "CONTLCONDICION_" + sGXsfl_108_idx ;
      cmbConTLCondicion.setName( GXCCtl );
      cmbConTLCondicion.setWebtags( "" );
      cmbConTLCondicion.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbConTLCondicion.addItem("A0", httpContext.getMessage( "Siempre", ""), (short)(0));
      cmbConTLCondicion.addItem("A1", httpContext.getMessage( "Se ingresó por novedad el concepto de código relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("A3", httpContext.getMessage( "Trabajador no es Jubilado y aplica a liquidación de aportes", ""), (short)(0));
      cmbConTLCondicion.addItem("A4", httpContext.getMessage( "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto", ""), (short)(0));
      cmbConTLCondicion.addItem("A5", httpContext.getMessage( "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)", ""), (short)(0));
      cmbConTLCondicion.addItem("A8", httpContext.getMessage( "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior", ""), (short)(0));
      cmbConTLCondicion.addItem("A9", httpContext.getMessage( "Tiene familiares adherentes a la obra social", ""), (short)(0));
      cmbConTLCondicion.addItem("A10", httpContext.getMessage( "Tiene Sindicato", ""), (short)(0));
      cmbConTLCondicion.addItem("A11", httpContext.getMessage( "Tiene jornada parcial", ""), (short)(0));
      cmbConTLCondicion.addItem("A12", httpContext.getMessage( "Obra social tiene aporte adicional", ""), (short)(0));
      cmbConTLCondicion.addItem("A13", httpContext.getMessage( "Empleador es agente de retención", ""), (short)(0));
      cmbConTLCondicion.addItem("A14", httpContext.getMessage( "El empleador es agente de retención y el empleado es alcanzado por ganancias", ""), (short)(0));
      cmbConTLCondicion.addItem("B1", httpContext.getMessage( "Legajo tiene cargado licencia igual al código  relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("B2", httpContext.getMessage( "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("B3", httpContext.getMessage( "Tiene obligación activa de igual al código relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("B4", httpContext.getMessage( "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbConTLCondicion.addItem("B5", httpContext.getMessage( "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbConTLCondicion.addItem("B6", httpContext.getMessage( "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbConTLCondicion.addItem("B7", httpContext.getMessage( "El legajo es empleado mensual y hay licencia sin goce de sueldo", ""), (short)(0));
      cmbConTLCondicion.addItem("B9", httpContext.getMessage( "Es egreso y no maneja fondo de cese laboral", ""), (short)(0));
      cmbConTLCondicion.addItem("B10", httpContext.getMessage( "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.", ""), (short)(0));
      cmbConTLCondicion.addItem("B11", httpContext.getMessage( "Liquida sac o alcanza ganancias", ""), (short)(0));
      cmbConTLCondicion.addItem("B12", httpContext.getMessage( "Empresa o convenio liquidan antiguedad", ""), (short)(0));
      cmbConTLCondicion.addItem("B13", httpContext.getMessage( "Empresa o convenio liquidan presentismo", ""), (short)(0));
      cmbConTLCondicion.addItem("B14", httpContext.getMessage( "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("B15", httpContext.getMessage( "Legajo tiene cargado hijo o hija con asignación de servicio de guardería", ""), (short)(0));
      cmbConTLCondicion.addItem("N01", httpContext.getMessage( "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)", ""), (short)(0));
      cmbConTLCondicion.addItem("B16", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo", ""), (short)(0));
      cmbConTLCondicion.addItem("B19", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbConTLCondicion.addItem("B20", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbConTLCondicion.addItem("B21", httpContext.getMessage( "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo", ""), (short)(0));
      cmbConTLCondicion.addItem("B22", httpContext.getMessage( "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo", ""), (short)(0));
      cmbConTLCondicion.addItem("B23", httpContext.getMessage( "Legajo tiene asignado tìtulo igual al código relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("B24", httpContext.getMessage( "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable", ""), (short)(0));
      cmbConTLCondicion.addItem("VP", httpContext.getMessage( "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbConTLCondicion.addItem("AI", httpContext.getMessage( "Legajo es de clase mensual y tiene cargadas ausencias injustificadas", ""), (short)(0));
      cmbConTLCondicion.addItem("R1", httpContext.getMessage( "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo", ""), (short)(0));
      cmbConTLCondicion.addItem("MI", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes", ""), (short)(0));
      cmbConTLCondicion.addItem("H1", httpContext.getMessage( "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano", ""), (short)(0));
      cmbConTLCondicion.addItem("LA", httpContext.getMessage( "Legajo aplica a liquidación de aportes", ""), (short)(0));
      cmbConTLCondicion.addItem("GU", httpContext.getMessage( "Legajo tiene configurado grossing up", ""), (short)(0));
      if ( cmbConTLCondicion.getItemCount() > 0 )
      {
         A1410ConTLCondicion = cmbConTLCondicion.getValidValue(A1410ConTLCondicion) ;
         n1410ConTLCondicion = false ;
      }
      GXCCtl = "CONTLTIPOCON_" + sGXsfl_108_idx ;
      cmbConTLTipoCon.setName( GXCCtl );
      cmbConTLTipoCon.setWebtags( "" );
      cmbConTLTipoCon.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbConTLTipoCon.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbConTLTipoCon.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbConTLTipoCon.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbConTLTipoCon.getItemCount() > 0 )
      {
         A1788ConTLTipoCon = cmbConTLTipoCon.getValidValue(A1788ConTLTipoCon) ;
         n1788ConTLTipoCon = false ;
      }
      GXCCtl = "CONTLSEGPLA_" + sGXsfl_108_idx ;
      cmbCONTLSegPla.setName( GXCCtl );
      cmbCONTLSegPla.setWebtags( "" );
      cmbCONTLSegPla.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbCONTLSegPla.addItem("1", httpContext.getMessage( "Sì", ""), (short)(0));
      cmbCONTLSegPla.addItem("2", httpContext.getMessage( "Si la empresa es agente de retención de ganancias", ""), (short)(0));
      cmbCONTLSegPla.addItem("3", httpContext.getMessage( "Si se liquida SAC o si la empresa es agente de retención de ganancias", ""), (short)(0));
      if ( cmbCONTLSegPla.getItemCount() > 0 )
      {
         A1789CONTLSegPla = (byte)(GXutil.lval( cmbCONTLSegPla.getValidValue(GXutil.trim( GXutil.str( A1789CONTLSegPla, 1, 0))))) ;
         n1789CONTLSegPla = false ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV54MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFTLiqCod',fld:'vTFTLIQCOD',pic:''},{av:'AV31TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV32TFConTLOrdejec',fld:'vTFCONTLORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV33TFConTLOrdejec_To',fld:'vTFCONTLORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV37TFConTLCondicion_Sels',fld:'vTFCONTLCONDICION_SELS',pic:''},{av:'AV38TFConTLConHab',fld:'vTFCONTLCONHAB',pic:'9'},{av:'AV39TFConTLConHab_To',fld:'vTFCONTLCONHAB_TO',pic:'9'},{av:'AV49TFConTLTipoCon_Sels',fld:'vTFCONTLTIPOCON_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV56WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCliCod_Visible',ctrl:'CLICOD',prop:'Visible'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtTLiqCod_Visible',ctrl:'TLIQCOD',prop:'Visible'},{av:'edtConTLOrdejec_Visible',ctrl:'CONTLORDEJEC',prop:'Visible'},{av:'cmbConTLVigencia'},{av:'cmbConTLCondicion'},{av:'edtConTLConHab_Visible',ctrl:'CONTLCONHAB',prop:'Visible'},{av:'cmbConTLTipoCon'},{av:'cmbCONTLSegPla'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV42GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV43GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV44GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV63ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13IQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV54MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFTLiqCod',fld:'vTFTLIQCOD',pic:''},{av:'AV31TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV32TFConTLOrdejec',fld:'vTFCONTLORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV33TFConTLOrdejec_To',fld:'vTFCONTLORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV37TFConTLCondicion_Sels',fld:'vTFCONTLCONDICION_SELS',pic:''},{av:'AV38TFConTLConHab',fld:'vTFCONTLCONHAB',pic:'9'},{av:'AV39TFConTLConHab_To',fld:'vTFCONTLCONHAB_TO',pic:'9'},{av:'AV49TFConTLTipoCon_Sels',fld:'vTFCONTLTIPOCON_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV56WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14IQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV54MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFTLiqCod',fld:'vTFTLIQCOD',pic:''},{av:'AV31TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV32TFConTLOrdejec',fld:'vTFCONTLORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV33TFConTLOrdejec_To',fld:'vTFCONTLORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV37TFConTLCondicion_Sels',fld:'vTFCONTLCONDICION_SELS',pic:''},{av:'AV38TFConTLConHab',fld:'vTFCONTLCONHAB',pic:'9'},{av:'AV39TFConTLConHab_To',fld:'vTFCONTLCONHAB_TO',pic:'9'},{av:'AV49TFConTLTipoCon_Sels',fld:'vTFCONTLTIPOCON_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV56WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15IQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV54MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFTLiqCod',fld:'vTFTLIQCOD',pic:''},{av:'AV31TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV32TFConTLOrdejec',fld:'vTFCONTLORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV33TFConTLOrdejec_To',fld:'vTFCONTLORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV37TFConTLCondicion_Sels',fld:'vTFCONTLCONDICION_SELS',pic:''},{av:'AV38TFConTLConHab',fld:'vTFCONTLCONHAB',pic:'9'},{av:'AV39TFConTLConHab_To',fld:'vTFCONTLCONHAB_TO',pic:'9'},{av:'AV49TFConTLTipoCon_Sels',fld:'vTFCONTLTIPOCON_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV56WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV48TFConTLTipoCon_SelsJson',fld:'vTFCONTLTIPOCON_SELSJSON',pic:''},{av:'AV49TFConTLTipoCon_Sels',fld:'vTFCONTLTIPOCON_SELS',pic:''},{av:'AV38TFConTLConHab',fld:'vTFCONTLCONHAB',pic:'9'},{av:'AV39TFConTLConHab_To',fld:'vTFCONTLCONHAB_TO',pic:'9'},{av:'AV36TFConTLCondicion_SelsJson',fld:'vTFCONTLCONDICION_SELSJSON',pic:''},{av:'AV37TFConTLCondicion_Sels',fld:'vTFCONTLCONDICION_SELS',pic:''},{av:'AV32TFConTLOrdejec',fld:'vTFCONTLORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV33TFConTLOrdejec_To',fld:'vTFCONTLORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV30TFTLiqCod',fld:'vTFTLIQCOD',pic:''},{av:'AV29TFTLiqCod_SelsJson',fld:'vTFTLIQCOD_SELSJSON',pic:''},{av:'AV31TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV26TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e20IQ2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV53Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV52VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11IQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV54MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFTLiqCod',fld:'vTFTLIQCOD',pic:''},{av:'AV31TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV32TFConTLOrdejec',fld:'vTFCONTLORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV33TFConTLOrdejec_To',fld:'vTFCONTLORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV37TFConTLCondicion_Sels',fld:'vTFCONTLCONDICION_SELS',pic:''},{av:'AV38TFConTLConHab',fld:'vTFCONTLCONHAB',pic:'9'},{av:'AV39TFConTLConHab_To',fld:'vTFCONTLCONHAB_TO',pic:'9'},{av:'AV49TFConTLTipoCon_Sels',fld:'vTFCONTLTIPOCON_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV56WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtCliCod_Visible',ctrl:'CLICOD',prop:'Visible'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtTLiqCod_Visible',ctrl:'TLIQCOD',prop:'Visible'},{av:'edtConTLOrdejec_Visible',ctrl:'CONTLORDEJEC',prop:'Visible'},{av:'cmbConTLVigencia'},{av:'cmbConTLCondicion'},{av:'edtConTLConHab_Visible',ctrl:'CONTLCONHAB',prop:'Visible'},{av:'cmbConTLTipoCon'},{av:'cmbCONTLSegPla'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV42GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV43GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV44GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV63ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12IQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV54MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFTLiqCod',fld:'vTFTLIQCOD',pic:''},{av:'AV31TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV32TFConTLOrdejec',fld:'vTFCONTLORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV33TFConTLOrdejec_To',fld:'vTFCONTLORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV37TFConTLCondicion_Sels',fld:'vTFCONTLCONDICION_SELS',pic:''},{av:'AV38TFConTLConHab',fld:'vTFCONTLCONHAB',pic:'9'},{av:'AV39TFConTLConHab_To',fld:'vTFCONTLCONHAB_TO',pic:'9'},{av:'AV49TFConTLTipoCon_Sels',fld:'vTFCONTLTIPOCON_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV56WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV26TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV29TFTLiqCod_SelsJson',fld:'vTFTLIQCOD_SELSJSON',pic:''},{av:'AV36TFConTLCondicion_SelsJson',fld:'vTFCONTLCONDICION_SELSJSON',pic:''},{av:'AV48TFConTLTipoCon_SelsJson',fld:'vTFCONTLTIPOCON_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFTLiqCod',fld:'vTFTLIQCOD',pic:''},{av:'AV31TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV32TFConTLOrdejec',fld:'vTFCONTLORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV33TFConTLOrdejec_To',fld:'vTFCONTLORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV37TFConTLCondicion_Sels',fld:'vTFCONTLCONDICION_SELS',pic:''},{av:'AV38TFConTLConHab',fld:'vTFCONTLCONHAB',pic:'9'},{av:'AV39TFConTLConHab_To',fld:'vTFCONTLCONHAB_TO',pic:'9'},{av:'AV49TFConTLTipoCon_Sels',fld:'vTFCONTLTIPOCON_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV48TFConTLTipoCon_SelsJson',fld:'vTFCONTLTIPOCON_SELSJSON',pic:''},{av:'AV36TFConTLCondicion_SelsJson',fld:'vTFCONTLCONDICION_SELSJSON',pic:''},{av:'AV29TFTLiqCod_SelsJson',fld:'vTFTLIQCOD_SELSJSON',pic:''},{av:'AV26TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCliCod_Visible',ctrl:'CLICOD',prop:'Visible'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtTLiqCod_Visible',ctrl:'TLIQCOD',prop:'Visible'},{av:'edtConTLOrdejec_Visible',ctrl:'CONTLORDEJEC',prop:'Visible'},{av:'cmbConTLVigencia'},{av:'cmbConTLCondicion'},{av:'edtConTLConHab_Visible',ctrl:'CONTLCONHAB',prop:'Visible'},{av:'cmbConTLTipoCon'},{av:'cmbCONTLSegPla'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV42GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV43GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV44GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV63ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOEXPORT'","{handler:'e16IQ2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17IQ2',iparms:[{av:'AV56WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV54MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV46CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e21IQ1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'validv_Versvg',iparms:[]");
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
      wcpOAV54MenuOpcCod = "" ;
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
      AV54MenuOpcCod = "" ;
      AV21ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV78Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27TFConCodigo = "" ;
      AV28TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV30TFTLiqCod = "" ;
      AV31TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFConTLCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFConTLTipoCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV40DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV63ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV44GridAppliedFilters = "" ;
      AV26TFConCodigo_SelsJson = "" ;
      AV29TFTLiqCod_SelsJson = "" ;
      AV36TFConTLCondicion_SelsJson = "" ;
      AV48TFConTLTipoCon_SelsJson = "" ;
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
      A26ConCodigo = "" ;
      A32TLiqCod = "" ;
      A1410ConTLCondicion = "" ;
      A1788ConTLTipoCon = "" ;
      AV53Display = "" ;
      AV52VerSVG = "" ;
      AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV81Conceptotipoliquidacionwwds_3_tfconcodigo = "" ;
      lV83Conceptotipoliquidacionwwds_5_tftliqcod = "" ;
      AV81Conceptotipoliquidacionwwds_3_tfconcodigo = "" ;
      AV83Conceptotipoliquidacionwwds_5_tftliqcod = "" ;
      H00IQ2_A1789CONTLSegPla = new byte[1] ;
      H00IQ2_n1789CONTLSegPla = new boolean[] {false} ;
      H00IQ2_A1788ConTLTipoCon = new String[] {""} ;
      H00IQ2_n1788ConTLTipoCon = new boolean[] {false} ;
      H00IQ2_A1470ConTLConHab = new byte[1] ;
      H00IQ2_A1410ConTLCondicion = new String[] {""} ;
      H00IQ2_n1410ConTLCondicion = new boolean[] {false} ;
      H00IQ2_A1409ConTLVigencia = new byte[1] ;
      H00IQ2_n1409ConTLVigencia = new boolean[] {false} ;
      H00IQ2_A1406ConTLOrdejec = new long[1] ;
      H00IQ2_A32TLiqCod = new String[] {""} ;
      H00IQ2_A26ConCodigo = new String[] {""} ;
      H00IQ2_A3CliCod = new int[1] ;
      H00IQ3_AGRID_nRecordCount = new long[1] ;
      AV62WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV57MenuBienveImgURL = "" ;
      AV59MenuBienveTitulo = "" ;
      AV60MenuBienveTexto = "" ;
      AV77Welcomemessage_foto_GXI = "" ;
      AV74observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext11 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV19ColumnsSelectorXML = "" ;
      AV70MenuOpcTitulo = "" ;
      GXv_int12 = new short[1] ;
      AV73filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV64ManageFiltersXml = "" ;
      AV17ExcelFilename = "" ;
      AV18ErrorMessage = "" ;
      AV20UserCustomValue = "" ;
      AV22ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char10 = "" ;
      GXt_char9 = "" ;
      GXv_char6 = new String[1] ;
      GXv_char5 = new String[1] ;
      GXt_char18 = "" ;
      GXt_char17 = "" ;
      GXv_char7 = new String[1] ;
      GXv_SdtWWPGridState20 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV58textoNoMostrara = "" ;
      GXv_char19 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptotipoliquidacionww__default(),
         new Object[] {
             new Object[] {
            H00IQ2_A1789CONTLSegPla, H00IQ2_n1789CONTLSegPla, H00IQ2_A1788ConTLTipoCon, H00IQ2_n1788ConTLTipoCon, H00IQ2_A1470ConTLConHab, H00IQ2_A1410ConTLCondicion, H00IQ2_n1410ConTLCondicion, H00IQ2_A1409ConTLVigencia, H00IQ2_n1409ConTLVigencia, H00IQ2_A1406ConTLOrdejec,
            H00IQ2_A32TLiqCod, H00IQ2_A26ConCodigo, H00IQ2_A3CliCod
            }
            , new Object[] {
            H00IQ3_AGRID_nRecordCount
            }
         }
      );
      AV78Pgmname = "ConceptoTipoLiquidacionWW" ;
      /* GeneXus formulas. */
      AV78Pgmname = "ConceptoTipoLiquidacionWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV65ManageFiltersExecutionStep ;
   private byte AV38TFConTLConHab ;
   private byte AV39TFConTLConHab_To ;
   private byte gxajaxcallmode ;
   private byte A1409ConTLVigencia ;
   private byte A1470ConTLConHab ;
   private byte A1789CONTLSegPla ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV88Conceptotipoliquidacionwwds_10_tfcontlconhab ;
   private byte AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to ;
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
   private short GXv_int12[] ;
   private short edtavVersvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_108 ;
   private int nGXsfl_108_idx=1 ;
   private int AV24TFCliCod ;
   private int AV25TFCliCod_To ;
   private int AV46CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int subGrid_Islastpage ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size ;
   private int AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels_size ;
   private int AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size ;
   private int AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size ;
   private int AV79Conceptotipoliquidacionwwds_1_tfclicod ;
   private int AV80Conceptotipoliquidacionwwds_2_tfclicod_to ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtCliCod_Visible ;
   private int edtConCodigo_Visible ;
   private int edtTLiqCod_Visible ;
   private int edtConTLOrdejec_Visible ;
   private int edtConTLConHab_Visible ;
   private int edtavVersvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV72filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV41PageToGo ;
   private int edtavDisplay_Visible ;
   private int AV91GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV32TFConTLOrdejec ;
   private long AV33TFConTLOrdejec_To ;
   private long AV42GridCurrentPage ;
   private long AV43GridPageCount ;
   private long A1406ConTLOrdejec ;
   private long GRID_nCurrentRecord ;
   private long AV85Conceptotipoliquidacionwwds_7_tfcontlordejec ;
   private long AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to ;
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
   private String sGXsfl_108_idx="0001" ;
   private String AV78Pgmname ;
   private String AV27TFConCodigo ;
   private String AV30TFTLiqCod ;
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
   private String A26ConCodigo ;
   private String edtConCodigo_Internalname ;
   private String A32TLiqCod ;
   private String edtTLiqCod_Internalname ;
   private String edtConTLOrdejec_Internalname ;
   private String A1410ConTLCondicion ;
   private String edtConTLConHab_Internalname ;
   private String A1788ConTLTipoCon ;
   private String AV53Display ;
   private String edtavDisplay_Internalname ;
   private String AV52VerSVG ;
   private String edtavVersvg_Internalname ;
   private String scmdbuf ;
   private String lV81Conceptotipoliquidacionwwds_3_tfconcodigo ;
   private String lV83Conceptotipoliquidacionwwds_5_tftliqcod ;
   private String AV81Conceptotipoliquidacionwwds_3_tfconcodigo ;
   private String AV83Conceptotipoliquidacionwwds_5_tftliqcod ;
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
   private String AV74observerPalabra ;
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
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String GXt_char10 ;
   private String GXt_char9 ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String GXt_char18 ;
   private String GXt_char17 ;
   private String GXv_char7[] ;
   private String GXv_char19[] ;
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
   private String edtConCodigo_Jsonclick ;
   private String edtTLiqCod_Jsonclick ;
   private String edtConTLOrdejec_Jsonclick ;
   private String GXCCtl ;
   private String edtConTLConHab_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV56WelcomeMessage_NoMostrarMas ;
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
   private boolean n1409ConTLVigencia ;
   private boolean n1410ConTLCondicion ;
   private boolean n1788ConTLTipoCon ;
   private boolean n1789CONTLSegPla ;
   private boolean bGXsfl_108_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV61MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean GXv_boolean8[] ;
   private boolean AV62WelcomeMessage_Foto_IsBlob ;
   private String AV26TFConCodigo_SelsJson ;
   private String AV29TFTLiqCod_SelsJson ;
   private String AV36TFConTLCondicion_SelsJson ;
   private String AV48TFConTLTipoCon_SelsJson ;
   private String AV60MenuBienveTexto ;
   private String AV19ColumnsSelectorXML ;
   private String AV64ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV58textoNoMostrara ;
   private String wcpOAV54MenuOpcCod ;
   private String AV54MenuOpcCod ;
   private String AV44GridAppliedFilters ;
   private String AV57MenuBienveImgURL ;
   private String AV59MenuBienveTitulo ;
   private String AV77Welcomemessage_foto_GXI ;
   private String AV70MenuOpcTitulo ;
   private String AV73filtrosTexto ;
   private String AV17ExcelFilename ;
   private String AV18ErrorMessage ;
   private String AV62WelcomeMessage_Foto ;
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
   private GXSimpleCollection<String> AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels ;
   private GXSimpleCollection<String> AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ;
   private GXSimpleCollection<String> AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbConTLVigencia ;
   private HTMLChoice cmbConTLCondicion ;
   private HTMLChoice cmbConTLTipoCon ;
   private HTMLChoice cmbCONTLSegPla ;
   private IDataStoreProvider pr_default ;
   private byte[] H00IQ2_A1789CONTLSegPla ;
   private boolean[] H00IQ2_n1789CONTLSegPla ;
   private String[] H00IQ2_A1788ConTLTipoCon ;
   private boolean[] H00IQ2_n1788ConTLTipoCon ;
   private byte[] H00IQ2_A1470ConTLConHab ;
   private String[] H00IQ2_A1410ConTLCondicion ;
   private boolean[] H00IQ2_n1410ConTLCondicion ;
   private byte[] H00IQ2_A1409ConTLVigencia ;
   private boolean[] H00IQ2_n1409ConTLVigencia ;
   private long[] H00IQ2_A1406ConTLOrdejec ;
   private String[] H00IQ2_A32TLiqCod ;
   private String[] H00IQ2_A26ConCodigo ;
   private int[] H00IQ2_A3CliCod ;
   private long[] H00IQ3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV28TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV31TFTLiqCod_Sels ;
   private GXSimpleCollection<String> AV37TFConTLCondicion_Sels ;
   private GXSimpleCollection<String> AV49TFConTLTipoCon_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV63ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item16[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext11[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState20[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV40DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class conceptotipoliquidacionww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00IQ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                          String A1410ConTLCondicion ,
                                          GXSimpleCollection<String> AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                          String A1788ConTLTipoCon ,
                                          GXSimpleCollection<String> AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                          int AV79Conceptotipoliquidacionwwds_1_tfclicod ,
                                          int AV80Conceptotipoliquidacionwwds_2_tfclicod_to ,
                                          int AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size ,
                                          String AV81Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                          int AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels_size ,
                                          String AV83Conceptotipoliquidacionwwds_5_tftliqcod ,
                                          long AV85Conceptotipoliquidacionwwds_7_tfcontlordejec ,
                                          long AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to ,
                                          int AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size ,
                                          byte AV88Conceptotipoliquidacionwwds_10_tfcontlconhab ,
                                          byte AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to ,
                                          int AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size ,
                                          int A3CliCod ,
                                          long A1406ConTLOrdejec ,
                                          byte A1470ConTLConHab ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[11];
      Object[] GXv_Object22 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " CONTLSegPla, ConTLTipoCon, ConTLConHab, ConTLCondicion, ConTLVigencia, ConTLOrdejec, TLiqCod, ConCodigo, CliCod" ;
      sFromString = " FROM ConceptoTipoLiquidacion" ;
      sOrderString = "" ;
      if ( ! (0==AV79Conceptotipoliquidacionwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int21[0] = (byte)(1) ;
      }
      if ( ! (0==AV80Conceptotipoliquidacionwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int21[1] = (byte)(1) ;
      }
      if ( ( AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81Conceptotipoliquidacionwwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int21[2] = (byte)(1) ;
      }
      if ( AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV83Conceptotipoliquidacionwwds_5_tftliqcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCod) like LOWER(?))");
      }
      else
      {
         GXv_int21[3] = (byte)(1) ;
      }
      if ( AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels, "TLiqCod IN (", ")")+")");
      }
      if ( ! (0==AV85Conceptotipoliquidacionwwds_7_tfcontlordejec) )
      {
         addWhere(sWhereString, "(ConTLOrdejec >= ?)");
      }
      else
      {
         GXv_int21[4] = (byte)(1) ;
      }
      if ( ! (0==AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to) )
      {
         addWhere(sWhereString, "(ConTLOrdejec <= ?)");
      }
      else
      {
         GXv_int21[5] = (byte)(1) ;
      }
      if ( AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels, "ConTLCondicion IN (", ")")+")");
      }
      if ( ! (0==AV88Conceptotipoliquidacionwwds_10_tfcontlconhab) )
      {
         addWhere(sWhereString, "(ConTLConHab >= ?)");
      }
      else
      {
         GXv_int21[6] = (byte)(1) ;
      }
      if ( ! (0==AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to) )
      {
         addWhere(sWhereString, "(ConTLConHab <= ?)");
      }
      else
      {
         GXv_int21[7] = (byte)(1) ;
      }
      if ( AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels, "ConTLTipoCon IN (", ")")+")");
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConCodigo, CliCod, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConCodigo DESC, CliCod, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY TLiqCod, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY TLiqCod DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConTLOrdejec, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConTLOrdejec DESC, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConTLVigencia, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConTLVigencia DESC, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConTLCondicion, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConTLCondicion DESC, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConTLConHab, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConTLConHab DESC, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConTLTipoCon, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConTLTipoCon DESC, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CONTLSegPla, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CONTLSegPla DESC, CliCod, ConCodigo, TLiqCod" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, ConCodigo, TLiqCod" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
   }

   protected Object[] conditional_H00IQ3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                          String A1410ConTLCondicion ,
                                          GXSimpleCollection<String> AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                          String A1788ConTLTipoCon ,
                                          GXSimpleCollection<String> AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                          int AV79Conceptotipoliquidacionwwds_1_tfclicod ,
                                          int AV80Conceptotipoliquidacionwwds_2_tfclicod_to ,
                                          int AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size ,
                                          String AV81Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                          int AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels_size ,
                                          String AV83Conceptotipoliquidacionwwds_5_tftliqcod ,
                                          long AV85Conceptotipoliquidacionwwds_7_tfcontlordejec ,
                                          long AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to ,
                                          int AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size ,
                                          byte AV88Conceptotipoliquidacionwwds_10_tfcontlconhab ,
                                          byte AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to ,
                                          int AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size ,
                                          int A3CliCod ,
                                          long A1406ConTLOrdejec ,
                                          byte A1470ConTLConHab ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int24 = new byte[8];
      Object[] GXv_Object25 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ConceptoTipoLiquidacion" ;
      if ( ! (0==AV79Conceptotipoliquidacionwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int24[0] = (byte)(1) ;
      }
      if ( ! (0==AV80Conceptotipoliquidacionwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int24[1] = (byte)(1) ;
      }
      if ( ( AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81Conceptotipoliquidacionwwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int24[2] = (byte)(1) ;
      }
      if ( AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82Conceptotipoliquidacionwwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV83Conceptotipoliquidacionwwds_5_tftliqcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCod) like LOWER(?))");
      }
      else
      {
         GXv_int24[3] = (byte)(1) ;
      }
      if ( AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Conceptotipoliquidacionwwds_6_tftliqcod_sels, "TLiqCod IN (", ")")+")");
      }
      if ( ! (0==AV85Conceptotipoliquidacionwwds_7_tfcontlordejec) )
      {
         addWhere(sWhereString, "(ConTLOrdejec >= ?)");
      }
      else
      {
         GXv_int24[4] = (byte)(1) ;
      }
      if ( ! (0==AV86Conceptotipoliquidacionwwds_8_tfcontlordejec_to) )
      {
         addWhere(sWhereString, "(ConTLOrdejec <= ?)");
      }
      else
      {
         GXv_int24[5] = (byte)(1) ;
      }
      if ( AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels, "ConTLCondicion IN (", ")")+")");
      }
      if ( ! (0==AV88Conceptotipoliquidacionwwds_10_tfcontlconhab) )
      {
         addWhere(sWhereString, "(ConTLConHab >= ?)");
      }
      else
      {
         GXv_int24[6] = (byte)(1) ;
      }
      if ( ! (0==AV89Conceptotipoliquidacionwwds_11_tfcontlconhab_to) )
      {
         addWhere(sWhereString, "(ConTLConHab <= ?)");
      }
      else
      {
         GXv_int24[7] = (byte)(1) ;
      }
      if ( AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Conceptotipoliquidacionwwds_12_tfcontltipocon_sels, "ConTLTipoCon IN (", ")")+")");
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
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object25[0] = scmdbuf ;
      GXv_Object25[1] = GXv_int24 ;
      return GXv_Object25 ;
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
                  return conditional_H00IQ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , ((Number) dynConstraints[15]).longValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).longValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() );
            case 1 :
                  return conditional_H00IQ3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , ((Number) dynConstraints[15]).longValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).longValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00IQ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00IQ3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((byte[]) buf[4])[0] = rslt.getByte(3);
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((long[]) buf[9])[0] = rslt.getLong(6);
               ((String[]) buf[10])[0] = rslt.getString(7, 20);
               ((String[]) buf[11])[0] = rslt.getString(8, 10);
               ((int[]) buf[12])[0] = rslt.getInt(9);
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
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[15]).longValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[16]).longValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[17]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[18]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[12]).longValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[13]).longValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               return;
      }
   }

}

