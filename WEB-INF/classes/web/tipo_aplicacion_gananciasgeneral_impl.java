package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class tipo_aplicacion_gananciasgeneral_impl extends GXWebComponent
{
   public tipo_aplicacion_gananciasgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public tipo_aplicacion_gananciasgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_aplicacion_gananciasgeneral_impl.class ));
   }

   public tipo_aplicacion_gananciasgeneral_impl( int remoteHandle ,
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
      cmbAplIIGGTrat = new HTMLChoice();
      cmbAplIIGGPrrtear = new HTMLChoice();
      dynAplIIGGCondicion = new HTMLChoice();
      cmbAplIIGGTopeTip = new HTMLChoice();
      dynAplIIGGgRelSec = new HTMLChoice();
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
               A1112AplIIGG = (short)(GXutil.lval( httpContext.GetPar( "AplIIGG"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1112AplIIGG)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"APLIIGGCONDICION") == 0 )
            {
               AV17CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlaapliiggcondicionBS2( AV17CliCod) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"APLIIGGGRELSEC") == 0 )
            {
               AV17CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlaapliigggrelsecBS2( AV17CliCod) ;
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
         paBS2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "tipo_aplicacion_ganancias General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.tipo_aplicacion_gananciasgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1112AplIIGG,4,0))}, new String[] {"CliCod","AplIIGG"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1112AplIIGG", GXutil.ltrim( localUtil.ntoc( wcpOA1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV17CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormBS2( )
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
      return "tipo_aplicacion_gananciasGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "tipo_aplicacion_ganancias General", "") ;
   }

   public void wbBS0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.tipo_aplicacion_gananciasgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAplIIGG_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtAplIIGG_Internalname, httpContext.getMessage( "Tratamiento IIGG Nro", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGG_Internalname, GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAplIIGG_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1112AplIIGG), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1112AplIIGG), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGG_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAplIIGG_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_tipo_aplicacion_gananciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAplIIGGNom_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtAplIIGGNom_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtAplIIGGNom_Internalname, A1113AplIIGGNom, "", "", (short)(0), 1, edtAplIIGGNom_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_tipo_aplicacion_gananciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbAplIIGGTrat.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbAplIIGGTrat.getInternalname(), httpContext.getMessage( "Tratamiento específico", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbAplIIGGTrat, cmbAplIIGGTrat.getInternalname(), GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0)), 1, cmbAplIIGGTrat.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbAplIIGGTrat.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_tipo_aplicacion_gananciasGeneral.htm");
         cmbAplIIGGTrat.setValue( GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbAplIIGGTrat.getInternalname(), "Values", cmbAplIIGGTrat.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAplIIGGPropor_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtAplIIGGPropor_Internalname, httpContext.getMessage( "Proporción del tope (1 =100%)", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGGPropor_Internalname, GXutil.ltrim( localUtil.ntoc( A1114AplIIGGPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAplIIGGPropor_Enabled!=0) ? localUtil.format( A1114AplIIGGPropor, "9.9999") : localUtil.format( A1114AplIIGGPropor, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGGPropor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAplIIGGPropor_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_tipo_aplicacion_gananciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavApliiggexencon_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavApliiggexencon_description_Internalname, httpContext.getMessage( "Concepto exento agrupador para F1357", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavApliiggexencon_description_Internalname, AV13AplIIGGExenCon_Description, GXutil.rtrim( localUtil.format( AV13AplIIGGExenCon_Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavApliiggexencon_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavApliiggexencon_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_tipo_aplicacion_gananciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbAplIIGGPrrtear.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbAplIIGGPrrtear.getInternalname(), httpContext.getMessage( "Tipo de cuota", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbAplIIGGPrrtear, cmbAplIIGGPrrtear.getInternalname(), GXutil.rtrim( A1121AplIIGGPrrtear), 1, cmbAplIIGGPrrtear.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbAplIIGGPrrtear.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_tipo_aplicacion_gananciasGeneral.htm");
         cmbAplIIGGPrrtear.setValue( GXutil.rtrim( A1121AplIIGGPrrtear) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbAplIIGGPrrtear.getInternalname(), "Values", cmbAplIIGGPrrtear.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynAplIIGGCondicion.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynAplIIGGCondicion.getInternalname(), httpContext.getMessage( "Condición a cumplir para exención", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynAplIIGGCondicion, dynAplIIGGCondicion.getInternalname(), GXutil.rtrim( A1124AplIIGGCondicion), 1, dynAplIIGGCondicion.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynAplIIGGCondicion.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_tipo_aplicacion_gananciasGeneral.htm");
         dynAplIIGGCondicion.setValue( GXutil.rtrim( A1124AplIIGGCondicion) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynAplIIGGCondicion.getInternalname(), "Values", dynAplIIGGCondicion.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_47_BS2( true) ;
      }
      else
      {
         wb_table1_47_BS2( false) ;
      }
      return  ;
   }

   public void wb_table1_47_BS2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynAplIIGGgRelSec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynAplIIGGgRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynAplIIGGgRelSec, dynAplIIGGgRelSec.getInternalname(), GXutil.trim( GXutil.str( A1998AplIIGGgRelSec, 6, 0)), 1, dynAplIIGGgRelSec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynAplIIGGgRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_tipo_aplicacion_gananciasGeneral.htm");
         dynAplIIGGgRelSec.setValue( GXutil.trim( GXutil.str( A1998AplIIGGgRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynAplIIGGgRelSec.getInternalname(), "Values", dynAplIIGGgRelSec.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11bs1_client"+"'", TempTags, "", 2, "HLP_tipo_aplicacion_gananciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12bs1_client"+"'", TempTags, "", 2, "HLP_tipo_aplicacion_gananciasGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_tipo_aplicacion_gananciasGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtApliIIGGExenOtr_Internalname, GXutil.rtrim( A1118ApliIIGGExenOtr), GXutil.rtrim( localUtil.format( A1118ApliIIGGExenOtr, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtApliIIGGExenOtr_Jsonclick, 0, "Attribute", "", "", "", "", edtApliIIGGExenOtr_Visible, 0, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_tipo_aplicacion_gananciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startBS2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "tipo_aplicacion_ganancias General", ""), (short)(0)) ;
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
            strupBS0( ) ;
         }
      }
   }

   public void wsBS2( )
   {
      startBS2( ) ;
      evtBS2( ) ;
   }

   public void evtBS2( )
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
                              strupBS0( ) ;
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
                              strupBS0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13BS2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBS0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14BS2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBS0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15BS2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBS0( ) ;
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
                              strupBS0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavApliiggexencon_description_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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

   public void weBS2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormBS2( ) ;
         }
      }
   }

   public void paBS2( )
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
            GX_FocusControl = edtavApliiggexencon_description_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlaapliiggcondicionBS2( int AV17CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaapliiggcondicion_dataBS2( AV17CliCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxaapliiggcondicion_htmlBS2( int AV17CliCod )
   {
      String gxdynajaxvalue;
      gxdlaapliiggcondicion_dataBS2( AV17CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynAplIIGGCondicion.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynAplIIGGCondicion.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaapliiggcondicion_dataBS2( int AV17CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00BS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV17CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00BS2_A1105CondExenIIGG[0]));
         gxdynajaxctrldescr.add(H00BS2_A1108CondexenIIGGNom[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlaapliigggrelsecBS2( int AV17CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaapliigggrelsec_dataBS2( AV17CliCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxaapliigggrelsec_htmlBS2( int AV17CliCod )
   {
      int gxdynajaxvalue;
      gxdlaapliigggrelsec_dataBS2( AV17CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynAplIIGGgRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynAplIIGGgRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaapliigggrelsec_dataBS2( int AV17CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00BS3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV17CliCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00BS3_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00BS3_A1880CliReDTChar[0]);
         pr_default.readNext(1);
      }
      pr_default.close(1);
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
      if ( cmbAplIIGGTrat.getItemCount() > 0 )
      {
         A1120AplIIGGTrat = (byte)(GXutil.lval( cmbAplIIGGTrat.getValidValue(GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbAplIIGGTrat.setValue( GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbAplIIGGTrat.getInternalname(), "Values", cmbAplIIGGTrat.ToJavascriptSource(), true);
      }
      if ( cmbAplIIGGPrrtear.getItemCount() > 0 )
      {
         A1121AplIIGGPrrtear = cmbAplIIGGPrrtear.getValidValue(A1121AplIIGGPrrtear) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbAplIIGGPrrtear.setValue( GXutil.rtrim( A1121AplIIGGPrrtear) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbAplIIGGPrrtear.getInternalname(), "Values", cmbAplIIGGPrrtear.ToJavascriptSource(), true);
      }
      if ( dynAplIIGGCondicion.getItemCount() > 0 )
      {
         A1124AplIIGGCondicion = dynAplIIGGCondicion.getValidValue(A1124AplIIGGCondicion) ;
         n1124AplIIGGCondicion = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynAplIIGGCondicion.setValue( GXutil.rtrim( A1124AplIIGGCondicion) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynAplIIGGCondicion.getInternalname(), "Values", dynAplIIGGCondicion.ToJavascriptSource(), true);
      }
      if ( cmbAplIIGGTopeTip.getItemCount() > 0 )
      {
         A1115AplIIGGTopeTip = (byte)(GXutil.lval( cmbAplIIGGTopeTip.getValidValue(GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbAplIIGGTopeTip.setValue( GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbAplIIGGTopeTip.getInternalname(), "Values", cmbAplIIGGTopeTip.ToJavascriptSource(), true);
      }
      if ( dynAplIIGGgRelSec.getItemCount() > 0 )
      {
         A1998AplIIGGgRelSec = (int)(GXutil.lval( dynAplIIGGgRelSec.getValidValue(GXutil.trim( GXutil.str( A1998AplIIGGgRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1998AplIIGGgRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1998AplIIGGgRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynAplIIGGgRelSec.setValue( GXutil.trim( GXutil.str( A1998AplIIGGgRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynAplIIGGgRelSec.getInternalname(), "Values", dynAplIIGGgRelSec.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfBS2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV24Pgmname = "tipo_aplicacion_gananciasGeneral" ;
      Gx_err = (short)(0) ;
      edtavApliiggexencon_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavApliiggexencon_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavApliiggexencon_description_Enabled), 5, 0), true);
      edtavApliiggtopevar_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavApliiggtopevar_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavApliiggtopevar_description_Enabled), 5, 0), true);
      edtavApliiggtopecon_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavApliiggtopecon_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavApliiggtopecon_description_Enabled), 5, 0), true);
   }

   public void rfBS2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15BS2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00BS4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1112AplIIGG)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A1118ApliIIGGExenOtr = H00BS4_A1118ApliIIGGExenOtr[0] ;
            n1118ApliIIGGExenOtr = H00BS4_n1118ApliIIGGExenOtr[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1118ApliIIGGExenOtr", A1118ApliIIGGExenOtr);
            A1998AplIIGGgRelSec = H00BS4_A1998AplIIGGgRelSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1998AplIIGGgRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1998AplIIGGgRelSec), 6, 0));
            A1119AplIIGGTopeFij = H00BS4_A1119AplIIGGTopeFij[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1119AplIIGGTopeFij", GXutil.ltrimstr( A1119AplIIGGTopeFij, 14, 2));
            A1115AplIIGGTopeTip = H00BS4_A1115AplIIGGTopeTip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
            A1124AplIIGGCondicion = H00BS4_A1124AplIIGGCondicion[0] ;
            n1124AplIIGGCondicion = H00BS4_n1124AplIIGGCondicion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
            A1121AplIIGGPrrtear = H00BS4_A1121AplIIGGPrrtear[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
            A1114AplIIGGPropor = H00BS4_A1114AplIIGGPropor[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1114AplIIGGPropor", GXutil.ltrimstr( A1114AplIIGGPropor, 6, 4));
            A1120AplIIGGTrat = H00BS4_A1120AplIIGGTrat[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
            A1113AplIIGGNom = H00BS4_A1113AplIIGGNom[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1113AplIIGGNom", A1113AplIIGGNom);
            /* Execute user event: Load */
            e14BS2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
         wbBS0( ) ;
      }
   }

   public void send_integrity_lvl_hashesBS2( )
   {
   }

   public void before_start_formulas( )
   {
      AV24Pgmname = "tipo_aplicacion_gananciasGeneral" ;
      Gx_err = (short)(0) ;
      edtavApliiggexencon_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavApliiggexencon_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavApliiggexencon_description_Enabled), 5, 0), true);
      edtavApliiggtopevar_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavApliiggtopevar_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavApliiggtopevar_description_Enabled), 5, 0), true);
      edtavApliiggtopecon_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavApliiggtopecon_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavApliiggtopecon_description_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strupBS0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13BS2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1112AplIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A1113AplIIGGNom = httpContext.cgiGet( edtAplIIGGNom_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1113AplIIGGNom", A1113AplIIGGNom);
         cmbAplIIGGTrat.setValue( httpContext.cgiGet( cmbAplIIGGTrat.getInternalname()) );
         A1120AplIIGGTrat = (byte)(GXutil.lval( httpContext.cgiGet( cmbAplIIGGTrat.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
         A1114AplIIGGPropor = localUtil.ctond( httpContext.cgiGet( edtAplIIGGPropor_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1114AplIIGGPropor", GXutil.ltrimstr( A1114AplIIGGPropor, 6, 4));
         AV13AplIIGGExenCon_Description = httpContext.cgiGet( edtavApliiggexencon_description_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13AplIIGGExenCon_Description", AV13AplIIGGExenCon_Description);
         cmbAplIIGGPrrtear.setValue( httpContext.cgiGet( cmbAplIIGGPrrtear.getInternalname()) );
         A1121AplIIGGPrrtear = httpContext.cgiGet( cmbAplIIGGPrrtear.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
         dynAplIIGGCondicion.setValue( httpContext.cgiGet( dynAplIIGGCondicion.getInternalname()) );
         A1124AplIIGGCondicion = httpContext.cgiGet( dynAplIIGGCondicion.getInternalname()) ;
         n1124AplIIGGCondicion = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
         cmbAplIIGGTopeTip.setValue( httpContext.cgiGet( cmbAplIIGGTopeTip.getInternalname()) );
         A1115AplIIGGTopeTip = (byte)(GXutil.lval( httpContext.cgiGet( cmbAplIIGGTopeTip.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
         AV12AplIIGGTopeVar_Description = httpContext.cgiGet( edtavApliiggtopevar_description_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12AplIIGGTopeVar_Description", AV12AplIIGGTopeVar_Description);
         AV21AplIIGGTopeCon_Description = httpContext.cgiGet( edtavApliiggtopecon_description_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21AplIIGGTopeCon_Description", AV21AplIIGGTopeCon_Description);
         A1119AplIIGGTopeFij = localUtil.ctond( httpContext.cgiGet( edtAplIIGGTopeFij_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1119AplIIGGTopeFij", GXutil.ltrimstr( A1119AplIIGGTopeFij, 14, 2));
         dynAplIIGGgRelSec.setValue( httpContext.cgiGet( dynAplIIGGgRelSec.getInternalname()) );
         A1998AplIIGGgRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynAplIIGGgRelSec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1998AplIIGGgRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1998AplIIGGgRelSec), 6, 0));
         A1118ApliIIGGExenOtr = httpContext.cgiGet( edtApliIIGGExenOtr_Internalname) ;
         n1118ApliIIGGExenOtr = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1118ApliIIGGExenOtr", A1118ApliIIGGExenOtr);
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
      e13BS2 ();
      if (returnInSub) return;
   }

   public void e13BS2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV17CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      tipo_aplicacion_gananciasgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV17CliCod = GXt_int1 ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_char4 = AV19Combo_DataJson ;
      GXv_char5[0] = AV20ComboSelectedValue ;
      GXv_char6[0] = AV21AplIIGGTopeCon_Description ;
      GXv_char7[0] = GXt_char4 ;
      new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGTopeCon", "UPD", false, A3CliCod, A1112AplIIGG, A3CliCod, "", GXv_char5, GXv_char6, GXv_char7) ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV20ComboSelectedValue = GXv_char5[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV21AplIIGGTopeCon_Description = GXv_char6[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.GXt_char4 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21AplIIGGTopeCon_Description", AV21AplIIGGTopeCon_Description);
      AV19Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV19Combo_DataJson ;
      GXv_char7[0] = AV20ComboSelectedValue ;
      GXv_char6[0] = AV21AplIIGGTopeCon_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGTopeCon", "UPD", false, A3CliCod, A1112AplIIGG, A3CliCod, "", GXv_char7, GXv_char6, GXv_char5) ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV20ComboSelectedValue = GXv_char7[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV21AplIIGGTopeCon_Description = GXv_char6[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21AplIIGGTopeCon_Description", AV21AplIIGGTopeCon_Description);
      AV19Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV19Combo_DataJson ;
      GXv_char7[0] = AV20ComboSelectedValue ;
      GXv_char6[0] = AV12AplIIGGTopeVar_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGTopeVar", "UPD", false, A3CliCod, A1112AplIIGG, A3CliCod, "", GXv_char7, GXv_char6, GXv_char5) ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV20ComboSelectedValue = GXv_char7[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV12AplIIGGTopeVar_Description = GXv_char6[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12AplIIGGTopeVar_Description", AV12AplIIGGTopeVar_Description);
      AV19Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV19Combo_DataJson ;
      GXv_char7[0] = AV20ComboSelectedValue ;
      GXv_char6[0] = AV12AplIIGGTopeVar_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGTopeVar", "UPD", false, A3CliCod, A1112AplIIGG, A3CliCod, "", GXv_char7, GXv_char6, GXv_char5) ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV20ComboSelectedValue = GXv_char7[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV12AplIIGGTopeVar_Description = GXv_char6[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12AplIIGGTopeVar_Description", AV12AplIIGGTopeVar_Description);
      AV19Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV19Combo_DataJson ;
      GXv_char7[0] = AV20ComboSelectedValue ;
      GXv_char6[0] = AV13AplIIGGExenCon_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGExenCon", "UPD", false, A3CliCod, A1112AplIIGG, A3CliCod, "", GXv_char7, GXv_char6, GXv_char5) ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV20ComboSelectedValue = GXv_char7[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV13AplIIGGExenCon_Description = GXv_char6[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13AplIIGGExenCon_Description", AV13AplIIGGExenCon_Description);
      AV19Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV19Combo_DataJson ;
      GXv_char7[0] = AV20ComboSelectedValue ;
      GXv_char6[0] = AV13AplIIGGExenCon_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGExenCon", "UPD", false, A3CliCod, A1112AplIIGG, A3CliCod, "", GXv_char7, GXv_char6, GXv_char5) ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV20ComboSelectedValue = GXv_char7[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.AV13AplIIGGExenCon_Description = GXv_char6[0] ;
      tipo_aplicacion_gananciasgeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13AplIIGGExenCon_Description", AV13AplIIGGExenCon_Description);
      AV19Combo_DataJson = GXt_char4 ;
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e14BS2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtApliIIGGExenOtr_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtApliIIGGExenOtr_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtApliIIGGExenOtr_Visible), 5, 0), true);
      GXt_boolean8 = AV16TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_aplicacion_ganancias_Update", GXv_boolean9) ;
      tipo_aplicacion_gananciasgeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV16TempBoolean = GXt_boolean8 ;
      if ( ! ( AV16TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean8 = AV16TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_aplicacion_ganancias_Delete", GXv_boolean9) ;
      tipo_aplicacion_gananciasgeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV16TempBoolean = GXt_boolean8 ;
      if ( ! ( AV16TempBoolean ) )
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV24Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "tipo_aplicacion_ganancias" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15BS2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV17CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      tipo_aplicacion_gananciasgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV17CliCod = GXt_int1 ;
   }

   public void wb_table1_47_BS2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup3_Internalname, httpContext.getMessage( "Tope", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_tipo_aplicacion_gananciasGeneral.htm");
         wb_table2_51_BS2( true) ;
      }
      else
      {
         wb_table2_51_BS2( false) ;
      }
      return  ;
   }

   public void wb_table2_51_BS2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_47_BS2e( true) ;
      }
      else
      {
         wb_table1_47_BS2e( false) ;
      }
   }

   public void wb_table2_51_BS2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable2_Internalname, tblUnnamedtable2_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbAplIIGGTopeTip.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbAplIIGGTopeTip.getInternalname(), httpContext.getMessage( "Tipo de tope", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbAplIIGGTopeTip, cmbAplIIGGTopeTip.getInternalname(), GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0)), 1, cmbAplIIGGTopeTip.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbAplIIGGTopeTip.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_tipo_aplicacion_gananciasGeneral.htm");
         cmbAplIIGGTopeTip.setValue( GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbAplIIGGTopeTip.getInternalname(), "Values", cmbAplIIGGTopeTip.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavApliiggtopevar_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavApliiggtopevar_description_Internalname, httpContext.getMessage( "Variable para tope", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavApliiggtopevar_description_Internalname, AV12AplIIGGTopeVar_Description, GXutil.rtrim( localUtil.format( AV12AplIIGGTopeVar_Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,61);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavApliiggtopevar_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavApliiggtopevar_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_tipo_aplicacion_gananciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavApliiggtopecon_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavApliiggtopecon_description_Internalname, httpContext.getMessage( "Concepto para tope", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavApliiggtopecon_description_Internalname, AV21AplIIGGTopeCon_Description, GXutil.rtrim( localUtil.format( AV21AplIIGGTopeCon_Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,66);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavApliiggtopecon_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavApliiggtopecon_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_tipo_aplicacion_gananciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtAplIIGGTopeFij_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtAplIIGGTopeFij_Internalname, httpContext.getMessage( "Tope fijo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGGTopeFij_Internalname, GXutil.ltrim( localUtil.ntoc( A1119AplIIGGTopeFij, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAplIIGGTopeFij_Enabled!=0) ? localUtil.format( A1119AplIIGGTopeFij, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1119AplIIGGTopeFij, "ZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGGTopeFij_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAplIIGGTopeFij_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_tipo_aplicacion_gananciasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_51_BS2e( true) ;
      }
      else
      {
         wb_table2_51_BS2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1112AplIIGG = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
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
      paBS2( ) ;
      wsBS2( ) ;
      weBS2( ) ;
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
      sCtrlA1112AplIIGG = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paBS2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "tipo_aplicacion_gananciasgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paBS2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1112AplIIGG = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1112AplIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1112AplIIGG != wcpOA1112AplIIGG ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1112AplIIGG = A1112AplIIGG ;
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
      sCtrlA1112AplIIGG = httpContext.cgiGet( sPrefix+"A1112AplIIGG_CTRL") ;
      if ( GXutil.len( sCtrlA1112AplIIGG) > 0 )
      {
         A1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA1112AplIIGG), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
      else
      {
         A1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1112AplIIGG_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paBS2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsBS2( ) ;
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
      wsBS2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1112AplIIGG_PARM", GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1112AplIIGG)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1112AplIIGG_CTRL", GXutil.rtrim( sCtrlA1112AplIIGG));
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
      weBS2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181782162", true, true);
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
      httpContext.AddJavascriptSource("tipo_aplicacion_gananciasgeneral.js", "?2025181782163", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtAplIIGG_Internalname = sPrefix+"APLIIGG" ;
      edtAplIIGGNom_Internalname = sPrefix+"APLIIGGNOM" ;
      cmbAplIIGGTrat.setInternalname( sPrefix+"APLIIGGTRAT" );
      edtAplIIGGPropor_Internalname = sPrefix+"APLIIGGPROPOR" ;
      edtavApliiggexencon_description_Internalname = sPrefix+"vAPLIIGGEXENCON_DESCRIPTION" ;
      cmbAplIIGGPrrtear.setInternalname( sPrefix+"APLIIGGPRRTEAR" );
      dynAplIIGGCondicion.setInternalname( sPrefix+"APLIIGGCONDICION" );
      cmbAplIIGGTopeTip.setInternalname( sPrefix+"APLIIGGTOPETIP" );
      edtavApliiggtopevar_description_Internalname = sPrefix+"vAPLIIGGTOPEVAR_DESCRIPTION" ;
      edtavApliiggtopecon_description_Internalname = sPrefix+"vAPLIIGGTOPECON_DESCRIPTION" ;
      edtAplIIGGTopeFij_Internalname = sPrefix+"APLIIGGTOPEFIJ" ;
      tblUnnamedtable2_Internalname = sPrefix+"UNNAMEDTABLE2" ;
      grpUnnamedgroup3_Internalname = sPrefix+"UNNAMEDGROUP3" ;
      tblUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      dynAplIIGGgRelSec.setInternalname( sPrefix+"APLIIGGGRELSEC" );
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtApliIIGGExenOtr_Internalname = sPrefix+"APLIIIGGEXENOTR" ;
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
      edtAplIIGGTopeFij_Jsonclick = "" ;
      edtAplIIGGTopeFij_Enabled = 0 ;
      edtavApliiggtopecon_description_Jsonclick = "" ;
      edtavApliiggtopecon_description_Enabled = 1 ;
      edtavApliiggtopevar_description_Jsonclick = "" ;
      edtavApliiggtopevar_description_Enabled = 1 ;
      cmbAplIIGGTopeTip.setJsonclick( "" );
      cmbAplIIGGTopeTip.setEnabled( 0 );
      edtApliIIGGExenOtr_Jsonclick = "" ;
      edtApliIIGGExenOtr_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      dynAplIIGGgRelSec.setJsonclick( "" );
      dynAplIIGGgRelSec.setEnabled( 0 );
      dynAplIIGGCondicion.setJsonclick( "" );
      dynAplIIGGCondicion.setEnabled( 0 );
      cmbAplIIGGPrrtear.setJsonclick( "" );
      cmbAplIIGGPrrtear.setEnabled( 0 );
      edtavApliiggexencon_description_Jsonclick = "" ;
      edtavApliiggexencon_description_Enabled = 1 ;
      edtAplIIGGPropor_Jsonclick = "" ;
      edtAplIIGGPropor_Enabled = 0 ;
      cmbAplIIGGTrat.setJsonclick( "" );
      cmbAplIIGGTrat.setEnabled( 0 );
      edtAplIIGGNom_Enabled = 0 ;
      edtAplIIGG_Jsonclick = "" ;
      edtAplIIGG_Enabled = 0 ;
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
      cmbAplIIGGTrat.setName( "APLIIGGTRAT" );
      cmbAplIIGGTrat.setWebtags( "" );
      cmbAplIIGGTrat.addItem(GXutil.trim( GXutil.str( 0, 2, 0)), httpContext.getMessage( "Ninguno", ""), (short)(0));
      cmbAplIIGGTrat.addItem("1", httpContext.getMessage( "Exento horas extras feriados y fines de semana", ""), (short)(0));
      cmbAplIIGGTrat.addItem("2", httpContext.getMessage( "SAC", ""), (short)(0));
      if ( cmbAplIIGGTrat.getItemCount() > 0 )
      {
      }
      cmbAplIIGGPrrtear.setName( "APLIIGGPRRTEAR" );
      cmbAplIIGGPrrtear.setWebtags( "" );
      cmbAplIIGGPrrtear.addItem("SIN", httpContext.getMessage( "Sin cuotas", ""), (short)(0));
      cmbAplIIGGPrrtear.addItem("FIJA", httpContext.getMessage( "Cuota fija", ""), (short)(0));
      cmbAplIIGGPrrtear.addItem("VAR", httpContext.getMessage( "Cuota variable", ""), (short)(0));
      if ( cmbAplIIGGPrrtear.getItemCount() > 0 )
      {
      }
      dynAplIIGGCondicion.setName( "APLIIGGCONDICION" );
      dynAplIIGGCondicion.setWebtags( "" );
      cmbAplIIGGTopeTip.setName( "APLIIGGTOPETIP" );
      cmbAplIIGGTopeTip.setWebtags( "" );
      cmbAplIIGGTopeTip.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "Sin Tope", ""), (short)(0));
      cmbAplIIGGTopeTip.addItem("1", httpContext.getMessage( "Variable", ""), (short)(0));
      cmbAplIIGGTopeTip.addItem("2", httpContext.getMessage( "Concepto", ""), (short)(0));
      cmbAplIIGGTopeTip.addItem("3", httpContext.getMessage( "Valor Fijo", ""), (short)(0));
      if ( cmbAplIIGGTopeTip.getItemCount() > 0 )
      {
      }
      dynAplIIGGgRelSec.setName( "APLIIGGGRELSEC" );
      dynAplIIGGgRelSec.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1112AplIIGG',fld:'APLIIGG',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11BS1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1112AplIIGG',fld:'APLIIGG',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12BS1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1112AplIIGG',fld:'APLIIGG',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_APLIIGG","{handler:'valid_Apliigg',iparms:[]");
      setEventMetadata("VALID_APLIIGG",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
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
      ClassString = "" ;
      StyleString = "" ;
      A1113AplIIGGNom = "" ;
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      TempTags = "" ;
      AV13AplIIGGExenCon_Description = "" ;
      A1121AplIIGGPrrtear = "" ;
      A1124AplIIGGCondicion = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      A1118ApliIIGGExenOtr = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H00BS2_A3CliCod = new int[1] ;
      H00BS2_A1105CondExenIIGG = new String[] {""} ;
      H00BS2_A1108CondexenIIGGNom = new String[] {""} ;
      H00BS3_A3CliCod = new int[1] ;
      H00BS3_A1885CliRelSec = new int[1] ;
      H00BS3_A1880CliReDTChar = new String[] {""} ;
      AV24Pgmname = "" ;
      H00BS4_A3CliCod = new int[1] ;
      H00BS4_A1112AplIIGG = new short[1] ;
      H00BS4_A1118ApliIIGGExenOtr = new String[] {""} ;
      H00BS4_n1118ApliIIGGExenOtr = new boolean[] {false} ;
      H00BS4_A1998AplIIGGgRelSec = new int[1] ;
      H00BS4_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00BS4_A1115AplIIGGTopeTip = new byte[1] ;
      H00BS4_A1124AplIIGGCondicion = new String[] {""} ;
      H00BS4_n1124AplIIGGCondicion = new boolean[] {false} ;
      H00BS4_A1121AplIIGGPrrtear = new String[] {""} ;
      H00BS4_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00BS4_A1120AplIIGGTrat = new byte[1] ;
      H00BS4_A1113AplIIGGNom = new String[] {""} ;
      A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      AV12AplIIGGTopeVar_Description = "" ;
      AV21AplIIGGTopeCon_Description = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV19Combo_DataJson = "" ;
      AV20ComboSelectedValue = "" ;
      GXt_char4 = "" ;
      GXv_char7 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_char5 = new String[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      sStyleString = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1112AplIIGG = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_aplicacion_gananciasgeneral__default(),
         new Object[] {
             new Object[] {
            H00BS2_A3CliCod, H00BS2_A1105CondExenIIGG, H00BS2_A1108CondexenIIGGNom
            }
            , new Object[] {
            H00BS3_A3CliCod, H00BS3_A1885CliRelSec, H00BS3_A1880CliReDTChar
            }
            , new Object[] {
            H00BS4_A3CliCod, H00BS4_A1112AplIIGG, H00BS4_A1118ApliIIGGExenOtr, H00BS4_n1118ApliIIGGExenOtr, H00BS4_A1998AplIIGGgRelSec, H00BS4_A1119AplIIGGTopeFij, H00BS4_A1115AplIIGGTopeTip, H00BS4_A1124AplIIGGCondicion, H00BS4_n1124AplIIGGCondicion, H00BS4_A1121AplIIGGPrrtear,
            H00BS4_A1114AplIIGGPropor, H00BS4_A1120AplIIGGTrat, H00BS4_A1113AplIIGGNom
            }
         }
      );
      AV24Pgmname = "tipo_aplicacion_gananciasGeneral" ;
      /* GeneXus formulas. */
      AV24Pgmname = "tipo_aplicacion_gananciasGeneral" ;
      Gx_err = (short)(0) ;
      edtavApliiggexencon_description_Enabled = 0 ;
      edtavApliiggtopevar_description_Enabled = 0 ;
      edtavApliiggtopecon_description_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1120AplIIGGTrat ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte A1115AplIIGGTopeTip ;
   private byte nGXWrapped ;
   private short wcpOA1112AplIIGG ;
   private short A1112AplIIGG ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int AV17CliCod ;
   private int edtAplIIGG_Enabled ;
   private int edtAplIIGGNom_Enabled ;
   private int edtAplIIGGPropor_Enabled ;
   private int edtavApliiggexencon_description_Enabled ;
   private int A1998AplIIGGgRelSec ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtApliIIGGExenOtr_Visible ;
   private int gxdynajaxindex ;
   private int edtavApliiggtopevar_description_Enabled ;
   private int edtavApliiggtopecon_description_Enabled ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtAplIIGGTopeFij_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal A1114AplIIGGPropor ;
   private java.math.BigDecimal A1119AplIIGGTopeFij ;
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
   private String edtAplIIGG_Internalname ;
   private String edtAplIIGG_Jsonclick ;
   private String edtAplIIGGNom_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtAplIIGGPropor_Internalname ;
   private String edtAplIIGGPropor_Jsonclick ;
   private String edtavApliiggexencon_description_Internalname ;
   private String TempTags ;
   private String edtavApliiggexencon_description_Jsonclick ;
   private String A1121AplIIGGPrrtear ;
   private String A1124AplIIGGCondicion ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtApliIIGGExenOtr_Internalname ;
   private String A1118ApliIIGGExenOtr ;
   private String edtApliIIGGExenOtr_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV24Pgmname ;
   private String edtavApliiggtopevar_description_Internalname ;
   private String edtavApliiggtopecon_description_Internalname ;
   private String edtAplIIGGTopeFij_Internalname ;
   private String GXt_char4 ;
   private String GXv_char7[] ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String sStyleString ;
   private String tblUnnamedtable1_Internalname ;
   private String grpUnnamedgroup3_Internalname ;
   private String tblUnnamedtable2_Internalname ;
   private String edtavApliiggtopevar_description_Jsonclick ;
   private String edtavApliiggtopecon_description_Jsonclick ;
   private String edtAplIIGGTopeFij_Jsonclick ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1112AplIIGG ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1124AplIIGGCondicion ;
   private boolean n1118ApliIIGGExenOtr ;
   private boolean returnInSub ;
   private boolean AV16TempBoolean ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private String AV19Combo_DataJson ;
   private String A1113AplIIGGNom ;
   private String AV13AplIIGGExenCon_Description ;
   private String AV12AplIIGGTopeVar_Description ;
   private String AV21AplIIGGTopeCon_Description ;
   private String AV20ComboSelectedValue ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private HTMLChoice cmbAplIIGGTrat ;
   private HTMLChoice cmbAplIIGGPrrtear ;
   private HTMLChoice dynAplIIGGCondicion ;
   private HTMLChoice cmbAplIIGGTopeTip ;
   private HTMLChoice dynAplIIGGgRelSec ;
   private IDataStoreProvider pr_default ;
   private int[] H00BS2_A3CliCod ;
   private String[] H00BS2_A1105CondExenIIGG ;
   private String[] H00BS2_A1108CondexenIIGGNom ;
   private int[] H00BS3_A3CliCod ;
   private int[] H00BS3_A1885CliRelSec ;
   private String[] H00BS3_A1880CliReDTChar ;
   private int[] H00BS4_A3CliCod ;
   private short[] H00BS4_A1112AplIIGG ;
   private String[] H00BS4_A1118ApliIIGGExenOtr ;
   private boolean[] H00BS4_n1118ApliIIGGExenOtr ;
   private int[] H00BS4_A1998AplIIGGgRelSec ;
   private java.math.BigDecimal[] H00BS4_A1119AplIIGGTopeFij ;
   private byte[] H00BS4_A1115AplIIGGTopeTip ;
   private String[] H00BS4_A1124AplIIGGCondicion ;
   private boolean[] H00BS4_n1124AplIIGGCondicion ;
   private String[] H00BS4_A1121AplIIGGPrrtear ;
   private java.math.BigDecimal[] H00BS4_A1114AplIIGGPropor ;
   private byte[] H00BS4_A1120AplIIGGTrat ;
   private String[] H00BS4_A1113AplIIGGNom ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class tipo_aplicacion_gananciasgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00BS2", "SELECT CliCod, CondExenIIGG, CondexenIIGGNom FROM condicion_exencion_iigg WHERE CliCod = ? ORDER BY CondexenIIGGNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00BS3", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00BS4", "SELECT CliCod, AplIIGG, ApliIIGGExenOtr, AplIIGGgRelSec, AplIIGGTopeFij, AplIIGGTopeTip, AplIIGGCondicion, AplIIGGPrrtear, AplIIGGPropor, AplIIGGTrat, AplIIGGNom FROM tipo_aplicacion_ganancias WHERE CliCod = ? and AplIIGG = ? ORDER BY CliCod, AplIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,2);
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(8, 20);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,4);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((String[]) buf[12])[0] = rslt.getVarchar(11);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

