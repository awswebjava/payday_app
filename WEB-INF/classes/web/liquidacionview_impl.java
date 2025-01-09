package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacionview_impl extends GXDataArea
{
   public liquidacionview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacionview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionview_impl.class ));
   }

   public liquidacionview_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "auxMenuOpcCod") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "auxMenuOpcCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "auxMenuOpcCod") ;
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
            AV31auxMenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31auxMenuOpcCod", AV31auxMenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31auxMenuOpcCod, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV13CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13CliCod), 6, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13CliCod), "ZZZZZ9")));
               AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
               AV10LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV10LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LiqNro), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LiqNro), "ZZZZZZZ9")));
               AV7TabCode = httpContext.GetPar( "TabCode") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV7TabCode", AV7TabCode);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7TabCode, ""))));
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
      pa502( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start502( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacionview", new String[] {GXutil.URLEncode(GXutil.rtrim(AV31auxMenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV13CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LiqNro,8,0)),GXutil.URLEncode(GXutil.rtrim(AV7TabCode))}, new String[] {"auxMenuOpcCod","CliCod","EmpCod","LiqNro","TabCode"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30lsdPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31auxMenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7TabCode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV13CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQNRO", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQNRO", GXutil.ltrim( localUtil.ntoc( AV10LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vLOADALLTABS", AV11LoadAllTabs);
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDTABCODE", GXutil.rtrim( AV12SelectedTabCode));
      web.GxWebStd.gx_hidden_field( httpContext, "vAUXMENUOPCCOD", AV31auxMenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31auxMenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSDPALABRA", GXutil.rtrim( AV30lsdPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30lsdPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV22MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTABCODE", GXutil.rtrim( AV7TabCode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7TabCode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Class", GXutil.rtrim( Tabs_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Historymanagement", GXutil.booltostr( Tabs_Historymanagement));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
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
      if ( ! ( WebComp_Liquidacionabmwc == null ) )
      {
         WebComp_Liquidacionabmwc.componentjscripts();
      }
      if ( ! ( WebComp_Liquidacionlegajowc == null ) )
      {
         WebComp_Liquidacionlegajowc.componentjscripts();
      }
      if ( ! ( WebComp_Lsd_reg1wwwc == null ) )
      {
         WebComp_Lsd_reg1wwwc.componentjscripts();
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
         we502( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt502( ) ;
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
      return formatLink("web.liquidacionview", new String[] {GXutil.URLEncode(GXutil.rtrim(AV31auxMenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV13CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LiqNro,8,0)),GXutil.URLEncode(GXutil.rtrim(AV7TabCode))}, new String[] {"auxMenuOpcCod","CliCod","EmpCod","LiqNro","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "LiquidacionView" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liquidacion View", "") ;
   }

   public void wb500( )
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
         wb_table1_9_502( true) ;
      }
      else
      {
         wb_table1_9_502( false) ;
      }
      return  ;
   }

   public void wb_table1_9_502e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDate_Internalname, localUtil.format(AV19Date, "99/99/99"), localUtil.format( AV19Date, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,80);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDate_Jsonclick, 0, "Attribute", "", "", "", "", edtavDate_Visible, 1, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Periodo", "right", false, "", "HLP_LiquidacionView.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavDate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavDate_Visible==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionView.htm");
         httpContext.writeTextNL( "</div>") ;
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLiqperiodo_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqperiodo_Internalname, localUtil.format(AV20LiqPeriodo, "99/99/9999"), localUtil.format( AV20LiqPeriodo, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,81);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqperiodo_Jsonclick, 0, "Attribute", "", "", "", "", edtavLiqperiodo_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionView.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLiqperiodo_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavLiqperiodo_Visible==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionView.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start502( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Liquidacion View", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup500( ) ;
   }

   public void ws502( )
   {
      start502( ) ;
      evt502( ) ;
   }

   public void evt502( )
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
                        else if ( GXutil.strcmp(sEvt, "TABS.TABCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11502 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e12502 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e13502 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14502 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOVOLVER'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoVolver' */
                           e15502 ();
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
                     if ( nCmpId == 60 )
                     {
                        OldLiquidacionabmwc = httpContext.cgiGet( "W0060") ;
                        if ( ( GXutil.len( OldLiquidacionabmwc) == 0 ) || ( GXutil.strcmp(OldLiquidacionabmwc, WebComp_Liquidacionabmwc_Component) != 0 ) )
                        {
                           WebComp_Liquidacionabmwc = WebUtils.getWebComponent(getClass(), "web." + OldLiquidacionabmwc + "_impl", remoteHandle, context);
                           WebComp_Liquidacionabmwc_Component = OldLiquidacionabmwc ;
                        }
                        if ( GXutil.len( WebComp_Liquidacionabmwc_Component) != 0 )
                        {
                           WebComp_Liquidacionabmwc.componentprocess("W0060", "", sEvt);
                        }
                        WebComp_Liquidacionabmwc_Component = OldLiquidacionabmwc ;
                     }
                     else if ( nCmpId == 68 )
                     {
                        OldLiquidacionlegajowc = httpContext.cgiGet( "W0068") ;
                        if ( ( GXutil.len( OldLiquidacionlegajowc) == 0 ) || ( GXutil.strcmp(OldLiquidacionlegajowc, WebComp_Liquidacionlegajowc_Component) != 0 ) )
                        {
                           WebComp_Liquidacionlegajowc = WebUtils.getWebComponent(getClass(), "web." + OldLiquidacionlegajowc + "_impl", remoteHandle, context);
                           WebComp_Liquidacionlegajowc_Component = OldLiquidacionlegajowc ;
                        }
                        if ( GXutil.len( WebComp_Liquidacionlegajowc_Component) != 0 )
                        {
                           WebComp_Liquidacionlegajowc.componentprocess("W0068", "", sEvt);
                        }
                        WebComp_Liquidacionlegajowc_Component = OldLiquidacionlegajowc ;
                     }
                     else if ( nCmpId == 76 )
                     {
                        OldLsd_reg1wwwc = httpContext.cgiGet( "W0076") ;
                        if ( ( GXutil.len( OldLsd_reg1wwwc) == 0 ) || ( GXutil.strcmp(OldLsd_reg1wwwc, WebComp_Lsd_reg1wwwc_Component) != 0 ) )
                        {
                           WebComp_Lsd_reg1wwwc = WebUtils.getWebComponent(getClass(), "web." + OldLsd_reg1wwwc + "_impl", remoteHandle, context);
                           WebComp_Lsd_reg1wwwc_Component = OldLsd_reg1wwwc ;
                        }
                        if ( GXutil.len( WebComp_Lsd_reg1wwwc_Component) != 0 )
                        {
                           WebComp_Lsd_reg1wwwc.componentprocess("W0076", "", sEvt);
                        }
                        WebComp_Lsd_reg1wwwc_Component = OldLsd_reg1wwwc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we502( )
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

   public void pa502( )
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
      AV29WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV29WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29WelcomeMessage_NoMostrarMas", AV29WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf502( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV39Pgmname = "LiquidacionView" ;
      Gx_err = (short)(0) ;
   }

   public void rf502( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Liquidacionabmwc_Component) != 0 )
            {
               WebComp_Liquidacionabmwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Liquidacionlegajowc_Component) != 0 )
            {
               WebComp_Liquidacionlegajowc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Lsd_reg1wwwc_Component) != 0 )
            {
               WebComp_Lsd_reg1wwwc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e13502 ();
         wb500( ) ;
      }
   }

   public void send_integrity_lvl_hashes502( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSDPALABRA", GXutil.rtrim( AV30lsdPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30lsdPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV22MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22MenuOpcCod, ""))));
   }

   public void before_start_formulas( )
   {
      AV39Pgmname = "LiquidacionView" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup500( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12502 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Tabs_Activepagecontrolname = httpContext.cgiGet( "TABS_Activepagecontrolname") ;
         Tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Tabs_Class = httpContext.cgiGet( "TABS_Class") ;
         Tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TABS_Historymanagement")) ;
         Tabs_Activepagecontrolname = httpContext.cgiGet( "TABS_Activepagecontrolname") ;
         /* Read variables values. */
         AV28WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV29WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29WelcomeMessage_NoMostrarMas", AV29WelcomeMessage_NoMostrarMas);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavDate_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vDATE");
            GX_FocusControl = edtavDate_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Date = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19Date", localUtil.format(AV19Date, "99/99/99"));
         }
         else
         {
            AV19Date = localUtil.ctod( httpContext.cgiGet( edtavDate_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19Date", localUtil.format(AV19Date, "99/99/99"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLiqperiodo_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLIQPERIODO");
            GX_FocusControl = edtavLiqperiodo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV20LiqPeriodo = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20LiqPeriodo", localUtil.format(AV20LiqPeriodo, "99/99/9999"));
         }
         else
         {
            AV20LiqPeriodo = localUtil.ctod( httpContext.cgiGet( edtavLiqperiodo_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20LiqPeriodo", localUtil.format(AV20LiqPeriodo, "99/99/9999"));
         }
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
      e12502 ();
      if (returnInSub) return;
   }

   public void e12502( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV30lsdPalabra = httpContext.getMessage( "LiquidacionLSD", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30lsdPalabra", AV30lsdPalabra);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30lsdPalabra, ""))));
      new web.setearensesion(remoteHandle, context).execute( httpContext.getMessage( "&LiqNro", ""), GXutil.trim( GXutil.str( AV10LiqNro, 8, 0))) ;
      GXv_date1[0] = AV20LiqPeriodo ;
      new web.getperiodoliquidacion(remoteHandle, context).execute( AV13CliCod, AV9EmpCod, AV10LiqNro, GXv_date1) ;
      liquidacionview_impl.this.AV20LiqPeriodo = GXv_date1[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20LiqPeriodo", localUtil.format(AV20LiqPeriodo, "99/99/9999"));
      Gx_mode = httpContext.getMessage( "DSP", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "&TabCode ", "")+AV7TabCode) ;
      AV22MenuOpcCod = AV7TabCode ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22MenuOpcCod", AV22MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22MenuOpcCod, ""))));
      GXv_SdtWWPContext2[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext2) ;
      AV6WWPContext = GXv_SdtWWPContext2[0] ;
      AV40GXLvl18 = (byte)(0) ;
      /* Using cursor H00502 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV13CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = H00502_A31LiqNro[0] ;
         A1EmpCod = H00502_A1EmpCod[0] ;
         A3CliCod = H00502_A3CliCod[0] ;
         A874LiqNombre = H00502_A874LiqNombre[0] ;
         AV40GXLvl18 = (byte)(1) ;
         Form.setCaption( httpContext.getMessage( "Liquidación ", "")+GXutil.trim( A874LiqNombre) );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV8Exists = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV40GXLvl18 == 0 )
      {
         Form.setCaption( httpContext.getMessage( "WWP_RecordNotFound", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV8Exists = false ;
      }
      if ( AV8Exists )
      {
         AV12SelectedTabCode = AV7TabCode ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12SelectedTabCode", AV12SelectedTabCode);
         Tabs_Activepagecontrolname = AV12SelectedTabCode ;
         ucTabs.sendProperty(context, "", false, Tabs_Internalname, "ActivePageControlName", Tabs_Activepagecontrolname);
         /* Execute user subroutine: 'LOADTABS' */
         S112 ();
         if (returnInSub) return;
      }
      GXv_char3[0] = AV23MenuBienveImgURL ;
      GXv_char4[0] = AV25MenuBienveTitulo ;
      GXv_char5[0] = AV24MenuBienveTexto ;
      GXv_boolean6[0] = AV26MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV22MenuOpcCod, GXv_char3, GXv_char4, GXv_char5, GXv_boolean6) ;
      liquidacionview_impl.this.AV23MenuBienveImgURL = GXv_char3[0] ;
      liquidacionview_impl.this.AV25MenuBienveTitulo = GXv_char4[0] ;
      liquidacionview_impl.this.AV24MenuBienveTexto = GXv_char5[0] ;
      liquidacionview_impl.this.AV26MenuBienveVisible = GXv_boolean6[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV26MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV26MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV25MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV24MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV28WelcomeMessage_Foto = AV23MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV28WelcomeMessage_Foto)==0) ? AV41Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV28WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV28WelcomeMessage_Foto), true);
         AV41Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV23MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV28WelcomeMessage_Foto)==0) ? AV41Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV28WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV28WelcomeMessage_Foto), true);
      }
      GXt_char7 = "" ;
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char5) ;
      liquidacionview_impl.this.GXt_char8 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char8, GXv_char4) ;
      liquidacionview_impl.this.GXt_char7 = GXv_char4[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char7 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
   }

   protected void nextLoad( )
   {
   }

   protected void e13502( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtavDate_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDate_Visible), 5, 0), true);
      edtavLiqperiodo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqperiodo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqperiodo_Visible), 5, 0), true);
   }

   public void e11502( )
   {
      /* Tabs_Tabchanged Routine */
      returnInSub = false ;
      AV12SelectedTabCode = Tabs_Activepagecontrolname ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12SelectedTabCode", AV12SelectedTabCode);
      AV11LoadAllTabs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11LoadAllTabs", AV11LoadAllTabs);
      /* Execute user subroutine: 'LOADTABS' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADTABS' Routine */
      returnInSub = false ;
      /* Using cursor H00503 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV13CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A31LiqNro = H00503_A31LiqNro[0] ;
         A1EmpCod = H00503_A1EmpCod[0] ;
         A3CliCod = H00503_A3CliCod[0] ;
         GXt_boolean9 = AV17TempBoolean ;
         GXv_boolean6[0] = GXt_boolean9 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "LiquidacionABM", GXv_boolean6) ;
         liquidacionview_impl.this.GXt_boolean9 = GXv_boolean6[0] ;
         AV17TempBoolean = GXt_boolean9 ;
         if ( AV17TempBoolean )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV12SelectedTabCode, "LiquidacionABM") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Liquidacionabmwc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Liquidacionabmwc_Component), GXutil.lower( "LiquidacionABM")) != 0 )
               {
                  WebComp_Liquidacionabmwc = WebUtils.getWebComponent(getClass(), "web.liquidacionabm_impl", remoteHandle, context);
                  WebComp_Liquidacionabmwc_Component = "LiquidacionABM" ;
               }
               if ( GXutil.len( WebComp_Liquidacionabmwc_Component) != 0 )
               {
                  WebComp_Liquidacionabmwc.setjustcreated();
                  WebComp_Liquidacionabmwc.componentprepare(new Object[] {"W0060","",AV31auxMenuOpcCod,Gx_mode,Integer.valueOf(AV13CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LiqNro)});
                  WebComp_Liquidacionabmwc.componentbind(new Object[] {"","","","",""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Liquidacionabmwc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0060"+"");
                  WebComp_Liquidacionabmwc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(1)});
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "LiquidacionLegajo") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Liquidacionlegajowc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Liquidacionlegajowc_Component), GXutil.lower( "LiquidacionLegajoWC")) != 0 )
            {
               WebComp_Liquidacionlegajowc = WebUtils.getWebComponent(getClass(), "web.liquidacionlegajowc_impl", remoteHandle, context);
               WebComp_Liquidacionlegajowc_Component = "LiquidacionLegajoWC" ;
            }
            if ( GXutil.len( WebComp_Liquidacionlegajowc_Component) != 0 )
            {
               WebComp_Liquidacionlegajowc.setjustcreated();
               WebComp_Liquidacionlegajowc.componentprepare(new Object[] {"W0068","",AV31auxMenuOpcCod,Integer.valueOf(AV13CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LiqNro)});
               WebComp_Liquidacionlegajowc.componentbind(new Object[] {"","","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Liquidacionlegajowc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0068"+"");
               WebComp_Liquidacionlegajowc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         GXt_boolean9 = AV17TempBoolean ;
         GXv_boolean6[0] = GXt_boolean9 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg1", GXv_boolean6) ;
         liquidacionview_impl.this.GXt_boolean9 = GXv_boolean6[0] ;
         AV17TempBoolean = GXt_boolean9 ;
         if ( AV17TempBoolean )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "LSD_reg1WW") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Lsd_reg1wwwc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Lsd_reg1wwwc_Component), GXutil.lower( "LSD_reg1WW")) != 0 )
               {
                  WebComp_Lsd_reg1wwwc = WebUtils.getWebComponent(getClass(), "web.lsd_reg1ww_impl", remoteHandle, context);
                  WebComp_Lsd_reg1wwwc_Component = "LSD_reg1WW" ;
               }
               if ( GXutil.len( WebComp_Lsd_reg1wwwc_Component) != 0 )
               {
                  WebComp_Lsd_reg1wwwc.setjustcreated();
                  WebComp_Lsd_reg1wwwc.componentprepare(new Object[] {"W0076","",AV30lsdPalabra,Integer.valueOf(AV13CliCod),Short.valueOf(AV9EmpCod),AV20LiqPeriodo,Integer.valueOf(AV10LiqNro)});
                  WebComp_Lsd_reg1wwwc.componentbind(new Object[] {"","","","vLIQPERIODO",""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Lsd_reg1wwwc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0076"+"");
                  WebComp_Lsd_reg1wwwc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(3)});
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      new web.setopcionmenusesion(remoteHandle, context).execute( httpContext.getMessage( "Liquidaciones", ""), "", "") ;
      httpContext.doAjaxRefresh();
   }

   public void e14502( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV29WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean6[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV22MenuOpcCod, GXv_boolean6) ;
         GXv_char5[0] = AV27textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char5) ;
         liquidacionview_impl.this.AV27textoNoMostrara = GXv_char5[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV27textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean6[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV22MenuOpcCod, GXv_boolean6) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void e15502( )
   {
      /* 'DoVolver' Routine */
      returnInSub = false ;
      if ( true )
      {
         GXv_date1[0] = AV21PeriodoLiq ;
         new web.getliqperiodoliq(remoteHandle, context).execute( AV13CliCod, AV9EmpCod, AV10LiqNro, GXv_date1) ;
         liquidacionview_impl.this.AV21PeriodoLiq = GXv_date1[0] ;
         callWebObject(formatLink("web.periodoview", new String[] {GXutil.URLEncode(GXutil.rtrim(AV31auxMenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV13CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV21PeriodoLiq)),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "LiquidacionWW", "")))}, new String[] {"MenuOpcCod","CliCod","EmpCod","PeriodoLiq","TabCode"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
      }
   }

   public void wb_table1_9_502( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e16501_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_LiquidacionView.htm");
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
         AV28WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV28WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV41Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV28WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV28WelcomeMessage_Foto)==0) ? AV41Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV28WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV28WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_LiquidacionView.htm");
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
         wb_table2_27_502( true) ;
      }
      else
      {
         wb_table2_27_502( false) ;
      }
      return  ;
   }

   public void wb_table2_27_502e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table3_32_502( true) ;
      }
      else
      {
         wb_table3_32_502( false) ;
      }
      return  ;
   }

   public void wb_table3_32_502e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV29WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,42);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionView.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellViewTabsPosition P0'>") ;
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblLiquidacionabm_title_Internalname, httpContext.getMessage( "General", ""), "", "", lblLiquidacionabm_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "LiquidacionABM") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableliquidacionabm_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0060"+"", GXutil.rtrim( WebComp_Liquidacionabmwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0060"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Liquidacionabmwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLiquidacionabmwc), GXutil.lower( WebComp_Liquidacionabmwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0060"+"");
               }
               WebComp_Liquidacionabmwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldLiquidacionabmwc), GXutil.lower( WebComp_Liquidacionabmwc_Component)) != 0 )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblLiquidacionlegajo_title_Internalname, httpContext.getMessage( "Recibos", ""), "", "", lblLiquidacionlegajo_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "LiquidacionLegajo") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableliquidacionlegajo_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0068"+"", GXutil.rtrim( WebComp_Liquidacionlegajowc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0068"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Liquidacionlegajowc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLiquidacionlegajowc), GXutil.lower( WebComp_Liquidacionlegajowc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0068"+"");
               }
               WebComp_Liquidacionlegajowc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldLiquidacionlegajowc), GXutil.lower( WebComp_Liquidacionlegajowc_Component)) != 0 )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblLsd_reg1ww_title_Internalname, httpContext.getMessage( "Libro de sueldos digital", ""), "", "", lblLsd_reg1ww_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "LSD_reg1WW") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelsd_reg1ww_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0076"+"", GXutil.rtrim( WebComp_Lsd_reg1wwwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0076"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Lsd_reg1wwwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLsd_reg1wwwc), GXutil.lower( WebComp_Lsd_reg1wwwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0076"+"");
               }
               WebComp_Lsd_reg1wwwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldLsd_reg1wwwc), GXutil.lower( WebComp_Lsd_reg1wwwc_Component)) != 0 )
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
         wb_table1_9_502e( true) ;
      }
      else
      {
         wb_table1_9_502e( false) ;
      }
   }

   public void wb_table3_32_502( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionView.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_32_502e( true) ;
      }
      else
      {
         wb_table3_32_502e( false) ;
      }
   }

   public void wb_table2_27_502( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionView.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_27_502e( true) ;
      }
      else
      {
         wb_table2_27_502e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV31auxMenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31auxMenuOpcCod", AV31auxMenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31auxMenuOpcCod, ""))));
      AV13CliCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13CliCod), "ZZZZZ9")));
      AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      AV10LiqNro = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LiqNro), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LiqNro), "ZZZZZZZ9")));
      AV7TabCode = (String)getParm(obj,4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7TabCode", AV7TabCode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7TabCode, ""))));
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
      pa502( ) ;
      ws502( ) ;
      we502( ) ;
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
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Liquidacionabmwc == null ) )
      {
         if ( GXutil.len( WebComp_Liquidacionabmwc_Component) != 0 )
         {
            WebComp_Liquidacionabmwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Liquidacionlegajowc == null ) )
      {
         if ( GXutil.len( WebComp_Liquidacionlegajowc_Component) != 0 )
         {
            WebComp_Liquidacionlegajowc.componentthemes();
         }
      }
      if ( ! ( WebComp_Lsd_reg1wwwc == null ) )
      {
         if ( GXutil.len( WebComp_Lsd_reg1wwwc_Component) != 0 )
         {
            WebComp_Lsd_reg1wwwc.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171352350", true, true);
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
      httpContext.AddJavascriptSource("liquidacionview.js", "?2025171352350", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      /* End function include_jscripts */
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
      lblLiquidacionabm_title_Internalname = "LIQUIDACIONABM_TITLE" ;
      divUnnamedtableliquidacionabm_Internalname = "UNNAMEDTABLELIQUIDACIONABM" ;
      lblLiquidacionlegajo_title_Internalname = "LIQUIDACIONLEGAJO_TITLE" ;
      divUnnamedtableliquidacionlegajo_Internalname = "UNNAMEDTABLELIQUIDACIONLEGAJO" ;
      lblLsd_reg1ww_title_Internalname = "LSD_REG1WW_TITLE" ;
      divUnnamedtablelsd_reg1ww_Internalname = "UNNAMEDTABLELSD_REG1WW" ;
      Tabs_Internalname = "TABS" ;
      divUnnamedtableviewcontainer_Internalname = "UNNAMEDTABLEVIEWCONTAINER" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavDate_Internalname = "vDATE" ;
      edtavLiqperiodo_Internalname = "vLIQPERIODO" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
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
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      edtavLiqperiodo_Jsonclick = "" ;
      edtavLiqperiodo_Visible = 1 ;
      edtavDate_Jsonclick = "" ;
      edtavDate_Visible = 1 ;
      Tabs_Historymanagement = GXutil.toBoolean( -1) ;
      Tabs_Class = "P0" ;
      Tabs_Pagecount = 3 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Liquidacion View", "") );
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
      AV29WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV29WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29WelcomeMessage_NoMostrarMas", AV29WelcomeMessage_NoMostrarMas);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV29WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV13CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV10LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV31auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV30lsdPalabra',fld:'vLSDPALABRA',pic:'',hsh:true},{av:'AV22MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV7TabCode',fld:'vTABCODE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("TABS.TABCHANGED","{handler:'e11502',iparms:[{av:'Tabs_Activepagecontrolname',ctrl:'TABS',prop:'ActivePageControlName'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV13CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'AV10LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV11LoadAllTabs',fld:'vLOADALLTABS',pic:''},{av:'AV12SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'AV31auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV30lsdPalabra',fld:'vLSDPALABRA',pic:'',hsh:true},{av:'AV20LiqPeriodo',fld:'vLIQPERIODO',pic:''}]");
      setEventMetadata("TABS.TABCHANGED",",oparms:[{av:'AV12SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'AV11LoadAllTabs',fld:'vLOADALLTABS',pic:''},{ctrl:'LIQUIDACIONABMWC'},{ctrl:'LIQUIDACIONLEGAJOWC'},{ctrl:'LSD_REG1WWWC'}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e14502',iparms:[{av:'AV29WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV22MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e16501',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("'DOVOLVER'","{handler:'e15502',iparms:[{av:'AV13CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV10LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV31auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("'DOVOLVER'",",oparms:[]}");
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
      wcpOAV31auxMenuOpcCod = "" ;
      wcpOAV7TabCode = "" ;
      Tabs_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV31auxMenuOpcCod = "" ;
      AV7TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gx_mode = "" ;
      AV30lsdPalabra = "" ;
      AV22MenuOpcCod = "" ;
      GXKey = "" ;
      AV12SelectedTabCode = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      AV19Date = GXutil.nullDate() ;
      AV20LiqPeriodo = GXutil.nullDate() ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldLiquidacionabmwc = "" ;
      WebComp_Liquidacionabmwc_Component = "" ;
      OldLiquidacionlegajowc = "" ;
      WebComp_Liquidacionlegajowc_Component = "" ;
      OldLsd_reg1wwwc = "" ;
      WebComp_Lsd_reg1wwwc_Component = "" ;
      AV39Pgmname = "" ;
      AV28WelcomeMessage_Foto = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext2 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H00502_A31LiqNro = new int[1] ;
      H00502_A1EmpCod = new short[1] ;
      H00502_A3CliCod = new int[1] ;
      H00502_A874LiqNombre = new String[] {""} ;
      A874LiqNombre = "" ;
      ucTabs = new com.genexus.webpanels.GXUserControl();
      AV23MenuBienveImgURL = "" ;
      GXv_char3 = new String[1] ;
      AV25MenuBienveTitulo = "" ;
      AV24MenuBienveTexto = "" ;
      AV41Welcomemessage_foto_GXI = "" ;
      GXt_char7 = "" ;
      GXt_char8 = "" ;
      GXv_char4 = new String[1] ;
      H00503_A31LiqNro = new int[1] ;
      H00503_A1EmpCod = new short[1] ;
      H00503_A3CliCod = new int[1] ;
      AV27textoNoMostrara = "" ;
      GXv_char5 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      AV21PeriodoLiq = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      sStyleString = "" ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblLiquidacionabm_title_Jsonclick = "" ;
      lblLiquidacionlegajo_title_Jsonclick = "" ;
      lblLsd_reg1ww_title_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionview__default(),
         new Object[] {
             new Object[] {
            H00502_A31LiqNro, H00502_A1EmpCod, H00502_A3CliCod, H00502_A874LiqNombre
            }
            , new Object[] {
            H00503_A31LiqNro, H00503_A1EmpCod, H00503_A3CliCod
            }
         }
      );
      AV39Pgmname = "LiquidacionView" ;
      /* GeneXus formulas. */
      AV39Pgmname = "LiquidacionView" ;
      Gx_err = (short)(0) ;
      WebComp_Liquidacionabmwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Liquidacionlegajowc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Lsd_reg1wwwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV40GXLvl18 ;
   private byte nGXWrapped ;
   private short wcpOAV9EmpCod ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV13CliCod ;
   private int wcpOAV10LiqNro ;
   private int AV13CliCod ;
   private int AV10LiqNro ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int Tabs_Pagecount ;
   private int edtavDate_Visible ;
   private int edtavLiqperiodo_Visible ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int idxLst ;
   private String wcpOAV7TabCode ;
   private String Tabs_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV7TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String Gx_mode ;
   private String AV30lsdPalabra ;
   private String GXKey ;
   private String AV12SelectedTabCode ;
   private String Tabs_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavDate_Internalname ;
   private String edtavDate_Jsonclick ;
   private String edtavLiqperiodo_Internalname ;
   private String edtavLiqperiodo_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String OldLiquidacionabmwc ;
   private String WebComp_Liquidacionabmwc_Component ;
   private String OldLiquidacionlegajowc ;
   private String WebComp_Liquidacionlegajowc_Component ;
   private String OldLsd_reg1wwwc ;
   private String WebComp_Lsd_reg1wwwc_Component ;
   private String AV39Pgmname ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String scmdbuf ;
   private String Tabs_Internalname ;
   private String GXv_char3[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String GXt_char7 ;
   private String GXt_char8 ;
   private String GXv_char4[] ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String GXv_char5[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divWelcomemessage_welcometableprincipal_Internalname ;
   private String divWelcomemessage_tableclose_Internalname ;
   private String lblWelcomemessage_closehelp_Jsonclick ;
   private String divWelcomemessage_welcomecontentitem_Internalname ;
   private String divWelcomemessage_welcomecontentflex_Internalname ;
   private String divWelcomemessage_welcometableimagen_Internalname ;
   private String ClassString ;
   private String imgavWelcomemessage_foto_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String divWelcomemessage_tabletexto_Internalname ;
   private String divWelcomemessage_welcomebottomitem_Internalname ;
   private String divWelcomemessage_tablecmb_Internalname ;
   private String divWelcomemessage_tablec_Internalname ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String lblLiquidacionabm_title_Internalname ;
   private String lblLiquidacionabm_title_Jsonclick ;
   private String divUnnamedtableliquidacionabm_Internalname ;
   private String lblLiquidacionlegajo_title_Internalname ;
   private String lblLiquidacionlegajo_title_Jsonclick ;
   private String divUnnamedtableliquidacionlegajo_Internalname ;
   private String lblLsd_reg1ww_title_Internalname ;
   private String lblLsd_reg1ww_title_Jsonclick ;
   private String divUnnamedtablelsd_reg1ww_Internalname ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private java.util.Date AV19Date ;
   private java.util.Date AV20LiqPeriodo ;
   private java.util.Date AV21PeriodoLiq ;
   private java.util.Date GXv_date1[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV11LoadAllTabs ;
   private boolean Tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV29WelcomeMessage_NoMostrarMas ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV8Exists ;
   private boolean AV26MenuBienveVisible ;
   private boolean AV17TempBoolean ;
   private boolean bDynCreated_Liquidacionabmwc ;
   private boolean bDynCreated_Liquidacionlegajowc ;
   private boolean GXt_boolean9 ;
   private boolean bDynCreated_Lsd_reg1wwwc ;
   private boolean GXv_boolean6[] ;
   private boolean AV28WelcomeMessage_Foto_IsBlob ;
   private String AV24MenuBienveTexto ;
   private String AV27textoNoMostrara ;
   private String wcpOAV31auxMenuOpcCod ;
   private String AV31auxMenuOpcCod ;
   private String AV22MenuOpcCod ;
   private String A874LiqNombre ;
   private String AV23MenuBienveImgURL ;
   private String AV25MenuBienveTitulo ;
   private String AV41Welcomemessage_foto_GXI ;
   private String AV28WelcomeMessage_Foto ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Liquidacionabmwc ;
   private GXWebComponent WebComp_Liquidacionlegajowc ;
   private GXWebComponent WebComp_Lsd_reg1wwwc ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private IDataStoreProvider pr_default ;
   private int[] H00502_A31LiqNro ;
   private short[] H00502_A1EmpCod ;
   private int[] H00502_A3CliCod ;
   private String[] H00502_A874LiqNombre ;
   private int[] H00503_A31LiqNro ;
   private short[] H00503_A1EmpCod ;
   private int[] H00503_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext2[] ;
}

final  class liquidacionview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00502", "SELECT LiqNro, EmpCod, CliCod, LiqNombre FROM Liquidacion WHERE (CliCod = ? and EmpCod = ? and LiqNro = ?) AND (CliCod = ? and EmpCod = ? and LiqNro = ?) ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00503", "SELECT LiqNro, EmpCod, CliCod FROM Liquidacion WHERE (CliCod = ? and EmpCod = ? and LiqNro = ?) AND (CliCod = ? and EmpCod = ? and LiqNro = ?) ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
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
      }
   }

}

