package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresabase_calculoview_impl extends GXDataArea
{
   public empresabase_calculoview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresabase_calculoview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresabase_calculoview_impl.class ));
   }

   public empresabase_calculoview_impl( int remoteHandle ,
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV10CliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV11EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
               AV12EmpBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "EmpBaseClaseLeg"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12EmpBaseClaseLeg", GXutil.str( AV12EmpBaseClaseLeg, 1, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12EmpBaseClaseLeg), "9")));
               AV13EmpBaseTipo = httpContext.GetPar( "EmpBaseTipo") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13EmpBaseTipo", AV13EmpBaseTipo);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13EmpBaseTipo, ""))));
               AV14EmpBaseCod1 = httpContext.GetPar( "EmpBaseCod1") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14EmpBaseCod1", AV14EmpBaseCod1);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14EmpBaseCod1, ""))));
               AV15EmpBaseCod2 = httpContext.GetPar( "EmpBaseCod2") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15EmpBaseCod2", AV15EmpBaseCod2);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15EmpBaseCod2, ""))));
               AV8TabCode = httpContext.GetPar( "TabCode") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8TabCode", AV8TabCode);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
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
      paKB2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startKB2( ) ;
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
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empresabase_calculoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV12EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV13EmpBaseTipo)),GXutil.URLEncode(GXutil.rtrim(AV14EmpBaseCod1)),GXutil.URLEncode(GXutil.rtrim(AV15EmpBaseCod2)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2","TabCode"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12EmpBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13EmpBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14EmpBaseCod1, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15EmpBaseCod2, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vLOADALLTABS", AV16LoadAllTabs);
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDTABCODE", GXutil.rtrim( AV17SelectedTabCode));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV10CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECLASELEG", GXutil.ltrim( localUtil.ntoc( AV12EmpBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12EmpBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASETIPO", GXutil.rtrim( AV13EmpBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13EmpBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECOD1", GXutil.rtrim( AV14EmpBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14EmpBaseCod1, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECOD2", GXutil.rtrim( AV15EmpBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15EmpBaseCod2, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTABCODE", GXutil.rtrim( AV8TabCode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Class", GXutil.rtrim( Tabs_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Historymanagement", GXutil.booltostr( Tabs_Historymanagement));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
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
      if ( ! ( WebComp_Generalwc == null ) )
      {
         WebComp_Generalwc.componentjscripts();
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
         weKB2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtKB2( ) ;
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
      return formatLink("web.empresabase_calculoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV12EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV13EmpBaseTipo)),GXutil.URLEncode(GXutil.rtrim(AV14EmpBaseCod1)),GXutil.URLEncode(GXutil.rtrim(AV15EmpBaseCod2)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "Empresabase_calculoView" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Empresabase_calculo View", "") ;
   }

   public void wbKB0( )
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
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_9_KB2( true) ;
      }
      else
      {
         wb_table1_9_KB2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_KB2e( boolean wbgen )
   {
      if ( wbgen )
      {
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

   public void startKB2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Empresabase_calculo View", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupKB0( ) ;
   }

   public void wsKB2( )
   {
      startKB2( ) ;
      evtKB2( ) ;
   }

   public void evtKB2( )
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e11KB2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e12KB2 ();
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
                     if ( nCmpId == 23 )
                     {
                        OldGeneralwc = httpContext.cgiGet( "W0023") ;
                        if ( ( GXutil.len( OldGeneralwc) == 0 ) || ( GXutil.strcmp(OldGeneralwc, WebComp_Generalwc_Component) != 0 ) )
                        {
                           WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "web." + OldGeneralwc + "_impl", remoteHandle, context);
                           WebComp_Generalwc_Component = OldGeneralwc ;
                        }
                        if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
                        {
                           WebComp_Generalwc.componentprocess("W0023", "", sEvt);
                        }
                        WebComp_Generalwc_Component = OldGeneralwc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weKB2( )
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

   public void paKB2( )
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
      rfKB2( ) ;
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
   }

   public void rfKB2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               WebComp_Generalwc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e12KB2 ();
         wbKB0( ) ;
      }
   }

   public void send_integrity_lvl_hashesKB2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupKB0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11KB2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         AV10CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV12EmpBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( "vEMPBASECLASELEG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV13EmpBaseTipo = httpContext.cgiGet( "vEMPBASETIPO") ;
         AV14EmpBaseCod1 = httpContext.cgiGet( "vEMPBASECOD1") ;
         AV15EmpBaseCod2 = httpContext.cgiGet( "vEMPBASECOD2") ;
         AV16LoadAllTabs = GXutil.strtobool( httpContext.cgiGet( "vLOADALLTABS")) ;
         AV17SelectedTabCode = httpContext.cgiGet( "vSELECTEDTABCODE") ;
         Tabs_Activepagecontrolname = httpContext.cgiGet( "TABS_Activepagecontrolname") ;
         Tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Tabs_Class = httpContext.cgiGet( "TABS_Class") ;
         Tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TABS_Historymanagement")) ;
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
      e11KB2 ();
      if (returnInSub) return;
   }

   public void e11KB2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", httpContext.getMessage( "DSP", ""), "") ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      AV21GXLvl11 = (byte)(0) ;
      /* Using cursor H00KB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Byte.valueOf(AV12EmpBaseClaseLeg), AV13EmpBaseTipo, AV14EmpBaseCod1, AV15EmpBaseCod2, Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Byte.valueOf(AV12EmpBaseClaseLeg), AV13EmpBaseTipo, AV14EmpBaseCod1, AV15EmpBaseCod2});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1431EmpBaseCod2 = H00KB2_A1431EmpBaseCod2[0] ;
         A1427EmpBaseClaseLeg = H00KB2_A1427EmpBaseClaseLeg[0] ;
         A1EmpCod = H00KB2_A1EmpCod[0] ;
         A1430EmpBaseCod1 = H00KB2_A1430EmpBaseCod1[0] ;
         A1429EmpBaseTipo = H00KB2_A1429EmpBaseTipo[0] ;
         A3CliCod = H00KB2_A3CliCod[0] ;
         GXt_char2 = A1515EmpBaseC1Txt ;
         GXv_char3[0] = GXt_char2 ;
         new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char3) ;
         empresabase_calculoview_impl.this.GXt_char2 = GXv_char3[0] ;
         A1515EmpBaseC1Txt = GXt_char2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1515EmpBaseC1Txt", A1515EmpBaseC1Txt);
         AV21GXLvl11 = (byte)(1) ;
         Form.setCaption( A1515EmpBaseC1Txt );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV21GXLvl11 == 0 )
      {
         Form.setCaption( httpContext.getMessage( "WWP_RecordNotFound", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = false ;
      }
      if ( AV9Exists )
      {
         AV17SelectedTabCode = AV8TabCode ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17SelectedTabCode", AV17SelectedTabCode);
         Tabs_Activepagecontrolname = AV17SelectedTabCode ;
         ucTabs.sendProperty(context, "", false, Tabs_Internalname, "ActivePageControlName", Tabs_Activepagecontrolname);
         /* Execute user subroutine: 'LOADTABS' */
         S112 ();
         if (returnInSub) return;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e12KB2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'LOADTABS' Routine */
      returnInSub = false ;
      if ( AV16LoadAllTabs || ( GXutil.strcmp(AV17SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV17SelectedTabCode, "General") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Generalwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Generalwc_Component), GXutil.lower( "Empresabase_calculoGeneral")) != 0 )
         {
            WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "web.empresabase_calculogeneral_impl", remoteHandle, context);
            WebComp_Generalwc_Component = "Empresabase_calculoGeneral" ;
         }
         if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
         {
            WebComp_Generalwc.setjustcreated();
            WebComp_Generalwc.componentprepare(new Object[] {"W0023","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Byte.valueOf(AV12EmpBaseClaseLeg),AV13EmpBaseTipo,AV14EmpBaseCod1,AV15EmpBaseCod2});
            WebComp_Generalwc.componentbind(new Object[] {"","","","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Generalwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0023"+"");
            WebComp_Generalwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
   }

   public void wb_table1_9_KB2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellViewTabsPosition'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableviewcontainer_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellViewTab", "left", "top", "", "", "div");
         /* User Defined Control */
         ucTabs.setProperty("PageCount", Tabs_Pagecount);
         ucTabs.setProperty("Class", Tabs_Class);
         ucTabs.setProperty("HistoryManagement", Tabs_Historymanagement);
         ucTabs.render(context, "tab", Tabs_Internalname, "TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "General", ""), "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_Empresabase_calculoView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "General") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablegeneral_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0023"+"", GXutil.rtrim( WebComp_Generalwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0023"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldGeneralwc), GXutil.lower( WebComp_Generalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0023"+"");
               }
               WebComp_Generalwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldGeneralwc), GXutil.lower( WebComp_Generalwc_Component)) != 0 )
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
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_KB2e( true) ;
      }
      else
      {
         wb_table1_9_KB2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
      AV11EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
      AV12EmpBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12EmpBaseClaseLeg", GXutil.str( AV12EmpBaseClaseLeg, 1, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12EmpBaseClaseLeg), "9")));
      AV13EmpBaseTipo = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13EmpBaseTipo", AV13EmpBaseTipo);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13EmpBaseTipo, ""))));
      AV14EmpBaseCod1 = (String)getParm(obj,4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14EmpBaseCod1", AV14EmpBaseCod1);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14EmpBaseCod1, ""))));
      AV15EmpBaseCod2 = (String)getParm(obj,5) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15EmpBaseCod2", AV15EmpBaseCod2);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15EmpBaseCod2, ""))));
      AV8TabCode = (String)getParm(obj,6) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8TabCode", AV8TabCode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
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
      paKB2( ) ;
      wsKB2( ) ;
      weKB2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Generalwc == null ) )
      {
         if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
         {
            WebComp_Generalwc.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251316514547", true, true);
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
      httpContext.AddJavascriptSource("empresabase_calculoview.js", "?20251316514547", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblGeneral_title_Internalname = "GENERAL_TITLE" ;
      divUnnamedtablegeneral_Internalname = "UNNAMEDTABLEGENERAL" ;
      Tabs_Internalname = "TABS" ;
      divUnnamedtableviewcontainer_Internalname = "UNNAMEDTABLEVIEWCONTAINER" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      Tabs_Historymanagement = GXutil.toBoolean( -1) ;
      Tabs_Class = "ViewTab Tab" ;
      Tabs_Pagecount = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Empresabase_calculo View", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV12EmpBaseClaseLeg',fld:'vEMPBASECLASELEG',pic:'9',hsh:true},{av:'AV13EmpBaseTipo',fld:'vEMPBASETIPO',pic:'',hsh:true},{av:'AV14EmpBaseCod1',fld:'vEMPBASECOD1',pic:'',hsh:true},{av:'AV15EmpBaseCod2',fld:'vEMPBASECOD2',pic:'',hsh:true},{av:'AV8TabCode',fld:'vTABCODE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
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
      wcpOAV13EmpBaseTipo = "" ;
      wcpOAV14EmpBaseCod1 = "" ;
      wcpOAV15EmpBaseCod2 = "" ;
      wcpOAV8TabCode = "" ;
      Tabs_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV13EmpBaseTipo = "" ;
      AV14EmpBaseCod1 = "" ;
      AV15EmpBaseCod2 = "" ;
      AV8TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV17SelectedTabCode = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldGeneralwc = "" ;
      WebComp_Generalwc_Component = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H00KB2_A1431EmpBaseCod2 = new String[] {""} ;
      H00KB2_A1427EmpBaseClaseLeg = new byte[1] ;
      H00KB2_A1EmpCod = new short[1] ;
      H00KB2_A1430EmpBaseCod1 = new String[] {""} ;
      H00KB2_A1429EmpBaseTipo = new String[] {""} ;
      H00KB2_A3CliCod = new int[1] ;
      A1431EmpBaseCod2 = "" ;
      A1430EmpBaseCod1 = "" ;
      A1429EmpBaseTipo = "" ;
      A1515EmpBaseC1Txt = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      ucTabs = new com.genexus.webpanels.GXUserControl();
      sStyleString = "" ;
      lblGeneral_title_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresabase_calculoview__default(),
         new Object[] {
             new Object[] {
            H00KB2_A1431EmpBaseCod2, H00KB2_A1427EmpBaseClaseLeg, H00KB2_A1EmpCod, H00KB2_A1430EmpBaseCod1, H00KB2_A1429EmpBaseTipo, H00KB2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Generalwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte wcpOAV12EmpBaseClaseLeg ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV12EmpBaseClaseLeg ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV21GXLvl11 ;
   private byte A1427EmpBaseClaseLeg ;
   private byte nGXWrapped ;
   private short wcpOAV11EmpCod ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV11EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A1EmpCod ;
   private int wcpOAV10CliCod ;
   private int AV10CliCod ;
   private int Tabs_Pagecount ;
   private int A3CliCod ;
   private int idxLst ;
   private String wcpOAV13EmpBaseTipo ;
   private String wcpOAV14EmpBaseCod1 ;
   private String wcpOAV15EmpBaseCod2 ;
   private String wcpOAV8TabCode ;
   private String Tabs_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV13EmpBaseTipo ;
   private String AV14EmpBaseCod1 ;
   private String AV15EmpBaseCod2 ;
   private String AV8TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV17SelectedTabCode ;
   private String Tabs_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String OldGeneralwc ;
   private String WebComp_Generalwc_Component ;
   private String scmdbuf ;
   private String A1431EmpBaseCod2 ;
   private String A1430EmpBaseCod1 ;
   private String A1429EmpBaseTipo ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String Tabs_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtablegeneral_Internalname ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV16LoadAllTabs ;
   private boolean Tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV9Exists ;
   private boolean bDynCreated_Generalwc ;
   private String A1515EmpBaseC1Txt ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Generalwc ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private IDataStoreProvider pr_default ;
   private String[] H00KB2_A1431EmpBaseCod2 ;
   private byte[] H00KB2_A1427EmpBaseClaseLeg ;
   private short[] H00KB2_A1EmpCod ;
   private String[] H00KB2_A1430EmpBaseCod1 ;
   private String[] H00KB2_A1429EmpBaseTipo ;
   private int[] H00KB2_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class empresabase_calculoview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00KB2", "SELECT EmpBaseCod2, EmpBaseClaseLeg, EmpCod, EmpBaseCod1, EmpBaseTipo, CliCod FROM Empresabase_calculo WHERE (CliCod = ? and EmpCod = ? and EmpBaseClaseLeg = ? and EmpBaseTipo = ( ?) and EmpBaseCod1 = ( ?) and EmpBaseCod2 = ( ?)) AND (CliCod = ? and EmpCod = ? and EmpBaseClaseLeg = ? and EmpBaseTipo = ( ?) and EmpBaseCod1 = ( ?) and EmpBaseCod2 = ( ?)) ORDER BY CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               return;
      }
   }

}

