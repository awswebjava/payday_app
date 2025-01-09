package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class motivoegresorevistaafipgeneral_impl extends GXWebComponent
{
   public motivoegresorevistaafipgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public motivoegresorevistaafipgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( motivoegresorevistaafipgeneral_impl.class ));
   }

   public motivoegresorevistaafipgeneral_impl( int remoteHandle ,
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
      chkMegSitRevDef = UIFactory.getCheckbox(this);
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
               A11MegCodigo = httpContext.GetPar( "MegCodigo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A11MegCodigo", A11MegCodigo);
               A1601MegSitRevista = (short)(GXutil.lval( httpContext.GetPar( "MegSitRevista"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),A11MegCodigo,Short.valueOf(A1601MegSitRevista)});
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
         paHY2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Motivo Egreso Revista Afip General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.motivoegresorevistaafipgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A11MegCodigo)),GXutil.URLEncode(GXutil.ltrimstr(A1601MegSitRevista,3,0))}, new String[] {"CliCod","MegCodigo","MegSitRevista"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA11MegCodigo", GXutil.rtrim( wcpOA11MegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1601MegSitRevista", GXutil.ltrim( localUtil.ntoc( wcpOA1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"MEGCODIGO", GXutil.rtrim( A11MegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"MEGSITREVISTA", GXutil.ltrim( localUtil.ntoc( A1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormHY2( )
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
      return "MotivoEgresoRevistaAfipGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Motivo Egreso Revista Afip General", "") ;
   }

   public void wbHY0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.motivoegresorevistaafipgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliNom_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCliNom_Internalname, httpContext.getMessage( "Cliente", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliNom_Internalname, A344CliNom, GXutil.rtrim( localUtil.format( A344CliNom, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliNom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliNom_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_MotivoEgresoRevistaAfipGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMegDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMegDescrip_Internalname, httpContext.getMessage( "Motivo Egreso", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMegDescrip_Internalname, A300MegDescrip, "", "", (short)(0), 1, edtMegDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_MotivoEgresoRevistaAfipGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavMegsitrevista_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavMegsitrevista_description_Internalname, httpContext.getMessage( "Situación de revista", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavMegsitrevista_description_Internalname, AV12MegSitRevista_Description, GXutil.rtrim( localUtil.format( AV12MegSitRevista_Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,24);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMegsitrevista_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavMegsitrevista_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MotivoEgresoRevistaAfipGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkMegSitRevDef.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkMegSitRevDef.getInternalname(), httpContext.getMessage( "Default", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkMegSitRevDef.getInternalname(), GXutil.booltostr( A1606MegSitRevDef), "", httpContext.getMessage( "Default", ""), 1, chkMegSitRevDef.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11hy1_client"+"'", TempTags, "", 2, "HLP_MotivoEgresoRevistaAfipGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12hy1_client"+"'", TempTags, "", 2, "HLP_MotivoEgresoRevistaAfipGeneral.htm");
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

   public void startHY2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Motivo Egreso Revista Afip General", ""), (short)(0)) ;
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
            strupHY0( ) ;
         }
      }
   }

   public void wsHY2( )
   {
      startHY2( ) ;
      evtHY2( ) ;
   }

   public void evtHY2( )
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
                              strupHY0( ) ;
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
                              strupHY0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13HY2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHY0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14HY2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHY0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15HY2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHY0( ) ;
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
                              strupHY0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavMegsitrevista_description_Internalname ;
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

   public void weHY2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormHY2( ) ;
         }
      }
   }

   public void paHY2( )
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
            GX_FocusControl = edtavMegsitrevista_description_Internalname ;
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
      A1606MegSitRevDef = GXutil.strtobool( GXutil.booltostr( A1606MegSitRevDef)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1606MegSitRevDef", A1606MegSitRevDef);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfHY2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV20Pgmname = "MotivoEgresoRevistaAfipGeneral" ;
      Gx_err = (short)(0) ;
      edtavMegsitrevista_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavMegsitrevista_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMegsitrevista_description_Enabled), 5, 0), true);
   }

   public void rfHY2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15HY2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00HY2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1606MegSitRevDef = H00HY2_A1606MegSitRevDef[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1606MegSitRevDef", A1606MegSitRevDef);
            /* Execute user event: Load */
            e14HY2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wbHY0( ) ;
      }
   }

   public void send_integrity_lvl_hashesHY2( )
   {
   }

   public void before_start_formulas( )
   {
      AV20Pgmname = "MotivoEgresoRevistaAfipGeneral" ;
      Gx_err = (short)(0) ;
      edtavMegsitrevista_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavMegsitrevista_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMegsitrevista_description_Enabled), 5, 0), true);
      /* Using cursor H00HY3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod)});
      A344CliNom = H00HY3_A344CliNom[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A344CliNom", A344CliNom);
      pr_default.close(1);
      /* Using cursor H00HY4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      A300MegDescrip = H00HY4_A300MegDescrip[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A300MegDescrip", A300MegDescrip);
      pr_default.close(2);
      pr_default.close(1);
      pr_default.close(2);
      fix_multi_value_controls( ) ;
   }

   public void strupHY0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13HY2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA11MegCodigo = httpContext.cgiGet( sPrefix+"wcpOA11MegCodigo") ;
         wcpOA1601MegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1601MegSitRevista"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A1601MegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"MEGSITREVISTA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A11MegCodigo = httpContext.cgiGet( sPrefix+"MEGCODIGO") ;
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A344CliNom = GXutil.upper( httpContext.cgiGet( edtCliNom_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A344CliNom", A344CliNom);
         A300MegDescrip = httpContext.cgiGet( edtMegDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A300MegDescrip", A300MegDescrip);
         AV12MegSitRevista_Description = httpContext.cgiGet( edtavMegsitrevista_description_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12MegSitRevista_Description", AV12MegSitRevista_Description);
         A1606MegSitRevDef = GXutil.strtobool( httpContext.cgiGet( chkMegSitRevDef.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1606MegSitRevDef", A1606MegSitRevDef);
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
      e13HY2 ();
      if (returnInSub) return;
   }

   public void e13HY2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      motivoegresorevistaafipgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_char4 = AV16Combo_DataJson ;
      GXv_char5[0] = AV17ComboSelectedValue ;
      GXv_char6[0] = AV12MegSitRevista_Description ;
      GXv_char7[0] = GXt_char4 ;
      new web.motivoegresorevistaafiploaddvcombo(remoteHandle, context).execute( "MegSitRevista", "UPD", false, A3CliCod, A11MegCodigo, A1601MegSitRevista, A3CliCod, "", GXv_char5, GXv_char6, GXv_char7) ;
      motivoegresorevistaafipgeneral_impl.this.AV17ComboSelectedValue = GXv_char5[0] ;
      motivoegresorevistaafipgeneral_impl.this.AV12MegSitRevista_Description = GXv_char6[0] ;
      motivoegresorevistaafipgeneral_impl.this.GXt_char4 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12MegSitRevista_Description", AV12MegSitRevista_Description);
      AV16Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV16Combo_DataJson ;
      GXv_char7[0] = AV17ComboSelectedValue ;
      GXv_char6[0] = AV12MegSitRevista_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.motivoegresorevistaafiploaddvcombo(remoteHandle, context).execute( "MegSitRevista", "UPD", false, A3CliCod, A11MegCodigo, A1601MegSitRevista, A3CliCod, "", GXv_char7, GXv_char6, GXv_char5) ;
      motivoegresorevistaafipgeneral_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
      motivoegresorevistaafipgeneral_impl.this.AV12MegSitRevista_Description = GXv_char6[0] ;
      motivoegresorevistaafipgeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12MegSitRevista_Description", AV12MegSitRevista_Description);
      AV16Combo_DataJson = GXt_char4 ;
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e14HY2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean8 = AV13TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgresoRevistaAfip_Update", GXv_boolean9) ;
      motivoegresorevistaafipgeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV13TempBoolean = GXt_boolean8 ;
      if ( ! ( AV13TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean8 = AV13TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgresoRevistaAfip_Delete", GXv_boolean9) ;
      motivoegresorevistaafipgeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV13TempBoolean = GXt_boolean8 ;
      if ( ! ( AV13TempBoolean ) )
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV20Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "MotivoEgresoRevistaAfip" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15HY2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      motivoegresorevistaafipgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A11MegCodigo = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A11MegCodigo", A11MegCodigo);
      A1601MegSitRevista = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
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
      paHY2( ) ;
      wsHY2( ) ;
      weHY2( ) ;
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
      sCtrlA11MegCodigo = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlA1601MegSitRevista = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paHY2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "motivoegresorevistaafipgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paHY2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A11MegCodigo", A11MegCodigo);
         A1601MegSitRevista = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA11MegCodigo = httpContext.cgiGet( sPrefix+"wcpOA11MegCodigo") ;
      wcpOA1601MegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1601MegSitRevista"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( GXutil.strcmp(A11MegCodigo, wcpOA11MegCodigo) != 0 ) || ( A1601MegSitRevista != wcpOA1601MegSitRevista ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA11MegCodigo = A11MegCodigo ;
      wcpOA1601MegSitRevista = A1601MegSitRevista ;
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
      sCtrlA11MegCodigo = httpContext.cgiGet( sPrefix+"A11MegCodigo_CTRL") ;
      if ( GXutil.len( sCtrlA11MegCodigo) > 0 )
      {
         A11MegCodigo = httpContext.cgiGet( sCtrlA11MegCodigo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A11MegCodigo", A11MegCodigo);
      }
      else
      {
         A11MegCodigo = httpContext.cgiGet( sPrefix+"A11MegCodigo_PARM") ;
      }
      sCtrlA1601MegSitRevista = httpContext.cgiGet( sPrefix+"A1601MegSitRevista_CTRL") ;
      if ( GXutil.len( sCtrlA1601MegSitRevista) > 0 )
      {
         A1601MegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA1601MegSitRevista), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
      }
      else
      {
         A1601MegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1601MegSitRevista_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paHY2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsHY2( ) ;
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
      wsHY2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A11MegCodigo_PARM", GXutil.rtrim( A11MegCodigo));
      if ( GXutil.len( GXutil.rtrim( sCtrlA11MegCodigo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A11MegCodigo_CTRL", GXutil.rtrim( sCtrlA11MegCodigo));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1601MegSitRevista_PARM", GXutil.ltrim( localUtil.ntoc( A1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1601MegSitRevista)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1601MegSitRevista_CTRL", GXutil.rtrim( sCtrlA1601MegSitRevista));
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
      weHY2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020294195", true, true);
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
      httpContext.AddJavascriptSource("motivoegresorevistaafipgeneral.js", "?2024122020294195", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtCliNom_Internalname = sPrefix+"CLINOM" ;
      edtMegDescrip_Internalname = sPrefix+"MEGDESCRIP" ;
      edtavMegsitrevista_description_Internalname = sPrefix+"vMEGSITREVISTA_DESCRIPTION" ;
      chkMegSitRevDef.setInternalname( sPrefix+"MEGSITREVDEF" );
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
      chkMegSitRevDef.setEnabled( 0 );
      edtavMegsitrevista_description_Jsonclick = "" ;
      edtavMegsitrevista_description_Enabled = 1 ;
      edtMegDescrip_Enabled = 0 ;
      edtCliNom_Jsonclick = "" ;
      edtCliNom_Enabled = 0 ;
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
      chkMegSitRevDef.setName( "MEGSITREVDEF" );
      chkMegSitRevDef.setWebtags( "" );
      chkMegSitRevDef.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkMegSitRevDef.getInternalname(), "TitleCaption", chkMegSitRevDef.getCaption(), true);
      chkMegSitRevDef.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A11MegCodigo',fld:'MEGCODIGO',pic:''},{av:'A1601MegSitRevista',fld:'MEGSITREVISTA',pic:'ZZ9'},{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11HY1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A11MegCodigo',fld:'MEGCODIGO',pic:''},{av:'A1601MegSitRevista',fld:'MEGSITREVISTA',pic:'ZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12HY1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A11MegCodigo',fld:'MEGCODIGO',pic:''},{av:'A1601MegSitRevista',fld:'MEGSITREVISTA',pic:'ZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
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
      wcpOA11MegCodigo = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A11MegCodigo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A344CliNom = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A300MegDescrip = "" ;
      TempTags = "" ;
      AV12MegSitRevista_Description = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV20Pgmname = "" ;
      scmdbuf = "" ;
      H00HY2_A3CliCod = new int[1] ;
      H00HY2_A11MegCodigo = new String[] {""} ;
      H00HY2_A1601MegSitRevista = new short[1] ;
      H00HY2_A1606MegSitRevDef = new boolean[] {false} ;
      H00HY2_A300MegDescrip = new String[] {""} ;
      H00HY2_A344CliNom = new String[] {""} ;
      H00HY3_A344CliNom = new String[] {""} ;
      H00HY4_A300MegDescrip = new String[] {""} ;
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
      sCtrlA11MegCodigo = "" ;
      sCtrlA1601MegSitRevista = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.motivoegresorevistaafipgeneral__default(),
         new Object[] {
             new Object[] {
            H00HY2_A3CliCod, H00HY2_A11MegCodigo, H00HY2_A1601MegSitRevista, H00HY2_A1606MegSitRevDef, H00HY2_A300MegDescrip, H00HY2_A344CliNom
            }
            , new Object[] {
            H00HY3_A344CliNom
            }
            , new Object[] {
            H00HY4_A300MegDescrip
            }
         }
      );
      AV20Pgmname = "MotivoEgresoRevistaAfipGeneral" ;
      /* GeneXus formulas. */
      AV20Pgmname = "MotivoEgresoRevistaAfipGeneral" ;
      Gx_err = (short)(0) ;
      edtavMegsitrevista_description_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1601MegSitRevista ;
   private short A1601MegSitRevista ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int edtCliNom_Enabled ;
   private int edtMegDescrip_Enabled ;
   private int edtavMegsitrevista_description_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int AV14CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String wcpOA11MegCodigo ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A11MegCodigo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtCliNom_Internalname ;
   private String edtCliNom_Jsonclick ;
   private String edtMegDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtavMegsitrevista_description_Internalname ;
   private String TempTags ;
   private String edtavMegsitrevista_description_Jsonclick ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV20Pgmname ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char7[] ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String sCtrlA3CliCod ;
   private String sCtrlA11MegCodigo ;
   private String sCtrlA1601MegSitRevista ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A1606MegSitRevDef ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV13TempBoolean ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private String AV16Combo_DataJson ;
   private String A344CliNom ;
   private String A300MegDescrip ;
   private String AV12MegSitRevista_Description ;
   private String AV17ComboSelectedValue ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private ICheckbox chkMegSitRevDef ;
   private IDataStoreProvider pr_default ;
   private int[] H00HY2_A3CliCod ;
   private String[] H00HY2_A11MegCodigo ;
   private short[] H00HY2_A1601MegSitRevista ;
   private boolean[] H00HY2_A1606MegSitRevDef ;
   private String[] H00HY2_A300MegDescrip ;
   private String[] H00HY2_A344CliNom ;
   private String[] H00HY3_A344CliNom ;
   private String[] H00HY4_A300MegDescrip ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class motivoegresorevistaafipgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00HY2", "SELECT T1.CliCod, T1.MegCodigo, T1.MegSitRevista, T1.MegSitRevDef, T3.MegDescrip, T2.CliNom FROM ((MotivoEgresoRevistaAfip T1 INNER JOIN Cliente T2 ON T2.CliCod = T1.CliCod) INNER JOIN MotivoEgreso T3 ON T3.CliCod = T1.CliCod AND T3.MegCodigo = T1.MegCodigo) WHERE T1.CliCod = ? and T1.MegCodigo = ( ?) and T1.MegSitRevista = ? ORDER BY T1.CliCod, T1.MegCodigo, T1.MegSitRevista ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00HY3", "SELECT CliNom FROM Cliente WHERE CliCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00HY4", "SELECT MegDescrip FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 2 :
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

