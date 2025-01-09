package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class periodos_impl extends GXDataArea
{
   public periodos_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public periodos_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( periodos_impl.class ));
   }

   public periodos_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbavPeriodoanio = new HTMLChoice();
      cmbavCardperiod1_periodomes = new HTMLChoice();
      cmbPeriodoMes = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Freestylegrid1") == 0 )
         {
            gxnrfreestylegrid1_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Freestylegrid1") == 0 )
         {
            gxgrfreestylegrid1_refresh_invoke( ) ;
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
            AV17MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17MenuOpcCod", AV17MenuOpcCod);
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

   public void gxnrfreestylegrid1_newrow_invoke( )
   {
      nRC_GXsfl_71 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_71"))) ;
      nGXsfl_71_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_71_idx"))) ;
      sGXsfl_71_idx = httpContext.GetPar( "sGXsfl_71_idx") ;
      cmbPeriodoMes.setVisible( (int)(GXutil.lval( httpContext.GetNextPar( ))) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPeriodoMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbPeriodoMes.getVisible(), 5, 0), !bGXsfl_71_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrfreestylegrid1_newrow( ) ;
      /* End function gxnrFreestylegrid1_newrow_invoke */
   }

   public void gxgrfreestylegrid1_refresh_invoke( )
   {
      cmbavPeriodoanio.fromJSonString( httpContext.GetNextPar( ));
      AV27PeriodoAnio = (short)(GXutil.lval( httpContext.GetPar( "PeriodoAnio"))) ;
      AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV10EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      cmbPeriodoMes.setVisible( (int)(GXutil.lval( httpContext.GetNextPar( ))) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPeriodoMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbPeriodoMes.getVisible(), 5, 0), !bGXsfl_71_Refreshing);
      AV21WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrfreestylegrid1_refresh( AV27PeriodoAnio, AV9CliCod, AV10EmpCod, AV21WelcomeMessage_NoMostrarMas) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrFreestylegrid1_refresh_invoke */
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
      paPC2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startPC2( ) ;
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
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.periodos", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vPERIODOANIO", GXutil.ltrim( localUtil.ntoc( AV27PeriodoAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_71", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_71, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PERIODOANIO", GXutil.ltrim( localUtil.ntoc( A1730PeriodoAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV10EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV17MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PERIODOLIQ", localUtil.dtoc( A1729PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "PERIODOCNTLIQ", GXutil.ltrim( localUtil.ntoc( A1735PeriodoCntLiq, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "FREESTYLEGRID1_Class", GXutil.rtrim( subFreestylegrid1_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "FREESTYLEGRID1_Flexwrap", GXutil.rtrim( subFreestylegrid1_Flexwrap));
      web.GxWebStd.gx_hidden_field( httpContext, "PERIODOMES_Visible", GXutil.ltrim( localUtil.ntoc( cmbPeriodoMes.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
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
         wePC2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtPC2( ) ;
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
      return formatLink("web.periodos", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "periodos" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "periodos", "") ;
   }

   public void wbPC0( )
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
         wb_table1_9_PC2( true) ;
      }
      else
      {
         wb_table1_9_PC2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_PC2e( boolean wbgen )
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
      if ( wbEnd == 71 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Freestylegrid1Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Freestylegrid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Freestylegrid1", Freestylegrid1Container, subFreestylegrid1_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Freestylegrid1ContainerData", Freestylegrid1Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Freestylegrid1ContainerData"+"V", Freestylegrid1Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylegrid1ContainerData"+"V"+"\" value='"+Freestylegrid1Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startPC2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "periodos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupPC0( ) ;
   }

   public void wsPC2( )
   {
      startPC2( ) ;
      evtPC2( ) ;
   }

   public void evtPC2( )
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
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11PC2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VPERIODOANIO.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12PC2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOAGREGAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoAgregar' */
                           e13PC2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "FREESTYLEGRID1.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 22), "FREESTYLEGRID1.REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_71_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_712( ) ;
                           cmbavCardperiod1_periodomes.setName( cmbavCardperiod1_periodomes.getInternalname() );
                           cmbavCardperiod1_periodomes.setValue( httpContext.cgiGet( cmbavCardperiod1_periodomes.getInternalname()) );
                           AV8CardPeriod1_PeriodoMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbavCardperiod1_periodomes.getInternalname()))) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavCardperiod1_periodomes.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CardPeriod1_PeriodoMes), 2, 0));
                           AV5CardPeriod1_PeriodoAnio = (short)(localUtil.ctol( httpContext.cgiGet( edtavCardperiod1_periodoanio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCardperiod1_periodoanio_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CardPeriod1_PeriodoAnio), 4, 0));
                           AV7CardPeriod1_PeriodoCntLiq = (short)(localUtil.ctol( httpContext.cgiGet( edtavCardperiod1_periodocntliq_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCardperiod1_periodocntliq_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CardPeriod1_PeriodoCntLiq), 4, 0));
                           AV25sinLiqCnt = (short)(localUtil.ctol( httpContext.cgiGet( edtavSinliqcnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavSinliqcnt_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25sinLiqCnt), 4, 0));
                           AV6CardPeriod1_PeriodoCntLeg = (short)(localUtil.ctol( httpContext.cgiGet( edtavCardperiod1_periodocntleg_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCardperiod1_periodocntleg_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CardPeriod1_PeriodoCntLeg), 4, 0));
                           AV22PeriodoLiq = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtavPeriodoliq_Internalname), 0)) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavPeriodoliq_Internalname, localUtil.format(AV22PeriodoLiq, "99/99/99"));
                           web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERIODOLIQ"+"_"+sGXsfl_71_idx, getSecureSignedToken( sGXsfl_71_idx, AV22PeriodoLiq));
                           cmbPeriodoMes.setName( cmbPeriodoMes.getInternalname() );
                           cmbPeriodoMes.setValue( httpContext.cgiGet( cmbPeriodoMes.getInternalname()) );
                           A1731PeriodoMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbPeriodoMes.getInternalname()))) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e14PC2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "FREESTYLEGRID1.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e15PC2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e16PC2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "FREESTYLEGRID1.REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e17PC2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Periodoanio Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vPERIODOANIO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV27PeriodoAnio )
                                    {
                                       Rfr0gs = true ;
                                    }
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

   public void wePC2( )
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

   public void paPC2( )
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

   public void gxnrfreestylegrid1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_712( ) ;
      while ( nGXsfl_71_idx <= nRC_GXsfl_71 )
      {
         sendrow_712( ) ;
         nGXsfl_71_idx = ((subFreestylegrid1_Islastpage==1)&&(nGXsfl_71_idx+1>subfreestylegrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_71_idx+1) ;
         sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_712( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Freestylegrid1Container)) ;
      /* End function gxnrFreestylegrid1_newrow */
   }

   public void gxgrfreestylegrid1_refresh( short AV27PeriodoAnio ,
                                           int AV9CliCod ,
                                           short AV10EmpCod ,
                                           boolean AV21WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e16PC2 ();
      FREESTYLEGRID1_nCurrentRecord = 0 ;
      rfPC2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrFreestylegrid1_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERIODOLIQ", getSecureSignedToken( "", AV22PeriodoLiq));
      web.GxWebStd.gx_hidden_field( httpContext, "vPERIODOLIQ", localUtil.format(AV22PeriodoLiq, "99/99/99"));
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
      AV21WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV21WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21WelcomeMessage_NoMostrarMas", AV21WelcomeMessage_NoMostrarMas);
      if ( cmbavPeriodoanio.getItemCount() > 0 )
      {
         AV27PeriodoAnio = (short)(GXutil.lval( cmbavPeriodoanio.getValidValue(GXutil.trim( GXutil.str( AV27PeriodoAnio, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27PeriodoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27PeriodoAnio), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPeriodoanio.setValue( GXutil.trim( GXutil.str( AV27PeriodoAnio, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPeriodoanio.getInternalname(), "Values", cmbavPeriodoanio.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      /* Execute user event: Refresh */
      e16PC2 ();
      rfPC2( ) ;
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
      cmbavCardperiod1_periodomes.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCardperiod1_periodomes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCardperiod1_periodomes.getEnabled(), 5, 0), !bGXsfl_71_Refreshing);
      edtavCardperiod1_periodoanio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCardperiod1_periodoanio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCardperiod1_periodoanio_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtavCardperiod1_periodocntliq_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCardperiod1_periodocntliq_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCardperiod1_periodocntliq_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtavSinliqcnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSinliqcnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSinliqcnt_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtavCardperiod1_periodocntleg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCardperiod1_periodocntleg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCardperiod1_periodocntleg_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtavPeriodoliq_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavPeriodoliq_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPeriodoliq_Enabled), 5, 0), !bGXsfl_71_Refreshing);
   }

   public void rfPC2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Freestylegrid1Container.ClearRows();
      }
      wbStart = (short)(71) ;
      e17PC2 ();
      nGXsfl_71_idx = 1 ;
      sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_712( ) ;
      bGXsfl_71_Refreshing = true ;
      Freestylegrid1Container.AddObjectProperty("GridName", "Freestylegrid1");
      Freestylegrid1Container.AddObjectProperty("CmpContext", "");
      Freestylegrid1Container.AddObjectProperty("InMasterPage", "false");
      Freestylegrid1Container.AddObjectProperty("Class", GXutil.rtrim( "gridOpciones"));
      Freestylegrid1Container.AddObjectProperty("Class", "gridOpciones");
      Freestylegrid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Freestylegrid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Freestylegrid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylegrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Freestylegrid1Container.setPageSize( subfreestylegrid1_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_712( ) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Short.valueOf(AV27PeriodoAnio) ,
                                              Short.valueOf(A1730PeriodoAnio) ,
                                              Integer.valueOf(AV9CliCod) ,
                                              Short.valueOf(AV10EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor H00PC2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Short.valueOf(AV27PeriodoAnio)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1730PeriodoAnio = H00PC2_A1730PeriodoAnio[0] ;
            A1731PeriodoMes = H00PC2_A1731PeriodoMes[0] ;
            A1729PeriodoLiq = H00PC2_A1729PeriodoLiq[0] ;
            A1EmpCod = H00PC2_A1EmpCod[0] ;
            A3CliCod = H00PC2_A3CliCod[0] ;
            GXt_int1 = A1735PeriodoCntLiq ;
            GXv_int2[0] = GXt_int1 ;
            new web.periodocantliq(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int2) ;
            periodos_impl.this.GXt_int1 = GXv_int2[0] ;
            A1735PeriodoCntLiq = GXt_int1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1735PeriodoCntLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1735PeriodoCntLiq), 4, 0));
            e15PC2 ();
            pr_default.readNext(0);
         }
         pr_default.close(0);
         wbEnd = (short)(71) ;
         wbPC0( ) ;
      }
      bGXsfl_71_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesPC2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERIODOLIQ"+"_"+sGXsfl_71_idx, getSecureSignedToken( sGXsfl_71_idx, AV22PeriodoLiq));
   }

   public int subfreestylegrid1_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subfreestylegrid1_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subfreestylegrid1_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subfreestylegrid1_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      cmbavCardperiod1_periodomes.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCardperiod1_periodomes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCardperiod1_periodomes.getEnabled(), 5, 0), !bGXsfl_71_Refreshing);
      edtavCardperiod1_periodoanio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCardperiod1_periodoanio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCardperiod1_periodoanio_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtavCardperiod1_periodocntliq_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCardperiod1_periodocntliq_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCardperiod1_periodocntliq_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtavSinliqcnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSinliqcnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSinliqcnt_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtavCardperiod1_periodocntleg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCardperiod1_periodocntleg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCardperiod1_periodocntleg_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtavPeriodoliq_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavPeriodoliq_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPeriodoliq_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupPC0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e14PC2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_71 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_71"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV10EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV9CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subFreestylegrid1_Class = httpContext.cgiGet( "FREESTYLEGRID1_Class") ;
         subFreestylegrid1_Flexwrap = httpContext.cgiGet( "FREESTYLEGRID1_Flexwrap") ;
         /* Read variables values. */
         AV20WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV21WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21WelcomeMessage_NoMostrarMas", AV21WelcomeMessage_NoMostrarMas);
         cmbavPeriodoanio.setName( cmbavPeriodoanio.getInternalname() );
         cmbavPeriodoanio.setValue( httpContext.cgiGet( cmbavPeriodoanio.getInternalname()) );
         AV27PeriodoAnio = (short)(GXutil.lval( httpContext.cgiGet( cmbavPeriodoanio.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27PeriodoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27PeriodoAnio), 4, 0));
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
      e14PC2 ();
      if (returnInSub) return;
   }

   public void e14PC2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV10EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      periodos_impl.this.GXt_int1 = GXv_int2[0] ;
      AV10EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
      GXt_int3 = AV9CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      periodos_impl.this.GXt_int3 = GXv_int4[0] ;
      AV9CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
      cmbPeriodoMes.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPeriodoMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbPeriodoMes.getVisible(), 5, 0), !bGXsfl_71_Refreshing);
      GXv_char5[0] = AV13MenuBienveImgURL ;
      GXv_char6[0] = AV15MenuBienveTitulo ;
      GXv_char7[0] = AV14MenuBienveTexto ;
      GXv_boolean8[0] = AV16MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV17MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      periodos_impl.this.AV13MenuBienveImgURL = GXv_char5[0] ;
      periodos_impl.this.AV15MenuBienveTitulo = GXv_char6[0] ;
      periodos_impl.this.AV14MenuBienveTexto = GXv_char7[0] ;
      periodos_impl.this.AV16MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV16MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV16MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV15MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV14MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV20WelcomeMessage_Foto = AV13MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV20WelcomeMessage_Foto)==0) ? AV37Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV20WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV20WelcomeMessage_Foto), true);
         AV37Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV13MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV20WelcomeMessage_Foto)==0) ? AV37Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV20WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV20WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      periodos_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      periodos_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      new web.setopcionmenusesion(remoteHandle, context).execute( AV17MenuOpcCod, "", "") ;
      /* Execute user subroutine: 'COMBO ANIOS' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'COUNT PERIODOS' */
      S122 ();
      if (returnInSub) return;
   }

   private void e15PC2( )
   {
      /* Freestylegrid1_Load Routine */
      returnInSub = false ;
      AV5CardPeriod1_PeriodoAnio = A1730PeriodoAnio ;
      httpContext.ajax_rsp_assign_attri("", false, edtavCardperiod1_periodoanio_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CardPeriod1_PeriodoAnio), 4, 0));
      AV8CardPeriod1_PeriodoMes = A1731PeriodoMes ;
      httpContext.ajax_rsp_assign_attri("", false, cmbavCardperiod1_periodomes.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CardPeriod1_PeriodoMes), 2, 0));
      AV7CardPeriod1_PeriodoCntLiq = A1735PeriodoCntLiq ;
      httpContext.ajax_rsp_assign_attri("", false, edtavCardperiod1_periodocntliq_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CardPeriod1_PeriodoCntLiq), 4, 0));
      GXv_int2[0] = AV6CardPeriod1_PeriodoCntLeg ;
      new web.getcntlegperiodo(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int2) ;
      periodos_impl.this.AV6CardPeriod1_PeriodoCntLeg = GXv_int2[0] ;
      httpContext.ajax_rsp_assign_attri("", false, edtavCardperiod1_periodocntleg_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CardPeriod1_PeriodoCntLeg), 4, 0));
      if ( (0==AV7CardPeriod1_PeriodoCntLiq) )
      {
         edtavCardperiod1_periodocntleg_Visible = 0 ;
         lblCardperiod1_periodolegajos_Visible = 0 ;
         divCardperiod1_tableliquidaciones_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divCardperiod1_tableliquidaciones_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divCardperiod1_tableliquidaciones_Visible), 5, 0), !bGXsfl_71_Refreshing);
         divTbl_sin_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTbl_sin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTbl_sin_Visible), 5, 0), !bGXsfl_71_Refreshing);
      }
      else
      {
         edtavCardperiod1_periodocntleg_Visible = 1 ;
         lblCardperiod1_periodolegajos_Visible = 1 ;
         divCardperiod1_tableliquidaciones_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divCardperiod1_tableliquidaciones_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divCardperiod1_tableliquidaciones_Visible), 5, 0), !bGXsfl_71_Refreshing);
         divTbl_sin_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTbl_sin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTbl_sin_Visible), 5, 0), !bGXsfl_71_Refreshing);
      }
      AV22PeriodoLiq = A1729PeriodoLiq ;
      httpContext.ajax_rsp_assign_attri("", false, edtavPeriodoliq_Internalname, localUtil.format(AV22PeriodoLiq, "99/99/99"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERIODOLIQ"+"_"+sGXsfl_71_idx, getSecureSignedToken( sGXsfl_71_idx, AV22PeriodoLiq));
      edtavPeriodoliq_Visible = 0 ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(71) ;
      }
      sendrow_712( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_71_Refreshing )
      {
         httpContext.doAjaxLoad(71, Freestylegrid1Row);
      }
      /*  Sending Event outputs  */
      cmbavCardperiod1_periodomes.setValue( GXutil.trim( GXutil.str( AV8CardPeriod1_PeriodoMes, 2, 0)) );
   }

   public void e13PC2( )
   {
      /* 'DoAgregar' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.liquidacion_", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "LiquidaciónABM", ""))),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "INS", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV9CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"MenuOpcCod","Modo","CliCod","EmpCod","LiqNro"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
   }

   public void e16PC2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV10EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      periodos_impl.this.GXt_int1 = GXv_int2[0] ;
      AV10EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
      GXt_int3 = AV9CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      periodos_impl.this.GXt_int3 = GXv_int4[0] ;
      AV9CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
      /* Execute user subroutine: 'COMBO ANIOS' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'COUNT PERIODOS' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavPeriodoanio.setValue( GXutil.trim( GXutil.str( AV27PeriodoAnio, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavPeriodoanio.getInternalname(), "Values", cmbavPeriodoanio.ToJavascriptSource(), true);
   }

   public void e11PC2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV21WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV17MenuOpcCod, GXv_boolean8) ;
         GXv_char7[0] = AV19textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char7) ;
         periodos_impl.this.AV19textoNoMostrara = GXv_char7[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV19textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV17MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void e17PC2( )
   {
      /* Freestylegrid1_Refresh Routine */
      returnInSub = false ;
   }

   public void e12PC2( )
   {
      /* Periodoanio_Controlvaluechanged Routine */
      returnInSub = false ;
      new web.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( httpContext.getMessage( "periodoanio", ""), GXutil.trim( GXutil.str( AV27PeriodoAnio, 4, 0))) ;
   }

   public void S112( )
   {
      /* 'COMBO ANIOS' Routine */
      returnInSub = false ;
      cmbavPeriodoanio.removeAllItems();
      cmbavPeriodoanio.addItem("0", httpContext.getMessage( "Todos", ""), (short)(0));
      AV29ultimoPeriodoAnio = (short)(0) ;
      AV38GXLvl150 = (byte)(0) ;
      /* Using cursor H00PC3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkPC3 = false ;
         A3CliCod = H00PC3_A3CliCod[0] ;
         A1EmpCod = H00PC3_A1EmpCod[0] ;
         A1730PeriodoAnio = H00PC3_A1730PeriodoAnio[0] ;
         AV38GXLvl150 = (byte)(1) ;
         cmbavPeriodoanio.addItem(GXutil.trim( GXutil.str( A1730PeriodoAnio, 4, 0)), GXutil.trim( GXutil.str( A1730PeriodoAnio, 4, 0)), (short)(0));
         AV29ultimoPeriodoAnio = A1730PeriodoAnio ;
         while ( (pr_default.getStatus(1) != 101) && ( H00PC3_A3CliCod[0] == A3CliCod ) && ( H00PC3_A1EmpCod[0] == A1EmpCod ) && ( H00PC3_A1730PeriodoAnio[0] == A1730PeriodoAnio ) )
         {
            brkPC3 = false ;
            if ( A3CliCod == AV9CliCod )
            {
               if ( A1EmpCod == AV10EmpCod )
               {
               }
            }
            brkPC3 = true ;
            pr_default.readNext(1);
         }
         if ( ! brkPC3 )
         {
            brkPC3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
      if ( AV38GXLvl150 == 0 )
      {
         AV32hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
         AV31hoyAnio = (short)(GXutil.year( AV32hoy)) ;
         cmbavPeriodoanio.addItem(GXutil.trim( GXutil.str( AV31hoyAnio, 4, 0)), GXutil.str( AV31hoyAnio, 4, 0), (short)(0));
      }
      GXt_char10 = AV33anioPalabra ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loaduserkeyvalue(remoteHandle, context).execute( httpContext.getMessage( "periodoanio", ""), AV9CliCod, "", GXv_char7) ;
      periodos_impl.this.GXt_char10 = GXv_char7[0] ;
      AV33anioPalabra = GXt_char10 ;
      AV28sesion_PeriodoAnio = (short)(GXutil.lval( AV33anioPalabra)) ;
      if ( (0==AV28sesion_PeriodoAnio) )
      {
         AV27PeriodoAnio = AV29ultimoPeriodoAnio ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27PeriodoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27PeriodoAnio), 4, 0));
      }
      else
      {
         AV27PeriodoAnio = AV28sesion_PeriodoAnio ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27PeriodoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27PeriodoAnio), 4, 0));
      }
   }

   public void S122( )
   {
      /* 'COUNT PERIODOS' Routine */
      returnInSub = false ;
      GXv_int2[0] = AV34cntPer ;
      new web.getcountperiodos(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV27PeriodoAnio, GXv_int2) ;
      periodos_impl.this.AV34cntPer = GXv_int2[0] ;
      lblCouttext_Caption = ""+GXutil.trim( GXutil.str( AV34cntPer, 4, 0))+httpContext.getMessage( " periodos", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
   }

   public void wb_table1_9_PC2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e18pc1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_periodos.htm");
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
         AV20WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV20WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV37Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV20WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV20WelcomeMessage_Foto)==0) ? AV37Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV20WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV20WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_periodos.htm");
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
         wb_table2_27_PC2( true) ;
      }
      else
      {
         wb_table2_27_PC2( false) ;
      }
      return  ;
   }

   public void wb_table2_27_PC2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table3_32_PC2( true) ;
      }
      else
      {
         wb_table3_32_PC2( false) ;
      }
      return  ;
   }

   public void wb_table3_32_PC2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_71_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV21WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,42);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_periodos.htm");
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
         web.GxWebStd.gx_div_start( httpContext, divTableacciones_Internalname, 1, 0, "px", 0, "px", "MB15", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table4_51_PC2( true) ;
      }
      else
      {
         wb_table4_51_PC2( false) ;
      }
      return  ;
   }

   public void wb_table4_51_PC2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavPeriodoanio.getInternalname(), httpContext.getMessage( "Periodo Anio", ""), "gx-form-item AttributeLabel h40Label MR30Label filtroPeriodoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'" + sGXsfl_71_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPeriodoanio, cmbavPeriodoanio.getInternalname(), GXutil.trim( GXutil.str( AV27PeriodoAnio, 4, 0)), 1, cmbavPeriodoanio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavPeriodoanio.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute h40 MR30 filtroPeriodo", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(0), "HLP_periodos.htm");
         cmbavPeriodoanio.setValue( GXutil.trim( GXutil.str( AV27PeriodoAnio, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPeriodoanio.getInternalname(), "Values", cmbavPeriodoanio.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled btn btn-default MR30" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnagregar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 71, 2, 0)+","+"null"+");", httpContext.getMessage( "Agregar", ""), bttBtnagregar_Jsonclick, 5, httpContext.getMessage( "Agregar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOAGREGAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_periodos.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gridOpcionesCell", "left", "top", "", "", "div");
         /*  Grid Control  */
         Freestylegrid1Container.SetIsFreestyle(true);
         Freestylegrid1Container.SetWrapped(nGXWrapped);
         startgridcontrol71( ) ;
      }
      if ( wbEnd == 71 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_71 = (int)(nGXsfl_71_idx-1) ;
         if ( Freestylegrid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Freestylegrid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Freestylegrid1", Freestylegrid1Container, subFreestylegrid1_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Freestylegrid1ContainerData", Freestylegrid1Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Freestylegrid1ContainerData"+"V", Freestylegrid1Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylegrid1ContainerData"+"V"+"\" value='"+Freestylegrid1Container.GridValuesHidden()+"'/>") ;
            }
         }
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
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_PC2e( true) ;
      }
      else
      {
         wb_table1_9_PC2e( false) ;
      }
   }

   public void wb_table4_51_PC2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_periodos.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", 1, 1, 0, (short)(0), "HLP_periodos.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_51_PC2e( true) ;
      }
      else
      {
         wb_table4_51_PC2e( false) ;
      }
   }

   public void wb_table3_32_PC2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_periodos.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_32_PC2e( true) ;
      }
      else
      {
         wb_table3_32_PC2e( false) ;
      }
   }

   public void wb_table2_27_PC2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_periodos.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_27_PC2e( true) ;
      }
      else
      {
         wb_table2_27_PC2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV17MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17MenuOpcCod", AV17MenuOpcCod);
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
      paPC2( ) ;
      wsPC2( ) ;
      wePC2( ) ;
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
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020365741", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("periodos.js", "?2024122020365741", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_712( )
   {
      cmbavCardperiod1_periodomes.setInternalname( "vCARDPERIOD1_PERIODOMES_"+sGXsfl_71_idx );
      edtavCardperiod1_periodoanio_Internalname = "vCARDPERIOD1_PERIODOANIO_"+sGXsfl_71_idx ;
      edtavCardperiod1_periodocntliq_Internalname = "vCARDPERIOD1_PERIODOCNTLIQ_"+sGXsfl_71_idx ;
      lblPeriodoliquidaciones1_Internalname = "PERIODOLIQUIDACIONES1_"+sGXsfl_71_idx ;
      edtavSinliqcnt_Internalname = "vSINLIQCNT_"+sGXsfl_71_idx ;
      lblPeriodoliquidaciones_Internalname = "PERIODOLIQUIDACIONES_"+sGXsfl_71_idx ;
      edtavCardperiod1_periodocntleg_Internalname = "vCARDPERIOD1_PERIODOCNTLEG_"+sGXsfl_71_idx ;
      lblCardperiod1_periodolegajos_Internalname = "CARDPERIOD1_PERIODOLEGAJOS_"+sGXsfl_71_idx ;
      edtavPeriodoliq_Internalname = "vPERIODOLIQ_"+sGXsfl_71_idx ;
      cmbPeriodoMes.setInternalname( "PERIODOMES_"+sGXsfl_71_idx );
   }

   public void subsflControlProps_fel_712( )
   {
      cmbavCardperiod1_periodomes.setInternalname( "vCARDPERIOD1_PERIODOMES_"+sGXsfl_71_fel_idx );
      edtavCardperiod1_periodoanio_Internalname = "vCARDPERIOD1_PERIODOANIO_"+sGXsfl_71_fel_idx ;
      edtavCardperiod1_periodocntliq_Internalname = "vCARDPERIOD1_PERIODOCNTLIQ_"+sGXsfl_71_fel_idx ;
      lblPeriodoliquidaciones1_Internalname = "PERIODOLIQUIDACIONES1_"+sGXsfl_71_fel_idx ;
      edtavSinliqcnt_Internalname = "vSINLIQCNT_"+sGXsfl_71_fel_idx ;
      lblPeriodoliquidaciones_Internalname = "PERIODOLIQUIDACIONES_"+sGXsfl_71_fel_idx ;
      edtavCardperiod1_periodocntleg_Internalname = "vCARDPERIOD1_PERIODOCNTLEG_"+sGXsfl_71_fel_idx ;
      lblCardperiod1_periodolegajos_Internalname = "CARDPERIOD1_PERIODOLEGAJOS_"+sGXsfl_71_fel_idx ;
      edtavPeriodoliq_Internalname = "vPERIODOLIQ_"+sGXsfl_71_fel_idx ;
      cmbPeriodoMes.setInternalname( "PERIODOMES_"+sGXsfl_71_fel_idx );
   }

   public void sendrow_712( )
   {
      subsflControlProps_712( ) ;
      wbPC0( ) ;
      Freestylegrid1Row = GXWebRow.GetNew(context,Freestylegrid1Container) ;
      if ( subFreestylegrid1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subFreestylegrid1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subFreestylegrid1_Class, "") != 0 )
         {
            subFreestylegrid1_Linesclass = subFreestylegrid1_Class+"Odd" ;
         }
      }
      else if ( subFreestylegrid1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subFreestylegrid1_Backstyle = (byte)(0) ;
         subFreestylegrid1_Backcolor = subFreestylegrid1_Allbackcolor ;
         if ( GXutil.strcmp(subFreestylegrid1_Class, "") != 0 )
         {
            subFreestylegrid1_Linesclass = subFreestylegrid1_Class+"Uniform" ;
         }
      }
      else if ( subFreestylegrid1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subFreestylegrid1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subFreestylegrid1_Class, "") != 0 )
         {
            subFreestylegrid1_Linesclass = subFreestylegrid1_Class+"Odd" ;
         }
         subFreestylegrid1_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subFreestylegrid1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subFreestylegrid1_Backstyle = (byte)(1) ;
         subFreestylegrid1_Backcolor = (int)(0xFFFFFF) ;
         if ( GXutil.strcmp(subFreestylegrid1_Class, "") != 0 )
         {
            subFreestylegrid1_Linesclass = subFreestylegrid1_Class+"Odd" ;
         }
      }
      /* Start of Columns property logic. */
      /* Table start */
      Freestylegrid1Row.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblFreestylegrid1layouttable_Internalname+"_"+sGXsfl_71_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divCardperiod1_cardperiodcontainer_Internalname+"_"+sGXsfl_71_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableMenuItemCardP","left","top"," "+"data-gx-flex"+" ","flex-direction:column;","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divCardperiod1_cardperiodtop_Internalname+"_"+sGXsfl_71_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","p20","left","top"," "+"data-gx-flex"+" ","flex-direction:column;","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Attribute/Variable Label */
      Freestylegrid1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavCardperiod1_periodomes.getInternalname(),httpContext.getMessage( "Card Period1_Periodo Mes", ""),"gx-form-item PeriodoMesLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      if ( ( cmbavCardperiod1_periodomes.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "vCARDPERIOD1_PERIODOMES_" + sGXsfl_71_idx ;
         cmbavCardperiod1_periodomes.setName( GXCCtl );
         cmbavCardperiod1_periodomes.setWebtags( "" );
         cmbavCardperiod1_periodomes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
         cmbavCardperiod1_periodomes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
         if ( cmbavCardperiod1_periodomes.getItemCount() > 0 )
         {
            AV8CardPeriod1_PeriodoMes = (byte)(GXutil.lval( cmbavCardperiod1_periodomes.getValidValue(GXutil.trim( GXutil.str( AV8CardPeriod1_PeriodoMes, 2, 0))))) ;
            httpContext.ajax_rsp_assign_attri("", false, cmbavCardperiod1_periodomes.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CardPeriod1_PeriodoMes), 2, 0));
         }
      }
      /* ComboBox */
      Freestylegrid1Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavCardperiod1_periodomes,cmbavCardperiod1_periodomes.getInternalname(),GXutil.trim( GXutil.str( AV8CardPeriod1_PeriodoMes, 2, 0)),Integer.valueOf(1),cmbavCardperiod1_periodomes.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(1),Integer.valueOf(cmbavCardperiod1_periodomes.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","PeriodoMes","","","","",Boolean.valueOf(true),Integer.valueOf(0)});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      cmbavCardperiod1_periodomes.setValue( GXutil.trim( GXutil.str( AV8CardPeriod1_PeriodoMes, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCardperiod1_periodomes.getInternalname(), "Values", cmbavCardperiod1_periodomes.ToJavascriptSource(), !bGXsfl_71_Refreshing);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Attribute/Variable Label */
      Freestylegrid1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCardperiod1_periodoanio_Internalname,httpContext.getMessage( "Card Period1_Periodo Anio", ""),"gx-form-item PeriodoAnioLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Single line edit */
      ROClassString = "PeriodoAnio" ;
      Freestylegrid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCardperiod1_periodoanio_Internalname,GXutil.ltrim( localUtil.ntoc( AV5CardPeriod1_PeriodoAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavCardperiod1_periodoanio_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV5CardPeriod1_PeriodoAnio), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV5CardPeriod1_PeriodoAnio), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCardperiod1_periodoanio_Jsonclick,Integer.valueOf(0),"PeriodoAnio","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCardperiod1_periodoanio_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divCardperiod1_cardperiodbottom_Internalname+"_"+sGXsfl_71_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","CardPeriodBottom p14","left","top"," "+"data-gx-flex"+" ","flex-direction:column;justify-content:space-between;","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divCardperiod1_tableliquidaciones_Internalname+"_"+sGXsfl_71_idx,Integer.valueOf(divCardperiod1_tableliquidaciones_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Attribute/Variable Label */
      Freestylegrid1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCardperiod1_periodocntliq_Internalname,httpContext.getMessage( "Card Period1_Periodo Cnt Liq", ""),"gx-form-item PeriodoTextBoldLabel mr5Label",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Single line edit */
      ROClassString = "PeriodoTextBold mr5" ;
      Freestylegrid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCardperiod1_periodocntliq_Internalname,GXutil.ltrim( localUtil.ntoc( AV7CardPeriod1_PeriodoCntLiq, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavCardperiod1_periodocntliq_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV7CardPeriod1_PeriodoCntLiq), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV7CardPeriod1_PeriodoCntLiq), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCardperiod1_periodocntliq_Jsonclick,Integer.valueOf(0),"PeriodoTextBold mr5","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCardperiod1_periodocntliq_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Text block */
      Freestylegrid1Row.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblPeriodoliquidaciones1_Internalname,httpContext.getMessage( "Liquidaciones", ""),"","",lblPeriodoliquidaciones1_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","PeriodoTextThin mr5",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTbl_sin_Internalname+"_"+sGXsfl_71_idx,Integer.valueOf(divTbl_sin_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Attribute/Variable Label */
      Freestylegrid1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSinliqcnt_Internalname,httpContext.getMessage( "sin Liq Cnt", ""),"gx-form-item PeriodoTextBoldLabel mr5Label",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Single line edit */
      ROClassString = "PeriodoTextBold mr5" ;
      Freestylegrid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSinliqcnt_Internalname,GXutil.ltrim( localUtil.ntoc( AV25sinLiqCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavSinliqcnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV25sinLiqCnt), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV25sinLiqCnt), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSinliqcnt_Jsonclick,Integer.valueOf(0),"PeriodoTextBold mr5","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSinliqcnt_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Text block */
      Freestylegrid1Row.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblPeriodoliquidaciones_Internalname,httpContext.getMessage( "Liquidaciones", ""),"","",lblPeriodoliquidaciones_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","PeriodoTextThin mr5",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divCardperiod1_tablelegajos_Internalname+"_"+sGXsfl_71_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      sendrow_71230( ) ;
   }

   public void sendrow_71230( )
   {
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Attribute/Variable Label */
      Freestylegrid1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCardperiod1_periodocntleg_Internalname,httpContext.getMessage( "Card Period1_Periodo Cnt Leg", ""),"gx-form-item PeriodoTextBoldLabel mr5Label",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Single line edit */
      ROClassString = "PeriodoTextBold mr5" ;
      Freestylegrid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCardperiod1_periodocntleg_Internalname,GXutil.ltrim( localUtil.ntoc( AV6CardPeriod1_PeriodoCntLeg, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavCardperiod1_periodocntleg_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV6CardPeriod1_PeriodoCntLeg), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV6CardPeriod1_PeriodoCntLeg), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCardperiod1_periodocntleg_Jsonclick,Integer.valueOf(0),"PeriodoTextBold mr5","",ROClassString,"","",Integer.valueOf(edtavCardperiod1_periodocntleg_Visible),Integer.valueOf(edtavCardperiod1_periodocntleg_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Text block */
      Freestylegrid1Row.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblCardperiod1_periodolegajos_Internalname,httpContext.getMessage( "Legajos", ""),"","",lblCardperiod1_periodolegajos_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","PeriodoTextThin",Integer.valueOf(0),"",Integer.valueOf(lblCardperiod1_periodolegajos_Visible),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         Freestylegrid1Container.CloseTag("cell");
      }
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         Freestylegrid1Container.CloseTag("row");
      }
      Freestylegrid1Row.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Attribute/Variable Label */
      Freestylegrid1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavPeriodoliq_Internalname,httpContext.getMessage( "Periodo Liq", ""),"gx-form-item AttributeDateLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Single line edit */
      ROClassString = "AttributeDate" ;
      Freestylegrid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavPeriodoliq_Internalname,localUtil.format(AV22PeriodoLiq, "99/99/99"),localUtil.format( AV22PeriodoLiq, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavPeriodoliq_Jsonclick,Integer.valueOf(0),"AttributeDate","",ROClassString,"","",Integer.valueOf(edtavPeriodoliq_Visible),Integer.valueOf(edtavPeriodoliq_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         Freestylegrid1Container.CloseTag("cell");
      }
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         Freestylegrid1Container.CloseTag("row");
      }
      Freestylegrid1Row.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","Invisible"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Table start */
      Freestylegrid1Row.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsfreestylegrid1_Internalname+"_"+sGXsfl_71_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      Freestylegrid1Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Div Control */
      Freestylegrid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      /* Attribute/Variable Label */
      Freestylegrid1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbPeriodoMes.getInternalname(),httpContext.getMessage( "Mes", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      if ( ( cmbPeriodoMes.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "PERIODOMES_" + sGXsfl_71_idx ;
         cmbPeriodoMes.setName( GXCCtl );
         cmbPeriodoMes.setWebtags( "" );
         cmbPeriodoMes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
         cmbPeriodoMes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
         cmbPeriodoMes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
         cmbPeriodoMes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
         cmbPeriodoMes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
         cmbPeriodoMes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
         cmbPeriodoMes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
         cmbPeriodoMes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
         cmbPeriodoMes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
         cmbPeriodoMes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
         cmbPeriodoMes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
         cmbPeriodoMes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
         if ( cmbPeriodoMes.getItemCount() > 0 )
         {
            A1731PeriodoMes = (byte)(GXutil.lval( cmbPeriodoMes.getValidValue(GXutil.trim( GXutil.str( A1731PeriodoMes, 2, 0))))) ;
         }
      }
      /* ComboBox */
      Freestylegrid1Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPeriodoMes,cmbPeriodoMes.getInternalname(),GXutil.trim( GXutil.str( A1731PeriodoMes, 2, 0)),Integer.valueOf(1),cmbPeriodoMes.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbPeriodoMes.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","Attribute","","","","",Boolean.valueOf(true),Integer.valueOf(0)});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      cmbPeriodoMes.setValue( GXutil.trim( GXutil.str( A1731PeriodoMes, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPeriodoMes.getInternalname(), "Values", cmbPeriodoMes.ToJavascriptSource(), !bGXsfl_71_Refreshing);
      Freestylegrid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylegrid1Row.AddRenderProperties(Freestylegrid1Column);
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         Freestylegrid1Container.CloseTag("cell");
      }
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         Freestylegrid1Container.CloseTag("row");
      }
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         Freestylegrid1Container.CloseTag("table");
      }
      /* End of table */
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         Freestylegrid1Container.CloseTag("cell");
      }
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         Freestylegrid1Container.CloseTag("row");
      }
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         Freestylegrid1Container.CloseTag("table");
      }
      /* End of table */
      send_integrity_lvl_hashesPC2( ) ;
      /* End of Columns property logic. */
      Freestylegrid1Container.AddRow(Freestylegrid1Row);
      nGXsfl_71_idx = ((subFreestylegrid1_Islastpage==1)&&(nGXsfl_71_idx+1>subfreestylegrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_71_idx+1) ;
      sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_712( ) ;
      /* End function sendrow_712 */
   }

   public void startgridcontrol71( )
   {
      if ( Freestylegrid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Freestylegrid1Container"+"DivS\" data-gxgridid=\"71\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subFreestylegrid1_Internalname, subFreestylegrid1_Internalname, "", "gridOpciones", 0, "", "", 1, 2, sStyleString, "", "", 0);
         Freestylegrid1Container.AddObjectProperty("GridName", "Freestylegrid1");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Freestylegrid1Container = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Freestylegrid1Container.Clear();
         }
         Freestylegrid1Container.SetIsFreestyle(true);
         Freestylegrid1Container.SetWrapped(nGXWrapped);
         Freestylegrid1Container.AddObjectProperty("GridName", "Freestylegrid1");
         Freestylegrid1Container.AddObjectProperty("Header", subFreestylegrid1_Header);
         Freestylegrid1Container.AddObjectProperty("Class", GXutil.rtrim( "gridOpciones"));
         Freestylegrid1Container.AddObjectProperty("Class", "gridOpciones");
         Freestylegrid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylegrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Freestylegrid1Container.AddObjectProperty("CmpContext", "");
         Freestylegrid1Container.AddObjectProperty("InMasterPage", "false");
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV8CardPeriod1_PeriodoMes, (byte)(2), (byte)(0), ".", "")));
         Freestylegrid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavCardperiod1_periodomes.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV5CardPeriod1_PeriodoAnio, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCardperiod1_periodoanio_Enabled, (byte)(5), (byte)(0), ".", "")));
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV7CardPeriod1_PeriodoCntLiq, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCardperiod1_periodocntliq_Enabled, (byte)(5), (byte)(0), ".", "")));
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Column.AddObjectProperty("Value", lblPeriodoliquidaciones1_Caption);
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV25sinLiqCnt, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSinliqcnt_Enabled, (byte)(5), (byte)(0), ".", "")));
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Column.AddObjectProperty("Value", lblPeriodoliquidaciones1_Caption);
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV6CardPeriod1_PeriodoCntLeg, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCardperiod1_periodocntleg_Enabled, (byte)(5), (byte)(0), ".", "")));
         Freestylegrid1Column.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavCardperiod1_periodocntleg_Visible, (byte)(5), (byte)(0), ".", "")));
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Column.AddObjectProperty("Value", lblCardperiod1_periodolegajos_Caption);
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Column.AddObjectProperty("Value", localUtil.format(AV22PeriodoLiq, "99/99/99"));
         Freestylegrid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavPeriodoliq_Enabled, (byte)(5), (byte)(0), ".", "")));
         Freestylegrid1Column.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavPeriodoliq_Visible, (byte)(5), (byte)(0), ".", "")));
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1731PeriodoMes, (byte)(2), (byte)(0), ".", "")));
         Freestylegrid1Column.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPeriodoMes.getVisible(), (byte)(5), (byte)(0), ".", "")));
         Freestylegrid1Container.AddColumnProperties(Freestylegrid1Column);
         Freestylegrid1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subFreestylegrid1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subFreestylegrid1_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Freestylegrid1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subFreestylegrid1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Freestylegrid1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subFreestylegrid1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Freestylegrid1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subFreestylegrid1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Freestylegrid1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subFreestylegrid1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Freestylegrid1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subFreestylegrid1_Collapsed, (byte)(1), (byte)(0), ".", "")));
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
      cmbavPeriodoanio.setInternalname( "vPERIODOANIO" );
      bttBtnagregar_Internalname = "BTNAGREGAR" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      divTableacciones_Internalname = "TABLEACCIONES" ;
      cmbavCardperiod1_periodomes.setInternalname( "vCARDPERIOD1_PERIODOMES" );
      edtavCardperiod1_periodoanio_Internalname = "vCARDPERIOD1_PERIODOANIO" ;
      divCardperiod1_cardperiodtop_Internalname = "CARDPERIOD1_CARDPERIODTOP" ;
      edtavCardperiod1_periodocntliq_Internalname = "vCARDPERIOD1_PERIODOCNTLIQ" ;
      lblPeriodoliquidaciones1_Internalname = "PERIODOLIQUIDACIONES1" ;
      divCardperiod1_tableliquidaciones_Internalname = "CARDPERIOD1_TABLELIQUIDACIONES" ;
      edtavSinliqcnt_Internalname = "vSINLIQCNT" ;
      lblPeriodoliquidaciones_Internalname = "PERIODOLIQUIDACIONES" ;
      divTbl_sin_Internalname = "TBL_SIN" ;
      edtavCardperiod1_periodocntleg_Internalname = "vCARDPERIOD1_PERIODOCNTLEG" ;
      lblCardperiod1_periodolegajos_Internalname = "CARDPERIOD1_PERIODOLEGAJOS" ;
      divCardperiod1_tablelegajos_Internalname = "CARDPERIOD1_TABLELEGAJOS" ;
      divCardperiod1_cardperiodbottom_Internalname = "CARDPERIOD1_CARDPERIODBOTTOM" ;
      divCardperiod1_cardperiodcontainer_Internalname = "CARDPERIOD1_CARDPERIODCONTAINER" ;
      edtavPeriodoliq_Internalname = "vPERIODOLIQ" ;
      cmbPeriodoMes.setInternalname( "PERIODOMES" );
      tblUnnamedtablecontentfsfreestylegrid1_Internalname = "UNNAMEDTABLECONTENTFSFREESTYLEGRID1" ;
      tblFreestylegrid1layouttable_Internalname = "FREESTYLEGRID1LAYOUTTABLE" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subFreestylegrid1_Internalname = "FREESTYLEGRID1" ;
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
      subFreestylegrid1_Allowcollapsing = (byte)(0) ;
      lblCardperiod1_periodolegajos_Caption = httpContext.getMessage( "Legajos", "") ;
      lblPeriodoliquidaciones1_Caption = httpContext.getMessage( "Liquidaciones", "") ;
      cmbPeriodoMes.setJsonclick( "" );
      edtavPeriodoliq_Jsonclick = "" ;
      edtavPeriodoliq_Enabled = 0 ;
      edtavPeriodoliq_Visible = 1 ;
      lblCardperiod1_periodolegajos_Visible = 1 ;
      edtavCardperiod1_periodocntleg_Jsonclick = "" ;
      edtavCardperiod1_periodocntleg_Enabled = 0 ;
      edtavCardperiod1_periodocntleg_Visible = 1 ;
      edtavSinliqcnt_Jsonclick = "" ;
      edtavSinliqcnt_Enabled = 0 ;
      divTbl_sin_Visible = 1 ;
      edtavCardperiod1_periodocntliq_Jsonclick = "" ;
      edtavCardperiod1_periodocntliq_Enabled = 0 ;
      divCardperiod1_tableliquidaciones_Visible = 1 ;
      edtavCardperiod1_periodoanio_Jsonclick = "" ;
      edtavCardperiod1_periodoanio_Enabled = 0 ;
      cmbavCardperiod1_periodomes.setJsonclick( "" );
      cmbavCardperiod1_periodomes.setEnabled( 0 );
      cmbavPeriodoanio.setJsonclick( "" );
      cmbavPeriodoanio.setEnabled( 1 );
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subFreestylegrid1_Backcolorstyle = (byte)(0) ;
      subFreestylegrid1_Flexwrap = "wrap" ;
      subFreestylegrid1_Class = "gridOpciones" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "periodos", "") );
      cmbPeriodoMes.setVisible( 1 );
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
      AV21WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV21WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21WelcomeMessage_NoMostrarMas", AV21WelcomeMessage_NoMostrarMas);
      cmbavPeriodoanio.setName( "vPERIODOANIO" );
      cmbavPeriodoanio.setWebtags( "" );
      if ( cmbavPeriodoanio.getItemCount() > 0 )
      {
         AV27PeriodoAnio = (short)(GXutil.lval( cmbavPeriodoanio.getValidValue(GXutil.trim( GXutil.str( AV27PeriodoAnio, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27PeriodoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27PeriodoAnio), 4, 0));
      }
      GXCCtl = "vCARDPERIOD1_PERIODOMES_" + sGXsfl_71_idx ;
      cmbavCardperiod1_periodomes.setName( GXCCtl );
      cmbavCardperiod1_periodomes.setWebtags( "" );
      cmbavCardperiod1_periodomes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbavCardperiod1_periodomes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbavCardperiod1_periodomes.getItemCount() > 0 )
      {
         AV8CardPeriod1_PeriodoMes = (byte)(GXutil.lval( cmbavCardperiod1_periodomes.getValidValue(GXutil.trim( GXutil.str( AV8CardPeriod1_PeriodoMes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavCardperiod1_periodomes.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CardPeriod1_PeriodoMes), 2, 0));
      }
      GXCCtl = "PERIODOMES_" + sGXsfl_71_idx ;
      cmbPeriodoMes.setName( GXCCtl );
      cmbPeriodoMes.setWebtags( "" );
      cmbPeriodoMes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbPeriodoMes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbPeriodoMes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbPeriodoMes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbPeriodoMes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbPeriodoMes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbPeriodoMes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbPeriodoMes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbPeriodoMes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbPeriodoMes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbPeriodoMes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbPeriodoMes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbPeriodoMes.getItemCount() > 0 )
      {
         A1731PeriodoMes = (byte)(GXutil.lval( cmbPeriodoMes.getValidValue(GXutil.trim( GXutil.str( A1731PeriodoMes, 2, 0))))) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'FREESTYLEGRID1_nFirstRecordOnPage'},{av:'FREESTYLEGRID1_nEOF'},{av:'cmbPeriodoMes'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1730PeriodoAnio',fld:'PERIODOANIO',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavPeriodoanio'},{av:'AV27PeriodoAnio',fld:'vPERIODOANIO',pic:'ZZZ9'},{av:'AV21WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'cmbavPeriodoanio'},{av:'AV27PeriodoAnio',fld:'vPERIODOANIO',pic:'ZZZ9'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'}]}");
      setEventMetadata("FREESTYLEGRID1.LOAD","{handler:'e15PC2',iparms:[{av:'A1730PeriodoAnio',fld:'PERIODOANIO',pic:'ZZZ9'},{av:'cmbPeriodoMes'},{av:'A1731PeriodoMes',fld:'PERIODOMES',pic:'Z9'},{av:'A1735PeriodoCntLiq',fld:'PERIODOCNTLIQ',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1729PeriodoLiq',fld:'PERIODOLIQ',pic:''}]");
      setEventMetadata("FREESTYLEGRID1.LOAD",",oparms:[{av:'AV5CardPeriod1_PeriodoAnio',fld:'vCARDPERIOD1_PERIODOANIO',pic:'ZZZ9'},{av:'cmbavCardperiod1_periodomes'},{av:'AV8CardPeriod1_PeriodoMes',fld:'vCARDPERIOD1_PERIODOMES',pic:'Z9'},{av:'AV7CardPeriod1_PeriodoCntLiq',fld:'vCARDPERIOD1_PERIODOCNTLIQ',pic:'ZZZ9'},{av:'AV6CardPeriod1_PeriodoCntLeg',fld:'vCARDPERIOD1_PERIODOCNTLEG',pic:'ZZZ9'},{av:'edtavCardperiod1_periodocntleg_Visible',ctrl:'vCARDPERIOD1_PERIODOCNTLEG',prop:'Visible'},{av:'lblCardperiod1_periodolegajos_Visible',ctrl:'CARDPERIOD1_PERIODOLEGAJOS',prop:'Visible'},{av:'divCardperiod1_tableliquidaciones_Visible',ctrl:'CARDPERIOD1_TABLELIQUIDACIONES',prop:'Visible'},{av:'divTbl_sin_Visible',ctrl:'TBL_SIN',prop:'Visible'},{av:'AV22PeriodoLiq',fld:'vPERIODOLIQ',pic:'',hsh:true},{av:'edtavPeriodoliq_Visible',ctrl:'vPERIODOLIQ',prop:'Visible'}]}");
      setEventMetadata("'DOAGREGAR'","{handler:'e13PC2',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("'DOAGREGAR'",",oparms:[{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e11PC2',iparms:[{av:'AV21WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV17MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e18PC1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("FREESTYLEGRID1.REFRESH","{handler:'e17PC2',iparms:[]");
      setEventMetadata("FREESTYLEGRID1.REFRESH",",oparms:[]}");
      setEventMetadata("VPERIODOANIO.CONTROLVALUECHANGED","{handler:'e12PC2',iparms:[{av:'cmbavPeriodoanio'},{av:'AV27PeriodoAnio',fld:'vPERIODOANIO',pic:'ZZZ9'}]");
      setEventMetadata("VPERIODOANIO.CONTROLVALUECHANGED",",oparms:[]}");
      setEventMetadata("VALIDV_CARDPERIOD1_PERIODOMES","{handler:'validv_Cardperiod1_periodomes',iparms:[]");
      setEventMetadata("VALIDV_CARDPERIOD1_PERIODOMES",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Periodomes',iparms:[]");
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
      wcpOAV17MenuOpcCod = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV17MenuOpcCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      Freestylegrid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV22PeriodoLiq = GXutil.nullDate() ;
      scmdbuf = "" ;
      H00PC2_A1730PeriodoAnio = new short[1] ;
      H00PC2_A1731PeriodoMes = new byte[1] ;
      H00PC2_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      H00PC2_A1EmpCod = new short[1] ;
      H00PC2_A3CliCod = new int[1] ;
      AV20WelcomeMessage_Foto = "" ;
      AV13MenuBienveImgURL = "" ;
      GXv_char5 = new String[1] ;
      AV15MenuBienveTitulo = "" ;
      AV14MenuBienveTexto = "" ;
      AV37Welcomemessage_foto_GXI = "" ;
      GXt_char9 = "" ;
      GXv_char6 = new String[1] ;
      Freestylegrid1Row = new com.genexus.webpanels.GXWebRow();
      GXv_int4 = new int[1] ;
      AV19textoNoMostrara = "" ;
      GXv_boolean8 = new boolean[1] ;
      H00PC3_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      H00PC3_A3CliCod = new int[1] ;
      H00PC3_A1EmpCod = new short[1] ;
      H00PC3_A1730PeriodoAnio = new short[1] ;
      AV32hoy = GXutil.nullDate() ;
      AV33anioPalabra = "" ;
      GXt_char10 = "" ;
      GXv_char7 = new String[1] ;
      GXv_int2 = new short[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      bttBtnagregar_Jsonclick = "" ;
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subFreestylegrid1_Linesclass = "" ;
      Freestylegrid1Column = new com.genexus.webpanels.GXWebColumn();
      GXCCtl = "" ;
      ROClassString = "" ;
      lblPeriodoliquidaciones1_Jsonclick = "" ;
      lblPeriodoliquidaciones_Jsonclick = "" ;
      lblCardperiod1_periodolegajos_Jsonclick = "" ;
      subFreestylegrid1_Header = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.periodos__default(),
         new Object[] {
             new Object[] {
            H00PC2_A1730PeriodoAnio, H00PC2_A1731PeriodoMes, H00PC2_A1729PeriodoLiq, H00PC2_A1EmpCod, H00PC2_A3CliCod
            }
            , new Object[] {
            H00PC3_A1729PeriodoLiq, H00PC3_A3CliCod, H00PC3_A1EmpCod, H00PC3_A1730PeriodoAnio
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      cmbavCardperiod1_periodomes.setEnabled( 0 );
      edtavCardperiod1_periodoanio_Enabled = 0 ;
      edtavCardperiod1_periodocntliq_Enabled = 0 ;
      edtavSinliqcnt_Enabled = 0 ;
      edtavCardperiod1_periodocntleg_Enabled = 0 ;
      edtavPeriodoliq_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte AV8CardPeriod1_PeriodoMes ;
   private byte A1731PeriodoMes ;
   private byte nDonePA ;
   private byte subFreestylegrid1_Backcolorstyle ;
   private byte FREESTYLEGRID1_nEOF ;
   private byte AV38GXLvl150 ;
   private byte subFreestylegrid1_Backstyle ;
   private byte subFreestylegrid1_Allowselection ;
   private byte subFreestylegrid1_Allowhovering ;
   private byte subFreestylegrid1_Allowcollapsing ;
   private byte subFreestylegrid1_Collapsed ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short AV27PeriodoAnio ;
   private short AV10EmpCod ;
   private short A1730PeriodoAnio ;
   private short A1EmpCod ;
   private short A1735PeriodoCntLiq ;
   private short wbEnd ;
   private short wbStart ;
   private short AV5CardPeriod1_PeriodoAnio ;
   private short AV7CardPeriod1_PeriodoCntLiq ;
   private short AV25sinLiqCnt ;
   private short AV6CardPeriod1_PeriodoCntLeg ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXt_int1 ;
   private short AV29ultimoPeriodoAnio ;
   private short AV31hoyAnio ;
   private short AV28sesion_PeriodoAnio ;
   private short AV34cntPer ;
   private short GXv_int2[] ;
   private int nRC_GXsfl_71 ;
   private int nGXsfl_71_idx=1 ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private int subFreestylegrid1_Islastpage ;
   private int edtavCardperiod1_periodoanio_Enabled ;
   private int edtavCardperiod1_periodocntliq_Enabled ;
   private int edtavSinliqcnt_Enabled ;
   private int edtavCardperiod1_periodocntleg_Enabled ;
   private int edtavPeriodoliq_Enabled ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int edtavCardperiod1_periodocntleg_Visible ;
   private int lblCardperiod1_periodolegajos_Visible ;
   private int divCardperiod1_tableliquidaciones_Visible ;
   private int divTbl_sin_Visible ;
   private int edtavPeriodoliq_Visible ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int idxLst ;
   private int subFreestylegrid1_Backcolor ;
   private int subFreestylegrid1_Allbackcolor ;
   private int subFreestylegrid1_Selectedindex ;
   private int subFreestylegrid1_Selectioncolor ;
   private int subFreestylegrid1_Hoveringcolor ;
   private long FREESTYLEGRID1_nCurrentRecord ;
   private long FREESTYLEGRID1_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_71_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String subFreestylegrid1_Class ;
   private String subFreestylegrid1_Flexwrap ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String subFreestylegrid1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavCardperiod1_periodoanio_Internalname ;
   private String edtavCardperiod1_periodocntliq_Internalname ;
   private String edtavSinliqcnt_Internalname ;
   private String edtavCardperiod1_periodocntleg_Internalname ;
   private String edtavPeriodoliq_Internalname ;
   private String scmdbuf ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String GXv_char5[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String GXt_char9 ;
   private String GXv_char6[] ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String divCardperiod1_tableliquidaciones_Internalname ;
   private String divTbl_sin_Internalname ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String AV33anioPalabra ;
   private String GXt_char10 ;
   private String GXv_char7[] ;
   private String lblCouttext_Caption ;
   private String lblCouttext_Internalname ;
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
   private String TempTags ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divTableacciones_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String bttBtnagregar_Internalname ;
   private String bttBtnagregar_Jsonclick ;
   private String divTablecontent_Internalname ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private String lblPeriodoliquidaciones1_Internalname ;
   private String lblPeriodoliquidaciones_Internalname ;
   private String lblCardperiod1_periodolegajos_Internalname ;
   private String sGXsfl_71_fel_idx="0001" ;
   private String subFreestylegrid1_Linesclass ;
   private String tblFreestylegrid1layouttable_Internalname ;
   private String divCardperiod1_cardperiodcontainer_Internalname ;
   private String divCardperiod1_cardperiodtop_Internalname ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtavCardperiod1_periodoanio_Jsonclick ;
   private String divCardperiod1_cardperiodbottom_Internalname ;
   private String edtavCardperiod1_periodocntliq_Jsonclick ;
   private String lblPeriodoliquidaciones1_Jsonclick ;
   private String edtavSinliqcnt_Jsonclick ;
   private String lblPeriodoliquidaciones_Jsonclick ;
   private String divCardperiod1_tablelegajos_Internalname ;
   private String edtavCardperiod1_periodocntleg_Jsonclick ;
   private String lblCardperiod1_periodolegajos_Jsonclick ;
   private String edtavPeriodoliq_Jsonclick ;
   private String tblUnnamedtablecontentfsfreestylegrid1_Internalname ;
   private String subFreestylegrid1_Header ;
   private String lblPeriodoliquidaciones1_Caption ;
   private String lblCardperiod1_periodolegajos_Caption ;
   private java.util.Date A1729PeriodoLiq ;
   private java.util.Date AV22PeriodoLiq ;
   private java.util.Date AV32hoy ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_71_Refreshing=false ;
   private boolean AV21WelcomeMessage_NoMostrarMas ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV16MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean GXv_boolean8[] ;
   private boolean brkPC3 ;
   private boolean AV20WelcomeMessage_Foto_IsBlob ;
   private String AV14MenuBienveTexto ;
   private String AV19textoNoMostrara ;
   private String wcpOAV17MenuOpcCod ;
   private String AV17MenuOpcCod ;
   private String AV13MenuBienveImgURL ;
   private String AV15MenuBienveTitulo ;
   private String AV37Welcomemessage_foto_GXI ;
   private String AV20WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid Freestylegrid1Container ;
   private com.genexus.webpanels.GXWebRow Freestylegrid1Row ;
   private com.genexus.webpanels.GXWebColumn Freestylegrid1Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbavPeriodoanio ;
   private HTMLChoice cmbavCardperiod1_periodomes ;
   private HTMLChoice cmbPeriodoMes ;
   private IDataStoreProvider pr_default ;
   private short[] H00PC2_A1730PeriodoAnio ;
   private byte[] H00PC2_A1731PeriodoMes ;
   private java.util.Date[] H00PC2_A1729PeriodoLiq ;
   private short[] H00PC2_A1EmpCod ;
   private int[] H00PC2_A3CliCod ;
   private java.util.Date[] H00PC3_A1729PeriodoLiq ;
   private int[] H00PC3_A3CliCod ;
   private short[] H00PC3_A1EmpCod ;
   private short[] H00PC3_A1730PeriodoAnio ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class periodos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00PC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV27PeriodoAnio ,
                                          short A1730PeriodoAnio ,
                                          int AV9CliCod ,
                                          short AV10EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[3];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT PeriodoAnio, PeriodoMes, PeriodoLiq, EmpCod, CliCod FROM Periodo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV27PeriodoAnio) )
      {
         addWhere(sWhereString, "(PeriodoAnio = ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, PeriodoLiq" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
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
                  return conditional_H00PC2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00PC2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00PC3", "SELECT PeriodoLiq, CliCod, EmpCod, PeriodoAnio FROM Periodo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, PeriodoAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

