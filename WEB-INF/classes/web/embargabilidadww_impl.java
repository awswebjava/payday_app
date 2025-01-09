package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class embargabilidadww_impl extends GXDataArea
{
   public embargabilidadww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public embargabilidadww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( embargabilidadww_impl.class ));
   }

   public embargabilidadww_impl( int remoteHandle ,
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
            AV40MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40MenuOpcCod", AV40MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV40MenuOpcCod, ""))));
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
      AV35PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV52ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV18ColumnsSelector);
      AV65Pgmname = httpContext.GetPar( "Pgmname") ;
      AV40MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV22TFEmbargaDescrip = httpContext.GetPar( "TFEmbargaDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV23TFEmbargaDescrip_Sels);
      AV33TFEmbargaExplicacion = httpContext.GetPar( "TFEmbargaExplicacion") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV34TFEmbargaExplicacion_Sels);
      AV31OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV29CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV42WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV35PaiCod, AV52ManageFiltersExecutionStep, AV18ColumnsSelector, AV65Pgmname, AV40MenuOpcCod, AV12GridState, AV22TFEmbargaDescrip, AV23TFEmbargaDescrip_Sels, AV33TFEmbargaExplicacion, AV34TFEmbargaExplicacion_Sels, AV31OrderedBy, AV14OrderedDsc, AV29CliCod, AV42WelcomeMessage_NoMostrarMas) ;
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
      paCA2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startCA2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.embargabilidadww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV40MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV65Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV40MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29CliCod), "ZZZZZ9")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV24DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV24DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV18ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV18ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV50ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV50ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV26GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV27GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV28GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV52ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV65Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV65Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV40MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV40MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMBARGADESCRIP", AV22TFEmbargaDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFEMBARGADESCRIP_SELS", AV23TFEmbargaDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFEMBARGADESCRIP_SELS", AV23TFEmbargaDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMBARGAEXPLICACION", AV33TFEmbargaExplicacion);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFEMBARGAEXPLICACION_SELS", AV34TFEmbargaExplicacion_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFEMBARGAEXPLICACION_SELS", AV34TFEmbargaExplicacion_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV31OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV29CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMBARGADESCRIP_SELSJSON", AV21TFEmbargaDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFEMBARGAEXPLICACION_SELSJSON", AV32TFEmbargaExplicacion_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV35PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
         weCA2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtCA2( ) ;
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
      return formatLink("web.embargabilidadww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV40MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "embargabilidadWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " embargabilidad", "") ;
   }

   public void wbCA0( )
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
         wb_table1_9_CA2( true) ;
      }
      else
      {
         wb_table1_9_CA2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_CA2e( boolean wbgen )
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
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV24DDO_TitleSettingsIcons);
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

   public void startCA2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " embargabilidad", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupCA0( ) ;
   }

   public void wsCA2( )
   {
      startCA2( ) ;
      evtCA2( ) ;
   }

   public void evtCA2( )
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
                           e11CA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12CA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13CA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14CA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15CA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e16CA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17CA2 ();
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
                           A1161EmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( edtEmbargaSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1160EmbarPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmbarPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1162EmbargaDescrip = GXutil.upper( httpContext.cgiGet( edtEmbargaDescrip_Internalname)) ;
                           A1203EmbargaExplicacion = httpContext.cgiGet( edtEmbargaExplicacion_Internalname) ;
                           AV39Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV39Display);
                           AV38VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV38VerSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e18CA2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e19CA2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20CA2 ();
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

   public void weCA2( )
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

   public void paCA2( )
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
                                 short AV35PaiCod ,
                                 byte AV52ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV18ColumnsSelector ,
                                 String AV65Pgmname ,
                                 String AV40MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 String AV22TFEmbargaDescrip ,
                                 GXSimpleCollection<String> AV23TFEmbargaDescrip_Sels ,
                                 String AV33TFEmbargaExplicacion ,
                                 GXSimpleCollection<String> AV34TFEmbargaExplicacion_Sels ,
                                 short AV31OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 int AV29CliCod ,
                                 boolean AV42WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e19CA2 ();
      GRID_nCurrentRecord = 0 ;
      rfCA2( ) ;
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
      AV42WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV42WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42WelcomeMessage_NoMostrarMas", AV42WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfCA2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV65Pgmname = "embargabilidadWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
   }

   public void rfCA2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(108) ;
      /* Execute user event: Refresh */
      e19CA2 ();
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
                                              A1162EmbargaDescrip ,
                                              AV67Embargabilidadwwds_2_tfembargadescrip_sels ,
                                              A1203EmbargaExplicacion ,
                                              AV69Embargabilidadwwds_4_tfembargaexplicacion_sels ,
                                              Integer.valueOf(AV67Embargabilidadwwds_2_tfembargadescrip_sels.size()) ,
                                              AV66Embargabilidadwwds_1_tfembargadescrip ,
                                              Integer.valueOf(AV69Embargabilidadwwds_4_tfembargaexplicacion_sels.size()) ,
                                              AV68Embargabilidadwwds_3_tfembargaexplicacion ,
                                              Short.valueOf(AV35PaiCod) ,
                                              Short.valueOf(A1160EmbarPaiCod) ,
                                              Short.valueOf(AV31OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV66Embargabilidadwwds_1_tfembargadescrip = GXutil.concat( GXutil.rtrim( AV66Embargabilidadwwds_1_tfembargadescrip), "%", "") ;
         lV68Embargabilidadwwds_3_tfembargaexplicacion = GXutil.concat( GXutil.rtrim( AV68Embargabilidadwwds_3_tfembargaexplicacion), "%", "") ;
         /* Using cursor H00CA2 */
         pr_default.execute(0, new Object[] {lV66Embargabilidadwwds_1_tfembargadescrip, lV68Embargabilidadwwds_3_tfembargaexplicacion, Short.valueOf(AV35PaiCod), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_108_idx = 1 ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1203EmbargaExplicacion = H00CA2_A1203EmbargaExplicacion[0] ;
            A1162EmbargaDescrip = H00CA2_A1162EmbargaDescrip[0] ;
            A1160EmbarPaiCod = H00CA2_A1160EmbarPaiCod[0] ;
            A1161EmbargaSec = H00CA2_A1161EmbargaSec[0] ;
            e20CA2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(108) ;
         wbCA0( ) ;
      }
      bGXsfl_108_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesCA2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV65Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV65Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV40MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV40MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV29CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29CliCod), "ZZZZZ9")));
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
      AV66Embargabilidadwwds_1_tfembargadescrip = AV22TFEmbargaDescrip ;
      AV67Embargabilidadwwds_2_tfembargadescrip_sels = AV23TFEmbargaDescrip_Sels ;
      AV68Embargabilidadwwds_3_tfembargaexplicacion = AV33TFEmbargaExplicacion ;
      AV69Embargabilidadwwds_4_tfembargaexplicacion_sels = AV34TFEmbargaExplicacion_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1162EmbargaDescrip ,
                                           AV67Embargabilidadwwds_2_tfembargadescrip_sels ,
                                           A1203EmbargaExplicacion ,
                                           AV69Embargabilidadwwds_4_tfembargaexplicacion_sels ,
                                           Integer.valueOf(AV67Embargabilidadwwds_2_tfembargadescrip_sels.size()) ,
                                           AV66Embargabilidadwwds_1_tfembargadescrip ,
                                           Integer.valueOf(AV69Embargabilidadwwds_4_tfembargaexplicacion_sels.size()) ,
                                           AV68Embargabilidadwwds_3_tfembargaexplicacion ,
                                           Short.valueOf(AV35PaiCod) ,
                                           Short.valueOf(A1160EmbarPaiCod) ,
                                           Short.valueOf(AV31OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV66Embargabilidadwwds_1_tfembargadescrip = GXutil.concat( GXutil.rtrim( AV66Embargabilidadwwds_1_tfembargadescrip), "%", "") ;
      lV68Embargabilidadwwds_3_tfembargaexplicacion = GXutil.concat( GXutil.rtrim( AV68Embargabilidadwwds_3_tfembargaexplicacion), "%", "") ;
      /* Using cursor H00CA3 */
      pr_default.execute(1, new Object[] {lV66Embargabilidadwwds_1_tfembargadescrip, lV68Embargabilidadwwds_3_tfembargaexplicacion, Short.valueOf(AV35PaiCod)});
      GRID_nRecordCount = H00CA3_AGRID_nRecordCount[0] ;
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
      AV66Embargabilidadwwds_1_tfembargadescrip = AV22TFEmbargaDescrip ;
      AV67Embargabilidadwwds_2_tfembargadescrip_sels = AV23TFEmbargaDescrip_Sels ;
      AV68Embargabilidadwwds_3_tfembargaexplicacion = AV33TFEmbargaExplicacion ;
      AV69Embargabilidadwwds_4_tfembargaexplicacion_sels = AV34TFEmbargaExplicacion_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV35PaiCod, AV52ManageFiltersExecutionStep, AV18ColumnsSelector, AV65Pgmname, AV40MenuOpcCod, AV12GridState, AV22TFEmbargaDescrip, AV23TFEmbargaDescrip_Sels, AV33TFEmbargaExplicacion, AV34TFEmbargaExplicacion_Sels, AV31OrderedBy, AV14OrderedDsc, AV29CliCod, AV42WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV66Embargabilidadwwds_1_tfembargadescrip = AV22TFEmbargaDescrip ;
      AV67Embargabilidadwwds_2_tfembargadescrip_sels = AV23TFEmbargaDescrip_Sels ;
      AV68Embargabilidadwwds_3_tfembargaexplicacion = AV33TFEmbargaExplicacion ;
      AV69Embargabilidadwwds_4_tfembargaexplicacion_sels = AV34TFEmbargaExplicacion_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV35PaiCod, AV52ManageFiltersExecutionStep, AV18ColumnsSelector, AV65Pgmname, AV40MenuOpcCod, AV12GridState, AV22TFEmbargaDescrip, AV23TFEmbargaDescrip_Sels, AV33TFEmbargaExplicacion, AV34TFEmbargaExplicacion_Sels, AV31OrderedBy, AV14OrderedDsc, AV29CliCod, AV42WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV66Embargabilidadwwds_1_tfembargadescrip = AV22TFEmbargaDescrip ;
      AV67Embargabilidadwwds_2_tfembargadescrip_sels = AV23TFEmbargaDescrip_Sels ;
      AV68Embargabilidadwwds_3_tfembargaexplicacion = AV33TFEmbargaExplicacion ;
      AV69Embargabilidadwwds_4_tfembargaexplicacion_sels = AV34TFEmbargaExplicacion_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV35PaiCod, AV52ManageFiltersExecutionStep, AV18ColumnsSelector, AV65Pgmname, AV40MenuOpcCod, AV12GridState, AV22TFEmbargaDescrip, AV23TFEmbargaDescrip_Sels, AV33TFEmbargaExplicacion, AV34TFEmbargaExplicacion_Sels, AV31OrderedBy, AV14OrderedDsc, AV29CliCod, AV42WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV66Embargabilidadwwds_1_tfembargadescrip = AV22TFEmbargaDescrip ;
      AV67Embargabilidadwwds_2_tfembargadescrip_sels = AV23TFEmbargaDescrip_Sels ;
      AV68Embargabilidadwwds_3_tfembargaexplicacion = AV33TFEmbargaExplicacion ;
      AV69Embargabilidadwwds_4_tfembargaexplicacion_sels = AV34TFEmbargaExplicacion_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV35PaiCod, AV52ManageFiltersExecutionStep, AV18ColumnsSelector, AV65Pgmname, AV40MenuOpcCod, AV12GridState, AV22TFEmbargaDescrip, AV23TFEmbargaDescrip_Sels, AV33TFEmbargaExplicacion, AV34TFEmbargaExplicacion_Sels, AV31OrderedBy, AV14OrderedDsc, AV29CliCod, AV42WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV66Embargabilidadwwds_1_tfembargadescrip = AV22TFEmbargaDescrip ;
      AV67Embargabilidadwwds_2_tfembargadescrip_sels = AV23TFEmbargaDescrip_Sels ;
      AV68Embargabilidadwwds_3_tfembargaexplicacion = AV33TFEmbargaExplicacion ;
      AV69Embargabilidadwwds_4_tfembargaexplicacion_sels = AV34TFEmbargaExplicacion_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV35PaiCod, AV52ManageFiltersExecutionStep, AV18ColumnsSelector, AV65Pgmname, AV40MenuOpcCod, AV12GridState, AV22TFEmbargaDescrip, AV23TFEmbargaDescrip_Sels, AV33TFEmbargaExplicacion, AV34TFEmbargaExplicacion_Sels, AV31OrderedBy, AV14OrderedDsc, AV29CliCod, AV42WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV65Pgmname = "embargabilidadWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupCA0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18CA2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV24DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV18ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV50ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_108 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_108"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV26GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV27GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV28GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         AV48WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV42WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42WelcomeMessage_NoMostrarMas", AV42WelcomeMessage_NoMostrarMas);
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
      e18CA2 ();
      if (returnInSub) return;
   }

   public void e18CA2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV40MenuOpcCod, "", "") ;
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
      Form.setCaption( httpContext.getMessage( " embargabilidad", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV31OrderedBy < 1 )
      {
         AV31OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV24DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV24DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char3[0] = AV43MenuBienveImgURL ;
      GXv_char4[0] = AV45MenuBienveTitulo ;
      GXv_char5[0] = AV46MenuBienveTexto ;
      GXv_boolean6[0] = AV47MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV40MenuOpcCod, GXv_char3, GXv_char4, GXv_char5, GXv_boolean6) ;
      embargabilidadww_impl.this.AV43MenuBienveImgURL = GXv_char3[0] ;
      embargabilidadww_impl.this.AV45MenuBienveTitulo = GXv_char4[0] ;
      embargabilidadww_impl.this.AV46MenuBienveTexto = GXv_char5[0] ;
      embargabilidadww_impl.this.AV47MenuBienveVisible = GXv_boolean6[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV47MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV47MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV45MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV46MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV48WelcomeMessage_Foto = AV43MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV48WelcomeMessage_Foto)==0) ? AV64Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV48WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV48WelcomeMessage_Foto), true);
         AV64Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV43MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV48WelcomeMessage_Foto)==0) ? AV64Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV48WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV48WelcomeMessage_Foto), true);
      }
      GXt_char7 = "" ;
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char5) ;
      embargabilidadww_impl.this.GXt_char8 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char8, GXv_char4) ;
      embargabilidadww_impl.this.GXt_char7 = GXv_char4[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char7 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV61observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV61observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV61observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV61observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXt_int9 = AV29CliCod ;
      GXv_int10[0] = GXt_int9 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int10) ;
      embargabilidadww_impl.this.GXt_int9 = GXv_int10[0] ;
      AV29CliCod = GXt_int9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29CliCod), "ZZZZZ9")));
      GXv_int11[0] = AV35PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV29CliCod, GXv_int11) ;
      embargabilidadww_impl.this.AV35PaiCod = GXv_int11[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35PaiCod), 4, 0));
      GXt_boolean12 = AV49paisEs ;
      GXv_boolean6[0] = GXt_boolean12 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean6) ;
      embargabilidadww_impl.this.GXt_boolean12 = GXv_boolean6[0] ;
      AV49paisEs = GXt_boolean12 ;
   }

   public void e19CA2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext13[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext13) ;
      AV6WWPContext = GXv_SdtWWPContext13[0] ;
      if ( AV52ManageFiltersExecutionStep == 1 )
      {
         AV52ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52ManageFiltersExecutionStep", GXutil.str( AV52ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV52ManageFiltersExecutionStep == 2 )
      {
         AV52ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52ManageFiltersExecutionStep", GXutil.str( AV52ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV20Session.getValue("embargabilidadWWColumnsSelector"), "") != 0 )
      {
         AV16ColumnsSelectorXML = AV20Session.getValue("embargabilidadWWColumnsSelector") ;
         AV18ColumnsSelector.fromxml(AV16ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S162 ();
         if (returnInSub) return;
      }
      edtEmbargaDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV18ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmbargaDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbargaDescrip_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtEmbargaExplicacion_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV18ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmbargaExplicacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbargaExplicacion_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV18ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      AV26GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GridCurrentPage), 10, 0));
      AV27GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GridPageCount), 10, 0));
      GXt_char8 = AV28GridAppliedFilters ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV65Pgmname, GXv_char5) ;
      embargabilidadww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV28GridAppliedFilters = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28GridAppliedFilters", AV28GridAppliedFilters);
      GXt_char8 = AV57MenuOpcTitulo ;
      GXv_char5[0] = GXt_char8 ;
      new web.gettxtcount(remoteHandle, context).execute( AV40MenuOpcCod, GXv_char5) ;
      embargabilidadww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV57MenuOpcTitulo = GXt_char8 ;
      if ( (GXutil.strcmp("", AV57MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV57MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int11[0] = (short)(AV59filterCount) ;
      GXv_char5[0] = AV60filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int11, GXv_char5) ;
      embargabilidadww_impl.this.AV59filterCount = GXv_int11[0] ;
      embargabilidadww_impl.this.AV60filtrosTexto = GXv_char5[0] ;
      if ( AV59filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV59filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV60filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV66Embargabilidadwwds_1_tfembargadescrip = AV22TFEmbargaDescrip ;
      AV67Embargabilidadwwds_2_tfembargadescrip_sels = AV23TFEmbargaDescrip_Sels ;
      AV68Embargabilidadwwds_3_tfembargaexplicacion = AV33TFEmbargaExplicacion ;
      AV69Embargabilidadwwds_4_tfembargaexplicacion_sels = AV34TFEmbargaExplicacion_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV18ColumnsSelector", AV18ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50ManageFiltersData", AV50ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e13CA2( )
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
         AV25PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV25PageToGo) ;
      }
   }

   public void e14CA2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15CA2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV31OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31OrderedBy), 4, 0));
         AV14OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmbargaDescrip") == 0 )
         {
            AV22TFEmbargaDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFEmbargaDescrip", AV22TFEmbargaDescrip);
            AV21TFEmbargaDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21TFEmbargaDescrip_SelsJson", AV21TFEmbargaDescrip_SelsJson);
            AV23TFEmbargaDescrip_Sels.fromJSonString(AV21TFEmbargaDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EmbargaExplicacion") == 0 )
         {
            AV33TFEmbargaExplicacion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFEmbargaExplicacion", AV33TFEmbargaExplicacion);
            AV32TFEmbargaExplicacion_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFEmbargaExplicacion_SelsJson", AV32TFEmbargaExplicacion_SelsJson);
            AV34TFEmbargaExplicacion_Sels.fromJSonString(AV32TFEmbargaExplicacion_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23TFEmbargaDescrip_Sels", AV23TFEmbargaDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34TFEmbargaExplicacion_Sels", AV34TFEmbargaExplicacion_Sels);
   }

   private void e20CA2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV39Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV39Display);
      edtavDisplay_Link = formatLink("web.embargabilidadview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A1161EmbargaSec,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"EmbargaSec","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char8 = AV38VerSVG ;
      GXv_char5[0] = GXt_char8 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char5) ;
      embargabilidadww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV38VerSVG = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV38VerSVG);
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

   public void e11CA2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV16ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV18ColumnsSelector.fromJSonString(AV16ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "embargabilidadWWColumnsSelector", ((GXutil.strcmp("", AV16ColumnsSelectorXML)==0) ? "" : AV18ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV18ColumnsSelector", AV18ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50ManageFiltersData", AV50ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e12CA2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("embargabilidadWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV65Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV52ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52ManageFiltersExecutionStep", GXutil.str( AV52ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("embargabilidadWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV52ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52ManageFiltersExecutionStep", GXutil.str( AV52ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char8 = AV51ManageFiltersXml ;
         GXv_char5[0] = GXt_char8 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "embargabilidadWWFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         embargabilidadww_impl.this.GXt_char8 = GXv_char5[0] ;
         AV51ManageFiltersXml = GXt_char8 ;
         if ( (GXutil.strcmp("", AV51ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S172 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV65Pgmname+"GridState", AV51ManageFiltersXml) ;
            AV12GridState.fromxml(AV51ManageFiltersXml, null, null);
            AV31OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31OrderedBy), 4, 0));
            AV14OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23TFEmbargaDescrip_Sels", AV23TFEmbargaDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34TFEmbargaExplicacion_Sels", AV34TFEmbargaExplicacion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV18ColumnsSelector", AV18ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50ManageFiltersData", AV50ManageFiltersData);
   }

   public void e16CA2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char5[0] = AV36ExcelFilename ;
      GXv_char4[0] = AV37ErrorMessage ;
      new web.embargabilidadwwexport(remoteHandle, context).execute( GXv_char5, GXv_char4) ;
      embargabilidadww_impl.this.AV36ExcelFilename = GXv_char5[0] ;
      embargabilidadww_impl.this.AV37ErrorMessage = GXv_char4[0] ;
      if ( GXutil.strcmp(AV36ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV36ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV37ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV31OrderedBy, 4, 0))+":"+(AV14OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S162( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV18ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14[0] = AV18ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmbargaDescrip", "", "Descripción", true, "") ;
      AV18ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV18ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "EmbargaExplicacion", "", "Explicacion", true, "") ;
      AV18ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV18ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&VerSVG", "", "", true, "") ;
      AV18ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXt_char8 = AV17UserCustomValue ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "embargabilidadWWColumnsSelector", GXv_char5) ;
      embargabilidadww_impl.this.GXt_char8 = GXv_char5[0] ;
      AV17UserCustomValue = GXt_char8 ;
      if ( ! ( (GXutil.strcmp("", AV17UserCustomValue)==0) ) )
      {
         AV19ColumnsSelectorAux.fromxml(AV17UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector15[0] = AV18ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, GXv_SdtWWPColumnsSelector15) ;
         AV19ColumnsSelectorAux = GXv_SdtWWPColumnsSelector14[0] ;
         AV18ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      }
      GXv_SdtWWPColumnsSelector15[0] = AV18ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV29CliCod, GXv_SdtWWPColumnsSelector15) ;
      AV18ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV50ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "embargabilidadWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV50ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S172( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV22TFEmbargaDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22TFEmbargaDescrip", AV22TFEmbargaDescrip);
      AV23TFEmbargaDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV33TFEmbargaExplicacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFEmbargaExplicacion", AV33TFEmbargaExplicacion);
      AV34TFEmbargaExplicacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue(AV65Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV65Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV20Session.getValue(AV65Pgmname+"GridState"), null, null);
      }
      AV31OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31OrderedBy), 4, 0));
      AV14OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
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
      AV70GXV1 = 1 ;
      while ( AV70GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV70GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGADESCRIP") == 0 )
         {
            AV22TFEmbargaDescrip = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFEmbargaDescrip", AV22TFEmbargaDescrip);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGADESCRIP_SEL") == 0 )
         {
            AV21TFEmbargaDescrip_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21TFEmbargaDescrip_SelsJson", AV21TFEmbargaDescrip_SelsJson);
            AV23TFEmbargaDescrip_Sels.fromJSonString(AV21TFEmbargaDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGAEXPLICACION") == 0 )
         {
            AV33TFEmbargaExplicacion = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFEmbargaExplicacion", AV33TFEmbargaExplicacion);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGAEXPLICACION_SEL") == 0 )
         {
            AV32TFEmbargaExplicacion_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFEmbargaExplicacion_SelsJson", AV32TFEmbargaExplicacion_SelsJson);
            AV34TFEmbargaExplicacion_Sels.fromJSonString(AV32TFEmbargaExplicacion_SelsJson, null);
         }
         AV70GXV1 = (int)(AV70GXV1+1) ;
      }
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV23TFEmbargaDescrip_Sels.size()==0), AV21TFEmbargaDescrip_SelsJson, GXv_char5) ;
      embargabilidadww_impl.this.GXt_char8 = GXv_char5[0] ;
      GXt_char7 = "" ;
      GXv_char4[0] = GXt_char7 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV34TFEmbargaExplicacion_Sels.size()==0), AV32TFEmbargaExplicacion_SelsJson, GXv_char4) ;
      embargabilidadww_impl.this.GXt_char7 = GXv_char4[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char8+"|"+GXt_char7 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV22TFEmbargaDescrip)==0), AV22TFEmbargaDescrip, GXv_char5) ;
      embargabilidadww_impl.this.GXt_char8 = GXv_char5[0] ;
      GXt_char7 = "" ;
      GXv_char4[0] = GXt_char7 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFEmbargaExplicacion)==0), AV33TFEmbargaExplicacion, GXv_char4) ;
      embargabilidadww_impl.this.GXt_char7 = GXv_char4[0] ;
      Ddo_grid_Filteredtext_set = GXt_char8+"|"+GXt_char7 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV20Session.getValue(AV65Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV31OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFEMBARGADESCRIP", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV22TFEmbargaDescrip)==0), (short)(0), AV22TFEmbargaDescrip, "", !(AV23TFEmbargaDescrip_Sels.size()==0), AV23TFEmbargaDescrip_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFEMBARGAEXPLICACION", httpContext.getMessage( "Explicacion", ""), !(GXutil.strcmp("", AV33TFEmbargaExplicacion)==0), (short)(0), AV33TFEmbargaExplicacion, "", !(AV34TFEmbargaExplicacion_Sels.size()==0), AV34TFEmbargaExplicacion_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      if ( ! (GXutil.strcmp("", AV40MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV40MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV65Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV65Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "embargabilidad" );
      AV20Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e17CA2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV42WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean6[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV40MenuOpcCod, GXv_boolean6) ;
         GXv_char5[0] = AV44textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV29CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char5) ;
         embargabilidadww_impl.this.AV44textoNoMostrara = GXv_char5[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV44textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean6[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV40MenuOpcCod, GXv_boolean6) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_CA2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_CA2( true) ;
      }
      else
      {
         wb_table2_12_CA2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_CA2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_CA2e( true) ;
      }
      else
      {
         wb_table1_9_CA2e( false) ;
      }
   }

   public void wb_table2_12_CA2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e21ca1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_embargabilidadWW.htm");
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
         AV48WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV48WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV64Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV48WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV48WelcomeMessage_Foto)==0) ? AV64Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV48WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV48WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_embargabilidadWW.htm");
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
         wb_table3_30_CA2( true) ;
      }
      else
      {
         wb_table3_30_CA2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_CA2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_CA2( true) ;
      }
      else
      {
         wb_table4_35_CA2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_CA2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV42WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_embargabilidadWW.htm");
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
         wb_table5_54_CA2( true) ;
      }
      else
      {
         wb_table5_54_CA2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_CA2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_CA2( true) ;
      }
      else
      {
         wb_table6_63_CA2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_CA2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV26GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV27GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV28GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_CA2e( true) ;
      }
      else
      {
         wb_table2_12_CA2e( false) ;
      }
   }

   public void wb_table6_63_CA2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_embargabilidadWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_embargabilidadWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV24DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV18ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV50ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_embargabilidadWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_embargabilidadWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_embargabilidadWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_97_CA2( true) ;
      }
      else
      {
         wb_table7_97_CA2( false) ;
      }
      return  ;
   }

   public void wb_table7_97_CA2e( boolean wbgen )
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
         wb_table6_63_CA2e( true) ;
      }
      else
      {
         wb_table6_63_CA2e( false) ;
      }
   }

   public void wb_table7_97_CA2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_embargabilidadWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_97_CA2e( true) ;
      }
      else
      {
         wb_table7_97_CA2e( false) ;
      }
   }

   public void wb_table5_54_CA2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_embargabilidadWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_embargabilidadWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_CA2e( true) ;
      }
      else
      {
         wb_table5_54_CA2e( false) ;
      }
   }

   public void wb_table4_35_CA2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_embargabilidadWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_CA2e( true) ;
      }
      else
      {
         wb_table4_35_CA2e( false) ;
      }
   }

   public void wb_table3_30_CA2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_embargabilidadWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_CA2e( true) ;
      }
      else
      {
         wb_table3_30_CA2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV40MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40MenuOpcCod", AV40MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV40MenuOpcCod, ""))));
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
      paCA2( ) ;
      wsCA2( ) ;
      weCA2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019565885", true, true);
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
      httpContext.AddJavascriptSource("embargabilidadww.js", "?2024122019565886", false, true);
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
      edtEmbargaSec_Internalname = "EMBARGASEC_"+sGXsfl_108_idx ;
      edtEmbarPaiCod_Internalname = "EMBARPAICOD_"+sGXsfl_108_idx ;
      edtEmbargaDescrip_Internalname = "EMBARGADESCRIP_"+sGXsfl_108_idx ;
      edtEmbargaExplicacion_Internalname = "EMBARGAEXPLICACION_"+sGXsfl_108_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_idx ;
   }

   public void subsflControlProps_fel_1082( )
   {
      edtEmbargaSec_Internalname = "EMBARGASEC_"+sGXsfl_108_fel_idx ;
      edtEmbarPaiCod_Internalname = "EMBARPAICOD_"+sGXsfl_108_fel_idx ;
      edtEmbargaDescrip_Internalname = "EMBARGADESCRIP_"+sGXsfl_108_fel_idx ;
      edtEmbargaExplicacion_Internalname = "EMBARGAEXPLICACION_"+sGXsfl_108_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_fel_idx ;
   }

   public void sendrow_1082( )
   {
      subsflControlProps_1082( ) ;
      wbCA0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmbargaSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1161EmbargaSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1161EmbargaSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmbargaSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmbarPaiCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1160EmbarPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1160EmbarPaiCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmbarPaiCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtEmbargaDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmbargaDescrip_Internalname,A1162EmbargaDescrip,GXutil.rtrim( localUtil.format( A1162EmbargaDescrip, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmbargaDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmbargaDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtEmbargaExplicacion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmbargaExplicacion_Internalname,A1203EmbargaExplicacion,A1203EmbargaExplicacion,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmbargaExplicacion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtEmbargaExplicacion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"Obs","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV39Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV38VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesCA2( ) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmbargaDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEmbargaExplicacion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Explicacion", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1161EmbargaSec, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1160EmbarPaiCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1162EmbargaDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmbargaDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1203EmbargaExplicacion);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmbargaExplicacion_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV39Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV38VerSVG));
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
      edtEmbargaSec_Internalname = "EMBARGASEC" ;
      edtEmbarPaiCod_Internalname = "EMBARPAICOD" ;
      edtEmbargaDescrip_Internalname = "EMBARGADESCRIP" ;
      edtEmbargaExplicacion_Internalname = "EMBARGAEXPLICACION" ;
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
      edtEmbargaExplicacion_Jsonclick = "" ;
      edtEmbargaDescrip_Jsonclick = "" ;
      edtEmbarPaiCod_Jsonclick = "" ;
      edtEmbargaSec_Jsonclick = "" ;
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
      edtEmbargaExplicacion_Visible = -1 ;
      edtEmbargaDescrip_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Datalistproc = "embargabilidadWWGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "T" ;
      Ddo_grid_Datalisttype = "Dynamic|Dynamic" ;
      Ddo_grid_Includedatalist = "T" ;
      Ddo_grid_Filtertype = "Character|Character" ;
      Ddo_grid_Includefilter = "T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2" ;
      Ddo_grid_Columnids = "2:EmbargaDescrip|3:EmbargaExplicacion" ;
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
      Form.setCaption( httpContext.getMessage( " embargabilidad", "") );
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
      AV42WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV42WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42WelcomeMessage_NoMostrarMas", AV42WelcomeMessage_NoMostrarMas);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV35PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV52ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV18ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV40MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFEmbargaDescrip',fld:'vTFEMBARGADESCRIP',pic:'@!'},{av:'AV23TFEmbargaDescrip_Sels',fld:'vTFEMBARGADESCRIP_SELS',pic:''},{av:'AV33TFEmbargaExplicacion',fld:'vTFEMBARGAEXPLICACION',pic:''},{av:'AV34TFEmbargaExplicacion_Sels',fld:'vTFEMBARGAEXPLICACION_SELS',pic:''},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV42WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV52ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV18ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtEmbargaDescrip_Visible',ctrl:'EMBARGADESCRIP',prop:'Visible'},{av:'edtEmbargaExplicacion_Visible',ctrl:'EMBARGAEXPLICACION',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV26GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV27GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV28GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV50ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13CA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV35PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV52ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV18ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV65Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV40MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFEmbargaDescrip',fld:'vTFEMBARGADESCRIP',pic:'@!'},{av:'AV23TFEmbargaDescrip_Sels',fld:'vTFEMBARGADESCRIP_SELS',pic:''},{av:'AV33TFEmbargaExplicacion',fld:'vTFEMBARGAEXPLICACION',pic:''},{av:'AV34TFEmbargaExplicacion_Sels',fld:'vTFEMBARGAEXPLICACION_SELS',pic:''},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV42WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14CA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV35PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV52ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV18ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV65Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV40MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFEmbargaDescrip',fld:'vTFEMBARGADESCRIP',pic:'@!'},{av:'AV23TFEmbargaDescrip_Sels',fld:'vTFEMBARGADESCRIP_SELS',pic:''},{av:'AV33TFEmbargaExplicacion',fld:'vTFEMBARGAEXPLICACION',pic:''},{av:'AV34TFEmbargaExplicacion_Sels',fld:'vTFEMBARGAEXPLICACION_SELS',pic:''},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV42WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15CA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV35PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV52ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV18ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV65Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV40MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFEmbargaDescrip',fld:'vTFEMBARGADESCRIP',pic:'@!'},{av:'AV23TFEmbargaDescrip_Sels',fld:'vTFEMBARGADESCRIP_SELS',pic:''},{av:'AV33TFEmbargaExplicacion',fld:'vTFEMBARGAEXPLICACION',pic:''},{av:'AV34TFEmbargaExplicacion_Sels',fld:'vTFEMBARGAEXPLICACION_SELS',pic:''},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV42WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV22TFEmbargaDescrip',fld:'vTFEMBARGADESCRIP',pic:'@!'},{av:'AV21TFEmbargaDescrip_SelsJson',fld:'vTFEMBARGADESCRIP_SELSJSON',pic:''},{av:'AV23TFEmbargaDescrip_Sels',fld:'vTFEMBARGADESCRIP_SELS',pic:''},{av:'AV33TFEmbargaExplicacion',fld:'vTFEMBARGAEXPLICACION',pic:''},{av:'AV32TFEmbargaExplicacion_SelsJson',fld:'vTFEMBARGAEXPLICACION_SELSJSON',pic:''},{av:'AV34TFEmbargaExplicacion_Sels',fld:'vTFEMBARGAEXPLICACION_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e20CA2',iparms:[{av:'A1161EmbargaSec',fld:'EMBARGASEC',pic:'ZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV39Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV38VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11CA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV35PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV52ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV18ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV65Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV40MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFEmbargaDescrip',fld:'vTFEMBARGADESCRIP',pic:'@!'},{av:'AV23TFEmbargaDescrip_Sels',fld:'vTFEMBARGADESCRIP_SELS',pic:''},{av:'AV33TFEmbargaExplicacion',fld:'vTFEMBARGAEXPLICACION',pic:''},{av:'AV34TFEmbargaExplicacion_Sels',fld:'vTFEMBARGAEXPLICACION_SELS',pic:''},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV42WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV18ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV52ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtEmbargaDescrip_Visible',ctrl:'EMBARGADESCRIP',prop:'Visible'},{av:'edtEmbargaExplicacion_Visible',ctrl:'EMBARGAEXPLICACION',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV26GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV27GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV28GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV50ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12CA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV35PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV52ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV18ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV65Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV40MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFEmbargaDescrip',fld:'vTFEMBARGADESCRIP',pic:'@!'},{av:'AV23TFEmbargaDescrip_Sels',fld:'vTFEMBARGADESCRIP_SELS',pic:''},{av:'AV33TFEmbargaExplicacion',fld:'vTFEMBARGAEXPLICACION',pic:''},{av:'AV34TFEmbargaExplicacion_Sels',fld:'vTFEMBARGAEXPLICACION_SELS',pic:''},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV42WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV21TFEmbargaDescrip_SelsJson',fld:'vTFEMBARGADESCRIP_SELSJSON',pic:''},{av:'AV32TFEmbargaExplicacion_SelsJson',fld:'vTFEMBARGAEXPLICACION_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV52ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV22TFEmbargaDescrip',fld:'vTFEMBARGADESCRIP',pic:'@!'},{av:'AV23TFEmbargaDescrip_Sels',fld:'vTFEMBARGADESCRIP_SELS',pic:''},{av:'AV33TFEmbargaExplicacion',fld:'vTFEMBARGAEXPLICACION',pic:''},{av:'AV34TFEmbargaExplicacion_Sels',fld:'vTFEMBARGAEXPLICACION_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV21TFEmbargaDescrip_SelsJson',fld:'vTFEMBARGADESCRIP_SELSJSON',pic:''},{av:'AV32TFEmbargaExplicacion_SelsJson',fld:'vTFEMBARGAEXPLICACION_SELSJSON',pic:''},{av:'AV18ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtEmbargaDescrip_Visible',ctrl:'EMBARGADESCRIP',prop:'Visible'},{av:'edtEmbargaExplicacion_Visible',ctrl:'EMBARGAEXPLICACION',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV26GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV27GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV28GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV50ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOEXPORT'","{handler:'e16CA2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17CA2',iparms:[{av:'AV42WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV40MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV29CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e21CA1',iparms:[]");
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
      wcpOAV40MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV40MenuOpcCod = "" ;
      AV18ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV65Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV22TFEmbargaDescrip = "" ;
      AV23TFEmbargaDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33TFEmbargaExplicacion = "" ;
      AV34TFEmbargaExplicacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV24DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV50ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV28GridAppliedFilters = "" ;
      AV21TFEmbargaDescrip_SelsJson = "" ;
      AV32TFEmbargaExplicacion_SelsJson = "" ;
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
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A1162EmbargaDescrip = "" ;
      A1203EmbargaExplicacion = "" ;
      AV39Display = "" ;
      AV38VerSVG = "" ;
      AV67Embargabilidadwwds_2_tfembargadescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Embargabilidadwwds_4_tfembargaexplicacion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV66Embargabilidadwwds_1_tfembargadescrip = "" ;
      lV68Embargabilidadwwds_3_tfembargaexplicacion = "" ;
      AV66Embargabilidadwwds_1_tfembargadescrip = "" ;
      AV68Embargabilidadwwds_3_tfembargaexplicacion = "" ;
      H00CA2_A1203EmbargaExplicacion = new String[] {""} ;
      H00CA2_A1162EmbargaDescrip = new String[] {""} ;
      H00CA2_A1160EmbarPaiCod = new short[1] ;
      H00CA2_A1161EmbargaSec = new short[1] ;
      H00CA3_AGRID_nRecordCount = new long[1] ;
      AV48WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV43MenuBienveImgURL = "" ;
      GXv_char3 = new String[1] ;
      AV45MenuBienveTitulo = "" ;
      AV46MenuBienveTexto = "" ;
      AV64Welcomemessage_foto_GXI = "" ;
      AV61observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int10 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext13 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV20Session = httpContext.getWebSession();
      AV16ColumnsSelectorXML = "" ;
      AV57MenuOpcTitulo = "" ;
      GXv_int11 = new short[1] ;
      AV60filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV51ManageFiltersXml = "" ;
      AV36ExcelFilename = "" ;
      AV37ErrorMessage = "" ;
      AV17UserCustomValue = "" ;
      AV19ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector15 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char8 = "" ;
      GXt_char7 = "" ;
      GXv_char4 = new String[1] ;
      GXv_SdtWWPGridState18 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV44textoNoMostrara = "" ;
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
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.embargabilidadww__default(),
         new Object[] {
             new Object[] {
            H00CA2_A1203EmbargaExplicacion, H00CA2_A1162EmbargaDescrip, H00CA2_A1160EmbarPaiCod, H00CA2_A1161EmbargaSec
            }
            , new Object[] {
            H00CA3_AGRID_nRecordCount
            }
         }
      );
      AV65Pgmname = "embargabilidadWW" ;
      /* GeneXus formulas. */
      AV65Pgmname = "embargabilidadWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV52ManageFiltersExecutionStep ;
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
   private short AV35PaiCod ;
   private short AV31OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1161EmbargaSec ;
   private short A1160EmbarPaiCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int11[] ;
   private short edtavVersvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_108 ;
   private int nGXsfl_108_idx=1 ;
   private int AV29CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Islastpage ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV67Embargabilidadwwds_2_tfembargadescrip_sels_size ;
   private int AV69Embargabilidadwwds_4_tfembargaexplicacion_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int9 ;
   private int GXv_int10[] ;
   private int edtEmbargaDescrip_Visible ;
   private int edtEmbargaExplicacion_Visible ;
   private int edtavVersvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV59filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV25PageToGo ;
   private int edtavDisplay_Visible ;
   private int AV70GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV26GridCurrentPage ;
   private long AV27GridPageCount ;
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
   private String sGXsfl_108_idx="0001" ;
   private String AV65Pgmname ;
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
   private String Ddo_grid_Datalistproc ;
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
   private String edtEmbargaSec_Internalname ;
   private String edtEmbarPaiCod_Internalname ;
   private String edtEmbargaDescrip_Internalname ;
   private String edtEmbargaExplicacion_Internalname ;
   private String AV39Display ;
   private String edtavDisplay_Internalname ;
   private String AV38VerSVG ;
   private String edtavVersvg_Internalname ;
   private String scmdbuf ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String GXv_char3[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String AV61observerPalabra ;
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
   private String GXt_char8 ;
   private String GXt_char7 ;
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
   private String edtEmbargaSec_Jsonclick ;
   private String edtEmbarPaiCod_Jsonclick ;
   private String edtEmbargaDescrip_Jsonclick ;
   private String edtEmbargaExplicacion_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV42WelcomeMessage_NoMostrarMas ;
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
   private boolean bGXsfl_108_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV47MenuBienveVisible ;
   private boolean AV49paisEs ;
   private boolean GXt_boolean12 ;
   private boolean gx_refresh_fired ;
   private boolean GXv_boolean6[] ;
   private boolean AV48WelcomeMessage_Foto_IsBlob ;
   private String AV21TFEmbargaDescrip_SelsJson ;
   private String AV32TFEmbargaExplicacion_SelsJson ;
   private String A1203EmbargaExplicacion ;
   private String AV46MenuBienveTexto ;
   private String AV16ColumnsSelectorXML ;
   private String AV51ManageFiltersXml ;
   private String AV17UserCustomValue ;
   private String AV44textoNoMostrara ;
   private String wcpOAV40MenuOpcCod ;
   private String AV40MenuOpcCod ;
   private String AV22TFEmbargaDescrip ;
   private String AV33TFEmbargaExplicacion ;
   private String AV28GridAppliedFilters ;
   private String A1162EmbargaDescrip ;
   private String lV66Embargabilidadwwds_1_tfembargadescrip ;
   private String lV68Embargabilidadwwds_3_tfembargaexplicacion ;
   private String AV66Embargabilidadwwds_1_tfembargadescrip ;
   private String AV68Embargabilidadwwds_3_tfembargaexplicacion ;
   private String AV43MenuBienveImgURL ;
   private String AV45MenuBienveTitulo ;
   private String AV64Welcomemessage_foto_GXI ;
   private String AV57MenuOpcTitulo ;
   private String AV60filtrosTexto ;
   private String AV36ExcelFilename ;
   private String AV37ErrorMessage ;
   private String AV48WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV67Embargabilidadwwds_2_tfembargadescrip_sels ;
   private GXSimpleCollection<String> AV69Embargabilidadwwds_4_tfembargaexplicacion_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private IDataStoreProvider pr_default ;
   private String[] H00CA2_A1203EmbargaExplicacion ;
   private String[] H00CA2_A1162EmbargaDescrip ;
   private short[] H00CA2_A1160EmbarPaiCod ;
   private short[] H00CA2_A1161EmbargaSec ;
   private long[] H00CA3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV23TFEmbargaDescrip_Sels ;
   private GXSimpleCollection<String> AV34TFEmbargaExplicacion_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV50ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext13[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState18[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV18ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector15[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV24DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class embargabilidadww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00CA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1162EmbargaDescrip ,
                                          GXSimpleCollection<String> AV67Embargabilidadwwds_2_tfembargadescrip_sels ,
                                          String A1203EmbargaExplicacion ,
                                          GXSimpleCollection<String> AV69Embargabilidadwwds_4_tfembargaexplicacion_sels ,
                                          int AV67Embargabilidadwwds_2_tfembargadescrip_sels_size ,
                                          String AV66Embargabilidadwwds_1_tfembargadescrip ,
                                          int AV69Embargabilidadwwds_4_tfembargaexplicacion_sels_size ,
                                          String AV68Embargabilidadwwds_3_tfembargaexplicacion ,
                                          short AV35PaiCod ,
                                          short A1160EmbarPaiCod ,
                                          short AV31OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[6];
      Object[] GXv_Object20 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " EmbargaExplicacion, EmbargaDescrip, EmbarPaiCod, EmbargaSec" ;
      sFromString = " FROM embargabilidad" ;
      sOrderString = "" ;
      if ( ( AV67Embargabilidadwwds_2_tfembargadescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Embargabilidadwwds_1_tfembargadescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int19[0] = (byte)(1) ;
      }
      if ( AV67Embargabilidadwwds_2_tfembargadescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Embargabilidadwwds_2_tfembargadescrip_sels, "EmbargaDescrip IN (", ")")+")");
      }
      if ( ( AV69Embargabilidadwwds_4_tfembargaexplicacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Embargabilidadwwds_3_tfembargaexplicacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaExplicacion) like LOWER(?))");
      }
      else
      {
         GXv_int19[1] = (byte)(1) ;
      }
      if ( AV69Embargabilidadwwds_4_tfembargaexplicacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Embargabilidadwwds_4_tfembargaexplicacion_sels, "EmbargaExplicacion IN (", ")")+")");
      }
      if ( ! (0==AV35PaiCod) )
      {
         addWhere(sWhereString, "(EmbarPaiCod = ?)");
      }
      else
      {
         GXv_int19[2] = (byte)(1) ;
      }
      if ( ( AV31OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY EmbargaDescrip, EmbargaSec" ;
      }
      else if ( ( AV31OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmbargaDescrip DESC, EmbargaSec" ;
      }
      else if ( ( AV31OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY EmbargaExplicacion, EmbargaSec" ;
      }
      else if ( ( AV31OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY EmbargaExplicacion DESC, EmbargaSec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY EmbargaSec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_H00CA3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1162EmbargaDescrip ,
                                          GXSimpleCollection<String> AV67Embargabilidadwwds_2_tfembargadescrip_sels ,
                                          String A1203EmbargaExplicacion ,
                                          GXSimpleCollection<String> AV69Embargabilidadwwds_4_tfembargaexplicacion_sels ,
                                          int AV67Embargabilidadwwds_2_tfembargadescrip_sels_size ,
                                          String AV66Embargabilidadwwds_1_tfembargadescrip ,
                                          int AV69Embargabilidadwwds_4_tfembargaexplicacion_sels_size ,
                                          String AV68Embargabilidadwwds_3_tfembargaexplicacion ,
                                          short AV35PaiCod ,
                                          short A1160EmbarPaiCod ,
                                          short AV31OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[3];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM embargabilidad" ;
      if ( ( AV67Embargabilidadwwds_2_tfembargadescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Embargabilidadwwds_1_tfembargadescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int22[0] = (byte)(1) ;
      }
      if ( AV67Embargabilidadwwds_2_tfembargadescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Embargabilidadwwds_2_tfembargadescrip_sels, "EmbargaDescrip IN (", ")")+")");
      }
      if ( ( AV69Embargabilidadwwds_4_tfembargaexplicacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Embargabilidadwwds_3_tfembargaexplicacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaExplicacion) like LOWER(?))");
      }
      else
      {
         GXv_int22[1] = (byte)(1) ;
      }
      if ( AV69Embargabilidadwwds_4_tfembargaexplicacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Embargabilidadwwds_4_tfembargaexplicacion_sels, "EmbargaExplicacion IN (", ")")+")");
      }
      if ( ! (0==AV35PaiCod) )
      {
         addWhere(sWhereString, "(EmbarPaiCod = ?)");
      }
      else
      {
         GXv_int22[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV31OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 2 ) && ( AV14OrderedDsc ) )
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
                  return conditional_H00CA2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Boolean) dynConstraints[11]).booleanValue() );
            case 1 :
                  return conditional_H00CA3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Boolean) dynConstraints[11]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00CA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00CA3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 200);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 30);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 200);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               return;
      }
   }

}

