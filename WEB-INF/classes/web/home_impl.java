package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class home_impl extends GXDataArea
{
   public home_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public home_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( home_impl.class ));
   }

   public home_impl( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetNextPar( ) ;
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
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetNextPar( ) ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridmenuicons") == 0 )
         {
            gxnrgridmenuicons_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridmenuicons") == 0 )
         {
            gxgrgridmenuicons_refresh_invoke( ) ;
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
      nRC_GXsfl_29 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_29"))) ;
      nGXsfl_29_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_29_idx"))) ;
      sGXsfl_29_idx = httpContext.GetPar( "sGXsfl_29_idx") ;
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
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7SDTNotificationsData);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void gxnrgridmenuicons_newrow_invoke( )
   {
      nRC_GXsfl_68 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_68"))) ;
      nGXsfl_68_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_68_idx"))) ;
      sGXsfl_68_idx = httpContext.GetPar( "sGXsfl_68_idx") ;
      edtavOptionlink_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOptionlink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Visible), 5, 0), !bGXsfl_68_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridmenuicons_newrow( ) ;
      /* End function gxnrGridmenuicons_newrow_invoke */
   }

   public void gxgrgridmenuicons_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      edtavOptionlink_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOptionlink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Visible), 5, 0), !bGXsfl_68_Refreshing);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7SDTNotificationsData);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridmenuicons_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridmenuicons_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.workwithplusmasterpage");
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
      pa382( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start382( ) ;
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
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.home", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTNOTIFICATIONSDATA", getSecureSignedToken( "", AV7SDTNotificationsData));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtnotificationsdata", AV7SDTNotificationsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtnotificationsdata", AV7SDTNotificationsData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtnotificationsdata", getSecureSignedToken( "", AV7SDTNotificationsData));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_29", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_29, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_68", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_68, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vELEMENTS", AV14Elements);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vELEMENTS", AV14Elements);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPARAMETERS", AV15Parameters);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPARAMETERS", AV15Parameters);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vITEMCLICKDATA", AV16ItemClickData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vITEMCLICKDATA", AV16ItemClickData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vITEMDOUBLECLICKDATA", AV17ItemDoubleClickData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vITEMDOUBLECLICKDATA", AV17ItemDoubleClickData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDRAGANDDROPDATA", AV18DragAndDropData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDRAGANDDROPDATA", AV18DragAndDropData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFILTERCHANGEDDATA", AV19FilterChangedData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFILTERCHANGEDDATA", AV19FilterChangedData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vITEMEXPANDDATA", AV20ItemExpandData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vITEMEXPANDDATA", AV20ItemExpandData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vITEMCOLLAPSEDATA", AV21ItemCollapseData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vITEMCOLLAPSEDATA", AV21ItemCollapseData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTNOTIFICATIONSDATA", AV7SDTNotificationsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTNOTIFICATIONSDATA", AV7SDTNotificationsData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTNOTIFICATIONSDATA", getSecureSignedToken( "", AV7SDTNotificationsData));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTLINE_Height", GXutil.rtrim( Utchartline_Height));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTLINE_Type", GXutil.rtrim( Utchartline_Type));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTLINE_Showvalues", GXutil.booltostr( Utchartline_Showvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTLINE_Charttype", GXutil.rtrim( Utchartline_Charttype));
      web.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Class", GXutil.rtrim( Gxuitabspanel_tabs_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs_Historymanagement));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Width", GXutil.rtrim( Dvpanel_tablenotifications_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Autowidth", GXutil.booltostr( Dvpanel_tablenotifications_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Autoheight", GXutil.booltostr( Dvpanel_tablenotifications_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Cls", GXutil.rtrim( Dvpanel_tablenotifications_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Title", GXutil.rtrim( Dvpanel_tablenotifications_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Collapsible", GXutil.booltostr( Dvpanel_tablenotifications_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Collapsed", GXutil.booltostr( Dvpanel_tablenotifications_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Showcollapseicon", GXutil.booltostr( Dvpanel_tablenotifications_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Iconposition", GXutil.rtrim( Dvpanel_tablenotifications_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Autoscroll", GXutil.booltostr( Dvpanel_tablenotifications_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTBARS_Height", GXutil.rtrim( Utchartbars_Height));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTBARS_Type", GXutil.rtrim( Utchartbars_Type));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTBARS_Charttype", GXutil.rtrim( Utchartbars_Charttype));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTBARS_Xaxistitle", GXutil.rtrim( Utchartbars_Xaxistitle));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION1_Width", GXutil.rtrim( Dvpanel_tablebottomsection1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION1_Autowidth", GXutil.booltostr( Dvpanel_tablebottomsection1_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION1_Autoheight", GXutil.booltostr( Dvpanel_tablebottomsection1_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION1_Cls", GXutil.rtrim( Dvpanel_tablebottomsection1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION1_Title", GXutil.rtrim( Dvpanel_tablebottomsection1_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION1_Collapsible", GXutil.booltostr( Dvpanel_tablebottomsection1_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION1_Collapsed", GXutil.booltostr( Dvpanel_tablebottomsection1_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION1_Showcollapseicon", GXutil.booltostr( Dvpanel_tablebottomsection1_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION1_Iconposition", GXutil.rtrim( Dvpanel_tablebottomsection1_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION1_Autoscroll", GXutil.booltostr( Dvpanel_tablebottomsection1_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Height", GXutil.rtrim( Utchartdoughnut_Height));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Type", GXutil.rtrim( Utchartdoughnut_Type));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Showvalues", GXutil.booltostr( Utchartdoughnut_Showvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Charttype", GXutil.rtrim( Utchartdoughnut_Charttype));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION3_Width", GXutil.rtrim( Dvpanel_tablebottomsection3_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION3_Autowidth", GXutil.booltostr( Dvpanel_tablebottomsection3_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION3_Autoheight", GXutil.booltostr( Dvpanel_tablebottomsection3_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION3_Cls", GXutil.rtrim( Dvpanel_tablebottomsection3_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION3_Title", GXutil.rtrim( Dvpanel_tablebottomsection3_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION3_Collapsible", GXutil.booltostr( Dvpanel_tablebottomsection3_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION3_Collapsed", GXutil.booltostr( Dvpanel_tablebottomsection3_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION3_Showcollapseicon", GXutil.booltostr( Dvpanel_tablebottomsection3_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION3_Iconposition", GXutil.rtrim( Dvpanel_tablebottomsection3_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION3_Autoscroll", GXutil.booltostr( Dvpanel_tablebottomsection3_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SECONDPANELRIGHTZONE_Width", GXutil.rtrim( Dvpanel_secondpanelrightzone_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SECONDPANELRIGHTZONE_Autowidth", GXutil.booltostr( Dvpanel_secondpanelrightzone_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SECONDPANELRIGHTZONE_Autoheight", GXutil.booltostr( Dvpanel_secondpanelrightzone_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SECONDPANELRIGHTZONE_Cls", GXutil.rtrim( Dvpanel_secondpanelrightzone_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SECONDPANELRIGHTZONE_Title", GXutil.rtrim( Dvpanel_secondpanelrightzone_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SECONDPANELRIGHTZONE_Collapsible", GXutil.booltostr( Dvpanel_secondpanelrightzone_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SECONDPANELRIGHTZONE_Collapsed", GXutil.booltostr( Dvpanel_secondpanelrightzone_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SECONDPANELRIGHTZONE_Showcollapseicon", GXutil.booltostr( Dvpanel_secondpanelrightzone_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SECONDPANELRIGHTZONE_Iconposition", GXutil.rtrim( Dvpanel_secondpanelrightzone_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SECONDPANELRIGHTZONE_Autoscroll", GXutil.booltostr( Dvpanel_secondpanelrightzone_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Height", GXutil.rtrim( Utchartsmoothline_Height));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Type", GXutil.rtrim( Utchartsmoothline_Type));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Charttype", GXutil.rtrim( Utchartsmoothline_Charttype));
      web.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Xaxistitle", GXutil.rtrim( Utchartsmoothline_Xaxistitle));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION2_Width", GXutil.rtrim( Dvpanel_tablebottomsection2_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION2_Autowidth", GXutil.booltostr( Dvpanel_tablebottomsection2_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION2_Autoheight", GXutil.booltostr( Dvpanel_tablebottomsection2_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION2_Cls", GXutil.rtrim( Dvpanel_tablebottomsection2_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION2_Title", GXutil.rtrim( Dvpanel_tablebottomsection2_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION2_Collapsible", GXutil.booltostr( Dvpanel_tablebottomsection2_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION2_Collapsed", GXutil.booltostr( Dvpanel_tablebottomsection2_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION2_Showcollapseicon", GXutil.booltostr( Dvpanel_tablebottomsection2_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION2_Iconposition", GXutil.rtrim( Dvpanel_tablebottomsection2_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEBOTTOMSECTION2_Autoscroll", GXutil.booltostr( Dvpanel_tablebottomsection2_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDMENUICONS_Class", GXutil.rtrim( subGridmenuicons_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDMENUICONS_Flexwrap", GXutil.rtrim( subGridmenuicons_Flexwrap));
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
      if ( ! ( WebComp_Wc == null ) )
      {
         WebComp_Wc.componentjscripts();
      }
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
         we382( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt382( ) ;
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
      return formatLink("web.home", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Home" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_HomeTitle", "") ;
   }

   public void wb380( )
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
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DashboardWithCalendarLeftContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableleftcontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Static images/pictures */
         ClassString = "ImageDashboardBanner" + " " + ((GXutil.strcmp(imgHomemodulesbackground3_gximage, "")==0) ? "GX_Image_HomeBannerImageSample_Class" : "GX_Image_"+imgHomemodulesbackground3_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "bacb295f-8081-4718-9910-31ffbda185ce", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgHomemodulesbackground3_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Home.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tablenotifications.setProperty("Width", Dvpanel_tablenotifications_Width);
         ucDvpanel_tablenotifications.setProperty("AutoWidth", Dvpanel_tablenotifications_Autowidth);
         ucDvpanel_tablenotifications.setProperty("AutoHeight", Dvpanel_tablenotifications_Autoheight);
         ucDvpanel_tablenotifications.setProperty("Cls", Dvpanel_tablenotifications_Cls);
         ucDvpanel_tablenotifications.setProperty("Title", Dvpanel_tablenotifications_Title);
         ucDvpanel_tablenotifications.setProperty("Collapsible", Dvpanel_tablenotifications_Collapsible);
         ucDvpanel_tablenotifications.setProperty("Collapsed", Dvpanel_tablenotifications_Collapsed);
         ucDvpanel_tablenotifications.setProperty("ShowCollapseIcon", Dvpanel_tablenotifications_Showcollapseicon);
         ucDvpanel_tablenotifications.setProperty("IconPosition", Dvpanel_tablenotifications_Iconposition);
         ucDvpanel_tablenotifications.setProperty("AutoScroll", Dvpanel_tablenotifications_Autoscroll);
         ucDvpanel_tablenotifications.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablenotifications_Internalname, "DVPANEL_TABLENOTIFICATIONSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLENOTIFICATIONSContainer"+"TableNotifications"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablenotifications_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGxuitabspanel_tabs.setProperty("PageCount", Gxuitabspanel_tabs_Pagecount);
         ucGxuitabspanel_tabs.setProperty("Class", Gxuitabspanel_tabs_Class);
         ucGxuitabspanel_tabs.setProperty("HistoryManagement", Gxuitabspanel_tabs_Historymanagement);
         ucGxuitabspanel_tabs.render(context, "tab", Gxuitabspanel_tabs_Internalname, "GXUITABSPANEL_TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblFirsttab_title_Internalname, httpContext.getMessage( "Notificaciones", ""), "", "", lblFirsttab_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_Home.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "FirstTab") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabletab1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 NotificationSubtitleCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblNotificationssubtitle_Internalname, lblNotificationssubtitle_Caption, "", "", lblNotificationssubtitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_Home.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 GridNoBorderNoHeader CellMarginTop HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol29( ) ;
      }
      if ( wbEnd == 29 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_29 = (int)(nGXsfl_29_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
            AV34GXV1 = nGXsfl_29_idx ;
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblAdditionalinformation_title_Internalname, httpContext.getMessage( "New Issues", ""), "", "", lblAdditionalinformation_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_Home.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "AdditionalInformation") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabletab2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUtchartline.setProperty("Elements", AV14Elements);
         ucUtchartline.setProperty("Parameters", AV15Parameters);
         ucUtchartline.setProperty("Height", Utchartline_Height);
         ucUtchartline.setProperty("Type", Utchartline_Type);
         ucUtchartline.setProperty("Title", Utchartline_Title);
         ucUtchartline.setProperty("ShowValues", Utchartline_Showvalues);
         ucUtchartline.setProperty("ChartType", Utchartline_Charttype);
         ucUtchartline.setProperty("ItemClickData", AV16ItemClickData);
         ucUtchartline.setProperty("ItemDoubleClickData", AV17ItemDoubleClickData);
         ucUtchartline.setProperty("DragAndDropData", AV18DragAndDropData);
         ucUtchartline.setProperty("FilterChangedData", AV19FilterChangedData);
         ucUtchartline.setProperty("ItemExpandData", AV20ItemExpandData);
         ucUtchartline.setProperty("ItemCollapseData", AV21ItemCollapseData);
         ucUtchartline.render(context, "queryviewer", Utchartline_Internalname, "UTCHARTLINEContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tablebottomsection1.setProperty("Width", Dvpanel_tablebottomsection1_Width);
         ucDvpanel_tablebottomsection1.setProperty("AutoWidth", Dvpanel_tablebottomsection1_Autowidth);
         ucDvpanel_tablebottomsection1.setProperty("AutoHeight", Dvpanel_tablebottomsection1_Autoheight);
         ucDvpanel_tablebottomsection1.setProperty("Cls", Dvpanel_tablebottomsection1_Cls);
         ucDvpanel_tablebottomsection1.setProperty("Title", Dvpanel_tablebottomsection1_Title);
         ucDvpanel_tablebottomsection1.setProperty("Collapsible", Dvpanel_tablebottomsection1_Collapsible);
         ucDvpanel_tablebottomsection1.setProperty("Collapsed", Dvpanel_tablebottomsection1_Collapsed);
         ucDvpanel_tablebottomsection1.setProperty("ShowCollapseIcon", Dvpanel_tablebottomsection1_Showcollapseicon);
         ucDvpanel_tablebottomsection1.setProperty("IconPosition", Dvpanel_tablebottomsection1_Iconposition);
         ucDvpanel_tablebottomsection1.setProperty("AutoScroll", Dvpanel_tablebottomsection1_Autoscroll);
         ucDvpanel_tablebottomsection1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablebottomsection1_Internalname, "DVPANEL_TABLEBOTTOMSECTION1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEBOTTOMSECTION1Container"+"TableBottomSection1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablebottomsection1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUtchartbars.setProperty("Elements", AV14Elements);
         ucUtchartbars.setProperty("Parameters", AV15Parameters);
         ucUtchartbars.setProperty("Height", Utchartbars_Height);
         ucUtchartbars.setProperty("Type", Utchartbars_Type);
         ucUtchartbars.setProperty("Title", Utchartbars_Title);
         ucUtchartbars.setProperty("ChartType", Utchartbars_Charttype);
         ucUtchartbars.setProperty("XAxisTitle", Utchartbars_Xaxistitle);
         ucUtchartbars.setProperty("ItemClickData", AV16ItemClickData);
         ucUtchartbars.setProperty("ItemDoubleClickData", AV17ItemDoubleClickData);
         ucUtchartbars.setProperty("DragAndDropData", AV18DragAndDropData);
         ucUtchartbars.setProperty("FilterChangedData", AV19FilterChangedData);
         ucUtchartbars.setProperty("ItemExpandData", AV20ItemExpandData);
         ucUtchartbars.setProperty("ItemCollapseData", AV21ItemCollapseData);
         ucUtchartbars.render(context, "queryviewer", Utchartbars_Internalname, "UTCHARTBARSContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tablebottomsection3.setProperty("Width", Dvpanel_tablebottomsection3_Width);
         ucDvpanel_tablebottomsection3.setProperty("AutoWidth", Dvpanel_tablebottomsection3_Autowidth);
         ucDvpanel_tablebottomsection3.setProperty("AutoHeight", Dvpanel_tablebottomsection3_Autoheight);
         ucDvpanel_tablebottomsection3.setProperty("Cls", Dvpanel_tablebottomsection3_Cls);
         ucDvpanel_tablebottomsection3.setProperty("Title", Dvpanel_tablebottomsection3_Title);
         ucDvpanel_tablebottomsection3.setProperty("Collapsible", Dvpanel_tablebottomsection3_Collapsible);
         ucDvpanel_tablebottomsection3.setProperty("Collapsed", Dvpanel_tablebottomsection3_Collapsed);
         ucDvpanel_tablebottomsection3.setProperty("ShowCollapseIcon", Dvpanel_tablebottomsection3_Showcollapseicon);
         ucDvpanel_tablebottomsection3.setProperty("IconPosition", Dvpanel_tablebottomsection3_Iconposition);
         ucDvpanel_tablebottomsection3.setProperty("AutoScroll", Dvpanel_tablebottomsection3_Autoscroll);
         ucDvpanel_tablebottomsection3.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablebottomsection3_Internalname, "DVPANEL_TABLEBOTTOMSECTION3Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEBOTTOMSECTION3Container"+"TableBottomSection3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablebottomsection3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUtchartdoughnut.setProperty("Elements", AV14Elements);
         ucUtchartdoughnut.setProperty("Parameters", AV15Parameters);
         ucUtchartdoughnut.setProperty("Height", Utchartdoughnut_Height);
         ucUtchartdoughnut.setProperty("Type", Utchartdoughnut_Type);
         ucUtchartdoughnut.setProperty("Title", Utchartdoughnut_Title);
         ucUtchartdoughnut.setProperty("ShowValues", Utchartdoughnut_Showvalues);
         ucUtchartdoughnut.setProperty("ChartType", Utchartdoughnut_Charttype);
         ucUtchartdoughnut.setProperty("ItemClickData", AV16ItemClickData);
         ucUtchartdoughnut.setProperty("ItemDoubleClickData", AV17ItemDoubleClickData);
         ucUtchartdoughnut.setProperty("DragAndDropData", AV18DragAndDropData);
         ucUtchartdoughnut.setProperty("FilterChangedData", AV19FilterChangedData);
         ucUtchartdoughnut.setProperty("ItemExpandData", AV20ItemExpandData);
         ucUtchartdoughnut.setProperty("ItemCollapseData", AV21ItemCollapseData);
         ucUtchartdoughnut.render(context, "queryviewer", Utchartdoughnut_Internalname, "UTCHARTDOUGHNUTContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DashboardWithCalendarRightContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablerightcontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTopInExtraSmall", "Center", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavDate_Internalname, httpContext.getMessage( "Date", ""), "col-sm-3 AttributeDateLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'" + sGXsfl_29_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDate_Internalname, localUtil.format(AV31Date, "99/99/99"), localUtil.format( AV31Date, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDate_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavDate_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateFlat", "right", false, "", "HLP_Home.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_secondpanelrightzone.setProperty("Width", Dvpanel_secondpanelrightzone_Width);
         ucDvpanel_secondpanelrightzone.setProperty("AutoWidth", Dvpanel_secondpanelrightzone_Autowidth);
         ucDvpanel_secondpanelrightzone.setProperty("AutoHeight", Dvpanel_secondpanelrightzone_Autoheight);
         ucDvpanel_secondpanelrightzone.setProperty("Cls", Dvpanel_secondpanelrightzone_Cls);
         ucDvpanel_secondpanelrightzone.setProperty("Title", Dvpanel_secondpanelrightzone_Title);
         ucDvpanel_secondpanelrightzone.setProperty("Collapsible", Dvpanel_secondpanelrightzone_Collapsible);
         ucDvpanel_secondpanelrightzone.setProperty("Collapsed", Dvpanel_secondpanelrightzone_Collapsed);
         ucDvpanel_secondpanelrightzone.setProperty("ShowCollapseIcon", Dvpanel_secondpanelrightzone_Showcollapseicon);
         ucDvpanel_secondpanelrightzone.setProperty("IconPosition", Dvpanel_secondpanelrightzone_Iconposition);
         ucDvpanel_secondpanelrightzone.setProperty("AutoScroll", Dvpanel_secondpanelrightzone_Autoscroll);
         ucDvpanel_secondpanelrightzone.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_secondpanelrightzone_Internalname, "DVPANEL_SECONDPANELRIGHTZONEContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_SECONDPANELRIGHTZONEContainer"+"SecondPanelRightZone"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divSecondpanelrightzone_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridmenuiconsContainer.SetIsFreestyle(true);
         GridmenuiconsContainer.SetWrapped(nGXWrapped);
         startgridcontrol68( ) ;
      }
      if ( wbEnd == 68 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_68 = (int)(nGXsfl_68_idx-1) ;
         if ( GridmenuiconsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV38GXV5 = nGXsfl_68_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridmenuiconsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridmenuicons", GridmenuiconsContainer, subGridmenuicons_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridmenuiconsContainerData", GridmenuiconsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridmenuiconsContainerData"+"V", GridmenuiconsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridmenuiconsContainerData"+"V"+"\" value='"+GridmenuiconsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tablebottomsection2.setProperty("Width", Dvpanel_tablebottomsection2_Width);
         ucDvpanel_tablebottomsection2.setProperty("AutoWidth", Dvpanel_tablebottomsection2_Autowidth);
         ucDvpanel_tablebottomsection2.setProperty("AutoHeight", Dvpanel_tablebottomsection2_Autoheight);
         ucDvpanel_tablebottomsection2.setProperty("Cls", Dvpanel_tablebottomsection2_Cls);
         ucDvpanel_tablebottomsection2.setProperty("Title", Dvpanel_tablebottomsection2_Title);
         ucDvpanel_tablebottomsection2.setProperty("Collapsible", Dvpanel_tablebottomsection2_Collapsible);
         ucDvpanel_tablebottomsection2.setProperty("Collapsed", Dvpanel_tablebottomsection2_Collapsed);
         ucDvpanel_tablebottomsection2.setProperty("ShowCollapseIcon", Dvpanel_tablebottomsection2_Showcollapseicon);
         ucDvpanel_tablebottomsection2.setProperty("IconPosition", Dvpanel_tablebottomsection2_Iconposition);
         ucDvpanel_tablebottomsection2.setProperty("AutoScroll", Dvpanel_tablebottomsection2_Autoscroll);
         ucDvpanel_tablebottomsection2.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablebottomsection2_Internalname, "DVPANEL_TABLEBOTTOMSECTION2Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEBOTTOMSECTION2Container"+"TableBottomSection2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablebottomsection2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUtchartsmoothline.setProperty("Elements", AV14Elements);
         ucUtchartsmoothline.setProperty("Parameters", AV15Parameters);
         ucUtchartsmoothline.setProperty("Height", Utchartsmoothline_Height);
         ucUtchartsmoothline.setProperty("Type", Utchartsmoothline_Type);
         ucUtchartsmoothline.setProperty("Title", Utchartsmoothline_Title);
         ucUtchartsmoothline.setProperty("ChartType", Utchartsmoothline_Charttype);
         ucUtchartsmoothline.setProperty("XAxisTitle", Utchartsmoothline_Xaxistitle);
         ucUtchartsmoothline.setProperty("ItemClickData", AV16ItemClickData);
         ucUtchartsmoothline.setProperty("ItemDoubleClickData", AV17ItemDoubleClickData);
         ucUtchartsmoothline.setProperty("DragAndDropData", AV18DragAndDropData);
         ucUtchartsmoothline.setProperty("FilterChangedData", AV19FilterChangedData);
         ucUtchartsmoothline.setProperty("ItemExpandData", AV20ItemExpandData);
         ucUtchartsmoothline.setProperty("ItemCollapseData", AV21ItemCollapseData);
         ucUtchartsmoothline.render(context, "queryviewer", Utchartsmoothline_Internalname, "UTCHARTSMOOTHLINEContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 29 )
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
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
               AV34GXV1 = nGXsfl_29_idx ;
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
      if ( wbEnd == 68 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridmenuiconsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV38GXV5 = nGXsfl_68_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridmenuiconsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridmenuicons", GridmenuiconsContainer, subGridmenuicons_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridmenuiconsContainerData", GridmenuiconsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridmenuiconsContainerData"+"V", GridmenuiconsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridmenuiconsContainerData"+"V"+"\" value='"+GridmenuiconsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start382( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_HomeTitle", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup380( ) ;
   }

   public void ws382( )
   {
      start382( ) ;
      evt382( ) ;
   }

   public void evt382( )
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
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_29_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_292( ) ;
                           AV34GXV1 = (int)(nGXsfl_29_idx+GRID_nFirstRecordOnPage) ;
                           if ( ( AV7SDTNotificationsData.size() >= AV34GXV1 ) && ( AV34GXV1 > 0 ) )
                           {
                              AV7SDTNotificationsData.currentItem( ((web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV34GXV1)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e11382 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e12382 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e13382 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 18), "GRIDMENUICONS.LOAD") == 0 )
                        {
                           nGXsfl_68_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_68_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_683( ) ;
                           AV28OptionLink = httpContext.cgiGet( edtavOptionlink_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavOptionlink_Internalname, AV28OptionLink);
                           AV29OptionTitle = httpContext.cgiGet( edtavOptiontitle_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavOptiontitle_Internalname, AV29OptionTitle);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDMENUICONS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e14383 ();
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 87 )
                     {
                        sEvtType = GXutil.left( sEvt, 4) ;
                        sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                        sCmpCtrl = "W0087" + sEvtType ;
                        OldWc = httpContext.cgiGet( sCmpCtrl) ;
                        if ( ( GXutil.len( OldWc) == 0 ) || ( GXutil.strcmp(OldWc, WebComp_GX_Process_Component) != 0 ) )
                        {
                           WebComp_GX_Process = WebUtils.getWebComponent(getClass(), "web." + OldWc + "_impl", remoteHandle, context);
                           WebComp_GX_Process_Component = OldWc ;
                        }
                        if ( GXutil.len( WebComp_GX_Process_Component) != 0 )
                        {
                           WebComp_GX_Process.componentprocess("W0087", sEvtType, sEvt);
                        }
                        nGXsfl_68_webc_idx = (int)(GXutil.lval( sEvtType)) ;
                        WebCompHandler = "Wc" ;
                        WebComp_GX_Process_Component = OldWc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we382( )
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

   public void pa382( )
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
            GX_FocusControl = edtavDate_Internalname ;
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
      subsflControlProps_292( ) ;
      while ( nGXsfl_29_idx <= nRC_GXsfl_29 )
      {
         sendrow_292( ) ;
         nGXsfl_29_idx = ((subGrid_Islastpage==1)&&(nGXsfl_29_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_29_idx+1) ;
         sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_292( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxnrgridmenuicons_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_683( ) ;
      while ( nGXsfl_68_idx <= nRC_GXsfl_68 )
      {
         sendrow_683( ) ;
         nGXsfl_68_idx = ((subGridmenuicons_Islastpage==1)&&(nGXsfl_68_idx+1>subgridmenuicons_fnc_recordsperpage( )) ? 1 : nGXsfl_68_idx+1) ;
         sGXsfl_68_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_683( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridmenuiconsContainer)) ;
      /* End function gxnrGridmenuicons_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 GXBaseCollection<web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> AV7SDTNotificationsData )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e13382 ();
      GRID_nCurrentRecord = 0 ;
      rf382( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void gxgrgridmenuicons_refresh( int subGrid_Rows ,
                                          GXBaseCollection<web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> AV7SDTNotificationsData )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e13382 ();
      GRIDMENUICONS_nCurrentRecord = 0 ;
      rf383( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridmenuicons_refresh */
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf382( ) ;
      rf383( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavSdtnotificationsdata__notificationiconclass_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationiconclass_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationiconclass_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationtitle_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationdatetime_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationdatetime_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavOptiontitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOptiontitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptiontitle_Enabled), 5, 0), !bGXsfl_68_Refreshing);
   }

   public void rf382( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(29) ;
      /* Execute user event: Refresh */
      e13382 ();
      nGXsfl_29_idx = 1 ;
      sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_292( ) ;
      bGXsfl_29_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_GX_Process_Component) != 0 )
            {
               WebComp_GX_Process.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            WebComp_Wc.componentstart();
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_292( ) ;
         e12382 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_29_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e12382 ();
         }
         wbEnd = (short)(29) ;
         wb380( ) ;
      }
      bGXsfl_29_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes382( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTNOTIFICATIONSDATA", AV7SDTNotificationsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTNOTIFICATIONSDATA", AV7SDTNotificationsData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTNOTIFICATIONSDATA", getSecureSignedToken( "", AV7SDTNotificationsData));
   }

   public void rf383( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridmenuiconsContainer.ClearRows();
      }
      wbStart = (short)(68) ;
      nGXsfl_68_idx = 1 ;
      sGXsfl_68_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_683( ) ;
      bGXsfl_68_Refreshing = true ;
      GridmenuiconsContainer.AddObjectProperty("GridName", "Gridmenuicons");
      GridmenuiconsContainer.AddObjectProperty("CmpContext", "");
      GridmenuiconsContainer.AddObjectProperty("InMasterPage", "false");
      GridmenuiconsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridmenuiconsContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridmenuiconsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridmenuiconsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridmenuiconsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridmenuicons_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridmenuiconsContainer.setPageSize( subgridmenuicons_fnc_recordsperpage( ) );
      if ( subGrid_Islastpage != 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordcount( )-subgrid_fnc_recordsperpage( )) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_683( ) ;
         e14383 ();
         wbEnd = (short)(68) ;
         wb380( ) ;
      }
      bGXsfl_68_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes383( )
   {
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
      return AV7SDTNotificationsData.size() ;
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
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridmenuicons_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridmenuicons_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridmenuicons_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridmenuicons_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavSdtnotificationsdata__notificationiconclass_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationiconclass_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationiconclass_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationtitle_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationdatetime_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationdatetime_Enabled), 5, 0), !bGXsfl_29_Refreshing);
      edtavOptiontitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOptiontitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptiontitle_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup380( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11382 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtnotificationsdata"), AV7SDTNotificationsData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vELEMENTS"), AV14Elements);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPARAMETERS"), AV15Parameters);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vITEMCLICKDATA"), AV16ItemClickData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vITEMDOUBLECLICKDATA"), AV17ItemDoubleClickData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDRAGANDDROPDATA"), AV18DragAndDropData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFILTERCHANGEDDATA"), AV19FilterChangedData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vITEMEXPANDDATA"), AV20ItemExpandData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vITEMCOLLAPSEDATA"), AV21ItemCollapseData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTNOTIFICATIONSDATA"), AV7SDTNotificationsData);
         /* Read saved values. */
         nRC_GXsfl_29 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_29"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_68 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_68"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Utchartline_Height = httpContext.cgiGet( "UTCHARTLINE_Height") ;
         Utchartline_Type = httpContext.cgiGet( "UTCHARTLINE_Type") ;
         Utchartline_Showvalues = GXutil.strtobool( httpContext.cgiGet( "UTCHARTLINE_Showvalues")) ;
         Utchartline_Charttype = httpContext.cgiGet( "UTCHARTLINE_Charttype") ;
         Gxuitabspanel_tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gxuitabspanel_tabs_Class = httpContext.cgiGet( "GXUITABSPANEL_TABS_Class") ;
         Gxuitabspanel_tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS_Historymanagement")) ;
         Dvpanel_tablenotifications_Width = httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Width") ;
         Dvpanel_tablenotifications_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Autowidth")) ;
         Dvpanel_tablenotifications_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Autoheight")) ;
         Dvpanel_tablenotifications_Cls = httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Cls") ;
         Dvpanel_tablenotifications_Title = httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Title") ;
         Dvpanel_tablenotifications_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Collapsible")) ;
         Dvpanel_tablenotifications_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Collapsed")) ;
         Dvpanel_tablenotifications_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Showcollapseicon")) ;
         Dvpanel_tablenotifications_Iconposition = httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Iconposition") ;
         Dvpanel_tablenotifications_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Autoscroll")) ;
         Utchartbars_Height = httpContext.cgiGet( "UTCHARTBARS_Height") ;
         Utchartbars_Type = httpContext.cgiGet( "UTCHARTBARS_Type") ;
         Utchartbars_Charttype = httpContext.cgiGet( "UTCHARTBARS_Charttype") ;
         Utchartbars_Xaxistitle = httpContext.cgiGet( "UTCHARTBARS_Xaxistitle") ;
         Dvpanel_tablebottomsection1_Width = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION1_Width") ;
         Dvpanel_tablebottomsection1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION1_Autowidth")) ;
         Dvpanel_tablebottomsection1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION1_Autoheight")) ;
         Dvpanel_tablebottomsection1_Cls = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION1_Cls") ;
         Dvpanel_tablebottomsection1_Title = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION1_Title") ;
         Dvpanel_tablebottomsection1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION1_Collapsible")) ;
         Dvpanel_tablebottomsection1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION1_Collapsed")) ;
         Dvpanel_tablebottomsection1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION1_Showcollapseicon")) ;
         Dvpanel_tablebottomsection1_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION1_Iconposition") ;
         Dvpanel_tablebottomsection1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION1_Autoscroll")) ;
         Utchartdoughnut_Height = httpContext.cgiGet( "UTCHARTDOUGHNUT_Height") ;
         Utchartdoughnut_Type = httpContext.cgiGet( "UTCHARTDOUGHNUT_Type") ;
         Utchartdoughnut_Showvalues = GXutil.strtobool( httpContext.cgiGet( "UTCHARTDOUGHNUT_Showvalues")) ;
         Utchartdoughnut_Charttype = httpContext.cgiGet( "UTCHARTDOUGHNUT_Charttype") ;
         Dvpanel_tablebottomsection3_Width = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION3_Width") ;
         Dvpanel_tablebottomsection3_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION3_Autowidth")) ;
         Dvpanel_tablebottomsection3_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION3_Autoheight")) ;
         Dvpanel_tablebottomsection3_Cls = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION3_Cls") ;
         Dvpanel_tablebottomsection3_Title = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION3_Title") ;
         Dvpanel_tablebottomsection3_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION3_Collapsible")) ;
         Dvpanel_tablebottomsection3_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION3_Collapsed")) ;
         Dvpanel_tablebottomsection3_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION3_Showcollapseicon")) ;
         Dvpanel_tablebottomsection3_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION3_Iconposition") ;
         Dvpanel_tablebottomsection3_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION3_Autoscroll")) ;
         Dvpanel_secondpanelrightzone_Width = httpContext.cgiGet( "DVPANEL_SECONDPANELRIGHTZONE_Width") ;
         Dvpanel_secondpanelrightzone_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SECONDPANELRIGHTZONE_Autowidth")) ;
         Dvpanel_secondpanelrightzone_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SECONDPANELRIGHTZONE_Autoheight")) ;
         Dvpanel_secondpanelrightzone_Cls = httpContext.cgiGet( "DVPANEL_SECONDPANELRIGHTZONE_Cls") ;
         Dvpanel_secondpanelrightzone_Title = httpContext.cgiGet( "DVPANEL_SECONDPANELRIGHTZONE_Title") ;
         Dvpanel_secondpanelrightzone_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SECONDPANELRIGHTZONE_Collapsible")) ;
         Dvpanel_secondpanelrightzone_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SECONDPANELRIGHTZONE_Collapsed")) ;
         Dvpanel_secondpanelrightzone_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SECONDPANELRIGHTZONE_Showcollapseicon")) ;
         Dvpanel_secondpanelrightzone_Iconposition = httpContext.cgiGet( "DVPANEL_SECONDPANELRIGHTZONE_Iconposition") ;
         Dvpanel_secondpanelrightzone_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SECONDPANELRIGHTZONE_Autoscroll")) ;
         Utchartsmoothline_Height = httpContext.cgiGet( "UTCHARTSMOOTHLINE_Height") ;
         Utchartsmoothline_Type = httpContext.cgiGet( "UTCHARTSMOOTHLINE_Type") ;
         Utchartsmoothline_Charttype = httpContext.cgiGet( "UTCHARTSMOOTHLINE_Charttype") ;
         Utchartsmoothline_Xaxistitle = httpContext.cgiGet( "UTCHARTSMOOTHLINE_Xaxistitle") ;
         Dvpanel_tablebottomsection2_Width = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION2_Width") ;
         Dvpanel_tablebottomsection2_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION2_Autowidth")) ;
         Dvpanel_tablebottomsection2_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION2_Autoheight")) ;
         Dvpanel_tablebottomsection2_Cls = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION2_Cls") ;
         Dvpanel_tablebottomsection2_Title = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION2_Title") ;
         Dvpanel_tablebottomsection2_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION2_Collapsible")) ;
         Dvpanel_tablebottomsection2_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION2_Collapsed")) ;
         Dvpanel_tablebottomsection2_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION2_Showcollapseicon")) ;
         Dvpanel_tablebottomsection2_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION2_Iconposition") ;
         Dvpanel_tablebottomsection2_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEBOTTOMSECTION2_Autoscroll")) ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         subGridmenuicons_Class = httpContext.cgiGet( "GRIDMENUICONS_Class") ;
         subGridmenuicons_Flexwrap = httpContext.cgiGet( "GRIDMENUICONS_Flexwrap") ;
         nRC_GXsfl_29 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_29"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_29_fel_idx = 0 ;
         while ( nGXsfl_29_fel_idx < nRC_GXsfl_29 )
         {
            nGXsfl_29_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_29_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_29_fel_idx+1) ;
            sGXsfl_29_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_292( ) ;
            AV34GXV1 = (int)(nGXsfl_29_fel_idx+GRID_nFirstRecordOnPage) ;
            if ( ( AV7SDTNotificationsData.size() >= AV34GXV1 ) && ( AV34GXV1 > 0 ) )
            {
               AV7SDTNotificationsData.currentItem( ((web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV34GXV1)) );
            }
         }
         if ( nGXsfl_29_fel_idx == 0 )
         {
            nGXsfl_29_idx = 1 ;
            sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_292( ) ;
         }
         nGXsfl_29_fel_idx = 1 ;
         /* Read variables values. */
         if ( localUtil.vcdate( httpContext.cgiGet( edtavDate_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vDATE");
            GX_FocusControl = edtavDate_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV31Date = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31Date", localUtil.format(AV31Date, "99/99/99"));
         }
         else
         {
            AV31Date = localUtil.ctod( httpContext.cgiGet( edtavDate_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31Date", localUtil.format(AV31Date, "99/99/99"));
         }
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
      e11382 ();
      if (returnInSub) return;
   }

   public void e11382( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV8Card1_Value = (short)(352) ;
      AV9Card2_Value = 7552 ;
      AV10Card3_Value = 825 ;
      AV11Card4_Value = (short)(2540) ;
      GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 = AV5HomeSampleData ;
      GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2[0] = GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 ;
      new web.wwpbaseobjects.gethomesampledata(remoteHandle, context).execute( GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2) ;
      GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 = GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2[0] ;
      AV5HomeSampleData = GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 ;
      AV13Axis = (com.reporting.genexusreporting.SdtQueryViewerElements_Element)new com.reporting.genexusreporting.SdtQueryViewerElements_Element(remoteHandle, context);
      AV13Axis.setgxTv_SdtQueryViewerElements_Element_Name( httpContext.getMessage( "ProductStatus", "") );
      AV13Axis.setgxTv_SdtQueryViewerElements_Element_Visible( "No" );
      AV12Axes.add(AV13Axis, 0);
      AV13Axis = (com.reporting.genexusreporting.SdtQueryViewerElements_Element)new com.reporting.genexusreporting.SdtQueryViewerElements_Element(remoteHandle, context);
      AV13Axis.setgxTv_SdtQueryViewerElements_Element_Name( httpContext.getMessage( "Check", "") );
      AV13Axis.setgxTv_SdtQueryViewerElements_Element_Visible( "No" );
      AV12Axes.add(AV13Axis, 0);
      GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 = AV7SDTNotificationsData ;
      GXv_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem4[0] = GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 ;
      new web.wwpbaseobjects.getnotificationsamples(remoteHandle, context).execute( GXv_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem4) ;
      GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 = GXv_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem4[0] ;
      AV7SDTNotificationsData = GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 ;
      gx_BV29 = true ;
      if ( AV7SDTNotificationsData.size() == 0 )
      {
         lblNotificationssubtitle_Caption = httpContext.getMessage( "WWP_Notifications_NoNewNotifications", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblNotificationssubtitle_Internalname, "Caption", lblNotificationssubtitle_Caption, true);
      }
      else if ( AV7SDTNotificationsData.size() == 1 )
      {
         lblNotificationssubtitle_Caption = httpContext.getMessage( "WWP_Notifications_OneNewNotification", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblNotificationssubtitle_Internalname, "Caption", lblNotificationssubtitle_Caption, true);
      }
      else
      {
         lblNotificationssubtitle_Caption = GXutil.format( httpContext.getMessage( "WWP_Notifications_NewNotifications", ""), GXutil.trim( GXutil.str( AV7SDTNotificationsData.size(), 9, 0)), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblNotificationssubtitle_Internalname, "Caption", lblNotificationssubtitle_Caption, true);
      }
      GXt_int5 = AV24CliCod ;
      GXv_int6[0] = GXt_int5 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
      home_impl.this.GXt_int5 = GXv_int6[0] ;
      AV24CliCod = GXt_int5 ;
      edtavOptionlink_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOptionlink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOptionlink_Visible), 5, 0), !bGXsfl_68_Refreshing);
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      subGrid_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   private void e12382( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV34GXV1 = 1 ;
      while ( AV34GXV1 <= AV7SDTNotificationsData.size() )
      {
         AV7SDTNotificationsData.currentItem( ((web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV34GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(29) ;
         }
         if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
         {
            sendrow_292( ) ;
            GRID_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRID_nCurrentRecord + 1 >= subgrid_fnc_recordcount( ) )
            {
               GRID_nEOF = (byte)(1) ;
               web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_29_Refreshing )
         {
            httpContext.doAjaxLoad(29, GridRow);
         }
         AV34GXV1 = (int)(AV34GXV1+1) ;
      }
   }

   public void e13382( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int5 = AV24CliCod ;
      GXv_int6[0] = GXt_int5 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
      home_impl.this.GXt_int5 = GXv_int6[0] ;
      AV24CliCod = GXt_int5 ;
   }

   private void e14383( )
   {
      /* Gridmenuicons_Load Routine */
      returnInSub = false ;
      AV38GXV5 = 1 ;
      while ( AV38GXV5 <= AV7SDTNotificationsData.size() )
      {
         AV7SDTNotificationsData.currentItem( ((web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV38GXV5)) );
         AV29OptionTitle = ((web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)(AV7SDTNotificationsData.currentItem())).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavOptiontitle_Internalname, AV29OptionTitle);
         AV30OptionThemeClass = ((web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)(AV7SDTNotificationsData.currentItem())).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass() ;
         lblOptionicon_Caption = GXutil.format( "<i class='%2 %1'></i>", AV30OptionThemeClass, "DashboardIcon", "", "", "", "", "", "", "") ;
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(68) ;
         }
         sendrow_683( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_68_Refreshing )
         {
            httpContext.doAjaxLoad(68, GridmenuiconsRow);
         }
         AV38GXV5 = (int)(AV38GXV5+1) ;
      }
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
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
      pa382( ) ;
      ws382( ) ;
      we382( ) ;
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
      httpContext.AddStyleSheetFile("QueryViewer/highcharts/css/highcharts.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/QueryViewer.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/highcharts/css/highcharts.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/QueryViewer.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/highcharts/css/highcharts.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/QueryViewer.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/highcharts/css/highcharts.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/QueryViewer.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Wc == null ) )
      {
         WebComp_Wc.componentthemes();
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202085623", true, true);
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
      httpContext.AddJavascriptSource("home.js", "?202412202085625", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_292( )
   {
      edtavSdtnotificationsdata__notificationiconclass_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONICONCLASS_"+sGXsfl_29_idx ;
      edtavSdtnotificationsdata__notificationtitle_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONTITLE_"+sGXsfl_29_idx ;
      edtavSdtnotificationsdata__notificationdatetime_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONDATETIME_"+sGXsfl_29_idx ;
   }

   public void subsflControlProps_fel_292( )
   {
      edtavSdtnotificationsdata__notificationiconclass_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONICONCLASS_"+sGXsfl_29_fel_idx ;
      edtavSdtnotificationsdata__notificationtitle_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONTITLE_"+sGXsfl_29_fel_idx ;
      edtavSdtnotificationsdata__notificationdatetime_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONDATETIME_"+sGXsfl_29_fel_idx ;
   }

   public void sendrow_292( )
   {
      subsflControlProps_292( ) ;
      wb380( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_29_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_29_idx) % (2))) == 0 )
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
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_29_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationiconclass_Internalname,((web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV34GXV1)).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtnotificationsdata__notificationiconclass_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavSdtnotificationsdata__notificationiconclass_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationtitle_Internalname,((web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV34GXV1)).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtnotificationsdata__notificationtitle_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtnotificationsdata__notificationtitle_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeSecondary" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationdatetime_Internalname,localUtil.ttoc( ((web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV34GXV1)).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime(), 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "),localUtil.format( ((web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV34GXV1)).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime(), "99/99/99 99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtnotificationsdata__notificationdatetime_Jsonclick,Integer.valueOf(0),"AttributeSecondary","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtnotificationsdata__notificationdatetime_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes382( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_29_idx = ((subGrid_Islastpage==1)&&(nGXsfl_29_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_29_idx+1) ;
         sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_292( ) ;
      }
      /* End function sendrow_292 */
   }

   public void subsflControlProps_683( )
   {
      edtavOptionlink_Internalname = "vOPTIONLINK_"+sGXsfl_68_idx ;
      lblOptionicon_Internalname = "OPTIONICON_"+sGXsfl_68_idx ;
      edtavOptiontitle_Internalname = "vOPTIONTITLE_"+sGXsfl_68_idx ;
   }

   public void subsflControlProps_fel_683( )
   {
      edtavOptionlink_Internalname = "vOPTIONLINK_"+sGXsfl_68_fel_idx ;
      lblOptionicon_Internalname = "OPTIONICON_"+sGXsfl_68_fel_idx ;
      edtavOptiontitle_Internalname = "vOPTIONTITLE_"+sGXsfl_68_fel_idx ;
   }

   public void sendrow_683( )
   {
      subsflControlProps_683( ) ;
      wb380( ) ;
      GridmenuiconsRow = GXWebRow.GetNew(context,GridmenuiconsContainer) ;
      if ( subGridmenuicons_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridmenuicons_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridmenuicons_Class, "") != 0 )
         {
            subGridmenuicons_Linesclass = subGridmenuicons_Class+"Odd" ;
         }
      }
      else if ( subGridmenuicons_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridmenuicons_Backstyle = (byte)(0) ;
         subGridmenuicons_Backcolor = subGridmenuicons_Allbackcolor ;
         if ( GXutil.strcmp(subGridmenuicons_Class, "") != 0 )
         {
            subGridmenuicons_Linesclass = subGridmenuicons_Class+"Uniform" ;
         }
      }
      else if ( subGridmenuicons_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridmenuicons_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridmenuicons_Class, "") != 0 )
         {
            subGridmenuicons_Linesclass = subGridmenuicons_Class+"Odd" ;
         }
         subGridmenuicons_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridmenuicons_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridmenuicons_Backstyle = (byte)(1) ;
         subGridmenuicons_Backcolor = (int)(0xFFFFFF) ;
         if ( GXutil.strcmp(subGridmenuicons_Class, "") != 0 )
         {
            subGridmenuicons_Linesclass = subGridmenuicons_Class+"Odd" ;
         }
      }
      /* Start of Columns property logic. */
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsgridmenuicons_Internalname+"_"+sGXsfl_68_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","justify-content:center;","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Invisible","left","top","","flex-grow:1;","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Table start */
      GridmenuiconsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsgridmenuicons_Internalname+"_"+sGXsfl_68_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Attribute/Variable Label */
      GridmenuiconsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavOptionlink_Internalname,httpContext.getMessage( "Option Link", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      GridmenuiconsRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavOptionlink_Internalname,AV28OptionLink,"","",Integer.valueOf(0),Integer.valueOf(edtavOptionlink_Visible),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      if ( GridmenuiconsContainer.GetWrapped() == 1 )
      {
         GridmenuiconsContainer.CloseTag("cell");
      }
      if ( GridmenuiconsContainer.GetWrapped() == 1 )
      {
         GridmenuiconsContainer.CloseTag("row");
      }
      if ( GridmenuiconsContainer.GetWrapped() == 1 )
      {
         GridmenuiconsContainer.CloseTag("table");
      }
      /* End of table */
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","DashboardMenuIconCell","left","top","","flex-grow:1;","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableoptioniconandtitle_Internalname+"_"+sGXsfl_68_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","flex-direction:column;","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;align-self:center;","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Text block */
      GridmenuiconsRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblOptionicon_Internalname,lblOptionicon_Caption,"","",lblOptionicon_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;align-self:center;","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Attribute/Variable Label */
      GridmenuiconsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavOptiontitle_Internalname,httpContext.getMessage( "Option Title", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridmenuiconsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavOptiontitle_Internalname,AV29OptionTitle,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavOptiontitle_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavOptiontitle_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(68),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableoptionwc_Internalname+"_"+sGXsfl_68_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableCardsMenu Invisible","left","top","","","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* Div Control */
      GridmenuiconsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      /* WebComponent */
      web.GxWebStd.gx_hidden_field( httpContext, "W0087"+sGXsfl_68_idx, GXutil.rtrim( WebComp_Wc_Component));
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gxwebcomponent"+" gxwebcomponent-loading");
      httpContext.writeText( " id=\""+"gxHTMLWrpW0087"+sGXsfl_68_idx+"\""+"") ;
      httpContext.writeText( ">") ;
      if ( bGXsfl_68_Refreshing )
      {
         if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strSearch( "W0087"+sGXsfl_68_idx, httpContext.cgiGet( "_EventName"), 1) != 0 ) )
         {
            if ( 1 != 0 )
            {
               WebComp_Wc.componentstart();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strcmp(GXutil.lower( OldWc), GXutil.lower( WebComp_Wc_Component)) != 0 ) )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0087"+sGXsfl_68_idx);
         }
         WebComp_Wc.componentdraw();
         if ( ! httpContext.isAjaxRequest( ) || ( GXutil.strcmp(GXutil.lower( OldWc), GXutil.lower( WebComp_Wc_Component)) != 0 ) )
         {
            httpContext.ajax_rspEndCmp();
         }
      }
      httpContext.writeText( "</div>") ;
      WebComp_Wc_Component = "" ;
      WebComp_Wc.componentjscripts();
      GridmenuiconsRow.AddColumnProperties("webcomp", -1, isAjaxCallMode( ), new Object[] {"Wc"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      GridmenuiconsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridmenuiconsRow.AddRenderProperties(GridmenuiconsColumn);
      send_integrity_lvl_hashes383( ) ;
      /* End of Columns property logic. */
      GridmenuiconsContainer.AddRow(GridmenuiconsRow);
      nGXsfl_68_idx = ((subGridmenuicons_Islastpage==1)&&(nGXsfl_68_idx+1>subgridmenuicons_fnc_recordsperpage( )) ? 1 : nGXsfl_68_idx+1) ;
      sGXsfl_68_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_683( ) ;
      /* End function sendrow_683 */
   }

   public void startgridcontrol29( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"29\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Notification Icon Class", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Notification Title", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeSecondary"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Notification Datetime", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtnotificationsdata__notificationiconclass_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtnotificationsdata__notificationtitle_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtnotificationsdata__notificationdatetime_Enabled, (byte)(5), (byte)(0), ".", "")));
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

   public void startgridcontrol68( )
   {
      if ( GridmenuiconsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridmenuiconsContainer"+"DivS\" data-gxgridid=\"68\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridmenuicons_Internalname, subGridmenuicons_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridmenuiconsContainer.AddObjectProperty("GridName", "Gridmenuicons");
      }
      else
      {
         GridmenuiconsContainer.AddObjectProperty("GridName", "Gridmenuicons");
         GridmenuiconsContainer.AddObjectProperty("Header", subGridmenuicons_Header);
         GridmenuiconsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         GridmenuiconsContainer.AddObjectProperty("Class", "FreeStyleGrid");
         GridmenuiconsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridmenuicons_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddObjectProperty("CmpContext", "");
         GridmenuiconsContainer.AddObjectProperty("InMasterPage", "false");
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsColumn.AddObjectProperty("Value", AV28OptionLink);
         GridmenuiconsColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavOptionlink_Visible, (byte)(5), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsColumn.AddObjectProperty("Value", lblOptionicon_Caption);
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsColumn.AddObjectProperty("Value", AV29OptionTitle);
         GridmenuiconsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavOptiontitle_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuiconsContainer.AddColumnProperties(GridmenuiconsColumn);
         GridmenuiconsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridmenuicons_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridmenuicons_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridmenuicons_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridmenuicons_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridmenuicons_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridmenuicons_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridmenuiconsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridmenuicons_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      imgHomemodulesbackground3_Internalname = "HOMEMODULESBACKGROUND3" ;
      lblFirsttab_title_Internalname = "FIRSTTAB_TITLE" ;
      lblNotificationssubtitle_Internalname = "NOTIFICATIONSSUBTITLE" ;
      edtavSdtnotificationsdata__notificationiconclass_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONICONCLASS" ;
      edtavSdtnotificationsdata__notificationtitle_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONTITLE" ;
      edtavSdtnotificationsdata__notificationdatetime_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONDATETIME" ;
      divTabletab1_Internalname = "TABLETAB1" ;
      lblAdditionalinformation_title_Internalname = "ADDITIONALINFORMATION_TITLE" ;
      Utchartline_Internalname = "UTCHARTLINE" ;
      divTabletab2_Internalname = "TABLETAB2" ;
      Gxuitabspanel_tabs_Internalname = "GXUITABSPANEL_TABS" ;
      divTablenotifications_Internalname = "TABLENOTIFICATIONS" ;
      Dvpanel_tablenotifications_Internalname = "DVPANEL_TABLENOTIFICATIONS" ;
      Utchartbars_Internalname = "UTCHARTBARS" ;
      divTablebottomsection1_Internalname = "TABLEBOTTOMSECTION1" ;
      Dvpanel_tablebottomsection1_Internalname = "DVPANEL_TABLEBOTTOMSECTION1" ;
      Utchartdoughnut_Internalname = "UTCHARTDOUGHNUT" ;
      divTablebottomsection3_Internalname = "TABLEBOTTOMSECTION3" ;
      Dvpanel_tablebottomsection3_Internalname = "DVPANEL_TABLEBOTTOMSECTION3" ;
      divTableleftcontent_Internalname = "TABLELEFTCONTENT" ;
      edtavDate_Internalname = "vDATE" ;
      edtavOptionlink_Internalname = "vOPTIONLINK" ;
      tblUnnamedtablecontentfsgridmenuicons_Internalname = "UNNAMEDTABLECONTENTFSGRIDMENUICONS" ;
      lblOptionicon_Internalname = "OPTIONICON" ;
      edtavOptiontitle_Internalname = "vOPTIONTITLE" ;
      divTableoptioniconandtitle_Internalname = "TABLEOPTIONICONANDTITLE" ;
      divTableoptionwc_Internalname = "TABLEOPTIONWC" ;
      divUnnamedtablefsgridmenuicons_Internalname = "UNNAMEDTABLEFSGRIDMENUICONS" ;
      divSecondpanelrightzone_Internalname = "SECONDPANELRIGHTZONE" ;
      Dvpanel_secondpanelrightzone_Internalname = "DVPANEL_SECONDPANELRIGHTZONE" ;
      Utchartsmoothline_Internalname = "UTCHARTSMOOTHLINE" ;
      divTablebottomsection2_Internalname = "TABLEBOTTOMSECTION2" ;
      Dvpanel_tablebottomsection2_Internalname = "DVPANEL_TABLEBOTTOMSECTION2" ;
      divTablerightcontent_Internalname = "TABLERIGHTCONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
      subGridmenuicons_Internalname = "GRIDMENUICONS" ;
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
      subGridmenuicons_Allowcollapsing = (byte)(0) ;
      lblOptionicon_Caption = httpContext.getMessage( "<i class='NotificationFontIconSuccess DashboardIcon  fa fa-home'></i>", "") ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtavOptiontitle_Jsonclick = "" ;
      edtavOptiontitle_Enabled = 0 ;
      lblOptionicon_Caption = httpContext.getMessage( "<i class='NotificationFontIconSuccess DashboardIcon  fa fa-home'></i>", "") ;
      edtavSdtnotificationsdata__notificationdatetime_Jsonclick = "" ;
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationtitle_Jsonclick = "" ;
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationiconclass_Jsonclick = "" ;
      edtavSdtnotificationsdata__notificationiconclass_Enabled = 0 ;
      subGrid_Class = "WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      subGridmenuicons_Backcolorstyle = (byte)(0) ;
      edtavSdtnotificationsdata__notificationdatetime_Enabled = -1 ;
      edtavSdtnotificationsdata__notificationtitle_Enabled = -1 ;
      edtavSdtnotificationsdata__notificationiconclass_Enabled = -1 ;
      Utchartsmoothline_Title = "" ;
      edtavDate_Jsonclick = "" ;
      edtavDate_Enabled = 1 ;
      Utchartdoughnut_Title = "" ;
      Utchartbars_Title = "" ;
      Utchartline_Title = "" ;
      lblNotificationssubtitle_Caption = httpContext.getMessage( "WWP_Notifications_NewNotifications", "") ;
      subGridmenuicons_Flexwrap = "wrap" ;
      subGridmenuicons_Class = "FreeStyleGrid" ;
      Dvpanel_tablebottomsection2_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection2_Iconposition = "Right" ;
      Dvpanel_tablebottomsection2_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection2_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection2_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection2_Title = httpContext.getMessage( "Task Board", "") ;
      Dvpanel_tablebottomsection2_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tablebottomsection2_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablebottomsection2_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection2_Width = "100%" ;
      Utchartsmoothline_Xaxistitle = " " ;
      Utchartsmoothline_Charttype = "SmoothLine" ;
      Utchartsmoothline_Type = "Chart" ;
      Utchartsmoothline_Height = "276px" ;
      Dvpanel_secondpanelrightzone_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_secondpanelrightzone_Iconposition = "Right" ;
      Dvpanel_secondpanelrightzone_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_secondpanelrightzone_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_secondpanelrightzone_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_secondpanelrightzone_Title = httpContext.getMessage( "Applications", "") ;
      Dvpanel_secondpanelrightzone_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_secondpanelrightzone_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_secondpanelrightzone_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_secondpanelrightzone_Width = "100%" ;
      Dvpanel_tablebottomsection3_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection3_Iconposition = "Right" ;
      Dvpanel_tablebottomsection3_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection3_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection3_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection3_Title = httpContext.getMessage( "Products", "") ;
      Dvpanel_tablebottomsection3_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tablebottomsection3_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablebottomsection3_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection3_Width = "100%" ;
      Utchartdoughnut_Charttype = "Doughnut" ;
      Utchartdoughnut_Showvalues = GXutil.toBoolean( 0) ;
      Utchartdoughnut_Type = "Chart" ;
      Utchartdoughnut_Height = "300px" ;
      Dvpanel_tablebottomsection1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection1_Iconposition = "Right" ;
      Dvpanel_tablebottomsection1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tablebottomsection1_Title = httpContext.getMessage( "Sales", "") ;
      Dvpanel_tablebottomsection1_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tablebottomsection1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablebottomsection1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablebottomsection1_Width = "100%" ;
      Utchartbars_Xaxistitle = " " ;
      Utchartbars_Charttype = "Bar" ;
      Utchartbars_Type = "Chart" ;
      Utchartbars_Height = "300px" ;
      Dvpanel_tablenotifications_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablenotifications_Iconposition = "Right" ;
      Dvpanel_tablenotifications_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablenotifications_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablenotifications_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tablenotifications_Title = httpContext.getMessage( "Monthly Report", "") ;
      Dvpanel_tablenotifications_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tablenotifications_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablenotifications_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablenotifications_Width = "100%" ;
      Gxuitabspanel_tabs_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs_Class = "OnlyLinks" ;
      Gxuitabspanel_tabs_Pagecount = 2 ;
      Utchartline_Charttype = "Line" ;
      Utchartline_Showvalues = GXutil.toBoolean( 0) ;
      Utchartline_Type = "Chart" ;
      Utchartline_Height = "250px" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "WWP_HomeTitle", "") );
      edtavOptionlink_Visible = 1 ;
      subGrid_Rows = 0 ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'GRIDMENUICONS_nFirstRecordOnPage'},{av:'GRIDMENUICONS_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtavOptionlink_Visible',ctrl:'vOPTIONLINK',prop:'Visible'},{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:29,pic:'',hsh:true},{av:'nGXsfl_29_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:29},{av:'nRC_GXsfl_29',ctrl:'GRID',prop:'GridRC',grid:29}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDMENUICONS.LOAD","{handler:'e14383',iparms:[{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:29,pic:'',hsh:true},{av:'nGXsfl_29_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:29},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_29',ctrl:'GRID',prop:'GridRC',grid:29}]");
      setEventMetadata("GRIDMENUICONS.LOAD",",oparms:[{av:'AV29OptionTitle',fld:'vOPTIONTITLE',pic:''},{av:'lblOptionicon_Caption',ctrl:'OPTIONICON',prop:'Caption'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e12382',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:29,pic:'',hsh:true},{av:'nGXsfl_29_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:29},{av:'nRC_GXsfl_29',ctrl:'GRID',prop:'GridRC',grid:29}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:29,pic:'',hsh:true},{av:'nGXsfl_29_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:29},{av:'nRC_GXsfl_29',ctrl:'GRID',prop:'GridRC',grid:29}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:29,pic:'',hsh:true},{av:'nGXsfl_29_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:29},{av:'nRC_GXsfl_29',ctrl:'GRID',prop:'GridRC',grid:29}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:29,pic:'',hsh:true},{av:'nGXsfl_29_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:29},{av:'nRC_GXsfl_29',ctrl:'GRID',prop:'GridRC',grid:29}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv4',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Optiontitle',iparms:[]");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV7SDTNotificationsData = new GXBaseCollection<web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem>(web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem.class, "WWP_SDTNotificationsDataSampleItem", "PayDay", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV14Elements = new GXBaseCollection<com.reporting.genexusreporting.SdtQueryViewerElements_Element>(com.reporting.genexusreporting.SdtQueryViewerElements_Element.class, "Element", "GeneXus.Reporting", remoteHandle);
      AV15Parameters = new GXBaseCollection<com.reporting.genexusreporting.SdtQueryViewerParameters_Parameter>(com.reporting.genexusreporting.SdtQueryViewerParameters_Parameter.class, "Parameter", "GeneXus.Reporting", remoteHandle);
      AV16ItemClickData = new com.reporting.genexusreporting.SdtQueryViewerItemClickData(remoteHandle, context);
      AV17ItemDoubleClickData = new com.reporting.genexusreporting.SdtQueryViewerItemDoubleClickData(remoteHandle, context);
      AV18DragAndDropData = new com.reporting.genexusreporting.SdtQueryViewerDragAndDropData(remoteHandle, context);
      AV19FilterChangedData = new com.reporting.genexusreporting.SdtQueryViewerFilterChangedData(remoteHandle, context);
      AV20ItemExpandData = new com.reporting.genexusreporting.SdtQueryViewerItemExpandData(remoteHandle, context);
      AV21ItemCollapseData = new com.reporting.genexusreporting.SdtQueryViewerItemCollapseData(remoteHandle, context);
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      imgHomemodulesbackground3_gximage = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      ucDvpanel_tablenotifications = new com.genexus.webpanels.GXUserControl();
      ucGxuitabspanel_tabs = new com.genexus.webpanels.GXUserControl();
      lblFirsttab_title_Jsonclick = "" ;
      lblNotificationssubtitle_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      lblAdditionalinformation_title_Jsonclick = "" ;
      ucUtchartline = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_tablebottomsection1 = new com.genexus.webpanels.GXUserControl();
      ucUtchartbars = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_tablebottomsection3 = new com.genexus.webpanels.GXUserControl();
      ucUtchartdoughnut = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV31Date = GXutil.nullDate() ;
      ucDvpanel_secondpanelrightzone = new com.genexus.webpanels.GXUserControl();
      GridmenuiconsContainer = new com.genexus.webpanels.GXWebGrid(context);
      ucDvpanel_tablebottomsection2 = new com.genexus.webpanels.GXUserControl();
      ucUtchartsmoothline = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV28OptionLink = "" ;
      AV29OptionTitle = "" ;
      OldWc = "" ;
      sCmpCtrl = "" ;
      WebComp_GX_Process_Component = "" ;
      WebCompHandler = "" ;
      AV5HomeSampleData = new GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>(web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem.class, "HomeSampleDataItem", "PayDay", remoteHandle);
      GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 = new GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>(web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem.class, "HomeSampleDataItem", "PayDay", remoteHandle);
      GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2 = new GXBaseCollection[1] ;
      AV13Axis = new com.reporting.genexusreporting.SdtQueryViewerElements_Element(remoteHandle, context);
      AV12Axes = new GXBaseCollection<com.reporting.genexusreporting.SdtQueryViewerElements_Element>(com.reporting.genexusreporting.SdtQueryViewerElements_Element.class, "Element", "GeneXus.Reporting", remoteHandle);
      GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 = new GXBaseCollection<web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem>(web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem.class, "WWP_SDTNotificationsDataSampleItem", "PayDay", remoteHandle);
      GXv_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem4 = new GXBaseCollection[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      GXv_int6 = new int[1] ;
      AV30OptionThemeClass = "" ;
      GridmenuiconsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      subGridmenuicons_Linesclass = "" ;
      GridmenuiconsColumn = new com.genexus.webpanels.GXWebColumn();
      lblOptionicon_Jsonclick = "" ;
      WebComp_Wc_Component = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      subGridmenuicons_Header = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavSdtnotificationsdata__notificationiconclass_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      edtavOptiontitle_Enabled = 0 ;
      WebComp_GX_Process = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGridmenuicons_Backcolorstyle ;
   private byte GRIDMENUICONS_nEOF ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGridmenuicons_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte subGridmenuicons_Allowselection ;
   private byte subGridmenuicons_Allowhovering ;
   private byte subGridmenuicons_Allowcollapsing ;
   private byte subGridmenuicons_Collapsed ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV8Card1_Value ;
   private short AV11Card4_Value ;
   private int nRC_GXsfl_29 ;
   private int nRC_GXsfl_68 ;
   private int subGrid_Rows ;
   private int nGXsfl_29_idx=1 ;
   private int nGXsfl_68_idx=1 ;
   private int edtavOptionlink_Visible ;
   private int Gxuitabspanel_tabs_Pagecount ;
   private int AV34GXV1 ;
   private int edtavDate_Enabled ;
   private int AV38GXV5 ;
   private int nGXsfl_68_webc_idx ;
   private int subGrid_Islastpage ;
   private int subGridmenuicons_Islastpage ;
   private int edtavSdtnotificationsdata__notificationiconclass_Enabled ;
   private int edtavSdtnotificationsdata__notificationtitle_Enabled ;
   private int edtavSdtnotificationsdata__notificationdatetime_Enabled ;
   private int edtavOptiontitle_Enabled ;
   private int GRID_nGridOutOfScope ;
   private int nGXsfl_29_fel_idx=1 ;
   private int AV9Card2_Value ;
   private int AV10Card3_Value ;
   private int AV24CliCod ;
   private int GXt_int5 ;
   private int GXv_int6[] ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGridmenuicons_Backcolor ;
   private int subGridmenuicons_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGridmenuicons_Selectedindex ;
   private int subGridmenuicons_Selectioncolor ;
   private int subGridmenuicons_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long GRID_nCurrentRecord ;
   private long GRIDMENUICONS_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private long GRIDMENUICONS_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_29_idx="0001" ;
   private String sGXsfl_68_idx="0001" ;
   private String edtavOptionlink_Internalname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Utchartline_Height ;
   private String Utchartline_Type ;
   private String Utchartline_Charttype ;
   private String Gxuitabspanel_tabs_Class ;
   private String Dvpanel_tablenotifications_Width ;
   private String Dvpanel_tablenotifications_Cls ;
   private String Dvpanel_tablenotifications_Title ;
   private String Dvpanel_tablenotifications_Iconposition ;
   private String Utchartbars_Height ;
   private String Utchartbars_Type ;
   private String Utchartbars_Charttype ;
   private String Utchartbars_Xaxistitle ;
   private String Dvpanel_tablebottomsection1_Width ;
   private String Dvpanel_tablebottomsection1_Cls ;
   private String Dvpanel_tablebottomsection1_Title ;
   private String Dvpanel_tablebottomsection1_Iconposition ;
   private String Utchartdoughnut_Height ;
   private String Utchartdoughnut_Type ;
   private String Utchartdoughnut_Charttype ;
   private String Dvpanel_tablebottomsection3_Width ;
   private String Dvpanel_tablebottomsection3_Cls ;
   private String Dvpanel_tablebottomsection3_Title ;
   private String Dvpanel_tablebottomsection3_Iconposition ;
   private String Dvpanel_secondpanelrightzone_Width ;
   private String Dvpanel_secondpanelrightzone_Cls ;
   private String Dvpanel_secondpanelrightzone_Title ;
   private String Dvpanel_secondpanelrightzone_Iconposition ;
   private String Utchartsmoothline_Height ;
   private String Utchartsmoothline_Type ;
   private String Utchartsmoothline_Charttype ;
   private String Utchartsmoothline_Xaxistitle ;
   private String Dvpanel_tablebottomsection2_Width ;
   private String Dvpanel_tablebottomsection2_Cls ;
   private String Dvpanel_tablebottomsection2_Title ;
   private String Dvpanel_tablebottomsection2_Iconposition ;
   private String Grid_empowerer_Gridinternalname ;
   private String subGridmenuicons_Class ;
   private String subGridmenuicons_Flexwrap ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableleftcontent_Internalname ;
   private String ClassString ;
   private String imgHomemodulesbackground3_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgHomemodulesbackground3_Internalname ;
   private String Dvpanel_tablenotifications_Internalname ;
   private String divTablenotifications_Internalname ;
   private String Gxuitabspanel_tabs_Internalname ;
   private String lblFirsttab_title_Internalname ;
   private String lblFirsttab_title_Jsonclick ;
   private String divTabletab1_Internalname ;
   private String lblNotificationssubtitle_Internalname ;
   private String lblNotificationssubtitle_Caption ;
   private String lblNotificationssubtitle_Jsonclick ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String lblAdditionalinformation_title_Internalname ;
   private String lblAdditionalinformation_title_Jsonclick ;
   private String divTabletab2_Internalname ;
   private String Utchartline_Title ;
   private String Utchartline_Internalname ;
   private String Dvpanel_tablebottomsection1_Internalname ;
   private String divTablebottomsection1_Internalname ;
   private String Utchartbars_Title ;
   private String Utchartbars_Internalname ;
   private String Dvpanel_tablebottomsection3_Internalname ;
   private String divTablebottomsection3_Internalname ;
   private String Utchartdoughnut_Title ;
   private String Utchartdoughnut_Internalname ;
   private String divTablerightcontent_Internalname ;
   private String edtavDate_Internalname ;
   private String TempTags ;
   private String edtavDate_Jsonclick ;
   private String Dvpanel_secondpanelrightzone_Internalname ;
   private String divSecondpanelrightzone_Internalname ;
   private String subGridmenuicons_Internalname ;
   private String Dvpanel_tablebottomsection2_Internalname ;
   private String divTablebottomsection2_Internalname ;
   private String Utchartsmoothline_Title ;
   private String Utchartsmoothline_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavOptiontitle_Internalname ;
   private String OldWc ;
   private String sCmpCtrl ;
   private String WebComp_GX_Process_Component ;
   private String WebCompHandler ;
   private String edtavSdtnotificationsdata__notificationiconclass_Internalname ;
   private String edtavSdtnotificationsdata__notificationtitle_Internalname ;
   private String edtavSdtnotificationsdata__notificationdatetime_Internalname ;
   private String sGXsfl_29_fel_idx="0001" ;
   private String lblOptionicon_Caption ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavSdtnotificationsdata__notificationiconclass_Jsonclick ;
   private String edtavSdtnotificationsdata__notificationtitle_Jsonclick ;
   private String edtavSdtnotificationsdata__notificationdatetime_Jsonclick ;
   private String lblOptionicon_Internalname ;
   private String sGXsfl_68_fel_idx="0001" ;
   private String subGridmenuicons_Linesclass ;
   private String divUnnamedtablefsgridmenuicons_Internalname ;
   private String tblUnnamedtablecontentfsgridmenuicons_Internalname ;
   private String divTableoptioniconandtitle_Internalname ;
   private String lblOptionicon_Jsonclick ;
   private String edtavOptiontitle_Jsonclick ;
   private String divTableoptionwc_Internalname ;
   private String WebComp_Wc_Component ;
   private String subGrid_Header ;
   private String subGridmenuicons_Header ;
   private java.util.Date AV31Date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_68_Refreshing=false ;
   private boolean Utchartline_Showvalues ;
   private boolean Gxuitabspanel_tabs_Historymanagement ;
   private boolean Dvpanel_tablenotifications_Autowidth ;
   private boolean Dvpanel_tablenotifications_Autoheight ;
   private boolean Dvpanel_tablenotifications_Collapsible ;
   private boolean Dvpanel_tablenotifications_Collapsed ;
   private boolean Dvpanel_tablenotifications_Showcollapseicon ;
   private boolean Dvpanel_tablenotifications_Autoscroll ;
   private boolean Dvpanel_tablebottomsection1_Autowidth ;
   private boolean Dvpanel_tablebottomsection1_Autoheight ;
   private boolean Dvpanel_tablebottomsection1_Collapsible ;
   private boolean Dvpanel_tablebottomsection1_Collapsed ;
   private boolean Dvpanel_tablebottomsection1_Showcollapseicon ;
   private boolean Dvpanel_tablebottomsection1_Autoscroll ;
   private boolean Utchartdoughnut_Showvalues ;
   private boolean Dvpanel_tablebottomsection3_Autowidth ;
   private boolean Dvpanel_tablebottomsection3_Autoheight ;
   private boolean Dvpanel_tablebottomsection3_Collapsible ;
   private boolean Dvpanel_tablebottomsection3_Collapsed ;
   private boolean Dvpanel_tablebottomsection3_Showcollapseicon ;
   private boolean Dvpanel_tablebottomsection3_Autoscroll ;
   private boolean Dvpanel_secondpanelrightzone_Autowidth ;
   private boolean Dvpanel_secondpanelrightzone_Autoheight ;
   private boolean Dvpanel_secondpanelrightzone_Collapsible ;
   private boolean Dvpanel_secondpanelrightzone_Collapsed ;
   private boolean Dvpanel_secondpanelrightzone_Showcollapseicon ;
   private boolean Dvpanel_secondpanelrightzone_Autoscroll ;
   private boolean Dvpanel_tablebottomsection2_Autowidth ;
   private boolean Dvpanel_tablebottomsection2_Autoheight ;
   private boolean Dvpanel_tablebottomsection2_Collapsible ;
   private boolean Dvpanel_tablebottomsection2_Collapsed ;
   private boolean Dvpanel_tablebottomsection2_Showcollapseicon ;
   private boolean Dvpanel_tablebottomsection2_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_29_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV29 ;
   private boolean gx_refresh_fired ;
   private String AV28OptionLink ;
   private String AV29OptionTitle ;
   private String AV30OptionThemeClass ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebGrid GridmenuiconsContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebRow GridmenuiconsRow ;
   private com.genexus.webpanels.GXWebColumn GridmenuiconsColumn ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wc ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablenotifications ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs ;
   private com.genexus.webpanels.GXUserControl ucUtchartline ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablebottomsection1 ;
   private com.genexus.webpanels.GXUserControl ucUtchartbars ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablebottomsection3 ;
   private com.genexus.webpanels.GXUserControl ucUtchartdoughnut ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_secondpanelrightzone ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablebottomsection2 ;
   private com.genexus.webpanels.GXUserControl ucUtchartsmoothline ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private GXWebComponent WebComp_GX_Process ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> AV5HomeSampleData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> AV7SDTNotificationsData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> GXv_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem4[] ;
   private GXBaseCollection<com.reporting.genexusreporting.SdtQueryViewerElements_Element> AV14Elements ;
   private GXBaseCollection<com.reporting.genexusreporting.SdtQueryViewerElements_Element> AV12Axes ;
   private GXBaseCollection<com.reporting.genexusreporting.SdtQueryViewerParameters_Parameter> AV15Parameters ;
   private com.reporting.genexusreporting.SdtQueryViewerElements_Element AV13Axis ;
   private com.reporting.genexusreporting.SdtQueryViewerItemClickData AV16ItemClickData ;
   private com.reporting.genexusreporting.SdtQueryViewerItemDoubleClickData AV17ItemDoubleClickData ;
   private com.reporting.genexusreporting.SdtQueryViewerDragAndDropData AV18DragAndDropData ;
   private com.reporting.genexusreporting.SdtQueryViewerFilterChangedData AV19FilterChangedData ;
   private com.reporting.genexusreporting.SdtQueryViewerItemExpandData AV20ItemExpandData ;
   private com.reporting.genexusreporting.SdtQueryViewerItemCollapseData AV21ItemCollapseData ;
}

