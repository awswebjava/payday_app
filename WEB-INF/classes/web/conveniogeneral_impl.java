package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conveniogeneral_impl extends GXWebComponent
{
   public conveniogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conveniogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conveniogeneral_impl.class ));
   }

   public conveniogeneral_impl( int remoteHandle ,
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
      dynConveSinCod = new HTMLChoice();
      cmbConvScrapTDoc = new HTMLChoice();
      cmbConvScrapTipo = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
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
               A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A9ConveCodigo = httpContext.GetPar( "ConveCodigo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A9ConveCodigo", A9ConveCodigo);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A46PaiCod),A9ConveCodigo});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVESINCOD") == 0 )
            {
               AV19Paicod = (short)(GXutil.lval( httpContext.GetPar( "Paicod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlaconvesincod6M2( AV19Paicod) ;
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
               gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
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
         pa6M2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Convenio General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conveniogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(A9ConveCodigo))}, new String[] {"PaiCod","ConveCodigo"}) +"\">") ;
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
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ConvenioGeneral");
      forbiddenHiddens.add("ConvBaseURL", GXutil.rtrim( localUtil.format( A1917ConvBaseURL, "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("conveniogeneral:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA46PaiCod", GXutil.ltrim( localUtil.ntoc( wcpOA46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA9ConveCodigo", GXutil.rtrim( wcpOA9ConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PAICOD", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPAICOD", GXutil.ltrim( localUtil.ntoc( AV19Paicod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseForm6M2( )
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
      return "ConvenioGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Convenio General", "") ;
   }

   public void wb6M0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.conveniogeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveCodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveCodigo_Internalname, GXutil.rtrim( A9ConveCodigo), GXutil.rtrim( localUtil.format( A9ConveCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveCodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConvenioGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveDescri_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveDescri_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtConveDescri_Internalname, A160ConveDescri, "", "", (short)(0), 1, edtConveDescri_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ConvenioGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConveSinCod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynConveSinCod.getInternalname(), httpContext.getMessage( "Sindicato", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConveSinCod, dynConveSinCod.getInternalname(), GXutil.rtrim( A935ConveSinCod), 1, dynConveSinCod.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynConveSinCod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConvenioGeneral.htm");
         dynConveSinCod.setValue( GXutil.rtrim( A935ConveSinCod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynConveSinCod.getInternalname(), "Values", dynConveSinCod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveEscFrecAct_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveEscFrecAct_Internalname, httpContext.getMessage( "Frecuenca de actualización (meses) de escalas salariales", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveEscFrecAct_Internalname, GXutil.ltrim( localUtil.ntoc( A2131ConveEscFrecAct, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveEscFrecAct_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveEscFrecAct_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveEscFrecAct_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConvenioGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConvBusGoogle_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConvBusGoogle_Internalname, httpContext.getMessage( "Bus Google", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConvBusGoogle_Internalname, A1915ConvBusGoogle, GXutil.rtrim( localUtil.format( A1915ConvBusGoogle, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConvBusGoogle_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConvBusGoogle_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConvenioGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConvBusWeb_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConvBusWeb_Internalname, httpContext.getMessage( "Bus Web", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConvBusWeb_Internalname, A1916ConvBusWeb, GXutil.rtrim( localUtil.format( A1916ConvBusWeb, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConvBusWeb_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConvBusWeb_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConvenioGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConvBaseURL_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConvBaseURL_Internalname, httpContext.getMessage( "Base URL", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConvBaseURL_Internalname, A1917ConvBaseURL, GXutil.rtrim( localUtil.format( A1917ConvBaseURL, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtConvBaseURL_Link, edtConvBaseURL_Linktarget, "", "", edtConvBaseURL_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConvBaseURL_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ConvenioGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConvScrapTDoc.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConvScrapTDoc.getInternalname(), httpContext.getMessage( "Scrap TDoc", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConvScrapTDoc, cmbConvScrapTDoc.getInternalname(), GXutil.rtrim( A1919ConvScrapTDoc), 1, cmbConvScrapTDoc.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConvScrapTDoc.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConvenioGeneral.htm");
         cmbConvScrapTDoc.setValue( GXutil.rtrim( A1919ConvScrapTDoc) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConvScrapTDoc.getInternalname(), "Values", cmbConvScrapTDoc.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConvScrapTipo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConvScrapTipo.getInternalname(), httpContext.getMessage( "Scrap Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConvScrapTipo, cmbConvScrapTipo.getInternalname(), GXutil.rtrim( A1918ConvScrapTipo), 1, cmbConvScrapTipo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConvScrapTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConvenioGeneral.htm");
         cmbConvScrapTipo.setValue( GXutil.rtrim( A1918ConvScrapTipo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConvScrapTipo.getInternalname(), "Values", cmbConvScrapTipo.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e116m1_client"+"'", TempTags, "", 2, "HLP_ConvenioGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e126m1_client"+"'", TempTags, "", 2, "HLP_ConvenioGeneral.htm");
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

   public void start6M2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Convenio General", ""), (short)(0)) ;
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
            strup6M0( ) ;
         }
      }
   }

   public void ws6M2( )
   {
      start6M2( ) ;
      evt6M2( ) ;
   }

   public void evt6M2( )
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
                              strup6M0( ) ;
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
                              strup6M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e136M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e146M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e156M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6M0( ) ;
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
                              strup6M0( ) ;
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

   public void we6M2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm6M2( ) ;
         }
      }
   }

   public void pa6M2( )
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

   public void gxdlaconvesincod6M2( short AV19Paicod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconvesincod_data6M2( AV19Paicod) ;
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

   public void gxaconvesincod_html6M2( short AV19Paicod )
   {
      String gxdynajaxvalue;
      gxdlaconvesincod_data6M2( AV19Paicod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveSinCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynConveSinCod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynConveSinCod.getItemCount() > 0 )
      {
         A935ConveSinCod = dynConveSinCod.getValidValue(A935ConveSinCod) ;
         n935ConveSinCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A935ConveSinCod", A935ConveSinCod);
      }
   }

   protected void gxdlaconvesincod_data6M2( short AV19Paicod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H006M2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV19Paicod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H006M2_A14SinCod[0]));
         gxdynajaxctrldescr.add(H006M2_A331SinDescrip[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
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
      if ( dynConveSinCod.getItemCount() > 0 )
      {
         A935ConveSinCod = dynConveSinCod.getValidValue(A935ConveSinCod) ;
         n935ConveSinCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A935ConveSinCod", A935ConveSinCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveSinCod.setValue( GXutil.rtrim( A935ConveSinCod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynConveSinCod.getInternalname(), "Values", dynConveSinCod.ToJavascriptSource(), true);
      }
      if ( cmbConvScrapTDoc.getItemCount() > 0 )
      {
         A1919ConvScrapTDoc = cmbConvScrapTDoc.getValidValue(A1919ConvScrapTDoc) ;
         n1919ConvScrapTDoc = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1919ConvScrapTDoc", A1919ConvScrapTDoc);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConvScrapTDoc.setValue( GXutil.rtrim( A1919ConvScrapTDoc) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConvScrapTDoc.getInternalname(), "Values", cmbConvScrapTDoc.ToJavascriptSource(), true);
      }
      if ( cmbConvScrapTipo.getItemCount() > 0 )
      {
         A1918ConvScrapTipo = cmbConvScrapTipo.getValidValue(A1918ConvScrapTipo) ;
         n1918ConvScrapTipo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1918ConvScrapTipo", A1918ConvScrapTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConvScrapTipo.setValue( GXutil.rtrim( A1918ConvScrapTipo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConvScrapTipo.getInternalname(), "Values", cmbConvScrapTipo.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf6M2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "ConvenioGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf6M2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e156M2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H006M3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1918ConvScrapTipo = H006M3_A1918ConvScrapTipo[0] ;
            n1918ConvScrapTipo = H006M3_n1918ConvScrapTipo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1918ConvScrapTipo", A1918ConvScrapTipo);
            A1919ConvScrapTDoc = H006M3_A1919ConvScrapTDoc[0] ;
            n1919ConvScrapTDoc = H006M3_n1919ConvScrapTDoc[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1919ConvScrapTDoc", A1919ConvScrapTDoc);
            A1917ConvBaseURL = H006M3_A1917ConvBaseURL[0] ;
            n1917ConvBaseURL = H006M3_n1917ConvBaseURL[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1917ConvBaseURL", A1917ConvBaseURL);
            A1916ConvBusWeb = H006M3_A1916ConvBusWeb[0] ;
            n1916ConvBusWeb = H006M3_n1916ConvBusWeb[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1916ConvBusWeb", A1916ConvBusWeb);
            A1915ConvBusGoogle = H006M3_A1915ConvBusGoogle[0] ;
            n1915ConvBusGoogle = H006M3_n1915ConvBusGoogle[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1915ConvBusGoogle", A1915ConvBusGoogle);
            A2131ConveEscFrecAct = H006M3_A2131ConveEscFrecAct[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2131ConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), 4, 0));
            A935ConveSinCod = H006M3_A935ConveSinCod[0] ;
            n935ConveSinCod = H006M3_n935ConveSinCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A935ConveSinCod", A935ConveSinCod);
            A160ConveDescri = H006M3_A160ConveDescri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A160ConveDescri", A160ConveDescri);
            /* Execute user event: Load */
            e146M2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         wb6M0( ) ;
      }
   }

   public void send_integrity_lvl_hashes6M2( )
   {
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "ConvenioGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup6M0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e136M2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA9ConveCodigo = httpContext.cgiGet( sPrefix+"wcpOA9ConveCodigo") ;
         A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"PAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A160ConveDescri = httpContext.cgiGet( edtConveDescri_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A160ConveDescri", A160ConveDescri);
         dynConveSinCod.setValue( httpContext.cgiGet( dynConveSinCod.getInternalname()) );
         A935ConveSinCod = httpContext.cgiGet( dynConveSinCod.getInternalname()) ;
         n935ConveSinCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A935ConveSinCod", A935ConveSinCod);
         A2131ConveEscFrecAct = (short)(localUtil.ctol( httpContext.cgiGet( edtConveEscFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2131ConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), 4, 0));
         A1915ConvBusGoogle = httpContext.cgiGet( edtConvBusGoogle_Internalname) ;
         n1915ConvBusGoogle = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1915ConvBusGoogle", A1915ConvBusGoogle);
         A1916ConvBusWeb = httpContext.cgiGet( edtConvBusWeb_Internalname) ;
         n1916ConvBusWeb = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1916ConvBusWeb", A1916ConvBusWeb);
         A1917ConvBaseURL = httpContext.cgiGet( edtConvBaseURL_Internalname) ;
         n1917ConvBaseURL = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1917ConvBaseURL", A1917ConvBaseURL);
         cmbConvScrapTDoc.setValue( httpContext.cgiGet( cmbConvScrapTDoc.getInternalname()) );
         A1919ConvScrapTDoc = httpContext.cgiGet( cmbConvScrapTDoc.getInternalname()) ;
         n1919ConvScrapTDoc = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1919ConvScrapTDoc", A1919ConvScrapTDoc);
         cmbConvScrapTipo.setValue( httpContext.cgiGet( cmbConvScrapTipo.getInternalname()) );
         A1918ConvScrapTipo = httpContext.cgiGet( cmbConvScrapTipo.getInternalname()) ;
         n1918ConvScrapTipo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1918ConvScrapTipo", A1918ConvScrapTipo);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ConvenioGeneral");
         A1917ConvBaseURL = httpContext.cgiGet( edtConvBaseURL_Internalname) ;
         n1917ConvBaseURL = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1917ConvBaseURL", A1917ConvBaseURL);
         forbiddenHiddens.add("ConvBaseURL", GXutil.rtrim( localUtil.format( A1917ConvBaseURL, "")));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("conveniogeneral:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e136M2 ();
      if (returnInSub) return;
   }

   public void e136M2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV15CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conveniogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV15CliCod = GXt_int1 ;
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

   protected void e146M2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtConvBaseURL_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConvBaseURL_Internalname, "Linktarget", edtConvBaseURL_Linktarget, true);
      edtConvBaseURL_Link = A1917ConvBaseURL ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConvBaseURL_Internalname, "Link", edtConvBaseURL_Link, true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Update", GXv_boolean5) ;
      conveniogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Delete", GXv_boolean5) ;
      conveniogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV18Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Convenio" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e156M2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV15CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conveniogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV15CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A9ConveCodigo = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A9ConveCodigo", A9ConveCodigo);
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
      pa6M2( ) ;
      ws6M2( ) ;
      we6M2( ) ;
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
      sCtrlA46PaiCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlA9ConveCodigo = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa6M2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "conveniogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa6M2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A9ConveCodigo = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A9ConveCodigo", A9ConveCodigo);
      }
      wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA9ConveCodigo = httpContext.cgiGet( sPrefix+"wcpOA9ConveCodigo") ;
      if ( ! GetJustCreated( ) && ( ( A46PaiCod != wcpOA46PaiCod ) || ( GXutil.strcmp(A9ConveCodigo, wcpOA9ConveCodigo) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA46PaiCod = A46PaiCod ;
      wcpOA9ConveCodigo = A9ConveCodigo ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA46PaiCod = httpContext.cgiGet( sPrefix+"A46PaiCod_CTRL") ;
      if ( GXutil.len( sCtrlA46PaiCod) > 0 )
      {
         A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA46PaiCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A46PaiCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA9ConveCodigo = httpContext.cgiGet( sPrefix+"A9ConveCodigo_CTRL") ;
      if ( GXutil.len( sCtrlA9ConveCodigo) > 0 )
      {
         A9ConveCodigo = httpContext.cgiGet( sCtrlA9ConveCodigo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A9ConveCodigo", A9ConveCodigo);
      }
      else
      {
         A9ConveCodigo = httpContext.cgiGet( sPrefix+"A9ConveCodigo_PARM") ;
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
      pa6M2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws6M2( ) ;
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
      ws6M2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A46PaiCod_PARM", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA46PaiCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A46PaiCod_CTRL", GXutil.rtrim( sCtrlA46PaiCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A9ConveCodigo_PARM", GXutil.rtrim( A9ConveCodigo));
      if ( GXutil.len( GXutil.rtrim( sCtrlA9ConveCodigo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A9ConveCodigo_CTRL", GXutil.rtrim( sCtrlA9ConveCodigo));
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
      we6M2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251717583797", true, true);
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
      httpContext.AddJavascriptSource("conveniogeneral.js", "?20251717583798", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtConveCodigo_Internalname = sPrefix+"CONVECODIGO" ;
      edtConveDescri_Internalname = sPrefix+"CONVEDESCRI" ;
      dynConveSinCod.setInternalname( sPrefix+"CONVESINCOD" );
      edtConveEscFrecAct_Internalname = sPrefix+"CONVEESCFRECACT" ;
      edtConvBusGoogle_Internalname = sPrefix+"CONVBUSGOOGLE" ;
      edtConvBusWeb_Internalname = sPrefix+"CONVBUSWEB" ;
      edtConvBaseURL_Internalname = sPrefix+"CONVBASEURL" ;
      cmbConvScrapTDoc.setInternalname( sPrefix+"CONVSCRAPTDOC" );
      cmbConvScrapTipo.setInternalname( sPrefix+"CONVSCRAPTIPO" );
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
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
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      cmbConvScrapTipo.setJsonclick( "" );
      cmbConvScrapTipo.setEnabled( 0 );
      cmbConvScrapTDoc.setJsonclick( "" );
      cmbConvScrapTDoc.setEnabled( 0 );
      edtConvBaseURL_Jsonclick = "" ;
      edtConvBaseURL_Linktarget = "" ;
      edtConvBaseURL_Link = "" ;
      edtConvBaseURL_Enabled = 0 ;
      edtConvBusWeb_Jsonclick = "" ;
      edtConvBusWeb_Enabled = 0 ;
      edtConvBusGoogle_Jsonclick = "" ;
      edtConvBusGoogle_Enabled = 0 ;
      edtConveEscFrecAct_Jsonclick = "" ;
      edtConveEscFrecAct_Enabled = 0 ;
      dynConveSinCod.setJsonclick( "" );
      dynConveSinCod.setEnabled( 0 );
      edtConveDescri_Enabled = 0 ;
      edtConveCodigo_Jsonclick = "" ;
      edtConveCodigo_Enabled = 0 ;
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
      dynConveSinCod.setName( "CONVESINCOD" );
      dynConveSinCod.setWebtags( "" );
      cmbConvScrapTDoc.setName( "CONVSCRAPTDOC" );
      cmbConvScrapTDoc.setWebtags( "" );
      cmbConvScrapTDoc.addItem("HTML", httpContext.getMessage( "Html", ""), (short)(0));
      cmbConvScrapTDoc.addItem("PDF", httpContext.getMessage( "PDF", ""), (short)(0));
      if ( cmbConvScrapTDoc.getItemCount() > 0 )
      {
      }
      cmbConvScrapTipo.setName( "CONVSCRAPTIPO" );
      cmbConvScrapTipo.setWebtags( "" );
      cmbConvScrapTipo.addItem("Tabla", httpContext.getMessage( "Tabla", ""), (short)(0));
      cmbConvScrapTipo.addItem("Texto", httpContext.getMessage( "Texto", ""), (short)(0));
      cmbConvScrapTipo.addItem("Imagen", httpContext.getMessage( "Imagen", ""), (short)(0));
      if ( cmbConvScrapTipo.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A9ConveCodigo',fld:'CONVECODIGO',pic:''},{av:'A1917ConvBaseURL',fld:'CONVBASEURL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e116M1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A9ConveCodigo',fld:'CONVECODIGO',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e126M1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A9ConveCodigo',fld:'CONVECODIGO',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CONVECODIGO","{handler:'valid_Convecodigo',iparms:[]");
      setEventMetadata("VALID_CONVECODIGO",",oparms:[]}");
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
      wcpOA9ConveCodigo = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A9ConveCodigo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      A1917ConvBaseURL = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A160ConveDescri = "" ;
      A935ConveSinCod = "" ;
      A1915ConvBusGoogle = "" ;
      A1916ConvBusWeb = "" ;
      A1919ConvScrapTDoc = "" ;
      A1918ConvScrapTipo = "" ;
      TempTags = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H006M2_A46PaiCod = new short[1] ;
      H006M2_A14SinCod = new String[] {""} ;
      H006M2_A331SinDescrip = new String[] {""} ;
      AV18Pgmname = "" ;
      H006M3_A46PaiCod = new short[1] ;
      H006M3_A9ConveCodigo = new String[] {""} ;
      H006M3_A1918ConvScrapTipo = new String[] {""} ;
      H006M3_n1918ConvScrapTipo = new boolean[] {false} ;
      H006M3_A1919ConvScrapTDoc = new String[] {""} ;
      H006M3_n1919ConvScrapTDoc = new boolean[] {false} ;
      H006M3_A1917ConvBaseURL = new String[] {""} ;
      H006M3_n1917ConvBaseURL = new boolean[] {false} ;
      H006M3_A1916ConvBusWeb = new String[] {""} ;
      H006M3_n1916ConvBusWeb = new boolean[] {false} ;
      H006M3_A1915ConvBusGoogle = new String[] {""} ;
      H006M3_n1915ConvBusGoogle = new boolean[] {false} ;
      H006M3_A2131ConveEscFrecAct = new short[1] ;
      H006M3_A935ConveSinCod = new String[] {""} ;
      H006M3_n935ConveSinCod = new boolean[] {false} ;
      H006M3_A160ConveDescri = new String[] {""} ;
      hsh = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA46PaiCod = "" ;
      sCtrlA9ConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conveniogeneral__default(),
         new Object[] {
             new Object[] {
            H006M2_A46PaiCod, H006M2_A14SinCod, H006M2_A331SinDescrip
            }
            , new Object[] {
            H006M3_A46PaiCod, H006M3_A9ConveCodigo, H006M3_A1918ConvScrapTipo, H006M3_n1918ConvScrapTipo, H006M3_A1919ConvScrapTDoc, H006M3_n1919ConvScrapTDoc, H006M3_A1917ConvBaseURL, H006M3_n1917ConvBaseURL, H006M3_A1916ConvBusWeb, H006M3_n1916ConvBusWeb,
            H006M3_A1915ConvBusGoogle, H006M3_n1915ConvBusGoogle, H006M3_A2131ConveEscFrecAct, H006M3_A935ConveSinCod, H006M3_n935ConveSinCod, H006M3_A160ConveDescri
            }
         }
      );
      AV18Pgmname = "ConvenioGeneral" ;
      /* GeneXus formulas. */
      AV18Pgmname = "ConvenioGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA46PaiCod ;
   private short A46PaiCod ;
   private short AV19Paicod ;
   private short wbEnd ;
   private short wbStart ;
   private short A2131ConveEscFrecAct ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtConveCodigo_Enabled ;
   private int edtConveDescri_Enabled ;
   private int edtConveEscFrecAct_Enabled ;
   private int edtConvBusGoogle_Enabled ;
   private int edtConvBusWeb_Enabled ;
   private int edtConvBaseURL_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int gxdynajaxindex ;
   private int AV15CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String wcpOA9ConveCodigo ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A9ConveCodigo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtConveCodigo_Internalname ;
   private String edtConveCodigo_Jsonclick ;
   private String edtConveDescri_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String A935ConveSinCod ;
   private String edtConveEscFrecAct_Internalname ;
   private String edtConveEscFrecAct_Jsonclick ;
   private String edtConvBusGoogle_Internalname ;
   private String edtConvBusGoogle_Jsonclick ;
   private String edtConvBusWeb_Internalname ;
   private String edtConvBusWeb_Jsonclick ;
   private String edtConvBaseURL_Internalname ;
   private String edtConvBaseURL_Link ;
   private String edtConvBaseURL_Linktarget ;
   private String edtConvBaseURL_Jsonclick ;
   private String A1919ConvScrapTDoc ;
   private String A1918ConvScrapTipo ;
   private String TempTags ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV18Pgmname ;
   private String hsh ;
   private String sCtrlA46PaiCod ;
   private String sCtrlA9ConveCodigo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n935ConveSinCod ;
   private boolean n1919ConvScrapTDoc ;
   private boolean n1918ConvScrapTipo ;
   private boolean n1917ConvBaseURL ;
   private boolean n1916ConvBusWeb ;
   private boolean n1915ConvBusGoogle ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A1917ConvBaseURL ;
   private String A160ConveDescri ;
   private String A1915ConvBusGoogle ;
   private String A1916ConvBusWeb ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynConveSinCod ;
   private HTMLChoice cmbConvScrapTDoc ;
   private HTMLChoice cmbConvScrapTipo ;
   private IDataStoreProvider pr_default ;
   private short[] H006M2_A46PaiCod ;
   private String[] H006M2_A14SinCod ;
   private String[] H006M2_A331SinDescrip ;
   private short[] H006M3_A46PaiCod ;
   private String[] H006M3_A9ConveCodigo ;
   private String[] H006M3_A1918ConvScrapTipo ;
   private boolean[] H006M3_n1918ConvScrapTipo ;
   private String[] H006M3_A1919ConvScrapTDoc ;
   private boolean[] H006M3_n1919ConvScrapTDoc ;
   private String[] H006M3_A1917ConvBaseURL ;
   private boolean[] H006M3_n1917ConvBaseURL ;
   private String[] H006M3_A1916ConvBusWeb ;
   private boolean[] H006M3_n1916ConvBusWeb ;
   private String[] H006M3_A1915ConvBusGoogle ;
   private boolean[] H006M3_n1915ConvBusGoogle ;
   private short[] H006M3_A2131ConveEscFrecAct ;
   private String[] H006M3_A935ConveSinCod ;
   private boolean[] H006M3_n935ConveSinCod ;
   private String[] H006M3_A160ConveDescri ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class conveniogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006M2", "SELECT PaiCod, SinCod, SinDescrip FROM Sindicato WHERE PaiCod = ? ORDER BY SinDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006M3", "SELECT PaiCod, ConveCodigo, ConvScrapTipo, ConvScrapTDoc, ConvBaseURL, ConvBusWeb, ConvBusGoogle, ConveEscFrecAct, ConveSinCod, ConveDescri FROM Convenio WHERE PaiCod = ? and ConveCodigo = ( ?) ORDER BY PaiCod, ConveCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(8);
               ((String[]) buf[13])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

