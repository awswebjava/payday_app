package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptogeneral_impl extends GXWebComponent
{
   public conceptogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptogeneral_impl.class ));
   }

   public conceptogeneral_impl( int remoteHandle ,
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
      dynTipoConCod = new HTMLChoice();
      chkConVariable = UIFactory.getCheckbox(this);
      cmbConAplicGan = new HTMLChoice();
      dynSubTipoConCod1 = new HTMLChoice();
      dynSubTipoConCod2 = new HTMLChoice();
      chkConHabilitado = UIFactory.getCheckbox(this);
      chkConCanti = UIFactory.getCheckbox(this);
      chkConValUni = UIFactory.getCheckbox(this);
      chkConImporte = UIFactory.getCheckbox(this);
      cmbConVigencia = new HTMLChoice();
      chkConRecalcular = UIFactory.getCheckbox(this);
      cmbConPreReq = new HTMLChoice();
      cmbConAdelDescu = new HTMLChoice();
      chkavEssistemaconceptosdefault = UIFactory.getCheckbox(this);
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
               A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),A26ConCodigo});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"SUBTIPOCONCOD1") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlasubtipoconcod14U2( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"SUBTIPOCONCOD2") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlasubtipoconcod24U2( ) ;
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
         pa4U2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Concepto General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A26ConCodigo))}, new String[] {"CliCod","ConCodigo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ConceptoGeneral");
      forbiddenHiddens.add("TipoConCod", GXutil.rtrim( localUtil.format( A37TipoConCod, "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("conceptogeneral:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA3CliCod", GXutil.ltrim( localUtil.ntoc( wcpOA3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA26ConCodigo", GXutil.rtrim( wcpOA26ConCodigo));
   }

   public void renderHtmlCloseForm4U2( )
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
      return "ConceptoGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Concepto General", "") ;
   }

   public void wb4U0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.conceptogeneral");
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
         web.GxWebStd.gx_div_start( httpContext, divConformula_cell_Internalname, 1, 0, "px", 0, "px", divConformula_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtConFormula_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFormula_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConFormula_Internalname, httpContext.getMessage( "Fórmula", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtConFormula_Internalname, A148ConFormula, edtConFormula_Link, "", (short)(0), edtConFormula_Visible, edtConFormula_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ConceptoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynTipoConCod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynTipoConCod.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynTipoConCod, dynTipoConCod.getInternalname(), GXutil.rtrim( A37TipoConCod), 1, dynTipoConCod.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynTipoConCod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoGeneral.htm");
         dynTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynTipoConCod.getInternalname(), "Values", dynTipoConCod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvariable_cell_Internalname, 1, 0, "px", 0, "px", divConvariable_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkConVariable.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConVariable.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConVariable.getInternalname(), httpContext.getMessage( "Remuneración Variable", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConVariable.getInternalname(), GXutil.booltostr( A159ConVariable), "", httpContext.getMessage( "Remuneración Variable", ""), chkConVariable.getVisible(), chkConVariable.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConaplicgan_cell_Internalname, 1, 0, "px", 0, "px", divConaplicgan_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbConAplicGan.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAplicGan.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAplicGan.getInternalname(), httpContext.getMessage( "Sujeto a ganancias", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAplicGan, cmbConAplicGan.getInternalname(), GXutil.trim( GXutil.str( A735ConAplicGan, 2, 0)), 1, cmbConAplicGan.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbConAplicGan.getVisible(), cmbConAplicGan.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoGeneral.htm");
         cmbConAplicGan.setValue( GXutil.trim( GXutil.str( A735ConAplicGan, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAplicGan.getInternalname(), "Values", cmbConAplicGan.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynSubTipoConCod1.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynSubTipoConCod1.getInternalname(), httpContext.getMessage( "Clasificación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynSubTipoConCod1, dynSubTipoConCod1.getInternalname(), GXutil.rtrim( A38SubTipoConCod1), 1, dynSubTipoConCod1.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynSubTipoConCod1.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoGeneral.htm");
         dynSubTipoConCod1.setValue( GXutil.rtrim( A38SubTipoConCod1) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynSubTipoConCod1.getInternalname(), "Values", dynSubTipoConCod1.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynSubTipoConCod2.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynSubTipoConCod2.getInternalname(), httpContext.getMessage( "Sub Clasif.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynSubTipoConCod2, dynSubTipoConCod2.getInternalname(), GXutil.rtrim( A39SubTipoConCod2), 1, dynSubTipoConCod2.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynSubTipoConCod2.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoGeneral.htm");
         dynSubTipoConCod2.setValue( GXutil.rtrim( A39SubTipoConCod2) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynSubTipoConCod2.getInternalname(), "Values", dynSubTipoConCod2.ToJavascriptSource(), true);
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_ConceptoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtConDescrip_Internalname, A41ConDescrip, "", "", (short)(0), 1, edtConDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ConceptoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConHabilitado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConHabilitado.getInternalname(), httpContext.getMessage( "Habilitado", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConHabilitado.getInternalname(), GXutil.booltostr( A150ConHabilitado), "", httpContext.getMessage( "Habilitado", ""), 1, chkConHabilitado.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConcanti_cell_Internalname, 1, 0, "px", 0, "px", divConcanti_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkConCanti.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConCanti.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConCanti.getInternalname(), httpContext.getMessage( "Cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConCanti.getInternalname(), GXutil.booltostr( A143ConCanti), "", httpContext.getMessage( "Cantidad", ""), chkConCanti.getVisible(), chkConCanti.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvaluni_cell_Internalname, 1, 0, "px", 0, "px", divConvaluni_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkConValUni.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConValUni.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConValUni.getInternalname(), httpContext.getMessage( "Valor Unitario", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConValUni.getInternalname(), GXutil.booltostr( A158ConValUni), "", httpContext.getMessage( "Valor Unitario", ""), chkConValUni.getVisible(), chkConValUni.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConimporte_cell_Internalname, 1, 0, "px", 0, "px", divConimporte_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkConImporte.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConImporte.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConImporte.getInternalname(), httpContext.getMessage( "Importe", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConImporte.getInternalname(), GXutil.booltostr( A152ConImporte), "", httpContext.getMessage( "Importe", ""), chkConImporte.getVisible(), chkConImporte.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConVigencia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConVigencia.getInternalname(), httpContext.getMessage( "Aplicación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConVigencia, cmbConVigencia.getInternalname(), GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)), 1, cmbConVigencia.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConVigencia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoGeneral.htm");
         cmbConVigencia.setValue( GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConVigencia.getInternalname(), "Values", cmbConVigencia.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConObservacion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConObservacion_Internalname, httpContext.getMessage( "Observacion", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtConObservacion_Internalname, A153ConObservacion, "", "", (short)(0), 1, edtConObservacion_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ConceptoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConRecalcular.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConRecalcular.getInternalname(), httpContext.getMessage( "Recalcular retroactivamente", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConRecalcular.getInternalname(), GXutil.booltostr( A762ConRecalcular), "", httpContext.getMessage( "Recalcular retroactivamente", ""), 1, chkConRecalcular.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConRangoCant_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConRangoCant_Internalname, httpContext.getMessage( "Rango de valores para cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtConRangoCant_Internalname, A1018ConRangoCant, "", "", (short)(0), 1, edtConRangoCant_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ConceptoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConPreReq.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConPreReq.getInternalname(), httpContext.getMessage( "Prerequisito para cálculo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConPreReq, cmbConPreReq.getInternalname(), GXutil.rtrim( A1066ConPreReq), 1, cmbConPreReq.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConPreReq.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoGeneral.htm");
         cmbConPreReq.setValue( GXutil.rtrim( A1066ConPreReq) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConPreReq.getInternalname(), "Values", cmbConPreReq.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAdelDescu.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAdelDescu.getInternalname(), httpContext.getMessage( "Adelanto/Descuento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAdelDescu, cmbConAdelDescu.getInternalname(), GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)), 1, cmbConAdelDescu.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConAdelDescu.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoGeneral.htm");
         cmbConAdelDescu.setValue( GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAdelDescu.getInternalname(), "Values", cmbConAdelDescu.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e114u1_client"+"'", TempTags, "", 2, "HLP_ConceptoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 106,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e124u1_client"+"'", TempTags, "", 2, "HLP_ConceptoGeneral.htm");
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
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEssistemaconceptosdefault.getInternalname(), GXutil.booltostr( AV15esSistemaConceptosDefault), "", "", chkavEssistemaconceptosdefault.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(110, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,110);\"");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConRetGanPropor_Internalname, GXutil.booltostr( A734ConRetGanPropor), GXutil.booltostr( A734ConRetGanPropor), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConRetGanPropor_Jsonclick, 0, "Attribute", "", "", "", "", edtConRetGanPropor_Visible, 0, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_ConceptoGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start4U2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Concepto General", ""), (short)(0)) ;
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
            strup4U0( ) ;
         }
      }
   }

   public void ws4U2( )
   {
      start4U2( ) ;
      evt4U2( ) ;
   }

   public void evt4U2( )
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
                              strup4U0( ) ;
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
                              strup4U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e134U2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e144U2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e154U2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4U0( ) ;
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
                              strup4U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = chkavEssistemaconceptosdefault.getInternalname() ;
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

   public void we4U2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm4U2( ) ;
         }
      }
   }

   public void pa4U2( )
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
            GX_FocusControl = chkavEssistemaconceptosdefault.getInternalname() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlatipoconcod4U1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlatipoconcod_data4U1( ) ;
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

   public void gxatipoconcod_html4U1( )
   {
      String gxdynajaxvalue;
      gxdlatipoconcod_data4U1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynTipoConCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynTipoConCod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = dynTipoConCod.getValidValue(A37TipoConCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37TipoConCod", A37TipoConCod);
      }
   }

   protected void gxdlatipoconcod_data4U1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H004U2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H004U2_A37TipoConCod[0]));
         gxdynajaxctrldescr.add(H004U2_A370TipoConDescrip[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlasubtipoconcod14U2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlasubtipoconcod1_data4U2( ) ;
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

   public void gxasubtipoconcod1_html4U2( )
   {
      String gxdynajaxvalue;
      gxdlasubtipoconcod1_data4U2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynSubTipoConCod1.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynSubTipoConCod1.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlasubtipoconcod1_data4U2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H004U3 */
      pr_default.execute(1, new Object[] {A37TipoConCod});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H004U3_A38SubTipoConCod1[0]));
         gxdynajaxctrldescr.add(H004U3_A371SubTipoConDes1[0]);
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxdlasubtipoconcod24U2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlasubtipoconcod2_data4U2( ) ;
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

   public void gxasubtipoconcod2_html4U2( )
   {
      String gxdynajaxvalue;
      gxdlasubtipoconcod2_data4U2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynSubTipoConCod2.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynSubTipoConCod2.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlasubtipoconcod2_data4U2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H004U4 */
      pr_default.execute(2, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      while ( (pr_default.getStatus(2) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H004U4_A39SubTipoConCod2[0]));
         gxdynajaxctrldescr.add(H004U4_A372SubTipoConDes2[0]);
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxasubtipoconcod1_html4U2( ) ;
         gxasubtipoconcod2_html4U2( ) ;
         dynTipoConCod.setName( "TIPOCONCOD" );
         dynTipoConCod.setWebtags( "" );
         dynTipoConCod.removeAllItems();
         /* Using cursor H004U5 */
         pr_default.execute(3);
         while ( (pr_default.getStatus(3) != 101) )
         {
            dynTipoConCod.addItem(H004U5_A37TipoConCod[0], H004U5_A370TipoConDescrip[0], (short)(0));
            pr_default.readNext(3);
         }
         pr_default.close(3);
         if ( dynTipoConCod.getItemCount() > 0 )
         {
            A37TipoConCod = dynTipoConCod.getValidValue(A37TipoConCod) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37TipoConCod", A37TipoConCod);
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = dynTipoConCod.getValidValue(A37TipoConCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37TipoConCod", A37TipoConCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynTipoConCod.getInternalname(), "Values", dynTipoConCod.ToJavascriptSource(), true);
      }
      A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A159ConVariable", A159ConVariable);
      if ( cmbConAplicGan.getItemCount() > 0 )
      {
         A735ConAplicGan = (byte)(GXutil.lval( cmbConAplicGan.getValidValue(GXutil.trim( GXutil.str( A735ConAplicGan, 2, 0))))) ;
         n735ConAplicGan = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A735ConAplicGan", GXutil.ltrimstr( DecimalUtil.doubleToDec(A735ConAplicGan), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAplicGan.setValue( GXutil.trim( GXutil.str( A735ConAplicGan, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAplicGan.getInternalname(), "Values", cmbConAplicGan.ToJavascriptSource(), true);
      }
      if ( dynSubTipoConCod1.getItemCount() > 0 )
      {
         A38SubTipoConCod1 = dynSubTipoConCod1.getValidValue(A38SubTipoConCod1) ;
         n38SubTipoConCod1 = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A38SubTipoConCod1", A38SubTipoConCod1);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynSubTipoConCod1.setValue( GXutil.rtrim( A38SubTipoConCod1) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynSubTipoConCod1.getInternalname(), "Values", dynSubTipoConCod1.ToJavascriptSource(), true);
      }
      if ( dynSubTipoConCod2.getItemCount() > 0 )
      {
         A39SubTipoConCod2 = dynSubTipoConCod2.getValidValue(A39SubTipoConCod2) ;
         n39SubTipoConCod2 = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A39SubTipoConCod2", A39SubTipoConCod2);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynSubTipoConCod2.setValue( GXutil.rtrim( A39SubTipoConCod2) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynSubTipoConCod2.getInternalname(), "Values", dynSubTipoConCod2.ToJavascriptSource(), true);
      }
      A150ConHabilitado = GXutil.strtobool( GXutil.booltostr( A150ConHabilitado)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A150ConHabilitado", A150ConHabilitado);
      A143ConCanti = GXutil.strtobool( GXutil.booltostr( A143ConCanti)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A143ConCanti", A143ConCanti);
      A158ConValUni = GXutil.strtobool( GXutil.booltostr( A158ConValUni)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A158ConValUni", A158ConValUni);
      A152ConImporte = GXutil.strtobool( GXutil.booltostr( A152ConImporte)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A152ConImporte", A152ConImporte);
      if ( cmbConVigencia.getItemCount() > 0 )
      {
         A162ConVigencia = (byte)(GXutil.lval( cmbConVigencia.getValidValue(GXutil.trim( GXutil.str( A162ConVigencia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConVigencia.setValue( GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConVigencia.getInternalname(), "Values", cmbConVigencia.ToJavascriptSource(), true);
      }
      A762ConRecalcular = GXutil.strtobool( GXutil.booltostr( A762ConRecalcular)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A762ConRecalcular", A762ConRecalcular);
      if ( cmbConPreReq.getItemCount() > 0 )
      {
         A1066ConPreReq = cmbConPreReq.getValidValue(A1066ConPreReq) ;
         n1066ConPreReq = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1066ConPreReq", A1066ConPreReq);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConPreReq.setValue( GXutil.rtrim( A1066ConPreReq) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConPreReq.getInternalname(), "Values", cmbConPreReq.ToJavascriptSource(), true);
      }
      if ( cmbConAdelDescu.getItemCount() > 0 )
      {
         A1077ConAdelDescu = (byte)(GXutil.lval( cmbConAdelDescu.getValidValue(GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0))))) ;
         n1077ConAdelDescu = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAdelDescu.setValue( GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAdelDescu.getInternalname(), "Values", cmbConAdelDescu.ToJavascriptSource(), true);
      }
      AV15esSistemaConceptosDefault = GXutil.strtobool( GXutil.booltostr( AV15esSistemaConceptosDefault)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15esSistemaConceptosDefault", AV15esSistemaConceptosDefault);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf4U2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV19Pgmname = "ConceptoGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf4U2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e154U2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H004U6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A734ConRetGanPropor = H004U6_A734ConRetGanPropor[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A734ConRetGanPropor", A734ConRetGanPropor);
            A1077ConAdelDescu = H004U6_A1077ConAdelDescu[0] ;
            n1077ConAdelDescu = H004U6_n1077ConAdelDescu[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
            A1066ConPreReq = H004U6_A1066ConPreReq[0] ;
            n1066ConPreReq = H004U6_n1066ConPreReq[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1066ConPreReq", A1066ConPreReq);
            A1018ConRangoCant = H004U6_A1018ConRangoCant[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1018ConRangoCant", A1018ConRangoCant);
            A762ConRecalcular = H004U6_A762ConRecalcular[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A762ConRecalcular", A762ConRecalcular);
            A153ConObservacion = H004U6_A153ConObservacion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A153ConObservacion", A153ConObservacion);
            A162ConVigencia = H004U6_A162ConVigencia[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
            A152ConImporte = H004U6_A152ConImporte[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A152ConImporte", A152ConImporte);
            A158ConValUni = H004U6_A158ConValUni[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A158ConValUni", A158ConValUni);
            A143ConCanti = H004U6_A143ConCanti[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A143ConCanti", A143ConCanti);
            A150ConHabilitado = H004U6_A150ConHabilitado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A150ConHabilitado", A150ConHabilitado);
            A41ConDescrip = H004U6_A41ConDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A41ConDescrip", A41ConDescrip);
            A39SubTipoConCod2 = H004U6_A39SubTipoConCod2[0] ;
            n39SubTipoConCod2 = H004U6_n39SubTipoConCod2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A39SubTipoConCod2", A39SubTipoConCod2);
            A38SubTipoConCod1 = H004U6_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = H004U6_n38SubTipoConCod1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A38SubTipoConCod1", A38SubTipoConCod1);
            A735ConAplicGan = H004U6_A735ConAplicGan[0] ;
            n735ConAplicGan = H004U6_n735ConAplicGan[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A735ConAplicGan", GXutil.ltrimstr( DecimalUtil.doubleToDec(A735ConAplicGan), 2, 0));
            A159ConVariable = H004U6_A159ConVariable[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A159ConVariable", A159ConVariable);
            A37TipoConCod = H004U6_A37TipoConCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37TipoConCod", A37TipoConCod);
            A148ConFormula = H004U6_A148ConFormula[0] ;
            n148ConFormula = H004U6_n148ConFormula[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A148ConFormula", A148ConFormula);
            gxasubtipoconcod1_html4U2( ) ;
            gxasubtipoconcod2_html4U2( ) ;
            /* Execute user event: Load */
            e144U2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
         wb4U0( ) ;
      }
   }

   public void send_integrity_lvl_hashes4U2( )
   {
   }

   public void before_start_formulas( )
   {
      AV19Pgmname = "ConceptoGeneral" ;
      Gx_err = (short)(0) ;
      gxasubtipoconcod1_html4U2( ) ;
      gxasubtipoconcod2_html4U2( ) ;
      fix_multi_value_controls( ) ;
   }

   public void strup4U0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e134U2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA26ConCodigo = httpContext.cgiGet( sPrefix+"wcpOA26ConCodigo") ;
         /* Read variables values. */
         A148ConFormula = httpContext.cgiGet( edtConFormula_Internalname) ;
         n148ConFormula = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A148ConFormula", A148ConFormula);
         dynTipoConCod.setValue( httpContext.cgiGet( dynTipoConCod.getInternalname()) );
         A37TipoConCod = httpContext.cgiGet( dynTipoConCod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37TipoConCod", A37TipoConCod);
         A159ConVariable = GXutil.strtobool( httpContext.cgiGet( chkConVariable.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A159ConVariable", A159ConVariable);
         cmbConAplicGan.setValue( httpContext.cgiGet( cmbConAplicGan.getInternalname()) );
         A735ConAplicGan = (byte)(GXutil.lval( httpContext.cgiGet( cmbConAplicGan.getInternalname()))) ;
         n735ConAplicGan = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A735ConAplicGan", GXutil.ltrimstr( DecimalUtil.doubleToDec(A735ConAplicGan), 2, 0));
         dynSubTipoConCod1.setValue( httpContext.cgiGet( dynSubTipoConCod1.getInternalname()) );
         A38SubTipoConCod1 = httpContext.cgiGet( dynSubTipoConCod1.getInternalname()) ;
         n38SubTipoConCod1 = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A38SubTipoConCod1", A38SubTipoConCod1);
         dynSubTipoConCod2.setValue( httpContext.cgiGet( dynSubTipoConCod2.getInternalname()) );
         A39SubTipoConCod2 = httpContext.cgiGet( dynSubTipoConCod2.getInternalname()) ;
         n39SubTipoConCod2 = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A39SubTipoConCod2", A39SubTipoConCod2);
         A41ConDescrip = httpContext.cgiGet( edtConDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A41ConDescrip", A41ConDescrip);
         A150ConHabilitado = GXutil.strtobool( httpContext.cgiGet( chkConHabilitado.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A150ConHabilitado", A150ConHabilitado);
         A143ConCanti = GXutil.strtobool( httpContext.cgiGet( chkConCanti.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A143ConCanti", A143ConCanti);
         A158ConValUni = GXutil.strtobool( httpContext.cgiGet( chkConValUni.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A158ConValUni", A158ConValUni);
         A152ConImporte = GXutil.strtobool( httpContext.cgiGet( chkConImporte.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A152ConImporte", A152ConImporte);
         cmbConVigencia.setValue( httpContext.cgiGet( cmbConVigencia.getInternalname()) );
         A162ConVigencia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConVigencia.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
         A153ConObservacion = httpContext.cgiGet( edtConObservacion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A153ConObservacion", A153ConObservacion);
         A762ConRecalcular = GXutil.strtobool( httpContext.cgiGet( chkConRecalcular.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A762ConRecalcular", A762ConRecalcular);
         A1018ConRangoCant = httpContext.cgiGet( edtConRangoCant_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1018ConRangoCant", A1018ConRangoCant);
         cmbConPreReq.setValue( httpContext.cgiGet( cmbConPreReq.getInternalname()) );
         A1066ConPreReq = httpContext.cgiGet( cmbConPreReq.getInternalname()) ;
         n1066ConPreReq = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1066ConPreReq", A1066ConPreReq);
         cmbConAdelDescu.setValue( httpContext.cgiGet( cmbConAdelDescu.getInternalname()) );
         A1077ConAdelDescu = (byte)(GXutil.lval( httpContext.cgiGet( cmbConAdelDescu.getInternalname()))) ;
         n1077ConAdelDescu = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
         AV15esSistemaConceptosDefault = GXutil.strtobool( httpContext.cgiGet( chkavEssistemaconceptosdefault.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15esSistemaConceptosDefault", AV15esSistemaConceptosDefault);
         A734ConRetGanPropor = GXutil.strtobool( httpContext.cgiGet( edtConRetGanPropor_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A734ConRetGanPropor", A734ConRetGanPropor);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ConceptoGeneral");
         A37TipoConCod = httpContext.cgiGet( dynTipoConCod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37TipoConCod", A37TipoConCod);
         forbiddenHiddens.add("TipoConCod", GXutil.rtrim( localUtil.format( A37TipoConCod, "")));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("conceptogeneral:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
         gxasubtipoconcod1_html4U2( ) ;
         gxasubtipoconcod2_html4U2( ) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e134U2 ();
      if (returnInSub) return;
   }

   public void e134U2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV11CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV11CliCod = GXt_int1 ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      chkavEssistemaconceptosdefault.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavEssistemaconceptosdefault.getInternalname(), "Visible", GXutil.ltrimstr( chkavEssistemaconceptosdefault.getVisible(), 5, 0), true);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOAD' */
      S122 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e144U2( )
   {
      /* Load Routine */
      returnInSub = false ;
      chkavEssistemaconceptosdefault.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavEssistemaconceptosdefault.getInternalname(), "Visible", GXutil.ltrimstr( chkavEssistemaconceptosdefault.getVisible(), 5, 0), true);
      edtConRetGanPropor_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConRetGanPropor_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRetGanPropor_Visible), 5, 0), true);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      GXt_boolean4 = AV14TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto_Update", GXv_boolean5) ;
      conceptogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV14TempBoolean = GXt_boolean4 ;
      if ( ! ( AV14TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV14TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto_Delete", GXv_boolean5) ;
      conceptogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV14TempBoolean = GXt_boolean4 ;
      if ( ! ( AV14TempBoolean ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) ) )
      {
         edtConFormula_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConFormula_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFormula_Visible), 5, 0), true);
         divConformula_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConformula_cell_Internalname, "Class", divConformula_cell_Class, true);
      }
      else
      {
         edtConFormula_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConFormula_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFormula_Visible), 5, 0), true);
         divConformula_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConformula_cell_Internalname, "Class", divConformula_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) ) )
      {
         chkConVariable.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), true);
         divConvariable_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
      }
      else
      {
         chkConVariable.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), true);
         divConvariable_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 ) ) )
      {
         cmbConAplicGan.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAplicGan.getInternalname(), "Visible", GXutil.ltrimstr( cmbConAplicGan.getVisible(), 5, 0), true);
         divConaplicgan_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
      }
      else
      {
         cmbConAplicGan.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAplicGan.getInternalname(), "Visible", GXutil.ltrimstr( cmbConAplicGan.getVisible(), 5, 0), true);
         divConaplicgan_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
      }
      if ( ! ( false ) )
      {
         chkConCanti.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConCanti.getInternalname(), "Visible", GXutil.ltrimstr( chkConCanti.getVisible(), 5, 0), true);
         divConcanti_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConcanti_cell_Internalname, "Class", divConcanti_cell_Class, true);
      }
      else
      {
         chkConCanti.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConCanti.getInternalname(), "Visible", GXutil.ltrimstr( chkConCanti.getVisible(), 5, 0), true);
         divConcanti_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConcanti_cell_Internalname, "Class", divConcanti_cell_Class, true);
      }
      if ( ! ( false ) )
      {
         chkConValUni.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConValUni.getInternalname(), "Visible", GXutil.ltrimstr( chkConValUni.getVisible(), 5, 0), true);
         divConvaluni_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvaluni_cell_Internalname, "Class", divConvaluni_cell_Class, true);
      }
      else
      {
         chkConValUni.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConValUni.getInternalname(), "Visible", GXutil.ltrimstr( chkConValUni.getVisible(), 5, 0), true);
         divConvaluni_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvaluni_cell_Internalname, "Class", divConvaluni_cell_Class, true);
      }
      if ( ! ( false ) )
      {
         chkConImporte.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConImporte.getInternalname(), "Visible", GXutil.ltrimstr( chkConImporte.getVisible(), 5, 0), true);
         divConimporte_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConimporte_cell_Internalname, "Class", divConimporte_cell_Class, true);
      }
      else
      {
         chkConImporte.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConImporte.getInternalname(), "Visible", GXutil.ltrimstr( chkConImporte.getVisible(), 5, 0), true);
         divConimporte_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConimporte_cell_Internalname, "Class", divConimporte_cell_Class, true);
      }
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV7TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV19Pgmname );
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV10HTTPRequest.getScriptName()+"?"+AV10HTTPRequest.getQuerystring() );
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Concepto" );
      AV9Session.setValue("TrnContext", AV7TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e154U2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV11CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV11CliCod = GXt_int1 ;
   }

   public void S122( )
   {
      /* 'LOAD' Routine */
      returnInSub = false ;
      GXt_boolean4 = AV15esSistemaConceptosDefault ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean5) ;
      conceptogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV15esSistemaConceptosDefault = GXt_boolean4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15esSistemaConceptosDefault", AV15esSistemaConceptosDefault);
      edtConFormula_Link = formatLink("web.editarformula", new String[] {GXutil.URLEncode(GXutil.rtrim(A26ConCodigo))}, new String[] {"MenuOpcCod","ConCodigo","LiqNro","LegNumero"})  ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConFormula_Internalname, "Link", edtConFormula_Link, true);
      chkavEssistemaconceptosdefault.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavEssistemaconceptosdefault.getInternalname(), "Visible", GXutil.ltrimstr( chkavEssistemaconceptosdefault.getVisible(), 5, 0), true);
      bttBtnupdate_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      bttBtndelete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) ) )
      {
         chkConVariable.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), true);
         divConvariable_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
      }
      else
      {
         chkConVariable.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), true);
         divConvariable_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
      }
      chkConCanti.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConCanti.getInternalname(), "Visible", GXutil.ltrimstr( chkConCanti.getVisible(), 5, 0), true);
      divConcanti_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divConcanti_cell_Internalname, "Class", divConcanti_cell_Class, true);
      chkConValUni.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConValUni.getInternalname(), "Visible", GXutil.ltrimstr( chkConValUni.getVisible(), 5, 0), true);
      divConvaluni_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvaluni_cell_Internalname, "Class", divConvaluni_cell_Class, true);
      chkConImporte.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConImporte.getInternalname(), "Visible", GXutil.ltrimstr( chkConImporte.getVisible(), 5, 0), true);
      divConimporte_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divConimporte_cell_Internalname, "Class", divConimporte_cell_Class, true);
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A26ConCodigo = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
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
      pa4U2( ) ;
      ws4U2( ) ;
      we4U2( ) ;
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
      sCtrlA26ConCodigo = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa4U2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "conceptogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa4U2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA26ConCodigo = httpContext.cgiGet( sPrefix+"wcpOA26ConCodigo") ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( GXutil.strcmp(A26ConCodigo, wcpOA26ConCodigo) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA26ConCodigo = A26ConCodigo ;
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
      sCtrlA26ConCodigo = httpContext.cgiGet( sPrefix+"A26ConCodigo_CTRL") ;
      if ( GXutil.len( sCtrlA26ConCodigo) > 0 )
      {
         A26ConCodigo = httpContext.cgiGet( sCtrlA26ConCodigo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
      }
      else
      {
         A26ConCodigo = httpContext.cgiGet( sPrefix+"A26ConCodigo_PARM") ;
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
      pa4U2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws4U2( ) ;
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
      ws4U2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A26ConCodigo_PARM", GXutil.rtrim( A26ConCodigo));
      if ( GXutil.len( GXutil.rtrim( sCtrlA26ConCodigo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A26ConCodigo_CTRL", GXutil.rtrim( sCtrlA26ConCodigo));
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
      we4U2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713285480", true, true);
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
      httpContext.AddJavascriptSource("conceptogeneral.js", "?20251713285481", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtConFormula_Internalname = sPrefix+"CONFORMULA" ;
      divConformula_cell_Internalname = sPrefix+"CONFORMULA_CELL" ;
      dynTipoConCod.setInternalname( sPrefix+"TIPOCONCOD" );
      chkConVariable.setInternalname( sPrefix+"CONVARIABLE" );
      divConvariable_cell_Internalname = sPrefix+"CONVARIABLE_CELL" ;
      cmbConAplicGan.setInternalname( sPrefix+"CONAPLICGAN" );
      divConaplicgan_cell_Internalname = sPrefix+"CONAPLICGAN_CELL" ;
      dynSubTipoConCod1.setInternalname( sPrefix+"SUBTIPOCONCOD1" );
      dynSubTipoConCod2.setInternalname( sPrefix+"SUBTIPOCONCOD2" );
      edtConCodigo_Internalname = sPrefix+"CONCODIGO" ;
      edtConDescrip_Internalname = sPrefix+"CONDESCRIP" ;
      chkConHabilitado.setInternalname( sPrefix+"CONHABILITADO" );
      chkConCanti.setInternalname( sPrefix+"CONCANTI" );
      divConcanti_cell_Internalname = sPrefix+"CONCANTI_CELL" ;
      chkConValUni.setInternalname( sPrefix+"CONVALUNI" );
      divConvaluni_cell_Internalname = sPrefix+"CONVALUNI_CELL" ;
      chkConImporte.setInternalname( sPrefix+"CONIMPORTE" );
      divConimporte_cell_Internalname = sPrefix+"CONIMPORTE_CELL" ;
      cmbConVigencia.setInternalname( sPrefix+"CONVIGENCIA" );
      edtConObservacion_Internalname = sPrefix+"CONOBSERVACION" ;
      chkConRecalcular.setInternalname( sPrefix+"CONRECALCULAR" );
      edtConRangoCant_Internalname = sPrefix+"CONRANGOCANT" ;
      cmbConPreReq.setInternalname( sPrefix+"CONPREREQ" );
      cmbConAdelDescu.setInternalname( sPrefix+"CONADELDESCU" );
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      chkavEssistemaconceptosdefault.setInternalname( sPrefix+"vESSISTEMACONCEPTOSDEFAULT" );
      edtConRetGanPropor_Internalname = sPrefix+"CONRETGANPROPOR" ;
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
      edtConRetGanPropor_Jsonclick = "" ;
      edtConRetGanPropor_Visible = 1 ;
      chkavEssistemaconceptosdefault.setVisible( 1 );
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      cmbConAdelDescu.setJsonclick( "" );
      cmbConAdelDescu.setEnabled( 0 );
      cmbConPreReq.setJsonclick( "" );
      cmbConPreReq.setEnabled( 0 );
      edtConRangoCant_Enabled = 0 ;
      chkConRecalcular.setEnabled( 0 );
      edtConObservacion_Enabled = 0 ;
      cmbConVigencia.setJsonclick( "" );
      cmbConVigencia.setEnabled( 0 );
      chkConImporte.setEnabled( 0 );
      chkConImporte.setVisible( 1 );
      divConimporte_cell_Class = "col-xs-12" ;
      chkConValUni.setEnabled( 0 );
      chkConValUni.setVisible( 1 );
      divConvaluni_cell_Class = "col-xs-12" ;
      chkConCanti.setEnabled( 0 );
      chkConCanti.setVisible( 1 );
      divConcanti_cell_Class = "col-xs-12" ;
      chkConHabilitado.setEnabled( 0 );
      edtConDescrip_Enabled = 0 ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Enabled = 0 ;
      dynSubTipoConCod2.setJsonclick( "" );
      dynSubTipoConCod2.setEnabled( 0 );
      dynSubTipoConCod1.setJsonclick( "" );
      dynSubTipoConCod1.setEnabled( 0 );
      cmbConAplicGan.setJsonclick( "" );
      cmbConAplicGan.setEnabled( 0 );
      cmbConAplicGan.setVisible( 1 );
      divConaplicgan_cell_Class = "col-xs-12" ;
      chkConVariable.setEnabled( 0 );
      chkConVariable.setVisible( 1 );
      divConvariable_cell_Class = "col-xs-12" ;
      dynTipoConCod.setJsonclick( "" );
      dynTipoConCod.setEnabled( 0 );
      edtConFormula_Link = "" ;
      edtConFormula_Enabled = 0 ;
      edtConFormula_Visible = 1 ;
      divConformula_cell_Class = "col-xs-12" ;
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
      dynTipoConCod.setName( "TIPOCONCOD" );
      dynTipoConCod.setWebtags( "" );
      dynTipoConCod.removeAllItems();
      /* Using cursor H004U7 */
      pr_default.execute(5);
      while ( (pr_default.getStatus(5) != 101) )
      {
         dynTipoConCod.addItem(H004U7_A37TipoConCod[0], H004U7_A370TipoConDescrip[0], (short)(0));
         pr_default.readNext(5);
      }
      pr_default.close(5);
      if ( dynTipoConCod.getItemCount() > 0 )
      {
      }
      chkConVariable.setName( "CONVARIABLE" );
      chkConVariable.setWebtags( "" );
      chkConVariable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConVariable.getInternalname(), "TitleCaption", chkConVariable.getCaption(), true);
      chkConVariable.setCheckedValue( "false" );
      cmbConAplicGan.setName( "CONAPLICGAN" );
      cmbConAplicGan.setWebtags( "" );
      cmbConAplicGan.addItem(GXutil.trim( GXutil.str( 0, 2, 0)), httpContext.getMessage( "No Aplica", ""), (short)(0));
      cmbConAplicGan.addItem("1", httpContext.getMessage( "Totalmente Gravado", ""), (short)(0));
      cmbConAplicGan.addItem("2", httpContext.getMessage( "Totalmente Exento", ""), (short)(0));
      cmbConAplicGan.addItem("4", httpContext.getMessage( "Exento parcialmente por ser horas extras de feriado y fines de semana", ""), (short)(0));
      cmbConAplicGan.addItem("5", httpContext.getMessage( "Exento hasta el 40% del Mínimo no imponible", ""), (short)(0));
      cmbConAplicGan.addItem("6", httpContext.getMessage( "SAC (puede ser gravado, exento, o parcialmente exento)", ""), (short)(0));
      cmbConAplicGan.addItem("7", httpContext.getMessage( "Bono de productividad. Exento parcialmente, prorrateable y condicionado al promedio del sueldo", ""), (short)(0));
      cmbConAplicGan.addItem("8", httpContext.getMessage( "Fallo de caja. Exento parcialmente, prorrateable y condicionado al promedio del sueldo", ""), (short)(0));
      cmbConAplicGan.addItem("9", httpContext.getMessage( "Similar naturaleza (similar a bono de prod y fallo de caja).  Exento parcialmente, prorrateable y condicionado al promedio del sueldo", ""), (short)(0));
      if ( cmbConAplicGan.getItemCount() > 0 )
      {
      }
      dynSubTipoConCod1.setName( "SUBTIPOCONCOD1" );
      dynSubTipoConCod1.setWebtags( "" );
      dynSubTipoConCod2.setName( "SUBTIPOCONCOD2" );
      dynSubTipoConCod2.setWebtags( "" );
      chkConHabilitado.setName( "CONHABILITADO" );
      chkConHabilitado.setWebtags( "" );
      chkConHabilitado.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConHabilitado.getInternalname(), "TitleCaption", chkConHabilitado.getCaption(), true);
      chkConHabilitado.setCheckedValue( "false" );
      chkConCanti.setName( "CONCANTI" );
      chkConCanti.setWebtags( "" );
      chkConCanti.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConCanti.getInternalname(), "TitleCaption", chkConCanti.getCaption(), true);
      chkConCanti.setCheckedValue( "false" );
      chkConValUni.setName( "CONVALUNI" );
      chkConValUni.setWebtags( "" );
      chkConValUni.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConValUni.getInternalname(), "TitleCaption", chkConValUni.getCaption(), true);
      chkConValUni.setCheckedValue( "false" );
      chkConImporte.setName( "CONIMPORTE" );
      chkConImporte.setWebtags( "" );
      chkConImporte.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConImporte.getInternalname(), "TitleCaption", chkConImporte.getCaption(), true);
      chkConImporte.setCheckedValue( "false" );
      cmbConVigencia.setName( "CONVIGENCIA" );
      cmbConVigencia.setWebtags( "" );
      cmbConVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
      cmbConVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
      if ( cmbConVigencia.getItemCount() > 0 )
      {
      }
      chkConRecalcular.setName( "CONRECALCULAR" );
      chkConRecalcular.setWebtags( "" );
      chkConRecalcular.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConRecalcular.getInternalname(), "TitleCaption", chkConRecalcular.getCaption(), true);
      chkConRecalcular.setCheckedValue( "false" );
      cmbConPreReq.setName( "CONPREREQ" );
      cmbConPreReq.setWebtags( "" );
      cmbConPreReq.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbConPreReq.addItem("APO_SIPA", httpContext.getMessage( "Conceptos que aporten a SIPA o Renatre", ""), (short)(0));
      cmbConPreReq.addItem("APO_SIPA_NoSacNiVac", httpContext.getMessage( "Conceptos que aporten a SIPA o Renatre distintos a SAC y vacaciones", ""), (short)(0));
      cmbConPreReq.addItem("APO_INSSJyP", httpContext.getMessage( "Conceptos que aporten a INSSJyP", ""), (short)(0));
      cmbConPreReq.addItem("APO_OS", httpContext.getMessage( "Conceptos que aporten a Obra Social o FSR", ""), (short)(0));
      cmbConPreReq.addItem("APO_DIF", httpContext.getMessage( "Conceptos que aporten a Diferenciales", ""), (short)(0));
      cmbConPreReq.addItem("APO_ESP", httpContext.getMessage( "Conceptos que aporten a Especiales", ""), (short)(0));
      cmbConPreReq.addItem("CON_SIPA", httpContext.getMessage( "Conceptos que contribuyan a SIPA o INSSJyP", ""), (short)(0));
      cmbConPreReq.addItem("CON_OS", httpContext.getMessage( "Conceptos que contribuyan a Obra social o FSR", ""), (short)(0));
      cmbConPreReq.addItem("CON_FNE", httpContext.getMessage( "Conceptos que contribuyan a AAFF, Renatre,o FNE", ""), (short)(0));
      cmbConPreReq.addItem("CON_LRT", httpContext.getMessage( "Conceptos que contribuyan a LRT", ""), (short)(0));
      cmbConPreReq.addItem("BRUTA", httpContext.getMessage( "Conceptos remunerativos y no remunerativos", ""), (short)(0));
      cmbConPreReq.addItem("REM", httpContext.getMessage( "Conceptos remunerativos", ""), (short)(0));
      cmbConPreReq.addItem("NRE", httpContext.getMessage( "Conceptos no remunerativos", ""), (short)(0));
      cmbConPreReq.addItem("REMNOSAC", httpContext.getMessage( "Conceptos remunerativos exceptuando SAC", ""), (short)(0));
      cmbConPreReq.addItem("EXENTOS", httpContext.getMessage( "Conceptos totalmente exentos de IIGG (excepto sac) y conceptos prorrateables", ""), (short)(0));
      cmbConPreReq.addItem("LICENCIAS", httpContext.getMessage( "Conceptos relacionados a licencias o feriados", ""), (short)(0));
      cmbConPreReq.addItem("FIJAS", httpContext.getMessage( "Conceptos de remuneración fija de tipo remunerativos y no remunerativos con clasificacion distinta a vacaciones", ""), (short)(0));
      if ( cmbConPreReq.getItemCount() > 0 )
      {
      }
      cmbConAdelDescu.setName( "CONADELDESCU" );
      cmbConAdelDescu.setWebtags( "" );
      cmbConAdelDescu.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbConAdelDescu.addItem("1", httpContext.getMessage( "Adelanto de mes próximo", ""), (short)(0));
      cmbConAdelDescu.addItem("2", httpContext.getMessage( "Descuento", ""), (short)(0));
      if ( cmbConAdelDescu.getItemCount() > 0 )
      {
      }
      chkavEssistemaconceptosdefault.setName( "vESSISTEMACONCEPTOSDEFAULT" );
      chkavEssistemaconceptosdefault.setWebtags( "" );
      chkavEssistemaconceptosdefault.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavEssistemaconceptosdefault.getInternalname(), "TitleCaption", chkavEssistemaconceptosdefault.getCaption(), true);
      chkavEssistemaconceptosdefault.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'dynSubTipoConCod1'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV15esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e114U1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e124U1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[]}");
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
      wcpOA26ConCodigo = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A26ConCodigo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      A37TipoConCod = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A148ConFormula = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A41ConDescrip = "" ;
      A153ConObservacion = "" ;
      A1018ConRangoCant = "" ;
      A1066ConPreReq = "" ;
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
      H004U2_A37TipoConCod = new String[] {""} ;
      H004U2_A370TipoConDescrip = new String[] {""} ;
      H004U3_A38SubTipoConCod1 = new String[] {""} ;
      H004U3_n38SubTipoConCod1 = new boolean[] {false} ;
      H004U3_A371SubTipoConDes1 = new String[] {""} ;
      H004U3_A37TipoConCod = new String[] {""} ;
      H004U4_A39SubTipoConCod2 = new String[] {""} ;
      H004U4_n39SubTipoConCod2 = new boolean[] {false} ;
      H004U4_A372SubTipoConDes2 = new String[] {""} ;
      H004U4_A37TipoConCod = new String[] {""} ;
      H004U4_A38SubTipoConCod1 = new String[] {""} ;
      H004U4_n38SubTipoConCod1 = new boolean[] {false} ;
      H004U5_A37TipoConCod = new String[] {""} ;
      H004U5_A370TipoConDescrip = new String[] {""} ;
      AV19Pgmname = "" ;
      H004U6_A3CliCod = new int[1] ;
      H004U6_A26ConCodigo = new String[] {""} ;
      H004U6_A734ConRetGanPropor = new boolean[] {false} ;
      H004U6_A1077ConAdelDescu = new byte[1] ;
      H004U6_n1077ConAdelDescu = new boolean[] {false} ;
      H004U6_A1066ConPreReq = new String[] {""} ;
      H004U6_n1066ConPreReq = new boolean[] {false} ;
      H004U6_A1018ConRangoCant = new String[] {""} ;
      H004U6_A762ConRecalcular = new boolean[] {false} ;
      H004U6_A153ConObservacion = new String[] {""} ;
      H004U6_A162ConVigencia = new byte[1] ;
      H004U6_A152ConImporte = new boolean[] {false} ;
      H004U6_A158ConValUni = new boolean[] {false} ;
      H004U6_A143ConCanti = new boolean[] {false} ;
      H004U6_A150ConHabilitado = new boolean[] {false} ;
      H004U6_A41ConDescrip = new String[] {""} ;
      H004U6_A39SubTipoConCod2 = new String[] {""} ;
      H004U6_n39SubTipoConCod2 = new boolean[] {false} ;
      H004U6_A38SubTipoConCod1 = new String[] {""} ;
      H004U6_n38SubTipoConCod1 = new boolean[] {false} ;
      H004U6_A735ConAplicGan = new byte[1] ;
      H004U6_n735ConAplicGan = new boolean[] {false} ;
      H004U6_A159ConVariable = new boolean[] {false} ;
      H004U6_A37TipoConCod = new String[] {""} ;
      H004U6_A148ConFormula = new String[] {""} ;
      H004U6_n148ConFormula = new boolean[] {false} ;
      hsh = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      Gx_mode = "" ;
      AV7TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10HTTPRequest = httpContext.getHttpRequest();
      AV9Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA26ConCodigo = "" ;
      H004U7_A37TipoConCod = new String[] {""} ;
      H004U7_A370TipoConDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptogeneral__default(),
         new Object[] {
             new Object[] {
            H004U2_A37TipoConCod, H004U2_A370TipoConDescrip
            }
            , new Object[] {
            H004U3_A38SubTipoConCod1, H004U3_A371SubTipoConDes1, H004U3_A37TipoConCod
            }
            , new Object[] {
            H004U4_A39SubTipoConCod2, H004U4_A372SubTipoConDes2, H004U4_A37TipoConCod, H004U4_A38SubTipoConCod1
            }
            , new Object[] {
            H004U5_A37TipoConCod, H004U5_A370TipoConDescrip
            }
            , new Object[] {
            H004U6_A3CliCod, H004U6_A26ConCodigo, H004U6_A734ConRetGanPropor, H004U6_A1077ConAdelDescu, H004U6_n1077ConAdelDescu, H004U6_A1066ConPreReq, H004U6_n1066ConPreReq, H004U6_A1018ConRangoCant, H004U6_A762ConRecalcular, H004U6_A153ConObservacion,
            H004U6_A162ConVigencia, H004U6_A152ConImporte, H004U6_A158ConValUni, H004U6_A143ConCanti, H004U6_A150ConHabilitado, H004U6_A41ConDescrip, H004U6_A39SubTipoConCod2, H004U6_n39SubTipoConCod2, H004U6_A38SubTipoConCod1, H004U6_n38SubTipoConCod1,
            H004U6_A735ConAplicGan, H004U6_n735ConAplicGan, H004U6_A159ConVariable, H004U6_A37TipoConCod, H004U6_A148ConFormula, H004U6_n148ConFormula
            }
            , new Object[] {
            H004U7_A37TipoConCod, H004U7_A370TipoConDescrip
            }
         }
      );
      AV19Pgmname = "ConceptoGeneral" ;
      /* GeneXus formulas. */
      AV19Pgmname = "ConceptoGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A735ConAplicGan ;
   private byte A162ConVigencia ;
   private byte A1077ConAdelDescu ;
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
   private int edtConFormula_Visible ;
   private int edtConFormula_Enabled ;
   private int edtConCodigo_Enabled ;
   private int edtConDescrip_Enabled ;
   private int edtConObservacion_Enabled ;
   private int edtConRangoCant_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtConRetGanPropor_Visible ;
   private int edtCliCod_Visible ;
   private int gxdynajaxindex ;
   private int AV11CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String wcpOA26ConCodigo ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A26ConCodigo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String A37TipoConCod ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String divConformula_cell_Internalname ;
   private String divConformula_cell_Class ;
   private String edtConFormula_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtConFormula_Link ;
   private String divConvariable_cell_Internalname ;
   private String divConvariable_cell_Class ;
   private String divConaplicgan_cell_Internalname ;
   private String divConaplicgan_cell_Class ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String edtConCodigo_Internalname ;
   private String edtConCodigo_Jsonclick ;
   private String edtConDescrip_Internalname ;
   private String divConcanti_cell_Internalname ;
   private String divConcanti_cell_Class ;
   private String divConvaluni_cell_Internalname ;
   private String divConvaluni_cell_Class ;
   private String divConimporte_cell_Internalname ;
   private String divConimporte_cell_Class ;
   private String edtConObservacion_Internalname ;
   private String edtConRangoCant_Internalname ;
   private String A1066ConPreReq ;
   private String TempTags ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtConRetGanPropor_Internalname ;
   private String edtConRetGanPropor_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV19Pgmname ;
   private String hsh ;
   private String Gx_mode ;
   private String sCtrlA3CliCod ;
   private String sCtrlA26ConCodigo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A159ConVariable ;
   private boolean A150ConHabilitado ;
   private boolean A143ConCanti ;
   private boolean A158ConValUni ;
   private boolean A152ConImporte ;
   private boolean A762ConRecalcular ;
   private boolean AV15esSistemaConceptosDefault ;
   private boolean A734ConRetGanPropor ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n38SubTipoConCod1 ;
   private boolean n735ConAplicGan ;
   private boolean n39SubTipoConCod2 ;
   private boolean n1066ConPreReq ;
   private boolean n1077ConAdelDescu ;
   private boolean n148ConFormula ;
   private boolean returnInSub ;
   private boolean AV14TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A148ConFormula ;
   private String A153ConObservacion ;
   private String A41ConDescrip ;
   private String A1018ConRangoCant ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV10HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynTipoConCod ;
   private ICheckbox chkConVariable ;
   private HTMLChoice cmbConAplicGan ;
   private HTMLChoice dynSubTipoConCod1 ;
   private HTMLChoice dynSubTipoConCod2 ;
   private ICheckbox chkConHabilitado ;
   private ICheckbox chkConCanti ;
   private ICheckbox chkConValUni ;
   private ICheckbox chkConImporte ;
   private HTMLChoice cmbConVigencia ;
   private ICheckbox chkConRecalcular ;
   private HTMLChoice cmbConPreReq ;
   private HTMLChoice cmbConAdelDescu ;
   private ICheckbox chkavEssistemaconceptosdefault ;
   private IDataStoreProvider pr_default ;
   private String[] H004U2_A37TipoConCod ;
   private String[] H004U2_A370TipoConDescrip ;
   private String[] H004U3_A38SubTipoConCod1 ;
   private boolean[] H004U3_n38SubTipoConCod1 ;
   private String[] H004U3_A371SubTipoConDes1 ;
   private String[] H004U3_A37TipoConCod ;
   private String[] H004U4_A39SubTipoConCod2 ;
   private boolean[] H004U4_n39SubTipoConCod2 ;
   private String[] H004U4_A372SubTipoConDes2 ;
   private String[] H004U4_A37TipoConCod ;
   private String[] H004U4_A38SubTipoConCod1 ;
   private boolean[] H004U4_n38SubTipoConCod1 ;
   private String[] H004U5_A37TipoConCod ;
   private String[] H004U5_A370TipoConDescrip ;
   private int[] H004U6_A3CliCod ;
   private String[] H004U6_A26ConCodigo ;
   private boolean[] H004U6_A734ConRetGanPropor ;
   private byte[] H004U6_A1077ConAdelDescu ;
   private boolean[] H004U6_n1077ConAdelDescu ;
   private String[] H004U6_A1066ConPreReq ;
   private boolean[] H004U6_n1066ConPreReq ;
   private String[] H004U6_A1018ConRangoCant ;
   private boolean[] H004U6_A762ConRecalcular ;
   private String[] H004U6_A153ConObservacion ;
   private byte[] H004U6_A162ConVigencia ;
   private boolean[] H004U6_A152ConImporte ;
   private boolean[] H004U6_A158ConValUni ;
   private boolean[] H004U6_A143ConCanti ;
   private boolean[] H004U6_A150ConHabilitado ;
   private String[] H004U6_A41ConDescrip ;
   private String[] H004U6_A39SubTipoConCod2 ;
   private boolean[] H004U6_n39SubTipoConCod2 ;
   private String[] H004U6_A38SubTipoConCod1 ;
   private boolean[] H004U6_n38SubTipoConCod1 ;
   private byte[] H004U6_A735ConAplicGan ;
   private boolean[] H004U6_n735ConAplicGan ;
   private boolean[] H004U6_A159ConVariable ;
   private String[] H004U6_A37TipoConCod ;
   private String[] H004U6_A148ConFormula ;
   private boolean[] H004U6_n148ConFormula ;
   private String[] H004U7_A37TipoConCod ;
   private String[] H004U7_A370TipoConDescrip ;
   private com.genexus.webpanels.WebSession AV9Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV7TrnContext ;
}

