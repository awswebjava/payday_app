package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajoview_impl extends GXDataArea
{
   public legajoview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajoview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajoview_impl.class ));
   }

   public legajoview_impl( int remoteHandle ,
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
            AV13CliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13CliCod), "ZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
               AV10LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LegNumero), "ZZZZZZZ9")));
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
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.masterpageframe");
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
      pa122( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start122( ) ;
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
      httpContext.writeText( " "+"class=\"form-horizontal FormSplitScreen\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormSplitScreen\" data-gx-class=\"form-horizontal FormSplitScreen\" novalidate action=\""+formatLink("web.legajoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV13CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(AV7TabCode))}, new String[] {"CliCod","EmpCod","LegNumero","TabCode"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormSplitScreen", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LegNumero), "ZZZZZZZ9")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vLOADALLTABS", AV11LoadAllTabs);
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDTABCODE", GXutil.rtrim( AV12SelectedTabCode));
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
      if ( ! ( WebComp_Generalwc == null ) )
      {
         WebComp_Generalwc.componentjscripts();
      }
      if ( ! ( WebComp_Agendanovedadeswc == null ) )
      {
         WebComp_Agendanovedadeswc.componentjscripts();
      }
      if ( ! ( WebComp_Legajolicenciaswc == null ) )
      {
         WebComp_Legajolicenciaswc.componentjscripts();
      }
      if ( ! ( WebComp_Legajocentroswc == null ) )
      {
         WebComp_Legajocentroswc.componentjscripts();
      }
      if ( ! ( WebComp_Codededuccionessolapawc == null ) )
      {
         WebComp_Codededuccionessolapawc.componentjscripts();
      }
      if ( ! ( WebComp_Liquidacionlegajowc == null ) )
      {
         WebComp_Liquidacionlegajowc.componentjscripts();
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
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormSplitScreen" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we122( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt122( ) ;
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
      return formatLink("web.legajoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV13CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(AV7TabCode))}, new String[] {"CliCod","EmpCod","LegNumero","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "LegajoView" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Legajo View", "") ;
   }

   public void wb120( )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellViewTabsPosition", "left", "top", "", "", "div");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "Datos", ""), "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoView.htm");
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
            web.GxWebStd.gx_hidden_field( httpContext, "W0020"+"", GXutil.rtrim( WebComp_Generalwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0020"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldGeneralwc), GXutil.lower( WebComp_Generalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0020"+"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblAgendanovedades_title_Internalname, httpContext.getMessage( "Horas y conceptos", ""), "", "", lblAgendanovedades_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "AgendaNovedades") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableagendanovedades_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0028"+"", GXutil.rtrim( WebComp_Agendanovedadeswc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0028"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Agendanovedadeswc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldAgendanovedadeswc), GXutil.lower( WebComp_Agendanovedadeswc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0028"+"");
               }
               WebComp_Agendanovedadeswc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldAgendanovedadeswc), GXutil.lower( WebComp_Agendanovedadeswc_Component)) != 0 )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblLegajolicencias_title_Internalname, httpContext.getMessage( "Licencias", ""), "", "", lblLegajolicencias_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "LegajoLicencias") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegajolicencias_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0036"+"", GXutil.rtrim( WebComp_Legajolicenciaswc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0036"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Legajolicenciaswc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLegajolicenciaswc), GXutil.lower( WebComp_Legajolicenciaswc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0036"+"");
               }
               WebComp_Legajolicenciaswc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldLegajolicenciaswc), GXutil.lower( WebComp_Legajolicenciaswc_Component)) != 0 )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblLegajocentros_title_Internalname, httpContext.getMessage( "Centros de Costo", ""), "", "", lblLegajocentros_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "LegajoCentros") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegajocentros_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0044"+"", GXutil.rtrim( WebComp_Legajocentroswc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0044"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Legajocentroswc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLegajocentroswc), GXutil.lower( WebComp_Legajocentroswc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0044"+"");
               }
               WebComp_Legajocentroswc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldLegajocentroswc), GXutil.lower( WebComp_Legajocentroswc_Component)) != 0 )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblCodededuccionessolapa_title_Internalname, httpContext.getMessage( "Siradig", ""), "", "", lblCodededuccionessolapa_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "CodeDeduccionesSolapa") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablecodededuccionessolapa_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0052"+"", GXutil.rtrim( WebComp_Codededuccionessolapawc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0052"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Codededuccionessolapawc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldCodededuccionessolapawc), GXutil.lower( WebComp_Codededuccionessolapawc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0052"+"");
               }
               WebComp_Codededuccionessolapawc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldCodededuccionessolapawc), GXutil.lower( WebComp_Codededuccionessolapawc_Component)) != 0 )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblLiquidacionlegajo_title_Internalname, httpContext.getMessage( "Liquidaciones", ""), "", "", lblLiquidacionlegajo_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "LiquidacionLegajo") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableliquidacionlegajo_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0060"+"", GXutil.rtrim( WebComp_Liquidacionlegajowc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0060"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Liquidacionlegajowc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLiquidacionlegajowc), GXutil.lower( WebComp_Liquidacionlegajowc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0060"+"");
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

   public void start122( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Legajo View", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup120( ) ;
   }

   public void ws122( )
   {
      start122( ) ;
      evt122( ) ;
   }

   public void evt122( )
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
                           e11122 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e12122 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e13122 ();
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
                     if ( nCmpId == 20 )
                     {
                        OldGeneralwc = httpContext.cgiGet( "W0020") ;
                        if ( ( GXutil.len( OldGeneralwc) == 0 ) || ( GXutil.strcmp(OldGeneralwc, WebComp_Generalwc_Component) != 0 ) )
                        {
                           WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "web." + OldGeneralwc + "_impl", remoteHandle, context);
                           WebComp_Generalwc_Component = OldGeneralwc ;
                        }
                        if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
                        {
                           WebComp_Generalwc.componentprocess("W0020", "", sEvt);
                        }
                        WebComp_Generalwc_Component = OldGeneralwc ;
                     }
                     else if ( nCmpId == 28 )
                     {
                        OldAgendanovedadeswc = httpContext.cgiGet( "W0028") ;
                        if ( ( GXutil.len( OldAgendanovedadeswc) == 0 ) || ( GXutil.strcmp(OldAgendanovedadeswc, WebComp_Agendanovedadeswc_Component) != 0 ) )
                        {
                           WebComp_Agendanovedadeswc = WebUtils.getWebComponent(getClass(), "web." + OldAgendanovedadeswc + "_impl", remoteHandle, context);
                           WebComp_Agendanovedadeswc_Component = OldAgendanovedadeswc ;
                        }
                        if ( GXutil.len( WebComp_Agendanovedadeswc_Component) != 0 )
                        {
                           WebComp_Agendanovedadeswc.componentprocess("W0028", "", sEvt);
                        }
                        WebComp_Agendanovedadeswc_Component = OldAgendanovedadeswc ;
                     }
                     else if ( nCmpId == 36 )
                     {
                        OldLegajolicenciaswc = httpContext.cgiGet( "W0036") ;
                        if ( ( GXutil.len( OldLegajolicenciaswc) == 0 ) || ( GXutil.strcmp(OldLegajolicenciaswc, WebComp_Legajolicenciaswc_Component) != 0 ) )
                        {
                           WebComp_Legajolicenciaswc = WebUtils.getWebComponent(getClass(), "web." + OldLegajolicenciaswc + "_impl", remoteHandle, context);
                           WebComp_Legajolicenciaswc_Component = OldLegajolicenciaswc ;
                        }
                        if ( GXutil.len( WebComp_Legajolicenciaswc_Component) != 0 )
                        {
                           WebComp_Legajolicenciaswc.componentprocess("W0036", "", sEvt);
                        }
                        WebComp_Legajolicenciaswc_Component = OldLegajolicenciaswc ;
                     }
                     else if ( nCmpId == 44 )
                     {
                        OldLegajocentroswc = httpContext.cgiGet( "W0044") ;
                        if ( ( GXutil.len( OldLegajocentroswc) == 0 ) || ( GXutil.strcmp(OldLegajocentroswc, WebComp_Legajocentroswc_Component) != 0 ) )
                        {
                           WebComp_Legajocentroswc = WebUtils.getWebComponent(getClass(), "web." + OldLegajocentroswc + "_impl", remoteHandle, context);
                           WebComp_Legajocentroswc_Component = OldLegajocentroswc ;
                        }
                        if ( GXutil.len( WebComp_Legajocentroswc_Component) != 0 )
                        {
                           WebComp_Legajocentroswc.componentprocess("W0044", "", sEvt);
                        }
                        WebComp_Legajocentroswc_Component = OldLegajocentroswc ;
                     }
                     else if ( nCmpId == 52 )
                     {
                        OldCodededuccionessolapawc = httpContext.cgiGet( "W0052") ;
                        if ( ( GXutil.len( OldCodededuccionessolapawc) == 0 ) || ( GXutil.strcmp(OldCodededuccionessolapawc, WebComp_Codededuccionessolapawc_Component) != 0 ) )
                        {
                           WebComp_Codededuccionessolapawc = WebUtils.getWebComponent(getClass(), "web." + OldCodededuccionessolapawc + "_impl", remoteHandle, context);
                           WebComp_Codededuccionessolapawc_Component = OldCodededuccionessolapawc ;
                        }
                        if ( GXutil.len( WebComp_Codededuccionessolapawc_Component) != 0 )
                        {
                           WebComp_Codededuccionessolapawc.componentprocess("W0052", "", sEvt);
                        }
                        WebComp_Codededuccionessolapawc_Component = OldCodededuccionessolapawc ;
                     }
                     else if ( nCmpId == 60 )
                     {
                        OldLiquidacionlegajowc = httpContext.cgiGet( "W0060") ;
                        if ( ( GXutil.len( OldLiquidacionlegajowc) == 0 ) || ( GXutil.strcmp(OldLiquidacionlegajowc, WebComp_Liquidacionlegajowc_Component) != 0 ) )
                        {
                           WebComp_Liquidacionlegajowc = WebUtils.getWebComponent(getClass(), "web." + OldLiquidacionlegajowc + "_impl", remoteHandle, context);
                           WebComp_Liquidacionlegajowc_Component = OldLiquidacionlegajowc ;
                        }
                        if ( GXutil.len( WebComp_Liquidacionlegajowc_Component) != 0 )
                        {
                           WebComp_Liquidacionlegajowc.componentprocess("W0060", "", sEvt);
                        }
                        WebComp_Liquidacionlegajowc_Component = OldLiquidacionlegajowc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we122( )
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

   public void pa122( )
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
      rf122( ) ;
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

   public void rf122( )
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
            if ( GXutil.len( WebComp_Agendanovedadeswc_Component) != 0 )
            {
               WebComp_Agendanovedadeswc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Legajolicenciaswc_Component) != 0 )
            {
               WebComp_Legajolicenciaswc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Legajocentroswc_Component) != 0 )
            {
               WebComp_Legajocentroswc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Codededuccionessolapawc_Component) != 0 )
            {
               WebComp_Codededuccionessolapawc.componentstart();
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
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e13122 ();
         wb120( ) ;
      }
   }

   public void send_integrity_lvl_hashes122( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup120( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12122 ();
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
      e12122 ();
      if (returnInSub) return;
   }

   public void e12122( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV18TrnMode = "DSP" ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      AV21GXLvl10 = (byte)(0) ;
      /* Using cursor H00122 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), Integer.valueOf(AV13CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = H00122_A6LegNumero[0] ;
         A1EmpCod = H00122_A1EmpCod[0] ;
         A3CliCod = H00122_A3CliCod[0] ;
         A250LegIdNomApe = H00122_A250LegIdNomApe[0] ;
         AV21GXLvl10 = (byte)(1) ;
         Form.setCaption( GXutil.trim( A250LegIdNomApe) );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV8Exists = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV21GXLvl10 == 0 )
      {
         divLayoutmaintable_Class = divLayoutmaintable_Class+" Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
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
   }

   protected void nextLoad( )
   {
   }

   protected void e13122( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void e11122( )
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
      /* Using cursor H00123 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), Integer.valueOf(AV13CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A6LegNumero = H00123_A6LegNumero[0] ;
         A1EmpCod = H00123_A1EmpCod[0] ;
         A3CliCod = H00123_A3CliCod[0] ;
         if ( false )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV12SelectedTabCode, "General") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Generalwc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Generalwc_Component), GXutil.lower( "LegajoGeneral")) != 0 )
               {
                  WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "web.legajogeneral_impl", remoteHandle, context);
                  WebComp_Generalwc_Component = "LegajoGeneral" ;
               }
               if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
               {
                  WebComp_Generalwc.setjustcreated();
                  WebComp_Generalwc.componentprepare(new Object[] {"W0020","",Integer.valueOf(AV13CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LegNumero)});
                  WebComp_Generalwc.componentbind(new Object[] {"","",""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Generalwc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0020"+"");
                  WebComp_Generalwc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(1)});
         }
         GXt_boolean2 = AV17TempBoolean ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAgendaNovedades", GXv_boolean3) ;
         legajoview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV17TempBoolean = GXt_boolean2 ;
         if ( AV17TempBoolean )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "AgendaNovedades") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Agendanovedadeswc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Agendanovedadeswc_Component), GXutil.lower( "LegajoAgendaNovedadesWC")) != 0 )
               {
                  WebComp_Agendanovedadeswc = WebUtils.getWebComponent(getClass(), "web.legajoagendanovedadeswc_impl", remoteHandle, context);
                  WebComp_Agendanovedadeswc_Component = "LegajoAgendaNovedadesWC" ;
               }
               if ( GXutil.len( WebComp_Agendanovedadeswc_Component) != 0 )
               {
                  WebComp_Agendanovedadeswc.setjustcreated();
                  WebComp_Agendanovedadeswc.componentprepare(new Object[] {"W0028","",Integer.valueOf(AV13CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LegNumero)});
                  WebComp_Agendanovedadeswc.componentbind(new Object[] {"","",""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Agendanovedadeswc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0028"+"");
                  WebComp_Agendanovedadeswc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(2)});
         }
         GXt_boolean2 = AV17TempBoolean ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajoLicencias", GXv_boolean3) ;
         legajoview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV17TempBoolean = GXt_boolean2 ;
         if ( AV17TempBoolean )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "LegajoLicencias") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Legajolicenciaswc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Legajolicenciaswc_Component), GXutil.lower( "LegajoLicenciasWC")) != 0 )
               {
                  WebComp_Legajolicenciaswc = WebUtils.getWebComponent(getClass(), "web.legajolicenciaswc_impl", remoteHandle, context);
                  WebComp_Legajolicenciaswc_Component = "LegajoLicenciasWC" ;
               }
               if ( GXutil.len( WebComp_Legajolicenciaswc_Component) != 0 )
               {
                  WebComp_Legajolicenciaswc.setjustcreated();
                  WebComp_Legajolicenciaswc.componentprepare(new Object[] {"W0036","",Integer.valueOf(AV13CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LegNumero)});
                  WebComp_Legajolicenciaswc.componentbind(new Object[] {"","",""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Legajolicenciaswc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0036"+"");
                  WebComp_Legajolicenciaswc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(3)});
         }
         GXt_boolean2 = AV17TempBoolean ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajoCC", GXv_boolean3) ;
         legajoview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV17TempBoolean = GXt_boolean2 ;
         if ( AV17TempBoolean && ( false ) )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "LegajoCentros") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Legajocentroswc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Legajocentroswc_Component), GXutil.lower( "LegajoCentrosWC")) != 0 )
               {
                  WebComp_Legajocentroswc = WebUtils.getWebComponent(getClass(), "web.legajocentroswc_impl", remoteHandle, context);
                  WebComp_Legajocentroswc_Component = "LegajoCentrosWC" ;
               }
               if ( GXutil.len( WebComp_Legajocentroswc_Component) != 0 )
               {
                  WebComp_Legajocentroswc.setjustcreated();
                  WebComp_Legajocentroswc.componentprepare(new Object[] {"W0044","",Integer.valueOf(AV13CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LegNumero)});
                  WebComp_Legajocentroswc.componentbind(new Object[] {"","",""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Legajocentroswc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0044"+"");
                  WebComp_Legajocentroswc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(4)});
         }
         GXt_boolean2 = AV17TempBoolean ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWdeduccionesSolapa", GXv_boolean3) ;
         legajoview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV17TempBoolean = GXt_boolean2 ;
         if ( AV17TempBoolean )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "CodeDeduccionesSolapa") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Codededuccionessolapawc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Codededuccionessolapawc_Component), GXutil.lower( "CompDeduccionesSolapa")) != 0 )
               {
                  WebComp_Codededuccionessolapawc = WebUtils.getWebComponent(getClass(), "web.compdeduccionessolapa_impl", remoteHandle, context);
                  WebComp_Codededuccionessolapawc_Component = "CompDeduccionesSolapa" ;
               }
               if ( GXutil.len( WebComp_Codededuccionessolapawc_Component) != 0 )
               {
                  WebComp_Codededuccionessolapawc.setjustcreated();
                  WebComp_Codededuccionessolapawc.componentprepare(new Object[] {"W0052","",Integer.valueOf(AV13CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LegNumero)});
                  WebComp_Codededuccionessolapawc.componentbind(new Object[] {"","",""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Codededuccionessolapawc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0052"+"");
                  WebComp_Codededuccionessolapawc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(5)});
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "LiquidacionLegajo") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Liquidacionlegajowc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Liquidacionlegajowc_Component), GXutil.lower( "LegajoLiquidacionesWC")) != 0 )
            {
               WebComp_Liquidacionlegajowc = WebUtils.getWebComponent(getClass(), "web.legajoliquidacioneswc_impl", remoteHandle, context);
               WebComp_Liquidacionlegajowc_Component = "LegajoLiquidacionesWC" ;
            }
            if ( GXutil.len( WebComp_Liquidacionlegajowc_Component) != 0 )
            {
               WebComp_Liquidacionlegajowc.setjustcreated();
               WebComp_Liquidacionlegajowc.componentprepare(new Object[] {"W0060","",Integer.valueOf(AV13CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LegNumero)});
               WebComp_Liquidacionlegajowc.componentbind(new Object[] {"","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Liquidacionlegajowc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0060"+"");
               WebComp_Liquidacionlegajowc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV13CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13CliCod), "ZZZZZ9")));
      AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      AV10LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LegNumero), "ZZZZZZZ9")));
      AV7TabCode = (String)getParm(obj,3) ;
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
      pa122( ) ;
      ws122( ) ;
      we122( ) ;
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
      if ( ! ( WebComp_Agendanovedadeswc == null ) )
      {
         if ( GXutil.len( WebComp_Agendanovedadeswc_Component) != 0 )
         {
            WebComp_Agendanovedadeswc.componentthemes();
         }
      }
      if ( ! ( WebComp_Legajolicenciaswc == null ) )
      {
         if ( GXutil.len( WebComp_Legajolicenciaswc_Component) != 0 )
         {
            WebComp_Legajolicenciaswc.componentthemes();
         }
      }
      if ( ! ( WebComp_Legajocentroswc == null ) )
      {
         if ( GXutil.len( WebComp_Legajocentroswc_Component) != 0 )
         {
            WebComp_Legajocentroswc.componentthemes();
         }
      }
      if ( ! ( WebComp_Codededuccionessolapawc == null ) )
      {
         if ( GXutil.len( WebComp_Codededuccionessolapawc_Component) != 0 )
         {
            WebComp_Codededuccionessolapawc.componentthemes();
         }
      }
      if ( ! ( WebComp_Liquidacionlegajowc == null ) )
      {
         if ( GXutil.len( WebComp_Liquidacionlegajowc_Component) != 0 )
         {
            WebComp_Liquidacionlegajowc.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020181344", true, true);
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
      httpContext.AddJavascriptSource("legajoview.js", "?2024122020181344", false, true);
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
      lblAgendanovedades_title_Internalname = "AGENDANOVEDADES_TITLE" ;
      divUnnamedtableagendanovedades_Internalname = "UNNAMEDTABLEAGENDANOVEDADES" ;
      lblLegajolicencias_title_Internalname = "LEGAJOLICENCIAS_TITLE" ;
      divUnnamedtablelegajolicencias_Internalname = "UNNAMEDTABLELEGAJOLICENCIAS" ;
      lblLegajocentros_title_Internalname = "LEGAJOCENTROS_TITLE" ;
      divUnnamedtablelegajocentros_Internalname = "UNNAMEDTABLELEGAJOCENTROS" ;
      lblCodededuccionessolapa_title_Internalname = "CODEDEDUCCIONESSOLAPA_TITLE" ;
      divUnnamedtablecodededuccionessolapa_Internalname = "UNNAMEDTABLECODEDEDUCCIONESSOLAPA" ;
      lblLiquidacionlegajo_title_Internalname = "LIQUIDACIONLEGAJO_TITLE" ;
      divUnnamedtableliquidacionlegajo_Internalname = "UNNAMEDTABLELIQUIDACIONLEGAJO" ;
      Tabs_Internalname = "TABS" ;
      divUnnamedtableviewcontainer_Internalname = "UNNAMEDTABLEVIEWCONTAINER" ;
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
      divLayoutmaintable_Class = "Table" ;
      Tabs_Historymanagement = GXutil.toBoolean( -1) ;
      Tabs_Class = "ViewTab Tab" ;
      Tabs_Pagecount = 6 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Legajo View", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV13CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV7TabCode',fld:'vTABCODE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("TABS.TABCHANGED","{handler:'e11122',iparms:[{av:'Tabs_Activepagecontrolname',ctrl:'TABS',prop:'ActivePageControlName'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV13CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV11LoadAllTabs',fld:'vLOADALLTABS',pic:''},{av:'AV12SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''}]");
      setEventMetadata("TABS.TABCHANGED",",oparms:[{av:'AV12SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'AV11LoadAllTabs',fld:'vLOADALLTABS',pic:''},{ctrl:'GENERALWC'},{ctrl:'AGENDANOVEDADESWC'},{ctrl:'LEGAJOLICENCIASWC'},{ctrl:'LEGAJOCENTROSWC'},{ctrl:'CODEDEDUCCIONESSOLAPAWC'},{ctrl:'LIQUIDACIONLEGAJOWC'}]}");
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
      wcpOAV7TabCode = "" ;
      Tabs_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV7TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV12SelectedTabCode = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucTabs = new com.genexus.webpanels.GXUserControl();
      lblGeneral_title_Jsonclick = "" ;
      WebComp_Generalwc_Component = "" ;
      OldGeneralwc = "" ;
      lblAgendanovedades_title_Jsonclick = "" ;
      WebComp_Agendanovedadeswc_Component = "" ;
      OldAgendanovedadeswc = "" ;
      lblLegajolicencias_title_Jsonclick = "" ;
      WebComp_Legajolicenciaswc_Component = "" ;
      OldLegajolicenciaswc = "" ;
      lblLegajocentros_title_Jsonclick = "" ;
      WebComp_Legajocentroswc_Component = "" ;
      OldLegajocentroswc = "" ;
      lblCodededuccionessolapa_title_Jsonclick = "" ;
      WebComp_Codededuccionessolapawc_Component = "" ;
      OldCodededuccionessolapawc = "" ;
      lblLiquidacionlegajo_title_Jsonclick = "" ;
      WebComp_Liquidacionlegajowc_Component = "" ;
      OldLiquidacionlegajowc = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV18TrnMode = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H00122_A6LegNumero = new int[1] ;
      H00122_A1EmpCod = new short[1] ;
      H00122_A3CliCod = new int[1] ;
      H00122_A250LegIdNomApe = new String[] {""} ;
      A250LegIdNomApe = "" ;
      H00123_A6LegNumero = new int[1] ;
      H00123_A1EmpCod = new short[1] ;
      H00123_A3CliCod = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajoview__default(),
         new Object[] {
             new Object[] {
            H00122_A6LegNumero, H00122_A1EmpCod, H00122_A3CliCod, H00122_A250LegIdNomApe
            }
            , new Object[] {
            H00123_A6LegNumero, H00123_A1EmpCod, H00123_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Generalwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Agendanovedadeswc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Legajolicenciaswc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Legajocentroswc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Codededuccionessolapawc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Liquidacionlegajowc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV21GXLvl10 ;
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
   private int wcpOAV10LegNumero ;
   private int AV13CliCod ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int Tabs_Pagecount ;
   private int idxLst ;
   private String wcpOAV7TabCode ;
   private String Tabs_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV7TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV12SelectedTabCode ;
   private String Tabs_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String Tabs_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtablegeneral_Internalname ;
   private String WebComp_Generalwc_Component ;
   private String OldGeneralwc ;
   private String lblAgendanovedades_title_Internalname ;
   private String lblAgendanovedades_title_Jsonclick ;
   private String divUnnamedtableagendanovedades_Internalname ;
   private String WebComp_Agendanovedadeswc_Component ;
   private String OldAgendanovedadeswc ;
   private String lblLegajolicencias_title_Internalname ;
   private String lblLegajolicencias_title_Jsonclick ;
   private String divUnnamedtablelegajolicencias_Internalname ;
   private String WebComp_Legajolicenciaswc_Component ;
   private String OldLegajolicenciaswc ;
   private String lblLegajocentros_title_Internalname ;
   private String lblLegajocentros_title_Jsonclick ;
   private String divUnnamedtablelegajocentros_Internalname ;
   private String WebComp_Legajocentroswc_Component ;
   private String OldLegajocentroswc ;
   private String lblCodededuccionessolapa_title_Internalname ;
   private String lblCodededuccionessolapa_title_Jsonclick ;
   private String divUnnamedtablecodededuccionessolapa_Internalname ;
   private String WebComp_Codededuccionessolapawc_Component ;
   private String OldCodededuccionessolapawc ;
   private String lblLiquidacionlegajo_title_Internalname ;
   private String lblLiquidacionlegajo_title_Jsonclick ;
   private String divUnnamedtableliquidacionlegajo_Internalname ;
   private String WebComp_Liquidacionlegajowc_Component ;
   private String OldLiquidacionlegajowc ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV18TrnMode ;
   private String scmdbuf ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV11LoadAllTabs ;
   private boolean Tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV8Exists ;
   private boolean bDynCreated_Generalwc ;
   private boolean AV17TempBoolean ;
   private boolean bDynCreated_Agendanovedadeswc ;
   private boolean bDynCreated_Legajolicenciaswc ;
   private boolean bDynCreated_Legajocentroswc ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean bDynCreated_Codededuccionessolapawc ;
   private boolean bDynCreated_Liquidacionlegajowc ;
   private String A250LegIdNomApe ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Generalwc ;
   private GXWebComponent WebComp_Agendanovedadeswc ;
   private GXWebComponent WebComp_Legajolicenciaswc ;
   private GXWebComponent WebComp_Legajocentroswc ;
   private GXWebComponent WebComp_Codededuccionessolapawc ;
   private GXWebComponent WebComp_Liquidacionlegajowc ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private IDataStoreProvider pr_default ;
   private int[] H00122_A6LegNumero ;
   private short[] H00122_A1EmpCod ;
   private int[] H00122_A3CliCod ;
   private String[] H00122_A250LegIdNomApe ;
   private int[] H00123_A6LegNumero ;
   private short[] H00123_A1EmpCod ;
   private int[] H00123_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class legajoview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00122", "SELECT LegNumero, EmpCod, CliCod, LegIdNomApe FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (CliCod = ? and EmpCod = ? and LegNumero = ?) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00123", "SELECT LegNumero, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (CliCod = ? and EmpCod = ? and LegNumero = ?) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

