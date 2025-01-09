package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357_alta_impl extends GXDataArea
{
   public f1357_alta_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357_alta_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357_alta_impl.class ));
   }

   public f1357_alta_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavLiqpermes = new HTMLChoice();
      cmbavF1357ctipopre = new HTMLChoice();
      radavAplicaa = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "Modo") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "Modo") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "Modo") ;
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
            AV19Modo = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19Modo", AV19Modo);
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
               AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
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
      pa9D2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start9D2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357_alta", new String[] {GXutil.URLEncode(GXutil.rtrim(AV19Modo)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0))}, new String[] {"Modo","CliCod","EmpCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vADELANTOTIPO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24AdelantoTipo), "9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGNUMERO_DATA", AV14LegNumero_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGNUMERO_DATA", AV14LegNumero_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQNRO", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERIODO", localUtil.dtoc( A283LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQCOD", GXutil.rtrim( A32TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGNUMERO", AV13LegNumero);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGNUMERO", AV13LegNumero);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV31Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vADELANTOTIPO", GXutil.ltrim( localUtil.ntoc( AV24AdelantoTipo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vADELANTOTIPO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24AdelantoTipo), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODO", GXutil.rtrim( AV19Modo));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Cls", GXutil.rtrim( Combo_legnumero_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Selectedvalue_set", GXutil.rtrim( Combo_legnumero_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Allowmultipleselection", GXutil.booltostr( Combo_legnumero_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Includeonlyselectedoption", GXutil.booltostr( Combo_legnumero_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Emptyitem", GXutil.booltostr( Combo_legnumero_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Multiplevaluestype", GXutil.rtrim( Combo_legnumero_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Selectedvalue_get", GXutil.rtrim( Combo_legnumero_Selectedvalue_get));
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
         we9D2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt9D2( ) ;
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
      return formatLink("web.f1357_alta", new String[] {GXutil.URLEncode(GXutil.rtrim(AV19Modo)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0))}, new String[] {"Modo","CliCod","EmpCod"})  ;
   }

   public String getPgmname( )
   {
      return "F1357_Alta" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Alta F1357", "") ;
   }

   public void wb9D0( )
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
         wb_table1_9_9D2( true) ;
      }
      else
      {
         wb_table1_9_9D2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_9D2e( boolean wbgen )
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

   public void start9D2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Alta F1357", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup9D0( ) ;
   }

   public void ws9D2( )
   {
      start9D2( ) ;
      evt9D2( ) ;
   }

   public void evt9D2( )
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
                           e119D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCONFIRMAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoConfirmar' */
                           e129D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCANCELAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCancelar' */
                           e139D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e149D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOVOLVER'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoVolver' */
                           e159D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e169D2 ();
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
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we9D2( )
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

   public void pa9D2( )
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
            GX_FocusControl = edtavLiqperano_Internalname ;
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
      if ( cmbavLiqpermes.getItemCount() > 0 )
      {
         AV10LiqPerMes = (byte)(GXutil.lval( cmbavLiqpermes.getValidValue(GXutil.trim( GXutil.str( AV10LiqPerMes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10LiqPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LiqPerMes), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqpermes.setValue( GXutil.trim( GXutil.str( AV10LiqPerMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqpermes.getInternalname(), "Values", cmbavLiqpermes.ToJavascriptSource(), true);
      }
      if ( cmbavF1357ctipopre.getItemCount() > 0 )
      {
         AV11F1357CTipoPre = (byte)(GXutil.lval( cmbavF1357ctipopre.getValidValue(GXutil.trim( GXutil.str( AV11F1357CTipoPre, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11F1357CTipoPre", GXutil.str( AV11F1357CTipoPre, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavF1357ctipopre.setValue( GXutil.trim( GXutil.str( AV11F1357CTipoPre, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavF1357ctipopre.getInternalname(), "Values", cmbavF1357ctipopre.ToJavascriptSource(), true);
      }
      AV12AplicaA = GXutil.rtrim( AV12AplicaA) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12AplicaA", AV12AplicaA);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf9D2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV31Pgmname = "F1357_Alta" ;
      Gx_err = (short)(0) ;
   }

   public void rf9D2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e149D2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e169D2 ();
         wb9D0( ) ;
      }
   }

   public void send_integrity_lvl_hashes9D2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV31Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vADELANTOTIPO", GXutil.ltrim( localUtil.ntoc( AV24AdelantoTipo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vADELANTOTIPO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24AdelantoTipo), "9")));
   }

   public void before_start_formulas( )
   {
      AV31Pgmname = "F1357_Alta" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup9D0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e119D2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV15DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGNUMERO_DATA"), AV14LegNumero_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGNUMERO"), AV13LegNumero);
         /* Read saved values. */
         Combo_legnumero_Cls = httpContext.cgiGet( "COMBO_LEGNUMERO_Cls") ;
         Combo_legnumero_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedvalue_set") ;
         Combo_legnumero_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Allowmultipleselection")) ;
         Combo_legnumero_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Includeonlyselectedoption")) ;
         Combo_legnumero_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Emptyitem")) ;
         Combo_legnumero_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGNUMERO_Multiplevaluestype") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLiqperano_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLiqperano_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLIQPERANO");
            GX_FocusControl = edtavLiqperano_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV9LiqPerAno = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9LiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LiqPerAno), 4, 0));
         }
         else
         {
            AV9LiqPerAno = (short)(localUtil.ctol( httpContext.cgiGet( edtavLiqperano_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9LiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LiqPerAno), 4, 0));
         }
         cmbavLiqpermes.setValue( httpContext.cgiGet( cmbavLiqpermes.getInternalname()) );
         AV10LiqPerMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbavLiqpermes.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10LiqPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LiqPerMes), 2, 0));
         cmbavF1357ctipopre.setValue( httpContext.cgiGet( cmbavF1357ctipopre.getInternalname()) );
         AV11F1357CTipoPre = (byte)(GXutil.lval( httpContext.cgiGet( cmbavF1357ctipopre.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11F1357CTipoPre", GXutil.str( AV11F1357CTipoPre, 1, 0));
         AV12AplicaA = httpContext.cgiGet( radavAplicaa.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12AplicaA", AV12AplicaA);
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
      e119D2 ();
      if (returnInSub) return;
   }

   public void e119D2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXt_int1 = AV7CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      f1357_alta_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV15DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV15DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S112 ();
      if (returnInSub) return;
      GXv_int5[0] = AV9LiqPerAno ;
      GXv_int6[0] = AV21mes ;
      GXv_boolean7[0] = false ;
      new web.getperiodoultliqmensual(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 0, GXv_int5, GXv_int6, GXv_boolean7) ;
      f1357_alta_impl.this.AV9LiqPerAno = GXv_int5[0] ;
      f1357_alta_impl.this.AV21mes = (byte)((byte)(GXv_int6[0])) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9LiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LiqPerAno), 4, 0));
      AV10LiqPerMes = (byte)(GXutil.lval( GXutil.trim( GXutil.str( AV21mes, 2, 0)))) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10LiqPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LiqPerMes), 2, 0));
      AV12AplicaA = httpContext.getMessage( "TODOS", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12AplicaA", AV12AplicaA);
      /* Execute user subroutine: 'VISIBILIDAD LEGAJOS' */
      S122 ();
      if (returnInSub) return;
   }

   public void e129D2( )
   {
      /* 'DoConfirmar' Routine */
      returnInSub = false ;
      if ( ( AV11F1357CTipoPre == 1 ) && ( AV10LiqPerMes != 12 ) )
      {
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Para tipo de DDJJ \"Anual\" debe seleccionar el mes de diciembre", "")) ;
      }
      else
      {
         AV17LiqNro.clear();
         AV18LiqPeriodo = localUtil.ymdtod( AV9LiqPerAno, AV10LiqPerMes, 1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18LiqPeriodo", localUtil.format(AV18LiqPeriodo, "99/99/9999"));
         GXt_char8 = AV22egresoTLiqCod ;
         GXt_char9 = AV22egresoTLiqCod ;
         GXv_char10[0] = GXt_char9 ;
         new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char10) ;
         f1357_alta_impl.this.GXt_char9 = GXv_char10[0] ;
         GXv_char11[0] = GXt_char8 ;
         new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char11) ;
         f1357_alta_impl.this.GXt_char8 = GXv_char11[0] ;
         AV22egresoTLiqCod = GXt_char8 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22egresoTLiqCod", AV22egresoTLiqCod);
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Byte.valueOf(AV11F1357CTipoPre) ,
                                              A32TLiqCod ,
                                              AV22egresoTLiqCod ,
                                              A283LiqPeriodo ,
                                              AV18LiqPeriodo ,
                                              Integer.valueOf(AV7CliCod) ,
                                              Short.valueOf(AV8EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor H009D2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV8EmpCod), AV18LiqPeriodo, AV22egresoTLiqCod, AV22egresoTLiqCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = H009D2_A3CliCod[0] ;
            A1EmpCod = H009D2_A1EmpCod[0] ;
            A283LiqPeriodo = H009D2_A283LiqPeriodo[0] ;
            A32TLiqCod = H009D2_A32TLiqCod[0] ;
            n32TLiqCod = H009D2_n32TLiqCod[0] ;
            A31LiqNro = H009D2_A31LiqNro[0] ;
            AV17LiqNro.add((int)(A31LiqNro), 0);
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV17LiqNro.size() == 0 )
         {
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "No existe liquidación para el periodo, según tipo de presentación", "")) ;
         }
         else
         {
            if ( GXutil.strcmp(AV12AplicaA, httpContext.getMessage( "TODOS", "")) == 0 )
            {
               pr_default.dynParam(1, new Object[]{ new Object[]{
                                                    Integer.valueOf(A31LiqNro) ,
                                                    AV17LiqNro ,
                                                    Integer.valueOf(AV7CliCod) ,
                                                    Short.valueOf(AV8EmpCod) ,
                                                    Integer.valueOf(A3CliCod) ,
                                                    Short.valueOf(A1EmpCod) } ,
                                                    new int[]{
                                                    TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                                    }
               });
               /* Using cursor H009D3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV8EmpCod)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A31LiqNro = H009D3_A31LiqNro[0] ;
                  A1EmpCod = H009D3_A1EmpCod[0] ;
                  A3CliCod = H009D3_A3CliCod[0] ;
                  A6LegNumero = H009D3_A6LegNumero[0] ;
                  AV13LegNumero.add((int)(A6LegNumero), 0);
                  pr_default.readNext(1);
               }
               pr_default.close(1);
            }
            if ( AV11F1357CTipoPre == 2 )
            {
               GXv_boolean7[0] = AV23egresoOK ;
               new web.egresovalidar(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, GXv_boolean7) ;
               f1357_alta_impl.this.AV23egresoOK = GXv_boolean7[0] ;
               if ( ! AV23egresoOK )
               {
                  new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Para tipo de presentación final los legajos deben tener fecha de egreso", "")) ;
                  new web.msgdebug(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "error fec egr", "")) ;
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "&LegNumero json ", "")+AV13LegNumero.toJSonString(false)) ;
            GXv_decimal12[0] = DecimalUtil.doubleToDec(0) ;
            GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
            GXv_int14[0] = (byte)(0) ;
            GXv_decimal15[0] = DecimalUtil.doubleToDec(0) ;
            GXv_char11[0] = "" ;
            new web.f1357(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero.toJSonString(false), AV18LiqPeriodo, AV11F1357CTipoPre, false, 0, AV24AdelantoTipo, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), "Calculo", GXv_decimal12, GXv_decimal13, GXv_int14, GXv_decimal15, GXv_char11) ;
            httpContext.setWebReturnParms(new Object[] {AV19Modo,Integer.valueOf(AV7CliCod),Short.valueOf(AV8EmpCod)});
            httpContext.setWebReturnParmsMetadata(new Object[] {"AV19Modo","AV7CliCod","AV8EmpCod"});
            httpContext.wjLocDisableFrm = (byte)(1) ;
            httpContext.nUserReturn = (byte)(1) ;
            returnInSub = true;
            if (true) return;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13LegNumero", AV13LegNumero);
   }

   public void e139D2( )
   {
      /* 'DoCancelar' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {AV19Modo,Integer.valueOf(AV7CliCod),Short.valueOf(AV8EmpCod)});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV19Modo","AV7CliCod","AV8EmpCod"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOLEGNUMERO' Routine */
      returnInSub = false ;
      /* Using cursor H009D4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1EmpCod = H009D4_A1EmpCod[0] ;
         A3CliCod = H009D4_A3CliCod[0] ;
         A6LegNumero = H009D4_A6LegNumero[0] ;
         A250LegIdNomApe = H009D4_A250LegIdNomApe[0] ;
         AV16Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV16Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
         AV16Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A250LegIdNomApe );
         AV14LegNumero_Data.add(AV16Combo_DataItem, 0);
         pr_default.readNext(2);
      }
      pr_default.close(2);
      Combo_legnumero_Selectedvalue_set = AV13LegNumero.toJSonString(false) ;
      ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "SelectedValue_set", Combo_legnumero_Selectedvalue_set);
   }

   public void e149D2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV7CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      f1357_alta_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      /*  Sending Event outputs  */
   }

   public void e159D2( )
   {
      /* 'DoVolver' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {AV19Modo,Integer.valueOf(AV7CliCod),Short.valueOf(AV8EmpCod)});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV19Modo","AV7CliCod","AV8EmpCod"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'VISIBILIDAD LEGAJOS' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV12AplicaA, httpContext.getMessage( "TODOS", "")) == 0 )
      {
         divTablesplittedlegnumero_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablesplittedlegnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedlegnumero_Visible), 5, 0), true);
      }
      else
      {
         divTablesplittedlegnumero_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablesplittedlegnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedlegnumero_Visible), 5, 0), true);
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e169D2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_9_9D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLiqperano_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqperano_Internalname, httpContext.getMessage( "Periodo liquidado", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqperano_Internalname, GXutil.ltrim( localUtil.ntoc( AV9LiqPerAno, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavLiqperano_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV9LiqPerAno), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV9LiqPerAno), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,17);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqperano_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavLiqperano_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_Alta.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqpermes.getInternalname(), httpContext.getMessage( "Liq Per Mes", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqpermes, cmbavLiqpermes.getInternalname(), GXutil.trim( GXutil.str( AV10LiqPerMes, 2, 0)), 1, cmbavLiqpermes.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavLiqpermes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,21);\"", "", true, (byte)(0), "HLP_F1357_Alta.htm");
         cmbavLiqpermes.setValue( GXutil.trim( GXutil.str( AV10LiqPerMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqpermes.getInternalname(), "Values", cmbavLiqpermes.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavF1357ctipopre.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavF1357ctipopre.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavF1357ctipopre, cmbavF1357ctipopre.getInternalname(), GXutil.trim( GXutil.str( AV11F1357CTipoPre, 1, 0)), 1, cmbavF1357ctipopre.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavF1357ctipopre.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "", true, (byte)(0), "HLP_F1357_Alta.htm");
         cmbavF1357ctipopre.setValue( GXutil.trim( GXutil.str( AV11F1357CTipoPre, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavF1357ctipopre.getInternalname(), "Values", cmbavF1357ctipopre.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+radavAplicaa.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Aplica a", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Radio button */
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'',0)\"" ;
         web.GxWebStd.gx_radio_ctrl( httpContext, radavAplicaa, radavAplicaa.getInternalname(), GXutil.rtrim( AV12AplicaA), "", 1, 1, 0, 0, StyleString, ClassString, "", "", 0, radavAplicaa.getJsonclick(), "'"+""+"'"+",false,"+"'"+""+"'", TempTags+" onclick="+"\""+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "HLP_F1357_Alta.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegnumero_Internalname, divTablesplittedlegnumero_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_legnumero_Internalname, httpContext.getMessage( "Legajos", ""), "", "", lblTextblockcombo_legnumero_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_F1357_Alta.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_legnumero.setProperty("Caption", Combo_legnumero_Caption);
         ucCombo_legnumero.setProperty("Cls", Combo_legnumero_Cls);
         ucCombo_legnumero.setProperty("AllowMultipleSelection", Combo_legnumero_Allowmultipleselection);
         ucCombo_legnumero.setProperty("IncludeOnlySelectedOption", Combo_legnumero_Includeonlyselectedoption);
         ucCombo_legnumero.setProperty("EmptyItem", Combo_legnumero_Emptyitem);
         ucCombo_legnumero.setProperty("MultipleValuesType", Combo_legnumero_Multiplevaluestype);
         ucCombo_legnumero.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
         ucCombo_legnumero.setProperty("DropDownOptionsData", AV14LegNumero_Data);
         ucCombo_legnumero.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legnumero_Internalname, "COMBO_LEGNUMEROContainer");
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
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirmar_Internalname, "", httpContext.getMessage( "Confirmar", ""), bttBtnconfirmar_Jsonclick, 5, httpContext.getMessage( "Confirmar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCONFIRMAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357_Alta.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancelar_Internalname, "", httpContext.getMessage( "Cancelar", ""), bttBtncancelar_Jsonclick, 5, httpContext.getMessage( "Cancelar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCANCELAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357_Alta.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_9D2e( true) ;
      }
      else
      {
         wb_table1_9_9D2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV19Modo = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Modo", AV19Modo);
      AV7CliCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      AV8EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
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
      pa9D2( ) ;
      ws9D2( ) ;
      we9D2( ) ;
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
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713391385", true, true);
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
      httpContext.AddJavascriptSource("f1357_alta.js", "?20251713391386", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavLiqperano_Internalname = "vLIQPERANO" ;
      cmbavLiqpermes.setInternalname( "vLIQPERMES" );
      cmbavF1357ctipopre.setInternalname( "vF1357CTIPOPRE" );
      radavAplicaa.setInternalname( "vAPLICAA" );
      lblTextblockcombo_legnumero_Internalname = "TEXTBLOCKCOMBO_LEGNUMERO" ;
      Combo_legnumero_Internalname = "COMBO_LEGNUMERO" ;
      divTablesplittedlegnumero_Internalname = "TABLESPLITTEDLEGNUMERO" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnconfirmar_Internalname = "BTNCONFIRMAR" ;
      bttBtncancelar_Internalname = "BTNCANCELAR" ;
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
      Combo_legnumero_Caption = "" ;
      divTablesplittedlegnumero_Visible = 1 ;
      radavAplicaa.setJsonclick( "" );
      cmbavF1357ctipopre.setJsonclick( "" );
      cmbavF1357ctipopre.setEnabled( 1 );
      cmbavLiqpermes.setJsonclick( "" );
      cmbavLiqpermes.setEnabled( 1 );
      edtavLiqperano_Jsonclick = "" ;
      edtavLiqperano_Enabled = 1 ;
      Combo_legnumero_Multiplevaluestype = "Tags" ;
      Combo_legnumero_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legnumero_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legnumero_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legnumero_Cls = "ExtendedCombo Attribute" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Alta F1357", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavLiqpermes.setName( "vLIQPERMES" );
      cmbavLiqpermes.setWebtags( "" );
      cmbavLiqpermes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbavLiqpermes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbavLiqpermes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbavLiqpermes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbavLiqpermes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbavLiqpermes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbavLiqpermes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbavLiqpermes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbavLiqpermes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbavLiqpermes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbavLiqpermes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbavLiqpermes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbavLiqpermes.getItemCount() > 0 )
      {
         AV10LiqPerMes = (byte)(GXutil.lval( cmbavLiqpermes.getValidValue(GXutil.trim( GXutil.str( AV10LiqPerMes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10LiqPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LiqPerMes), 2, 0));
      }
      cmbavF1357ctipopre.setName( "vF1357CTIPOPRE" );
      cmbavF1357ctipopre.setWebtags( "" );
      cmbavF1357ctipopre.addItem("1", httpContext.getMessage( "Anual", ""), (short)(0));
      cmbavF1357ctipopre.addItem("2", httpContext.getMessage( "Final", ""), (short)(0));
      cmbavF1357ctipopre.addItem("3", httpContext.getMessage( "Informativa", ""), (short)(0));
      if ( cmbavF1357ctipopre.getItemCount() > 0 )
      {
         AV11F1357CTipoPre = (byte)(GXutil.lval( cmbavF1357ctipopre.getValidValue(GXutil.trim( GXutil.str( AV11F1357CTipoPre, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11F1357CTipoPre", GXutil.str( AV11F1357CTipoPre, 1, 0));
      }
      radavAplicaa.setName( "vAPLICAA" );
      radavAplicaa.setWebtags( "" );
      radavAplicaa.addItem("TODOS", httpContext.getMessage( "Todos los empleados", ""), (short)(0));
      radavAplicaa.addItem("ALGUNOS", httpContext.getMessage( "Empleados específicos", ""), (short)(0));
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'radavAplicaa'},{av:'AV12AplicaA',fld:'vAPLICAA',pic:''},{av:'AV31Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV24AdelantoTipo',fld:'vADELANTOTIPO',pic:'9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("'DOCONFIRMAR'","{handler:'e129D2',iparms:[{av:'cmbavF1357ctipopre'},{av:'AV11F1357CTipoPre',fld:'vF1357CTIPOPRE',pic:'9'},{av:'cmbavLiqpermes'},{av:'AV10LiqPerMes',fld:'vLIQPERMES',pic:'Z9'},{av:'AV9LiqPerAno',fld:'vLIQPERANO',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV12AplicaA',fld:'vAPLICAA',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV31Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV24AdelantoTipo',fld:'vADELANTOTIPO',pic:'9',hsh:true},{av:'AV19Modo',fld:'vMODO',pic:''}]");
      setEventMetadata("'DOCONFIRMAR'",",oparms:[{av:'AV18LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV22egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''}]}");
      setEventMetadata("'DOCANCELAR'","{handler:'e139D2',iparms:[{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV19Modo',fld:'vMODO',pic:''}]");
      setEventMetadata("'DOCANCELAR'",",oparms:[]}");
      setEventMetadata("'DOVOLVER'","{handler:'e159D2',iparms:[{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV19Modo',fld:'vMODO',pic:''}]");
      setEventMetadata("'DOVOLVER'",",oparms:[]}");
      setEventMetadata("VALIDV_LIQPERMES","{handler:'validv_Liqpermes',iparms:[]");
      setEventMetadata("VALIDV_LIQPERMES",",oparms:[]}");
      setEventMetadata("VALIDV_F1357CTIPOPRE","{handler:'validv_F1357ctipopre',iparms:[]");
      setEventMetadata("VALIDV_F1357CTIPOPRE",",oparms:[]}");
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
      wcpOAV19Modo = "" ;
      Combo_legnumero_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV19Modo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV31Pgmname = "" ;
      GXKey = "" ;
      AV15DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV14LegNumero_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A283LiqPeriodo = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      AV13LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      Combo_legnumero_Selectedvalue_set = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV12AplicaA = "" ;
      Gx_mode = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_int5 = new short[1] ;
      GXv_int6 = new short[1] ;
      AV17LiqNro = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV18LiqPeriodo = GXutil.nullDate() ;
      AV22egresoTLiqCod = "" ;
      GXt_char8 = "" ;
      GXt_char9 = "" ;
      GXv_char10 = new String[1] ;
      scmdbuf = "" ;
      H009D2_A3CliCod = new int[1] ;
      H009D2_A1EmpCod = new short[1] ;
      H009D2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      H009D2_A32TLiqCod = new String[] {""} ;
      H009D2_n32TLiqCod = new boolean[] {false} ;
      H009D2_A31LiqNro = new int[1] ;
      H009D3_A31LiqNro = new int[1] ;
      H009D3_A1EmpCod = new short[1] ;
      H009D3_A3CliCod = new int[1] ;
      H009D3_A6LegNumero = new int[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_int14 = new byte[1] ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      GXv_char11 = new String[1] ;
      H009D4_A1EmpCod = new short[1] ;
      H009D4_A3CliCod = new int[1] ;
      H009D4_A6LegNumero = new int[1] ;
      H009D4_A250LegIdNomApe = new String[] {""} ;
      A250LegIdNomApe = "" ;
      AV16Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      ucCombo_legnumero = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      sStyleString = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblockcombo_legnumero_Jsonclick = "" ;
      bttBtnconfirmar_Jsonclick = "" ;
      bttBtncancelar_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357_alta__default(),
         new Object[] {
             new Object[] {
            H009D2_A3CliCod, H009D2_A1EmpCod, H009D2_A283LiqPeriodo, H009D2_A32TLiqCod, H009D2_n32TLiqCod, H009D2_A31LiqNro
            }
            , new Object[] {
            H009D3_A31LiqNro, H009D3_A1EmpCod, H009D3_A3CliCod, H009D3_A6LegNumero
            }
            , new Object[] {
            H009D4_A1EmpCod, H009D4_A3CliCod, H009D4_A6LegNumero, H009D4_A250LegIdNomApe
            }
         }
      );
      AV31Pgmname = "F1357_Alta" ;
      /* GeneXus formulas. */
      AV31Pgmname = "F1357_Alta" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV24AdelantoTipo ;
   private byte nDonePA ;
   private byte AV10LiqPerMes ;
   private byte AV11F1357CTipoPre ;
   private byte AV21mes ;
   private byte GXv_int14[] ;
   private byte nGXWrapped ;
   private short wcpOAV8EmpCod ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV9LiqPerAno ;
   private short GXv_int5[] ;
   private short GXv_int6[] ;
   private int wcpOAV7CliCod ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int divTablesplittedlegnumero_Visible ;
   private int edtavLiqperano_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private String wcpOAV19Modo ;
   private String Combo_legnumero_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV19Modo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV31Pgmname ;
   private String GXKey ;
   private String A32TLiqCod ;
   private String Combo_legnumero_Cls ;
   private String Combo_legnumero_Selectedvalue_set ;
   private String Combo_legnumero_Multiplevaluestype ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavLiqperano_Internalname ;
   private String AV12AplicaA ;
   private String Gx_mode ;
   private String AV22egresoTLiqCod ;
   private String GXt_char8 ;
   private String GXt_char9 ;
   private String GXv_char10[] ;
   private String scmdbuf ;
   private String GXv_char11[] ;
   private String Combo_legnumero_Internalname ;
   private String divTablesplittedlegnumero_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String TempTags ;
   private String edtavLiqperano_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String lblTextblockcombo_legnumero_Internalname ;
   private String lblTextblockcombo_legnumero_Jsonclick ;
   private String Combo_legnumero_Caption ;
   private String bttBtnconfirmar_Internalname ;
   private String bttBtnconfirmar_Jsonclick ;
   private String bttBtncancelar_Internalname ;
   private String bttBtncancelar_Jsonclick ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV18LiqPeriodo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Combo_legnumero_Allowmultipleselection ;
   private boolean Combo_legnumero_Includeonlyselectedoption ;
   private boolean Combo_legnumero_Emptyitem ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean n32TLiqCod ;
   private boolean AV23egresoOK ;
   private boolean GXv_boolean7[] ;
   private String A250LegIdNomApe ;
   private GXSimpleCollection<Integer> AV13LegNumero ;
   private GXSimpleCollection<Integer> AV17LiqNro ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucCombo_legnumero ;
   private HTMLChoice cmbavLiqpermes ;
   private HTMLChoice cmbavF1357ctipopre ;
   private HTMLChoice radavAplicaa ;
   private IDataStoreProvider pr_default ;
   private int[] H009D2_A3CliCod ;
   private short[] H009D2_A1EmpCod ;
   private java.util.Date[] H009D2_A283LiqPeriodo ;
   private String[] H009D2_A32TLiqCod ;
   private boolean[] H009D2_n32TLiqCod ;
   private int[] H009D2_A31LiqNro ;
   private int[] H009D3_A31LiqNro ;
   private short[] H009D3_A1EmpCod ;
   private int[] H009D3_A3CliCod ;
   private int[] H009D3_A6LegNumero ;
   private short[] H009D4_A1EmpCod ;
   private int[] H009D4_A3CliCod ;
   private int[] H009D4_A6LegNumero ;
   private String[] H009D4_A250LegIdNomApe ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14LegNumero_Data ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV16Combo_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV15DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class f1357_alta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H009D2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte AV11F1357CTipoPre ,
                                          String A32TLiqCod ,
                                          String AV22egresoTLiqCod ,
                                          java.util.Date A283LiqPeriodo ,
                                          java.util.Date AV18LiqPeriodo ,
                                          int AV7CliCod ,
                                          short AV8EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[5];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LiqPeriodo, TLiqCod, LiqNro FROM Liquidacion" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LiqPeriodo = ?)");
      if ( AV11F1357CTipoPre != 2 )
      {
         addWhere(sWhereString, "(TLiqCod <> ( ?))");
      }
      else
      {
         GXv_int16[3] = (byte)(1) ;
      }
      if ( AV11F1357CTipoPre == 2 )
      {
         addWhere(sWhereString, "(TLiqCod = ( ?))");
      }
      else
      {
         GXv_int16[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro DESC" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_H009D3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int A31LiqNro ,
                                          GXSimpleCollection<Integer> AV17LiqNro ,
                                          int AV7CliCod ,
                                          short AV8EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int18 = new byte[2];
      Object[] GXv_Object19 = new Object[2];
      scmdbuf = "SELECT LiqNro, EmpCod, CliCod, LegNumero FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV17LiqNro, "LiqNro IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object19[0] = scmdbuf ;
      GXv_Object19[1] = GXv_int18 ;
      return GXv_Object19 ;
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
                  return conditional_H009D2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (String)dynConstraints[1] , (String)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() );
            case 1 :
                  return conditional_H009D3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (GXSimpleCollection<Integer>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H009D2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H009D3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H009D4", "SELECT EmpCod, CliCod, LegNumero, LegIdNomApe FROM Legajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

