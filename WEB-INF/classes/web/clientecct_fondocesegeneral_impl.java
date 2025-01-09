package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clientecct_fondocesegeneral_impl extends GXWebComponent
{
   public clientecct_fondocesegeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clientecct_fondocesegeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientecct_fondocesegeneral_impl.class ));
   }

   public clientecct_fondocesegeneral_impl( int remoteHandle ,
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
      chkCliConveFondoRem = UIFactory.getCheckbox(this);
      chkCliConveFondoNre = UIFactory.getCheckbox(this);
      chkCliConveFondoDes = UIFactory.getCheckbox(this);
      dynCliConveFondoRelSec = new HTMLChoice();
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
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1565CliConvenio", A1565CliConvenio);
               A1575CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
               A2147CliConveFondoSec = (short)(GXutil.lval( httpContext.GetPar( "CliConveFondoSec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1564CliPaiConve),A1565CliConvenio,A1575CliConveVig,Short.valueOf(A2147CliConveFondoSec)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CLICONVEFONDORELSEC") == 0 )
            {
               AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlacliconvefondorelsecMI2( AV14CliCod) ;
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
         paMI2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Clientecct_fondocese General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.clientecct_fondocesegeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(A1575CliConveVig)),GXutil.URLEncode(GXutil.ltrimstr(A2147CliConveFondoSec,4,0))}, new String[] {"CliCod","CliPaiConve","CliConvenio","CliConveVig","CliConveFondoSec"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( wcpOA1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1565CliConvenio", GXutil.rtrim( wcpOA1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1575CliConveVig", localUtil.dtoc( wcpOA1575CliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA2147CliConveFondoSec", GXutil.ltrim( localUtil.ntoc( wcpOA2147CliConveFondoSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICONVENIO", GXutil.rtrim( A1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICONVEVIG", localUtil.dtoc( A1575CliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV14CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormMI2( )
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
      return "Clientecct_fondoceseGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Clientecct_fondocese General", "") ;
   }

   public void wbMI0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.clientecct_fondocesegeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCliconvenio_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCliconvenio_description_Internalname, httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCliconvenio_description_Internalname, AV12CliConvenio_Description, GXutil.rtrim( localUtil.format( AV12CliConvenio_Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,14);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCliconvenio_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCliconvenio_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Clientecct_fondoceseGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveDefault_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveDefault_Internalname, httpContext.getMessage( "Fecha de vigencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveDefault_Internalname, GXutil.booltostr( A905ConveDefault), GXutil.booltostr( A905ConveDefault), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveDefault_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveDefault_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_Clientecct_fondoceseGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveFondoSec_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCliConveFondoSec_Internalname, httpContext.getMessage( "Fondo Sec", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveFondoSec_Internalname, GXutil.ltrim( localUtil.ntoc( A2147CliConveFondoSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliConveFondoSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2147CliConveFondoSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2147CliConveFondoSec), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveFondoSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveFondoSec_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Clientecct_fondoceseGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveFondoMeses_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCliConveFondoMeses_Internalname, httpContext.getMessage( "Meses desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveFondoMeses_Internalname, GXutil.ltrim( localUtil.ntoc( A2148CliConveFondoMeses, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliConveFondoMeses_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveFondoMeses_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveFondoMeses_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Clientecct_fondoceseGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveFondoPrc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCliConveFondoPrc_Internalname, httpContext.getMessage( "Porcentaje", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveFondoPrc_Internalname, GXutil.ltrim( localUtil.ntoc( A2150CliConveFondoPrc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliConveFondoPrc_Enabled!=0) ? localUtil.format( A2150CliConveFondoPrc, "9.9999") : localUtil.format( A2150CliConveFondoPrc, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveFondoPrc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveFondoPrc_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Clientecct_fondoceseGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCliConveFondoRem.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkCliConveFondoRem.getInternalname(), httpContext.getMessage( "Contemplar remunerativos", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCliConveFondoRem.getInternalname(), GXutil.booltostr( A2151CliConveFondoRem), "", httpContext.getMessage( "Contemplar remunerativos", ""), 1, chkCliConveFondoRem.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCliConveFondoNre.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkCliConveFondoNre.getInternalname(), httpContext.getMessage( "Contemplar no remunerativos", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCliConveFondoNre.getInternalname(), GXutil.booltostr( A2152CliConveFondoNre), "", httpContext.getMessage( "Contemplar no remunerativos", ""), 1, chkCliConveFondoNre.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCliConveFondoDes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkCliConveFondoDes.getInternalname(), httpContext.getMessage( "Contemplar descuentos", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCliConveFondoDes.getInternalname(), GXutil.booltostr( A2153CliConveFondoDes), "", httpContext.getMessage( "Contemplar descuentos", ""), 1, chkCliConveFondoDes.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCliConveFondoRelSec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynCliConveFondoRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCliConveFondoRelSec, dynCliConveFondoRelSec.getInternalname(), GXutil.trim( GXutil.str( A2154CliConveFondoRelSec, 6, 0)), 1, dynCliConveFondoRelSec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynCliConveFondoRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Clientecct_fondoceseGeneral.htm");
         dynCliConveFondoRelSec.setValue( GXutil.trim( GXutil.str( A2154CliConveFondoRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynCliConveFondoRelSec.getInternalname(), "Values", dynCliConveFondoRelSec.ToJavascriptSource(), true);
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
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11mi1_client"+"'", TempTags, "", 2, "HLP_Clientecct_fondoceseGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12mi1_client"+"'", TempTags, "", 2, "HLP_Clientecct_fondoceseGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Clientecct_fondoceseGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Clientecct_fondoceseGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startMI2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Clientecct_fondocese General", ""), (short)(0)) ;
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
            strupMI0( ) ;
         }
      }
   }

   public void wsMI2( )
   {
      startMI2( ) ;
      evtMI2( ) ;
   }

   public void evtMI2( )
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
                              strupMI0( ) ;
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
                              strupMI0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13MI2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupMI0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14MI2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupMI0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15MI2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupMI0( ) ;
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
                              strupMI0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavCliconvenio_description_Internalname ;
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

   public void weMI2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormMI2( ) ;
         }
      }
   }

   public void paMI2( )
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
            GX_FocusControl = edtavCliconvenio_description_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlacliconvefondorelsecMI2( int AV14CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacliconvefondorelsec_dataMI2( AV14CliCod) ;
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

   public void gxacliconvefondorelsec_htmlMI2( int AV14CliCod )
   {
      int gxdynajaxvalue;
      gxdlacliconvefondorelsec_dataMI2( AV14CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCliConveFondoRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynCliConveFondoRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacliconvefondorelsec_dataMI2( int AV14CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00MI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00MI2_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00MI2_A1880CliReDTChar[0]);
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
      A2151CliConveFondoRem = GXutil.strtobool( GXutil.booltostr( A2151CliConveFondoRem)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
      A2152CliConveFondoNre = GXutil.strtobool( GXutil.booltostr( A2152CliConveFondoNre)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
      A2153CliConveFondoDes = GXutil.strtobool( GXutil.booltostr( A2153CliConveFondoDes)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
      if ( dynCliConveFondoRelSec.getItemCount() > 0 )
      {
         A2154CliConveFondoRelSec = (int)(GXutil.lval( dynCliConveFondoRelSec.getValidValue(GXutil.trim( GXutil.str( A2154CliConveFondoRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2154CliConveFondoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2154CliConveFondoRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConveFondoRelSec.setValue( GXutil.trim( GXutil.str( A2154CliConveFondoRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynCliConveFondoRelSec.getInternalname(), "Values", dynCliConveFondoRelSec.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfMI2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV20Pgmname = "Clientecct_fondoceseGeneral" ;
      Gx_err = (short)(0) ;
      edtavCliconvenio_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCliconvenio_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliconvenio_description_Enabled), 5, 0), true);
   }

   public void rfMI2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15MI2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00MI3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2154CliConveFondoRelSec = H00MI3_A2154CliConveFondoRelSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2154CliConveFondoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2154CliConveFondoRelSec), 6, 0));
            A2153CliConveFondoDes = H00MI3_A2153CliConveFondoDes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
            A2152CliConveFondoNre = H00MI3_A2152CliConveFondoNre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
            A2151CliConveFondoRem = H00MI3_A2151CliConveFondoRem[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
            A2150CliConveFondoPrc = H00MI3_A2150CliConveFondoPrc[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2150CliConveFondoPrc", GXutil.ltrimstr( A2150CliConveFondoPrc, 6, 4));
            A2148CliConveFondoMeses = H00MI3_A2148CliConveFondoMeses[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2148CliConveFondoMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), 4, 0));
            /* Execute user event: Load */
            e14MI2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         wbMI0( ) ;
      }
   }

   public void send_integrity_lvl_hashesMI2( )
   {
   }

   public void before_start_formulas( )
   {
      AV20Pgmname = "Clientecct_fondoceseGeneral" ;
      Gx_err = (short)(0) ;
      edtavCliconvenio_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCliconvenio_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliconvenio_description_Enabled), 5, 0), true);
      /* Using cursor H00MI4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      A905ConveDefault = H00MI4_A905ConveDefault[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A905ConveDefault", A905ConveDefault);
      pr_default.close(2);
      pr_default.close(2);
      fix_multi_value_controls( ) ;
   }

   public void strupMI0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13MI2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1565CliConvenio = httpContext.cgiGet( sPrefix+"wcpOA1565CliConvenio") ;
         wcpOA1575CliConveVig = localUtil.ctod( httpContext.cgiGet( sPrefix+"wcpOA1575CliConveVig"), 0) ;
         wcpOA2147CliConveFondoSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA2147CliConveFondoSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A1575CliConveVig = localUtil.ctod( httpContext.cgiGet( sPrefix+"CLICONVEVIG"), 0) ;
         A1565CliConvenio = httpContext.cgiGet( sPrefix+"CLICONVENIO") ;
         /* Read variables values. */
         AV12CliConvenio_Description = httpContext.cgiGet( edtavCliconvenio_description_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12CliConvenio_Description", AV12CliConvenio_Description);
         A905ConveDefault = GXutil.strtobool( httpContext.cgiGet( edtConveDefault_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A905ConveDefault", A905ConveDefault);
         A2148CliConveFondoMeses = (short)(localUtil.ctol( httpContext.cgiGet( edtCliConveFondoMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2148CliConveFondoMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), 4, 0));
         A2150CliConveFondoPrc = localUtil.ctond( httpContext.cgiGet( edtCliConveFondoPrc_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2150CliConveFondoPrc", GXutil.ltrimstr( A2150CliConveFondoPrc, 6, 4));
         A2151CliConveFondoRem = GXutil.strtobool( httpContext.cgiGet( chkCliConveFondoRem.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
         A2152CliConveFondoNre = GXutil.strtobool( httpContext.cgiGet( chkCliConveFondoNre.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
         A2153CliConveFondoDes = GXutil.strtobool( httpContext.cgiGet( chkCliConveFondoDes.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
         dynCliConveFondoRelSec.setValue( httpContext.cgiGet( dynCliConveFondoRelSec.getInternalname()) );
         A2154CliConveFondoRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynCliConveFondoRelSec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2154CliConveFondoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2154CliConveFondoRelSec), 6, 0));
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
      e13MI2 ();
      if (returnInSub) return;
   }

   public void e13MI2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      clientecct_fondocesegeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_char4 = AV16Combo_DataJson ;
      GXv_char5[0] = AV17ComboSelectedValue ;
      GXv_char6[0] = AV12CliConvenio_Description ;
      GXv_char7[0] = GXt_char4 ;
      new web.clientecct_fondoceseloaddvcombo(remoteHandle, context).execute( "CliConvenio", "UPD", false, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig, A2147CliConveFondoSec, A3CliCod, A1564CliPaiConve, A1565CliConvenio, "", GXv_char5, GXv_char6, GXv_char7) ;
      clientecct_fondocesegeneral_impl.this.AV17ComboSelectedValue = GXv_char5[0] ;
      clientecct_fondocesegeneral_impl.this.AV12CliConvenio_Description = GXv_char6[0] ;
      clientecct_fondocesegeneral_impl.this.GXt_char4 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12CliConvenio_Description", AV12CliConvenio_Description);
      AV16Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV16Combo_DataJson ;
      GXv_char7[0] = AV17ComboSelectedValue ;
      GXv_char6[0] = AV12CliConvenio_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.clientecct_fondoceseloaddvcombo(remoteHandle, context).execute( "CliConvenio", "UPD", false, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig, A2147CliConveFondoSec, A3CliCod, A1564CliPaiConve, A1565CliConvenio, "", GXv_char7, GXv_char6, GXv_char5) ;
      clientecct_fondocesegeneral_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
      clientecct_fondocesegeneral_impl.this.AV12CliConvenio_Description = GXv_char6[0] ;
      clientecct_fondocesegeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12CliConvenio_Description", AV12CliConvenio_Description);
      AV16Combo_DataJson = GXt_char4 ;
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e14MI2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      GXt_boolean8 = AV13TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClientecct_fondocese_Update", GXv_boolean9) ;
      clientecct_fondocesegeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV13TempBoolean = GXt_boolean8 ;
      if ( ! ( AV13TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean8 = AV13TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClientecct_fondocese_Delete", GXv_boolean9) ;
      clientecct_fondocesegeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Clientecct_fondocese" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15MI2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      clientecct_fondocesegeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1565CliConvenio", A1565CliConvenio);
      A1575CliConveVig = (java.util.Date)getParm(obj,3,TypeConstants.DATE) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      A2147CliConveFondoSec = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
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
      paMI2( ) ;
      wsMI2( ) ;
      weMI2( ) ;
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
      sCtrlA1564CliPaiConve = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlA1565CliConvenio = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlA1575CliConveVig = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlA2147CliConveFondoSec = (String)getParm(obj,4,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paMI2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "clientecct_fondocesegeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paMI2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = (java.util.Date)getParm(obj,5,TypeConstants.DATE) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         A2147CliConveFondoSec = ((Number) GXutil.testNumericType( getParm(obj,6,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1565CliConvenio = httpContext.cgiGet( sPrefix+"wcpOA1565CliConvenio") ;
      wcpOA1575CliConveVig = localUtil.ctod( httpContext.cgiGet( sPrefix+"wcpOA1575CliConveVig"), 0) ;
      wcpOA2147CliConveFondoSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA2147CliConveFondoSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1564CliPaiConve != wcpOA1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, wcpOA1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(wcpOA1575CliConveVig)) ) || ( A2147CliConveFondoSec != wcpOA2147CliConveFondoSec ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1564CliPaiConve = A1564CliPaiConve ;
      wcpOA1565CliConvenio = A1565CliConvenio ;
      wcpOA1575CliConveVig = A1575CliConveVig ;
      wcpOA2147CliConveFondoSec = A2147CliConveFondoSec ;
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
      sCtrlA1564CliPaiConve = httpContext.cgiGet( sPrefix+"A1564CliPaiConve_CTRL") ;
      if ( GXutil.len( sCtrlA1564CliPaiConve) > 0 )
      {
         A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA1564CliPaiConve), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      else
      {
         A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1564CliPaiConve_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA1565CliConvenio = httpContext.cgiGet( sPrefix+"A1565CliConvenio_CTRL") ;
      if ( GXutil.len( sCtrlA1565CliConvenio) > 0 )
      {
         A1565CliConvenio = httpContext.cgiGet( sCtrlA1565CliConvenio) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1565CliConvenio", A1565CliConvenio);
      }
      else
      {
         A1565CliConvenio = httpContext.cgiGet( sPrefix+"A1565CliConvenio_PARM") ;
      }
      sCtrlA1575CliConveVig = httpContext.cgiGet( sPrefix+"A1575CliConveVig_CTRL") ;
      if ( GXutil.len( sCtrlA1575CliConveVig) > 0 )
      {
         A1575CliConveVig = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( sCtrlA1575CliConveVig), 0)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      }
      else
      {
         A1575CliConveVig = localUtil.ctod( httpContext.cgiGet( sPrefix+"A1575CliConveVig_PARM"), 0) ;
      }
      sCtrlA2147CliConveFondoSec = httpContext.cgiGet( sPrefix+"A2147CliConveFondoSec_CTRL") ;
      if ( GXutil.len( sCtrlA2147CliConveFondoSec) > 0 )
      {
         A2147CliConveFondoSec = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA2147CliConveFondoSec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
      }
      else
      {
         A2147CliConveFondoSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A2147CliConveFondoSec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paMI2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsMI2( ) ;
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
      wsMI2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1564CliPaiConve_PARM", GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1564CliPaiConve)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1564CliPaiConve_CTRL", GXutil.rtrim( sCtrlA1564CliPaiConve));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1565CliConvenio_PARM", GXutil.rtrim( A1565CliConvenio));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1565CliConvenio)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1565CliConvenio_CTRL", GXutil.rtrim( sCtrlA1565CliConvenio));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1575CliConveVig_PARM", localUtil.dtoc( A1575CliConveVig, 0, "/"));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1575CliConveVig)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1575CliConveVig_CTRL", GXutil.rtrim( sCtrlA1575CliConveVig));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A2147CliConveFondoSec_PARM", GXutil.ltrim( localUtil.ntoc( A2147CliConveFondoSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA2147CliConveFondoSec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A2147CliConveFondoSec_CTRL", GXutil.rtrim( sCtrlA2147CliConveFondoSec));
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
      weMI2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171326249", true, true);
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
      httpContext.AddJavascriptSource("clientecct_fondocesegeneral.js", "?2025171326249", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavCliconvenio_description_Internalname = sPrefix+"vCLICONVENIO_DESCRIPTION" ;
      edtConveDefault_Internalname = sPrefix+"CONVEDEFAULT" ;
      edtCliConveFondoSec_Internalname = sPrefix+"CLICONVEFONDOSEC" ;
      edtCliConveFondoMeses_Internalname = sPrefix+"CLICONVEFONDOMESES" ;
      edtCliConveFondoPrc_Internalname = sPrefix+"CLICONVEFONDOPRC" ;
      chkCliConveFondoRem.setInternalname( sPrefix+"CLICONVEFONDOREM" );
      chkCliConveFondoNre.setInternalname( sPrefix+"CLICONVEFONDONRE" );
      chkCliConveFondoDes.setInternalname( sPrefix+"CLICONVEFONDODES" );
      dynCliConveFondoRelSec.setInternalname( sPrefix+"CLICONVEFONDORELSEC" );
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtCliPaiConve_Internalname = sPrefix+"CLIPAICONVE" ;
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
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      dynCliConveFondoRelSec.setJsonclick( "" );
      dynCliConveFondoRelSec.setEnabled( 0 );
      chkCliConveFondoDes.setEnabled( 0 );
      chkCliConveFondoNre.setEnabled( 0 );
      chkCliConveFondoRem.setEnabled( 0 );
      edtCliConveFondoPrc_Jsonclick = "" ;
      edtCliConveFondoPrc_Enabled = 0 ;
      edtCliConveFondoMeses_Jsonclick = "" ;
      edtCliConveFondoMeses_Enabled = 0 ;
      edtCliConveFondoSec_Jsonclick = "" ;
      edtCliConveFondoSec_Enabled = 0 ;
      edtConveDefault_Jsonclick = "" ;
      edtConveDefault_Enabled = 0 ;
      edtavCliconvenio_description_Jsonclick = "" ;
      edtavCliconvenio_description_Enabled = 1 ;
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
      chkCliConveFondoRem.setName( "CLICONVEFONDOREM" );
      chkCliConveFondoRem.setWebtags( "" );
      chkCliConveFondoRem.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCliConveFondoRem.getInternalname(), "TitleCaption", chkCliConveFondoRem.getCaption(), true);
      chkCliConveFondoRem.setCheckedValue( "false" );
      chkCliConveFondoNre.setName( "CLICONVEFONDONRE" );
      chkCliConveFondoNre.setWebtags( "" );
      chkCliConveFondoNre.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCliConveFondoNre.getInternalname(), "TitleCaption", chkCliConveFondoNre.getCaption(), true);
      chkCliConveFondoNre.setCheckedValue( "false" );
      chkCliConveFondoDes.setName( "CLICONVEFONDODES" );
      chkCliConveFondoDes.setWebtags( "" );
      chkCliConveFondoDes.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCliConveFondoDes.getInternalname(), "TitleCaption", chkCliConveFondoDes.getCaption(), true);
      chkCliConveFondoDes.setCheckedValue( "false" );
      dynCliConveFondoRelSec.setName( "CLICONVEFONDORELSEC" );
      dynCliConveFondoRelSec.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''},{av:'A2147CliConveFondoSec',fld:'CLICONVEFONDOSEC',pic:'ZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11MI1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''},{av:'A2147CliConveFondoSec',fld:'CLICONVEFONDOSEC',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12MI1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''},{av:'A2147CliConveFondoSec',fld:'CLICONVEFONDOSEC',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CLICONVEFONDOSEC","{handler:'valid_Cliconvefondosec',iparms:[]");
      setEventMetadata("VALID_CLICONVEFONDOSEC",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[]}");
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
      wcpOA1565CliConvenio = "" ;
      wcpOA1575CliConveVig = GXutil.nullDate() ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      TempTags = "" ;
      AV12CliConvenio_Description = "" ;
      A2150CliConveFondoPrc = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
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
      H00MI2_A3CliCod = new int[1] ;
      H00MI2_A1885CliRelSec = new int[1] ;
      H00MI2_A1880CliReDTChar = new String[] {""} ;
      AV20Pgmname = "" ;
      H00MI3_A3CliCod = new int[1] ;
      H00MI3_A1564CliPaiConve = new short[1] ;
      H00MI3_A1565CliConvenio = new String[] {""} ;
      H00MI3_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      H00MI3_A2147CliConveFondoSec = new short[1] ;
      H00MI3_A2154CliConveFondoRelSec = new int[1] ;
      H00MI3_A2153CliConveFondoDes = new boolean[] {false} ;
      H00MI3_A2152CliConveFondoNre = new boolean[] {false} ;
      H00MI3_A2151CliConveFondoRem = new boolean[] {false} ;
      H00MI3_A2150CliConveFondoPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00MI3_A2148CliConveFondoMeses = new short[1] ;
      H00MI3_A905ConveDefault = new boolean[] {false} ;
      H00MI4_A905ConveDefault = new boolean[] {false} ;
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
      sCtrlA1564CliPaiConve = "" ;
      sCtrlA1565CliConvenio = "" ;
      sCtrlA1575CliConveVig = "" ;
      sCtrlA2147CliConveFondoSec = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientecct_fondocesegeneral__default(),
         new Object[] {
             new Object[] {
            H00MI2_A3CliCod, H00MI2_A1885CliRelSec, H00MI2_A1880CliReDTChar
            }
            , new Object[] {
            H00MI3_A3CliCod, H00MI3_A1564CliPaiConve, H00MI3_A1565CliConvenio, H00MI3_A1575CliConveVig, H00MI3_A2147CliConveFondoSec, H00MI3_A2154CliConveFondoRelSec, H00MI3_A2153CliConveFondoDes, H00MI3_A2152CliConveFondoNre, H00MI3_A2151CliConveFondoRem, H00MI3_A2150CliConveFondoPrc,
            H00MI3_A2148CliConveFondoMeses, H00MI3_A905ConveDefault
            }
            , new Object[] {
            H00MI4_A905ConveDefault
            }
         }
      );
      AV20Pgmname = "Clientecct_fondoceseGeneral" ;
      /* GeneXus formulas. */
      AV20Pgmname = "Clientecct_fondoceseGeneral" ;
      Gx_err = (short)(0) ;
      edtavCliconvenio_description_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1564CliPaiConve ;
   private short wcpOA2147CliConveFondoSec ;
   private short A1564CliPaiConve ;
   private short A2147CliConveFondoSec ;
   private short wbEnd ;
   private short wbStart ;
   private short A2148CliConveFondoMeses ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int AV14CliCod ;
   private int edtavCliconvenio_description_Enabled ;
   private int edtConveDefault_Enabled ;
   private int edtCliConveFondoSec_Enabled ;
   private int edtCliConveFondoMeses_Enabled ;
   private int edtCliConveFondoPrc_Enabled ;
   private int A2154CliConveFondoRelSec ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtCliPaiConve_Visible ;
   private int gxdynajaxindex ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private java.math.BigDecimal A2150CliConveFondoPrc ;
   private String wcpOA1565CliConvenio ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A1565CliConvenio ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtavCliconvenio_description_Internalname ;
   private String TempTags ;
   private String edtavCliconvenio_description_Jsonclick ;
   private String edtConveDefault_Internalname ;
   private String edtConveDefault_Jsonclick ;
   private String edtCliConveFondoSec_Internalname ;
   private String edtCliConveFondoSec_Jsonclick ;
   private String edtCliConveFondoMeses_Internalname ;
   private String edtCliConveFondoMeses_Jsonclick ;
   private String edtCliConveFondoPrc_Internalname ;
   private String edtCliConveFondoPrc_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV20Pgmname ;
   private String GXt_char4 ;
   private String GXv_char7[] ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1564CliPaiConve ;
   private String sCtrlA1565CliConvenio ;
   private String sCtrlA1575CliConveVig ;
   private String sCtrlA2147CliConveFondoSec ;
   private java.util.Date wcpOA1575CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A905ConveDefault ;
   private boolean A2151CliConveFondoRem ;
   private boolean A2152CliConveFondoNre ;
   private boolean A2153CliConveFondoDes ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV13TempBoolean ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private String AV16Combo_DataJson ;
   private String AV12CliConvenio_Description ;
   private String AV17ComboSelectedValue ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private ICheckbox chkCliConveFondoRem ;
   private ICheckbox chkCliConveFondoNre ;
   private ICheckbox chkCliConveFondoDes ;
   private HTMLChoice dynCliConveFondoRelSec ;
   private IDataStoreProvider pr_default ;
   private int[] H00MI2_A3CliCod ;
   private int[] H00MI2_A1885CliRelSec ;
   private String[] H00MI2_A1880CliReDTChar ;
   private int[] H00MI3_A3CliCod ;
   private short[] H00MI3_A1564CliPaiConve ;
   private String[] H00MI3_A1565CliConvenio ;
   private java.util.Date[] H00MI3_A1575CliConveVig ;
   private short[] H00MI3_A2147CliConveFondoSec ;
   private int[] H00MI3_A2154CliConveFondoRelSec ;
   private boolean[] H00MI3_A2153CliConveFondoDes ;
   private boolean[] H00MI3_A2152CliConveFondoNre ;
   private boolean[] H00MI3_A2151CliConveFondoRem ;
   private java.math.BigDecimal[] H00MI3_A2150CliConveFondoPrc ;
   private short[] H00MI3_A2148CliConveFondoMeses ;
   private boolean[] H00MI3_A905ConveDefault ;
   private boolean[] H00MI4_A905ConveDefault ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class clientecct_fondocesegeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00MI2", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MI3", "SELECT T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CliConveVig, T1.CliConveFondoSec, T1.CliConveFondoRelSec, T1.CliConveFondoDes, T1.CliConveFondoNre, T1.CliConveFondoRem, T1.CliConveFondoPrc, T1.CliConveFondoMeses, T2.ConveDefault FROM (Clientecct_fondocese T1 INNER JOIN ClienteConvenio_Particularidades T2 ON T2.CliCod = T1.CliCod AND T2.CliPaiConve = T1.CliPaiConve AND T2.CliConvenio = T1.CliConvenio AND T2.CliConveVig = T1.CliConveVig) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) and T1.CliConveVig = ? and T1.CliConveFondoSec = ? ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CliConveVig, T1.CliConveFondoSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00MI4", "SELECT ConveDefault FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,4);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               return;
            case 2 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

