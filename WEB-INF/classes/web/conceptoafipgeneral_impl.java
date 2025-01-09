package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptoafipgeneral_impl extends GXWebComponent
{
   public conceptoafipgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptoafipgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoafipgeneral_impl.class ));
   }

   public conceptoafipgeneral_impl( int remoteHandle ,
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
      cmbConAFIPMarcaRep = new HTMLChoice();
      cmbConAFIPSIPAApo = new HTMLChoice();
      cmbConAFIPSIPACont = new HTMLChoice();
      cmbConAFIPINSSJyPApo = new HTMLChoice();
      cmbConAFIPINSSJyPCont = new HTMLChoice();
      cmbConAFIPObraSocApo = new HTMLChoice();
      cmbConAFIPObraSocCont = new HTMLChoice();
      cmbConAFIPFonSolRedApo = new HTMLChoice();
      cmbConAFIPFonSolRedCont = new HTMLChoice();
      cmbConAFIPRenateaApo = new HTMLChoice();
      cmbConAFIPRenateaCont = new HTMLChoice();
      cmbConAFIPAsigFamCont = new HTMLChoice();
      cmbConAFIPFonNacEmpCont = new HTMLChoice();
      cmbConAFIPLeyRieTrabCont = new HTMLChoice();
      cmbConAFIPRegDifApo = new HTMLChoice();
      cmbConAFIPRegEspApo = new HTMLChoice();
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
               A73ConCodPropio = httpContext.GetPar( "ConCodPropio") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A73ConCodPropio", A73ConCodPropio);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),A73ConCodPropio});
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
         pa6Q2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Concepto AFIPGeneral", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptoafipgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A73ConCodPropio))}, new String[] {"CliCod","ConCodPropio"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA73ConCodPropio", GXutil.rtrim( wcpOA73ConCodPropio));
   }

   public void renderHtmlCloseForm6Q2( )
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
      return "ConceptoAFIPGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Concepto AFIPGeneral", "") ;
   }

   public void wb6Q0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.conceptoafipgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPMarcaRep.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPMarcaRep.getInternalname(), httpContext.getMessage( "Repeticion", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPMarcaRep, cmbConAFIPMarcaRep.getInternalname(), GXutil.rtrim( A134ConAFIPMarcaRep), 1, cmbConAFIPMarcaRep.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPMarcaRep.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPMarcaRep.setValue( GXutil.rtrim( A134ConAFIPMarcaRep) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPMarcaRep.getInternalname(), "Values", cmbConAFIPMarcaRep.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPSIPAApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPSIPAApo.getInternalname(), httpContext.getMessage( "Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPSIPAApo, cmbConAFIPSIPAApo.getInternalname(), GXutil.rtrim( A141ConAFIPSIPAApo), 1, cmbConAFIPSIPAApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPSIPAApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPSIPAApo.setValue( GXutil.rtrim( A141ConAFIPSIPAApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPSIPAApo.getInternalname(), "Values", cmbConAFIPSIPAApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPSIPACont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPSIPACont.getInternalname(), httpContext.getMessage( "Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPSIPACont, cmbConAFIPSIPACont.getInternalname(), GXutil.rtrim( A142ConAFIPSIPACont), 1, cmbConAFIPSIPACont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPSIPACont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPSIPACont.setValue( GXutil.rtrim( A142ConAFIPSIPACont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPSIPACont.getInternalname(), "Values", cmbConAFIPSIPACont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPINSSJyPApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPINSSJyPApo.getInternalname(), httpContext.getMessage( "Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPINSSJyPApo, cmbConAFIPINSSJyPApo.getInternalname(), GXutil.rtrim( A131ConAFIPINSSJyPApo), 1, cmbConAFIPINSSJyPApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPINSSJyPApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPINSSJyPApo.setValue( GXutil.rtrim( A131ConAFIPINSSJyPApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPINSSJyPApo.getInternalname(), "Values", cmbConAFIPINSSJyPApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPINSSJyPCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPINSSJyPCont.getInternalname(), httpContext.getMessage( "Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPINSSJyPCont, cmbConAFIPINSSJyPCont.getInternalname(), GXutil.rtrim( A132ConAFIPINSSJyPCont), 1, cmbConAFIPINSSJyPCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPINSSJyPCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPINSSJyPCont.setValue( GXutil.rtrim( A132ConAFIPINSSJyPCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPINSSJyPCont.getInternalname(), "Values", cmbConAFIPINSSJyPCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPObraSocApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPObraSocApo.getInternalname(), httpContext.getMessage( "Social Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPObraSocApo, cmbConAFIPObraSocApo.getInternalname(), GXutil.rtrim( A135ConAFIPObraSocApo), 1, cmbConAFIPObraSocApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPObraSocApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPObraSocApo.setValue( GXutil.rtrim( A135ConAFIPObraSocApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPObraSocApo.getInternalname(), "Values", cmbConAFIPObraSocApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPObraSocCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPObraSocCont.getInternalname(), httpContext.getMessage( "Social Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPObraSocCont, cmbConAFIPObraSocCont.getInternalname(), GXutil.rtrim( A136ConAFIPObraSocCont), 1, cmbConAFIPObraSocCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPObraSocCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPObraSocCont.setValue( GXutil.rtrim( A136ConAFIPObraSocCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPObraSocCont.getInternalname(), "Values", cmbConAFIPObraSocCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPFonSolRedApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPFonSolRedApo.getInternalname(), httpContext.getMessage( "Redist. Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPFonSolRedApo, cmbConAFIPFonSolRedApo.getInternalname(), GXutil.rtrim( A129ConAFIPFonSolRedApo), 1, cmbConAFIPFonSolRedApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPFonSolRedApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPFonSolRedApo.setValue( GXutil.rtrim( A129ConAFIPFonSolRedApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPFonSolRedApo.getInternalname(), "Values", cmbConAFIPFonSolRedApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPFonSolRedCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPFonSolRedCont.getInternalname(), httpContext.getMessage( "Redist. Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPFonSolRedCont, cmbConAFIPFonSolRedCont.getInternalname(), GXutil.rtrim( A130ConAFIPFonSolRedCont), 1, cmbConAFIPFonSolRedCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPFonSolRedCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPFonSolRedCont.setValue( GXutil.rtrim( A130ConAFIPFonSolRedCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPFonSolRedCont.getInternalname(), "Values", cmbConAFIPFonSolRedCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPRenateaApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPRenateaApo.getInternalname(), httpContext.getMessage( "Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPRenateaApo, cmbConAFIPRenateaApo.getInternalname(), GXutil.rtrim( A139ConAFIPRenateaApo), 1, cmbConAFIPRenateaApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPRenateaApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPRenateaApo.setValue( GXutil.rtrim( A139ConAFIPRenateaApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPRenateaApo.getInternalname(), "Values", cmbConAFIPRenateaApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPRenateaCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPRenateaCont.getInternalname(), httpContext.getMessage( "Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPRenateaCont, cmbConAFIPRenateaCont.getInternalname(), GXutil.rtrim( A140ConAFIPRenateaCont), 1, cmbConAFIPRenateaCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPRenateaCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPRenateaCont.setValue( GXutil.rtrim( A140ConAFIPRenateaCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPRenateaCont.getInternalname(), "Values", cmbConAFIPRenateaCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPAsigFamCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPAsigFamCont.getInternalname(), httpContext.getMessage( "Familiares Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPAsigFamCont, cmbConAFIPAsigFamCont.getInternalname(), GXutil.rtrim( A127ConAFIPAsigFamCont), 1, cmbConAFIPAsigFamCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPAsigFamCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPAsigFamCont.setValue( GXutil.rtrim( A127ConAFIPAsigFamCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPAsigFamCont.getInternalname(), "Values", cmbConAFIPAsigFamCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPFonNacEmpCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPFonNacEmpCont.getInternalname(), httpContext.getMessage( "Empleo Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPFonNacEmpCont, cmbConAFIPFonNacEmpCont.getInternalname(), GXutil.rtrim( A128ConAFIPFonNacEmpCont), 1, cmbConAFIPFonNacEmpCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPFonNacEmpCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPFonNacEmpCont.setValue( GXutil.rtrim( A128ConAFIPFonNacEmpCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPFonNacEmpCont.getInternalname(), "Values", cmbConAFIPFonNacEmpCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPLeyRieTrabCont.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPLeyRieTrabCont.getInternalname(), httpContext.getMessage( "Trabajo Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPLeyRieTrabCont, cmbConAFIPLeyRieTrabCont.getInternalname(), GXutil.rtrim( A133ConAFIPLeyRieTrabCont), 1, cmbConAFIPLeyRieTrabCont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPLeyRieTrabCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPLeyRieTrabCont.setValue( GXutil.rtrim( A133ConAFIPLeyRieTrabCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Values", cmbConAFIPLeyRieTrabCont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPRegDifApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPRegDifApo.getInternalname(), httpContext.getMessage( "Diferenciales Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPRegDifApo, cmbConAFIPRegDifApo.getInternalname(), GXutil.rtrim( A137ConAFIPRegDifApo), 1, cmbConAFIPRegDifApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPRegDifApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPRegDifApo.setValue( GXutil.rtrim( A137ConAFIPRegDifApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPRegDifApo.getInternalname(), "Values", cmbConAFIPRegDifApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPRegEspApo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConAFIPRegEspApo.getInternalname(), httpContext.getMessage( "Especiales Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPRegEspApo, cmbConAFIPRegEspApo.getInternalname(), GXutil.rtrim( A138ConAFIPRegEspApo), 1, cmbConAFIPRegEspApo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPRegEspApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ConceptoAFIPGeneral.htm");
         cmbConAFIPRegEspApo.setValue( GXutil.rtrim( A138ConAFIPRegEspApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPRegEspApo.getInternalname(), "Values", cmbConAFIPRegEspApo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCodPropio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConCodPropio_Internalname, httpContext.getMessage( "Cod Propio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConCodPropio_Internalname, GXutil.rtrim( A73ConCodPropio), GXutil.rtrim( localUtil.format( A73ConCodPropio, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodPropio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodPropio_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoAFIPGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConAfipEstado_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConAfipEstado_Internalname, httpContext.getMessage( "Afip Estado", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConAfipEstado_Internalname, GXutil.rtrim( A379ConAfipEstado), GXutil.rtrim( localUtil.format( A379ConAfipEstado, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConAfipEstado_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConAfipEstado_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoAFIPGeneral.htm");
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
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e116q1_client"+"'", TempTags, "", 2, "HLP_ConceptoAFIPGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 106,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e126q1_client"+"'", TempTags, "", 2, "HLP_ConceptoAFIPGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoAFIPGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start6Q2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Concepto AFIPGeneral", ""), (short)(0)) ;
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
            strup6Q0( ) ;
         }
      }
   }

   public void ws6Q2( )
   {
      start6Q2( ) ;
      evt6Q2( ) ;
   }

   public void evt6Q2( )
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
                              strup6Q0( ) ;
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
                              strup6Q0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e136Q2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Q0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e146Q2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Q0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e156Q2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Q0( ) ;
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
                              strup6Q0( ) ;
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

   public void we6Q2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm6Q2( ) ;
         }
      }
   }

   public void pa6Q2( )
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
      if ( cmbConAFIPMarcaRep.getItemCount() > 0 )
      {
         A134ConAFIPMarcaRep = cmbConAFIPMarcaRep.getValidValue(A134ConAFIPMarcaRep) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A134ConAFIPMarcaRep", A134ConAFIPMarcaRep);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPMarcaRep.setValue( GXutil.rtrim( A134ConAFIPMarcaRep) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPMarcaRep.getInternalname(), "Values", cmbConAFIPMarcaRep.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPSIPAApo.getItemCount() > 0 )
      {
         A141ConAFIPSIPAApo = cmbConAFIPSIPAApo.getValidValue(A141ConAFIPSIPAApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A141ConAFIPSIPAApo", A141ConAFIPSIPAApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPSIPAApo.setValue( GXutil.rtrim( A141ConAFIPSIPAApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPSIPAApo.getInternalname(), "Values", cmbConAFIPSIPAApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPSIPACont.getItemCount() > 0 )
      {
         A142ConAFIPSIPACont = cmbConAFIPSIPACont.getValidValue(A142ConAFIPSIPACont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A142ConAFIPSIPACont", A142ConAFIPSIPACont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPSIPACont.setValue( GXutil.rtrim( A142ConAFIPSIPACont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPSIPACont.getInternalname(), "Values", cmbConAFIPSIPACont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPINSSJyPApo.getItemCount() > 0 )
      {
         A131ConAFIPINSSJyPApo = cmbConAFIPINSSJyPApo.getValidValue(A131ConAFIPINSSJyPApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A131ConAFIPINSSJyPApo", A131ConAFIPINSSJyPApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPINSSJyPApo.setValue( GXutil.rtrim( A131ConAFIPINSSJyPApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPINSSJyPApo.getInternalname(), "Values", cmbConAFIPINSSJyPApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPINSSJyPCont.getItemCount() > 0 )
      {
         A132ConAFIPINSSJyPCont = cmbConAFIPINSSJyPCont.getValidValue(A132ConAFIPINSSJyPCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A132ConAFIPINSSJyPCont", A132ConAFIPINSSJyPCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPINSSJyPCont.setValue( GXutil.rtrim( A132ConAFIPINSSJyPCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPINSSJyPCont.getInternalname(), "Values", cmbConAFIPINSSJyPCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPObraSocApo.getItemCount() > 0 )
      {
         A135ConAFIPObraSocApo = cmbConAFIPObraSocApo.getValidValue(A135ConAFIPObraSocApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A135ConAFIPObraSocApo", A135ConAFIPObraSocApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPObraSocApo.setValue( GXutil.rtrim( A135ConAFIPObraSocApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPObraSocApo.getInternalname(), "Values", cmbConAFIPObraSocApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPObraSocCont.getItemCount() > 0 )
      {
         A136ConAFIPObraSocCont = cmbConAFIPObraSocCont.getValidValue(A136ConAFIPObraSocCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A136ConAFIPObraSocCont", A136ConAFIPObraSocCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPObraSocCont.setValue( GXutil.rtrim( A136ConAFIPObraSocCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPObraSocCont.getInternalname(), "Values", cmbConAFIPObraSocCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPFonSolRedApo.getItemCount() > 0 )
      {
         A129ConAFIPFonSolRedApo = cmbConAFIPFonSolRedApo.getValidValue(A129ConAFIPFonSolRedApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A129ConAFIPFonSolRedApo", A129ConAFIPFonSolRedApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPFonSolRedApo.setValue( GXutil.rtrim( A129ConAFIPFonSolRedApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPFonSolRedApo.getInternalname(), "Values", cmbConAFIPFonSolRedApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPFonSolRedCont.getItemCount() > 0 )
      {
         A130ConAFIPFonSolRedCont = cmbConAFIPFonSolRedCont.getValidValue(A130ConAFIPFonSolRedCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A130ConAFIPFonSolRedCont", A130ConAFIPFonSolRedCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPFonSolRedCont.setValue( GXutil.rtrim( A130ConAFIPFonSolRedCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPFonSolRedCont.getInternalname(), "Values", cmbConAFIPFonSolRedCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPRenateaApo.getItemCount() > 0 )
      {
         A139ConAFIPRenateaApo = cmbConAFIPRenateaApo.getValidValue(A139ConAFIPRenateaApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A139ConAFIPRenateaApo", A139ConAFIPRenateaApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPRenateaApo.setValue( GXutil.rtrim( A139ConAFIPRenateaApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPRenateaApo.getInternalname(), "Values", cmbConAFIPRenateaApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPRenateaCont.getItemCount() > 0 )
      {
         A140ConAFIPRenateaCont = cmbConAFIPRenateaCont.getValidValue(A140ConAFIPRenateaCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A140ConAFIPRenateaCont", A140ConAFIPRenateaCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPRenateaCont.setValue( GXutil.rtrim( A140ConAFIPRenateaCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPRenateaCont.getInternalname(), "Values", cmbConAFIPRenateaCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPAsigFamCont.getItemCount() > 0 )
      {
         A127ConAFIPAsigFamCont = cmbConAFIPAsigFamCont.getValidValue(A127ConAFIPAsigFamCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A127ConAFIPAsigFamCont", A127ConAFIPAsigFamCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPAsigFamCont.setValue( GXutil.rtrim( A127ConAFIPAsigFamCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPAsigFamCont.getInternalname(), "Values", cmbConAFIPAsigFamCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPFonNacEmpCont.getItemCount() > 0 )
      {
         A128ConAFIPFonNacEmpCont = cmbConAFIPFonNacEmpCont.getValidValue(A128ConAFIPFonNacEmpCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A128ConAFIPFonNacEmpCont", A128ConAFIPFonNacEmpCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPFonNacEmpCont.setValue( GXutil.rtrim( A128ConAFIPFonNacEmpCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPFonNacEmpCont.getInternalname(), "Values", cmbConAFIPFonNacEmpCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPLeyRieTrabCont.getItemCount() > 0 )
      {
         A133ConAFIPLeyRieTrabCont = cmbConAFIPLeyRieTrabCont.getValidValue(A133ConAFIPLeyRieTrabCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A133ConAFIPLeyRieTrabCont", A133ConAFIPLeyRieTrabCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPLeyRieTrabCont.setValue( GXutil.rtrim( A133ConAFIPLeyRieTrabCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Values", cmbConAFIPLeyRieTrabCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPRegDifApo.getItemCount() > 0 )
      {
         A137ConAFIPRegDifApo = cmbConAFIPRegDifApo.getValidValue(A137ConAFIPRegDifApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A137ConAFIPRegDifApo", A137ConAFIPRegDifApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPRegDifApo.setValue( GXutil.rtrim( A137ConAFIPRegDifApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPRegDifApo.getInternalname(), "Values", cmbConAFIPRegDifApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPRegEspApo.getItemCount() > 0 )
      {
         A138ConAFIPRegEspApo = cmbConAFIPRegEspApo.getValidValue(A138ConAFIPRegEspApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A138ConAFIPRegEspApo", A138ConAFIPRegEspApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPRegEspApo.setValue( GXutil.rtrim( A138ConAFIPRegEspApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAFIPRegEspApo.getInternalname(), "Values", cmbConAFIPRegEspApo.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf6Q2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "ConceptoAFIPGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf6Q2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e156Q2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H006Q2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A379ConAfipEstado = H006Q2_A379ConAfipEstado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A379ConAfipEstado", A379ConAfipEstado);
            A138ConAFIPRegEspApo = H006Q2_A138ConAFIPRegEspApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A138ConAFIPRegEspApo", A138ConAFIPRegEspApo);
            A137ConAFIPRegDifApo = H006Q2_A137ConAFIPRegDifApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A137ConAFIPRegDifApo", A137ConAFIPRegDifApo);
            A133ConAFIPLeyRieTrabCont = H006Q2_A133ConAFIPLeyRieTrabCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A133ConAFIPLeyRieTrabCont", A133ConAFIPLeyRieTrabCont);
            A128ConAFIPFonNacEmpCont = H006Q2_A128ConAFIPFonNacEmpCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A128ConAFIPFonNacEmpCont", A128ConAFIPFonNacEmpCont);
            A127ConAFIPAsigFamCont = H006Q2_A127ConAFIPAsigFamCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A127ConAFIPAsigFamCont", A127ConAFIPAsigFamCont);
            A140ConAFIPRenateaCont = H006Q2_A140ConAFIPRenateaCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A140ConAFIPRenateaCont", A140ConAFIPRenateaCont);
            A139ConAFIPRenateaApo = H006Q2_A139ConAFIPRenateaApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A139ConAFIPRenateaApo", A139ConAFIPRenateaApo);
            A130ConAFIPFonSolRedCont = H006Q2_A130ConAFIPFonSolRedCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A130ConAFIPFonSolRedCont", A130ConAFIPFonSolRedCont);
            A129ConAFIPFonSolRedApo = H006Q2_A129ConAFIPFonSolRedApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A129ConAFIPFonSolRedApo", A129ConAFIPFonSolRedApo);
            A136ConAFIPObraSocCont = H006Q2_A136ConAFIPObraSocCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A136ConAFIPObraSocCont", A136ConAFIPObraSocCont);
            A135ConAFIPObraSocApo = H006Q2_A135ConAFIPObraSocApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A135ConAFIPObraSocApo", A135ConAFIPObraSocApo);
            A132ConAFIPINSSJyPCont = H006Q2_A132ConAFIPINSSJyPCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A132ConAFIPINSSJyPCont", A132ConAFIPINSSJyPCont);
            A131ConAFIPINSSJyPApo = H006Q2_A131ConAFIPINSSJyPApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A131ConAFIPINSSJyPApo", A131ConAFIPINSSJyPApo);
            A142ConAFIPSIPACont = H006Q2_A142ConAFIPSIPACont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A142ConAFIPSIPACont", A142ConAFIPSIPACont);
            A141ConAFIPSIPAApo = H006Q2_A141ConAFIPSIPAApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A141ConAFIPSIPAApo", A141ConAFIPSIPAApo);
            A134ConAFIPMarcaRep = H006Q2_A134ConAFIPMarcaRep[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A134ConAFIPMarcaRep", A134ConAFIPMarcaRep);
            /* Execute user event: Load */
            e146Q2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb6Q0( ) ;
      }
   }

   public void send_integrity_lvl_hashes6Q2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "ConceptoAFIPGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup6Q0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e136Q2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA73ConCodPropio = httpContext.cgiGet( sPrefix+"wcpOA73ConCodPropio") ;
         /* Read variables values. */
         cmbConAFIPMarcaRep.setValue( httpContext.cgiGet( cmbConAFIPMarcaRep.getInternalname()) );
         A134ConAFIPMarcaRep = httpContext.cgiGet( cmbConAFIPMarcaRep.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A134ConAFIPMarcaRep", A134ConAFIPMarcaRep);
         cmbConAFIPSIPAApo.setValue( httpContext.cgiGet( cmbConAFIPSIPAApo.getInternalname()) );
         A141ConAFIPSIPAApo = httpContext.cgiGet( cmbConAFIPSIPAApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A141ConAFIPSIPAApo", A141ConAFIPSIPAApo);
         cmbConAFIPSIPACont.setValue( httpContext.cgiGet( cmbConAFIPSIPACont.getInternalname()) );
         A142ConAFIPSIPACont = httpContext.cgiGet( cmbConAFIPSIPACont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A142ConAFIPSIPACont", A142ConAFIPSIPACont);
         cmbConAFIPINSSJyPApo.setValue( httpContext.cgiGet( cmbConAFIPINSSJyPApo.getInternalname()) );
         A131ConAFIPINSSJyPApo = httpContext.cgiGet( cmbConAFIPINSSJyPApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A131ConAFIPINSSJyPApo", A131ConAFIPINSSJyPApo);
         cmbConAFIPINSSJyPCont.setValue( httpContext.cgiGet( cmbConAFIPINSSJyPCont.getInternalname()) );
         A132ConAFIPINSSJyPCont = httpContext.cgiGet( cmbConAFIPINSSJyPCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A132ConAFIPINSSJyPCont", A132ConAFIPINSSJyPCont);
         cmbConAFIPObraSocApo.setValue( httpContext.cgiGet( cmbConAFIPObraSocApo.getInternalname()) );
         A135ConAFIPObraSocApo = httpContext.cgiGet( cmbConAFIPObraSocApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A135ConAFIPObraSocApo", A135ConAFIPObraSocApo);
         cmbConAFIPObraSocCont.setValue( httpContext.cgiGet( cmbConAFIPObraSocCont.getInternalname()) );
         A136ConAFIPObraSocCont = httpContext.cgiGet( cmbConAFIPObraSocCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A136ConAFIPObraSocCont", A136ConAFIPObraSocCont);
         cmbConAFIPFonSolRedApo.setValue( httpContext.cgiGet( cmbConAFIPFonSolRedApo.getInternalname()) );
         A129ConAFIPFonSolRedApo = httpContext.cgiGet( cmbConAFIPFonSolRedApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A129ConAFIPFonSolRedApo", A129ConAFIPFonSolRedApo);
         cmbConAFIPFonSolRedCont.setValue( httpContext.cgiGet( cmbConAFIPFonSolRedCont.getInternalname()) );
         A130ConAFIPFonSolRedCont = httpContext.cgiGet( cmbConAFIPFonSolRedCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A130ConAFIPFonSolRedCont", A130ConAFIPFonSolRedCont);
         cmbConAFIPRenateaApo.setValue( httpContext.cgiGet( cmbConAFIPRenateaApo.getInternalname()) );
         A139ConAFIPRenateaApo = httpContext.cgiGet( cmbConAFIPRenateaApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A139ConAFIPRenateaApo", A139ConAFIPRenateaApo);
         cmbConAFIPRenateaCont.setValue( httpContext.cgiGet( cmbConAFIPRenateaCont.getInternalname()) );
         A140ConAFIPRenateaCont = httpContext.cgiGet( cmbConAFIPRenateaCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A140ConAFIPRenateaCont", A140ConAFIPRenateaCont);
         cmbConAFIPAsigFamCont.setValue( httpContext.cgiGet( cmbConAFIPAsigFamCont.getInternalname()) );
         A127ConAFIPAsigFamCont = httpContext.cgiGet( cmbConAFIPAsigFamCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A127ConAFIPAsigFamCont", A127ConAFIPAsigFamCont);
         cmbConAFIPFonNacEmpCont.setValue( httpContext.cgiGet( cmbConAFIPFonNacEmpCont.getInternalname()) );
         A128ConAFIPFonNacEmpCont = httpContext.cgiGet( cmbConAFIPFonNacEmpCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A128ConAFIPFonNacEmpCont", A128ConAFIPFonNacEmpCont);
         cmbConAFIPLeyRieTrabCont.setValue( httpContext.cgiGet( cmbConAFIPLeyRieTrabCont.getInternalname()) );
         A133ConAFIPLeyRieTrabCont = httpContext.cgiGet( cmbConAFIPLeyRieTrabCont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A133ConAFIPLeyRieTrabCont", A133ConAFIPLeyRieTrabCont);
         cmbConAFIPRegDifApo.setValue( httpContext.cgiGet( cmbConAFIPRegDifApo.getInternalname()) );
         A137ConAFIPRegDifApo = httpContext.cgiGet( cmbConAFIPRegDifApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A137ConAFIPRegDifApo", A137ConAFIPRegDifApo);
         cmbConAFIPRegEspApo.setValue( httpContext.cgiGet( cmbConAFIPRegEspApo.getInternalname()) );
         A138ConAFIPRegEspApo = httpContext.cgiGet( cmbConAFIPRegEspApo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A138ConAFIPRegEspApo", A138ConAFIPRegEspApo);
         A379ConAfipEstado = httpContext.cgiGet( edtConAfipEstado_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A379ConAfipEstado", A379ConAfipEstado);
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
      e136Q2 ();
      if (returnInSub) return;
   }

   public void e136Q2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptoafipgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e146Q2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoAFIP_Update", GXv_boolean5) ;
      conceptoafipgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoAFIP_Delete", GXv_boolean5) ;
      conceptoafipgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "ConceptoAFIP" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e156Q2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptoafipgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A73ConCodPropio = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A73ConCodPropio", A73ConCodPropio);
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
      pa6Q2( ) ;
      ws6Q2( ) ;
      we6Q2( ) ;
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
      sCtrlA73ConCodPropio = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa6Q2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "conceptoafipgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa6Q2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A73ConCodPropio = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A73ConCodPropio", A73ConCodPropio);
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA73ConCodPropio = httpContext.cgiGet( sPrefix+"wcpOA73ConCodPropio") ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( GXutil.strcmp(A73ConCodPropio, wcpOA73ConCodPropio) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA73ConCodPropio = A73ConCodPropio ;
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
      sCtrlA73ConCodPropio = httpContext.cgiGet( sPrefix+"A73ConCodPropio_CTRL") ;
      if ( GXutil.len( sCtrlA73ConCodPropio) > 0 )
      {
         A73ConCodPropio = httpContext.cgiGet( sCtrlA73ConCodPropio) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A73ConCodPropio", A73ConCodPropio);
      }
      else
      {
         A73ConCodPropio = httpContext.cgiGet( sPrefix+"A73ConCodPropio_PARM") ;
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
      pa6Q2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws6Q2( ) ;
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
      ws6Q2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A73ConCodPropio_PARM", GXutil.rtrim( A73ConCodPropio));
      if ( GXutil.len( GXutil.rtrim( sCtrlA73ConCodPropio)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A73ConCodPropio_CTRL", GXutil.rtrim( sCtrlA73ConCodPropio));
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
      we6Q2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019463832", true, true);
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
      httpContext.AddJavascriptSource("conceptoafipgeneral.js", "?2024122019463832", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbConAFIPMarcaRep.setInternalname( sPrefix+"CONAFIPMARCAREP" );
      cmbConAFIPSIPAApo.setInternalname( sPrefix+"CONAFIPSIPAAPO" );
      cmbConAFIPSIPACont.setInternalname( sPrefix+"CONAFIPSIPACONT" );
      cmbConAFIPINSSJyPApo.setInternalname( sPrefix+"CONAFIPINSSJYPAPO" );
      cmbConAFIPINSSJyPCont.setInternalname( sPrefix+"CONAFIPINSSJYPCONT" );
      cmbConAFIPObraSocApo.setInternalname( sPrefix+"CONAFIPOBRASOCAPO" );
      cmbConAFIPObraSocCont.setInternalname( sPrefix+"CONAFIPOBRASOCCONT" );
      cmbConAFIPFonSolRedApo.setInternalname( sPrefix+"CONAFIPFONSOLREDAPO" );
      cmbConAFIPFonSolRedCont.setInternalname( sPrefix+"CONAFIPFONSOLREDCONT" );
      cmbConAFIPRenateaApo.setInternalname( sPrefix+"CONAFIPRENATEAAPO" );
      cmbConAFIPRenateaCont.setInternalname( sPrefix+"CONAFIPRENATEACONT" );
      cmbConAFIPAsigFamCont.setInternalname( sPrefix+"CONAFIPASIGFAMCONT" );
      cmbConAFIPFonNacEmpCont.setInternalname( sPrefix+"CONAFIPFONNACEMPCONT" );
      cmbConAFIPLeyRieTrabCont.setInternalname( sPrefix+"CONAFIPLEYRIETRABCONT" );
      cmbConAFIPRegDifApo.setInternalname( sPrefix+"CONAFIPREGDIFAPO" );
      cmbConAFIPRegEspApo.setInternalname( sPrefix+"CONAFIPREGESPAPO" );
      edtConCodPropio_Internalname = sPrefix+"CONCODPROPIO" ;
      edtConAfipEstado_Internalname = sPrefix+"CONAFIPESTADO" ;
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
      edtConAfipEstado_Jsonclick = "" ;
      edtConAfipEstado_Enabled = 0 ;
      edtConCodPropio_Jsonclick = "" ;
      edtConCodPropio_Enabled = 0 ;
      cmbConAFIPRegEspApo.setJsonclick( "" );
      cmbConAFIPRegEspApo.setEnabled( 0 );
      cmbConAFIPRegDifApo.setJsonclick( "" );
      cmbConAFIPRegDifApo.setEnabled( 0 );
      cmbConAFIPLeyRieTrabCont.setJsonclick( "" );
      cmbConAFIPLeyRieTrabCont.setEnabled( 0 );
      cmbConAFIPFonNacEmpCont.setJsonclick( "" );
      cmbConAFIPFonNacEmpCont.setEnabled( 0 );
      cmbConAFIPAsigFamCont.setJsonclick( "" );
      cmbConAFIPAsigFamCont.setEnabled( 0 );
      cmbConAFIPRenateaCont.setJsonclick( "" );
      cmbConAFIPRenateaCont.setEnabled( 0 );
      cmbConAFIPRenateaApo.setJsonclick( "" );
      cmbConAFIPRenateaApo.setEnabled( 0 );
      cmbConAFIPFonSolRedCont.setJsonclick( "" );
      cmbConAFIPFonSolRedCont.setEnabled( 0 );
      cmbConAFIPFonSolRedApo.setJsonclick( "" );
      cmbConAFIPFonSolRedApo.setEnabled( 0 );
      cmbConAFIPObraSocCont.setJsonclick( "" );
      cmbConAFIPObraSocCont.setEnabled( 0 );
      cmbConAFIPObraSocApo.setJsonclick( "" );
      cmbConAFIPObraSocApo.setEnabled( 0 );
      cmbConAFIPINSSJyPCont.setJsonclick( "" );
      cmbConAFIPINSSJyPCont.setEnabled( 0 );
      cmbConAFIPINSSJyPApo.setJsonclick( "" );
      cmbConAFIPINSSJyPApo.setEnabled( 0 );
      cmbConAFIPSIPACont.setJsonclick( "" );
      cmbConAFIPSIPACont.setEnabled( 0 );
      cmbConAFIPSIPAApo.setJsonclick( "" );
      cmbConAFIPSIPAApo.setEnabled( 0 );
      cmbConAFIPMarcaRep.setJsonclick( "" );
      cmbConAFIPMarcaRep.setEnabled( 0 );
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
      cmbConAFIPMarcaRep.setName( "CONAFIPMARCAREP" );
      cmbConAFIPMarcaRep.setWebtags( "" );
      cmbConAFIPMarcaRep.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPMarcaRep.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPMarcaRep.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPMarcaRep.addItem("", "-", (short)(0));
      if ( cmbConAFIPMarcaRep.getItemCount() > 0 )
      {
      }
      cmbConAFIPSIPAApo.setName( "CONAFIPSIPAAPO" );
      cmbConAFIPSIPAApo.setWebtags( "" );
      cmbConAFIPSIPAApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPSIPAApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPSIPAApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPSIPAApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPSIPAApo.getItemCount() > 0 )
      {
      }
      cmbConAFIPSIPACont.setName( "CONAFIPSIPACONT" );
      cmbConAFIPSIPACont.setWebtags( "" );
      cmbConAFIPSIPACont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPSIPACont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPSIPACont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPSIPACont.addItem("", "-", (short)(0));
      if ( cmbConAFIPSIPACont.getItemCount() > 0 )
      {
      }
      cmbConAFIPINSSJyPApo.setName( "CONAFIPINSSJYPAPO" );
      cmbConAFIPINSSJyPApo.setWebtags( "" );
      cmbConAFIPINSSJyPApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPINSSJyPApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPINSSJyPApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPINSSJyPApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPINSSJyPApo.getItemCount() > 0 )
      {
      }
      cmbConAFIPINSSJyPCont.setName( "CONAFIPINSSJYPCONT" );
      cmbConAFIPINSSJyPCont.setWebtags( "" );
      cmbConAFIPINSSJyPCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPINSSJyPCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPINSSJyPCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPINSSJyPCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPINSSJyPCont.getItemCount() > 0 )
      {
      }
      cmbConAFIPObraSocApo.setName( "CONAFIPOBRASOCAPO" );
      cmbConAFIPObraSocApo.setWebtags( "" );
      cmbConAFIPObraSocApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPObraSocApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPObraSocApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPObraSocApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPObraSocApo.getItemCount() > 0 )
      {
      }
      cmbConAFIPObraSocCont.setName( "CONAFIPOBRASOCCONT" );
      cmbConAFIPObraSocCont.setWebtags( "" );
      cmbConAFIPObraSocCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPObraSocCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPObraSocCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPObraSocCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPObraSocCont.getItemCount() > 0 )
      {
      }
      cmbConAFIPFonSolRedApo.setName( "CONAFIPFONSOLREDAPO" );
      cmbConAFIPFonSolRedApo.setWebtags( "" );
      cmbConAFIPFonSolRedApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPFonSolRedApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPFonSolRedApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPFonSolRedApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPFonSolRedApo.getItemCount() > 0 )
      {
      }
      cmbConAFIPFonSolRedCont.setName( "CONAFIPFONSOLREDCONT" );
      cmbConAFIPFonSolRedCont.setWebtags( "" );
      cmbConAFIPFonSolRedCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPFonSolRedCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPFonSolRedCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPFonSolRedCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPFonSolRedCont.getItemCount() > 0 )
      {
      }
      cmbConAFIPRenateaApo.setName( "CONAFIPRENATEAAPO" );
      cmbConAFIPRenateaApo.setWebtags( "" );
      cmbConAFIPRenateaApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPRenateaApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPRenateaApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPRenateaApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPRenateaApo.getItemCount() > 0 )
      {
      }
      cmbConAFIPRenateaCont.setName( "CONAFIPRENATEACONT" );
      cmbConAFIPRenateaCont.setWebtags( "" );
      cmbConAFIPRenateaCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPRenateaCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPRenateaCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPRenateaCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPRenateaCont.getItemCount() > 0 )
      {
      }
      cmbConAFIPAsigFamCont.setName( "CONAFIPASIGFAMCONT" );
      cmbConAFIPAsigFamCont.setWebtags( "" );
      cmbConAFIPAsigFamCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPAsigFamCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPAsigFamCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPAsigFamCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPAsigFamCont.getItemCount() > 0 )
      {
      }
      cmbConAFIPFonNacEmpCont.setName( "CONAFIPFONNACEMPCONT" );
      cmbConAFIPFonNacEmpCont.setWebtags( "" );
      cmbConAFIPFonNacEmpCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPFonNacEmpCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPFonNacEmpCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPFonNacEmpCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPFonNacEmpCont.getItemCount() > 0 )
      {
      }
      cmbConAFIPLeyRieTrabCont.setName( "CONAFIPLEYRIETRABCONT" );
      cmbConAFIPLeyRieTrabCont.setWebtags( "" );
      cmbConAFIPLeyRieTrabCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPLeyRieTrabCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPLeyRieTrabCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPLeyRieTrabCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPLeyRieTrabCont.getItemCount() > 0 )
      {
      }
      cmbConAFIPRegDifApo.setName( "CONAFIPREGDIFAPO" );
      cmbConAFIPRegDifApo.setWebtags( "" );
      cmbConAFIPRegDifApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPRegDifApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPRegDifApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPRegDifApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPRegDifApo.getItemCount() > 0 )
      {
      }
      cmbConAFIPRegEspApo.setName( "CONAFIPREGESPAPO" );
      cmbConAFIPRegEspApo.setWebtags( "" );
      cmbConAFIPRegEspApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPRegEspApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPRegEspApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPRegEspApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPRegEspApo.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A73ConCodPropio',fld:'CONCODPROPIO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e116Q1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A73ConCodPropio',fld:'CONCODPROPIO',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e126Q1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A73ConCodPropio',fld:'CONCODPROPIO',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CONCODPROPIO","{handler:'valid_Concodpropio',iparms:[]");
      setEventMetadata("VALID_CONCODPROPIO",",oparms:[]}");
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
      wcpOA73ConCodPropio = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A73ConCodPropio = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A134ConAFIPMarcaRep = "" ;
      A141ConAFIPSIPAApo = "" ;
      A142ConAFIPSIPACont = "" ;
      A131ConAFIPINSSJyPApo = "" ;
      A132ConAFIPINSSJyPCont = "" ;
      A135ConAFIPObraSocApo = "" ;
      A136ConAFIPObraSocCont = "" ;
      A129ConAFIPFonSolRedApo = "" ;
      A130ConAFIPFonSolRedCont = "" ;
      A139ConAFIPRenateaApo = "" ;
      A140ConAFIPRenateaCont = "" ;
      A127ConAFIPAsigFamCont = "" ;
      A128ConAFIPFonNacEmpCont = "" ;
      A133ConAFIPLeyRieTrabCont = "" ;
      A137ConAFIPRegDifApo = "" ;
      A138ConAFIPRegEspApo = "" ;
      A379ConAfipEstado = "" ;
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
      H006Q2_A3CliCod = new int[1] ;
      H006Q2_A73ConCodPropio = new String[] {""} ;
      H006Q2_A379ConAfipEstado = new String[] {""} ;
      H006Q2_A138ConAFIPRegEspApo = new String[] {""} ;
      H006Q2_A137ConAFIPRegDifApo = new String[] {""} ;
      H006Q2_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      H006Q2_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      H006Q2_A127ConAFIPAsigFamCont = new String[] {""} ;
      H006Q2_A140ConAFIPRenateaCont = new String[] {""} ;
      H006Q2_A139ConAFIPRenateaApo = new String[] {""} ;
      H006Q2_A130ConAFIPFonSolRedCont = new String[] {""} ;
      H006Q2_A129ConAFIPFonSolRedApo = new String[] {""} ;
      H006Q2_A136ConAFIPObraSocCont = new String[] {""} ;
      H006Q2_A135ConAFIPObraSocApo = new String[] {""} ;
      H006Q2_A132ConAFIPINSSJyPCont = new String[] {""} ;
      H006Q2_A131ConAFIPINSSJyPApo = new String[] {""} ;
      H006Q2_A142ConAFIPSIPACont = new String[] {""} ;
      H006Q2_A141ConAFIPSIPAApo = new String[] {""} ;
      H006Q2_A134ConAFIPMarcaRep = new String[] {""} ;
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
      sCtrlA73ConCodPropio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoafipgeneral__default(),
         new Object[] {
             new Object[] {
            H006Q2_A3CliCod, H006Q2_A73ConCodPropio, H006Q2_A379ConAfipEstado, H006Q2_A138ConAFIPRegEspApo, H006Q2_A137ConAFIPRegDifApo, H006Q2_A133ConAFIPLeyRieTrabCont, H006Q2_A128ConAFIPFonNacEmpCont, H006Q2_A127ConAFIPAsigFamCont, H006Q2_A140ConAFIPRenateaCont, H006Q2_A139ConAFIPRenateaApo,
            H006Q2_A130ConAFIPFonSolRedCont, H006Q2_A129ConAFIPFonSolRedApo, H006Q2_A136ConAFIPObraSocCont, H006Q2_A135ConAFIPObraSocApo, H006Q2_A132ConAFIPINSSJyPCont, H006Q2_A131ConAFIPINSSJyPApo, H006Q2_A142ConAFIPSIPACont, H006Q2_A141ConAFIPSIPAApo, H006Q2_A134ConAFIPMarcaRep
            }
         }
      );
      AV17Pgmname = "ConceptoAFIPGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "ConceptoAFIPGeneral" ;
      Gx_err = (short)(0) ;
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
   private int edtConCodPropio_Enabled ;
   private int edtConAfipEstado_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String wcpOA73ConCodPropio ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A73ConCodPropio ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String A134ConAFIPMarcaRep ;
   private String A141ConAFIPSIPAApo ;
   private String A142ConAFIPSIPACont ;
   private String A131ConAFIPINSSJyPApo ;
   private String A132ConAFIPINSSJyPCont ;
   private String A135ConAFIPObraSocApo ;
   private String A136ConAFIPObraSocCont ;
   private String A129ConAFIPFonSolRedApo ;
   private String A130ConAFIPFonSolRedCont ;
   private String A139ConAFIPRenateaApo ;
   private String A140ConAFIPRenateaCont ;
   private String A127ConAFIPAsigFamCont ;
   private String A128ConAFIPFonNacEmpCont ;
   private String A133ConAFIPLeyRieTrabCont ;
   private String A137ConAFIPRegDifApo ;
   private String A138ConAFIPRegEspApo ;
   private String edtConCodPropio_Internalname ;
   private String edtConCodPropio_Jsonclick ;
   private String edtConAfipEstado_Internalname ;
   private String A379ConAfipEstado ;
   private String edtConAfipEstado_Jsonclick ;
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
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String sCtrlA3CliCod ;
   private String sCtrlA73ConCodPropio ;
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
   private HTMLChoice cmbConAFIPMarcaRep ;
   private HTMLChoice cmbConAFIPSIPAApo ;
   private HTMLChoice cmbConAFIPSIPACont ;
   private HTMLChoice cmbConAFIPINSSJyPApo ;
   private HTMLChoice cmbConAFIPINSSJyPCont ;
   private HTMLChoice cmbConAFIPObraSocApo ;
   private HTMLChoice cmbConAFIPObraSocCont ;
   private HTMLChoice cmbConAFIPFonSolRedApo ;
   private HTMLChoice cmbConAFIPFonSolRedCont ;
   private HTMLChoice cmbConAFIPRenateaApo ;
   private HTMLChoice cmbConAFIPRenateaCont ;
   private HTMLChoice cmbConAFIPAsigFamCont ;
   private HTMLChoice cmbConAFIPFonNacEmpCont ;
   private HTMLChoice cmbConAFIPLeyRieTrabCont ;
   private HTMLChoice cmbConAFIPRegDifApo ;
   private HTMLChoice cmbConAFIPRegEspApo ;
   private IDataStoreProvider pr_default ;
   private int[] H006Q2_A3CliCod ;
   private String[] H006Q2_A73ConCodPropio ;
   private String[] H006Q2_A379ConAfipEstado ;
   private String[] H006Q2_A138ConAFIPRegEspApo ;
   private String[] H006Q2_A137ConAFIPRegDifApo ;
   private String[] H006Q2_A133ConAFIPLeyRieTrabCont ;
   private String[] H006Q2_A128ConAFIPFonNacEmpCont ;
   private String[] H006Q2_A127ConAFIPAsigFamCont ;
   private String[] H006Q2_A140ConAFIPRenateaCont ;
   private String[] H006Q2_A139ConAFIPRenateaApo ;
   private String[] H006Q2_A130ConAFIPFonSolRedCont ;
   private String[] H006Q2_A129ConAFIPFonSolRedApo ;
   private String[] H006Q2_A136ConAFIPObraSocCont ;
   private String[] H006Q2_A135ConAFIPObraSocApo ;
   private String[] H006Q2_A132ConAFIPINSSJyPCont ;
   private String[] H006Q2_A131ConAFIPINSSJyPApo ;
   private String[] H006Q2_A142ConAFIPSIPACont ;
   private String[] H006Q2_A141ConAFIPSIPAApo ;
   private String[] H006Q2_A134ConAFIPMarcaRep ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class conceptoafipgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006Q2", "SELECT CliCod, ConCodPropio, ConAfipEstado, ConAFIPRegEspApo, ConAFIPRegDifApo, ConAFIPLeyRieTrabCont, ConAFIPFonNacEmpCont, ConAFIPAsigFamCont, ConAFIPRenateaCont, ConAFIPRenateaApo, ConAFIPFonSolRedCont, ConAFIPFonSolRedApo, ConAFIPObraSocCont, ConAFIPObraSocApo, ConAFIPINSSJyPCont, ConAFIPINSSJyPApo, ConAFIPSIPACont, ConAFIPSIPAApo, ConAFIPMarcaRep FROM ConceptoAFIP WHERE CliCod = ? and ConCodPropio = ( ?) ORDER BY CliCod, ConCodPropio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
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
               return;
      }
   }

}

