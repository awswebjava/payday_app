package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class condicion_exencion_iigggeneral_impl extends GXWebComponent
{
   public condicion_exencion_iigggeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public condicion_exencion_iigggeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condicion_exencion_iigggeneral_impl.class ));
   }

   public condicion_exencion_iigggeneral_impl( int remoteHandle ,
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
      chkCondExenIIGGAcu = UIFactory.getCheckbox(this);
      chkCondExenIIGGProm = UIFactory.getCheckbox(this);
      cmbCondExenIIGGOpe = new HTMLChoice();
      dynCondExenRelSec = new HTMLChoice();
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
               A1105CondExenIIGG = httpContext.GetPar( "CondExenIIGG") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1105CondExenIIGG", A1105CondExenIIGG);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),A1105CondExenIIGG});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONDEXENRELSEC") == 0 )
            {
               AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlacondexenrelsecBN2( AV14CliCod) ;
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
         paBN2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "condicion_exencion_iigg General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.condicion_exencion_iigggeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A1105CondExenIIGG))}, new String[] {"CliCod","CondExenIIGG"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1105CondExenIIGG", GXutil.rtrim( wcpOA1105CondExenIIGG));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV14CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormBN2( )
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
      return "condicion_exencion_iiggGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "condicion_exencion_iigg General", "") ;
   }

   public void wbBN0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.condicion_exencion_iigggeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCondExenIIGG_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCondExenIIGG_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCondExenIIGG_Internalname, GXutil.rtrim( A1105CondExenIIGG), GXutil.rtrim( localUtil.format( A1105CondExenIIGG, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCondExenIIGG_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCondExenIIGG_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_condicion_exencion_iiggGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCondexeniiggcon_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCondexeniiggcon_description_Internalname, httpContext.getMessage( "Concepto a evaluar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCondexeniiggcon_description_Internalname, AV18CondExenIIGGCon_Description, GXutil.rtrim( localUtil.format( AV18CondExenIIGGCon_Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,19);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCondexeniiggcon_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCondexeniiggcon_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_condicion_exencion_iiggGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCondExenIIGGAcu.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkCondExenIIGGAcu.getInternalname(), httpContext.getMessage( "Acumulado", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCondExenIIGGAcu.getInternalname(), GXutil.booltostr( A1106CondExenIIGGAcu), "", httpContext.getMessage( "Acumulado", ""), 1, chkCondExenIIGGAcu.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCondExenIIGGProm.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkCondExenIIGGProm.getInternalname(), httpContext.getMessage( "Promedio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCondExenIIGGProm.getInternalname(), GXutil.booltostr( A1107CondExenIIGGProm), "", httpContext.getMessage( "Promedio", ""), 1, chkCondExenIIGGProm.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCondExenIIGGOpe.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbCondExenIIGGOpe.getInternalname(), httpContext.getMessage( "Operador de comparación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCondExenIIGGOpe, cmbCondExenIIGGOpe.getInternalname(), GXutil.rtrim( A2238CondExenIIGGOpe), 1, cmbCondExenIIGGOpe.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCondExenIIGGOpe.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_condicion_exencion_iiggGeneral.htm");
         cmbCondExenIIGGOpe.setValue( GXutil.rtrim( A2238CondExenIIGGOpe) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCondExenIIGGOpe.getInternalname(), "Values", cmbCondExenIIGGOpe.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCondexeniiggvar_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCondexeniiggvar_description_Internalname, httpContext.getMessage( "Variable a comparar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCondexeniiggvar_description_Internalname, AV12CondExenIIGGVar_Description, GXutil.rtrim( localUtil.format( AV12CondExenIIGGVar_Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCondexeniiggvar_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCondexeniiggvar_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_condicion_exencion_iiggGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCondExenIIGGVFi_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCondExenIIGGVFi_Internalname, httpContext.getMessage( "Valor fijo a comparar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCondExenIIGGVFi_Internalname, GXutil.ltrim( localUtil.ntoc( A2237CondExenIIGGVFi, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCondExenIIGGVFi_Enabled!=0) ? localUtil.format( A2237CondExenIIGGVFi, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A2237CondExenIIGGVFi, "ZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCondExenIIGGVFi_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCondExenIIGGVFi_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_condicion_exencion_iiggGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCondexenIIGGNom_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCondexenIIGGNom_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtCondexenIIGGNom_Internalname, A1108CondexenIIGGNom, "", "", (short)(0), 1, edtCondexenIIGGNom_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_condicion_exencion_iiggGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCondExenRelSec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynCondExenRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCondExenRelSec, dynCondExenRelSec.getInternalname(), GXutil.trim( GXutil.str( A2001CondExenRelSec, 6, 0)), 1, dynCondExenRelSec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynCondExenRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_condicion_exencion_iiggGeneral.htm");
         dynCondExenRelSec.setValue( GXutil.trim( GXutil.str( A2001CondExenRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynCondExenRelSec.getInternalname(), "Values", dynCondExenRelSec.ToJavascriptSource(), true);
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
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11bn1_client"+"'", TempTags, "", 2, "HLP_condicion_exencion_iiggGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12bn1_client"+"'", TempTags, "", 2, "HLP_condicion_exencion_iiggGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_condicion_exencion_iiggGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startBN2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "condicion_exencion_iigg General", ""), (short)(0)) ;
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
            strupBN0( ) ;
         }
      }
   }

   public void wsBN2( )
   {
      startBN2( ) ;
      evtBN2( ) ;
   }

   public void evtBN2( )
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
                              strupBN0( ) ;
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
                              strupBN0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13BN2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBN0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14BN2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBN0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15BN2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBN0( ) ;
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
                              strupBN0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavCondexeniiggcon_description_Internalname ;
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

   public void weBN2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormBN2( ) ;
         }
      }
   }

   public void paBN2( )
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
            GX_FocusControl = edtavCondexeniiggcon_description_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlacondexenrelsecBN2( int AV14CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacondexenrelsec_dataBN2( AV14CliCod) ;
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

   public void gxacondexenrelsec_htmlBN2( int AV14CliCod )
   {
      int gxdynajaxvalue;
      gxdlacondexenrelsec_dataBN2( AV14CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCondExenRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynCondExenRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacondexenrelsec_dataBN2( int AV14CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00BN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00BN2_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00BN2_A1880CliReDTChar[0]);
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
      A1106CondExenIIGGAcu = GXutil.strtobool( GXutil.booltostr( A1106CondExenIIGGAcu)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
      A1107CondExenIIGGProm = GXutil.strtobool( GXutil.booltostr( A1107CondExenIIGGProm)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
      if ( cmbCondExenIIGGOpe.getItemCount() > 0 )
      {
         A2238CondExenIIGGOpe = cmbCondExenIIGGOpe.getValidValue(A2238CondExenIIGGOpe) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2238CondExenIIGGOpe", A2238CondExenIIGGOpe);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCondExenIIGGOpe.setValue( GXutil.rtrim( A2238CondExenIIGGOpe) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCondExenIIGGOpe.getInternalname(), "Values", cmbCondExenIIGGOpe.ToJavascriptSource(), true);
      }
      if ( dynCondExenRelSec.getItemCount() > 0 )
      {
         A2001CondExenRelSec = (int)(GXutil.lval( dynCondExenRelSec.getValidValue(GXutil.trim( GXutil.str( A2001CondExenRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2001CondExenRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2001CondExenRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCondExenRelSec.setValue( GXutil.trim( GXutil.str( A2001CondExenRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynCondExenRelSec.getInternalname(), "Values", dynCondExenRelSec.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfBN2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV21Pgmname = "condicion_exencion_iiggGeneral" ;
      Gx_err = (short)(0) ;
      edtavCondexeniiggcon_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCondexeniiggcon_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCondexeniiggcon_description_Enabled), 5, 0), true);
      edtavCondexeniiggvar_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCondexeniiggvar_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCondexeniiggvar_description_Enabled), 5, 0), true);
   }

   public void rfBN2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15BN2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00BN3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A1105CondExenIIGG});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2001CondExenRelSec = H00BN3_A2001CondExenRelSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2001CondExenRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2001CondExenRelSec), 6, 0));
            A1108CondexenIIGGNom = H00BN3_A1108CondexenIIGGNom[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1108CondexenIIGGNom", A1108CondexenIIGGNom);
            A2237CondExenIIGGVFi = H00BN3_A2237CondExenIIGGVFi[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2237CondExenIIGGVFi", GXutil.ltrimstr( A2237CondExenIIGGVFi, 14, 2));
            A2238CondExenIIGGOpe = H00BN3_A2238CondExenIIGGOpe[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2238CondExenIIGGOpe", A2238CondExenIIGGOpe);
            A1107CondExenIIGGProm = H00BN3_A1107CondExenIIGGProm[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
            A1106CondExenIIGGAcu = H00BN3_A1106CondExenIIGGAcu[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
            /* Execute user event: Load */
            e14BN2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         wbBN0( ) ;
      }
   }

   public void send_integrity_lvl_hashesBN2( )
   {
   }

   public void before_start_formulas( )
   {
      AV21Pgmname = "condicion_exencion_iiggGeneral" ;
      Gx_err = (short)(0) ;
      edtavCondexeniiggcon_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCondexeniiggcon_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCondexeniiggcon_description_Enabled), 5, 0), true);
      edtavCondexeniiggvar_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCondexeniiggvar_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCondexeniiggvar_description_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strupBN0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13BN2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1105CondExenIIGG = httpContext.cgiGet( sPrefix+"wcpOA1105CondExenIIGG") ;
         /* Read variables values. */
         AV18CondExenIIGGCon_Description = httpContext.cgiGet( edtavCondexeniiggcon_description_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18CondExenIIGGCon_Description", AV18CondExenIIGGCon_Description);
         A1106CondExenIIGGAcu = GXutil.strtobool( httpContext.cgiGet( chkCondExenIIGGAcu.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
         A1107CondExenIIGGProm = GXutil.strtobool( httpContext.cgiGet( chkCondExenIIGGProm.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
         cmbCondExenIIGGOpe.setValue( httpContext.cgiGet( cmbCondExenIIGGOpe.getInternalname()) );
         A2238CondExenIIGGOpe = httpContext.cgiGet( cmbCondExenIIGGOpe.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2238CondExenIIGGOpe", A2238CondExenIIGGOpe);
         AV12CondExenIIGGVar_Description = httpContext.cgiGet( edtavCondexeniiggvar_description_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12CondExenIIGGVar_Description", AV12CondExenIIGGVar_Description);
         A2237CondExenIIGGVFi = localUtil.ctond( httpContext.cgiGet( edtCondExenIIGGVFi_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2237CondExenIIGGVFi", GXutil.ltrimstr( A2237CondExenIIGGVFi, 14, 2));
         A1108CondexenIIGGNom = httpContext.cgiGet( edtCondexenIIGGNom_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1108CondexenIIGGNom", A1108CondexenIIGGNom);
         dynCondExenRelSec.setValue( httpContext.cgiGet( dynCondExenRelSec.getInternalname()) );
         A2001CondExenRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynCondExenRelSec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2001CondExenRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2001CondExenRelSec), 6, 0));
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
      e13BN2 ();
      if (returnInSub) return;
   }

   public void e13BN2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      condicion_exencion_iigggeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_char4 = AV16Combo_DataJson ;
      GXv_char5[0] = AV17ComboSelectedValue ;
      GXv_char6[0] = AV12CondExenIIGGVar_Description ;
      GXv_char7[0] = GXt_char4 ;
      new web.condicion_exencion_iiggloaddvcombo(remoteHandle, context).execute( "CondExenIIGGVar", "UPD", false, A3CliCod, A1105CondExenIIGG, A3CliCod, "", GXv_char5, GXv_char6, GXv_char7) ;
      condicion_exencion_iigggeneral_impl.this.AV17ComboSelectedValue = GXv_char5[0] ;
      condicion_exencion_iigggeneral_impl.this.AV12CondExenIIGGVar_Description = GXv_char6[0] ;
      condicion_exencion_iigggeneral_impl.this.GXt_char4 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12CondExenIIGGVar_Description", AV12CondExenIIGGVar_Description);
      AV16Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV16Combo_DataJson ;
      GXv_char7[0] = AV17ComboSelectedValue ;
      GXv_char6[0] = AV12CondExenIIGGVar_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.condicion_exencion_iiggloaddvcombo(remoteHandle, context).execute( "CondExenIIGGVar", "UPD", false, A3CliCod, A1105CondExenIIGG, A3CliCod, "", GXv_char7, GXv_char6, GXv_char5) ;
      condicion_exencion_iigggeneral_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
      condicion_exencion_iigggeneral_impl.this.AV12CondExenIIGGVar_Description = GXv_char6[0] ;
      condicion_exencion_iigggeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12CondExenIIGGVar_Description", AV12CondExenIIGGVar_Description);
      AV16Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV16Combo_DataJson ;
      GXv_char7[0] = AV17ComboSelectedValue ;
      GXv_char6[0] = AV18CondExenIIGGCon_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.condicion_exencion_iiggloaddvcombo(remoteHandle, context).execute( "CondExenIIGGCon", "UPD", false, A3CliCod, A1105CondExenIIGG, A3CliCod, "", GXv_char7, GXv_char6, GXv_char5) ;
      condicion_exencion_iigggeneral_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
      condicion_exencion_iigggeneral_impl.this.AV18CondExenIIGGCon_Description = GXv_char6[0] ;
      condicion_exencion_iigggeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18CondExenIIGGCon_Description", AV18CondExenIIGGCon_Description);
      AV16Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV16Combo_DataJson ;
      GXv_char7[0] = AV17ComboSelectedValue ;
      GXv_char6[0] = AV18CondExenIIGGCon_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.condicion_exencion_iiggloaddvcombo(remoteHandle, context).execute( "CondExenIIGGCon", "UPD", false, A3CliCod, A1105CondExenIIGG, A3CliCod, "", GXv_char7, GXv_char6, GXv_char5) ;
      condicion_exencion_iigggeneral_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
      condicion_exencion_iigggeneral_impl.this.AV18CondExenIIGGCon_Description = GXv_char6[0] ;
      condicion_exencion_iigggeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18CondExenIIGGCon_Description", AV18CondExenIIGGCon_Description);
      AV16Combo_DataJson = GXt_char4 ;
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e14BN2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      GXt_boolean8 = AV13TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWcondicion_exencion_iigg_Update", GXv_boolean9) ;
      condicion_exencion_iigggeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV13TempBoolean = GXt_boolean8 ;
      if ( AV13TempBoolean )
      {
         GXt_boolean8 = AV13TempBoolean ;
         GXv_boolean9[0] = GXt_boolean8 ;
         new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean9) ;
         condicion_exencion_iigggeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
         AV13TempBoolean = GXt_boolean8 ;
         if ( ! ( AV13TempBoolean ) )
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
      GXt_boolean8 = AV13TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWcondicion_exencion_iigg_Delete", GXv_boolean9) ;
      condicion_exencion_iigggeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV13TempBoolean = GXt_boolean8 ;
      if ( AV13TempBoolean )
      {
         GXt_boolean8 = AV13TempBoolean ;
         GXv_boolean9[0] = GXt_boolean8 ;
         new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean9) ;
         condicion_exencion_iigggeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
         AV13TempBoolean = GXt_boolean8 ;
         if ( ! ( AV13TempBoolean ) )
         {
            bttBtndelete_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
         }
      }
      else
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV21Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "condicion_exencion_iigg" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15BN2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      condicion_exencion_iigggeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1105CondExenIIGG = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1105CondExenIIGG", A1105CondExenIIGG);
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
      paBN2( ) ;
      wsBN2( ) ;
      weBN2( ) ;
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
      sCtrlA1105CondExenIIGG = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paBN2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "condicion_exencion_iigggeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paBN2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1105CondExenIIGG = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1105CondExenIIGG", A1105CondExenIIGG);
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1105CondExenIIGG = httpContext.cgiGet( sPrefix+"wcpOA1105CondExenIIGG") ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( GXutil.strcmp(A1105CondExenIIGG, wcpOA1105CondExenIIGG) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1105CondExenIIGG = A1105CondExenIIGG ;
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
      sCtrlA1105CondExenIIGG = httpContext.cgiGet( sPrefix+"A1105CondExenIIGG_CTRL") ;
      if ( GXutil.len( sCtrlA1105CondExenIIGG) > 0 )
      {
         A1105CondExenIIGG = httpContext.cgiGet( sCtrlA1105CondExenIIGG) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1105CondExenIIGG", A1105CondExenIIGG);
      }
      else
      {
         A1105CondExenIIGG = httpContext.cgiGet( sPrefix+"A1105CondExenIIGG_PARM") ;
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
      paBN2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsBN2( ) ;
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
      wsBN2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1105CondExenIIGG_PARM", GXutil.rtrim( A1105CondExenIIGG));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1105CondExenIIGG)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1105CondExenIIGG_CTRL", GXutil.rtrim( sCtrlA1105CondExenIIGG));
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
      weBN2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251816595945", true, true);
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
      httpContext.AddJavascriptSource("condicion_exencion_iigggeneral.js", "?20251816595945", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtCondExenIIGG_Internalname = sPrefix+"CONDEXENIIGG" ;
      edtavCondexeniiggcon_description_Internalname = sPrefix+"vCONDEXENIIGGCON_DESCRIPTION" ;
      chkCondExenIIGGAcu.setInternalname( sPrefix+"CONDEXENIIGGACU" );
      chkCondExenIIGGProm.setInternalname( sPrefix+"CONDEXENIIGGPROM" );
      cmbCondExenIIGGOpe.setInternalname( sPrefix+"CONDEXENIIGGOPE" );
      edtavCondexeniiggvar_description_Internalname = sPrefix+"vCONDEXENIIGGVAR_DESCRIPTION" ;
      edtCondExenIIGGVFi_Internalname = sPrefix+"CONDEXENIIGGVFI" ;
      edtCondexenIIGGNom_Internalname = sPrefix+"CONDEXENIIGGNOM" ;
      dynCondExenRelSec.setInternalname( sPrefix+"CONDEXENRELSEC" );
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
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
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      dynCondExenRelSec.setJsonclick( "" );
      dynCondExenRelSec.setEnabled( 0 );
      edtCondexenIIGGNom_Enabled = 0 ;
      edtCondExenIIGGVFi_Jsonclick = "" ;
      edtCondExenIIGGVFi_Enabled = 0 ;
      edtavCondexeniiggvar_description_Jsonclick = "" ;
      edtavCondexeniiggvar_description_Enabled = 1 ;
      cmbCondExenIIGGOpe.setJsonclick( "" );
      cmbCondExenIIGGOpe.setEnabled( 0 );
      chkCondExenIIGGProm.setEnabled( 0 );
      chkCondExenIIGGAcu.setEnabled( 0 );
      edtavCondexeniiggcon_description_Jsonclick = "" ;
      edtavCondexeniiggcon_description_Enabled = 1 ;
      edtCondExenIIGG_Jsonclick = "" ;
      edtCondExenIIGG_Enabled = 0 ;
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
      chkCondExenIIGGAcu.setName( "CONDEXENIIGGACU" );
      chkCondExenIIGGAcu.setWebtags( "" );
      chkCondExenIIGGAcu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCondExenIIGGAcu.getInternalname(), "TitleCaption", chkCondExenIIGGAcu.getCaption(), true);
      chkCondExenIIGGAcu.setCheckedValue( "false" );
      chkCondExenIIGGProm.setName( "CONDEXENIIGGPROM" );
      chkCondExenIIGGProm.setWebtags( "" );
      chkCondExenIIGGProm.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCondExenIIGGProm.getInternalname(), "TitleCaption", chkCondExenIIGGProm.getCaption(), true);
      chkCondExenIIGGProm.setCheckedValue( "false" );
      cmbCondExenIIGGOpe.setName( "CONDEXENIIGGOPE" );
      cmbCondExenIIGGOpe.setWebtags( "" );
      cmbCondExenIIGGOpe.addItem("menor", "<", (short)(0));
      cmbCondExenIIGGOpe.addItem("mayor", ">", (short)(0));
      cmbCondExenIIGGOpe.addItem("igual", "=", (short)(0));
      cmbCondExenIIGGOpe.addItem("menorOIgual", "<=", (short)(0));
      cmbCondExenIIGGOpe.addItem("mayorOIgual", ">=", (short)(0));
      if ( cmbCondExenIIGGOpe.getItemCount() > 0 )
      {
      }
      dynCondExenRelSec.setName( "CONDEXENRELSEC" );
      dynCondExenRelSec.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1105CondExenIIGG',fld:'CONDEXENIIGG',pic:''},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11BN1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1105CondExenIIGG',fld:'CONDEXENIIGG',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12BN1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1105CondExenIIGG',fld:'CONDEXENIIGG',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CONDEXENIIGG","{handler:'valid_Condexeniigg',iparms:[]");
      setEventMetadata("VALID_CONDEXENIIGG",",oparms:[]}");
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
      wcpOA1105CondExenIIGG = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A1105CondExenIIGG = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      TempTags = "" ;
      AV18CondExenIIGGCon_Description = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A2238CondExenIIGGOpe = "" ;
      AV12CondExenIIGGVar_Description = "" ;
      A2237CondExenIIGGVFi = DecimalUtil.ZERO ;
      A1108CondexenIIGGNom = "" ;
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
      H00BN2_A3CliCod = new int[1] ;
      H00BN2_A1885CliRelSec = new int[1] ;
      H00BN2_A1880CliReDTChar = new String[] {""} ;
      AV21Pgmname = "" ;
      H00BN3_A3CliCod = new int[1] ;
      H00BN3_A1105CondExenIIGG = new String[] {""} ;
      H00BN3_A2001CondExenRelSec = new int[1] ;
      H00BN3_A1108CondexenIIGGNom = new String[] {""} ;
      H00BN3_A2237CondExenIIGGVFi = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00BN3_A2238CondExenIIGGOpe = new String[] {""} ;
      H00BN3_A1107CondExenIIGGProm = new boolean[] {false} ;
      H00BN3_A1106CondExenIIGGAcu = new boolean[] {false} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV16Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      GXt_char4 = "" ;
      GXv_char7 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_char5 = new String[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1105CondExenIIGG = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condicion_exencion_iigggeneral__default(),
         new Object[] {
             new Object[] {
            H00BN2_A3CliCod, H00BN2_A1885CliRelSec, H00BN2_A1880CliReDTChar
            }
            , new Object[] {
            H00BN3_A3CliCod, H00BN3_A1105CondExenIIGG, H00BN3_A2001CondExenRelSec, H00BN3_A1108CondexenIIGGNom, H00BN3_A2237CondExenIIGGVFi, H00BN3_A2238CondExenIIGGOpe, H00BN3_A1107CondExenIIGGProm, H00BN3_A1106CondExenIIGGAcu
            }
         }
      );
      AV21Pgmname = "condicion_exencion_iiggGeneral" ;
      /* GeneXus formulas. */
      AV21Pgmname = "condicion_exencion_iiggGeneral" ;
      Gx_err = (short)(0) ;
      edtavCondexeniiggcon_description_Enabled = 0 ;
      edtavCondexeniiggvar_description_Enabled = 0 ;
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
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int AV14CliCod ;
   private int edtCondExenIIGG_Enabled ;
   private int edtavCondexeniiggcon_description_Enabled ;
   private int edtavCondexeniiggvar_description_Enabled ;
   private int edtCondExenIIGGVFi_Enabled ;
   private int edtCondexenIIGGNom_Enabled ;
   private int A2001CondExenRelSec ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int gxdynajaxindex ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private java.math.BigDecimal A2237CondExenIIGGVFi ;
   private String wcpOA1105CondExenIIGG ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A1105CondExenIIGG ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtCondExenIIGG_Internalname ;
   private String edtCondExenIIGG_Jsonclick ;
   private String edtavCondexeniiggcon_description_Internalname ;
   private String TempTags ;
   private String edtavCondexeniiggcon_description_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String A2238CondExenIIGGOpe ;
   private String edtavCondexeniiggvar_description_Internalname ;
   private String edtavCondexeniiggvar_description_Jsonclick ;
   private String edtCondExenIIGGVFi_Internalname ;
   private String edtCondExenIIGGVFi_Jsonclick ;
   private String edtCondexenIIGGNom_Internalname ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV21Pgmname ;
   private String GXt_char4 ;
   private String GXv_char7[] ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1105CondExenIIGG ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A1106CondExenIIGGAcu ;
   private boolean A1107CondExenIIGGProm ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV13TempBoolean ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private String AV16Combo_DataJson ;
   private String AV18CondExenIIGGCon_Description ;
   private String AV12CondExenIIGGVar_Description ;
   private String A1108CondexenIIGGNom ;
   private String AV17ComboSelectedValue ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private ICheckbox chkCondExenIIGGAcu ;
   private ICheckbox chkCondExenIIGGProm ;
   private HTMLChoice cmbCondExenIIGGOpe ;
   private HTMLChoice dynCondExenRelSec ;
   private IDataStoreProvider pr_default ;
   private int[] H00BN2_A3CliCod ;
   private int[] H00BN2_A1885CliRelSec ;
   private String[] H00BN2_A1880CliReDTChar ;
   private int[] H00BN3_A3CliCod ;
   private String[] H00BN3_A1105CondExenIIGG ;
   private int[] H00BN3_A2001CondExenRelSec ;
   private String[] H00BN3_A1108CondexenIIGGNom ;
   private java.math.BigDecimal[] H00BN3_A2237CondExenIIGGVFi ;
   private String[] H00BN3_A2238CondExenIIGGOpe ;
   private boolean[] H00BN3_A1107CondExenIIGGProm ;
   private boolean[] H00BN3_A1106CondExenIIGGAcu ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class condicion_exencion_iigggeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00BN2", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00BN3", "SELECT CliCod, CondExenIIGG, CondExenRelSec, CondexenIIGGNom, CondExenIIGGVFi, CondExenIIGGOpe, CondExenIIGGProm, CondExenIIGGAcu FROM condicion_exencion_iigg WHERE CliCod = ? and CondExenIIGG = ( ?) ORDER BY CliCod, CondExenIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

