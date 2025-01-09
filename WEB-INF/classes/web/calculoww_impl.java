package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class calculoww_impl extends GXDataArea
{
   public calculoww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public calculoww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculoww_impl.class ));
   }

   public calculoww_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbidOperando = new HTMLChoice();
      chkavTieneparametros = UIFactory.getCheckbox(this);
      chkOpeEsCant = UIFactory.getCheckbox(this);
      chkOpeAliEs = UIFactory.getCheckbox(this);
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
            AV61MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61MenuOpcCod", AV61MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV61MenuOpcCod, ""))));
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
      AV76ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV19ColumnsSelector);
      AV89Pgmname = httpContext.GetPar( "Pgmname") ;
      AV61MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV27TFOpeCodFormula = httpContext.GetPar( "TFOpeCodFormula") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV28TFOpeCodFormula_Sels);
      AV30TFOpeDescripcion = httpContext.GetPar( "TFOpeDescripcion") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV31TFOpeDescripcion_Sels);
      AV54TFOpeEsCant_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFOpeEsCant_Sel"))) ;
      AV55TFOpeAliEs_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFOpeAliEs_Sel"))) ;
      AV49CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV72sistema_CliCod = (int)(GXutil.lval( httpContext.GetPar( "sistema_CliCod"))) ;
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV63WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV19ColumnsSelector, AV89Pgmname, AV61MenuOpcCod, AV12GridState, AV27TFOpeCodFormula, AV28TFOpeCodFormula_Sels, AV30TFOpeDescripcion, AV31TFOpeDescripcion_Sels, AV54TFOpeEsCant_Sel, AV55TFOpeAliEs_Sel, AV49CliCod, AV72sistema_CliCod, AV14OrderedBy, AV15OrderedDsc, AV63WelcomeMessage_NoMostrarMas) ;
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
      pa9N2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start9N2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV61MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV89Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV61MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV49CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSISTEMA_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV72sistema_CliCod), "ZZZZZ9")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV42DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV42DDO_TitleSettingsIcons);
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV74ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV74ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV44GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV45GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV46GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV76ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV89Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV89Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV61MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV61MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPECODFORMULA", GXutil.rtrim( AV27TFOpeCodFormula));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFOPECODFORMULA_SELS", AV28TFOpeCodFormula_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFOPECODFORMULA_SELS", AV28TFOpeCodFormula_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPEDESCRIPCION", AV30TFOpeDescripcion);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFOPEDESCRIPCION_SELS", AV31TFOpeDescripcion_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFOPEDESCRIPCION_SELS", AV31TFOpeDescripcion_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPEESCANT_SEL", GXutil.ltrim( localUtil.ntoc( AV54TFOpeEsCant_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPEALIES_SEL", GXutil.ltrim( localUtil.ntoc( AV55TFOpeAliEs_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV49CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV49CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSISTEMA_CLICOD", GXutil.ltrim( localUtil.ntoc( AV72sistema_CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSISTEMA_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV72sistema_CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPECODFORMULA_SELSJSON", AV26TFOpeCodFormula_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFOPEDESCRIPCION_SELSJSON", AV29TFOpeDescripcion_SelsJson);
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
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
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
         we9N2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt9N2( ) ;
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
      return formatLink("web.calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV61MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "CalculoWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Cálculos", "") ;
   }

   public void wb9N0( )
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
         wb_table1_9_9N2( true) ;
      }
      else
      {
         wb_table1_9_9N2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_9N2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnreportarnousados_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Reportar no usados", ""), bttBtnreportarnousados_Jsonclick, 5, httpContext.getMessage( "Reportar no usados", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOREPORTARNOUSADOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CalculoWW.htm");
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
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV42DDO_TitleSettingsIcons);
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

   public void start9N2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Cálculos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup9N0( ) ;
   }

   public void ws9N2( )
   {
      start9N2( ) ;
      evt9N2( ) ;
   }

   public void evt9N2( )
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
                           e119N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e129N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e139N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e149N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e159N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOREPORTARNOUSADOS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoReportarnousados' */
                           e169N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e179N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e189N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e199N2 ();
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
                           cmbidOperando.setName( cmbidOperando.getInternalname() );
                           cmbidOperando.setValue( httpContext.cgiGet( cmbidOperando.getInternalname()) );
                           A74idOperando = httpContext.cgiGet( cmbidOperando.getInternalname()) ;
                           A473OpeCodFormula = httpContext.cgiGet( edtOpeCodFormula_Internalname) ;
                           A474OpeDescripcion = httpContext.cgiGet( edtOpeDescripcion_Internalname) ;
                           AV70tieneParametros = GXutil.strtobool( httpContext.cgiGet( chkavTieneparametros.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavTieneparametros.getInternalname(), AV70tieneParametros);
                           A932OpeEsCant = GXutil.strtobool( httpContext.cgiGet( chkOpeEsCant.getInternalname())) ;
                           A1032OpeAliEs = GXutil.strtobool( httpContext.cgiGet( chkOpeAliEs.getInternalname())) ;
                           AV60Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV60Display);
                           AV59VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV59VerSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e209N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e219N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e229N2 ();
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

   public void we9N2( )
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

   public void pa9N2( )
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
                                 byte AV76ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ,
                                 String AV89Pgmname ,
                                 String AV61MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 String AV27TFOpeCodFormula ,
                                 GXSimpleCollection<String> AV28TFOpeCodFormula_Sels ,
                                 String AV30TFOpeDescripcion ,
                                 GXSimpleCollection<String> AV31TFOpeDescripcion_Sels ,
                                 byte AV54TFOpeEsCant_Sel ,
                                 byte AV55TFOpeAliEs_Sel ,
                                 int AV49CliCod ,
                                 int AV72sistema_CliCod ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 boolean AV63WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e219N2 ();
      GRID_nCurrentRecord = 0 ;
      rf9N2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "PAICOD", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_IDOPERANDO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A74idOperando, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "IDOPERANDO", GXutil.rtrim( A74idOperando));
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
      AV63WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV63WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63WelcomeMessage_NoMostrarMas", AV63WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf9N2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV89Pgmname = "CalculoWW" ;
      Gx_err = (short)(0) ;
      chkavTieneparametros.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavTieneparametros.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTieneparametros.getEnabled(), 5, 0), !bGXsfl_110_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
   }

   public void rf9N2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e219N2 ();
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
                                              A473OpeCodFormula ,
                                              AV91Calculowwds_2_tfopecodformula_sels ,
                                              A474OpeDescripcion ,
                                              AV93Calculowwds_4_tfopedescripcion_sels ,
                                              Integer.valueOf(AV91Calculowwds_2_tfopecodformula_sels.size()) ,
                                              AV90Calculowwds_1_tfopecodformula ,
                                              Integer.valueOf(AV93Calculowwds_4_tfopedescripcion_sels.size()) ,
                                              AV92Calculowwds_3_tfopedescripcion ,
                                              Byte.valueOf(AV94Calculowwds_5_tfopeescant_sel) ,
                                              Byte.valueOf(AV95Calculowwds_6_tfopealies_sel) ,
                                              Boolean.valueOf(A932OpeEsCant) ,
                                              Boolean.valueOf(A1032OpeAliEs) ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV90Calculowwds_1_tfopecodformula = GXutil.padr( GXutil.rtrim( AV90Calculowwds_1_tfopecodformula), 40, "%") ;
         lV92Calculowwds_3_tfopedescripcion = GXutil.concat( GXutil.rtrim( AV92Calculowwds_3_tfopedescripcion), "%", "") ;
         /* Using cursor H009N2 */
         pr_default.execute(0, new Object[] {lV90Calculowwds_1_tfopecodformula, lV92Calculowwds_3_tfopedescripcion, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1032OpeAliEs = H009N2_A1032OpeAliEs[0] ;
            A932OpeEsCant = H009N2_A932OpeEsCant[0] ;
            A474OpeDescripcion = H009N2_A474OpeDescripcion[0] ;
            A473OpeCodFormula = H009N2_A473OpeCodFormula[0] ;
            A74idOperando = H009N2_A74idOperando[0] ;
            A46PaiCod = H009N2_A46PaiCod[0] ;
            e229N2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wb9N0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes9N2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV89Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV89Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV61MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV61MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV49CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV49CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSISTEMA_CLICOD", GXutil.ltrim( localUtil.ntoc( AV72sistema_CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSISTEMA_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV72sistema_CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAICOD"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_IDOPERANDO"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, GXutil.rtrim( localUtil.format( A74idOperando, ""))));
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
      AV90Calculowwds_1_tfopecodformula = AV27TFOpeCodFormula ;
      AV91Calculowwds_2_tfopecodformula_sels = AV28TFOpeCodFormula_Sels ;
      AV92Calculowwds_3_tfopedescripcion = AV30TFOpeDescripcion ;
      AV93Calculowwds_4_tfopedescripcion_sels = AV31TFOpeDescripcion_Sels ;
      AV94Calculowwds_5_tfopeescant_sel = AV54TFOpeEsCant_Sel ;
      AV95Calculowwds_6_tfopealies_sel = AV55TFOpeAliEs_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A473OpeCodFormula ,
                                           AV91Calculowwds_2_tfopecodformula_sels ,
                                           A474OpeDescripcion ,
                                           AV93Calculowwds_4_tfopedescripcion_sels ,
                                           Integer.valueOf(AV91Calculowwds_2_tfopecodformula_sels.size()) ,
                                           AV90Calculowwds_1_tfopecodformula ,
                                           Integer.valueOf(AV93Calculowwds_4_tfopedescripcion_sels.size()) ,
                                           AV92Calculowwds_3_tfopedescripcion ,
                                           Byte.valueOf(AV94Calculowwds_5_tfopeescant_sel) ,
                                           Byte.valueOf(AV95Calculowwds_6_tfopealies_sel) ,
                                           Boolean.valueOf(A932OpeEsCant) ,
                                           Boolean.valueOf(A1032OpeAliEs) ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV90Calculowwds_1_tfopecodformula = GXutil.padr( GXutil.rtrim( AV90Calculowwds_1_tfopecodformula), 40, "%") ;
      lV92Calculowwds_3_tfopedescripcion = GXutil.concat( GXutil.rtrim( AV92Calculowwds_3_tfopedescripcion), "%", "") ;
      /* Using cursor H009N3 */
      pr_default.execute(1, new Object[] {lV90Calculowwds_1_tfopecodformula, lV92Calculowwds_3_tfopedescripcion});
      GRID_nRecordCount = H009N3_AGRID_nRecordCount[0] ;
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
      AV90Calculowwds_1_tfopecodformula = AV27TFOpeCodFormula ;
      AV91Calculowwds_2_tfopecodformula_sels = AV28TFOpeCodFormula_Sels ;
      AV92Calculowwds_3_tfopedescripcion = AV30TFOpeDescripcion ;
      AV93Calculowwds_4_tfopedescripcion_sels = AV31TFOpeDescripcion_Sels ;
      AV94Calculowwds_5_tfopeescant_sel = AV54TFOpeEsCant_Sel ;
      AV95Calculowwds_6_tfopealies_sel = AV55TFOpeAliEs_Sel ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV19ColumnsSelector, AV89Pgmname, AV61MenuOpcCod, AV12GridState, AV27TFOpeCodFormula, AV28TFOpeCodFormula_Sels, AV30TFOpeDescripcion, AV31TFOpeDescripcion_Sels, AV54TFOpeEsCant_Sel, AV55TFOpeAliEs_Sel, AV49CliCod, AV72sistema_CliCod, AV14OrderedBy, AV15OrderedDsc, AV63WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV90Calculowwds_1_tfopecodformula = AV27TFOpeCodFormula ;
      AV91Calculowwds_2_tfopecodformula_sels = AV28TFOpeCodFormula_Sels ;
      AV92Calculowwds_3_tfopedescripcion = AV30TFOpeDescripcion ;
      AV93Calculowwds_4_tfopedescripcion_sels = AV31TFOpeDescripcion_Sels ;
      AV94Calculowwds_5_tfopeescant_sel = AV54TFOpeEsCant_Sel ;
      AV95Calculowwds_6_tfopealies_sel = AV55TFOpeAliEs_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV19ColumnsSelector, AV89Pgmname, AV61MenuOpcCod, AV12GridState, AV27TFOpeCodFormula, AV28TFOpeCodFormula_Sels, AV30TFOpeDescripcion, AV31TFOpeDescripcion_Sels, AV54TFOpeEsCant_Sel, AV55TFOpeAliEs_Sel, AV49CliCod, AV72sistema_CliCod, AV14OrderedBy, AV15OrderedDsc, AV63WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV90Calculowwds_1_tfopecodformula = AV27TFOpeCodFormula ;
      AV91Calculowwds_2_tfopecodformula_sels = AV28TFOpeCodFormula_Sels ;
      AV92Calculowwds_3_tfopedescripcion = AV30TFOpeDescripcion ;
      AV93Calculowwds_4_tfopedescripcion_sels = AV31TFOpeDescripcion_Sels ;
      AV94Calculowwds_5_tfopeescant_sel = AV54TFOpeEsCant_Sel ;
      AV95Calculowwds_6_tfopealies_sel = AV55TFOpeAliEs_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV19ColumnsSelector, AV89Pgmname, AV61MenuOpcCod, AV12GridState, AV27TFOpeCodFormula, AV28TFOpeCodFormula_Sels, AV30TFOpeDescripcion, AV31TFOpeDescripcion_Sels, AV54TFOpeEsCant_Sel, AV55TFOpeAliEs_Sel, AV49CliCod, AV72sistema_CliCod, AV14OrderedBy, AV15OrderedDsc, AV63WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV90Calculowwds_1_tfopecodformula = AV27TFOpeCodFormula ;
      AV91Calculowwds_2_tfopecodformula_sels = AV28TFOpeCodFormula_Sels ;
      AV92Calculowwds_3_tfopedescripcion = AV30TFOpeDescripcion ;
      AV93Calculowwds_4_tfopedescripcion_sels = AV31TFOpeDescripcion_Sels ;
      AV94Calculowwds_5_tfopeescant_sel = AV54TFOpeEsCant_Sel ;
      AV95Calculowwds_6_tfopealies_sel = AV55TFOpeAliEs_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV19ColumnsSelector, AV89Pgmname, AV61MenuOpcCod, AV12GridState, AV27TFOpeCodFormula, AV28TFOpeCodFormula_Sels, AV30TFOpeDescripcion, AV31TFOpeDescripcion_Sels, AV54TFOpeEsCant_Sel, AV55TFOpeAliEs_Sel, AV49CliCod, AV72sistema_CliCod, AV14OrderedBy, AV15OrderedDsc, AV63WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV90Calculowwds_1_tfopecodformula = AV27TFOpeCodFormula ;
      AV91Calculowwds_2_tfopecodformula_sels = AV28TFOpeCodFormula_Sels ;
      AV92Calculowwds_3_tfopedescripcion = AV30TFOpeDescripcion ;
      AV93Calculowwds_4_tfopedescripcion_sels = AV31TFOpeDescripcion_Sels ;
      AV94Calculowwds_5_tfopeescant_sel = AV54TFOpeEsCant_Sel ;
      AV95Calculowwds_6_tfopealies_sel = AV55TFOpeAliEs_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV19ColumnsSelector, AV89Pgmname, AV61MenuOpcCod, AV12GridState, AV27TFOpeCodFormula, AV28TFOpeCodFormula_Sels, AV30TFOpeDescripcion, AV31TFOpeDescripcion_Sels, AV54TFOpeEsCant_Sel, AV55TFOpeAliEs_Sel, AV49CliCod, AV72sistema_CliCod, AV14OrderedBy, AV15OrderedDsc, AV63WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV89Pgmname = "CalculoWW" ;
      Gx_err = (short)(0) ;
      chkavTieneparametros.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavTieneparametros.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTieneparametros.getEnabled(), 5, 0), !bGXsfl_110_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup9N0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e209N2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV42DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV19ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV74ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV44GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV45GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV46GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( "DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Fixable = httpContext.cgiGet( "DDO_GRID_Fixable") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( "DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( "DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( "DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( "DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
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
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV69WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV63WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63WelcomeMessage_NoMostrarMas", AV63WelcomeMessage_NoMostrarMas);
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
      e209N2 ();
      if (returnInSub) return;
   }

   public void e209N2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV61MenuOpcCod, "", "") ;
      GXt_int1 = AV49CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      calculoww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV49CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV49CliCod), "ZZZZZ9")));
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
      Form.setCaption( httpContext.getMessage( " Cálculos", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV42DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV42DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV64MenuBienveImgURL ;
      GXv_char6[0] = AV66MenuBienveTitulo ;
      GXv_char7[0] = AV67MenuBienveTexto ;
      GXv_boolean8[0] = AV68MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV61MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      calculoww_impl.this.AV64MenuBienveImgURL = GXv_char5[0] ;
      calculoww_impl.this.AV66MenuBienveTitulo = GXv_char6[0] ;
      calculoww_impl.this.AV67MenuBienveTexto = GXv_char7[0] ;
      calculoww_impl.this.AV68MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV68MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV68MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV66MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV67MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV69WelcomeMessage_Foto = AV64MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV69WelcomeMessage_Foto)==0) ? AV88Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV69WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV69WelcomeMessage_Foto), true);
         AV88Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV64MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV69WelcomeMessage_Foto)==0) ? AV88Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV69WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV69WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      calculoww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      calculoww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV82observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV82observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV82observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV82observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXv_int11[0] = AV71PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV49CliCod, GXv_int11) ;
      calculoww_impl.this.AV71PaiCod = GXv_int11[0] ;
      GXv_int2[0] = AV72sistema_CliCod ;
      new web.clientenucleodepais(remoteHandle, context).execute( AV71PaiCod, GXv_int2) ;
      calculoww_impl.this.AV72sistema_CliCod = GXv_int2[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72sistema_CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV72sistema_CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSISTEMA_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV72sistema_CliCod), "ZZZZZ9")));
   }

   public void e219N2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV49CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      calculoww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV49CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV49CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext12[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext12) ;
      AV6WWPContext = GXv_SdtWWPContext12[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV76ManageFiltersExecutionStep == 1 )
      {
         AV76ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV76ManageFiltersExecutionStep == 2 )
      {
         AV76ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV21Session.getValue("CalculoWWColumnsSelector"), "") != 0 )
      {
         AV17ColumnsSelectorXML = AV21Session.getValue("CalculoWWColumnsSelector") ;
         AV19ColumnsSelector.fromxml(AV17ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtOpeCodFormula_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCodFormula_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCodFormula_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtOpeDescripcion_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeDescripcion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeDescripcion_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkavTieneparametros.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkavTieneparametros.getInternalname(), "Visible", GXutil.ltrimstr( chkavTieneparametros.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkOpeEsCant.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeEsCant.getInternalname(), "Visible", GXutil.ltrimstr( chkOpeEsCant.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkOpeAliEs.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeAliEs.getInternalname(), "Visible", GXutil.ltrimstr( chkOpeAliEs.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV44GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44GridCurrentPage), 10, 0));
      AV45GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45GridPageCount), 10, 0));
      GXt_char10 = AV46GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV89Pgmname, GXv_char7) ;
      calculoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV46GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46GridAppliedFilters", AV46GridAppliedFilters);
      GXt_char10 = AV81MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV61MenuOpcCod, GXv_char7) ;
      calculoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV81MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV81MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV81MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int11[0] = (short)(AV84filterCount) ;
      GXv_char7[0] = AV85filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int11, GXv_char7) ;
      calculoww_impl.this.AV84filterCount = GXv_int11[0] ;
      calculoww_impl.this.AV85filtrosTexto = GXv_char7[0] ;
      if ( AV84filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV84filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV85filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV90Calculowwds_1_tfopecodformula = AV27TFOpeCodFormula ;
      AV91Calculowwds_2_tfopecodformula_sels = AV28TFOpeCodFormula_Sels ;
      AV92Calculowwds_3_tfopedescripcion = AV30TFOpeDescripcion ;
      AV93Calculowwds_4_tfopedescripcion_sels = AV31TFOpeDescripcion_Sels ;
      AV94Calculowwds_5_tfopeescant_sel = AV54TFOpeEsCant_Sel ;
      AV95Calculowwds_6_tfopealies_sel = AV55TFOpeAliEs_Sel ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV74ManageFiltersData", AV74ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e139N2( )
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
         AV43PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV43PageToGo) ;
      }
   }

   public void e149N2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e159N2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OpeCodFormula") == 0 )
         {
            AV27TFOpeCodFormula = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFOpeCodFormula", AV27TFOpeCodFormula);
            AV26TFOpeCodFormula_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFOpeCodFormula_SelsJson", AV26TFOpeCodFormula_SelsJson);
            AV28TFOpeCodFormula_Sels.fromJSonString(AV26TFOpeCodFormula_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OpeDescripcion") == 0 )
         {
            AV30TFOpeDescripcion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFOpeDescripcion", AV30TFOpeDescripcion);
            AV29TFOpeDescripcion_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFOpeDescripcion_SelsJson", AV29TFOpeDescripcion_SelsJson);
            AV31TFOpeDescripcion_Sels.fromJSonString(AV29TFOpeDescripcion_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OpeEsCant") == 0 )
         {
            AV54TFOpeEsCant_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFOpeEsCant_Sel", GXutil.str( AV54TFOpeEsCant_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "OpeAliEs") == 0 )
         {
            AV55TFOpeAliEs_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFOpeAliEs_Sel", GXutil.str( AV55TFOpeAliEs_Sel, 1, 0));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28TFOpeCodFormula_Sels", AV28TFOpeCodFormula_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31TFOpeDescripcion_Sels", AV31TFOpeDescripcion_Sels);
   }

   private void e229N2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV60Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV60Display);
      edtavDisplay_Link = formatLink("web.calculoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(A74idOperando)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PaiCod","idOperando","TabCode"})  ;
      GXt_boolean13 = AV70tieneParametros ;
      GXv_boolean8[0] = GXt_boolean13 ;
      new web.calculotieneparametros(remoteHandle, context).execute( A46PaiCod, A74idOperando, GXv_boolean8) ;
      calculoww_impl.this.GXt_boolean13 = GXv_boolean8[0] ;
      AV70tieneParametros = GXt_boolean13 ;
      httpContext.ajax_rsp_assign_attri("", false, chkavTieneparametros.getInternalname(), AV70tieneParametros);
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV59VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      calculoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV59VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV59VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
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

   public void e119N2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV17ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV19ColumnsSelector.fromJSonString(AV17ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "CalculoWWColumnsSelector", ((GXutil.strcmp("", AV17ColumnsSelectorXML)==0) ? "" : AV19ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV74ManageFiltersData", AV74ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e129N2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("CalculoWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV89Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV76ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("CalculoWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV76ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV75ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "CalculoWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         calculoww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV75ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV75ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV89Pgmname+"GridState", AV75ManageFiltersXml) ;
            AV12GridState.fromxml(AV75ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28TFOpeCodFormula_Sels", AV28TFOpeCodFormula_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31TFOpeDescripcion_Sels", AV31TFOpeDescripcion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV74ManageFiltersData", AV74ManageFiltersData);
   }

   public void e169N2( )
   {
      /* 'DoReportarnousados' Routine */
      returnInSub = false ;
      new web.reportarcalculosnousados(remoteHandle, context).execute( ) ;
   }

   public void e179N2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","PaiCod","idOperando"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e189N2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV52ExcelFilename ;
      GXv_char6[0] = AV53ErrorMessage ;
      new web.calculowwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      calculoww_impl.this.AV52ExcelFilename = GXv_char7[0] ;
      calculoww_impl.this.AV53ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV52ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV52ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV53ErrorMessage);
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OpeCodFormula", "", "Código", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OpeDescripcion", "", "Descripción", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&tieneParametros", "", "Tiene parámetros", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OpeEsCant", "", "Determina cantidad", false, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "OpeAliEs", "", "Es alícuota", false, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&VerSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXt_char10 = AV18UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "CalculoWWColumnsSelector", GXv_char7) ;
      calculoww_impl.this.GXt_char10 = GXv_char7[0] ;
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
      new web.fixcolumnsselector(remoteHandle, context).execute( AV49CliCod, GXv_SdtWWPColumnsSelector15) ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean13 = AV73TempBoolean ;
      GXv_boolean8[0] = GXt_boolean13 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWOperando_Insert", GXv_boolean8) ;
      calculoww_impl.this.GXt_boolean13 = GXv_boolean8[0] ;
      AV73TempBoolean = GXt_boolean13 ;
      if ( ! ( AV73TempBoolean && ( ( AV49CliCod == AV72sistema_CliCod ) ) ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV74ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "CalculoWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV74ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV27TFOpeCodFormula = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFOpeCodFormula", AV27TFOpeCodFormula);
      AV28TFOpeCodFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV30TFOpeDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFOpeDescripcion", AV30TFOpeDescripcion);
      AV31TFOpeDescripcion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54TFOpeEsCant_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54TFOpeEsCant_Sel", GXutil.str( AV54TFOpeEsCant_Sel, 1, 0));
      AV55TFOpeAliEs_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFOpeAliEs_Sel", GXutil.str( AV55TFOpeAliEs_Sel, 1, 0));
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue(AV89Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV89Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV21Session.getValue(AV89Pgmname+"GridState"), null, null);
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
      AV96GXV1 = 1 ;
      while ( AV96GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV96GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECODFORMULA") == 0 )
         {
            AV27TFOpeCodFormula = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFOpeCodFormula", AV27TFOpeCodFormula);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECODFORMULA_SEL") == 0 )
         {
            AV26TFOpeCodFormula_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFOpeCodFormula_SelsJson", AV26TFOpeCodFormula_SelsJson);
            AV28TFOpeCodFormula_Sels.fromJSonString(AV26TFOpeCodFormula_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPEDESCRIPCION") == 0 )
         {
            AV30TFOpeDescripcion = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFOpeDescripcion", AV30TFOpeDescripcion);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPEDESCRIPCION_SEL") == 0 )
         {
            AV29TFOpeDescripcion_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFOpeDescripcion_SelsJson", AV29TFOpeDescripcion_SelsJson);
            AV31TFOpeDescripcion_Sels.fromJSonString(AV29TFOpeDescripcion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPEESCANT_SEL") == 0 )
         {
            AV54TFOpeEsCant_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFOpeEsCant_Sel", GXutil.str( AV54TFOpeEsCant_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPEALIES_SEL") == 0 )
         {
            AV55TFOpeAliEs_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFOpeAliEs_Sel", GXutil.str( AV55TFOpeAliEs_Sel, 1, 0));
         }
         AV96GXV1 = (int)(AV96GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV28TFOpeCodFormula_Sels.size()==0), AV26TFOpeCodFormula_SelsJson, GXv_char7) ;
      calculoww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV31TFOpeDescripcion_Sels.size()==0), AV29TFOpeDescripcion_SelsJson, GXv_char6) ;
      calculoww_impl.this.GXt_char9 = GXv_char6[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char10+"|"+GXt_char9+"||"+((0==AV54TFOpeEsCant_Sel) ? "" : GXutil.str( AV54TFOpeEsCant_Sel, 1, 0))+"|"+((0==AV55TFOpeAliEs_Sel) ? "" : GXutil.str( AV55TFOpeAliEs_Sel, 1, 0)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV27TFOpeCodFormula)==0), AV27TFOpeCodFormula, GXv_char7) ;
      calculoww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFOpeDescripcion)==0), AV30TFOpeDescripcion, GXv_char6) ;
      calculoww_impl.this.GXt_char9 = GXv_char6[0] ;
      Ddo_grid_Filteredtext_set = GXt_char10+"|"+GXt_char9+"|||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV21Session.getValue(AV89Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFOPECODFORMULA", httpContext.getMessage( "Código", ""), !(GXutil.strcmp("", AV27TFOpeCodFormula)==0), (short)(0), AV27TFOpeCodFormula, "", !(AV28TFOpeCodFormula_Sels.size()==0), AV28TFOpeCodFormula_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFOPEDESCRIPCION", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV30TFOpeDescripcion)==0), (short)(0), AV30TFOpeDescripcion, "", !(AV31TFOpeDescripcion_Sels.size()==0), AV31TFOpeDescripcion_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFOPEESCANT_SEL", httpContext.getMessage( "Determina cantidad", ""), !(0==AV54TFOpeEsCant_Sel), (short)(0), GXutil.trim( GXutil.str( AV54TFOpeEsCant_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFOPEALIES_SEL", httpContext.getMessage( "Es alícuota", ""), !(0==AV55TFOpeAliEs_Sel), (short)(0), GXutil.trim( GXutil.str( AV55TFOpeAliEs_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      if ( ! (GXutil.strcmp("", AV61MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV61MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV89Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV89Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Calculo" );
      AV21Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e199N2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV63WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV61MenuOpcCod, GXv_boolean8) ;
         GXv_char7[0] = AV65textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV49CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char7) ;
         calculoww_impl.this.AV65textoNoMostrara = GXv_char7[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV65textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV61MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_9N2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_9N2( true) ;
      }
      else
      {
         wb_table2_12_9N2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_9N2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_9N2e( true) ;
      }
      else
      {
         wb_table1_9_9N2e( false) ;
      }
   }

   public void wb_table2_12_9N2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e239n1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_CalculoWW.htm");
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
         AV69WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV69WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV88Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV69WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV69WelcomeMessage_Foto)==0) ? AV88Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV69WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV69WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_CalculoWW.htm");
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
         wb_table3_30_9N2( true) ;
      }
      else
      {
         wb_table3_30_9N2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_9N2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_9N2( true) ;
      }
      else
      {
         wb_table4_35_9N2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_9N2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV63WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_CalculoWW.htm");
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
         wb_table5_54_9N2( true) ;
      }
      else
      {
         wb_table5_54_9N2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_9N2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_9N2( true) ;
      }
      else
      {
         wb_table6_63_9N2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_9N2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV44GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV45GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV46GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_9N2e( true) ;
      }
      else
      {
         wb_table2_12_9N2e( false) ;
      }
   }

   public void wb_table6_63_9N2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_CalculoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_CalculoWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV42DDO_TitleSettingsIcons);
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV74ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CalculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CalculoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_CalculoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_CalculoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_9N2( true) ;
      }
      else
      {
         wb_table7_99_9N2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_9N2e( boolean wbgen )
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
         wb_table6_63_9N2e( true) ;
      }
      else
      {
         wb_table6_63_9N2e( false) ;
      }
   }

   public void wb_table7_99_9N2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_CalculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_9N2e( true) ;
      }
      else
      {
         wb_table7_99_9N2e( false) ;
      }
   }

   public void wb_table5_54_9N2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_CalculoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_CalculoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_9N2e( true) ;
      }
      else
      {
         wb_table5_54_9N2e( false) ;
      }
   }

   public void wb_table4_35_9N2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_CalculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_9N2e( true) ;
      }
      else
      {
         wb_table4_35_9N2e( false) ;
      }
   }

   public void wb_table3_30_9N2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_CalculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_9N2e( true) ;
      }
      else
      {
         wb_table3_30_9N2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV61MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61MenuOpcCod", AV61MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV61MenuOpcCod, ""))));
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
      pa9N2( ) ;
      ws9N2( ) ;
      we9N2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412201942833", true, true);
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
      httpContext.AddJavascriptSource("calculoww.js", "?202412201942833", false, true);
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
      cmbidOperando.setInternalname( "IDOPERANDO_"+sGXsfl_110_idx );
      edtOpeCodFormula_Internalname = "OPECODFORMULA_"+sGXsfl_110_idx ;
      edtOpeDescripcion_Internalname = "OPEDESCRIPCION_"+sGXsfl_110_idx ;
      chkavTieneparametros.setInternalname( "vTIENEPARAMETROS_"+sGXsfl_110_idx );
      chkOpeEsCant.setInternalname( "OPEESCANT_"+sGXsfl_110_idx );
      chkOpeAliEs.setInternalname( "OPEALIES_"+sGXsfl_110_idx );
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_idx ;
   }

   public void subsflControlProps_fel_1102( )
   {
      edtPaiCod_Internalname = "PAICOD_"+sGXsfl_110_fel_idx ;
      cmbidOperando.setInternalname( "IDOPERANDO_"+sGXsfl_110_fel_idx );
      edtOpeCodFormula_Internalname = "OPECODFORMULA_"+sGXsfl_110_fel_idx ;
      edtOpeDescripcion_Internalname = "OPEDESCRIPCION_"+sGXsfl_110_fel_idx ;
      chkavTieneparametros.setInternalname( "vTIENEPARAMETROS_"+sGXsfl_110_fel_idx );
      chkOpeEsCant.setInternalname( "OPEESCANT_"+sGXsfl_110_fel_idx );
      chkOpeAliEs.setInternalname( "OPEALIES_"+sGXsfl_110_fel_idx );
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_fel_idx ;
   }

   public void sendrow_1102( )
   {
      subsflControlProps_1102( ) ;
      wb9N0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbidOperando.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "IDOPERANDO_" + sGXsfl_110_idx ;
            cmbidOperando.setName( GXCCtl );
            cmbidOperando.setWebtags( "" );
            cmbidOperando.addItem("[antiguedad]", httpContext.getMessage( "Antiguedad en años", ""), (short)(0));
            cmbidOperando.addItem("[antiguedad_indemnizacion]", httpContext.getMessage( "Antig. fracción 3 meses = 1 año", ""), (short)(0));
            cmbidOperando.addItem("{concepto}", httpContext.getMessage( "Concepto", ""), (short)(0));
            cmbidOperando.addItem("{conceptos}", httpContext.getMessage( "Conceptos", ""), (short)(0));
            cmbidOperando.addItem("[dias_mes]", httpContext.getMessage( "Cantidad de dias del mes. Si el parámetro \"Todos los meses tienen 30 dias\" está en \"Si\", devuelve el valor 30, si no devuelve la cantidad de días del mes reales.", ""), (short)(0));
            cmbidOperando.addItem("[dias_semestre]", httpContext.getMessage( "Cantidad de dias del semestre. Tiene en cuenta el parámetro \"Todos los meses tienen 30 días\" para calcular la cantidad de días del semestre.", ""), (short)(0));
            cmbidOperando.addItem("[dias_trabajados_mes]", httpContext.getMessage( "Cantidad de dias trabajados de forma normal en el mes. Es la cantidad de días del mes menos los días de licencia y los días feriados trabajados (que se liquidan aparte), contemplando fecha de ingreso y egreso.", ""), (short)(0));
            cmbidOperando.addItem("[dias_remunerados_semestre]", httpContext.getMessage( "Cantidad de dias remunerados en el semestre. Es la cantidad de días del semestre menos las ausencias injustificadas, contemplando fecha de ingreso y egreso.", ""), (short)(0));
            cmbidOperando.addItem("[plan_medico]", httpContext.getMessage( "Plan Médico", ""), (short)(0));
            cmbidOperando.addItem("[remu_var]", httpContext.getMessage( "Remuneraciones Variables", ""), (short)(0));
            cmbidOperando.addItem("[basico_mensual]", httpContext.getMessage( "Sueldo Básico Mensual", ""), (short)(0));
            cmbidOperando.addItem("[contr_OS_ali]", httpContext.getMessage( "Alícuota para contribución patronal destinada a obra social", ""), (short)(0));
            cmbidOperando.addItem("[contr_FSR_ali]", httpContext.getMessage( "Alìcuota para contribuciòn patronal destinada a FSR (ex ANSSAL)", ""), (short)(0));
            cmbidOperando.addItem("[apo_Dif]", httpContext.getMessage( "Total No Remunerativos que tributan a  aporte de Régimenes Diferenciales", ""), (short)(0));
            cmbidOperando.addItem("[tipoLiq]", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
            cmbidOperando.addItem("[mes_Periodo]", httpContext.getMessage( "Mes Periodo", ""), (short)(0));
            cmbidOperando.addItem("[novedad_cantidad]", httpContext.getMessage( "Cantidad de horas (jornalizados) o días (mensualizados) informadas en agenda de novedades", ""), (short)(0));
            cmbidOperando.addItem("[novedad_importe]", httpContext.getMessage( "Importe informado en agenda de novedades", ""), (short)(0));
            cmbidOperando.addItem("[ART_ali]", httpContext.getMessage( "Alícuota de Contribución Patronal ART según Empresa", ""), (short)(0));
            cmbidOperando.addItem("[gan_cuotas]", httpContext.getMessage( "Ganancias - Cantidad de cuotas faltantes", ""), (short)(0));
            cmbidOperando.addItem("[con_discapacidad]", httpContext.getMessage( "Legajo con Discapacidad", ""), (short)(0));
            cmbidOperando.addItem("[sexo]", httpContext.getMessage( "Legajo Sexo", ""), (short)(0));
            cmbidOperando.addItem("[motivo_egreso]", httpContext.getMessage( "Legajo Motivo de Egreso", ""), (short)(0));
            cmbidOperando.addItem("[area]", httpContext.getMessage( "Legajo Area", ""), (short)(0));
            cmbidOperando.addItem("[categoria]", httpContext.getMessage( "Legajo Categoria", ""), (short)(0));
            cmbidOperando.addItem("[convenio]", httpContext.getMessage( "Legajo Convenio", ""), (short)(0));
            cmbidOperando.addItem("[clase]", httpContext.getMessage( "Legajo Clase", ""), (short)(0));
            cmbidOperando.addItem("[sindicato]", httpContext.getMessage( "Legajo Sindicato", ""), (short)(0));
            cmbidOperando.addItem("[obraSocial]", httpContext.getMessage( "Obra Social_", ""), (short)(0));
            cmbidOperando.addItem("[edad]", httpContext.getMessage( "Edad", ""), (short)(0));
            cmbidOperando.addItem("[monto_siradig]", httpContext.getMessage( "Importes de items ingresados en SIRADIG al 100% para el concepto. En el caso de deducciones generales anuales el importe se aplicará en el mes de diciembre o en liquidación final.", ""), (short)(0));
            cmbidOperando.addItem("[hora_basica]", httpContext.getMessage( "Valor hora básico", ""), (short)(0));
            cmbidOperando.addItem("[horas_extras_exentas]", httpContext.getMessage( "Horas extras exentas.", ""), (short)(0));
            cmbidOperando.addItem("[exentas]", httpContext.getMessage( "Ganancias - remuneraciones totalmente exentas.", ""), (short)(0));
            cmbidOperando.addItem("[descuentos_ley_ganancias]", httpContext.getMessage( "Ganancias - Descuentos de ley sobre remuneración bruta", ""), (short)(0));
            cmbidOperando.addItem("[deduce_conyuge]", httpContext.getMessage( "Ganancias - Deduce conyuge", ""), (short)(0));
            cmbidOperando.addItem("[cant_hijos]", httpContext.getMessage( "Cantidad de hijos menores a 18 años, no incapacitados para el trabajo", ""), (short)(0));
            cmbidOperando.addItem("[cant_hijos_incap]", httpContext.getMessage( "Cantidad de hijos incapacitados para el trabajo", ""), (short)(0));
            cmbidOperando.addItem("[prc_ded_hijos]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos no incapacitados para el trabajo", ""), (short)(0));
            cmbidOperando.addItem("[prc_ded_hijos_incap]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos incapacitados para el trabajo", ""), (short)(0));
            cmbidOperando.addItem("[ded_esp_inc]", httpContext.getMessage( "Deduccion especial incrementada", ""), (short)(0));
            cmbidOperando.addItem("[descuentos_anticipo_sac]", httpContext.getMessage( "Descuentos de ley sobre anticipo de SAC", ""), (short)(0));
            cmbidOperando.addItem("[pagos_a_cuenta_anteriores]", httpContext.getMessage( "Pagos a cuenta actualizados. Se recorren las liquidaciones de periodos anteriores para tomar los valores actualizados de pagos a cuenta considerando la carga al día de SIRADIG", ""), (short)(0));
            cmbidOperando.addItem("[alicuota_ley]", httpContext.getMessage( "Alicuota total descuentos de ley según legajo", ""), (short)(0));
            cmbidOperando.addItem("[sueldo_bruto_promedio]", httpContext.getMessage( "Sueldo Bruto Promedio Anual. Este valor es recalculado de forma retroactiva para siempre reflejar el promedio más actualizado", ""), (short)(0));
            cmbidOperando.addItem("[nro_cuota]", httpContext.getMessage( "Número de cuota para ganancias. En liquidaciones de egreso en donde el empleado no continua relación con otro empleador el valor equivale a la cantidad de cuotas totales del año.", ""), (short)(0));
            cmbidOperando.addItem("[agente_retencion]", httpContext.getMessage( "Empresa es agente de retención para el empleado", ""), (short)(0));
            cmbidOperando.addItem("[mni_zona]", httpContext.getMessage( "Deducción [Artículo 30, inciso a)] Mínimo no imponible. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
            cmbidOperando.addItem("[ded_hijo_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
            cmbidOperando.addItem("[ded_hijo_incap_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo incapacitado para el trabajo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
            cmbidOperando.addItem("[ded_cony_zona]", httpContext.getMessage( "Deducción [Art. 30] Cónyuge / unión convivencial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
            cmbidOperando.addItem("[ded_especial_zona]", httpContext.getMessage( "Deducción [Art. 30, inc c, A. 2] Especial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
            cmbidOperando.addItem("[cant_cuotas]", httpContext.getMessage( "Cantidad de cuotas a retener ganancias", ""), (short)(0));
            cmbidOperando.addItem("[f1357_saldo]", httpContext.getMessage( "Saldo de F1357 del año anterior. Aplica en el mes de abril.", ""), (short)(0));
            cmbidOperando.addItem("[descuentos_retencion]", httpContext.getMessage( "Descuentos de Ley más descuentos sobre anticipo de SAC", ""), (short)(0));
            cmbidOperando.addItem("[os_cantidad_adherentes]", httpContext.getMessage( "Cantidad de adherentes adicionales a la obra social", ""), (short)(0));
            cmbidOperando.addItem("[horas_mes]", httpContext.getMessage( "Horas del mes según categoría, o en su defecto el valor de la variable de horas mes default", ""), (short)(0));
            cmbidOperando.addItem("[os_apo_adic]", httpContext.getMessage( "Aporte adicional obra social", ""), (short)(0));
            cmbidOperando.addItem("[horas_jornal]", httpContext.getMessage( "Horas por día que trabaja el empleado", ""), (short)(0));
            cmbidOperando.addItem("[dias_vacaciones]", httpContext.getMessage( "Cantidad de días de vacaciones del periodo", ""), (short)(0));
            cmbidOperando.addItem("[remuneracion_licencia]", httpContext.getMessage( "Càlculo de remuneraciòn por la licencia paga", ""), (short)(0));
            cmbidOperando.addItem("[viaticos]", httpContext.getMessage( "Total de viáticos. Incluye importes de otros empleos informado en siradig para el periodo", ""), (short)(0));
            cmbidOperando.addItem("[materiales_didacticos]", httpContext.getMessage( "Total de materiales didácticos de personal docente. Incluye importes de otros empleos informados en siradig para el periodo", ""), (short)(0));
            cmbidOperando.addItem("[descuentos_sobre_gravados]", httpContext.getMessage( "Descuentos de ley sobre impuesto gravado", ""), (short)(0));
            cmbidOperando.addItem("[remuneracion_vacaciones_no_gozadas]", httpContext.getMessage( "Mismo cálculo que se realiza para vacaciones, pero la cantidad de días es la que corresponde por ley según años de antiguedad, siempre y cuando el empleado no se haya tomado ya las vacaciones.", ""), (short)(0));
            cmbidOperando.addItem("[tope_indemnizatorio]", httpContext.getMessage( "Tope Indemnizatorio del convenio", ""), (short)(0));
            cmbidOperando.addItem("[alicuota_sindical]", httpContext.getMessage( "Alícuota de cuota sindical", ""), (short)(0));
            cmbidOperando.addItem("[adelanto_retencion]", httpContext.getMessage( "Adelanto de retencion de ganancias", ""), (short)(0));
            cmbidOperando.addItem("[adicional_convenio]", httpContext.getMessage( "Adicional por convenio", ""), (short)(0));
            cmbidOperando.addItem("[horas_jornada_completa]", httpContext.getMessage( "Cantidad de horas de la jornada completa", ""), (short)(0));
            cmbidOperando.addItem("[valor_categoria]", httpContext.getMessage( "Sueldo Categoria", ""), (short)(0));
            cmbidOperando.addItem("{feriado_trabajado_horas}", httpContext.getMessage( "Horas feriado trabajado", ""), (short)(0));
            cmbidOperando.addItem("[feriados_no_trabajados]", httpContext.getMessage( "Feriados no trabajados", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_5]", httpContext.getMessage( "Base imponible 5 -Aportes INSSJYP", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_2]", httpContext.getMessage( "Base imponible 2 - CONTRIBUCIONES SIPA E INSSJYP", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_3]", httpContext.getMessage( "base Imponible 3 - ONTRIBUCIONES FNE, AAFF, Y RENATRE", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_4]", httpContext.getMessage( "Base imponible 4 - APORTES OS Y FSR", ""), (short)(0));
            cmbidOperando.addItem("[base_dif_apo_OS_FSR]", httpContext.getMessage( "base Diferencial - Aportes OS y FSR", ""), (short)(0));
            cmbidOperando.addItem("[base_dif_con_OS_FSR]", httpContext.getMessage( "Base diferencial - Contribuciones OS y FSR", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_8]", httpContext.getMessage( "base Imponible 8  -  CONTRIBUCIONES OS Y FSR", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_9]", httpContext.getMessage( "base Imponible 9 - CONTRIBUCIONES LRT", ""), (short)(0));
            cmbidOperando.addItem("[importe_a_detraer]", httpContext.getMessage( "Importe a detraer", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_6]", httpContext.getMessage( "Base imponible 6 - APORTES DIFERENCIALES", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_7]", httpContext.getMessage( "base Imponible 7 - APORTES ESPECIALES", ""), (short)(0));
            cmbidOperando.addItem("[remuneracion_adelanto_vacaciones]", httpContext.getMessage( "Remuneracion adelanto de vacaciones", ""), (short)(0));
            cmbidOperando.addItem("[sueldo_bruto]", httpContext.getMessage( "Sueldo Bruto", ""), (short)(0));
            cmbidOperando.addItem("[descuento_adelanto]", httpContext.getMessage( "Descuento por adelanto", ""), (short)(0));
            cmbidOperando.addItem("[dias_proporcionar_tope]", httpContext.getMessage( "Días para proporcionar tope para cálculo de máximo imponible de sueldo", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_1_sueldo]", httpContext.getMessage( "Tope para base imponible 1 sueldo", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_sac]", httpContext.getMessage( "Tope para base imponible para SAC", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_adelantoVac]", httpContext.getMessage( "Tope para base imponible para adelanto de vacaciones de mes próximo", ""), (short)(0));
            cmbidOperando.addItem("[base_imponible_1]", httpContext.getMessage( "Base imponible 1 - Aportes SIPA", ""), (short)(0));
            cmbidOperando.addItem("[sueldo_basico]", httpContext.getMessage( "Sueldo básico", ""), (short)(0));
            cmbidOperando.addItem("[calculo_sac]", httpContext.getMessage( "Cálculo SAC", ""), (short)(0));
            cmbidOperando.addItem("[haberes_sac]", httpContext.getMessage( "Haberes Sac", ""), (short)(0));
            cmbidOperando.addItem("[anticipo_sac]", httpContext.getMessage( "Anticipo de SAC", ""), (short)(0));
            cmbidOperando.addItem("[sac_estimado]", httpContext.getMessage( "Estimación de próximo SAC", ""), (short)(0));
            cmbidOperando.addItem("[total_exentos_sin_sac]", httpContext.getMessage( "Total Exentos Sin Sac", ""), (short)(0));
            cmbidOperando.addItem("[cuotas_prorrateo]", httpContext.getMessage( "Cuotas prorrateos", ""), (short)(0));
            cmbidOperando.addItem("[prorrateables]", httpContext.getMessage( "Prorrateables", ""), (short)(0));
            cmbidOperando.addItem("[exento_concepto]", httpContext.getMessage( "Cálculo exento", ""), (short)(0));
            cmbidOperando.addItem("[deduccion]", httpContext.getMessage( "Calculo Deduccion", ""), (short)(0));
            cmbidOperando.addItem("[retencion_ganancias]", httpContext.getMessage( "Retención ganancias", ""), (short)(0));
            cmbidOperando.addItem("[empresa_antiguedad]", httpContext.getMessage( "Importe o alícuota para antiguedad por empresa (fuera de convenio)", ""), (short)(0));
            cmbidOperando.addItem("[empresa_presentismo]", httpContext.getMessage( "Importe o alícuota para presentismo por empresa (fuera de convenio)", ""), (short)(0));
            cmbidOperando.addItem("[asistencia_perfecta]", httpContext.getMessage( "Flag de asistencia perfecta. Si se registran faltas injustificadas o llegadas tarde es 0, caso contrario es 1", ""), (short)(0));
            cmbidOperando.addItem("[es_primera_quincena]", httpContext.getMessage( "Es primera quincena", ""), (short)(0));
            cmbidOperando.addItem("[ART_fijo]", httpContext.getMessage( "Importe fijo de ART", ""), (short)(0));
            cmbidOperando.addItem("[contr_jub_ali]", httpContext.getMessage( "Alìcuota de contribuciòn dej ubilaciòn", ""), (short)(0));
            cmbidOperando.addItem("[contr_inssjyp_ali]", httpContext.getMessage( "Alìcuota de contribución PAMI", ""), (short)(0));
            cmbidOperando.addItem("[contr_aaff_ali]", httpContext.getMessage( "Alìcuota de contribuciòn asignaciones familiares", ""), (short)(0));
            cmbidOperando.addItem("[contr_fne_ali]", httpContext.getMessage( "Alìcuota de contribuciòn fondo nacional de empleo", ""), (short)(0));
            cmbidOperando.addItem("[obligacion]", httpContext.getMessage( "Obligación", ""), (short)(0));
            cmbidOperando.addItem("[liquidar_sac]", httpContext.getMessage( "liquidar_sac", ""), (short)(0));
            cmbidOperando.addItem("[plus_vacacional]", httpContext.getMessage( "Plus Vacacional", ""), (short)(0));
            cmbidOperando.addItem("[no_laborables]", httpContext.getMessage( "Días no laborables no trabajados", ""), (short)(0));
            cmbidOperando.addItem("[remuneracion_descuento]", httpContext.getMessage( "Ausencias injustificadas", ""), (short)(0));
            cmbidOperando.addItem("[dias_proporcionar_sac]", httpContext.getMessage( "Cantidad de días para proporcionar SAC", ""), (short)(0));
            cmbidOperando.addItem("[hora_normal]", httpContext.getMessage( "Valor de hora normal", ""), (short)(0));
            cmbidOperando.addItem("[extra]", httpContext.getMessage( "Aumento de hora extra sobre hora normal", ""), (short)(0));
            cmbidOperando.addItem("[recargo]", httpContext.getMessage( "Recargo por tipo de trabajo (por ejemplo nocturno)", ""), (short)(0));
            cmbidOperando.addItem("[jubilacion]", httpContext.getMessage( "Jubilación", ""), (short)(0));
            cmbidOperando.addItem("[obra_social]", httpContext.getMessage( "Obra Social", ""), (short)(0));
            cmbidOperando.addItem("[ley_19032]", httpContext.getMessage( "Ley 19032", ""), (short)(0));
            cmbidOperando.addItem("[remuneracion_accidente_empresa]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de la empresa", ""), (short)(0));
            cmbidOperando.addItem("[remuneracion_accidente_ART]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de ART", ""), (short)(0));
            cmbidOperando.addItem("[ultimo_dia_mes]", httpContext.getMessage( "Ultimo día del mes", ""), (short)(0));
            cmbidOperando.addItem("[dia_fecha_egreso]", httpContext.getMessage( "Día de fecha de egreso", ""), (short)(0));
            cmbidOperando.addItem("[indemnizacion_antiguedad]", httpContext.getMessage( "Indemnización por antiguedad", ""), (short)(0));
            cmbidOperando.addItem("[proporcion_antiguedad_motivo]", httpContext.getMessage( "Proporción según antiguedad y motivo de egreso definido en el concepto", ""), (short)(0));
            cmbidOperando.addItem("[reintegro_guarderia]", httpContext.getMessage( "Reintegro por gastos de guardería", ""), (short)(0));
            cmbidOperando.addItem("[beneficio_guarderia]", httpContext.getMessage( "Beneficio Guarderia", ""), (short)(0));
            cmbidOperando.addItem("[ultimo_dia_mes_egreso]", httpContext.getMessage( "Ultimo día del mes de egreso", ""), (short)(0));
            cmbidOperando.addItem("[dias_mes_egreso]", httpContext.getMessage( "Cantidad de días del mes de egreso", ""), (short)(0));
            cmbidOperando.addItem("[cuota_sindical]", httpContext.getMessage( "Cuota sindical", ""), (short)(0));
            cmbidOperando.addItem("[obra_social_adherentes]", httpContext.getMessage( "Obra Social Adherentes", ""), (short)(0));
            cmbidOperando.addItem("[antiguedad_importe]", httpContext.getMessage( "Antiguedad importe", ""), (short)(0));
            cmbidOperando.addItem("[presentismo_importe]", httpContext.getMessage( "Presentismo importe", ""), (short)(0));
            cmbidOperando.addItem("{sueldo}", httpContext.getMessage( "Sueldo", ""), (short)(0));
            cmbidOperando.addItem("{hora_completa}", httpContext.getMessage( "Hora básica más adicional", ""), (short)(0));
            cmbidOperando.addItem("{feriados_trabajados}", httpContext.getMessage( "Feriados trabajados", ""), (short)(0));
            cmbidOperando.addItem("[vacaciones_descuento]", httpContext.getMessage( "Descuento por días no trabajados por vacaciones", ""), (short)(0));
            cmbidOperando.addItem("[licencias_descuento]", httpContext.getMessage( "Descuento por días no trabajados por licencias", ""), (short)(0));
            cmbidOperando.addItem("{feriados_no_trabajados_descuento}", httpContext.getMessage( "Descuento por días no trabajados feriados", ""), (short)(0));
            cmbidOperando.addItem("{no_laborables_descuento}", httpContext.getMessage( "Descuento por días no trabajados no laborables", ""), (short)(0));
            cmbidOperando.addItem("{sac}", httpContext.getMessage( "Sueldo anual complementario", ""), (short)(0));
            cmbidOperando.addItem("{sac_proporcional}", httpContext.getMessage( "SAC Proporcional", ""), (short)(0));
            cmbidOperando.addItem("{sueldo_adicional}", httpContext.getMessage( "Sueldo Adicional", ""), (short)(0));
            cmbidOperando.addItem("{vacaciones_no_gozadas_ant}", httpContext.getMessage( "Vacaciones no gozadas de año anterior", ""), (short)(0));
            cmbidOperando.addItem("{egreso_descuento}", httpContext.getMessage( "Descuento por días no trabajados por egreso", ""), (short)(0));
            cmbidOperando.addItem("{obra_social_diferencial}", httpContext.getMessage( "Obra social diferencial", ""), (short)(0));
            cmbidOperando.addItem("{dias_HastaFinSemestre}", httpContext.getMessage( "Dias faltantes hasta el fin del semestre", ""), (short)(0));
            cmbidOperando.addItem("{tratamiento_exencion}", httpContext.getMessage( "Cálculo exento por tratamiento de exención de IIGG", ""), (short)(0));
            cmbidOperando.addItem("{horas_nocturnas}", httpContext.getMessage( "Adicional por horas nocturna", ""), (short)(0));
            cmbidOperando.addItem("{extras_al_50}", httpContext.getMessage( "Horas extras al 50%", ""), (short)(0));
            cmbidOperando.addItem("{extras_nocturnas_al_50}", httpContext.getMessage( "Horas extras nocturnas al 50%", ""), (short)(0));
            cmbidOperando.addItem("{extras_nocturnas_al_100}", httpContext.getMessage( "Horas extras nocturnas al 100%", ""), (short)(0));
            cmbidOperando.addItem("{extras_al_100}", httpContext.getMessage( "Horas extras al 100%", ""), (short)(0));
            cmbidOperando.addItem("{retroactivo}", httpContext.getMessage( "Recálculo de liquidaciones anteriores para calcular valores retroactivos", ""), (short)(0));
            cmbidOperando.addItem("{fondo_cese}", httpContext.getMessage( "Fondo de cese laboral", ""), (short)(0));
            cmbidOperando.addItem("{plus_licencia}", httpContext.getMessage( "Plus Licencia", ""), (short)(0));
            cmbidOperando.addItem("{redondeo}", httpContext.getMessage( "Redondeo", ""), (short)(0));
            cmbidOperando.addItem("{leg_prop_adi}", httpContext.getMessage( "Propiedad adicional de legajo", ""), (short)(0));
            cmbidOperando.addItem("{ded_art_30}", httpContext.getMessage( "Deducciones artículo 30", ""), (short)(0));
            cmbidOperando.addItem("{devolucion_ganancias}", httpContext.getMessage( "Devolución ganancias", ""), (short)(0));
            cmbidOperando.addItem("{ded_gen_men}", httpContext.getMessage( "Deducciones generales mensuales", ""), (short)(0));
            cmbidOperando.addItem("{ded_gen_anu}", httpContext.getMessage( "Deducciones generales anuales", ""), (short)(0));
            cmbidOperando.addItem("{rem_gravada_gan}", httpContext.getMessage( "Remuneración gravada en ganancias", ""), (short)(0));
            cmbidOperando.addItem("{gan_neta}", httpContext.getMessage( "Ganancia neta para impuesto a las ganancias", ""), (short)(0));
            cmbidOperando.addItem("{gnsi_sin_dei}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias, menos deducción especial incrementada", ""), (short)(0));
            cmbidOperando.addItem("{gnsi}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias", ""), (short)(0));
            cmbidOperando.addItem("{gan_neta_topes}", httpContext.getMessage( "Ganancia neta para calcular topes de deducciones de impuestos a las ganancias", ""), (short)(0));
            cmbidOperando.addItem("{calculo_iigg_neto}", httpContext.getMessage( "Cálculo de impuesto a las ganancias menos pagos a cuenta de periodos anteriores e importes pagados en liquidaciones anteriores", ""), (short)(0));
            cmbidOperando.addItem("{importe_iigg}", httpContext.getMessage( "Importe a retener de impuesto a las ganancias", ""), (short)(0));
            cmbidOperando.addItem("[calculo_iigg]", httpContext.getMessage( "Cálculo de impuesto a las ganancias usando tabla de escalas de AFIP", ""), (short)(0));
            cmbidOperando.addItem("{sueldo_bruto_ganancias}", httpContext.getMessage( "Sueldo Bruto más sueldo bruto de otros empleos", ""), (short)(0));
            cmbidOperando.addItem("{sueldo_bruto_menos_ley}", httpContext.getMessage( "Sueldo bruto menos descuentos de ley", ""), (short)(0));
            cmbidOperando.addItem("{alcanza_ganancias}", httpContext.getMessage( "Empleado es alcanzado por impuesto a las ganancias", ""), (short)(0));
            cmbidOperando.addItem("{contribucion_jubilacion}", httpContext.getMessage( "Contribución jubilación", ""), (short)(0));
            cmbidOperando.addItem("{contribucion_inssjp}", httpContext.getMessage( "Contribución  ley 19032", ""), (short)(0));
            cmbidOperando.addItem("{contribucion_aaff}", httpContext.getMessage( "Contribución asignaciones familiares", ""), (short)(0));
            cmbidOperando.addItem("{contribucion_fne}", httpContext.getMessage( "Contribución FNE", ""), (short)(0));
            cmbidOperando.addItem("{grossing_up}", httpContext.getMessage( "Grossing up", ""), (short)(0));
            if ( cmbidOperando.getItemCount() > 0 )
            {
               A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbidOperando,cmbidOperando.getInternalname(),GXutil.rtrim( A74idOperando),Integer.valueOf(1),cmbidOperando.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
         httpContext.ajax_rsp_assign_prop("", false, cmbidOperando.getInternalname(), "Values", cmbidOperando.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtOpeCodFormula_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOpeCodFormula_Internalname,GXutil.rtrim( A473OpeCodFormula),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOpeCodFormula_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOpeCodFormula_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtOpeDescripcion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOpeDescripcion_Internalname,A474OpeDescripcion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOpeDescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtOpeDescripcion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkavTieneparametros.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vTIENEPARAMETROS_" + sGXsfl_110_idx ;
         chkavTieneparametros.setName( GXCCtl );
         chkavTieneparametros.setWebtags( "" );
         chkavTieneparametros.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavTieneparametros.getInternalname(), "TitleCaption", chkavTieneparametros.getCaption(), !bGXsfl_110_Refreshing);
         chkavTieneparametros.setCheckedValue( "false" );
         AV70tieneParametros = GXutil.strtobool( GXutil.booltostr( AV70tieneParametros)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavTieneparametros.getInternalname(), AV70tieneParametros);
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavTieneparametros.getInternalname(),GXutil.booltostr( AV70tieneParametros),"","",Integer.valueOf(chkavTieneparametros.getVisible()),Integer.valueOf(chkavTieneparametros.getEnabled()),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkOpeEsCant.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "OPEESCANT_" + sGXsfl_110_idx ;
         chkOpeEsCant.setName( GXCCtl );
         chkOpeEsCant.setWebtags( "" );
         chkOpeEsCant.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeEsCant.getInternalname(), "TitleCaption", chkOpeEsCant.getCaption(), !bGXsfl_110_Refreshing);
         chkOpeEsCant.setCheckedValue( "false" );
         A932OpeEsCant = GXutil.strtobool( GXutil.booltostr( A932OpeEsCant)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkOpeEsCant.getInternalname(),GXutil.booltostr( A932OpeEsCant),"","",Integer.valueOf(chkOpeEsCant.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkOpeAliEs.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "OPEALIES_" + sGXsfl_110_idx ;
         chkOpeAliEs.setName( GXCCtl );
         chkOpeAliEs.setWebtags( "" );
         chkOpeAliEs.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeAliEs.getInternalname(), "TitleCaption", chkOpeAliEs.getCaption(), !bGXsfl_110_Refreshing);
         chkOpeAliEs.setCheckedValue( "false" );
         A1032OpeAliEs = GXutil.strtobool( GXutil.booltostr( A1032OpeAliEs)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkOpeAliEs.getInternalname(),GXutil.booltostr( A1032OpeAliEs),"","",Integer.valueOf(chkOpeAliEs.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV60Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV59VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes9N2( ) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOpeCodFormula_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtOpeDescripcion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkavTieneparametros.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tiene parámetros", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkOpeEsCant.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Determina cantidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkOpeAliEs.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Es alícuota", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A74idOperando));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A473OpeCodFormula));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOpeCodFormula_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A474OpeDescripcion);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtOpeDescripcion_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV70tieneParametros));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkavTieneparametros.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkavTieneparametros.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A932OpeEsCant));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkOpeEsCant.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1032OpeAliEs));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkOpeAliEs.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV60Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV59VerSVG));
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
      cmbidOperando.setInternalname( "IDOPERANDO" );
      edtOpeCodFormula_Internalname = "OPECODFORMULA" ;
      edtOpeDescripcion_Internalname = "OPEDESCRIPCION" ;
      chkavTieneparametros.setInternalname( "vTIENEPARAMETROS" );
      chkOpeEsCant.setInternalname( "OPEESCANT" );
      chkOpeAliEs.setInternalname( "OPEALIES" );
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = "TABLEPADDING" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      bttBtnreportarnousados_Internalname = "BTNREPORTARNOUSADOS" ;
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
      chkOpeAliEs.setCaption( "" );
      chkOpeEsCant.setCaption( "" );
      chkavTieneparametros.setCaption( "" );
      chkavTieneparametros.setEnabled( 0 );
      edtOpeDescripcion_Jsonclick = "" ;
      edtOpeCodFormula_Jsonclick = "" ;
      cmbidOperando.setJsonclick( "" );
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
      edtavDisplay_Link = "" ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      edtavVersvg_Visible = -1 ;
      chkOpeAliEs.setVisible( -1 );
      chkOpeEsCant.setVisible( -1 );
      chkavTieneparametros.setVisible( -1 );
      edtOpeDescripcion_Visible = -1 ;
      edtOpeCodFormula_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Datalistproc = "CalculoWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked" ;
      Ddo_grid_Allowmultipleselection = "T|T|||" ;
      Ddo_grid_Datalisttype = "Dynamic|Dynamic||FixedValues|FixedValues" ;
      Ddo_grid_Includedatalist = "T|T||T|T" ;
      Ddo_grid_Filtertype = "Character|Character|||" ;
      Ddo_grid_Includefilter = "T|T|||" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T||T|T" ;
      Ddo_grid_Columnssortvalues = "1|2||3|4" ;
      Ddo_grid_Columnids = "2:OpeCodFormula|3:OpeDescripcion|4:tieneParametros|5:OpeEsCant|6:OpeAliEs" ;
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
      Form.setCaption( httpContext.getMessage( " Cálculos", "") );
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
      AV63WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV63WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63WelcomeMessage_NoMostrarMas", AV63WelcomeMessage_NoMostrarMas);
      GXCCtl = "IDOPERANDO_" + sGXsfl_110_idx ;
      cmbidOperando.setName( GXCCtl );
      cmbidOperando.setWebtags( "" );
      cmbidOperando.addItem("[antiguedad]", httpContext.getMessage( "Antiguedad en años", ""), (short)(0));
      cmbidOperando.addItem("[antiguedad_indemnizacion]", httpContext.getMessage( "Antig. fracción 3 meses = 1 año", ""), (short)(0));
      cmbidOperando.addItem("{concepto}", httpContext.getMessage( "Concepto", ""), (short)(0));
      cmbidOperando.addItem("{conceptos}", httpContext.getMessage( "Conceptos", ""), (short)(0));
      cmbidOperando.addItem("[dias_mes]", httpContext.getMessage( "Cantidad de dias del mes. Si el parámetro \"Todos los meses tienen 30 dias\" está en \"Si\", devuelve el valor 30, si no devuelve la cantidad de días del mes reales.", ""), (short)(0));
      cmbidOperando.addItem("[dias_semestre]", httpContext.getMessage( "Cantidad de dias del semestre. Tiene en cuenta el parámetro \"Todos los meses tienen 30 días\" para calcular la cantidad de días del semestre.", ""), (short)(0));
      cmbidOperando.addItem("[dias_trabajados_mes]", httpContext.getMessage( "Cantidad de dias trabajados de forma normal en el mes. Es la cantidad de días del mes menos los días de licencia y los días feriados trabajados (que se liquidan aparte), contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbidOperando.addItem("[dias_remunerados_semestre]", httpContext.getMessage( "Cantidad de dias remunerados en el semestre. Es la cantidad de días del semestre menos las ausencias injustificadas, contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbidOperando.addItem("[plan_medico]", httpContext.getMessage( "Plan Médico", ""), (short)(0));
      cmbidOperando.addItem("[remu_var]", httpContext.getMessage( "Remuneraciones Variables", ""), (short)(0));
      cmbidOperando.addItem("[basico_mensual]", httpContext.getMessage( "Sueldo Básico Mensual", ""), (short)(0));
      cmbidOperando.addItem("[contr_OS_ali]", httpContext.getMessage( "Alícuota para contribución patronal destinada a obra social", ""), (short)(0));
      cmbidOperando.addItem("[contr_FSR_ali]", httpContext.getMessage( "Alìcuota para contribuciòn patronal destinada a FSR (ex ANSSAL)", ""), (short)(0));
      cmbidOperando.addItem("[apo_Dif]", httpContext.getMessage( "Total No Remunerativos que tributan a  aporte de Régimenes Diferenciales", ""), (short)(0));
      cmbidOperando.addItem("[tipoLiq]", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
      cmbidOperando.addItem("[mes_Periodo]", httpContext.getMessage( "Mes Periodo", ""), (short)(0));
      cmbidOperando.addItem("[novedad_cantidad]", httpContext.getMessage( "Cantidad de horas (jornalizados) o días (mensualizados) informadas en agenda de novedades", ""), (short)(0));
      cmbidOperando.addItem("[novedad_importe]", httpContext.getMessage( "Importe informado en agenda de novedades", ""), (short)(0));
      cmbidOperando.addItem("[ART_ali]", httpContext.getMessage( "Alícuota de Contribución Patronal ART según Empresa", ""), (short)(0));
      cmbidOperando.addItem("[gan_cuotas]", httpContext.getMessage( "Ganancias - Cantidad de cuotas faltantes", ""), (short)(0));
      cmbidOperando.addItem("[con_discapacidad]", httpContext.getMessage( "Legajo con Discapacidad", ""), (short)(0));
      cmbidOperando.addItem("[sexo]", httpContext.getMessage( "Legajo Sexo", ""), (short)(0));
      cmbidOperando.addItem("[motivo_egreso]", httpContext.getMessage( "Legajo Motivo de Egreso", ""), (short)(0));
      cmbidOperando.addItem("[area]", httpContext.getMessage( "Legajo Area", ""), (short)(0));
      cmbidOperando.addItem("[categoria]", httpContext.getMessage( "Legajo Categoria", ""), (short)(0));
      cmbidOperando.addItem("[convenio]", httpContext.getMessage( "Legajo Convenio", ""), (short)(0));
      cmbidOperando.addItem("[clase]", httpContext.getMessage( "Legajo Clase", ""), (short)(0));
      cmbidOperando.addItem("[sindicato]", httpContext.getMessage( "Legajo Sindicato", ""), (short)(0));
      cmbidOperando.addItem("[obraSocial]", httpContext.getMessage( "Obra Social_", ""), (short)(0));
      cmbidOperando.addItem("[edad]", httpContext.getMessage( "Edad", ""), (short)(0));
      cmbidOperando.addItem("[monto_siradig]", httpContext.getMessage( "Importes de items ingresados en SIRADIG al 100% para el concepto. En el caso de deducciones generales anuales el importe se aplicará en el mes de diciembre o en liquidación final.", ""), (short)(0));
      cmbidOperando.addItem("[hora_basica]", httpContext.getMessage( "Valor hora básico", ""), (short)(0));
      cmbidOperando.addItem("[horas_extras_exentas]", httpContext.getMessage( "Horas extras exentas.", ""), (short)(0));
      cmbidOperando.addItem("[exentas]", httpContext.getMessage( "Ganancias - remuneraciones totalmente exentas.", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_ley_ganancias]", httpContext.getMessage( "Ganancias - Descuentos de ley sobre remuneración bruta", ""), (short)(0));
      cmbidOperando.addItem("[deduce_conyuge]", httpContext.getMessage( "Ganancias - Deduce conyuge", ""), (short)(0));
      cmbidOperando.addItem("[cant_hijos]", httpContext.getMessage( "Cantidad de hijos menores a 18 años, no incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[cant_hijos_incap]", httpContext.getMessage( "Cantidad de hijos incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[prc_ded_hijos]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos no incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[prc_ded_hijos_incap]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[ded_esp_inc]", httpContext.getMessage( "Deduccion especial incrementada", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_anticipo_sac]", httpContext.getMessage( "Descuentos de ley sobre anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[pagos_a_cuenta_anteriores]", httpContext.getMessage( "Pagos a cuenta actualizados. Se recorren las liquidaciones de periodos anteriores para tomar los valores actualizados de pagos a cuenta considerando la carga al día de SIRADIG", ""), (short)(0));
      cmbidOperando.addItem("[alicuota_ley]", httpContext.getMessage( "Alicuota total descuentos de ley según legajo", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_bruto_promedio]", httpContext.getMessage( "Sueldo Bruto Promedio Anual. Este valor es recalculado de forma retroactiva para siempre reflejar el promedio más actualizado", ""), (short)(0));
      cmbidOperando.addItem("[nro_cuota]", httpContext.getMessage( "Número de cuota para ganancias. En liquidaciones de egreso en donde el empleado no continua relación con otro empleador el valor equivale a la cantidad de cuotas totales del año.", ""), (short)(0));
      cmbidOperando.addItem("[agente_retencion]", httpContext.getMessage( "Empresa es agente de retención para el empleado", ""), (short)(0));
      cmbidOperando.addItem("[mni_zona]", httpContext.getMessage( "Deducción [Artículo 30, inciso a)] Mínimo no imponible. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_hijo_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_hijo_incap_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo incapacitado para el trabajo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_cony_zona]", httpContext.getMessage( "Deducción [Art. 30] Cónyuge / unión convivencial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_especial_zona]", httpContext.getMessage( "Deducción [Art. 30, inc c, A. 2] Especial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[cant_cuotas]", httpContext.getMessage( "Cantidad de cuotas a retener ganancias", ""), (short)(0));
      cmbidOperando.addItem("[f1357_saldo]", httpContext.getMessage( "Saldo de F1357 del año anterior. Aplica en el mes de abril.", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_retencion]", httpContext.getMessage( "Descuentos de Ley más descuentos sobre anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[os_cantidad_adherentes]", httpContext.getMessage( "Cantidad de adherentes adicionales a la obra social", ""), (short)(0));
      cmbidOperando.addItem("[horas_mes]", httpContext.getMessage( "Horas del mes según categoría, o en su defecto el valor de la variable de horas mes default", ""), (short)(0));
      cmbidOperando.addItem("[os_apo_adic]", httpContext.getMessage( "Aporte adicional obra social", ""), (short)(0));
      cmbidOperando.addItem("[horas_jornal]", httpContext.getMessage( "Horas por día que trabaja el empleado", ""), (short)(0));
      cmbidOperando.addItem("[dias_vacaciones]", httpContext.getMessage( "Cantidad de días de vacaciones del periodo", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_licencia]", httpContext.getMessage( "Càlculo de remuneraciòn por la licencia paga", ""), (short)(0));
      cmbidOperando.addItem("[viaticos]", httpContext.getMessage( "Total de viáticos. Incluye importes de otros empleos informado en siradig para el periodo", ""), (short)(0));
      cmbidOperando.addItem("[materiales_didacticos]", httpContext.getMessage( "Total de materiales didácticos de personal docente. Incluye importes de otros empleos informados en siradig para el periodo", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_sobre_gravados]", httpContext.getMessage( "Descuentos de ley sobre impuesto gravado", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_vacaciones_no_gozadas]", httpContext.getMessage( "Mismo cálculo que se realiza para vacaciones, pero la cantidad de días es la que corresponde por ley según años de antiguedad, siempre y cuando el empleado no se haya tomado ya las vacaciones.", ""), (short)(0));
      cmbidOperando.addItem("[tope_indemnizatorio]", httpContext.getMessage( "Tope Indemnizatorio del convenio", ""), (short)(0));
      cmbidOperando.addItem("[alicuota_sindical]", httpContext.getMessage( "Alícuota de cuota sindical", ""), (short)(0));
      cmbidOperando.addItem("[adelanto_retencion]", httpContext.getMessage( "Adelanto de retencion de ganancias", ""), (short)(0));
      cmbidOperando.addItem("[adicional_convenio]", httpContext.getMessage( "Adicional por convenio", ""), (short)(0));
      cmbidOperando.addItem("[horas_jornada_completa]", httpContext.getMessage( "Cantidad de horas de la jornada completa", ""), (short)(0));
      cmbidOperando.addItem("[valor_categoria]", httpContext.getMessage( "Sueldo Categoria", ""), (short)(0));
      cmbidOperando.addItem("{feriado_trabajado_horas}", httpContext.getMessage( "Horas feriado trabajado", ""), (short)(0));
      cmbidOperando.addItem("[feriados_no_trabajados]", httpContext.getMessage( "Feriados no trabajados", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_5]", httpContext.getMessage( "Base imponible 5 -Aportes INSSJYP", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_2]", httpContext.getMessage( "Base imponible 2 - CONTRIBUCIONES SIPA E INSSJYP", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_3]", httpContext.getMessage( "base Imponible 3 - ONTRIBUCIONES FNE, AAFF, Y RENATRE", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_4]", httpContext.getMessage( "Base imponible 4 - APORTES OS Y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_dif_apo_OS_FSR]", httpContext.getMessage( "base Diferencial - Aportes OS y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_dif_con_OS_FSR]", httpContext.getMessage( "Base diferencial - Contribuciones OS y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_8]", httpContext.getMessage( "base Imponible 8  -  CONTRIBUCIONES OS Y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_9]", httpContext.getMessage( "base Imponible 9 - CONTRIBUCIONES LRT", ""), (short)(0));
      cmbidOperando.addItem("[importe_a_detraer]", httpContext.getMessage( "Importe a detraer", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_6]", httpContext.getMessage( "Base imponible 6 - APORTES DIFERENCIALES", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_7]", httpContext.getMessage( "base Imponible 7 - APORTES ESPECIALES", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_adelanto_vacaciones]", httpContext.getMessage( "Remuneracion adelanto de vacaciones", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_bruto]", httpContext.getMessage( "Sueldo Bruto", ""), (short)(0));
      cmbidOperando.addItem("[descuento_adelanto]", httpContext.getMessage( "Descuento por adelanto", ""), (short)(0));
      cmbidOperando.addItem("[dias_proporcionar_tope]", httpContext.getMessage( "Días para proporcionar tope para cálculo de máximo imponible de sueldo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_1_sueldo]", httpContext.getMessage( "Tope para base imponible 1 sueldo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_sac]", httpContext.getMessage( "Tope para base imponible para SAC", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_adelantoVac]", httpContext.getMessage( "Tope para base imponible para adelanto de vacaciones de mes próximo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_1]", httpContext.getMessage( "Base imponible 1 - Aportes SIPA", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_basico]", httpContext.getMessage( "Sueldo básico", ""), (short)(0));
      cmbidOperando.addItem("[calculo_sac]", httpContext.getMessage( "Cálculo SAC", ""), (short)(0));
      cmbidOperando.addItem("[haberes_sac]", httpContext.getMessage( "Haberes Sac", ""), (short)(0));
      cmbidOperando.addItem("[anticipo_sac]", httpContext.getMessage( "Anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[sac_estimado]", httpContext.getMessage( "Estimación de próximo SAC", ""), (short)(0));
      cmbidOperando.addItem("[total_exentos_sin_sac]", httpContext.getMessage( "Total Exentos Sin Sac", ""), (short)(0));
      cmbidOperando.addItem("[cuotas_prorrateo]", httpContext.getMessage( "Cuotas prorrateos", ""), (short)(0));
      cmbidOperando.addItem("[prorrateables]", httpContext.getMessage( "Prorrateables", ""), (short)(0));
      cmbidOperando.addItem("[exento_concepto]", httpContext.getMessage( "Cálculo exento", ""), (short)(0));
      cmbidOperando.addItem("[deduccion]", httpContext.getMessage( "Calculo Deduccion", ""), (short)(0));
      cmbidOperando.addItem("[retencion_ganancias]", httpContext.getMessage( "Retención ganancias", ""), (short)(0));
      cmbidOperando.addItem("[empresa_antiguedad]", httpContext.getMessage( "Importe o alícuota para antiguedad por empresa (fuera de convenio)", ""), (short)(0));
      cmbidOperando.addItem("[empresa_presentismo]", httpContext.getMessage( "Importe o alícuota para presentismo por empresa (fuera de convenio)", ""), (short)(0));
      cmbidOperando.addItem("[asistencia_perfecta]", httpContext.getMessage( "Flag de asistencia perfecta. Si se registran faltas injustificadas o llegadas tarde es 0, caso contrario es 1", ""), (short)(0));
      cmbidOperando.addItem("[es_primera_quincena]", httpContext.getMessage( "Es primera quincena", ""), (short)(0));
      cmbidOperando.addItem("[ART_fijo]", httpContext.getMessage( "Importe fijo de ART", ""), (short)(0));
      cmbidOperando.addItem("[contr_jub_ali]", httpContext.getMessage( "Alìcuota de contribuciòn dej ubilaciòn", ""), (short)(0));
      cmbidOperando.addItem("[contr_inssjyp_ali]", httpContext.getMessage( "Alìcuota de contribución PAMI", ""), (short)(0));
      cmbidOperando.addItem("[contr_aaff_ali]", httpContext.getMessage( "Alìcuota de contribuciòn asignaciones familiares", ""), (short)(0));
      cmbidOperando.addItem("[contr_fne_ali]", httpContext.getMessage( "Alìcuota de contribuciòn fondo nacional de empleo", ""), (short)(0));
      cmbidOperando.addItem("[obligacion]", httpContext.getMessage( "Obligación", ""), (short)(0));
      cmbidOperando.addItem("[liquidar_sac]", httpContext.getMessage( "liquidar_sac", ""), (short)(0));
      cmbidOperando.addItem("[plus_vacacional]", httpContext.getMessage( "Plus Vacacional", ""), (short)(0));
      cmbidOperando.addItem("[no_laborables]", httpContext.getMessage( "Días no laborables no trabajados", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_descuento]", httpContext.getMessage( "Ausencias injustificadas", ""), (short)(0));
      cmbidOperando.addItem("[dias_proporcionar_sac]", httpContext.getMessage( "Cantidad de días para proporcionar SAC", ""), (short)(0));
      cmbidOperando.addItem("[hora_normal]", httpContext.getMessage( "Valor de hora normal", ""), (short)(0));
      cmbidOperando.addItem("[extra]", httpContext.getMessage( "Aumento de hora extra sobre hora normal", ""), (short)(0));
      cmbidOperando.addItem("[recargo]", httpContext.getMessage( "Recargo por tipo de trabajo (por ejemplo nocturno)", ""), (short)(0));
      cmbidOperando.addItem("[jubilacion]", httpContext.getMessage( "Jubilación", ""), (short)(0));
      cmbidOperando.addItem("[obra_social]", httpContext.getMessage( "Obra Social", ""), (short)(0));
      cmbidOperando.addItem("[ley_19032]", httpContext.getMessage( "Ley 19032", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_accidente_empresa]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de la empresa", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_accidente_ART]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de ART", ""), (short)(0));
      cmbidOperando.addItem("[ultimo_dia_mes]", httpContext.getMessage( "Ultimo día del mes", ""), (short)(0));
      cmbidOperando.addItem("[dia_fecha_egreso]", httpContext.getMessage( "Día de fecha de egreso", ""), (short)(0));
      cmbidOperando.addItem("[indemnizacion_antiguedad]", httpContext.getMessage( "Indemnización por antiguedad", ""), (short)(0));
      cmbidOperando.addItem("[proporcion_antiguedad_motivo]", httpContext.getMessage( "Proporción según antiguedad y motivo de egreso definido en el concepto", ""), (short)(0));
      cmbidOperando.addItem("[reintegro_guarderia]", httpContext.getMessage( "Reintegro por gastos de guardería", ""), (short)(0));
      cmbidOperando.addItem("[beneficio_guarderia]", httpContext.getMessage( "Beneficio Guarderia", ""), (short)(0));
      cmbidOperando.addItem("[ultimo_dia_mes_egreso]", httpContext.getMessage( "Ultimo día del mes de egreso", ""), (short)(0));
      cmbidOperando.addItem("[dias_mes_egreso]", httpContext.getMessage( "Cantidad de días del mes de egreso", ""), (short)(0));
      cmbidOperando.addItem("[cuota_sindical]", httpContext.getMessage( "Cuota sindical", ""), (short)(0));
      cmbidOperando.addItem("[obra_social_adherentes]", httpContext.getMessage( "Obra Social Adherentes", ""), (short)(0));
      cmbidOperando.addItem("[antiguedad_importe]", httpContext.getMessage( "Antiguedad importe", ""), (short)(0));
      cmbidOperando.addItem("[presentismo_importe]", httpContext.getMessage( "Presentismo importe", ""), (short)(0));
      cmbidOperando.addItem("{sueldo}", httpContext.getMessage( "Sueldo", ""), (short)(0));
      cmbidOperando.addItem("{hora_completa}", httpContext.getMessage( "Hora básica más adicional", ""), (short)(0));
      cmbidOperando.addItem("{feriados_trabajados}", httpContext.getMessage( "Feriados trabajados", ""), (short)(0));
      cmbidOperando.addItem("[vacaciones_descuento]", httpContext.getMessage( "Descuento por días no trabajados por vacaciones", ""), (short)(0));
      cmbidOperando.addItem("[licencias_descuento]", httpContext.getMessage( "Descuento por días no trabajados por licencias", ""), (short)(0));
      cmbidOperando.addItem("{feriados_no_trabajados_descuento}", httpContext.getMessage( "Descuento por días no trabajados feriados", ""), (short)(0));
      cmbidOperando.addItem("{no_laborables_descuento}", httpContext.getMessage( "Descuento por días no trabajados no laborables", ""), (short)(0));
      cmbidOperando.addItem("{sac}", httpContext.getMessage( "Sueldo anual complementario", ""), (short)(0));
      cmbidOperando.addItem("{sac_proporcional}", httpContext.getMessage( "SAC Proporcional", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_adicional}", httpContext.getMessage( "Sueldo Adicional", ""), (short)(0));
      cmbidOperando.addItem("{vacaciones_no_gozadas_ant}", httpContext.getMessage( "Vacaciones no gozadas de año anterior", ""), (short)(0));
      cmbidOperando.addItem("{egreso_descuento}", httpContext.getMessage( "Descuento por días no trabajados por egreso", ""), (short)(0));
      cmbidOperando.addItem("{obra_social_diferencial}", httpContext.getMessage( "Obra social diferencial", ""), (short)(0));
      cmbidOperando.addItem("{dias_HastaFinSemestre}", httpContext.getMessage( "Dias faltantes hasta el fin del semestre", ""), (short)(0));
      cmbidOperando.addItem("{tratamiento_exencion}", httpContext.getMessage( "Cálculo exento por tratamiento de exención de IIGG", ""), (short)(0));
      cmbidOperando.addItem("{horas_nocturnas}", httpContext.getMessage( "Adicional por horas nocturna", ""), (short)(0));
      cmbidOperando.addItem("{extras_al_50}", httpContext.getMessage( "Horas extras al 50%", ""), (short)(0));
      cmbidOperando.addItem("{extras_nocturnas_al_50}", httpContext.getMessage( "Horas extras nocturnas al 50%", ""), (short)(0));
      cmbidOperando.addItem("{extras_nocturnas_al_100}", httpContext.getMessage( "Horas extras nocturnas al 100%", ""), (short)(0));
      cmbidOperando.addItem("{extras_al_100}", httpContext.getMessage( "Horas extras al 100%", ""), (short)(0));
      cmbidOperando.addItem("{retroactivo}", httpContext.getMessage( "Recálculo de liquidaciones anteriores para calcular valores retroactivos", ""), (short)(0));
      cmbidOperando.addItem("{fondo_cese}", httpContext.getMessage( "Fondo de cese laboral", ""), (short)(0));
      cmbidOperando.addItem("{plus_licencia}", httpContext.getMessage( "Plus Licencia", ""), (short)(0));
      cmbidOperando.addItem("{redondeo}", httpContext.getMessage( "Redondeo", ""), (short)(0));
      cmbidOperando.addItem("{leg_prop_adi}", httpContext.getMessage( "Propiedad adicional de legajo", ""), (short)(0));
      cmbidOperando.addItem("{ded_art_30}", httpContext.getMessage( "Deducciones artículo 30", ""), (short)(0));
      cmbidOperando.addItem("{devolucion_ganancias}", httpContext.getMessage( "Devolución ganancias", ""), (short)(0));
      cmbidOperando.addItem("{ded_gen_men}", httpContext.getMessage( "Deducciones generales mensuales", ""), (short)(0));
      cmbidOperando.addItem("{ded_gen_anu}", httpContext.getMessage( "Deducciones generales anuales", ""), (short)(0));
      cmbidOperando.addItem("{rem_gravada_gan}", httpContext.getMessage( "Remuneración gravada en ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gan_neta}", httpContext.getMessage( "Ganancia neta para impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gnsi_sin_dei}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias, menos deducción especial incrementada", ""), (short)(0));
      cmbidOperando.addItem("{gnsi}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gan_neta_topes}", httpContext.getMessage( "Ganancia neta para calcular topes de deducciones de impuestos a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{calculo_iigg_neto}", httpContext.getMessage( "Cálculo de impuesto a las ganancias menos pagos a cuenta de periodos anteriores e importes pagados en liquidaciones anteriores", ""), (short)(0));
      cmbidOperando.addItem("{importe_iigg}", httpContext.getMessage( "Importe a retener de impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("[calculo_iigg]", httpContext.getMessage( "Cálculo de impuesto a las ganancias usando tabla de escalas de AFIP", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_bruto_ganancias}", httpContext.getMessage( "Sueldo Bruto más sueldo bruto de otros empleos", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_bruto_menos_ley}", httpContext.getMessage( "Sueldo bruto menos descuentos de ley", ""), (short)(0));
      cmbidOperando.addItem("{alcanza_ganancias}", httpContext.getMessage( "Empleado es alcanzado por impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_jubilacion}", httpContext.getMessage( "Contribución jubilación", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_inssjp}", httpContext.getMessage( "Contribución  ley 19032", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_aaff}", httpContext.getMessage( "Contribución asignaciones familiares", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_fne}", httpContext.getMessage( "Contribución FNE", ""), (short)(0));
      cmbidOperando.addItem("{grossing_up}", httpContext.getMessage( "Grossing up", ""), (short)(0));
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
      }
      GXCCtl = "vTIENEPARAMETROS_" + sGXsfl_110_idx ;
      chkavTieneparametros.setName( GXCCtl );
      chkavTieneparametros.setWebtags( "" );
      chkavTieneparametros.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavTieneparametros.getInternalname(), "TitleCaption", chkavTieneparametros.getCaption(), !bGXsfl_110_Refreshing);
      chkavTieneparametros.setCheckedValue( "false" );
      AV70tieneParametros = GXutil.strtobool( GXutil.booltostr( AV70tieneParametros)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavTieneparametros.getInternalname(), AV70tieneParametros);
      GXCCtl = "OPEESCANT_" + sGXsfl_110_idx ;
      chkOpeEsCant.setName( GXCCtl );
      chkOpeEsCant.setWebtags( "" );
      chkOpeEsCant.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeEsCant.getInternalname(), "TitleCaption", chkOpeEsCant.getCaption(), !bGXsfl_110_Refreshing);
      chkOpeEsCant.setCheckedValue( "false" );
      A932OpeEsCant = GXutil.strtobool( GXutil.booltostr( A932OpeEsCant)) ;
      GXCCtl = "OPEALIES_" + sGXsfl_110_idx ;
      chkOpeAliEs.setName( GXCCtl );
      chkOpeAliEs.setWebtags( "" );
      chkOpeAliEs.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeAliEs.getInternalname(), "TitleCaption", chkOpeAliEs.getCaption(), !bGXsfl_110_Refreshing);
      chkOpeAliEs.setCheckedValue( "false" );
      A1032OpeAliEs = GXutil.strtobool( GXutil.booltostr( A1032OpeAliEs)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV89Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV61MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV27TFOpeCodFormula',fld:'vTFOPECODFORMULA',pic:''},{av:'AV28TFOpeCodFormula_Sels',fld:'vTFOPECODFORMULA_SELS',pic:''},{av:'AV30TFOpeDescripcion',fld:'vTFOPEDESCRIPCION',pic:''},{av:'AV31TFOpeDescripcion_Sels',fld:'vTFOPEDESCRIPCION_SELS',pic:''},{av:'AV54TFOpeEsCant_Sel',fld:'vTFOPEESCANT_SEL',pic:'9'},{av:'AV55TFOpeAliEs_Sel',fld:'vTFOPEALIES_SEL',pic:'9'},{av:'AV49CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV72sistema_CliCod',fld:'vSISTEMA_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV63WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV49CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtOpeCodFormula_Visible',ctrl:'OPECODFORMULA',prop:'Visible'},{av:'edtOpeDescripcion_Visible',ctrl:'OPEDESCRIPCION',prop:'Visible'},{av:'chkavTieneparametros.getVisible()',ctrl:'vTIENEPARAMETROS',prop:'Visible'},{av:'chkOpeEsCant.getVisible()',ctrl:'OPEESCANT',prop:'Visible'},{av:'chkOpeAliEs.getVisible()',ctrl:'OPEALIES',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV44GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV45GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV46GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV74ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e139N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV89Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV61MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV27TFOpeCodFormula',fld:'vTFOPECODFORMULA',pic:''},{av:'AV28TFOpeCodFormula_Sels',fld:'vTFOPECODFORMULA_SELS',pic:''},{av:'AV30TFOpeDescripcion',fld:'vTFOPEDESCRIPCION',pic:''},{av:'AV31TFOpeDescripcion_Sels',fld:'vTFOPEDESCRIPCION_SELS',pic:''},{av:'AV54TFOpeEsCant_Sel',fld:'vTFOPEESCANT_SEL',pic:'9'},{av:'AV55TFOpeAliEs_Sel',fld:'vTFOPEALIES_SEL',pic:'9'},{av:'AV49CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV72sistema_CliCod',fld:'vSISTEMA_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV63WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e149N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV89Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV61MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV27TFOpeCodFormula',fld:'vTFOPECODFORMULA',pic:''},{av:'AV28TFOpeCodFormula_Sels',fld:'vTFOPECODFORMULA_SELS',pic:''},{av:'AV30TFOpeDescripcion',fld:'vTFOPEDESCRIPCION',pic:''},{av:'AV31TFOpeDescripcion_Sels',fld:'vTFOPEDESCRIPCION_SELS',pic:''},{av:'AV54TFOpeEsCant_Sel',fld:'vTFOPEESCANT_SEL',pic:'9'},{av:'AV55TFOpeAliEs_Sel',fld:'vTFOPEALIES_SEL',pic:'9'},{av:'AV49CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV72sistema_CliCod',fld:'vSISTEMA_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV63WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e159N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV89Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV61MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV27TFOpeCodFormula',fld:'vTFOPECODFORMULA',pic:''},{av:'AV28TFOpeCodFormula_Sels',fld:'vTFOPECODFORMULA_SELS',pic:''},{av:'AV30TFOpeDescripcion',fld:'vTFOPEDESCRIPCION',pic:''},{av:'AV31TFOpeDescripcion_Sels',fld:'vTFOPEDESCRIPCION_SELS',pic:''},{av:'AV54TFOpeEsCant_Sel',fld:'vTFOPEESCANT_SEL',pic:'9'},{av:'AV55TFOpeAliEs_Sel',fld:'vTFOPEALIES_SEL',pic:'9'},{av:'AV49CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV72sistema_CliCod',fld:'vSISTEMA_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV63WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27TFOpeCodFormula',fld:'vTFOPECODFORMULA',pic:''},{av:'AV26TFOpeCodFormula_SelsJson',fld:'vTFOPECODFORMULA_SELSJSON',pic:''},{av:'AV28TFOpeCodFormula_Sels',fld:'vTFOPECODFORMULA_SELS',pic:''},{av:'AV30TFOpeDescripcion',fld:'vTFOPEDESCRIPCION',pic:''},{av:'AV29TFOpeDescripcion_SelsJson',fld:'vTFOPEDESCRIPCION_SELSJSON',pic:''},{av:'AV31TFOpeDescripcion_Sels',fld:'vTFOPEDESCRIPCION_SELS',pic:''},{av:'AV54TFOpeEsCant_Sel',fld:'vTFOPEESCANT_SEL',pic:'9'},{av:'AV55TFOpeAliEs_Sel',fld:'vTFOPEALIES_SEL',pic:'9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e229N2',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9',hsh:true},{av:'cmbidOperando'},{av:'A74idOperando',fld:'IDOPERANDO',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV60Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV70tieneParametros',fld:'vTIENEPARAMETROS',pic:''},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV59VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e119N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV89Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV61MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV27TFOpeCodFormula',fld:'vTFOPECODFORMULA',pic:''},{av:'AV28TFOpeCodFormula_Sels',fld:'vTFOPECODFORMULA_SELS',pic:''},{av:'AV30TFOpeDescripcion',fld:'vTFOPEDESCRIPCION',pic:''},{av:'AV31TFOpeDescripcion_Sels',fld:'vTFOPEDESCRIPCION_SELS',pic:''},{av:'AV54TFOpeEsCant_Sel',fld:'vTFOPEESCANT_SEL',pic:'9'},{av:'AV55TFOpeAliEs_Sel',fld:'vTFOPEALIES_SEL',pic:'9'},{av:'AV49CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV72sistema_CliCod',fld:'vSISTEMA_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV63WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV49CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtOpeCodFormula_Visible',ctrl:'OPECODFORMULA',prop:'Visible'},{av:'edtOpeDescripcion_Visible',ctrl:'OPEDESCRIPCION',prop:'Visible'},{av:'chkavTieneparametros.getVisible()',ctrl:'vTIENEPARAMETROS',prop:'Visible'},{av:'chkOpeEsCant.getVisible()',ctrl:'OPEESCANT',prop:'Visible'},{av:'chkOpeAliEs.getVisible()',ctrl:'OPEALIES',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV44GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV45GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV46GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV74ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e129N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV89Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV61MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV27TFOpeCodFormula',fld:'vTFOPECODFORMULA',pic:''},{av:'AV28TFOpeCodFormula_Sels',fld:'vTFOPECODFORMULA_SELS',pic:''},{av:'AV30TFOpeDescripcion',fld:'vTFOPEDESCRIPCION',pic:''},{av:'AV31TFOpeDescripcion_Sels',fld:'vTFOPEDESCRIPCION_SELS',pic:''},{av:'AV54TFOpeEsCant_Sel',fld:'vTFOPEESCANT_SEL',pic:'9'},{av:'AV55TFOpeAliEs_Sel',fld:'vTFOPEALIES_SEL',pic:'9'},{av:'AV49CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV72sistema_CliCod',fld:'vSISTEMA_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV63WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV26TFOpeCodFormula_SelsJson',fld:'vTFOPECODFORMULA_SELSJSON',pic:''},{av:'AV29TFOpeDescripcion_SelsJson',fld:'vTFOPEDESCRIPCION_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27TFOpeCodFormula',fld:'vTFOPECODFORMULA',pic:''},{av:'AV28TFOpeCodFormula_Sels',fld:'vTFOPECODFORMULA_SELS',pic:''},{av:'AV30TFOpeDescripcion',fld:'vTFOPEDESCRIPCION',pic:''},{av:'AV31TFOpeDescripcion_Sels',fld:'vTFOPEDESCRIPCION_SELS',pic:''},{av:'AV54TFOpeEsCant_Sel',fld:'vTFOPEESCANT_SEL',pic:'9'},{av:'AV55TFOpeAliEs_Sel',fld:'vTFOPEALIES_SEL',pic:'9'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV29TFOpeDescripcion_SelsJson',fld:'vTFOPEDESCRIPCION_SELSJSON',pic:''},{av:'AV26TFOpeCodFormula_SelsJson',fld:'vTFOPECODFORMULA_SELSJSON',pic:''},{av:'AV49CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtOpeCodFormula_Visible',ctrl:'OPECODFORMULA',prop:'Visible'},{av:'edtOpeDescripcion_Visible',ctrl:'OPEDESCRIPCION',prop:'Visible'},{av:'chkavTieneparametros.getVisible()',ctrl:'vTIENEPARAMETROS',prop:'Visible'},{av:'chkOpeEsCant.getVisible()',ctrl:'OPEESCANT',prop:'Visible'},{av:'chkOpeAliEs.getVisible()',ctrl:'OPEALIES',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV44GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV45GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV46GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV74ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOREPORTARNOUSADOS'","{handler:'e169N2',iparms:[]");
      setEventMetadata("'DOREPORTARNOUSADOS'",",oparms:[]}");
      setEventMetadata("'DOINSERT'","{handler:'e179N2',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9',hsh:true},{av:'cmbidOperando'},{av:'A74idOperando',fld:'IDOPERANDO',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e189N2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e199N2',iparms:[{av:'AV63WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV61MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV49CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e239N1',iparms:[]");
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
      wcpOAV61MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV61MenuOpcCod = "" ;
      AV19ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV89Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27TFOpeCodFormula = "" ;
      AV28TFOpeCodFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV30TFOpeDescripcion = "" ;
      AV31TFOpeDescripcion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV42DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV74ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV46GridAppliedFilters = "" ;
      AV26TFOpeCodFormula_SelsJson = "" ;
      AV29TFOpeDescripcion_SelsJson = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtnreportarnousados_Jsonclick = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A74idOperando = "" ;
      A473OpeCodFormula = "" ;
      A474OpeDescripcion = "" ;
      AV60Display = "" ;
      AV59VerSVG = "" ;
      AV91Calculowwds_2_tfopecodformula_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV93Calculowwds_4_tfopedescripcion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV90Calculowwds_1_tfopecodformula = "" ;
      lV92Calculowwds_3_tfopedescripcion = "" ;
      AV90Calculowwds_1_tfopecodformula = "" ;
      AV92Calculowwds_3_tfopedescripcion = "" ;
      H009N2_A1032OpeAliEs = new boolean[] {false} ;
      H009N2_A932OpeEsCant = new boolean[] {false} ;
      H009N2_A474OpeDescripcion = new String[] {""} ;
      H009N2_A473OpeCodFormula = new String[] {""} ;
      H009N2_A74idOperando = new String[] {""} ;
      H009N2_A46PaiCod = new short[1] ;
      H009N3_AGRID_nRecordCount = new long[1] ;
      AV69WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV64MenuBienveImgURL = "" ;
      GXv_char5 = new String[1] ;
      AV66MenuBienveTitulo = "" ;
      AV67MenuBienveTexto = "" ;
      AV88Welcomemessage_foto_GXI = "" ;
      AV82observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext12 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV17ColumnsSelectorXML = "" ;
      AV81MenuOpcTitulo = "" ;
      GXv_int11 = new short[1] ;
      AV85filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV75ManageFiltersXml = "" ;
      AV52ExcelFilename = "" ;
      AV53ErrorMessage = "" ;
      AV18UserCustomValue = "" ;
      AV20ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector15 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char10 = "" ;
      GXt_char9 = "" ;
      GXv_char6 = new String[1] ;
      GXv_SdtWWPGridState18 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV65textoNoMostrara = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculoww__default(),
         new Object[] {
             new Object[] {
            H009N2_A1032OpeAliEs, H009N2_A932OpeEsCant, H009N2_A474OpeDescripcion, H009N2_A473OpeCodFormula, H009N2_A74idOperando, H009N2_A46PaiCod
            }
            , new Object[] {
            H009N3_AGRID_nRecordCount
            }
         }
      );
      AV89Pgmname = "CalculoWW" ;
      /* GeneXus formulas. */
      AV89Pgmname = "CalculoWW" ;
      Gx_err = (short)(0) ;
      chkavTieneparametros.setEnabled( 0 );
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV76ManageFiltersExecutionStep ;
   private byte AV54TFOpeEsCant_Sel ;
   private byte AV55TFOpeAliEs_Sel ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV94Calculowwds_5_tfopeescant_sel ;
   private byte AV95Calculowwds_6_tfopealies_sel ;
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
   private short A46PaiCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV71PaiCod ;
   private short GXv_int11[] ;
   private short edtavVersvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV49CliCod ;
   private int AV72sistema_CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Islastpage ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV91Calculowwds_2_tfopecodformula_sels_size ;
   private int AV93Calculowwds_4_tfopedescripcion_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtOpeCodFormula_Visible ;
   private int edtOpeDescripcion_Visible ;
   private int edtavVersvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV84filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV43PageToGo ;
   private int edtavDisplay_Visible ;
   private int bttBtninsert_Visible ;
   private int AV96GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV44GridCurrentPage ;
   private long AV45GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_110_idx="0001" ;
   private String AV89Pgmname ;
   private String AV27TFOpeCodFormula ;
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
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Fixable ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String TempTags ;
   private String bttBtnreportarnousados_Internalname ;
   private String bttBtnreportarnousados_Jsonclick ;
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
   private String A74idOperando ;
   private String A473OpeCodFormula ;
   private String edtOpeCodFormula_Internalname ;
   private String edtOpeDescripcion_Internalname ;
   private String AV60Display ;
   private String edtavDisplay_Internalname ;
   private String AV59VerSVG ;
   private String edtavVersvg_Internalname ;
   private String scmdbuf ;
   private String lV90Calculowwds_1_tfopecodformula ;
   private String AV90Calculowwds_1_tfopecodformula ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String GXv_char5[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String AV82observerPalabra ;
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
   private String bttBtninsert_Internalname ;
   private String GXt_char10 ;
   private String GXt_char9 ;
   private String GXv_char6[] ;
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
   private String GXCCtl ;
   private String edtOpeCodFormula_Jsonclick ;
   private String edtOpeDescripcion_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV63WelcomeMessage_NoMostrarMas ;
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
   private boolean AV70tieneParametros ;
   private boolean A932OpeEsCant ;
   private boolean A1032OpeAliEs ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV68MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean AV73TempBoolean ;
   private boolean GXt_boolean13 ;
   private boolean GXv_boolean8[] ;
   private boolean AV69WelcomeMessage_Foto_IsBlob ;
   private String AV26TFOpeCodFormula_SelsJson ;
   private String AV29TFOpeDescripcion_SelsJson ;
   private String AV67MenuBienveTexto ;
   private String AV17ColumnsSelectorXML ;
   private String AV75ManageFiltersXml ;
   private String AV18UserCustomValue ;
   private String AV65textoNoMostrara ;
   private String wcpOAV61MenuOpcCod ;
   private String AV61MenuOpcCod ;
   private String AV30TFOpeDescripcion ;
   private String AV46GridAppliedFilters ;
   private String A474OpeDescripcion ;
   private String lV92Calculowwds_3_tfopedescripcion ;
   private String AV92Calculowwds_3_tfopedescripcion ;
   private String AV64MenuBienveImgURL ;
   private String AV66MenuBienveTitulo ;
   private String AV88Welcomemessage_foto_GXI ;
   private String AV81MenuOpcTitulo ;
   private String AV85filtrosTexto ;
   private String AV52ExcelFilename ;
   private String AV53ErrorMessage ;
   private String AV69WelcomeMessage_Foto ;
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
   private GXSimpleCollection<String> AV91Calculowwds_2_tfopecodformula_sels ;
   private GXSimpleCollection<String> AV93Calculowwds_4_tfopedescripcion_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbidOperando ;
   private ICheckbox chkavTieneparametros ;
   private ICheckbox chkOpeEsCant ;
   private ICheckbox chkOpeAliEs ;
   private IDataStoreProvider pr_default ;
   private boolean[] H009N2_A1032OpeAliEs ;
   private boolean[] H009N2_A932OpeEsCant ;
   private String[] H009N2_A474OpeDescripcion ;
   private String[] H009N2_A473OpeCodFormula ;
   private String[] H009N2_A74idOperando ;
   private short[] H009N2_A46PaiCod ;
   private long[] H009N3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV28TFOpeCodFormula_Sels ;
   private GXSimpleCollection<String> AV31TFOpeDescripcion_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV74ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext12[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState18[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector15[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV42DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class calculoww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H009N2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A473OpeCodFormula ,
                                          GXSimpleCollection<String> AV91Calculowwds_2_tfopecodformula_sels ,
                                          String A474OpeDescripcion ,
                                          GXSimpleCollection<String> AV93Calculowwds_4_tfopedescripcion_sels ,
                                          int AV91Calculowwds_2_tfopecodformula_sels_size ,
                                          String AV90Calculowwds_1_tfopecodformula ,
                                          int AV93Calculowwds_4_tfopedescripcion_sels_size ,
                                          String AV92Calculowwds_3_tfopedescripcion ,
                                          byte AV94Calculowwds_5_tfopeescant_sel ,
                                          byte AV95Calculowwds_6_tfopealies_sel ,
                                          boolean A932OpeEsCant ,
                                          boolean A1032OpeAliEs ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[5];
      Object[] GXv_Object20 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " OpeAliEs, OpeEsCant, OpeDescripcion, OpeCodFormula, idOperando, PaiCod" ;
      sFromString = " FROM calculo" ;
      sOrderString = "" ;
      if ( ( AV91Calculowwds_2_tfopecodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Calculowwds_1_tfopecodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int19[0] = (byte)(1) ;
      }
      if ( AV91Calculowwds_2_tfopecodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Calculowwds_2_tfopecodformula_sels, "OpeCodFormula IN (", ")")+")");
      }
      if ( ( AV93Calculowwds_4_tfopedescripcion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Calculowwds_3_tfopedescripcion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeDescripcion) like LOWER(?))");
      }
      else
      {
         GXv_int19[1] = (byte)(1) ;
      }
      if ( AV93Calculowwds_4_tfopedescripcion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Calculowwds_4_tfopedescripcion_sels, "OpeDescripcion IN (", ")")+")");
      }
      if ( AV94Calculowwds_5_tfopeescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeEsCant = TRUE)");
      }
      if ( AV94Calculowwds_5_tfopeescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeEsCant = FALSE)");
      }
      if ( AV95Calculowwds_6_tfopealies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeAliEs = TRUE)");
      }
      if ( AV95Calculowwds_6_tfopealies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeAliEs = FALSE)");
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY OpeCodFormula, PaiCod, idOperando" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY OpeCodFormula DESC, PaiCod, idOperando" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY OpeDescripcion, PaiCod, idOperando" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY OpeDescripcion DESC, PaiCod, idOperando" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY OpeEsCant, PaiCod, idOperando" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY OpeEsCant DESC, PaiCod, idOperando" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY OpeAliEs, PaiCod, idOperando" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY OpeAliEs DESC, PaiCod, idOperando" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY PaiCod, idOperando" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_H009N3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A473OpeCodFormula ,
                                          GXSimpleCollection<String> AV91Calculowwds_2_tfopecodformula_sels ,
                                          String A474OpeDescripcion ,
                                          GXSimpleCollection<String> AV93Calculowwds_4_tfopedescripcion_sels ,
                                          int AV91Calculowwds_2_tfopecodformula_sels_size ,
                                          String AV90Calculowwds_1_tfopecodformula ,
                                          int AV93Calculowwds_4_tfopedescripcion_sels_size ,
                                          String AV92Calculowwds_3_tfopedescripcion ,
                                          byte AV94Calculowwds_5_tfopeescant_sel ,
                                          byte AV95Calculowwds_6_tfopealies_sel ,
                                          boolean A932OpeEsCant ,
                                          boolean A1032OpeAliEs ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[2];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM calculo" ;
      if ( ( AV91Calculowwds_2_tfopecodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Calculowwds_1_tfopecodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int22[0] = (byte)(1) ;
      }
      if ( AV91Calculowwds_2_tfopecodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Calculowwds_2_tfopecodformula_sels, "OpeCodFormula IN (", ")")+")");
      }
      if ( ( AV93Calculowwds_4_tfopedescripcion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Calculowwds_3_tfopedescripcion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeDescripcion) like LOWER(?))");
      }
      else
      {
         GXv_int22[1] = (byte)(1) ;
      }
      if ( AV93Calculowwds_4_tfopedescripcion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Calculowwds_4_tfopedescripcion_sels, "OpeDescripcion IN (", ")")+")");
      }
      if ( AV94Calculowwds_5_tfopeescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeEsCant = TRUE)");
      }
      if ( AV94Calculowwds_5_tfopeescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeEsCant = FALSE)");
      }
      if ( AV95Calculowwds_6_tfopealies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeAliEs = TRUE)");
      }
      if ( AV95Calculowwds_6_tfopealies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeAliEs = FALSE)");
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
                  return conditional_H009N2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Boolean) dynConstraints[10]).booleanValue() , ((Boolean) dynConstraints[11]).booleanValue() , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() );
            case 1 :
                  return conditional_H009N3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Boolean) dynConstraints[10]).booleanValue() , ((Boolean) dynConstraints[11]).booleanValue() , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H009N2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H009N3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
                  stmt.setString(sIdx, (String)parms[5], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[2], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
      }
   }

}

