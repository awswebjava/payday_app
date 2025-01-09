package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class periodocardsview_impl extends GXDataArea
{
   public periodocardsview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public periodocardsview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( periodocardsview_impl.class ));
   }

   public periodocardsview_impl( int remoteHandle ,
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
            AV19MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19MenuOpcCod", AV19MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV19MenuOpcCod, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV10CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV10CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CliCod), 6, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
               AV11EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
               AV12PeriodoLiq = localUtil.parseDateParm( httpContext.GetPar( "PeriodoLiq")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12PeriodoLiq", localUtil.format(AV12PeriodoLiq, "99/99/99"));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERIODOLIQ", getSecureSignedToken( "", AV12PeriodoLiq));
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
      paP82( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startP82( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.periodocardsview", new String[] {GXutil.URLEncode(GXutil.rtrim(AV19MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV10CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV12PeriodoLiq)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"MenuOpcCod","CliCod","EmpCod","PeriodoLiq","TabCode"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQUIDACIONESPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20liquidacionesPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22lsdPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV19MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERIODOLIQ", getSecureSignedToken( "", AV12PeriodoLiq));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV10CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "PERIODOLIQ", localUtil.dtoc( A1729PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vPERIODOLIQ", localUtil.dtoc( AV12PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERIODOLIQ", getSecureSignedToken( "", AV12PeriodoLiq));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vLOADALLTABS", AV13LoadAllTabs);
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDTABCODE", GXutil.rtrim( AV14SelectedTabCode));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV19MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV19MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQUIDACIONESPALABRA", GXutil.rtrim( AV20liquidacionesPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQUIDACIONESPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20liquidacionesPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSDPALABRA", GXutil.rtrim( AV22lsdPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22lsdPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTABCODE", GXutil.rtrim( AV8TabCode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
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
      if ( ! ( WebComp_Liquidacionwwwc == null ) )
      {
         WebComp_Liquidacionwwwc.componentjscripts();
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
         weP82( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtP82( ) ;
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
      return formatLink("web.periodocardsview", new String[] {GXutil.URLEncode(GXutil.rtrim(AV19MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV10CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV12PeriodoLiq)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"MenuOpcCod","CliCod","EmpCod","PeriodoLiq","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "PeriodoCardsView" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Periodo Cards View", "") ;
   }

   public void wbP80( )
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
         wb_table1_9_P82( true) ;
      }
      else
      {
         wb_table1_9_P82( false) ;
      }
      return  ;
   }

   public void wb_table1_9_P82e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCero_Internalname, GXutil.ltrim( localUtil.ntoc( AV18Cero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV18Cero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCero_Jsonclick, 0, "Attribute", "", "", "", "", edtavCero_Visible, 1, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PeriodoCardsView.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startP82( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Periodo Cards View", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupP80( ) ;
   }

   public void wsP82( )
   {
      startP82( ) ;
      evtP82( ) ;
   }

   public void evtP82( )
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
                           e11P82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e12P82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e13P82 ();
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
                        OldLiquidacionwwwc = httpContext.cgiGet( "W0031") ;
                        if ( ( GXutil.len( OldLiquidacionwwwc) == 0 ) || ( GXutil.strcmp(OldLiquidacionwwwc, WebComp_Liquidacionwwwc_Component) != 0 ) )
                        {
                           WebComp_Liquidacionwwwc = WebUtils.getWebComponent(getClass(), "web." + OldLiquidacionwwwc + "_impl", remoteHandle, context);
                           WebComp_Liquidacionwwwc_Component = OldLiquidacionwwwc ;
                        }
                        if ( GXutil.len( WebComp_Liquidacionwwwc_Component) != 0 )
                        {
                           WebComp_Liquidacionwwwc.componentprocess("W0031", "", sEvt);
                        }
                        WebComp_Liquidacionwwwc_Component = OldLiquidacionwwwc ;
                     }
                     else if ( nCmpId == 39 )
                     {
                        OldLsd_reg1wwwc = httpContext.cgiGet( "W0039") ;
                        if ( ( GXutil.len( OldLsd_reg1wwwc) == 0 ) || ( GXutil.strcmp(OldLsd_reg1wwwc, WebComp_Lsd_reg1wwwc_Component) != 0 ) )
                        {
                           WebComp_Lsd_reg1wwwc = WebUtils.getWebComponent(getClass(), "web." + OldLsd_reg1wwwc + "_impl", remoteHandle, context);
                           WebComp_Lsd_reg1wwwc_Component = OldLsd_reg1wwwc ;
                        }
                        if ( GXutil.len( WebComp_Lsd_reg1wwwc_Component) != 0 )
                        {
                           WebComp_Lsd_reg1wwwc.componentprocess("W0039", "", sEvt);
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

   public void weP82( )
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

   public void paP82( )
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
            GX_FocusControl = edtavCero_Internalname ;
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfP82( ) ;
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

   public void rfP82( )
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
            if ( GXutil.len( WebComp_Liquidacionwwwc_Component) != 0 )
            {
               WebComp_Liquidacionwwwc.componentstart();
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
         e13P82 ();
         wbP80( ) ;
      }
   }

   public void send_integrity_lvl_hashesP82( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQUIDACIONESPALABRA", GXutil.rtrim( AV20liquidacionesPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQUIDACIONESPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20liquidacionesPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSDPALABRA", GXutil.rtrim( AV22lsdPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22lsdPalabra, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupP80( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12P82 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         AV19MenuOpcCod = httpContext.cgiGet( "vMENUOPCCOD") ;
         Tabs_Activepagecontrolname = httpContext.cgiGet( "TABS_Activepagecontrolname") ;
         Tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Tabs_Class = httpContext.cgiGet( "TABS_Class") ;
         Tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TABS_Historymanagement")) ;
         Tabs_Activepagecontrolname = httpContext.cgiGet( "TABS_Activepagecontrolname") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCERO");
            GX_FocusControl = edtavCero_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV18Cero = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18Cero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18Cero), 8, 0));
         }
         else
         {
            AV18Cero = (int)(localUtil.ctol( httpContext.cgiGet( edtavCero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18Cero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18Cero), 8, 0));
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
      e12P82 ();
      if (returnInSub) return;
   }

   public void e12P82( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV21websession.setValue(httpContext.getMessage( "&PeriodoLiq", ""), GXutil.trim( localUtil.dtoc( AV12PeriodoLiq, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")));
      AV20liquidacionesPalabra = httpContext.getMessage( "Liquidaciones", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20liquidacionesPalabra", AV20liquidacionesPalabra);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQUIDACIONESPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20liquidacionesPalabra, ""))));
      AV22lsdPalabra = httpContext.getMessage( "PeriodoLSD", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22lsdPalabra", AV22lsdPalabra);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22lsdPalabra, ""))));
      new web.setopcionmenusesion(remoteHandle, context).execute( AV20liquidacionesPalabra, "", "") ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      AV25GXLvl14 = (byte)(0) ;
      /* Using cursor H00P82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV12PeriodoLiq, Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV12PeriodoLiq});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1729PeriodoLiq = H00P82_A1729PeriodoLiq[0] ;
         A1EmpCod = H00P82_A1EmpCod[0] ;
         A3CliCod = H00P82_A3CliCod[0] ;
         AV25GXLvl14 = (byte)(1) ;
         Form.setCaption( httpContext.getMessage( "Liquidaciones", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV25GXLvl14 == 0 )
      {
         Form.setCaption( httpContext.getMessage( "WWP_RecordNotFound", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = false ;
      }
      if ( AV9Exists )
      {
         AV14SelectedTabCode = AV8TabCode ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14SelectedTabCode", AV14SelectedTabCode);
         Tabs_Activepagecontrolname = AV14SelectedTabCode ;
         ucTabs.sendProperty(context, "", false, Tabs_Internalname, "ActivePageControlName", Tabs_Activepagecontrolname);
         /* Execute user subroutine: 'LOADTABS' */
         S112 ();
         if (returnInSub) return;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e13P82( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtavCero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCero_Visible), 5, 0), true);
   }

   public void e11P82( )
   {
      /* Tabs_Tabchanged Routine */
      returnInSub = false ;
      AV14SelectedTabCode = Tabs_Activepagecontrolname ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14SelectedTabCode", AV14SelectedTabCode);
      AV13LoadAllTabs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LoadAllTabs", AV13LoadAllTabs);
      /* Execute user subroutine: 'LOADTABS' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADTABS' Routine */
      returnInSub = false ;
      /* Using cursor H00P83 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV12PeriodoLiq, Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV12PeriodoLiq});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1729PeriodoLiq = H00P83_A1729PeriodoLiq[0] ;
         A1EmpCod = H00P83_A1EmpCod[0] ;
         A3CliCod = H00P83_A3CliCod[0] ;
         if ( AV13LoadAllTabs || ( GXutil.strcmp(AV14SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV14SelectedTabCode, "General") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Generalwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Generalwc_Component), GXutil.lower( "PeriodoCardsGeneral")) != 0 )
            {
               WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "web.periodocardsgeneral_impl", remoteHandle, context);
               WebComp_Generalwc_Component = "PeriodoCardsGeneral" ;
            }
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               WebComp_Generalwc.setjustcreated();
               WebComp_Generalwc.componentprepare(new Object[] {"W0023","",AV19MenuOpcCod,Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),AV12PeriodoLiq});
               WebComp_Generalwc.componentbind(new Object[] {"","","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Generalwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0023"+"");
               WebComp_Generalwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         GXt_boolean2 = AV17TempBoolean ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacion", GXv_boolean3) ;
         periodocardsview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV17TempBoolean = GXt_boolean2 ;
         if ( AV17TempBoolean )
         {
            if ( AV13LoadAllTabs || ( GXutil.strcmp(AV14SelectedTabCode, "LiquidacionWW") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Liquidacionwwwc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Liquidacionwwwc_Component), GXutil.lower( "LiquidacionWW")) != 0 )
               {
                  WebComp_Liquidacionwwwc = WebUtils.getWebComponent(getClass(), "web.liquidacionww_impl", remoteHandle, context);
                  WebComp_Liquidacionwwwc_Component = "LiquidacionWW" ;
               }
               if ( GXutil.len( WebComp_Liquidacionwwwc_Component) != 0 )
               {
                  WebComp_Liquidacionwwwc.setjustcreated();
                  WebComp_Liquidacionwwwc.componentprepare(new Object[] {"W0031","",AV20liquidacionesPalabra,AV12PeriodoLiq});
                  WebComp_Liquidacionwwwc.componentbind(new Object[] {"",""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Liquidacionwwwc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0031"+"");
                  WebComp_Liquidacionwwwc.componentdraw();
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg1", GXv_boolean3) ;
         periodocardsview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV17TempBoolean = GXt_boolean2 ;
         if ( AV17TempBoolean )
         {
            if ( AV13LoadAllTabs || ( GXutil.strcmp(AV14SelectedTabCode, "LSD_reg1WW") == 0 ) )
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
                  WebComp_Lsd_reg1wwwc.componentprepare(new Object[] {"W0039","",AV22lsdPalabra,Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),AV12PeriodoLiq,Integer.valueOf(AV18Cero)});
                  WebComp_Lsd_reg1wwwc.componentbind(new Object[] {"","","","","vCERO"});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Lsd_reg1wwwc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0039"+"");
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
   }

   public void wb_table1_9_P82( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "General", ""), "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PeriodoCardsView.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblLiquidacionww_title_Internalname, httpContext.getMessage( " Liquidaciones", ""), "", "", lblLiquidacionww_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PeriodoCardsView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "LiquidacionWW") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableliquidacionww_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0031"+"", GXutil.rtrim( WebComp_Liquidacionwwwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0031"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Liquidacionwwwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLiquidacionwwwc), GXutil.lower( WebComp_Liquidacionwwwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0031"+"");
               }
               WebComp_Liquidacionwwwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldLiquidacionwwwc), GXutil.lower( WebComp_Liquidacionwwwc_Component)) != 0 )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblLsd_reg1ww_title_Internalname, httpContext.getMessage( "Libro de sueldo digital", ""), "", "", lblLsd_reg1ww_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PeriodoCardsView.htm");
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
            web.GxWebStd.gx_hidden_field( httpContext, "W0039"+"", GXutil.rtrim( WebComp_Lsd_reg1wwwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0039"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Lsd_reg1wwwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldLsd_reg1wwwc), GXutil.lower( WebComp_Lsd_reg1wwwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0039"+"");
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
         wb_table1_9_P82e( true) ;
      }
      else
      {
         wb_table1_9_P82e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV19MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19MenuOpcCod", AV19MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV19MenuOpcCod, ""))));
      AV10CliCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CliCod), "ZZZZZ9")));
      AV11EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11EmpCod), "ZZZ9")));
      AV12PeriodoLiq = (java.util.Date)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12PeriodoLiq", localUtil.format(AV12PeriodoLiq, "99/99/99"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERIODOLIQ", getSecureSignedToken( "", AV12PeriodoLiq));
      AV8TabCode = (String)getParm(obj,4) ;
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
      paP82( ) ;
      wsP82( ) ;
      weP82( ) ;
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
      if ( ! ( WebComp_Liquidacionwwwc == null ) )
      {
         if ( GXutil.len( WebComp_Liquidacionwwwc_Component) != 0 )
         {
            WebComp_Liquidacionwwwc.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202036522", true, true);
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
      httpContext.AddJavascriptSource("periodocardsview.js", "?202412202036522", false, true);
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
      lblLiquidacionww_title_Internalname = "LIQUIDACIONWW_TITLE" ;
      divUnnamedtableliquidacionww_Internalname = "UNNAMEDTABLELIQUIDACIONWW" ;
      lblLsd_reg1ww_title_Internalname = "LSD_REG1WW_TITLE" ;
      divUnnamedtablelsd_reg1ww_Internalname = "UNNAMEDTABLELSD_REG1WW" ;
      Tabs_Internalname = "TABS" ;
      divUnnamedtableviewcontainer_Internalname = "UNNAMEDTABLEVIEWCONTAINER" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCero_Internalname = "vCERO" ;
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
      edtavCero_Jsonclick = "" ;
      edtavCero_Visible = 1 ;
      Tabs_Historymanagement = GXutil.toBoolean( -1) ;
      Tabs_Class = "ViewTab Tab" ;
      Tabs_Pagecount = 3 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Periodo Cards View", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV12PeriodoLiq',fld:'vPERIODOLIQ',pic:'',hsh:true},{av:'AV19MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV20liquidacionesPalabra',fld:'vLIQUIDACIONESPALABRA',pic:'',hsh:true},{av:'AV22lsdPalabra',fld:'vLSDPALABRA',pic:'',hsh:true},{av:'AV8TabCode',fld:'vTABCODE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("TABS.TABCHANGED","{handler:'e11P82',iparms:[{av:'Tabs_Activepagecontrolname',ctrl:'TABS',prop:'ActivePageControlName'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV10CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A1729PeriodoLiq',fld:'PERIODOLIQ',pic:''},{av:'AV12PeriodoLiq',fld:'vPERIODOLIQ',pic:'',hsh:true},{av:'AV13LoadAllTabs',fld:'vLOADALLTABS',pic:''},{av:'AV14SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'AV19MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV20liquidacionesPalabra',fld:'vLIQUIDACIONESPALABRA',pic:'',hsh:true},{av:'AV22lsdPalabra',fld:'vLSDPALABRA',pic:'',hsh:true},{av:'AV18Cero',fld:'vCERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("TABS.TABCHANGED",",oparms:[{av:'AV14SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'AV13LoadAllTabs',fld:'vLOADALLTABS',pic:''},{ctrl:'GENERALWC'},{ctrl:'LIQUIDACIONWWWC'},{ctrl:'LSD_REG1WWWC'}]}");
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
      wcpOAV19MenuOpcCod = "" ;
      wcpOAV12PeriodoLiq = GXutil.nullDate() ;
      wcpOAV8TabCode = "" ;
      Tabs_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV19MenuOpcCod = "" ;
      AV12PeriodoLiq = GXutil.nullDate() ;
      AV8TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV20liquidacionesPalabra = "" ;
      AV22lsdPalabra = "" ;
      GXKey = "" ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      AV14SelectedTabCode = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldGeneralwc = "" ;
      WebComp_Generalwc_Component = "" ;
      OldLiquidacionwwwc = "" ;
      WebComp_Liquidacionwwwc_Component = "" ;
      OldLsd_reg1wwwc = "" ;
      WebComp_Lsd_reg1wwwc_Component = "" ;
      AV21websession = httpContext.getWebSession();
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H00P82_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      H00P82_A1EmpCod = new short[1] ;
      H00P82_A3CliCod = new int[1] ;
      ucTabs = new com.genexus.webpanels.GXUserControl();
      H00P83_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      H00P83_A1EmpCod = new short[1] ;
      H00P83_A3CliCod = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      sStyleString = "" ;
      lblGeneral_title_Jsonclick = "" ;
      lblLiquidacionww_title_Jsonclick = "" ;
      lblLsd_reg1ww_title_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.periodocardsview__default(),
         new Object[] {
             new Object[] {
            H00P82_A1729PeriodoLiq, H00P82_A1EmpCod, H00P82_A3CliCod
            }
            , new Object[] {
            H00P83_A1729PeriodoLiq, H00P83_A1EmpCod, H00P83_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Generalwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Liquidacionwwwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Lsd_reg1wwwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV25GXLvl14 ;
   private byte nGXWrapped ;
   private short wcpOAV11EmpCod ;
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
   private int AV10CliCod ;
   private int A3CliCod ;
   private int Tabs_Pagecount ;
   private int AV18Cero ;
   private int edtavCero_Visible ;
   private int idxLst ;
   private String wcpOAV8TabCode ;
   private String Tabs_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV8TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV20liquidacionesPalabra ;
   private String AV22lsdPalabra ;
   private String GXKey ;
   private String AV14SelectedTabCode ;
   private String Tabs_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavCero_Internalname ;
   private String edtavCero_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String OldGeneralwc ;
   private String WebComp_Generalwc_Component ;
   private String OldLiquidacionwwwc ;
   private String WebComp_Liquidacionwwwc_Component ;
   private String OldLsd_reg1wwwc ;
   private String WebComp_Lsd_reg1wwwc_Component ;
   private String scmdbuf ;
   private String Tabs_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtablegeneral_Internalname ;
   private String lblLiquidacionww_title_Internalname ;
   private String lblLiquidacionww_title_Jsonclick ;
   private String divUnnamedtableliquidacionww_Internalname ;
   private String lblLsd_reg1ww_title_Internalname ;
   private String lblLsd_reg1ww_title_Jsonclick ;
   private String divUnnamedtablelsd_reg1ww_Internalname ;
   private java.util.Date wcpOAV12PeriodoLiq ;
   private java.util.Date AV12PeriodoLiq ;
   private java.util.Date A1729PeriodoLiq ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV13LoadAllTabs ;
   private boolean Tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV9Exists ;
   private boolean bDynCreated_Generalwc ;
   private boolean AV17TempBoolean ;
   private boolean bDynCreated_Liquidacionwwwc ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean bDynCreated_Lsd_reg1wwwc ;
   private String wcpOAV19MenuOpcCod ;
   private String AV19MenuOpcCod ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Generalwc ;
   private GXWebComponent WebComp_Liquidacionwwwc ;
   private GXWebComponent WebComp_Lsd_reg1wwwc ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] H00P82_A1729PeriodoLiq ;
   private short[] H00P82_A1EmpCod ;
   private int[] H00P82_A3CliCod ;
   private java.util.Date[] H00P83_A1729PeriodoLiq ;
   private short[] H00P83_A1EmpCod ;
   private int[] H00P83_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV21websession ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class periodocardsview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00P82", "SELECT PeriodoLiq, EmpCod, CliCod FROM Periodo WHERE (CliCod = ? and EmpCod = ? and PeriodoLiq = ?) AND (CliCod = ? and EmpCod = ? and PeriodoLiq = ?) ORDER BY CliCod, EmpCod, PeriodoLiq ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00P83", "SELECT PeriodoLiq, EmpCod, CliCod FROM Periodo WHERE (CliCod = ? and EmpCod = ? and PeriodoLiq = ?) AND (CliCod = ? and EmpCod = ? and PeriodoLiq = ?) ORDER BY CliCod, EmpCod, PeriodoLiq ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
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
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
      }
   }

}

