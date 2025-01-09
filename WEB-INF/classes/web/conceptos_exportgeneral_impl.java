package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptos_exportgeneral_impl extends GXWebComponent
{
   public conceptos_exportgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptos_exportgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptos_exportgeneral_impl.class ));
   }

   public conceptos_exportgeneral_impl( int remoteHandle ,
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
      cmbConVigencia = new HTMLChoice();
      chkConVariable = UIFactory.getCheckbox(this);
      chkConForEditable = UIFactory.getCheckbox(this);
      chkConRecalcular = UIFactory.getCheckbox(this);
      chkConMostrarPos = UIFactory.getCheckbox(this);
      cmbConAdelDescu = new HTMLChoice();
      chkConSegunPla = UIFactory.getCheckbox(this);
      cmbConSacDeven = new HTMLChoice();
      cmbConBaseLic = new HTMLChoice();
      cmbConBaseFer = new HTMLChoice();
      cmbConBaseHorExt = new HTMLChoice();
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
         paID2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Conceptos_export General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptos_exportgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A26ConCodigo))}, new String[] {"CliCod","ConCodigo"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA26ConCodigo", GXutil.rtrim( wcpOA26ConCodigo));
   }

   public void renderHtmlCloseFormID2( )
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
      return "Conceptos_exportGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Conceptos_export General", "") ;
   }

   public void wbID0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.conceptos_exportgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliCod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cli Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_Conceptos_exportGeneral.htm");
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
         web.GxWebStd.gx_html_textarea( httpContext, edtConDescrip_Internalname, A41ConDescrip, "", "", (short)(0), 1, edtConDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConOrden_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConOrden_Internalname, httpContext.getMessage( "Orden", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConOrden_Internalname, GXutil.ltrim( localUtil.ntoc( A40ConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConOrden_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A40ConOrden), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A40ConOrden), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConOrden_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConOrden_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
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
         web.GxWebStd.gx_label_element( httpContext, cmbConVigencia.getInternalname(), httpContext.getMessage( "Vigencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConVigencia, cmbConVigencia.getInternalname(), GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)), 1, cmbConVigencia.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConVigencia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Conceptos_exportGeneral.htm");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConLiqBasica_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConLiqBasica_Internalname, httpContext.getMessage( "Basica (borrar)", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConLiqBasica_Internalname, GXutil.ltrim( localUtil.ntoc( A1488ConLiqBasica, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConLiqBasica_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1488ConLiqBasica), "9") : localUtil.format( DecimalUtil.doubleToDec(A1488ConLiqBasica), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConLiqBasica_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConLiqBasica_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFormula_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConFormula_Internalname, httpContext.getMessage( "Formula", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtConFormula_Internalname, A148ConFormula, "", "", (short)(0), 1, edtConFormula_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_exportGeneral.htm");
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
         web.GxWebStd.gx_html_textarea( httpContext, edtConObservacion_Internalname, A153ConObservacion, "", "", (short)(0), 1, edtConObservacion_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConVariable.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConVariable.getInternalname(), httpContext.getMessage( "Remuneración variable", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConVariable.getInternalname(), GXutil.booltostr( A159ConVariable), "", httpContext.getMessage( "Remuneración variable", ""), 1, chkConVariable.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConForEditable.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConForEditable.getInternalname(), httpContext.getMessage( "Editable (borrar)", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConForEditable.getInternalname(), GXutil.booltostr( A146ConForEditable), "", httpContext.getMessage( "Editable (borrar)", ""), 1, chkConForEditable.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoConDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtTipoConDescrip_Internalname, httpContext.getMessage( "Tipo De Concepto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtTipoConDescrip_Internalname, A370TipoConDescrip, edtTipoConDescrip_Link, "", (short)(0), 1, edtTipoConDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSubTipoConDes1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtSubTipoConDes1_Internalname, httpContext.getMessage( "Tipo De Concepto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtSubTipoConDes1_Internalname, A371SubTipoConDes1, "", "", (short)(0), 1, edtSubTipoConDes1_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSubTipoConDes2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtSubTipoConDes2_Internalname, httpContext.getMessage( "Tipo De Concepto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtSubTipoConDes2_Internalname, A372SubTipoConDes2, "", "", (short)(0), 1, edtSubTipoConDes2_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConTipoLiqAux_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConTipoLiqAux_Internalname, httpContext.getMessage( "Liq Aux", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConTipoLiqAux_Internalname, A503ConTipoLiqAux, GXutil.rtrim( localUtil.format( A503ConTipoLiqAux, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConTipoLiqAux_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConTipoLiqAux_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConClasifAux_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConClasifAux_Internalname, httpContext.getMessage( "Clasificación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConClasifAux_Internalname, A970ConClasifAux, GXutil.rtrim( localUtil.format( A970ConClasifAux, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConClasifAux_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConClasifAux_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConOrdEjec_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConOrdEjec_Internalname, httpContext.getMessage( "Ord Ejec", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConOrdEjec_Internalname, GXutil.ltrim( localUtil.ntoc( A510ConOrdEjec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConOrdEjec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A510ConOrdEjec), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A510ConOrdEjec), "ZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConOrdEjec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConOrdEjec_Enabled, 0, "text", "1", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFormulaExpl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConFormulaExpl_Internalname, httpContext.getMessage( "Formula Expl", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtConFormulaExpl_Internalname, A569ConFormulaExpl, "", "", (short)(0), 1, edtConFormulaExpl_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_exportGeneral.htm");
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
         web.GxWebStd.gx_label_element( httpContext, chkConRecalcular.getInternalname(), httpContext.getMessage( "Recalcular por impuesto a las ganancias", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConRecalcular.getInternalname(), GXutil.booltostr( A762ConRecalcular), "", httpContext.getMessage( "Recalcular por impuesto a las ganancias", ""), 1, chkConRecalcular.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
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
         web.GxWebStd.gx_html_textarea( httpContext, edtConRangoCant_Internalname, A1018ConRangoCant, "", "", (short)(0), 1, edtConRangoCant_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCondicionDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCondicionDescrip_Internalname, httpContext.getMessage( "Condición para liquidación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtCondicionDescrip_Internalname, A1758CondicionDescrip, "", "", (short)(0), 1, edtCondicionDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCondCodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConCondCodigo_Internalname, httpContext.getMessage( "Código relacionado a la condición", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConCondCodigo_Internalname, GXutil.rtrim( A954ConCondCodigo), GXutil.rtrim( localUtil.format( A954ConCondCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCondCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCondCodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConMostrarPos.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConMostrarPos.getInternalname(), httpContext.getMessage( "Mostrar en recibo solo si es mayor a cero", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConMostrarPos.getInternalname(), GXutil.booltostr( A1068ConMostrarPos), "", httpContext.getMessage( "Mostrar en recibo solo si es mayor a cero", ""), 1, chkConMostrarPos.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
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
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAdelDescu, cmbConAdelDescu.getInternalname(), GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)), 1, cmbConAdelDescu.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConAdelDescu.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Conceptos_exportGeneral.htm");
         cmbConAdelDescu.setValue( GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConAdelDescu.getInternalname(), "Values", cmbConAdelDescu.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGG_Internalname, GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAplIIGG_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1112AplIIGG), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1112AplIIGG), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGG_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAplIIGG_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConSegunPla.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConSegunPla.getInternalname(), httpContext.getMessage( "Si no se cumple la condición, liquidar en segundo plano a posteriori", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConSegunPla.getInternalname(), GXutil.booltostr( A1194ConSegunPla), "", httpContext.getMessage( "Si no se cumple la condición, liquidar en segundo plano a posteriori", ""), 1, chkConSegunPla.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConNumero_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConNumero_Internalname, httpContext.getMessage( "Numero", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A1471ConNumero, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1471ConNumero), "9") : localUtil.format( DecimalUtil.doubleToDec(A1471ConNumero), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConNumero_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCodAfip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConCodAfip_Internalname, httpContext.getMessage( "Concepto AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConCodAfip_Internalname, GXutil.rtrim( A1648ConCodAfip), GXutil.rtrim( localUtil.format( A1648ConCodAfip, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodAfip_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodAfip_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConSIPAApo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConSIPAApo_Internalname, httpContext.getMessage( "SIPAApo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConSIPAApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1472ConSIPAApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConSIPAApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1472ConSIPAApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1472ConSIPAApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConSIPAApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConSIPAApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConSIPACont_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConSIPACont_Internalname, httpContext.getMessage( "SIPACont", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConSIPACont_Internalname, GXutil.ltrim( localUtil.ntoc( A1473ConSIPACont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConSIPACont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1473ConSIPACont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1473ConSIPACont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConSIPACont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConSIPACont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConINSSJyPApo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConINSSJyPApo_Internalname, httpContext.getMessage( "INSSJy PApo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConINSSJyPApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1474ConINSSJyPApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConINSSJyPApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1474ConINSSJyPApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1474ConINSSJyPApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConINSSJyPApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConINSSJyPApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConINSSJyPCont_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConINSSJyPCont_Internalname, httpContext.getMessage( "INSSJy PCont", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConINSSJyPCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1475ConINSSJyPCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConINSSJyPCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1475ConINSSJyPCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1475ConINSSJyPCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConINSSJyPCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConINSSJyPCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConObraSocApo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConObraSocApo_Internalname, httpContext.getMessage( "Soc Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConObraSocApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1476ConObraSocApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConObraSocApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1476ConObraSocApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1476ConObraSocApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConObraSocApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConObraSocApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConObraSocCont_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConObraSocCont_Internalname, httpContext.getMessage( "Soc Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConObraSocCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1477ConObraSocCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConObraSocCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1477ConObraSocCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1477ConObraSocCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConObraSocCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConObraSocCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFonSolRedApo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConFonSolRedApo_Internalname, httpContext.getMessage( "Red Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConFonSolRedApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1478ConFonSolRedApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConFonSolRedApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1478ConFonSolRedApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1478ConFonSolRedApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConFonSolRedApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConFonSolRedApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFonSolRedCont_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConFonSolRedCont_Internalname, httpContext.getMessage( "Red Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConFonSolRedCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1479ConFonSolRedCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConFonSolRedCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1479ConFonSolRedCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1479ConFonSolRedCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConFonSolRedCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConFonSolRedCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConRenateaApo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConRenateaApo_Internalname, httpContext.getMessage( "Renatea Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConRenateaApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1480ConRenateaApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConRenateaApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1480ConRenateaApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1480ConRenateaApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConRenateaApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConRenateaApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConRenateaCont_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConRenateaCont_Internalname, httpContext.getMessage( "Renatea Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConRenateaCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1481ConRenateaCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConRenateaCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1481ConRenateaCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1481ConRenateaCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConRenateaCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConRenateaCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConAsigFamCont_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConAsigFamCont_Internalname, httpContext.getMessage( "Fam Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConAsigFamCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1482ConAsigFamCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConAsigFamCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1482ConAsigFamCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1482ConAsigFamCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConAsigFamCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConAsigFamCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFonNacEmpCont_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConFonNacEmpCont_Internalname, httpContext.getMessage( "Emp Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConFonNacEmpCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1483ConFonNacEmpCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConFonNacEmpCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1483ConFonNacEmpCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1483ConFonNacEmpCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConFonNacEmpCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConFonNacEmpCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConLeyRieTrabCont_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConLeyRieTrabCont_Internalname, httpContext.getMessage( "Trab Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConLeyRieTrabCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1484ConLeyRieTrabCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConLeyRieTrabCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1484ConLeyRieTrabCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1484ConLeyRieTrabCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConLeyRieTrabCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConLeyRieTrabCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConRegDifApo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConRegDifApo_Internalname, httpContext.getMessage( "Dif Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConRegDifApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1485ConRegDifApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConRegDifApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1485ConRegDifApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1485ConRegDifApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConRegDifApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConRegDifApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConRegEspApo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConRegEspApo_Internalname, httpContext.getMessage( "Esp Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConRegEspApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1486ConRegEspApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConRegEspApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1486ConRegEspApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1486ConRegEspApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConRegEspApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConRegEspApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConSacDeven.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConSacDeven.getInternalname(), httpContext.getMessage( "Tipo devengamiento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConSacDeven, cmbConSacDeven.getInternalname(), GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0)), 1, cmbConSacDeven.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConSacDeven.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Conceptos_exportGeneral.htm");
         cmbConSacDeven.setValue( GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConSacDeven.getInternalname(), "Values", cmbConSacDeven.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConceptoPais_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConceptoPais_Internalname, httpContext.getMessage( "Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConceptoPais_Internalname, GXutil.ltrim( localUtil.ntoc( A1644ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConceptoPais_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1644ConceptoPais), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1644ConceptoPais), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConceptoPais_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConceptoPais_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConceptoConveCodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConceptoConveCodigo_Internalname, httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConceptoConveCodigo_Internalname, GXutil.rtrim( A1645ConceptoConveCodigo), GXutil.rtrim( localUtil.format( A1645ConceptoConveCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConceptoConveCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConceptoConveCodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConBaseLic.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConBaseLic.getInternalname(), httpContext.getMessage( "Base de cálculo para licencias de remuneraciòn actual", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConBaseLic, cmbConBaseLic.getInternalname(), GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0)), 1, cmbConBaseLic.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConBaseLic.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Conceptos_exportGeneral.htm");
         cmbConBaseLic.setValue( GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConBaseLic.getInternalname(), "Values", cmbConBaseLic.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConBaseFer.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConBaseFer.getInternalname(), httpContext.getMessage( "Base de cálculo para feriados de remuneración actual", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConBaseFer, cmbConBaseFer.getInternalname(), GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0)), 1, cmbConBaseFer.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConBaseFer.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Conceptos_exportGeneral.htm");
         cmbConBaseFer.setValue( GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConBaseFer.getInternalname(), "Values", cmbConBaseFer.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConBaseHorExt.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConBaseHorExt.getInternalname(), httpContext.getMessage( "Base de cálculo para horas extras de remuneración actual", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConBaseHorExt, cmbConBaseHorExt.getInternalname(), GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0)), 1, cmbConBaseHorExt.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConBaseHorExt.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Conceptos_exportGeneral.htm");
         cmbConBaseHorExt.setValue( GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConBaseHorExt.getInternalname(), "Values", cmbConBaseHorExt.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 254,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11id1_client"+"'", TempTags, "", 2, "HLP_Conceptos_exportGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 256,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12id1_client"+"'", TempTags, "", 2, "HLP_Conceptos_exportGeneral.htm");
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

   public void startID2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Conceptos_export General", ""), (short)(0)) ;
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
            strupID0( ) ;
         }
      }
   }

   public void wsID2( )
   {
      startID2( ) ;
      evtID2( ) ;
   }

   public void evtID2( )
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
                              strupID0( ) ;
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
                              strupID0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13ID2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupID0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14ID2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupID0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15ID2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupID0( ) ;
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
                              strupID0( ) ;
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

   public void weID2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormID2( ) ;
         }
      }
   }

   public void paID2( )
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
      A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A159ConVariable", A159ConVariable);
      A146ConForEditable = GXutil.strtobool( GXutil.booltostr( A146ConForEditable)) ;
      n146ConForEditable = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A146ConForEditable", A146ConForEditable);
      A762ConRecalcular = GXutil.strtobool( GXutil.booltostr( A762ConRecalcular)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A762ConRecalcular", A762ConRecalcular);
      A1068ConMostrarPos = GXutil.strtobool( GXutil.booltostr( A1068ConMostrarPos)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1068ConMostrarPos", A1068ConMostrarPos);
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
      A1194ConSegunPla = GXutil.strtobool( GXutil.booltostr( A1194ConSegunPla)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1194ConSegunPla", A1194ConSegunPla);
      if ( cmbConSacDeven.getItemCount() > 0 )
      {
         A1539ConSacDeven = (byte)(GXutil.lval( cmbConSacDeven.getValidValue(GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1539ConSacDeven", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1539ConSacDeven), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConSacDeven.setValue( GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConSacDeven.getInternalname(), "Values", cmbConSacDeven.ToJavascriptSource(), true);
      }
      if ( cmbConBaseLic.getItemCount() > 0 )
      {
         A1620ConBaseLic = (byte)(GXutil.lval( cmbConBaseLic.getValidValue(GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConBaseLic.setValue( GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConBaseLic.getInternalname(), "Values", cmbConBaseLic.ToJavascriptSource(), true);
      }
      if ( cmbConBaseFer.getItemCount() > 0 )
      {
         A1621ConBaseFer = (byte)(GXutil.lval( cmbConBaseFer.getValidValue(GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConBaseFer.setValue( GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConBaseFer.getInternalname(), "Values", cmbConBaseFer.ToJavascriptSource(), true);
      }
      if ( cmbConBaseHorExt.getItemCount() > 0 )
      {
         A1622ConBaseHorExt = (byte)(GXutil.lval( cmbConBaseHorExt.getValidValue(GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConBaseHorExt.setValue( GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConBaseHorExt.getInternalname(), "Values", cmbConBaseHorExt.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfID2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "Conceptos_exportGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfID2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15ID2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00ID2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A38SubTipoConCod1 = H00ID2_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = H00ID2_n38SubTipoConCod1[0] ;
            A39SubTipoConCod2 = H00ID2_A39SubTipoConCod2[0] ;
            n39SubTipoConCod2 = H00ID2_n39SubTipoConCod2[0] ;
            A953ConCondicion = H00ID2_A953ConCondicion[0] ;
            n953ConCondicion = H00ID2_n953ConCondicion[0] ;
            A37TipoConCod = H00ID2_A37TipoConCod[0] ;
            A1622ConBaseHorExt = H00ID2_A1622ConBaseHorExt[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
            A1621ConBaseFer = H00ID2_A1621ConBaseFer[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
            A1620ConBaseLic = H00ID2_A1620ConBaseLic[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
            A1645ConceptoConveCodigo = H00ID2_A1645ConceptoConveCodigo[0] ;
            n1645ConceptoConveCodigo = H00ID2_n1645ConceptoConveCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1645ConceptoConveCodigo", A1645ConceptoConveCodigo);
            A1644ConceptoPais = H00ID2_A1644ConceptoPais[0] ;
            n1644ConceptoPais = H00ID2_n1644ConceptoPais[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
            A1539ConSacDeven = H00ID2_A1539ConSacDeven[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1539ConSacDeven", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1539ConSacDeven), 2, 0));
            A1486ConRegEspApo = H00ID2_A1486ConRegEspApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1486ConRegEspApo", GXutil.str( A1486ConRegEspApo, 1, 0));
            A1485ConRegDifApo = H00ID2_A1485ConRegDifApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1485ConRegDifApo", GXutil.str( A1485ConRegDifApo, 1, 0));
            A1484ConLeyRieTrabCont = H00ID2_A1484ConLeyRieTrabCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1484ConLeyRieTrabCont", GXutil.str( A1484ConLeyRieTrabCont, 1, 0));
            A1483ConFonNacEmpCont = H00ID2_A1483ConFonNacEmpCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1483ConFonNacEmpCont", GXutil.str( A1483ConFonNacEmpCont, 1, 0));
            A1482ConAsigFamCont = H00ID2_A1482ConAsigFamCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1482ConAsigFamCont", GXutil.str( A1482ConAsigFamCont, 1, 0));
            A1481ConRenateaCont = H00ID2_A1481ConRenateaCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1481ConRenateaCont", GXutil.str( A1481ConRenateaCont, 1, 0));
            A1480ConRenateaApo = H00ID2_A1480ConRenateaApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1480ConRenateaApo", GXutil.str( A1480ConRenateaApo, 1, 0));
            A1479ConFonSolRedCont = H00ID2_A1479ConFonSolRedCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1479ConFonSolRedCont", GXutil.str( A1479ConFonSolRedCont, 1, 0));
            A1478ConFonSolRedApo = H00ID2_A1478ConFonSolRedApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1478ConFonSolRedApo", GXutil.str( A1478ConFonSolRedApo, 1, 0));
            A1477ConObraSocCont = H00ID2_A1477ConObraSocCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1477ConObraSocCont", GXutil.str( A1477ConObraSocCont, 1, 0));
            A1476ConObraSocApo = H00ID2_A1476ConObraSocApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1476ConObraSocApo", GXutil.str( A1476ConObraSocApo, 1, 0));
            A1475ConINSSJyPCont = H00ID2_A1475ConINSSJyPCont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1475ConINSSJyPCont", GXutil.str( A1475ConINSSJyPCont, 1, 0));
            A1474ConINSSJyPApo = H00ID2_A1474ConINSSJyPApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1474ConINSSJyPApo", GXutil.str( A1474ConINSSJyPApo, 1, 0));
            A1473ConSIPACont = H00ID2_A1473ConSIPACont[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1473ConSIPACont", GXutil.str( A1473ConSIPACont, 1, 0));
            A1472ConSIPAApo = H00ID2_A1472ConSIPAApo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1472ConSIPAApo", GXutil.str( A1472ConSIPAApo, 1, 0));
            A1648ConCodAfip = H00ID2_A1648ConCodAfip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1648ConCodAfip", A1648ConCodAfip);
            A1471ConNumero = H00ID2_A1471ConNumero[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1471ConNumero", GXutil.str( A1471ConNumero, 1, 0));
            A1194ConSegunPla = H00ID2_A1194ConSegunPla[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1194ConSegunPla", A1194ConSegunPla);
            A1112AplIIGG = H00ID2_A1112AplIIGG[0] ;
            n1112AplIIGG = H00ID2_n1112AplIIGG[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
            A1077ConAdelDescu = H00ID2_A1077ConAdelDescu[0] ;
            n1077ConAdelDescu = H00ID2_n1077ConAdelDescu[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
            A1068ConMostrarPos = H00ID2_A1068ConMostrarPos[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1068ConMostrarPos", A1068ConMostrarPos);
            A954ConCondCodigo = H00ID2_A954ConCondCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A954ConCondCodigo", A954ConCondCodigo);
            A1758CondicionDescrip = H00ID2_A1758CondicionDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1758CondicionDescrip", A1758CondicionDescrip);
            A1018ConRangoCant = H00ID2_A1018ConRangoCant[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1018ConRangoCant", A1018ConRangoCant);
            A762ConRecalcular = H00ID2_A762ConRecalcular[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A762ConRecalcular", A762ConRecalcular);
            A569ConFormulaExpl = H00ID2_A569ConFormulaExpl[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A569ConFormulaExpl", A569ConFormulaExpl);
            A510ConOrdEjec = H00ID2_A510ConOrdEjec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A510ConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A510ConOrdEjec), 12, 0));
            A970ConClasifAux = H00ID2_A970ConClasifAux[0] ;
            n970ConClasifAux = H00ID2_n970ConClasifAux[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A970ConClasifAux", A970ConClasifAux);
            A503ConTipoLiqAux = H00ID2_A503ConTipoLiqAux[0] ;
            n503ConTipoLiqAux = H00ID2_n503ConTipoLiqAux[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A503ConTipoLiqAux", A503ConTipoLiqAux);
            A372SubTipoConDes2 = H00ID2_A372SubTipoConDes2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A372SubTipoConDes2", A372SubTipoConDes2);
            A371SubTipoConDes1 = H00ID2_A371SubTipoConDes1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A371SubTipoConDes1", A371SubTipoConDes1);
            A370TipoConDescrip = H00ID2_A370TipoConDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A370TipoConDescrip", A370TipoConDescrip);
            A146ConForEditable = H00ID2_A146ConForEditable[0] ;
            n146ConForEditable = H00ID2_n146ConForEditable[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A146ConForEditable", A146ConForEditable);
            A159ConVariable = H00ID2_A159ConVariable[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A159ConVariable", A159ConVariable);
            A153ConObservacion = H00ID2_A153ConObservacion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A153ConObservacion", A153ConObservacion);
            A148ConFormula = H00ID2_A148ConFormula[0] ;
            n148ConFormula = H00ID2_n148ConFormula[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A148ConFormula", A148ConFormula);
            A1488ConLiqBasica = H00ID2_A1488ConLiqBasica[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1488ConLiqBasica", GXutil.str( A1488ConLiqBasica, 1, 0));
            A162ConVigencia = H00ID2_A162ConVigencia[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
            A40ConOrden = H00ID2_A40ConOrden[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40ConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40ConOrden), 8, 0));
            A41ConDescrip = H00ID2_A41ConDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A41ConDescrip", A41ConDescrip);
            A1758CondicionDescrip = H00ID2_A1758CondicionDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1758CondicionDescrip", A1758CondicionDescrip);
            A370TipoConDescrip = H00ID2_A370TipoConDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A370TipoConDescrip", A370TipoConDescrip);
            A371SubTipoConDes1 = H00ID2_A371SubTipoConDes1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A371SubTipoConDes1", A371SubTipoConDes1);
            A372SubTipoConDes2 = H00ID2_A372SubTipoConDes2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A372SubTipoConDes2", A372SubTipoConDes2);
            /* Execute user event: Load */
            e14ID2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wbID0( ) ;
      }
   }

   public void send_integrity_lvl_hashesID2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "Conceptos_exportGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupID0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13ID2 ();
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
         A41ConDescrip = httpContext.cgiGet( edtConDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A41ConDescrip", A41ConDescrip);
         A40ConOrden = (int)(localUtil.ctol( httpContext.cgiGet( edtConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40ConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40ConOrden), 8, 0));
         cmbConVigencia.setValue( httpContext.cgiGet( cmbConVigencia.getInternalname()) );
         A162ConVigencia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConVigencia.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
         A1488ConLiqBasica = (byte)(localUtil.ctol( httpContext.cgiGet( edtConLiqBasica_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1488ConLiqBasica", GXutil.str( A1488ConLiqBasica, 1, 0));
         A148ConFormula = httpContext.cgiGet( edtConFormula_Internalname) ;
         n148ConFormula = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A148ConFormula", A148ConFormula);
         A153ConObservacion = httpContext.cgiGet( edtConObservacion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A153ConObservacion", A153ConObservacion);
         A159ConVariable = GXutil.strtobool( httpContext.cgiGet( chkConVariable.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A159ConVariable", A159ConVariable);
         A146ConForEditable = GXutil.strtobool( httpContext.cgiGet( chkConForEditable.getInternalname())) ;
         n146ConForEditable = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A146ConForEditable", A146ConForEditable);
         A370TipoConDescrip = httpContext.cgiGet( edtTipoConDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A370TipoConDescrip", A370TipoConDescrip);
         A371SubTipoConDes1 = httpContext.cgiGet( edtSubTipoConDes1_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A371SubTipoConDes1", A371SubTipoConDes1);
         A372SubTipoConDes2 = httpContext.cgiGet( edtSubTipoConDes2_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A372SubTipoConDes2", A372SubTipoConDes2);
         A503ConTipoLiqAux = httpContext.cgiGet( edtConTipoLiqAux_Internalname) ;
         n503ConTipoLiqAux = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A503ConTipoLiqAux", A503ConTipoLiqAux);
         A970ConClasifAux = httpContext.cgiGet( edtConClasifAux_Internalname) ;
         n970ConClasifAux = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A970ConClasifAux", A970ConClasifAux);
         A510ConOrdEjec = localUtil.ctol( httpContext.cgiGet( edtConOrdEjec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A510ConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A510ConOrdEjec), 12, 0));
         A569ConFormulaExpl = httpContext.cgiGet( edtConFormulaExpl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A569ConFormulaExpl", A569ConFormulaExpl);
         A762ConRecalcular = GXutil.strtobool( httpContext.cgiGet( chkConRecalcular.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A762ConRecalcular", A762ConRecalcular);
         A1018ConRangoCant = httpContext.cgiGet( edtConRangoCant_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1018ConRangoCant", A1018ConRangoCant);
         A1758CondicionDescrip = httpContext.cgiGet( edtCondicionDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1758CondicionDescrip", A1758CondicionDescrip);
         A954ConCondCodigo = httpContext.cgiGet( edtConCondCodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A954ConCondCodigo", A954ConCondCodigo);
         A1068ConMostrarPos = GXutil.strtobool( httpContext.cgiGet( chkConMostrarPos.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1068ConMostrarPos", A1068ConMostrarPos);
         cmbConAdelDescu.setValue( httpContext.cgiGet( cmbConAdelDescu.getInternalname()) );
         A1077ConAdelDescu = (byte)(GXutil.lval( httpContext.cgiGet( cmbConAdelDescu.getInternalname()))) ;
         n1077ConAdelDescu = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
         A1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( edtAplIIGG_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         A1194ConSegunPla = GXutil.strtobool( httpContext.cgiGet( chkConSegunPla.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1194ConSegunPla", A1194ConSegunPla);
         A1471ConNumero = (byte)(localUtil.ctol( httpContext.cgiGet( edtConNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1471ConNumero", GXutil.str( A1471ConNumero, 1, 0));
         A1648ConCodAfip = httpContext.cgiGet( edtConCodAfip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1648ConCodAfip", A1648ConCodAfip);
         A1472ConSIPAApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConSIPAApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1472ConSIPAApo", GXutil.str( A1472ConSIPAApo, 1, 0));
         A1473ConSIPACont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConSIPACont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1473ConSIPACont", GXutil.str( A1473ConSIPACont, 1, 0));
         A1474ConINSSJyPApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConINSSJyPApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1474ConINSSJyPApo", GXutil.str( A1474ConINSSJyPApo, 1, 0));
         A1475ConINSSJyPCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConINSSJyPCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1475ConINSSJyPCont", GXutil.str( A1475ConINSSJyPCont, 1, 0));
         A1476ConObraSocApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConObraSocApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1476ConObraSocApo", GXutil.str( A1476ConObraSocApo, 1, 0));
         A1477ConObraSocCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConObraSocCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1477ConObraSocCont", GXutil.str( A1477ConObraSocCont, 1, 0));
         A1478ConFonSolRedApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConFonSolRedApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1478ConFonSolRedApo", GXutil.str( A1478ConFonSolRedApo, 1, 0));
         A1479ConFonSolRedCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConFonSolRedCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1479ConFonSolRedCont", GXutil.str( A1479ConFonSolRedCont, 1, 0));
         A1480ConRenateaApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRenateaApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1480ConRenateaApo", GXutil.str( A1480ConRenateaApo, 1, 0));
         A1481ConRenateaCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRenateaCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1481ConRenateaCont", GXutil.str( A1481ConRenateaCont, 1, 0));
         A1482ConAsigFamCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConAsigFamCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1482ConAsigFamCont", GXutil.str( A1482ConAsigFamCont, 1, 0));
         A1483ConFonNacEmpCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConFonNacEmpCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1483ConFonNacEmpCont", GXutil.str( A1483ConFonNacEmpCont, 1, 0));
         A1484ConLeyRieTrabCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConLeyRieTrabCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1484ConLeyRieTrabCont", GXutil.str( A1484ConLeyRieTrabCont, 1, 0));
         A1485ConRegDifApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRegDifApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1485ConRegDifApo", GXutil.str( A1485ConRegDifApo, 1, 0));
         A1486ConRegEspApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRegEspApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1486ConRegEspApo", GXutil.str( A1486ConRegEspApo, 1, 0));
         cmbConSacDeven.setValue( httpContext.cgiGet( cmbConSacDeven.getInternalname()) );
         A1539ConSacDeven = (byte)(GXutil.lval( httpContext.cgiGet( cmbConSacDeven.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1539ConSacDeven", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1539ConSacDeven), 2, 0));
         A1644ConceptoPais = (short)(localUtil.ctol( httpContext.cgiGet( edtConceptoPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         n1644ConceptoPais = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
         A1645ConceptoConveCodigo = httpContext.cgiGet( edtConceptoConveCodigo_Internalname) ;
         n1645ConceptoConveCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1645ConceptoConveCodigo", A1645ConceptoConveCodigo);
         cmbConBaseLic.setValue( httpContext.cgiGet( cmbConBaseLic.getInternalname()) );
         A1620ConBaseLic = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseLic.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         cmbConBaseFer.setValue( httpContext.cgiGet( cmbConBaseFer.getInternalname()) );
         A1621ConBaseFer = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseFer.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         cmbConBaseHorExt.setValue( httpContext.cgiGet( cmbConBaseHorExt.getInternalname()) );
         A1622ConBaseHorExt = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseHorExt.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
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
      e13ID2 ();
      if (returnInSub) return;
   }

   public void e13ID2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptos_exportgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14ID2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoDeConcepto", GXv_boolean5) ;
      conceptos_exportgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( AV12TempBoolean )
      {
         edtTipoConDescrip_Link = formatLink("web.tipodeconceptoview", new String[] {GXutil.URLEncode(GXutil.rtrim(A37TipoConCod)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"TipoConCod","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtTipoConDescrip_Internalname, "Link", edtTipoConDescrip_Link, true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptos_export_Update", GXv_boolean5) ;
      conceptos_exportgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptos_export_Delete", GXv_boolean5) ;
      conceptos_exportgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Conceptos_export" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15ID2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptos_exportgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
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
      paID2( ) ;
      wsID2( ) ;
      weID2( ) ;
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
      paID2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "conceptos_exportgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paID2( ) ;
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
      paID2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsID2( ) ;
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
      wsID2( ) ;
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
      weID2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713291540", true, true);
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
      httpContext.AddJavascriptSource("conceptos_exportgeneral.js", "?20251713291540", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtConCodigo_Internalname = sPrefix+"CONCODIGO" ;
      edtConDescrip_Internalname = sPrefix+"CONDESCRIP" ;
      edtConOrden_Internalname = sPrefix+"CONORDEN" ;
      cmbConVigencia.setInternalname( sPrefix+"CONVIGENCIA" );
      edtConLiqBasica_Internalname = sPrefix+"CONLIQBASICA" ;
      edtConFormula_Internalname = sPrefix+"CONFORMULA" ;
      edtConObservacion_Internalname = sPrefix+"CONOBSERVACION" ;
      chkConVariable.setInternalname( sPrefix+"CONVARIABLE" );
      chkConForEditable.setInternalname( sPrefix+"CONFOREDITABLE" );
      edtTipoConDescrip_Internalname = sPrefix+"TIPOCONDESCRIP" ;
      edtSubTipoConDes1_Internalname = sPrefix+"SUBTIPOCONDES1" ;
      edtSubTipoConDes2_Internalname = sPrefix+"SUBTIPOCONDES2" ;
      edtConTipoLiqAux_Internalname = sPrefix+"CONTIPOLIQAUX" ;
      edtConClasifAux_Internalname = sPrefix+"CONCLASIFAUX" ;
      edtConOrdEjec_Internalname = sPrefix+"CONORDEJEC" ;
      edtConFormulaExpl_Internalname = sPrefix+"CONFORMULAEXPL" ;
      chkConRecalcular.setInternalname( sPrefix+"CONRECALCULAR" );
      edtConRangoCant_Internalname = sPrefix+"CONRANGOCANT" ;
      edtCondicionDescrip_Internalname = sPrefix+"CONDICIONDESCRIP" ;
      edtConCondCodigo_Internalname = sPrefix+"CONCONDCODIGO" ;
      chkConMostrarPos.setInternalname( sPrefix+"CONMOSTRARPOS" );
      cmbConAdelDescu.setInternalname( sPrefix+"CONADELDESCU" );
      edtAplIIGG_Internalname = sPrefix+"APLIIGG" ;
      chkConSegunPla.setInternalname( sPrefix+"CONSEGUNPLA" );
      edtConNumero_Internalname = sPrefix+"CONNUMERO" ;
      edtConCodAfip_Internalname = sPrefix+"CONCODAFIP" ;
      edtConSIPAApo_Internalname = sPrefix+"CONSIPAAPO" ;
      edtConSIPACont_Internalname = sPrefix+"CONSIPACONT" ;
      edtConINSSJyPApo_Internalname = sPrefix+"CONINSSJYPAPO" ;
      edtConINSSJyPCont_Internalname = sPrefix+"CONINSSJYPCONT" ;
      edtConObraSocApo_Internalname = sPrefix+"CONOBRASOCAPO" ;
      edtConObraSocCont_Internalname = sPrefix+"CONOBRASOCCONT" ;
      edtConFonSolRedApo_Internalname = sPrefix+"CONFONSOLREDAPO" ;
      edtConFonSolRedCont_Internalname = sPrefix+"CONFONSOLREDCONT" ;
      edtConRenateaApo_Internalname = sPrefix+"CONRENATEAAPO" ;
      edtConRenateaCont_Internalname = sPrefix+"CONRENATEACONT" ;
      edtConAsigFamCont_Internalname = sPrefix+"CONASIGFAMCONT" ;
      edtConFonNacEmpCont_Internalname = sPrefix+"CONFONNACEMPCONT" ;
      edtConLeyRieTrabCont_Internalname = sPrefix+"CONLEYRIETRABCONT" ;
      edtConRegDifApo_Internalname = sPrefix+"CONREGDIFAPO" ;
      edtConRegEspApo_Internalname = sPrefix+"CONREGESPAPO" ;
      cmbConSacDeven.setInternalname( sPrefix+"CONSACDEVEN" );
      edtConceptoPais_Internalname = sPrefix+"CONCEPTOPAIS" ;
      edtConceptoConveCodigo_Internalname = sPrefix+"CONCEPTOCONVECODIGO" ;
      cmbConBaseLic.setInternalname( sPrefix+"CONBASELIC" );
      cmbConBaseFer.setInternalname( sPrefix+"CONBASEFER" );
      cmbConBaseHorExt.setInternalname( sPrefix+"CONBASEHOREXT" );
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
      cmbConBaseHorExt.setJsonclick( "" );
      cmbConBaseHorExt.setEnabled( 0 );
      cmbConBaseFer.setJsonclick( "" );
      cmbConBaseFer.setEnabled( 0 );
      cmbConBaseLic.setJsonclick( "" );
      cmbConBaseLic.setEnabled( 0 );
      edtConceptoConveCodigo_Jsonclick = "" ;
      edtConceptoConveCodigo_Enabled = 0 ;
      edtConceptoPais_Jsonclick = "" ;
      edtConceptoPais_Enabled = 0 ;
      cmbConSacDeven.setJsonclick( "" );
      cmbConSacDeven.setEnabled( 0 );
      edtConRegEspApo_Jsonclick = "" ;
      edtConRegEspApo_Enabled = 0 ;
      edtConRegDifApo_Jsonclick = "" ;
      edtConRegDifApo_Enabled = 0 ;
      edtConLeyRieTrabCont_Jsonclick = "" ;
      edtConLeyRieTrabCont_Enabled = 0 ;
      edtConFonNacEmpCont_Jsonclick = "" ;
      edtConFonNacEmpCont_Enabled = 0 ;
      edtConAsigFamCont_Jsonclick = "" ;
      edtConAsigFamCont_Enabled = 0 ;
      edtConRenateaCont_Jsonclick = "" ;
      edtConRenateaCont_Enabled = 0 ;
      edtConRenateaApo_Jsonclick = "" ;
      edtConRenateaApo_Enabled = 0 ;
      edtConFonSolRedCont_Jsonclick = "" ;
      edtConFonSolRedCont_Enabled = 0 ;
      edtConFonSolRedApo_Jsonclick = "" ;
      edtConFonSolRedApo_Enabled = 0 ;
      edtConObraSocCont_Jsonclick = "" ;
      edtConObraSocCont_Enabled = 0 ;
      edtConObraSocApo_Jsonclick = "" ;
      edtConObraSocApo_Enabled = 0 ;
      edtConINSSJyPCont_Jsonclick = "" ;
      edtConINSSJyPCont_Enabled = 0 ;
      edtConINSSJyPApo_Jsonclick = "" ;
      edtConINSSJyPApo_Enabled = 0 ;
      edtConSIPACont_Jsonclick = "" ;
      edtConSIPACont_Enabled = 0 ;
      edtConSIPAApo_Jsonclick = "" ;
      edtConSIPAApo_Enabled = 0 ;
      edtConCodAfip_Jsonclick = "" ;
      edtConCodAfip_Enabled = 0 ;
      edtConNumero_Jsonclick = "" ;
      edtConNumero_Enabled = 0 ;
      chkConSegunPla.setEnabled( 0 );
      edtAplIIGG_Jsonclick = "" ;
      edtAplIIGG_Enabled = 0 ;
      cmbConAdelDescu.setJsonclick( "" );
      cmbConAdelDescu.setEnabled( 0 );
      chkConMostrarPos.setEnabled( 0 );
      edtConCondCodigo_Jsonclick = "" ;
      edtConCondCodigo_Enabled = 0 ;
      edtCondicionDescrip_Enabled = 0 ;
      edtConRangoCant_Enabled = 0 ;
      chkConRecalcular.setEnabled( 0 );
      edtConFormulaExpl_Enabled = 0 ;
      edtConOrdEjec_Jsonclick = "" ;
      edtConOrdEjec_Enabled = 0 ;
      edtConClasifAux_Jsonclick = "" ;
      edtConClasifAux_Enabled = 0 ;
      edtConTipoLiqAux_Jsonclick = "" ;
      edtConTipoLiqAux_Enabled = 0 ;
      edtSubTipoConDes2_Enabled = 0 ;
      edtSubTipoConDes1_Enabled = 0 ;
      edtTipoConDescrip_Link = "" ;
      edtTipoConDescrip_Enabled = 0 ;
      chkConForEditable.setEnabled( 0 );
      chkConVariable.setEnabled( 0 );
      edtConObservacion_Enabled = 0 ;
      edtConFormula_Enabled = 0 ;
      edtConLiqBasica_Jsonclick = "" ;
      edtConLiqBasica_Enabled = 0 ;
      cmbConVigencia.setJsonclick( "" );
      cmbConVigencia.setEnabled( 0 );
      edtConOrden_Jsonclick = "" ;
      edtConOrden_Enabled = 0 ;
      edtConDescrip_Enabled = 0 ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Enabled = 0 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 0 ;
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
      cmbConVigencia.setName( "CONVIGENCIA" );
      cmbConVigencia.setWebtags( "" );
      cmbConVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
      cmbConVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
      if ( cmbConVigencia.getItemCount() > 0 )
      {
      }
      chkConVariable.setName( "CONVARIABLE" );
      chkConVariable.setWebtags( "" );
      chkConVariable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConVariable.getInternalname(), "TitleCaption", chkConVariable.getCaption(), true);
      chkConVariable.setCheckedValue( "false" );
      chkConForEditable.setName( "CONFOREDITABLE" );
      chkConForEditable.setWebtags( "" );
      chkConForEditable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConForEditable.getInternalname(), "TitleCaption", chkConForEditable.getCaption(), true);
      chkConForEditable.setCheckedValue( "false" );
      chkConRecalcular.setName( "CONRECALCULAR" );
      chkConRecalcular.setWebtags( "" );
      chkConRecalcular.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConRecalcular.getInternalname(), "TitleCaption", chkConRecalcular.getCaption(), true);
      chkConRecalcular.setCheckedValue( "false" );
      chkConMostrarPos.setName( "CONMOSTRARPOS" );
      chkConMostrarPos.setWebtags( "" );
      chkConMostrarPos.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConMostrarPos.getInternalname(), "TitleCaption", chkConMostrarPos.getCaption(), true);
      chkConMostrarPos.setCheckedValue( "false" );
      cmbConAdelDescu.setName( "CONADELDESCU" );
      cmbConAdelDescu.setWebtags( "" );
      cmbConAdelDescu.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbConAdelDescu.addItem("1", httpContext.getMessage( "Adelanto de mes próximo", ""), (short)(0));
      cmbConAdelDescu.addItem("2", httpContext.getMessage( "Descuento", ""), (short)(0));
      if ( cmbConAdelDescu.getItemCount() > 0 )
      {
      }
      chkConSegunPla.setName( "CONSEGUNPLA" );
      chkConSegunPla.setWebtags( "" );
      chkConSegunPla.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConSegunPla.getInternalname(), "TitleCaption", chkConSegunPla.getCaption(), true);
      chkConSegunPla.setCheckedValue( "false" );
      cmbConSacDeven.setName( "CONSACDEVEN" );
      cmbConSacDeven.setWebtags( "" );
      cmbConSacDeven.addItem("0", httpContext.getMessage( "No aplica", ""), (short)(0));
      cmbConSacDeven.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbConSacDeven.addItem("3", httpContext.getMessage( "Trimestral", ""), (short)(0));
      cmbConSacDeven.addItem("4", httpContext.getMessage( "Cuatrimestral", ""), (short)(0));
      cmbConSacDeven.addItem("6", httpContext.getMessage( "Semestral", ""), (short)(0));
      cmbConSacDeven.addItem("12", httpContext.getMessage( "Anual", ""), (short)(0));
      if ( cmbConSacDeven.getItemCount() > 0 )
      {
      }
      cmbConBaseLic.setName( "CONBASELIC" );
      cmbConBaseLic.setWebtags( "" );
      cmbConBaseLic.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseLic.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseLic.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseLic.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseLic.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseLic.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseLic.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseLic.getItemCount() > 0 )
      {
      }
      cmbConBaseFer.setName( "CONBASEFER" );
      cmbConBaseFer.setWebtags( "" );
      cmbConBaseFer.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseFer.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseFer.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseFer.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseFer.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseFer.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseFer.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseFer.getItemCount() > 0 )
      {
      }
      cmbConBaseHorExt.setName( "CONBASEHOREXT" );
      cmbConBaseHorExt.setWebtags( "" );
      cmbConBaseHorExt.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseHorExt.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseHorExt.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseHorExt.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseHorExt.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseHorExt.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseHorExt.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseHorExt.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11ID1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12ID1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[]}");
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
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A41ConDescrip = "" ;
      A148ConFormula = "" ;
      A153ConObservacion = "" ;
      A370TipoConDescrip = "" ;
      A371SubTipoConDes1 = "" ;
      A372SubTipoConDes2 = "" ;
      A503ConTipoLiqAux = "" ;
      A970ConClasifAux = "" ;
      A569ConFormulaExpl = "" ;
      A1018ConRangoCant = "" ;
      A1758CondicionDescrip = "" ;
      A954ConCondCodigo = "" ;
      A1648ConCodAfip = "" ;
      A1645ConceptoConveCodigo = "" ;
      TempTags = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      H00ID2_A38SubTipoConCod1 = new String[] {""} ;
      H00ID2_n38SubTipoConCod1 = new boolean[] {false} ;
      H00ID2_A39SubTipoConCod2 = new String[] {""} ;
      H00ID2_n39SubTipoConCod2 = new boolean[] {false} ;
      H00ID2_A953ConCondicion = new String[] {""} ;
      H00ID2_n953ConCondicion = new boolean[] {false} ;
      H00ID2_A3CliCod = new int[1] ;
      H00ID2_A26ConCodigo = new String[] {""} ;
      H00ID2_A37TipoConCod = new String[] {""} ;
      H00ID2_A1622ConBaseHorExt = new byte[1] ;
      H00ID2_A1621ConBaseFer = new byte[1] ;
      H00ID2_A1620ConBaseLic = new byte[1] ;
      H00ID2_A1645ConceptoConveCodigo = new String[] {""} ;
      H00ID2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      H00ID2_A1644ConceptoPais = new short[1] ;
      H00ID2_n1644ConceptoPais = new boolean[] {false} ;
      H00ID2_A1539ConSacDeven = new byte[1] ;
      H00ID2_A1486ConRegEspApo = new byte[1] ;
      H00ID2_A1485ConRegDifApo = new byte[1] ;
      H00ID2_A1484ConLeyRieTrabCont = new byte[1] ;
      H00ID2_A1483ConFonNacEmpCont = new byte[1] ;
      H00ID2_A1482ConAsigFamCont = new byte[1] ;
      H00ID2_A1481ConRenateaCont = new byte[1] ;
      H00ID2_A1480ConRenateaApo = new byte[1] ;
      H00ID2_A1479ConFonSolRedCont = new byte[1] ;
      H00ID2_A1478ConFonSolRedApo = new byte[1] ;
      H00ID2_A1477ConObraSocCont = new byte[1] ;
      H00ID2_A1476ConObraSocApo = new byte[1] ;
      H00ID2_A1475ConINSSJyPCont = new byte[1] ;
      H00ID2_A1474ConINSSJyPApo = new byte[1] ;
      H00ID2_A1473ConSIPACont = new byte[1] ;
      H00ID2_A1472ConSIPAApo = new byte[1] ;
      H00ID2_A1648ConCodAfip = new String[] {""} ;
      H00ID2_A1471ConNumero = new byte[1] ;
      H00ID2_A1194ConSegunPla = new boolean[] {false} ;
      H00ID2_A1112AplIIGG = new short[1] ;
      H00ID2_n1112AplIIGG = new boolean[] {false} ;
      H00ID2_A1077ConAdelDescu = new byte[1] ;
      H00ID2_n1077ConAdelDescu = new boolean[] {false} ;
      H00ID2_A1068ConMostrarPos = new boolean[] {false} ;
      H00ID2_A954ConCondCodigo = new String[] {""} ;
      H00ID2_A1758CondicionDescrip = new String[] {""} ;
      H00ID2_A1018ConRangoCant = new String[] {""} ;
      H00ID2_A762ConRecalcular = new boolean[] {false} ;
      H00ID2_A569ConFormulaExpl = new String[] {""} ;
      H00ID2_A510ConOrdEjec = new long[1] ;
      H00ID2_A970ConClasifAux = new String[] {""} ;
      H00ID2_n970ConClasifAux = new boolean[] {false} ;
      H00ID2_A503ConTipoLiqAux = new String[] {""} ;
      H00ID2_n503ConTipoLiqAux = new boolean[] {false} ;
      H00ID2_A372SubTipoConDes2 = new String[] {""} ;
      H00ID2_A371SubTipoConDes1 = new String[] {""} ;
      H00ID2_A370TipoConDescrip = new String[] {""} ;
      H00ID2_A146ConForEditable = new boolean[] {false} ;
      H00ID2_n146ConForEditable = new boolean[] {false} ;
      H00ID2_A159ConVariable = new boolean[] {false} ;
      H00ID2_A153ConObservacion = new String[] {""} ;
      H00ID2_A148ConFormula = new String[] {""} ;
      H00ID2_n148ConFormula = new boolean[] {false} ;
      H00ID2_A1488ConLiqBasica = new byte[1] ;
      H00ID2_A162ConVigencia = new byte[1] ;
      H00ID2_A40ConOrden = new int[1] ;
      H00ID2_A41ConDescrip = new String[] {""} ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A953ConCondicion = "" ;
      A37TipoConCod = "" ;
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
      sCtrlA26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptos_exportgeneral__default(),
         new Object[] {
             new Object[] {
            H00ID2_A38SubTipoConCod1, H00ID2_n38SubTipoConCod1, H00ID2_A39SubTipoConCod2, H00ID2_n39SubTipoConCod2, H00ID2_A953ConCondicion, H00ID2_n953ConCondicion, H00ID2_A3CliCod, H00ID2_A26ConCodigo, H00ID2_A37TipoConCod, H00ID2_A1622ConBaseHorExt,
            H00ID2_A1621ConBaseFer, H00ID2_A1620ConBaseLic, H00ID2_A1645ConceptoConveCodigo, H00ID2_n1645ConceptoConveCodigo, H00ID2_A1644ConceptoPais, H00ID2_n1644ConceptoPais, H00ID2_A1539ConSacDeven, H00ID2_A1486ConRegEspApo, H00ID2_A1485ConRegDifApo, H00ID2_A1484ConLeyRieTrabCont,
            H00ID2_A1483ConFonNacEmpCont, H00ID2_A1482ConAsigFamCont, H00ID2_A1481ConRenateaCont, H00ID2_A1480ConRenateaApo, H00ID2_A1479ConFonSolRedCont, H00ID2_A1478ConFonSolRedApo, H00ID2_A1477ConObraSocCont, H00ID2_A1476ConObraSocApo, H00ID2_A1475ConINSSJyPCont, H00ID2_A1474ConINSSJyPApo,
            H00ID2_A1473ConSIPACont, H00ID2_A1472ConSIPAApo, H00ID2_A1648ConCodAfip, H00ID2_A1471ConNumero, H00ID2_A1194ConSegunPla, H00ID2_A1112AplIIGG, H00ID2_n1112AplIIGG, H00ID2_A1077ConAdelDescu, H00ID2_n1077ConAdelDescu, H00ID2_A1068ConMostrarPos,
            H00ID2_A954ConCondCodigo, H00ID2_A1758CondicionDescrip, H00ID2_A1018ConRangoCant, H00ID2_A762ConRecalcular, H00ID2_A569ConFormulaExpl, H00ID2_A510ConOrdEjec, H00ID2_A970ConClasifAux, H00ID2_n970ConClasifAux, H00ID2_A503ConTipoLiqAux, H00ID2_n503ConTipoLiqAux,
            H00ID2_A372SubTipoConDes2, H00ID2_A371SubTipoConDes1, H00ID2_A370TipoConDescrip, H00ID2_A146ConForEditable, H00ID2_n146ConForEditable, H00ID2_A159ConVariable, H00ID2_A153ConObservacion, H00ID2_A148ConFormula, H00ID2_n148ConFormula, H00ID2_A1488ConLiqBasica,
            H00ID2_A162ConVigencia, H00ID2_A40ConOrden, H00ID2_A41ConDescrip
            }
         }
      );
      AV17Pgmname = "Conceptos_exportGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "Conceptos_exportGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A162ConVigencia ;
   private byte A1488ConLiqBasica ;
   private byte A1077ConAdelDescu ;
   private byte A1471ConNumero ;
   private byte A1472ConSIPAApo ;
   private byte A1473ConSIPACont ;
   private byte A1474ConINSSJyPApo ;
   private byte A1475ConINSSJyPCont ;
   private byte A1476ConObraSocApo ;
   private byte A1477ConObraSocCont ;
   private byte A1478ConFonSolRedApo ;
   private byte A1479ConFonSolRedCont ;
   private byte A1480ConRenateaApo ;
   private byte A1481ConRenateaCont ;
   private byte A1482ConAsigFamCont ;
   private byte A1483ConFonNacEmpCont ;
   private byte A1484ConLeyRieTrabCont ;
   private byte A1485ConRegDifApo ;
   private byte A1486ConRegEspApo ;
   private byte A1539ConSacDeven ;
   private byte A1620ConBaseLic ;
   private byte A1621ConBaseFer ;
   private byte A1622ConBaseHorExt ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short A1112AplIIGG ;
   private short A1644ConceptoPais ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int edtCliCod_Enabled ;
   private int edtConCodigo_Enabled ;
   private int edtConDescrip_Enabled ;
   private int A40ConOrden ;
   private int edtConOrden_Enabled ;
   private int edtConLiqBasica_Enabled ;
   private int edtConFormula_Enabled ;
   private int edtConObservacion_Enabled ;
   private int edtTipoConDescrip_Enabled ;
   private int edtSubTipoConDes1_Enabled ;
   private int edtSubTipoConDes2_Enabled ;
   private int edtConTipoLiqAux_Enabled ;
   private int edtConClasifAux_Enabled ;
   private int edtConOrdEjec_Enabled ;
   private int edtConFormulaExpl_Enabled ;
   private int edtConRangoCant_Enabled ;
   private int edtCondicionDescrip_Enabled ;
   private int edtConCondCodigo_Enabled ;
   private int edtAplIIGG_Enabled ;
   private int edtConNumero_Enabled ;
   private int edtConCodAfip_Enabled ;
   private int edtConSIPAApo_Enabled ;
   private int edtConSIPACont_Enabled ;
   private int edtConINSSJyPApo_Enabled ;
   private int edtConINSSJyPCont_Enabled ;
   private int edtConObraSocApo_Enabled ;
   private int edtConObraSocCont_Enabled ;
   private int edtConFonSolRedApo_Enabled ;
   private int edtConFonSolRedCont_Enabled ;
   private int edtConRenateaApo_Enabled ;
   private int edtConRenateaCont_Enabled ;
   private int edtConAsigFamCont_Enabled ;
   private int edtConFonNacEmpCont_Enabled ;
   private int edtConLeyRieTrabCont_Enabled ;
   private int edtConRegDifApo_Enabled ;
   private int edtConRegEspApo_Enabled ;
   private int edtConceptoPais_Enabled ;
   private int edtConceptoConveCodigo_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private long A510ConOrdEjec ;
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
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtConCodigo_Internalname ;
   private String edtConCodigo_Jsonclick ;
   private String edtConDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtConOrden_Internalname ;
   private String edtConOrden_Jsonclick ;
   private String edtConLiqBasica_Internalname ;
   private String edtConLiqBasica_Jsonclick ;
   private String edtConFormula_Internalname ;
   private String edtConObservacion_Internalname ;
   private String edtTipoConDescrip_Internalname ;
   private String edtTipoConDescrip_Link ;
   private String edtSubTipoConDes1_Internalname ;
   private String edtSubTipoConDes2_Internalname ;
   private String edtConTipoLiqAux_Internalname ;
   private String edtConTipoLiqAux_Jsonclick ;
   private String edtConClasifAux_Internalname ;
   private String edtConClasifAux_Jsonclick ;
   private String edtConOrdEjec_Internalname ;
   private String edtConOrdEjec_Jsonclick ;
   private String edtConFormulaExpl_Internalname ;
   private String edtConRangoCant_Internalname ;
   private String edtCondicionDescrip_Internalname ;
   private String edtConCondCodigo_Internalname ;
   private String A954ConCondCodigo ;
   private String edtConCondCodigo_Jsonclick ;
   private String edtAplIIGG_Internalname ;
   private String edtAplIIGG_Jsonclick ;
   private String edtConNumero_Internalname ;
   private String edtConNumero_Jsonclick ;
   private String edtConCodAfip_Internalname ;
   private String A1648ConCodAfip ;
   private String edtConCodAfip_Jsonclick ;
   private String edtConSIPAApo_Internalname ;
   private String edtConSIPAApo_Jsonclick ;
   private String edtConSIPACont_Internalname ;
   private String edtConSIPACont_Jsonclick ;
   private String edtConINSSJyPApo_Internalname ;
   private String edtConINSSJyPApo_Jsonclick ;
   private String edtConINSSJyPCont_Internalname ;
   private String edtConINSSJyPCont_Jsonclick ;
   private String edtConObraSocApo_Internalname ;
   private String edtConObraSocApo_Jsonclick ;
   private String edtConObraSocCont_Internalname ;
   private String edtConObraSocCont_Jsonclick ;
   private String edtConFonSolRedApo_Internalname ;
   private String edtConFonSolRedApo_Jsonclick ;
   private String edtConFonSolRedCont_Internalname ;
   private String edtConFonSolRedCont_Jsonclick ;
   private String edtConRenateaApo_Internalname ;
   private String edtConRenateaApo_Jsonclick ;
   private String edtConRenateaCont_Internalname ;
   private String edtConRenateaCont_Jsonclick ;
   private String edtConAsigFamCont_Internalname ;
   private String edtConAsigFamCont_Jsonclick ;
   private String edtConFonNacEmpCont_Internalname ;
   private String edtConFonNacEmpCont_Jsonclick ;
   private String edtConLeyRieTrabCont_Internalname ;
   private String edtConLeyRieTrabCont_Jsonclick ;
   private String edtConRegDifApo_Internalname ;
   private String edtConRegDifApo_Jsonclick ;
   private String edtConRegEspApo_Internalname ;
   private String edtConRegEspApo_Jsonclick ;
   private String edtConceptoPais_Internalname ;
   private String edtConceptoPais_Jsonclick ;
   private String edtConceptoConveCodigo_Internalname ;
   private String A1645ConceptoConveCodigo ;
   private String edtConceptoConveCodigo_Jsonclick ;
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
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String A953ConCondicion ;
   private String A37TipoConCod ;
   private String sCtrlA3CliCod ;
   private String sCtrlA26ConCodigo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A159ConVariable ;
   private boolean A146ConForEditable ;
   private boolean A762ConRecalcular ;
   private boolean A1068ConMostrarPos ;
   private boolean A1194ConSegunPla ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n146ConForEditable ;
   private boolean n1077ConAdelDescu ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean n953ConCondicion ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n1644ConceptoPais ;
   private boolean n1112AplIIGG ;
   private boolean n970ConClasifAux ;
   private boolean n503ConTipoLiqAux ;
   private boolean n148ConFormula ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A148ConFormula ;
   private String A153ConObservacion ;
   private String A569ConFormulaExpl ;
   private String A41ConDescrip ;
   private String A370TipoConDescrip ;
   private String A371SubTipoConDes1 ;
   private String A372SubTipoConDes2 ;
   private String A503ConTipoLiqAux ;
   private String A970ConClasifAux ;
   private String A1018ConRangoCant ;
   private String A1758CondicionDescrip ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private HTMLChoice cmbConVigencia ;
   private ICheckbox chkConVariable ;
   private ICheckbox chkConForEditable ;
   private ICheckbox chkConRecalcular ;
   private ICheckbox chkConMostrarPos ;
   private HTMLChoice cmbConAdelDescu ;
   private ICheckbox chkConSegunPla ;
   private HTMLChoice cmbConSacDeven ;
   private HTMLChoice cmbConBaseLic ;
   private HTMLChoice cmbConBaseFer ;
   private HTMLChoice cmbConBaseHorExt ;
   private IDataStoreProvider pr_default ;
   private String[] H00ID2_A38SubTipoConCod1 ;
   private boolean[] H00ID2_n38SubTipoConCod1 ;
   private String[] H00ID2_A39SubTipoConCod2 ;
   private boolean[] H00ID2_n39SubTipoConCod2 ;
   private String[] H00ID2_A953ConCondicion ;
   private boolean[] H00ID2_n953ConCondicion ;
   private int[] H00ID2_A3CliCod ;
   private String[] H00ID2_A26ConCodigo ;
   private String[] H00ID2_A37TipoConCod ;
   private byte[] H00ID2_A1622ConBaseHorExt ;
   private byte[] H00ID2_A1621ConBaseFer ;
   private byte[] H00ID2_A1620ConBaseLic ;
   private String[] H00ID2_A1645ConceptoConveCodigo ;
   private boolean[] H00ID2_n1645ConceptoConveCodigo ;
   private short[] H00ID2_A1644ConceptoPais ;
   private boolean[] H00ID2_n1644ConceptoPais ;
   private byte[] H00ID2_A1539ConSacDeven ;
   private byte[] H00ID2_A1486ConRegEspApo ;
   private byte[] H00ID2_A1485ConRegDifApo ;
   private byte[] H00ID2_A1484ConLeyRieTrabCont ;
   private byte[] H00ID2_A1483ConFonNacEmpCont ;
   private byte[] H00ID2_A1482ConAsigFamCont ;
   private byte[] H00ID2_A1481ConRenateaCont ;
   private byte[] H00ID2_A1480ConRenateaApo ;
   private byte[] H00ID2_A1479ConFonSolRedCont ;
   private byte[] H00ID2_A1478ConFonSolRedApo ;
   private byte[] H00ID2_A1477ConObraSocCont ;
   private byte[] H00ID2_A1476ConObraSocApo ;
   private byte[] H00ID2_A1475ConINSSJyPCont ;
   private byte[] H00ID2_A1474ConINSSJyPApo ;
   private byte[] H00ID2_A1473ConSIPACont ;
   private byte[] H00ID2_A1472ConSIPAApo ;
   private String[] H00ID2_A1648ConCodAfip ;
   private byte[] H00ID2_A1471ConNumero ;
   private boolean[] H00ID2_A1194ConSegunPla ;
   private short[] H00ID2_A1112AplIIGG ;
   private boolean[] H00ID2_n1112AplIIGG ;
   private byte[] H00ID2_A1077ConAdelDescu ;
   private boolean[] H00ID2_n1077ConAdelDescu ;
   private boolean[] H00ID2_A1068ConMostrarPos ;
   private String[] H00ID2_A954ConCondCodigo ;
   private String[] H00ID2_A1758CondicionDescrip ;
   private String[] H00ID2_A1018ConRangoCant ;
   private boolean[] H00ID2_A762ConRecalcular ;
   private String[] H00ID2_A569ConFormulaExpl ;
   private long[] H00ID2_A510ConOrdEjec ;
   private String[] H00ID2_A970ConClasifAux ;
   private boolean[] H00ID2_n970ConClasifAux ;
   private String[] H00ID2_A503ConTipoLiqAux ;
   private boolean[] H00ID2_n503ConTipoLiqAux ;
   private String[] H00ID2_A372SubTipoConDes2 ;
   private String[] H00ID2_A371SubTipoConDes1 ;
   private String[] H00ID2_A370TipoConDescrip ;
   private boolean[] H00ID2_A146ConForEditable ;
   private boolean[] H00ID2_n146ConForEditable ;
   private boolean[] H00ID2_A159ConVariable ;
   private String[] H00ID2_A153ConObservacion ;
   private String[] H00ID2_A148ConFormula ;
   private boolean[] H00ID2_n148ConFormula ;
   private byte[] H00ID2_A1488ConLiqBasica ;
   private byte[] H00ID2_A162ConVigencia ;
   private int[] H00ID2_A40ConOrden ;
   private String[] H00ID2_A41ConDescrip ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class conceptos_exportgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00ID2", "SELECT T1.SubTipoConCod1, T1.SubTipoConCod2, T1.ConCondicion, T1.CliCod, T1.ConCodigo, T1.TipoConCod, T1.ConBaseHorExt, T1.ConBaseFer, T1.ConBaseLic, T1.ConceptoConveCodigo, T1.ConceptoPais, T1.ConSacDeven, T1.ConRegEspApo, T1.ConRegDifApo, T1.ConLeyRieTrabCont, T1.ConFonNacEmpCont, T1.ConAsigFamCont, T1.ConRenateaCont, T1.ConRenateaApo, T1.ConFonSolRedCont, T1.ConFonSolRedApo, T1.ConObraSocCont, T1.ConObraSocApo, T1.ConINSSJyPCont, T1.ConINSSJyPApo, T1.ConSIPACont, T1.ConSIPAApo, T1.ConCodAfip, T1.ConNumero, T1.ConSegunPla, T1.AplIIGG, T1.ConAdelDescu, T1.ConMostrarPos, T1.ConCondCodigo, T2.CondicionDescrip, T1.ConRangoCant, T1.ConRecalcular, T1.ConFormulaExpl, T1.ConOrdEjec, T1.ConClasifAux, T1.ConTipoLiqAux, T5.SubTipoConDes2, T4.SubTipoConDes1, T3.TipoConDescrip, T1.ConForEditable, T1.ConVariable, T1.ConObservacion, T1.ConFormula, T1.ConLiqBasica, T1.ConVigencia, T1.ConOrden, T1.ConDescrip FROM ((((Concepto T1 LEFT JOIN Condiciones_concepto T2 ON T2.ConCondicion = T1.ConCondicion) INNER JOIN TipoDeConcepto T3 ON T3.TipoConCod = T1.TipoConCod) LEFT JOIN TipoDeConceptoSubtipo1 T4 ON T4.TipoConCod = T1.TipoConCod AND T4.SubTipoConCod1 = T1.SubTipoConCod1) LEFT JOIN tipo_concepto_subtipo2 T5 ON T5.TipoConCod = T1.TipoConCod AND T5.SubTipoConCod1 = T1.SubTipoConCod1 AND T5.SubTipoConCod2 = T1.SubTipoConCod2) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) ORDER BY T1.CliCod, T1.ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((String[]) buf[7])[0] = rslt.getString(5, 10);
               ((String[]) buf[8])[0] = rslt.getString(6, 20);
               ((byte[]) buf[9])[0] = rslt.getByte(7);
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(11);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((byte[]) buf[16])[0] = rslt.getByte(12);
               ((byte[]) buf[17])[0] = rslt.getByte(13);
               ((byte[]) buf[18])[0] = rslt.getByte(14);
               ((byte[]) buf[19])[0] = rslt.getByte(15);
               ((byte[]) buf[20])[0] = rslt.getByte(16);
               ((byte[]) buf[21])[0] = rslt.getByte(17);
               ((byte[]) buf[22])[0] = rslt.getByte(18);
               ((byte[]) buf[23])[0] = rslt.getByte(19);
               ((byte[]) buf[24])[0] = rslt.getByte(20);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((byte[]) buf[26])[0] = rslt.getByte(22);
               ((byte[]) buf[27])[0] = rslt.getByte(23);
               ((byte[]) buf[28])[0] = rslt.getByte(24);
               ((byte[]) buf[29])[0] = rslt.getByte(25);
               ((byte[]) buf[30])[0] = rslt.getByte(26);
               ((byte[]) buf[31])[0] = rslt.getByte(27);
               ((String[]) buf[32])[0] = rslt.getString(28, 6);
               ((byte[]) buf[33])[0] = rslt.getByte(29);
               ((boolean[]) buf[34])[0] = rslt.getBoolean(30);
               ((short[]) buf[35])[0] = rslt.getShort(31);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(32);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((boolean[]) buf[39])[0] = rslt.getBoolean(33);
               ((String[]) buf[40])[0] = rslt.getString(34, 20);
               ((String[]) buf[41])[0] = rslt.getVarchar(35);
               ((String[]) buf[42])[0] = rslt.getVarchar(36);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(37);
               ((String[]) buf[44])[0] = rslt.getLongVarchar(38);
               ((long[]) buf[45])[0] = rslt.getLong(39);
               ((String[]) buf[46])[0] = rslt.getVarchar(40);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((String[]) buf[48])[0] = rslt.getVarchar(41);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((String[]) buf[50])[0] = rslt.getVarchar(42);
               ((String[]) buf[51])[0] = rslt.getVarchar(43);
               ((String[]) buf[52])[0] = rslt.getVarchar(44);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(45);
               ((boolean[]) buf[54])[0] = rslt.wasNull();
               ((boolean[]) buf[55])[0] = rslt.getBoolean(46);
               ((String[]) buf[56])[0] = rslt.getLongVarchar(47);
               ((String[]) buf[57])[0] = rslt.getLongVarchar(48);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((byte[]) buf[59])[0] = rslt.getByte(49);
               ((byte[]) buf[60])[0] = rslt.getByte(50);
               ((int[]) buf[61])[0] = rslt.getInt(51);
               ((String[]) buf[62])[0] = rslt.getVarchar(52);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

