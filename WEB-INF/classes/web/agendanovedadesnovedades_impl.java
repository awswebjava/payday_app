package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class agendanovedadesnovedades_impl extends GXWebComponent
{
   public agendanovedadesnovedades_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public agendanovedadesnovedades_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( agendanovedadesnovedades_impl.class ));
   }

   public agendanovedadesnovedades_impl( int remoteHandle ,
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
               A25AgeOrden = (short)(GXutil.lval( httpContext.GetPar( "AgeOrden"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1EmpCod),Integer.valueOf(A6LegNumero),Short.valueOf(A25AgeOrden)});
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
         pa622( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Agenda Novedades Novedades", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.agendanovedadesnovedades", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A25AgeOrden,4,0))}, new String[] {"CliCod","EmpCod","LegNumero","AgeOrden"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA25AgeOrden", GXutil.ltrim( localUtil.ntoc( wcpOA25AgeOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AGEORDEN", GXutil.ltrim( localUtil.ntoc( A25AgeOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseForm622( )
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
      return "AgendaNovedadesNovedades" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Agenda Novedades Novedades", "") ;
   }

   public void wb620( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.agendanovedadesnovedades");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegNumero_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLegNumero_Internalname, httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_AgendaNovedadesNovedades.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_AgendaNovedadesNovedades.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAgeCanti_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtAgeCanti_Internalname, httpContext.getMessage( "Cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtAgeCanti_Internalname, GXutil.ltrim( localUtil.ntoc( A110AgeCanti, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAgeCanti_Enabled!=0) ? localUtil.format( A110AgeCanti, "ZZZZZ9.99") : localUtil.format( A110AgeCanti, "ZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAgeCanti_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAgeCanti_Enabled, 0, "text", "", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_AgendaNovedadesNovedades.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedageimporte_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockageimporte_Internalname, httpContext.getMessage( "Importe", ""), "", "", lblTextblockageimporte_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_AgendaNovedadesNovedades.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table1_32_622( true) ;
      }
      else
      {
         wb_table1_32_622( false) ;
      }
      return  ;
   }

   public void wb_table1_32_622e( boolean wbgen )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAgeFecDes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtAgeFecDes_Internalname, httpContext.getMessage( "Desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtAgeFecDes_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtAgeFecDes_Internalname, localUtil.format(A111AgeFecDes, "99/99/9999"), localUtil.format( A111AgeFecDes, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAgeFecDes_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAgeFecDes_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_AgendaNovedadesNovedades.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtAgeFecDes_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtAgeFecDes_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_AgendaNovedadesNovedades.htm");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAgeFecHas_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtAgeFecHas_Internalname, httpContext.getMessage( "Hasta", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtAgeFecHas_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtAgeFecHas_Internalname, localUtil.format(A112AgeFecHas, "99/99/9999"), localUtil.format( A112AgeFecHas, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAgeFecHas_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAgeFecHas_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_AgendaNovedadesNovedades.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtAgeFecHas_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtAgeFecHas_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_AgendaNovedadesNovedades.htm");
         httpContext.writeTextNL( "</div>") ;
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11621_client"+"'", TempTags, "", 2, "HLP_AgendaNovedadesNovedades.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12621_client"+"'", TempTags, "", 2, "HLP_AgendaNovedadesNovedades.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_AgendaNovedadesNovedades.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_AgendaNovedadesNovedades.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtAgeVUnit_Internalname, GXutil.ltrim( localUtil.ntoc( A115AgeVUnit, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( A115AgeVUnit, "ZZ,ZZZ,ZZZ,ZZ9.99")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAgeVUnit_Jsonclick, 0, "Attribute", "", "", "", "", edtAgeVUnit_Visible, 0, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_AgendaNovedadesNovedades.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start622( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Agenda Novedades Novedades", ""), (short)(0)) ;
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
            strup620( ) ;
         }
      }
   }

   public void ws622( )
   {
      start622( ) ;
      evt622( ) ;
   }

   public void evt622( )
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
                              strup620( ) ;
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
                              strup620( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13622 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup620( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14622 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup620( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15622 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup620( ) ;
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
                              strup620( ) ;
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

   public void we622( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm622( ) ;
         }
      }
   }

   public void pa622( )
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf622( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "AgendaNovedadesNovedades" ;
      Gx_err = (short)(0) ;
   }

   public void rf622( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15622 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00622 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A115AgeVUnit = H00622_A115AgeVUnit[0] ;
            n115AgeVUnit = H00622_n115AgeVUnit[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A115AgeVUnit", GXutil.ltrimstr( A115AgeVUnit, 14, 2));
            A112AgeFecHas = H00622_A112AgeFecHas[0] ;
            n112AgeFecHas = H00622_n112AgeFecHas[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
            A111AgeFecDes = H00622_A111AgeFecDes[0] ;
            n111AgeFecDes = H00622_n111AgeFecDes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
            A113AgeImporte = H00622_A113AgeImporte[0] ;
            n113AgeImporte = H00622_n113AgeImporte[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A113AgeImporte", GXutil.ltrimstr( A113AgeImporte, 14, 2));
            A110AgeCanti = H00622_A110AgeCanti[0] ;
            n110AgeCanti = H00622_n110AgeCanti[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
            A26ConCodigo = H00622_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
            /* Execute user event: Load */
            e14622 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb620( ) ;
      }
   }

   public void send_integrity_lvl_hashes622( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "AgendaNovedadesNovedades" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup620( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13622 ();
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
         wcpOA25AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA25AgeOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A25AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AGEORDEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
         A110AgeCanti = localUtil.ctond( httpContext.cgiGet( edtAgeCanti_Internalname)) ;
         n110AgeCanti = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
         A113AgeImporte = localUtil.ctond( httpContext.cgiGet( edtAgeImporte_Internalname)) ;
         n113AgeImporte = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A113AgeImporte", GXutil.ltrimstr( A113AgeImporte, 14, 2));
         A111AgeFecDes = localUtil.ctod( httpContext.cgiGet( edtAgeFecDes_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         n111AgeFecDes = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
         A112AgeFecHas = localUtil.ctod( httpContext.cgiGet( edtAgeFecHas_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         n112AgeFecHas = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
         A115AgeVUnit = localUtil.ctond( httpContext.cgiGet( edtAgeVUnit_Internalname)) ;
         n115AgeVUnit = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A115AgeVUnit", GXutil.ltrimstr( A115AgeVUnit, 14, 2));
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
      e13622 ();
      if (returnInSub) return;
   }

   public void e13622( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      agendanovedadesnovedades_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14622( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtAgeVUnit_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAgeVUnit_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeVUnit_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades_Update", GXv_boolean5) ;
      agendanovedadesnovedades_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades_Delete", GXv_boolean5) ;
      agendanovedadesnovedades_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Novedades" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15622( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      agendanovedadesnovedades_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   public void wb_table1_32_622( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedageimporte_Internalname, tblTablemergedageimporte_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtAgeImporte_Internalname, httpContext.getMessage( "Importe", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtAgeImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A113AgeImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAgeImporte_Enabled!=0) ? localUtil.format( A113AgeImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A113AgeImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAgeImporte_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAgeImporte_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_AgendaNovedadesNovedades.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblAgeimporte_righttext_Internalname, httpContext.getMessage( "Si ingresa valor en importe, se sobreescribirá la fórmula con este valor", ""), "", "", lblAgeimporte_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_AgendaNovedadesNovedades.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_32_622e( true) ;
      }
      else
      {
         wb_table1_32_622e( false) ;
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
      A25AgeOrden = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
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
      pa622( ) ;
      ws622( ) ;
      we622( ) ;
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
      sCtrlA25AgeOrden = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa622( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "agendanovedadesnovedades", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa622( ) ;
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
         A25AgeOrden = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA25AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA25AgeOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1EmpCod != wcpOA1EmpCod ) || ( A6LegNumero != wcpOA6LegNumero ) || ( A25AgeOrden != wcpOA25AgeOrden ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1EmpCod = A1EmpCod ;
      wcpOA6LegNumero = A6LegNumero ;
      wcpOA25AgeOrden = A25AgeOrden ;
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
      sCtrlA25AgeOrden = httpContext.cgiGet( sPrefix+"A25AgeOrden_CTRL") ;
      if ( GXutil.len( sCtrlA25AgeOrden) > 0 )
      {
         A25AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA25AgeOrden), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
      }
      else
      {
         A25AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A25AgeOrden_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      pa622( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws622( ) ;
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
      ws622( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A25AgeOrden_PARM", GXutil.ltrim( localUtil.ntoc( A25AgeOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA25AgeOrden)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A25AgeOrden_CTRL", GXutil.rtrim( sCtrlA25AgeOrden));
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
      we622( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019403116", true, true);
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
      httpContext.AddJavascriptSource("agendanovedadesnovedades.js", "?2024122019403116", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO" ;
      edtConCodigo_Internalname = sPrefix+"CONCODIGO" ;
      edtAgeCanti_Internalname = sPrefix+"AGECANTI" ;
      lblTextblockageimporte_Internalname = sPrefix+"TEXTBLOCKAGEIMPORTE" ;
      edtAgeImporte_Internalname = sPrefix+"AGEIMPORTE" ;
      lblAgeimporte_righttext_Internalname = sPrefix+"AGEIMPORTE_RIGHTTEXT" ;
      tblTablemergedageimporte_Internalname = sPrefix+"TABLEMERGEDAGEIMPORTE" ;
      divTablesplittedageimporte_Internalname = sPrefix+"TABLESPLITTEDAGEIMPORTE" ;
      edtAgeFecDes_Internalname = sPrefix+"AGEFECDES" ;
      edtAgeFecHas_Internalname = sPrefix+"AGEFECHAS" ;
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtAgeVUnit_Internalname = sPrefix+"AGEVUNIT" ;
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
      edtAgeImporte_Jsonclick = "" ;
      edtAgeImporte_Enabled = 0 ;
      edtAgeVUnit_Jsonclick = "" ;
      edtAgeVUnit_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      edtAgeFecHas_Jsonclick = "" ;
      edtAgeFecHas_Enabled = 0 ;
      edtAgeFecDes_Jsonclick = "" ;
      edtAgeFecDes_Enabled = 0 ;
      edtAgeCanti_Jsonclick = "" ;
      edtAgeCanti_Enabled = 0 ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Enabled = 0 ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 0 ;
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
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A25AgeOrden',fld:'AGEORDEN',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11621',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A25AgeOrden',fld:'AGEORDEN',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12621',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A25AgeOrden',fld:'AGEORDEN',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
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
      GX_FocusControl = "" ;
      A26ConCodigo = "" ;
      A110AgeCanti = DecimalUtil.ZERO ;
      lblTextblockageimporte_Jsonclick = "" ;
      A111AgeFecDes = GXutil.nullDate() ;
      A112AgeFecHas = GXutil.nullDate() ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      A115AgeVUnit = DecimalUtil.ZERO ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      H00622_A3CliCod = new int[1] ;
      H00622_A1EmpCod = new short[1] ;
      H00622_A6LegNumero = new int[1] ;
      H00622_A25AgeOrden = new short[1] ;
      H00622_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00622_n115AgeVUnit = new boolean[] {false} ;
      H00622_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      H00622_n112AgeFecHas = new boolean[] {false} ;
      H00622_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      H00622_n111AgeFecDes = new boolean[] {false} ;
      H00622_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00622_n113AgeImporte = new boolean[] {false} ;
      H00622_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00622_n110AgeCanti = new boolean[] {false} ;
      H00622_A26ConCodigo = new String[] {""} ;
      A113AgeImporte = DecimalUtil.ZERO ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      sStyleString = "" ;
      lblAgeimporte_righttext_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1EmpCod = "" ;
      sCtrlA6LegNumero = "" ;
      sCtrlA25AgeOrden = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.agendanovedadesnovedades__default(),
         new Object[] {
             new Object[] {
            H00622_A3CliCod, H00622_A1EmpCod, H00622_A6LegNumero, H00622_A25AgeOrden, H00622_A115AgeVUnit, H00622_n115AgeVUnit, H00622_A112AgeFecHas, H00622_n112AgeFecHas, H00622_A111AgeFecDes, H00622_n111AgeFecDes,
            H00622_A113AgeImporte, H00622_n113AgeImporte, H00622_A110AgeCanti, H00622_n110AgeCanti, H00622_A26ConCodigo
            }
         }
      );
      AV17Pgmname = "AgendaNovedadesNovedades" ;
      /* GeneXus formulas. */
      AV17Pgmname = "AgendaNovedadesNovedades" ;
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
   private short wcpOA25AgeOrden ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int wcpOA6LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int edtLegNumero_Enabled ;
   private int edtConCodigo_Enabled ;
   private int edtAgeCanti_Enabled ;
   private int edtAgeFecDes_Enabled ;
   private int edtAgeFecHas_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtEmpCod_Visible ;
   private int edtAgeVUnit_Visible ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtAgeImporte_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal A110AgeCanti ;
   private java.math.BigDecimal A115AgeVUnit ;
   private java.math.BigDecimal A113AgeImporte ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtConCodigo_Internalname ;
   private String A26ConCodigo ;
   private String edtConCodigo_Jsonclick ;
   private String edtAgeCanti_Internalname ;
   private String edtAgeCanti_Jsonclick ;
   private String divTablesplittedageimporte_Internalname ;
   private String lblTextblockageimporte_Internalname ;
   private String lblTextblockageimporte_Jsonclick ;
   private String edtAgeFecDes_Internalname ;
   private String edtAgeFecDes_Jsonclick ;
   private String edtAgeFecHas_Internalname ;
   private String edtAgeFecHas_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtAgeVUnit_Internalname ;
   private String edtAgeVUnit_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String edtAgeImporte_Internalname ;
   private String sStyleString ;
   private String tblTablemergedageimporte_Internalname ;
   private String edtAgeImporte_Jsonclick ;
   private String lblAgeimporte_righttext_Internalname ;
   private String lblAgeimporte_righttext_Jsonclick ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1EmpCod ;
   private String sCtrlA6LegNumero ;
   private String sCtrlA25AgeOrden ;
   private java.util.Date A111AgeFecDes ;
   private java.util.Date A112AgeFecHas ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n115AgeVUnit ;
   private boolean n112AgeFecHas ;
   private boolean n111AgeFecDes ;
   private boolean n113AgeImporte ;
   private boolean n110AgeCanti ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private IDataStoreProvider pr_default ;
   private int[] H00622_A3CliCod ;
   private short[] H00622_A1EmpCod ;
   private int[] H00622_A6LegNumero ;
   private short[] H00622_A25AgeOrden ;
   private java.math.BigDecimal[] H00622_A115AgeVUnit ;
   private boolean[] H00622_n115AgeVUnit ;
   private java.util.Date[] H00622_A112AgeFecHas ;
   private boolean[] H00622_n112AgeFecHas ;
   private java.util.Date[] H00622_A111AgeFecDes ;
   private boolean[] H00622_n111AgeFecDes ;
   private java.math.BigDecimal[] H00622_A113AgeImporte ;
   private boolean[] H00622_n113AgeImporte ;
   private java.math.BigDecimal[] H00622_A110AgeCanti ;
   private boolean[] H00622_n110AgeCanti ;
   private String[] H00622_A26ConCodigo ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class agendanovedadesnovedades__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00622", "SELECT CliCod, EmpCod, LegNumero, AgeOrden, AgeVUnit, AgeFecHas, AgeFecDes, AgeImporte, AgeCanti, ConCodigo FROM AgendaNovedades WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and AgeOrden = ? ORDER BY CliCod, EmpCod, LegNumero, AgeOrden ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(10, 10);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

