package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class lsd_reg4view_impl extends GXDataArea
{
   public lsd_reg4view_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public lsd_reg4view_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lsd_reg4view_impl.class ));
   }

   public lsd_reg4view_impl( int remoteHandle ,
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
               AV12LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12LSDSec), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12LSDSec), "ZZZZZZZ9")));
               AV13LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LSD2Sec), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD2SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13LSD2Sec), "ZZZZZZZ9")));
               AV14LSD4Sec = (short)(GXutil.lval( httpContext.GetPar( "LSD4Sec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14LSD4Sec), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD4SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14LSD4Sec), "ZZZ9")));
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
      paHK2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startHK2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.lsd_reg4view", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV12LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14LSD4Sec,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"CliCod","EmpCod","LSDSec","LSD2Sec","LSD4Sec","TabCode"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12LSDSec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD2SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13LSD2Sec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD4SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14LSD4Sec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vLOADALLTABS", AV15LoadAllTabs);
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDTABCODE", GXutil.rtrim( AV16SelectedTabCode));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV10CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSDSEC", GXutil.ltrim( localUtil.ntoc( AV12LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12LSDSec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSD2SEC", GXutil.ltrim( localUtil.ntoc( AV13LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD2SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13LSD2Sec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSD4SEC", GXutil.ltrim( localUtil.ntoc( AV14LSD4Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD4SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14LSD4Sec), "ZZZ9")));
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
         weHK2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtHK2( ) ;
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
      return formatLink("web.lsd_reg4view", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV12LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14LSD4Sec,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"CliCod","EmpCod","LSDSec","LSD2Sec","LSD4Sec","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "LSD_reg4View" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "LSD_reg4 View", "") ;
   }

   public void wbHK0( )
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
         wb_table1_9_HK2( true) ;
      }
      else
      {
         wb_table1_9_HK2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_HK2e( boolean wbgen )
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

   public void startHK2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "LSD_reg4 View", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupHK0( ) ;
   }

   public void wsHK2( )
   {
      startHK2( ) ;
      evtHK2( ) ;
   }

   public void evtHK2( )
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
                           e11HK2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e12HK2 ();
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

   public void weHK2( )
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

   public void paHK2( )
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
      rfHK2( ) ;
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

   public void rfHK2( )
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
         e12HK2 ();
         wbHK0( ) ;
      }
   }

   public void send_integrity_lvl_hashesHK2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupHK0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11HK2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         AV10CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV12LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( "vLSDSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV13LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( "vLSD2SEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV14LSD4Sec = (short)(localUtil.ctol( httpContext.cgiGet( "vLSD4SEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV15LoadAllTabs = GXutil.strtobool( httpContext.cgiGet( "vLOADALLTABS")) ;
         AV16SelectedTabCode = httpContext.cgiGet( "vSELECTEDTABCODE") ;
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
      e11HK2 ();
      if (returnInSub) return;
   }

   public void e11HK2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", httpContext.getMessage( "DSP", ""), "") ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      AV20GXLvl11 = (byte)(0) ;
      /* Using cursor H00HK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12LSDSec), Integer.valueOf(AV13LSD2Sec), Short.valueOf(AV14LSD4Sec), Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12LSDSec), Integer.valueOf(AV13LSD2Sec), Short.valueOf(AV14LSD4Sec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1674LSD4Sec = H00HK2_A1674LSD4Sec[0] ;
         A1657LSD2Sec = H00HK2_A1657LSD2Sec[0] ;
         A1649LSDSec = H00HK2_A1649LSDSec[0] ;
         A1EmpCod = H00HK2_A1EmpCod[0] ;
         A3CliCod = H00HK2_A3CliCod[0] ;
         A1675LSD4CUIL_3_11 = H00HK2_A1675LSD4CUIL_3_11[0] ;
         AV20GXLvl11 = (byte)(1) ;
         Form.setCaption( GXutil.str( A1675LSD4CUIL_3_11, 11, 0) );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV20GXLvl11 == 0 )
      {
         Form.setCaption( httpContext.getMessage( "WWP_RecordNotFound", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = false ;
      }
      if ( AV9Exists )
      {
         AV16SelectedTabCode = AV8TabCode ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16SelectedTabCode", AV16SelectedTabCode);
         Tabs_Activepagecontrolname = AV16SelectedTabCode ;
         ucTabs.sendProperty(context, "", false, Tabs_Internalname, "ActivePageControlName", Tabs_Activepagecontrolname);
         /* Execute user subroutine: 'LOADTABS' */
         S112 ();
         if (returnInSub) return;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e12HK2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'LOADTABS' Routine */
      returnInSub = false ;
      if ( AV15LoadAllTabs || ( GXutil.strcmp(AV16SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV16SelectedTabCode, "General") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Generalwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Generalwc_Component), GXutil.lower( "LSD_reg4General")) != 0 )
         {
            WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "web.lsd_reg4general_impl", remoteHandle, context);
            WebComp_Generalwc_Component = "LSD_reg4General" ;
         }
         if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
         {
            WebComp_Generalwc.setjustcreated();
            WebComp_Generalwc.componentprepare(new Object[] {"W0023","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV12LSDSec),Integer.valueOf(AV13LSD2Sec),Short.valueOf(AV14LSD4Sec)});
            WebComp_Generalwc.componentbind(new Object[] {"","","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Generalwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0023"+"");
            WebComp_Generalwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
   }

   public void wb_table1_9_HK2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "General", ""), "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LSD_reg4View.htm");
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
         wb_table1_9_HK2e( true) ;
      }
      else
      {
         wb_table1_9_HK2e( false) ;
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
      AV12LSDSec = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12LSDSec), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12LSDSec), "ZZZZZZZ9")));
      AV13LSD2Sec = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LSD2Sec), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD2SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13LSD2Sec), "ZZZZZZZ9")));
      AV14LSD4Sec = ((Number) GXutil.testNumericType( getParm(obj,4), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14LSD4Sec), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD4SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14LSD4Sec), "ZZZ9")));
      AV8TabCode = (String)getParm(obj,5) ;
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
      paHK2( ) ;
      wsHK2( ) ;
      weHK2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202027436", true, true);
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
      httpContext.AddJavascriptSource("lsd_reg4view.js", "?202412202027436", false, true);
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
      Form.setCaption( httpContext.getMessage( "LSD_reg4 View", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV12LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV13LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV14LSD4Sec',fld:'vLSD4SEC',pic:'ZZZ9',hsh:true},{av:'AV8TabCode',fld:'vTABCODE',pic:'',hsh:true}]");
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
      wcpOAV8TabCode = "" ;
      Tabs_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV8TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV16SelectedTabCode = "" ;
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
      H00HK2_A1674LSD4Sec = new short[1] ;
      H00HK2_A1657LSD2Sec = new int[1] ;
      H00HK2_A1649LSDSec = new int[1] ;
      H00HK2_A1EmpCod = new short[1] ;
      H00HK2_A3CliCod = new int[1] ;
      H00HK2_A1675LSD4CUIL_3_11 = new long[1] ;
      ucTabs = new com.genexus.webpanels.GXUserControl();
      sStyleString = "" ;
      lblGeneral_title_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.lsd_reg4view__default(),
         new Object[] {
             new Object[] {
            H00HK2_A1674LSD4Sec, H00HK2_A1657LSD2Sec, H00HK2_A1649LSDSec, H00HK2_A1EmpCod, H00HK2_A3CliCod, H00HK2_A1675LSD4CUIL_3_11
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Generalwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV20GXLvl11 ;
   private byte nGXWrapped ;
   private short wcpOAV11EmpCod ;
   private short wcpOAV14LSD4Sec ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV11EmpCod ;
   private short AV14LSD4Sec ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A1674LSD4Sec ;
   private short A1EmpCod ;
   private int wcpOAV10CliCod ;
   private int wcpOAV12LSDSec ;
   private int wcpOAV13LSD2Sec ;
   private int AV10CliCod ;
   private int AV12LSDSec ;
   private int AV13LSD2Sec ;
   private int Tabs_Pagecount ;
   private int A1657LSD2Sec ;
   private int A1649LSDSec ;
   private int A3CliCod ;
   private int idxLst ;
   private long A1675LSD4CUIL_3_11 ;
   private String wcpOAV8TabCode ;
   private String Tabs_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV8TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV16SelectedTabCode ;
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
   private String Tabs_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtablegeneral_Internalname ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15LoadAllTabs ;
   private boolean Tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV9Exists ;
   private boolean bDynCreated_Generalwc ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Generalwc ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private IDataStoreProvider pr_default ;
   private short[] H00HK2_A1674LSD4Sec ;
   private int[] H00HK2_A1657LSD2Sec ;
   private int[] H00HK2_A1649LSDSec ;
   private short[] H00HK2_A1EmpCod ;
   private int[] H00HK2_A3CliCod ;
   private long[] H00HK2_A1675LSD4CUIL_3_11 ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class lsd_reg4view__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00HK2", "SELECT LSD4Sec, LSD2Sec, LSDSec, EmpCod, CliCod, LSD4CUIL_3_11 FROM LSD_reg4 WHERE (CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ? and LSD4Sec = ?) AND (CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ? and LSD4Sec = ?) ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
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
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
      }
   }

}
