package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class escalasalarialgeneral_impl extends GXWebComponent
{
   public escalasalarialgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public escalasalarialgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( escalasalarialgeneral_impl.class ));
   }

   public escalasalarialgeneral_impl( int remoteHandle ,
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
      dynCatCodigo = new HTMLChoice();
      dynCatSalRelSec = new HTMLChoice();
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
               A8CatCodigo = httpContext.GetPar( "CatCodigo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A8CatCodigo", A8CatCodigo);
               A907CatVigencia = localUtil.parseDateParm( httpContext.GetPar( "CatVigencia")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1564CliPaiConve),A1565CliConvenio,A8CatCodigo,A907CatVigencia});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CATCODIGO") == 0 )
            {
               AV13CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               AV20Clipaiconve = (short)(GXutil.lval( httpContext.GetPar( "Clipaiconve"))) ;
               AV21Cliconvenio = httpContext.GetPar( "Cliconvenio") ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlacatcodigoER2( AV13CliCod, AV20Clipaiconve, AV21Cliconvenio) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CATSALRELSEC") == 0 )
            {
               AV13CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlacatsalrelsecER2( AV13CliCod) ;
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
         paER2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Escala Salarial General", "")) ;
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.escalasalarialgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.rtrim(A8CatCodigo)),GXutil.URLEncode(GXutil.formatDateParm(A907CatVigencia))}, new String[] {"CliCod","CliPaiConve","CliConvenio","CatCodigo","CatVigencia"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA8CatCodigo", GXutil.rtrim( wcpOA8CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA907CatVigencia", localUtil.dtoc( wcpOA907CatVigencia, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV13CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV20Clipaiconve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICONVENIO", GXutil.rtrim( AV21Cliconvenio));
   }

   public void renderHtmlCloseFormER2( )
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
      return "EscalaSalarialGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Escala Salarial General", "") ;
   }

   public void wbER0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.escalasalarialgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCatCodigo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynCatCodigo.getInternalname(), httpContext.getMessage( "Categoria", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCatCodigo, dynCatCodigo.getInternalname(), GXutil.rtrim( A8CatCodigo), 1, dynCatCodigo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynCatCodigo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_EscalaSalarialGeneral.htm");
         dynCatCodigo.setValue( GXutil.rtrim( A8CatCodigo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynCatCodigo.getInternalname(), "Values", dynCatCodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatVigencia_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCatVigencia_Internalname, httpContext.getMessage( "Vigencia desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtCatVigencia_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtCatVigencia_Internalname, localUtil.format(A907CatVigencia, "99/99/9999"), localUtil.format( A907CatVigencia, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCatVigencia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCatVigencia_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_EscalaSalarialGeneral.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtCatVigencia_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtCatVigencia_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_EscalaSalarialGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEscBasico_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEscBasico_Internalname, httpContext.getMessage( "Básico", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEscBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEscBasico_Enabled!=0) ? localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEscBasico_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEscBasico_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_EscalaSalarialGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEscAdicional_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEscAdicional_Internalname, httpContext.getMessage( "Adicional", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEscAdicional_Internalname, GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEscAdicional_Enabled!=0) ? localUtil.format( A1893EscAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1893EscAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEscAdicional_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEscAdicional_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_EscalaSalarialGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divCatsalrelsec_cell_Internalname, 1, 0, "px", 0, "px", divCatsalrelsec_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", dynCatSalRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCatSalRelSec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynCatSalRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCatSalRelSec, dynCatSalRelSec.getInternalname(), GXutil.trim( GXutil.str( A1891CatSalRelSec, 6, 0)), 1, dynCatSalRelSec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", dynCatSalRelSec.getVisible(), dynCatSalRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_EscalaSalarialGeneral.htm");
         dynCatSalRelSec.setValue( GXutil.trim( GXutil.str( A1891CatSalRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynCatSalRelSec.getInternalname(), "Values", dynCatSalRelSec.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11er1_client"+"'", TempTags, "", 2, "HLP_EscalaSalarialGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 41,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12er1_client"+"'", TempTags, "", 2, "HLP_EscalaSalarialGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EscalaSalarialGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_EscalaSalarialGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EscalaSalarialGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startER2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Escala Salarial General", ""), (short)(0)) ;
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
            strupER0( ) ;
         }
      }
   }

   public void wsER2( )
   {
      startER2( ) ;
      evtER2( ) ;
   }

   public void evtER2( )
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
                              strupER0( ) ;
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
                              strupER0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13ER2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupER0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14ER2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupER0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15ER2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupER0( ) ;
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
                              strupER0( ) ;
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

   public void weER2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormER2( ) ;
         }
      }
   }

   public void paER2( )
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

   public void gxdlacatcodigoER2( int AV13CliCod ,
                                  short AV20Clipaiconve ,
                                  String AV21Cliconvenio )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacatcodigo_dataER2( AV13CliCod, AV20Clipaiconve, AV21Cliconvenio) ;
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

   public void gxacatcodigo_htmlER2( int AV13CliCod ,
                                     short AV20Clipaiconve ,
                                     String AV21Cliconvenio )
   {
      String gxdynajaxvalue;
      gxdlacatcodigo_dataER2( AV13CliCod, AV20Clipaiconve, AV21Cliconvenio) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCatCodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynCatCodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacatcodigo_dataER2( int AV13CliCod ,
                                          short AV20Clipaiconve ,
                                          String AV21Cliconvenio )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00ER2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV20Clipaiconve), AV21Cliconvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00ER2_A8CatCodigo[0]));
         gxdynajaxctrldescr.add(H00ER2_A123CatDescrip[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlacatsalrelsecER2( int AV13CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacatsalrelsec_dataER2( AV13CliCod) ;
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

   public void gxacatsalrelsec_htmlER2( int AV13CliCod )
   {
      int gxdynajaxvalue;
      gxdlacatsalrelsec_dataER2( AV13CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCatSalRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynCatSalRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacatsalrelsec_dataER2( int AV13CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00ER3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV13CliCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00ER3_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00ER3_A1880CliReDTChar[0]);
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
      if ( dynCatCodigo.getItemCount() > 0 )
      {
         A8CatCodigo = dynCatCodigo.getValidValue(A8CatCodigo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A8CatCodigo", A8CatCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCatCodigo.setValue( GXutil.rtrim( A8CatCodigo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynCatCodigo.getInternalname(), "Values", dynCatCodigo.ToJavascriptSource(), true);
      }
      if ( dynCatSalRelSec.getItemCount() > 0 )
      {
         A1891CatSalRelSec = (int)(GXutil.lval( dynCatSalRelSec.getValidValue(GXutil.trim( GXutil.str( A1891CatSalRelSec, 6, 0))))) ;
         n1891CatSalRelSec = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1891CatSalRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1891CatSalRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCatSalRelSec.setValue( GXutil.trim( GXutil.str( A1891CatSalRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynCatSalRelSec.getInternalname(), "Values", dynCatSalRelSec.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfER2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV19Pgmname = "EscalaSalarialGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfER2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15ER2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00ER4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A1891CatSalRelSec = H00ER4_A1891CatSalRelSec[0] ;
            n1891CatSalRelSec = H00ER4_n1891CatSalRelSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1891CatSalRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1891CatSalRelSec), 6, 0));
            A1893EscAdicional = H00ER4_A1893EscAdicional[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1893EscAdicional", GXutil.ltrimstr( A1893EscAdicional, 14, 2));
            A1892EscBasico = H00ER4_A1892EscBasico[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1892EscBasico", GXutil.ltrimstr( A1892EscBasico, 14, 2));
            /* Execute user event: Load */
            e14ER2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
         wbER0( ) ;
      }
   }

   public void send_integrity_lvl_hashesER2( )
   {
   }

   public void before_start_formulas( )
   {
      AV19Pgmname = "EscalaSalarialGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupER0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13ER2 ();
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
         wcpOA8CatCodigo = httpContext.cgiGet( sPrefix+"wcpOA8CatCodigo") ;
         wcpOA907CatVigencia = localUtil.ctod( httpContext.cgiGet( sPrefix+"wcpOA907CatVigencia"), 0) ;
         /* Read variables values. */
         A1892EscBasico = localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1892EscBasico", GXutil.ltrimstr( A1892EscBasico, 14, 2));
         A1893EscAdicional = localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1893EscAdicional", GXutil.ltrimstr( A1893EscAdicional, 14, 2));
         dynCatSalRelSec.setValue( httpContext.cgiGet( dynCatSalRelSec.getInternalname()) );
         A1891CatSalRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynCatSalRelSec.getInternalname()))) ;
         n1891CatSalRelSec = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1891CatSalRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1891CatSalRelSec), 6, 0));
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
      e13ER2 ();
      if (returnInSub) return;
   }

   public void e13ER2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      escalasalarialgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14ER2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEscalaSalarial_Update", GXv_boolean5) ;
      escalasalarialgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEscalaSalarial_Delete", GXv_boolean5) ;
      escalasalarialgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
      if ( ! ( ( AV17Essistemaconceptosdefault.doubleValue() == ( 1 )) || ( AV18Clienteconveniador ) ) )
      {
         dynCatSalRelSec.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynCatSalRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCatSalRelSec.getVisible(), 5, 0), true);
         divCatsalrelsec_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
      }
      else
      {
         dynCatSalRelSec.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynCatSalRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCatSalRelSec.getVisible(), 5, 0), true);
         divCatsalrelsec_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
      }
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV8TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV19Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "EscalaSalarial" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15ER2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      escalasalarialgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
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
      A8CatCodigo = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A8CatCodigo", A8CatCodigo);
      A907CatVigencia = (java.util.Date)getParm(obj,4,TypeConstants.DATE) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
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
      paER2( ) ;
      wsER2( ) ;
      weER2( ) ;
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
      sCtrlA8CatCodigo = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlA907CatVigencia = (String)getParm(obj,4,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paER2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "escalasalarialgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paER2( ) ;
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
         A8CatCodigo = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A8CatCodigo", A8CatCodigo);
         A907CatVigencia = (java.util.Date)getParm(obj,6,TypeConstants.DATE) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1565CliConvenio = httpContext.cgiGet( sPrefix+"wcpOA1565CliConvenio") ;
      wcpOA8CatCodigo = httpContext.cgiGet( sPrefix+"wcpOA8CatCodigo") ;
      wcpOA907CatVigencia = localUtil.ctod( httpContext.cgiGet( sPrefix+"wcpOA907CatVigencia"), 0) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1564CliPaiConve != wcpOA1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, wcpOA1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, wcpOA8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(wcpOA907CatVigencia)) ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1564CliPaiConve = A1564CliPaiConve ;
      wcpOA1565CliConvenio = A1565CliConvenio ;
      wcpOA8CatCodigo = A8CatCodigo ;
      wcpOA907CatVigencia = A907CatVigencia ;
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
      sCtrlA8CatCodigo = httpContext.cgiGet( sPrefix+"A8CatCodigo_CTRL") ;
      if ( GXutil.len( sCtrlA8CatCodigo) > 0 )
      {
         A8CatCodigo = httpContext.cgiGet( sCtrlA8CatCodigo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A8CatCodigo", A8CatCodigo);
      }
      else
      {
         A8CatCodigo = httpContext.cgiGet( sPrefix+"A8CatCodigo_PARM") ;
      }
      sCtrlA907CatVigencia = httpContext.cgiGet( sPrefix+"A907CatVigencia_CTRL") ;
      if ( GXutil.len( sCtrlA907CatVigencia) > 0 )
      {
         A907CatVigencia = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( sCtrlA907CatVigencia), 0)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
      }
      else
      {
         A907CatVigencia = localUtil.ctod( httpContext.cgiGet( sPrefix+"A907CatVigencia_PARM"), 0) ;
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
      paER2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsER2( ) ;
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
      wsER2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A8CatCodigo_PARM", GXutil.rtrim( A8CatCodigo));
      if ( GXutil.len( GXutil.rtrim( sCtrlA8CatCodigo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A8CatCodigo_CTRL", GXutil.rtrim( sCtrlA8CatCodigo));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A907CatVigencia_PARM", localUtil.dtoc( A907CatVigencia, 0, "/"));
      if ( GXutil.len( GXutil.rtrim( sCtrlA907CatVigencia)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A907CatVigencia_CTRL", GXutil.rtrim( sCtrlA907CatVigencia));
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
      weER2( ) ;
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
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713381731", true, true);
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
      httpContext.AddJavascriptSource("escalasalarialgeneral.js", "?20251713381731", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynCatCodigo.setInternalname( sPrefix+"CATCODIGO" );
      edtCatVigencia_Internalname = sPrefix+"CATVIGENCIA" ;
      edtEscBasico_Internalname = sPrefix+"ESCBASICO" ;
      edtEscAdicional_Internalname = sPrefix+"ESCADICIONAL" ;
      dynCatSalRelSec.setInternalname( sPrefix+"CATSALRELSEC" );
      divCatsalrelsec_cell_Internalname = sPrefix+"CATSALRELSEC_CELL" ;
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtCliPaiConve_Internalname = sPrefix+"CLIPAICONVE" ;
      edtCliConvenio_Internalname = sPrefix+"CLICONVENIO" ;
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
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      dynCatSalRelSec.setJsonclick( "" );
      dynCatSalRelSec.setEnabled( 0 );
      dynCatSalRelSec.setVisible( 1 );
      divCatsalrelsec_cell_Class = "col-xs-12" ;
      edtEscAdicional_Jsonclick = "" ;
      edtEscAdicional_Enabled = 0 ;
      edtEscBasico_Jsonclick = "" ;
      edtEscBasico_Enabled = 0 ;
      edtCatVigencia_Jsonclick = "" ;
      edtCatVigencia_Enabled = 0 ;
      dynCatCodigo.setJsonclick( "" );
      dynCatCodigo.setEnabled( 0 );
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
      dynCatCodigo.setName( "CATCODIGO" );
      dynCatCodigo.setWebtags( "" );
      dynCatSalRelSec.setName( "CATSALRELSEC" );
      dynCatSalRelSec.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''},{av:'A907CatVigencia',fld:'CATVIGENCIA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11ER1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''},{av:'A907CatVigencia',fld:'CATVIGENCIA',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12ER1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''},{av:'A907CatVigencia',fld:'CATVIGENCIA',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CATCODIGO","{handler:'valid_Catcodigo',iparms:[]");
      setEventMetadata("VALID_CATCODIGO",",oparms:[]}");
      setEventMetadata("VALID_CATVIGENCIA","{handler:'valid_Catvigencia',iparms:[]");
      setEventMetadata("VALID_CATVIGENCIA",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[]}");
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
      wcpOA8CatCodigo = "" ;
      wcpOA907CatVigencia = GXutil.nullDate() ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      AV21Cliconvenio = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
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
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H00ER2_A3CliCod = new int[1] ;
      H00ER2_A1564CliPaiConve = new short[1] ;
      H00ER2_A1565CliConvenio = new String[] {""} ;
      H00ER2_A8CatCodigo = new String[] {""} ;
      H00ER2_A123CatDescrip = new String[] {""} ;
      H00ER3_A3CliCod = new int[1] ;
      H00ER3_A1885CliRelSec = new int[1] ;
      H00ER3_A1880CliReDTChar = new String[] {""} ;
      AV19Pgmname = "" ;
      H00ER4_A3CliCod = new int[1] ;
      H00ER4_A1564CliPaiConve = new short[1] ;
      H00ER4_A1565CliConvenio = new String[] {""} ;
      H00ER4_A8CatCodigo = new String[] {""} ;
      H00ER4_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      H00ER4_A1891CatSalRelSec = new int[1] ;
      H00ER4_n1891CatSalRelSec = new boolean[] {false} ;
      H00ER4_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00ER4_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV17Essistemaconceptosdefault = DecimalUtil.ZERO ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1564CliPaiConve = "" ;
      sCtrlA1565CliConvenio = "" ;
      sCtrlA8CatCodigo = "" ;
      sCtrlA907CatVigencia = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.escalasalarialgeneral__default(),
         new Object[] {
             new Object[] {
            H00ER2_A3CliCod, H00ER2_A1564CliPaiConve, H00ER2_A1565CliConvenio, H00ER2_A8CatCodigo, H00ER2_A123CatDescrip
            }
            , new Object[] {
            H00ER3_A3CliCod, H00ER3_A1885CliRelSec, H00ER3_A1880CliReDTChar
            }
            , new Object[] {
            H00ER4_A3CliCod, H00ER4_A1564CliPaiConve, H00ER4_A1565CliConvenio, H00ER4_A8CatCodigo, H00ER4_A907CatVigencia, H00ER4_A1891CatSalRelSec, H00ER4_n1891CatSalRelSec, H00ER4_A1893EscAdicional, H00ER4_A1892EscBasico
            }
         }
      );
      AV19Pgmname = "EscalaSalarialGeneral" ;
      /* GeneXus formulas. */
      AV19Pgmname = "EscalaSalarialGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1564CliPaiConve ;
   private short A1564CliPaiConve ;
   private short AV20Clipaiconve ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int AV13CliCod ;
   private int edtCatVigencia_Enabled ;
   private int edtEscBasico_Enabled ;
   private int edtEscAdicional_Enabled ;
   private int A1891CatSalRelSec ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtCliPaiConve_Visible ;
   private int edtCliConvenio_Visible ;
   private int gxdynajaxindex ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private java.math.BigDecimal AV17Essistemaconceptosdefault ;
   private String wcpOA1565CliConvenio ;
   private String wcpOA8CatCodigo ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String AV21Cliconvenio ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtCatVigencia_Internalname ;
   private String edtCatVigencia_Jsonclick ;
   private String edtEscBasico_Internalname ;
   private String edtEscBasico_Jsonclick ;
   private String edtEscAdicional_Internalname ;
   private String edtEscAdicional_Jsonclick ;
   private String divCatsalrelsec_cell_Internalname ;
   private String divCatsalrelsec_cell_Class ;
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
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Internalname ;
   private String edtCliConvenio_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV19Pgmname ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1564CliPaiConve ;
   private String sCtrlA1565CliConvenio ;
   private String sCtrlA8CatCodigo ;
   private String sCtrlA907CatVigencia ;
   private java.util.Date wcpOA907CatVigencia ;
   private java.util.Date A907CatVigencia ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1891CatSalRelSec ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean AV18Clienteconveniador ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private HTMLChoice dynCatCodigo ;
   private HTMLChoice dynCatSalRelSec ;
   private IDataStoreProvider pr_default ;
   private int[] H00ER2_A3CliCod ;
   private short[] H00ER2_A1564CliPaiConve ;
   private String[] H00ER2_A1565CliConvenio ;
   private String[] H00ER2_A8CatCodigo ;
   private String[] H00ER2_A123CatDescrip ;
   private int[] H00ER3_A3CliCod ;
   private int[] H00ER3_A1885CliRelSec ;
   private String[] H00ER3_A1880CliReDTChar ;
   private int[] H00ER4_A3CliCod ;
   private short[] H00ER4_A1564CliPaiConve ;
   private String[] H00ER4_A1565CliConvenio ;
   private String[] H00ER4_A8CatCodigo ;
   private java.util.Date[] H00ER4_A907CatVigencia ;
   private int[] H00ER4_A1891CatSalRelSec ;
   private boolean[] H00ER4_n1891CatSalRelSec ;
   private java.math.BigDecimal[] H00ER4_A1893EscAdicional ;
   private java.math.BigDecimal[] H00ER4_A1892EscBasico ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class escalasalarialgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00ER2", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatDescrip FROM Categoria1 WHERE (CliCod = ?) AND (CliPaiConve = ?) AND (CliConvenio = ( ?)) ORDER BY CatDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00ER3", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00ER4", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia, CatSalRelSec, EscAdicional, EscBasico FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatVigencia = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}
