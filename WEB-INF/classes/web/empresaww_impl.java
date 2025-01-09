package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresaww_impl extends GXDataArea
{
   public empresaww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresaww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresaww_impl.class ));
   }

   public empresaww_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
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
            AV113MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV113MenuOpcCod", AV113MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV113MenuOpcCod, ""))));
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
      AV124ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV20ColumnsSelector);
      AV137Pgmname = httpContext.GetPar( "Pgmname") ;
      AV113MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV11GridState);
      AV25TFEmpNom = httpContext.GetPar( "TFEmpNom") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV69TFEmpNom_Sels);
      AV27TFEmpCUIT = GXutil.lval( httpContext.GetPar( "TFEmpCUIT")) ;
      AV108TFEmpCUIT_To = GXutil.lval( httpContext.GetPar( "TFEmpCUIT_To")) ;
      AV53TFActDescrip = httpContext.GetPar( "TFActDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV87TFActDescrip_Sels);
      AV59TFTipEmpleDescri = httpContext.GetPar( "TFTipEmpleDescri") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV91TFTipEmpleDescri_Sels);
      AV100TFEmpZonDescrip = httpContext.GetPar( "TFEmpZonDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV101TFEmpZonDescrip_Sels);
      AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV92CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV115WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV124ManageFiltersExecutionStep, AV20ColumnsSelector, AV137Pgmname, AV113MenuOpcCod, AV11GridState, AV25TFEmpNom, AV69TFEmpNom_Sels, AV27TFEmpCUIT, AV108TFEmpCUIT_To, AV53TFActDescrip, AV87TFActDescrip_Sels, AV59TFTipEmpleDescri, AV91TFTipEmpleDescri_Sels, AV100TFEmpZonDescrip, AV101TFEmpZonDescrip_Sels, AV13OrderedBy, AV14OrderedDsc, AV92CliCod, AV115WelcomeMessage_NoMostrarMas) ;
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
      pa2H2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2H2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empresaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV113MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV137Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV113MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV92CliCod), "ZZZZZ9")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV61DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV61DDO_TitleSettingsIcons);
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV122ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV122ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV63GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV64GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV65GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV124ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV137Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV137Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV113MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV113MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPNOM", AV25TFEmpNom);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFEMPNOM_SELS", AV69TFEmpNom_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFEMPNOM_SELS", AV69TFEmpNom_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPCUIT", GXutil.ltrim( localUtil.ntoc( AV27TFEmpCUIT, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPCUIT_TO", GXutil.ltrim( localUtil.ntoc( AV108TFEmpCUIT_To, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFACTDESCRIP", AV53TFActDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFACTDESCRIP_SELS", AV87TFActDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFACTDESCRIP_SELS", AV87TFActDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTIPEMPLEDESCRI", AV59TFTipEmpleDescri);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFTIPEMPLEDESCRI_SELS", AV91TFTipEmpleDescri_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFTIPEMPLEDESCRI_SELS", AV91TFTipEmpleDescri_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPZONDESCRIP", AV100TFEmpZonDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFEMPZONDESCRIP_SELS", AV101TFEmpZonDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFEMPZONDESCRIP_SELS", AV101TFEmpZonDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV92CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV92CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPNOM_SELSJSON", AV68TFEmpNom_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFACTDESCRIP_SELSJSON", AV86TFActDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTIPEMPLEDESCRI_SELSJSON", AV90TFTipEmpleDescri_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMPZONDESCRIP_SELSJSON", AV99TFEmpZonDescrip_SelsJson);
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
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
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
         we2H2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2H2( ) ;
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
      return formatLink("web.empresaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV113MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "EmpresaWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Empresas", "") ;
   }

   public void wb2H0( )
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
         wb_table1_9_2H2( true) ;
      }
      else
      {
         wb_table1_9_2H2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_2H2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV61DDO_TitleSettingsIcons);
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

   public void start2H2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Empresas", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2H0( ) ;
   }

   public void ws2H2( )
   {
      start2H2( ) ;
      evt2H2( ) ;
   }

   public void evt2H2( )
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
                           e112H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e162H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e172H2 ();
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
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2EmpNom = GXutil.upper( httpContext.cgiGet( edtEmpNom_Internalname)) ;
                           A177EmpCUIT = localUtil.ctol( httpContext.cgiGet( edtEmpCUIT_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A108ActDescrip = httpContext.cgiGet( edtActDescrip_Internalname) ;
                           A339TipEmpleDescri = httpContext.cgiGet( edtTipEmpleDescri_Internalname) ;
                           A518EmpZonDescrip = httpContext.cgiGet( edtEmpZonDescrip_Internalname) ;
                           AV105Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV105Update);
                           AV106Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV106Delete);
                           AV112Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV112Display);
                           AV109VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV109VerSVG);
                           AV110ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV110ModificarSVG);
                           AV111EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV111EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e182H2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e192H2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e202H2 ();
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

   public void we2H2( )
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

   public void pa2H2( )
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
                                 byte AV124ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelector ,
                                 String AV137Pgmname ,
                                 String AV113MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV11GridState ,
                                 String AV25TFEmpNom ,
                                 GXSimpleCollection<String> AV69TFEmpNom_Sels ,
                                 long AV27TFEmpCUIT ,
                                 long AV108TFEmpCUIT_To ,
                                 String AV53TFActDescrip ,
                                 GXSimpleCollection<String> AV87TFActDescrip_Sels ,
                                 String AV59TFTipEmpleDescri ,
                                 GXSimpleCollection<String> AV91TFTipEmpleDescri_Sels ,
                                 String AV100TFEmpZonDescrip ,
                                 GXSimpleCollection<String> AV101TFEmpZonDescrip_Sels ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 int AV92CliCod ,
                                 boolean AV115WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e192H2 ();
      GRID_nCurrentRecord = 0 ;
      rf2H2( ) ;
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
      AV115WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV115WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV115WelcomeMessage_NoMostrarMas", AV115WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2H2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV137Pgmname = "EmpresaWW" ;
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

   public void rf2H2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e192H2 ();
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
                                              A2EmpNom ,
                                              AV139Empresawwds_2_tfempnom_sels ,
                                              A108ActDescrip ,
                                              AV143Empresawwds_6_tfactdescrip_sels ,
                                              A339TipEmpleDescri ,
                                              AV145Empresawwds_8_tftipempledescri_sels ,
                                              A518EmpZonDescrip ,
                                              AV147Empresawwds_10_tfempzondescrip_sels ,
                                              Integer.valueOf(AV139Empresawwds_2_tfempnom_sels.size()) ,
                                              AV138Empresawwds_1_tfempnom ,
                                              Long.valueOf(AV140Empresawwds_3_tfempcuit) ,
                                              Long.valueOf(AV141Empresawwds_4_tfempcuit_to) ,
                                              Integer.valueOf(AV143Empresawwds_6_tfactdescrip_sels.size()) ,
                                              AV142Empresawwds_5_tfactdescrip ,
                                              Integer.valueOf(AV145Empresawwds_8_tftipempledescri_sels.size()) ,
                                              AV144Empresawwds_7_tftipempledescri ,
                                              Integer.valueOf(AV147Empresawwds_10_tfempzondescrip_sels.size()) ,
                                              AV146Empresawwds_9_tfempzondescrip ,
                                              Long.valueOf(A177EmpCUIT) ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              Integer.valueOf(AV92CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV138Empresawwds_1_tfempnom = GXutil.concat( GXutil.rtrim( AV138Empresawwds_1_tfempnom), "%", "") ;
         lV142Empresawwds_5_tfactdescrip = GXutil.concat( GXutil.rtrim( AV142Empresawwds_5_tfactdescrip), "%", "") ;
         lV144Empresawwds_7_tftipempledescri = GXutil.concat( GXutil.rtrim( AV144Empresawwds_7_tftipempledescri), "%", "") ;
         lV146Empresawwds_9_tfempzondescrip = GXutil.concat( GXutil.rtrim( AV146Empresawwds_9_tfempzondescrip), "%", "") ;
         /* Using cursor H002H2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV92CliCod), lV138Empresawwds_1_tfempnom, Long.valueOf(AV140Empresawwds_3_tfempcuit), Long.valueOf(AV141Empresawwds_4_tfempcuit_to), lV142Empresawwds_5_tfactdescrip, lV144Empresawwds_7_tftipempledescri, lV146Empresawwds_9_tfempzondescrip, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A43ActCodigo = H002H2_A43ActCodigo[0] ;
            n43ActCodigo = H002H2_n43ActCodigo[0] ;
            A45TipEmpleCod = H002H2_A45TipEmpleCod[0] ;
            n45TipEmpleCod = H002H2_n45TipEmpleCod[0] ;
            A44EmpZonCod = H002H2_A44EmpZonCod[0] ;
            n44EmpZonCod = H002H2_n44EmpZonCod[0] ;
            A518EmpZonDescrip = H002H2_A518EmpZonDescrip[0] ;
            A339TipEmpleDescri = H002H2_A339TipEmpleDescri[0] ;
            A108ActDescrip = H002H2_A108ActDescrip[0] ;
            A177EmpCUIT = H002H2_A177EmpCUIT[0] ;
            A2EmpNom = H002H2_A2EmpNom[0] ;
            A1EmpCod = H002H2_A1EmpCod[0] ;
            A3CliCod = H002H2_A3CliCod[0] ;
            A108ActDescrip = H002H2_A108ActDescrip[0] ;
            A339TipEmpleDescri = H002H2_A339TipEmpleDescri[0] ;
            A518EmpZonDescrip = H002H2_A518EmpZonDescrip[0] ;
            e202H2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wb2H0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2H2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV137Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV137Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV113MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV113MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV92CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV92CliCod), "ZZZZZ9")));
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
      AV138Empresawwds_1_tfempnom = AV25TFEmpNom ;
      AV139Empresawwds_2_tfempnom_sels = AV69TFEmpNom_Sels ;
      AV140Empresawwds_3_tfempcuit = AV27TFEmpCUIT ;
      AV141Empresawwds_4_tfempcuit_to = AV108TFEmpCUIT_To ;
      AV142Empresawwds_5_tfactdescrip = AV53TFActDescrip ;
      AV143Empresawwds_6_tfactdescrip_sels = AV87TFActDescrip_Sels ;
      AV144Empresawwds_7_tftipempledescri = AV59TFTipEmpleDescri ;
      AV145Empresawwds_8_tftipempledescri_sels = AV91TFTipEmpleDescri_Sels ;
      AV146Empresawwds_9_tfempzondescrip = AV100TFEmpZonDescrip ;
      AV147Empresawwds_10_tfempzondescrip_sels = AV101TFEmpZonDescrip_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A2EmpNom ,
                                           AV139Empresawwds_2_tfempnom_sels ,
                                           A108ActDescrip ,
                                           AV143Empresawwds_6_tfactdescrip_sels ,
                                           A339TipEmpleDescri ,
                                           AV145Empresawwds_8_tftipempledescri_sels ,
                                           A518EmpZonDescrip ,
                                           AV147Empresawwds_10_tfempzondescrip_sels ,
                                           Integer.valueOf(AV139Empresawwds_2_tfempnom_sels.size()) ,
                                           AV138Empresawwds_1_tfempnom ,
                                           Long.valueOf(AV140Empresawwds_3_tfempcuit) ,
                                           Long.valueOf(AV141Empresawwds_4_tfempcuit_to) ,
                                           Integer.valueOf(AV143Empresawwds_6_tfactdescrip_sels.size()) ,
                                           AV142Empresawwds_5_tfactdescrip ,
                                           Integer.valueOf(AV145Empresawwds_8_tftipempledescri_sels.size()) ,
                                           AV144Empresawwds_7_tftipempledescri ,
                                           Integer.valueOf(AV147Empresawwds_10_tfempzondescrip_sels.size()) ,
                                           AV146Empresawwds_9_tfempzondescrip ,
                                           Long.valueOf(A177EmpCUIT) ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           Integer.valueOf(AV92CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV138Empresawwds_1_tfempnom = GXutil.concat( GXutil.rtrim( AV138Empresawwds_1_tfempnom), "%", "") ;
      lV142Empresawwds_5_tfactdescrip = GXutil.concat( GXutil.rtrim( AV142Empresawwds_5_tfactdescrip), "%", "") ;
      lV144Empresawwds_7_tftipempledescri = GXutil.concat( GXutil.rtrim( AV144Empresawwds_7_tftipempledescri), "%", "") ;
      lV146Empresawwds_9_tfempzondescrip = GXutil.concat( GXutil.rtrim( AV146Empresawwds_9_tfempzondescrip), "%", "") ;
      /* Using cursor H002H3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV92CliCod), lV138Empresawwds_1_tfempnom, Long.valueOf(AV140Empresawwds_3_tfempcuit), Long.valueOf(AV141Empresawwds_4_tfempcuit_to), lV142Empresawwds_5_tfactdescrip, lV144Empresawwds_7_tftipempledescri, lV146Empresawwds_9_tfempzondescrip});
      GRID_nRecordCount = H002H3_AGRID_nRecordCount[0] ;
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
      AV138Empresawwds_1_tfempnom = AV25TFEmpNom ;
      AV139Empresawwds_2_tfempnom_sels = AV69TFEmpNom_Sels ;
      AV140Empresawwds_3_tfempcuit = AV27TFEmpCUIT ;
      AV141Empresawwds_4_tfempcuit_to = AV108TFEmpCUIT_To ;
      AV142Empresawwds_5_tfactdescrip = AV53TFActDescrip ;
      AV143Empresawwds_6_tfactdescrip_sels = AV87TFActDescrip_Sels ;
      AV144Empresawwds_7_tftipempledescri = AV59TFTipEmpleDescri ;
      AV145Empresawwds_8_tftipempledescri_sels = AV91TFTipEmpleDescri_Sels ;
      AV146Empresawwds_9_tfempzondescrip = AV100TFEmpZonDescrip ;
      AV147Empresawwds_10_tfempzondescrip_sels = AV101TFEmpZonDescrip_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV124ManageFiltersExecutionStep, AV20ColumnsSelector, AV137Pgmname, AV113MenuOpcCod, AV11GridState, AV25TFEmpNom, AV69TFEmpNom_Sels, AV27TFEmpCUIT, AV108TFEmpCUIT_To, AV53TFActDescrip, AV87TFActDescrip_Sels, AV59TFTipEmpleDescri, AV91TFTipEmpleDescri_Sels, AV100TFEmpZonDescrip, AV101TFEmpZonDescrip_Sels, AV13OrderedBy, AV14OrderedDsc, AV92CliCod, AV115WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV138Empresawwds_1_tfempnom = AV25TFEmpNom ;
      AV139Empresawwds_2_tfempnom_sels = AV69TFEmpNom_Sels ;
      AV140Empresawwds_3_tfempcuit = AV27TFEmpCUIT ;
      AV141Empresawwds_4_tfempcuit_to = AV108TFEmpCUIT_To ;
      AV142Empresawwds_5_tfactdescrip = AV53TFActDescrip ;
      AV143Empresawwds_6_tfactdescrip_sels = AV87TFActDescrip_Sels ;
      AV144Empresawwds_7_tftipempledescri = AV59TFTipEmpleDescri ;
      AV145Empresawwds_8_tftipempledescri_sels = AV91TFTipEmpleDescri_Sels ;
      AV146Empresawwds_9_tfempzondescrip = AV100TFEmpZonDescrip ;
      AV147Empresawwds_10_tfempzondescrip_sels = AV101TFEmpZonDescrip_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV124ManageFiltersExecutionStep, AV20ColumnsSelector, AV137Pgmname, AV113MenuOpcCod, AV11GridState, AV25TFEmpNom, AV69TFEmpNom_Sels, AV27TFEmpCUIT, AV108TFEmpCUIT_To, AV53TFActDescrip, AV87TFActDescrip_Sels, AV59TFTipEmpleDescri, AV91TFTipEmpleDescri_Sels, AV100TFEmpZonDescrip, AV101TFEmpZonDescrip_Sels, AV13OrderedBy, AV14OrderedDsc, AV92CliCod, AV115WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV138Empresawwds_1_tfempnom = AV25TFEmpNom ;
      AV139Empresawwds_2_tfempnom_sels = AV69TFEmpNom_Sels ;
      AV140Empresawwds_3_tfempcuit = AV27TFEmpCUIT ;
      AV141Empresawwds_4_tfempcuit_to = AV108TFEmpCUIT_To ;
      AV142Empresawwds_5_tfactdescrip = AV53TFActDescrip ;
      AV143Empresawwds_6_tfactdescrip_sels = AV87TFActDescrip_Sels ;
      AV144Empresawwds_7_tftipempledescri = AV59TFTipEmpleDescri ;
      AV145Empresawwds_8_tftipempledescri_sels = AV91TFTipEmpleDescri_Sels ;
      AV146Empresawwds_9_tfempzondescrip = AV100TFEmpZonDescrip ;
      AV147Empresawwds_10_tfempzondescrip_sels = AV101TFEmpZonDescrip_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV124ManageFiltersExecutionStep, AV20ColumnsSelector, AV137Pgmname, AV113MenuOpcCod, AV11GridState, AV25TFEmpNom, AV69TFEmpNom_Sels, AV27TFEmpCUIT, AV108TFEmpCUIT_To, AV53TFActDescrip, AV87TFActDescrip_Sels, AV59TFTipEmpleDescri, AV91TFTipEmpleDescri_Sels, AV100TFEmpZonDescrip, AV101TFEmpZonDescrip_Sels, AV13OrderedBy, AV14OrderedDsc, AV92CliCod, AV115WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV138Empresawwds_1_tfempnom = AV25TFEmpNom ;
      AV139Empresawwds_2_tfempnom_sels = AV69TFEmpNom_Sels ;
      AV140Empresawwds_3_tfempcuit = AV27TFEmpCUIT ;
      AV141Empresawwds_4_tfempcuit_to = AV108TFEmpCUIT_To ;
      AV142Empresawwds_5_tfactdescrip = AV53TFActDescrip ;
      AV143Empresawwds_6_tfactdescrip_sels = AV87TFActDescrip_Sels ;
      AV144Empresawwds_7_tftipempledescri = AV59TFTipEmpleDescri ;
      AV145Empresawwds_8_tftipempledescri_sels = AV91TFTipEmpleDescri_Sels ;
      AV146Empresawwds_9_tfempzondescrip = AV100TFEmpZonDescrip ;
      AV147Empresawwds_10_tfempzondescrip_sels = AV101TFEmpZonDescrip_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV124ManageFiltersExecutionStep, AV20ColumnsSelector, AV137Pgmname, AV113MenuOpcCod, AV11GridState, AV25TFEmpNom, AV69TFEmpNom_Sels, AV27TFEmpCUIT, AV108TFEmpCUIT_To, AV53TFActDescrip, AV87TFActDescrip_Sels, AV59TFTipEmpleDescri, AV91TFTipEmpleDescri_Sels, AV100TFEmpZonDescrip, AV101TFEmpZonDescrip_Sels, AV13OrderedBy, AV14OrderedDsc, AV92CliCod, AV115WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV138Empresawwds_1_tfempnom = AV25TFEmpNom ;
      AV139Empresawwds_2_tfempnom_sels = AV69TFEmpNom_Sels ;
      AV140Empresawwds_3_tfempcuit = AV27TFEmpCUIT ;
      AV141Empresawwds_4_tfempcuit_to = AV108TFEmpCUIT_To ;
      AV142Empresawwds_5_tfactdescrip = AV53TFActDescrip ;
      AV143Empresawwds_6_tfactdescrip_sels = AV87TFActDescrip_Sels ;
      AV144Empresawwds_7_tftipempledescri = AV59TFTipEmpleDescri ;
      AV145Empresawwds_8_tftipempledescri_sels = AV91TFTipEmpleDescri_Sels ;
      AV146Empresawwds_9_tfempzondescrip = AV100TFEmpZonDescrip ;
      AV147Empresawwds_10_tfempzondescrip_sels = AV101TFEmpZonDescrip_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV124ManageFiltersExecutionStep, AV20ColumnsSelector, AV137Pgmname, AV113MenuOpcCod, AV11GridState, AV25TFEmpNom, AV69TFEmpNom_Sels, AV27TFEmpCUIT, AV108TFEmpCUIT_To, AV53TFActDescrip, AV87TFActDescrip_Sels, AV59TFTipEmpleDescri, AV91TFTipEmpleDescri_Sels, AV100TFEmpZonDescrip, AV101TFEmpZonDescrip_Sels, AV13OrderedBy, AV14OrderedDsc, AV92CliCod, AV115WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV137Pgmname = "EmpresaWW" ;
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

   public void strup2H0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e182H2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV61DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV20ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV122ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV63GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV64GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV65GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV92CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( "DDO_GRID_Filteredtextto_get") ;
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV121WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV115WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV115WelcomeMessage_NoMostrarMas", AV115WelcomeMessage_NoMostrarMas);
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
      e182H2 ();
      if (returnInSub) return;
   }

   public void e182H2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV113MenuOpcCod, "", "") ;
      GXt_int1 = AV92CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      empresaww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV92CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV92CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV92CliCod), "ZZZZZ9")));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV8HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Empresas", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV13OrderedBy < 1 )
      {
         AV13OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV61DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV61DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV116MenuBienveImgURL ;
      GXv_char6[0] = AV118MenuBienveTitulo ;
      GXv_char7[0] = AV119MenuBienveTexto ;
      GXv_boolean8[0] = AV120MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV113MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      empresaww_impl.this.AV116MenuBienveImgURL = GXv_char5[0] ;
      empresaww_impl.this.AV118MenuBienveTitulo = GXv_char6[0] ;
      empresaww_impl.this.AV119MenuBienveTexto = GXv_char7[0] ;
      empresaww_impl.this.AV120MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV120MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV120MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV118MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV119MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV121WelcomeMessage_Foto = AV116MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV121WelcomeMessage_Foto)==0) ? AV136Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV121WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV121WelcomeMessage_Foto), true);
         AV136Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV116MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV121WelcomeMessage_Foto)==0) ? AV136Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV121WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV121WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      empresaww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      empresaww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV130observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV130observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV130observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV130observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e192H2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV92CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      empresaww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV92CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV92CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV92CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext11[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext11) ;
      AV6WWPContext = GXv_SdtWWPContext11[0] ;
      if ( AV124ManageFiltersExecutionStep == 1 )
      {
         AV124ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV124ManageFiltersExecutionStep", GXutil.str( AV124ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV124ManageFiltersExecutionStep == 2 )
      {
         AV124ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV124ManageFiltersExecutionStep", GXutil.str( AV124ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV22Session.getValue("EmpresaWWColumnsSelector"), "") != 0 )
      {
         AV18ColumnsSelectorXML = AV22Session.getValue("EmpresaWWColumnsSelector") ;
         AV20ColumnsSelector.fromxml(AV18ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S162 ();
         if (returnInSub) return;
      }
      edtEmpNom_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpNom_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpNom_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtEmpCUIT_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCUIT_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCUIT_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtActDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtActDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtActDescrip_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtTipEmpleDescri_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipEmpleDescri_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipEmpleDescri_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtEmpZonDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpZonDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpZonDescrip_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV63GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63GridCurrentPage), 10, 0));
      AV64GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV64GridPageCount), 10, 0));
      GXt_char10 = AV65GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV137Pgmname, GXv_char7) ;
      empresaww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV65GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65GridAppliedFilters", AV65GridAppliedFilters);
      GXt_char10 = AV129MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV113MenuOpcCod, GXv_char7) ;
      empresaww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV129MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV129MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV129MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int12[0] = (short)(AV132filterCount) ;
      GXv_char7[0] = AV133filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV11GridState, GXv_int12, GXv_char7) ;
      empresaww_impl.this.AV132filterCount = GXv_int12[0] ;
      empresaww_impl.this.AV133filtrosTexto = GXv_char7[0] ;
      if ( AV132filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV132filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV133filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV138Empresawwds_1_tfempnom = AV25TFEmpNom ;
      AV139Empresawwds_2_tfempnom_sels = AV69TFEmpNom_Sels ;
      AV140Empresawwds_3_tfempcuit = AV27TFEmpCUIT ;
      AV141Empresawwds_4_tfempcuit_to = AV108TFEmpCUIT_To ;
      AV142Empresawwds_5_tfactdescrip = AV53TFActDescrip ;
      AV143Empresawwds_6_tfactdescrip_sels = AV87TFActDescrip_Sels ;
      AV144Empresawwds_7_tftipempledescri = AV59TFTipEmpleDescri ;
      AV145Empresawwds_8_tftipempledescri_sels = AV91TFTipEmpleDescri_Sels ;
      AV146Empresawwds_9_tfempzondescrip = AV100TFEmpZonDescrip ;
      AV147Empresawwds_10_tfempzondescrip_sels = AV101TFEmpZonDescrip_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV122ManageFiltersData", AV122ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e132H2( )
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
         AV62PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV62PageToGo) ;
      }
   }

   public void e142H2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e152H2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV13OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         AV14OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpNom") == 0 )
         {
            AV25TFEmpNom = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFEmpNom", AV25TFEmpNom);
            AV68TFEmpNom_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFEmpNom_SelsJson", AV68TFEmpNom_SelsJson);
            AV69TFEmpNom_Sels.fromJSonString(AV68TFEmpNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpCUIT") == 0 )
         {
            AV27TFEmpCUIT = GXutil.lval( Ddo_grid_Filteredtext_get) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFEmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFEmpCUIT), 11, 0));
            AV108TFEmpCUIT_To = GXutil.lval( Ddo_grid_Filteredtextto_get) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV108TFEmpCUIT_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV108TFEmpCUIT_To), 11, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ActDescrip") == 0 )
         {
            AV53TFActDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFActDescrip", AV53TFActDescrip);
            AV86TFActDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86TFActDescrip_SelsJson", AV86TFActDescrip_SelsJson);
            AV87TFActDescrip_Sels.fromJSonString(AV86TFActDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "TipEmpleDescri") == 0 )
         {
            AV59TFTipEmpleDescri = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFTipEmpleDescri", AV59TFTipEmpleDescri);
            AV90TFTipEmpleDescri_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFTipEmpleDescri_SelsJson", AV90TFTipEmpleDescri_SelsJson);
            AV91TFTipEmpleDescri_Sels.fromJSonString(AV90TFTipEmpleDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmpZonDescrip") == 0 )
         {
            AV100TFEmpZonDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV100TFEmpZonDescrip", AV100TFEmpZonDescrip);
            AV99TFEmpZonDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99TFEmpZonDescrip_SelsJson", AV99TFEmpZonDescrip_SelsJson);
            AV101TFEmpZonDescrip_Sels.fromJSonString(AV99TFEmpZonDescrip_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV69TFEmpNom_Sels", AV69TFEmpNom_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV87TFActDescrip_Sels", AV87TFActDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV91TFTipEmpleDescri_Sels", AV91TFTipEmpleDescri_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV101TFEmpZonDescrip_Sels", AV101TFEmpZonDescrip_Sels);
   }

   private void e202H2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV105Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV105Update);
      edtavUpdate_Link = formatLink("web.empresa_cabecera", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "UPD", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV92CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0))}, new String[] {"TrnMode","CliCod","EmpCod","MenuOpcCod"})  ;
      AV106Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV106Delete);
      edtavDelete_Link = formatLink("web.empresa_cabecera", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "DLT", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV92CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0))}, new String[] {"TrnMode","CliCod","EmpCod","MenuOpcCod"})  ;
      AV112Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV112Display);
      edtavDisplay_Link = formatLink("web.empresaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV109VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      empresaww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV109VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV109VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char10 = AV110ModificarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      empresaww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV110ModificarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV110ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char10 = AV111EliminarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      empresaww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV111EliminarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV111EliminarSVG);
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

   public void e112H2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV18ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV20ColumnsSelector.fromJSonString(AV18ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "EmpresaWWColumnsSelector", ((GXutil.strcmp("", AV18ColumnsSelectorXML)==0) ? "" : AV20ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV122ManageFiltersData", AV122ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e122H2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("EmpresaWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV137Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV124ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV124ManageFiltersExecutionStep", GXutil.str( AV124ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("EmpresaWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV124ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV124ManageFiltersExecutionStep", GXutil.str( AV124ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV123ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "EmpresaWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         empresaww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV123ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV123ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S172 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV137Pgmname+"GridState", AV123ManageFiltersXml) ;
            AV11GridState.fromxml(AV123ManageFiltersXml, null, null);
            AV13OrderedBy = AV11GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
            AV14OrderedDsc = AV11GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV69TFEmpNom_Sels", AV69TFEmpNom_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV87TFActDescrip_Sels", AV87TFActDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV91TFTipEmpleDescri_Sels", AV91TFTipEmpleDescri_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV101TFEmpZonDescrip_Sels", AV101TFEmpZonDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV122ManageFiltersData", AV122ManageFiltersData);
   }

   public void e162H2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV16ExcelFilename ;
      GXv_char6[0] = AV17ErrorMessage ;
      new web.empresawwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      empresaww_impl.this.AV16ExcelFilename = GXv_char7[0] ;
      empresaww_impl.this.AV17ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV16ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV16ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV17ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV13OrderedBy, 4, 0))+":"+(AV14OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S162( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV20ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "EmpNom", "", "Nombre", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "EmpCUIT", "", "CUIT", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ActDescrip", "", "Actividad", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "TipEmpleDescri", "", "Tipo de Empleador", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "EmpZonDescrip", "", "Zona", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
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
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EmpresaWWColumnsSelector", GXv_char7) ;
      empresaww_impl.this.GXt_char10 = GXv_char7[0] ;
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
      new web.fixcolumnsselector(remoteHandle, context).execute( AV92CliCod, GXv_SdtWWPColumnsSelector14) ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 = AV122ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item16[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "EmpresaWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item16) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item16[0] ;
      AV122ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 ;
   }

   public void S172( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV25TFEmpNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25TFEmpNom", AV25TFEmpNom);
      AV69TFEmpNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27TFEmpCUIT = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFEmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFEmpCUIT), 11, 0));
      AV108TFEmpCUIT_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV108TFEmpCUIT_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV108TFEmpCUIT_To), 11, 0));
      AV53TFActDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53TFActDescrip", AV53TFActDescrip);
      AV87TFActDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59TFTipEmpleDescri = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59TFTipEmpleDescri", AV59TFTipEmpleDescri);
      AV91TFTipEmpleDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV100TFEmpZonDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV100TFEmpZonDescrip", AV100TFEmpZonDescrip);
      AV101TFEmpZonDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV22Session.getValue(AV137Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV137Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV22Session.getValue(AV137Pgmname+"GridState"), null, null);
      }
      AV13OrderedBy = AV11GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
      AV14OrderedDsc = AV11GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S182 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV11GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV11GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV11GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S182( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV148GXV1 = 1 ;
      while ( AV148GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV148GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPNOM") == 0 )
         {
            AV25TFEmpNom = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFEmpNom", AV25TFEmpNom);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPNOM_SEL") == 0 )
         {
            AV68TFEmpNom_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFEmpNom_SelsJson", AV68TFEmpNom_SelsJson);
            AV69TFEmpNom_Sels.fromJSonString(AV68TFEmpNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPCUIT") == 0 )
         {
            AV27TFEmpCUIT = GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFEmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFEmpCUIT), 11, 0));
            AV108TFEmpCUIT_To = GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV108TFEmpCUIT_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV108TFEmpCUIT_To), 11, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFACTDESCRIP") == 0 )
         {
            AV53TFActDescrip = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFActDescrip", AV53TFActDescrip);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFACTDESCRIP_SEL") == 0 )
         {
            AV86TFActDescrip_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86TFActDescrip_SelsJson", AV86TFActDescrip_SelsJson);
            AV87TFActDescrip_Sels.fromJSonString(AV86TFActDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDESCRI") == 0 )
         {
            AV59TFTipEmpleDescri = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFTipEmpleDescri", AV59TFTipEmpleDescri);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDESCRI_SEL") == 0 )
         {
            AV90TFTipEmpleDescri_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFTipEmpleDescri_SelsJson", AV90TFTipEmpleDescri_SelsJson);
            AV91TFTipEmpleDescri_Sels.fromJSonString(AV90TFTipEmpleDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPZONDESCRIP") == 0 )
         {
            AV100TFEmpZonDescrip = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV100TFEmpZonDescrip", AV100TFEmpZonDescrip);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPZONDESCRIP_SEL") == 0 )
         {
            AV99TFEmpZonDescrip_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99TFEmpZonDescrip_SelsJson", AV99TFEmpZonDescrip_SelsJson);
            AV101TFEmpZonDescrip_Sels.fromJSonString(AV99TFEmpZonDescrip_SelsJson, null);
         }
         AV148GXV1 = (int)(AV148GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV69TFEmpNom_Sels.size()==0), AV68TFEmpNom_SelsJson, GXv_char7) ;
      empresaww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV87TFActDescrip_Sels.size()==0), AV86TFActDescrip_SelsJson, GXv_char6) ;
      empresaww_impl.this.GXt_char9 = GXv_char6[0] ;
      GXt_char17 = "" ;
      GXv_char5[0] = GXt_char17 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV91TFTipEmpleDescri_Sels.size()==0), AV90TFTipEmpleDescri_SelsJson, GXv_char5) ;
      empresaww_impl.this.GXt_char17 = GXv_char5[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV101TFEmpZonDescrip_Sels.size()==0), AV99TFEmpZonDescrip_SelsJson, GXv_char19) ;
      empresaww_impl.this.GXt_char18 = GXv_char19[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char10+"||"+GXt_char9+"|"+GXt_char17+"|"+GXt_char18 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV25TFEmpNom)==0), AV25TFEmpNom, GXv_char19) ;
      empresaww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char17 = "" ;
      GXv_char7[0] = GXt_char17 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV53TFActDescrip)==0), AV53TFActDescrip, GXv_char7) ;
      empresaww_impl.this.GXt_char17 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char6[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV59TFTipEmpleDescri)==0), AV59TFTipEmpleDescri, GXv_char6) ;
      empresaww_impl.this.GXt_char10 = GXv_char6[0] ;
      GXt_char9 = "" ;
      GXv_char5[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV100TFEmpZonDescrip)==0), AV100TFEmpZonDescrip, GXv_char5) ;
      empresaww_impl.this.GXt_char9 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = GXt_char18+"|"+((0==AV27TFEmpCUIT) ? "" : GXutil.str( AV27TFEmpCUIT, 11, 0))+"|"+GXt_char17+"|"+GXt_char10+"|"+GXt_char9 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|"+((0==AV108TFEmpCUIT_To) ? "" : GXutil.str( AV108TFEmpCUIT_To, 11, 0))+"|||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV22Session.getValue(AV137Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFEMPNOM", httpContext.getMessage( "Nombre", ""), !(GXutil.strcmp("", AV25TFEmpNom)==0), (short)(0), AV25TFEmpNom, "", !(AV69TFEmpNom_Sels.size()==0), AV69TFEmpNom_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFEMPCUIT", httpContext.getMessage( "CUIT", ""), !((0==AV27TFEmpCUIT)&&(0==AV108TFEmpCUIT_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFEmpCUIT, 11, 0)), GXutil.trim( GXutil.str( AV108TFEmpCUIT_To, 11, 0))) ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFACTDESCRIP", httpContext.getMessage( "Actividad", ""), !(GXutil.strcmp("", AV53TFActDescrip)==0), (short)(0), AV53TFActDescrip, "", !(AV87TFActDescrip_Sels.size()==0), AV87TFActDescrip_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFTIPEMPLEDESCRI", httpContext.getMessage( "Tipo de Empleador", ""), !(GXutil.strcmp("", AV59TFTipEmpleDescri)==0), (short)(0), AV59TFTipEmpleDescri, "", !(AV91TFTipEmpleDescri_Sels.size()==0), AV91TFTipEmpleDescri_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFEMPZONDESCRIP", httpContext.getMessage( "Zona", ""), !(GXutil.strcmp("", AV100TFEmpZonDescrip)==0), (short)(0), AV100TFEmpZonDescrip, "", !(AV101TFEmpZonDescrip_Sels.size()==0), AV101TFEmpZonDescrip_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      if ( ! (GXutil.strcmp("", AV113MenuOpcCod)==0) )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV113MenuOpcCod );
         AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV12GridStateFilterValue, 0);
      }
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV137Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV137Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Empresa" );
      AV22Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e172H2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV115WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV113MenuOpcCod, GXv_boolean8) ;
         GXv_char19[0] = AV117textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV92CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char19) ;
         empresaww_impl.this.AV117textoNoMostrara = GXv_char19[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV117textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV113MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_2H2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_2H2( true) ;
      }
      else
      {
         wb_table2_12_2H2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_2H2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_2H2e( true) ;
      }
      else
      {
         wb_table1_9_2H2e( false) ;
      }
   }

   public void wb_table2_12_2H2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e212h1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_EmpresaWW.htm");
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
         AV121WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV121WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV136Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV121WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV121WelcomeMessage_Foto)==0) ? AV136Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV121WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV121WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_EmpresaWW.htm");
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
         wb_table3_30_2H2( true) ;
      }
      else
      {
         wb_table3_30_2H2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_2H2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_2H2( true) ;
      }
      else
      {
         wb_table4_35_2H2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_2H2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV115WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_EmpresaWW.htm");
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
         wb_table5_54_2H2( true) ;
      }
      else
      {
         wb_table5_54_2H2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_2H2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_2H2( true) ;
      }
      else
      {
         wb_table6_63_2H2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_2H2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV63GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV64GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV65GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_2H2e( true) ;
      }
      else
      {
         wb_table2_12_2H2e( false) ;
      }
   }

   public void wb_table6_63_2H2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_EmpresaWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_EmpresaWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV61DDO_TitleSettingsIcons);
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV122ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 7, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e222h1_client"+"'", TempTags, "", 2, "HLP_EmpresaWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EmpresaWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_EmpresaWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_EmpresaWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_2H2( true) ;
      }
      else
      {
         wb_table7_99_2H2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_2H2e( boolean wbgen )
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
         wb_table6_63_2H2e( true) ;
      }
      else
      {
         wb_table6_63_2H2e( false) ;
      }
   }

   public void wb_table7_99_2H2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_EmpresaWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_2H2e( true) ;
      }
      else
      {
         wb_table7_99_2H2e( false) ;
      }
   }

   public void wb_table5_54_2H2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_EmpresaWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_EmpresaWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_2H2e( true) ;
      }
      else
      {
         wb_table5_54_2H2e( false) ;
      }
   }

   public void wb_table4_35_2H2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_EmpresaWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_2H2e( true) ;
      }
      else
      {
         wb_table4_35_2H2e( false) ;
      }
   }

   public void wb_table3_30_2H2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_EmpresaWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_2H2e( true) ;
      }
      else
      {
         wb_table3_30_2H2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV113MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV113MenuOpcCod", AV113MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV113MenuOpcCod, ""))));
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
      pa2H2( ) ;
      ws2H2( ) ;
      we2H2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202513934431", true, true);
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
      httpContext.AddJavascriptSource("empresaww.js", "?202513934432", false, true);
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
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_110_idx ;
      edtEmpNom_Internalname = "EMPNOM_"+sGXsfl_110_idx ;
      edtEmpCUIT_Internalname = "EMPCUIT_"+sGXsfl_110_idx ;
      edtActDescrip_Internalname = "ACTDESCRIP_"+sGXsfl_110_idx ;
      edtTipEmpleDescri_Internalname = "TIPEMPLEDESCRI_"+sGXsfl_110_idx ;
      edtEmpZonDescrip_Internalname = "EMPZONDESCRIP_"+sGXsfl_110_idx ;
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
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_110_fel_idx ;
      edtEmpNom_Internalname = "EMPNOM_"+sGXsfl_110_fel_idx ;
      edtEmpCUIT_Internalname = "EMPCUIT_"+sGXsfl_110_fel_idx ;
      edtActDescrip_Internalname = "ACTDESCRIP_"+sGXsfl_110_fel_idx ;
      edtTipEmpleDescri_Internalname = "TIPEMPLEDESCRI_"+sGXsfl_110_fel_idx ;
      edtEmpZonDescrip_Internalname = "EMPZONDESCRIP_"+sGXsfl_110_fel_idx ;
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
      wb2H0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtEmpNom_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpNom_Internalname,A2EmpNom,GXutil.rtrim( localUtil.format( A2EmpNom, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpNom_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmpNom_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionLarga","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEmpCUIT_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCUIT_Internalname,GXutil.ltrim( localUtil.ntoc( A177EmpCUIT, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A177EmpCUIT), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpCUIT_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmpCUIT_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtActDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtActDescrip_Internalname,A108ActDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtActDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtActDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(150),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtTipEmpleDescri_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTipEmpleDescri_Internalname,A339TipEmpleDescri,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTipEmpleDescri_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtTipEmpleDescri_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtEmpZonDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpZonDescrip_Internalname,A518EmpZonDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpZonDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtEmpZonDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV105Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV106Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV112Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV109VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV110ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV111EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2H2( ) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpNom_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nombre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpCUIT_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CUIT", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtActDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Actividad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtTipEmpleDescri_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de Empleador", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmpZonDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Zona", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2EmpNom);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpNom_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A177EmpCUIT, (byte)(11), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpCUIT_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A108ActDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtActDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A339TipEmpleDescri);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtTipEmpleDescri_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A518EmpZonDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpZonDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV105Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV106Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV112Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV109VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV110ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV111EliminarSVG));
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
      edtEmpCod_Internalname = "EMPCOD" ;
      edtEmpNom_Internalname = "EMPNOM" ;
      edtEmpCUIT_Internalname = "EMPCUIT" ;
      edtActDescrip_Internalname = "ACTDESCRIP" ;
      edtTipEmpleDescri_Internalname = "TIPEMPLEDESCRI" ;
      edtEmpZonDescrip_Internalname = "EMPZONDESCRIP" ;
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
      edtavDelete_Visible = -1 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 0 ;
      edtavUpdate_Visible = -1 ;
      edtEmpZonDescrip_Jsonclick = "" ;
      edtTipEmpleDescri_Jsonclick = "" ;
      edtActDescrip_Jsonclick = "" ;
      edtEmpCUIT_Jsonclick = "" ;
      edtEmpNom_Jsonclick = "" ;
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
      edtEmpZonDescrip_Visible = -1 ;
      edtTipEmpleDescri_Visible = -1 ;
      edtActDescrip_Visible = -1 ;
      edtEmpCUIT_Visible = -1 ;
      edtEmpNom_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "|11.0|||" ;
      Ddo_grid_Datalistproc = "EmpresaWWGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "T||T|T|T" ;
      Ddo_grid_Datalisttype = "Dynamic||Dynamic|Dynamic|Dynamic" ;
      Ddo_grid_Includedatalist = "T||T|T|T" ;
      Ddo_grid_Filterisrange = "|T|||" ;
      Ddo_grid_Filtertype = "Character|Numeric|Character|Character|Character" ;
      Ddo_grid_Includefilter = "T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5" ;
      Ddo_grid_Columnids = "2:EmpNom|3:EmpCUIT|4:ActDescrip|5:TipEmpleDescri|6:EmpZonDescrip" ;
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
      Form.setCaption( httpContext.getMessage( " Empresas", "") );
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
      AV115WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV115WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV115WelcomeMessage_NoMostrarMas", AV115WelcomeMessage_NoMostrarMas);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV124ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV137Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV113MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFEmpNom',fld:'vTFEMPNOM',pic:'@!'},{av:'AV69TFEmpNom_Sels',fld:'vTFEMPNOM_SELS',pic:''},{av:'AV27TFEmpCUIT',fld:'vTFEMPCUIT',pic:'ZZZZZZZZZZ9'},{av:'AV108TFEmpCUIT_To',fld:'vTFEMPCUIT_TO',pic:'ZZZZZZZZZZ9'},{av:'AV53TFActDescrip',fld:'vTFACTDESCRIP',pic:''},{av:'AV87TFActDescrip_Sels',fld:'vTFACTDESCRIP_SELS',pic:''},{av:'AV59TFTipEmpleDescri',fld:'vTFTIPEMPLEDESCRI',pic:''},{av:'AV91TFTipEmpleDescri_Sels',fld:'vTFTIPEMPLEDESCRI_SELS',pic:''},{av:'AV100TFEmpZonDescrip',fld:'vTFEMPZONDESCRIP',pic:''},{av:'AV101TFEmpZonDescrip_Sels',fld:'vTFEMPZONDESCRIP_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV115WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV124ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtEmpNom_Visible',ctrl:'EMPNOM',prop:'Visible'},{av:'edtEmpCUIT_Visible',ctrl:'EMPCUIT',prop:'Visible'},{av:'edtActDescrip_Visible',ctrl:'ACTDESCRIP',prop:'Visible'},{av:'edtTipEmpleDescri_Visible',ctrl:'TIPEMPLEDESCRI',prop:'Visible'},{av:'edtEmpZonDescrip_Visible',ctrl:'EMPZONDESCRIP',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV63GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV64GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV65GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV122ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e132H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV124ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV137Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV113MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFEmpNom',fld:'vTFEMPNOM',pic:'@!'},{av:'AV69TFEmpNom_Sels',fld:'vTFEMPNOM_SELS',pic:''},{av:'AV27TFEmpCUIT',fld:'vTFEMPCUIT',pic:'ZZZZZZZZZZ9'},{av:'AV108TFEmpCUIT_To',fld:'vTFEMPCUIT_TO',pic:'ZZZZZZZZZZ9'},{av:'AV53TFActDescrip',fld:'vTFACTDESCRIP',pic:''},{av:'AV87TFActDescrip_Sels',fld:'vTFACTDESCRIP_SELS',pic:''},{av:'AV59TFTipEmpleDescri',fld:'vTFTIPEMPLEDESCRI',pic:''},{av:'AV91TFTipEmpleDescri_Sels',fld:'vTFTIPEMPLEDESCRI_SELS',pic:''},{av:'AV100TFEmpZonDescrip',fld:'vTFEMPZONDESCRIP',pic:''},{av:'AV101TFEmpZonDescrip_Sels',fld:'vTFEMPZONDESCRIP_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV115WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e142H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV124ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV137Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV113MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFEmpNom',fld:'vTFEMPNOM',pic:'@!'},{av:'AV69TFEmpNom_Sels',fld:'vTFEMPNOM_SELS',pic:''},{av:'AV27TFEmpCUIT',fld:'vTFEMPCUIT',pic:'ZZZZZZZZZZ9'},{av:'AV108TFEmpCUIT_To',fld:'vTFEMPCUIT_TO',pic:'ZZZZZZZZZZ9'},{av:'AV53TFActDescrip',fld:'vTFACTDESCRIP',pic:''},{av:'AV87TFActDescrip_Sels',fld:'vTFACTDESCRIP_SELS',pic:''},{av:'AV59TFTipEmpleDescri',fld:'vTFTIPEMPLEDESCRI',pic:''},{av:'AV91TFTipEmpleDescri_Sels',fld:'vTFTIPEMPLEDESCRI_SELS',pic:''},{av:'AV100TFEmpZonDescrip',fld:'vTFEMPZONDESCRIP',pic:''},{av:'AV101TFEmpZonDescrip_Sels',fld:'vTFEMPZONDESCRIP_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV115WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e152H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV124ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV137Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV113MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFEmpNom',fld:'vTFEMPNOM',pic:'@!'},{av:'AV69TFEmpNom_Sels',fld:'vTFEMPNOM_SELS',pic:''},{av:'AV27TFEmpCUIT',fld:'vTFEMPCUIT',pic:'ZZZZZZZZZZ9'},{av:'AV108TFEmpCUIT_To',fld:'vTFEMPCUIT_TO',pic:'ZZZZZZZZZZ9'},{av:'AV53TFActDescrip',fld:'vTFACTDESCRIP',pic:''},{av:'AV87TFActDescrip_Sels',fld:'vTFACTDESCRIP_SELS',pic:''},{av:'AV59TFTipEmpleDescri',fld:'vTFTIPEMPLEDESCRI',pic:''},{av:'AV91TFTipEmpleDescri_Sels',fld:'vTFTIPEMPLEDESCRI_SELS',pic:''},{av:'AV100TFEmpZonDescrip',fld:'vTFEMPZONDESCRIP',pic:''},{av:'AV101TFEmpZonDescrip_Sels',fld:'vTFEMPZONDESCRIP_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV115WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV25TFEmpNom',fld:'vTFEMPNOM',pic:'@!'},{av:'AV68TFEmpNom_SelsJson',fld:'vTFEMPNOM_SELSJSON',pic:''},{av:'AV69TFEmpNom_Sels',fld:'vTFEMPNOM_SELS',pic:''},{av:'AV27TFEmpCUIT',fld:'vTFEMPCUIT',pic:'ZZZZZZZZZZ9'},{av:'AV108TFEmpCUIT_To',fld:'vTFEMPCUIT_TO',pic:'ZZZZZZZZZZ9'},{av:'AV53TFActDescrip',fld:'vTFACTDESCRIP',pic:''},{av:'AV86TFActDescrip_SelsJson',fld:'vTFACTDESCRIP_SELSJSON',pic:''},{av:'AV87TFActDescrip_Sels',fld:'vTFACTDESCRIP_SELS',pic:''},{av:'AV59TFTipEmpleDescri',fld:'vTFTIPEMPLEDESCRI',pic:''},{av:'AV90TFTipEmpleDescri_SelsJson',fld:'vTFTIPEMPLEDESCRI_SELSJSON',pic:''},{av:'AV91TFTipEmpleDescri_Sels',fld:'vTFTIPEMPLEDESCRI_SELS',pic:''},{av:'AV100TFEmpZonDescrip',fld:'vTFEMPZONDESCRIP',pic:''},{av:'AV99TFEmpZonDescrip_SelsJson',fld:'vTFEMPZONDESCRIP_SELSJSON',pic:''},{av:'AV101TFEmpZonDescrip_Sels',fld:'vTFEMPZONDESCRIP_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e202H2',iparms:[{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV105Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV106Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV112Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV109VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV110ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV111EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e112H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV124ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV137Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV113MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFEmpNom',fld:'vTFEMPNOM',pic:'@!'},{av:'AV69TFEmpNom_Sels',fld:'vTFEMPNOM_SELS',pic:''},{av:'AV27TFEmpCUIT',fld:'vTFEMPCUIT',pic:'ZZZZZZZZZZ9'},{av:'AV108TFEmpCUIT_To',fld:'vTFEMPCUIT_TO',pic:'ZZZZZZZZZZ9'},{av:'AV53TFActDescrip',fld:'vTFACTDESCRIP',pic:''},{av:'AV87TFActDescrip_Sels',fld:'vTFACTDESCRIP_SELS',pic:''},{av:'AV59TFTipEmpleDescri',fld:'vTFTIPEMPLEDESCRI',pic:''},{av:'AV91TFTipEmpleDescri_Sels',fld:'vTFTIPEMPLEDESCRI_SELS',pic:''},{av:'AV100TFEmpZonDescrip',fld:'vTFEMPZONDESCRIP',pic:''},{av:'AV101TFEmpZonDescrip_Sels',fld:'vTFEMPZONDESCRIP_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV115WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV124ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtEmpNom_Visible',ctrl:'EMPNOM',prop:'Visible'},{av:'edtEmpCUIT_Visible',ctrl:'EMPCUIT',prop:'Visible'},{av:'edtActDescrip_Visible',ctrl:'ACTDESCRIP',prop:'Visible'},{av:'edtTipEmpleDescri_Visible',ctrl:'TIPEMPLEDESCRI',prop:'Visible'},{av:'edtEmpZonDescrip_Visible',ctrl:'EMPZONDESCRIP',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV63GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV64GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV65GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV122ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e122H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV124ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV137Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV113MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV25TFEmpNom',fld:'vTFEMPNOM',pic:'@!'},{av:'AV69TFEmpNom_Sels',fld:'vTFEMPNOM_SELS',pic:''},{av:'AV27TFEmpCUIT',fld:'vTFEMPCUIT',pic:'ZZZZZZZZZZ9'},{av:'AV108TFEmpCUIT_To',fld:'vTFEMPCUIT_TO',pic:'ZZZZZZZZZZ9'},{av:'AV53TFActDescrip',fld:'vTFACTDESCRIP',pic:''},{av:'AV87TFActDescrip_Sels',fld:'vTFACTDESCRIP_SELS',pic:''},{av:'AV59TFTipEmpleDescri',fld:'vTFTIPEMPLEDESCRI',pic:''},{av:'AV91TFTipEmpleDescri_Sels',fld:'vTFTIPEMPLEDESCRI_SELS',pic:''},{av:'AV100TFEmpZonDescrip',fld:'vTFEMPZONDESCRIP',pic:''},{av:'AV101TFEmpZonDescrip_Sels',fld:'vTFEMPZONDESCRIP_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV115WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV68TFEmpNom_SelsJson',fld:'vTFEMPNOM_SELSJSON',pic:''},{av:'AV86TFActDescrip_SelsJson',fld:'vTFACTDESCRIP_SELSJSON',pic:''},{av:'AV90TFTipEmpleDescri_SelsJson',fld:'vTFTIPEMPLEDESCRI_SELSJSON',pic:''},{av:'AV99TFEmpZonDescrip_SelsJson',fld:'vTFEMPZONDESCRIP_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV124ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV25TFEmpNom',fld:'vTFEMPNOM',pic:'@!'},{av:'AV69TFEmpNom_Sels',fld:'vTFEMPNOM_SELS',pic:''},{av:'AV27TFEmpCUIT',fld:'vTFEMPCUIT',pic:'ZZZZZZZZZZ9'},{av:'AV108TFEmpCUIT_To',fld:'vTFEMPCUIT_TO',pic:'ZZZZZZZZZZ9'},{av:'AV53TFActDescrip',fld:'vTFACTDESCRIP',pic:''},{av:'AV87TFActDescrip_Sels',fld:'vTFACTDESCRIP_SELS',pic:''},{av:'AV59TFTipEmpleDescri',fld:'vTFTIPEMPLEDESCRI',pic:''},{av:'AV91TFTipEmpleDescri_Sels',fld:'vTFTIPEMPLEDESCRI_SELS',pic:''},{av:'AV100TFEmpZonDescrip',fld:'vTFEMPZONDESCRIP',pic:''},{av:'AV101TFEmpZonDescrip_Sels',fld:'vTFEMPZONDESCRIP_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV99TFEmpZonDescrip_SelsJson',fld:'vTFEMPZONDESCRIP_SELSJSON',pic:''},{av:'AV90TFTipEmpleDescri_SelsJson',fld:'vTFTIPEMPLEDESCRI_SELSJSON',pic:''},{av:'AV86TFActDescrip_SelsJson',fld:'vTFACTDESCRIP_SELSJSON',pic:''},{av:'AV68TFEmpNom_SelsJson',fld:'vTFEMPNOM_SELSJSON',pic:''},{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtEmpNom_Visible',ctrl:'EMPNOM',prop:'Visible'},{av:'edtEmpCUIT_Visible',ctrl:'EMPCUIT',prop:'Visible'},{av:'edtActDescrip_Visible',ctrl:'ACTDESCRIP',prop:'Visible'},{av:'edtTipEmpleDescri_Visible',ctrl:'TIPEMPLEDESCRI',prop:'Visible'},{av:'edtEmpZonDescrip_Visible',ctrl:'EMPZONDESCRIP',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV63GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV64GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV65GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV122ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e222H1',iparms:[{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e162H2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e172H2',iparms:[{av:'AV115WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV113MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV92CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e212H1',iparms:[]");
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
      wcpOAV113MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV113MenuOpcCod = "" ;
      AV20ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV137Pgmname = "" ;
      AV11GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25TFEmpNom = "" ;
      AV69TFEmpNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53TFActDescrip = "" ;
      AV87TFActDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59TFTipEmpleDescri = "" ;
      AV91TFTipEmpleDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100TFEmpZonDescrip = "" ;
      AV101TFEmpZonDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV61DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV122ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV65GridAppliedFilters = "" ;
      AV68TFEmpNom_SelsJson = "" ;
      AV86TFActDescrip_SelsJson = "" ;
      AV90TFTipEmpleDescri_SelsJson = "" ;
      AV99TFEmpZonDescrip_SelsJson = "" ;
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
      A2EmpNom = "" ;
      A108ActDescrip = "" ;
      A339TipEmpleDescri = "" ;
      A518EmpZonDescrip = "" ;
      AV105Update = "" ;
      AV106Delete = "" ;
      AV112Display = "" ;
      AV109VerSVG = "" ;
      AV110ModificarSVG = "" ;
      AV111EliminarSVG = "" ;
      AV139Empresawwds_2_tfempnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV143Empresawwds_6_tfactdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV145Empresawwds_8_tftipempledescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV147Empresawwds_10_tfempzondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV138Empresawwds_1_tfempnom = "" ;
      lV142Empresawwds_5_tfactdescrip = "" ;
      lV144Empresawwds_7_tftipempledescri = "" ;
      lV146Empresawwds_9_tfempzondescrip = "" ;
      AV138Empresawwds_1_tfempnom = "" ;
      AV142Empresawwds_5_tfactdescrip = "" ;
      AV144Empresawwds_7_tftipempledescri = "" ;
      AV146Empresawwds_9_tfempzondescrip = "" ;
      H002H2_A43ActCodigo = new String[] {""} ;
      H002H2_n43ActCodigo = new boolean[] {false} ;
      H002H2_A45TipEmpleCod = new String[] {""} ;
      H002H2_n45TipEmpleCod = new boolean[] {false} ;
      H002H2_A44EmpZonCod = new String[] {""} ;
      H002H2_n44EmpZonCod = new boolean[] {false} ;
      H002H2_A518EmpZonDescrip = new String[] {""} ;
      H002H2_A339TipEmpleDescri = new String[] {""} ;
      H002H2_A108ActDescrip = new String[] {""} ;
      H002H2_A177EmpCUIT = new long[1] ;
      H002H2_A2EmpNom = new String[] {""} ;
      H002H2_A1EmpCod = new short[1] ;
      H002H2_A3CliCod = new int[1] ;
      A43ActCodigo = "" ;
      A45TipEmpleCod = "" ;
      A44EmpZonCod = "" ;
      H002H3_AGRID_nRecordCount = new long[1] ;
      AV121WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV8HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV116MenuBienveImgURL = "" ;
      AV118MenuBienveTitulo = "" ;
      AV119MenuBienveTexto = "" ;
      AV136Welcomemessage_foto_GXI = "" ;
      AV130observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext11 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV22Session = httpContext.getWebSession();
      AV18ColumnsSelectorXML = "" ;
      AV129MenuOpcTitulo = "" ;
      GXv_int12 = new short[1] ;
      AV133filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV123ManageFiltersXml = "" ;
      AV16ExcelFilename = "" ;
      AV17ErrorMessage = "" ;
      AV19UserCustomValue = "" ;
      AV21ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection[1] ;
      AV12GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char18 = "" ;
      GXt_char17 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char10 = "" ;
      GXv_char6 = new String[1] ;
      GXt_char9 = "" ;
      GXv_char5 = new String[1] ;
      GXv_SdtWWPGridState20 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV117textoNoMostrara = "" ;
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
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresaww__default(),
         new Object[] {
             new Object[] {
            H002H2_A43ActCodigo, H002H2_n43ActCodigo, H002H2_A45TipEmpleCod, H002H2_n45TipEmpleCod, H002H2_A44EmpZonCod, H002H2_n44EmpZonCod, H002H2_A518EmpZonDescrip, H002H2_A339TipEmpleDescri, H002H2_A108ActDescrip, H002H2_A177EmpCUIT,
            H002H2_A2EmpNom, H002H2_A1EmpCod, H002H2_A3CliCod
            }
            , new Object[] {
            H002H3_AGRID_nRecordCount
            }
         }
      );
      AV137Pgmname = "EmpresaWW" ;
      /* GeneXus formulas. */
      AV137Pgmname = "EmpresaWW" ;
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
   private byte AV124ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
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
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int12[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV92CliCod ;
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
   private int AV139Empresawwds_2_tfempnom_sels_size ;
   private int AV143Empresawwds_6_tfactdescrip_sels_size ;
   private int AV145Empresawwds_8_tftipempledescri_sels_size ;
   private int AV147Empresawwds_10_tfempzondescrip_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtEmpNom_Visible ;
   private int edtEmpCUIT_Visible ;
   private int edtActDescrip_Visible ;
   private int edtTipEmpleDescri_Visible ;
   private int edtEmpZonDescrip_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV132filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV62PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int AV148GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV27TFEmpCUIT ;
   private long AV108TFEmpCUIT_To ;
   private long AV63GridCurrentPage ;
   private long AV64GridPageCount ;
   private long A177EmpCUIT ;
   private long GRID_nCurrentRecord ;
   private long AV140Empresawwds_3_tfempcuit ;
   private long AV141Empresawwds_4_tfempcuit_to ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_110_idx="0001" ;
   private String AV137Pgmname ;
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
   private String edtEmpCod_Internalname ;
   private String edtEmpNom_Internalname ;
   private String edtEmpCUIT_Internalname ;
   private String edtActDescrip_Internalname ;
   private String edtTipEmpleDescri_Internalname ;
   private String edtEmpZonDescrip_Internalname ;
   private String AV105Update ;
   private String edtavUpdate_Internalname ;
   private String AV106Delete ;
   private String edtavDelete_Internalname ;
   private String AV112Display ;
   private String edtavDisplay_Internalname ;
   private String AV109VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV110ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV111EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String A43ActCodigo ;
   private String A45TipEmpleCod ;
   private String A44EmpZonCod ;
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
   private String AV130observerPalabra ;
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
   private String GXt_char18 ;
   private String GXt_char17 ;
   private String GXv_char7[] ;
   private String GXt_char10 ;
   private String GXv_char6[] ;
   private String GXt_char9 ;
   private String GXv_char5[] ;
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
   private String bttBtninsert_Internalname ;
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
   private String edtEmpCod_Jsonclick ;
   private String edtEmpNom_Jsonclick ;
   private String edtEmpCUIT_Jsonclick ;
   private String edtActDescrip_Jsonclick ;
   private String edtTipEmpleDescri_Jsonclick ;
   private String edtEmpZonDescrip_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV115WelcomeMessage_NoMostrarMas ;
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
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n43ActCodigo ;
   private boolean n45TipEmpleCod ;
   private boolean n44EmpZonCod ;
   private boolean returnInSub ;
   private boolean AV120MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean GXv_boolean8[] ;
   private boolean AV121WelcomeMessage_Foto_IsBlob ;
   private String AV68TFEmpNom_SelsJson ;
   private String AV86TFActDescrip_SelsJson ;
   private String AV90TFTipEmpleDescri_SelsJson ;
   private String AV99TFEmpZonDescrip_SelsJson ;
   private String AV119MenuBienveTexto ;
   private String AV18ColumnsSelectorXML ;
   private String AV123ManageFiltersXml ;
   private String AV19UserCustomValue ;
   private String AV117textoNoMostrara ;
   private String wcpOAV113MenuOpcCod ;
   private String AV113MenuOpcCod ;
   private String AV25TFEmpNom ;
   private String AV53TFActDescrip ;
   private String AV59TFTipEmpleDescri ;
   private String AV100TFEmpZonDescrip ;
   private String AV65GridAppliedFilters ;
   private String A2EmpNom ;
   private String A108ActDescrip ;
   private String A339TipEmpleDescri ;
   private String A518EmpZonDescrip ;
   private String lV138Empresawwds_1_tfempnom ;
   private String lV142Empresawwds_5_tfactdescrip ;
   private String lV144Empresawwds_7_tftipempledescri ;
   private String lV146Empresawwds_9_tfempzondescrip ;
   private String AV138Empresawwds_1_tfempnom ;
   private String AV142Empresawwds_5_tfactdescrip ;
   private String AV144Empresawwds_7_tftipempledescri ;
   private String AV146Empresawwds_9_tfempzondescrip ;
   private String AV116MenuBienveImgURL ;
   private String AV118MenuBienveTitulo ;
   private String AV136Welcomemessage_foto_GXI ;
   private String AV129MenuOpcTitulo ;
   private String AV133filtrosTexto ;
   private String AV16ExcelFilename ;
   private String AV17ErrorMessage ;
   private String AV121WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV139Empresawwds_2_tfempnom_sels ;
   private GXSimpleCollection<String> AV143Empresawwds_6_tfactdescrip_sels ;
   private GXSimpleCollection<String> AV145Empresawwds_8_tftipempledescri_sels ;
   private GXSimpleCollection<String> AV147Empresawwds_10_tfempzondescrip_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private IDataStoreProvider pr_default ;
   private String[] H002H2_A43ActCodigo ;
   private boolean[] H002H2_n43ActCodigo ;
   private String[] H002H2_A45TipEmpleCod ;
   private boolean[] H002H2_n45TipEmpleCod ;
   private String[] H002H2_A44EmpZonCod ;
   private boolean[] H002H2_n44EmpZonCod ;
   private String[] H002H2_A518EmpZonDescrip ;
   private String[] H002H2_A339TipEmpleDescri ;
   private String[] H002H2_A108ActDescrip ;
   private long[] H002H2_A177EmpCUIT ;
   private String[] H002H2_A2EmpNom ;
   private short[] H002H2_A1EmpCod ;
   private int[] H002H2_A3CliCod ;
   private long[] H002H3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV69TFEmpNom_Sels ;
   private GXSimpleCollection<String> AV87TFActDescrip_Sels ;
   private GXSimpleCollection<String> AV91TFTipEmpleDescri_Sels ;
   private GXSimpleCollection<String> AV101TFEmpZonDescrip_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV122ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item15 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item16[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext11[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState20[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV61DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class empresaww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002H2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2EmpNom ,
                                          GXSimpleCollection<String> AV139Empresawwds_2_tfempnom_sels ,
                                          String A108ActDescrip ,
                                          GXSimpleCollection<String> AV143Empresawwds_6_tfactdescrip_sels ,
                                          String A339TipEmpleDescri ,
                                          GXSimpleCollection<String> AV145Empresawwds_8_tftipempledescri_sels ,
                                          String A518EmpZonDescrip ,
                                          GXSimpleCollection<String> AV147Empresawwds_10_tfempzondescrip_sels ,
                                          int AV139Empresawwds_2_tfempnom_sels_size ,
                                          String AV138Empresawwds_1_tfempnom ,
                                          long AV140Empresawwds_3_tfempcuit ,
                                          long AV141Empresawwds_4_tfempcuit_to ,
                                          int AV143Empresawwds_6_tfactdescrip_sels_size ,
                                          String AV142Empresawwds_5_tfactdescrip ,
                                          int AV145Empresawwds_8_tftipempledescri_sels_size ,
                                          String AV144Empresawwds_7_tftipempledescri ,
                                          int AV147Empresawwds_10_tfempzondescrip_sels_size ,
                                          String AV146Empresawwds_9_tfempzondescrip ,
                                          long A177EmpCUIT ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV92CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[10];
      Object[] GXv_Object22 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.ActCodigo, T1.TipEmpleCod, T1.EmpZonCod AS EmpZonCod, T4.ZonDescrip AS EmpZonDescrip, T3.TipEmpleDescri, T2.ActDescrip, T1.EmpCUIT, T1.EmpNom, T1.EmpCod, T1.CliCod" ;
      sFromString = " FROM (((Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) LEFT JOIN TipoEmpleador T3 ON T3.TipEmpleCod = T1.TipEmpleCod) LEFT JOIN Zona T4 ON T4.ZonCod" ;
      sFromString += " = T1.EmpZonCod)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV139Empresawwds_2_tfempnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV138Empresawwds_1_tfempnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpNom) like LOWER(?))");
      }
      else
      {
         GXv_int21[1] = (byte)(1) ;
      }
      if ( AV139Empresawwds_2_tfempnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV139Empresawwds_2_tfempnom_sels, "T1.EmpNom IN (", ")")+")");
      }
      if ( ! (0==AV140Empresawwds_3_tfempcuit) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT >= ?)");
      }
      else
      {
         GXv_int21[2] = (byte)(1) ;
      }
      if ( ! (0==AV141Empresawwds_4_tfempcuit_to) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT <= ?)");
      }
      else
      {
         GXv_int21[3] = (byte)(1) ;
      }
      if ( ( AV143Empresawwds_6_tfactdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV142Empresawwds_5_tfactdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ActDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int21[4] = (byte)(1) ;
      }
      if ( AV143Empresawwds_6_tfactdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV143Empresawwds_6_tfactdescrip_sels, "T2.ActDescrip IN (", ")")+")");
      }
      if ( ( AV145Empresawwds_8_tftipempledescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV144Empresawwds_7_tftipempledescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipEmpleDescri) like LOWER(?))");
      }
      else
      {
         GXv_int21[5] = (byte)(1) ;
      }
      if ( AV145Empresawwds_8_tftipempledescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV145Empresawwds_8_tftipempledescri_sels, "T3.TipEmpleDescri IN (", ")")+")");
      }
      if ( ( AV147Empresawwds_10_tfempzondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV146Empresawwds_9_tfempzondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.ZonDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int21[6] = (byte)(1) ;
      }
      if ( AV147Empresawwds_10_tfempzondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV147Empresawwds_10_tfempzondescrip_sels, "T4.ZonDescrip IN (", ")")+")");
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.EmpNom, T1.CliCod, T1.EmpCod" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.EmpNom DESC, T1.CliCod, T1.EmpCod" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.EmpCUIT, T1.CliCod, T1.EmpCod" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.EmpCUIT DESC, T1.CliCod, T1.EmpCod" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.ActDescrip, T1.CliCod, T1.EmpCod" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.ActDescrip DESC, T1.CliCod, T1.EmpCod" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.TipEmpleDescri, T1.CliCod, T1.EmpCod" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.TipEmpleDescri DESC, T1.CliCod, T1.EmpCod" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T4.ZonDescrip, T1.CliCod, T1.EmpCod" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T4.ZonDescrip DESC, T1.CliCod, T1.EmpCod" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
   }

   protected Object[] conditional_H002H3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2EmpNom ,
                                          GXSimpleCollection<String> AV139Empresawwds_2_tfempnom_sels ,
                                          String A108ActDescrip ,
                                          GXSimpleCollection<String> AV143Empresawwds_6_tfactdescrip_sels ,
                                          String A339TipEmpleDescri ,
                                          GXSimpleCollection<String> AV145Empresawwds_8_tftipempledescri_sels ,
                                          String A518EmpZonDescrip ,
                                          GXSimpleCollection<String> AV147Empresawwds_10_tfempzondescrip_sels ,
                                          int AV139Empresawwds_2_tfempnom_sels_size ,
                                          String AV138Empresawwds_1_tfempnom ,
                                          long AV140Empresawwds_3_tfempcuit ,
                                          long AV141Empresawwds_4_tfempcuit_to ,
                                          int AV143Empresawwds_6_tfactdescrip_sels_size ,
                                          String AV142Empresawwds_5_tfactdescrip ,
                                          int AV145Empresawwds_8_tftipempledescri_sels_size ,
                                          String AV144Empresawwds_7_tftipempledescri ,
                                          int AV147Empresawwds_10_tfempzondescrip_sels_size ,
                                          String AV146Empresawwds_9_tfempzondescrip ,
                                          long A177EmpCUIT ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV92CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int24 = new byte[7];
      Object[] GXv_Object25 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (((Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) LEFT JOIN TipoEmpleador T3 ON T3.TipEmpleCod = T1.TipEmpleCod) LEFT JOIN" ;
      scmdbuf += " Zona T4 ON T4.ZonCod = T1.EmpZonCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV139Empresawwds_2_tfempnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV138Empresawwds_1_tfempnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpNom) like LOWER(?))");
      }
      else
      {
         GXv_int24[1] = (byte)(1) ;
      }
      if ( AV139Empresawwds_2_tfempnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV139Empresawwds_2_tfempnom_sels, "T1.EmpNom IN (", ")")+")");
      }
      if ( ! (0==AV140Empresawwds_3_tfempcuit) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT >= ?)");
      }
      else
      {
         GXv_int24[2] = (byte)(1) ;
      }
      if ( ! (0==AV141Empresawwds_4_tfempcuit_to) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT <= ?)");
      }
      else
      {
         GXv_int24[3] = (byte)(1) ;
      }
      if ( ( AV143Empresawwds_6_tfactdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV142Empresawwds_5_tfactdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ActDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int24[4] = (byte)(1) ;
      }
      if ( AV143Empresawwds_6_tfactdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV143Empresawwds_6_tfactdescrip_sels, "T2.ActDescrip IN (", ")")+")");
      }
      if ( ( AV145Empresawwds_8_tftipempledescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV144Empresawwds_7_tftipempledescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipEmpleDescri) like LOWER(?))");
      }
      else
      {
         GXv_int24[5] = (byte)(1) ;
      }
      if ( AV145Empresawwds_8_tftipempledescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV145Empresawwds_8_tftipempledescri_sels, "T3.TipEmpleDescri IN (", ")")+")");
      }
      if ( ( AV147Empresawwds_10_tfempzondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV146Empresawwds_9_tfempzondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.ZonDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int24[6] = (byte)(1) ;
      }
      if ( AV147Empresawwds_10_tfempzondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV147Empresawwds_10_tfempzondescrip_sels, "T4.ZonDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
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
                  return conditional_H002H2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).longValue() , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() );
            case 1 :
                  return conditional_H002H3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).longValue() , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002H2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002H3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 4);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(4);
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((long[]) buf[9])[0] = rslt.getLong(7);
               ((String[]) buf[10])[0] = rslt.getVarchar(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               ((int[]) buf[12])[0] = rslt.getInt(10);
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
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[12]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[13]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 150);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
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
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[9]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[10]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 150);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 400);
               }
               return;
      }
   }

}

