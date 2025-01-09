package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class obligaciongeneral_impl extends GXWebComponent
{
   public obligaciongeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public obligaciongeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obligaciongeneral_impl.class ));
   }

   public obligaciongeneral_impl( int remoteHandle ,
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
      dynLegNumero = new HTMLChoice();
      dynTipoOblSec = new HTMLChoice();
      cmbOblEstado = new HTMLChoice();
      dynOblLiqNro = new HTMLChoice();
      dynOblConCodigo = new HTMLChoice();
      chkOblNoRemu = UIFactory.getCheckbox(this);
      chkOblDescu = UIFactory.getCheckbox(this);
      cmbOblConcepto = new HTMLChoice();
      cmbOblTipoMov = new HTMLChoice();
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
               A1172OblSecuencial = (short)(GXutil.lval( httpContext.GetPar( "OblSecuencial"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1EmpCod),Integer.valueOf(A6LegNumero),Short.valueOf(A1172OblSecuencial)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"LEGNUMERO") == 0 )
            {
               AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               AV15EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlalegnumeroCF2( AV14CliCod, AV15EmpCod) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"TIPOOBLSEC") == 0 )
            {
               AV21Paicod = (short)(GXutil.lval( httpContext.GetPar( "Paicod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlatipooblsecCF2( AV21Paicod) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"OBLLIQNRO") == 0 )
            {
               AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               AV15EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlaoblliqnroCF2( AV14CliCod, AV15EmpCod, A6LegNumero) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"OBLCONCODIGO") == 0 )
            {
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               AV22Anticiposubtipoconcod1 = CommonUtil.decimalVal( httpContext.GetPar( "Anticiposubtipoconcod1"), ".") ;
               AV23Desdedtipoconcod = CommonUtil.decimalVal( httpContext.GetPar( "Desdedtipoconcod"), ".") ;
               AV24Hastadtipoconcod = CommonUtil.decimalVal( httpContext.GetPar( "Hastadtipoconcod"), ".") ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlaoblconcodigoCF2( A3CliCod, A1EmpCod, A6LegNumero, AV22Anticiposubtipoconcod1, AV23Desdedtipoconcod, AV24Hastadtipoconcod) ;
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
         paCF2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Obligacion General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.obligaciongeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1172OblSecuencial,4,0))}, new String[] {"CliCod","EmpCod","LegNumero","OblSecuencial"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ObligacionGeneral");
      forbiddenHiddens.add("OblLiqNro", localUtil.format( DecimalUtil.doubleToDec(A1195OblLiqNro), "ZZZZZZZ9"));
      forbiddenHiddens.add("OblPorc", localUtil.format( A1179OblPorc, "9.9999"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("obligaciongeneral:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA3CliCod", GXutil.ltrim( localUtil.ntoc( wcpOA3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOA1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA6LegNumero", GXutil.ltrim( localUtil.ntoc( wcpOA6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1172OblSecuencial", GXutil.ltrim( localUtil.ntoc( wcpOA1172OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV14CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV15EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPAICOD", GXutil.ltrim( localUtil.ntoc( AV21Paicod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vANTICIPOSUBTIPOCONCOD1", GXutil.ltrim( localUtil.ntoc( AV22Anticiposubtipoconcod1, (byte)(10), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDESDEDTIPOCONCOD", GXutil.ltrim( localUtil.ntoc( AV23Desdedtipoconcod, (byte)(10), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vHASTADTIPOCONCOD", GXutil.ltrim( localUtil.ntoc( AV24Hastadtipoconcod, (byte)(10), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormCF2( )
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
      return "ObligacionGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Obligacion General", "") ;
   }

   public void wbCF0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.obligaciongeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynLegNumero.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynLegNumero.getInternalname(), httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynLegNumero, dynLegNumero.getInternalname(), GXutil.trim( GXutil.str( A6LegNumero, 8, 0)), 1, dynLegNumero.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynLegNumero.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ObligacionGeneral.htm");
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynLegNumero.getInternalname(), "Values", dynLegNumero.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynTipoOblSec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynTipoOblSec.getInternalname(), httpContext.getMessage( "Obligación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynTipoOblSec, dynTipoOblSec.getInternalname(), GXutil.trim( GXutil.str( A1163TipoOblSec, 4, 0)), 1, dynTipoOblSec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynTipoOblSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ObligacionGeneral.htm");
         dynTipoOblSec.setValue( GXutil.trim( GXutil.str( A1163TipoOblSec, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynTipoOblSec.getInternalname(), "Values", dynTipoOblSec.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbOblEstado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbOblEstado.getInternalname(), httpContext.getMessage( "Estado", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbOblEstado, cmbOblEstado.getInternalname(), GXutil.trim( GXutil.str( A1173OblEstado, 1, 0)), 1, cmbOblEstado.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbOblEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ObligacionGeneral.htm");
         cmbOblEstado.setValue( GXutil.trim( GXutil.str( A1173OblEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbOblEstado.getInternalname(), "Values", cmbOblEstado.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblObs_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtOblObs_Internalname, httpContext.getMessage( "Observaciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtOblObs_Internalname, A1174OblObs, "", "", (short)(0), 1, edtOblObs_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ObligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divObltotal_cell_Internalname, 1, 0, "px", 0, "px", divObltotal_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtOblTotal_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblTotal_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtOblTotal_Internalname, httpContext.getMessage( "Total", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtOblTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A1176OblTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtOblTotal_Enabled!=0) ? localUtil.format( A1176OblTotal, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1176OblTotal, "ZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblTotal_Jsonclick, 0, "Attribute", "", "", "", "", edtOblTotal_Visible, edtOblTotal_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_ObligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divOblliqnro_cell_Internalname, 1, 0, "px", 0, "px", divOblliqnro_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", dynOblLiqNro.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynOblLiqNro.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynOblLiqNro.getInternalname(), httpContext.getMessage( "Liquidación del anticipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynOblLiqNro, dynOblLiqNro.getInternalname(), GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)), 1, dynOblLiqNro.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", dynOblLiqNro.getVisible(), dynOblLiqNro.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ObligacionGeneral.htm");
         dynOblLiqNro.setValue( GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblLiqNro.getInternalname(), "Values", dynOblLiqNro.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divOblconcodigo_cell_Internalname, 1, 0, "px", 0, "px", divOblconcodigo_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", dynOblConCodigo.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynOblConCodigo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynOblConCodigo.getInternalname(), httpContext.getMessage( "Concepto del anticipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynOblConCodigo, dynOblConCodigo.getInternalname(), GXutil.rtrim( A1169OblConCodigo), 1, dynOblConCodigo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", dynOblConCodigo.getVisible(), dynOblConCodigo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ObligacionGeneral.htm");
         dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblConCodigo.getInternalname(), "Values", dynOblConCodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divOblcancuo_cell_Internalname, 1, 0, "px", 0, "px", divOblcancuo_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtOblCanCuo_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblCanCuo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtOblCanCuo_Internalname, httpContext.getMessage( "Cantidad de cuotas", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtOblCanCuo_Internalname, GXutil.ltrim( localUtil.ntoc( A1177OblCanCuo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtOblCanCuo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1177OblCanCuo), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1177OblCanCuo), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblCanCuo_Jsonclick, 0, "Attribute", "", "", "", "", edtOblCanCuo_Visible, edtOblCanCuo_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ObligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblImpFij_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtOblImpFij_Internalname, httpContext.getMessage( "Importe de cuota fija", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtOblImpFij_Internalname, GXutil.ltrim( localUtil.ntoc( A1178OblImpFij, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtOblImpFij_Enabled!=0) ? localUtil.format( A1178OblImpFij, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1178OblImpFij, "ZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblImpFij_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOblImpFij_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_ObligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblPorc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtOblPorc_Internalname, httpContext.getMessage( "Porcentaje", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtOblPorc_Internalname, GXutil.ltrim( localUtil.ntoc( A1179OblPorc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtOblPorc_Enabled!=0) ? localUtil.format( A1179OblPorc, "9.9999") : localUtil.format( A1179OblPorc, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblPorc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOblPorc_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_ObligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divOblnoremu_cell_Internalname, 1, 0, "px", 0, "px", divOblnoremu_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkOblNoRemu.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOblNoRemu.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkOblNoRemu.getInternalname(), httpContext.getMessage( "Incluir conceptos de tipo no remunerativos para base de cálculo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOblNoRemu.getInternalname(), GXutil.booltostr( A1181OblNoRemu), "", httpContext.getMessage( "Incluir conceptos de tipo no remunerativos para base de cálculo", ""), chkOblNoRemu.getVisible(), chkOblNoRemu.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divObldescu_cell_Internalname, 1, 0, "px", 0, "px", divObldescu_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkOblDescu.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOblDescu.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkOblDescu.getInternalname(), httpContext.getMessage( "Incluir conceptos de tipo retencion para base de cálculo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOblDescu.getInternalname(), GXutil.booltostr( A1182OblDescu), "", httpContext.getMessage( "Incluir conceptos de tipo retencion para base de cálculo", ""), chkOblDescu.getVisible(), chkOblDescu.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbOblConcepto.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbOblConcepto.getInternalname(), httpContext.getMessage( "Concepto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbOblConcepto, cmbOblConcepto.getInternalname(), GXutil.rtrim( A2343OblConcepto), 1, cmbOblConcepto.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbOblConcepto.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ObligacionGeneral.htm");
         cmbOblConcepto.setValue( GXutil.rtrim( A2343OblConcepto) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbOblConcepto.getInternalname(), "Values", cmbOblConcepto.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbOblTipoMov.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbOblTipoMov.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbOblTipoMov, cmbOblTipoMov.getInternalname(), GXutil.rtrim( A2345OblTipoMov), 1, cmbOblTipoMov.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbOblTipoMov.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_ObligacionGeneral.htm");
         cmbOblTipoMov.setValue( GXutil.rtrim( A2345OblTipoMov) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbOblTipoMov.getInternalname(), "Values", cmbOblTipoMov.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11cf1_client"+"'", TempTags, "", 2, "HLP_ObligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 86,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12cf1_client"+"'", TempTags, "", 2, "HLP_ObligacionGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ObligacionGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_ObligacionGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtOblSecuencial_Internalname, GXutil.ltrim( localUtil.ntoc( A1172OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1172OblSecuencial), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblSecuencial_Jsonclick, 0, "Attribute", "", "", "", "", edtOblSecuencial_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ObligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startCF2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Obligacion General", ""), (short)(0)) ;
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
            strupCF0( ) ;
         }
      }
   }

   public void wsCF2( )
   {
      startCF2( ) ;
      evtCF2( ) ;
   }

   public void evtCF2( )
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
                              strupCF0( ) ;
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
                              strupCF0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13CF2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupCF0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14CF2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupCF0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15CF2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupCF0( ) ;
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
                              strupCF0( ) ;
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

   public void weCF2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormCF2( ) ;
         }
      }
   }

   public void paCF2( )
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

   public void gxdlalegnumeroCF2( int AV14CliCod ,
                                  short AV15EmpCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlalegnumero_dataCF2( AV14CliCod, AV15EmpCod) ;
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

   public void gxalegnumero_htmlCF2( int AV14CliCod ,
                                     short AV15EmpCod )
   {
      int gxdynajaxvalue;
      gxdlalegnumero_dataCF2( AV14CliCod, AV15EmpCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynLegNumero.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynLegNumero.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 8, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlalegnumero_dataCF2( int AV14CliCod ,
                                          short AV15EmpCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00CF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV15EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00CF2_A6LegNumero[0], (byte)(8), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00CF2_A250LegIdNomApe[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlatipooblsecCF2( short AV21Paicod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlatipooblsec_dataCF2( AV21Paicod) ;
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

   public void gxatipooblsec_htmlCF2( short AV21Paicod )
   {
      short gxdynajaxvalue;
      gxdlatipooblsec_dataCF2( AV21Paicod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynTipoOblSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynTipoOblSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlatipooblsec_dataCF2( short AV21Paicod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00CF3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV21Paicod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00CF3_A1163TipoOblSec[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00CF3_A1165TipoOblDescrip[0]);
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxdlaoblliqnroCF2( int AV14CliCod ,
                                  short AV15EmpCod ,
                                  int A6LegNumero )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaoblliqnro_dataCF2( AV14CliCod, AV15EmpCod, A6LegNumero) ;
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

   public void gxaoblliqnro_htmlCF2( int AV14CliCod ,
                                     short AV15EmpCod ,
                                     int A6LegNumero )
   {
      int gxdynajaxvalue;
      gxdlaoblliqnro_dataCF2( AV14CliCod, AV15EmpCod, A6LegNumero) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynOblLiqNro.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynOblLiqNro.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 8, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaoblliqnro_dataCF2( int AV14CliCod ,
                                          short AV15EmpCod ,
                                          int A6LegNumero )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00CF4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV15EmpCod), Integer.valueOf(A6LegNumero)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00CF4_A31LiqNro[0], (byte)(8), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00CF4_A874LiqNombre[0]);
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void gxdlaoblconcodigoCF2( int A3CliCod ,
                                     short A1EmpCod ,
                                     int A6LegNumero ,
                                     java.math.BigDecimal AV22Anticiposubtipoconcod1 ,
                                     java.math.BigDecimal AV23Desdedtipoconcod ,
                                     java.math.BigDecimal AV24Hastadtipoconcod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaoblconcodigo_dataCF2( A3CliCod, A1EmpCod, A6LegNumero, AV22Anticiposubtipoconcod1, AV23Desdedtipoconcod, AV24Hastadtipoconcod) ;
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

   public void gxaoblconcodigo_htmlCF2( int A3CliCod ,
                                        short A1EmpCod ,
                                        int A6LegNumero ,
                                        java.math.BigDecimal AV22Anticiposubtipoconcod1 ,
                                        java.math.BigDecimal AV23Desdedtipoconcod ,
                                        java.math.BigDecimal AV24Hastadtipoconcod )
   {
      String gxdynajaxvalue;
      gxdlaoblconcodigo_dataCF2( A3CliCod, A1EmpCod, A6LegNumero, AV22Anticiposubtipoconcod1, AV23Desdedtipoconcod, AV24Hastadtipoconcod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynOblConCodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynOblConCodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynOblConCodigo.getItemCount() > 0 )
      {
         A1169OblConCodigo = dynOblConCodigo.getValidValue(A1169OblConCodigo) ;
         n1169OblConCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1169OblConCodigo", A1169OblConCodigo);
      }
   }

   protected void gxdlaoblconcodigo_dataCF2( int A3CliCod ,
                                             short A1EmpCod ,
                                             int A6LegNumero ,
                                             java.math.BigDecimal AV22Anticiposubtipoconcod1 ,
                                             java.math.BigDecimal AV23Desdedtipoconcod ,
                                             java.math.BigDecimal AV24Hastadtipoconcod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00CF5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), AV23Desdedtipoconcod, AV24Hastadtipoconcod, AV22Anticiposubtipoconcod1});
      while ( (pr_default.getStatus(3) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00CF5_A394DConCodigo[0]));
         gxdynajaxctrldescr.add(H00CF5_A393DConDescrip[0]);
         pr_default.readNext(3);
      }
      pr_default.close(3);
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
      if ( dynLegNumero.getItemCount() > 0 )
      {
         A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValidValue(GXutil.trim( GXutil.str( A6LegNumero, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynLegNumero.getInternalname(), "Values", dynLegNumero.ToJavascriptSource(), true);
      }
      if ( dynTipoOblSec.getItemCount() > 0 )
      {
         A1163TipoOblSec = (short)(GXutil.lval( dynTipoOblSec.getValidValue(GXutil.trim( GXutil.str( A1163TipoOblSec, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynTipoOblSec.setValue( GXutil.trim( GXutil.str( A1163TipoOblSec, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynTipoOblSec.getInternalname(), "Values", dynTipoOblSec.ToJavascriptSource(), true);
      }
      if ( cmbOblEstado.getItemCount() > 0 )
      {
         A1173OblEstado = (byte)(GXutil.lval( cmbOblEstado.getValidValue(GXutil.trim( GXutil.str( A1173OblEstado, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbOblEstado.setValue( GXutil.trim( GXutil.str( A1173OblEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbOblEstado.getInternalname(), "Values", cmbOblEstado.ToJavascriptSource(), true);
      }
      if ( dynOblLiqNro.getItemCount() > 0 )
      {
         A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValidValue(GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0))))) ;
         n1195OblLiqNro = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblLiqNro.setValue( GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblLiqNro.getInternalname(), "Values", dynOblLiqNro.ToJavascriptSource(), true);
      }
      if ( dynOblConCodigo.getItemCount() > 0 )
      {
         A1169OblConCodigo = dynOblConCodigo.getValidValue(A1169OblConCodigo) ;
         n1169OblConCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1169OblConCodigo", A1169OblConCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblConCodigo.getInternalname(), "Values", dynOblConCodigo.ToJavascriptSource(), true);
      }
      A1181OblNoRemu = GXutil.strtobool( GXutil.booltostr( A1181OblNoRemu)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1181OblNoRemu", A1181OblNoRemu);
      A1182OblDescu = GXutil.strtobool( GXutil.booltostr( A1182OblDescu)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1182OblDescu", A1182OblDescu);
      if ( cmbOblConcepto.getItemCount() > 0 )
      {
         A2343OblConcepto = cmbOblConcepto.getValidValue(A2343OblConcepto) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2343OblConcepto", A2343OblConcepto);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbOblConcepto.setValue( GXutil.rtrim( A2343OblConcepto) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbOblConcepto.getInternalname(), "Values", cmbOblConcepto.ToJavascriptSource(), true);
      }
      if ( cmbOblTipoMov.getItemCount() > 0 )
      {
         A2345OblTipoMov = cmbOblTipoMov.getValidValue(A2345OblTipoMov) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2345OblTipoMov", A2345OblTipoMov);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbOblTipoMov.setValue( GXutil.rtrim( A2345OblTipoMov) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbOblTipoMov.getInternalname(), "Values", cmbOblTipoMov.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfCF2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV20Pgmname = "ObligacionGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfCF2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15CF2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00CF6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A1168TipoOblTotTipo = H00CF6_A1168TipoOblTotTipo[0] ;
            A2345OblTipoMov = H00CF6_A2345OblTipoMov[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2345OblTipoMov", A2345OblTipoMov);
            A2343OblConcepto = H00CF6_A2343OblConcepto[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2343OblConcepto", A2343OblConcepto);
            A1182OblDescu = H00CF6_A1182OblDescu[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1182OblDescu", A1182OblDescu);
            A1181OblNoRemu = H00CF6_A1181OblNoRemu[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1181OblNoRemu", A1181OblNoRemu);
            A1179OblPorc = H00CF6_A1179OblPorc[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1179OblPorc", GXutil.ltrimstr( A1179OblPorc, 6, 4));
            A1178OblImpFij = H00CF6_A1178OblImpFij[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1178OblImpFij", GXutil.ltrimstr( A1178OblImpFij, 14, 2));
            A1177OblCanCuo = H00CF6_A1177OblCanCuo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1177OblCanCuo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1177OblCanCuo), 4, 0));
            A1169OblConCodigo = H00CF6_A1169OblConCodigo[0] ;
            n1169OblConCodigo = H00CF6_n1169OblConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1169OblConCodigo", A1169OblConCodigo);
            A1195OblLiqNro = H00CF6_A1195OblLiqNro[0] ;
            n1195OblLiqNro = H00CF6_n1195OblLiqNro[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
            A1176OblTotal = H00CF6_A1176OblTotal[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1176OblTotal", GXutil.ltrimstr( A1176OblTotal, 14, 2));
            A1174OblObs = H00CF6_A1174OblObs[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1174OblObs", A1174OblObs);
            A1173OblEstado = H00CF6_A1173OblEstado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
            A1163TipoOblSec = H00CF6_A1163TipoOblSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
            A1168TipoOblTotTipo = H00CF6_A1168TipoOblTotTipo[0] ;
            /* Execute user event: Load */
            e14CF2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
         wbCF0( ) ;
      }
   }

   public void send_integrity_lvl_hashesCF2( )
   {
   }

   public void before_start_formulas( )
   {
      AV20Pgmname = "ObligacionGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupCF0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13CF2 ();
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
         wcpOA1172OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1172OblSecuencial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         dynTipoOblSec.setValue( httpContext.cgiGet( dynTipoOblSec.getInternalname()) );
         A1163TipoOblSec = (short)(GXutil.lval( httpContext.cgiGet( dynTipoOblSec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
         cmbOblEstado.setValue( httpContext.cgiGet( cmbOblEstado.getInternalname()) );
         A1173OblEstado = (byte)(GXutil.lval( httpContext.cgiGet( cmbOblEstado.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
         A1174OblObs = httpContext.cgiGet( edtOblObs_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1174OblObs", A1174OblObs);
         A1176OblTotal = localUtil.ctond( httpContext.cgiGet( edtOblTotal_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1176OblTotal", GXutil.ltrimstr( A1176OblTotal, 14, 2));
         dynOblLiqNro.setValue( httpContext.cgiGet( dynOblLiqNro.getInternalname()) );
         A1195OblLiqNro = (int)(GXutil.lval( httpContext.cgiGet( dynOblLiqNro.getInternalname()))) ;
         n1195OblLiqNro = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
         dynOblConCodigo.setValue( httpContext.cgiGet( dynOblConCodigo.getInternalname()) );
         A1169OblConCodigo = httpContext.cgiGet( dynOblConCodigo.getInternalname()) ;
         n1169OblConCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1169OblConCodigo", A1169OblConCodigo);
         A1177OblCanCuo = (short)(localUtil.ctol( httpContext.cgiGet( edtOblCanCuo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1177OblCanCuo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1177OblCanCuo), 4, 0));
         A1178OblImpFij = localUtil.ctond( httpContext.cgiGet( edtOblImpFij_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1178OblImpFij", GXutil.ltrimstr( A1178OblImpFij, 14, 2));
         A1179OblPorc = localUtil.ctond( httpContext.cgiGet( edtOblPorc_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1179OblPorc", GXutil.ltrimstr( A1179OblPorc, 6, 4));
         A1181OblNoRemu = GXutil.strtobool( httpContext.cgiGet( chkOblNoRemu.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1181OblNoRemu", A1181OblNoRemu);
         A1182OblDescu = GXutil.strtobool( httpContext.cgiGet( chkOblDescu.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1182OblDescu", A1182OblDescu);
         cmbOblConcepto.setValue( httpContext.cgiGet( cmbOblConcepto.getInternalname()) );
         A2343OblConcepto = httpContext.cgiGet( cmbOblConcepto.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2343OblConcepto", A2343OblConcepto);
         cmbOblTipoMov.setValue( httpContext.cgiGet( cmbOblTipoMov.getInternalname()) );
         A2345OblTipoMov = httpContext.cgiGet( cmbOblTipoMov.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2345OblTipoMov", A2345OblTipoMov);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ObligacionGeneral");
         A1195OblLiqNro = (int)(GXutil.lval( httpContext.cgiGet( dynOblLiqNro.getInternalname()))) ;
         n1195OblLiqNro = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
         forbiddenHiddens.add("OblLiqNro", localUtil.format( DecimalUtil.doubleToDec(A1195OblLiqNro), "ZZZZZZZ9"));
         A1179OblPorc = localUtil.ctond( httpContext.cgiGet( edtOblPorc_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1179OblPorc", GXutil.ltrimstr( A1179OblPorc, 6, 4));
         forbiddenHiddens.add("OblPorc", localUtil.format( A1179OblPorc, "9.9999"));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("obligaciongeneral:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e13CF2 ();
      if (returnInSub) return;
   }

   public void e13CF2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      obligaciongeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
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

   protected void e14CF2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtOblSecuencial_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtOblSecuencial_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblSecuencial_Visible), 5, 0), true);
      GXt_boolean4 = AV13TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Update", GXv_boolean5) ;
      obligaciongeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV13TempBoolean = GXt_boolean4 ;
      if ( ! ( AV13TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV13TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Delete", GXv_boolean5) ;
      obligaciongeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV13TempBoolean = GXt_boolean4 ;
      if ( ! ( AV13TempBoolean ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
      if ( ! ( ( A1168TipoOblTotTipo == 1 ) ) )
      {
         edtOblTotal_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtOblTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblTotal_Visible), 5, 0), true);
         divObltotal_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
      }
      else
      {
         edtOblTotal_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtOblTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblTotal_Visible), 5, 0), true);
         divObltotal_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
      }
      if ( ! ( ( A1168TipoOblTotTipo == 2 ) ) )
      {
         dynOblLiqNro.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblLiqNro.getInternalname(), "Visible", GXutil.ltrimstr( dynOblLiqNro.getVisible(), 5, 0), true);
         divOblliqnro_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
      }
      else
      {
         dynOblLiqNro.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblLiqNro.getInternalname(), "Visible", GXutil.ltrimstr( dynOblLiqNro.getVisible(), 5, 0), true);
         divOblliqnro_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
      }
      if ( ! ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) ) )
      {
         dynOblConCodigo.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblConCodigo.getInternalname(), "Visible", GXutil.ltrimstr( dynOblConCodigo.getVisible(), 5, 0), true);
         divOblconcodigo_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
      }
      else
      {
         dynOblConCodigo.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblConCodigo.getInternalname(), "Visible", GXutil.ltrimstr( dynOblConCodigo.getVisible(), 5, 0), true);
         divOblconcodigo_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
      }
      if ( ! ( ( A1168TipoOblTotTipo != 0 ) ) )
      {
         edtOblCanCuo_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtOblCanCuo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblCanCuo_Visible), 5, 0), true);
         divOblcancuo_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
      }
      else
      {
         edtOblCanCuo_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtOblCanCuo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblCanCuo_Visible), 5, 0), true);
         divOblcancuo_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
      }
      if ( ! ( ( A1179OblPorc.doubleValue() > 0 ) ) )
      {
         chkOblNoRemu.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkOblNoRemu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblNoRemu.getVisible(), 5, 0), true);
         divOblnoremu_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOblnoremu_cell_Internalname, "Class", divOblnoremu_cell_Class, true);
      }
      else
      {
         chkOblNoRemu.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkOblNoRemu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblNoRemu.getVisible(), 5, 0), true);
         divOblnoremu_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOblnoremu_cell_Internalname, "Class", divOblnoremu_cell_Class, true);
      }
      if ( ! ( ( A1179OblPorc.doubleValue() > 0 ) ) )
      {
         chkOblDescu.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkOblDescu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblDescu.getVisible(), 5, 0), true);
         divObldescu_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divObldescu_cell_Internalname, "Class", divObldescu_cell_Class, true);
      }
      else
      {
         chkOblDescu.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkOblDescu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblDescu.getVisible(), 5, 0), true);
         divObldescu_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divObldescu_cell_Internalname, "Class", divObldescu_cell_Class, true);
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Obligacion" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15CF2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      obligaciongeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
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
      A1172OblSecuencial = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
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
      paCF2( ) ;
      wsCF2( ) ;
      weCF2( ) ;
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
      sCtrlA1172OblSecuencial = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paCF2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "obligaciongeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paCF2( ) ;
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
         A1172OblSecuencial = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1172OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1172OblSecuencial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1EmpCod != wcpOA1EmpCod ) || ( A6LegNumero != wcpOA6LegNumero ) || ( A1172OblSecuencial != wcpOA1172OblSecuencial ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1EmpCod = A1EmpCod ;
      wcpOA6LegNumero = A6LegNumero ;
      wcpOA1172OblSecuencial = A1172OblSecuencial ;
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
      sCtrlA1172OblSecuencial = httpContext.cgiGet( sPrefix+"A1172OblSecuencial_CTRL") ;
      if ( GXutil.len( sCtrlA1172OblSecuencial) > 0 )
      {
         A1172OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA1172OblSecuencial), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
      }
      else
      {
         A1172OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1172OblSecuencial_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paCF2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsCF2( ) ;
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
      wsCF2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1172OblSecuencial_PARM", GXutil.ltrim( localUtil.ntoc( A1172OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1172OblSecuencial)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1172OblSecuencial_CTRL", GXutil.rtrim( sCtrlA1172OblSecuencial));
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
      weCF2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713555937", true, true);
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
      httpContext.AddJavascriptSource("obligaciongeneral.js", "?20251713555937", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynLegNumero.setInternalname( sPrefix+"LEGNUMERO" );
      dynTipoOblSec.setInternalname( sPrefix+"TIPOOBLSEC" );
      cmbOblEstado.setInternalname( sPrefix+"OBLESTADO" );
      edtOblObs_Internalname = sPrefix+"OBLOBS" ;
      edtOblTotal_Internalname = sPrefix+"OBLTOTAL" ;
      divObltotal_cell_Internalname = sPrefix+"OBLTOTAL_CELL" ;
      dynOblLiqNro.setInternalname( sPrefix+"OBLLIQNRO" );
      divOblliqnro_cell_Internalname = sPrefix+"OBLLIQNRO_CELL" ;
      dynOblConCodigo.setInternalname( sPrefix+"OBLCONCODIGO" );
      divOblconcodigo_cell_Internalname = sPrefix+"OBLCONCODIGO_CELL" ;
      edtOblCanCuo_Internalname = sPrefix+"OBLCANCUO" ;
      divOblcancuo_cell_Internalname = sPrefix+"OBLCANCUO_CELL" ;
      edtOblImpFij_Internalname = sPrefix+"OBLIMPFIJ" ;
      edtOblPorc_Internalname = sPrefix+"OBLPORC" ;
      chkOblNoRemu.setInternalname( sPrefix+"OBLNOREMU" );
      divOblnoremu_cell_Internalname = sPrefix+"OBLNOREMU_CELL" ;
      chkOblDescu.setInternalname( sPrefix+"OBLDESCU" );
      divObldescu_cell_Internalname = sPrefix+"OBLDESCU_CELL" ;
      cmbOblConcepto.setInternalname( sPrefix+"OBLCONCEPTO" );
      cmbOblTipoMov.setInternalname( sPrefix+"OBLTIPOMOV" );
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtOblSecuencial_Internalname = sPrefix+"OBLSECUENCIAL" ;
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
      edtOblSecuencial_Jsonclick = "" ;
      edtOblSecuencial_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      cmbOblTipoMov.setJsonclick( "" );
      cmbOblTipoMov.setEnabled( 0 );
      cmbOblConcepto.setJsonclick( "" );
      cmbOblConcepto.setEnabled( 0 );
      chkOblDescu.setEnabled( 0 );
      chkOblDescu.setVisible( 1 );
      divObldescu_cell_Class = "col-xs-12" ;
      chkOblNoRemu.setEnabled( 0 );
      chkOblNoRemu.setVisible( 1 );
      divOblnoremu_cell_Class = "col-xs-12" ;
      edtOblPorc_Jsonclick = "" ;
      edtOblPorc_Enabled = 0 ;
      edtOblImpFij_Jsonclick = "" ;
      edtOblImpFij_Enabled = 0 ;
      edtOblCanCuo_Jsonclick = "" ;
      edtOblCanCuo_Enabled = 0 ;
      edtOblCanCuo_Visible = 1 ;
      divOblcancuo_cell_Class = "col-xs-12" ;
      dynOblConCodigo.setJsonclick( "" );
      dynOblConCodigo.setEnabled( 0 );
      dynOblConCodigo.setVisible( 1 );
      divOblconcodigo_cell_Class = "col-xs-12" ;
      dynOblLiqNro.setJsonclick( "" );
      dynOblLiqNro.setEnabled( 0 );
      dynOblLiqNro.setVisible( 1 );
      divOblliqnro_cell_Class = "col-xs-12" ;
      edtOblTotal_Jsonclick = "" ;
      edtOblTotal_Enabled = 0 ;
      edtOblTotal_Visible = 1 ;
      divObltotal_cell_Class = "col-xs-12" ;
      edtOblObs_Enabled = 0 ;
      cmbOblEstado.setJsonclick( "" );
      cmbOblEstado.setEnabled( 0 );
      dynTipoOblSec.setJsonclick( "" );
      dynTipoOblSec.setEnabled( 0 );
      dynLegNumero.setJsonclick( "" );
      dynLegNumero.setEnabled( 0 );
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
      dynLegNumero.setName( "LEGNUMERO" );
      dynLegNumero.setWebtags( "" );
      dynTipoOblSec.setName( "TIPOOBLSEC" );
      dynTipoOblSec.setWebtags( "" );
      cmbOblEstado.setName( "OBLESTADO" );
      cmbOblEstado.setWebtags( "" );
      cmbOblEstado.addItem("0", httpContext.getMessage( "Inactivo", ""), (short)(0));
      cmbOblEstado.addItem("1", httpContext.getMessage( "Activo", ""), (short)(0));
      if ( cmbOblEstado.getItemCount() > 0 )
      {
      }
      dynOblLiqNro.setName( "OBLLIQNRO" );
      dynOblLiqNro.setWebtags( "" );
      dynOblConCodigo.setName( "OBLCONCODIGO" );
      dynOblConCodigo.setWebtags( "" );
      chkOblNoRemu.setName( "OBLNOREMU" );
      chkOblNoRemu.setWebtags( "" );
      chkOblNoRemu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkOblNoRemu.getInternalname(), "TitleCaption", chkOblNoRemu.getCaption(), true);
      chkOblNoRemu.setCheckedValue( "false" );
      chkOblDescu.setName( "OBLDESCU" );
      chkOblDescu.setWebtags( "" );
      chkOblDescu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkOblDescu.getInternalname(), "TitleCaption", chkOblDescu.getCaption(), true);
      chkOblDescu.setCheckedValue( "false" );
      cmbOblConcepto.setName( "OBLCONCEPTO" );
      cmbOblConcepto.setWebtags( "" );
      if ( cmbOblConcepto.getItemCount() > 0 )
      {
      }
      cmbOblTipoMov.setName( "OBLTIPOMOV" );
      cmbOblTipoMov.setWebtags( "" );
      cmbOblTipoMov.addItem("Descuento", httpContext.getMessage( "Descuento", ""), (short)(0));
      cmbOblTipoMov.addItem("Acreditacion", httpContext.getMessage( "Acreditación", ""), (short)(0));
      if ( cmbOblTipoMov.getItemCount() > 0 )
      {
      }
      /* End function init_web_controls */
   }

   public void valid_Legnumero( )
   {
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      n1195OblLiqNro = false ;
      A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValue())) ;
      n1195OblLiqNro = false ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      gxaoblliqnro_htmlCF2( AV14CliCod, AV15EmpCod, A6LegNumero) ;
      gxaoblconcodigo_htmlCF2( A3CliCod, A1EmpCod, A6LegNumero, AV22Anticiposubtipoconcod1, AV23Desdedtipoconcod, AV24Hastadtipoconcod) ;
      dynload_actions( ) ;
      if ( dynOblLiqNro.getItemCount() > 0 )
      {
         A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValidValue(GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0))))) ;
         n1195OblLiqNro = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblLiqNro.setValue( GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)) );
      }
      if ( dynOblConCodigo.getItemCount() > 0 )
      {
         A1169OblConCodigo = dynOblConCodigo.getValidValue(A1169OblConCodigo) ;
         n1169OblConCodigo = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1195OblLiqNro", GXutil.ltrim( localUtil.ntoc( A1195OblLiqNro, (byte)(8), (byte)(0), ".", "")));
      dynOblLiqNro.setValue( GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblLiqNro.getInternalname(), "Values", dynOblLiqNro.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1169OblConCodigo", GXutil.rtrim( A1169OblConCodigo));
      dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblConCodigo.getInternalname(), "Values", dynOblConCodigo.ToJavascriptSource(), true);
   }

   public void valid_Clicod( )
   {
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      gxaoblconcodigo_htmlCF2( A3CliCod, A1EmpCod, A6LegNumero, AV22Anticiposubtipoconcod1, AV23Desdedtipoconcod, AV24Hastadtipoconcod) ;
      dynload_actions( ) ;
      if ( dynOblConCodigo.getItemCount() > 0 )
      {
         A1169OblConCodigo = dynOblConCodigo.getValidValue(A1169OblConCodigo) ;
         n1169OblConCodigo = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1169OblConCodigo", GXutil.rtrim( A1169OblConCodigo));
      dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblConCodigo.getInternalname(), "Values", dynOblConCodigo.ToJavascriptSource(), true);
   }

   public void valid_Empcod( )
   {
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      gxaoblconcodigo_htmlCF2( A3CliCod, A1EmpCod, A6LegNumero, AV22Anticiposubtipoconcod1, AV23Desdedtipoconcod, AV24Hastadtipoconcod) ;
      dynload_actions( ) ;
      if ( dynOblConCodigo.getItemCount() > 0 )
      {
         A1169OblConCodigo = dynOblConCodigo.getValidValue(A1169OblConCodigo) ;
         n1169OblConCodigo = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1169OblConCodigo", GXutil.rtrim( A1169OblConCodigo));
      dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynOblConCodigo.getInternalname(), "Values", dynOblConCodigo.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A1172OblSecuencial',fld:'OBLSECUENCIAL',pic:'ZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1179OblPorc',fld:'OBLPORC',pic:'9.9999'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11CF1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A1172OblSecuencial',fld:'OBLSECUENCIAL',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12CF1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A1172OblSecuencial',fld:'OBLSECUENCIAL',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV15EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV22Anticiposubtipoconcod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:'9999999.99'},{av:'AV23Desdedtipoconcod',fld:'vDESDEDTIPOCONCOD',pic:'9999999.99'},{av:'AV24Hastadtipoconcod',fld:'vHASTADTIPOCONCOD',pic:'9999999.99'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''}]}");
      setEventMetadata("VALID_TIPOOBLSEC","{handler:'valid_Tipooblsec',iparms:[]");
      setEventMetadata("VALID_TIPOOBLSEC",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV22Anticiposubtipoconcod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:'9999999.99'},{av:'AV23Desdedtipoconcod',fld:'vDESDEDTIPOCONCOD',pic:'9999999.99'},{av:'AV24Hastadtipoconcod',fld:'vHASTADTIPOCONCOD',pic:'9999999.99'},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV22Anticiposubtipoconcod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:'9999999.99'},{av:'AV23Desdedtipoconcod',fld:'vDESDEDTIPOCONCOD',pic:'9999999.99'},{av:'AV24Hastadtipoconcod',fld:'vHASTADTIPOCONCOD',pic:'9999999.99'},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''}]}");
      setEventMetadata("VALID_OBLSECUENCIAL","{handler:'valid_Oblsecuencial',iparms:[]");
      setEventMetadata("VALID_OBLSECUENCIAL",",oparms:[]}");
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
      AV22Anticiposubtipoconcod1 = DecimalUtil.ZERO ;
      AV23Desdedtipoconcod = DecimalUtil.ZERO ;
      AV24Hastadtipoconcod = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      A1179OblPorc = DecimalUtil.ZERO ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1174OblObs = "" ;
      A1176OblTotal = DecimalUtil.ZERO ;
      A1169OblConCodigo = "" ;
      A1178OblImpFij = DecimalUtil.ZERO ;
      A2343OblConcepto = "" ;
      A2345OblTipoMov = "" ;
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
      H00CF2_A3CliCod = new int[1] ;
      H00CF2_A1EmpCod = new short[1] ;
      H00CF2_A6LegNumero = new int[1] ;
      H00CF2_A250LegIdNomApe = new String[] {""} ;
      H00CF2_A1818LegEstado = new byte[1] ;
      H00CF3_A1163TipoOblSec = new short[1] ;
      H00CF3_A1165TipoOblDescrip = new String[] {""} ;
      H00CF3_A1159TipoOblPaiCod = new short[1] ;
      H00CF4_A3CliCod = new int[1] ;
      H00CF4_A1EmpCod = new short[1] ;
      H00CF4_A6LegNumero = new int[1] ;
      H00CF4_A31LiqNro = new int[1] ;
      H00CF4_A874LiqNombre = new String[] {""} ;
      H00CF5_A3CliCod = new int[1] ;
      H00CF5_A1EmpCod = new short[1] ;
      H00CF5_A31LiqNro = new int[1] ;
      H00CF5_A6LegNumero = new int[1] ;
      H00CF5_A81LiqDSecuencial = new int[1] ;
      H00CF5_A394DConCodigo = new String[] {""} ;
      H00CF5_A393DConDescrip = new String[] {""} ;
      H00CF5_A468DSubTipoConCod1 = new String[] {""} ;
      H00CF5_n468DSubTipoConCod1 = new boolean[] {false} ;
      H00CF5_A464DTipoConCod = new String[] {""} ;
      AV20Pgmname = "" ;
      H00CF6_A3CliCod = new int[1] ;
      H00CF6_A1EmpCod = new short[1] ;
      H00CF6_A6LegNumero = new int[1] ;
      H00CF6_A1172OblSecuencial = new short[1] ;
      H00CF6_A1168TipoOblTotTipo = new byte[1] ;
      H00CF6_A2345OblTipoMov = new String[] {""} ;
      H00CF6_A2343OblConcepto = new String[] {""} ;
      H00CF6_A1182OblDescu = new boolean[] {false} ;
      H00CF6_A1181OblNoRemu = new boolean[] {false} ;
      H00CF6_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CF6_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CF6_A1177OblCanCuo = new short[1] ;
      H00CF6_A1169OblConCodigo = new String[] {""} ;
      H00CF6_n1169OblConCodigo = new boolean[] {false} ;
      H00CF6_A1195OblLiqNro = new int[1] ;
      H00CF6_n1195OblLiqNro = new boolean[] {false} ;
      H00CF6_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CF6_A1174OblObs = new String[] {""} ;
      H00CF6_A1173OblEstado = new byte[1] ;
      H00CF6_A1163TipoOblSec = new short[1] ;
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
      sCtrlA3CliCod = "" ;
      sCtrlA1EmpCod = "" ;
      sCtrlA6LegNumero = "" ;
      sCtrlA1172OblSecuencial = "" ;
      Z1169OblConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obligaciongeneral__default(),
         new Object[] {
             new Object[] {
            H00CF2_A3CliCod, H00CF2_A1EmpCod, H00CF2_A6LegNumero, H00CF2_A250LegIdNomApe, H00CF2_A1818LegEstado
            }
            , new Object[] {
            H00CF3_A1163TipoOblSec, H00CF3_A1165TipoOblDescrip, H00CF3_A1159TipoOblPaiCod
            }
            , new Object[] {
            H00CF4_A3CliCod, H00CF4_A1EmpCod, H00CF4_A6LegNumero, H00CF4_A31LiqNro, H00CF4_A874LiqNombre
            }
            , new Object[] {
            H00CF5_A3CliCod, H00CF5_A1EmpCod, H00CF5_A31LiqNro, H00CF5_A6LegNumero, H00CF5_A81LiqDSecuencial, H00CF5_A394DConCodigo, H00CF5_A393DConDescrip, H00CF5_A468DSubTipoConCod1, H00CF5_n468DSubTipoConCod1, H00CF5_A464DTipoConCod
            }
            , new Object[] {
            H00CF6_A3CliCod, H00CF6_A1EmpCod, H00CF6_A6LegNumero, H00CF6_A1172OblSecuencial, H00CF6_A1168TipoOblTotTipo, H00CF6_A2345OblTipoMov, H00CF6_A2343OblConcepto, H00CF6_A1182OblDescu, H00CF6_A1181OblNoRemu, H00CF6_A1179OblPorc,
            H00CF6_A1178OblImpFij, H00CF6_A1177OblCanCuo, H00CF6_A1169OblConCodigo, H00CF6_n1169OblConCodigo, H00CF6_A1195OblLiqNro, H00CF6_n1195OblLiqNro, H00CF6_A1176OblTotal, H00CF6_A1174OblObs, H00CF6_A1173OblEstado, H00CF6_A1163TipoOblSec
            }
         }
      );
      AV20Pgmname = "ObligacionGeneral" ;
      /* GeneXus formulas. */
      AV20Pgmname = "ObligacionGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1173OblEstado ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte A1168TipoOblTotTipo ;
   private byte nGXWrapped ;
   private short wcpOA1EmpCod ;
   private short wcpOA1172OblSecuencial ;
   private short A1EmpCod ;
   private short A1172OblSecuencial ;
   private short AV15EmpCod ;
   private short AV21Paicod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1163TipoOblSec ;
   private short A1177OblCanCuo ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int wcpOA6LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV14CliCod ;
   private int A1195OblLiqNro ;
   private int edtOblObs_Enabled ;
   private int edtOblTotal_Visible ;
   private int edtOblTotal_Enabled ;
   private int edtOblCanCuo_Visible ;
   private int edtOblCanCuo_Enabled ;
   private int edtOblImpFij_Enabled ;
   private int edtOblPorc_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtEmpCod_Visible ;
   private int edtOblSecuencial_Visible ;
   private int gxdynajaxindex ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private int Z1195OblLiqNro ;
   private java.math.BigDecimal AV22Anticiposubtipoconcod1 ;
   private java.math.BigDecimal AV23Desdedtipoconcod ;
   private java.math.BigDecimal AV24Hastadtipoconcod ;
   private java.math.BigDecimal A1179OblPorc ;
   private java.math.BigDecimal A1176OblTotal ;
   private java.math.BigDecimal A1178OblImpFij ;
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
   private String edtOblObs_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divObltotal_cell_Internalname ;
   private String divObltotal_cell_Class ;
   private String edtOblTotal_Internalname ;
   private String edtOblTotal_Jsonclick ;
   private String divOblliqnro_cell_Internalname ;
   private String divOblliqnro_cell_Class ;
   private String divOblconcodigo_cell_Internalname ;
   private String divOblconcodigo_cell_Class ;
   private String A1169OblConCodigo ;
   private String divOblcancuo_cell_Internalname ;
   private String divOblcancuo_cell_Class ;
   private String edtOblCanCuo_Internalname ;
   private String edtOblCanCuo_Jsonclick ;
   private String edtOblImpFij_Internalname ;
   private String edtOblImpFij_Jsonclick ;
   private String edtOblPorc_Internalname ;
   private String edtOblPorc_Jsonclick ;
   private String divOblnoremu_cell_Internalname ;
   private String divOblnoremu_cell_Class ;
   private String divObldescu_cell_Internalname ;
   private String divObldescu_cell_Class ;
   private String A2343OblConcepto ;
   private String A2345OblTipoMov ;
   private String TempTags ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtOblSecuencial_Internalname ;
   private String edtOblSecuencial_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV20Pgmname ;
   private String hsh ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1EmpCod ;
   private String sCtrlA6LegNumero ;
   private String sCtrlA1172OblSecuencial ;
   private String Z1169OblConCodigo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A1181OblNoRemu ;
   private boolean A1182OblDescu ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1169OblConCodigo ;
   private boolean n1195OblLiqNro ;
   private boolean returnInSub ;
   private boolean AV13TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A1174OblObs ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynLegNumero ;
   private HTMLChoice dynTipoOblSec ;
   private HTMLChoice cmbOblEstado ;
   private HTMLChoice dynOblLiqNro ;
   private HTMLChoice dynOblConCodigo ;
   private ICheckbox chkOblNoRemu ;
   private ICheckbox chkOblDescu ;
   private HTMLChoice cmbOblConcepto ;
   private HTMLChoice cmbOblTipoMov ;
   private IDataStoreProvider pr_default ;
   private int[] H00CF2_A3CliCod ;
   private short[] H00CF2_A1EmpCod ;
   private int[] H00CF2_A6LegNumero ;
   private String[] H00CF2_A250LegIdNomApe ;
   private byte[] H00CF2_A1818LegEstado ;
   private short[] H00CF3_A1163TipoOblSec ;
   private String[] H00CF3_A1165TipoOblDescrip ;
   private short[] H00CF3_A1159TipoOblPaiCod ;
   private int[] H00CF4_A3CliCod ;
   private short[] H00CF4_A1EmpCod ;
   private int[] H00CF4_A6LegNumero ;
   private int[] H00CF4_A31LiqNro ;
   private String[] H00CF4_A874LiqNombre ;
   private int[] H00CF5_A3CliCod ;
   private short[] H00CF5_A1EmpCod ;
   private int[] H00CF5_A31LiqNro ;
   private int[] H00CF5_A6LegNumero ;
   private int[] H00CF5_A81LiqDSecuencial ;
   private String[] H00CF5_A394DConCodigo ;
   private String[] H00CF5_A393DConDescrip ;
   private String[] H00CF5_A468DSubTipoConCod1 ;
   private boolean[] H00CF5_n468DSubTipoConCod1 ;
   private String[] H00CF5_A464DTipoConCod ;
   private int[] H00CF6_A3CliCod ;
   private short[] H00CF6_A1EmpCod ;
   private int[] H00CF6_A6LegNumero ;
   private short[] H00CF6_A1172OblSecuencial ;
   private byte[] H00CF6_A1168TipoOblTotTipo ;
   private String[] H00CF6_A2345OblTipoMov ;
   private String[] H00CF6_A2343OblConcepto ;
   private boolean[] H00CF6_A1182OblDescu ;
   private boolean[] H00CF6_A1181OblNoRemu ;
   private java.math.BigDecimal[] H00CF6_A1179OblPorc ;
   private java.math.BigDecimal[] H00CF6_A1178OblImpFij ;
   private short[] H00CF6_A1177OblCanCuo ;
   private String[] H00CF6_A1169OblConCodigo ;
   private boolean[] H00CF6_n1169OblConCodigo ;
   private int[] H00CF6_A1195OblLiqNro ;
   private boolean[] H00CF6_n1195OblLiqNro ;
   private java.math.BigDecimal[] H00CF6_A1176OblTotal ;
   private String[] H00CF6_A1174OblObs ;
   private byte[] H00CF6_A1173OblEstado ;
   private short[] H00CF6_A1163TipoOblSec ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class obligaciongeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00CF2", "SELECT CliCod, EmpCod, LegNumero, LegIdNomApe, LegEstado FROM Legajo WHERE (CliCod = ?) AND (EmpCod = ?) AND (LegEstado = 1) ORDER BY LegIdNomApe ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00CF3", "SELECT TipoOblSec, TipoOblDescrip, TipoOblPaiCod FROM tipo_obligacion WHERE TipoOblPaiCod = ? ORDER BY TipoOblDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00CF4", "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqNro, T2.LiqNombre FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ?) AND (T1.EmpCod = ?) AND (T1.LegNumero = ?) ORDER BY T2.LiqNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00CF5", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial, DConCodigo, DConDescrip, DSubTipoConCod1, DTipoConCod FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (DTipoConCod >= ?) AND (DTipoConCod <= ?) AND (DSubTipoConCod1 = ?) ORDER BY DConDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00CF6", "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial, T2.TipoOblTotTipo, T1.OblTipoMov, T1.OblConcepto, T1.OblDescu, T1.OblNoRemu, T1.OblPorc, T1.OblImpFij, T1.OblCanCuo, T1.OblConCodigo, T1.OblLiqNro, T1.OblTotal, T1.OblObs, T1.OblEstado, T1.TipoOblSec FROM (Obligacion T1 INNER JOIN tipo_obligacion T2 ON T2.TipoOblSec = T1.TipoOblSec) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.OblSecuencial = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,4);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 10);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((int[]) buf[14])[0] = rslt.getInt(14);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(15,2);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(16);
               ((byte[]) buf[18])[0] = rslt.getByte(17);
               ((short[]) buf[19])[0] = rslt.getShort(18);
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
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

