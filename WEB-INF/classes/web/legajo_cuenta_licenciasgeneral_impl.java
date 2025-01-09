package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajo_cuenta_licenciasgeneral_impl extends GXWebComponent
{
   public legajo_cuenta_licenciasgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajo_cuenta_licenciasgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_cuenta_licenciasgeneral_impl.class ));
   }

   public legajo_cuenta_licenciasgeneral_impl( int remoteHandle ,
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
      chkLegCuLIncluir = UIFactory.getCheckbox(this);
      cmbLegCuenLicTpo = new HTMLChoice();
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
               A2243LegCuenLicTpo = httpContext.GetPar( "LegCuenLicTpo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
               A2266LegCuenAnio = (short)(GXutil.lval( httpContext.GetPar( "LegCuenAnio"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1EmpCod),Integer.valueOf(A6LegNumero),A2243LegCuenLicTpo,Short.valueOf(A2266LegCuenAnio)});
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
         paOW2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "legajo_cuenta_licencias General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajo_cuenta_licenciasgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(A2243LegCuenLicTpo)),GXutil.URLEncode(GXutil.ltrimstr(A2266LegCuenAnio,4,0))}, new String[] {"CliCod","EmpCod","LegNumero","LegCuenLicTpo","LegCuenAnio"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA2243LegCuenLicTpo", GXutil.rtrim( wcpOA2243LegCuenLicTpo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA2266LegCuenAnio", GXutil.ltrim( localUtil.ntoc( wcpOA2266LegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormOW2( )
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
      return "legajo_cuenta_licenciasGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "legajo_cuenta_licencias General", "") ;
   }

   public void wbOW0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.legajo_cuenta_licenciasgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegIdNomApe_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegIdNomApe_Internalname, httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegIdNomApe_Internalname, A250LegIdNomApe, GXutil.rtrim( localUtil.format( A250LegIdNomApe, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegIdNomApe_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegIdNomApe_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuenAnio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuenAnio_Internalname, httpContext.getMessage( "Año", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenAnio_Internalname, GXutil.ltrim( localUtil.ntoc( A2266LegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuenAnio_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2266LegCuenAnio), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2266LegCuenAnio), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenAnio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuenAnio_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Anio", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuenLicPerIni_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuenLicPerIni_Internalname, httpContext.getMessage( "Inicio de periodo de correspondencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtLegCuenLicPerIni_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenLicPerIni_Internalname, localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"), localUtil.format( A2244LegCuenLicPerIni, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenLicPerIni_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuenLicPerIni_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtLegCuenLicPerIni_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegCuenLicPerIni_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuenLicPerFin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuenLicPerFin_Internalname, httpContext.getMessage( "Fin de periodo de correspondencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtLegCuenLicPerFin_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenLicPerFin_Internalname, localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"), localUtil.format( A2245LegCuenLicPerFin, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenLicPerFin_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuenLicPerFin_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtLegCuenLicPerFin_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegCuenLicPerFin_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkLegCuLIncluir.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkLegCuLIncluir.getInternalname(), httpContext.getMessage( "Recorrer", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkLegCuLIncluir.getInternalname(), GXutil.booltostr( A2321LegCuLIncluir), "", httpContext.getMessage( "Recorrer", ""), 1, chkLegCuLIncluir.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuenDiasCorres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuenDiasCorres_Internalname, httpContext.getMessage( "Cantidad de días que corresponden por antiguedad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenDiasCorres_Internalname, GXutil.ltrim( localUtil.ntoc( A2247LegCuenDiasCorres, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuenDiasCorres_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenDiasCorres_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuenDiasCorres_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLiPAnt_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuLiPAnt_Internalname, httpContext.getMessage( "Pendientes de años anteriores", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLiPAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A2303LegCuLiPAnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLiPAnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLiPAnt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLiPAnt_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLiPVen_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuLiPVen_Internalname, httpContext.getMessage( "Pendientes de años anteriores vencidas", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLiPVen_Internalname, GXutil.ltrim( localUtil.ntoc( A2304LegCuLiPVen, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLiPVen_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2304LegCuLiPVen), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2304LegCuLiPVen), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLiPVen_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLiPVen_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLiPCur_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuLiPCur_Internalname, httpContext.getMessage( "Pendientes actuales", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLiPCur_Internalname, GXutil.ltrim( localUtil.ntoc( A2302LegCuLiPCur, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLiPCur_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2302LegCuLiPCur), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2302LegCuLiPCur), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLiPCur_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLiPCur_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLActVen_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuLActVen_Internalname, httpContext.getMessage( "Actuales (del periodo) a vencer", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLActVen_Internalname, GXutil.ltrim( localUtil.ntoc( A2315LegCuLActVen, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLActVen_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2315LegCuLActVen), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2315LegCuLActVen), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLActVen_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLActVen_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLiPApr_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuLiPApr_Internalname, httpContext.getMessage( "Solicitadas y pendientes de aprobación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLiPApr_Internalname, GXutil.ltrim( localUtil.ntoc( A2306LegCuLiPApr, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLiPApr_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2306LegCuLiPApr), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2306LegCuLiPApr), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLiPApr_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLiPApr_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuenDiasGoz_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuenDiasGoz_Internalname, httpContext.getMessage( "Cantidad de días aprobados", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenDiasGoz_Internalname, GXutil.ltrim( localUtil.ntoc( A2248LegCuenDiasGoz, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuenDiasGoz_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenDiasGoz_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuenDiasGoz_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLiPSaldo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegCuLiPSaldo_Internalname, httpContext.getMessage( "Total disponible", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLiPSaldo_Internalname, GXutil.ltrim( localUtil.ntoc( A2305LegCuLiPSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLiPSaldo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLiPSaldo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLiPSaldo_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11ow1_client"+"'", TempTags, "", 2, "HLP_legajo_cuenta_licenciasGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtLegNumero_Visible, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLegCuenLicTpo, cmbLegCuenLicTpo.getInternalname(), GXutil.rtrim( A2243LegCuenLicTpo), 1, cmbLegCuenLicTpo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbLegCuenLicTpo.getVisible(), 0, 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_legajo_cuenta_licenciasGeneral.htm");
         cmbLegCuenLicTpo.setValue( GXutil.rtrim( A2243LegCuenLicTpo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegCuenLicTpo.getInternalname(), "Values", cmbLegCuenLicTpo.ToJavascriptSource(), true);
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLRecalc_Internalname, GXutil.booltostr( A2322LegCuLRecalc), GXutil.booltostr( A2322LegCuLRecalc), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLRecalc_Jsonclick, 0, "Attribute", "", "", "", "", edtLegCuLRecalc_Visible, 0, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenAntDias_Internalname, GXutil.ltrim( localUtil.ntoc( A2246LegCuenAntDias, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2246LegCuenAntDias), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenAntDias_Jsonclick, 0, "Attribute", "", "", "", "", edtLegCuenAntDias_Visible, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenAntAnios_Internalname, GXutil.ltrim( localUtil.ntoc( A2299LegCuenAntAnios, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2299LegCuenAntAnios), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenAntAnios_Jsonclick, 0, "Attribute", "", "", "", "", edtLegCuenAntAnios_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenAntMeses_Internalname, GXutil.ltrim( localUtil.ntoc( A2300LegCuenAntMeses, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2300LegCuenAntMeses), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenAntMeses_Jsonclick, 0, "Attribute", "", "", "", "", edtLegCuenAntMeses_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licenciasGeneral.htm");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtLegCueAntTexto_Internalname, A2301LegCueAntTexto, "", "", (short)(0), edtLegCueAntTexto_Visible, 0, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_legajo_cuenta_licenciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startOW2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "legajo_cuenta_licencias General", ""), (short)(0)) ;
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
            strupOW0( ) ;
         }
      }
   }

   public void wsOW2( )
   {
      startOW2( ) ;
      evtOW2( ) ;
   }

   public void evtOW2( )
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
                              strupOW0( ) ;
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
                              strupOW0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e12OW2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOW0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e13OW2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOW0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e14OW2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOW0( ) ;
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
                              strupOW0( ) ;
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

   public void weOW2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormOW2( ) ;
         }
      }
   }

   public void paOW2( )
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
      A2321LegCuLIncluir = GXutil.strtobool( GXutil.booltostr( A2321LegCuLIncluir)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2321LegCuLIncluir", A2321LegCuLIncluir);
      if ( cmbLegCuenLicTpo.getItemCount() > 0 )
      {
         A2243LegCuenLicTpo = cmbLegCuenLicTpo.getValidValue(A2243LegCuenLicTpo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegCuenLicTpo.setValue( GXutil.rtrim( A2243LegCuenLicTpo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegCuenLicTpo.getInternalname(), "Values", cmbLegCuenLicTpo.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfOW2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "legajo_cuenta_licenciasGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfOW2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e14OW2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00OW2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A2301LegCueAntTexto = H00OW2_A2301LegCueAntTexto[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2301LegCueAntTexto", A2301LegCueAntTexto);
            A2300LegCuenAntMeses = H00OW2_A2300LegCuenAntMeses[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2300LegCuenAntMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2300LegCuenAntMeses), 4, 0));
            A2299LegCuenAntAnios = H00OW2_A2299LegCuenAntAnios[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2299LegCuenAntAnios", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2299LegCuenAntAnios), 4, 0));
            A2246LegCuenAntDias = H00OW2_A2246LegCuenAntDias[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2246LegCuenAntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2246LegCuenAntDias), 8, 0));
            A2322LegCuLRecalc = H00OW2_A2322LegCuLRecalc[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2322LegCuLRecalc", A2322LegCuLRecalc);
            A2305LegCuLiPSaldo = H00OW2_A2305LegCuLiPSaldo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2305LegCuLiPSaldo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), 4, 0));
            A2248LegCuenDiasGoz = H00OW2_A2248LegCuenDiasGoz[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2248LegCuenDiasGoz", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), 4, 0));
            A2306LegCuLiPApr = H00OW2_A2306LegCuLiPApr[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2306LegCuLiPApr", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2306LegCuLiPApr), 4, 0));
            A2315LegCuLActVen = H00OW2_A2315LegCuLActVen[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2315LegCuLActVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2315LegCuLActVen), 4, 0));
            A2302LegCuLiPCur = H00OW2_A2302LegCuLiPCur[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2302LegCuLiPCur", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2302LegCuLiPCur), 4, 0));
            A2304LegCuLiPVen = H00OW2_A2304LegCuLiPVen[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2304LegCuLiPVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2304LegCuLiPVen), 4, 0));
            A2303LegCuLiPAnt = H00OW2_A2303LegCuLiPAnt[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2303LegCuLiPAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), 4, 0));
            A2247LegCuenDiasCorres = H00OW2_A2247LegCuenDiasCorres[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2247LegCuenDiasCorres", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), 4, 0));
            A2321LegCuLIncluir = H00OW2_A2321LegCuLIncluir[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2321LegCuLIncluir", A2321LegCuLIncluir);
            A2245LegCuenLicPerFin = H00OW2_A2245LegCuenLicPerFin[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2245LegCuenLicPerFin", localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"));
            A2244LegCuenLicPerIni = H00OW2_A2244LegCuenLicPerIni[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2244LegCuenLicPerIni", localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"));
            /* Execute user event: Load */
            e13OW2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wbOW0( ) ;
      }
   }

   public void send_integrity_lvl_hashesOW2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "legajo_cuenta_licenciasGeneral" ;
      Gx_err = (short)(0) ;
      /* Using cursor H00OW3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      A250LegIdNomApe = H00OW3_A250LegIdNomApe[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A250LegIdNomApe", A250LegIdNomApe);
      pr_default.close(1);
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strupOW0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12OW2 ();
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
         wcpOA2243LegCuenLicTpo = httpContext.cgiGet( sPrefix+"wcpOA2243LegCuenLicTpo") ;
         wcpOA2266LegCuenAnio = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA2266LegCuenAnio"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A250LegIdNomApe = httpContext.cgiGet( edtLegIdNomApe_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A250LegIdNomApe", A250LegIdNomApe);
         A2244LegCuenLicPerIni = localUtil.ctod( httpContext.cgiGet( edtLegCuenLicPerIni_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2244LegCuenLicPerIni", localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"));
         A2245LegCuenLicPerFin = localUtil.ctod( httpContext.cgiGet( edtLegCuenLicPerFin_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2245LegCuenLicPerFin", localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"));
         A2321LegCuLIncluir = GXutil.strtobool( httpContext.cgiGet( chkLegCuLIncluir.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2321LegCuLIncluir", A2321LegCuLIncluir);
         A2247LegCuenDiasCorres = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenDiasCorres_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2247LegCuenDiasCorres", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), 4, 0));
         A2303LegCuLiPAnt = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2303LegCuLiPAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), 4, 0));
         A2304LegCuLiPVen = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPVen_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2304LegCuLiPVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2304LegCuLiPVen), 4, 0));
         A2302LegCuLiPCur = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPCur_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2302LegCuLiPCur", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2302LegCuLiPCur), 4, 0));
         A2315LegCuLActVen = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLActVen_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2315LegCuLActVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2315LegCuLActVen), 4, 0));
         A2306LegCuLiPApr = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPApr_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2306LegCuLiPApr", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2306LegCuLiPApr), 4, 0));
         A2248LegCuenDiasGoz = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenDiasGoz_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2248LegCuenDiasGoz", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), 4, 0));
         A2305LegCuLiPSaldo = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPSaldo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2305LegCuLiPSaldo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), 4, 0));
         A2322LegCuLRecalc = GXutil.strtobool( httpContext.cgiGet( edtLegCuLRecalc_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2322LegCuLRecalc", A2322LegCuLRecalc);
         A2246LegCuenAntDias = (int)(localUtil.ctol( httpContext.cgiGet( edtLegCuenAntDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2246LegCuenAntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2246LegCuenAntDias), 8, 0));
         A2299LegCuenAntAnios = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenAntAnios_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2299LegCuenAntAnios", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2299LegCuenAntAnios), 4, 0));
         A2300LegCuenAntMeses = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenAntMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2300LegCuenAntMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2300LegCuenAntMeses), 4, 0));
         A2301LegCueAntTexto = httpContext.cgiGet( edtLegCueAntTexto_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2301LegCueAntTexto", A2301LegCueAntTexto);
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
      e12OW2 ();
      if (returnInSub) return;
   }

   public void e12OW2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      legajo_cuenta_licenciasgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e13OW2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Visible), 5, 0), true);
      cmbLegCuenLicTpo.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegCuenLicTpo.getInternalname(), "Visible", GXutil.ltrimstr( cmbLegCuenLicTpo.getVisible(), 5, 0), true);
      edtLegCuLRecalc_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegCuLRecalc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLRecalc_Visible), 5, 0), true);
      edtLegCuenAntDias_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegCuenAntDias_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAntDias_Visible), 5, 0), true);
      edtLegCuenAntAnios_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegCuenAntAnios_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAntAnios_Visible), 5, 0), true);
      edtLegCuenAntMeses_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegCuenAntMeses_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAntMeses_Visible), 5, 0), true);
      edtLegCueAntTexto_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegCueAntTexto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCueAntTexto_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_cuenta_licencias_Update", GXv_boolean5) ;
      legajo_cuenta_licenciasgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "legajo_cuenta_licencias" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e14OW2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      legajo_cuenta_licenciasgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
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
      A2243LegCuenLicTpo = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
      A2266LegCuenAnio = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
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
      paOW2( ) ;
      wsOW2( ) ;
      weOW2( ) ;
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
      sCtrlA2243LegCuenLicTpo = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlA2266LegCuenAnio = (String)getParm(obj,4,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paOW2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "legajo_cuenta_licenciasgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paOW2( ) ;
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
         A2243LegCuenLicTpo = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
         A2266LegCuenAnio = ((Number) GXutil.testNumericType( getParm(obj,6,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA2243LegCuenLicTpo = httpContext.cgiGet( sPrefix+"wcpOA2243LegCuenLicTpo") ;
      wcpOA2266LegCuenAnio = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA2266LegCuenAnio"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1EmpCod != wcpOA1EmpCod ) || ( A6LegNumero != wcpOA6LegNumero ) || ( GXutil.strcmp(A2243LegCuenLicTpo, wcpOA2243LegCuenLicTpo) != 0 ) || ( A2266LegCuenAnio != wcpOA2266LegCuenAnio ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1EmpCod = A1EmpCod ;
      wcpOA6LegNumero = A6LegNumero ;
      wcpOA2243LegCuenLicTpo = A2243LegCuenLicTpo ;
      wcpOA2266LegCuenAnio = A2266LegCuenAnio ;
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
      sCtrlA2243LegCuenLicTpo = httpContext.cgiGet( sPrefix+"A2243LegCuenLicTpo_CTRL") ;
      if ( GXutil.len( sCtrlA2243LegCuenLicTpo) > 0 )
      {
         A2243LegCuenLicTpo = httpContext.cgiGet( sCtrlA2243LegCuenLicTpo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
      }
      else
      {
         A2243LegCuenLicTpo = httpContext.cgiGet( sPrefix+"A2243LegCuenLicTpo_PARM") ;
      }
      sCtrlA2266LegCuenAnio = httpContext.cgiGet( sPrefix+"A2266LegCuenAnio_CTRL") ;
      if ( GXutil.len( sCtrlA2266LegCuenAnio) > 0 )
      {
         A2266LegCuenAnio = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA2266LegCuenAnio), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
      }
      else
      {
         A2266LegCuenAnio = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A2266LegCuenAnio_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paOW2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsOW2( ) ;
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
      wsOW2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A2243LegCuenLicTpo_PARM", GXutil.rtrim( A2243LegCuenLicTpo));
      if ( GXutil.len( GXutil.rtrim( sCtrlA2243LegCuenLicTpo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A2243LegCuenLicTpo_CTRL", GXutil.rtrim( sCtrlA2243LegCuenLicTpo));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A2266LegCuenAnio_PARM", GXutil.ltrim( localUtil.ntoc( A2266LegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA2266LegCuenAnio)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A2266LegCuenAnio_CTRL", GXutil.rtrim( sCtrlA2266LegCuenAnio));
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
      weOW2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713491931", true, true);
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
      httpContext.AddJavascriptSource("legajo_cuenta_licenciasgeneral.js", "?20251713491931", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtLegIdNomApe_Internalname = sPrefix+"LEGIDNOMAPE" ;
      edtLegCuenAnio_Internalname = sPrefix+"LEGCUENANIO" ;
      edtLegCuenLicPerIni_Internalname = sPrefix+"LEGCUENLICPERINI" ;
      edtLegCuenLicPerFin_Internalname = sPrefix+"LEGCUENLICPERFIN" ;
      chkLegCuLIncluir.setInternalname( sPrefix+"LEGCULINCLUIR" );
      edtLegCuenDiasCorres_Internalname = sPrefix+"LEGCUENDIASCORRES" ;
      edtLegCuLiPAnt_Internalname = sPrefix+"LEGCULIPANT" ;
      edtLegCuLiPVen_Internalname = sPrefix+"LEGCULIPVEN" ;
      edtLegCuLiPCur_Internalname = sPrefix+"LEGCULIPCUR" ;
      edtLegCuLActVen_Internalname = sPrefix+"LEGCULACTVEN" ;
      edtLegCuLiPApr_Internalname = sPrefix+"LEGCULIPAPR" ;
      edtLegCuenDiasGoz_Internalname = sPrefix+"LEGCUENDIASGOZ" ;
      edtLegCuLiPSaldo_Internalname = sPrefix+"LEGCULIPSALDO" ;
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO" ;
      cmbLegCuenLicTpo.setInternalname( sPrefix+"LEGCUENLICTPO" );
      edtLegCuLRecalc_Internalname = sPrefix+"LEGCULRECALC" ;
      edtLegCuenAntDias_Internalname = sPrefix+"LEGCUENANTDIAS" ;
      edtLegCuenAntAnios_Internalname = sPrefix+"LEGCUENANTANIOS" ;
      edtLegCuenAntMeses_Internalname = sPrefix+"LEGCUENANTMESES" ;
      edtLegCueAntTexto_Internalname = sPrefix+"LEGCUEANTTEXTO" ;
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
      edtLegCueAntTexto_Visible = 1 ;
      edtLegCuenAntMeses_Jsonclick = "" ;
      edtLegCuenAntMeses_Visible = 1 ;
      edtLegCuenAntAnios_Jsonclick = "" ;
      edtLegCuenAntAnios_Visible = 1 ;
      edtLegCuenAntDias_Jsonclick = "" ;
      edtLegCuenAntDias_Visible = 1 ;
      edtLegCuLRecalc_Jsonclick = "" ;
      edtLegCuLRecalc_Visible = 1 ;
      cmbLegCuenLicTpo.setJsonclick( "" );
      cmbLegCuenLicTpo.setVisible( 1 );
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      edtLegCuLiPSaldo_Jsonclick = "" ;
      edtLegCuLiPSaldo_Enabled = 0 ;
      edtLegCuenDiasGoz_Jsonclick = "" ;
      edtLegCuenDiasGoz_Enabled = 0 ;
      edtLegCuLiPApr_Jsonclick = "" ;
      edtLegCuLiPApr_Enabled = 0 ;
      edtLegCuLActVen_Jsonclick = "" ;
      edtLegCuLActVen_Enabled = 0 ;
      edtLegCuLiPCur_Jsonclick = "" ;
      edtLegCuLiPCur_Enabled = 0 ;
      edtLegCuLiPVen_Jsonclick = "" ;
      edtLegCuLiPVen_Enabled = 0 ;
      edtLegCuLiPAnt_Jsonclick = "" ;
      edtLegCuLiPAnt_Enabled = 0 ;
      edtLegCuenDiasCorres_Jsonclick = "" ;
      edtLegCuenDiasCorres_Enabled = 0 ;
      chkLegCuLIncluir.setEnabled( 0 );
      edtLegCuenLicPerFin_Jsonclick = "" ;
      edtLegCuenLicPerFin_Enabled = 0 ;
      edtLegCuenLicPerIni_Jsonclick = "" ;
      edtLegCuenLicPerIni_Enabled = 0 ;
      edtLegCuenAnio_Jsonclick = "" ;
      edtLegCuenAnio_Enabled = 0 ;
      edtLegIdNomApe_Jsonclick = "" ;
      edtLegIdNomApe_Enabled = 0 ;
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
      chkLegCuLIncluir.setName( "LEGCULINCLUIR" );
      chkLegCuLIncluir.setWebtags( "" );
      chkLegCuLIncluir.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkLegCuLIncluir.getInternalname(), "TitleCaption", chkLegCuLIncluir.getCaption(), true);
      chkLegCuLIncluir.setCheckedValue( "false" );
      cmbLegCuenLicTpo.setName( "LEGCUENLICTPO" );
      cmbLegCuenLicTpo.setWebtags( "" );
      cmbLegCuenLicTpo.addItem("Vacaciones", httpContext.getMessage( "Vacaciones", ""), (short)(0));
      if ( cmbLegCuenLicTpo.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'cmbLegCuenLicTpo'},{av:'A2243LegCuenLicTpo',fld:'LEGCUENLICTPO',pic:''},{av:'A2266LegCuenAnio',fld:'LEGCUENANIO',pic:'ZZZ9'},{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11OW1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'cmbLegCuenLicTpo'},{av:'A2243LegCuenLicTpo',fld:'LEGCUENLICTPO',pic:''},{av:'A2266LegCuenAnio',fld:'LEGCUENANIO',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("VALID_LEGCUENANIO","{handler:'valid_Legcuenanio',iparms:[]");
      setEventMetadata("VALID_LEGCUENANIO",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_LEGCUENLICTPO","{handler:'valid_Legcuenlictpo',iparms:[]");
      setEventMetadata("VALID_LEGCUENLICTPO",",oparms:[]}");
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
      wcpOA2243LegCuenLicTpo = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A2243LegCuenLicTpo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A250LegIdNomApe = "" ;
      A2244LegCuenLicPerIni = GXutil.nullDate() ;
      A2245LegCuenLicPerFin = GXutil.nullDate() ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtnupdate_Jsonclick = "" ;
      A2301LegCueAntTexto = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      H00OW2_A3CliCod = new int[1] ;
      H00OW2_A1EmpCod = new short[1] ;
      H00OW2_A6LegNumero = new int[1] ;
      H00OW2_A2243LegCuenLicTpo = new String[] {""} ;
      H00OW2_A2266LegCuenAnio = new short[1] ;
      H00OW2_A2301LegCueAntTexto = new String[] {""} ;
      H00OW2_A2300LegCuenAntMeses = new short[1] ;
      H00OW2_A2299LegCuenAntAnios = new short[1] ;
      H00OW2_A2246LegCuenAntDias = new int[1] ;
      H00OW2_A2322LegCuLRecalc = new boolean[] {false} ;
      H00OW2_A2305LegCuLiPSaldo = new short[1] ;
      H00OW2_A2248LegCuenDiasGoz = new short[1] ;
      H00OW2_A2306LegCuLiPApr = new short[1] ;
      H00OW2_A2315LegCuLActVen = new short[1] ;
      H00OW2_A2302LegCuLiPCur = new short[1] ;
      H00OW2_A2304LegCuLiPVen = new short[1] ;
      H00OW2_A2303LegCuLiPAnt = new short[1] ;
      H00OW2_A2247LegCuenDiasCorres = new short[1] ;
      H00OW2_A2321LegCuLIncluir = new boolean[] {false} ;
      H00OW2_A2245LegCuenLicPerFin = new java.util.Date[] {GXutil.nullDate()} ;
      H00OW2_A2244LegCuenLicPerIni = new java.util.Date[] {GXutil.nullDate()} ;
      H00OW2_A250LegIdNomApe = new String[] {""} ;
      H00OW3_A250LegIdNomApe = new String[] {""} ;
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
      sCtrlA6LegNumero = "" ;
      sCtrlA2243LegCuenLicTpo = "" ;
      sCtrlA2266LegCuenAnio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_cuenta_licenciasgeneral__default(),
         new Object[] {
             new Object[] {
            H00OW2_A3CliCod, H00OW2_A1EmpCod, H00OW2_A6LegNumero, H00OW2_A2243LegCuenLicTpo, H00OW2_A2266LegCuenAnio, H00OW2_A2301LegCueAntTexto, H00OW2_A2300LegCuenAntMeses, H00OW2_A2299LegCuenAntAnios, H00OW2_A2246LegCuenAntDias, H00OW2_A2322LegCuLRecalc,
            H00OW2_A2305LegCuLiPSaldo, H00OW2_A2248LegCuenDiasGoz, H00OW2_A2306LegCuLiPApr, H00OW2_A2315LegCuLActVen, H00OW2_A2302LegCuLiPCur, H00OW2_A2304LegCuLiPVen, H00OW2_A2303LegCuLiPAnt, H00OW2_A2247LegCuenDiasCorres, H00OW2_A2321LegCuLIncluir, H00OW2_A2245LegCuenLicPerFin,
            H00OW2_A2244LegCuenLicPerIni, H00OW2_A250LegIdNomApe
            }
            , new Object[] {
            H00OW3_A250LegIdNomApe
            }
         }
      );
      AV17Pgmname = "legajo_cuenta_licenciasGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "legajo_cuenta_licenciasGeneral" ;
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
   private short wcpOA2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2266LegCuenAnio ;
   private short wbEnd ;
   private short wbStart ;
   private short A2247LegCuenDiasCorres ;
   private short A2303LegCuLiPAnt ;
   private short A2304LegCuLiPVen ;
   private short A2302LegCuLiPCur ;
   private short A2315LegCuLActVen ;
   private short A2306LegCuLiPApr ;
   private short A2248LegCuenDiasGoz ;
   private short A2305LegCuLiPSaldo ;
   private short A2299LegCuenAntAnios ;
   private short A2300LegCuenAntMeses ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int wcpOA6LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int edtLegIdNomApe_Enabled ;
   private int edtLegCuenAnio_Enabled ;
   private int edtLegCuenLicPerIni_Enabled ;
   private int edtLegCuenLicPerFin_Enabled ;
   private int edtLegCuenDiasCorres_Enabled ;
   private int edtLegCuLiPAnt_Enabled ;
   private int edtLegCuLiPVen_Enabled ;
   private int edtLegCuLiPCur_Enabled ;
   private int edtLegCuLActVen_Enabled ;
   private int edtLegCuLiPApr_Enabled ;
   private int edtLegCuenDiasGoz_Enabled ;
   private int edtLegCuLiPSaldo_Enabled ;
   private int bttBtnupdate_Visible ;
   private int edtCliCod_Visible ;
   private int edtEmpCod_Visible ;
   private int edtLegNumero_Visible ;
   private int edtLegCuLRecalc_Visible ;
   private int A2246LegCuenAntDias ;
   private int edtLegCuenAntDias_Visible ;
   private int edtLegCuenAntAnios_Visible ;
   private int edtLegCuenAntMeses_Visible ;
   private int edtLegCueAntTexto_Visible ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String wcpOA2243LegCuenLicTpo ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A2243LegCuenLicTpo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtLegIdNomApe_Internalname ;
   private String edtLegIdNomApe_Jsonclick ;
   private String edtLegCuenAnio_Internalname ;
   private String edtLegCuenAnio_Jsonclick ;
   private String edtLegCuenLicPerIni_Internalname ;
   private String edtLegCuenLicPerIni_Jsonclick ;
   private String edtLegCuenLicPerFin_Internalname ;
   private String edtLegCuenLicPerFin_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtLegCuenDiasCorres_Internalname ;
   private String edtLegCuenDiasCorres_Jsonclick ;
   private String edtLegCuLiPAnt_Internalname ;
   private String edtLegCuLiPAnt_Jsonclick ;
   private String edtLegCuLiPVen_Internalname ;
   private String edtLegCuLiPVen_Jsonclick ;
   private String edtLegCuLiPCur_Internalname ;
   private String edtLegCuLiPCur_Jsonclick ;
   private String edtLegCuLActVen_Internalname ;
   private String edtLegCuLActVen_Jsonclick ;
   private String edtLegCuLiPApr_Internalname ;
   private String edtLegCuLiPApr_Jsonclick ;
   private String edtLegCuenDiasGoz_Internalname ;
   private String edtLegCuenDiasGoz_Jsonclick ;
   private String edtLegCuLiPSaldo_Internalname ;
   private String edtLegCuLiPSaldo_Jsonclick ;
   private String TempTags ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegCuLRecalc_Internalname ;
   private String edtLegCuLRecalc_Jsonclick ;
   private String edtLegCuenAntDias_Internalname ;
   private String edtLegCuenAntDias_Jsonclick ;
   private String edtLegCuenAntAnios_Internalname ;
   private String edtLegCuenAntAnios_Jsonclick ;
   private String edtLegCuenAntMeses_Internalname ;
   private String edtLegCuenAntMeses_Jsonclick ;
   private String edtLegCueAntTexto_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1EmpCod ;
   private String sCtrlA6LegNumero ;
   private String sCtrlA2243LegCuenLicTpo ;
   private String sCtrlA2266LegCuenAnio ;
   private java.util.Date A2244LegCuenLicPerIni ;
   private java.util.Date A2245LegCuenLicPerFin ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A2321LegCuLIncluir ;
   private boolean A2322LegCuLRecalc ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A2301LegCueAntTexto ;
   private String A250LegIdNomApe ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private ICheckbox chkLegCuLIncluir ;
   private HTMLChoice cmbLegCuenLicTpo ;
   private IDataStoreProvider pr_default ;
   private int[] H00OW2_A3CliCod ;
   private short[] H00OW2_A1EmpCod ;
   private int[] H00OW2_A6LegNumero ;
   private String[] H00OW2_A2243LegCuenLicTpo ;
   private short[] H00OW2_A2266LegCuenAnio ;
   private String[] H00OW2_A2301LegCueAntTexto ;
   private short[] H00OW2_A2300LegCuenAntMeses ;
   private short[] H00OW2_A2299LegCuenAntAnios ;
   private int[] H00OW2_A2246LegCuenAntDias ;
   private boolean[] H00OW2_A2322LegCuLRecalc ;
   private short[] H00OW2_A2305LegCuLiPSaldo ;
   private short[] H00OW2_A2248LegCuenDiasGoz ;
   private short[] H00OW2_A2306LegCuLiPApr ;
   private short[] H00OW2_A2315LegCuLActVen ;
   private short[] H00OW2_A2302LegCuLiPCur ;
   private short[] H00OW2_A2304LegCuLiPVen ;
   private short[] H00OW2_A2303LegCuLiPAnt ;
   private short[] H00OW2_A2247LegCuenDiasCorres ;
   private boolean[] H00OW2_A2321LegCuLIncluir ;
   private java.util.Date[] H00OW2_A2245LegCuenLicPerFin ;
   private java.util.Date[] H00OW2_A2244LegCuenLicPerIni ;
   private String[] H00OW2_A250LegIdNomApe ;
   private String[] H00OW3_A250LegIdNomApe ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class legajo_cuenta_licenciasgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00OW2", "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegCuenLicTpo, T1.LegCuenAnio, T1.LegCueAntTexto, T1.LegCuenAntMeses, T1.LegCuenAntAnios, T1.LegCuenAntDias, T1.LegCuLRecalc, T1.LegCuLiPSaldo, T1.LegCuenDiasGoz, T1.LegCuLiPApr, T1.LegCuLActVen, T1.LegCuLiPCur, T1.LegCuLiPVen, T1.LegCuLiPAnt, T1.LegCuenDiasCorres, T1.LegCuLIncluir, T1.LegCuenLicPerFin, T1.LegCuenLicPerIni, T2.LegIdNomApe FROM (legajo_cuenta_licencias T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.LegCuenLicTpo = ( ?) and T1.LegCuenAnio = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegCuenLicTpo, T1.LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00OW3", "SELECT LegIdNomApe FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(20);
               ((java.util.Date[]) buf[20])[0] = rslt.getGXDate(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

