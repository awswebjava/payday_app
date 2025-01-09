package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresabase_calculogeneral_impl extends GXWebComponent
{
   public empresabase_calculogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresabase_calculogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresabase_calculogeneral_impl.class ));
   }

   public empresabase_calculogeneral_impl( int remoteHandle ,
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
      dynEmpCod = new HTMLChoice();
      cmbEmpBaseClaseLeg = new HTMLChoice();
      cmbEmpBaseTipo = new HTMLChoice();
      cmbEmpBaseCod1 = new HTMLChoice();
      cmbEmpBaseCod2 = new HTMLChoice();
      cmbEmpLicDMes = new HTMLChoice();
      chkEmpLicAdju = UIFactory.getCheckbox(this);
      chkEmpLicAdjuObl = UIFactory.getCheckbox(this);
      chkEmpLicNecAut = UIFactory.getCheckbox(this);
      chkEmpLicIngMot = UIFactory.getCheckbox(this);
      chkEmpLicMotObl = UIFactory.getCheckbox(this);
      cmbEmpBasePromTCnt = new HTMLChoice();
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
               A1427EmpBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "EmpBaseClaseLeg"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
               A1429EmpBaseTipo = httpContext.GetPar( "EmpBaseTipo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
               A1430EmpBaseCod1 = httpContext.GetPar( "EmpBaseCod1") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
               A1431EmpBaseCod2 = httpContext.GetPar( "EmpBaseCod2") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1EmpCod),Byte.valueOf(A1427EmpBaseClaseLeg),A1429EmpBaseTipo,A1430EmpBaseCod1,A1431EmpBaseCod2});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"EMPCOD") == 0 )
            {
               AV13CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlaempcodKK2( AV13CliCod) ;
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
         paKK2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Empresabase_calculo General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empresabase_calculogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1427EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(A1429EmpBaseTipo)),GXutil.URLEncode(GXutil.rtrim(A1430EmpBaseCod1)),GXutil.URLEncode(GXutil.rtrim(A1431EmpBaseCod2))}, new String[] {"CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1427EmpBaseClaseLeg", GXutil.ltrim( localUtil.ntoc( wcpOA1427EmpBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1429EmpBaseTipo", GXutil.rtrim( wcpOA1429EmpBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1430EmpBaseCod1", GXutil.rtrim( wcpOA1430EmpBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1431EmpBaseCod2", GXutil.rtrim( wcpOA1431EmpBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV13CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormKK2( )
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
      return "Empresabase_calculoGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Empresabase_calculo General", "") ;
   }

   public void wbKK0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.empresabase_calculogeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynEmpCod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynEmpCod.getInternalname(), httpContext.getMessage( "Empresa", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynEmpCod, dynEmpCod.getInternalname(), GXutil.trim( GXutil.str( A1EmpCod, 4, 0)), 1, dynEmpCod.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynEmpCod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Empresabase_calculoGeneral.htm");
         dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynEmpCod.getInternalname(), "Values", dynEmpCod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBaseClaseLeg.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbEmpBaseClaseLeg.getInternalname(), httpContext.getMessage( "Clase de legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBaseClaseLeg, cmbEmpBaseClaseLeg.getInternalname(), GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0)), 1, cmbEmpBaseClaseLeg.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbEmpBaseClaseLeg.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Empresabase_calculoGeneral.htm");
         cmbEmpBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseClaseLeg.getInternalname(), "Values", cmbEmpBaseClaseLeg.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBaseTipo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbEmpBaseTipo.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBaseTipo, cmbEmpBaseTipo.getInternalname(), GXutil.rtrim( A1429EmpBaseTipo), 1, cmbEmpBaseTipo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEmpBaseTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Empresabase_calculoGeneral.htm");
         cmbEmpBaseTipo.setValue( GXutil.rtrim( A1429EmpBaseTipo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseTipo.getInternalname(), "Values", cmbEmpBaseTipo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmpbasecod1_cell_Internalname, 1, 0, "px", 0, "px", divEmpbasecod1_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbEmpBaseCod1.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBaseCod1.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbEmpBaseCod1.getInternalname(), httpContext.getMessage( "Código 1", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBaseCod1, cmbEmpBaseCod1.getInternalname(), GXutil.rtrim( A1430EmpBaseCod1), 1, cmbEmpBaseCod1.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbEmpBaseCod1.getVisible(), cmbEmpBaseCod1.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Empresabase_calculoGeneral.htm");
         cmbEmpBaseCod1.setValue( GXutil.rtrim( A1430EmpBaseCod1) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseCod1.getInternalname(), "Values", cmbEmpBaseCod1.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmpbasecod2_cell_Internalname, 1, 0, "px", 0, "px", divEmpbasecod2_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbEmpBaseCod2.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBaseCod2.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbEmpBaseCod2.getInternalname(), httpContext.getMessage( "Código 2", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBaseCod2, cmbEmpBaseCod2.getInternalname(), GXutil.rtrim( A1431EmpBaseCod2), 1, cmbEmpBaseCod2.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbEmpBaseCod2.getVisible(), cmbEmpBaseCod2.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Empresabase_calculoGeneral.htm");
         cmbEmpBaseCod2.setValue( GXutil.rtrim( A1431EmpBaseCod2) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseCod2.getInternalname(), "Values", cmbEmpBaseCod2.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmpbaseplus_cell_Internalname, 1, 0, "px", 0, "px", divEmpbaseplus_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtEmpBasePlus_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpBasePlus_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpBasePlus_Internalname, httpContext.getMessage( "Porcentaje para plus", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBasePlus_Internalname, GXutil.ltrim( localUtil.ntoc( A1432EmpBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpBasePlus_Enabled!=0) ? localUtil.format( A1432EmpBasePlus, "9.9999") : localUtil.format( A1432EmpBasePlus, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBasePlus_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpBasePlus_Visible, edtEmpBasePlus_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Empresabase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicdmin_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdmin_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtEmpLicDMin_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLicDMin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpLicDMin_Internalname, httpContext.getMessage( "Cantidad mínima de días permitidos por licencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpLicDMin_Internalname, GXutil.ltrim( localUtil.ntoc( A1517EmpLicDMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpLicDMin_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1517EmpLicDMin), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1517EmpLicDMin), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpLicDMin_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpLicDMin_Visible, edtEmpLicDMin_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicdlim_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdlim_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtEmpLicDLim_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLicDLim_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpLicDLim_Internalname, httpContext.getMessage( "Cantidad de días permitidos por licencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpLicDLim_Internalname, GXutil.ltrim( localUtil.ntoc( A1502EmpLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpLicDLim_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1502EmpLicDLim), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1502EmpLicDLim), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpLicDLim_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpLicDLim_Visible, edtEmpLicDLim_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicdseman_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdseman_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtEmpLicDSeman_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLicDSeman_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpLicDSeman_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpLicDSeman_Internalname, GXutil.ltrim( localUtil.ntoc( A1503EmpLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpLicDSeman_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1503EmpLicDSeman), "9") : localUtil.format( DecimalUtil.doubleToDec(A1503EmpLicDSeman), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpLicDSeman_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpLicDSeman_Visible, edtEmpLicDSeman_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicdmes_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdmes_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbEmpLicDMes.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpLicDMes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbEmpLicDMes.getInternalname(), httpContext.getMessage( "Cantidad de días permitidos por mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpLicDMes, cmbEmpLicDMes.getInternalname(), GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0)), 1, cmbEmpLicDMes.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbEmpLicDMes.getVisible(), cmbEmpLicDMes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Empresabase_calculoGeneral.htm");
         cmbEmpLicDMes.setValue( GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpLicDMes.getInternalname(), "Values", cmbEmpLicDMes.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicdsemes_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdsemes_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtEmpLicDSemes_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLicDSemes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpLicDSemes_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpLicDSemes_Internalname, GXutil.ltrim( localUtil.ntoc( A1505EmpLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpLicDSemes_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1505EmpLicDSemes), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1505EmpLicDSemes), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpLicDSemes_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpLicDSemes_Visible, edtEmpLicDSemes_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicdanual_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdanual_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtEmpLicDAnual_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLicDAnual_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpLicDAnual_Internalname, httpContext.getMessage( "Cantidad de días permitidos por año", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpLicDAnual_Internalname, GXutil.ltrim( localUtil.ntoc( A1506EmpLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpLicDAnual_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1506EmpLicDAnual), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1506EmpLicDAnual), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpLicDAnual_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpLicDAnual_Visible, edtEmpLicDAnual_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicadju_cell_Internalname, 1, 0, "px", 0, "px", divEmplicadju_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkEmpLicAdju.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLicAdju.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkEmpLicAdju.getInternalname(), httpContext.getMessage( "Permite adjuntar documento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLicAdju.getInternalname(), GXutil.booltostr( A1507EmpLicAdju), "", httpContext.getMessage( "Permite adjuntar documento", ""), chkEmpLicAdju.getVisible(), chkEmpLicAdju.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicadjuobl_cell_Internalname, 1, 0, "px", 0, "px", divEmplicadjuobl_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkEmpLicAdjuObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLicAdjuObl.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkEmpLicAdjuObl.getInternalname(), httpContext.getMessage( "Obliga a adjuntar documento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLicAdjuObl.getInternalname(), GXutil.booltostr( A1508EmpLicAdjuObl), "", httpContext.getMessage( "Obliga a adjuntar documento", ""), chkEmpLicAdjuObl.getVisible(), chkEmpLicAdjuObl.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicnecaut_cell_Internalname, 1, 0, "px", 0, "px", divEmplicnecaut_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkEmpLicNecAut.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLicNecAut.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkEmpLicNecAut.getInternalname(), httpContext.getMessage( "Necesita autorización", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLicNecAut.getInternalname(), GXutil.booltostr( A1509EmpLicNecAut), "", httpContext.getMessage( "Necesita autorización", ""), chkEmpLicNecAut.getVisible(), chkEmpLicNecAut.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicingmot_cell_Internalname, 1, 0, "px", 0, "px", divEmplicingmot_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkEmpLicIngMot.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLicIngMot.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkEmpLicIngMot.getInternalname(), httpContext.getMessage( "Permite ingresar motivo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLicIngMot.getInternalname(), GXutil.booltostr( A1510EmpLicIngMot), "", httpContext.getMessage( "Permite ingresar motivo", ""), chkEmpLicIngMot.getVisible(), chkEmpLicIngMot.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divEmplicmotobl_cell_Internalname, 1, 0, "px", 0, "px", divEmplicmotobl_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkEmpLicMotObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLicMotObl.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkEmpLicMotObl.getInternalname(), httpContext.getMessage( "Obliga a ingresar motivo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLicMotObl.getInternalname(), GXutil.booltostr( A1511EmpLicMotObl), "", httpContext.getMessage( "Obliga a ingresar motivo", ""), chkEmpLicMotObl.getVisible(), chkEmpLicMotObl.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpBasePromCnt1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpBasePromCnt1_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBasePromCnt1_Internalname, GXutil.ltrim( localUtil.ntoc( A1437EmpBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpBasePromCnt1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBasePromCnt1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpBasePromCnt1_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpBasePromCnt2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpBasePromCnt2_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBasePromCnt2_Internalname, GXutil.ltrim( localUtil.ntoc( A1438EmpBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpBasePromCnt2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBasePromCnt2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpBasePromCnt2_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBasePromTCnt.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbEmpBasePromTCnt.getInternalname(), httpContext.getMessage( "Días o Meses", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBasePromTCnt, cmbEmpBasePromTCnt.getInternalname(), GXutil.rtrim( A1439EmpBasePromTCnt), 1, cmbEmpBasePromTCnt.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEmpBasePromTCnt.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Empresabase_calculoGeneral.htm");
         cmbEmpBasePromTCnt.setValue( GXutil.rtrim( A1439EmpBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBasePromTCnt.getInternalname(), "Values", cmbEmpBasePromTCnt.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11kk1_client"+"'", TempTags, "", 2, "HLP_Empresabase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 116,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12kk1_client"+"'", TempTags, "", 2, "HLP_Empresabase_calculoGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculoGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBaseOrd_Internalname, GXutil.ltrim( localUtil.ntoc( A1518EmpBaseOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1518EmpBaseOrd), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBaseOrd_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpBaseOrd_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startKK2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Empresabase_calculo General", ""), (short)(0)) ;
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
            strupKK0( ) ;
         }
      }
   }

   public void wsKK2( )
   {
      startKK2( ) ;
      evtKK2( ) ;
   }

   public void evtKK2( )
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
                              strupKK0( ) ;
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
                              strupKK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13KK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupKK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14KK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupKK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15KK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupKK0( ) ;
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
                              strupKK0( ) ;
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

   public void weKK2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormKK2( ) ;
         }
      }
   }

   public void paKK2( )
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

   public void gxdlaempcodKK2( int AV13CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaempcod_dataKK2( AV13CliCod) ;
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

   public void gxaempcod_htmlKK2( int AV13CliCod )
   {
      short gxdynajaxvalue;
      gxdlaempcod_dataKK2( AV13CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynEmpCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynEmpCod.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynEmpCod.getItemCount() > 0 )
      {
         A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValidValue(GXutil.trim( GXutil.str( A1EmpCod, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
   }

   protected void gxdlaempcod_dataKK2( int AV13CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00KK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00KK2_A1EmpCod[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00KK2_A2EmpNom[0]);
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
      if ( dynEmpCod.getItemCount() > 0 )
      {
         A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValidValue(GXutil.trim( GXutil.str( A1EmpCod, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynEmpCod.getInternalname(), "Values", dynEmpCod.ToJavascriptSource(), true);
      }
      if ( cmbEmpBaseClaseLeg.getItemCount() > 0 )
      {
         A1427EmpBaseClaseLeg = (byte)(GXutil.lval( cmbEmpBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseClaseLeg.getInternalname(), "Values", cmbEmpBaseClaseLeg.ToJavascriptSource(), true);
      }
      if ( cmbEmpBaseTipo.getItemCount() > 0 )
      {
         A1429EmpBaseTipo = cmbEmpBaseTipo.getValidValue(A1429EmpBaseTipo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseTipo.setValue( GXutil.rtrim( A1429EmpBaseTipo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseTipo.getInternalname(), "Values", cmbEmpBaseTipo.ToJavascriptSource(), true);
      }
      if ( cmbEmpBaseCod1.getItemCount() > 0 )
      {
         A1430EmpBaseCod1 = cmbEmpBaseCod1.getValidValue(A1430EmpBaseCod1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseCod1.setValue( GXutil.rtrim( A1430EmpBaseCod1) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseCod1.getInternalname(), "Values", cmbEmpBaseCod1.ToJavascriptSource(), true);
      }
      if ( cmbEmpBaseCod2.getItemCount() > 0 )
      {
         A1431EmpBaseCod2 = cmbEmpBaseCod2.getValidValue(A1431EmpBaseCod2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseCod2.setValue( GXutil.rtrim( A1431EmpBaseCod2) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseCod2.getInternalname(), "Values", cmbEmpBaseCod2.ToJavascriptSource(), true);
      }
      if ( cmbEmpLicDMes.getItemCount() > 0 )
      {
         A1504EmpLicDMes = (byte)(GXutil.lval( cmbEmpLicDMes.getValidValue(GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0))))) ;
         n1504EmpLicDMes = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1504EmpLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1504EmpLicDMes), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpLicDMes.setValue( GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpLicDMes.getInternalname(), "Values", cmbEmpLicDMes.ToJavascriptSource(), true);
      }
      A1507EmpLicAdju = GXutil.strtobool( GXutil.booltostr( A1507EmpLicAdju)) ;
      n1507EmpLicAdju = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1507EmpLicAdju", A1507EmpLicAdju);
      A1508EmpLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1508EmpLicAdjuObl)) ;
      n1508EmpLicAdjuObl = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1508EmpLicAdjuObl", A1508EmpLicAdjuObl);
      A1509EmpLicNecAut = GXutil.strtobool( GXutil.booltostr( A1509EmpLicNecAut)) ;
      n1509EmpLicNecAut = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1509EmpLicNecAut", A1509EmpLicNecAut);
      A1510EmpLicIngMot = GXutil.strtobool( GXutil.booltostr( A1510EmpLicIngMot)) ;
      n1510EmpLicIngMot = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1510EmpLicIngMot", A1510EmpLicIngMot);
      A1511EmpLicMotObl = GXutil.strtobool( GXutil.booltostr( A1511EmpLicMotObl)) ;
      n1511EmpLicMotObl = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1511EmpLicMotObl", A1511EmpLicMotObl);
      if ( cmbEmpBasePromTCnt.getItemCount() > 0 )
      {
         A1439EmpBasePromTCnt = cmbEmpBasePromTCnt.getValidValue(A1439EmpBasePromTCnt) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1439EmpBasePromTCnt", A1439EmpBasePromTCnt);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBasePromTCnt.setValue( GXutil.rtrim( A1439EmpBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBasePromTCnt.getInternalname(), "Values", cmbEmpBasePromTCnt.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfKK2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "Empresabase_calculoGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfKK2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15KK2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00KK3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1518EmpBaseOrd = H00KK3_A1518EmpBaseOrd[0] ;
            n1518EmpBaseOrd = H00KK3_n1518EmpBaseOrd[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1518EmpBaseOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1518EmpBaseOrd), 4, 0));
            A1439EmpBasePromTCnt = H00KK3_A1439EmpBasePromTCnt[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1439EmpBasePromTCnt", A1439EmpBasePromTCnt);
            A1438EmpBasePromCnt2 = H00KK3_A1438EmpBasePromCnt2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1438EmpBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), 3, 0));
            A1437EmpBasePromCnt1 = H00KK3_A1437EmpBasePromCnt1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1437EmpBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), 3, 0));
            A1511EmpLicMotObl = H00KK3_A1511EmpLicMotObl[0] ;
            n1511EmpLicMotObl = H00KK3_n1511EmpLicMotObl[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1511EmpLicMotObl", A1511EmpLicMotObl);
            A1510EmpLicIngMot = H00KK3_A1510EmpLicIngMot[0] ;
            n1510EmpLicIngMot = H00KK3_n1510EmpLicIngMot[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1510EmpLicIngMot", A1510EmpLicIngMot);
            A1509EmpLicNecAut = H00KK3_A1509EmpLicNecAut[0] ;
            n1509EmpLicNecAut = H00KK3_n1509EmpLicNecAut[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1509EmpLicNecAut", A1509EmpLicNecAut);
            A1508EmpLicAdjuObl = H00KK3_A1508EmpLicAdjuObl[0] ;
            n1508EmpLicAdjuObl = H00KK3_n1508EmpLicAdjuObl[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1508EmpLicAdjuObl", A1508EmpLicAdjuObl);
            A1507EmpLicAdju = H00KK3_A1507EmpLicAdju[0] ;
            n1507EmpLicAdju = H00KK3_n1507EmpLicAdju[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1507EmpLicAdju", A1507EmpLicAdju);
            A1506EmpLicDAnual = H00KK3_A1506EmpLicDAnual[0] ;
            n1506EmpLicDAnual = H00KK3_n1506EmpLicDAnual[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1506EmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1506EmpLicDAnual), 3, 0));
            A1505EmpLicDSemes = H00KK3_A1505EmpLicDSemes[0] ;
            n1505EmpLicDSemes = H00KK3_n1505EmpLicDSemes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1505EmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1505EmpLicDSemes), 3, 0));
            A1504EmpLicDMes = H00KK3_A1504EmpLicDMes[0] ;
            n1504EmpLicDMes = H00KK3_n1504EmpLicDMes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1504EmpLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1504EmpLicDMes), 2, 0));
            A1503EmpLicDSeman = H00KK3_A1503EmpLicDSeman[0] ;
            n1503EmpLicDSeman = H00KK3_n1503EmpLicDSeman[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1503EmpLicDSeman", GXutil.str( A1503EmpLicDSeman, 1, 0));
            A1502EmpLicDLim = H00KK3_A1502EmpLicDLim[0] ;
            n1502EmpLicDLim = H00KK3_n1502EmpLicDLim[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1502EmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1502EmpLicDLim), 3, 0));
            A1517EmpLicDMin = H00KK3_A1517EmpLicDMin[0] ;
            n1517EmpLicDMin = H00KK3_n1517EmpLicDMin[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1517EmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1517EmpLicDMin), 2, 0));
            A1432EmpBasePlus = H00KK3_A1432EmpBasePlus[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1432EmpBasePlus", GXutil.ltrimstr( A1432EmpBasePlus, 6, 4));
            /* Execute user event: Load */
            e14KK2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         wbKK0( ) ;
      }
   }

   public void send_integrity_lvl_hashesKK2( )
   {
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "Empresabase_calculoGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupKK0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13KK2 ();
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
         wcpOA1427EmpBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1427EmpBaseClaseLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1429EmpBaseTipo = httpContext.cgiGet( sPrefix+"wcpOA1429EmpBaseTipo") ;
         wcpOA1430EmpBaseCod1 = httpContext.cgiGet( sPrefix+"wcpOA1430EmpBaseCod1") ;
         wcpOA1431EmpBaseCod2 = httpContext.cgiGet( sPrefix+"wcpOA1431EmpBaseCod2") ;
         /* Read variables values. */
         A1432EmpBasePlus = localUtil.ctond( httpContext.cgiGet( edtEmpBasePlus_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1432EmpBasePlus", GXutil.ltrimstr( A1432EmpBasePlus, 6, 4));
         A1517EmpLicDMin = (byte)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         n1517EmpLicDMin = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1517EmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1517EmpLicDMin), 2, 0));
         A1502EmpLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         n1502EmpLicDLim = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1502EmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1502EmpLicDLim), 3, 0));
         A1503EmpLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         n1503EmpLicDSeman = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1503EmpLicDSeman", GXutil.str( A1503EmpLicDSeman, 1, 0));
         cmbEmpLicDMes.setValue( httpContext.cgiGet( cmbEmpLicDMes.getInternalname()) );
         A1504EmpLicDMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbEmpLicDMes.getInternalname()))) ;
         n1504EmpLicDMes = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1504EmpLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1504EmpLicDMes), 2, 0));
         A1505EmpLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         n1505EmpLicDSemes = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1505EmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1505EmpLicDSemes), 3, 0));
         A1506EmpLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         n1506EmpLicDAnual = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1506EmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1506EmpLicDAnual), 3, 0));
         A1507EmpLicAdju = GXutil.strtobool( httpContext.cgiGet( chkEmpLicAdju.getInternalname())) ;
         n1507EmpLicAdju = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1507EmpLicAdju", A1507EmpLicAdju);
         A1508EmpLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( chkEmpLicAdjuObl.getInternalname())) ;
         n1508EmpLicAdjuObl = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1508EmpLicAdjuObl", A1508EmpLicAdjuObl);
         A1509EmpLicNecAut = GXutil.strtobool( httpContext.cgiGet( chkEmpLicNecAut.getInternalname())) ;
         n1509EmpLicNecAut = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1509EmpLicNecAut", A1509EmpLicNecAut);
         A1510EmpLicIngMot = GXutil.strtobool( httpContext.cgiGet( chkEmpLicIngMot.getInternalname())) ;
         n1510EmpLicIngMot = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1510EmpLicIngMot", A1510EmpLicIngMot);
         A1511EmpLicMotObl = GXutil.strtobool( httpContext.cgiGet( chkEmpLicMotObl.getInternalname())) ;
         n1511EmpLicMotObl = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1511EmpLicMotObl", A1511EmpLicMotObl);
         A1437EmpBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1437EmpBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), 3, 0));
         A1438EmpBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1438EmpBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), 3, 0));
         cmbEmpBasePromTCnt.setValue( httpContext.cgiGet( cmbEmpBasePromTCnt.getInternalname()) );
         A1439EmpBasePromTCnt = httpContext.cgiGet( cmbEmpBasePromTCnt.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1439EmpBasePromTCnt", A1439EmpBasePromTCnt);
         A1518EmpBaseOrd = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpBaseOrd_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         n1518EmpBaseOrd = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1518EmpBaseOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1518EmpBaseOrd), 4, 0));
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
      e13KK2 ();
      if (returnInSub) return;
   }

   public void e13KK2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      empresabase_calculogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14KK2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpBaseOrd_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpBaseOrd_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBaseOrd_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresabase_calculo_Update", GXv_boolean5) ;
      empresabase_calculogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresabase_calculo_Delete", GXv_boolean5) ;
      empresabase_calculogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "horaNormal") != 0 ) ) )
      {
         cmbEmpBaseCod1.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseCod1.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpBaseCod1.getVisible(), 5, 0), true);
         divEmpbasecod1_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmpbasecod1_cell_Internalname, "Class", divEmpbasecod1_cell_Class, true);
      }
      else
      {
         cmbEmpBaseCod1.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseCod1.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpBaseCod1.getVisible(), 5, 0), true);
         divEmpbasecod1_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmpbasecod1_cell_Internalname, "Class", divEmpbasecod1_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "horaNormal") != 0 ) && ( GXutil.strcmp(AV17Empbasetipo, "licencia") != 0 ) ) )
      {
         cmbEmpBaseCod2.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseCod2.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpBaseCod2.getVisible(), 5, 0), true);
         divEmpbasecod2_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmpbasecod2_cell_Internalname, "Class", divEmpbasecod2_cell_Class, true);
      }
      else
      {
         cmbEmpBaseCod2.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpBaseCod2.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpBaseCod2.getVisible(), 5, 0), true);
         divEmpbasecod2_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmpbasecod2_cell_Internalname, "Class", divEmpbasecod2_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "horaNormal") != 0 ) ) )
      {
         edtEmpBasePlus_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpBasePlus_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBasePlus_Visible), 5, 0), true);
         divEmpbaseplus_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmpbaseplus_cell_Internalname, "Class", divEmpbaseplus_cell_Class, true);
      }
      else
      {
         edtEmpBasePlus_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpBasePlus_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBasePlus_Visible), 5, 0), true);
         divEmpbaseplus_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmpbaseplus_cell_Internalname, "Class", divEmpbaseplus_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         edtEmpLicDMin_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLicDMin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDMin_Visible), 5, 0), true);
         divEmplicdmin_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdmin_cell_Internalname, "Class", divEmplicdmin_cell_Class, true);
      }
      else
      {
         edtEmpLicDMin_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLicDMin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDMin_Visible), 5, 0), true);
         divEmplicdmin_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdmin_cell_Internalname, "Class", divEmplicdmin_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         edtEmpLicDLim_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDLim_Visible), 5, 0), true);
         divEmplicdlim_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdlim_cell_Internalname, "Class", divEmplicdlim_cell_Class, true);
      }
      else
      {
         edtEmpLicDLim_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDLim_Visible), 5, 0), true);
         divEmplicdlim_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdlim_cell_Internalname, "Class", divEmplicdlim_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         edtEmpLicDSeman_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSeman_Visible), 5, 0), true);
         divEmplicdseman_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdseman_cell_Internalname, "Class", divEmplicdseman_cell_Class, true);
      }
      else
      {
         edtEmpLicDSeman_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSeman_Visible), 5, 0), true);
         divEmplicdseman_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdseman_cell_Internalname, "Class", divEmplicdseman_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         cmbEmpLicDMes.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpLicDMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpLicDMes.getVisible(), 5, 0), true);
         divEmplicdmes_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdmes_cell_Internalname, "Class", divEmplicdmes_cell_Class, true);
      }
      else
      {
         cmbEmpLicDMes.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpLicDMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpLicDMes.getVisible(), 5, 0), true);
         divEmplicdmes_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdmes_cell_Internalname, "Class", divEmplicdmes_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         edtEmpLicDSemes_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSemes_Visible), 5, 0), true);
         divEmplicdsemes_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdsemes_cell_Internalname, "Class", divEmplicdsemes_cell_Class, true);
      }
      else
      {
         edtEmpLicDSemes_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSemes_Visible), 5, 0), true);
         divEmplicdsemes_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdsemes_cell_Internalname, "Class", divEmplicdsemes_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         edtEmpLicDAnual_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDAnual_Visible), 5, 0), true);
         divEmplicdanual_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdanual_cell_Internalname, "Class", divEmplicdanual_cell_Class, true);
      }
      else
      {
         edtEmpLicDAnual_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDAnual_Visible), 5, 0), true);
         divEmplicdanual_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicdanual_cell_Internalname, "Class", divEmplicdanual_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         chkEmpLicAdju.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicAdju.getVisible(), 5, 0), true);
         divEmplicadju_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicadju_cell_Internalname, "Class", divEmplicadju_cell_Class, true);
      }
      else
      {
         chkEmpLicAdju.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicAdju.getVisible(), 5, 0), true);
         divEmplicadju_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicadju_cell_Internalname, "Class", divEmplicadju_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         chkEmpLicAdjuObl.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicAdjuObl.getVisible(), 5, 0), true);
         divEmplicadjuobl_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicadjuobl_cell_Internalname, "Class", divEmplicadjuobl_cell_Class, true);
      }
      else
      {
         chkEmpLicAdjuObl.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicAdjuObl.getVisible(), 5, 0), true);
         divEmplicadjuobl_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicadjuobl_cell_Internalname, "Class", divEmplicadjuobl_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         chkEmpLicNecAut.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicNecAut.getVisible(), 5, 0), true);
         divEmplicnecaut_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicnecaut_cell_Internalname, "Class", divEmplicnecaut_cell_Class, true);
      }
      else
      {
         chkEmpLicNecAut.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicNecAut.getVisible(), 5, 0), true);
         divEmplicnecaut_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicnecaut_cell_Internalname, "Class", divEmplicnecaut_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         chkEmpLicIngMot.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicIngMot.getVisible(), 5, 0), true);
         divEmplicingmot_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicingmot_cell_Internalname, "Class", divEmplicingmot_cell_Class, true);
      }
      else
      {
         chkEmpLicIngMot.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicIngMot.getVisible(), 5, 0), true);
         divEmplicingmot_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicingmot_cell_Internalname, "Class", divEmplicingmot_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Empbasetipo, "licencia") == 0 ) ) )
      {
         chkEmpLicMotObl.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicMotObl.getVisible(), 5, 0), true);
         divEmplicmotobl_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicmotobl_cell_Internalname, "Class", divEmplicmotobl_cell_Class, true);
      }
      else
      {
         chkEmpLicMotObl.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicMotObl.getVisible(), 5, 0), true);
         divEmplicmotobl_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divEmplicmotobl_cell_Internalname, "Class", divEmplicmotobl_cell_Class, true);
      }
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV8TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV18Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Empresabase_calculo" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15KK2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      empresabase_calculogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A1427EmpBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
      A1429EmpBaseTipo = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
      A1430EmpBaseCod1 = (String)getParm(obj,4,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
      A1431EmpBaseCod2 = (String)getParm(obj,5,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
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
      paKK2( ) ;
      wsKK2( ) ;
      weKK2( ) ;
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
      sCtrlA1427EmpBaseClaseLeg = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlA1429EmpBaseTipo = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlA1430EmpBaseCod1 = (String)getParm(obj,4,TypeConstants.STRING) ;
      sCtrlA1431EmpBaseCod2 = (String)getParm(obj,5,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paKK2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "empresabase_calculogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paKK2( ) ;
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
         A1427EmpBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
         A1429EmpBaseTipo = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
         A1430EmpBaseCod1 = (String)getParm(obj,6,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
         A1431EmpBaseCod2 = (String)getParm(obj,7,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1427EmpBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1427EmpBaseClaseLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1429EmpBaseTipo = httpContext.cgiGet( sPrefix+"wcpOA1429EmpBaseTipo") ;
      wcpOA1430EmpBaseCod1 = httpContext.cgiGet( sPrefix+"wcpOA1430EmpBaseCod1") ;
      wcpOA1431EmpBaseCod2 = httpContext.cgiGet( sPrefix+"wcpOA1431EmpBaseCod2") ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1EmpCod != wcpOA1EmpCod ) || ( A1427EmpBaseClaseLeg != wcpOA1427EmpBaseClaseLeg ) || ( GXutil.strcmp(A1429EmpBaseTipo, wcpOA1429EmpBaseTipo) != 0 ) || ( GXutil.strcmp(A1430EmpBaseCod1, wcpOA1430EmpBaseCod1) != 0 ) || ( GXutil.strcmp(A1431EmpBaseCod2, wcpOA1431EmpBaseCod2) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1EmpCod = A1EmpCod ;
      wcpOA1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
      wcpOA1429EmpBaseTipo = A1429EmpBaseTipo ;
      wcpOA1430EmpBaseCod1 = A1430EmpBaseCod1 ;
      wcpOA1431EmpBaseCod2 = A1431EmpBaseCod2 ;
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
      sCtrlA1427EmpBaseClaseLeg = httpContext.cgiGet( sPrefix+"A1427EmpBaseClaseLeg_CTRL") ;
      if ( GXutil.len( sCtrlA1427EmpBaseClaseLeg) > 0 )
      {
         A1427EmpBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sCtrlA1427EmpBaseClaseLeg), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
      }
      else
      {
         A1427EmpBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1427EmpBaseClaseLeg_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA1429EmpBaseTipo = httpContext.cgiGet( sPrefix+"A1429EmpBaseTipo_CTRL") ;
      if ( GXutil.len( sCtrlA1429EmpBaseTipo) > 0 )
      {
         A1429EmpBaseTipo = httpContext.cgiGet( sCtrlA1429EmpBaseTipo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
      }
      else
      {
         A1429EmpBaseTipo = httpContext.cgiGet( sPrefix+"A1429EmpBaseTipo_PARM") ;
      }
      sCtrlA1430EmpBaseCod1 = httpContext.cgiGet( sPrefix+"A1430EmpBaseCod1_CTRL") ;
      if ( GXutil.len( sCtrlA1430EmpBaseCod1) > 0 )
      {
         A1430EmpBaseCod1 = httpContext.cgiGet( sCtrlA1430EmpBaseCod1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
      }
      else
      {
         A1430EmpBaseCod1 = httpContext.cgiGet( sPrefix+"A1430EmpBaseCod1_PARM") ;
      }
      sCtrlA1431EmpBaseCod2 = httpContext.cgiGet( sPrefix+"A1431EmpBaseCod2_CTRL") ;
      if ( GXutil.len( sCtrlA1431EmpBaseCod2) > 0 )
      {
         A1431EmpBaseCod2 = httpContext.cgiGet( sCtrlA1431EmpBaseCod2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
      }
      else
      {
         A1431EmpBaseCod2 = httpContext.cgiGet( sPrefix+"A1431EmpBaseCod2_PARM") ;
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
      paKK2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsKK2( ) ;
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
      wsKK2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1427EmpBaseClaseLeg_PARM", GXutil.ltrim( localUtil.ntoc( A1427EmpBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1427EmpBaseClaseLeg)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1427EmpBaseClaseLeg_CTRL", GXutil.rtrim( sCtrlA1427EmpBaseClaseLeg));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1429EmpBaseTipo_PARM", GXutil.rtrim( A1429EmpBaseTipo));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1429EmpBaseTipo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1429EmpBaseTipo_CTRL", GXutil.rtrim( sCtrlA1429EmpBaseTipo));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1430EmpBaseCod1_PARM", GXutil.rtrim( A1430EmpBaseCod1));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1430EmpBaseCod1)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1430EmpBaseCod1_CTRL", GXutil.rtrim( sCtrlA1430EmpBaseCod1));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1431EmpBaseCod2_PARM", GXutil.rtrim( A1431EmpBaseCod2));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1431EmpBaseCod2)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1431EmpBaseCod2_CTRL", GXutil.rtrim( sCtrlA1431EmpBaseCod2));
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
      weKK2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251316514475", true, true);
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
      httpContext.AddJavascriptSource("empresabase_calculogeneral.js", "?20251316514475", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynEmpCod.setInternalname( sPrefix+"EMPCOD" );
      cmbEmpBaseClaseLeg.setInternalname( sPrefix+"EMPBASECLASELEG" );
      cmbEmpBaseTipo.setInternalname( sPrefix+"EMPBASETIPO" );
      cmbEmpBaseCod1.setInternalname( sPrefix+"EMPBASECOD1" );
      divEmpbasecod1_cell_Internalname = sPrefix+"EMPBASECOD1_CELL" ;
      cmbEmpBaseCod2.setInternalname( sPrefix+"EMPBASECOD2" );
      divEmpbasecod2_cell_Internalname = sPrefix+"EMPBASECOD2_CELL" ;
      edtEmpBasePlus_Internalname = sPrefix+"EMPBASEPLUS" ;
      divEmpbaseplus_cell_Internalname = sPrefix+"EMPBASEPLUS_CELL" ;
      edtEmpLicDMin_Internalname = sPrefix+"EMPLICDMIN" ;
      divEmplicdmin_cell_Internalname = sPrefix+"EMPLICDMIN_CELL" ;
      edtEmpLicDLim_Internalname = sPrefix+"EMPLICDLIM" ;
      divEmplicdlim_cell_Internalname = sPrefix+"EMPLICDLIM_CELL" ;
      edtEmpLicDSeman_Internalname = sPrefix+"EMPLICDSEMAN" ;
      divEmplicdseman_cell_Internalname = sPrefix+"EMPLICDSEMAN_CELL" ;
      cmbEmpLicDMes.setInternalname( sPrefix+"EMPLICDMES" );
      divEmplicdmes_cell_Internalname = sPrefix+"EMPLICDMES_CELL" ;
      edtEmpLicDSemes_Internalname = sPrefix+"EMPLICDSEMES" ;
      divEmplicdsemes_cell_Internalname = sPrefix+"EMPLICDSEMES_CELL" ;
      edtEmpLicDAnual_Internalname = sPrefix+"EMPLICDANUAL" ;
      divEmplicdanual_cell_Internalname = sPrefix+"EMPLICDANUAL_CELL" ;
      chkEmpLicAdju.setInternalname( sPrefix+"EMPLICADJU" );
      divEmplicadju_cell_Internalname = sPrefix+"EMPLICADJU_CELL" ;
      chkEmpLicAdjuObl.setInternalname( sPrefix+"EMPLICADJUOBL" );
      divEmplicadjuobl_cell_Internalname = sPrefix+"EMPLICADJUOBL_CELL" ;
      chkEmpLicNecAut.setInternalname( sPrefix+"EMPLICNECAUT" );
      divEmplicnecaut_cell_Internalname = sPrefix+"EMPLICNECAUT_CELL" ;
      chkEmpLicIngMot.setInternalname( sPrefix+"EMPLICINGMOT" );
      divEmplicingmot_cell_Internalname = sPrefix+"EMPLICINGMOT_CELL" ;
      chkEmpLicMotObl.setInternalname( sPrefix+"EMPLICMOTOBL" );
      divEmplicmotobl_cell_Internalname = sPrefix+"EMPLICMOTOBL_CELL" ;
      edtEmpBasePromCnt1_Internalname = sPrefix+"EMPBASEPROMCNT1" ;
      edtEmpBasePromCnt2_Internalname = sPrefix+"EMPBASEPROMCNT2" ;
      cmbEmpBasePromTCnt.setInternalname( sPrefix+"EMPBASEPROMTCNT" );
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpBaseOrd_Internalname = sPrefix+"EMPBASEORD" ;
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
      edtEmpBaseOrd_Jsonclick = "" ;
      edtEmpBaseOrd_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      cmbEmpBasePromTCnt.setJsonclick( "" );
      cmbEmpBasePromTCnt.setEnabled( 0 );
      edtEmpBasePromCnt2_Jsonclick = "" ;
      edtEmpBasePromCnt2_Enabled = 0 ;
      edtEmpBasePromCnt1_Jsonclick = "" ;
      edtEmpBasePromCnt1_Enabled = 0 ;
      chkEmpLicMotObl.setEnabled( 0 );
      chkEmpLicMotObl.setVisible( 1 );
      divEmplicmotobl_cell_Class = "col-xs-12" ;
      chkEmpLicIngMot.setEnabled( 0 );
      chkEmpLicIngMot.setVisible( 1 );
      divEmplicingmot_cell_Class = "col-xs-12" ;
      chkEmpLicNecAut.setEnabled( 0 );
      chkEmpLicNecAut.setVisible( 1 );
      divEmplicnecaut_cell_Class = "col-xs-12" ;
      chkEmpLicAdjuObl.setEnabled( 0 );
      chkEmpLicAdjuObl.setVisible( 1 );
      divEmplicadjuobl_cell_Class = "col-xs-12" ;
      chkEmpLicAdju.setEnabled( 0 );
      chkEmpLicAdju.setVisible( 1 );
      divEmplicadju_cell_Class = "col-xs-12" ;
      edtEmpLicDAnual_Jsonclick = "" ;
      edtEmpLicDAnual_Enabled = 0 ;
      edtEmpLicDAnual_Visible = 1 ;
      divEmplicdanual_cell_Class = "col-xs-12" ;
      edtEmpLicDSemes_Jsonclick = "" ;
      edtEmpLicDSemes_Enabled = 0 ;
      edtEmpLicDSemes_Visible = 1 ;
      divEmplicdsemes_cell_Class = "col-xs-12" ;
      cmbEmpLicDMes.setJsonclick( "" );
      cmbEmpLicDMes.setEnabled( 0 );
      cmbEmpLicDMes.setVisible( 1 );
      divEmplicdmes_cell_Class = "col-xs-12" ;
      edtEmpLicDSeman_Jsonclick = "" ;
      edtEmpLicDSeman_Enabled = 0 ;
      edtEmpLicDSeman_Visible = 1 ;
      divEmplicdseman_cell_Class = "col-xs-12" ;
      edtEmpLicDLim_Jsonclick = "" ;
      edtEmpLicDLim_Enabled = 0 ;
      edtEmpLicDLim_Visible = 1 ;
      divEmplicdlim_cell_Class = "col-xs-12" ;
      edtEmpLicDMin_Jsonclick = "" ;
      edtEmpLicDMin_Enabled = 0 ;
      edtEmpLicDMin_Visible = 1 ;
      divEmplicdmin_cell_Class = "col-xs-12" ;
      edtEmpBasePlus_Jsonclick = "" ;
      edtEmpBasePlus_Enabled = 0 ;
      edtEmpBasePlus_Visible = 1 ;
      divEmpbaseplus_cell_Class = "col-xs-12" ;
      cmbEmpBaseCod2.setJsonclick( "" );
      cmbEmpBaseCod2.setEnabled( 0 );
      cmbEmpBaseCod2.setVisible( 1 );
      divEmpbasecod2_cell_Class = "col-xs-12" ;
      cmbEmpBaseCod1.setJsonclick( "" );
      cmbEmpBaseCod1.setEnabled( 0 );
      cmbEmpBaseCod1.setVisible( 1 );
      divEmpbasecod1_cell_Class = "col-xs-12" ;
      cmbEmpBaseTipo.setJsonclick( "" );
      cmbEmpBaseTipo.setEnabled( 0 );
      cmbEmpBaseClaseLeg.setJsonclick( "" );
      cmbEmpBaseClaseLeg.setEnabled( 0 );
      dynEmpCod.setJsonclick( "" );
      dynEmpCod.setEnabled( 0 );
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
      dynEmpCod.setName( "EMPCOD" );
      dynEmpCod.setWebtags( "" );
      cmbEmpBaseClaseLeg.setName( "EMPBASECLASELEG" );
      cmbEmpBaseClaseLeg.setWebtags( "" );
      cmbEmpBaseClaseLeg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbEmpBaseClaseLeg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbEmpBaseClaseLeg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbEmpBaseClaseLeg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbEmpBaseClaseLeg.getItemCount() > 0 )
      {
      }
      cmbEmpBaseTipo.setName( "EMPBASETIPO" );
      cmbEmpBaseTipo.setWebtags( "" );
      cmbEmpBaseTipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
      cmbEmpBaseTipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
      cmbEmpBaseTipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
      if ( cmbEmpBaseTipo.getItemCount() > 0 )
      {
      }
      cmbEmpBaseCod1.setName( "EMPBASECOD1" );
      cmbEmpBaseCod1.setWebtags( "" );
      if ( cmbEmpBaseCod1.getItemCount() > 0 )
      {
      }
      cmbEmpBaseCod2.setName( "EMPBASECOD2" );
      cmbEmpBaseCod2.setWebtags( "" );
      if ( cmbEmpBaseCod2.getItemCount() > 0 )
      {
      }
      cmbEmpLicDMes.setName( "EMPLICDMES" );
      cmbEmpLicDMes.setWebtags( "" );
      if ( cmbEmpLicDMes.getItemCount() > 0 )
      {
      }
      chkEmpLicAdju.setName( "EMPLICADJU" );
      chkEmpLicAdju.setWebtags( "" );
      chkEmpLicAdju.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicAdju.getInternalname(), "TitleCaption", chkEmpLicAdju.getCaption(), true);
      chkEmpLicAdju.setCheckedValue( "false" );
      chkEmpLicAdjuObl.setName( "EMPLICADJUOBL" );
      chkEmpLicAdjuObl.setWebtags( "" );
      chkEmpLicAdjuObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicAdjuObl.getInternalname(), "TitleCaption", chkEmpLicAdjuObl.getCaption(), true);
      chkEmpLicAdjuObl.setCheckedValue( "false" );
      chkEmpLicNecAut.setName( "EMPLICNECAUT" );
      chkEmpLicNecAut.setWebtags( "" );
      chkEmpLicNecAut.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicNecAut.getInternalname(), "TitleCaption", chkEmpLicNecAut.getCaption(), true);
      chkEmpLicNecAut.setCheckedValue( "false" );
      chkEmpLicIngMot.setName( "EMPLICINGMOT" );
      chkEmpLicIngMot.setWebtags( "" );
      chkEmpLicIngMot.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicIngMot.getInternalname(), "TitleCaption", chkEmpLicIngMot.getCaption(), true);
      chkEmpLicIngMot.setCheckedValue( "false" );
      chkEmpLicMotObl.setName( "EMPLICMOTOBL" );
      chkEmpLicMotObl.setWebtags( "" );
      chkEmpLicMotObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLicMotObl.getInternalname(), "TitleCaption", chkEmpLicMotObl.getCaption(), true);
      chkEmpLicMotObl.setCheckedValue( "false" );
      cmbEmpBasePromTCnt.setName( "EMPBASEPROMTCNT" );
      cmbEmpBasePromTCnt.setWebtags( "" );
      cmbEmpBasePromTCnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
      cmbEmpBasePromTCnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbEmpBasePromTCnt.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'cmbEmpBaseClaseLeg'},{av:'A1427EmpBaseClaseLeg',fld:'EMPBASECLASELEG',pic:'9'},{av:'cmbEmpBaseTipo'},{av:'A1429EmpBaseTipo',fld:'EMPBASETIPO',pic:''},{av:'cmbEmpBaseCod1'},{av:'A1430EmpBaseCod1',fld:'EMPBASECOD1',pic:''},{av:'cmbEmpBaseCod2'},{av:'A1431EmpBaseCod2',fld:'EMPBASECOD2',pic:''},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11KK1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'cmbEmpBaseClaseLeg'},{av:'A1427EmpBaseClaseLeg',fld:'EMPBASECLASELEG',pic:'9'},{av:'cmbEmpBaseTipo'},{av:'A1429EmpBaseTipo',fld:'EMPBASETIPO',pic:''},{av:'cmbEmpBaseCod1'},{av:'A1430EmpBaseCod1',fld:'EMPBASECOD1',pic:''},{av:'cmbEmpBaseCod2'},{av:'A1431EmpBaseCod2',fld:'EMPBASECOD2',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12KK1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'cmbEmpBaseClaseLeg'},{av:'A1427EmpBaseClaseLeg',fld:'EMPBASECLASELEG',pic:'9'},{av:'cmbEmpBaseTipo'},{av:'A1429EmpBaseTipo',fld:'EMPBASETIPO',pic:''},{av:'cmbEmpBaseCod1'},{av:'A1430EmpBaseCod1',fld:'EMPBASECOD1',pic:''},{av:'cmbEmpBaseCod2'},{av:'A1431EmpBaseCod2',fld:'EMPBASECOD2',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_EMPBASECLASELEG","{handler:'valid_Empbaseclaseleg',iparms:[]");
      setEventMetadata("VALID_EMPBASECLASELEG",",oparms:[]}");
      setEventMetadata("VALID_EMPBASETIPO","{handler:'valid_Empbasetipo',iparms:[]");
      setEventMetadata("VALID_EMPBASETIPO",",oparms:[]}");
      setEventMetadata("VALID_EMPBASECOD1","{handler:'valid_Empbasecod1',iparms:[]");
      setEventMetadata("VALID_EMPBASECOD1",",oparms:[]}");
      setEventMetadata("VALID_EMPBASECOD2","{handler:'valid_Empbasecod2',iparms:[]");
      setEventMetadata("VALID_EMPBASECOD2",",oparms:[]}");
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
      wcpOA1429EmpBaseTipo = "" ;
      wcpOA1430EmpBaseCod1 = "" ;
      wcpOA1431EmpBaseCod2 = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A1429EmpBaseTipo = "" ;
      A1430EmpBaseCod1 = "" ;
      A1431EmpBaseCod2 = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      A1439EmpBasePromTCnt = "" ;
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
      H00KK2_A3CliCod = new int[1] ;
      H00KK2_A1EmpCod = new short[1] ;
      H00KK2_A2EmpNom = new String[] {""} ;
      AV18Pgmname = "" ;
      H00KK3_A3CliCod = new int[1] ;
      H00KK3_A1EmpCod = new short[1] ;
      H00KK3_A1427EmpBaseClaseLeg = new byte[1] ;
      H00KK3_A1429EmpBaseTipo = new String[] {""} ;
      H00KK3_A1430EmpBaseCod1 = new String[] {""} ;
      H00KK3_A1431EmpBaseCod2 = new String[] {""} ;
      H00KK3_A1518EmpBaseOrd = new short[1] ;
      H00KK3_n1518EmpBaseOrd = new boolean[] {false} ;
      H00KK3_A1439EmpBasePromTCnt = new String[] {""} ;
      H00KK3_A1438EmpBasePromCnt2 = new short[1] ;
      H00KK3_A1437EmpBasePromCnt1 = new short[1] ;
      H00KK3_A1511EmpLicMotObl = new boolean[] {false} ;
      H00KK3_n1511EmpLicMotObl = new boolean[] {false} ;
      H00KK3_A1510EmpLicIngMot = new boolean[] {false} ;
      H00KK3_n1510EmpLicIngMot = new boolean[] {false} ;
      H00KK3_A1509EmpLicNecAut = new boolean[] {false} ;
      H00KK3_n1509EmpLicNecAut = new boolean[] {false} ;
      H00KK3_A1508EmpLicAdjuObl = new boolean[] {false} ;
      H00KK3_n1508EmpLicAdjuObl = new boolean[] {false} ;
      H00KK3_A1507EmpLicAdju = new boolean[] {false} ;
      H00KK3_n1507EmpLicAdju = new boolean[] {false} ;
      H00KK3_A1506EmpLicDAnual = new short[1] ;
      H00KK3_n1506EmpLicDAnual = new boolean[] {false} ;
      H00KK3_A1505EmpLicDSemes = new short[1] ;
      H00KK3_n1505EmpLicDSemes = new boolean[] {false} ;
      H00KK3_A1504EmpLicDMes = new byte[1] ;
      H00KK3_n1504EmpLicDMes = new boolean[] {false} ;
      H00KK3_A1503EmpLicDSeman = new byte[1] ;
      H00KK3_n1503EmpLicDSeman = new boolean[] {false} ;
      H00KK3_A1502EmpLicDLim = new short[1] ;
      H00KK3_n1502EmpLicDLim = new boolean[] {false} ;
      H00KK3_A1517EmpLicDMin = new byte[1] ;
      H00KK3_n1517EmpLicDMin = new boolean[] {false} ;
      H00KK3_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV17Empbasetipo = "" ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1EmpCod = "" ;
      sCtrlA1427EmpBaseClaseLeg = "" ;
      sCtrlA1429EmpBaseTipo = "" ;
      sCtrlA1430EmpBaseCod1 = "" ;
      sCtrlA1431EmpBaseCod2 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresabase_calculogeneral__default(),
         new Object[] {
             new Object[] {
            H00KK2_A3CliCod, H00KK2_A1EmpCod, H00KK2_A2EmpNom
            }
            , new Object[] {
            H00KK3_A3CliCod, H00KK3_A1EmpCod, H00KK3_A1427EmpBaseClaseLeg, H00KK3_A1429EmpBaseTipo, H00KK3_A1430EmpBaseCod1, H00KK3_A1431EmpBaseCod2, H00KK3_A1518EmpBaseOrd, H00KK3_n1518EmpBaseOrd, H00KK3_A1439EmpBasePromTCnt, H00KK3_A1438EmpBasePromCnt2,
            H00KK3_A1437EmpBasePromCnt1, H00KK3_A1511EmpLicMotObl, H00KK3_n1511EmpLicMotObl, H00KK3_A1510EmpLicIngMot, H00KK3_n1510EmpLicIngMot, H00KK3_A1509EmpLicNecAut, H00KK3_n1509EmpLicNecAut, H00KK3_A1508EmpLicAdjuObl, H00KK3_n1508EmpLicAdjuObl, H00KK3_A1507EmpLicAdju,
            H00KK3_n1507EmpLicAdju, H00KK3_A1506EmpLicDAnual, H00KK3_n1506EmpLicDAnual, H00KK3_A1505EmpLicDSemes, H00KK3_n1505EmpLicDSemes, H00KK3_A1504EmpLicDMes, H00KK3_n1504EmpLicDMes, H00KK3_A1503EmpLicDSeman, H00KK3_n1503EmpLicDSeman, H00KK3_A1502EmpLicDLim,
            H00KK3_n1502EmpLicDLim, H00KK3_A1517EmpLicDMin, H00KK3_n1517EmpLicDMin, H00KK3_A1432EmpBasePlus
            }
         }
      );
      AV18Pgmname = "Empresabase_calculoGeneral" ;
      /* GeneXus formulas. */
      AV18Pgmname = "Empresabase_calculoGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte wcpOA1427EmpBaseClaseLeg ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1427EmpBaseClaseLeg ;
   private byte A1517EmpLicDMin ;
   private byte A1503EmpLicDSeman ;
   private byte A1504EmpLicDMes ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1502EmpLicDLim ;
   private short A1505EmpLicDSemes ;
   private short A1506EmpLicDAnual ;
   private short A1437EmpBasePromCnt1 ;
   private short A1438EmpBasePromCnt2 ;
   private short A1518EmpBaseOrd ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int AV13CliCod ;
   private int edtEmpBasePlus_Visible ;
   private int edtEmpBasePlus_Enabled ;
   private int edtEmpLicDMin_Visible ;
   private int edtEmpLicDMin_Enabled ;
   private int edtEmpLicDLim_Visible ;
   private int edtEmpLicDLim_Enabled ;
   private int edtEmpLicDSeman_Visible ;
   private int edtEmpLicDSeman_Enabled ;
   private int edtEmpLicDSemes_Visible ;
   private int edtEmpLicDSemes_Enabled ;
   private int edtEmpLicDAnual_Visible ;
   private int edtEmpLicDAnual_Enabled ;
   private int edtEmpBasePromCnt1_Enabled ;
   private int edtEmpBasePromCnt2_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtEmpBaseOrd_Visible ;
   private int gxdynajaxindex ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private java.math.BigDecimal A1432EmpBasePlus ;
   private String wcpOA1429EmpBaseTipo ;
   private String wcpOA1430EmpBaseCod1 ;
   private String wcpOA1431EmpBaseCod2 ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A1429EmpBaseTipo ;
   private String A1430EmpBaseCod1 ;
   private String A1431EmpBaseCod2 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String divEmpbasecod1_cell_Internalname ;
   private String divEmpbasecod1_cell_Class ;
   private String divEmpbasecod2_cell_Internalname ;
   private String divEmpbasecod2_cell_Class ;
   private String divEmpbaseplus_cell_Internalname ;
   private String divEmpbaseplus_cell_Class ;
   private String edtEmpBasePlus_Internalname ;
   private String edtEmpBasePlus_Jsonclick ;
   private String divEmplicdmin_cell_Internalname ;
   private String divEmplicdmin_cell_Class ;
   private String edtEmpLicDMin_Internalname ;
   private String edtEmpLicDMin_Jsonclick ;
   private String divEmplicdlim_cell_Internalname ;
   private String divEmplicdlim_cell_Class ;
   private String edtEmpLicDLim_Internalname ;
   private String edtEmpLicDLim_Jsonclick ;
   private String divEmplicdseman_cell_Internalname ;
   private String divEmplicdseman_cell_Class ;
   private String edtEmpLicDSeman_Internalname ;
   private String edtEmpLicDSeman_Jsonclick ;
   private String divEmplicdmes_cell_Internalname ;
   private String divEmplicdmes_cell_Class ;
   private String divEmplicdsemes_cell_Internalname ;
   private String divEmplicdsemes_cell_Class ;
   private String edtEmpLicDSemes_Internalname ;
   private String edtEmpLicDSemes_Jsonclick ;
   private String divEmplicdanual_cell_Internalname ;
   private String divEmplicdanual_cell_Class ;
   private String edtEmpLicDAnual_Internalname ;
   private String edtEmpLicDAnual_Jsonclick ;
   private String divEmplicadju_cell_Internalname ;
   private String divEmplicadju_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String divEmplicadjuobl_cell_Internalname ;
   private String divEmplicadjuobl_cell_Class ;
   private String divEmplicnecaut_cell_Internalname ;
   private String divEmplicnecaut_cell_Class ;
   private String divEmplicingmot_cell_Internalname ;
   private String divEmplicingmot_cell_Class ;
   private String divEmplicmotobl_cell_Internalname ;
   private String divEmplicmotobl_cell_Class ;
   private String edtEmpBasePromCnt1_Internalname ;
   private String edtEmpBasePromCnt1_Jsonclick ;
   private String edtEmpBasePromCnt2_Internalname ;
   private String edtEmpBasePromCnt2_Jsonclick ;
   private String A1439EmpBasePromTCnt ;
   private String TempTags ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpBaseOrd_Internalname ;
   private String edtEmpBaseOrd_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV18Pgmname ;
   private String AV17Empbasetipo ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1EmpCod ;
   private String sCtrlA1427EmpBaseClaseLeg ;
   private String sCtrlA1429EmpBaseTipo ;
   private String sCtrlA1430EmpBaseCod1 ;
   private String sCtrlA1431EmpBaseCod2 ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A1507EmpLicAdju ;
   private boolean A1508EmpLicAdjuObl ;
   private boolean A1509EmpLicNecAut ;
   private boolean A1510EmpLicIngMot ;
   private boolean A1511EmpLicMotObl ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1504EmpLicDMes ;
   private boolean n1507EmpLicAdju ;
   private boolean n1508EmpLicAdjuObl ;
   private boolean n1509EmpLicNecAut ;
   private boolean n1510EmpLicIngMot ;
   private boolean n1511EmpLicMotObl ;
   private boolean n1518EmpBaseOrd ;
   private boolean n1506EmpLicDAnual ;
   private boolean n1505EmpLicDSemes ;
   private boolean n1503EmpLicDSeman ;
   private boolean n1502EmpLicDLim ;
   private boolean n1517EmpLicDMin ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private HTMLChoice dynEmpCod ;
   private HTMLChoice cmbEmpBaseClaseLeg ;
   private HTMLChoice cmbEmpBaseTipo ;
   private HTMLChoice cmbEmpBaseCod1 ;
   private HTMLChoice cmbEmpBaseCod2 ;
   private HTMLChoice cmbEmpLicDMes ;
   private ICheckbox chkEmpLicAdju ;
   private ICheckbox chkEmpLicAdjuObl ;
   private ICheckbox chkEmpLicNecAut ;
   private ICheckbox chkEmpLicIngMot ;
   private ICheckbox chkEmpLicMotObl ;
   private HTMLChoice cmbEmpBasePromTCnt ;
   private IDataStoreProvider pr_default ;
   private int[] H00KK2_A3CliCod ;
   private short[] H00KK2_A1EmpCod ;
   private String[] H00KK2_A2EmpNom ;
   private int[] H00KK3_A3CliCod ;
   private short[] H00KK3_A1EmpCod ;
   private byte[] H00KK3_A1427EmpBaseClaseLeg ;
   private String[] H00KK3_A1429EmpBaseTipo ;
   private String[] H00KK3_A1430EmpBaseCod1 ;
   private String[] H00KK3_A1431EmpBaseCod2 ;
   private short[] H00KK3_A1518EmpBaseOrd ;
   private boolean[] H00KK3_n1518EmpBaseOrd ;
   private String[] H00KK3_A1439EmpBasePromTCnt ;
   private short[] H00KK3_A1438EmpBasePromCnt2 ;
   private short[] H00KK3_A1437EmpBasePromCnt1 ;
   private boolean[] H00KK3_A1511EmpLicMotObl ;
   private boolean[] H00KK3_n1511EmpLicMotObl ;
   private boolean[] H00KK3_A1510EmpLicIngMot ;
   private boolean[] H00KK3_n1510EmpLicIngMot ;
   private boolean[] H00KK3_A1509EmpLicNecAut ;
   private boolean[] H00KK3_n1509EmpLicNecAut ;
   private boolean[] H00KK3_A1508EmpLicAdjuObl ;
   private boolean[] H00KK3_n1508EmpLicAdjuObl ;
   private boolean[] H00KK3_A1507EmpLicAdju ;
   private boolean[] H00KK3_n1507EmpLicAdju ;
   private short[] H00KK3_A1506EmpLicDAnual ;
   private boolean[] H00KK3_n1506EmpLicDAnual ;
   private short[] H00KK3_A1505EmpLicDSemes ;
   private boolean[] H00KK3_n1505EmpLicDSemes ;
   private byte[] H00KK3_A1504EmpLicDMes ;
   private boolean[] H00KK3_n1504EmpLicDMes ;
   private byte[] H00KK3_A1503EmpLicDSeman ;
   private boolean[] H00KK3_n1503EmpLicDSeman ;
   private short[] H00KK3_A1502EmpLicDLim ;
   private boolean[] H00KK3_n1502EmpLicDLim ;
   private byte[] H00KK3_A1517EmpLicDMin ;
   private boolean[] H00KK3_n1517EmpLicDMin ;
   private java.math.BigDecimal[] H00KK3_A1432EmpBasePlus ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class empresabase_calculogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00KK2", "SELECT CliCod, EmpCod, EmpNom FROM Empresa WHERE CliCod = ? ORDER BY EmpNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KK3", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBaseOrd, EmpBasePromTCnt, EmpBasePromCnt2, EmpBasePromCnt1, EmpLicMotObl, EmpLicIngMot, EmpLicNecAut, EmpLicAdjuObl, EmpLicAdju, EmpLicDAnual, EmpLicDSemes, EmpLicDMes, EmpLicDSeman, EmpLicDLim, EmpLicDMin, EmpBasePlus FROM Empresabase_calculo WHERE CliCod = ? and EmpCod = ? and EmpBaseClaseLeg = ? and EmpBaseTipo = ( ?) and EmpBaseCod1 = ( ?) and EmpBaseCod2 = ( ?) ORDER BY CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((boolean[]) buf[15])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((short[]) buf[21])[0] = rslt.getShort(16);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((short[]) buf[23])[0] = rslt.getShort(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((byte[]) buf[25])[0] = rslt.getByte(18);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((byte[]) buf[27])[0] = rslt.getByte(19);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(20);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((byte[]) buf[31])[0] = rslt.getByte(21);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[33])[0] = rslt.getBigDecimal(22,4);
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
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
      }
   }

}