final  class conceptogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004U2", "SELECT TipoConCod, TipoConDescrip FROM TipoDeConcepto ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004U3", "SELECT SubTipoConCod1, SubTipoConDes1, TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ( ?) ORDER BY SubTipoConDes1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004U4", "SELECT SubTipoConCod2, SubTipoConDes2, TipoConCod, SubTipoConCod1 FROM tipo_concepto_subtipo2 WHERE (TipoConCod = ( ?)) AND (SubTipoConCod1 = ( ?)) ORDER BY SubTipoConDes2 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004U5", "SELECT TipoConCod, TipoConDescrip FROM TipoDeConcepto ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004U6", "SELECT CliCod, ConCodigo, ConRetGanPropor, ConAdelDescu, ConPreReq, ConRangoCant, ConRecalcular, ConObservacion, ConVigencia, ConImporte, ConValUni, ConCanti, ConHabilitado, ConDescrip, SubTipoConCod2, SubTipoConCod1, ConAplicGan, ConVariable, TipoConCod, ConFormula FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U7", "SELECT TipoConCod, TipoConDescrip FROM TipoDeConcepto ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((byte[]) buf[10])[0] = rslt.getByte(9);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(13);
               ((String[]) buf[15])[0] = rslt.getVarchar(14);
               ((String[]) buf[16])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((byte[]) buf[20])[0] = rslt.getByte(17);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((boolean[]) buf[22])[0] = rslt.getBoolean(18);
               ((String[]) buf[23])[0] = rslt.getString(19, 20);
               ((String[]) buf[24])[0] = rslt.getLongVarchar(20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

