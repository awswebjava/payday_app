package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class lsd_reg4general_impl extends GXWebComponent
{
   public lsd_reg4general_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public lsd_reg4general_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lsd_reg4general_impl.class ));
   }

   public lsd_reg4general_impl( int remoteHandle ,
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
               A1649LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
               A1657LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
               A1674LSD4Sec = (short)(GXutil.lval( httpContext.GetPar( "LSD4Sec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1EmpCod),Integer.valueOf(A1649LSDSec),Integer.valueOf(A1657LSD2Sec),Short.valueOf(A1674LSD4Sec)});
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
         paHL2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "LSD_reg4 General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.lsd_reg4general", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1649LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1657LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1674LSD4Sec,4,0))}, new String[] {"CliCod","EmpCod","LSDSec","LSD2Sec","LSD4Sec"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1649LSDSec", GXutil.ltrim( localUtil.ntoc( wcpOA1649LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1657LSD2Sec", GXutil.ltrim( localUtil.ntoc( wcpOA1657LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1674LSD4Sec", GXutil.ltrim( localUtil.ntoc( wcpOA1674LSD4Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormHL2( )
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
      return "LSD_reg4General" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "LSD_reg4 General", "") ;
   }

   public void wbHL0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.lsd_reg4general");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CUIL_3_11_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CUIL_3_11_Internalname, httpContext.getMessage( "CUIL", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CUIL_3_11_Internalname, GXutil.ltrim( localUtil.ntoc( A1675LSD4CUIL_3_11, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4CUIL_3_11_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CUIL_3_11_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CUIL_3_11_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4Conyuge_14_1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4Conyuge_14_1_Internalname, httpContext.getMessage( "Conyuge", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4Conyuge_14_1_Internalname, GXutil.rtrim( A1676LSD4Conyuge_14_1), GXutil.rtrim( localUtil.format( A1676LSD4Conyuge_14_1, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4Conyuge_14_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4Conyuge_14_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CantidadHijos_15_2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CantidadHijos_15_2_Internalname, httpContext.getMessage( "Hijos", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CantidadHijos_15_2_Internalname, GXutil.ltrim( localUtil.ntoc( A1677LSD4CantidadHijos_15_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4CantidadHijos_15_2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CantidadHijos_15_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CantidadHijos_15_2_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4MarcaCCT_17_1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4MarcaCCT_17_1_Internalname, httpContext.getMessage( "En convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4MarcaCCT_17_1_Internalname, GXutil.rtrim( A1678LSD4MarcaCCT_17_1), GXutil.rtrim( localUtil.format( A1678LSD4MarcaCCT_17_1, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4MarcaCCT_17_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4MarcaCCT_17_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4MarcaSCVO_18_1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4MarcaSCVO_18_1_Internalname, httpContext.getMessage( "SCVO", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4MarcaSCVO_18_1_Internalname, GXutil.rtrim( A1679LSD4MarcaSCVO_18_1), GXutil.rtrim( localUtil.format( A1679LSD4MarcaSCVO_18_1, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4MarcaSCVO_18_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4MarcaSCVO_18_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4MarcaReduccion_19_1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4MarcaReduccion_19_1_Internalname, httpContext.getMessage( "Reducc.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4MarcaReduccion_19_1_Internalname, GXutil.rtrim( A1680LSD4MarcaReduccion_19_1), GXutil.rtrim( localUtil.format( A1680LSD4MarcaReduccion_19_1, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4MarcaReduccion_19_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4MarcaReduccion_19_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4TipoEmpresa_20_1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4TipoEmpresa_20_1_Internalname, httpContext.getMessage( "Empl.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4TipoEmpresa_20_1_Internalname, GXutil.rtrim( A1681LSD4TipoEmpresa_20_1), GXutil.rtrim( localUtil.format( A1681LSD4TipoEmpresa_20_1, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4TipoEmpresa_20_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4TipoEmpresa_20_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4TipoOperacion_21_1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4TipoOperacion_21_1_Internalname, httpContext.getMessage( "Tipo Ope.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4TipoOperacion_21_1_Internalname, GXutil.rtrim( A1682LSD4TipoOperacion_21_1), GXutil.rtrim( localUtil.format( A1682LSD4TipoOperacion_21_1, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4TipoOperacion_21_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4TipoOperacion_21_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoSituacion_22_2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoSituacion_22_2_Internalname, httpContext.getMessage( "Situación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoSituacion_22_2_Internalname, GXutil.rtrim( A1683LSD4CodigoSituacion_22_2), GXutil.rtrim( localUtil.format( A1683LSD4CodigoSituacion_22_2, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoSituacion_22_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoSituacion_22_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoCondicion_24_2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoCondicion_24_2_Internalname, httpContext.getMessage( "Condición", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoCondicion_24_2_Internalname, GXutil.rtrim( A1684LSD4CodigoCondicion_24_2), GXutil.rtrim( localUtil.format( A1684LSD4CodigoCondicion_24_2, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoCondicion_24_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoCondicion_24_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoActividad_26_3_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoActividad_26_3_Internalname, httpContext.getMessage( "Actividad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoActividad_26_3_Internalname, GXutil.rtrim( A1685LSD4CodigoActividad_26_3), GXutil.rtrim( localUtil.format( A1685LSD4CodigoActividad_26_3, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoActividad_26_3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoActividad_26_3_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoModalidadContratacio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoModalidadContratacio_Internalname, httpContext.getMessage( "Modalidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoModalidadContratacio_Internalname, GXutil.rtrim( A1686LSD4CodigoModalidadContratacio), GXutil.rtrim( localUtil.format( A1686LSD4CodigoModalidadContratacio, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoModalidadContratacio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoModalidadContratacio_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoSiniestrado_32_2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoSiniestrado_32_2_Internalname, httpContext.getMessage( "Siniestrado", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoSiniestrado_32_2_Internalname, GXutil.rtrim( A1687LSD4CodigoSiniestrado_32_2), GXutil.rtrim( localUtil.format( A1687LSD4CodigoSiniestrado_32_2, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoSiniestrado_32_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoSiniestrado_32_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoLocalidad_34_2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoLocalidad_34_2_Internalname, httpContext.getMessage( "Zona", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoLocalidad_34_2_Internalname, GXutil.rtrim( A1688LSD4CodigoLocalidad_34_2), GXutil.rtrim( localUtil.format( A1688LSD4CodigoLocalidad_34_2, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoLocalidad_34_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoLocalidad_34_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4SituacionRevista1_36_2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4SituacionRevista1_36_2_Internalname, httpContext.getMessage( "Sit. 1", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4SituacionRevista1_36_2_Internalname, GXutil.rtrim( A1689LSD4SituacionRevista1_36_2), GXutil.rtrim( localUtil.format( A1689LSD4SituacionRevista1_36_2, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4SituacionRevista1_36_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4SituacionRevista1_36_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4DiaInicioSituacionRevista1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4DiaInicioSituacionRevista1_Internalname, httpContext.getMessage( "Sit. 1 ini.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4DiaInicioSituacionRevista1_Internalname, GXutil.rtrim( A1690LSD4DiaInicioSituacionRevista1), GXutil.rtrim( localUtil.format( A1690LSD4DiaInicioSituacionRevista1, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4DiaInicioSituacionRevista1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4DiaInicioSituacionRevista1_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4SituacionRevista2_40_2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4SituacionRevista2_40_2_Internalname, httpContext.getMessage( "Sit. 2", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4SituacionRevista2_40_2_Internalname, GXutil.rtrim( A1691LSD4SituacionRevista2_40_2), GXutil.rtrim( localUtil.format( A1691LSD4SituacionRevista2_40_2, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4SituacionRevista2_40_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4SituacionRevista2_40_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4DiaInicioSituacionRevista2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4DiaInicioSituacionRevista2_Internalname, httpContext.getMessage( "Sit. 2 ini.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4DiaInicioSituacionRevista2_Internalname, GXutil.rtrim( A1692LSD4DiaInicioSituacionRevista2), GXutil.rtrim( localUtil.format( A1692LSD4DiaInicioSituacionRevista2, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4DiaInicioSituacionRevista2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4DiaInicioSituacionRevista2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4SituacionRevista3_44_2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4SituacionRevista3_44_2_Internalname, httpContext.getMessage( "Sit. 3", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4SituacionRevista3_44_2_Internalname, GXutil.rtrim( A1693LSD4SituacionRevista3_44_2), GXutil.rtrim( localUtil.format( A1693LSD4SituacionRevista3_44_2, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4SituacionRevista3_44_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4SituacionRevista3_44_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4DiaInicioSituacionRevista3_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4DiaInicioSituacionRevista3_Internalname, httpContext.getMessage( "Sit. 3 ini.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4DiaInicioSituacionRevista3_Internalname, GXutil.rtrim( A1694LSD4DiaInicioSituacionRevista3), GXutil.rtrim( localUtil.format( A1694LSD4DiaInicioSituacionRevista3, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4DiaInicioSituacionRevista3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4DiaInicioSituacionRevista3_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CantidadDiasTrabajados_48__Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CantidadDiasTrabajados_48__Internalname, httpContext.getMessage( "Días trab.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CantidadDiasTrabajados_48__Internalname, GXutil.ltrim( localUtil.ntoc( A1695LSD4CantidadDiasTrabajados_48_, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4CantidadDiasTrabajados_48__Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CantidadDiasTrabajados_48__Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CantidadDiasTrabajados_48__Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4HorasTrabajadas_50_3_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4HorasTrabajadas_50_3_Internalname, httpContext.getMessage( "Horas trab.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4HorasTrabajadas_50_3_Internalname, GXutil.ltrim( localUtil.ntoc( A1696LSD4HorasTrabajadas_50_3, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4HorasTrabajadas_50_3_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4HorasTrabajadas_50_3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4HorasTrabajadas_50_3_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4PorcentajeAporteAdicionalS_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4PorcentajeAporteAdicionalS_Internalname, httpContext.getMessage( "Porc. adic. SS", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4PorcentajeAporteAdicionalS_Internalname, GXutil.ltrim( localUtil.ntoc( A1697LSD4PorcentajeAporteAdicionalS, (byte)(8), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4PorcentajeAporteAdicionalS_Enabled!=0) ? localUtil.format( A1697LSD4PorcentajeAporteAdicionalS, "ZZZZ9.99") : localUtil.format( A1697LSD4PorcentajeAporteAdicionalS, "ZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4PorcentajeAporteAdicionalS_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4PorcentajeAporteAdicionalS_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4ContribucionTareaDiferenci_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4ContribucionTareaDiferenci_Internalname, httpContext.getMessage( "Contr. tarea dif.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4ContribucionTareaDiferenci_Internalname, GXutil.ltrim( localUtil.ntoc( A1698LSD4ContribucionTareaDiferenci, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4ContribucionTareaDiferenci_Enabled!=0) ? localUtil.format( A1698LSD4ContribucionTareaDiferenci, "ZZ9.99") : localUtil.format( A1698LSD4ContribucionTareaDiferenci, "ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4ContribucionTareaDiferenci_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4ContribucionTareaDiferenci_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoObraSocial_63_6_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoObraSocial_63_6_Internalname, httpContext.getMessage( "Obra social", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoObraSocial_63_6_Internalname, GXutil.rtrim( A1699LSD4CodigoObraSocial_63_6), GXutil.rtrim( localUtil.format( A1699LSD4CodigoObraSocial_63_6, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoObraSocial_63_6_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoObraSocial_63_6_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CantidadAdherentes_69_2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4CantidadAdherentes_69_2_Internalname, httpContext.getMessage( "Adherentes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CantidadAdherentes_69_2_Internalname, GXutil.ltrim( localUtil.ntoc( A1700LSD4CantidadAdherentes_69_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4CantidadAdherentes_69_2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CantidadAdherentes_69_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CantidadAdherentes_69_2_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4AporteAdicionalOS_71_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4AporteAdicionalOS_71_15_Internalname, httpContext.getMessage( "Apo. adic. OS", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4AporteAdicionalOS_71_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1701LSD4AporteAdicionalOS_71_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4AporteAdicionalOS_71_15_Enabled!=0) ? localUtil.format( A1701LSD4AporteAdicionalOS_71_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1701LSD4AporteAdicionalOS_71_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4AporteAdicionalOS_71_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4AporteAdicionalOS_71_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4ContribucionAdicionalOS_86_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4ContribucionAdicionalOS_86_Internalname, httpContext.getMessage( "Contr. adic. OS", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4ContribucionAdicionalOS_86_Internalname, GXutil.ltrim( localUtil.ntoc( A1702LSD4ContribucionAdicionalOS_86, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4ContribucionAdicionalOS_86_Enabled!=0) ? localUtil.format( A1702LSD4ContribucionAdicionalOS_86, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1702LSD4ContribucionAdicionalOS_86, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4ContribucionAdicionalOS_86_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4ContribucionAdicionalOS_86_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseCalculoDiferencialApor_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseCalculoDiferencialApor_Internalname, httpContext.getMessage( "Base calc. dif. apo. OS y FSR", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseCalculoDiferencialApor_Internalname, GXutil.ltrim( localUtil.ntoc( A1703LSD4BaseCalculoDiferencialApor, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseCalculoDiferencialApor_Enabled!=0) ? localUtil.format( A1703LSD4BaseCalculoDiferencialApor, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1703LSD4BaseCalculoDiferencialApor, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseCalculoDiferencialApor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseCalculoDiferencialApor_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseCalculoDiferencialOSyF_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseCalculoDiferencialOSyF_Internalname, httpContext.getMessage( "Base calc. Dif. OS y FSR", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseCalculoDiferencialOSyF_Internalname, GXutil.ltrim( localUtil.ntoc( A1704LSD4BaseCalculoDiferencialOSyF, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseCalculoDiferencialOSyF_Enabled!=0) ? localUtil.format( A1704LSD4BaseCalculoDiferencialOSyF, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1704LSD4BaseCalculoDiferencialOSyF, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseCalculoDiferencialOSyF_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseCalculoDiferencialOSyF_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseCalculoDiferencialLRT__Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseCalculoDiferencialLRT__Internalname, httpContext.getMessage( "dif. LRT", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseCalculoDiferencialLRT__Internalname, GXutil.ltrim( localUtil.ntoc( A1705LSD4BaseCalculoDiferencialLRT_, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseCalculoDiferencialLRT__Enabled!=0) ? localUtil.format( A1705LSD4BaseCalculoDiferencialLRT_, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1705LSD4BaseCalculoDiferencialLRT_, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseCalculoDiferencialLRT__Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseCalculoDiferencialLRT__Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4RemuneracionMaternidadANSe_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4RemuneracionMaternidadANSe_Internalname, httpContext.getMessage( "Maternidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4RemuneracionMaternidadANSe_Internalname, GXutil.ltrim( localUtil.ntoc( A1706LSD4RemuneracionMaternidadANSe, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4RemuneracionMaternidadANSe_Enabled!=0) ? localUtil.format( A1706LSD4RemuneracionMaternidadANSe, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1706LSD4RemuneracionMaternidadANSe, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4RemuneracionMaternidadANSe_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4RemuneracionMaternidadANSe_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4RemuneracionBruta_161_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4RemuneracionBruta_161_15_Internalname, httpContext.getMessage( "Bruto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4RemuneracionBruta_161_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1707LSD4RemuneracionBruta_161_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4RemuneracionBruta_161_15_Enabled!=0) ? localUtil.format( A1707LSD4RemuneracionBruta_161_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1707LSD4RemuneracionBruta_161_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4RemuneracionBruta_161_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4RemuneracionBruta_161_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible1_176_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible1_176_15_Internalname, httpContext.getMessage( "Base imp. 1", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible1_176_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1708LSD4BaseImponible1_176_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible1_176_15_Enabled!=0) ? localUtil.format( A1708LSD4BaseImponible1_176_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1708LSD4BaseImponible1_176_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible1_176_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible1_176_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible2_191_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible2_191_15_Internalname, httpContext.getMessage( "Base imp. 2", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible2_191_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1709LSD4BaseImponible2_191_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible2_191_15_Enabled!=0) ? localUtil.format( A1709LSD4BaseImponible2_191_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1709LSD4BaseImponible2_191_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible2_191_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible2_191_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible3_206_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible3_206_15_Internalname, httpContext.getMessage( "Base imp. 3", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible3_206_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1710LSD4BaseImponible3_206_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible3_206_15_Enabled!=0) ? localUtil.format( A1710LSD4BaseImponible3_206_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1710LSD4BaseImponible3_206_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible3_206_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible3_206_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible4_221_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible4_221_15_Internalname, httpContext.getMessage( "Base imp. 4", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible4_221_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1711LSD4BaseImponible4_221_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible4_221_15_Enabled!=0) ? localUtil.format( A1711LSD4BaseImponible4_221_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1711LSD4BaseImponible4_221_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible4_221_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible4_221_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible5_236_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible5_236_15_Internalname, httpContext.getMessage( "Base imp. 5", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible5_236_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1712LSD4BaseImponible5_236_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible5_236_15_Enabled!=0) ? localUtil.format( A1712LSD4BaseImponible5_236_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1712LSD4BaseImponible5_236_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible5_236_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible5_236_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible6_251_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible6_251_15_Internalname, httpContext.getMessage( "Base imp. 6", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible6_251_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1713LSD4BaseImponible6_251_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible6_251_15_Enabled!=0) ? localUtil.format( A1713LSD4BaseImponible6_251_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1713LSD4BaseImponible6_251_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible6_251_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible6_251_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible7_266_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible7_266_15_Internalname, httpContext.getMessage( "Base imp. 7", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible7_266_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1714LSD4BaseImponible7_266_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible7_266_15_Enabled!=0) ? localUtil.format( A1714LSD4BaseImponible7_266_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1714LSD4BaseImponible7_266_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible7_266_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible7_266_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible8_281_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible8_281_15_Internalname, httpContext.getMessage( "Base imp. 8", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible8_281_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1715LSD4BaseImponible8_281_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible8_281_15_Enabled!=0) ? localUtil.format( A1715LSD4BaseImponible8_281_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1715LSD4BaseImponible8_281_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible8_281_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible8_281_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible9_296_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible9_296_15_Internalname, httpContext.getMessage( "Base imp. 9", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible9_296_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1716LSD4BaseImponible9_296_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible9_296_15_Enabled!=0) ? localUtil.format( A1716LSD4BaseImponible9_296_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1716LSD4BaseImponible9_296_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible9_296_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible9_296_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseDifApoSegSoc_311_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseDifApoSegSoc_311_15_Internalname, httpContext.getMessage( "Base dif. apo. SS", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseDifApoSegSoc_311_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1717LSD4BaseDifApoSegSoc_311_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseDifApoSegSoc_311_15_Enabled!=0) ? localUtil.format( A1717LSD4BaseDifApoSegSoc_311_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1717LSD4BaseDifApoSegSoc_311_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseDifApoSegSoc_311_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseDifApoSegSoc_311_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseDifContSegSoc_326_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseDifContSegSoc_326_15_Internalname, httpContext.getMessage( "Base dif. cont. SS", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseDifContSegSoc_326_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1718LSD4BaseDifContSegSoc_326_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseDifContSegSoc_326_15_Enabled!=0) ? localUtil.format( A1718LSD4BaseDifContSegSoc_326_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1718LSD4BaseDifContSegSoc_326_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseDifContSegSoc_326_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseDifContSegSoc_326_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible10_341_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible10_341_15_Internalname, httpContext.getMessage( "Base imp. 10", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible10_341_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1719LSD4BaseImponible10_341_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible10_341_15_Enabled!=0) ? localUtil.format( A1719LSD4BaseImponible10_341_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1719LSD4BaseImponible10_341_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible10_341_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible10_341_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4ImporteADetraer_356_15_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtLSD4ImporteADetraer_356_15_Internalname, httpContext.getMessage( "Importe a detraer", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4ImporteADetraer_356_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1720LSD4ImporteADetraer_356_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4ImporteADetraer_356_15_Enabled!=0) ? localUtil.format( A1720LSD4ImporteADetraer_356_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1720LSD4ImporteADetraer_356_15, "ZZZZZZZZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4ImporteADetraer_356_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4ImporteADetraer_356_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 244,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11hl1_client"+"'", TempTags, "", 2, "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 246,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12hl1_client"+"'", TempTags, "", 2, "HLP_LSD_reg4General.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LSD_reg4General.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSDSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1649LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSDSec_Jsonclick, 0, "Attribute", "", "", "", "", edtLSDSec_Visible, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2Sec_Internalname, GXutil.ltrim( localUtil.ntoc( A1657LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1657LSD2Sec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2Sec_Jsonclick, 0, "Attribute", "", "", "", "", edtLSD2Sec_Visible, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4Sec_Internalname, GXutil.ltrim( localUtil.ntoc( A1674LSD4Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1674LSD4Sec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4Sec_Jsonclick, 0, "Attribute", "", "", "", "", edtLSD4Sec_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4General.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startHL2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "LSD_reg4 General", ""), (short)(0)) ;
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
            strupHL0( ) ;
         }
      }
   }

   public void wsHL2( )
   {
      startHL2( ) ;
      evtHL2( ) ;
   }

   public void evtHL2( )
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
                              strupHL0( ) ;
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
                              strupHL0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13HL2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHL0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14HL2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHL0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15HL2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHL0( ) ;
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
                              strupHL0( ) ;
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

   public void weHL2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormHL2( ) ;
         }
      }
   }

   public void paHL2( )
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
      rfHL2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "LSD_reg4General" ;
      Gx_err = (short)(0) ;
   }

   public void rfHL2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15HL2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00HL2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1674LSD4Sec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1720LSD4ImporteADetraer_356_15 = H00HL2_A1720LSD4ImporteADetraer_356_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1720LSD4ImporteADetraer_356_15", GXutil.ltrimstr( A1720LSD4ImporteADetraer_356_15, 16, 2));
            A1719LSD4BaseImponible10_341_15 = H00HL2_A1719LSD4BaseImponible10_341_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1719LSD4BaseImponible10_341_15", GXutil.ltrimstr( A1719LSD4BaseImponible10_341_15, 16, 2));
            A1718LSD4BaseDifContSegSoc_326_15 = H00HL2_A1718LSD4BaseDifContSegSoc_326_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1718LSD4BaseDifContSegSoc_326_15", GXutil.ltrimstr( A1718LSD4BaseDifContSegSoc_326_15, 16, 2));
            A1717LSD4BaseDifApoSegSoc_311_15 = H00HL2_A1717LSD4BaseDifApoSegSoc_311_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1717LSD4BaseDifApoSegSoc_311_15", GXutil.ltrimstr( A1717LSD4BaseDifApoSegSoc_311_15, 16, 2));
            A1716LSD4BaseImponible9_296_15 = H00HL2_A1716LSD4BaseImponible9_296_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1716LSD4BaseImponible9_296_15", GXutil.ltrimstr( A1716LSD4BaseImponible9_296_15, 16, 2));
            A1715LSD4BaseImponible8_281_15 = H00HL2_A1715LSD4BaseImponible8_281_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1715LSD4BaseImponible8_281_15", GXutil.ltrimstr( A1715LSD4BaseImponible8_281_15, 16, 2));
            A1714LSD4BaseImponible7_266_15 = H00HL2_A1714LSD4BaseImponible7_266_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1714LSD4BaseImponible7_266_15", GXutil.ltrimstr( A1714LSD4BaseImponible7_266_15, 16, 2));
            A1713LSD4BaseImponible6_251_15 = H00HL2_A1713LSD4BaseImponible6_251_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1713LSD4BaseImponible6_251_15", GXutil.ltrimstr( A1713LSD4BaseImponible6_251_15, 16, 2));
            A1712LSD4BaseImponible5_236_15 = H00HL2_A1712LSD4BaseImponible5_236_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1712LSD4BaseImponible5_236_15", GXutil.ltrimstr( A1712LSD4BaseImponible5_236_15, 16, 2));
            A1711LSD4BaseImponible4_221_15 = H00HL2_A1711LSD4BaseImponible4_221_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1711LSD4BaseImponible4_221_15", GXutil.ltrimstr( A1711LSD4BaseImponible4_221_15, 16, 2));
            A1710LSD4BaseImponible3_206_15 = H00HL2_A1710LSD4BaseImponible3_206_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1710LSD4BaseImponible3_206_15", GXutil.ltrimstr( A1710LSD4BaseImponible3_206_15, 16, 2));
            A1709LSD4BaseImponible2_191_15 = H00HL2_A1709LSD4BaseImponible2_191_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1709LSD4BaseImponible2_191_15", GXutil.ltrimstr( A1709LSD4BaseImponible2_191_15, 16, 2));
            A1708LSD4BaseImponible1_176_15 = H00HL2_A1708LSD4BaseImponible1_176_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1708LSD4BaseImponible1_176_15", GXutil.ltrimstr( A1708LSD4BaseImponible1_176_15, 16, 2));
            A1707LSD4RemuneracionBruta_161_15 = H00HL2_A1707LSD4RemuneracionBruta_161_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1707LSD4RemuneracionBruta_161_15", GXutil.ltrimstr( A1707LSD4RemuneracionBruta_161_15, 16, 2));
            A1706LSD4RemuneracionMaternidadANSe = H00HL2_A1706LSD4RemuneracionMaternidadANSe[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1706LSD4RemuneracionMaternidadANSe", GXutil.ltrimstr( A1706LSD4RemuneracionMaternidadANSe, 16, 2));
            A1705LSD4BaseCalculoDiferencialLRT_ = H00HL2_A1705LSD4BaseCalculoDiferencialLRT_[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1705LSD4BaseCalculoDiferencialLRT_", GXutil.ltrimstr( A1705LSD4BaseCalculoDiferencialLRT_, 16, 2));
            A1704LSD4BaseCalculoDiferencialOSyF = H00HL2_A1704LSD4BaseCalculoDiferencialOSyF[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1704LSD4BaseCalculoDiferencialOSyF", GXutil.ltrimstr( A1704LSD4BaseCalculoDiferencialOSyF, 16, 2));
            A1703LSD4BaseCalculoDiferencialApor = H00HL2_A1703LSD4BaseCalculoDiferencialApor[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1703LSD4BaseCalculoDiferencialApor", GXutil.ltrimstr( A1703LSD4BaseCalculoDiferencialApor, 16, 2));
            A1702LSD4ContribucionAdicionalOS_86 = H00HL2_A1702LSD4ContribucionAdicionalOS_86[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1702LSD4ContribucionAdicionalOS_86", GXutil.ltrimstr( A1702LSD4ContribucionAdicionalOS_86, 16, 2));
            A1701LSD4AporteAdicionalOS_71_15 = H00HL2_A1701LSD4AporteAdicionalOS_71_15[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1701LSD4AporteAdicionalOS_71_15", GXutil.ltrimstr( A1701LSD4AporteAdicionalOS_71_15, 16, 2));
            A1700LSD4CantidadAdherentes_69_2 = H00HL2_A1700LSD4CantidadAdherentes_69_2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1700LSD4CantidadAdherentes_69_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), 2, 0));
            A1699LSD4CodigoObraSocial_63_6 = H00HL2_A1699LSD4CodigoObraSocial_63_6[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1699LSD4CodigoObraSocial_63_6", A1699LSD4CodigoObraSocial_63_6);
            A1698LSD4ContribucionTareaDiferenci = H00HL2_A1698LSD4ContribucionTareaDiferenci[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1698LSD4ContribucionTareaDiferenci", GXutil.ltrimstr( A1698LSD4ContribucionTareaDiferenci, 6, 2));
            A1697LSD4PorcentajeAporteAdicionalS = H00HL2_A1697LSD4PorcentajeAporteAdicionalS[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1697LSD4PorcentajeAporteAdicionalS", GXutil.ltrimstr( A1697LSD4PorcentajeAporteAdicionalS, 8, 2));
            A1696LSD4HorasTrabajadas_50_3 = H00HL2_A1696LSD4HorasTrabajadas_50_3[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1696LSD4HorasTrabajadas_50_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), 3, 0));
            A1695LSD4CantidadDiasTrabajados_48_ = H00HL2_A1695LSD4CantidadDiasTrabajados_48_[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1695LSD4CantidadDiasTrabajados_48_", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), 2, 0));
            A1694LSD4DiaInicioSituacionRevista3 = H00HL2_A1694LSD4DiaInicioSituacionRevista3[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1694LSD4DiaInicioSituacionRevista3", A1694LSD4DiaInicioSituacionRevista3);
            A1693LSD4SituacionRevista3_44_2 = H00HL2_A1693LSD4SituacionRevista3_44_2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1693LSD4SituacionRevista3_44_2", A1693LSD4SituacionRevista3_44_2);
            A1692LSD4DiaInicioSituacionRevista2 = H00HL2_A1692LSD4DiaInicioSituacionRevista2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1692LSD4DiaInicioSituacionRevista2", A1692LSD4DiaInicioSituacionRevista2);
            A1691LSD4SituacionRevista2_40_2 = H00HL2_A1691LSD4SituacionRevista2_40_2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1691LSD4SituacionRevista2_40_2", A1691LSD4SituacionRevista2_40_2);
            A1690LSD4DiaInicioSituacionRevista1 = H00HL2_A1690LSD4DiaInicioSituacionRevista1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1690LSD4DiaInicioSituacionRevista1", A1690LSD4DiaInicioSituacionRevista1);
            A1689LSD4SituacionRevista1_36_2 = H00HL2_A1689LSD4SituacionRevista1_36_2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1689LSD4SituacionRevista1_36_2", A1689LSD4SituacionRevista1_36_2);
            A1688LSD4CodigoLocalidad_34_2 = H00HL2_A1688LSD4CodigoLocalidad_34_2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1688LSD4CodigoLocalidad_34_2", A1688LSD4CodigoLocalidad_34_2);
            A1687LSD4CodigoSiniestrado_32_2 = H00HL2_A1687LSD4CodigoSiniestrado_32_2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1687LSD4CodigoSiniestrado_32_2", A1687LSD4CodigoSiniestrado_32_2);
            A1686LSD4CodigoModalidadContratacio = H00HL2_A1686LSD4CodigoModalidadContratacio[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1686LSD4CodigoModalidadContratacio", A1686LSD4CodigoModalidadContratacio);
            A1685LSD4CodigoActividad_26_3 = H00HL2_A1685LSD4CodigoActividad_26_3[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1685LSD4CodigoActividad_26_3", A1685LSD4CodigoActividad_26_3);
            A1684LSD4CodigoCondicion_24_2 = H00HL2_A1684LSD4CodigoCondicion_24_2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1684LSD4CodigoCondicion_24_2", A1684LSD4CodigoCondicion_24_2);
            A1683LSD4CodigoSituacion_22_2 = H00HL2_A1683LSD4CodigoSituacion_22_2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1683LSD4CodigoSituacion_22_2", A1683LSD4CodigoSituacion_22_2);
            A1682LSD4TipoOperacion_21_1 = H00HL2_A1682LSD4TipoOperacion_21_1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1682LSD4TipoOperacion_21_1", A1682LSD4TipoOperacion_21_1);
            A1681LSD4TipoEmpresa_20_1 = H00HL2_A1681LSD4TipoEmpresa_20_1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1681LSD4TipoEmpresa_20_1", A1681LSD4TipoEmpresa_20_1);
            A1680LSD4MarcaReduccion_19_1 = H00HL2_A1680LSD4MarcaReduccion_19_1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1680LSD4MarcaReduccion_19_1", A1680LSD4MarcaReduccion_19_1);
            A1679LSD4MarcaSCVO_18_1 = H00HL2_A1679LSD4MarcaSCVO_18_1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1679LSD4MarcaSCVO_18_1", A1679LSD4MarcaSCVO_18_1);
            A1678LSD4MarcaCCT_17_1 = H00HL2_A1678LSD4MarcaCCT_17_1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1678LSD4MarcaCCT_17_1", A1678LSD4MarcaCCT_17_1);
            A1677LSD4CantidadHijos_15_2 = H00HL2_A1677LSD4CantidadHijos_15_2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1677LSD4CantidadHijos_15_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), 2, 0));
            A1676LSD4Conyuge_14_1 = H00HL2_A1676LSD4Conyuge_14_1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1676LSD4Conyuge_14_1", A1676LSD4Conyuge_14_1);
            A1675LSD4CUIL_3_11 = H00HL2_A1675LSD4CUIL_3_11[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1675LSD4CUIL_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), 11, 0));
            /* Execute user event: Load */
            e14HL2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wbHL0( ) ;
      }
   }

   public void send_integrity_lvl_hashesHL2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "LSD_reg4General" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupHL0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13HL2 ();
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
         wcpOA1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1649LSDSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1657LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1657LSD2Sec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1674LSD4Sec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1674LSD4Sec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A1675LSD4CUIL_3_11 = localUtil.ctol( httpContext.cgiGet( edtLSD4CUIL_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1675LSD4CUIL_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), 11, 0));
         A1676LSD4Conyuge_14_1 = httpContext.cgiGet( edtLSD4Conyuge_14_1_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1676LSD4Conyuge_14_1", A1676LSD4Conyuge_14_1);
         A1677LSD4CantidadHijos_15_2 = (byte)(localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadHijos_15_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1677LSD4CantidadHijos_15_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), 2, 0));
         A1678LSD4MarcaCCT_17_1 = httpContext.cgiGet( edtLSD4MarcaCCT_17_1_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1678LSD4MarcaCCT_17_1", A1678LSD4MarcaCCT_17_1);
         A1679LSD4MarcaSCVO_18_1 = httpContext.cgiGet( edtLSD4MarcaSCVO_18_1_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1679LSD4MarcaSCVO_18_1", A1679LSD4MarcaSCVO_18_1);
         A1680LSD4MarcaReduccion_19_1 = httpContext.cgiGet( edtLSD4MarcaReduccion_19_1_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1680LSD4MarcaReduccion_19_1", A1680LSD4MarcaReduccion_19_1);
         A1681LSD4TipoEmpresa_20_1 = httpContext.cgiGet( edtLSD4TipoEmpresa_20_1_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1681LSD4TipoEmpresa_20_1", A1681LSD4TipoEmpresa_20_1);
         A1682LSD4TipoOperacion_21_1 = httpContext.cgiGet( edtLSD4TipoOperacion_21_1_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1682LSD4TipoOperacion_21_1", A1682LSD4TipoOperacion_21_1);
         A1683LSD4CodigoSituacion_22_2 = httpContext.cgiGet( edtLSD4CodigoSituacion_22_2_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1683LSD4CodigoSituacion_22_2", A1683LSD4CodigoSituacion_22_2);
         A1684LSD4CodigoCondicion_24_2 = httpContext.cgiGet( edtLSD4CodigoCondicion_24_2_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1684LSD4CodigoCondicion_24_2", A1684LSD4CodigoCondicion_24_2);
         A1685LSD4CodigoActividad_26_3 = httpContext.cgiGet( edtLSD4CodigoActividad_26_3_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1685LSD4CodigoActividad_26_3", A1685LSD4CodigoActividad_26_3);
         A1686LSD4CodigoModalidadContratacio = httpContext.cgiGet( edtLSD4CodigoModalidadContratacio_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1686LSD4CodigoModalidadContratacio", A1686LSD4CodigoModalidadContratacio);
         A1687LSD4CodigoSiniestrado_32_2 = httpContext.cgiGet( edtLSD4CodigoSiniestrado_32_2_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1687LSD4CodigoSiniestrado_32_2", A1687LSD4CodigoSiniestrado_32_2);
         A1688LSD4CodigoLocalidad_34_2 = httpContext.cgiGet( edtLSD4CodigoLocalidad_34_2_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1688LSD4CodigoLocalidad_34_2", A1688LSD4CodigoLocalidad_34_2);
         A1689LSD4SituacionRevista1_36_2 = httpContext.cgiGet( edtLSD4SituacionRevista1_36_2_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1689LSD4SituacionRevista1_36_2", A1689LSD4SituacionRevista1_36_2);
         A1690LSD4DiaInicioSituacionRevista1 = httpContext.cgiGet( edtLSD4DiaInicioSituacionRevista1_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1690LSD4DiaInicioSituacionRevista1", A1690LSD4DiaInicioSituacionRevista1);
         A1691LSD4SituacionRevista2_40_2 = httpContext.cgiGet( edtLSD4SituacionRevista2_40_2_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1691LSD4SituacionRevista2_40_2", A1691LSD4SituacionRevista2_40_2);
         A1692LSD4DiaInicioSituacionRevista2 = httpContext.cgiGet( edtLSD4DiaInicioSituacionRevista2_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1692LSD4DiaInicioSituacionRevista2", A1692LSD4DiaInicioSituacionRevista2);
         A1693LSD4SituacionRevista3_44_2 = httpContext.cgiGet( edtLSD4SituacionRevista3_44_2_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1693LSD4SituacionRevista3_44_2", A1693LSD4SituacionRevista3_44_2);
         A1694LSD4DiaInicioSituacionRevista3 = httpContext.cgiGet( edtLSD4DiaInicioSituacionRevista3_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1694LSD4DiaInicioSituacionRevista3", A1694LSD4DiaInicioSituacionRevista3);
         A1695LSD4CantidadDiasTrabajados_48_ = (byte)(localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadDiasTrabajados_48__Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1695LSD4CantidadDiasTrabajados_48_", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), 2, 0));
         A1696LSD4HorasTrabajadas_50_3 = (short)(localUtil.ctol( httpContext.cgiGet( edtLSD4HorasTrabajadas_50_3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1696LSD4HorasTrabajadas_50_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), 3, 0));
         A1697LSD4PorcentajeAporteAdicionalS = localUtil.ctond( httpContext.cgiGet( edtLSD4PorcentajeAporteAdicionalS_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1697LSD4PorcentajeAporteAdicionalS", GXutil.ltrimstr( A1697LSD4PorcentajeAporteAdicionalS, 8, 2));
         A1698LSD4ContribucionTareaDiferenci = localUtil.ctond( httpContext.cgiGet( edtLSD4ContribucionTareaDiferenci_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1698LSD4ContribucionTareaDiferenci", GXutil.ltrimstr( A1698LSD4ContribucionTareaDiferenci, 6, 2));
         A1699LSD4CodigoObraSocial_63_6 = httpContext.cgiGet( edtLSD4CodigoObraSocial_63_6_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1699LSD4CodigoObraSocial_63_6", A1699LSD4CodigoObraSocial_63_6);
         A1700LSD4CantidadAdherentes_69_2 = (byte)(localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadAdherentes_69_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1700LSD4CantidadAdherentes_69_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), 2, 0));
         A1701LSD4AporteAdicionalOS_71_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4AporteAdicionalOS_71_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1701LSD4AporteAdicionalOS_71_15", GXutil.ltrimstr( A1701LSD4AporteAdicionalOS_71_15, 16, 2));
         A1702LSD4ContribucionAdicionalOS_86 = localUtil.ctond( httpContext.cgiGet( edtLSD4ContribucionAdicionalOS_86_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1702LSD4ContribucionAdicionalOS_86", GXutil.ltrimstr( A1702LSD4ContribucionAdicionalOS_86, 16, 2));
         A1703LSD4BaseCalculoDiferencialApor = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialApor_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1703LSD4BaseCalculoDiferencialApor", GXutil.ltrimstr( A1703LSD4BaseCalculoDiferencialApor, 16, 2));
         A1704LSD4BaseCalculoDiferencialOSyF = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialOSyF_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1704LSD4BaseCalculoDiferencialOSyF", GXutil.ltrimstr( A1704LSD4BaseCalculoDiferencialOSyF, 16, 2));
         A1705LSD4BaseCalculoDiferencialLRT_ = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialLRT__Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1705LSD4BaseCalculoDiferencialLRT_", GXutil.ltrimstr( A1705LSD4BaseCalculoDiferencialLRT_, 16, 2));
         A1706LSD4RemuneracionMaternidadANSe = localUtil.ctond( httpContext.cgiGet( edtLSD4RemuneracionMaternidadANSe_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1706LSD4RemuneracionMaternidadANSe", GXutil.ltrimstr( A1706LSD4RemuneracionMaternidadANSe, 16, 2));
         A1707LSD4RemuneracionBruta_161_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4RemuneracionBruta_161_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1707LSD4RemuneracionBruta_161_15", GXutil.ltrimstr( A1707LSD4RemuneracionBruta_161_15, 16, 2));
         A1708LSD4BaseImponible1_176_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible1_176_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1708LSD4BaseImponible1_176_15", GXutil.ltrimstr( A1708LSD4BaseImponible1_176_15, 16, 2));
         A1709LSD4BaseImponible2_191_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible2_191_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1709LSD4BaseImponible2_191_15", GXutil.ltrimstr( A1709LSD4BaseImponible2_191_15, 16, 2));
         A1710LSD4BaseImponible3_206_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible3_206_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1710LSD4BaseImponible3_206_15", GXutil.ltrimstr( A1710LSD4BaseImponible3_206_15, 16, 2));
         A1711LSD4BaseImponible4_221_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible4_221_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1711LSD4BaseImponible4_221_15", GXutil.ltrimstr( A1711LSD4BaseImponible4_221_15, 16, 2));
         A1712LSD4BaseImponible5_236_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible5_236_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1712LSD4BaseImponible5_236_15", GXutil.ltrimstr( A1712LSD4BaseImponible5_236_15, 16, 2));
         A1713LSD4BaseImponible6_251_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible6_251_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1713LSD4BaseImponible6_251_15", GXutil.ltrimstr( A1713LSD4BaseImponible6_251_15, 16, 2));
         A1714LSD4BaseImponible7_266_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible7_266_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1714LSD4BaseImponible7_266_15", GXutil.ltrimstr( A1714LSD4BaseImponible7_266_15, 16, 2));
         A1715LSD4BaseImponible8_281_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible8_281_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1715LSD4BaseImponible8_281_15", GXutil.ltrimstr( A1715LSD4BaseImponible8_281_15, 16, 2));
         A1716LSD4BaseImponible9_296_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible9_296_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1716LSD4BaseImponible9_296_15", GXutil.ltrimstr( A1716LSD4BaseImponible9_296_15, 16, 2));
         A1717LSD4BaseDifApoSegSoc_311_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseDifApoSegSoc_311_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1717LSD4BaseDifApoSegSoc_311_15", GXutil.ltrimstr( A1717LSD4BaseDifApoSegSoc_311_15, 16, 2));
         A1718LSD4BaseDifContSegSoc_326_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseDifContSegSoc_326_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1718LSD4BaseDifContSegSoc_326_15", GXutil.ltrimstr( A1718LSD4BaseDifContSegSoc_326_15, 16, 2));
         A1719LSD4BaseImponible10_341_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible10_341_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1719LSD4BaseImponible10_341_15", GXutil.ltrimstr( A1719LSD4BaseImponible10_341_15, 16, 2));
         A1720LSD4ImporteADetraer_356_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4ImporteADetraer_356_15_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1720LSD4ImporteADetraer_356_15", GXutil.ltrimstr( A1720LSD4ImporteADetraer_356_15, 16, 2));
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
      e13HL2 ();
      if (returnInSub) return;
   }

   public void e13HL2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      lsd_reg4general_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14HL2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtLSDSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSDSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Visible), 5, 0), true);
      edtLSD2Sec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSD2Sec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Visible), 5, 0), true);
      edtLSD4Sec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSD4Sec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4Sec_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg4_Update", GXv_boolean5) ;
      lsd_reg4general_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg4_Delete", GXv_boolean5) ;
      lsd_reg4general_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "LSD_reg4" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15HL2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      lsd_reg4general_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A1649LSDSec = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
      A1657LSD2Sec = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
      A1674LSD4Sec = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
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
      paHL2( ) ;
      wsHL2( ) ;
      weHL2( ) ;
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
      sCtrlA1649LSDSec = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlA1657LSD2Sec = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlA1674LSD4Sec = (String)getParm(obj,4,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paHL2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "lsd_reg4general", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paHL2( ) ;
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
         A1649LSDSec = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         A1674LSD4Sec = ((Number) GXutil.testNumericType( getParm(obj,6,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1649LSDSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1657LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1657LSD2Sec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1674LSD4Sec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1674LSD4Sec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1EmpCod != wcpOA1EmpCod ) || ( A1649LSDSec != wcpOA1649LSDSec ) || ( A1657LSD2Sec != wcpOA1657LSD2Sec ) || ( A1674LSD4Sec != wcpOA1674LSD4Sec ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1EmpCod = A1EmpCod ;
      wcpOA1649LSDSec = A1649LSDSec ;
      wcpOA1657LSD2Sec = A1657LSD2Sec ;
      wcpOA1674LSD4Sec = A1674LSD4Sec ;
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
      sCtrlA1649LSDSec = httpContext.cgiGet( sPrefix+"A1649LSDSec_CTRL") ;
      if ( GXutil.len( sCtrlA1649LSDSec) > 0 )
      {
         A1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlA1649LSDSec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
      }
      else
      {
         A1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1649LSDSec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA1657LSD2Sec = httpContext.cgiGet( sPrefix+"A1657LSD2Sec_CTRL") ;
      if ( GXutil.len( sCtrlA1657LSD2Sec) > 0 )
      {
         A1657LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlA1657LSD2Sec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
      }
      else
      {
         A1657LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1657LSD2Sec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA1674LSD4Sec = httpContext.cgiGet( sPrefix+"A1674LSD4Sec_CTRL") ;
      if ( GXutil.len( sCtrlA1674LSD4Sec) > 0 )
      {
         A1674LSD4Sec = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA1674LSD4Sec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
      }
      else
      {
         A1674LSD4Sec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1674LSD4Sec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paHL2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsHL2( ) ;
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
      wsHL2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1649LSDSec_PARM", GXutil.ltrim( localUtil.ntoc( A1649LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1649LSDSec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1649LSDSec_CTRL", GXutil.rtrim( sCtrlA1649LSDSec));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1657LSD2Sec_PARM", GXutil.ltrim( localUtil.ntoc( A1657LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1657LSD2Sec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1657LSD2Sec_CTRL", GXutil.rtrim( sCtrlA1657LSD2Sec));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1674LSD4Sec_PARM", GXutil.ltrim( localUtil.ntoc( A1674LSD4Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1674LSD4Sec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1674LSD4Sec_CTRL", GXutil.rtrim( sCtrlA1674LSD4Sec));
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
      weHL2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202027292", true, true);
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
      httpContext.AddJavascriptSource("lsd_reg4general.js", "?202412202027292", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtLSD4CUIL_3_11_Internalname = sPrefix+"LSD4CUIL_3_11" ;
      edtLSD4Conyuge_14_1_Internalname = sPrefix+"LSD4CONYUGE_14_1" ;
      edtLSD4CantidadHijos_15_2_Internalname = sPrefix+"LSD4CANTIDADHIJOS_15_2" ;
      edtLSD4MarcaCCT_17_1_Internalname = sPrefix+"LSD4MARCACCT_17_1" ;
      edtLSD4MarcaSCVO_18_1_Internalname = sPrefix+"LSD4MARCASCVO_18_1" ;
      edtLSD4MarcaReduccion_19_1_Internalname = sPrefix+"LSD4MARCAREDUCCION_19_1" ;
      edtLSD4TipoEmpresa_20_1_Internalname = sPrefix+"LSD4TIPOEMPRESA_20_1" ;
      edtLSD4TipoOperacion_21_1_Internalname = sPrefix+"LSD4TIPOOPERACION_21_1" ;
      edtLSD4CodigoSituacion_22_2_Internalname = sPrefix+"LSD4CODIGOSITUACION_22_2" ;
      edtLSD4CodigoCondicion_24_2_Internalname = sPrefix+"LSD4CODIGOCONDICION_24_2" ;
      edtLSD4CodigoActividad_26_3_Internalname = sPrefix+"LSD4CODIGOACTIVIDAD_26_3" ;
      edtLSD4CodigoModalidadContratacio_Internalname = sPrefix+"LSD4CODIGOMODALIDADCONTRATACIO" ;
      edtLSD4CodigoSiniestrado_32_2_Internalname = sPrefix+"LSD4CODIGOSINIESTRADO_32_2" ;
      edtLSD4CodigoLocalidad_34_2_Internalname = sPrefix+"LSD4CODIGOLOCALIDAD_34_2" ;
      edtLSD4SituacionRevista1_36_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA1_36_2" ;
      edtLSD4DiaInicioSituacionRevista1_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA1" ;
      edtLSD4SituacionRevista2_40_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA2_40_2" ;
      edtLSD4DiaInicioSituacionRevista2_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA2" ;
      edtLSD4SituacionRevista3_44_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA3_44_2" ;
      edtLSD4DiaInicioSituacionRevista3_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA3" ;
      edtLSD4CantidadDiasTrabajados_48__Internalname = sPrefix+"LSD4CANTIDADDIASTRABAJADOS_48_" ;
      edtLSD4HorasTrabajadas_50_3_Internalname = sPrefix+"LSD4HORASTRABAJADAS_50_3" ;
      edtLSD4PorcentajeAporteAdicionalS_Internalname = sPrefix+"LSD4PORCENTAJEAPORTEADICIONALS" ;
      edtLSD4ContribucionTareaDiferenci_Internalname = sPrefix+"LSD4CONTRIBUCIONTAREADIFERENCI" ;
      edtLSD4CodigoObraSocial_63_6_Internalname = sPrefix+"LSD4CODIGOOBRASOCIAL_63_6" ;
      edtLSD4CantidadAdherentes_69_2_Internalname = sPrefix+"LSD4CANTIDADADHERENTES_69_2" ;
      edtLSD4AporteAdicionalOS_71_15_Internalname = sPrefix+"LSD4APORTEADICIONALOS_71_15" ;
      edtLSD4ContribucionAdicionalOS_86_Internalname = sPrefix+"LSD4CONTRIBUCIONADICIONALOS_86" ;
      edtLSD4BaseCalculoDiferencialApor_Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALAPOR" ;
      edtLSD4BaseCalculoDiferencialOSyF_Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALOSYF" ;
      edtLSD4BaseCalculoDiferencialLRT__Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALLRT_" ;
      edtLSD4RemuneracionMaternidadANSe_Internalname = sPrefix+"LSD4REMUNERACIONMATERNIDADANSE" ;
      edtLSD4RemuneracionBruta_161_15_Internalname = sPrefix+"LSD4REMUNERACIONBRUTA_161_15" ;
      edtLSD4BaseImponible1_176_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE1_176_15" ;
      edtLSD4BaseImponible2_191_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE2_191_15" ;
      edtLSD4BaseImponible3_206_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE3_206_15" ;
      edtLSD4BaseImponible4_221_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE4_221_15" ;
      edtLSD4BaseImponible5_236_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE5_236_15" ;
      edtLSD4BaseImponible6_251_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE6_251_15" ;
      edtLSD4BaseImponible7_266_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE7_266_15" ;
      edtLSD4BaseImponible8_281_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE8_281_15" ;
      edtLSD4BaseImponible9_296_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE9_296_15" ;
      edtLSD4BaseDifApoSegSoc_311_15_Internalname = sPrefix+"LSD4BASEDIFAPOSEGSOC_311_15" ;
      edtLSD4BaseDifContSegSoc_326_15_Internalname = sPrefix+"LSD4BASEDIFCONTSEGSOC_326_15" ;
      edtLSD4BaseImponible10_341_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE10_341_15" ;
      edtLSD4ImporteADetraer_356_15_Internalname = sPrefix+"LSD4IMPORTEADETRAER_356_15" ;
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLSDSec_Internalname = sPrefix+"LSDSEC" ;
      edtLSD2Sec_Internalname = sPrefix+"LSD2SEC" ;
      edtLSD4Sec_Internalname = sPrefix+"LSD4SEC" ;
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
      edtLSD4Sec_Jsonclick = "" ;
      edtLSD4Sec_Visible = 1 ;
      edtLSD2Sec_Jsonclick = "" ;
      edtLSD2Sec_Visible = 1 ;
      edtLSDSec_Jsonclick = "" ;
      edtLSDSec_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      edtLSD4ImporteADetraer_356_15_Jsonclick = "" ;
      edtLSD4ImporteADetraer_356_15_Enabled = 0 ;
      edtLSD4BaseImponible10_341_15_Jsonclick = "" ;
      edtLSD4BaseImponible10_341_15_Enabled = 0 ;
      edtLSD4BaseDifContSegSoc_326_15_Jsonclick = "" ;
      edtLSD4BaseDifContSegSoc_326_15_Enabled = 0 ;
      edtLSD4BaseDifApoSegSoc_311_15_Jsonclick = "" ;
      edtLSD4BaseDifApoSegSoc_311_15_Enabled = 0 ;
      edtLSD4BaseImponible9_296_15_Jsonclick = "" ;
      edtLSD4BaseImponible9_296_15_Enabled = 0 ;
      edtLSD4BaseImponible8_281_15_Jsonclick = "" ;
      edtLSD4BaseImponible8_281_15_Enabled = 0 ;
      edtLSD4BaseImponible7_266_15_Jsonclick = "" ;
      edtLSD4BaseImponible7_266_15_Enabled = 0 ;
      edtLSD4BaseImponible6_251_15_Jsonclick = "" ;
      edtLSD4BaseImponible6_251_15_Enabled = 0 ;
      edtLSD4BaseImponible5_236_15_Jsonclick = "" ;
      edtLSD4BaseImponible5_236_15_Enabled = 0 ;
      edtLSD4BaseImponible4_221_15_Jsonclick = "" ;
      edtLSD4BaseImponible4_221_15_Enabled = 0 ;
      edtLSD4BaseImponible3_206_15_Jsonclick = "" ;
      edtLSD4BaseImponible3_206_15_Enabled = 0 ;
      edtLSD4BaseImponible2_191_15_Jsonclick = "" ;
      edtLSD4BaseImponible2_191_15_Enabled = 0 ;
      edtLSD4BaseImponible1_176_15_Jsonclick = "" ;
      edtLSD4BaseImponible1_176_15_Enabled = 0 ;
      edtLSD4RemuneracionBruta_161_15_Jsonclick = "" ;
      edtLSD4RemuneracionBruta_161_15_Enabled = 0 ;
      edtLSD4RemuneracionMaternidadANSe_Jsonclick = "" ;
      edtLSD4RemuneracionMaternidadANSe_Enabled = 0 ;
      edtLSD4BaseCalculoDiferencialLRT__Jsonclick = "" ;
      edtLSD4BaseCalculoDiferencialLRT__Enabled = 0 ;
      edtLSD4BaseCalculoDiferencialOSyF_Jsonclick = "" ;
      edtLSD4BaseCalculoDiferencialOSyF_Enabled = 0 ;
      edtLSD4BaseCalculoDiferencialApor_Jsonclick = "" ;
      edtLSD4BaseCalculoDiferencialApor_Enabled = 0 ;
      edtLSD4ContribucionAdicionalOS_86_Jsonclick = "" ;
      edtLSD4ContribucionAdicionalOS_86_Enabled = 0 ;
      edtLSD4AporteAdicionalOS_71_15_Jsonclick = "" ;
      edtLSD4AporteAdicionalOS_71_15_Enabled = 0 ;
      edtLSD4CantidadAdherentes_69_2_Jsonclick = "" ;
      edtLSD4CantidadAdherentes_69_2_Enabled = 0 ;
      edtLSD4CodigoObraSocial_63_6_Jsonclick = "" ;
      edtLSD4CodigoObraSocial_63_6_Enabled = 0 ;
      edtLSD4ContribucionTareaDiferenci_Jsonclick = "" ;
      edtLSD4ContribucionTareaDiferenci_Enabled = 0 ;
      edtLSD4PorcentajeAporteAdicionalS_Jsonclick = "" ;
      edtLSD4PorcentajeAporteAdicionalS_Enabled = 0 ;
      edtLSD4HorasTrabajadas_50_3_Jsonclick = "" ;
      edtLSD4HorasTrabajadas_50_3_Enabled = 0 ;
      edtLSD4CantidadDiasTrabajados_48__Jsonclick = "" ;
      edtLSD4CantidadDiasTrabajados_48__Enabled = 0 ;
      edtLSD4DiaInicioSituacionRevista3_Jsonclick = "" ;
      edtLSD4DiaInicioSituacionRevista3_Enabled = 0 ;
      edtLSD4SituacionRevista3_44_2_Jsonclick = "" ;
      edtLSD4SituacionRevista3_44_2_Enabled = 0 ;
      edtLSD4DiaInicioSituacionRevista2_Jsonclick = "" ;
      edtLSD4DiaInicioSituacionRevista2_Enabled = 0 ;
      edtLSD4SituacionRevista2_40_2_Jsonclick = "" ;
      edtLSD4SituacionRevista2_40_2_Enabled = 0 ;
      edtLSD4DiaInicioSituacionRevista1_Jsonclick = "" ;
      edtLSD4DiaInicioSituacionRevista1_Enabled = 0 ;
      edtLSD4SituacionRevista1_36_2_Jsonclick = "" ;
      edtLSD4SituacionRevista1_36_2_Enabled = 0 ;
      edtLSD4CodigoLocalidad_34_2_Jsonclick = "" ;
      edtLSD4CodigoLocalidad_34_2_Enabled = 0 ;
      edtLSD4CodigoSiniestrado_32_2_Jsonclick = "" ;
      edtLSD4CodigoSiniestrado_32_2_Enabled = 0 ;
      edtLSD4CodigoModalidadContratacio_Jsonclick = "" ;
      edtLSD4CodigoModalidadContratacio_Enabled = 0 ;
      edtLSD4CodigoActividad_26_3_Jsonclick = "" ;
      edtLSD4CodigoActividad_26_3_Enabled = 0 ;
      edtLSD4CodigoCondicion_24_2_Jsonclick = "" ;
      edtLSD4CodigoCondicion_24_2_Enabled = 0 ;
      edtLSD4CodigoSituacion_22_2_Jsonclick = "" ;
      edtLSD4CodigoSituacion_22_2_Enabled = 0 ;
      edtLSD4TipoOperacion_21_1_Jsonclick = "" ;
      edtLSD4TipoOperacion_21_1_Enabled = 0 ;
      edtLSD4TipoEmpresa_20_1_Jsonclick = "" ;
      edtLSD4TipoEmpresa_20_1_Enabled = 0 ;
      edtLSD4MarcaReduccion_19_1_Jsonclick = "" ;
      edtLSD4MarcaReduccion_19_1_Enabled = 0 ;
      edtLSD4MarcaSCVO_18_1_Jsonclick = "" ;
      edtLSD4MarcaSCVO_18_1_Enabled = 0 ;
      edtLSD4MarcaCCT_17_1_Jsonclick = "" ;
      edtLSD4MarcaCCT_17_1_Enabled = 0 ;
      edtLSD4CantidadHijos_15_2_Jsonclick = "" ;
      edtLSD4CantidadHijos_15_2_Enabled = 0 ;
      edtLSD4Conyuge_14_1_Jsonclick = "" ;
      edtLSD4Conyuge_14_1_Enabled = 0 ;
      edtLSD4CUIL_3_11_Jsonclick = "" ;
      edtLSD4CUIL_3_11_Enabled = 0 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'},{av:'A1657LSD2Sec',fld:'LSD2SEC',pic:'ZZZZZZZ9'},{av:'A1674LSD4Sec',fld:'LSD4SEC',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11HL1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'},{av:'A1657LSD2Sec',fld:'LSD2SEC',pic:'ZZZZZZZ9'},{av:'A1674LSD4Sec',fld:'LSD4SEC',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12HL1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'},{av:'A1657LSD2Sec',fld:'LSD2SEC',pic:'ZZZZZZZ9'},{av:'A1674LSD4Sec',fld:'LSD4SEC',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LSDSEC","{handler:'valid_Lsdsec',iparms:[]");
      setEventMetadata("VALID_LSDSEC",",oparms:[]}");
      setEventMetadata("VALID_LSD2SEC","{handler:'valid_Lsd2sec',iparms:[]");
      setEventMetadata("VALID_LSD2SEC",",oparms:[]}");
      setEventMetadata("VALID_LSD4SEC","{handler:'valid_Lsd4sec',iparms:[]");
      setEventMetadata("VALID_LSD4SEC",",oparms:[]}");
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
      A1676LSD4Conyuge_14_1 = "" ;
      A1678LSD4MarcaCCT_17_1 = "" ;
      A1679LSD4MarcaSCVO_18_1 = "" ;
      A1680LSD4MarcaReduccion_19_1 = "" ;
      A1681LSD4TipoEmpresa_20_1 = "" ;
      A1682LSD4TipoOperacion_21_1 = "" ;
      A1683LSD4CodigoSituacion_22_2 = "" ;
      A1684LSD4CodigoCondicion_24_2 = "" ;
      A1685LSD4CodigoActividad_26_3 = "" ;
      A1686LSD4CodigoModalidadContratacio = "" ;
      A1687LSD4CodigoSiniestrado_32_2 = "" ;
      A1688LSD4CodigoLocalidad_34_2 = "" ;
      A1689LSD4SituacionRevista1_36_2 = "" ;
      A1690LSD4DiaInicioSituacionRevista1 = "" ;
      A1691LSD4SituacionRevista2_40_2 = "" ;
      A1692LSD4DiaInicioSituacionRevista2 = "" ;
      A1693LSD4SituacionRevista3_44_2 = "" ;
      A1694LSD4DiaInicioSituacionRevista3 = "" ;
      A1697LSD4PorcentajeAporteAdicionalS = DecimalUtil.ZERO ;
      A1698LSD4ContribucionTareaDiferenci = DecimalUtil.ZERO ;
      A1699LSD4CodigoObraSocial_63_6 = "" ;
      A1701LSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      A1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.ZERO ;
      A1703LSD4BaseCalculoDiferencialApor = DecimalUtil.ZERO ;
      A1704LSD4BaseCalculoDiferencialOSyF = DecimalUtil.ZERO ;
      A1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.ZERO ;
      A1706LSD4RemuneracionMaternidadANSe = DecimalUtil.ZERO ;
      A1707LSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      A1708LSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      A1709LSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      A1710LSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      A1711LSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      A1712LSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      A1713LSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      A1714LSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      A1715LSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      A1716LSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      A1717LSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      A1718LSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      A1719LSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      A1720LSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      H00HL2_A3CliCod = new int[1] ;
      H00HL2_A1EmpCod = new short[1] ;
      H00HL2_A1649LSDSec = new int[1] ;
      H00HL2_A1657LSD2Sec = new int[1] ;
      H00HL2_A1674LSD4Sec = new short[1] ;
      H00HL2_A1720LSD4ImporteADetraer_356_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1719LSD4BaseImponible10_341_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1718LSD4BaseDifContSegSoc_326_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1717LSD4BaseDifApoSegSoc_311_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1716LSD4BaseImponible9_296_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1715LSD4BaseImponible8_281_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1714LSD4BaseImponible7_266_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1713LSD4BaseImponible6_251_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1712LSD4BaseImponible5_236_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1711LSD4BaseImponible4_221_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1710LSD4BaseImponible3_206_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1709LSD4BaseImponible2_191_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1708LSD4BaseImponible1_176_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1707LSD4RemuneracionBruta_161_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1706LSD4RemuneracionMaternidadANSe = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1705LSD4BaseCalculoDiferencialLRT_ = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1704LSD4BaseCalculoDiferencialOSyF = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1703LSD4BaseCalculoDiferencialApor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1702LSD4ContribucionAdicionalOS_86 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1701LSD4AporteAdicionalOS_71_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1700LSD4CantidadAdherentes_69_2 = new byte[1] ;
      H00HL2_A1699LSD4CodigoObraSocial_63_6 = new String[] {""} ;
      H00HL2_A1698LSD4ContribucionTareaDiferenci = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1697LSD4PorcentajeAporteAdicionalS = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HL2_A1696LSD4HorasTrabajadas_50_3 = new short[1] ;
      H00HL2_A1695LSD4CantidadDiasTrabajados_48_ = new byte[1] ;
      H00HL2_A1694LSD4DiaInicioSituacionRevista3 = new String[] {""} ;
      H00HL2_A1693LSD4SituacionRevista3_44_2 = new String[] {""} ;
      H00HL2_A1692LSD4DiaInicioSituacionRevista2 = new String[] {""} ;
      H00HL2_A1691LSD4SituacionRevista2_40_2 = new String[] {""} ;
      H00HL2_A1690LSD4DiaInicioSituacionRevista1 = new String[] {""} ;
      H00HL2_A1689LSD4SituacionRevista1_36_2 = new String[] {""} ;
      H00HL2_A1688LSD4CodigoLocalidad_34_2 = new String[] {""} ;
      H00HL2_A1687LSD4CodigoSiniestrado_32_2 = new String[] {""} ;
      H00HL2_A1686LSD4CodigoModalidadContratacio = new String[] {""} ;
      H00HL2_A1685LSD4CodigoActividad_26_3 = new String[] {""} ;
      H00HL2_A1684LSD4CodigoCondicion_24_2 = new String[] {""} ;
      H00HL2_A1683LSD4CodigoSituacion_22_2 = new String[] {""} ;
      H00HL2_A1682LSD4TipoOperacion_21_1 = new String[] {""} ;
      H00HL2_A1681LSD4TipoEmpresa_20_1 = new String[] {""} ;
      H00HL2_A1680LSD4MarcaReduccion_19_1 = new String[] {""} ;
      H00HL2_A1679LSD4MarcaSCVO_18_1 = new String[] {""} ;
      H00HL2_A1678LSD4MarcaCCT_17_1 = new String[] {""} ;
      H00HL2_A1677LSD4CantidadHijos_15_2 = new byte[1] ;
      H00HL2_A1676LSD4Conyuge_14_1 = new String[] {""} ;
      H00HL2_A1675LSD4CUIL_3_11 = new long[1] ;
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
      sCtrlA1649LSDSec = "" ;
      sCtrlA1657LSD2Sec = "" ;
      sCtrlA1674LSD4Sec = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.lsd_reg4general__default(),
         new Object[] {
             new Object[] {
            H00HL2_A3CliCod, H00HL2_A1EmpCod, H00HL2_A1649LSDSec, H00HL2_A1657LSD2Sec, H00HL2_A1674LSD4Sec, H00HL2_A1720LSD4ImporteADetraer_356_15, H00HL2_A1719LSD4BaseImponible10_341_15, H00HL2_A1718LSD4BaseDifContSegSoc_326_15, H00HL2_A1717LSD4BaseDifApoSegSoc_311_15, H00HL2_A1716LSD4BaseImponible9_296_15,
            H00HL2_A1715LSD4BaseImponible8_281_15, H00HL2_A1714LSD4BaseImponible7_266_15, H00HL2_A1713LSD4BaseImponible6_251_15, H00HL2_A1712LSD4BaseImponible5_236_15, H00HL2_A1711LSD4BaseImponible4_221_15, H00HL2_A1710LSD4BaseImponible3_206_15, H00HL2_A1709LSD4BaseImponible2_191_15, H00HL2_A1708LSD4BaseImponible1_176_15, H00HL2_A1707LSD4RemuneracionBruta_161_15, H00HL2_A1706LSD4RemuneracionMaternidadANSe,
            H00HL2_A1705LSD4BaseCalculoDiferencialLRT_, H00HL2_A1704LSD4BaseCalculoDiferencialOSyF, H00HL2_A1703LSD4BaseCalculoDiferencialApor, H00HL2_A1702LSD4ContribucionAdicionalOS_86, H00HL2_A1701LSD4AporteAdicionalOS_71_15, H00HL2_A1700LSD4CantidadAdherentes_69_2, H00HL2_A1699LSD4CodigoObraSocial_63_6, H00HL2_A1698LSD4ContribucionTareaDiferenci, H00HL2_A1697LSD4PorcentajeAporteAdicionalS, H00HL2_A1696LSD4HorasTrabajadas_50_3,
            H00HL2_A1695LSD4CantidadDiasTrabajados_48_, H00HL2_A1694LSD4DiaInicioSituacionRevista3, H00HL2_A1693LSD4SituacionRevista3_44_2, H00HL2_A1692LSD4DiaInicioSituacionRevista2, H00HL2_A1691LSD4SituacionRevista2_40_2, H00HL2_A1690LSD4DiaInicioSituacionRevista1, H00HL2_A1689LSD4SituacionRevista1_36_2, H00HL2_A1688LSD4CodigoLocalidad_34_2, H00HL2_A1687LSD4CodigoSiniestrado_32_2, H00HL2_A1686LSD4CodigoModalidadContratacio,
            H00HL2_A1685LSD4CodigoActividad_26_3, H00HL2_A1684LSD4CodigoCondicion_24_2, H00HL2_A1683LSD4CodigoSituacion_22_2, H00HL2_A1682LSD4TipoOperacion_21_1, H00HL2_A1681LSD4TipoEmpresa_20_1, H00HL2_A1680LSD4MarcaReduccion_19_1, H00HL2_A1679LSD4MarcaSCVO_18_1, H00HL2_A1678LSD4MarcaCCT_17_1, H00HL2_A1677LSD4CantidadHijos_15_2, H00HL2_A1676LSD4Conyuge_14_1,
            H00HL2_A1675LSD4CUIL_3_11
            }
         }
      );
      AV17Pgmname = "LSD_reg4General" ;
      /* GeneXus formulas. */
      AV17Pgmname = "LSD_reg4General" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1677LSD4CantidadHijos_15_2 ;
   private byte A1695LSD4CantidadDiasTrabajados_48_ ;
   private byte A1700LSD4CantidadAdherentes_69_2 ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1EmpCod ;
   private short wcpOA1674LSD4Sec ;
   private short A1EmpCod ;
   private short A1674LSD4Sec ;
   private short wbEnd ;
   private short wbStart ;
   private short A1696LSD4HorasTrabajadas_50_3 ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int wcpOA1649LSDSec ;
   private int wcpOA1657LSD2Sec ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int A1657LSD2Sec ;
   private int edtLSD4CUIL_3_11_Enabled ;
   private int edtLSD4Conyuge_14_1_Enabled ;
   private int edtLSD4CantidadHijos_15_2_Enabled ;
   private int edtLSD4MarcaCCT_17_1_Enabled ;
   private int edtLSD4MarcaSCVO_18_1_Enabled ;
   private int edtLSD4MarcaReduccion_19_1_Enabled ;
   private int edtLSD4TipoEmpresa_20_1_Enabled ;
   private int edtLSD4TipoOperacion_21_1_Enabled ;
   private int edtLSD4CodigoSituacion_22_2_Enabled ;
   private int edtLSD4CodigoCondicion_24_2_Enabled ;
   private int edtLSD4CodigoActividad_26_3_Enabled ;
   private int edtLSD4CodigoModalidadContratacio_Enabled ;
   private int edtLSD4CodigoSiniestrado_32_2_Enabled ;
   private int edtLSD4CodigoLocalidad_34_2_Enabled ;
   private int edtLSD4SituacionRevista1_36_2_Enabled ;
   private int edtLSD4DiaInicioSituacionRevista1_Enabled ;
   private int edtLSD4SituacionRevista2_40_2_Enabled ;
   private int edtLSD4DiaInicioSituacionRevista2_Enabled ;
   private int edtLSD4SituacionRevista3_44_2_Enabled ;
   private int edtLSD4DiaInicioSituacionRevista3_Enabled ;
   private int edtLSD4CantidadDiasTrabajados_48__Enabled ;
   private int edtLSD4HorasTrabajadas_50_3_Enabled ;
   private int edtLSD4PorcentajeAporteAdicionalS_Enabled ;
   private int edtLSD4ContribucionTareaDiferenci_Enabled ;
   private int edtLSD4CodigoObraSocial_63_6_Enabled ;
   private int edtLSD4CantidadAdherentes_69_2_Enabled ;
   private int edtLSD4AporteAdicionalOS_71_15_Enabled ;
   private int edtLSD4ContribucionAdicionalOS_86_Enabled ;
   private int edtLSD4BaseCalculoDiferencialApor_Enabled ;
   private int edtLSD4BaseCalculoDiferencialOSyF_Enabled ;
   private int edtLSD4BaseCalculoDiferencialLRT__Enabled ;
   private int edtLSD4RemuneracionMaternidadANSe_Enabled ;
   private int edtLSD4RemuneracionBruta_161_15_Enabled ;
   private int edtLSD4BaseImponible1_176_15_Enabled ;
   private int edtLSD4BaseImponible2_191_15_Enabled ;
   private int edtLSD4BaseImponible3_206_15_Enabled ;
   private int edtLSD4BaseImponible4_221_15_Enabled ;
   private int edtLSD4BaseImponible5_236_15_Enabled ;
   private int edtLSD4BaseImponible6_251_15_Enabled ;
   private int edtLSD4BaseImponible7_266_15_Enabled ;
   private int edtLSD4BaseImponible8_281_15_Enabled ;
   private int edtLSD4BaseImponible9_296_15_Enabled ;
   private int edtLSD4BaseDifApoSegSoc_311_15_Enabled ;
   private int edtLSD4BaseDifContSegSoc_326_15_Enabled ;
   private int edtLSD4BaseImponible10_341_15_Enabled ;
   private int edtLSD4ImporteADetraer_356_15_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtEmpCod_Visible ;
   private int edtLSDSec_Visible ;
   private int edtLSD2Sec_Visible ;
   private int edtLSD4Sec_Visible ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private long A1675LSD4CUIL_3_11 ;
   private java.math.BigDecimal A1697LSD4PorcentajeAporteAdicionalS ;
   private java.math.BigDecimal A1698LSD4ContribucionTareaDiferenci ;
   private java.math.BigDecimal A1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal A1720LSD4ImporteADetraer_356_15 ;
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
   private String edtLSD4CUIL_3_11_Internalname ;
   private String edtLSD4CUIL_3_11_Jsonclick ;
   private String edtLSD4Conyuge_14_1_Internalname ;
   private String A1676LSD4Conyuge_14_1 ;
   private String edtLSD4Conyuge_14_1_Jsonclick ;
   private String edtLSD4CantidadHijos_15_2_Internalname ;
   private String edtLSD4CantidadHijos_15_2_Jsonclick ;
   private String edtLSD4MarcaCCT_17_1_Internalname ;
   private String A1678LSD4MarcaCCT_17_1 ;
   private String edtLSD4MarcaCCT_17_1_Jsonclick ;
   private String edtLSD4MarcaSCVO_18_1_Internalname ;
   private String A1679LSD4MarcaSCVO_18_1 ;
   private String edtLSD4MarcaSCVO_18_1_Jsonclick ;
   private String edtLSD4MarcaReduccion_19_1_Internalname ;
   private String A1680LSD4MarcaReduccion_19_1 ;
   private String edtLSD4MarcaReduccion_19_1_Jsonclick ;
   private String edtLSD4TipoEmpresa_20_1_Internalname ;
   private String A1681LSD4TipoEmpresa_20_1 ;
   private String edtLSD4TipoEmpresa_20_1_Jsonclick ;
   private String edtLSD4TipoOperacion_21_1_Internalname ;
   private String A1682LSD4TipoOperacion_21_1 ;
   private String edtLSD4TipoOperacion_21_1_Jsonclick ;
   private String edtLSD4CodigoSituacion_22_2_Internalname ;
   private String A1683LSD4CodigoSituacion_22_2 ;
   private String edtLSD4CodigoSituacion_22_2_Jsonclick ;
   private String edtLSD4CodigoCondicion_24_2_Internalname ;
   private String A1684LSD4CodigoCondicion_24_2 ;
   private String edtLSD4CodigoCondicion_24_2_Jsonclick ;
   private String edtLSD4CodigoActividad_26_3_Internalname ;
   private String A1685LSD4CodigoActividad_26_3 ;
   private String edtLSD4CodigoActividad_26_3_Jsonclick ;
   private String edtLSD4CodigoModalidadContratacio_Internalname ;
   private String A1686LSD4CodigoModalidadContratacio ;
   private String edtLSD4CodigoModalidadContratacio_Jsonclick ;
   private String edtLSD4CodigoSiniestrado_32_2_Internalname ;
   private String A1687LSD4CodigoSiniestrado_32_2 ;
   private String edtLSD4CodigoSiniestrado_32_2_Jsonclick ;
   private String edtLSD4CodigoLocalidad_34_2_Internalname ;
   private String A1688LSD4CodigoLocalidad_34_2 ;
   private String edtLSD4CodigoLocalidad_34_2_Jsonclick ;
   private String edtLSD4SituacionRevista1_36_2_Internalname ;
   private String A1689LSD4SituacionRevista1_36_2 ;
   private String edtLSD4SituacionRevista1_36_2_Jsonclick ;
   private String edtLSD4DiaInicioSituacionRevista1_Internalname ;
   private String A1690LSD4DiaInicioSituacionRevista1 ;
   private String edtLSD4DiaInicioSituacionRevista1_Jsonclick ;
   private String edtLSD4SituacionRevista2_40_2_Internalname ;
   private String A1691LSD4SituacionRevista2_40_2 ;
   private String edtLSD4SituacionRevista2_40_2_Jsonclick ;
   private String edtLSD4DiaInicioSituacionRevista2_Internalname ;
   private String A1692LSD4DiaInicioSituacionRevista2 ;
   private String edtLSD4DiaInicioSituacionRevista2_Jsonclick ;
   private String edtLSD4SituacionRevista3_44_2_Internalname ;
   private String A1693LSD4SituacionRevista3_44_2 ;
   private String edtLSD4SituacionRevista3_44_2_Jsonclick ;
   private String edtLSD4DiaInicioSituacionRevista3_Internalname ;
   private String A1694LSD4DiaInicioSituacionRevista3 ;
   private String edtLSD4DiaInicioSituacionRevista3_Jsonclick ;
   private String edtLSD4CantidadDiasTrabajados_48__Internalname ;
   private String edtLSD4CantidadDiasTrabajados_48__Jsonclick ;
   private String edtLSD4HorasTrabajadas_50_3_Internalname ;
   private String edtLSD4HorasTrabajadas_50_3_Jsonclick ;
   private String edtLSD4PorcentajeAporteAdicionalS_Internalname ;
   private String edtLSD4PorcentajeAporteAdicionalS_Jsonclick ;
   private String edtLSD4ContribucionTareaDiferenci_Internalname ;
   private String edtLSD4ContribucionTareaDiferenci_Jsonclick ;
   private String edtLSD4CodigoObraSocial_63_6_Internalname ;
   private String A1699LSD4CodigoObraSocial_63_6 ;
   private String edtLSD4CodigoObraSocial_63_6_Jsonclick ;
   private String edtLSD4CantidadAdherentes_69_2_Internalname ;
   private String edtLSD4CantidadAdherentes_69_2_Jsonclick ;
   private String edtLSD4AporteAdicionalOS_71_15_Internalname ;
   private String edtLSD4AporteAdicionalOS_71_15_Jsonclick ;
   private String edtLSD4ContribucionAdicionalOS_86_Internalname ;
   private String edtLSD4ContribucionAdicionalOS_86_Jsonclick ;
   private String edtLSD4BaseCalculoDiferencialApor_Internalname ;
   private String edtLSD4BaseCalculoDiferencialApor_Jsonclick ;
   private String edtLSD4BaseCalculoDiferencialOSyF_Internalname ;
   private String edtLSD4BaseCalculoDiferencialOSyF_Jsonclick ;
   private String edtLSD4BaseCalculoDiferencialLRT__Internalname ;
   private String edtLSD4BaseCalculoDiferencialLRT__Jsonclick ;
   private String edtLSD4RemuneracionMaternidadANSe_Internalname ;
   private String edtLSD4RemuneracionMaternidadANSe_Jsonclick ;
   private String edtLSD4RemuneracionBruta_161_15_Internalname ;
   private String edtLSD4RemuneracionBruta_161_15_Jsonclick ;
   private String edtLSD4BaseImponible1_176_15_Internalname ;
   private String edtLSD4BaseImponible1_176_15_Jsonclick ;
   private String edtLSD4BaseImponible2_191_15_Internalname ;
   private String edtLSD4BaseImponible2_191_15_Jsonclick ;
   private String edtLSD4BaseImponible3_206_15_Internalname ;
   private String edtLSD4BaseImponible3_206_15_Jsonclick ;
   private String edtLSD4BaseImponible4_221_15_Internalname ;
   private String edtLSD4BaseImponible4_221_15_Jsonclick ;
   private String edtLSD4BaseImponible5_236_15_Internalname ;
   private String edtLSD4BaseImponible5_236_15_Jsonclick ;
   private String edtLSD4BaseImponible6_251_15_Internalname ;
   private String edtLSD4BaseImponible6_251_15_Jsonclick ;
   private String edtLSD4BaseImponible7_266_15_Internalname ;
   private String edtLSD4BaseImponible7_266_15_Jsonclick ;
   private String edtLSD4BaseImponible8_281_15_Internalname ;
   private String edtLSD4BaseImponible8_281_15_Jsonclick ;
   private String edtLSD4BaseImponible9_296_15_Internalname ;
   private String edtLSD4BaseImponible9_296_15_Jsonclick ;
   private String edtLSD4BaseDifApoSegSoc_311_15_Internalname ;
   private String edtLSD4BaseDifApoSegSoc_311_15_Jsonclick ;
   private String edtLSD4BaseDifContSegSoc_326_15_Internalname ;
   private String edtLSD4BaseDifContSegSoc_326_15_Jsonclick ;
   private String edtLSD4BaseImponible10_341_15_Internalname ;
   private String edtLSD4BaseImponible10_341_15_Jsonclick ;
   private String edtLSD4ImporteADetraer_356_15_Internalname ;
   private String edtLSD4ImporteADetraer_356_15_Jsonclick ;
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
   private String edtLSDSec_Internalname ;
   private String edtLSDSec_Jsonclick ;
   private String edtLSD2Sec_Internalname ;
   private String edtLSD2Sec_Jsonclick ;
   private String edtLSD4Sec_Internalname ;
   private String edtLSD4Sec_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1EmpCod ;
   private String sCtrlA1649LSDSec ;
   private String sCtrlA1657LSD2Sec ;
   private String sCtrlA1674LSD4Sec ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private IDataStoreProvider pr_default ;
   private int[] H00HL2_A3CliCod ;
   private short[] H00HL2_A1EmpCod ;
   private int[] H00HL2_A1649LSDSec ;
   private int[] H00HL2_A1657LSD2Sec ;
   private short[] H00HL2_A1674LSD4Sec ;
   private java.math.BigDecimal[] H00HL2_A1720LSD4ImporteADetraer_356_15 ;
   private java.math.BigDecimal[] H00HL2_A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal[] H00HL2_A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal[] H00HL2_A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal[] H00HL2_A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal[] H00HL2_A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal[] H00HL2_A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal[] H00HL2_A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal[] H00HL2_A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal[] H00HL2_A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal[] H00HL2_A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal[] H00HL2_A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal[] H00HL2_A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal[] H00HL2_A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal[] H00HL2_A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal[] H00HL2_A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal[] H00HL2_A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal[] H00HL2_A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal[] H00HL2_A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal[] H00HL2_A1701LSD4AporteAdicionalOS_71_15 ;
   private byte[] H00HL2_A1700LSD4CantidadAdherentes_69_2 ;
   private String[] H00HL2_A1699LSD4CodigoObraSocial_63_6 ;
   private java.math.BigDecimal[] H00HL2_A1698LSD4ContribucionTareaDiferenci ;
   private java.math.BigDecimal[] H00HL2_A1697LSD4PorcentajeAporteAdicionalS ;
   private short[] H00HL2_A1696LSD4HorasTrabajadas_50_3 ;
   private byte[] H00HL2_A1695LSD4CantidadDiasTrabajados_48_ ;
   private String[] H00HL2_A1694LSD4DiaInicioSituacionRevista3 ;
   private String[] H00HL2_A1693LSD4SituacionRevista3_44_2 ;
   private String[] H00HL2_A1692LSD4DiaInicioSituacionRevista2 ;
   private String[] H00HL2_A1691LSD4SituacionRevista2_40_2 ;
   private String[] H00HL2_A1690LSD4DiaInicioSituacionRevista1 ;
   private String[] H00HL2_A1689LSD4SituacionRevista1_36_2 ;
   private String[] H00HL2_A1688LSD4CodigoLocalidad_34_2 ;
   private String[] H00HL2_A1687LSD4CodigoSiniestrado_32_2 ;
   private String[] H00HL2_A1686LSD4CodigoModalidadContratacio ;
   private String[] H00HL2_A1685LSD4CodigoActividad_26_3 ;
   private String[] H00HL2_A1684LSD4CodigoCondicion_24_2 ;
   private String[] H00HL2_A1683LSD4CodigoSituacion_22_2 ;
   private String[] H00HL2_A1682LSD4TipoOperacion_21_1 ;
   private String[] H00HL2_A1681LSD4TipoEmpresa_20_1 ;
   private String[] H00HL2_A1680LSD4MarcaReduccion_19_1 ;
   private String[] H00HL2_A1679LSD4MarcaSCVO_18_1 ;
   private String[] H00HL2_A1678LSD4MarcaCCT_17_1 ;
   private byte[] H00HL2_A1677LSD4CantidadHijos_15_2 ;
   private String[] H00HL2_A1676LSD4Conyuge_14_1 ;
   private long[] H00HL2_A1675LSD4CUIL_3_11 ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class lsd_reg4general__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00HL2", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec, LSD4ImporteADetraer_356_15, LSD4BaseImponible10_341_15, LSD4BaseDifContSegSoc_326_15, LSD4BaseDifApoSegSoc_311_15, LSD4BaseImponible9_296_15, LSD4BaseImponible8_281_15, LSD4BaseImponible7_266_15, LSD4BaseImponible6_251_15, LSD4BaseImponible5_236_15, LSD4BaseImponible4_221_15, LSD4BaseImponible3_206_15, LSD4BaseImponible2_191_15, LSD4BaseImponible1_176_15, LSD4RemuneracionBruta_161_15, LSD4RemuneracionMaternidadANSe, LSD4BaseCalculoDiferencialLRT_, LSD4BaseCalculoDiferencialOSyF, LSD4BaseCalculoDiferencialApor, LSD4ContribucionAdicionalOS_86, LSD4AporteAdicionalOS_71_15, LSD4CantidadAdherentes_69_2, LSD4CodigoObraSocial_63_6, LSD4ContribucionTareaDiferenci, LSD4PorcentajeAporteAdicionalS, LSD4HorasTrabajadas_50_3, LSD4CantidadDiasTrabajados_48_, LSD4DiaInicioSituacionRevista3, LSD4SituacionRevista3_44_2, LSD4DiaInicioSituacionRevista2, LSD4SituacionRevista2_40_2, LSD4DiaInicioSituacionRevista1, LSD4SituacionRevista1_36_2, LSD4CodigoLocalidad_34_2, LSD4CodigoSiniestrado_32_2, LSD4CodigoModalidadContratacio, LSD4CodigoActividad_26_3, LSD4CodigoCondicion_24_2, LSD4CodigoSituacion_22_2, LSD4TipoOperacion_21_1, LSD4TipoEmpresa_20_1, LSD4MarcaReduccion_19_1, LSD4MarcaSCVO_18_1, LSD4MarcaCCT_17_1, LSD4CantidadHijos_15_2, LSD4Conyuge_14_1, LSD4CUIL_3_11 FROM LSD_reg4 WHERE CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ? and LSD4Sec = ? ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((byte[]) buf[25])[0] = rslt.getByte(26);
               ((String[]) buf[26])[0] = rslt.getString(27, 6);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,2);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(29,2);
               ((short[]) buf[29])[0] = rslt.getShort(30);
               ((byte[]) buf[30])[0] = rslt.getByte(31);
               ((String[]) buf[31])[0] = rslt.getString(32, 2);
               ((String[]) buf[32])[0] = rslt.getString(33, 2);
               ((String[]) buf[33])[0] = rslt.getString(34, 2);
               ((String[]) buf[34])[0] = rslt.getString(35, 2);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getString(37, 2);
               ((String[]) buf[37])[0] = rslt.getString(38, 2);
               ((String[]) buf[38])[0] = rslt.getString(39, 2);
               ((String[]) buf[39])[0] = rslt.getString(40, 3);
               ((String[]) buf[40])[0] = rslt.getString(41, 3);
               ((String[]) buf[41])[0] = rslt.getString(42, 2);
               ((String[]) buf[42])[0] = rslt.getString(43, 2);
               ((String[]) buf[43])[0] = rslt.getString(44, 1);
               ((String[]) buf[44])[0] = rslt.getString(45, 1);
               ((String[]) buf[45])[0] = rslt.getString(46, 1);
               ((String[]) buf[46])[0] = rslt.getString(47, 1);
               ((String[]) buf[47])[0] = rslt.getString(48, 1);
               ((byte[]) buf[48])[0] = rslt.getByte(49);
               ((String[]) buf[49])[0] = rslt.getString(50, 1);
               ((long[]) buf[50])[0] = rslt.getLong(51);
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
               return;
      }
   }

}

