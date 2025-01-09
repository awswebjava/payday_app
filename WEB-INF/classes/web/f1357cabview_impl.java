package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357cabview_impl extends GXDataArea
{
   public f1357cabview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357cabview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357cabview_impl.class ));
   }

   public f1357cabview_impl( int remoteHandle ,
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
               AV17F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV17F1357CTipoPre", GXutil.str( AV17F1357CTipoPre, 1, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CTIPOPRE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17F1357CTipoPre), "9")));
               AV12F1357CPer = httpContext.GetPar( "F1357CPer") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12F1357CPer", AV12F1357CPer);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CPER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12F1357CPer, ""))));
               AV13F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13F1357CSec), 2, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13F1357CSec), "Z9")));
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
      pa9G2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start9G2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357cabview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV17F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(AV12F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(AV13F1357CSec,2,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec","TabCode"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CTIPOPRE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17F1357CTipoPre), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CPER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12F1357CPer, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13F1357CSec), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vLOADALLTABS", AV14LoadAllTabs);
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDTABCODE", GXutil.rtrim( AV15SelectedTabCode));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV10CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CTIPOPRE", GXutil.ltrim( localUtil.ntoc( AV17F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CTIPOPRE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17F1357CTipoPre), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CPER", GXutil.rtrim( AV12F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CPER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12F1357CPer, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CSEC", GXutil.ltrim( localUtil.ntoc( AV13F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13F1357CSec), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV18MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18MenuOpcCod, ""))));
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
      if ( ! ( WebComp_F1357legwc == null ) )
      {
         WebComp_F1357legwc.componentjscripts();
      }
      if ( ! ( WebComp_F1357lcalculowc == null ) )
      {
         WebComp_F1357lcalculowc.componentjscripts();
      }
      if ( ! ( WebComp_F1357legremunwc == null ) )
      {
         WebComp_F1357legremunwc.componentjscripts();
      }
      if ( ! ( WebComp_F1357ldedperwc == null ) )
      {
         WebComp_F1357ldedperwc.componentjscripts();
      }
      if ( ! ( WebComp_F1357legdedgenwc == null ) )
      {
         WebComp_F1357legdedgenwc.componentjscripts();
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
         we9G2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt9G2( ) ;
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
      return formatLink("web.f1357cabview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV17F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(AV12F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(AV13F1357CSec,2,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "F1357CabView" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "F1357 Cab View", "") ;
   }

   public void wb9G0( )
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
         wb_table1_9_9G2( true) ;
      }
      else
      {
         wb_table1_9_9G2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_9G2e( boolean wbgen )
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

   public void start9G2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "F1357 Cab View", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup9G0( ) ;
   }

   public void ws9G2( )
   {
      start9G2( ) ;
      evt9G2( ) ;
   }

   public void evt9G2( )
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
                           e119G2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e129G2 ();
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
                     else if ( nCmpId == 31 )
                     {
                        OldF1357legwc = httpContext.cgiGet( "W0031") ;
                        if ( ( GXutil.len( OldF1357legwc) == 0 ) || ( GXutil.strcmp(OldF1357legwc, WebComp_F1357legwc_Component) != 0 ) )
                        {
                           WebComp_F1357legwc = WebUtils.getWebComponent(getClass(), "web." + OldF1357legwc + "_impl", remoteHandle, context);
                           WebComp_F1357legwc_Component = OldF1357legwc ;
                        }
                        if ( GXutil.len( WebComp_F1357legwc_Component) != 0 )
                        {
                           WebComp_F1357legwc.componentprocess("W0031", "", sEvt);
                        }
                        WebComp_F1357legwc_Component = OldF1357legwc ;
                     }
                     else if ( nCmpId == 39 )
                     {
                        OldF1357lcalculowc = httpContext.cgiGet( "W0039") ;
                        if ( ( GXutil.len( OldF1357lcalculowc) == 0 ) || ( GXutil.strcmp(OldF1357lcalculowc, WebComp_F1357lcalculowc_Component) != 0 ) )
                        {
                           WebComp_F1357lcalculowc = WebUtils.getWebComponent(getClass(), "web." + OldF1357lcalculowc + "_impl", remoteHandle, context);
                           WebComp_F1357lcalculowc_Component = OldF1357lcalculowc ;
                        }
                        if ( GXutil.len( WebComp_F1357lcalculowc_Component) != 0 )
                        {
                           WebComp_F1357lcalculowc.componentprocess("W0039", "", sEvt);
                        }
                        WebComp_F1357lcalculowc_Component = OldF1357lcalculowc ;
                     }
                     else if ( nCmpId == 47 )
                     {
                        OldF1357legremunwc = httpContext.cgiGet( "W0047") ;
                        if ( ( GXutil.len( OldF1357legremunwc) == 0 ) || ( GXutil.strcmp(OldF1357legremunwc, WebComp_F1357legremunwc_Component) != 0 ) )
                        {
                           WebComp_F1357legremunwc = WebUtils.getWebComponent(getClass(), "web." + OldF1357legremunwc + "_impl", remoteHandle, context);
                           WebComp_F1357legremunwc_Component = OldF1357legremunwc ;
                        }
                        if ( GXutil.len( WebComp_F1357legremunwc_Component) != 0 )
                        {
                           WebComp_F1357legremunwc.componentprocess("W0047", "", sEvt);
                        }
                        WebComp_F1357legremunwc_Component = OldF1357legremunwc ;
                     }
                     else if ( nCmpId == 55 )
                     {
                        OldF1357ldedperwc = httpContext.cgiGet( "W0055") ;
                        if ( ( GXutil.len( OldF1357ldedperwc) == 0 ) || ( GXutil.strcmp(OldF1357ldedperwc, WebComp_F1357ldedperwc_Component) != 0 ) )
                        {
                           WebComp_F1357ldedperwc = WebUtils.getWebComponent(getClass(), "web." + OldF1357ldedperwc + "_impl", remoteHandle, context);
                           WebComp_F1357ldedperwc_Component = OldF1357ldedperwc ;
                        }
                        if ( GXutil.len( WebComp_F1357ldedperwc_Component) != 0 )
                        {
                           WebComp_F1357ldedperwc.componentprocess("W0055", "", sEvt);
                        }
                        WebComp_F1357ldedperwc_Component = OldF1357ldedperwc ;
                     }
                     else if ( nCmpId == 63 )
                     {
                        OldF1357legdedgenwc = httpContext.cgiGet( "W0063") ;
                        if ( ( GXutil.len( OldF1357legdedgenwc) == 0 ) || ( GXutil.strcmp(OldF1357legdedgenwc, WebComp_F1357legdedgenwc_Component) != 0 ) )
                        {
                           WebComp_F1357legdedgenwc = WebUtils.getWebComponent(getClass(), "web." + OldF1357legdedgenwc + "_impl", remoteHandle, context);
                           WebComp_F1357legdedgenwc_Component = OldF1357legdedgenwc ;
                        }
                        if ( GXutil.len( WebComp_F1357legdedgenwc_Component) != 0 )
                        {
                           WebComp_F1357legdedgenwc.componentprocess("W0063", "", sEvt);
                        }
                        WebComp_F1357legdedgenwc_Component = OldF1357legdedgenwc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we9G2( )
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

   public void pa9G2( )
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
      rf9G2( ) ;
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

   public void rf9G2( )
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
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_F1357legwc_Component) != 0 )
            {
               WebComp_F1357legwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_F1357lcalculowc_Component) != 0 )
            {
               WebComp_F1357lcalculowc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_F1357legremunwc_Component) != 0 )
            {
               WebComp_F1357legremunwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_F1357ldedperwc_Component) != 0 )
            {
               WebComp_F1357ldedperwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_F1357legdedgenwc_Component) != 0 )
            {
               WebComp_F1357legdedgenwc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e129G2 ();
         wb9G0( ) ;
      }
   }

   public void send_integrity_lvl_hashes9G2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV18MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18MenuOpcCod, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup9G0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e119G2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         AV18MenuOpcCod = httpContext.cgiGet( "vMENUOPCCOD") ;
         AV10CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV17F1357CTipoPre = (byte)(localUtil.ctol( httpContext.cgiGet( "vF1357CTIPOPRE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV12F1357CPer = httpContext.cgiGet( "vF1357CPER") ;
         AV13F1357CSec = (byte)(localUtil.ctol( httpContext.cgiGet( "vF1357CSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV14LoadAllTabs = GXutil.strtobool( httpContext.cgiGet( "vLOADALLTABS")) ;
         AV15SelectedTabCode = httpContext.cgiGet( "vSELECTEDTABCODE") ;
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
      e119G2 ();
      if (returnInSub) return;
   }

   public void e119G2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", httpContext.getMessage( "DSP", ""), "") ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      AV21GXLvl11 = (byte)(0) ;
      /* Using cursor H009G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Byte.valueOf(AV17F1357CTipoPre), AV12F1357CPer, Byte.valueOf(AV13F1357CSec), Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Byte.valueOf(AV17F1357CTipoPre), AV12F1357CPer, Byte.valueOf(AV13F1357CSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A778F1357CSec = H009G2_A778F1357CSec[0] ;
         A777F1357CPer = H009G2_A777F1357CPer[0] ;
         A784F1357CTipoPre = H009G2_A784F1357CTipoPre[0] ;
         A1EmpCod = H009G2_A1EmpCod[0] ;
         A3CliCod = H009G2_A3CliCod[0] ;
         AV21GXLvl11 = (byte)(1) ;
         Form.setCaption( httpContext.getMessage( "F1357 ", "")+httpContext.getMessage( web.gxdomainf1357_tipospresentacion.getDescription(httpContext,(byte)A784F1357CTipoPre), "")+" - "+GXutil.trim( A777F1357CPer)+" - "+GXutil.trim( GXutil.str( A778F1357CSec, 2, 0)) );
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
         AV15SelectedTabCode = AV8TabCode ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15SelectedTabCode", AV15SelectedTabCode);
         Tabs_Activepagecontrolname = AV15SelectedTabCode ;
         ucTabs.sendProperty(context, "", false, Tabs_Internalname, "ActivePageControlName", Tabs_Activepagecontrolname);
         /* Execute user subroutine: 'LOADTABS' */
         S112 ();
         if (returnInSub) return;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e129G2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'LOADTABS' Routine */
      returnInSub = false ;
      if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV15SelectedTabCode, "General") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Generalwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Generalwc_Component), GXutil.lower( "F1357CabGeneral")) != 0 )
         {
            WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "web.f1357cabgeneral_impl", remoteHandle, context);
            WebComp_Generalwc_Component = "F1357CabGeneral" ;
         }
         if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
         {
            WebComp_Generalwc.setjustcreated();
            WebComp_Generalwc.componentprepare(new Object[] {"W0023","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Byte.valueOf(AV17F1357CTipoPre),AV12F1357CPer,Byte.valueOf(AV13F1357CSec)});
            WebComp_Generalwc.componentbind(new Object[] {"","","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Generalwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0023"+"");
            WebComp_Generalwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "F1357Leg") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_F1357legwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_F1357legwc_Component), GXutil.lower( "F1357CabF1357LegWC")) != 0 )
         {
            WebComp_F1357legwc = WebUtils.getWebComponent(getClass(), "web.f1357cabf1357legwc_impl", remoteHandle, context);
            WebComp_F1357legwc_Component = "F1357CabF1357LegWC" ;
         }
         if ( GXutil.len( WebComp_F1357legwc_Component) != 0 )
         {
            WebComp_F1357legwc.setjustcreated();
            WebComp_F1357legwc.componentprepare(new Object[] {"W0031","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Byte.valueOf(AV17F1357CTipoPre),AV12F1357CPer,Byte.valueOf(AV13F1357CSec)});
            WebComp_F1357legwc.componentbind(new Object[] {"","","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_F1357legwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0031"+"");
            WebComp_F1357legwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "F1357LCalculo") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_F1357lcalculowc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_F1357lcalculowc_Component), GXutil.lower( "F1357CabF1357LCalculoWC")) != 0 )
         {
            WebComp_F1357lcalculowc = WebUtils.getWebComponent(getClass(), "web.f1357cabf1357lcalculowc_impl", remoteHandle, context);
            WebComp_F1357lcalculowc_Component = "F1357CabF1357LCalculoWC" ;
         }
         if ( GXutil.len( WebComp_F1357lcalculowc_Component) != 0 )
         {
            WebComp_F1357lcalculowc.setjustcreated();
            WebComp_F1357lcalculowc.componentprepare(new Object[] {"W0039","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Byte.valueOf(AV17F1357CTipoPre),AV12F1357CPer,Byte.valueOf(AV13F1357CSec)});
            WebComp_F1357lcalculowc.componentbind(new Object[] {"","","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_F1357lcalculowc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0039"+"");
            WebComp_F1357lcalculowc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "F1357LegRemun") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_F1357legremunwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_F1357legremunwc_Component), GXutil.lower( "F1357CabF1357LegRemunWC")) != 0 )
         {
            WebComp_F1357legremunwc = WebUtils.getWebComponent(getClass(), "web.f1357cabf1357legremunwc_impl", remoteHandle, context);
            WebComp_F1357legremunwc_Component = "F1357CabF1357LegRemunWC" ;
         }
         if ( GXutil.len( WebComp_F1357legremunwc_Component) != 0 )
         {
            WebComp_F1357legremunwc.setjustcreated();
            WebComp_F1357legremunwc.componentprepare(new Object[] {"W0047","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Byte.valueOf(AV17F1357CTipoPre),AV12F1357CPer,Byte.valueOf(AV13F1357CSec)});
            WebComp_F1357legremunwc.componentbind(new Object[] {"","","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_F1357legremunwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0047"+"");
            WebComp_F1357legremunwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "F1357LDedPer") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_F1357ldedperwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_F1357ldedperwc_Component), GXutil.lower( "F1357CabF1357LDedPerWC")) != 0 )
         {
            WebComp_F1357ldedperwc = WebUtils.getWebComponent(getClass(), "web.f1357cabf1357ldedperwc_impl", remoteHandle, context);
            WebComp_F1357ldedperwc_Component = "F1357CabF1357LDedPerWC" ;
         }
         if ( GXutil.len( WebComp_F1357ldedperwc_Component) != 0 )
         {
            WebComp_F1357ldedperwc.setjustcreated();
            WebComp_F1357ldedperwc.componentprepare(new Object[] {"W0055","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Byte.valueOf(AV17F1357CTipoPre),AV12F1357CPer,Byte.valueOf(AV13F1357CSec)});
            WebComp_F1357ldedperwc.componentbind(new Object[] {"","","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_F1357ldedperwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0055"+"");
            WebComp_F1357ldedperwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV14LoadAllTabs || ( GXutil.strcmp(AV15SelectedTabCode, "F1357LegDedGen") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_F1357legdedgenwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_F1357legdedgenwc_Component), GXutil.lower( "F1357CabF1357LegDedGenWC")) != 0 )
         {
            WebComp_F1357legdedgenwc = WebUtils.getWebComponent(getClass(), "web.f1357cabf1357legdedgenwc_impl", remoteHandle, context);
            WebComp_F1357legdedgenwc_Component = "F1357CabF1357LegDedGenWC" ;
         }
         if ( GXutil.len( WebComp_F1357legdedgenwc_Component) != 0 )
         {
            WebComp_F1357legdedgenwc.setjustcreated();
            WebComp_F1357legdedgenwc.componentprepare(new Object[] {"W0063","",Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Byte.valueOf(AV17F1357CTipoPre),AV12F1357CPer,Byte.valueOf(AV13F1357CSec)});
            WebComp_F1357legdedgenwc.componentbind(new Object[] {"","","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_F1357legdedgenwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0063"+"");
            WebComp_F1357legdedgenwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
   }

   public void wb_table1_9_9G2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "General", ""), "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_F1357CabView.htm");
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
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblF1357leg_title_Internalname, httpContext.getMessage( "Datos legajos", ""), "", "", lblF1357leg_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_F1357CabView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "F1357Leg") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablef1357leg_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0031"+"", GXutil.rtrim( WebComp_F1357legwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0031"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_F1357legwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldF1357legwc), GXutil.lower( WebComp_F1357legwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0031"+"");
               }
               WebComp_F1357legwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldF1357legwc), GXutil.lower( WebComp_F1357legwc_Component)) != 0 )
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
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblF1357lcalculo_title_Internalname, httpContext.getMessage( "Cálculos", ""), "", "", lblF1357lcalculo_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_F1357CabView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "F1357LCalculo") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablef1357lcalculo_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0039"+"", GXutil.rtrim( WebComp_F1357lcalculowc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0039"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_F1357lcalculowc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldF1357lcalculowc), GXutil.lower( WebComp_F1357lcalculowc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0039"+"");
               }
               WebComp_F1357lcalculowc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldF1357lcalculowc), GXutil.lower( WebComp_F1357lcalculowc_Component)) != 0 )
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
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblF1357legremun_title_Internalname, httpContext.getMessage( "Remuneraciones", ""), "", "", lblF1357legremun_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_F1357CabView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "F1357LegRemun") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablef1357legremun_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0047"+"", GXutil.rtrim( WebComp_F1357legremunwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0047"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_F1357legremunwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldF1357legremunwc), GXutil.lower( WebComp_F1357legremunwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0047"+"");
               }
               WebComp_F1357legremunwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldF1357legremunwc), GXutil.lower( WebComp_F1357legremunwc_Component)) != 0 )
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
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title5"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblF1357ldedper_title_Internalname, httpContext.getMessage( "Deducciones Art. 30", ""), "", "", lblF1357ldedper_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_F1357CabView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "F1357LDedPer") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablef1357ldedper_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0055"+"", GXutil.rtrim( WebComp_F1357ldedperwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0055"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_F1357ldedperwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldF1357ldedperwc), GXutil.lower( WebComp_F1357ldedperwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0055"+"");
               }
               WebComp_F1357ldedperwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldF1357ldedperwc), GXutil.lower( WebComp_F1357ldedperwc_Component)) != 0 )
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
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title6"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblF1357legdedgen_title_Internalname, httpContext.getMessage( "Deducciones generales", ""), "", "", lblF1357legdedgen_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_F1357CabView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "F1357LegDedGen") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablef1357legdedgen_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0063"+"", GXutil.rtrim( WebComp_F1357legdedgenwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0063"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_F1357legdedgenwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldF1357legdedgenwc), GXutil.lower( WebComp_F1357legdedgenwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0063"+"");
               }
               WebComp_F1357legdedgenwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldF1357legdedgenwc), GXutil.lower( WebComp_F1357legdedgenwc_Component)) != 0 )
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
         wb_table1_9_9G2e( true) ;
      }
      else
      {
         wb_table1_9_9G2e( false) ;
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
      AV17F1357CTipoPre = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17F1357CTipoPre", GXutil.str( AV17F1357CTipoPre, 1, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CTIPOPRE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17F1357CTipoPre), "9")));
      AV12F1357CPer = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12F1357CPer", AV12F1357CPer);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CPER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12F1357CPer, ""))));
      AV13F1357CSec = ((Number) GXutil.testNumericType( getParm(obj,4), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13F1357CSec), 2, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13F1357CSec), "Z9")));
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
      pa9G2( ) ;
      ws9G2( ) ;
      we9G2( ) ;
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
      if ( ! ( WebComp_F1357legwc == null ) )
      {
         if ( GXutil.len( WebComp_F1357legwc_Component) != 0 )
         {
            WebComp_F1357legwc.componentthemes();
         }
      }
      if ( ! ( WebComp_F1357lcalculowc == null ) )
      {
         if ( GXutil.len( WebComp_F1357lcalculowc_Component) != 0 )
         {
            WebComp_F1357lcalculowc.componentthemes();
         }
      }
      if ( ! ( WebComp_F1357legremunwc == null ) )
      {
         if ( GXutil.len( WebComp_F1357legremunwc_Component) != 0 )
         {
            WebComp_F1357legremunwc.componentthemes();
         }
      }
      if ( ! ( WebComp_F1357ldedperwc == null ) )
      {
         if ( GXutil.len( WebComp_F1357ldedperwc_Component) != 0 )
         {
            WebComp_F1357ldedperwc.componentthemes();
         }
      }
      if ( ! ( WebComp_F1357legdedgenwc == null ) )
      {
         if ( GXutil.len( WebComp_F1357legdedgenwc_Component) != 0 )
         {
            WebComp_F1357legdedgenwc.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202051949", true, true);
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
      httpContext.AddJavascriptSource("f1357cabview.js", "?202412202051949", false, true);
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
      lblF1357leg_title_Internalname = "F1357LEG_TITLE" ;
      divUnnamedtablef1357leg_Internalname = "UNNAMEDTABLEF1357LEG" ;
      lblF1357lcalculo_title_Internalname = "F1357LCALCULO_TITLE" ;
      divUnnamedtablef1357lcalculo_Internalname = "UNNAMEDTABLEF1357LCALCULO" ;
      lblF1357legremun_title_Internalname = "F1357LEGREMUN_TITLE" ;
      divUnnamedtablef1357legremun_Internalname = "UNNAMEDTABLEF1357LEGREMUN" ;
      lblF1357ldedper_title_Internalname = "F1357LDEDPER_TITLE" ;
      divUnnamedtablef1357ldedper_Internalname = "UNNAMEDTABLEF1357LDEDPER" ;
      lblF1357legdedgen_title_Internalname = "F1357LEGDEDGEN_TITLE" ;
      divUnnamedtablef1357legdedgen_Internalname = "UNNAMEDTABLEF1357LEGDEDGEN" ;
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
      Tabs_Pagecount = 6 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "F1357 Cab View", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV17F1357CTipoPre',fld:'vF1357CTIPOPRE',pic:'9',hsh:true},{av:'AV12F1357CPer',fld:'vF1357CPER',pic:'',hsh:true},{av:'AV13F1357CSec',fld:'vF1357CSEC',pic:'Z9',hsh:true},{av:'AV18MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV8TabCode',fld:'vTABCODE',pic:'',hsh:true}]");
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
      wcpOAV12F1357CPer = "" ;
      wcpOAV8TabCode = "" ;
      Tabs_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV12F1357CPer = "" ;
      AV8TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV18MenuOpcCod = "" ;
      GXKey = "" ;
      AV15SelectedTabCode = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldGeneralwc = "" ;
      WebComp_Generalwc_Component = "" ;
      OldF1357legwc = "" ;
      WebComp_F1357legwc_Component = "" ;
      OldF1357lcalculowc = "" ;
      WebComp_F1357lcalculowc_Component = "" ;
      OldF1357legremunwc = "" ;
      WebComp_F1357legremunwc_Component = "" ;
      OldF1357ldedperwc = "" ;
      WebComp_F1357ldedperwc_Component = "" ;
      OldF1357legdedgenwc = "" ;
      WebComp_F1357legdedgenwc_Component = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H009G2_A778F1357CSec = new byte[1] ;
      H009G2_A777F1357CPer = new String[] {""} ;
      H009G2_A784F1357CTipoPre = new byte[1] ;
      H009G2_A1EmpCod = new short[1] ;
      H009G2_A3CliCod = new int[1] ;
      A777F1357CPer = "" ;
      ucTabs = new com.genexus.webpanels.GXUserControl();
      sStyleString = "" ;
      lblGeneral_title_Jsonclick = "" ;
      lblF1357leg_title_Jsonclick = "" ;
      lblF1357lcalculo_title_Jsonclick = "" ;
      lblF1357legremun_title_Jsonclick = "" ;
      lblF1357ldedper_title_Jsonclick = "" ;
      lblF1357legdedgen_title_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357cabview__default(),
         new Object[] {
             new Object[] {
            H009G2_A778F1357CSec, H009G2_A777F1357CPer, H009G2_A784F1357CTipoPre, H009G2_A1EmpCod, H009G2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Generalwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_F1357legwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_F1357lcalculowc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_F1357legremunwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_F1357ldedperwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_F1357legdedgenwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte wcpOAV17F1357CTipoPre ;
   private byte wcpOAV13F1357CSec ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV17F1357CTipoPre ;
   private byte AV13F1357CSec ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV21GXLvl11 ;
   private byte A778F1357CSec ;
   private byte A784F1357CTipoPre ;
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
   private String wcpOAV12F1357CPer ;
   private String wcpOAV8TabCode ;
   private String Tabs_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV12F1357CPer ;
   private String AV8TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV15SelectedTabCode ;
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
   private String OldF1357legwc ;
   private String WebComp_F1357legwc_Component ;
   private String OldF1357lcalculowc ;
   private String WebComp_F1357lcalculowc_Component ;
   private String OldF1357legremunwc ;
   private String WebComp_F1357legremunwc_Component ;
   private String OldF1357ldedperwc ;
   private String WebComp_F1357ldedperwc_Component ;
   private String OldF1357legdedgenwc ;
   private String WebComp_F1357legdedgenwc_Component ;
   private String scmdbuf ;
   private String A777F1357CPer ;
   private String Tabs_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtablegeneral_Internalname ;
   private String lblF1357leg_title_Internalname ;
   private String lblF1357leg_title_Jsonclick ;
   private String divUnnamedtablef1357leg_Internalname ;
   private String lblF1357lcalculo_title_Internalname ;
   private String lblF1357lcalculo_title_Jsonclick ;
   private String divUnnamedtablef1357lcalculo_Internalname ;
   private String lblF1357legremun_title_Internalname ;
   private String lblF1357legremun_title_Jsonclick ;
   private String divUnnamedtablef1357legremun_Internalname ;
   private String lblF1357ldedper_title_Internalname ;
   private String lblF1357ldedper_title_Jsonclick ;
   private String divUnnamedtablef1357ldedper_Internalname ;
   private String lblF1357legdedgen_title_Internalname ;
   private String lblF1357legdedgen_title_Jsonclick ;
   private String divUnnamedtablef1357legdedgen_Internalname ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14LoadAllTabs ;
   private boolean Tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV9Exists ;
   private boolean bDynCreated_Generalwc ;
   private boolean bDynCreated_F1357legwc ;
   private boolean bDynCreated_F1357lcalculowc ;
   private boolean bDynCreated_F1357legremunwc ;
   private boolean bDynCreated_F1357ldedperwc ;
   private boolean bDynCreated_F1357legdedgenwc ;
   private String AV18MenuOpcCod ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Generalwc ;
   private GXWebComponent WebComp_F1357legwc ;
   private GXWebComponent WebComp_F1357lcalculowc ;
   private GXWebComponent WebComp_F1357legremunwc ;
   private GXWebComponent WebComp_F1357ldedperwc ;
   private GXWebComponent WebComp_F1357legdedgenwc ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private IDataStoreProvider pr_default ;
   private byte[] H009G2_A778F1357CSec ;
   private String[] H009G2_A777F1357CPer ;
   private byte[] H009G2_A784F1357CTipoPre ;
   private short[] H009G2_A1EmpCod ;
   private int[] H009G2_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class f1357cabview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H009G2", "SELECT F1357CSec, F1357CPer, F1357CTipoPre, EmpCod, CliCod FROM F1357Cab WHERE (CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) and F1357CSec = ?) AND (CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) and F1357CSec = ?) ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setString(9, (String)parms[8], 6);
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               return;
      }
   }

}

