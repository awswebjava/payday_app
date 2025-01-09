package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajosview_impl extends GXWebComponent
{
   public legajosview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajosview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajosview_impl.class ));
   }

   public legajosview_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               AV10CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CliCod), 6, 0));
               AV11EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
               AV13LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
               AV8TabCode = httpContext.GetPar( "TabCode") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8TabCode", AV8TabCode);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV13LegNumero),AV8TabCode});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
               gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
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
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paJR2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
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
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( httpContext.getMessage( "Legajos View", "")) ;
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
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal FormSplitScreen\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormSplitScreen\" data-gx-class=\"form-horizontal FormSplitScreen\" novalidate action=\""+formatLink("web.legajosview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"CliCod","EmpCod","LegNumero","TabCode"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal FormSplitScreen", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormSplitScreen" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV25Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEXISTS", getSecureSignedToken( sPrefix, AV9Exists));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMODOPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV19modoPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV22palabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMENUOPCCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV21MenuOpcCod, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV10CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV11EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV13LegNumero", GXutil.ltrim( localUtil.ntoc( wcpOAV13LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8TabCode", GXutil.rtrim( wcpOAV8TabCode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV25Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV25Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vEXISTS", AV9Exists);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEXISTS", getSecureSignedToken( sPrefix, AV9Exists));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTABCODE", GXutil.rtrim( AV8TabCode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV10CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vLOADALLTABS", AV14LoadAllTabs);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSELECTEDTABCODE", GXutil.rtrim( AV15SelectedTabCode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV13LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODOPALABRA", GXutil.rtrim( AV19modoPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMODOPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV19modoPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPALABRA", GXutil.rtrim( AV22palabra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV22palabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENUOPCCOD", AV21MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMENUOPCCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV21MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TABS_Class", GXutil.rtrim( Tabs_Class));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TABS_Historymanagement", GXutil.booltostr( Tabs_Historymanagement));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
   }

   public void renderHtmlCloseFormJR2( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
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
         if ( ! ( WebComp_Wcbienvenidalegajo == null ) )
         {
            WebComp_Wcbienvenidalegajo.componentjscripts();
         }
         if ( ! ( WebComp_Legajoabmwc == null ) )
         {
            WebComp_Legajoabmwc.componentjscripts();
         }
         if ( ! ( WebComp_Horaswcwc == null ) )
         {
            WebComp_Horaswcwc.componentjscripts();
         }
         if ( ! ( WebComp_Licenciaswcwc == null ) )
         {
            WebComp_Licenciaswcwc.componentjscripts();
         }
         if ( ! ( WebComp_Familiawcwc == null ) )
         {
            WebComp_Familiawcwc.componentjscripts();
         }
         if ( ! ( WebComp_Codededuccionessolapa2wc == null ) )
         {
            WebComp_Codededuccionessolapa2wc.componentjscripts();
         }
         if ( ! ( WebComp_Liquidacioneswcwc == null ) )
         {
            WebComp_Liquidacioneswcwc.componentjscripts();
         }
         if ( ! ( WebComp_Ganancias_prorrateoswc == null ) )
         {
            WebComp_Ganancias_prorrateoswc.componentjscripts();
         }
         if ( ! ( WebComp_Obligacioneswc == null ) )
         {
            WebComp_Obligacioneswc.componentjscripts();
         }
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "LegajosView" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Legajos View", "") ;
   }

   public void wbJR0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.legajosview");
            httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
            httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
         }
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableSplitScreen", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_9_JR2( true) ;
      }
      else
      {
         wb_table1_9_JR2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_JR2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellViewTabsPosition", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableviewcontainer_Internalname, divUnnamedtableviewcontainer_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellViewTab", "left", "top", "", "", "div");
         /* User Defined Control */
         ucTabs.setProperty("PageCount", Tabs_Pagecount);
         ucTabs.setProperty("Class", Tabs_Class);
         ucTabs.setProperty("HistoryManagement", Tabs_Historymanagement);
         ucTabs.render(context, "tab", Tabs_Internalname, sPrefix+"TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblLegajoabm_title_Internalname, httpContext.getMessage( "Datos empleado", ""), "", "", lblLegajoabm_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajosView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "LegajoABM") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegajoabm_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0026"+"", GXutil.rtrim( WebComp_Legajoabmwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0026"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Legajoabmwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLegajoabmwc), GXutil.lower( WebComp_Legajoabmwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0026"+"");
               }
               WebComp_Legajoabmwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldLegajoabmwc), GXutil.lower( WebComp_Legajoabmwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblHoraswc_title_Internalname, httpContext.getMessage( "Horas y conceptos", ""), "", "", lblHoraswc_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajosView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "horasWC") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablehoraswc_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0034"+"", GXutil.rtrim( WebComp_Horaswcwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0034"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Horaswcwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldHoraswcwc), GXutil.lower( WebComp_Horaswcwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0034"+"");
               }
               WebComp_Horaswcwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldHoraswcwc), GXutil.lower( WebComp_Horaswcwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblLicenciaswc_title_Internalname, httpContext.getMessage( "Licencias", ""), "", "", lblLicenciaswc_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajosView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "licenciasWC") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelicenciaswc_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0042"+"", GXutil.rtrim( WebComp_Licenciaswcwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0042"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Licenciaswcwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLicenciaswcwc), GXutil.lower( WebComp_Licenciaswcwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0042"+"");
               }
               WebComp_Licenciaswcwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldLicenciaswcwc), GXutil.lower( WebComp_Licenciaswcwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblFamiliawc_title_Internalname, httpContext.getMessage( "Familia", ""), "", "", lblFamiliawc_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajosView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "familiaWC") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablefamiliawc_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0050"+"", GXutil.rtrim( WebComp_Familiawcwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0050"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Familiawcwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldFamiliawcwc), GXutil.lower( WebComp_Familiawcwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0050"+"");
               }
               WebComp_Familiawcwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldFamiliawcwc), GXutil.lower( WebComp_Familiawcwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"title5"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCodededuccionessolapa2_title_Internalname, httpContext.getMessage( "Siradig", ""), "", "", lblCodededuccionessolapa2_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajosView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "CodeDeduccionesSolapa2") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablecodededuccionessolapa2_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0058"+"", GXutil.rtrim( WebComp_Codededuccionessolapa2wc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0058"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Codededuccionessolapa2wc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldCodededuccionessolapa2wc), GXutil.lower( WebComp_Codededuccionessolapa2wc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0058"+"");
               }
               WebComp_Codededuccionessolapa2wc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldCodededuccionessolapa2wc), GXutil.lower( WebComp_Codededuccionessolapa2wc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"title6"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblLiquidacioneswc_title_Internalname, httpContext.getMessage( "Liquidaciones", ""), "", "", lblLiquidacioneswc_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajosView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "liquidacionesWC") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"panel6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableliquidacioneswc_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0066"+"", GXutil.rtrim( WebComp_Liquidacioneswcwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0066"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Liquidacioneswcwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLiquidacioneswcwc), GXutil.lower( WebComp_Liquidacioneswcwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0066"+"");
               }
               WebComp_Liquidacioneswcwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldLiquidacioneswcwc), GXutil.lower( WebComp_Liquidacioneswcwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"title7"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGanancias_prorrateos_title_Internalname, httpContext.getMessage( "Ganancias", ""), "", "", lblGanancias_prorrateos_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajosView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "ganancias_prorrateos") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"panel7"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableganancias_prorrateos_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0074"+"", GXutil.rtrim( WebComp_Ganancias_prorrateoswc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0074"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Ganancias_prorrateoswc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldGanancias_prorrateoswc), GXutil.lower( WebComp_Ganancias_prorrateoswc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0074"+"");
               }
               WebComp_Ganancias_prorrateoswc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldGanancias_prorrateoswc), GXutil.lower( WebComp_Ganancias_prorrateoswc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"title8"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblObligaciones_title_Internalname, httpContext.getMessage( "Obligaciones", ""), "", "", lblObligaciones_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajosView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "obligaciones") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"TABSContainer"+"panel8"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableobligaciones_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0082"+"", GXutil.rtrim( WebComp_Obligacioneswc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0082"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Obligacioneswc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldObligacioneswc), GXutil.lower( WebComp_Obligacioneswc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0082"+"");
               }
               WebComp_Obligacioneswc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldObligacioneswc), GXutil.lower( WebComp_Obligacioneswc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startJR2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Legajos View", ""), (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strupJR0( ) ;
         }
      }
   }

   public void wsJR2( )
   {
      startJR2( ) ;
      evtJR2( ) ;
   }

   public void evtJR2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJR0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "TABS.TABCHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJR0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11JR2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJR0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e12JR2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJR0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e13JR2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJR0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJR0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                     }
                  }
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 12 )
                     {
                        OldWcbienvenidalegajo = httpContext.cgiGet( sPrefix+"W0012") ;
                        if ( ( GXutil.len( OldWcbienvenidalegajo) == 0 ) || ( GXutil.strcmp(OldWcbienvenidalegajo, WebComp_Wcbienvenidalegajo_Component) != 0 ) )
                        {
                           WebComp_Wcbienvenidalegajo = WebUtils.getWebComponent(getClass(), "web." + OldWcbienvenidalegajo + "_impl", remoteHandle, context);
                           WebComp_Wcbienvenidalegajo_Component = OldWcbienvenidalegajo ;
                        }
                        if ( GXutil.len( WebComp_Wcbienvenidalegajo_Component) != 0 )
                        {
                           WebComp_Wcbienvenidalegajo.componentprocess(sPrefix+"W0012", "", sEvt);
                        }
                        WebComp_Wcbienvenidalegajo_Component = OldWcbienvenidalegajo ;
                     }
                     else if ( nCmpId == 26 )
                     {
                        OldLegajoabmwc = httpContext.cgiGet( sPrefix+"W0026") ;
                        if ( ( GXutil.len( OldLegajoabmwc) == 0 ) || ( GXutil.strcmp(OldLegajoabmwc, WebComp_Legajoabmwc_Component) != 0 ) )
                        {
                           WebComp_Legajoabmwc = WebUtils.getWebComponent(getClass(), "web." + OldLegajoabmwc + "_impl", remoteHandle, context);
                           WebComp_Legajoabmwc_Component = OldLegajoabmwc ;
                        }
                        if ( GXutil.len( WebComp_Legajoabmwc_Component) != 0 )
                        {
                           WebComp_Legajoabmwc.componentprocess(sPrefix+"W0026", "", sEvt);
                        }
                        WebComp_Legajoabmwc_Component = OldLegajoabmwc ;
                     }
                     else if ( nCmpId == 34 )
                     {
                        OldHoraswcwc = httpContext.cgiGet( sPrefix+"W0034") ;
                        if ( ( GXutil.len( OldHoraswcwc) == 0 ) || ( GXutil.strcmp(OldHoraswcwc, WebComp_Horaswcwc_Component) != 0 ) )
                        {
                           WebComp_Horaswcwc = WebUtils.getWebComponent(getClass(), "web." + OldHoraswcwc + "_impl", remoteHandle, context);
                           WebComp_Horaswcwc_Component = OldHoraswcwc ;
                        }
                        if ( GXutil.len( WebComp_Horaswcwc_Component) != 0 )
                        {
                           WebComp_Horaswcwc.componentprocess(sPrefix+"W0034", "", sEvt);
                        }
                        WebComp_Horaswcwc_Component = OldHoraswcwc ;
                     }
                     else if ( nCmpId == 42 )
                     {
                        OldLicenciaswcwc = httpContext.cgiGet( sPrefix+"W0042") ;
                        if ( ( GXutil.len( OldLicenciaswcwc) == 0 ) || ( GXutil.strcmp(OldLicenciaswcwc, WebComp_Licenciaswcwc_Component) != 0 ) )
                        {
                           WebComp_Licenciaswcwc = WebUtils.getWebComponent(getClass(), "web." + OldLicenciaswcwc + "_impl", remoteHandle, context);
                           WebComp_Licenciaswcwc_Component = OldLicenciaswcwc ;
                        }
                        if ( GXutil.len( WebComp_Licenciaswcwc_Component) != 0 )
                        {
                           WebComp_Licenciaswcwc.componentprocess(sPrefix+"W0042", "", sEvt);
                        }
                        WebComp_Licenciaswcwc_Component = OldLicenciaswcwc ;
                     }
                     else if ( nCmpId == 50 )
                     {
                        OldFamiliawcwc = httpContext.cgiGet( sPrefix+"W0050") ;
                        if ( ( GXutil.len( OldFamiliawcwc) == 0 ) || ( GXutil.strcmp(OldFamiliawcwc, WebComp_Familiawcwc_Component) != 0 ) )
                        {
                           WebComp_Familiawcwc = WebUtils.getWebComponent(getClass(), "web." + OldFamiliawcwc + "_impl", remoteHandle, context);
                           WebComp_Familiawcwc_Component = OldFamiliawcwc ;
                        }
                        if ( GXutil.len( WebComp_Familiawcwc_Component) != 0 )
                        {
                           WebComp_Familiawcwc.componentprocess(sPrefix+"W0050", "", sEvt);
                        }
                        WebComp_Familiawcwc_Component = OldFamiliawcwc ;
                     }
                     else if ( nCmpId == 58 )
                     {
                        OldCodededuccionessolapa2wc = httpContext.cgiGet( sPrefix+"W0058") ;
                        if ( ( GXutil.len( OldCodededuccionessolapa2wc) == 0 ) || ( GXutil.strcmp(OldCodededuccionessolapa2wc, WebComp_Codededuccionessolapa2wc_Component) != 0 ) )
                        {
                           WebComp_Codededuccionessolapa2wc = WebUtils.getWebComponent(getClass(), "web." + OldCodededuccionessolapa2wc + "_impl", remoteHandle, context);
                           WebComp_Codededuccionessolapa2wc_Component = OldCodededuccionessolapa2wc ;
                        }
                        if ( GXutil.len( WebComp_Codededuccionessolapa2wc_Component) != 0 )
                        {
                           WebComp_Codededuccionessolapa2wc.componentprocess(sPrefix+"W0058", "", sEvt);
                        }
                        WebComp_Codededuccionessolapa2wc_Component = OldCodededuccionessolapa2wc ;
                     }
                     else if ( nCmpId == 66 )
                     {
                        OldLiquidacioneswcwc = httpContext.cgiGet( sPrefix+"W0066") ;
                        if ( ( GXutil.len( OldLiquidacioneswcwc) == 0 ) || ( GXutil.strcmp(OldLiquidacioneswcwc, WebComp_Liquidacioneswcwc_Component) != 0 ) )
                        {
                           WebComp_Liquidacioneswcwc = WebUtils.getWebComponent(getClass(), "web." + OldLiquidacioneswcwc + "_impl", remoteHandle, context);
                           WebComp_Liquidacioneswcwc_Component = OldLiquidacioneswcwc ;
                        }
                        if ( GXutil.len( WebComp_Liquidacioneswcwc_Component) != 0 )
                        {
                           WebComp_Liquidacioneswcwc.componentprocess(sPrefix+"W0066", "", sEvt);
                        }
                        WebComp_Liquidacioneswcwc_Component = OldLiquidacioneswcwc ;
                     }
                     else if ( nCmpId == 74 )
                     {
                        OldGanancias_prorrateoswc = httpContext.cgiGet( sPrefix+"W0074") ;
                        if ( ( GXutil.len( OldGanancias_prorrateoswc) == 0 ) || ( GXutil.strcmp(OldGanancias_prorrateoswc, WebComp_Ganancias_prorrateoswc_Component) != 0 ) )
                        {
                           WebComp_Ganancias_prorrateoswc = WebUtils.getWebComponent(getClass(), "web." + OldGanancias_prorrateoswc + "_impl", remoteHandle, context);
                           WebComp_Ganancias_prorrateoswc_Component = OldGanancias_prorrateoswc ;
                        }
                        if ( GXutil.len( WebComp_Ganancias_prorrateoswc_Component) != 0 )
                        {
                           WebComp_Ganancias_prorrateoswc.componentprocess(sPrefix+"W0074", "", sEvt);
                        }
                        WebComp_Ganancias_prorrateoswc_Component = OldGanancias_prorrateoswc ;
                     }
                     else if ( nCmpId == 82 )
                     {
                        OldObligacioneswc = httpContext.cgiGet( sPrefix+"W0082") ;
                        if ( ( GXutil.len( OldObligacioneswc) == 0 ) || ( GXutil.strcmp(OldObligacioneswc, WebComp_Obligacioneswc_Component) != 0 ) )
                        {
                           WebComp_Obligacioneswc = WebUtils.getWebComponent(getClass(), "web." + OldObligacioneswc + "_impl", remoteHandle, context);
                           WebComp_Obligacioneswc_Component = OldObligacioneswc ;
                        }
                        if ( GXutil.len( WebComp_Obligacioneswc_Component) != 0 )
                        {
                           WebComp_Obligacioneswc.componentprocess(sPrefix+"W0082", "", sEvt);
                        }
                        WebComp_Obligacioneswc_Component = OldObligacioneswc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weJR2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormJR2( ) ;
         }
      }
   }

   public void paJR2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
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
      rfJR2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV25Pgmname = "LegajosView" ;
      Gx_err = (short)(0) ;
   }

   public void rfJR2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Wcbienvenidalegajo_Component) != 0 )
            {
               WebComp_Wcbienvenidalegajo.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Legajoabmwc_Component) != 0 )
            {
               WebComp_Legajoabmwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Horaswcwc_Component) != 0 )
            {
               WebComp_Horaswcwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Licenciaswcwc_Component) != 0 )
            {
               WebComp_Licenciaswcwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Familiawcwc_Component) != 0 )
            {
               WebComp_Familiawcwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Codededuccionessolapa2wc_Component) != 0 )
            {
               WebComp_Codededuccionessolapa2wc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Liquidacioneswcwc_Component) != 0 )
            {
               WebComp_Liquidacioneswcwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Ganancias_prorrateoswc_Component) != 0 )
            {
               WebComp_Ganancias_prorrateoswc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Obligacioneswc_Component) != 0 )
            {
               WebComp_Obligacioneswc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e13JR2 ();
         wbJR0( ) ;
      }
   }

   public void send_integrity_lvl_hashesJR2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV25Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV25Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vEXISTS", AV9Exists);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEXISTS", getSecureSignedToken( sPrefix, AV9Exists));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODOPALABRA", GXutil.rtrim( AV19modoPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMODOPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV19modoPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPALABRA", GXutil.rtrim( AV22palabra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV22palabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENUOPCCOD", AV21MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMENUOPCCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV21MenuOpcCod, ""))));
   }

   public void before_start_formulas( )
   {
      AV25Pgmname = "LegajosView" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupJR0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12JR2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV10CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV13LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV13LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV8TabCode = httpContext.cgiGet( sPrefix+"wcpOAV8TabCode") ;
         Tabs_Activepagecontrolname = httpContext.cgiGet( sPrefix+"TABS_Activepagecontrolname") ;
         Tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Tabs_Class = httpContext.cgiGet( sPrefix+"TABS_Class") ;
         Tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( sPrefix+"TABS_Historymanagement")) ;
         Tabs_Activepagecontrolname = httpContext.cgiGet( sPrefix+"TABS_Activepagecontrolname") ;
         /* Read variables values. */
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e12JR2 ();
      if (returnInSub) return;
   }

   public void e12JR2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV19modoPalabra = AV20websession.getValue(httpContext.getMessage( "MODO_LEGAJO", "")) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19modoPalabra", AV19modoPalabra);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMODOPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV19modoPalabra, ""))));
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "start &modoPalabra ", "")+AV19modoPalabra+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV11EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV13LegNumero, 8, 0))) ;
      AV26GXLvl11 = (byte)(0) ;
      /* Using cursor H00JR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV13LegNumero), Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV13LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = H00JR2_A6LegNumero[0] ;
         A1EmpCod = H00JR2_A1EmpCod[0] ;
         A3CliCod = H00JR2_A3CliCod[0] ;
         AV26GXLvl11 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "existe", "")) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV26GXLvl11 == 0 )
      {
         divLayoutmaintable_Class = divLayoutmaintable_Class+" Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
         AV9Exists = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9Exists", AV9Exists);
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEXISTS", getSecureSignedToken( sPrefix, AV9Exists));
         new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "no existe", "")) ;
      }
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      AV27GXLvl25 = (byte)(0) ;
      /* Using cursor H00JR3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV13LegNumero), Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV13LegNumero)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A6LegNumero = H00JR3_A6LegNumero[0] ;
         A1EmpCod = H00JR3_A1EmpCod[0] ;
         A3CliCod = H00JR3_A3CliCod[0] ;
         AV27GXLvl25 = (byte)(1) ;
         AV9Exists = true ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9Exists", AV9Exists);
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEXISTS", getSecureSignedToken( sPrefix, AV9Exists));
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      if ( AV27GXLvl25 == 0 )
      {
         divLayoutmaintable_Class = divLayoutmaintable_Class+" Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
         AV9Exists = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9Exists", AV9Exists);
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEXISTS", getSecureSignedToken( sPrefix, AV9Exists));
      }
      if ( AV9Exists )
      {
         AV15SelectedTabCode = AV8TabCode ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15SelectedTabCode", AV15SelectedTabCode);
         Tabs_Activepagecontrolname = AV15SelectedTabCode ;
         ucTabs.sendProperty(context, sPrefix, false, Tabs_Internalname, "ActivePageControlName", Tabs_Activepagecontrolname);
         /* Execute user subroutine: 'LOADTABS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Object Property */
      if ( GXutil.len( sPrefix) == 0 )
      {
         bDynCreated_Wcbienvenidalegajo = true ;
      }
      if ( GXutil.strcmp(GXutil.lower( WebComp_Wcbienvenidalegajo_Component), GXutil.lower( "BienvenidaLegajo")) != 0 )
      {
         WebComp_Wcbienvenidalegajo = WebUtils.getWebComponent(getClass(), "web.bienvenidalegajo_impl", remoteHandle, context);
         WebComp_Wcbienvenidalegajo_Component = "BienvenidaLegajo" ;
      }
      if ( GXutil.len( WebComp_Wcbienvenidalegajo_Component) != 0 )
      {
         WebComp_Wcbienvenidalegajo.setjustcreated();
         WebComp_Wcbienvenidalegajo.componentprepare(new Object[] {sPrefix+"W0012","",AV19modoPalabra});
         WebComp_Wcbienvenidalegajo.componentbind(new Object[] {""});
      }
      if ( ! AV9Exists )
      {
         divLayoutmaintable_Class = divLayoutmaintable_Class+httpContext.getMessage( "FormSplitScreen", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
         Tabs_Activepagecontrolname = AV8TabCode ;
         ucTabs.sendProperty(context, sPrefix, false, Tabs_Internalname, "ActivePageControlName", Tabs_Activepagecontrolname);
         /* Execute user subroutine: 'LOADTABS' */
         S112 ();
         if (returnInSub) return;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e13JR2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void e11JR2( )
   {
      /* Tabs_Tabchanged Routine */
      returnInSub = false ;
      AV15SelectedTabCode = Tabs_Activepagecontrolname ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15SelectedTabCode", AV15SelectedTabCode);
      AV14LoadAllTabs = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14LoadAllTabs", AV14LoadAllTabs);
      /* Execute user subroutine: 'LOADTABS' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADTABS' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "loadtabs 1", "")) ;
      tblTblbienve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblbienve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblbienve_Visible), 5, 0), true);
      if ( ! AV9Exists )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "loadtabs 2", "")) ;
         if ( (GXutil.strcmp("", AV8TabCode)==0) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "loadtabs 3", "")) ;
            divUnnamedtableviewcontainer_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divUnnamedtableviewcontainer_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divUnnamedtableviewcontainer_Visible), 5, 0), true);
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "loadtabs 4", "")) ;
            /* Object Property */
            if ( GXutil.len( sPrefix) == 0 )
            {
               bDynCreated_Legajoabmwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Legajoabmwc_Component), GXutil.lower( "LegajoABM")) != 0 )
            {
               WebComp_Legajoabmwc = WebUtils.getWebComponent(getClass(), "web.legajoabm_impl", remoteHandle, context);
               WebComp_Legajoabmwc_Component = "LegajoABM" ;
            }
            if ( GXutil.len( WebComp_Legajoabmwc_Component) != 0 )
            {
               WebComp_Legajoabmwc.setjustcreated();
               WebComp_Legajoabmwc.componentprepare(new Object[] {sPrefix+"W0026","",httpContext.getMessage( "INS", ""),Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(0),""});
               WebComp_Legajoabmwc.componentbind(new Object[] {""+""+"","","","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Legajoabmwc )
            {
               httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0026"+"");
               WebComp_Legajoabmwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "loadtabs 5 &LoadAllTabs ", "")+GXutil.trim( GXutil.booltostr( AV14LoadAllTabs))+httpContext.getMessage( " &SelectedTabCode ", "")+GXutil.trim( AV15SelectedTabCode)) ;
         /* Using cursor H00JR4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV13LegNumero), Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV13LegNumero)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A6LegNumero = H00JR4_A6LegNumero[0] ;
            A1EmpCod = H00JR4_A1EmpCod[0] ;
            A3CliCod = H00JR4_A3CliCod[0] ;
            GXt_boolean2 = AV16TempBoolean ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( "LegajoABM", GXv_boolean3) ;
            legajosview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            AV16TempBoolean = GXt_boolean2 ;
            if ( AV16TempBoolean )
            {
               if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV15SelectedTabCode, "LegajoABM") == 0 ) )
               {
                  /* Object Property */
                  if ( GXutil.len( sPrefix) == 0 )
                  {
                     bDynCreated_Legajoabmwc = true ;
                  }
                  if ( GXutil.strcmp(GXutil.lower( WebComp_Legajoabmwc_Component), GXutil.lower( "LegajoABM")) != 0 )
                  {
                     WebComp_Legajoabmwc = WebUtils.getWebComponent(getClass(), "web.legajoabm_impl", remoteHandle, context);
                     WebComp_Legajoabmwc_Component = "LegajoABM" ;
                  }
                  if ( GXutil.len( WebComp_Legajoabmwc_Component) != 0 )
                  {
                     WebComp_Legajoabmwc.setjustcreated();
                     WebComp_Legajoabmwc.componentprepare(new Object[] {sPrefix+"W0026","",AV19modoPalabra,Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV13LegNumero),AV22palabra});
                     WebComp_Legajoabmwc.componentbind(new Object[] {"","","","",""});
                  }
                  if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Legajoabmwc )
                  {
                     httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0026"+"");
                     WebComp_Legajoabmwc.componentdraw();
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            else
            {
               this.executeUsercontrolMethod(sPrefix, false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(1)});
            }
            GXt_boolean2 = AV16TempBoolean ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAgendaNovedades", GXv_boolean3) ;
            legajosview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            AV16TempBoolean = GXt_boolean2 ;
            if ( AV16TempBoolean )
            {
               if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "horasWC") == 0 ) )
               {
                  /* Object Property */
                  if ( GXutil.len( sPrefix) == 0 )
                  {
                     bDynCreated_Horaswcwc = true ;
                  }
                  if ( GXutil.strcmp(GXutil.lower( WebComp_Horaswcwc_Component), GXutil.lower( "horasWC")) != 0 )
                  {
                     WebComp_Horaswcwc = WebUtils.getWebComponent(getClass(), "web.horaswc_impl", remoteHandle, context);
                     WebComp_Horaswcwc_Component = "horasWC" ;
                  }
                  if ( GXutil.len( WebComp_Horaswcwc_Component) != 0 )
                  {
                     WebComp_Horaswcwc.setjustcreated();
                     WebComp_Horaswcwc.componentprepare(new Object[] {sPrefix+"W0034","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV13LegNumero)});
                     WebComp_Horaswcwc.componentbind(new Object[] {"","",""});
                  }
                  if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Horaswcwc )
                  {
                     httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0034"+"");
                     WebComp_Horaswcwc.componentdraw();
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            else
            {
               this.executeUsercontrolMethod(sPrefix, false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(2)});
            }
            GXt_boolean2 = AV16TempBoolean ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajoLicencias", GXv_boolean3) ;
            legajosview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            AV16TempBoolean = GXt_boolean2 ;
            if ( AV16TempBoolean )
            {
               if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "licenciasWC") == 0 ) )
               {
                  /* Object Property */
                  if ( GXutil.len( sPrefix) == 0 )
                  {
                     bDynCreated_Licenciaswcwc = true ;
                  }
                  if ( GXutil.strcmp(GXutil.lower( WebComp_Licenciaswcwc_Component), GXutil.lower( "licenciasWC")) != 0 )
                  {
                     WebComp_Licenciaswcwc = WebUtils.getWebComponent(getClass(), "web.licenciaswc_impl", remoteHandle, context);
                     WebComp_Licenciaswcwc_Component = "licenciasWC" ;
                  }
                  if ( GXutil.len( WebComp_Licenciaswcwc_Component) != 0 )
                  {
                     WebComp_Licenciaswcwc.setjustcreated();
                     WebComp_Licenciaswcwc.componentprepare(new Object[] {sPrefix+"W0042","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV13LegNumero)});
                     WebComp_Licenciaswcwc.componentbind(new Object[] {"","",""});
                  }
                  if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Licenciaswcwc )
                  {
                     httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0042"+"");
                     WebComp_Licenciaswcwc.componentdraw();
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            else
            {
               this.executeUsercontrolMethod(sPrefix, false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(3)});
            }
            if ( false )
            {
               if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "familiaWC") == 0 ) )
               {
                  /* Object Property */
                  if ( GXutil.len( sPrefix) == 0 )
                  {
                     bDynCreated_Familiawcwc = true ;
                  }
                  if ( GXutil.strcmp(GXutil.lower( WebComp_Familiawcwc_Component), GXutil.lower( "familiaWC")) != 0 )
                  {
                     WebComp_Familiawcwc = WebUtils.getWebComponent(getClass(), "web.familiawc_impl", remoteHandle, context);
                     WebComp_Familiawcwc_Component = "familiaWC" ;
                  }
                  if ( GXutil.len( WebComp_Familiawcwc_Component) != 0 )
                  {
                     WebComp_Familiawcwc.setjustcreated();
                     WebComp_Familiawcwc.componentprepare(new Object[] {sPrefix+"W0050","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV13LegNumero)});
                     WebComp_Familiawcwc.componentbind(new Object[] {"","",""});
                  }
                  if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Familiawcwc )
                  {
                     httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0050"+"");
                     WebComp_Familiawcwc.componentdraw();
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            else
            {
               this.executeUsercontrolMethod(sPrefix, false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(4)});
            }
            GXt_boolean2 = AV16TempBoolean ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWdeduccionesSolapa", GXv_boolean3) ;
            legajosview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            AV16TempBoolean = GXt_boolean2 ;
            if ( AV16TempBoolean )
            {
               if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "CodeDeduccionesSolapa2") == 0 ) )
               {
                  /* Object Property */
                  if ( GXutil.len( sPrefix) == 0 )
                  {
                     bDynCreated_Codededuccionessolapa2wc = true ;
                  }
                  if ( GXutil.strcmp(GXutil.lower( WebComp_Codededuccionessolapa2wc_Component), GXutil.lower( "CompDeduccionesSolapa2")) != 0 )
                  {
                     WebComp_Codededuccionessolapa2wc = WebUtils.getWebComponent(getClass(), "web.compdeduccionessolapa2_impl", remoteHandle, context);
                     WebComp_Codededuccionessolapa2wc_Component = "CompDeduccionesSolapa2" ;
                  }
                  if ( GXutil.len( WebComp_Codededuccionessolapa2wc_Component) != 0 )
                  {
                     WebComp_Codededuccionessolapa2wc.setjustcreated();
                     WebComp_Codededuccionessolapa2wc.componentprepare(new Object[] {sPrefix+"W0058","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV13LegNumero)});
                     WebComp_Codededuccionessolapa2wc.componentbind(new Object[] {"","",""});
                  }
                  if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Codededuccionessolapa2wc )
                  {
                     httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0058"+"");
                     WebComp_Codededuccionessolapa2wc.componentdraw();
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            else
            {
               this.executeUsercontrolMethod(sPrefix, false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(5)});
            }
            if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "liquidacionesWC") == 0 ) )
            {
               /* Object Property */
               if ( GXutil.len( sPrefix) == 0 )
               {
                  bDynCreated_Liquidacioneswcwc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Liquidacioneswcwc_Component), GXutil.lower( "liquidacionesWC")) != 0 )
               {
                  WebComp_Liquidacioneswcwc = WebUtils.getWebComponent(getClass(), "web.liquidacioneswc_impl", remoteHandle, context);
                  WebComp_Liquidacioneswcwc_Component = "liquidacionesWC" ;
               }
               if ( GXutil.len( WebComp_Liquidacioneswcwc_Component) != 0 )
               {
                  WebComp_Liquidacioneswcwc.setjustcreated();
                  WebComp_Liquidacioneswcwc.componentprepare(new Object[] {sPrefix+"W0066","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV13LegNumero)});
                  WebComp_Liquidacioneswcwc.componentbind(new Object[] {"","",""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Liquidacioneswcwc )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0066"+"");
                  WebComp_Liquidacioneswcwc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
            GXt_boolean2 = AV16TempBoolean ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "ganancias_prorrateos", GXv_boolean3) ;
            legajosview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            AV16TempBoolean = GXt_boolean2 ;
            if ( AV16TempBoolean )
            {
               if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "ganancias_prorrateos") == 0 ) )
               {
                  /* Object Property */
                  if ( GXutil.len( sPrefix) == 0 )
                  {
                     bDynCreated_Ganancias_prorrateoswc = true ;
                  }
                  if ( GXutil.strcmp(GXutil.lower( WebComp_Ganancias_prorrateoswc_Component), GXutil.lower( "ganancias_prorrateos")) != 0 )
                  {
                     WebComp_Ganancias_prorrateoswc = WebUtils.getWebComponent(getClass(), "web.ganancias_prorrateos_impl", remoteHandle, context);
                     WebComp_Ganancias_prorrateoswc_Component = "ganancias_prorrateos" ;
                  }
                  if ( GXutil.len( WebComp_Ganancias_prorrateoswc_Component) != 0 )
                  {
                     WebComp_Ganancias_prorrateoswc.setjustcreated();
                     WebComp_Ganancias_prorrateoswc.componentprepare(new Object[] {sPrefix+"W0074","",AV21MenuOpcCod,Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV13LegNumero)});
                     WebComp_Ganancias_prorrateoswc.componentbind(new Object[] {"","","",""});
                  }
                  if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Ganancias_prorrateoswc )
                  {
                     httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0074"+"");
                     WebComp_Ganancias_prorrateoswc.componentdraw();
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            else
            {
               this.executeUsercontrolMethod(sPrefix, false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(7)});
            }
            GXt_boolean2 = AV16TempBoolean ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( "obligaciones", GXv_boolean3) ;
            legajosview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            AV16TempBoolean = GXt_boolean2 ;
            if ( AV16TempBoolean )
            {
               if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "obligaciones") == 0 ) )
               {
                  /* Object Property */
                  if ( GXutil.len( sPrefix) == 0 )
                  {
                     bDynCreated_Obligacioneswc = true ;
                  }
                  if ( GXutil.strcmp(GXutil.lower( WebComp_Obligacioneswc_Component), GXutil.lower( "obligaciones")) != 0 )
                  {
                     WebComp_Obligacioneswc = WebUtils.getWebComponent(getClass(), "web.obligaciones_impl", remoteHandle, context);
                     WebComp_Obligacioneswc_Component = "obligaciones" ;
                  }
                  if ( GXutil.len( WebComp_Obligacioneswc_Component) != 0 )
                  {
                     WebComp_Obligacioneswc.setjustcreated();
                     WebComp_Obligacioneswc.componentprepare(new Object[] {sPrefix+"W0082","",AV21MenuOpcCod,Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV13LegNumero)});
                     WebComp_Obligacioneswc.componentbind(new Object[] {"","","",""});
                  }
                  if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Obligacioneswc )
                  {
                     httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0082"+"");
                     WebComp_Obligacioneswc.componentdraw();
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            else
            {
               this.executeUsercontrolMethod(sPrefix, false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(8)});
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
      }
   }

   public void wb_table1_9_JR2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTblbienve_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTblbienve_Internalname, tblTblbienve_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0012"+"", GXutil.rtrim( WebComp_Wcbienvenidalegajo_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0012"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Wcbienvenidalegajo_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldWcbienvenidalegajo), GXutil.lower( WebComp_Wcbienvenidalegajo_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0012"+"");
               }
               WebComp_Wcbienvenidalegajo.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldWcbienvenidalegajo), GXutil.lower( WebComp_Wcbienvenidalegajo_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_JR2e( true) ;
      }
      else
      {
         wb_table1_9_JR2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CliCod), 6, 0));
      AV11EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
      AV13LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      AV8TabCode = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8TabCode", AV8TabCode);
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
      paJR2( ) ;
      wsJR2( ) ;
      weJR2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlAV10CliCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV11EmpCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV13LegNumero = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV8TabCode = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paJR2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "legajosview", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paJR2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV10CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CliCod), 6, 0));
         AV11EmpCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
         AV13LegNumero = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
         AV8TabCode = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8TabCode", AV8TabCode);
      }
      wcpOAV10CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV13LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV13LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV8TabCode = httpContext.cgiGet( sPrefix+"wcpOAV8TabCode") ;
      if ( ! GetJustCreated( ) && ( ( AV10CliCod != wcpOAV10CliCod ) || ( AV11EmpCod != wcpOAV11EmpCod ) || ( AV13LegNumero != wcpOAV13LegNumero ) || ( GXutil.strcmp(AV8TabCode, wcpOAV8TabCode) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV10CliCod = AV10CliCod ;
      wcpOAV11EmpCod = AV11EmpCod ;
      wcpOAV13LegNumero = AV13LegNumero ;
      wcpOAV8TabCode = AV8TabCode ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV10CliCod = httpContext.cgiGet( sPrefix+"AV10CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV10CliCod) > 0 )
      {
         AV10CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV10CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CliCod), 6, 0));
      }
      else
      {
         AV10CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV10CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV11EmpCod = httpContext.cgiGet( sPrefix+"AV11EmpCod_CTRL") ;
      if ( GXutil.len( sCtrlAV11EmpCod) > 0 )
      {
         AV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV11EmpCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
      }
      else
      {
         AV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV11EmpCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV13LegNumero = httpContext.cgiGet( sPrefix+"AV13LegNumero_CTRL") ;
      if ( GXutil.len( sCtrlAV13LegNumero) > 0 )
      {
         AV13LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV13LegNumero), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      }
      else
      {
         AV13LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV13LegNumero_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV8TabCode = httpContext.cgiGet( sPrefix+"AV8TabCode_CTRL") ;
      if ( GXutil.len( sCtrlAV8TabCode) > 0 )
      {
         AV8TabCode = httpContext.cgiGet( sCtrlAV8TabCode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8TabCode", AV8TabCode);
      }
      else
      {
         AV8TabCode = httpContext.cgiGet( sPrefix+"AV8TabCode_PARM") ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      paJR2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsJR2( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wsJR2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV10CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10CliCod_CTRL", GXutil.rtrim( sCtrlAV10CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11EmpCod_PARM", GXutil.ltrim( localUtil.ntoc( AV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV11EmpCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11EmpCod_CTRL", GXutil.rtrim( sCtrlAV11EmpCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV13LegNumero_PARM", GXutil.ltrim( localUtil.ntoc( AV13LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV13LegNumero)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV13LegNumero_CTRL", GXutil.rtrim( sCtrlAV13LegNumero));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8TabCode_PARM", GXutil.rtrim( AV8TabCode));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV8TabCode)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8TabCode_CTRL", GXutil.rtrim( sCtrlAV8TabCode));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      weJR2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
      if ( ! ( WebComp_Wcbienvenidalegajo == null ) )
      {
         WebComp_Wcbienvenidalegajo.componentjscripts();
      }
      if ( ! ( WebComp_Legajoabmwc == null ) )
      {
         WebComp_Legajoabmwc.componentjscripts();
      }
      if ( ! ( WebComp_Horaswcwc == null ) )
      {
         WebComp_Horaswcwc.componentjscripts();
      }
      if ( ! ( WebComp_Licenciaswcwc == null ) )
      {
         WebComp_Licenciaswcwc.componentjscripts();
      }
      if ( ! ( WebComp_Familiawcwc == null ) )
      {
         WebComp_Familiawcwc.componentjscripts();
      }
      if ( ! ( WebComp_Codededuccionessolapa2wc == null ) )
      {
         WebComp_Codededuccionessolapa2wc.componentjscripts();
      }
      if ( ! ( WebComp_Liquidacioneswcwc == null ) )
      {
         WebComp_Liquidacioneswcwc.componentjscripts();
      }
      if ( ! ( WebComp_Ganancias_prorrateoswc == null ) )
      {
         WebComp_Ganancias_prorrateoswc.componentjscripts();
      }
      if ( ! ( WebComp_Obligacioneswc == null ) )
      {
         WebComp_Obligacioneswc.componentjscripts();
      }
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Wcbienvenidalegajo == null ) )
      {
         if ( GXutil.len( WebComp_Wcbienvenidalegajo_Component) != 0 )
         {
            WebComp_Wcbienvenidalegajo.componentthemes();
         }
      }
      if ( ! ( WebComp_Legajoabmwc == null ) )
      {
         if ( GXutil.len( WebComp_Legajoabmwc_Component) != 0 )
         {
            WebComp_Legajoabmwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Horaswcwc == null ) )
      {
         if ( GXutil.len( WebComp_Horaswcwc_Component) != 0 )
         {
            WebComp_Horaswcwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Licenciaswcwc == null ) )
      {
         if ( GXutil.len( WebComp_Licenciaswcwc_Component) != 0 )
         {
            WebComp_Licenciaswcwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Familiawcwc == null ) )
      {
         if ( GXutil.len( WebComp_Familiawcwc_Component) != 0 )
         {
            WebComp_Familiawcwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Codededuccionessolapa2wc == null ) )
      {
         if ( GXutil.len( WebComp_Codededuccionessolapa2wc_Component) != 0 )
         {
            WebComp_Codededuccionessolapa2wc.componentthemes();
         }
      }
      if ( ! ( WebComp_Liquidacioneswcwc == null ) )
      {
         if ( GXutil.len( WebComp_Liquidacioneswcwc_Component) != 0 )
         {
            WebComp_Liquidacioneswcwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Ganancias_prorrateoswc == null ) )
      {
         if ( GXutil.len( WebComp_Ganancias_prorrateoswc_Component) != 0 )
         {
            WebComp_Ganancias_prorrateoswc.componentthemes();
         }
      }
      if ( ! ( WebComp_Obligacioneswc == null ) )
      {
         if ( GXutil.len( WebComp_Obligacioneswc_Component) != 0 )
         {
            WebComp_Obligacioneswc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171347428", true, true);
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
      httpContext.AddJavascriptSource("legajosview.js", "?2025171347428", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      tblTblbienve_Internalname = sPrefix+"TBLBIENVE" ;
      lblLegajoabm_title_Internalname = sPrefix+"LEGAJOABM_TITLE" ;
      divUnnamedtablelegajoabm_Internalname = sPrefix+"UNNAMEDTABLELEGAJOABM" ;
      lblHoraswc_title_Internalname = sPrefix+"HORASWC_TITLE" ;
      divUnnamedtablehoraswc_Internalname = sPrefix+"UNNAMEDTABLEHORASWC" ;
      lblLicenciaswc_title_Internalname = sPrefix+"LICENCIASWC_TITLE" ;
      divUnnamedtablelicenciaswc_Internalname = sPrefix+"UNNAMEDTABLELICENCIASWC" ;
      lblFamiliawc_title_Internalname = sPrefix+"FAMILIAWC_TITLE" ;
      divUnnamedtablefamiliawc_Internalname = sPrefix+"UNNAMEDTABLEFAMILIAWC" ;
      lblCodededuccionessolapa2_title_Internalname = sPrefix+"CODEDEDUCCIONESSOLAPA2_TITLE" ;
      divUnnamedtablecodededuccionessolapa2_Internalname = sPrefix+"UNNAMEDTABLECODEDEDUCCIONESSOLAPA2" ;
      lblLiquidacioneswc_title_Internalname = sPrefix+"LIQUIDACIONESWC_TITLE" ;
      divUnnamedtableliquidacioneswc_Internalname = sPrefix+"UNNAMEDTABLELIQUIDACIONESWC" ;
      lblGanancias_prorrateos_title_Internalname = sPrefix+"GANANCIAS_PRORRATEOS_TITLE" ;
      divUnnamedtableganancias_prorrateos_Internalname = sPrefix+"UNNAMEDTABLEGANANCIAS_PRORRATEOS" ;
      lblObligaciones_title_Internalname = sPrefix+"OBLIGACIONES_TITLE" ;
      divUnnamedtableobligaciones_Internalname = sPrefix+"UNNAMEDTABLEOBLIGACIONES" ;
      Tabs_Internalname = sPrefix+"TABS" ;
      divUnnamedtableviewcontainer_Internalname = sPrefix+"UNNAMEDTABLEVIEWCONTAINER" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      tblTblbienve_Visible = 1 ;
      divUnnamedtableviewcontainer_Visible = 1 ;
      divLayoutmaintable_Class = "Table" ;
      Tabs_Historymanagement = GXutil.toBoolean( -1) ;
      Tabs_Class = "ViewTab Tab" ;
      Tabs_Pagecount = 8 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV25Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV9Exists',fld:'vEXISTS',pic:'',hsh:true},{av:'AV19modoPalabra',fld:'vMODOPALABRA',pic:'',hsh:true},{av:'AV22palabra',fld:'vPALABRA',pic:'',hsh:true},{av:'AV21MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("TABS.TABCHANGED","{handler:'e11JR2',iparms:[{av:'Tabs_Activepagecontrolname',ctrl:'TABS',prop:'ActivePageControlName'},{av:'AV25Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV9Exists',fld:'vEXISTS',pic:'',hsh:true},{av:'AV8TabCode',fld:'vTABCODE',pic:''},{av:'AV10CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV14LoadAllTabs',fld:'vLOADALLTABS',pic:''},{av:'AV15SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV19modoPalabra',fld:'vMODOPALABRA',pic:'',hsh:true},{av:'AV22palabra',fld:'vPALABRA',pic:'',hsh:true},{av:'AV21MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("TABS.TABCHANGED",",oparms:[{av:'AV15SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'AV14LoadAllTabs',fld:'vLOADALLTABS',pic:''},{av:'tblTblbienve_Visible',ctrl:'TBLBIENVE',prop:'Visible'},{av:'divUnnamedtableviewcontainer_Visible',ctrl:'UNNAMEDTABLEVIEWCONTAINER',prop:'Visible'},{ctrl:'LEGAJOABMWC'},{ctrl:'HORASWCWC'},{ctrl:'LICENCIASWCWC'},{ctrl:'FAMILIAWCWC'},{ctrl:'CODEDEDUCCIONESSOLAPA2WC'},{ctrl:'LIQUIDACIONESWCWC'},{ctrl:'GANANCIAS_PRORRATEOSWC'},{ctrl:'OBLIGACIONESWC'}]}");
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
      wcpOAV8TabCode = "" ;
      Tabs_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV8TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV25Pgmname = "" ;
      AV19modoPalabra = "" ;
      AV22palabra = "" ;
      AV21MenuOpcCod = "" ;
      GXKey = "" ;
      AV15SelectedTabCode = "" ;
      GX_FocusControl = "" ;
      ucTabs = new com.genexus.webpanels.GXUserControl();
      lblLegajoabm_title_Jsonclick = "" ;
      WebComp_Legajoabmwc_Component = "" ;
      OldLegajoabmwc = "" ;
      lblHoraswc_title_Jsonclick = "" ;
      WebComp_Horaswcwc_Component = "" ;
      OldHoraswcwc = "" ;
      lblLicenciaswc_title_Jsonclick = "" ;
      WebComp_Licenciaswcwc_Component = "" ;
      OldLicenciaswcwc = "" ;
      lblFamiliawc_title_Jsonclick = "" ;
      WebComp_Familiawcwc_Component = "" ;
      OldFamiliawcwc = "" ;
      lblCodededuccionessolapa2_title_Jsonclick = "" ;
      WebComp_Codededuccionessolapa2wc_Component = "" ;
      OldCodededuccionessolapa2wc = "" ;
      lblLiquidacioneswc_title_Jsonclick = "" ;
      WebComp_Liquidacioneswcwc_Component = "" ;
      OldLiquidacioneswcwc = "" ;
      lblGanancias_prorrateos_title_Jsonclick = "" ;
      WebComp_Ganancias_prorrateoswc_Component = "" ;
      OldGanancias_prorrateoswc = "" ;
      lblObligaciones_title_Jsonclick = "" ;
      WebComp_Obligacioneswc_Component = "" ;
      OldObligacioneswc = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldWcbienvenidalegajo = "" ;
      WebComp_Wcbienvenidalegajo_Component = "" ;
      AV20websession = httpContext.getWebSession();
      scmdbuf = "" ;
      H00JR2_A6LegNumero = new int[1] ;
      H00JR2_A1EmpCod = new short[1] ;
      H00JR2_A3CliCod = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      H00JR3_A6LegNumero = new int[1] ;
      H00JR3_A1EmpCod = new short[1] ;
      H00JR3_A3CliCod = new int[1] ;
      H00JR4_A6LegNumero = new int[1] ;
      H00JR4_A1EmpCod = new short[1] ;
      H00JR4_A3CliCod = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      sStyleString = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV10CliCod = "" ;
      sCtrlAV11EmpCod = "" ;
      sCtrlAV13LegNumero = "" ;
      sCtrlAV8TabCode = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajosview__default(),
         new Object[] {
             new Object[] {
            H00JR2_A6LegNumero, H00JR2_A1EmpCod, H00JR2_A3CliCod
            }
            , new Object[] {
            H00JR3_A6LegNumero, H00JR3_A1EmpCod, H00JR3_A3CliCod
            }
            , new Object[] {
            H00JR4_A6LegNumero, H00JR4_A1EmpCod, H00JR4_A3CliCod
            }
         }
      );
      AV25Pgmname = "LegajosView" ;
      /* GeneXus formulas. */
      AV25Pgmname = "LegajosView" ;
      Gx_err = (short)(0) ;
      WebComp_Wcbienvenidalegajo = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Legajoabmwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Horaswcwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Licenciaswcwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Familiawcwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Codededuccionessolapa2wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Liquidacioneswcwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Ganancias_prorrateoswc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Obligacioneswc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte AV26GXLvl11 ;
   private byte AV27GXLvl25 ;
   private byte nGXWrapped ;
   private short wcpOAV11EmpCod ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV10CliCod ;
   private int wcpOAV13LegNumero ;
   private int AV10CliCod ;
   private int AV13LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int Tabs_Pagecount ;
   private int divUnnamedtableviewcontainer_Visible ;
   private int tblTblbienve_Visible ;
   private int idxLst ;
   private String wcpOAV8TabCode ;
   private String Tabs_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV8TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV25Pgmname ;
   private String AV19modoPalabra ;
   private String AV22palabra ;
   private String GXKey ;
   private String AV15SelectedTabCode ;
   private String Tabs_Class ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String Tabs_Internalname ;
   private String lblLegajoabm_title_Internalname ;
   private String lblLegajoabm_title_Jsonclick ;
   private String divUnnamedtablelegajoabm_Internalname ;
   private String WebComp_Legajoabmwc_Component ;
   private String OldLegajoabmwc ;
   private String lblHoraswc_title_Internalname ;
   private String lblHoraswc_title_Jsonclick ;
   private String divUnnamedtablehoraswc_Internalname ;
   private String WebComp_Horaswcwc_Component ;
   private String OldHoraswcwc ;
   private String lblLicenciaswc_title_Internalname ;
   private String lblLicenciaswc_title_Jsonclick ;
   private String divUnnamedtablelicenciaswc_Internalname ;
   private String WebComp_Licenciaswcwc_Component ;
   private String OldLicenciaswcwc ;
   private String lblFamiliawc_title_Internalname ;
   private String lblFamiliawc_title_Jsonclick ;
   private String divUnnamedtablefamiliawc_Internalname ;
   private String WebComp_Familiawcwc_Component ;
   private String OldFamiliawcwc ;
   private String lblCodededuccionessolapa2_title_Internalname ;
   private String lblCodededuccionessolapa2_title_Jsonclick ;
   private String divUnnamedtablecodededuccionessolapa2_Internalname ;
   private String WebComp_Codededuccionessolapa2wc_Component ;
   private String OldCodededuccionessolapa2wc ;
   private String lblLiquidacioneswc_title_Internalname ;
   private String lblLiquidacioneswc_title_Jsonclick ;
   private String divUnnamedtableliquidacioneswc_Internalname ;
   private String WebComp_Liquidacioneswcwc_Component ;
   private String OldLiquidacioneswcwc ;
   private String lblGanancias_prorrateos_title_Internalname ;
   private String lblGanancias_prorrateos_title_Jsonclick ;
   private String divUnnamedtableganancias_prorrateos_Internalname ;
   private String WebComp_Ganancias_prorrateoswc_Component ;
   private String OldGanancias_prorrateoswc ;
   private String lblObligaciones_title_Internalname ;
   private String lblObligaciones_title_Jsonclick ;
   private String divUnnamedtableobligaciones_Internalname ;
   private String WebComp_Obligacioneswc_Component ;
   private String OldObligacioneswc ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String OldWcbienvenidalegajo ;
   private String WebComp_Wcbienvenidalegajo_Component ;
   private String scmdbuf ;
   private String tblTblbienve_Internalname ;
   private String sStyleString ;
   private String sCtrlAV10CliCod ;
   private String sCtrlAV11EmpCod ;
   private String sCtrlAV13LegNumero ;
   private String sCtrlAV8TabCode ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV9Exists ;
   private boolean AV14LoadAllTabs ;
   private boolean Tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean bDynCreated_Wcbienvenidalegajo ;
   private boolean bDynCreated_Legajoabmwc ;
   private boolean AV16TempBoolean ;
   private boolean bDynCreated_Horaswcwc ;
   private boolean bDynCreated_Licenciaswcwc ;
   private boolean bDynCreated_Familiawcwc ;
   private boolean bDynCreated_Codededuccionessolapa2wc ;
   private boolean bDynCreated_Liquidacioneswcwc ;
   private boolean bDynCreated_Ganancias_prorrateoswc ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean bDynCreated_Obligacioneswc ;
   private String AV21MenuOpcCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wcbienvenidalegajo ;
   private GXWebComponent WebComp_Legajoabmwc ;
   private GXWebComponent WebComp_Horaswcwc ;
   private GXWebComponent WebComp_Licenciaswcwc ;
   private GXWebComponent WebComp_Familiawcwc ;
   private GXWebComponent WebComp_Codededuccionessolapa2wc ;
   private GXWebComponent WebComp_Liquidacioneswcwc ;
   private GXWebComponent WebComp_Ganancias_prorrateoswc ;
   private GXWebComponent WebComp_Obligacioneswc ;
   private com.genexus.webpanels.WebSession AV20websession ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private IDataStoreProvider pr_default ;
   private int[] H00JR2_A6LegNumero ;
   private short[] H00JR2_A1EmpCod ;
   private int[] H00JR2_A3CliCod ;
   private int[] H00JR3_A6LegNumero ;
   private short[] H00JR3_A1EmpCod ;
   private int[] H00JR3_A3CliCod ;
   private int[] H00JR4_A6LegNumero ;
   private short[] H00JR4_A1EmpCod ;
   private int[] H00JR4_A3CliCod ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class legajosview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00JR2", "SELECT LegNumero, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (CliCod = ? and EmpCod = ? and LegNumero = ?) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00JR3", "SELECT LegNumero, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (CliCod = ? and EmpCod = ? and LegNumero = ?) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00JR4", "SELECT LegNumero, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (CliCod = ? and EmpCod = ? and LegNumero = ?) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

