package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_legajomigrlegupd_impl extends GXWebComponent
{
   public importacion_legajomigrlegupd_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_legajomigrlegupd_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_legajomigrlegupd_impl.class ));
   }

   public importacion_legajomigrlegupd_impl( int remoteHandle ,
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
      cmbMigrLegModTra = new HTMLChoice();
      cmbMigrLegClase = new HTMLChoice();
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
               A87MigrLegNumero = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1EmpCod),Integer.valueOf(A87MigrLegNumero)});
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
         pa8Z2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "importacion_legajo Migr Leg UPD", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importacion_legajomigrlegupd", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A87MigrLegNumero,8,0))}, new String[] {"CliCod","EmpCod","MigrLegNumero"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOA1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA87MigrLegNumero", GXutil.ltrim( localUtil.ntoc( wcpOA87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseForm8Z2( )
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
      return "importacion_legajoMigrLegUPD" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "importacion_legajo Migr Leg UPD", "") ;
   }

   public void wb8Z0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.importacion_legajomigrlegupd");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegId_Internalname, httpContext.getMessage( "ID/Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegId_Internalname, GXutil.rtrim( A626MigrLegId), GXutil.rtrim( localUtil.format( A626MigrLegId, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegId_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegCUIL_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegCUIL_Internalname, httpContext.getMessage( "CUIL", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCUIL_Internalname, GXutil.rtrim( A597MigrLegCUIL), GXutil.rtrim( localUtil.format( A597MigrLegCUIL, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCUIL_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegCUIL_Enabled, 0, "text", "", 13, "chr", 1, "row", 13, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Cuit", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegApellido_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegApellido_Internalname, httpContext.getMessage( "Apellido", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegApellido_Internalname, A592MigrLegApellido, "", "", (short)(0), 1, edtMigrLegApellido_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegNombre_Internalname, httpContext.getMessage( "Nombres", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegNombre_Internalname, A593MigrLegNombre, "", "", (short)(0), 1, edtMigrLegNombre_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegmodtra_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegmodtra_Internalname, httpContext.getMessage( "Relación laboral", ""), "", "", lblTextblockmigrlegmodtra_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table1_37_8Z2( true) ;
      }
      else
      {
         wb_table1_37_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table1_37_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegclase_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegclase_Internalname, httpContext.getMessage( "Frecuencia de pago", ""), "", "", lblTextblockmigrlegclase_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table2_51_8Z2( true) ;
      }
      else
      {
         wb_table2_51_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table2_51_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegFecNac_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegFecNac_Internalname, httpContext.getMessage( "Fecha de Nacimiento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtMigrLegFecNac_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFecNac_Internalname, localUtil.format(A594MigrLegFecNac, "99/99/9999"), localUtil.format( A594MigrLegFecNac, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFecNac_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegFecNac_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtMigrLegFecNac_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMigrLegFecNac_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_importacion_legajoMigrLegUPD.htm");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegFecIngreso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegFecIngreso_Internalname, httpContext.getMessage( "Fecha de Ingreso", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtMigrLegFecIngreso_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFecIngreso_Internalname, localUtil.format(A603MigrLegFecIngreso, "99/99/9999"), localUtil.format( A603MigrLegFecIngreso, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFecIngreso_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegFecIngreso_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtMigrLegFecIngreso_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMigrLegFecIngreso_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_importacion_legajoMigrLegUPD.htm");
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
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegsexo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegsexo_Internalname, httpContext.getMessage( "Sexo", ""), "", "", lblTextblockmigrlegsexo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table3_75_8Z2( true) ;
      }
      else
      {
         wb_table3_75_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table3_75_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegDomici_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegDomici_Internalname, httpContext.getMessage( "Domicilio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegDomici_Internalname, A599MigrLegDomici, "", "", (short)(0), 1, edtMigrLegDomici_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "4000", -1, 0, "", "", (byte)(-1), true, "VarcharTextArea", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegCodPos_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegCodPos_Internalname, httpContext.getMessage( "Código Postal", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegCodPos_Internalname, A601MigrLegCodPos, "", "", (short)(0), 1, edtMigrLegCodPos_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegTelefono_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegTelefono_Internalname, httpContext.getMessage( "Teléfono", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegTelefono_Internalname, A602MigrLegTelefono, "", "", (short)(0), 1, edtMigrLegTelefono_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegEmail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegEmail_Internalname, httpContext.getMessage( "Email", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegEmail_Internalname, A600MigrLegEmail, GXutil.rtrim( localUtil.format( A600MigrLegEmail, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegEmail_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegEmail_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegestadocivil_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegestadocivil_Internalname, httpContext.getMessage( "Estado Civil", ""), "", "", lblTextblockmigrlegestadocivil_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table4_109_8Z2( true) ;
      }
      else
      {
         wb_table4_109_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table4_109_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegarea_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegarea_Internalname, httpContext.getMessage( "Área", ""), "", "", lblTextblockmigrlegarea_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table5_123_8Z2( true) ;
      }
      else
      {
         wb_table5_123_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table5_123_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegsindicato_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegsindicato_Internalname, httpContext.getMessage( "Sindicato", ""), "", "", lblTextblockmigrlegsindicato_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table6_137_8Z2( true) ;
      }
      else
      {
         wb_table6_137_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table6_137_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegconvenio_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegconvenio_Internalname, httpContext.getMessage( "Convenio", ""), "", "", lblTextblockmigrlegconvenio_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table7_151_8Z2( true) ;
      }
      else
      {
         wb_table7_151_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table7_151_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegcategoria_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegcategoria_Internalname, httpContext.getMessage( "Categoría", ""), "", "", lblTextblockmigrlegcategoria_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table8_165_8Z2( true) ;
      }
      else
      {
         wb_table8_165_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table8_165_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegbanco_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegbanco_Internalname, httpContext.getMessage( "Banco", ""), "", "", lblTextblockmigrlegbanco_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table9_179_8Z2( true) ;
      }
      else
      {
         wb_table9_179_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table9_179_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegBasico_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegBasico_Internalname, httpContext.getMessage( "Básico", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A608MigrLegBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMigrLegBasico_Enabled!=0) ? localUtil.format( A608MigrLegBasico, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A608MigrLegBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegBasico_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegBasico_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegobrasocial_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegobrasocial_Internalname, httpContext.getMessage( "Obra Social", ""), "", "", lblTextblockmigrlegobrasocial_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table10_198_8Z2( true) ;
      }
      else
      {
         wb_table10_198_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table10_198_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegCBU_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegCBU_Internalname, httpContext.getMessage( "CBU", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCBU_Internalname, A621MigrLegCBU, GXutil.rtrim( localUtil.format( A621MigrLegCBU, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCBU_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegCBU_Enabled, 0, "text", "", 22, "chr", 1, "row", 22, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CBU", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegmodalidad_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegmodalidad_Internalname, httpContext.getMessage( "Modalidad AFIP", ""), "", "", lblTextblockmigrlegmodalidad_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table11_217_8Z2( true) ;
      }
      else
      {
         wb_table11_217_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table11_217_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegHorSem_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegHorSem_Internalname, httpContext.getMessage( "Horas normales semanales", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegHorSem_Internalname, GXutil.ltrim( localUtil.ntoc( A2275MigrLegHorSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMigrLegHorSem_Enabled!=0) ? localUtil.format( A2275MigrLegHorSem, "Z9.9") : localUtil.format( A2275MigrLegHorSem, "Z9.9"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegHorSem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegHorSem_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegzona_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegzona_Internalname, httpContext.getMessage( "Zona AFIP", ""), "", "", lblTextblockmigrlegzona_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table12_236_8Z2( true) ;
      }
      else
      {
         wb_table12_236_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table12_236_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegactividad_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegactividad_Internalname, httpContext.getMessage( "Actividad AFIP", ""), "", "", lblTextblockmigrlegactividad_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table13_250_8Z2( true) ;
      }
      else
      {
         wb_table13_250_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table13_250_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegcondicion_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegcondicion_Internalname, httpContext.getMessage( "Condición AFIP", ""), "", "", lblTextblockmigrlegcondicion_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table14_264_8Z2( true) ;
      }
      else
      {
         wb_table14_264_8Z2( false) ;
      }
      return  ;
   }

   public void wb_table14_264_8Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegActLabClas_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegActLabClas_Internalname, httpContext.getMessage( "Actividad laboral AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegActLabClas_Internalname, A2239MigrLegActLabClas, GXutil.rtrim( localUtil.format( A2239MigrLegActLabClas, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegActLabClas_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegActLabClas_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegPueAfip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegPueAfip_Internalname, httpContext.getMessage( "Puesto desempeñado AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegPueAfip_Internalname, A2240MigrLegPueAfip, "", "", (short)(0), 1, edtMigrLegPueAfip_Enabled, 0, 80, "chr", 4, "row", (byte)(0), StyleString, ClassString, "", "", "255", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegObs_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegObs_Internalname, httpContext.getMessage( "Observaciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegObs_Internalname, A628MigrLegObs, "", "", (short)(0), 1, edtMigrLegObs_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 290,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e118z1_client"+"'", TempTags, "", 2, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 292,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e128z1_client"+"'", TempTags, "", 2, "HLP_importacion_legajoMigrLegUPD.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A87MigrLegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegNumero_Visible, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegDiscapacidad_Internalname, GXutil.rtrim( A598MigrLegDiscapacidad), GXutil.rtrim( localUtil.format( A598MigrLegDiscapacidad, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegDiscapacidad_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegDiscapacidad_Visible, 0, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegOSAfip_Internalname, GXutil.rtrim( A634MigrLegOSAfip), GXutil.rtrim( localUtil.format( A634MigrLegOSAfip, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegOSAfip_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegOSAfip_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegLugarDePago_Internalname, A606MigrLegLugarDePago, GXutil.rtrim( localUtil.format( A606MigrLegLugarDePago, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegLugarDePago_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegLugarDePago_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegBanSuc_Internalname, A611MigrLegBanSuc, "", "", (short)(0), edtMigrLegBanSuc_Visible, 0, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegBanTipCuen_Internalname, A612MigrLegBanTipCuen, GXutil.rtrim( localUtil.format( A612MigrLegBanTipCuen, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegBanTipCuen_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegBanTipCuen_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCuentaBanc_Internalname, A619MigrLegCuentaBanc, GXutil.rtrim( localUtil.format( A619MigrLegCuentaBanc, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCuentaBanc_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegCuentaBanc_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegFormaPago_Internalname, A609MigrLegFormaPago, "", "", (short)(0), edtMigrLegFormaPago_Visible, 0, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegSituacionRevista_Internalname, A623MigrLegSituacionRevista, GXutil.rtrim( localUtil.format( A623MigrLegSituacionRevista, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegSituacionRevista_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegSituacionRevista_Visible, 0, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegSiniestrado_Internalname, A625MigrLegSiniestrado, "", "", (short)(0), edtMigrLegSiniestrado_Visible, 0, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegSCVO_Internalname, GXutil.rtrim( A622MigrLegSCVO), GXutil.rtrim( localUtil.format( A622MigrLegSCVO, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegSCVO_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegSCVO_Visible, 0, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegPlanMedico_Internalname, A615MigrLegPlanMedico, "", "", (short)(0), edtMigrLegPlanMedico_Visible, 0, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrTieneConyuge_Internalname, GXutil.rtrim( A631MigrTieneConyuge), GXutil.rtrim( localUtil.format( A631MigrTieneConyuge, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrTieneConyuge_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrTieneConyuge_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrCantidadHijos_Internalname, GXutil.ltrim( localUtil.ntoc( A632MigrCantidadHijos, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A632MigrCantidadHijos), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrCantidadHijos_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrCantidadHijos_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start8Z2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "importacion_legajo Migr Leg UPD", ""), (short)(0)) ;
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
            strup8Z0( ) ;
         }
      }
   }

   public void ws8Z2( )
   {
      start8Z2( ) ;
      evt8Z2( ) ;
   }

   public void evt8Z2( )
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
                              strup8Z0( ) ;
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
                              strup8Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e138Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e148Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e158Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8Z0( ) ;
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
                              strup8Z0( ) ;
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

   public void we8Z2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm8Z2( ) ;
         }
      }
   }

   public void pa8Z2( )
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
      if ( cmbMigrLegModTra.getItemCount() > 0 )
      {
         A2415MigrLegModTra = cmbMigrLegModTra.getValidValue(A2415MigrLegModTra) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2415MigrLegModTra", A2415MigrLegModTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegModTra.setValue( GXutil.rtrim( A2415MigrLegModTra) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbMigrLegModTra.getInternalname(), "Values", cmbMigrLegModTra.ToJavascriptSource(), true);
      }
      if ( cmbMigrLegClase.getItemCount() > 0 )
      {
         A607MigrLegClase = cmbMigrLegClase.getValidValue(A607MigrLegClase) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A607MigrLegClase", A607MigrLegClase);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegClase.setValue( GXutil.rtrim( A607MigrLegClase) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbMigrLegClase.getInternalname(), "Values", cmbMigrLegClase.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf8Z2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "importacion_legajoMigrLegUPD" ;
      Gx_err = (short)(0) ;
   }

   public void rf8Z2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e158Z2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H008Z2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A632MigrCantidadHijos = H008Z2_A632MigrCantidadHijos[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
            A631MigrTieneConyuge = H008Z2_A631MigrTieneConyuge[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
            A615MigrLegPlanMedico = H008Z2_A615MigrLegPlanMedico[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A615MigrLegPlanMedico", A615MigrLegPlanMedico);
            A622MigrLegSCVO = H008Z2_A622MigrLegSCVO[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A622MigrLegSCVO", A622MigrLegSCVO);
            A625MigrLegSiniestrado = H008Z2_A625MigrLegSiniestrado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
            A623MigrLegSituacionRevista = H008Z2_A623MigrLegSituacionRevista[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
            A609MigrLegFormaPago = H008Z2_A609MigrLegFormaPago[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
            A619MigrLegCuentaBanc = H008Z2_A619MigrLegCuentaBanc[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A619MigrLegCuentaBanc", A619MigrLegCuentaBanc);
            A612MigrLegBanTipCuen = H008Z2_A612MigrLegBanTipCuen[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
            A611MigrLegBanSuc = H008Z2_A611MigrLegBanSuc[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A611MigrLegBanSuc", A611MigrLegBanSuc);
            A606MigrLegLugarDePago = H008Z2_A606MigrLegLugarDePago[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A606MigrLegLugarDePago", A606MigrLegLugarDePago);
            A634MigrLegOSAfip = H008Z2_A634MigrLegOSAfip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
            A598MigrLegDiscapacidad = H008Z2_A598MigrLegDiscapacidad[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
            A628MigrLegObs = H008Z2_A628MigrLegObs[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A628MigrLegObs", A628MigrLegObs);
            A2240MigrLegPueAfip = H008Z2_A2240MigrLegPueAfip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2240MigrLegPueAfip", A2240MigrLegPueAfip);
            A2239MigrLegActLabClas = H008Z2_A2239MigrLegActLabClas[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2239MigrLegActLabClas", A2239MigrLegActLabClas);
            A624MigrLegCondicion = H008Z2_A624MigrLegCondicion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A624MigrLegCondicion", A624MigrLegCondicion);
            A616MigrLegActividad = H008Z2_A616MigrLegActividad[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A616MigrLegActividad", A616MigrLegActividad);
            A620MigrLegZona = H008Z2_A620MigrLegZona[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A620MigrLegZona", A620MigrLegZona);
            A2275MigrLegHorSem = H008Z2_A2275MigrLegHorSem[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2275MigrLegHorSem", GXutil.ltrimstr( A2275MigrLegHorSem, 4, 1));
            A617MigrLegModalidad = H008Z2_A617MigrLegModalidad[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A617MigrLegModalidad", A617MigrLegModalidad);
            A621MigrLegCBU = H008Z2_A621MigrLegCBU[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A621MigrLegCBU", A621MigrLegCBU);
            A614MigrLegObraSocial = H008Z2_A614MigrLegObraSocial[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
            A608MigrLegBasico = H008Z2_A608MigrLegBasico[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
            A610MigrLegBanco = H008Z2_A610MigrLegBanco[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A610MigrLegBanco", A610MigrLegBanco);
            A604MigrLegCategoria = H008Z2_A604MigrLegCategoria[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A604MigrLegCategoria", A604MigrLegCategoria);
            A627MigrLegConvenio = H008Z2_A627MigrLegConvenio[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A627MigrLegConvenio", A627MigrLegConvenio);
            A613MigrLegSindicato = H008Z2_A613MigrLegSindicato[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A613MigrLegSindicato", A613MigrLegSindicato);
            A605MigrLegArea = H008Z2_A605MigrLegArea[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A605MigrLegArea", A605MigrLegArea);
            A596MigrLegEstadoCivil = H008Z2_A596MigrLegEstadoCivil[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
            A600MigrLegEmail = H008Z2_A600MigrLegEmail[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A600MigrLegEmail", A600MigrLegEmail);
            A602MigrLegTelefono = H008Z2_A602MigrLegTelefono[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A602MigrLegTelefono", A602MigrLegTelefono);
            A601MigrLegCodPos = H008Z2_A601MigrLegCodPos[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A601MigrLegCodPos", A601MigrLegCodPos);
            A599MigrLegDomici = H008Z2_A599MigrLegDomici[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A599MigrLegDomici", A599MigrLegDomici);
            A595MigrLegSexo = H008Z2_A595MigrLegSexo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A595MigrLegSexo", A595MigrLegSexo);
            A603MigrLegFecIngreso = H008Z2_A603MigrLegFecIngreso[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
            A594MigrLegFecNac = H008Z2_A594MigrLegFecNac[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
            A607MigrLegClase = H008Z2_A607MigrLegClase[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A607MigrLegClase", A607MigrLegClase);
            A2415MigrLegModTra = H008Z2_A2415MigrLegModTra[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2415MigrLegModTra", A2415MigrLegModTra);
            A593MigrLegNombre = H008Z2_A593MigrLegNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A593MigrLegNombre", A593MigrLegNombre);
            A592MigrLegApellido = H008Z2_A592MigrLegApellido[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A592MigrLegApellido", A592MigrLegApellido);
            A597MigrLegCUIL = H008Z2_A597MigrLegCUIL[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A597MigrLegCUIL", A597MigrLegCUIL);
            A626MigrLegId = H008Z2_A626MigrLegId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A626MigrLegId", A626MigrLegId);
            /* Execute user event: Load */
            e148Z2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb8Z0( ) ;
      }
   }

   public void send_integrity_lvl_hashes8Z2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "importacion_legajoMigrLegUPD" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup8Z0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e138Z2 ();
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
         wcpOA87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA87MigrLegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A626MigrLegId = httpContext.cgiGet( edtMigrLegId_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A626MigrLegId", A626MigrLegId);
         A597MigrLegCUIL = httpContext.cgiGet( edtMigrLegCUIL_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A597MigrLegCUIL", A597MigrLegCUIL);
         A592MigrLegApellido = httpContext.cgiGet( edtMigrLegApellido_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A592MigrLegApellido", A592MigrLegApellido);
         A593MigrLegNombre = httpContext.cgiGet( edtMigrLegNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A593MigrLegNombre", A593MigrLegNombre);
         cmbMigrLegModTra.setValue( httpContext.cgiGet( cmbMigrLegModTra.getInternalname()) );
         A2415MigrLegModTra = httpContext.cgiGet( cmbMigrLegModTra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2415MigrLegModTra", A2415MigrLegModTra);
         cmbMigrLegClase.setValue( httpContext.cgiGet( cmbMigrLegClase.getInternalname()) );
         A607MigrLegClase = httpContext.cgiGet( cmbMigrLegClase.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A607MigrLegClase", A607MigrLegClase);
         A594MigrLegFecNac = localUtil.ctod( httpContext.cgiGet( edtMigrLegFecNac_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
         A603MigrLegFecIngreso = localUtil.ctod( httpContext.cgiGet( edtMigrLegFecIngreso_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
         A595MigrLegSexo = httpContext.cgiGet( edtMigrLegSexo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A595MigrLegSexo", A595MigrLegSexo);
         A599MigrLegDomici = httpContext.cgiGet( edtMigrLegDomici_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A599MigrLegDomici", A599MigrLegDomici);
         A601MigrLegCodPos = httpContext.cgiGet( edtMigrLegCodPos_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A601MigrLegCodPos", A601MigrLegCodPos);
         A602MigrLegTelefono = httpContext.cgiGet( edtMigrLegTelefono_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A602MigrLegTelefono", A602MigrLegTelefono);
         A600MigrLegEmail = httpContext.cgiGet( edtMigrLegEmail_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A600MigrLegEmail", A600MigrLegEmail);
         A596MigrLegEstadoCivil = httpContext.cgiGet( edtMigrLegEstadoCivil_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
         A605MigrLegArea = httpContext.cgiGet( edtMigrLegArea_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A605MigrLegArea", A605MigrLegArea);
         A613MigrLegSindicato = httpContext.cgiGet( edtMigrLegSindicato_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A613MigrLegSindicato", A613MigrLegSindicato);
         A627MigrLegConvenio = httpContext.cgiGet( edtMigrLegConvenio_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A627MigrLegConvenio", A627MigrLegConvenio);
         A604MigrLegCategoria = httpContext.cgiGet( edtMigrLegCategoria_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A604MigrLegCategoria", A604MigrLegCategoria);
         A610MigrLegBanco = httpContext.cgiGet( edtMigrLegBanco_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A610MigrLegBanco", A610MigrLegBanco);
         A608MigrLegBasico = localUtil.ctond( httpContext.cgiGet( edtMigrLegBasico_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
         A614MigrLegObraSocial = httpContext.cgiGet( edtMigrLegObraSocial_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
         A621MigrLegCBU = httpContext.cgiGet( edtMigrLegCBU_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A621MigrLegCBU", A621MigrLegCBU);
         A617MigrLegModalidad = httpContext.cgiGet( edtMigrLegModalidad_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A617MigrLegModalidad", A617MigrLegModalidad);
         A2275MigrLegHorSem = localUtil.ctond( httpContext.cgiGet( edtMigrLegHorSem_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2275MigrLegHorSem", GXutil.ltrimstr( A2275MigrLegHorSem, 4, 1));
         A620MigrLegZona = httpContext.cgiGet( edtMigrLegZona_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A620MigrLegZona", A620MigrLegZona);
         A616MigrLegActividad = httpContext.cgiGet( edtMigrLegActividad_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A616MigrLegActividad", A616MigrLegActividad);
         A624MigrLegCondicion = GXutil.upper( httpContext.cgiGet( edtMigrLegCondicion_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A624MigrLegCondicion", A624MigrLegCondicion);
         A2239MigrLegActLabClas = httpContext.cgiGet( edtMigrLegActLabClas_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2239MigrLegActLabClas", A2239MigrLegActLabClas);
         A2240MigrLegPueAfip = httpContext.cgiGet( edtMigrLegPueAfip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2240MigrLegPueAfip", A2240MigrLegPueAfip);
         A628MigrLegObs = httpContext.cgiGet( edtMigrLegObs_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A628MigrLegObs", A628MigrLegObs);
         A598MigrLegDiscapacidad = httpContext.cgiGet( edtMigrLegDiscapacidad_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
         A634MigrLegOSAfip = httpContext.cgiGet( edtMigrLegOSAfip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
         A606MigrLegLugarDePago = GXutil.upper( httpContext.cgiGet( edtMigrLegLugarDePago_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A606MigrLegLugarDePago", A606MigrLegLugarDePago);
         A611MigrLegBanSuc = httpContext.cgiGet( edtMigrLegBanSuc_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A611MigrLegBanSuc", A611MigrLegBanSuc);
         A612MigrLegBanTipCuen = GXutil.upper( httpContext.cgiGet( edtMigrLegBanTipCuen_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
         A619MigrLegCuentaBanc = GXutil.upper( httpContext.cgiGet( edtMigrLegCuentaBanc_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A619MigrLegCuentaBanc", A619MigrLegCuentaBanc);
         A609MigrLegFormaPago = httpContext.cgiGet( edtMigrLegFormaPago_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
         A623MigrLegSituacionRevista = GXutil.upper( httpContext.cgiGet( edtMigrLegSituacionRevista_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
         A625MigrLegSiniestrado = httpContext.cgiGet( edtMigrLegSiniestrado_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
         A622MigrLegSCVO = httpContext.cgiGet( edtMigrLegSCVO_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A622MigrLegSCVO", A622MigrLegSCVO);
         A615MigrLegPlanMedico = httpContext.cgiGet( edtMigrLegPlanMedico_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A615MigrLegPlanMedico", A615MigrLegPlanMedico);
         A631MigrTieneConyuge = httpContext.cgiGet( edtMigrTieneConyuge_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
         A632MigrCantidadHijos = (short)(localUtil.ctol( httpContext.cgiGet( edtMigrCantidadHijos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
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
      e138Z2 ();
      if (returnInSub) return;
   }

   public void e138Z2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      importacion_legajomigrlegupd_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e148Z2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtMigrLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Visible), 5, 0), true);
      edtMigrLegDiscapacidad_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegDiscapacidad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegDiscapacidad_Visible), 5, 0), true);
      edtMigrLegOSAfip_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegOSAfip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Visible), 5, 0), true);
      edtMigrLegLugarDePago_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegLugarDePago_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegLugarDePago_Visible), 5, 0), true);
      edtMigrLegBanSuc_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegBanSuc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanSuc_Visible), 5, 0), true);
      edtMigrLegBanTipCuen_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegBanTipCuen_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanTipCuen_Visible), 5, 0), true);
      edtMigrLegCuentaBanc_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegCuentaBanc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCuentaBanc_Visible), 5, 0), true);
      edtMigrLegFormaPago_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegFormaPago_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFormaPago_Visible), 5, 0), true);
      edtMigrLegSituacionRevista_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegSituacionRevista_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSituacionRevista_Visible), 5, 0), true);
      edtMigrLegSiniestrado_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegSiniestrado_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSiniestrado_Visible), 5, 0), true);
      edtMigrLegSCVO_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegSCVO_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSCVO_Visible), 5, 0), true);
      edtMigrLegPlanMedico_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrLegPlanMedico_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegPlanMedico_Visible), 5, 0), true);
      edtMigrTieneConyuge_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrTieneConyuge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrTieneConyuge_Visible), 5, 0), true);
      edtMigrCantidadHijos_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMigrCantidadHijos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrCantidadHijos_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMigrLegUPD_Update", GXv_boolean5) ;
      importacion_legajomigrlegupd_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMigrLegUPD_Delete", GXv_boolean5) ;
      importacion_legajomigrlegupd_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "MigrLegUPD" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e158Z2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      importacion_legajomigrlegupd_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   public void wb_table14_264_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegcondicion_Internalname, tblTablemergedmigrlegcondicion_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegCondicion_Internalname, httpContext.getMessage( "Condición", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCondicion_Internalname, A624MigrLegCondicion, GXutil.rtrim( localUtil.format( A624MigrLegCondicion, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCondicion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegCondicion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegcondicion_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegcondicion_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table14_264_8Z2e( true) ;
      }
      else
      {
         wb_table14_264_8Z2e( false) ;
      }
   }

   public void wb_table13_250_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegactividad_Internalname, tblTablemergedmigrlegactividad_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegActividad_Internalname, httpContext.getMessage( "Actividad", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegActividad_Internalname, A616MigrLegActividad, GXutil.rtrim( localUtil.format( A616MigrLegActividad, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegActividad_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegActividad_Enabled, 0, "text", "", 80, "chr", 1, "row", 150, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegactividad_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegactividad_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table13_250_8Z2e( true) ;
      }
      else
      {
         wb_table13_250_8Z2e( false) ;
      }
   }

   public void wb_table12_236_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegzona_Internalname, tblTablemergedmigrlegzona_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegZona_Internalname, httpContext.getMessage( "Zona", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegZona_Internalname, A620MigrLegZona, "", "", (short)(0), 1, edtMigrLegZona_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegzona_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegzona_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table12_236_8Z2e( true) ;
      }
      else
      {
         wb_table12_236_8Z2e( false) ;
      }
   }

   public void wb_table11_217_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegmodalidad_Internalname, tblTablemergedmigrlegmodalidad_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegModalidad_Internalname, httpContext.getMessage( "Migr Leg Modalidad", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegModalidad_Internalname, A617MigrLegModalidad, "", "", (short)(0), 1, edtMigrLegModalidad_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegmodalidad_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegmodalidad_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table11_217_8Z2e( true) ;
      }
      else
      {
         wb_table11_217_8Z2e( false) ;
      }
   }

   public void wb_table10_198_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegobrasocial_Internalname, tblTablemergedmigrlegobrasocial_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegObraSocial_Internalname, httpContext.getMessage( "Obra Social", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegObraSocial_Internalname, A614MigrLegObraSocial, "", "", (short)(0), 1, edtMigrLegObraSocial_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegobrasocial_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegobrasocial_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table10_198_8Z2e( true) ;
      }
      else
      {
         wb_table10_198_8Z2e( false) ;
      }
   }

   public void wb_table9_179_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegbanco_Internalname, tblTablemergedmigrlegbanco_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegBanco_Internalname, httpContext.getMessage( "Banco", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegBanco_Internalname, A610MigrLegBanco, "", "", (short)(0), 1, edtMigrLegBanco_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegbanco_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegbanco_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table9_179_8Z2e( true) ;
      }
      else
      {
         wb_table9_179_8Z2e( false) ;
      }
   }

   public void wb_table8_165_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegcategoria_Internalname, tblTablemergedmigrlegcategoria_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegCategoria_Internalname, httpContext.getMessage( "Categoría", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegCategoria_Internalname, A604MigrLegCategoria, "", "", (short)(0), 1, edtMigrLegCategoria_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegcategoria_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegcategoria_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table8_165_8Z2e( true) ;
      }
      else
      {
         wb_table8_165_8Z2e( false) ;
      }
   }

   public void wb_table7_151_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegconvenio_Internalname, tblTablemergedmigrlegconvenio_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegConvenio_Internalname, httpContext.getMessage( "Convenio", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegConvenio_Internalname, A627MigrLegConvenio, "", "", (short)(0), 1, edtMigrLegConvenio_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegconvenio_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegconvenio_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_151_8Z2e( true) ;
      }
      else
      {
         wb_table7_151_8Z2e( false) ;
      }
   }

   public void wb_table6_137_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegsindicato_Internalname, tblTablemergedmigrlegsindicato_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegSindicato_Internalname, httpContext.getMessage( "Sindicato", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegSindicato_Internalname, A613MigrLegSindicato, "", "", (short)(0), 1, edtMigrLegSindicato_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegsindicato_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegsindicato_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_137_8Z2e( true) ;
      }
      else
      {
         wb_table6_137_8Z2e( false) ;
      }
   }

   public void wb_table5_123_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegarea_Internalname, tblTablemergedmigrlegarea_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegArea_Internalname, httpContext.getMessage( "Área", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegArea_Internalname, A605MigrLegArea, "", "", (short)(0), 1, edtMigrLegArea_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegarea_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegarea_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_123_8Z2e( true) ;
      }
      else
      {
         wb_table5_123_8Z2e( false) ;
      }
   }

   public void wb_table4_109_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegestadocivil_Internalname, tblTablemergedmigrlegestadocivil_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegEstadoCivil_Internalname, httpContext.getMessage( "Estado Civil", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegEstadoCivil_Internalname, A596MigrLegEstadoCivil, "", "", (short)(0), 1, edtMigrLegEstadoCivil_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegestadocivil_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegestadocivil_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_109_8Z2e( true) ;
      }
      else
      {
         wb_table4_109_8Z2e( false) ;
      }
   }

   public void wb_table3_75_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegsexo_Internalname, tblTablemergedmigrlegsexo_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMigrLegSexo_Internalname, httpContext.getMessage( "Sexo", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegSexo_Internalname, GXutil.rtrim( A595MigrLegSexo), GXutil.rtrim( localUtil.format( A595MigrLegSexo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegSexo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegSexo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoMigrLegUPD.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegsexo_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegsexo_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_75_8Z2e( true) ;
      }
      else
      {
         wb_table3_75_8Z2e( false) ;
      }
   }

   public void wb_table2_51_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegclase_Internalname, tblTablemergedmigrlegclase_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbMigrLegClase.getInternalname(), httpContext.getMessage( "Frecuencia de pago", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegClase, cmbMigrLegClase.getInternalname(), GXutil.rtrim( A607MigrLegClase), 1, cmbMigrLegClase.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegClase.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         cmbMigrLegClase.setValue( GXutil.rtrim( A607MigrLegClase) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbMigrLegClase.getInternalname(), "Values", cmbMigrLegClase.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegclase_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegclase_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_51_8Z2e( true) ;
      }
      else
      {
         wb_table2_51_8Z2e( false) ;
      }
   }

   public void wb_table1_37_8Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegmodtra_Internalname, tblTablemergedmigrlegmodtra_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbMigrLegModTra.getInternalname(), httpContext.getMessage( "Relación laboral", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegModTra, cmbMigrLegModTra.getInternalname(), GXutil.rtrim( A2415MigrLegModTra), 1, cmbMigrLegModTra.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegModTra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         cmbMigrLegModTra.setValue( GXutil.rtrim( A2415MigrLegModTra) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbMigrLegModTra.getInternalname(), "Values", cmbMigrLegModTra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegmodtra_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegmodtra_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoMigrLegUPD.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_37_8Z2e( true) ;
      }
      else
      {
         wb_table1_37_8Z2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A87MigrLegNumero = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
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
      pa8Z2( ) ;
      ws8Z2( ) ;
      we8Z2( ) ;
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
      sCtrlA87MigrLegNumero = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa8Z2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "importacion_legajomigrlegupd", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa8Z2( ) ;
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
         A87MigrLegNumero = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA87MigrLegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1EmpCod != wcpOA1EmpCod ) || ( A87MigrLegNumero != wcpOA87MigrLegNumero ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1EmpCod = A1EmpCod ;
      wcpOA87MigrLegNumero = A87MigrLegNumero ;
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
      sCtrlA87MigrLegNumero = httpContext.cgiGet( sPrefix+"A87MigrLegNumero_CTRL") ;
      if ( GXutil.len( sCtrlA87MigrLegNumero) > 0 )
      {
         A87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlA87MigrLegNumero), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      }
      else
      {
         A87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A87MigrLegNumero_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      pa8Z2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws8Z2( ) ;
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
      ws8Z2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A87MigrLegNumero_PARM", GXutil.ltrim( localUtil.ntoc( A87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA87MigrLegNumero)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A87MigrLegNumero_CTRL", GXutil.rtrim( sCtrlA87MigrLegNumero));
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
      we8Z2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202513174288", true, true);
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
      httpContext.AddJavascriptSource("importacion_legajomigrlegupd.js", "?202513174288", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtMigrLegId_Internalname = sPrefix+"MIGRLEGID" ;
      edtMigrLegCUIL_Internalname = sPrefix+"MIGRLEGCUIL" ;
      edtMigrLegApellido_Internalname = sPrefix+"MIGRLEGAPELLIDO" ;
      edtMigrLegNombre_Internalname = sPrefix+"MIGRLEGNOMBRE" ;
      lblTextblockmigrlegmodtra_Internalname = sPrefix+"TEXTBLOCKMIGRLEGMODTRA" ;
      cmbMigrLegModTra.setInternalname( sPrefix+"MIGRLEGMODTRA" );
      lblMigrlegmodtra_righttext_Internalname = sPrefix+"MIGRLEGMODTRA_RIGHTTEXT" ;
      tblTablemergedmigrlegmodtra_Internalname = sPrefix+"TABLEMERGEDMIGRLEGMODTRA" ;
      divTablesplittedmigrlegmodtra_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGMODTRA" ;
      lblTextblockmigrlegclase_Internalname = sPrefix+"TEXTBLOCKMIGRLEGCLASE" ;
      cmbMigrLegClase.setInternalname( sPrefix+"MIGRLEGCLASE" );
      lblMigrlegclase_righttext_Internalname = sPrefix+"MIGRLEGCLASE_RIGHTTEXT" ;
      tblTablemergedmigrlegclase_Internalname = sPrefix+"TABLEMERGEDMIGRLEGCLASE" ;
      divTablesplittedmigrlegclase_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGCLASE" ;
      edtMigrLegFecNac_Internalname = sPrefix+"MIGRLEGFECNAC" ;
      edtMigrLegFecIngreso_Internalname = sPrefix+"MIGRLEGFECINGRESO" ;
      lblTextblockmigrlegsexo_Internalname = sPrefix+"TEXTBLOCKMIGRLEGSEXO" ;
      edtMigrLegSexo_Internalname = sPrefix+"MIGRLEGSEXO" ;
      lblMigrlegsexo_righttext_Internalname = sPrefix+"MIGRLEGSEXO_RIGHTTEXT" ;
      tblTablemergedmigrlegsexo_Internalname = sPrefix+"TABLEMERGEDMIGRLEGSEXO" ;
      divTablesplittedmigrlegsexo_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGSEXO" ;
      edtMigrLegDomici_Internalname = sPrefix+"MIGRLEGDOMICI" ;
      edtMigrLegCodPos_Internalname = sPrefix+"MIGRLEGCODPOS" ;
      edtMigrLegTelefono_Internalname = sPrefix+"MIGRLEGTELEFONO" ;
      edtMigrLegEmail_Internalname = sPrefix+"MIGRLEGEMAIL" ;
      lblTextblockmigrlegestadocivil_Internalname = sPrefix+"TEXTBLOCKMIGRLEGESTADOCIVIL" ;
      edtMigrLegEstadoCivil_Internalname = sPrefix+"MIGRLEGESTADOCIVIL" ;
      lblMigrlegestadocivil_righttext_Internalname = sPrefix+"MIGRLEGESTADOCIVIL_RIGHTTEXT" ;
      tblTablemergedmigrlegestadocivil_Internalname = sPrefix+"TABLEMERGEDMIGRLEGESTADOCIVIL" ;
      divTablesplittedmigrlegestadocivil_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGESTADOCIVIL" ;
      lblTextblockmigrlegarea_Internalname = sPrefix+"TEXTBLOCKMIGRLEGAREA" ;
      edtMigrLegArea_Internalname = sPrefix+"MIGRLEGAREA" ;
      lblMigrlegarea_righttext_Internalname = sPrefix+"MIGRLEGAREA_RIGHTTEXT" ;
      tblTablemergedmigrlegarea_Internalname = sPrefix+"TABLEMERGEDMIGRLEGAREA" ;
      divTablesplittedmigrlegarea_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGAREA" ;
      lblTextblockmigrlegsindicato_Internalname = sPrefix+"TEXTBLOCKMIGRLEGSINDICATO" ;
      edtMigrLegSindicato_Internalname = sPrefix+"MIGRLEGSINDICATO" ;
      lblMigrlegsindicato_righttext_Internalname = sPrefix+"MIGRLEGSINDICATO_RIGHTTEXT" ;
      tblTablemergedmigrlegsindicato_Internalname = sPrefix+"TABLEMERGEDMIGRLEGSINDICATO" ;
      divTablesplittedmigrlegsindicato_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGSINDICATO" ;
      lblTextblockmigrlegconvenio_Internalname = sPrefix+"TEXTBLOCKMIGRLEGCONVENIO" ;
      edtMigrLegConvenio_Internalname = sPrefix+"MIGRLEGCONVENIO" ;
      lblMigrlegconvenio_righttext_Internalname = sPrefix+"MIGRLEGCONVENIO_RIGHTTEXT" ;
      tblTablemergedmigrlegconvenio_Internalname = sPrefix+"TABLEMERGEDMIGRLEGCONVENIO" ;
      divTablesplittedmigrlegconvenio_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGCONVENIO" ;
      lblTextblockmigrlegcategoria_Internalname = sPrefix+"TEXTBLOCKMIGRLEGCATEGORIA" ;
      edtMigrLegCategoria_Internalname = sPrefix+"MIGRLEGCATEGORIA" ;
      lblMigrlegcategoria_righttext_Internalname = sPrefix+"MIGRLEGCATEGORIA_RIGHTTEXT" ;
      tblTablemergedmigrlegcategoria_Internalname = sPrefix+"TABLEMERGEDMIGRLEGCATEGORIA" ;
      divTablesplittedmigrlegcategoria_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGCATEGORIA" ;
      lblTextblockmigrlegbanco_Internalname = sPrefix+"TEXTBLOCKMIGRLEGBANCO" ;
      edtMigrLegBanco_Internalname = sPrefix+"MIGRLEGBANCO" ;
      lblMigrlegbanco_righttext_Internalname = sPrefix+"MIGRLEGBANCO_RIGHTTEXT" ;
      tblTablemergedmigrlegbanco_Internalname = sPrefix+"TABLEMERGEDMIGRLEGBANCO" ;
      divTablesplittedmigrlegbanco_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGBANCO" ;
      edtMigrLegBasico_Internalname = sPrefix+"MIGRLEGBASICO" ;
      lblTextblockmigrlegobrasocial_Internalname = sPrefix+"TEXTBLOCKMIGRLEGOBRASOCIAL" ;
      edtMigrLegObraSocial_Internalname = sPrefix+"MIGRLEGOBRASOCIAL" ;
      lblMigrlegobrasocial_righttext_Internalname = sPrefix+"MIGRLEGOBRASOCIAL_RIGHTTEXT" ;
      tblTablemergedmigrlegobrasocial_Internalname = sPrefix+"TABLEMERGEDMIGRLEGOBRASOCIAL" ;
      divTablesplittedmigrlegobrasocial_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGOBRASOCIAL" ;
      edtMigrLegCBU_Internalname = sPrefix+"MIGRLEGCBU" ;
      lblTextblockmigrlegmodalidad_Internalname = sPrefix+"TEXTBLOCKMIGRLEGMODALIDAD" ;
      edtMigrLegModalidad_Internalname = sPrefix+"MIGRLEGMODALIDAD" ;
      lblMigrlegmodalidad_righttext_Internalname = sPrefix+"MIGRLEGMODALIDAD_RIGHTTEXT" ;
      tblTablemergedmigrlegmodalidad_Internalname = sPrefix+"TABLEMERGEDMIGRLEGMODALIDAD" ;
      divTablesplittedmigrlegmodalidad_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGMODALIDAD" ;
      edtMigrLegHorSem_Internalname = sPrefix+"MIGRLEGHORSEM" ;
      lblTextblockmigrlegzona_Internalname = sPrefix+"TEXTBLOCKMIGRLEGZONA" ;
      edtMigrLegZona_Internalname = sPrefix+"MIGRLEGZONA" ;
      lblMigrlegzona_righttext_Internalname = sPrefix+"MIGRLEGZONA_RIGHTTEXT" ;
      tblTablemergedmigrlegzona_Internalname = sPrefix+"TABLEMERGEDMIGRLEGZONA" ;
      divTablesplittedmigrlegzona_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGZONA" ;
      lblTextblockmigrlegactividad_Internalname = sPrefix+"TEXTBLOCKMIGRLEGACTIVIDAD" ;
      edtMigrLegActividad_Internalname = sPrefix+"MIGRLEGACTIVIDAD" ;
      lblMigrlegactividad_righttext_Internalname = sPrefix+"MIGRLEGACTIVIDAD_RIGHTTEXT" ;
      tblTablemergedmigrlegactividad_Internalname = sPrefix+"TABLEMERGEDMIGRLEGACTIVIDAD" ;
      divTablesplittedmigrlegactividad_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGACTIVIDAD" ;
      lblTextblockmigrlegcondicion_Internalname = sPrefix+"TEXTBLOCKMIGRLEGCONDICION" ;
      edtMigrLegCondicion_Internalname = sPrefix+"MIGRLEGCONDICION" ;
      lblMigrlegcondicion_righttext_Internalname = sPrefix+"MIGRLEGCONDICION_RIGHTTEXT" ;
      tblTablemergedmigrlegcondicion_Internalname = sPrefix+"TABLEMERGEDMIGRLEGCONDICION" ;
      divTablesplittedmigrlegcondicion_Internalname = sPrefix+"TABLESPLITTEDMIGRLEGCONDICION" ;
      edtMigrLegActLabClas_Internalname = sPrefix+"MIGRLEGACTLABCLAS" ;
      edtMigrLegPueAfip_Internalname = sPrefix+"MIGRLEGPUEAFIP" ;
      edtMigrLegObs_Internalname = sPrefix+"MIGRLEGOBS" ;
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtMigrLegNumero_Internalname = sPrefix+"MIGRLEGNUMERO" ;
      edtMigrLegDiscapacidad_Internalname = sPrefix+"MIGRLEGDISCAPACIDAD" ;
      edtMigrLegOSAfip_Internalname = sPrefix+"MIGRLEGOSAFIP" ;
      edtMigrLegLugarDePago_Internalname = sPrefix+"MIGRLEGLUGARDEPAGO" ;
      edtMigrLegBanSuc_Internalname = sPrefix+"MIGRLEGBANSUC" ;
      edtMigrLegBanTipCuen_Internalname = sPrefix+"MIGRLEGBANTIPCUEN" ;
      edtMigrLegCuentaBanc_Internalname = sPrefix+"MIGRLEGCUENTABANC" ;
      edtMigrLegFormaPago_Internalname = sPrefix+"MIGRLEGFORMAPAGO" ;
      edtMigrLegSituacionRevista_Internalname = sPrefix+"MIGRLEGSITUACIONREVISTA" ;
      edtMigrLegSiniestrado_Internalname = sPrefix+"MIGRLEGSINIESTRADO" ;
      edtMigrLegSCVO_Internalname = sPrefix+"MIGRLEGSCVO" ;
      edtMigrLegPlanMedico_Internalname = sPrefix+"MIGRLEGPLANMEDICO" ;
      edtMigrTieneConyuge_Internalname = sPrefix+"MIGRTIENECONYUGE" ;
      edtMigrCantidadHijos_Internalname = sPrefix+"MIGRCANTIDADHIJOS" ;
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
      cmbMigrLegModTra.setJsonclick( "" );
      cmbMigrLegModTra.setEnabled( 0 );
      cmbMigrLegClase.setJsonclick( "" );
      cmbMigrLegClase.setEnabled( 0 );
      edtMigrLegSexo_Jsonclick = "" ;
      edtMigrLegSexo_Enabled = 0 ;
      edtMigrLegEstadoCivil_Enabled = 0 ;
      edtMigrLegArea_Enabled = 0 ;
      edtMigrLegSindicato_Enabled = 0 ;
      edtMigrLegConvenio_Enabled = 0 ;
      edtMigrLegCategoria_Enabled = 0 ;
      edtMigrLegBanco_Enabled = 0 ;
      edtMigrLegObraSocial_Enabled = 0 ;
      edtMigrLegModalidad_Enabled = 0 ;
      edtMigrLegZona_Enabled = 0 ;
      edtMigrLegActividad_Jsonclick = "" ;
      edtMigrLegActividad_Enabled = 0 ;
      edtMigrLegCondicion_Jsonclick = "" ;
      edtMigrLegCondicion_Enabled = 0 ;
      edtMigrCantidadHijos_Jsonclick = "" ;
      edtMigrCantidadHijos_Visible = 1 ;
      edtMigrTieneConyuge_Jsonclick = "" ;
      edtMigrTieneConyuge_Visible = 1 ;
      edtMigrLegPlanMedico_Visible = 1 ;
      edtMigrLegSCVO_Jsonclick = "" ;
      edtMigrLegSCVO_Visible = 1 ;
      edtMigrLegSiniestrado_Visible = 1 ;
      edtMigrLegSituacionRevista_Jsonclick = "" ;
      edtMigrLegSituacionRevista_Visible = 1 ;
      edtMigrLegFormaPago_Visible = 1 ;
      edtMigrLegCuentaBanc_Jsonclick = "" ;
      edtMigrLegCuentaBanc_Visible = 1 ;
      edtMigrLegBanTipCuen_Jsonclick = "" ;
      edtMigrLegBanTipCuen_Visible = 1 ;
      edtMigrLegBanSuc_Visible = 1 ;
      edtMigrLegLugarDePago_Jsonclick = "" ;
      edtMigrLegLugarDePago_Visible = 1 ;
      edtMigrLegOSAfip_Jsonclick = "" ;
      edtMigrLegOSAfip_Visible = 1 ;
      edtMigrLegDiscapacidad_Jsonclick = "" ;
      edtMigrLegDiscapacidad_Visible = 1 ;
      edtMigrLegNumero_Jsonclick = "" ;
      edtMigrLegNumero_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      edtMigrLegObs_Enabled = 0 ;
      edtMigrLegPueAfip_Enabled = 0 ;
      edtMigrLegActLabClas_Jsonclick = "" ;
      edtMigrLegActLabClas_Enabled = 0 ;
      edtMigrLegHorSem_Jsonclick = "" ;
      edtMigrLegHorSem_Enabled = 0 ;
      edtMigrLegCBU_Jsonclick = "" ;
      edtMigrLegCBU_Enabled = 0 ;
      edtMigrLegBasico_Jsonclick = "" ;
      edtMigrLegBasico_Enabled = 0 ;
      edtMigrLegEmail_Jsonclick = "" ;
      edtMigrLegEmail_Enabled = 0 ;
      edtMigrLegTelefono_Enabled = 0 ;
      edtMigrLegCodPos_Enabled = 0 ;
      edtMigrLegDomici_Enabled = 0 ;
      edtMigrLegFecIngreso_Jsonclick = "" ;
      edtMigrLegFecIngreso_Enabled = 0 ;
      edtMigrLegFecNac_Jsonclick = "" ;
      edtMigrLegFecNac_Enabled = 0 ;
      edtMigrLegNombre_Enabled = 0 ;
      edtMigrLegApellido_Enabled = 0 ;
      edtMigrLegCUIL_Jsonclick = "" ;
      edtMigrLegCUIL_Enabled = 0 ;
      edtMigrLegId_Jsonclick = "" ;
      edtMigrLegId_Enabled = 0 ;
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
      cmbMigrLegModTra.setName( "MIGRLEGMODTRA" );
      cmbMigrLegModTra.setWebtags( "" );
      if ( cmbMigrLegModTra.getItemCount() > 0 )
      {
      }
      cmbMigrLegClase.setName( "MIGRLEGCLASE" );
      cmbMigrLegClase.setWebtags( "" );
      if ( cmbMigrLegClase.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e118Z1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e128Z1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGNUMERO","{handler:'valid_Migrlegnumero',iparms:[]");
      setEventMetadata("VALID_MIGRLEGNUMERO",",oparms:[]}");
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
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A626MigrLegId = "" ;
      A597MigrLegCUIL = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A592MigrLegApellido = "" ;
      A593MigrLegNombre = "" ;
      lblTextblockmigrlegmodtra_Jsonclick = "" ;
      lblTextblockmigrlegclase_Jsonclick = "" ;
      A594MigrLegFecNac = GXutil.nullDate() ;
      A603MigrLegFecIngreso = GXutil.nullDate() ;
      lblTextblockmigrlegsexo_Jsonclick = "" ;
      A599MigrLegDomici = "" ;
      A601MigrLegCodPos = "" ;
      A602MigrLegTelefono = "" ;
      A600MigrLegEmail = "" ;
      lblTextblockmigrlegestadocivil_Jsonclick = "" ;
      lblTextblockmigrlegarea_Jsonclick = "" ;
      lblTextblockmigrlegsindicato_Jsonclick = "" ;
      lblTextblockmigrlegconvenio_Jsonclick = "" ;
      lblTextblockmigrlegcategoria_Jsonclick = "" ;
      lblTextblockmigrlegbanco_Jsonclick = "" ;
      A608MigrLegBasico = DecimalUtil.ZERO ;
      lblTextblockmigrlegobrasocial_Jsonclick = "" ;
      A621MigrLegCBU = "" ;
      lblTextblockmigrlegmodalidad_Jsonclick = "" ;
      A2275MigrLegHorSem = DecimalUtil.ZERO ;
      lblTextblockmigrlegzona_Jsonclick = "" ;
      lblTextblockmigrlegactividad_Jsonclick = "" ;
      lblTextblockmigrlegcondicion_Jsonclick = "" ;
      A2239MigrLegActLabClas = "" ;
      A2240MigrLegPueAfip = "" ;
      A628MigrLegObs = "" ;
      TempTags = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      A598MigrLegDiscapacidad = "" ;
      A634MigrLegOSAfip = "" ;
      A606MigrLegLugarDePago = "" ;
      A611MigrLegBanSuc = "" ;
      A612MigrLegBanTipCuen = "" ;
      A619MigrLegCuentaBanc = "" ;
      A609MigrLegFormaPago = "" ;
      A623MigrLegSituacionRevista = "" ;
      A625MigrLegSiniestrado = "" ;
      A622MigrLegSCVO = "" ;
      A615MigrLegPlanMedico = "" ;
      A631MigrTieneConyuge = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A2415MigrLegModTra = "" ;
      A607MigrLegClase = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      H008Z2_A3CliCod = new int[1] ;
      H008Z2_A1EmpCod = new short[1] ;
      H008Z2_A87MigrLegNumero = new int[1] ;
      H008Z2_A632MigrCantidadHijos = new short[1] ;
      H008Z2_A631MigrTieneConyuge = new String[] {""} ;
      H008Z2_A615MigrLegPlanMedico = new String[] {""} ;
      H008Z2_A622MigrLegSCVO = new String[] {""} ;
      H008Z2_A625MigrLegSiniestrado = new String[] {""} ;
      H008Z2_A623MigrLegSituacionRevista = new String[] {""} ;
      H008Z2_A609MigrLegFormaPago = new String[] {""} ;
      H008Z2_A619MigrLegCuentaBanc = new String[] {""} ;
      H008Z2_A612MigrLegBanTipCuen = new String[] {""} ;
      H008Z2_A611MigrLegBanSuc = new String[] {""} ;
      H008Z2_A606MigrLegLugarDePago = new String[] {""} ;
      H008Z2_A634MigrLegOSAfip = new String[] {""} ;
      H008Z2_A598MigrLegDiscapacidad = new String[] {""} ;
      H008Z2_A628MigrLegObs = new String[] {""} ;
      H008Z2_A2240MigrLegPueAfip = new String[] {""} ;
      H008Z2_A2239MigrLegActLabClas = new String[] {""} ;
      H008Z2_A624MigrLegCondicion = new String[] {""} ;
      H008Z2_A616MigrLegActividad = new String[] {""} ;
      H008Z2_A620MigrLegZona = new String[] {""} ;
      H008Z2_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H008Z2_A617MigrLegModalidad = new String[] {""} ;
      H008Z2_A621MigrLegCBU = new String[] {""} ;
      H008Z2_A614MigrLegObraSocial = new String[] {""} ;
      H008Z2_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H008Z2_A610MigrLegBanco = new String[] {""} ;
      H008Z2_A604MigrLegCategoria = new String[] {""} ;
      H008Z2_A627MigrLegConvenio = new String[] {""} ;
      H008Z2_A613MigrLegSindicato = new String[] {""} ;
      H008Z2_A605MigrLegArea = new String[] {""} ;
      H008Z2_A596MigrLegEstadoCivil = new String[] {""} ;
      H008Z2_A600MigrLegEmail = new String[] {""} ;
      H008Z2_A602MigrLegTelefono = new String[] {""} ;
      H008Z2_A601MigrLegCodPos = new String[] {""} ;
      H008Z2_A599MigrLegDomici = new String[] {""} ;
      H008Z2_A595MigrLegSexo = new String[] {""} ;
      H008Z2_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      H008Z2_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      H008Z2_A607MigrLegClase = new String[] {""} ;
      H008Z2_A2415MigrLegModTra = new String[] {""} ;
      H008Z2_A593MigrLegNombre = new String[] {""} ;
      H008Z2_A592MigrLegApellido = new String[] {""} ;
      H008Z2_A597MigrLegCUIL = new String[] {""} ;
      H008Z2_A626MigrLegId = new String[] {""} ;
      A624MigrLegCondicion = "" ;
      A616MigrLegActividad = "" ;
      A620MigrLegZona = "" ;
      A617MigrLegModalidad = "" ;
      A614MigrLegObraSocial = "" ;
      A610MigrLegBanco = "" ;
      A604MigrLegCategoria = "" ;
      A627MigrLegConvenio = "" ;
      A613MigrLegSindicato = "" ;
      A605MigrLegArea = "" ;
      A596MigrLegEstadoCivil = "" ;
      A595MigrLegSexo = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      sStyleString = "" ;
      lblMigrlegcondicion_righttext_Jsonclick = "" ;
      lblMigrlegactividad_righttext_Jsonclick = "" ;
      lblMigrlegzona_righttext_Jsonclick = "" ;
      lblMigrlegmodalidad_righttext_Jsonclick = "" ;
      lblMigrlegobrasocial_righttext_Jsonclick = "" ;
      lblMigrlegbanco_righttext_Jsonclick = "" ;
      lblMigrlegcategoria_righttext_Jsonclick = "" ;
      lblMigrlegconvenio_righttext_Jsonclick = "" ;
      lblMigrlegsindicato_righttext_Jsonclick = "" ;
      lblMigrlegarea_righttext_Jsonclick = "" ;
      lblMigrlegestadocivil_righttext_Jsonclick = "" ;
      lblMigrlegsexo_righttext_Jsonclick = "" ;
      lblMigrlegclase_righttext_Jsonclick = "" ;
      lblMigrlegmodtra_righttext_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1EmpCod = "" ;
      sCtrlA87MigrLegNumero = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_legajomigrlegupd__default(),
         new Object[] {
             new Object[] {
            H008Z2_A3CliCod, H008Z2_A1EmpCod, H008Z2_A87MigrLegNumero, H008Z2_A632MigrCantidadHijos, H008Z2_A631MigrTieneConyuge, H008Z2_A615MigrLegPlanMedico, H008Z2_A622MigrLegSCVO, H008Z2_A625MigrLegSiniestrado, H008Z2_A623MigrLegSituacionRevista, H008Z2_A609MigrLegFormaPago,
            H008Z2_A619MigrLegCuentaBanc, H008Z2_A612MigrLegBanTipCuen, H008Z2_A611MigrLegBanSuc, H008Z2_A606MigrLegLugarDePago, H008Z2_A634MigrLegOSAfip, H008Z2_A598MigrLegDiscapacidad, H008Z2_A628MigrLegObs, H008Z2_A2240MigrLegPueAfip, H008Z2_A2239MigrLegActLabClas, H008Z2_A624MigrLegCondicion,
            H008Z2_A616MigrLegActividad, H008Z2_A620MigrLegZona, H008Z2_A2275MigrLegHorSem, H008Z2_A617MigrLegModalidad, H008Z2_A621MigrLegCBU, H008Z2_A614MigrLegObraSocial, H008Z2_A608MigrLegBasico, H008Z2_A610MigrLegBanco, H008Z2_A604MigrLegCategoria, H008Z2_A627MigrLegConvenio,
            H008Z2_A613MigrLegSindicato, H008Z2_A605MigrLegArea, H008Z2_A596MigrLegEstadoCivil, H008Z2_A600MigrLegEmail, H008Z2_A602MigrLegTelefono, H008Z2_A601MigrLegCodPos, H008Z2_A599MigrLegDomici, H008Z2_A595MigrLegSexo, H008Z2_A603MigrLegFecIngreso, H008Z2_A594MigrLegFecNac,
            H008Z2_A607MigrLegClase, H008Z2_A2415MigrLegModTra, H008Z2_A593MigrLegNombre, H008Z2_A592MigrLegApellido, H008Z2_A597MigrLegCUIL, H008Z2_A626MigrLegId
            }
         }
      );
      AV17Pgmname = "importacion_legajoMigrLegUPD" ;
      /* GeneXus formulas. */
      AV17Pgmname = "importacion_legajoMigrLegUPD" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A632MigrCantidadHijos ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int wcpOA87MigrLegNumero ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private int edtMigrLegId_Enabled ;
   private int edtMigrLegCUIL_Enabled ;
   private int edtMigrLegApellido_Enabled ;
   private int edtMigrLegNombre_Enabled ;
   private int edtMigrLegFecNac_Enabled ;
   private int edtMigrLegFecIngreso_Enabled ;
   private int edtMigrLegDomici_Enabled ;
   private int edtMigrLegCodPos_Enabled ;
   private int edtMigrLegTelefono_Enabled ;
   private int edtMigrLegEmail_Enabled ;
   private int edtMigrLegBasico_Enabled ;
   private int edtMigrLegCBU_Enabled ;
   private int edtMigrLegHorSem_Enabled ;
   private int edtMigrLegActLabClas_Enabled ;
   private int edtMigrLegPueAfip_Enabled ;
   private int edtMigrLegObs_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtEmpCod_Visible ;
   private int edtMigrLegNumero_Visible ;
   private int edtMigrLegDiscapacidad_Visible ;
   private int edtMigrLegOSAfip_Visible ;
   private int edtMigrLegLugarDePago_Visible ;
   private int edtMigrLegBanSuc_Visible ;
   private int edtMigrLegBanTipCuen_Visible ;
   private int edtMigrLegCuentaBanc_Visible ;
   private int edtMigrLegFormaPago_Visible ;
   private int edtMigrLegSituacionRevista_Visible ;
   private int edtMigrLegSiniestrado_Visible ;
   private int edtMigrLegSCVO_Visible ;
   private int edtMigrLegPlanMedico_Visible ;
   private int edtMigrTieneConyuge_Visible ;
   private int edtMigrCantidadHijos_Visible ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtMigrLegCondicion_Enabled ;
   private int edtMigrLegActividad_Enabled ;
   private int edtMigrLegZona_Enabled ;
   private int edtMigrLegModalidad_Enabled ;
   private int edtMigrLegObraSocial_Enabled ;
   private int edtMigrLegBanco_Enabled ;
   private int edtMigrLegCategoria_Enabled ;
   private int edtMigrLegConvenio_Enabled ;
   private int edtMigrLegSindicato_Enabled ;
   private int edtMigrLegArea_Enabled ;
   private int edtMigrLegEstadoCivil_Enabled ;
   private int edtMigrLegSexo_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal A608MigrLegBasico ;
   private java.math.BigDecimal A2275MigrLegHorSem ;
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
   private String edtMigrLegId_Internalname ;
   private String A626MigrLegId ;
   private String edtMigrLegId_Jsonclick ;
   private String edtMigrLegCUIL_Internalname ;
   private String A597MigrLegCUIL ;
   private String edtMigrLegCUIL_Jsonclick ;
   private String edtMigrLegApellido_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtMigrLegNombre_Internalname ;
   private String divTablesplittedmigrlegmodtra_Internalname ;
   private String lblTextblockmigrlegmodtra_Internalname ;
   private String lblTextblockmigrlegmodtra_Jsonclick ;
   private String divTablesplittedmigrlegclase_Internalname ;
   private String lblTextblockmigrlegclase_Internalname ;
   private String lblTextblockmigrlegclase_Jsonclick ;
   private String edtMigrLegFecNac_Internalname ;
   private String edtMigrLegFecNac_Jsonclick ;
   private String edtMigrLegFecIngreso_Internalname ;
   private String edtMigrLegFecIngreso_Jsonclick ;
   private String divTablesplittedmigrlegsexo_Internalname ;
   private String lblTextblockmigrlegsexo_Internalname ;
   private String lblTextblockmigrlegsexo_Jsonclick ;
   private String edtMigrLegDomici_Internalname ;
   private String edtMigrLegCodPos_Internalname ;
   private String edtMigrLegTelefono_Internalname ;
   private String edtMigrLegEmail_Internalname ;
   private String edtMigrLegEmail_Jsonclick ;
   private String divTablesplittedmigrlegestadocivil_Internalname ;
   private String lblTextblockmigrlegestadocivil_Internalname ;
   private String lblTextblockmigrlegestadocivil_Jsonclick ;
   private String divTablesplittedmigrlegarea_Internalname ;
   private String lblTextblockmigrlegarea_Internalname ;
   private String lblTextblockmigrlegarea_Jsonclick ;
   private String divTablesplittedmigrlegsindicato_Internalname ;
   private String lblTextblockmigrlegsindicato_Internalname ;
   private String lblTextblockmigrlegsindicato_Jsonclick ;
   private String divTablesplittedmigrlegconvenio_Internalname ;
   private String lblTextblockmigrlegconvenio_Internalname ;
   private String lblTextblockmigrlegconvenio_Jsonclick ;
   private String divTablesplittedmigrlegcategoria_Internalname ;
   private String lblTextblockmigrlegcategoria_Internalname ;
   private String lblTextblockmigrlegcategoria_Jsonclick ;
   private String divTablesplittedmigrlegbanco_Internalname ;
   private String lblTextblockmigrlegbanco_Internalname ;
   private String lblTextblockmigrlegbanco_Jsonclick ;
   private String edtMigrLegBasico_Internalname ;
   private String edtMigrLegBasico_Jsonclick ;
   private String divTablesplittedmigrlegobrasocial_Internalname ;
   private String lblTextblockmigrlegobrasocial_Internalname ;
   private String lblTextblockmigrlegobrasocial_Jsonclick ;
   private String edtMigrLegCBU_Internalname ;
   private String edtMigrLegCBU_Jsonclick ;
   private String divTablesplittedmigrlegmodalidad_Internalname ;
   private String lblTextblockmigrlegmodalidad_Internalname ;
   private String lblTextblockmigrlegmodalidad_Jsonclick ;
   private String edtMigrLegHorSem_Internalname ;
   private String edtMigrLegHorSem_Jsonclick ;
   private String divTablesplittedmigrlegzona_Internalname ;
   private String lblTextblockmigrlegzona_Internalname ;
   private String lblTextblockmigrlegzona_Jsonclick ;
   private String divTablesplittedmigrlegactividad_Internalname ;
   private String lblTextblockmigrlegactividad_Internalname ;
   private String lblTextblockmigrlegactividad_Jsonclick ;
   private String divTablesplittedmigrlegcondicion_Internalname ;
   private String lblTextblockmigrlegcondicion_Internalname ;
   private String lblTextblockmigrlegcondicion_Jsonclick ;
   private String edtMigrLegActLabClas_Internalname ;
   private String edtMigrLegActLabClas_Jsonclick ;
   private String edtMigrLegPueAfip_Internalname ;
   private String edtMigrLegObs_Internalname ;
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
   private String edtMigrLegNumero_Internalname ;
   private String edtMigrLegNumero_Jsonclick ;
   private String edtMigrLegDiscapacidad_Internalname ;
   private String A598MigrLegDiscapacidad ;
   private String edtMigrLegDiscapacidad_Jsonclick ;
   private String edtMigrLegOSAfip_Internalname ;
   private String A634MigrLegOSAfip ;
   private String edtMigrLegOSAfip_Jsonclick ;
   private String edtMigrLegLugarDePago_Internalname ;
   private String edtMigrLegLugarDePago_Jsonclick ;
   private String edtMigrLegBanSuc_Internalname ;
   private String edtMigrLegBanTipCuen_Internalname ;
   private String edtMigrLegBanTipCuen_Jsonclick ;
   private String edtMigrLegCuentaBanc_Internalname ;
   private String edtMigrLegCuentaBanc_Jsonclick ;
   private String edtMigrLegFormaPago_Internalname ;
   private String edtMigrLegSituacionRevista_Internalname ;
   private String edtMigrLegSituacionRevista_Jsonclick ;
   private String edtMigrLegSiniestrado_Internalname ;
   private String edtMigrLegSCVO_Internalname ;
   private String A622MigrLegSCVO ;
   private String edtMigrLegSCVO_Jsonclick ;
   private String edtMigrLegPlanMedico_Internalname ;
   private String edtMigrTieneConyuge_Internalname ;
   private String A631MigrTieneConyuge ;
   private String edtMigrTieneConyuge_Jsonclick ;
   private String edtMigrCantidadHijos_Internalname ;
   private String edtMigrCantidadHijos_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A595MigrLegSexo ;
   private String edtMigrLegSexo_Internalname ;
   private String edtMigrLegEstadoCivil_Internalname ;
   private String edtMigrLegArea_Internalname ;
   private String edtMigrLegSindicato_Internalname ;
   private String edtMigrLegConvenio_Internalname ;
   private String edtMigrLegCategoria_Internalname ;
   private String edtMigrLegBanco_Internalname ;
   private String edtMigrLegObraSocial_Internalname ;
   private String edtMigrLegModalidad_Internalname ;
   private String edtMigrLegZona_Internalname ;
   private String edtMigrLegActividad_Internalname ;
   private String edtMigrLegCondicion_Internalname ;
   private String sStyleString ;
   private String tblTablemergedmigrlegcondicion_Internalname ;
   private String edtMigrLegCondicion_Jsonclick ;
   private String lblMigrlegcondicion_righttext_Internalname ;
   private String lblMigrlegcondicion_righttext_Jsonclick ;
   private String tblTablemergedmigrlegactividad_Internalname ;
   private String edtMigrLegActividad_Jsonclick ;
   private String lblMigrlegactividad_righttext_Internalname ;
   private String lblMigrlegactividad_righttext_Jsonclick ;
   private String tblTablemergedmigrlegzona_Internalname ;
   private String lblMigrlegzona_righttext_Internalname ;
   private String lblMigrlegzona_righttext_Jsonclick ;
   private String tblTablemergedmigrlegmodalidad_Internalname ;
   private String lblMigrlegmodalidad_righttext_Internalname ;
   private String lblMigrlegmodalidad_righttext_Jsonclick ;
   private String tblTablemergedmigrlegobrasocial_Internalname ;
   private String lblMigrlegobrasocial_righttext_Internalname ;
   private String lblMigrlegobrasocial_righttext_Jsonclick ;
   private String tblTablemergedmigrlegbanco_Internalname ;
   private String lblMigrlegbanco_righttext_Internalname ;
   private String lblMigrlegbanco_righttext_Jsonclick ;
   private String tblTablemergedmigrlegcategoria_Internalname ;
   private String lblMigrlegcategoria_righttext_Internalname ;
   private String lblMigrlegcategoria_righttext_Jsonclick ;
   private String tblTablemergedmigrlegconvenio_Internalname ;
   private String lblMigrlegconvenio_righttext_Internalname ;
   private String lblMigrlegconvenio_righttext_Jsonclick ;
   private String tblTablemergedmigrlegsindicato_Internalname ;
   private String lblMigrlegsindicato_righttext_Internalname ;
   private String lblMigrlegsindicato_righttext_Jsonclick ;
   private String tblTablemergedmigrlegarea_Internalname ;
   private String lblMigrlegarea_righttext_Internalname ;
   private String lblMigrlegarea_righttext_Jsonclick ;
   private String tblTablemergedmigrlegestadocivil_Internalname ;
   private String lblMigrlegestadocivil_righttext_Internalname ;
   private String lblMigrlegestadocivil_righttext_Jsonclick ;
   private String tblTablemergedmigrlegsexo_Internalname ;
   private String edtMigrLegSexo_Jsonclick ;
   private String lblMigrlegsexo_righttext_Internalname ;
   private String lblMigrlegsexo_righttext_Jsonclick ;
   private String tblTablemergedmigrlegclase_Internalname ;
   private String lblMigrlegclase_righttext_Internalname ;
   private String lblMigrlegclase_righttext_Jsonclick ;
   private String tblTablemergedmigrlegmodtra_Internalname ;
   private String lblMigrlegmodtra_righttext_Internalname ;
   private String lblMigrlegmodtra_righttext_Jsonclick ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1EmpCod ;
   private String sCtrlA87MigrLegNumero ;
   private java.util.Date A594MigrLegFecNac ;
   private java.util.Date A603MigrLegFecIngreso ;
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
   private String A628MigrLegObs ;
   private String A592MigrLegApellido ;
   private String A593MigrLegNombre ;
   private String A599MigrLegDomici ;
   private String A601MigrLegCodPos ;
   private String A602MigrLegTelefono ;
   private String A600MigrLegEmail ;
   private String A621MigrLegCBU ;
   private String A2239MigrLegActLabClas ;
   private String A2240MigrLegPueAfip ;
   private String A606MigrLegLugarDePago ;
   private String A611MigrLegBanSuc ;
   private String A612MigrLegBanTipCuen ;
   private String A619MigrLegCuentaBanc ;
   private String A609MigrLegFormaPago ;
   private String A623MigrLegSituacionRevista ;
   private String A625MigrLegSiniestrado ;
   private String A615MigrLegPlanMedico ;
   private String A2415MigrLegModTra ;
   private String A607MigrLegClase ;
   private String A624MigrLegCondicion ;
   private String A616MigrLegActividad ;
   private String A620MigrLegZona ;
   private String A617MigrLegModalidad ;
   private String A614MigrLegObraSocial ;
   private String A610MigrLegBanco ;
   private String A604MigrLegCategoria ;
   private String A627MigrLegConvenio ;
   private String A613MigrLegSindicato ;
   private String A605MigrLegArea ;
   private String A596MigrLegEstadoCivil ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private HTMLChoice cmbMigrLegModTra ;
   private HTMLChoice cmbMigrLegClase ;
   private IDataStoreProvider pr_default ;
   private int[] H008Z2_A3CliCod ;
   private short[] H008Z2_A1EmpCod ;
   private int[] H008Z2_A87MigrLegNumero ;
   private short[] H008Z2_A632MigrCantidadHijos ;
   private String[] H008Z2_A631MigrTieneConyuge ;
   private String[] H008Z2_A615MigrLegPlanMedico ;
   private String[] H008Z2_A622MigrLegSCVO ;
   private String[] H008Z2_A625MigrLegSiniestrado ;
   private String[] H008Z2_A623MigrLegSituacionRevista ;
   private String[] H008Z2_A609MigrLegFormaPago ;
   private String[] H008Z2_A619MigrLegCuentaBanc ;
   private String[] H008Z2_A612MigrLegBanTipCuen ;
   private String[] H008Z2_A611MigrLegBanSuc ;
   private String[] H008Z2_A606MigrLegLugarDePago ;
   private String[] H008Z2_A634MigrLegOSAfip ;
   private String[] H008Z2_A598MigrLegDiscapacidad ;
   private String[] H008Z2_A628MigrLegObs ;
   private String[] H008Z2_A2240MigrLegPueAfip ;
   private String[] H008Z2_A2239MigrLegActLabClas ;
   private String[] H008Z2_A624MigrLegCondicion ;
   private String[] H008Z2_A616MigrLegActividad ;
   private String[] H008Z2_A620MigrLegZona ;
   private java.math.BigDecimal[] H008Z2_A2275MigrLegHorSem ;
   private String[] H008Z2_A617MigrLegModalidad ;
   private String[] H008Z2_A621MigrLegCBU ;
   private String[] H008Z2_A614MigrLegObraSocial ;
   private java.math.BigDecimal[] H008Z2_A608MigrLegBasico ;
   private String[] H008Z2_A610MigrLegBanco ;
   private String[] H008Z2_A604MigrLegCategoria ;
   private String[] H008Z2_A627MigrLegConvenio ;
   private String[] H008Z2_A613MigrLegSindicato ;
   private String[] H008Z2_A605MigrLegArea ;
   private String[] H008Z2_A596MigrLegEstadoCivil ;
   private String[] H008Z2_A600MigrLegEmail ;
   private String[] H008Z2_A602MigrLegTelefono ;
   private String[] H008Z2_A601MigrLegCodPos ;
   private String[] H008Z2_A599MigrLegDomici ;
   private String[] H008Z2_A595MigrLegSexo ;
   private java.util.Date[] H008Z2_A603MigrLegFecIngreso ;
   private java.util.Date[] H008Z2_A594MigrLegFecNac ;
   private String[] H008Z2_A607MigrLegClase ;
   private String[] H008Z2_A2415MigrLegModTra ;
   private String[] H008Z2_A593MigrLegNombre ;
   private String[] H008Z2_A592MigrLegApellido ;
   private String[] H008Z2_A597MigrLegCUIL ;
   private String[] H008Z2_A626MigrLegId ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class importacion_legajomigrlegupd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H008Z2", "SELECT CliCod, EmpCod, MigrLegNumero, MigrCantidadHijos, MigrTieneConyuge, MigrLegPlanMedico, MigrLegSCVO, MigrLegSiniestrado, MigrLegSituacionRevista, MigrLegFormaPago, MigrLegCuentaBanc, MigrLegBanTipCuen, MigrLegBanSuc, MigrLegLugarDePago, MigrLegOSAfip, MigrLegDiscapacidad, MigrLegObs, MigrLegPueAfip, MigrLegActLabClas, MigrLegCondicion, MigrLegActividad, MigrLegZona, MigrLegHorSem, MigrLegModalidad, MigrLegCBU, MigrLegObraSocial, MigrLegBasico, MigrLegBanco, MigrLegCategoria, MigrLegConvenio, MigrLegSindicato, MigrLegArea, MigrLegEstadoCivil, MigrLegEmail, MigrLegTelefono, MigrLegCodPos, MigrLegDomici, MigrLegSexo, MigrLegFecIngreso, MigrLegFecNac, MigrLegClase, MigrLegModTra, MigrLegNombre, MigrLegApellido, MigrLegCUIL, MigrLegId FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((String[]) buf[15])[0] = rslt.getString(16, 2);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,1);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(27,2);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((String[]) buf[31])[0] = rslt.getVarchar(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getVarchar(36);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getString(38, 20);
               ((java.util.Date[]) buf[38])[0] = rslt.getGXDate(39);
               ((java.util.Date[]) buf[39])[0] = rslt.getGXDate(40);
               ((String[]) buf[40])[0] = rslt.getVarchar(41);
               ((String[]) buf[41])[0] = rslt.getVarchar(42);
               ((String[]) buf[42])[0] = rslt.getVarchar(43);
               ((String[]) buf[43])[0] = rslt.getVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 13);
               ((String[]) buf[45])[0] = rslt.getString(46, 20);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

