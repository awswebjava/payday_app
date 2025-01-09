package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajogeneral_impl extends GXWebComponent
{
   public legajogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajogeneral_impl.class ));
   }

   public legajogeneral_impl( int remoteHandle ,
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
      cmbLegSexo = new HTMLChoice();
      cmbLegEstadoCivil = new HTMLChoice();
      cmbLegDiscapacidad = new HTMLChoice();
      cmbLegClase = new HTMLChoice();
      chkLegSCVO = UIFactory.getCheckbox(this);
      cmbLegFormaPago = new HTMLChoice();
      cmbLegBanTipCuen = new HTMLChoice();
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
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1EmpCod),Integer.valueOf(A6LegNumero)});
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
         pa5S2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Legajo General", "")) ;
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/img_ucRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0))}, new String[] {"CliCod","EmpCod","LegNumero"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
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
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA3CliCod", GXutil.ltrim( localUtil.ntoc( wcpOA3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOA1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA6LegNumero", GXutil.ltrim( localUtil.ntoc( wcpOA6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCONVEVERSIONCLI", GXutil.ltrim( localUtil.ntoc( A1576LegConveVersionCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGPAICOD", GXutil.ltrim( localUtil.ntoc( A22LegPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCONVECODIGO", GXutil.rtrim( A937LegConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMG_UC1_Class_img", GXutil.rtrim( Img_uc1_Class_img));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Width", GXutil.rtrim( Dvpanel_transactiondetail_paneliden_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Autowidth", GXutil.booltostr( Dvpanel_transactiondetail_paneliden_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Autoheight", GXutil.booltostr( Dvpanel_transactiondetail_paneliden_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Cls", GXutil.rtrim( Dvpanel_transactiondetail_paneliden_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Title", GXutil.rtrim( Dvpanel_transactiondetail_paneliden_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Collapsible", GXutil.booltostr( Dvpanel_transactiondetail_paneliden_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Collapsed", GXutil.booltostr( Dvpanel_transactiondetail_paneliden_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Showcollapseicon", GXutil.booltostr( Dvpanel_transactiondetail_paneliden_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Iconposition", GXutil.rtrim( Dvpanel_transactiondetail_paneliden_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Autoscroll", GXutil.booltostr( Dvpanel_transactiondetail_paneliden_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Width", GXutil.rtrim( Dvpanel_transactiondetail_panellab_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Autowidth", GXutil.booltostr( Dvpanel_transactiondetail_panellab_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Autoheight", GXutil.booltostr( Dvpanel_transactiondetail_panellab_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Cls", GXutil.rtrim( Dvpanel_transactiondetail_panellab_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Title", GXutil.rtrim( Dvpanel_transactiondetail_panellab_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Collapsible", GXutil.booltostr( Dvpanel_transactiondetail_panellab_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Collapsed", GXutil.booltostr( Dvpanel_transactiondetail_panellab_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Showcollapseicon", GXutil.booltostr( Dvpanel_transactiondetail_panellab_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Iconposition", GXutil.rtrim( Dvpanel_transactiondetail_panellab_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Autoscroll", GXutil.booltostr( Dvpanel_transactiondetail_panellab_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Width", GXutil.rtrim( Dvpanel_transactiondetail_panelotr_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Autowidth", GXutil.booltostr( Dvpanel_transactiondetail_panelotr_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Autoheight", GXutil.booltostr( Dvpanel_transactiondetail_panelotr_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Cls", GXutil.rtrim( Dvpanel_transactiondetail_panelotr_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Title", GXutil.rtrim( Dvpanel_transactiondetail_panelotr_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Collapsible", GXutil.booltostr( Dvpanel_transactiondetail_panelotr_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Collapsed", GXutil.booltostr( Dvpanel_transactiondetail_panelotr_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Showcollapseicon", GXutil.booltostr( Dvpanel_transactiondetail_panelotr_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Iconposition", GXutil.rtrim( Dvpanel_transactiondetail_panelotr_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Autoscroll", GXutil.booltostr( Dvpanel_transactiondetail_panelotr_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Width", GXutil.rtrim( Dvpanel_transactiondetail_panelban_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Autowidth", GXutil.booltostr( Dvpanel_transactiondetail_panelban_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Autoheight", GXutil.booltostr( Dvpanel_transactiondetail_panelban_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Cls", GXutil.rtrim( Dvpanel_transactiondetail_panelban_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Title", GXutil.rtrim( Dvpanel_transactiondetail_panelban_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Collapsible", GXutil.booltostr( Dvpanel_transactiondetail_panelban_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Collapsed", GXutil.booltostr( Dvpanel_transactiondetail_panelban_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Showcollapseicon", GXutil.booltostr( Dvpanel_transactiondetail_panelban_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Iconposition", GXutil.rtrim( Dvpanel_transactiondetail_panelban_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Autoscroll", GXutil.booltostr( Dvpanel_transactiondetail_panelban_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
   }

   public void renderHtmlCloseForm5S2( )
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
      return "LegajoGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Legajo General", "") ;
   }

   public void wb5S0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.legajogeneral");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("UserControls/img_ucRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         }
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTable_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 11,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdateup_Internalname, "", httpContext.getMessage( "Modificar", ""), bttBtnupdateup_Jsonclick, 5, httpContext.getMessage( "Modificar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOUPDATEUP\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 13,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtneliminarup_Internalname, "", httpContext.getMessage( "Eliminar", ""), bttBtneliminarup_Jsonclick, 5, httpContext.getMessage( "Eliminar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOELIMINARUP\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTransactiondetail_tablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTransactiondetail_tablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_22_5S2( true) ;
      }
      else
      {
         wb_table1_22_5S2( false) ;
      }
      return  ;
   }

   public void wb_table1_22_5S2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_transactiondetail_panellab.setProperty("Width", Dvpanel_transactiondetail_panellab_Width);
         ucDvpanel_transactiondetail_panellab.setProperty("AutoWidth", Dvpanel_transactiondetail_panellab_Autowidth);
         ucDvpanel_transactiondetail_panellab.setProperty("AutoHeight", Dvpanel_transactiondetail_panellab_Autoheight);
         ucDvpanel_transactiondetail_panellab.setProperty("Cls", Dvpanel_transactiondetail_panellab_Cls);
         ucDvpanel_transactiondetail_panellab.setProperty("Title", Dvpanel_transactiondetail_panellab_Title);
         ucDvpanel_transactiondetail_panellab.setProperty("Collapsible", Dvpanel_transactiondetail_panellab_Collapsible);
         ucDvpanel_transactiondetail_panellab.setProperty("Collapsed", Dvpanel_transactiondetail_panellab_Collapsed);
         ucDvpanel_transactiondetail_panellab.setProperty("ShowCollapseIcon", Dvpanel_transactiondetail_panellab_Showcollapseicon);
         ucDvpanel_transactiondetail_panellab.setProperty("IconPosition", Dvpanel_transactiondetail_panellab_Iconposition);
         ucDvpanel_transactiondetail_panellab.setProperty("AutoScroll", Dvpanel_transactiondetail_panellab_Autoscroll);
         ucDvpanel_transactiondetail_panellab.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_transactiondetail_panellab_Internalname, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLABContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLABContainer"+"TransactionDetail_PanelLab"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTransactiondetail_panellab_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLegClase.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbLegClase.getInternalname(), httpContext.getMessage( "Clase", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLegClase, cmbLegClase.getInternalname(), GXutil.trim( GXutil.str( A235LegClase, 1, 0)), 1, cmbLegClase.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbLegClase.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_LegajoGeneral.htm");
         cmbLegClase.setValue( GXutil.trim( GXutil.str( A235LegClase, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegClase.getInternalname(), "Values", cmbLegClase.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOsoSiglaYDesc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtOsoSiglaYDesc_Internalname, httpContext.getMessage( "Obra Social", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtOsoSiglaYDesc_Internalname, A555OsoSiglaYDesc, "", "", (short)(0), 1, edtOsoSiglaYDesc_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtSecDescrip_Internalname, httpContext.getMessage( "Area", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtSecDescrip_Internalname, A329SecDescrip, "", "", (short)(0), 1, edtSecDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSinDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtSinDescrip_Internalname, httpContext.getMessage( "Sindicato", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtSinDescrip_Internalname, A331SinDescrip, "", "", (short)(0), 1, edtSinDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLegbasico_cell_Internalname, 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegBasico_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegBasico_Internalname, httpContext.getMessage( "Sueldo Básico categoría", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A233LegBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegBasico_Enabled!=0) ? localUtil.format( A233LegBasico, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A233LegBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegBasico_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegBasico_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLegsueldofuera_cell_Internalname, 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegSueldoFuera_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegSueldoFuera_Internalname, httpContext.getMessage( "Sueldo fuera de convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegSueldoFuera_Internalname, GXutil.ltrim( localUtil.ntoc( A264LegSueldoFuera, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegSueldoFuera_Enabled!=0) ? localUtil.format( A264LegSueldoFuera, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A264LegSueldoFuera, "ZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegSueldoFuera_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegSueldoFuera_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divMegdescrip_cell_Internalname, 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMegDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMegDescrip_Internalname, httpContext.getMessage( "Motivo de Egreso", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMegDescrip_Internalname, A300MegDescrip, "", "", (short)(0), 1, edtMegDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_transactiondetail_panelotr.setProperty("Width", Dvpanel_transactiondetail_panelotr_Width);
         ucDvpanel_transactiondetail_panelotr.setProperty("AutoWidth", Dvpanel_transactiondetail_panelotr_Autowidth);
         ucDvpanel_transactiondetail_panelotr.setProperty("AutoHeight", Dvpanel_transactiondetail_panelotr_Autoheight);
         ucDvpanel_transactiondetail_panelotr.setProperty("Cls", Dvpanel_transactiondetail_panelotr_Cls);
         ucDvpanel_transactiondetail_panelotr.setProperty("Title", Dvpanel_transactiondetail_panelotr_Title);
         ucDvpanel_transactiondetail_panelotr.setProperty("Collapsible", Dvpanel_transactiondetail_panelotr_Collapsible);
         ucDvpanel_transactiondetail_panelotr.setProperty("Collapsed", Dvpanel_transactiondetail_panelotr_Collapsed);
         ucDvpanel_transactiondetail_panelotr.setProperty("ShowCollapseIcon", Dvpanel_transactiondetail_panelotr_Showcollapseicon);
         ucDvpanel_transactiondetail_panelotr.setProperty("IconPosition", Dvpanel_transactiondetail_panelotr_Iconposition);
         ucDvpanel_transactiondetail_panelotr.setProperty("AutoScroll", Dvpanel_transactiondetail_panelotr_Autoscroll);
         ucDvpanel_transactiondetail_panelotr.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_transactiondetail_panelotr_Internalname, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTRContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTRContainer"+"TransactionDetail_PanelOtr"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTransactiondetail_panelotr_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipEmpleCod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtTipEmpleCod_Internalname, httpContext.getMessage( "Tipo de Empleador", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtTipEmpleCod_Internalname, GXutil.rtrim( A45TipEmpleCod), GXutil.rtrim( localUtil.format( A45TipEmpleCod, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipEmpleCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipEmpleCod_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCondiDescri_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCondiDescri_Internalname, httpContext.getMessage( "Condicion", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCondiDescri_Internalname, A144CondiDescri, GXutil.rtrim( localUtil.format( A144CondiDescri, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCondiDescri_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCondiDescri_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegActDescri_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegActDescri_Internalname, httpContext.getMessage( "Actividad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegActDescri_Internalname, A227LegActDescri, GXutil.rtrim( localUtil.format( A227LegActDescri, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegActDescri_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegActDescri_Enabled, 0, "text", "", 80, "chr", 1, "row", 150, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMprDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMprDescrip_Internalname, httpContext.getMessage( "Modalidad de Contratación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMprDescrip_Internalname, A303MprDescrip, "", "", (short)(0), 1, edtMprDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSinieDescri_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtSinieDescri_Internalname, httpContext.getMessage( "Siniestrado", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtSinieDescri_Internalname, A333SinieDescri, "", "", (short)(0), 1, edtSinieDescri_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtZonDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtZonDescrip_Internalname, httpContext.getMessage( "Zona", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtZonDescrip_Internalname, A342ZonDescrip, "", "", (short)(0), 1, edtZonDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOsoC3992_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtOsoC3992_Internalname, httpContext.getMessage( "Obra Social (Cód. AFIP)", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtOsoC3992_Internalname, GXutil.rtrim( A306OsoC3992), GXutil.rtrim( localUtil.format( A306OsoC3992, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOsoC3992_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOsoC3992_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkLegSCVO.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkLegSCVO.getInternalname(), httpContext.getMessage( "Seguro de Vida Obligatorio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkLegSCVO.getInternalname(), GXutil.booltostr( A262LegSCVO), "", httpContext.getMessage( "Seguro de Vida Obligatorio", ""), 1, chkLegSCVO.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_transactiondetail_panelban.setProperty("Width", Dvpanel_transactiondetail_panelban_Width);
         ucDvpanel_transactiondetail_panelban.setProperty("AutoWidth", Dvpanel_transactiondetail_panelban_Autowidth);
         ucDvpanel_transactiondetail_panelban.setProperty("AutoHeight", Dvpanel_transactiondetail_panelban_Autoheight);
         ucDvpanel_transactiondetail_panelban.setProperty("Cls", Dvpanel_transactiondetail_panelban_Cls);
         ucDvpanel_transactiondetail_panelban.setProperty("Title", Dvpanel_transactiondetail_panelban_Title);
         ucDvpanel_transactiondetail_panelban.setProperty("Collapsible", Dvpanel_transactiondetail_panelban_Collapsible);
         ucDvpanel_transactiondetail_panelban.setProperty("Collapsed", Dvpanel_transactiondetail_panelban_Collapsed);
         ucDvpanel_transactiondetail_panelban.setProperty("ShowCollapseIcon", Dvpanel_transactiondetail_panelban_Showcollapseicon);
         ucDvpanel_transactiondetail_panelban.setProperty("IconPosition", Dvpanel_transactiondetail_panelban_Iconposition);
         ucDvpanel_transactiondetail_panelban.setProperty("AutoScroll", Dvpanel_transactiondetail_panelban_Autoscroll);
         ucDvpanel_transactiondetail_panelban.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_transactiondetail_panelban_Internalname, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBANContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBANContainer"+"TransactionDetail_PanelBan"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTransactiondetail_panelban_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLpgDescri_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLpgDescri_Internalname, httpContext.getMessage( "Lugar de Pago", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLpgDescri_Internalname, A291LpgDescri, GXutil.rtrim( localUtil.format( A291LpgDescri, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLpgDescri_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLpgDescri_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLegFormaPago.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbLegFormaPago.getInternalname(), httpContext.getMessage( "Forma de pago", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLegFormaPago, cmbLegFormaPago.getInternalname(), GXutil.trim( GXutil.str( A248LegFormaPago, 1, 0)), 1, cmbLegFormaPago.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbLegFormaPago.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_LegajoGeneral.htm");
         cmbLegFormaPago.setValue( GXutil.trim( GXutil.str( A248LegFormaPago, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegFormaPago.getInternalname(), "Values", cmbLegFormaPago.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegBanSuc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegBanSuc_Internalname, httpContext.getMessage( "Sucursal", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegBanSuc_Internalname, A231LegBanSuc, GXutil.rtrim( localUtil.format( A231LegBanSuc, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegBanSuc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegBanSuc_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLegBanTipCuen.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbLegBanTipCuen.getInternalname(), httpContext.getMessage( "Tipo de Cuenta", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLegBanTipCuen, cmbLegBanTipCuen.getInternalname(), GXutil.rtrim( A232LegBanTipCuen), 1, cmbLegBanTipCuen.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbLegBanTipCuen.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_LegajoGeneral.htm");
         cmbLegBanTipCuen.setValue( GXutil.rtrim( A232LegBanTipCuen) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegBanTipCuen.getInternalname(), "Values", cmbLegBanTipCuen.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuentaBanc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuentaBanc_Internalname, httpContext.getMessage( "Cta. Bancaria", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuentaBanc_Internalname, A238LegCuentaBanc, GXutil.rtrim( localUtil.format( A238LegCuentaBanc, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuentaBanc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuentaBanc_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCBU_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCBU_Internalname, httpContext.getMessage( "CBU", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCBU_Internalname, A234LegCBU, GXutil.rtrim( localUtil.format( A234LegCBU, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCBU_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCBU_Enabled, 0, "text", "", 22, "chr", 1, "row", 22, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CBU", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
         ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
         ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
         ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
         ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
         ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
         ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
         ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
         ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
         ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
         ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegObs_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegObs_Internalname, httpContext.getMessage( "Observaciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtLegObs_Internalname, A515LegObs, "", "", (short)(0), 1, edtLegObs_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 235,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 5, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOUPDATE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 237,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnDefault" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DODELETE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoGeneral.htm");
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
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LegajoGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start5S2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Legajo General", ""), (short)(0)) ;
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
            strup5S0( ) ;
         }
      }
   }

   public void ws5S2( )
   {
      start5S2( ) ;
      evt5S2( ) ;
   }

   public void evt5S2( )
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
                              strup5S0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e115S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5S0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "'DOUPDATEUP'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5S0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "'DOELIMINARUP'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5S0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "'DOUPDATE'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5S0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "'DODELETE'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5S0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5S0( ) ;
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
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we5S2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm5S2( ) ;
         }
      }
   }

   public void pa5S2( )
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
      if ( cmbLegSexo.getItemCount() > 0 )
      {
         A263LegSexo = (byte)(GXutil.lval( cmbLegSexo.getValidValue(GXutil.trim( GXutil.str( A263LegSexo, 2, 0))))) ;
         n263LegSexo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A263LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A263LegSexo), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegSexo.setValue( GXutil.trim( GXutil.str( A263LegSexo, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegSexo.getInternalname(), "Values", cmbLegSexo.ToJavascriptSource(), true);
      }
      if ( cmbLegEstadoCivil.getItemCount() > 0 )
      {
         A243LegEstadoCivil = (short)(GXutil.lval( cmbLegEstadoCivil.getValidValue(GXutil.trim( GXutil.str( A243LegEstadoCivil, 4, 0))))) ;
         n243LegEstadoCivil = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A243LegEstadoCivil", GXutil.ltrimstr( DecimalUtil.doubleToDec(A243LegEstadoCivil), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegEstadoCivil.setValue( GXutil.trim( GXutil.str( A243LegEstadoCivil, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegEstadoCivil.getInternalname(), "Values", cmbLegEstadoCivil.ToJavascriptSource(), true);
      }
      if ( cmbLegDiscapacidad.getItemCount() > 0 )
      {
         A241LegDiscapacidad = (byte)(GXutil.lval( cmbLegDiscapacidad.getValidValue(GXutil.trim( GXutil.str( A241LegDiscapacidad, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A241LegDiscapacidad", GXutil.str( A241LegDiscapacidad, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegDiscapacidad.setValue( GXutil.trim( GXutil.str( A241LegDiscapacidad, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegDiscapacidad.getInternalname(), "Values", cmbLegDiscapacidad.ToJavascriptSource(), true);
      }
      if ( cmbLegClase.getItemCount() > 0 )
      {
         A235LegClase = (byte)(GXutil.lval( cmbLegClase.getValidValue(GXutil.trim( GXutil.str( A235LegClase, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A235LegClase", GXutil.str( A235LegClase, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegClase.setValue( GXutil.trim( GXutil.str( A235LegClase, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegClase.getInternalname(), "Values", cmbLegClase.ToJavascriptSource(), true);
      }
      A262LegSCVO = GXutil.strtobool( GXutil.booltostr( A262LegSCVO)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A262LegSCVO", A262LegSCVO);
      if ( cmbLegFormaPago.getItemCount() > 0 )
      {
         A248LegFormaPago = (byte)(GXutil.lval( cmbLegFormaPago.getValidValue(GXutil.trim( GXutil.str( A248LegFormaPago, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A248LegFormaPago", GXutil.str( A248LegFormaPago, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegFormaPago.setValue( GXutil.trim( GXutil.str( A248LegFormaPago, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegFormaPago.getInternalname(), "Values", cmbLegFormaPago.ToJavascriptSource(), true);
      }
      if ( cmbLegBanTipCuen.getItemCount() > 0 )
      {
         A232LegBanTipCuen = cmbLegBanTipCuen.getValidValue(A232LegBanTipCuen) ;
         n232LegBanTipCuen = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A232LegBanTipCuen", A232LegBanTipCuen);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegBanTipCuen.setValue( GXutil.rtrim( A232LegBanTipCuen) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegBanTipCuen.getInternalname(), "Values", cmbLegBanTipCuen.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf5S2( ) ;
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

   public void rf5S2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H005S2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1581LegLpgCodigo = H005S2_A1581LegLpgCodigo[0] ;
            n1581LegLpgCodigo = H005S2_n1581LegLpgCodigo[0] ;
            A1583LegMegCodigo = H005S2_A1583LegMegCodigo[0] ;
            n1583LegMegCodigo = H005S2_n1583LegMegCodigo[0] ;
            A1580LegOsoCod = H005S2_A1580LegOsoCod[0] ;
            n1580LegOsoCod = H005S2_n1580LegOsoCod[0] ;
            A1579LegSecCodigo = H005S2_A1579LegSecCodigo[0] ;
            n1579LegSecCodigo = H005S2_n1579LegSecCodigo[0] ;
            A18MprCod = H005S2_A18MprCod[0] ;
            n18MprCod = H005S2_n18MprCod[0] ;
            A20ZonCod = H005S2_A20ZonCod[0] ;
            n20ZonCod = H005S2_n20ZonCod[0] ;
            A17CondiCodigo = H005S2_A17CondiCodigo[0] ;
            n17CondiCodigo = H005S2_n17CondiCodigo[0] ;
            A19SinieCodigo = H005S2_A19SinieCodigo[0] ;
            n19SinieCodigo = H005S2_n19SinieCodigo[0] ;
            A910LegSinCod = H005S2_A910LegSinCod[0] ;
            n910LegSinCod = H005S2_n910LegSinCod[0] ;
            A15LegActCodigo = H005S2_A15LegActCodigo[0] ;
            n15LegActCodigo = H005S2_n15LegActCodigo[0] ;
            A515LegObs = H005S2_A515LegObs[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A515LegObs", A515LegObs);
            A234LegCBU = H005S2_A234LegCBU[0] ;
            n234LegCBU = H005S2_n234LegCBU[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A234LegCBU", A234LegCBU);
            A238LegCuentaBanc = H005S2_A238LegCuentaBanc[0] ;
            n238LegCuentaBanc = H005S2_n238LegCuentaBanc[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A238LegCuentaBanc", A238LegCuentaBanc);
            A232LegBanTipCuen = H005S2_A232LegBanTipCuen[0] ;
            n232LegBanTipCuen = H005S2_n232LegBanTipCuen[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A232LegBanTipCuen", A232LegBanTipCuen);
            A231LegBanSuc = H005S2_A231LegBanSuc[0] ;
            n231LegBanSuc = H005S2_n231LegBanSuc[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A231LegBanSuc", A231LegBanSuc);
            A248LegFormaPago = H005S2_A248LegFormaPago[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A248LegFormaPago", GXutil.str( A248LegFormaPago, 1, 0));
            A291LpgDescri = H005S2_A291LpgDescri[0] ;
            n291LpgDescri = H005S2_n291LpgDescri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A291LpgDescri", A291LpgDescri);
            A262LegSCVO = H005S2_A262LegSCVO[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A262LegSCVO", A262LegSCVO);
            A342ZonDescrip = H005S2_A342ZonDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A342ZonDescrip", A342ZonDescrip);
            A333SinieDescri = H005S2_A333SinieDescri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A333SinieDescri", A333SinieDescri);
            A303MprDescrip = H005S2_A303MprDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A303MprDescrip", A303MprDescrip);
            A227LegActDescri = H005S2_A227LegActDescri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A227LegActDescri", A227LegActDescri);
            A144CondiDescri = H005S2_A144CondiDescri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A144CondiDescri", A144CondiDescri);
            A300MegDescrip = H005S2_A300MegDescrip[0] ;
            n300MegDescrip = H005S2_n300MegDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A300MegDescrip", A300MegDescrip);
            A264LegSueldoFuera = H005S2_A264LegSueldoFuera[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A264LegSueldoFuera", GXutil.ltrimstr( A264LegSueldoFuera, 14, 2));
            A331SinDescrip = H005S2_A331SinDescrip[0] ;
            n331SinDescrip = H005S2_n331SinDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A331SinDescrip", A331SinDescrip);
            A329SecDescrip = H005S2_A329SecDescrip[0] ;
            n329SecDescrip = H005S2_n329SecDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A329SecDescrip", A329SecDescrip);
            A555OsoSiglaYDesc = H005S2_A555OsoSiglaYDesc[0] ;
            n555OsoSiglaYDesc = H005S2_n555OsoSiglaYDesc[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            A236LegCodPos = H005S2_A236LegCodPos[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A236LegCodPos", A236LegCodPos);
            A242LegDomici = H005S2_A242LegDomici[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A242LegDomici", A242LegDomici);
            A479LegEmail = H005S2_A479LegEmail[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A479LegEmail", A479LegEmail);
            A265LegTelefono = H005S2_A265LegTelefono[0] ;
            n265LegTelefono = H005S2_n265LegTelefono[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A265LegTelefono", A265LegTelefono);
            A241LegDiscapacidad = H005S2_A241LegDiscapacidad[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A241LegDiscapacidad", GXutil.str( A241LegDiscapacidad, 1, 0));
            A243LegEstadoCivil = H005S2_A243LegEstadoCivil[0] ;
            n243LegEstadoCivil = H005S2_n243LegEstadoCivil[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A243LegEstadoCivil", GXutil.ltrimstr( DecimalUtil.doubleToDec(A243LegEstadoCivil), 4, 0));
            A244LegFecEgreso = H005S2_A244LegFecEgreso[0] ;
            n244LegFecEgreso = H005S2_n244LegFecEgreso[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A244LegFecEgreso", localUtil.format(A244LegFecEgreso, "99/99/9999"));
            A245LegFecIngreso = H005S2_A245LegFecIngreso[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A245LegFecIngreso", localUtil.format(A245LegFecIngreso, "99/99/9999"));
            A239LegCUIL = H005S2_A239LegCUIL[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A239LegCUIL", GXutil.ltrimstr( DecimalUtil.doubleToDec(A239LegCUIL), 11, 0));
            A93LegId = H005S2_A93LegId[0] ;
            n93LegId = H005S2_n93LegId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A93LegId", A93LegId);
            A246LegFecNac = H005S2_A246LegFecNac[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A246LegFecNac", localUtil.format(A246LegFecNac, "99/99/9999"));
            A230LegApellido = H005S2_A230LegApellido[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A230LegApellido", A230LegApellido);
            A251LegNombre = H005S2_A251LegNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A251LegNombre", A251LegNombre);
            A263LegSexo = H005S2_A263LegSexo[0] ;
            n263LegSexo = H005S2_n263LegSexo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A263LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A263LegSexo), 2, 0));
            A235LegClase = H005S2_A235LegClase[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A235LegClase", GXutil.str( A235LegClase, 1, 0));
            A937LegConveCodigo = H005S2_A937LegConveCodigo[0] ;
            n937LegConveCodigo = H005S2_n937LegConveCodigo[0] ;
            A22LegPaiCod = H005S2_A22LegPaiCod[0] ;
            n22LegPaiCod = H005S2_n22LegPaiCod[0] ;
            A1576LegConveVersionCli = H005S2_A1576LegConveVersionCli[0] ;
            n1576LegConveVersionCli = H005S2_n1576LegConveVersionCli[0] ;
            A303MprDescrip = H005S2_A303MprDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A303MprDescrip", A303MprDescrip);
            A342ZonDescrip = H005S2_A342ZonDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A342ZonDescrip", A342ZonDescrip);
            A144CondiDescri = H005S2_A144CondiDescri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A144CondiDescri", A144CondiDescri);
            A333SinieDescri = H005S2_A333SinieDescri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A333SinieDescri", A333SinieDescri);
            A227LegActDescri = H005S2_A227LegActDescri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A227LegActDescri", A227LegActDescri);
            A331SinDescrip = H005S2_A331SinDescrip[0] ;
            n331SinDescrip = H005S2_n331SinDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A331SinDescrip", A331SinDescrip);
            A291LpgDescri = H005S2_A291LpgDescri[0] ;
            n291LpgDescri = H005S2_n291LpgDescri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A291LpgDescri", A291LpgDescri);
            A300MegDescrip = H005S2_A300MegDescrip[0] ;
            n300MegDescrip = H005S2_n300MegDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A300MegDescrip", A300MegDescrip);
            A555OsoSiglaYDesc = H005S2_A555OsoSiglaYDesc[0] ;
            n555OsoSiglaYDesc = H005S2_n555OsoSiglaYDesc[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            A329SecDescrip = H005S2_A329SecDescrip[0] ;
            n329SecDescrip = H005S2_n329SecDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A329SecDescrip", A329SecDescrip);
            /* Execute user event: Load */
            e115S2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb5S0( ) ;
      }
   }

   public void send_integrity_lvl_hashes5S2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      /* Using cursor H005S3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      A1965EmpOsoCod = H005S3_A1965EmpOsoCod[0] ;
      n1965EmpOsoCod = H005S3_n1965EmpOsoCod[0] ;
      A45TipEmpleCod = H005S3_A45TipEmpleCod[0] ;
      n45TipEmpleCod = H005S3_n45TipEmpleCod[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A45TipEmpleCod", A45TipEmpleCod);
      pr_default.close(1);
      /* Using cursor H005S4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
      A306OsoC3992 = H005S4_A306OsoC3992[0] ;
      n306OsoC3992 = H005S4_n306OsoC3992[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A306OsoC3992", A306OsoC3992);
      pr_default.close(2);
      pr_default.close(1);
      pr_default.close(2);
      fix_multi_value_controls( ) ;
   }

   public void strup5S0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Img_uc1_Class_img = httpContext.cgiGet( sPrefix+"IMG_UC1_Class_img") ;
         Dvpanel_transactiondetail_paneliden_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Width") ;
         Dvpanel_transactiondetail_paneliden_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Autowidth")) ;
         Dvpanel_transactiondetail_paneliden_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Autoheight")) ;
         Dvpanel_transactiondetail_paneliden_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Cls") ;
         Dvpanel_transactiondetail_paneliden_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Title") ;
         Dvpanel_transactiondetail_paneliden_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Collapsible")) ;
         Dvpanel_transactiondetail_paneliden_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Collapsed")) ;
         Dvpanel_transactiondetail_paneliden_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Showcollapseicon")) ;
         Dvpanel_transactiondetail_paneliden_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Iconposition") ;
         Dvpanel_transactiondetail_paneliden_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN_Autoscroll")) ;
         Dvpanel_transactiondetail_panellab_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Width") ;
         Dvpanel_transactiondetail_panellab_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Autowidth")) ;
         Dvpanel_transactiondetail_panellab_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Autoheight")) ;
         Dvpanel_transactiondetail_panellab_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Cls") ;
         Dvpanel_transactiondetail_panellab_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Title") ;
         Dvpanel_transactiondetail_panellab_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Collapsible")) ;
         Dvpanel_transactiondetail_panellab_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Collapsed")) ;
         Dvpanel_transactiondetail_panellab_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Showcollapseicon")) ;
         Dvpanel_transactiondetail_panellab_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Iconposition") ;
         Dvpanel_transactiondetail_panellab_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB_Autoscroll")) ;
         Dvpanel_transactiondetail_panelotr_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Width") ;
         Dvpanel_transactiondetail_panelotr_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Autowidth")) ;
         Dvpanel_transactiondetail_panelotr_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Autoheight")) ;
         Dvpanel_transactiondetail_panelotr_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Cls") ;
         Dvpanel_transactiondetail_panelotr_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Title") ;
         Dvpanel_transactiondetail_panelotr_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Collapsible")) ;
         Dvpanel_transactiondetail_panelotr_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Collapsed")) ;
         Dvpanel_transactiondetail_panelotr_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Showcollapseicon")) ;
         Dvpanel_transactiondetail_panelotr_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Iconposition") ;
         Dvpanel_transactiondetail_panelotr_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR_Autoscroll")) ;
         Dvpanel_transactiondetail_panelban_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Width") ;
         Dvpanel_transactiondetail_panelban_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Autowidth")) ;
         Dvpanel_transactiondetail_panelban_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Autoheight")) ;
         Dvpanel_transactiondetail_panelban_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Cls") ;
         Dvpanel_transactiondetail_panelban_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Title") ;
         Dvpanel_transactiondetail_panelban_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Collapsible")) ;
         Dvpanel_transactiondetail_panelban_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Collapsed")) ;
         Dvpanel_transactiondetail_panelban_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Showcollapseicon")) ;
         Dvpanel_transactiondetail_panelban_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Iconposition") ;
         Dvpanel_transactiondetail_panelban_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN_Autoscroll")) ;
         Dvpanel_unnamedtable1_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Width") ;
         Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
         Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
         Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Cls") ;
         Dvpanel_unnamedtable1_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Title") ;
         Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
         Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
         Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
         Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Iconposition") ;
         Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
         /* Read variables values. */
         cmbLegSexo.setValue( httpContext.cgiGet( cmbLegSexo.getInternalname()) );
         A263LegSexo = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegSexo.getInternalname()))) ;
         n263LegSexo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A263LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A263LegSexo), 2, 0));
         A251LegNombre = httpContext.cgiGet( edtLegNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A251LegNombre", A251LegNombre);
         A230LegApellido = httpContext.cgiGet( edtLegApellido_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A230LegApellido", A230LegApellido);
         A246LegFecNac = localUtil.ctod( httpContext.cgiGet( edtLegFecNac_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A246LegFecNac", localUtil.format(A246LegFecNac, "99/99/9999"));
         A93LegId = httpContext.cgiGet( edtLegId_Internalname) ;
         n93LegId = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A93LegId", A93LegId);
         A239LegCUIL = localUtil.ctol( httpContext.cgiGet( edtLegCUIL_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A239LegCUIL", GXutil.ltrimstr( DecimalUtil.doubleToDec(A239LegCUIL), 11, 0));
         A245LegFecIngreso = localUtil.ctod( httpContext.cgiGet( edtLegFecIngreso_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A245LegFecIngreso", localUtil.format(A245LegFecIngreso, "99/99/9999"));
         A244LegFecEgreso = localUtil.ctod( httpContext.cgiGet( edtLegFecEgreso_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         n244LegFecEgreso = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A244LegFecEgreso", localUtil.format(A244LegFecEgreso, "99/99/9999"));
         cmbLegEstadoCivil.setValue( httpContext.cgiGet( cmbLegEstadoCivil.getInternalname()) );
         A243LegEstadoCivil = (short)(GXutil.lval( httpContext.cgiGet( cmbLegEstadoCivil.getInternalname()))) ;
         n243LegEstadoCivil = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A243LegEstadoCivil", GXutil.ltrimstr( DecimalUtil.doubleToDec(A243LegEstadoCivil), 4, 0));
         cmbLegDiscapacidad.setValue( httpContext.cgiGet( cmbLegDiscapacidad.getInternalname()) );
         A241LegDiscapacidad = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegDiscapacidad.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A241LegDiscapacidad", GXutil.str( A241LegDiscapacidad, 1, 0));
         A265LegTelefono = GXutil.upper( httpContext.cgiGet( edtLegTelefono_Internalname)) ;
         n265LegTelefono = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A265LegTelefono", A265LegTelefono);
         A479LegEmail = httpContext.cgiGet( edtLegEmail_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A479LegEmail", A479LegEmail);
         A242LegDomici = httpContext.cgiGet( edtLegDomici_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A242LegDomici", A242LegDomici);
         A236LegCodPos = GXutil.upper( httpContext.cgiGet( edtLegCodPos_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A236LegCodPos", A236LegCodPos);
         cmbLegClase.setValue( httpContext.cgiGet( cmbLegClase.getInternalname()) );
         A235LegClase = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegClase.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A235LegClase", GXutil.str( A235LegClase, 1, 0));
         A555OsoSiglaYDesc = httpContext.cgiGet( edtOsoSiglaYDesc_Internalname) ;
         n555OsoSiglaYDesc = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
         A329SecDescrip = httpContext.cgiGet( edtSecDescrip_Internalname) ;
         n329SecDescrip = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A329SecDescrip", A329SecDescrip);
         A331SinDescrip = httpContext.cgiGet( edtSinDescrip_Internalname) ;
         n331SinDescrip = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A331SinDescrip", A331SinDescrip);
         A233LegBasico = localUtil.ctond( httpContext.cgiGet( edtLegBasico_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A233LegBasico", GXutil.ltrimstr( A233LegBasico, 14, 2));
         A264LegSueldoFuera = localUtil.ctond( httpContext.cgiGet( edtLegSueldoFuera_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A264LegSueldoFuera", GXutil.ltrimstr( A264LegSueldoFuera, 14, 2));
         A300MegDescrip = httpContext.cgiGet( edtMegDescrip_Internalname) ;
         n300MegDescrip = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A300MegDescrip", A300MegDescrip);
         A45TipEmpleCod = httpContext.cgiGet( edtTipEmpleCod_Internalname) ;
         n45TipEmpleCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A45TipEmpleCod", A45TipEmpleCod);
         A144CondiDescri = GXutil.upper( httpContext.cgiGet( edtCondiDescri_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A144CondiDescri", A144CondiDescri);
         A227LegActDescri = httpContext.cgiGet( edtLegActDescri_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A227LegActDescri", A227LegActDescri);
         A303MprDescrip = httpContext.cgiGet( edtMprDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A303MprDescrip", A303MprDescrip);
         A333SinieDescri = httpContext.cgiGet( edtSinieDescri_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A333SinieDescri", A333SinieDescri);
         A342ZonDescrip = httpContext.cgiGet( edtZonDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A342ZonDescrip", A342ZonDescrip);
         A306OsoC3992 = httpContext.cgiGet( edtOsoC3992_Internalname) ;
         n306OsoC3992 = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A306OsoC3992", A306OsoC3992);
         A262LegSCVO = GXutil.strtobool( httpContext.cgiGet( chkLegSCVO.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A262LegSCVO", A262LegSCVO);
         A291LpgDescri = GXutil.upper( httpContext.cgiGet( edtLpgDescri_Internalname)) ;
         n291LpgDescri = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A291LpgDescri", A291LpgDescri);
         cmbLegFormaPago.setValue( httpContext.cgiGet( cmbLegFormaPago.getInternalname()) );
         A248LegFormaPago = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegFormaPago.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A248LegFormaPago", GXutil.str( A248LegFormaPago, 1, 0));
         A231LegBanSuc = GXutil.upper( httpContext.cgiGet( edtLegBanSuc_Internalname)) ;
         n231LegBanSuc = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A231LegBanSuc", A231LegBanSuc);
         cmbLegBanTipCuen.setValue( httpContext.cgiGet( cmbLegBanTipCuen.getInternalname()) );
         A232LegBanTipCuen = httpContext.cgiGet( cmbLegBanTipCuen.getInternalname()) ;
         n232LegBanTipCuen = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A232LegBanTipCuen", A232LegBanTipCuen);
         A238LegCuentaBanc = GXutil.upper( httpContext.cgiGet( edtLegCuentaBanc_Internalname)) ;
         n238LegCuentaBanc = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A238LegCuentaBanc", A238LegCuentaBanc);
         A234LegCBU = httpContext.cgiGet( edtLegCBU_Internalname) ;
         n234LegCBU = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A234LegCBU", A234LegCBU);
         A515LegObs = httpContext.cgiGet( edtLegObs_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A515LegObs", A515LegObs);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e115S2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_22_5S2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTransactiondetail_tableprindom_Internalname, tblTransactiondetail_tableprindom_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvpanel_transactiondetail_paneliden.setProperty("Width", Dvpanel_transactiondetail_paneliden_Width);
         ucDvpanel_transactiondetail_paneliden.setProperty("AutoWidth", Dvpanel_transactiondetail_paneliden_Autowidth);
         ucDvpanel_transactiondetail_paneliden.setProperty("AutoHeight", Dvpanel_transactiondetail_paneliden_Autoheight);
         ucDvpanel_transactiondetail_paneliden.setProperty("Cls", Dvpanel_transactiondetail_paneliden_Cls);
         ucDvpanel_transactiondetail_paneliden.setProperty("Title", Dvpanel_transactiondetail_paneliden_Title);
         ucDvpanel_transactiondetail_paneliden.setProperty("Collapsible", Dvpanel_transactiondetail_paneliden_Collapsible);
         ucDvpanel_transactiondetail_paneliden.setProperty("Collapsed", Dvpanel_transactiondetail_paneliden_Collapsed);
         ucDvpanel_transactiondetail_paneliden.setProperty("ShowCollapseIcon", Dvpanel_transactiondetail_paneliden_Showcollapseicon);
         ucDvpanel_transactiondetail_paneliden.setProperty("IconPosition", Dvpanel_transactiondetail_paneliden_Iconposition);
         ucDvpanel_transactiondetail_paneliden.setProperty("AutoScroll", Dvpanel_transactiondetail_paneliden_Autoscroll);
         ucDvpanel_transactiondetail_paneliden.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_transactiondetail_paneliden_Internalname, sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDENContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDENContainer"+"TransactionDetail_PanelIden"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTransactiondetail_paneliden_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucImg_uc1.setProperty("class_img", Img_uc1_Class_img);
         ucImg_uc1.render(context, "img_uc", Img_uc1_Internalname, sPrefix+"IMG_UC1Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLegSexo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbLegSexo.getInternalname(), httpContext.getMessage( "Sexo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLegSexo, cmbLegSexo.getInternalname(), GXutil.trim( GXutil.str( A263LegSexo, 2, 0)), 1, cmbLegSexo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbLegSexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_LegajoGeneral.htm");
         cmbLegSexo.setValue( GXutil.trim( GXutil.str( A263LegSexo, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegSexo.getInternalname(), "Values", cmbLegSexo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegNombre_Internalname, httpContext.getMessage( "Nombres", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegNombre_Internalname, A251LegNombre, GXutil.rtrim( localUtil.format( A251LegNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNombre_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegApellido_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegApellido_Internalname, httpContext.getMessage( "Apellido", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegApellido_Internalname, A230LegApellido, GXutil.rtrim( localUtil.format( A230LegApellido, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegApellido_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegApellido_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegFecNac_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegFecNac_Internalname, httpContext.getMessage( "Fec. Nac.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtLegFecNac_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegFecNac_Internalname, localUtil.format(A246LegFecNac, "99/99/9999"), localUtil.format( A246LegFecNac, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegFecNac_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegFecNac_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtLegFecNac_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegFecNac_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LegajoGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegId_Internalname, httpContext.getMessage( "Legajo Nro/ID", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegId_Internalname, GXutil.rtrim( A93LegId), GXutil.rtrim( localUtil.format( A93LegId, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegId_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCUIL_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCUIL_Internalname, httpContext.getMessage( "CUIL", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCUIL_Internalname, GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCUIL_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A239LegCUIL), "ZZ-ZZZZZZZZ-9") : localUtil.format( DecimalUtil.doubleToDec(A239LegCUIL), "ZZ-ZZZZZZZZ-9"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCUIL_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCUIL_Enabled, 0, "text", "", 13, "chr", 1, "row", 13, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegFecIngreso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegFecIngreso_Internalname, httpContext.getMessage( "Fecha de Ingreso", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtLegFecIngreso_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegFecIngreso_Internalname, localUtil.format(A245LegFecIngreso, "99/99/9999"), localUtil.format( A245LegFecIngreso, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegFecIngreso_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegFecIngreso_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtLegFecIngreso_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegFecIngreso_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LegajoGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegFecEgreso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegFecEgreso_Internalname, httpContext.getMessage( "Fecha de Egreso", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtLegFecEgreso_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegFecEgreso_Internalname, localUtil.format(A244LegFecEgreso, "99/99/9999"), localUtil.format( A244LegFecEgreso, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegFecEgreso_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegFecEgreso_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtLegFecEgreso_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegFecEgreso_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LegajoGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLegEstadoCivil.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbLegEstadoCivil.getInternalname(), httpContext.getMessage( "Est. Civil", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLegEstadoCivil, cmbLegEstadoCivil.getInternalname(), GXutil.trim( GXutil.str( A243LegEstadoCivil, 4, 0)), 1, cmbLegEstadoCivil.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbLegEstadoCivil.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_LegajoGeneral.htm");
         cmbLegEstadoCivil.setValue( GXutil.trim( GXutil.str( A243LegEstadoCivil, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegEstadoCivil.getInternalname(), "Values", cmbLegEstadoCivil.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLegDiscapacidad.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbLegDiscapacidad.getInternalname(), httpContext.getMessage( "Discapacidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLegDiscapacidad, cmbLegDiscapacidad.getInternalname(), GXutil.trim( GXutil.str( A241LegDiscapacidad, 1, 0)), 1, cmbLegDiscapacidad.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbLegDiscapacidad.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_LegajoGeneral.htm");
         cmbLegDiscapacidad.setValue( GXutil.trim( GXutil.str( A241LegDiscapacidad, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegDiscapacidad.getInternalname(), "Values", cmbLegDiscapacidad.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegTelefono_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegTelefono_Internalname, httpContext.getMessage( "Telefono", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegTelefono_Internalname, A265LegTelefono, GXutil.rtrim( localUtil.format( A265LegTelefono, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegTelefono_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegTelefono_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegEmail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegEmail_Internalname, httpContext.getMessage( "Email", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegEmail_Internalname, A479LegEmail, GXutil.rtrim( localUtil.format( A479LegEmail, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "mailto:"+A479LegEmail, "", "", "", edtLegEmail_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegEmail_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegDomici_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegDomici_Internalname, httpContext.getMessage( "Domicilio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtLegDomici_Internalname, A242LegDomici, "", "", (short)(0), 1, edtLegDomici_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "4000", -1, 0, "", "", (byte)(-1), true, "VarcharTextArea", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCodPos_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCodPos_Internalname, httpContext.getMessage( "Cod. Pos.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCodPos_Internalname, GXutil.rtrim( A236LegCodPos), GXutil.rtrim( localUtil.format( A236LegCodPos, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCodPos_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCodPos_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoPostal", "left", true, "", "HLP_LegajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_22_5S2e( true) ;
      }
      else
      {
         wb_table1_22_5S2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
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
      pa5S2( ) ;
      ws5S2( ) ;
      we5S2( ) ;
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
      sCtrlA3CliCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlA1EmpCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlA6LegNumero = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa5S2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "legajogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa5S2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1EmpCod != wcpOA1EmpCod ) || ( A6LegNumero != wcpOA6LegNumero ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1EmpCod = A1EmpCod ;
      wcpOA6LegNumero = A6LegNumero ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA3CliCod = httpContext.cgiGet( sPrefix+"A3CliCod_CTRL") ;
      if ( GXutil.len( sCtrlA3CliCod) > 0 )
      {
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlA3CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A3CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA1EmpCod = httpContext.cgiGet( sPrefix+"A1EmpCod_CTRL") ;
      if ( GXutil.len( sCtrlA1EmpCod) > 0 )
      {
         A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA1EmpCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      else
      {
         A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1EmpCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA6LegNumero = httpContext.cgiGet( sPrefix+"A6LegNumero_CTRL") ;
      if ( GXutil.len( sCtrlA6LegNumero) > 0 )
      {
         A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlA6LegNumero), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      else
      {
         A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A6LegNumero_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      pa5S2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws5S2( ) ;
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
      ws5S2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A3CliCod_PARM", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA3CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A3CliCod_CTRL", GXutil.rtrim( sCtrlA3CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1EmpCod_PARM", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1EmpCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1EmpCod_CTRL", GXutil.rtrim( sCtrlA1EmpCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A6LegNumero_PARM", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA6LegNumero)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A6LegNumero_CTRL", GXutil.rtrim( sCtrlA6LegNumero));
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
      we5S2( ) ;
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
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020171925", true, true);
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
      httpContext.AddJavascriptSource("legajogeneral.js", "?2024122020171925", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/img_ucRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      bttBtnupdateup_Internalname = sPrefix+"BTNUPDATEUP" ;
      bttBtneliminarup_Internalname = sPrefix+"BTNELIMINARUP" ;
      Img_uc1_Internalname = sPrefix+"IMG_UC1" ;
      cmbLegSexo.setInternalname( sPrefix+"LEGSEXO" );
      edtLegNombre_Internalname = sPrefix+"LEGNOMBRE" ;
      edtLegApellido_Internalname = sPrefix+"LEGAPELLIDO" ;
      edtLegFecNac_Internalname = sPrefix+"LEGFECNAC" ;
      edtLegId_Internalname = sPrefix+"LEGID" ;
      edtLegCUIL_Internalname = sPrefix+"LEGCUIL" ;
      edtLegFecIngreso_Internalname = sPrefix+"LEGFECINGRESO" ;
      edtLegFecEgreso_Internalname = sPrefix+"LEGFECEGRESO" ;
      cmbLegEstadoCivil.setInternalname( sPrefix+"LEGESTADOCIVIL" );
      cmbLegDiscapacidad.setInternalname( sPrefix+"LEGDISCAPACIDAD" );
      edtLegTelefono_Internalname = sPrefix+"LEGTELEFONO" ;
      edtLegEmail_Internalname = sPrefix+"LEGEMAIL" ;
      edtLegDomici_Internalname = sPrefix+"LEGDOMICI" ;
      edtLegCodPos_Internalname = sPrefix+"LEGCODPOS" ;
      divTransactiondetail_paneliden_Internalname = sPrefix+"TRANSACTIONDETAIL_PANELIDEN" ;
      Dvpanel_transactiondetail_paneliden_Internalname = sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELIDEN" ;
      tblTransactiondetail_tableprindom_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEPRINDOM" ;
      cmbLegClase.setInternalname( sPrefix+"LEGCLASE" );
      edtOsoSiglaYDesc_Internalname = sPrefix+"OSOSIGLAYDESC" ;
      edtSecDescrip_Internalname = sPrefix+"SECDESCRIP" ;
      edtSinDescrip_Internalname = sPrefix+"SINDESCRIP" ;
      edtLegBasico_Internalname = sPrefix+"LEGBASICO" ;
      divLegbasico_cell_Internalname = sPrefix+"LEGBASICO_CELL" ;
      edtLegSueldoFuera_Internalname = sPrefix+"LEGSUELDOFUERA" ;
      divLegsueldofuera_cell_Internalname = sPrefix+"LEGSUELDOFUERA_CELL" ;
      edtMegDescrip_Internalname = sPrefix+"MEGDESCRIP" ;
      divMegdescrip_cell_Internalname = sPrefix+"MEGDESCRIP_CELL" ;
      divTransactiondetail_panellab_Internalname = sPrefix+"TRANSACTIONDETAIL_PANELLAB" ;
      Dvpanel_transactiondetail_panellab_Internalname = sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELLAB" ;
      edtTipEmpleCod_Internalname = sPrefix+"TIPEMPLECOD" ;
      edtCondiDescri_Internalname = sPrefix+"CONDIDESCRI" ;
      edtLegActDescri_Internalname = sPrefix+"LEGACTDESCRI" ;
      edtMprDescrip_Internalname = sPrefix+"MPRDESCRIP" ;
      edtSinieDescri_Internalname = sPrefix+"SINIEDESCRI" ;
      edtZonDescrip_Internalname = sPrefix+"ZONDESCRIP" ;
      edtOsoC3992_Internalname = sPrefix+"OSOC3992" ;
      chkLegSCVO.setInternalname( sPrefix+"LEGSCVO" );
      divTransactiondetail_panelotr_Internalname = sPrefix+"TRANSACTIONDETAIL_PANELOTR" ;
      Dvpanel_transactiondetail_panelotr_Internalname = sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELOTR" ;
      edtLpgDescri_Internalname = sPrefix+"LPGDESCRI" ;
      cmbLegFormaPago.setInternalname( sPrefix+"LEGFORMAPAGO" );
      edtLegBanSuc_Internalname = sPrefix+"LEGBANSUC" ;
      cmbLegBanTipCuen.setInternalname( sPrefix+"LEGBANTIPCUEN" );
      edtLegCuentaBanc_Internalname = sPrefix+"LEGCUENTABANC" ;
      edtLegCBU_Internalname = sPrefix+"LEGCBU" ;
      divTransactiondetail_panelban_Internalname = sPrefix+"TRANSACTIONDETAIL_PANELBAN" ;
      Dvpanel_transactiondetail_panelban_Internalname = sPrefix+"DVPANEL_TRANSACTIONDETAIL_PANELBAN" ;
      edtLegObs_Internalname = sPrefix+"LEGOBS" ;
      divUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE1" ;
      divTransactiondetail_tablecontent_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLECONTENT" ;
      divTransactiondetail_tablemain_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEMAIN" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
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
      edtLegCodPos_Jsonclick = "" ;
      edtLegCodPos_Enabled = 0 ;
      edtLegDomici_Enabled = 0 ;
      edtLegEmail_Jsonclick = "" ;
      edtLegEmail_Enabled = 0 ;
      edtLegTelefono_Jsonclick = "" ;
      edtLegTelefono_Enabled = 0 ;
      cmbLegDiscapacidad.setJsonclick( "" );
      cmbLegDiscapacidad.setEnabled( 0 );
      cmbLegEstadoCivil.setJsonclick( "" );
      cmbLegEstadoCivil.setEnabled( 0 );
      edtLegFecEgreso_Jsonclick = "" ;
      edtLegFecEgreso_Enabled = 0 ;
      edtLegFecIngreso_Jsonclick = "" ;
      edtLegFecIngreso_Enabled = 0 ;
      edtLegCUIL_Jsonclick = "" ;
      edtLegCUIL_Enabled = 0 ;
      edtLegId_Jsonclick = "" ;
      edtLegId_Enabled = 0 ;
      edtLegFecNac_Jsonclick = "" ;
      edtLegFecNac_Enabled = 0 ;
      edtLegApellido_Jsonclick = "" ;
      edtLegApellido_Enabled = 0 ;
      edtLegNombre_Jsonclick = "" ;
      edtLegNombre_Enabled = 0 ;
      cmbLegSexo.setJsonclick( "" );
      cmbLegSexo.setEnabled( 0 );
      edtLegNumero_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      edtLegObs_Enabled = 0 ;
      edtLegCBU_Jsonclick = "" ;
      edtLegCBU_Enabled = 0 ;
      edtLegCuentaBanc_Jsonclick = "" ;
      edtLegCuentaBanc_Enabled = 0 ;
      cmbLegBanTipCuen.setJsonclick( "" );
      cmbLegBanTipCuen.setEnabled( 0 );
      edtLegBanSuc_Jsonclick = "" ;
      edtLegBanSuc_Enabled = 0 ;
      cmbLegFormaPago.setJsonclick( "" );
      cmbLegFormaPago.setEnabled( 0 );
      edtLpgDescri_Jsonclick = "" ;
      edtLpgDescri_Enabled = 0 ;
      chkLegSCVO.setEnabled( 0 );
      edtOsoC3992_Jsonclick = "" ;
      edtOsoC3992_Enabled = 0 ;
      edtZonDescrip_Enabled = 0 ;
      edtSinieDescri_Enabled = 0 ;
      edtMprDescrip_Enabled = 0 ;
      edtLegActDescri_Jsonclick = "" ;
      edtLegActDescri_Enabled = 0 ;
      edtCondiDescri_Jsonclick = "" ;
      edtCondiDescri_Enabled = 0 ;
      edtTipEmpleCod_Jsonclick = "" ;
      edtTipEmpleCod_Enabled = 0 ;
      edtMegDescrip_Enabled = 0 ;
      edtLegSueldoFuera_Jsonclick = "" ;
      edtLegSueldoFuera_Enabled = 0 ;
      edtLegBasico_Jsonclick = "" ;
      edtLegBasico_Enabled = 0 ;
      edtSinDescrip_Enabled = 0 ;
      edtSecDescrip_Enabled = 0 ;
      edtOsoSiglaYDesc_Enabled = 0 ;
      cmbLegClase.setJsonclick( "" );
      cmbLegClase.setEnabled( 0 );
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = httpContext.getMessage( "Observaciones", "") ;
      Dvpanel_unnamedtable1_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      Dvpanel_transactiondetail_panelban_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panelban_Iconposition = "Right" ;
      Dvpanel_transactiondetail_panelban_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panelban_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panelban_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_transactiondetail_panelban_Title = httpContext.getMessage( "Datos bancarios", "") ;
      Dvpanel_transactiondetail_panelban_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_transactiondetail_panelban_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_transactiondetail_panelban_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panelban_Width = "100%" ;
      Dvpanel_transactiondetail_panelotr_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panelotr_Iconposition = "Right" ;
      Dvpanel_transactiondetail_panelotr_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panelotr_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panelotr_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_transactiondetail_panelotr_Title = httpContext.getMessage( "Datos AFIP ", "") ;
      Dvpanel_transactiondetail_panelotr_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_transactiondetail_panelotr_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_transactiondetail_panelotr_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panelotr_Width = "100%" ;
      Dvpanel_transactiondetail_panellab_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panellab_Iconposition = "Right" ;
      Dvpanel_transactiondetail_panellab_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panellab_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panellab_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_transactiondetail_panellab_Title = httpContext.getMessage( "Datos Laborales", "") ;
      Dvpanel_transactiondetail_panellab_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_transactiondetail_panellab_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_transactiondetail_panellab_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_panellab_Width = "100%" ;
      Dvpanel_transactiondetail_paneliden_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_paneliden_Iconposition = "Right" ;
      Dvpanel_transactiondetail_paneliden_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_paneliden_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_paneliden_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_transactiondetail_paneliden_Title = httpContext.getMessage( "Datos Personales", "") ;
      Dvpanel_transactiondetail_paneliden_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_transactiondetail_paneliden_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_transactiondetail_paneliden_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_paneliden_Width = "100%" ;
      Img_uc1_Class_img = "ReadonlyW100px" ;
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
      cmbLegSexo.setName( "LEGSEXO" );
      cmbLegSexo.setWebtags( "" );
      if ( cmbLegSexo.getItemCount() > 0 )
      {
      }
      cmbLegEstadoCivil.setName( "LEGESTADOCIVIL" );
      cmbLegEstadoCivil.setWebtags( "" );
      if ( cmbLegEstadoCivil.getItemCount() > 0 )
      {
      }
      cmbLegDiscapacidad.setName( "LEGDISCAPACIDAD" );
      cmbLegDiscapacidad.setWebtags( "" );
      cmbLegDiscapacidad.addItem("0", httpContext.getMessage( "NO", ""), (short)(0));
      cmbLegDiscapacidad.addItem("1", httpContext.getMessage( "SI", ""), (short)(0));
      if ( cmbLegDiscapacidad.getItemCount() > 0 )
      {
      }
      cmbLegClase.setName( "LEGCLASE" );
      cmbLegClase.setWebtags( "" );
      cmbLegClase.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbLegClase.addItem("2", httpContext.getMessage( "Jornal", ""), (short)(0));
      if ( cmbLegClase.getItemCount() > 0 )
      {
      }
      chkLegSCVO.setName( "LEGSCVO" );
      chkLegSCVO.setWebtags( "" );
      chkLegSCVO.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkLegSCVO.getInternalname(), "TitleCaption", chkLegSCVO.getCaption(), true);
      chkLegSCVO.setCheckedValue( "false" );
      cmbLegFormaPago.setName( "LEGFORMAPAGO" );
      cmbLegFormaPago.setWebtags( "" );
      cmbLegFormaPago.addItem("1", httpContext.getMessage( "Efectivo", ""), (short)(0));
      cmbLegFormaPago.addItem("2", httpContext.getMessage( "Cheque", ""), (short)(0));
      cmbLegFormaPago.addItem("3", httpContext.getMessage( "Transferencia", ""), (short)(0));
      if ( cmbLegFormaPago.getItemCount() > 0 )
      {
      }
      cmbLegBanTipCuen.setName( "LEGBANTIPCUEN" );
      cmbLegBanTipCuen.setWebtags( "" );
      cmbLegBanTipCuen.addItem("CA", httpContext.getMessage( "Caja de Ahorro", ""), (short)(0));
      cmbLegBanTipCuen.addItem("CC", httpContext.getMessage( "Cuenta Corriente", ""), (short)(0));
      if ( cmbLegBanTipCuen.getItemCount() > 0 )
      {
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A262LegSCVO',fld:'LEGSCVO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VALID_LEGCLASE","{handler:'valid_Legclase',iparms:[]");
      setEventMetadata("VALID_LEGCLASE",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
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
      sPrefix = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      A937LegConveCodigo = "" ;
      GX_FocusControl = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnupdateup_Jsonclick = "" ;
      bttBtneliminarup_Jsonclick = "" ;
      ucDvpanel_transactiondetail_panellab = new com.genexus.webpanels.GXUserControl();
      A555OsoSiglaYDesc = "" ;
      A329SecDescrip = "" ;
      A331SinDescrip = "" ;
      A233LegBasico = DecimalUtil.ZERO ;
      A264LegSueldoFuera = DecimalUtil.ZERO ;
      A300MegDescrip = "" ;
      ucDvpanel_transactiondetail_panelotr = new com.genexus.webpanels.GXUserControl();
      A45TipEmpleCod = "" ;
      A144CondiDescri = "" ;
      A227LegActDescri = "" ;
      A303MprDescrip = "" ;
      A333SinieDescri = "" ;
      A342ZonDescrip = "" ;
      A306OsoC3992 = "" ;
      ucDvpanel_transactiondetail_panelban = new com.genexus.webpanels.GXUserControl();
      A291LpgDescri = "" ;
      A231LegBanSuc = "" ;
      A232LegBanTipCuen = "" ;
      A238LegCuentaBanc = "" ;
      A234LegCBU = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      A515LegObs = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      H005S2_A1581LegLpgCodigo = new String[] {""} ;
      H005S2_n1581LegLpgCodigo = new boolean[] {false} ;
      H005S2_A1583LegMegCodigo = new String[] {""} ;
      H005S2_n1583LegMegCodigo = new boolean[] {false} ;
      H005S2_A1580LegOsoCod = new String[] {""} ;
      H005S2_n1580LegOsoCod = new boolean[] {false} ;
      H005S2_A1579LegSecCodigo = new String[] {""} ;
      H005S2_n1579LegSecCodigo = new boolean[] {false} ;
      H005S2_A18MprCod = new String[] {""} ;
      H005S2_n18MprCod = new boolean[] {false} ;
      H005S2_A20ZonCod = new String[] {""} ;
      H005S2_n20ZonCod = new boolean[] {false} ;
      H005S2_A17CondiCodigo = new short[1] ;
      H005S2_n17CondiCodigo = new boolean[] {false} ;
      H005S2_A1965EmpOsoCod = new String[] {""} ;
      H005S2_n1965EmpOsoCod = new boolean[] {false} ;
      H005S2_A19SinieCodigo = new String[] {""} ;
      H005S2_n19SinieCodigo = new boolean[] {false} ;
      H005S2_A910LegSinCod = new String[] {""} ;
      H005S2_n910LegSinCod = new boolean[] {false} ;
      H005S2_A15LegActCodigo = new String[] {""} ;
      H005S2_n15LegActCodigo = new boolean[] {false} ;
      H005S2_A3CliCod = new int[1] ;
      H005S2_A1EmpCod = new short[1] ;
      H005S2_A6LegNumero = new int[1] ;
      H005S2_A515LegObs = new String[] {""} ;
      H005S2_A234LegCBU = new String[] {""} ;
      H005S2_n234LegCBU = new boolean[] {false} ;
      H005S2_A238LegCuentaBanc = new String[] {""} ;
      H005S2_n238LegCuentaBanc = new boolean[] {false} ;
      H005S2_A232LegBanTipCuen = new String[] {""} ;
      H005S2_n232LegBanTipCuen = new boolean[] {false} ;
      H005S2_A231LegBanSuc = new String[] {""} ;
      H005S2_n231LegBanSuc = new boolean[] {false} ;
      H005S2_A248LegFormaPago = new byte[1] ;
      H005S2_A291LpgDescri = new String[] {""} ;
      H005S2_n291LpgDescri = new boolean[] {false} ;
      H005S2_A262LegSCVO = new boolean[] {false} ;
      H005S2_A306OsoC3992 = new String[] {""} ;
      H005S2_n306OsoC3992 = new boolean[] {false} ;
      H005S2_A342ZonDescrip = new String[] {""} ;
      H005S2_A333SinieDescri = new String[] {""} ;
      H005S2_A303MprDescrip = new String[] {""} ;
      H005S2_A227LegActDescri = new String[] {""} ;
      H005S2_A144CondiDescri = new String[] {""} ;
      H005S2_A45TipEmpleCod = new String[] {""} ;
      H005S2_n45TipEmpleCod = new boolean[] {false} ;
      H005S2_A300MegDescrip = new String[] {""} ;
      H005S2_n300MegDescrip = new boolean[] {false} ;
      H005S2_A264LegSueldoFuera = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H005S2_A331SinDescrip = new String[] {""} ;
      H005S2_n331SinDescrip = new boolean[] {false} ;
      H005S2_A329SecDescrip = new String[] {""} ;
      H005S2_n329SecDescrip = new boolean[] {false} ;
      H005S2_A555OsoSiglaYDesc = new String[] {""} ;
      H005S2_n555OsoSiglaYDesc = new boolean[] {false} ;
      H005S2_A236LegCodPos = new String[] {""} ;
      H005S2_A242LegDomici = new String[] {""} ;
      H005S2_A479LegEmail = new String[] {""} ;
      H005S2_A265LegTelefono = new String[] {""} ;
      H005S2_n265LegTelefono = new boolean[] {false} ;
      H005S2_A241LegDiscapacidad = new byte[1] ;
      H005S2_A243LegEstadoCivil = new short[1] ;
      H005S2_n243LegEstadoCivil = new boolean[] {false} ;
      H005S2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      H005S2_n244LegFecEgreso = new boolean[] {false} ;
      H005S2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      H005S2_A239LegCUIL = new long[1] ;
      H005S2_A93LegId = new String[] {""} ;
      H005S2_n93LegId = new boolean[] {false} ;
      H005S2_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      H005S2_A230LegApellido = new String[] {""} ;
      H005S2_A251LegNombre = new String[] {""} ;
      H005S2_A263LegSexo = new byte[1] ;
      H005S2_n263LegSexo = new boolean[] {false} ;
      H005S2_A235LegClase = new byte[1] ;
      H005S2_A937LegConveCodigo = new String[] {""} ;
      H005S2_n937LegConveCodigo = new boolean[] {false} ;
      H005S2_A22LegPaiCod = new short[1] ;
      H005S2_n22LegPaiCod = new boolean[] {false} ;
      H005S2_A1576LegConveVersionCli = new int[1] ;
      H005S2_n1576LegConveVersionCli = new boolean[] {false} ;
      A1581LegLpgCodigo = "" ;
      A1583LegMegCodigo = "" ;
      A1580LegOsoCod = "" ;
      A1579LegSecCodigo = "" ;
      A18MprCod = "" ;
      A20ZonCod = "" ;
      A19SinieCodigo = "" ;
      A910LegSinCod = "" ;
      A15LegActCodigo = "" ;
      A236LegCodPos = "" ;
      A242LegDomici = "" ;
      A479LegEmail = "" ;
      A265LegTelefono = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A93LegId = "" ;
      A246LegFecNac = GXutil.nullDate() ;
      A230LegApellido = "" ;
      A251LegNombre = "" ;
      H005S3_A1965EmpOsoCod = new String[] {""} ;
      H005S3_n1965EmpOsoCod = new boolean[] {false} ;
      H005S3_A45TipEmpleCod = new String[] {""} ;
      H005S3_n45TipEmpleCod = new boolean[] {false} ;
      A1965EmpOsoCod = "" ;
      H005S4_A306OsoC3992 = new String[] {""} ;
      H005S4_n306OsoC3992 = new boolean[] {false} ;
      sStyleString = "" ;
      ucDvpanel_transactiondetail_paneliden = new com.genexus.webpanels.GXUserControl();
      ucImg_uc1 = new com.genexus.webpanels.GXUserControl();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1EmpCod = "" ;
      sCtrlA6LegNumero = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajogeneral__default(),
         new Object[] {
             new Object[] {
            H005S2_A1581LegLpgCodigo, H005S2_n1581LegLpgCodigo, H005S2_A1583LegMegCodigo, H005S2_n1583LegMegCodigo, H005S2_A1580LegOsoCod, H005S2_n1580LegOsoCod, H005S2_A1579LegSecCodigo, H005S2_n1579LegSecCodigo, H005S2_A18MprCod, H005S2_n18MprCod,
            H005S2_A20ZonCod, H005S2_n20ZonCod, H005S2_A17CondiCodigo, H005S2_n17CondiCodigo, H005S2_A1965EmpOsoCod, H005S2_n1965EmpOsoCod, H005S2_A19SinieCodigo, H005S2_n19SinieCodigo, H005S2_A910LegSinCod, H005S2_n910LegSinCod,
            H005S2_A15LegActCodigo, H005S2_n15LegActCodigo, H005S2_A3CliCod, H005S2_A1EmpCod, H005S2_A6LegNumero, H005S2_A515LegObs, H005S2_A234LegCBU, H005S2_n234LegCBU, H005S2_A238LegCuentaBanc, H005S2_n238LegCuentaBanc,
            H005S2_A232LegBanTipCuen, H005S2_n232LegBanTipCuen, H005S2_A231LegBanSuc, H005S2_n231LegBanSuc, H005S2_A248LegFormaPago, H005S2_A291LpgDescri, H005S2_n291LpgDescri, H005S2_A262LegSCVO, H005S2_A306OsoC3992, H005S2_n306OsoC3992,
            H005S2_A342ZonDescrip, H005S2_A333SinieDescri, H005S2_A303MprDescrip, H005S2_A227LegActDescri, H005S2_A144CondiDescri, H005S2_A45TipEmpleCod, H005S2_n45TipEmpleCod, H005S2_A300MegDescrip, H005S2_n300MegDescrip, H005S2_A264LegSueldoFuera,
            H005S2_A331SinDescrip, H005S2_n331SinDescrip, H005S2_A329SecDescrip, H005S2_n329SecDescrip, H005S2_A555OsoSiglaYDesc, H005S2_n555OsoSiglaYDesc, H005S2_A236LegCodPos, H005S2_A242LegDomici, H005S2_A479LegEmail, H005S2_A265LegTelefono,
            H005S2_n265LegTelefono, H005S2_A241LegDiscapacidad, H005S2_A243LegEstadoCivil, H005S2_n243LegEstadoCivil, H005S2_A244LegFecEgreso, H005S2_n244LegFecEgreso, H005S2_A245LegFecIngreso, H005S2_A239LegCUIL, H005S2_A93LegId, H005S2_n93LegId,
            H005S2_A246LegFecNac, H005S2_A230LegApellido, H005S2_A251LegNombre, H005S2_A263LegSexo, H005S2_n263LegSexo, H005S2_A235LegClase, H005S2_A937LegConveCodigo, H005S2_n937LegConveCodigo, H005S2_A22LegPaiCod, H005S2_n22LegPaiCod,
            H005S2_A1576LegConveVersionCli, H005S2_n1576LegConveVersionCli
            }
            , new Object[] {
            H005S3_A1965EmpOsoCod, H005S3_n1965EmpOsoCod, H005S3_A45TipEmpleCod, H005S3_n45TipEmpleCod
            }
            , new Object[] {
            H005S4_A306OsoC3992, H005S4_n306OsoC3992
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A235LegClase ;
   private byte A248LegFormaPago ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte A263LegSexo ;
   private byte A241LegDiscapacidad ;
   private byte nGXWrapped ;
   private short wcpOA1EmpCod ;
   private short A1EmpCod ;
   private short A22LegPaiCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short A243LegEstadoCivil ;
   private short Gx_err ;
   private short A17CondiCodigo ;
   private int wcpOA3CliCod ;
   private int wcpOA6LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A1576LegConveVersionCli ;
   private int edtOsoSiglaYDesc_Enabled ;
   private int edtSecDescrip_Enabled ;
   private int edtSinDescrip_Enabled ;
   private int edtLegBasico_Enabled ;
   private int edtLegSueldoFuera_Enabled ;
   private int edtMegDescrip_Enabled ;
   private int edtTipEmpleCod_Enabled ;
   private int edtCondiDescri_Enabled ;
   private int edtLegActDescri_Enabled ;
   private int edtMprDescrip_Enabled ;
   private int edtSinieDescri_Enabled ;
   private int edtZonDescrip_Enabled ;
   private int edtOsoC3992_Enabled ;
   private int edtLpgDescri_Enabled ;
   private int edtLegBanSuc_Enabled ;
   private int edtLegCuentaBanc_Enabled ;
   private int edtLegCBU_Enabled ;
   private int edtLegObs_Enabled ;
   private int edtLegNombre_Enabled ;
   private int edtLegApellido_Enabled ;
   private int edtLegFecNac_Enabled ;
   private int edtLegId_Enabled ;
   private int edtLegCUIL_Enabled ;
   private int edtLegFecIngreso_Enabled ;
   private int edtLegFecEgreso_Enabled ;
   private int edtLegTelefono_Enabled ;
   private int edtLegEmail_Enabled ;
   private int edtLegDomici_Enabled ;
   private int edtLegCodPos_Enabled ;
   private int idxLst ;
   private long A239LegCUIL ;
   private java.math.BigDecimal A233LegBasico ;
   private java.math.BigDecimal A264LegSueldoFuera ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String A937LegConveCodigo ;
   private String Img_uc1_Class_img ;
   private String Dvpanel_transactiondetail_paneliden_Width ;
   private String Dvpanel_transactiondetail_paneliden_Cls ;
   private String Dvpanel_transactiondetail_paneliden_Title ;
   private String Dvpanel_transactiondetail_paneliden_Iconposition ;
   private String Dvpanel_transactiondetail_panellab_Width ;
   private String Dvpanel_transactiondetail_panellab_Cls ;
   private String Dvpanel_transactiondetail_panellab_Title ;
   private String Dvpanel_transactiondetail_panellab_Iconposition ;
   private String Dvpanel_transactiondetail_panelotr_Width ;
   private String Dvpanel_transactiondetail_panelotr_Cls ;
   private String Dvpanel_transactiondetail_panelotr_Title ;
   private String Dvpanel_transactiondetail_panelotr_Iconposition ;
   private String Dvpanel_transactiondetail_panelban_Width ;
   private String Dvpanel_transactiondetail_panelban_Cls ;
   private String Dvpanel_transactiondetail_panelban_Title ;
   private String Dvpanel_transactiondetail_panelban_Iconposition ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnupdateup_Internalname ;
   private String bttBtnupdateup_Jsonclick ;
   private String bttBtneliminarup_Internalname ;
   private String bttBtneliminarup_Jsonclick ;
   private String divTransactiondetail_tablemain_Internalname ;
   private String divTransactiondetail_tablecontent_Internalname ;
   private String Dvpanel_transactiondetail_panellab_Internalname ;
   private String divTransactiondetail_panellab_Internalname ;
   private String edtOsoSiglaYDesc_Internalname ;
   private String edtSecDescrip_Internalname ;
   private String edtSinDescrip_Internalname ;
   private String divLegbasico_cell_Internalname ;
   private String edtLegBasico_Internalname ;
   private String edtLegBasico_Jsonclick ;
   private String divLegsueldofuera_cell_Internalname ;
   private String edtLegSueldoFuera_Internalname ;
   private String edtLegSueldoFuera_Jsonclick ;
   private String divMegdescrip_cell_Internalname ;
   private String edtMegDescrip_Internalname ;
   private String Dvpanel_transactiondetail_panelotr_Internalname ;
   private String divTransactiondetail_panelotr_Internalname ;
   private String edtTipEmpleCod_Internalname ;
   private String A45TipEmpleCod ;
   private String edtTipEmpleCod_Jsonclick ;
   private String edtCondiDescri_Internalname ;
   private String edtCondiDescri_Jsonclick ;
   private String edtLegActDescri_Internalname ;
   private String edtLegActDescri_Jsonclick ;
   private String edtMprDescrip_Internalname ;
   private String edtSinieDescri_Internalname ;
   private String edtZonDescrip_Internalname ;
   private String edtOsoC3992_Internalname ;
   private String A306OsoC3992 ;
   private String edtOsoC3992_Jsonclick ;
   private String Dvpanel_transactiondetail_panelban_Internalname ;
   private String divTransactiondetail_panelban_Internalname ;
   private String edtLpgDescri_Internalname ;
   private String edtLpgDescri_Jsonclick ;
   private String edtLegBanSuc_Internalname ;
   private String edtLegBanSuc_Jsonclick ;
   private String A232LegBanTipCuen ;
   private String edtLegCuentaBanc_Internalname ;
   private String edtLegCuentaBanc_Jsonclick ;
   private String edtLegCBU_Internalname ;
   private String edtLegCBU_Jsonclick ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String edtLegObs_Internalname ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private String A1581LegLpgCodigo ;
   private String A1583LegMegCodigo ;
   private String A1580LegOsoCod ;
   private String A1579LegSecCodigo ;
   private String A18MprCod ;
   private String A20ZonCod ;
   private String A19SinieCodigo ;
   private String A910LegSinCod ;
   private String A15LegActCodigo ;
   private String A236LegCodPos ;
   private String A93LegId ;
   private String A1965EmpOsoCod ;
   private String edtLegNombre_Internalname ;
   private String edtLegApellido_Internalname ;
   private String edtLegFecNac_Internalname ;
   private String edtLegId_Internalname ;
   private String edtLegCUIL_Internalname ;
   private String edtLegFecIngreso_Internalname ;
   private String edtLegFecEgreso_Internalname ;
   private String edtLegTelefono_Internalname ;
   private String edtLegEmail_Internalname ;
   private String edtLegDomici_Internalname ;
   private String edtLegCodPos_Internalname ;
   private String sStyleString ;
   private String tblTransactiondetail_tableprindom_Internalname ;
   private String Dvpanel_transactiondetail_paneliden_Internalname ;
   private String divTransactiondetail_paneliden_Internalname ;
   private String Img_uc1_Internalname ;
   private String edtLegNombre_Jsonclick ;
   private String edtLegApellido_Jsonclick ;
   private String edtLegFecNac_Jsonclick ;
   private String edtLegId_Jsonclick ;
   private String edtLegCUIL_Jsonclick ;
   private String edtLegFecIngreso_Jsonclick ;
   private String edtLegFecEgreso_Jsonclick ;
   private String edtLegTelefono_Jsonclick ;
   private String edtLegEmail_Jsonclick ;
   private String edtLegCodPos_Jsonclick ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1EmpCod ;
   private String sCtrlA6LegNumero ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A246LegFecNac ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_transactiondetail_paneliden_Autowidth ;
   private boolean Dvpanel_transactiondetail_paneliden_Autoheight ;
   private boolean Dvpanel_transactiondetail_paneliden_Collapsible ;
   private boolean Dvpanel_transactiondetail_paneliden_Collapsed ;
   private boolean Dvpanel_transactiondetail_paneliden_Showcollapseicon ;
   private boolean Dvpanel_transactiondetail_paneliden_Autoscroll ;
   private boolean Dvpanel_transactiondetail_panellab_Autowidth ;
   private boolean Dvpanel_transactiondetail_panellab_Autoheight ;
   private boolean Dvpanel_transactiondetail_panellab_Collapsible ;
   private boolean Dvpanel_transactiondetail_panellab_Collapsed ;
   private boolean Dvpanel_transactiondetail_panellab_Showcollapseicon ;
   private boolean Dvpanel_transactiondetail_panellab_Autoscroll ;
   private boolean Dvpanel_transactiondetail_panelotr_Autowidth ;
   private boolean Dvpanel_transactiondetail_panelotr_Autoheight ;
   private boolean Dvpanel_transactiondetail_panelotr_Collapsible ;
   private boolean Dvpanel_transactiondetail_panelotr_Collapsed ;
   private boolean Dvpanel_transactiondetail_panelotr_Showcollapseicon ;
   private boolean Dvpanel_transactiondetail_panelotr_Autoscroll ;
   private boolean Dvpanel_transactiondetail_panelban_Autowidth ;
   private boolean Dvpanel_transactiondetail_panelban_Autoheight ;
   private boolean Dvpanel_transactiondetail_panelban_Collapsible ;
   private boolean Dvpanel_transactiondetail_panelban_Collapsed ;
   private boolean Dvpanel_transactiondetail_panelban_Showcollapseicon ;
   private boolean Dvpanel_transactiondetail_panelban_Autoscroll ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean wbLoad ;
   private boolean A262LegSCVO ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n263LegSexo ;
   private boolean n243LegEstadoCivil ;
   private boolean n232LegBanTipCuen ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1581LegLpgCodigo ;
   private boolean n1583LegMegCodigo ;
   private boolean n1580LegOsoCod ;
   private boolean n1579LegSecCodigo ;
   private boolean n18MprCod ;
   private boolean n20ZonCod ;
   private boolean n17CondiCodigo ;
   private boolean n19SinieCodigo ;
   private boolean n910LegSinCod ;
   private boolean n15LegActCodigo ;
   private boolean n234LegCBU ;
   private boolean n238LegCuentaBanc ;
   private boolean n231LegBanSuc ;
   private boolean n291LpgDescri ;
   private boolean n300MegDescrip ;
   private boolean n331SinDescrip ;
   private boolean n329SecDescrip ;
   private boolean n555OsoSiglaYDesc ;
   private boolean n265LegTelefono ;
   private boolean n244LegFecEgreso ;
   private boolean n93LegId ;
   private boolean n937LegConveCodigo ;
   private boolean n22LegPaiCod ;
   private boolean n1576LegConveVersionCli ;
   private boolean n1965EmpOsoCod ;
   private boolean n45TipEmpleCod ;
   private boolean n306OsoC3992 ;
   private boolean returnInSub ;
   private String A515LegObs ;
   private String A555OsoSiglaYDesc ;
   private String A329SecDescrip ;
   private String A331SinDescrip ;
   private String A300MegDescrip ;
   private String A144CondiDescri ;
   private String A227LegActDescri ;
   private String A303MprDescrip ;
   private String A333SinieDescri ;
   private String A342ZonDescrip ;
   private String A291LpgDescri ;
   private String A231LegBanSuc ;
   private String A238LegCuentaBanc ;
   private String A234LegCBU ;
   private String A242LegDomici ;
   private String A479LegEmail ;
   private String A265LegTelefono ;
   private String A230LegApellido ;
   private String A251LegNombre ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_transactiondetail_panellab ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_transactiondetail_panelotr ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_transactiondetail_panelban ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_transactiondetail_paneliden ;
   private com.genexus.webpanels.GXUserControl ucImg_uc1 ;
   private HTMLChoice cmbLegSexo ;
   private HTMLChoice cmbLegEstadoCivil ;
   private HTMLChoice cmbLegDiscapacidad ;
   private HTMLChoice cmbLegClase ;
   private ICheckbox chkLegSCVO ;
   private HTMLChoice cmbLegFormaPago ;
   private HTMLChoice cmbLegBanTipCuen ;
   private IDataStoreProvider pr_default ;
   private String[] H005S2_A1581LegLpgCodigo ;
   private boolean[] H005S2_n1581LegLpgCodigo ;
   private String[] H005S2_A1583LegMegCodigo ;
   private boolean[] H005S2_n1583LegMegCodigo ;
   private String[] H005S2_A1580LegOsoCod ;
   private boolean[] H005S2_n1580LegOsoCod ;
   private String[] H005S2_A1579LegSecCodigo ;
   private boolean[] H005S2_n1579LegSecCodigo ;
   private String[] H005S2_A18MprCod ;
   private boolean[] H005S2_n18MprCod ;
   private String[] H005S2_A20ZonCod ;
   private boolean[] H005S2_n20ZonCod ;
   private short[] H005S2_A17CondiCodigo ;
   private boolean[] H005S2_n17CondiCodigo ;
   private String[] H005S2_A1965EmpOsoCod ;
   private boolean[] H005S2_n1965EmpOsoCod ;
   private String[] H005S2_A19SinieCodigo ;
   private boolean[] H005S2_n19SinieCodigo ;
   private String[] H005S2_A910LegSinCod ;
   private boolean[] H005S2_n910LegSinCod ;
   private String[] H005S2_A15LegActCodigo ;
   private boolean[] H005S2_n15LegActCodigo ;
   private int[] H005S2_A3CliCod ;
   private short[] H005S2_A1EmpCod ;
   private int[] H005S2_A6LegNumero ;
   private String[] H005S2_A515LegObs ;
   private String[] H005S2_A234LegCBU ;
   private boolean[] H005S2_n234LegCBU ;
   private String[] H005S2_A238LegCuentaBanc ;
   private boolean[] H005S2_n238LegCuentaBanc ;
   private String[] H005S2_A232LegBanTipCuen ;
   private boolean[] H005S2_n232LegBanTipCuen ;
   private String[] H005S2_A231LegBanSuc ;
   private boolean[] H005S2_n231LegBanSuc ;
   private byte[] H005S2_A248LegFormaPago ;
   private String[] H005S2_A291LpgDescri ;
   private boolean[] H005S2_n291LpgDescri ;
   private boolean[] H005S2_A262LegSCVO ;
   private String[] H005S2_A306OsoC3992 ;
   private boolean[] H005S2_n306OsoC3992 ;
   private String[] H005S2_A342ZonDescrip ;
   private String[] H005S2_A333SinieDescri ;
   private String[] H005S2_A303MprDescrip ;
   private String[] H005S2_A227LegActDescri ;
   private String[] H005S2_A144CondiDescri ;
   private String[] H005S2_A45TipEmpleCod ;
   private boolean[] H005S2_n45TipEmpleCod ;
   private String[] H005S2_A300MegDescrip ;
   private boolean[] H005S2_n300MegDescrip ;
   private java.math.BigDecimal[] H005S2_A264LegSueldoFuera ;
   private String[] H005S2_A331SinDescrip ;
   private boolean[] H005S2_n331SinDescrip ;
   private String[] H005S2_A329SecDescrip ;
   private boolean[] H005S2_n329SecDescrip ;
   private String[] H005S2_A555OsoSiglaYDesc ;
   private boolean[] H005S2_n555OsoSiglaYDesc ;
   private String[] H005S2_A236LegCodPos ;
   private String[] H005S2_A242LegDomici ;
   private String[] H005S2_A479LegEmail ;
   private String[] H005S2_A265LegTelefono ;
   private boolean[] H005S2_n265LegTelefono ;
   private byte[] H005S2_A241LegDiscapacidad ;
   private short[] H005S2_A243LegEstadoCivil ;
   private boolean[] H005S2_n243LegEstadoCivil ;
   private java.util.Date[] H005S2_A244LegFecEgreso ;
   private boolean[] H005S2_n244LegFecEgreso ;
   private java.util.Date[] H005S2_A245LegFecIngreso ;
   private long[] H005S2_A239LegCUIL ;
   private String[] H005S2_A93LegId ;
   private boolean[] H005S2_n93LegId ;
   private java.util.Date[] H005S2_A246LegFecNac ;
   private String[] H005S2_A230LegApellido ;
   private String[] H005S2_A251LegNombre ;
   private byte[] H005S2_A263LegSexo ;
   private boolean[] H005S2_n263LegSexo ;
   private byte[] H005S2_A235LegClase ;
   private String[] H005S2_A937LegConveCodigo ;
   private boolean[] H005S2_n937LegConveCodigo ;
   private short[] H005S2_A22LegPaiCod ;
   private boolean[] H005S2_n22LegPaiCod ;
   private int[] H005S2_A1576LegConveVersionCli ;
   private boolean[] H005S2_n1576LegConveVersionCli ;
   private String[] H005S3_A1965EmpOsoCod ;
   private boolean[] H005S3_n1965EmpOsoCod ;
   private String[] H005S3_A45TipEmpleCod ;
   private boolean[] H005S3_n45TipEmpleCod ;
   private String[] H005S4_A306OsoC3992 ;
   private boolean[] H005S4_n306OsoC3992 ;
}

final  class legajogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H005S2", "SELECT T1.LegLpgCodigo AS LegLpgCodigo, T1.LegMegCodigo AS LegMegCodigo, T1.LegOsoCod AS LegOsoCod, T1.LegSecCodigo AS LegSecCodigo, T1.MprCod, T1.ZonCod, T1.CondiCodigo, T12.EmpOsoCod AS EmpOsoCod, T1.SinieCodigo, T1.LegSinCod AS LegSinCod, T1.LegActCodigo AS LegActCodigo, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegObs, T1.LegCBU, T1.LegCuentaBanc, T1.LegBanTipCuen, T1.LegBanSuc, T1.LegFormaPago, T8.LpgDescri, T1.LegSCVO, T13.OsoC3992, T3.ZonDescrip, T5.SinieDescri, T2.MprDescrip, T6.ActDescrip AS LegActDescri, T4.CondiDescri, T12.TipEmpleCod, T9.MegDescrip, T1.LegSueldoFuera, T7.SinDescrip, T11.SecDescrip, T10.OsoSiglaYDesc, T1.LegCodPos, T1.LegDomici, T1.LegEmail, T1.LegTelefono, T1.LegDiscapacidad, T1.LegEstadoCivil, T1.LegFecEgreso, T1.LegFecIngreso, T1.LegCUIL, T1.LegId, T1.LegFecNac, T1.LegApellido, T1.LegNombre, T1.LegSexo, T1.LegClase, T1.LegConveCodigo, T1.LegPaiCod AS LegPaiCod, T1.LegConveVersionCli FROM ((((((((((((Legajo T1 LEFT JOIN ModalidadAFIP T2 ON T2.MprCod = T1.MprCod) LEFT JOIN Zona T3 ON T3.ZonCod = T1.ZonCod) LEFT JOIN CondicionAFIP T4 ON T4.CondiCodigo = T1.CondiCodigo) LEFT JOIN Siniestrado T5 ON T5.SinieCodigo = T1.SinieCodigo) LEFT JOIN Actividad T6 ON T6.ActCodigo = T1.LegActCodigo) LEFT JOIN Sindicato T7 ON T7.PaiCod = T1.LegPaiCod AND T7.SinCod = T1.LegSinCod) LEFT JOIN LugardePago T8 ON T8.CliCod = T1.CliCod AND T8.LpgCodigo = T1.LegLpgCodigo) LEFT JOIN MotivoEgreso T9 ON T9.CliCod = T1.CliCod AND T9.MegCodigo = T1.LegMegCodigo) LEFT JOIN ObraSocial T10 ON T10.CliCod = T1.CliCod AND T10.OsoCod = T1.LegOsoCod) LEFT JOIN Seccion T11 ON T11.CliCod = T1.CliCod AND T11.SecCodigo = T1.LegSecCodigo) INNER JOIN Empresa T12 ON T12.CliCod = T1.CliCod AND T12.EmpCod = T1.EmpCod) LEFT JOIN ObraSocial T13 ON T13.CliCod = T1.CliCod AND T13.OsoCod = T12.EmpOsoCod) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H005S3", "SELECT EmpOsoCod, TipEmpleCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H005S4", "SELECT OsoC3992 FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(7);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(9, 4);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(11, 8);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((int[]) buf[22])[0] = rslt.getInt(12);
               ((short[]) buf[23])[0] = rslt.getShort(13);
               ((int[]) buf[24])[0] = rslt.getInt(14);
               ((String[]) buf[25])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[26])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(19);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((byte[]) buf[34])[0] = rslt.getByte(20);
               ((String[]) buf[35])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((boolean[]) buf[37])[0] = rslt.getBoolean(22);
               ((String[]) buf[38])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getVarchar(24);
               ((String[]) buf[41])[0] = rslt.getVarchar(25);
               ((String[]) buf[42])[0] = rslt.getVarchar(26);
               ((String[]) buf[43])[0] = rslt.getVarchar(27);
               ((String[]) buf[44])[0] = rslt.getVarchar(28);
               ((String[]) buf[45])[0] = rslt.getString(29, 4);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((String[]) buf[47])[0] = rslt.getVarchar(30);
               ((boolean[]) buf[48])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[49])[0] = rslt.getBigDecimal(31,2);
               ((String[]) buf[50])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getVarchar(34);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(35, 20);
               ((String[]) buf[57])[0] = rslt.getVarchar(36);
               ((String[]) buf[58])[0] = rslt.getVarchar(37);
               ((String[]) buf[59])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[60])[0] = rslt.wasNull();
               ((byte[]) buf[61])[0] = rslt.getByte(39);
               ((short[]) buf[62])[0] = rslt.getShort(40);
               ((boolean[]) buf[63])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[64])[0] = rslt.getGXDate(41);
               ((boolean[]) buf[65])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[66])[0] = rslt.getGXDate(42);
               ((long[]) buf[67])[0] = rslt.getLong(43);
               ((String[]) buf[68])[0] = rslt.getString(44, 20);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[70])[0] = rslt.getGXDate(45);
               ((String[]) buf[71])[0] = rslt.getVarchar(46);
               ((String[]) buf[72])[0] = rslt.getVarchar(47);
               ((byte[]) buf[73])[0] = rslt.getByte(48);
               ((boolean[]) buf[74])[0] = rslt.wasNull();
               ((byte[]) buf[75])[0] = rslt.getByte(49);
               ((String[]) buf[76])[0] = rslt.getString(50, 20);
               ((boolean[]) buf[77])[0] = rslt.wasNull();
               ((short[]) buf[78])[0] = rslt.getShort(51);
               ((boolean[]) buf[79])[0] = rslt.wasNull();
               ((int[]) buf[80])[0] = rslt.getInt(52);
               ((boolean[]) buf[81])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 4);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
      }
   }

}

