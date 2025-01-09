package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class situaciongeneral_impl extends GXWebComponent
{
   public situaciongeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public situaciongeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( situaciongeneral_impl.class ));
   }

   public situaciongeneral_impl( int remoteHandle ,
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
      chkSitEsLicencia = UIFactory.getCheckbox(this);
      chkSitLicCuentaTrab = UIFactory.getCheckbox(this);
      chkSitEsAusencia = UIFactory.getCheckbox(this);
      chkSitAbsorbeFer = UIFactory.getCheckbox(this);
      chkEstadoCanPresen = UIFactory.getCheckbox(this);
      chkEstadoRemCorr = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "SitCodigo") ;
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
               A16SitCodigo = httpContext.GetPar( "SitCodigo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A16SitCodigo", A16SitCodigo);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,A16SitCodigo});
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
               gxfirstwebparm = httpContext.GetFirstPar( "SitCodigo") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "SitCodigo") ;
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
         pa5F2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Situacion General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.situaciongeneral", new String[] {GXutil.URLEncode(GXutil.rtrim(A16SitCodigo))}, new String[] {"SitCodigo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"SituacionGeneral");
      A738SitEsLicencia = GXutil.strtobool( GXutil.booltostr( A738SitEsLicencia)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A738SitEsLicencia", A738SitEsLicencia);
      forbiddenHiddens.add("SitEsLicencia", GXutil.booltostr( A738SitEsLicencia));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("situaciongeneral:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA16SitCodigo", GXutil.rtrim( wcpOA16SitCodigo));
   }

   public void renderHtmlCloseForm5F2( )
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
      return "SituacionGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Situacion General", "") ;
   }

   public void wb5F0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.situaciongeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSitCodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtSitCodigo_Internalname, httpContext.getMessage( "Situacion de Revista", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtSitCodigo_Internalname, GXutil.rtrim( A16SitCodigo), GXutil.rtrim( localUtil.format( A16SitCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSitCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSitCodigo_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_SituacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSitDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtSitDescrip_Internalname, httpContext.getMessage( "Situación de Revista", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtSitDescrip_Internalname, A334SitDescrip, GXutil.rtrim( localUtil.format( A334SitDescrip, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSitDescrip_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSitDescrip_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_SituacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSitEsLicencia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkSitEsLicencia.getInternalname(), httpContext.getMessage( "Es Licencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSitEsLicencia.getInternalname(), GXutil.booltostr( A738SitEsLicencia), "", httpContext.getMessage( "Es Licencia", ""), 1, chkSitEsLicencia.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divSitliccuentatrab_cell_Internalname, 1, 0, "px", 0, "px", divSitliccuentatrab_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkSitLicCuentaTrab.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSitLicCuentaTrab.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkSitLicCuentaTrab.getInternalname(), httpContext.getMessage( "Con goce de sueldo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSitLicCuentaTrab.getInternalname(), GXutil.booltostr( A739SitLicCuentaTrab), "", httpContext.getMessage( "Con goce de sueldo", ""), chkSitLicCuentaTrab.getVisible(), chkSitLicCuentaTrab.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSitEsAusencia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkSitEsAusencia.getInternalname(), httpContext.getMessage( "Es Ausencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSitEsAusencia.getInternalname(), GXutil.booltostr( A916SitEsAusencia), "", httpContext.getMessage( "Es Ausencia", ""), 1, chkSitEsAusencia.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSitAbsorbeFer.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkSitAbsorbeFer.getInternalname(), httpContext.getMessage( "Absorbe feriado", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSitAbsorbeFer.getInternalname(), GXutil.booltostr( A1220SitAbsorbeFer), "", httpContext.getMessage( "Absorbe feriado", ""), 1, chkSitAbsorbeFer.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEstadoCanPresen.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkEstadoCanPresen.getInternalname(), httpContext.getMessage( "Cancela presentismo (para fuera de convenio)", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEstadoCanPresen.getInternalname(), GXutil.booltostr( A1807EstadoCanPresen), "", httpContext.getMessage( "Cancela presentismo (para fuera de convenio)", ""), 1, chkEstadoCanPresen.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEstadoRemCorr.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkEstadoRemCorr.getInternalname(), httpContext.getMessage( "Remunera días corridos para jornales", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEstadoRemCorr.getInternalname(), GXutil.booltostr( A1809EstadoRemCorr), "", httpContext.getMessage( "Remunera días corridos para jornales", ""), 1, chkEstadoRemCorr.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEstadositrevista_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEstadositrevista_description_Internalname, httpContext.getMessage( "Situación de revista AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEstadositrevista_description_Internalname, AV15EstadoSitRevista_Description, GXutil.rtrim( localUtil.format( AV15EstadoSitRevista_Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEstadositrevista_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEstadositrevista_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_SituacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEstadosiniestro_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEstadosiniestro_description_Internalname, httpContext.getMessage( "Siniestrado AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEstadosiniestro_description_Internalname, AV16EstadoSiniestro_Description, GXutil.rtrim( localUtil.format( AV16EstadoSiniestro_Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEstadosiniestro_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEstadosiniestro_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_SituacionGeneral.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e115f1_client"+"'", TempTags, "", 2, "HLP_SituacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnDefault" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e125f1_client"+"'", TempTags, "", 2, "HLP_SituacionGeneral.htm");
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

   public void start5F2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Situacion General", ""), (short)(0)) ;
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
            strup5F0( ) ;
         }
      }
   }

   public void ws5F2( )
   {
      start5F2( ) ;
      evt5F2( ) ;
   }

   public void evt5F2( )
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
                              strup5F0( ) ;
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
                              strup5F0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e135F2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5F0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e145F2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5F0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e155F2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5F0( ) ;
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
                              strup5F0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavEstadositrevista_description_Internalname ;
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

   public void we5F2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm5F2( ) ;
         }
      }
   }

   public void pa5F2( )
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
            GX_FocusControl = edtavEstadositrevista_description_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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
      A738SitEsLicencia = GXutil.strtobool( GXutil.booltostr( A738SitEsLicencia)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A738SitEsLicencia", A738SitEsLicencia);
      A739SitLicCuentaTrab = GXutil.strtobool( GXutil.booltostr( A739SitLicCuentaTrab)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A739SitLicCuentaTrab", A739SitLicCuentaTrab);
      A916SitEsAusencia = GXutil.strtobool( GXutil.booltostr( A916SitEsAusencia)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A916SitEsAusencia", A916SitEsAusencia);
      A1220SitAbsorbeFer = GXutil.strtobool( GXutil.booltostr( A1220SitAbsorbeFer)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1220SitAbsorbeFer", A1220SitAbsorbeFer);
      A1807EstadoCanPresen = GXutil.strtobool( GXutil.booltostr( A1807EstadoCanPresen)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1807EstadoCanPresen", A1807EstadoCanPresen);
      A1809EstadoRemCorr = GXutil.strtobool( GXutil.booltostr( A1809EstadoRemCorr)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1809EstadoRemCorr", A1809EstadoRemCorr);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf5F2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV21Pgmname = "SituacionGeneral" ;
      Gx_err = (short)(0) ;
      edtavEstadositrevista_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadositrevista_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadositrevista_description_Enabled), 5, 0), true);
      edtavEstadosiniestro_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadosiniestro_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadosiniestro_description_Enabled), 5, 0), true);
   }

   public void rf5F2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e155F2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H005F2 */
         pr_default.execute(0, new Object[] {A16SitCodigo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1809EstadoRemCorr = H005F2_A1809EstadoRemCorr[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1809EstadoRemCorr", A1809EstadoRemCorr);
            A1807EstadoCanPresen = H005F2_A1807EstadoCanPresen[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1807EstadoCanPresen", A1807EstadoCanPresen);
            A1220SitAbsorbeFer = H005F2_A1220SitAbsorbeFer[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1220SitAbsorbeFer", A1220SitAbsorbeFer);
            A916SitEsAusencia = H005F2_A916SitEsAusencia[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A916SitEsAusencia", A916SitEsAusencia);
            A739SitLicCuentaTrab = H005F2_A739SitLicCuentaTrab[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A739SitLicCuentaTrab", A739SitLicCuentaTrab);
            A738SitEsLicencia = H005F2_A738SitEsLicencia[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A738SitEsLicencia", A738SitEsLicencia);
            A334SitDescrip = H005F2_A334SitDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A334SitDescrip", A334SitDescrip);
            /* Execute user event: Load */
            e145F2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb5F0( ) ;
      }
   }

   public void send_integrity_lvl_hashes5F2( )
   {
   }

   public void before_start_formulas( )
   {
      AV21Pgmname = "SituacionGeneral" ;
      Gx_err = (short)(0) ;
      edtavEstadositrevista_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadositrevista_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadositrevista_description_Enabled), 5, 0), true);
      edtavEstadosiniestro_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadosiniestro_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadosiniestro_description_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup5F0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e135F2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA16SitCodigo = httpContext.cgiGet( sPrefix+"wcpOA16SitCodigo") ;
         /* Read variables values. */
         A334SitDescrip = GXutil.upper( httpContext.cgiGet( edtSitDescrip_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A334SitDescrip", A334SitDescrip);
         A738SitEsLicencia = GXutil.strtobool( httpContext.cgiGet( chkSitEsLicencia.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A738SitEsLicencia", A738SitEsLicencia);
         A739SitLicCuentaTrab = GXutil.strtobool( httpContext.cgiGet( chkSitLicCuentaTrab.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A739SitLicCuentaTrab", A739SitLicCuentaTrab);
         A916SitEsAusencia = GXutil.strtobool( httpContext.cgiGet( chkSitEsAusencia.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A916SitEsAusencia", A916SitEsAusencia);
         A1220SitAbsorbeFer = GXutil.strtobool( httpContext.cgiGet( chkSitAbsorbeFer.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1220SitAbsorbeFer", A1220SitAbsorbeFer);
         A1807EstadoCanPresen = GXutil.strtobool( httpContext.cgiGet( chkEstadoCanPresen.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1807EstadoCanPresen", A1807EstadoCanPresen);
         A1809EstadoRemCorr = GXutil.strtobool( httpContext.cgiGet( chkEstadoRemCorr.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1809EstadoRemCorr", A1809EstadoRemCorr);
         AV15EstadoSitRevista_Description = httpContext.cgiGet( edtavEstadositrevista_description_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15EstadoSitRevista_Description", AV15EstadoSitRevista_Description);
         AV16EstadoSiniestro_Description = httpContext.cgiGet( edtavEstadosiniestro_description_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16EstadoSiniestro_Description", AV16EstadoSiniestro_Description);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"SituacionGeneral");
         A738SitEsLicencia = GXutil.strtobool( httpContext.cgiGet( chkSitEsLicencia.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A738SitEsLicencia", A738SitEsLicencia);
         forbiddenHiddens.add("SitEsLicencia", GXutil.booltostr( A738SitEsLicencia));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("situaciongeneral:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e135F2 ();
      if (returnInSub) return;
   }

   public void e135F2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV11CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      situaciongeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV11CliCod = GXt_int1 ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_char4 = AV17Combo_DataJson ;
      GXv_char5[0] = AV18ComboSelectedValue ;
      GXv_char6[0] = AV16EstadoSiniestro_Description ;
      GXv_char7[0] = GXt_char4 ;
      new web.estadoloaddvcombo(remoteHandle, context).execute( "EstadoSiniestro", "UPD", false, A16SitCodigo, "", GXv_char5, GXv_char6, GXv_char7) ;
      situaciongeneral_impl.this.AV18ComboSelectedValue = GXv_char5[0] ;
      situaciongeneral_impl.this.AV16EstadoSiniestro_Description = GXv_char6[0] ;
      situaciongeneral_impl.this.GXt_char4 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16EstadoSiniestro_Description", AV16EstadoSiniestro_Description);
      AV17Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV17Combo_DataJson ;
      GXv_char7[0] = AV18ComboSelectedValue ;
      GXv_char6[0] = AV16EstadoSiniestro_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.estadoloaddvcombo(remoteHandle, context).execute( "EstadoSiniestro", "UPD", false, A16SitCodigo, "", GXv_char7, GXv_char6, GXv_char5) ;
      situaciongeneral_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
      situaciongeneral_impl.this.AV16EstadoSiniestro_Description = GXv_char6[0] ;
      situaciongeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16EstadoSiniestro_Description", AV16EstadoSiniestro_Description);
      AV17Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV17Combo_DataJson ;
      GXv_char7[0] = AV18ComboSelectedValue ;
      GXv_char6[0] = AV15EstadoSitRevista_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.estadoloaddvcombo(remoteHandle, context).execute( "EstadoSitRevista", "UPD", false, A16SitCodigo, "", GXv_char7, GXv_char6, GXv_char5) ;
      situaciongeneral_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
      situaciongeneral_impl.this.AV15EstadoSitRevista_Description = GXv_char6[0] ;
      situaciongeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15EstadoSitRevista_Description", AV15EstadoSitRevista_Description);
      AV17Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV17Combo_DataJson ;
      GXv_char7[0] = AV18ComboSelectedValue ;
      GXv_char6[0] = AV15EstadoSitRevista_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.estadoloaddvcombo(remoteHandle, context).execute( "EstadoSitRevista", "UPD", false, A16SitCodigo, "", GXv_char7, GXv_char6, GXv_char5) ;
      situaciongeneral_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
      situaciongeneral_impl.this.AV15EstadoSitRevista_Description = GXv_char6[0] ;
      situaciongeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15EstadoSitRevista_Description", AV15EstadoSitRevista_Description);
      AV17Combo_DataJson = GXt_char4 ;
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e145F2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean8 = AV14TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion_Update", GXv_boolean9) ;
      situaciongeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV14TempBoolean = GXt_boolean8 ;
      if ( AV14TempBoolean )
      {
         GXt_boolean8 = AV14TempBoolean ;
         GXv_boolean9[0] = GXt_boolean8 ;
         new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean9) ;
         situaciongeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
         AV14TempBoolean = (boolean)((GXt_boolean8)) ;
         if ( ! ( AV14TempBoolean ) )
         {
            bttBtnupdate_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
         }
      }
      else
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean8 = AV14TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion_Delete", GXv_boolean9) ;
      situaciongeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV14TempBoolean = GXt_boolean8 ;
      if ( ! ( AV14TempBoolean ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
      if ( ! ( ( A738SitEsLicencia ) ) )
      {
         chkSitLicCuentaTrab.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkSitLicCuentaTrab.getInternalname(), "Visible", GXutil.ltrimstr( chkSitLicCuentaTrab.getVisible(), 5, 0), true);
         divSitliccuentatrab_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divSitliccuentatrab_cell_Internalname, "Class", divSitliccuentatrab_cell_Class, true);
      }
      else
      {
         chkSitLicCuentaTrab.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkSitLicCuentaTrab.getInternalname(), "Visible", GXutil.ltrimstr( chkSitLicCuentaTrab.getVisible(), 5, 0), true);
         divSitliccuentatrab_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divSitliccuentatrab_cell_Internalname, "Class", divSitliccuentatrab_cell_Class, true);
      }
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV7TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV21Pgmname );
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV10HTTPRequest.getScriptName()+"?"+AV10HTTPRequest.getQuerystring() );
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Estado" );
      AV9Session.setValue("TrnContext", AV7TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e155F2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV11CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      situaciongeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV11CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A16SitCodigo = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A16SitCodigo", A16SitCodigo);
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
      pa5F2( ) ;
      ws5F2( ) ;
      we5F2( ) ;
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
      sCtrlA16SitCodigo = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa5F2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "situaciongeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa5F2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A16SitCodigo = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A16SitCodigo", A16SitCodigo);
      }
      wcpOA16SitCodigo = httpContext.cgiGet( sPrefix+"wcpOA16SitCodigo") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(A16SitCodigo, wcpOA16SitCodigo) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA16SitCodigo = A16SitCodigo ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA16SitCodigo = httpContext.cgiGet( sPrefix+"A16SitCodigo_CTRL") ;
      if ( GXutil.len( sCtrlA16SitCodigo) > 0 )
      {
         A16SitCodigo = httpContext.cgiGet( sCtrlA16SitCodigo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A16SitCodigo", A16SitCodigo);
      }
      else
      {
         A16SitCodigo = httpContext.cgiGet( sPrefix+"A16SitCodigo_PARM") ;
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
      pa5F2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws5F2( ) ;
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
      ws5F2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A16SitCodigo_PARM", GXutil.rtrim( A16SitCodigo));
      if ( GXutil.len( GXutil.rtrim( sCtrlA16SitCodigo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A16SitCodigo_CTRL", GXutil.rtrim( sCtrlA16SitCodigo));
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
      we5F2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020401070", true, true);
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
      httpContext.AddJavascriptSource("situaciongeneral.js", "?2024122020401071", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtSitCodigo_Internalname = sPrefix+"SITCODIGO" ;
      edtSitDescrip_Internalname = sPrefix+"SITDESCRIP" ;
      chkSitEsLicencia.setInternalname( sPrefix+"SITESLICENCIA" );
      chkSitLicCuentaTrab.setInternalname( sPrefix+"SITLICCUENTATRAB" );
      divSitliccuentatrab_cell_Internalname = sPrefix+"SITLICCUENTATRAB_CELL" ;
      chkSitEsAusencia.setInternalname( sPrefix+"SITESAUSENCIA" );
      chkSitAbsorbeFer.setInternalname( sPrefix+"SITABSORBEFER" );
      chkEstadoCanPresen.setInternalname( sPrefix+"ESTADOCANPRESEN" );
      chkEstadoRemCorr.setInternalname( sPrefix+"ESTADOREMCORR" );
      edtavEstadositrevista_description_Internalname = sPrefix+"vESTADOSITREVISTA_DESCRIPTION" ;
      edtavEstadosiniestro_description_Internalname = sPrefix+"vESTADOSINIESTRO_DESCRIPTION" ;
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
      edtavEstadosiniestro_description_Jsonclick = "" ;
      edtavEstadosiniestro_description_Enabled = 1 ;
      edtavEstadositrevista_description_Jsonclick = "" ;
      edtavEstadositrevista_description_Enabled = 1 ;
      chkEstadoRemCorr.setEnabled( 0 );
      chkEstadoCanPresen.setEnabled( 0 );
      chkSitAbsorbeFer.setEnabled( 0 );
      chkSitEsAusencia.setEnabled( 0 );
      chkSitLicCuentaTrab.setEnabled( 0 );
      chkSitLicCuentaTrab.setVisible( 1 );
      divSitliccuentatrab_cell_Class = "col-xs-12" ;
      chkSitEsLicencia.setEnabled( 0 );
      edtSitDescrip_Jsonclick = "" ;
      edtSitDescrip_Enabled = 0 ;
      edtSitCodigo_Jsonclick = "" ;
      edtSitCodigo_Enabled = 0 ;
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
      chkSitEsLicencia.setName( "SITESLICENCIA" );
      chkSitEsLicencia.setWebtags( "" );
      chkSitEsLicencia.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkSitEsLicencia.getInternalname(), "TitleCaption", chkSitEsLicencia.getCaption(), true);
      chkSitEsLicencia.setCheckedValue( "false" );
      chkSitLicCuentaTrab.setName( "SITLICCUENTATRAB" );
      chkSitLicCuentaTrab.setWebtags( "" );
      chkSitLicCuentaTrab.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkSitLicCuentaTrab.getInternalname(), "TitleCaption", chkSitLicCuentaTrab.getCaption(), true);
      chkSitLicCuentaTrab.setCheckedValue( "false" );
      chkSitEsAusencia.setName( "SITESAUSENCIA" );
      chkSitEsAusencia.setWebtags( "" );
      chkSitEsAusencia.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkSitEsAusencia.getInternalname(), "TitleCaption", chkSitEsAusencia.getCaption(), true);
      chkSitEsAusencia.setCheckedValue( "false" );
      chkSitAbsorbeFer.setName( "SITABSORBEFER" );
      chkSitAbsorbeFer.setWebtags( "" );
      chkSitAbsorbeFer.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkSitAbsorbeFer.getInternalname(), "TitleCaption", chkSitAbsorbeFer.getCaption(), true);
      chkSitAbsorbeFer.setCheckedValue( "false" );
      chkEstadoCanPresen.setName( "ESTADOCANPRESEN" );
      chkEstadoCanPresen.setWebtags( "" );
      chkEstadoCanPresen.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEstadoCanPresen.getInternalname(), "TitleCaption", chkEstadoCanPresen.getCaption(), true);
      chkEstadoCanPresen.setCheckedValue( "false" );
      chkEstadoRemCorr.setName( "ESTADOREMCORR" );
      chkEstadoRemCorr.setWebtags( "" );
      chkEstadoRemCorr.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEstadoRemCorr.getInternalname(), "TitleCaption", chkEstadoRemCorr.getCaption(), true);
      chkEstadoRemCorr.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A16SitCodigo',fld:'SITCODIGO',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''},{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e115F1',iparms:[{av:'A16SitCodigo',fld:'SITCODIGO',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e125F1',iparms:[{av:'A16SitCodigo',fld:'SITCODIGO',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_SITCODIGO","{handler:'valid_Sitcodigo',iparms:[]");
      setEventMetadata("VALID_SITCODIGO",",oparms:[]}");
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
      wcpOA16SitCodigo = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A16SitCodigo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      GX_FocusControl = "" ;
      A334SitDescrip = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      AV15EstadoSitRevista_Description = "" ;
      AV16EstadoSiniestro_Description = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV21Pgmname = "" ;
      scmdbuf = "" ;
      H005F2_A16SitCodigo = new String[] {""} ;
      H005F2_A1809EstadoRemCorr = new boolean[] {false} ;
      H005F2_A1807EstadoCanPresen = new boolean[] {false} ;
      H005F2_A1220SitAbsorbeFer = new boolean[] {false} ;
      H005F2_A916SitEsAusencia = new boolean[] {false} ;
      H005F2_A739SitLicCuentaTrab = new boolean[] {false} ;
      H005F2_A738SitEsLicencia = new boolean[] {false} ;
      H005F2_A334SitDescrip = new String[] {""} ;
      hsh = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV17Combo_DataJson = "" ;
      AV18ComboSelectedValue = "" ;
      GXt_char4 = "" ;
      GXv_char7 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_char5 = new String[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV7TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10HTTPRequest = httpContext.getHttpRequest();
      AV9Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA16SitCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.situaciongeneral__default(),
         new Object[] {
             new Object[] {
            H005F2_A16SitCodigo, H005F2_A1809EstadoRemCorr, H005F2_A1807EstadoCanPresen, H005F2_A1220SitAbsorbeFer, H005F2_A916SitEsAusencia, H005F2_A739SitLicCuentaTrab, H005F2_A738SitEsLicencia, H005F2_A334SitDescrip
            }
         }
      );
      AV21Pgmname = "SituacionGeneral" ;
      /* GeneXus formulas. */
      AV21Pgmname = "SituacionGeneral" ;
      Gx_err = (short)(0) ;
      edtavEstadositrevista_description_Enabled = 0 ;
      edtavEstadosiniestro_description_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtSitCodigo_Enabled ;
   private int edtSitDescrip_Enabled ;
   private int edtavEstadositrevista_description_Enabled ;
   private int edtavEstadosiniestro_description_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int AV11CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String wcpOA16SitCodigo ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A16SitCodigo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtSitCodigo_Internalname ;
   private String edtSitCodigo_Jsonclick ;
   private String edtSitDescrip_Internalname ;
   private String edtSitDescrip_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divSitliccuentatrab_cell_Internalname ;
   private String divSitliccuentatrab_cell_Class ;
   private String edtavEstadositrevista_description_Internalname ;
   private String TempTags ;
   private String edtavEstadositrevista_description_Jsonclick ;
   private String edtavEstadosiniestro_description_Internalname ;
   private String edtavEstadosiniestro_description_Jsonclick ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV21Pgmname ;
   private String scmdbuf ;
   private String hsh ;
   private String GXt_char4 ;
   private String GXv_char7[] ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String sCtrlA16SitCodigo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean A738SitEsLicencia ;
   private boolean wbLoad ;
   private boolean A739SitLicCuentaTrab ;
   private boolean A916SitEsAusencia ;
   private boolean A1220SitAbsorbeFer ;
   private boolean A1807EstadoCanPresen ;
   private boolean A1809EstadoRemCorr ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV14TempBoolean ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private String AV17Combo_DataJson ;
   private String A334SitDescrip ;
   private String AV15EstadoSitRevista_Description ;
   private String AV16EstadoSiniestro_Description ;
   private String AV18ComboSelectedValue ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV10HTTPRequest ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkSitEsLicencia ;
   private ICheckbox chkSitLicCuentaTrab ;
   private ICheckbox chkSitEsAusencia ;
   private ICheckbox chkSitAbsorbeFer ;
   private ICheckbox chkEstadoCanPresen ;
   private ICheckbox chkEstadoRemCorr ;
   private IDataStoreProvider pr_default ;
   private String[] H005F2_A16SitCodigo ;
   private boolean[] H005F2_A1809EstadoRemCorr ;
   private boolean[] H005F2_A1807EstadoCanPresen ;
   private boolean[] H005F2_A1220SitAbsorbeFer ;
   private boolean[] H005F2_A916SitEsAusencia ;
   private boolean[] H005F2_A739SitLicCuentaTrab ;
   private boolean[] H005F2_A738SitEsLicencia ;
   private String[] H005F2_A334SitDescrip ;
   private com.genexus.webpanels.WebSession AV9Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV7TrnContext ;
}

final  class situaciongeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H005F2", "SELECT SitCodigo, EstadoRemCorr, EstadoCanPresen, SitAbsorbeFer, SitEsAusencia, SitLicCuentaTrab, SitEsLicencia, SitDescrip FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
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
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}

