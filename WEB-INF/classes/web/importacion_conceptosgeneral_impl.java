package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_conceptosgeneral_impl extends GXWebComponent
{
   public importacion_conceptosgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_conceptosgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_conceptosgeneral_impl.class ));
   }

   public importacion_conceptosgeneral_impl( int remoteHandle ,
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
      cmbImpLiqSIPAApo = new HTMLChoice();
      cmbImpLiqSIPACont = new HTMLChoice();
      cmbImpLiqINSSJyPApo = new HTMLChoice();
      cmbImpLiqINSSJyPCont = new HTMLChoice();
      cmbImpLiqObraSocApo = new HTMLChoice();
      cmbImpLiqObraSocCont = new HTMLChoice();
      cmbImpLiqFonSolRedApo = new HTMLChoice();
      cmbImpLiqFonSolRedCont = new HTMLChoice();
      cmbImpLiqRenateaApo = new HTMLChoice();
      cmbImpLiqRenateaCont = new HTMLChoice();
      cmbImpLiqAsigFamCont = new HTMLChoice();
      cmbImpLiqFonNacEmpCont = new HTMLChoice();
      cmbImpLiqLeyRieTrabCont = new HTMLChoice();
      cmbImpLiqRegDifApo = new HTMLChoice();
      cmbImpLiqRegEspApo = new HTMLChoice();
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
               A88ImpLiqSec = (short)(GXutil.lval( httpContext.GetPar( "ImpLiqSec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
               A89ImpLiqConExtCod = httpContext.GetPar( "ImpLiqConExtCod") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1EmpCod),Short.valueOf(A88ImpLiqSec),A89ImpLiqConExtCod});
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
         pa8F2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "importacion_conceptos General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importacion_conceptosgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A88ImpLiqSec,4,0)),GXutil.URLEncode(GXutil.rtrim(A89ImpLiqConExtCod))}, new String[] {"CliCod","EmpCod","ImpLiqSec","ImpLiqConExtCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA88ImpLiqSec", GXutil.ltrim( localUtil.ntoc( wcpOA88ImpLiqSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA89ImpLiqConExtCod", GXutil.rtrim( wcpOA89ImpLiqConExtCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Width", GXutil.rtrim( Dvpanel_transactiondetail_apocontr_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Autowidth", GXutil.booltostr( Dvpanel_transactiondetail_apocontr_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Autoheight", GXutil.booltostr( Dvpanel_transactiondetail_apocontr_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Cls", GXutil.rtrim( Dvpanel_transactiondetail_apocontr_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Title", GXutil.rtrim( Dvpanel_transactiondetail_apocontr_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Collapsible", GXutil.booltostr( Dvpanel_transactiondetail_apocontr_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Collapsed", GXutil.booltostr( Dvpanel_transactiondetail_apocontr_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Showcollapseicon", GXutil.booltostr( Dvpanel_transactiondetail_apocontr_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Iconposition", GXutil.rtrim( Dvpanel_transactiondetail_apocontr_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Autoscroll", GXutil.booltostr( Dvpanel_transactiondetail_apocontr_Autoscroll));
   }

   public void renderHtmlCloseForm8F2( )
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
      return "importacion_conceptosGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "importacion_conceptos General", "") ;
   }

   public void wb8F0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.importacion_conceptosgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, divTransactiondetail_tableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqConAfipCod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtImpLiqConAfipCod_Internalname, httpContext.getMessage( "Concepto AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqConAfipCod_Internalname, GXutil.rtrim( A642ImpLiqConAfipCod), GXutil.rtrim( localUtil.format( A642ImpLiqConAfipCod, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqConAfipCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpLiqConAfipCod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_conceptosGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqConExtCod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtImpLiqConExtCod_Internalname, httpContext.getMessage( "Código Externo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqConExtCod_Internalname, GXutil.rtrim( A89ImpLiqConExtCod), GXutil.rtrim( localUtil.format( A89ImpLiqConExtCod, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqConExtCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpLiqConExtCod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_conceptosGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqConExtDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtImpLiqConExtDescrip_Internalname, httpContext.getMessage( "Descripción Externa", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtImpLiqConExtDescrip_Internalname, A640ImpLiqConExtDescrip, "", "", (short)(0), 1, edtImpLiqConExtDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "Descrip", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_conceptosGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqConSisCod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtImpLiqConSisCod_Internalname, httpContext.getMessage( "Concepto Sistema", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqConSisCod_Internalname, GXutil.rtrim( A641ImpLiqConSisCod), GXutil.rtrim( localUtil.format( A641ImpLiqConSisCod, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqConSisCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpLiqConSisCod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_conceptosGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_transactiondetail_apocontr.setProperty("Width", Dvpanel_transactiondetail_apocontr_Width);
         ucDvpanel_transactiondetail_apocontr.setProperty("AutoWidth", Dvpanel_transactiondetail_apocontr_Autowidth);
         ucDvpanel_transactiondetail_apocontr.setProperty("AutoHeight", Dvpanel_transactiondetail_apocontr_Autoheight);
         ucDvpanel_transactiondetail_apocontr.setProperty("Cls", Dvpanel_transactiondetail_apocontr_Cls);
         ucDvpanel_transactiondetail_apocontr.setProperty("Title", Dvpanel_transactiondetail_apocontr_Title);
         ucDvpanel_transactiondetail_apocontr.setProperty("Collapsible", Dvpanel_transactiondetail_apocontr_Collapsible);
         ucDvpanel_transactiondetail_apocontr.setProperty("Collapsed", Dvpanel_transactiondetail_apocontr_Collapsed);
         ucDvpanel_transactiondetail_apocontr.setProperty("ShowCollapseIcon", Dvpanel_transactiondetail_apocontr_Showcollapseicon);
         ucDvpanel_transactiondetail_apocontr.setProperty("IconPosition", Dvpanel_transactiondetail_apocontr_Iconposition);
         ucDvpanel_transactiondetail_apocontr.setProperty("AutoScroll", Dvpanel_transactiondetail_apocontr_Autoscroll);
         ucDvpanel_transactiondetail_apocontr.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_transactiondetail_apocontr_Internalname, sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTRContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTRContainer"+"TransactionDetail_ApoContr"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTransactiondetail_apocontr_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqSIPAApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqSIPAApo.getInternalname(), httpContext.getMessage( "SIPA Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqSIPAApo, cmbImpLiqSIPAApo.getInternalname(), GXutil.rtrim( A643ImpLiqSIPAApo), 1, cmbImpLiqSIPAApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqSIPAApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqSIPAApo.setValue( GXutil.rtrim( A643ImpLiqSIPAApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqSIPAApo.getInternalname(), "Values", cmbImpLiqSIPAApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqSIPACont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqSIPACont.getInternalname(), httpContext.getMessage( "SIPA Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqSIPACont, cmbImpLiqSIPACont.getInternalname(), GXutil.rtrim( A644ImpLiqSIPACont), 1, cmbImpLiqSIPACont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqSIPACont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqSIPACont.setValue( GXutil.rtrim( A644ImpLiqSIPACont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqSIPACont.getInternalname(), "Values", cmbImpLiqSIPACont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqINSSJyPApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqINSSJyPApo.getInternalname(), httpContext.getMessage( "INSSJyP Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqINSSJyPApo, cmbImpLiqINSSJyPApo.getInternalname(), GXutil.rtrim( A645ImpLiqINSSJyPApo), 1, cmbImpLiqINSSJyPApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqINSSJyPApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqINSSJyPApo.setValue( GXutil.rtrim( A645ImpLiqINSSJyPApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqINSSJyPApo.getInternalname(), "Values", cmbImpLiqINSSJyPApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqINSSJyPCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqINSSJyPCont.getInternalname(), httpContext.getMessage( "INSSJyP Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqINSSJyPCont, cmbImpLiqINSSJyPCont.getInternalname(), GXutil.rtrim( A646ImpLiqINSSJyPCont), 1, cmbImpLiqINSSJyPCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqINSSJyPCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqINSSJyPCont.setValue( GXutil.rtrim( A646ImpLiqINSSJyPCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqINSSJyPCont.getInternalname(), "Values", cmbImpLiqINSSJyPCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqObraSocApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqObraSocApo.getInternalname(), httpContext.getMessage( "Obra Social Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqObraSocApo, cmbImpLiqObraSocApo.getInternalname(), GXutil.rtrim( A647ImpLiqObraSocApo), 1, cmbImpLiqObraSocApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqObraSocApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqObraSocApo.setValue( GXutil.rtrim( A647ImpLiqObraSocApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqObraSocApo.getInternalname(), "Values", cmbImpLiqObraSocApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqObraSocCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqObraSocCont.getInternalname(), httpContext.getMessage( "Obra Social Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqObraSocCont, cmbImpLiqObraSocCont.getInternalname(), GXutil.rtrim( A648ImpLiqObraSocCont), 1, cmbImpLiqObraSocCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqObraSocCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqObraSocCont.setValue( GXutil.rtrim( A648ImpLiqObraSocCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqObraSocCont.getInternalname(), "Values", cmbImpLiqObraSocCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqFonSolRedApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqFonSolRedApo.getInternalname(), httpContext.getMessage( "Redist. Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqFonSolRedApo, cmbImpLiqFonSolRedApo.getInternalname(), GXutil.rtrim( A649ImpLiqFonSolRedApo), 1, cmbImpLiqFonSolRedApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqFonSolRedApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqFonSolRedApo.setValue( GXutil.rtrim( A649ImpLiqFonSolRedApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqFonSolRedApo.getInternalname(), "Values", cmbImpLiqFonSolRedApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqFonSolRedCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqFonSolRedCont.getInternalname(), httpContext.getMessage( "Redist. Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqFonSolRedCont, cmbImpLiqFonSolRedCont.getInternalname(), GXutil.rtrim( A650ImpLiqFonSolRedCont), 1, cmbImpLiqFonSolRedCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqFonSolRedCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqFonSolRedCont.setValue( GXutil.rtrim( A650ImpLiqFonSolRedCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqFonSolRedCont.getInternalname(), "Values", cmbImpLiqFonSolRedCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqRenateaApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqRenateaApo.getInternalname(), httpContext.getMessage( "RENATEA Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqRenateaApo, cmbImpLiqRenateaApo.getInternalname(), GXutil.rtrim( A651ImpLiqRenateaApo), 1, cmbImpLiqRenateaApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqRenateaApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqRenateaApo.setValue( GXutil.rtrim( A651ImpLiqRenateaApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqRenateaApo.getInternalname(), "Values", cmbImpLiqRenateaApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqRenateaCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqRenateaCont.getInternalname(), httpContext.getMessage( "RENATEA Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqRenateaCont, cmbImpLiqRenateaCont.getInternalname(), GXutil.rtrim( A652ImpLiqRenateaCont), 1, cmbImpLiqRenateaCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqRenateaCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqRenateaCont.setValue( GXutil.rtrim( A652ImpLiqRenateaCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqRenateaCont.getInternalname(), "Values", cmbImpLiqRenateaCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqAsigFamCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqAsigFamCont.getInternalname(), httpContext.getMessage( "Asignaciones Familiares Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqAsigFamCont, cmbImpLiqAsigFamCont.getInternalname(), GXutil.rtrim( A653ImpLiqAsigFamCont), 1, cmbImpLiqAsigFamCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqAsigFamCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqAsigFamCont.setValue( GXutil.rtrim( A653ImpLiqAsigFamCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqAsigFamCont.getInternalname(), "Values", cmbImpLiqAsigFamCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqFonNacEmpCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqFonNacEmpCont.getInternalname(), httpContext.getMessage( "Fondo Nacional Empleo Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqFonNacEmpCont, cmbImpLiqFonNacEmpCont.getInternalname(), GXutil.rtrim( A654ImpLiqFonNacEmpCont), 1, cmbImpLiqFonNacEmpCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqFonNacEmpCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqFonNacEmpCont.setValue( GXutil.rtrim( A654ImpLiqFonNacEmpCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqFonNacEmpCont.getInternalname(), "Values", cmbImpLiqFonNacEmpCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqLeyRieTrabCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqLeyRieTrabCont.getInternalname(), httpContext.getMessage( "Ley Riesgos Trabajo Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqLeyRieTrabCont, cmbImpLiqLeyRieTrabCont.getInternalname(), GXutil.rtrim( A655ImpLiqLeyRieTrabCont), 1, cmbImpLiqLeyRieTrabCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqLeyRieTrabCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqLeyRieTrabCont.setValue( GXutil.rtrim( A655ImpLiqLeyRieTrabCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqLeyRieTrabCont.getInternalname(), "Values", cmbImpLiqLeyRieTrabCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqRegDifApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqRegDifApo.getInternalname(), httpContext.getMessage( "Regimenes Diferenciales Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqRegDifApo, cmbImpLiqRegDifApo.getInternalname(), GXutil.rtrim( A656ImpLiqRegDifApo), 1, cmbImpLiqRegDifApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqRegDifApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqRegDifApo.setValue( GXutil.rtrim( A656ImpLiqRegDifApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqRegDifApo.getInternalname(), "Values", cmbImpLiqRegDifApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqRegEspApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbImpLiqRegEspApo.getInternalname(), httpContext.getMessage( "Regimenes Especiales Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqRegEspApo, cmbImpLiqRegEspApo.getInternalname(), GXutil.rtrim( A657ImpLiqRegEspApo), 1, cmbImpLiqRegEspApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqRegEspApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_conceptosGeneral.htm");
         cmbImpLiqRegEspApo.setValue( GXutil.rtrim( A657ImpLiqRegEspApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqRegEspApo.getInternalname(), "Values", cmbImpLiqRegEspApo.ToJavascriptSource(), true);
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e118f1_client"+"'", TempTags, "", 2, "HLP_importacion_conceptosGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 116,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e128f1_client"+"'", TempTags, "", 2, "HLP_importacion_conceptosGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_conceptosGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_importacion_conceptosGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqSec_Internalname, GXutil.ltrim( localUtil.ntoc( A88ImpLiqSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A88ImpLiqSec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqSec_Jsonclick, 0, "Attribute", "", "", "", "", edtImpLiqSec_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_conceptosGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start8F2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "importacion_conceptos General", ""), (short)(0)) ;
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
            strup8F0( ) ;
         }
      }
   }

   public void ws8F2( )
   {
      start8F2( ) ;
      evt8F2( ) ;
   }

   public void evt8F2( )
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
                              strup8F0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8F0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e138F2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8F0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e148F2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8F0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e158F2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8F0( ) ;
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
                              strup8F0( ) ;
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

   public void we8F2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm8F2( ) ;
         }
      }
   }

   public void pa8F2( )
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
      if ( cmbImpLiqSIPAApo.getItemCount() > 0 )
      {
         A643ImpLiqSIPAApo = cmbImpLiqSIPAApo.getValidValue(A643ImpLiqSIPAApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A643ImpLiqSIPAApo", A643ImpLiqSIPAApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqSIPAApo.setValue( GXutil.rtrim( A643ImpLiqSIPAApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqSIPAApo.getInternalname(), "Values", cmbImpLiqSIPAApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqSIPACont.getItemCount() > 0 )
      {
         A644ImpLiqSIPACont = cmbImpLiqSIPACont.getValidValue(A644ImpLiqSIPACont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A644ImpLiqSIPACont", A644ImpLiqSIPACont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqSIPACont.setValue( GXutil.rtrim( A644ImpLiqSIPACont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqSIPACont.getInternalname(), "Values", cmbImpLiqSIPACont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqINSSJyPApo.getItemCount() > 0 )
      {
         A645ImpLiqINSSJyPApo = cmbImpLiqINSSJyPApo.getValidValue(A645ImpLiqINSSJyPApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A645ImpLiqINSSJyPApo", A645ImpLiqINSSJyPApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqINSSJyPApo.setValue( GXutil.rtrim( A645ImpLiqINSSJyPApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqINSSJyPApo.getInternalname(), "Values", cmbImpLiqINSSJyPApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqINSSJyPCont.getItemCount() > 0 )
      {
         A646ImpLiqINSSJyPCont = cmbImpLiqINSSJyPCont.getValidValue(A646ImpLiqINSSJyPCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A646ImpLiqINSSJyPCont", A646ImpLiqINSSJyPCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqINSSJyPCont.setValue( GXutil.rtrim( A646ImpLiqINSSJyPCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqINSSJyPCont.getInternalname(), "Values", cmbImpLiqINSSJyPCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqObraSocApo.getItemCount() > 0 )
      {
         A647ImpLiqObraSocApo = cmbImpLiqObraSocApo.getValidValue(A647ImpLiqObraSocApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A647ImpLiqObraSocApo", A647ImpLiqObraSocApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqObraSocApo.setValue( GXutil.rtrim( A647ImpLiqObraSocApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqObraSocApo.getInternalname(), "Values", cmbImpLiqObraSocApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqObraSocCont.getItemCount() > 0 )
      {
         A648ImpLiqObraSocCont = cmbImpLiqObraSocCont.getValidValue(A648ImpLiqObraSocCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A648ImpLiqObraSocCont", A648ImpLiqObraSocCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqObraSocCont.setValue( GXutil.rtrim( A648ImpLiqObraSocCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqObraSocCont.getInternalname(), "Values", cmbImpLiqObraSocCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqFonSolRedApo.getItemCount() > 0 )
      {
         A649ImpLiqFonSolRedApo = cmbImpLiqFonSolRedApo.getValidValue(A649ImpLiqFonSolRedApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A649ImpLiqFonSolRedApo", A649ImpLiqFonSolRedApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqFonSolRedApo.setValue( GXutil.rtrim( A649ImpLiqFonSolRedApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqFonSolRedApo.getInternalname(), "Values", cmbImpLiqFonSolRedApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqFonSolRedCont.getItemCount() > 0 )
      {
         A650ImpLiqFonSolRedCont = cmbImpLiqFonSolRedCont.getValidValue(A650ImpLiqFonSolRedCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A650ImpLiqFonSolRedCont", A650ImpLiqFonSolRedCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqFonSolRedCont.setValue( GXutil.rtrim( A650ImpLiqFonSolRedCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqFonSolRedCont.getInternalname(), "Values", cmbImpLiqFonSolRedCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqRenateaApo.getItemCount() > 0 )
      {
         A651ImpLiqRenateaApo = cmbImpLiqRenateaApo.getValidValue(A651ImpLiqRenateaApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A651ImpLiqRenateaApo", A651ImpLiqRenateaApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqRenateaApo.setValue( GXutil.rtrim( A651ImpLiqRenateaApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqRenateaApo.getInternalname(), "Values", cmbImpLiqRenateaApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqRenateaCont.getItemCount() > 0 )
      {
         A652ImpLiqRenateaCont = cmbImpLiqRenateaCont.getValidValue(A652ImpLiqRenateaCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A652ImpLiqRenateaCont", A652ImpLiqRenateaCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqRenateaCont.setValue( GXutil.rtrim( A652ImpLiqRenateaCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqRenateaCont.getInternalname(), "Values", cmbImpLiqRenateaCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqAsigFamCont.getItemCount() > 0 )
      {
         A653ImpLiqAsigFamCont = cmbImpLiqAsigFamCont.getValidValue(A653ImpLiqAsigFamCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A653ImpLiqAsigFamCont", A653ImpLiqAsigFamCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqAsigFamCont.setValue( GXutil.rtrim( A653ImpLiqAsigFamCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqAsigFamCont.getInternalname(), "Values", cmbImpLiqAsigFamCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqFonNacEmpCont.getItemCount() > 0 )
      {
         A654ImpLiqFonNacEmpCont = cmbImpLiqFonNacEmpCont.getValidValue(A654ImpLiqFonNacEmpCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A654ImpLiqFonNacEmpCont", A654ImpLiqFonNacEmpCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqFonNacEmpCont.setValue( GXutil.rtrim( A654ImpLiqFonNacEmpCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqFonNacEmpCont.getInternalname(), "Values", cmbImpLiqFonNacEmpCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqLeyRieTrabCont.getItemCount() > 0 )
      {
         A655ImpLiqLeyRieTrabCont = cmbImpLiqLeyRieTrabCont.getValidValue(A655ImpLiqLeyRieTrabCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A655ImpLiqLeyRieTrabCont", A655ImpLiqLeyRieTrabCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqLeyRieTrabCont.setValue( GXutil.rtrim( A655ImpLiqLeyRieTrabCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqLeyRieTrabCont.getInternalname(), "Values", cmbImpLiqLeyRieTrabCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqRegDifApo.getItemCount() > 0 )
      {
         A656ImpLiqRegDifApo = cmbImpLiqRegDifApo.getValidValue(A656ImpLiqRegDifApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A656ImpLiqRegDifApo", A656ImpLiqRegDifApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqRegDifApo.setValue( GXutil.rtrim( A656ImpLiqRegDifApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqRegDifApo.getInternalname(), "Values", cmbImpLiqRegDifApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqRegEspApo.getItemCount() > 0 )
      {
         A657ImpLiqRegEspApo = cmbImpLiqRegEspApo.getValidValue(A657ImpLiqRegEspApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A657ImpLiqRegEspApo", A657ImpLiqRegEspApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqRegEspApo.setValue( GXutil.rtrim( A657ImpLiqRegEspApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqRegEspApo.getInternalname(), "Values", cmbImpLiqRegEspApo.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf8F2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "importacion_conceptosGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf8F2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e158F2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H008F2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A657ImpLiqRegEspApo = H008F2_A657ImpLiqRegEspApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A657ImpLiqRegEspApo", A657ImpLiqRegEspApo);
            A656ImpLiqRegDifApo = H008F2_A656ImpLiqRegDifApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A656ImpLiqRegDifApo", A656ImpLiqRegDifApo);
            A655ImpLiqLeyRieTrabCont = H008F2_A655ImpLiqLeyRieTrabCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A655ImpLiqLeyRieTrabCont", A655ImpLiqLeyRieTrabCont);
            A654ImpLiqFonNacEmpCont = H008F2_A654ImpLiqFonNacEmpCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A654ImpLiqFonNacEmpCont", A654ImpLiqFonNacEmpCont);
            A653ImpLiqAsigFamCont = H008F2_A653ImpLiqAsigFamCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A653ImpLiqAsigFamCont", A653ImpLiqAsigFamCont);
            A652ImpLiqRenateaCont = H008F2_A652ImpLiqRenateaCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A652ImpLiqRenateaCont", A652ImpLiqRenateaCont);
            A651ImpLiqRenateaApo = H008F2_A651ImpLiqRenateaApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A651ImpLiqRenateaApo", A651ImpLiqRenateaApo);
            A650ImpLiqFonSolRedCont = H008F2_A650ImpLiqFonSolRedCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A650ImpLiqFonSolRedCont", A650ImpLiqFonSolRedCont);
            A649ImpLiqFonSolRedApo = H008F2_A649ImpLiqFonSolRedApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A649ImpLiqFonSolRedApo", A649ImpLiqFonSolRedApo);
            A648ImpLiqObraSocCont = H008F2_A648ImpLiqObraSocCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A648ImpLiqObraSocCont", A648ImpLiqObraSocCont);
            A647ImpLiqObraSocApo = H008F2_A647ImpLiqObraSocApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A647ImpLiqObraSocApo", A647ImpLiqObraSocApo);
            A646ImpLiqINSSJyPCont = H008F2_A646ImpLiqINSSJyPCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A646ImpLiqINSSJyPCont", A646ImpLiqINSSJyPCont);
            A645ImpLiqINSSJyPApo = H008F2_A645ImpLiqINSSJyPApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A645ImpLiqINSSJyPApo", A645ImpLiqINSSJyPApo);
            A644ImpLiqSIPACont = H008F2_A644ImpLiqSIPACont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A644ImpLiqSIPACont", A644ImpLiqSIPACont);
            A643ImpLiqSIPAApo = H008F2_A643ImpLiqSIPAApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A643ImpLiqSIPAApo", A643ImpLiqSIPAApo);
            A641ImpLiqConSisCod = H008F2_A641ImpLiqConSisCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A641ImpLiqConSisCod", A641ImpLiqConSisCod);
            A640ImpLiqConExtDescrip = H008F2_A640ImpLiqConExtDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A640ImpLiqConExtDescrip", A640ImpLiqConExtDescrip);
            A642ImpLiqConAfipCod = H008F2_A642ImpLiqConAfipCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A642ImpLiqConAfipCod", A642ImpLiqConAfipCod);
            /* Execute user event: Load */
            e148F2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb8F0( ) ;
      }
   }

   public void send_integrity_lvl_hashes8F2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "importacion_conceptosGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup8F0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e138F2 ();
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
         wcpOA88ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA88ImpLiqSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA89ImpLiqConExtCod = httpContext.cgiGet( sPrefix+"wcpOA89ImpLiqConExtCod") ;
         Dvpanel_transactiondetail_apocontr_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Width") ;
         Dvpanel_transactiondetail_apocontr_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Autowidth")) ;
         Dvpanel_transactiondetail_apocontr_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Autoheight")) ;
         Dvpanel_transactiondetail_apocontr_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Cls") ;
         Dvpanel_transactiondetail_apocontr_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Title") ;
         Dvpanel_transactiondetail_apocontr_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Collapsible")) ;
         Dvpanel_transactiondetail_apocontr_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Collapsed")) ;
         Dvpanel_transactiondetail_apocontr_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Showcollapseicon")) ;
         Dvpanel_transactiondetail_apocontr_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Iconposition") ;
         Dvpanel_transactiondetail_apocontr_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR_Autoscroll")) ;
         /* Read variables values. */
         A642ImpLiqConAfipCod = httpContext.cgiGet( edtImpLiqConAfipCod_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A642ImpLiqConAfipCod", A642ImpLiqConAfipCod);
         A640ImpLiqConExtDescrip = httpContext.cgiGet( edtImpLiqConExtDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A640ImpLiqConExtDescrip", A640ImpLiqConExtDescrip);
         A641ImpLiqConSisCod = httpContext.cgiGet( edtImpLiqConSisCod_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A641ImpLiqConSisCod", A641ImpLiqConSisCod);
         cmbImpLiqSIPAApo.setValue( httpContext.cgiGet( cmbImpLiqSIPAApo.getInternalname()) );
         A643ImpLiqSIPAApo = httpContext.cgiGet( cmbImpLiqSIPAApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A643ImpLiqSIPAApo", A643ImpLiqSIPAApo);
         cmbImpLiqSIPACont.setValue( httpContext.cgiGet( cmbImpLiqSIPACont.getInternalname()) );
         A644ImpLiqSIPACont = httpContext.cgiGet( cmbImpLiqSIPACont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A644ImpLiqSIPACont", A644ImpLiqSIPACont);
         cmbImpLiqINSSJyPApo.setValue( httpContext.cgiGet( cmbImpLiqINSSJyPApo.getInternalname()) );
         A645ImpLiqINSSJyPApo = httpContext.cgiGet( cmbImpLiqINSSJyPApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A645ImpLiqINSSJyPApo", A645ImpLiqINSSJyPApo);
         cmbImpLiqINSSJyPCont.setValue( httpContext.cgiGet( cmbImpLiqINSSJyPCont.getInternalname()) );
         A646ImpLiqINSSJyPCont = httpContext.cgiGet( cmbImpLiqINSSJyPCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A646ImpLiqINSSJyPCont", A646ImpLiqINSSJyPCont);
         cmbImpLiqObraSocApo.setValue( httpContext.cgiGet( cmbImpLiqObraSocApo.getInternalname()) );
         A647ImpLiqObraSocApo = httpContext.cgiGet( cmbImpLiqObraSocApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A647ImpLiqObraSocApo", A647ImpLiqObraSocApo);
         cmbImpLiqObraSocCont.setValue( httpContext.cgiGet( cmbImpLiqObraSocCont.getInternalname()) );
         A648ImpLiqObraSocCont = httpContext.cgiGet( cmbImpLiqObraSocCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A648ImpLiqObraSocCont", A648ImpLiqObraSocCont);
         cmbImpLiqFonSolRedApo.setValue( httpContext.cgiGet( cmbImpLiqFonSolRedApo.getInternalname()) );
         A649ImpLiqFonSolRedApo = httpContext.cgiGet( cmbImpLiqFonSolRedApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A649ImpLiqFonSolRedApo", A649ImpLiqFonSolRedApo);
         cmbImpLiqFonSolRedCont.setValue( httpContext.cgiGet( cmbImpLiqFonSolRedCont.getInternalname()) );
         A650ImpLiqFonSolRedCont = httpContext.cgiGet( cmbImpLiqFonSolRedCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A650ImpLiqFonSolRedCont", A650ImpLiqFonSolRedCont);
         cmbImpLiqRenateaApo.setValue( httpContext.cgiGet( cmbImpLiqRenateaApo.getInternalname()) );
         A651ImpLiqRenateaApo = httpContext.cgiGet( cmbImpLiqRenateaApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A651ImpLiqRenateaApo", A651ImpLiqRenateaApo);
         cmbImpLiqRenateaCont.setValue( httpContext.cgiGet( cmbImpLiqRenateaCont.getInternalname()) );
         A652ImpLiqRenateaCont = httpContext.cgiGet( cmbImpLiqRenateaCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A652ImpLiqRenateaCont", A652ImpLiqRenateaCont);
         cmbImpLiqAsigFamCont.setValue( httpContext.cgiGet( cmbImpLiqAsigFamCont.getInternalname()) );
         A653ImpLiqAsigFamCont = httpContext.cgiGet( cmbImpLiqAsigFamCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A653ImpLiqAsigFamCont", A653ImpLiqAsigFamCont);
         cmbImpLiqFonNacEmpCont.setValue( httpContext.cgiGet( cmbImpLiqFonNacEmpCont.getInternalname()) );
         A654ImpLiqFonNacEmpCont = httpContext.cgiGet( cmbImpLiqFonNacEmpCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A654ImpLiqFonNacEmpCont", A654ImpLiqFonNacEmpCont);
         cmbImpLiqLeyRieTrabCont.setValue( httpContext.cgiGet( cmbImpLiqLeyRieTrabCont.getInternalname()) );
         A655ImpLiqLeyRieTrabCont = httpContext.cgiGet( cmbImpLiqLeyRieTrabCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A655ImpLiqLeyRieTrabCont", A655ImpLiqLeyRieTrabCont);
         cmbImpLiqRegDifApo.setValue( httpContext.cgiGet( cmbImpLiqRegDifApo.getInternalname()) );
         A656ImpLiqRegDifApo = httpContext.cgiGet( cmbImpLiqRegDifApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A656ImpLiqRegDifApo", A656ImpLiqRegDifApo);
         cmbImpLiqRegEspApo.setValue( httpContext.cgiGet( cmbImpLiqRegEspApo.getInternalname()) );
         A657ImpLiqRegEspApo = httpContext.cgiGet( cmbImpLiqRegEspApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A657ImpLiqRegEspApo", A657ImpLiqRegEspApo);
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
      e138F2 ();
      if (returnInSub) return;
   }

   public void e138F2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      importacion_conceptosgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e148F2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtImpLiqSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtImpLiqSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqSec_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_conceptos_Update", GXv_boolean5) ;
      importacion_conceptosgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_conceptos_Delete", GXv_boolean5) ;
      importacion_conceptosgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV8TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV17Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "importacion_conceptos" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e158F2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      importacion_conceptosgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A88ImpLiqSec = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
      A89ImpLiqConExtCod = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
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
      pa8F2( ) ;
      ws8F2( ) ;
      we8F2( ) ;
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
      sCtrlA88ImpLiqSec = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlA89ImpLiqConExtCod = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa8F2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "importacion_conceptosgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa8F2( ) ;
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
         A88ImpLiqSec = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         A89ImpLiqConExtCod = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA88ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA88ImpLiqSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA89ImpLiqConExtCod = httpContext.cgiGet( sPrefix+"wcpOA89ImpLiqConExtCod") ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1EmpCod != wcpOA1EmpCod ) || ( A88ImpLiqSec != wcpOA88ImpLiqSec ) || ( GXutil.strcmp(A89ImpLiqConExtCod, wcpOA89ImpLiqConExtCod) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1EmpCod = A1EmpCod ;
      wcpOA88ImpLiqSec = A88ImpLiqSec ;
      wcpOA89ImpLiqConExtCod = A89ImpLiqConExtCod ;
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
      sCtrlA88ImpLiqSec = httpContext.cgiGet( sPrefix+"A88ImpLiqSec_CTRL") ;
      if ( GXutil.len( sCtrlA88ImpLiqSec) > 0 )
      {
         A88ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA88ImpLiqSec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
      }
      else
      {
         A88ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A88ImpLiqSec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA89ImpLiqConExtCod = httpContext.cgiGet( sPrefix+"A89ImpLiqConExtCod_CTRL") ;
      if ( GXutil.len( sCtrlA89ImpLiqConExtCod) > 0 )
      {
         A89ImpLiqConExtCod = httpContext.cgiGet( sCtrlA89ImpLiqConExtCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
      }
      else
      {
         A89ImpLiqConExtCod = httpContext.cgiGet( sPrefix+"A89ImpLiqConExtCod_PARM") ;
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
      pa8F2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws8F2( ) ;
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
      ws8F2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A88ImpLiqSec_PARM", GXutil.ltrim( localUtil.ntoc( A88ImpLiqSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA88ImpLiqSec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A88ImpLiqSec_CTRL", GXutil.rtrim( sCtrlA88ImpLiqSec));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A89ImpLiqConExtCod_PARM", GXutil.rtrim( A89ImpLiqConExtCod));
      if ( GXutil.len( GXutil.rtrim( sCtrlA89ImpLiqConExtCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A89ImpLiqConExtCod_CTRL", GXutil.rtrim( sCtrlA89ImpLiqConExtCod));
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
      we8F2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202091078", true, true);
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
      httpContext.AddJavascriptSource("importacion_conceptosgeneral.js", "?202412202091079", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtImpLiqConAfipCod_Internalname = sPrefix+"IMPLIQCONAFIPCOD" ;
      edtImpLiqConExtCod_Internalname = sPrefix+"IMPLIQCONEXTCOD" ;
      edtImpLiqConExtDescrip_Internalname = sPrefix+"IMPLIQCONEXTDESCRIP" ;
      edtImpLiqConSisCod_Internalname = sPrefix+"IMPLIQCONSISCOD" ;
      cmbImpLiqSIPAApo.setInternalname( sPrefix+"IMPLIQSIPAAPO" );
      cmbImpLiqSIPACont.setInternalname( sPrefix+"IMPLIQSIPACONT" );
      cmbImpLiqINSSJyPApo.setInternalname( sPrefix+"IMPLIQINSSJYPAPO" );
      cmbImpLiqINSSJyPCont.setInternalname( sPrefix+"IMPLIQINSSJYPCONT" );
      cmbImpLiqObraSocApo.setInternalname( sPrefix+"IMPLIQOBRASOCAPO" );
      cmbImpLiqObraSocCont.setInternalname( sPrefix+"IMPLIQOBRASOCCONT" );
      cmbImpLiqFonSolRedApo.setInternalname( sPrefix+"IMPLIQFONSOLREDAPO" );
      cmbImpLiqFonSolRedCont.setInternalname( sPrefix+"IMPLIQFONSOLREDCONT" );
      cmbImpLiqRenateaApo.setInternalname( sPrefix+"IMPLIQRENATEAAPO" );
      cmbImpLiqRenateaCont.setInternalname( sPrefix+"IMPLIQRENATEACONT" );
      cmbImpLiqAsigFamCont.setInternalname( sPrefix+"IMPLIQASIGFAMCONT" );
      cmbImpLiqFonNacEmpCont.setInternalname( sPrefix+"IMPLIQFONNACEMPCONT" );
      cmbImpLiqLeyRieTrabCont.setInternalname( sPrefix+"IMPLIQLEYRIETRABCONT" );
      cmbImpLiqRegDifApo.setInternalname( sPrefix+"IMPLIQREGDIFAPO" );
      cmbImpLiqRegEspApo.setInternalname( sPrefix+"IMPLIQREGESPAPO" );
      divTransactiondetail_apocontr_Internalname = sPrefix+"TRANSACTIONDETAIL_APOCONTR" ;
      Dvpanel_transactiondetail_apocontr_Internalname = sPrefix+"DVPANEL_TRANSACTIONDETAIL_APOCONTR" ;
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtImpLiqSec_Internalname = sPrefix+"IMPLIQSEC" ;
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
      edtImpLiqSec_Jsonclick = "" ;
      edtImpLiqSec_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      cmbImpLiqRegEspApo.setJsonclick( "" );
      cmbImpLiqRegEspApo.setEnabled( 0 );
      cmbImpLiqRegDifApo.setJsonclick( "" );
      cmbImpLiqRegDifApo.setEnabled( 0 );
      cmbImpLiqLeyRieTrabCont.setJsonclick( "" );
      cmbImpLiqLeyRieTrabCont.setEnabled( 0 );
      cmbImpLiqFonNacEmpCont.setJsonclick( "" );
      cmbImpLiqFonNacEmpCont.setEnabled( 0 );
      cmbImpLiqAsigFamCont.setJsonclick( "" );
      cmbImpLiqAsigFamCont.setEnabled( 0 );
      cmbImpLiqRenateaCont.setJsonclick( "" );
      cmbImpLiqRenateaCont.setEnabled( 0 );
      cmbImpLiqRenateaApo.setJsonclick( "" );
      cmbImpLiqRenateaApo.setEnabled( 0 );
      cmbImpLiqFonSolRedCont.setJsonclick( "" );
      cmbImpLiqFonSolRedCont.setEnabled( 0 );
      cmbImpLiqFonSolRedApo.setJsonclick( "" );
      cmbImpLiqFonSolRedApo.setEnabled( 0 );
      cmbImpLiqObraSocCont.setJsonclick( "" );
      cmbImpLiqObraSocCont.setEnabled( 0 );
      cmbImpLiqObraSocApo.setJsonclick( "" );
      cmbImpLiqObraSocApo.setEnabled( 0 );
      cmbImpLiqINSSJyPCont.setJsonclick( "" );
      cmbImpLiqINSSJyPCont.setEnabled( 0 );
      cmbImpLiqINSSJyPApo.setJsonclick( "" );
      cmbImpLiqINSSJyPApo.setEnabled( 0 );
      cmbImpLiqSIPACont.setJsonclick( "" );
      cmbImpLiqSIPACont.setEnabled( 0 );
      cmbImpLiqSIPAApo.setJsonclick( "" );
      cmbImpLiqSIPAApo.setEnabled( 0 );
      edtImpLiqConSisCod_Jsonclick = "" ;
      edtImpLiqConSisCod_Enabled = 0 ;
      edtImpLiqConExtDescrip_Enabled = 0 ;
      edtImpLiqConExtCod_Jsonclick = "" ;
      edtImpLiqConExtCod_Enabled = 0 ;
      edtImpLiqConAfipCod_Jsonclick = "" ;
      edtImpLiqConAfipCod_Enabled = 0 ;
      Dvpanel_transactiondetail_apocontr_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_apocontr_Iconposition = "Right" ;
      Dvpanel_transactiondetail_apocontr_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_apocontr_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_apocontr_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_transactiondetail_apocontr_Title = "" ;
      Dvpanel_transactiondetail_apocontr_Cls = "Proximo a desarrollar" ;
      Dvpanel_transactiondetail_apocontr_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_transactiondetail_apocontr_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_transactiondetail_apocontr_Width = "100%" ;
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
      cmbImpLiqSIPAApo.setName( "IMPLIQSIPAAPO" );
      cmbImpLiqSIPAApo.setWebtags( "" );
      cmbImpLiqSIPAApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqSIPAApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqSIPAApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqSIPAApo.getItemCount() > 0 )
      {
      }
      cmbImpLiqSIPACont.setName( "IMPLIQSIPACONT" );
      cmbImpLiqSIPACont.setWebtags( "" );
      cmbImpLiqSIPACont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqSIPACont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqSIPACont.addItem("", "-", (short)(0));
      if ( cmbImpLiqSIPACont.getItemCount() > 0 )
      {
      }
      cmbImpLiqINSSJyPApo.setName( "IMPLIQINSSJYPAPO" );
      cmbImpLiqINSSJyPApo.setWebtags( "" );
      cmbImpLiqINSSJyPApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqINSSJyPApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqINSSJyPApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqINSSJyPApo.getItemCount() > 0 )
      {
      }
      cmbImpLiqINSSJyPCont.setName( "IMPLIQINSSJYPCONT" );
      cmbImpLiqINSSJyPCont.setWebtags( "" );
      cmbImpLiqINSSJyPCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqINSSJyPCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqINSSJyPCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqINSSJyPCont.getItemCount() > 0 )
      {
      }
      cmbImpLiqObraSocApo.setName( "IMPLIQOBRASOCAPO" );
      cmbImpLiqObraSocApo.setWebtags( "" );
      cmbImpLiqObraSocApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqObraSocApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqObraSocApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqObraSocApo.getItemCount() > 0 )
      {
      }
      cmbImpLiqObraSocCont.setName( "IMPLIQOBRASOCCONT" );
      cmbImpLiqObraSocCont.setWebtags( "" );
      cmbImpLiqObraSocCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqObraSocCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqObraSocCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqObraSocCont.getItemCount() > 0 )
      {
      }
      cmbImpLiqFonSolRedApo.setName( "IMPLIQFONSOLREDAPO" );
      cmbImpLiqFonSolRedApo.setWebtags( "" );
      cmbImpLiqFonSolRedApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqFonSolRedApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqFonSolRedApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqFonSolRedApo.getItemCount() > 0 )
      {
      }
      cmbImpLiqFonSolRedCont.setName( "IMPLIQFONSOLREDCONT" );
      cmbImpLiqFonSolRedCont.setWebtags( "" );
      cmbImpLiqFonSolRedCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqFonSolRedCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqFonSolRedCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqFonSolRedCont.getItemCount() > 0 )
      {
      }
      cmbImpLiqRenateaApo.setName( "IMPLIQRENATEAAPO" );
      cmbImpLiqRenateaApo.setWebtags( "" );
      cmbImpLiqRenateaApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqRenateaApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqRenateaApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqRenateaApo.getItemCount() > 0 )
      {
      }
      cmbImpLiqRenateaCont.setName( "IMPLIQRENATEACONT" );
      cmbImpLiqRenateaCont.setWebtags( "" );
      cmbImpLiqRenateaCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqRenateaCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqRenateaCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqRenateaCont.getItemCount() > 0 )
      {
      }
      cmbImpLiqAsigFamCont.setName( "IMPLIQASIGFAMCONT" );
      cmbImpLiqAsigFamCont.setWebtags( "" );
      cmbImpLiqAsigFamCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqAsigFamCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqAsigFamCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqAsigFamCont.getItemCount() > 0 )
      {
      }
      cmbImpLiqFonNacEmpCont.setName( "IMPLIQFONNACEMPCONT" );
      cmbImpLiqFonNacEmpCont.setWebtags( "" );
      cmbImpLiqFonNacEmpCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqFonNacEmpCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqFonNacEmpCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqFonNacEmpCont.getItemCount() > 0 )
      {
      }
      cmbImpLiqLeyRieTrabCont.setName( "IMPLIQLEYRIETRABCONT" );
      cmbImpLiqLeyRieTrabCont.setWebtags( "" );
      cmbImpLiqLeyRieTrabCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqLeyRieTrabCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqLeyRieTrabCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqLeyRieTrabCont.getItemCount() > 0 )
      {
      }
      cmbImpLiqRegDifApo.setName( "IMPLIQREGDIFAPO" );
      cmbImpLiqRegDifApo.setWebtags( "" );
      cmbImpLiqRegDifApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqRegDifApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqRegDifApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqRegDifApo.getItemCount() > 0 )
      {
      }
      cmbImpLiqRegEspApo.setName( "IMPLIQREGESPAPO" );
      cmbImpLiqRegEspApo.setWebtags( "" );
      cmbImpLiqRegEspApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqRegEspApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqRegEspApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqRegEspApo.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A88ImpLiqSec',fld:'IMPLIQSEC',pic:'ZZZ9'},{av:'A89ImpLiqConExtCod',fld:'IMPLIQCONEXTCOD',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e118F1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A88ImpLiqSec',fld:'IMPLIQSEC',pic:'ZZZ9'},{av:'A89ImpLiqConExtCod',fld:'IMPLIQCONEXTCOD',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e128F1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A88ImpLiqSec',fld:'IMPLIQSEC',pic:'ZZZ9'},{av:'A89ImpLiqConExtCod',fld:'IMPLIQCONEXTCOD',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQCONEXTCOD","{handler:'valid_Impliqconextcod',iparms:[]");
      setEventMetadata("VALID_IMPLIQCONEXTCOD",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQSEC","{handler:'valid_Impliqsec',iparms:[]");
      setEventMetadata("VALID_IMPLIQSEC",",oparms:[]}");
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
      wcpOA89ImpLiqConExtCod = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A89ImpLiqConExtCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A642ImpLiqConAfipCod = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A640ImpLiqConExtDescrip = "" ;
      A641ImpLiqConSisCod = "" ;
      ucDvpanel_transactiondetail_apocontr = new com.genexus.webpanels.GXUserControl();
      A643ImpLiqSIPAApo = "" ;
      A644ImpLiqSIPACont = "" ;
      A645ImpLiqINSSJyPApo = "" ;
      A646ImpLiqINSSJyPCont = "" ;
      A647ImpLiqObraSocApo = "" ;
      A648ImpLiqObraSocCont = "" ;
      A649ImpLiqFonSolRedApo = "" ;
      A650ImpLiqFonSolRedCont = "" ;
      A651ImpLiqRenateaApo = "" ;
      A652ImpLiqRenateaCont = "" ;
      A653ImpLiqAsigFamCont = "" ;
      A654ImpLiqFonNacEmpCont = "" ;
      A655ImpLiqLeyRieTrabCont = "" ;
      A656ImpLiqRegDifApo = "" ;
      A657ImpLiqRegEspApo = "" ;
      TempTags = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      H008F2_A3CliCod = new int[1] ;
      H008F2_A1EmpCod = new short[1] ;
      H008F2_A88ImpLiqSec = new short[1] ;
      H008F2_A89ImpLiqConExtCod = new String[] {""} ;
      H008F2_A657ImpLiqRegEspApo = new String[] {""} ;
      H008F2_A656ImpLiqRegDifApo = new String[] {""} ;
      H008F2_A655ImpLiqLeyRieTrabCont = new String[] {""} ;
      H008F2_A654ImpLiqFonNacEmpCont = new String[] {""} ;
      H008F2_A653ImpLiqAsigFamCont = new String[] {""} ;
      H008F2_A652ImpLiqRenateaCont = new String[] {""} ;
      H008F2_A651ImpLiqRenateaApo = new String[] {""} ;
      H008F2_A650ImpLiqFonSolRedCont = new String[] {""} ;
      H008F2_A649ImpLiqFonSolRedApo = new String[] {""} ;
      H008F2_A648ImpLiqObraSocCont = new String[] {""} ;
      H008F2_A647ImpLiqObraSocApo = new String[] {""} ;
      H008F2_A646ImpLiqINSSJyPCont = new String[] {""} ;
      H008F2_A645ImpLiqINSSJyPApo = new String[] {""} ;
      H008F2_A644ImpLiqSIPACont = new String[] {""} ;
      H008F2_A643ImpLiqSIPAApo = new String[] {""} ;
      H008F2_A641ImpLiqConSisCod = new String[] {""} ;
      H008F2_A640ImpLiqConExtDescrip = new String[] {""} ;
      H008F2_A642ImpLiqConAfipCod = new String[] {""} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1EmpCod = "" ;
      sCtrlA88ImpLiqSec = "" ;
      sCtrlA89ImpLiqConExtCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_conceptosgeneral__default(),
         new Object[] {
             new Object[] {
            H008F2_A3CliCod, H008F2_A1EmpCod, H008F2_A88ImpLiqSec, H008F2_A89ImpLiqConExtCod, H008F2_A657ImpLiqRegEspApo, H008F2_A656ImpLiqRegDifApo, H008F2_A655ImpLiqLeyRieTrabCont, H008F2_A654ImpLiqFonNacEmpCont, H008F2_A653ImpLiqAsigFamCont, H008F2_A652ImpLiqRenateaCont,
            H008F2_A651ImpLiqRenateaApo, H008F2_A650ImpLiqFonSolRedCont, H008F2_A649ImpLiqFonSolRedApo, H008F2_A648ImpLiqObraSocCont, H008F2_A647ImpLiqObraSocApo, H008F2_A646ImpLiqINSSJyPCont, H008F2_A645ImpLiqINSSJyPApo, H008F2_A644ImpLiqSIPACont, H008F2_A643ImpLiqSIPAApo, H008F2_A641ImpLiqConSisCod,
            H008F2_A640ImpLiqConExtDescrip, H008F2_A642ImpLiqConAfipCod
            }
         }
      );
      AV17Pgmname = "importacion_conceptosGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "importacion_conceptosGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1EmpCod ;
   private short wcpOA88ImpLiqSec ;
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int edtImpLiqConAfipCod_Enabled ;
   private int edtImpLiqConExtCod_Enabled ;
   private int edtImpLiqConExtDescrip_Enabled ;
   private int edtImpLiqConSisCod_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtEmpCod_Visible ;
   private int edtImpLiqSec_Visible ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String wcpOA89ImpLiqConExtCod ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A89ImpLiqConExtCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_transactiondetail_apocontr_Width ;
   private String Dvpanel_transactiondetail_apocontr_Cls ;
   private String Dvpanel_transactiondetail_apocontr_Title ;
   private String Dvpanel_transactiondetail_apocontr_Iconposition ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtImpLiqConAfipCod_Internalname ;
   private String A642ImpLiqConAfipCod ;
   private String edtImpLiqConAfipCod_Jsonclick ;
   private String edtImpLiqConExtCod_Internalname ;
   private String edtImpLiqConExtCod_Jsonclick ;
   private String edtImpLiqConExtDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtImpLiqConSisCod_Internalname ;
   private String A641ImpLiqConSisCod ;
   private String edtImpLiqConSisCod_Jsonclick ;
   private String Dvpanel_transactiondetail_apocontr_Internalname ;
   private String divTransactiondetail_apocontr_Internalname ;
   private String A643ImpLiqSIPAApo ;
   private String A644ImpLiqSIPACont ;
   private String A645ImpLiqINSSJyPApo ;
   private String A646ImpLiqINSSJyPCont ;
   private String A647ImpLiqObraSocApo ;
   private String A648ImpLiqObraSocCont ;
   private String A649ImpLiqFonSolRedApo ;
   private String A650ImpLiqFonSolRedCont ;
   private String A651ImpLiqRenateaApo ;
   private String A652ImpLiqRenateaCont ;
   private String A653ImpLiqAsigFamCont ;
   private String A654ImpLiqFonNacEmpCont ;
   private String A655ImpLiqLeyRieTrabCont ;
   private String A656ImpLiqRegDifApo ;
   private String A657ImpLiqRegEspApo ;
   private String TempTags ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtImpLiqSec_Internalname ;
   private String edtImpLiqSec_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1EmpCod ;
   private String sCtrlA88ImpLiqSec ;
   private String sCtrlA89ImpLiqConExtCod ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_transactiondetail_apocontr_Autowidth ;
   private boolean Dvpanel_transactiondetail_apocontr_Autoheight ;
   private boolean Dvpanel_transactiondetail_apocontr_Collapsible ;
   private boolean Dvpanel_transactiondetail_apocontr_Collapsed ;
   private boolean Dvpanel_transactiondetail_apocontr_Showcollapseicon ;
   private boolean Dvpanel_transactiondetail_apocontr_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A640ImpLiqConExtDescrip ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_transactiondetail_apocontr ;
   private HTMLChoice cmbImpLiqSIPAApo ;
   private HTMLChoice cmbImpLiqSIPACont ;
   private HTMLChoice cmbImpLiqINSSJyPApo ;
   private HTMLChoice cmbImpLiqINSSJyPCont ;
   private HTMLChoice cmbImpLiqObraSocApo ;
   private HTMLChoice cmbImpLiqObraSocCont ;
   private HTMLChoice cmbImpLiqFonSolRedApo ;
   private HTMLChoice cmbImpLiqFonSolRedCont ;
   private HTMLChoice cmbImpLiqRenateaApo ;
   private HTMLChoice cmbImpLiqRenateaCont ;
   private HTMLChoice cmbImpLiqAsigFamCont ;
   private HTMLChoice cmbImpLiqFonNacEmpCont ;
   private HTMLChoice cmbImpLiqLeyRieTrabCont ;
   private HTMLChoice cmbImpLiqRegDifApo ;
   private HTMLChoice cmbImpLiqRegEspApo ;
   private IDataStoreProvider pr_default ;
   private int[] H008F2_A3CliCod ;
   private short[] H008F2_A1EmpCod ;
   private short[] H008F2_A88ImpLiqSec ;
   private String[] H008F2_A89ImpLiqConExtCod ;
   private String[] H008F2_A657ImpLiqRegEspApo ;
   private String[] H008F2_A656ImpLiqRegDifApo ;
   private String[] H008F2_A655ImpLiqLeyRieTrabCont ;
   private String[] H008F2_A654ImpLiqFonNacEmpCont ;
   private String[] H008F2_A653ImpLiqAsigFamCont ;
   private String[] H008F2_A652ImpLiqRenateaCont ;
   private String[] H008F2_A651ImpLiqRenateaApo ;
   private String[] H008F2_A650ImpLiqFonSolRedCont ;
   private String[] H008F2_A649ImpLiqFonSolRedApo ;
   private String[] H008F2_A648ImpLiqObraSocCont ;
   private String[] H008F2_A647ImpLiqObraSocApo ;
   private String[] H008F2_A646ImpLiqINSSJyPCont ;
   private String[] H008F2_A645ImpLiqINSSJyPApo ;
   private String[] H008F2_A644ImpLiqSIPACont ;
   private String[] H008F2_A643ImpLiqSIPAApo ;
   private String[] H008F2_A641ImpLiqConSisCod ;
   private String[] H008F2_A640ImpLiqConExtDescrip ;
   private String[] H008F2_A642ImpLiqConAfipCod ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class importacion_conceptosgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H008F2", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod, ImpLiqRegEspApo, ImpLiqRegDifApo, ImpLiqLeyRieTrabCont, ImpLiqFonNacEmpCont, ImpLiqAsigFamCont, ImpLiqRenateaCont, ImpLiqRenateaApo, ImpLiqFonSolRedCont, ImpLiqFonSolRedApo, ImpLiqObraSocCont, ImpLiqObraSocApo, ImpLiqINSSJyPCont, ImpLiqINSSJyPApo, ImpLiqSIPACont, ImpLiqSIPAApo, ImpLiqConSisCod, ImpLiqConExtDescrip, ImpLiqConAfipCod FROM importacion_conceptos WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqConExtCod = ( ?) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getString(18, 1);
               ((String[]) buf[18])[0] = rslt.getString(19, 1);
               ((String[]) buf[19])[0] = rslt.getString(20, 20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

