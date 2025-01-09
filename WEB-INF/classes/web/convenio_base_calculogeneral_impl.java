package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_base_calculogeneral_impl extends GXWebComponent
{
   public convenio_base_calculogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_base_calculogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_base_calculogeneral_impl.class ));
   }

   public convenio_base_calculogeneral_impl( int remoteHandle ,
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
      cmbConveBaseClaseLeg = new HTMLChoice();
      cmbConveBaseTipo = new HTMLChoice();
      cmbConveLicDMes = new HTMLChoice();
      chkConveLicAdju = UIFactory.getCheckbox(this);
      chkConveLicAdjuObl = UIFactory.getCheckbox(this);
      chkConveLicNecAut = UIFactory.getCheckbox(this);
      chkConveLicIngMot = UIFactory.getCheckbox(this);
      chkConveLicMotObl = UIFactory.getCheckbox(this);
      cmbConveBasePromTCnt = new HTMLChoice();
      dynConveBaseRelSec = new HTMLChoice();
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
               A1454ConveBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "ConveBaseClaseLeg"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
               A1455ConveBaseTipo = httpContext.GetPar( "ConveBaseTipo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
               A1456ConveBaseCod1 = httpContext.GetPar( "ConveBaseCod1") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
               A1457ConveBaseCod2 = httpContext.GetPar( "ConveBaseCod2") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1564CliPaiConve),A1565CliConvenio,Byte.valueOf(A1454ConveBaseClaseLeg),A1455ConveBaseTipo,A1456ConveBaseCod1,A1457ConveBaseCod2});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVEBASERELSEC") == 0 )
            {
               AV13CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlaconvebaserelsecF02( AV13CliCod) ;
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
         paF02( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Convenio_base_calculo General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio_base_calculogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(A1454ConveBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(A1455ConveBaseTipo)),GXutil.URLEncode(GXutil.rtrim(A1456ConveBaseCod1)),GXutil.URLEncode(GXutil.rtrim(A1457ConveBaseCod2))}, new String[] {"CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1454ConveBaseClaseLeg", GXutil.ltrim( localUtil.ntoc( wcpOA1454ConveBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1455ConveBaseTipo", GXutil.rtrim( wcpOA1455ConveBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1456ConveBaseCod1", GXutil.rtrim( wcpOA1456ConveBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1457ConveBaseCod2", GXutil.rtrim( wcpOA1457ConveBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV13CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormF02( )
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
      return "Convenio_base_calculoGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Convenio_base_calculo General", "") ;
   }

   public void wbF00( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.convenio_base_calculogeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveBaseClaseLeg.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConveBaseClaseLeg.getInternalname(), httpContext.getMessage( "Clase de legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveBaseClaseLeg, cmbConveBaseClaseLeg.getInternalname(), GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)), 1, cmbConveBaseClaseLeg.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConveBaseClaseLeg.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Convenio_base_calculoGeneral.htm");
         cmbConveBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveBaseClaseLeg.getInternalname(), "Values", cmbConveBaseClaseLeg.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveBaseTipo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConveBaseTipo.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveBaseTipo, cmbConveBaseTipo.getInternalname(), GXutil.rtrim( A1455ConveBaseTipo), 1, cmbConveBaseTipo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConveBaseTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Convenio_base_calculoGeneral.htm");
         cmbConveBaseTipo.setValue( GXutil.rtrim( A1455ConveBaseTipo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveBaseTipo.getInternalname(), "Values", cmbConveBaseTipo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvebasecod1_cell_Internalname, 1, 0, "px", 0, "px", divConvebasecod1_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtConveBaseCod1_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveBaseCod1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveBaseCod1_Internalname, httpContext.getMessage( "Código 1", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveBaseCod1_Internalname, GXutil.rtrim( A1456ConveBaseCod1), GXutil.rtrim( localUtil.format( A1456ConveBaseCod1, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveBaseCod1_Jsonclick, 0, "Attribute", "", "", "", "", edtConveBaseCod1_Visible, edtConveBaseCod1_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvebasecod2_cell_Internalname, 1, 0, "px", 0, "px", divConvebasecod2_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtConveBaseCod2_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveBaseCod2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveBaseCod2_Internalname, httpContext.getMessage( "Código 2", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveBaseCod2_Internalname, GXutil.rtrim( A1457ConveBaseCod2), GXutil.rtrim( localUtil.format( A1457ConveBaseCod2, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveBaseCod2_Jsonclick, 0, "Attribute", "", "", "", "", edtConveBaseCod2_Visible, edtConveBaseCod2_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvebaseplus_cell_Internalname, 1, 0, "px", 0, "px", divConvebaseplus_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtConveBasePlus_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveBasePlus_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveBasePlus_Internalname, httpContext.getMessage( "Porcentaje para plus", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveBasePlus_Internalname, GXutil.ltrim( localUtil.ntoc( A1458ConveBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveBasePlus_Enabled!=0) ? localUtil.format( A1458ConveBasePlus, "9.9999") : localUtil.format( A1458ConveBasePlus, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveBasePlus_Jsonclick, 0, "Attribute", "", "", "", "", edtConveBasePlus_Visible, edtConveBasePlus_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvelicdlim_cell_Internalname, 1, 0, "px", 0, "px", divConvelicdlim_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtConveLicDLim_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveLicDLim_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveLicDLim_Internalname, httpContext.getMessage( "Cantidad de días permitidos por licencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveLicDLim_Internalname, GXutil.ltrim( localUtil.ntoc( A1610ConveLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveLicDLim_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1610ConveLicDLim), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1610ConveLicDLim), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveLicDLim_Jsonclick, 0, "Attribute", "", "", "", "", edtConveLicDLim_Visible, edtConveLicDLim_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvelicdseman_cell_Internalname, 1, 0, "px", 0, "px", divConvelicdseman_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtConveLicDSeman_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveLicDSeman_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveLicDSeman_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveLicDSeman_Internalname, GXutil.ltrim( localUtil.ntoc( A1611ConveLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveLicDSeman_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1611ConveLicDSeman), "9") : localUtil.format( DecimalUtil.doubleToDec(A1611ConveLicDSeman), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveLicDSeman_Jsonclick, 0, "Attribute", "", "", "", "", edtConveLicDSeman_Visible, edtConveLicDSeman_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvelicdmes_cell_Internalname, 1, 0, "px", 0, "px", divConvelicdmes_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbConveLicDMes.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveLicDMes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConveLicDMes.getInternalname(), httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveLicDMes, cmbConveLicDMes.getInternalname(), GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0)), 1, cmbConveLicDMes.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbConveLicDMes.getVisible(), cmbConveLicDMes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Convenio_base_calculoGeneral.htm");
         cmbConveLicDMes.setValue( GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveLicDMes.getInternalname(), "Values", cmbConveLicDMes.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvelicdsemes_cell_Internalname, 1, 0, "px", 0, "px", divConvelicdsemes_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtConveLicDSemes_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveLicDSemes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveLicDSemes_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveLicDSemes_Internalname, GXutil.ltrim( localUtil.ntoc( A1613ConveLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveLicDSemes_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1613ConveLicDSemes), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1613ConveLicDSemes), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveLicDSemes_Jsonclick, 0, "Attribute", "", "", "", "", edtConveLicDSemes_Visible, edtConveLicDSemes_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvelicdanual_cell_Internalname, 1, 0, "px", 0, "px", divConvelicdanual_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtConveLicDAnual_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveLicDAnual_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveLicDAnual_Internalname, httpContext.getMessage( "Cantidad de días permitidos por año", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveLicDAnual_Internalname, GXutil.ltrim( localUtil.ntoc( A1614ConveLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveLicDAnual_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1614ConveLicDAnual), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1614ConveLicDAnual), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveLicDAnual_Jsonclick, 0, "Attribute", "", "", "", "", edtConveLicDAnual_Visible, edtConveLicDAnual_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvelicadju_cell_Internalname, 1, 0, "px", 0, "px", divConvelicadju_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkConveLicAdju.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveLicAdju.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConveLicAdju.getInternalname(), httpContext.getMessage( "Permite adjuntar documento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveLicAdju.getInternalname(), GXutil.booltostr( A1615ConveLicAdju), "", httpContext.getMessage( "Permite adjuntar documento", ""), chkConveLicAdju.getVisible(), chkConveLicAdju.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvelicadjuobl_cell_Internalname, 1, 0, "px", 0, "px", divConvelicadjuobl_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkConveLicAdjuObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveLicAdjuObl.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConveLicAdjuObl.getInternalname(), httpContext.getMessage( "Obliga a adjuntar documento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveLicAdjuObl.getInternalname(), GXutil.booltostr( A1616ConveLicAdjuObl), "", httpContext.getMessage( "Obliga a adjuntar documento", ""), chkConveLicAdjuObl.getVisible(), chkConveLicAdjuObl.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvelicnecaut_cell_Internalname, 1, 0, "px", 0, "px", divConvelicnecaut_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkConveLicNecAut.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveLicNecAut.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConveLicNecAut.getInternalname(), httpContext.getMessage( "Necesita autorización", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveLicNecAut.getInternalname(), GXutil.booltostr( A1617ConveLicNecAut), "", httpContext.getMessage( "Necesita autorización", ""), chkConveLicNecAut.getVisible(), chkConveLicNecAut.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvelicingmot_cell_Internalname, 1, 0, "px", 0, "px", divConvelicingmot_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkConveLicIngMot.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveLicIngMot.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConveLicIngMot.getInternalname(), httpContext.getMessage( "Permite ingresar motivo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveLicIngMot.getInternalname(), GXutil.booltostr( A1618ConveLicIngMot), "", httpContext.getMessage( "Permite ingresar motivo", ""), chkConveLicIngMot.getVisible(), chkConveLicIngMot.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConvelicmotobl_cell_Internalname, 1, 0, "px", 0, "px", divConvelicmotobl_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkConveLicMotObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveLicMotObl.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkConveLicMotObl.getInternalname(), httpContext.getMessage( "Obliga a ingresar motivo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveLicMotObl.getInternalname(), GXutil.booltostr( A1619ConveLicMotObl), "", httpContext.getMessage( "Obliga a ingresar motivo", ""), chkConveLicMotObl.getVisible(), chkConveLicMotObl.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveBasePromCnt1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveBasePromCnt1_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveBasePromCnt1_Internalname, GXutil.ltrim( localUtil.ntoc( A1465ConveBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveBasePromCnt1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveBasePromCnt1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveBasePromCnt1_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveBasePromCnt2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveBasePromCnt2_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveBasePromCnt2_Internalname, GXutil.ltrim( localUtil.ntoc( A1466ConveBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveBasePromCnt2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveBasePromCnt2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveBasePromCnt2_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveBasePromTCnt.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConveBasePromTCnt.getInternalname(), httpContext.getMessage( "Días o Meses", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveBasePromTCnt, cmbConveBasePromTCnt.getInternalname(), GXutil.rtrim( A1467ConveBasePromTCnt), 1, cmbConveBasePromTCnt.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConveBasePromTCnt.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Convenio_base_calculoGeneral.htm");
         cmbConveBasePromTCnt.setValue( GXutil.rtrim( A1467ConveBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveBasePromTCnt.getInternalname(), "Values", cmbConveBasePromTCnt.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConveBaseRelSec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynConveBaseRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConveBaseRelSec, dynConveBaseRelSec.getInternalname(), GXutil.trim( GXutil.str( A2060ConveBaseRelSec, 6, 0)), 1, dynConveBaseRelSec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynConveBaseRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Convenio_base_calculoGeneral.htm");
         dynConveBaseRelSec.setValue( GXutil.trim( GXutil.str( A2060ConveBaseRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynConveBaseRelSec.getInternalname(), "Values", dynConveBaseRelSec.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11f01_client"+"'", TempTags, "", 2, "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 111,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12f01_client"+"'", TempTags, "", 2, "HLP_Convenio_base_calculoGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculoGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Convenio_base_calculoGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_base_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startF02( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Convenio_base_calculo General", ""), (short)(0)) ;
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
            strupF00( ) ;
         }
      }
   }

   public void wsF02( )
   {
      startF02( ) ;
      evtF02( ) ;
   }

   public void evtF02( )
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
                              strupF00( ) ;
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
                              strupF00( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13F02 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupF00( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14F02 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupF00( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15F02 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupF00( ) ;
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
                              strupF00( ) ;
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

   public void weF02( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormF02( ) ;
         }
      }
   }

   public void paF02( )
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

   public void gxdlaconvebaserelsecF02( int AV13CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconvebaserelsec_dataF02( AV13CliCod) ;
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

   public void gxaconvebaserelsec_htmlF02( int AV13CliCod )
   {
      int gxdynajaxvalue;
      gxdlaconvebaserelsec_dataF02( AV13CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveBaseRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynConveBaseRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconvebaserelsec_dataF02( int AV13CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00F02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00F02_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00F02_A1880CliReDTChar[0]);
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
      if ( cmbConveBaseClaseLeg.getItemCount() > 0 )
      {
         A1454ConveBaseClaseLeg = (byte)(GXutil.lval( cmbConveBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveBaseClaseLeg.getInternalname(), "Values", cmbConveBaseClaseLeg.ToJavascriptSource(), true);
      }
      if ( cmbConveBaseTipo.getItemCount() > 0 )
      {
         A1455ConveBaseTipo = cmbConveBaseTipo.getValidValue(A1455ConveBaseTipo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBaseTipo.setValue( GXutil.rtrim( A1455ConveBaseTipo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveBaseTipo.getInternalname(), "Values", cmbConveBaseTipo.ToJavascriptSource(), true);
      }
      if ( cmbConveLicDMes.getItemCount() > 0 )
      {
         A1612ConveLicDMes = (byte)(GXutil.lval( cmbConveLicDMes.getValidValue(GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveLicDMes.setValue( GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveLicDMes.getInternalname(), "Values", cmbConveLicDMes.ToJavascriptSource(), true);
      }
      A1615ConveLicAdju = GXutil.strtobool( GXutil.booltostr( A1615ConveLicAdju)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1615ConveLicAdju", A1615ConveLicAdju);
      A1616ConveLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1616ConveLicAdjuObl)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
      A1617ConveLicNecAut = GXutil.strtobool( GXutil.booltostr( A1617ConveLicNecAut)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
      A1618ConveLicIngMot = GXutil.strtobool( GXutil.booltostr( A1618ConveLicIngMot)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
      A1619ConveLicMotObl = GXutil.strtobool( GXutil.booltostr( A1619ConveLicMotObl)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
      if ( cmbConveBasePromTCnt.getItemCount() > 0 )
      {
         A1467ConveBasePromTCnt = cmbConveBasePromTCnt.getValidValue(A1467ConveBasePromTCnt) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBasePromTCnt.setValue( GXutil.rtrim( A1467ConveBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveBasePromTCnt.getInternalname(), "Values", cmbConveBasePromTCnt.ToJavascriptSource(), true);
      }
      if ( dynConveBaseRelSec.getItemCount() > 0 )
      {
         A2060ConveBaseRelSec = (int)(GXutil.lval( dynConveBaseRelSec.getValidValue(GXutil.trim( GXutil.str( A2060ConveBaseRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2060ConveBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2060ConveBaseRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveBaseRelSec.setValue( GXutil.trim( GXutil.str( A2060ConveBaseRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynConveBaseRelSec.getInternalname(), "Values", dynConveBaseRelSec.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfF02( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "Convenio_base_calculoGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfF02( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15F02 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00F03 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2060ConveBaseRelSec = H00F03_A2060ConveBaseRelSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2060ConveBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2060ConveBaseRelSec), 6, 0));
            A1467ConveBasePromTCnt = H00F03_A1467ConveBasePromTCnt[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
            A1466ConveBasePromCnt2 = H00F03_A1466ConveBasePromCnt2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1466ConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), 3, 0));
            A1465ConveBasePromCnt1 = H00F03_A1465ConveBasePromCnt1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1465ConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), 3, 0));
            A1619ConveLicMotObl = H00F03_A1619ConveLicMotObl[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
            A1618ConveLicIngMot = H00F03_A1618ConveLicIngMot[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
            A1617ConveLicNecAut = H00F03_A1617ConveLicNecAut[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
            A1616ConveLicAdjuObl = H00F03_A1616ConveLicAdjuObl[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
            A1615ConveLicAdju = H00F03_A1615ConveLicAdju[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1615ConveLicAdju", A1615ConveLicAdju);
            A1614ConveLicDAnual = H00F03_A1614ConveLicDAnual[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1614ConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1614ConveLicDAnual), 3, 0));
            A1613ConveLicDSemes = H00F03_A1613ConveLicDSemes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1613ConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1613ConveLicDSemes), 3, 0));
            A1612ConveLicDMes = H00F03_A1612ConveLicDMes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
            A1611ConveLicDSeman = H00F03_A1611ConveLicDSeman[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1611ConveLicDSeman", GXutil.str( A1611ConveLicDSeman, 1, 0));
            A1610ConveLicDLim = H00F03_A1610ConveLicDLim[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1610ConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1610ConveLicDLim), 3, 0));
            A1458ConveBasePlus = H00F03_A1458ConveBasePlus[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1458ConveBasePlus", GXutil.ltrimstr( A1458ConveBasePlus, 6, 4));
            /* Execute user event: Load */
            e14F02 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         wbF00( ) ;
      }
   }

   public void send_integrity_lvl_hashesF02( )
   {
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "Convenio_base_calculoGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupF00( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13F02 ();
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
         wcpOA1454ConveBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1454ConveBaseClaseLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1455ConveBaseTipo = httpContext.cgiGet( sPrefix+"wcpOA1455ConveBaseTipo") ;
         wcpOA1456ConveBaseCod1 = httpContext.cgiGet( sPrefix+"wcpOA1456ConveBaseCod1") ;
         wcpOA1457ConveBaseCod2 = httpContext.cgiGet( sPrefix+"wcpOA1457ConveBaseCod2") ;
         /* Read variables values. */
         A1458ConveBasePlus = localUtil.ctond( httpContext.cgiGet( edtConveBasePlus_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1458ConveBasePlus", GXutil.ltrimstr( A1458ConveBasePlus, 6, 4));
         A1610ConveLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( edtConveLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1610ConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1610ConveLicDLim), 3, 0));
         A1611ConveLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( edtConveLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1611ConveLicDSeman", GXutil.str( A1611ConveLicDSeman, 1, 0));
         cmbConveLicDMes.setValue( httpContext.cgiGet( cmbConveLicDMes.getInternalname()) );
         A1612ConveLicDMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbConveLicDMes.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
         A1613ConveLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( edtConveLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1613ConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1613ConveLicDSemes), 3, 0));
         A1614ConveLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( edtConveLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1614ConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1614ConveLicDAnual), 3, 0));
         A1615ConveLicAdju = GXutil.strtobool( httpContext.cgiGet( chkConveLicAdju.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1615ConveLicAdju", A1615ConveLicAdju);
         A1616ConveLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( chkConveLicAdjuObl.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
         A1617ConveLicNecAut = GXutil.strtobool( httpContext.cgiGet( chkConveLicNecAut.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
         A1618ConveLicIngMot = GXutil.strtobool( httpContext.cgiGet( chkConveLicIngMot.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
         A1619ConveLicMotObl = GXutil.strtobool( httpContext.cgiGet( chkConveLicMotObl.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
         A1465ConveBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( edtConveBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1465ConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), 3, 0));
         A1466ConveBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( edtConveBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1466ConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), 3, 0));
         cmbConveBasePromTCnt.setValue( httpContext.cgiGet( cmbConveBasePromTCnt.getInternalname()) );
         A1467ConveBasePromTCnt = httpContext.cgiGet( cmbConveBasePromTCnt.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
         dynConveBaseRelSec.setValue( httpContext.cgiGet( dynConveBaseRelSec.getInternalname()) );
         A2060ConveBaseRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynConveBaseRelSec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2060ConveBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2060ConveBaseRelSec), 6, 0));
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
      e13F02 ();
      if (returnInSub) return;
   }

   public void e13F02( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_base_calculogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14F02( )
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
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_base_calculo_Update", GXv_boolean5) ;
      convenio_base_calculogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_base_calculo_Delete", GXv_boolean5) ;
      convenio_base_calculogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "horaNormal") != 0 ) ) )
      {
         edtConveBaseCod1_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveBaseCod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod1_Visible), 5, 0), true);
         divConvebasecod1_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvebasecod1_cell_Internalname, "Class", divConvebasecod1_cell_Class, true);
      }
      else
      {
         edtConveBaseCod1_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveBaseCod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod1_Visible), 5, 0), true);
         divConvebasecod1_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvebasecod1_cell_Internalname, "Class", divConvebasecod1_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "horaNormal") != 0 ) ) )
      {
         edtConveBaseCod2_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveBaseCod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod2_Visible), 5, 0), true);
         divConvebasecod2_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvebasecod2_cell_Internalname, "Class", divConvebasecod2_cell_Class, true);
      }
      else
      {
         edtConveBaseCod2_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveBaseCod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod2_Visible), 5, 0), true);
         divConvebasecod2_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvebasecod2_cell_Internalname, "Class", divConvebasecod2_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "horaNormal") != 0 ) ) )
      {
         edtConveBasePlus_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveBasePlus_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBasePlus_Visible), 5, 0), true);
         divConvebaseplus_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvebaseplus_cell_Internalname, "Class", divConvebaseplus_cell_Class, true);
      }
      else
      {
         edtConveBasePlus_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveBasePlus_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBasePlus_Visible), 5, 0), true);
         divConvebaseplus_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvebaseplus_cell_Internalname, "Class", divConvebaseplus_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "licencia") == 0 ) ) )
      {
         edtConveLicDLim_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDLim_Visible), 5, 0), true);
         divConvelicdlim_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicdlim_cell_Internalname, "Class", divConvelicdlim_cell_Class, true);
      }
      else
      {
         edtConveLicDLim_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDLim_Visible), 5, 0), true);
         divConvelicdlim_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicdlim_cell_Internalname, "Class", divConvelicdlim_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "licencia") == 0 ) ) )
      {
         edtConveLicDSeman_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSeman_Visible), 5, 0), true);
         divConvelicdseman_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicdseman_cell_Internalname, "Class", divConvelicdseman_cell_Class, true);
      }
      else
      {
         edtConveLicDSeman_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSeman_Visible), 5, 0), true);
         divConvelicdseman_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicdseman_cell_Internalname, "Class", divConvelicdseman_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "licencia") == 0 ) ) )
      {
         cmbConveLicDMes.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveLicDMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveLicDMes.getVisible(), 5, 0), true);
         divConvelicdmes_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicdmes_cell_Internalname, "Class", divConvelicdmes_cell_Class, true);
      }
      else
      {
         cmbConveLicDMes.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveLicDMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveLicDMes.getVisible(), 5, 0), true);
         divConvelicdmes_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicdmes_cell_Internalname, "Class", divConvelicdmes_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "licencia") == 0 ) ) )
      {
         edtConveLicDSemes_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSemes_Visible), 5, 0), true);
         divConvelicdsemes_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicdsemes_cell_Internalname, "Class", divConvelicdsemes_cell_Class, true);
      }
      else
      {
         edtConveLicDSemes_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSemes_Visible), 5, 0), true);
         divConvelicdsemes_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicdsemes_cell_Internalname, "Class", divConvelicdsemes_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "licencia") == 0 ) ) )
      {
         edtConveLicDAnual_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDAnual_Visible), 5, 0), true);
         divConvelicdanual_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicdanual_cell_Internalname, "Class", divConvelicdanual_cell_Class, true);
      }
      else
      {
         edtConveLicDAnual_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDAnual_Visible), 5, 0), true);
         divConvelicdanual_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicdanual_cell_Internalname, "Class", divConvelicdanual_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "licencia") == 0 ) ) )
      {
         chkConveLicAdju.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicAdju.getVisible(), 5, 0), true);
         divConvelicadju_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicadju_cell_Internalname, "Class", divConvelicadju_cell_Class, true);
      }
      else
      {
         chkConveLicAdju.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicAdju.getVisible(), 5, 0), true);
         divConvelicadju_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicadju_cell_Internalname, "Class", divConvelicadju_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "licencia") == 0 ) ) )
      {
         chkConveLicAdjuObl.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicAdjuObl.getVisible(), 5, 0), true);
         divConvelicadjuobl_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicadjuobl_cell_Internalname, "Class", divConvelicadjuobl_cell_Class, true);
      }
      else
      {
         chkConveLicAdjuObl.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicAdjuObl.getVisible(), 5, 0), true);
         divConvelicadjuobl_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicadjuobl_cell_Internalname, "Class", divConvelicadjuobl_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "licencia") == 0 ) ) )
      {
         chkConveLicNecAut.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicNecAut.getVisible(), 5, 0), true);
         divConvelicnecaut_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicnecaut_cell_Internalname, "Class", divConvelicnecaut_cell_Class, true);
      }
      else
      {
         chkConveLicNecAut.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicNecAut.getVisible(), 5, 0), true);
         divConvelicnecaut_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicnecaut_cell_Internalname, "Class", divConvelicnecaut_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "licencia") == 0 ) ) )
      {
         chkConveLicIngMot.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicIngMot.getVisible(), 5, 0), true);
         divConvelicingmot_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicingmot_cell_Internalname, "Class", divConvelicingmot_cell_Class, true);
      }
      else
      {
         chkConveLicIngMot.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicIngMot.getVisible(), 5, 0), true);
         divConvelicingmot_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicingmot_cell_Internalname, "Class", divConvelicingmot_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Convebasetipo, "licencia") == 0 ) ) )
      {
         chkConveLicMotObl.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicMotObl.getVisible(), 5, 0), true);
         divConvelicmotobl_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicmotobl_cell_Internalname, "Class", divConvelicmotobl_cell_Class, true);
      }
      else
      {
         chkConveLicMotObl.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicMotObl.getVisible(), 5, 0), true);
         divConvelicmotobl_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConvelicmotobl_cell_Internalname, "Class", divConvelicmotobl_cell_Class, true);
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Convenio_base_calculo" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15F02( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_base_calculogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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
      A1454ConveBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
      A1455ConveBaseTipo = (String)getParm(obj,4,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
      A1456ConveBaseCod1 = (String)getParm(obj,5,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
      A1457ConveBaseCod2 = (String)getParm(obj,6,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
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
      paF02( ) ;
      wsF02( ) ;
      weF02( ) ;
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
      sCtrlA1454ConveBaseClaseLeg = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlA1455ConveBaseTipo = (String)getParm(obj,4,TypeConstants.STRING) ;
      sCtrlA1456ConveBaseCod1 = (String)getParm(obj,5,TypeConstants.STRING) ;
      sCtrlA1457ConveBaseCod2 = (String)getParm(obj,6,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paF02( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "convenio_base_calculogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paF02( ) ;
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
         A1454ConveBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
         A1455ConveBaseTipo = (String)getParm(obj,6,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
         A1456ConveBaseCod1 = (String)getParm(obj,7,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
         A1457ConveBaseCod2 = (String)getParm(obj,8,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1565CliConvenio = httpContext.cgiGet( sPrefix+"wcpOA1565CliConvenio") ;
      wcpOA1454ConveBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1454ConveBaseClaseLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1455ConveBaseTipo = httpContext.cgiGet( sPrefix+"wcpOA1455ConveBaseTipo") ;
      wcpOA1456ConveBaseCod1 = httpContext.cgiGet( sPrefix+"wcpOA1456ConveBaseCod1") ;
      wcpOA1457ConveBaseCod2 = httpContext.cgiGet( sPrefix+"wcpOA1457ConveBaseCod2") ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1564CliPaiConve != wcpOA1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, wcpOA1565CliConvenio) != 0 ) || ( A1454ConveBaseClaseLeg != wcpOA1454ConveBaseClaseLeg ) || ( GXutil.strcmp(A1455ConveBaseTipo, wcpOA1455ConveBaseTipo) != 0 ) || ( GXutil.strcmp(A1456ConveBaseCod1, wcpOA1456ConveBaseCod1) != 0 ) || ( GXutil.strcmp(A1457ConveBaseCod2, wcpOA1457ConveBaseCod2) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1564CliPaiConve = A1564CliPaiConve ;
      wcpOA1565CliConvenio = A1565CliConvenio ;
      wcpOA1454ConveBaseClaseLeg = A1454ConveBaseClaseLeg ;
      wcpOA1455ConveBaseTipo = A1455ConveBaseTipo ;
      wcpOA1456ConveBaseCod1 = A1456ConveBaseCod1 ;
      wcpOA1457ConveBaseCod2 = A1457ConveBaseCod2 ;
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
      sCtrlA1454ConveBaseClaseLeg = httpContext.cgiGet( sPrefix+"A1454ConveBaseClaseLeg_CTRL") ;
      if ( GXutil.len( sCtrlA1454ConveBaseClaseLeg) > 0 )
      {
         A1454ConveBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sCtrlA1454ConveBaseClaseLeg), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
      }
      else
      {
         A1454ConveBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1454ConveBaseClaseLeg_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA1455ConveBaseTipo = httpContext.cgiGet( sPrefix+"A1455ConveBaseTipo_CTRL") ;
      if ( GXutil.len( sCtrlA1455ConveBaseTipo) > 0 )
      {
         A1455ConveBaseTipo = httpContext.cgiGet( sCtrlA1455ConveBaseTipo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
      }
      else
      {
         A1455ConveBaseTipo = httpContext.cgiGet( sPrefix+"A1455ConveBaseTipo_PARM") ;
      }
      sCtrlA1456ConveBaseCod1 = httpContext.cgiGet( sPrefix+"A1456ConveBaseCod1_CTRL") ;
      if ( GXutil.len( sCtrlA1456ConveBaseCod1) > 0 )
      {
         A1456ConveBaseCod1 = httpContext.cgiGet( sCtrlA1456ConveBaseCod1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
      }
      else
      {
         A1456ConveBaseCod1 = httpContext.cgiGet( sPrefix+"A1456ConveBaseCod1_PARM") ;
      }
      sCtrlA1457ConveBaseCod2 = httpContext.cgiGet( sPrefix+"A1457ConveBaseCod2_CTRL") ;
      if ( GXutil.len( sCtrlA1457ConveBaseCod2) > 0 )
      {
         A1457ConveBaseCod2 = httpContext.cgiGet( sCtrlA1457ConveBaseCod2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
      }
      else
      {
         A1457ConveBaseCod2 = httpContext.cgiGet( sPrefix+"A1457ConveBaseCod2_PARM") ;
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
      paF02( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsF02( ) ;
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
      wsF02( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1454ConveBaseClaseLeg_PARM", GXutil.ltrim( localUtil.ntoc( A1454ConveBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1454ConveBaseClaseLeg)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1454ConveBaseClaseLeg_CTRL", GXutil.rtrim( sCtrlA1454ConveBaseClaseLeg));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1455ConveBaseTipo_PARM", GXutil.rtrim( A1455ConveBaseTipo));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1455ConveBaseTipo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1455ConveBaseTipo_CTRL", GXutil.rtrim( sCtrlA1455ConveBaseTipo));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1456ConveBaseCod1_PARM", GXutil.rtrim( A1456ConveBaseCod1));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1456ConveBaseCod1)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1456ConveBaseCod1_CTRL", GXutil.rtrim( sCtrlA1456ConveBaseCod1));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1457ConveBaseCod2_PARM", GXutil.rtrim( A1457ConveBaseCod2));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1457ConveBaseCod2)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1457ConveBaseCod2_CTRL", GXutil.rtrim( sCtrlA1457ConveBaseCod2));
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
      weF02( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025131830475", true, true);
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
      httpContext.AddJavascriptSource("convenio_base_calculogeneral.js", "?2025131830475", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbConveBaseClaseLeg.setInternalname( sPrefix+"CONVEBASECLASELEG" );
      cmbConveBaseTipo.setInternalname( sPrefix+"CONVEBASETIPO" );
      edtConveBaseCod1_Internalname = sPrefix+"CONVEBASECOD1" ;
      divConvebasecod1_cell_Internalname = sPrefix+"CONVEBASECOD1_CELL" ;
      edtConveBaseCod2_Internalname = sPrefix+"CONVEBASECOD2" ;
      divConvebasecod2_cell_Internalname = sPrefix+"CONVEBASECOD2_CELL" ;
      edtConveBasePlus_Internalname = sPrefix+"CONVEBASEPLUS" ;
      divConvebaseplus_cell_Internalname = sPrefix+"CONVEBASEPLUS_CELL" ;
      edtConveLicDLim_Internalname = sPrefix+"CONVELICDLIM" ;
      divConvelicdlim_cell_Internalname = sPrefix+"CONVELICDLIM_CELL" ;
      edtConveLicDSeman_Internalname = sPrefix+"CONVELICDSEMAN" ;
      divConvelicdseman_cell_Internalname = sPrefix+"CONVELICDSEMAN_CELL" ;
      cmbConveLicDMes.setInternalname( sPrefix+"CONVELICDMES" );
      divConvelicdmes_cell_Internalname = sPrefix+"CONVELICDMES_CELL" ;
      edtConveLicDSemes_Internalname = sPrefix+"CONVELICDSEMES" ;
      divConvelicdsemes_cell_Internalname = sPrefix+"CONVELICDSEMES_CELL" ;
      edtConveLicDAnual_Internalname = sPrefix+"CONVELICDANUAL" ;
      divConvelicdanual_cell_Internalname = sPrefix+"CONVELICDANUAL_CELL" ;
      chkConveLicAdju.setInternalname( sPrefix+"CONVELICADJU" );
      divConvelicadju_cell_Internalname = sPrefix+"CONVELICADJU_CELL" ;
      chkConveLicAdjuObl.setInternalname( sPrefix+"CONVELICADJUOBL" );
      divConvelicadjuobl_cell_Internalname = sPrefix+"CONVELICADJUOBL_CELL" ;
      chkConveLicNecAut.setInternalname( sPrefix+"CONVELICNECAUT" );
      divConvelicnecaut_cell_Internalname = sPrefix+"CONVELICNECAUT_CELL" ;
      chkConveLicIngMot.setInternalname( sPrefix+"CONVELICINGMOT" );
      divConvelicingmot_cell_Internalname = sPrefix+"CONVELICINGMOT_CELL" ;
      chkConveLicMotObl.setInternalname( sPrefix+"CONVELICMOTOBL" );
      divConvelicmotobl_cell_Internalname = sPrefix+"CONVELICMOTOBL_CELL" ;
      edtConveBasePromCnt1_Internalname = sPrefix+"CONVEBASEPROMCNT1" ;
      edtConveBasePromCnt2_Internalname = sPrefix+"CONVEBASEPROMCNT2" ;
      cmbConveBasePromTCnt.setInternalname( sPrefix+"CONVEBASEPROMTCNT" );
      dynConveBaseRelSec.setInternalname( sPrefix+"CONVEBASERELSEC" );
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
      dynConveBaseRelSec.setJsonclick( "" );
      dynConveBaseRelSec.setEnabled( 0 );
      cmbConveBasePromTCnt.setJsonclick( "" );
      cmbConveBasePromTCnt.setEnabled( 0 );
      edtConveBasePromCnt2_Jsonclick = "" ;
      edtConveBasePromCnt2_Enabled = 0 ;
      edtConveBasePromCnt1_Jsonclick = "" ;
      edtConveBasePromCnt1_Enabled = 0 ;
      chkConveLicMotObl.setEnabled( 0 );
      chkConveLicMotObl.setVisible( 1 );
      divConvelicmotobl_cell_Class = "col-xs-12" ;
      chkConveLicIngMot.setEnabled( 0 );
      chkConveLicIngMot.setVisible( 1 );
      divConvelicingmot_cell_Class = "col-xs-12" ;
      chkConveLicNecAut.setEnabled( 0 );
      chkConveLicNecAut.setVisible( 1 );
      divConvelicnecaut_cell_Class = "col-xs-12" ;
      chkConveLicAdjuObl.setEnabled( 0 );
      chkConveLicAdjuObl.setVisible( 1 );
      divConvelicadjuobl_cell_Class = "col-xs-12" ;
      chkConveLicAdju.setEnabled( 0 );
      chkConveLicAdju.setVisible( 1 );
      divConvelicadju_cell_Class = "col-xs-12" ;
      edtConveLicDAnual_Jsonclick = "" ;
      edtConveLicDAnual_Enabled = 0 ;
      edtConveLicDAnual_Visible = 1 ;
      divConvelicdanual_cell_Class = "col-xs-12" ;
      edtConveLicDSemes_Jsonclick = "" ;
      edtConveLicDSemes_Enabled = 0 ;
      edtConveLicDSemes_Visible = 1 ;
      divConvelicdsemes_cell_Class = "col-xs-12" ;
      cmbConveLicDMes.setJsonclick( "" );
      cmbConveLicDMes.setEnabled( 0 );
      cmbConveLicDMes.setVisible( 1 );
      divConvelicdmes_cell_Class = "col-xs-12" ;
      edtConveLicDSeman_Jsonclick = "" ;
      edtConveLicDSeman_Enabled = 0 ;
      edtConveLicDSeman_Visible = 1 ;
      divConvelicdseman_cell_Class = "col-xs-12" ;
      edtConveLicDLim_Jsonclick = "" ;
      edtConveLicDLim_Enabled = 0 ;
      edtConveLicDLim_Visible = 1 ;
      divConvelicdlim_cell_Class = "col-xs-12" ;
      edtConveBasePlus_Jsonclick = "" ;
      edtConveBasePlus_Enabled = 0 ;
      edtConveBasePlus_Visible = 1 ;
      divConvebaseplus_cell_Class = "col-xs-12" ;
      edtConveBaseCod2_Jsonclick = "" ;
      edtConveBaseCod2_Enabled = 0 ;
      edtConveBaseCod2_Visible = 1 ;
      divConvebasecod2_cell_Class = "col-xs-12" ;
      edtConveBaseCod1_Jsonclick = "" ;
      edtConveBaseCod1_Enabled = 0 ;
      edtConveBaseCod1_Visible = 1 ;
      divConvebasecod1_cell_Class = "col-xs-12" ;
      cmbConveBaseTipo.setJsonclick( "" );
      cmbConveBaseTipo.setEnabled( 0 );
      cmbConveBaseClaseLeg.setJsonclick( "" );
      cmbConveBaseClaseLeg.setEnabled( 0 );
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
      cmbConveBaseClaseLeg.setName( "CONVEBASECLASELEG" );
      cmbConveBaseClaseLeg.setWebtags( "" );
      cmbConveBaseClaseLeg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbConveBaseClaseLeg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbConveBaseClaseLeg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbConveBaseClaseLeg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbConveBaseClaseLeg.getItemCount() > 0 )
      {
      }
      cmbConveBaseTipo.setName( "CONVEBASETIPO" );
      cmbConveBaseTipo.setWebtags( "" );
      cmbConveBaseTipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
      cmbConveBaseTipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
      cmbConveBaseTipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
      if ( cmbConveBaseTipo.getItemCount() > 0 )
      {
      }
      cmbConveLicDMes.setName( "CONVELICDMES" );
      cmbConveLicDMes.setWebtags( "" );
      if ( cmbConveLicDMes.getItemCount() > 0 )
      {
      }
      chkConveLicAdju.setName( "CONVELICADJU" );
      chkConveLicAdju.setWebtags( "" );
      chkConveLicAdju.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicAdju.getInternalname(), "TitleCaption", chkConveLicAdju.getCaption(), true);
      chkConveLicAdju.setCheckedValue( "false" );
      chkConveLicAdjuObl.setName( "CONVELICADJUOBL" );
      chkConveLicAdjuObl.setWebtags( "" );
      chkConveLicAdjuObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicAdjuObl.getInternalname(), "TitleCaption", chkConveLicAdjuObl.getCaption(), true);
      chkConveLicAdjuObl.setCheckedValue( "false" );
      chkConveLicNecAut.setName( "CONVELICNECAUT" );
      chkConveLicNecAut.setWebtags( "" );
      chkConveLicNecAut.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicNecAut.getInternalname(), "TitleCaption", chkConveLicNecAut.getCaption(), true);
      chkConveLicNecAut.setCheckedValue( "false" );
      chkConveLicIngMot.setName( "CONVELICINGMOT" );
      chkConveLicIngMot.setWebtags( "" );
      chkConveLicIngMot.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicIngMot.getInternalname(), "TitleCaption", chkConveLicIngMot.getCaption(), true);
      chkConveLicIngMot.setCheckedValue( "false" );
      chkConveLicMotObl.setName( "CONVELICMOTOBL" );
      chkConveLicMotObl.setWebtags( "" );
      chkConveLicMotObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkConveLicMotObl.getInternalname(), "TitleCaption", chkConveLicMotObl.getCaption(), true);
      chkConveLicMotObl.setCheckedValue( "false" );
      cmbConveBasePromTCnt.setName( "CONVEBASEPROMTCNT" );
      cmbConveBasePromTCnt.setWebtags( "" );
      cmbConveBasePromTCnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
      cmbConveBasePromTCnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbConveBasePromTCnt.getItemCount() > 0 )
      {
      }
      dynConveBaseRelSec.setName( "CONVEBASERELSEC" );
      dynConveBaseRelSec.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'cmbConveBaseClaseLeg'},{av:'A1454ConveBaseClaseLeg',fld:'CONVEBASECLASELEG',pic:'9'},{av:'cmbConveBaseTipo'},{av:'A1455ConveBaseTipo',fld:'CONVEBASETIPO',pic:''},{av:'A1456ConveBaseCod1',fld:'CONVEBASECOD1',pic:''},{av:'A1457ConveBaseCod2',fld:'CONVEBASECOD2',pic:''},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11F01',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'cmbConveBaseClaseLeg'},{av:'A1454ConveBaseClaseLeg',fld:'CONVEBASECLASELEG',pic:'9'},{av:'cmbConveBaseTipo'},{av:'A1455ConveBaseTipo',fld:'CONVEBASETIPO',pic:''},{av:'A1456ConveBaseCod1',fld:'CONVEBASECOD1',pic:''},{av:'A1457ConveBaseCod2',fld:'CONVEBASECOD2',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12F01',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'cmbConveBaseClaseLeg'},{av:'A1454ConveBaseClaseLeg',fld:'CONVEBASECLASELEG',pic:'9'},{av:'cmbConveBaseTipo'},{av:'A1455ConveBaseTipo',fld:'CONVEBASETIPO',pic:''},{av:'A1456ConveBaseCod1',fld:'CONVEBASECOD1',pic:''},{av:'A1457ConveBaseCod2',fld:'CONVEBASECOD2',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CONVEBASECLASELEG","{handler:'valid_Convebaseclaseleg',iparms:[]");
      setEventMetadata("VALID_CONVEBASECLASELEG",",oparms:[]}");
      setEventMetadata("VALID_CONVEBASETIPO","{handler:'valid_Convebasetipo',iparms:[]");
      setEventMetadata("VALID_CONVEBASETIPO",",oparms:[]}");
      setEventMetadata("VALID_CONVEBASECOD1","{handler:'valid_Convebasecod1',iparms:[]");
      setEventMetadata("VALID_CONVEBASECOD1",",oparms:[]}");
      setEventMetadata("VALID_CONVEBASECOD2","{handler:'valid_Convebasecod2',iparms:[]");
      setEventMetadata("VALID_CONVEBASECOD2",",oparms:[]}");
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
      wcpOA1455ConveBaseTipo = "" ;
      wcpOA1456ConveBaseCod1 = "" ;
      wcpOA1457ConveBaseCod2 = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A1565CliConvenio = "" ;
      A1455ConveBaseTipo = "" ;
      A1456ConveBaseCod1 = "" ;
      A1457ConveBaseCod2 = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A1458ConveBasePlus = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      A1467ConveBasePromTCnt = "" ;
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
      H00F02_A3CliCod = new int[1] ;
      H00F02_A1885CliRelSec = new int[1] ;
      H00F02_A1880CliReDTChar = new String[] {""} ;
      AV18Pgmname = "" ;
      H00F03_A3CliCod = new int[1] ;
      H00F03_A1564CliPaiConve = new short[1] ;
      H00F03_A1565CliConvenio = new String[] {""} ;
      H00F03_A1454ConveBaseClaseLeg = new byte[1] ;
      H00F03_A1455ConveBaseTipo = new String[] {""} ;
      H00F03_A1456ConveBaseCod1 = new String[] {""} ;
      H00F03_A1457ConveBaseCod2 = new String[] {""} ;
      H00F03_A2060ConveBaseRelSec = new int[1] ;
      H00F03_A1467ConveBasePromTCnt = new String[] {""} ;
      H00F03_A1466ConveBasePromCnt2 = new short[1] ;
      H00F03_A1465ConveBasePromCnt1 = new short[1] ;
      H00F03_A1619ConveLicMotObl = new boolean[] {false} ;
      H00F03_A1618ConveLicIngMot = new boolean[] {false} ;
      H00F03_A1617ConveLicNecAut = new boolean[] {false} ;
      H00F03_A1616ConveLicAdjuObl = new boolean[] {false} ;
      H00F03_A1615ConveLicAdju = new boolean[] {false} ;
      H00F03_A1614ConveLicDAnual = new short[1] ;
      H00F03_A1613ConveLicDSemes = new short[1] ;
      H00F03_A1612ConveLicDMes = new byte[1] ;
      H00F03_A1611ConveLicDSeman = new byte[1] ;
      H00F03_A1610ConveLicDLim = new short[1] ;
      H00F03_A1458ConveBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV17Convebasetipo = "" ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1564CliPaiConve = "" ;
      sCtrlA1565CliConvenio = "" ;
      sCtrlA1454ConveBaseClaseLeg = "" ;
      sCtrlA1455ConveBaseTipo = "" ;
      sCtrlA1456ConveBaseCod1 = "" ;
      sCtrlA1457ConveBaseCod2 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_base_calculogeneral__default(),
         new Object[] {
             new Object[] {
            H00F02_A3CliCod, H00F02_A1885CliRelSec, H00F02_A1880CliReDTChar
            }
            , new Object[] {
            H00F03_A3CliCod, H00F03_A1564CliPaiConve, H00F03_A1565CliConvenio, H00F03_A1454ConveBaseClaseLeg, H00F03_A1455ConveBaseTipo, H00F03_A1456ConveBaseCod1, H00F03_A1457ConveBaseCod2, H00F03_A2060ConveBaseRelSec, H00F03_A1467ConveBasePromTCnt, H00F03_A1466ConveBasePromCnt2,
            H00F03_A1465ConveBasePromCnt1, H00F03_A1619ConveLicMotObl, H00F03_A1618ConveLicIngMot, H00F03_A1617ConveLicNecAut, H00F03_A1616ConveLicAdjuObl, H00F03_A1615ConveLicAdju, H00F03_A1614ConveLicDAnual, H00F03_A1613ConveLicDSemes, H00F03_A1612ConveLicDMes, H00F03_A1611ConveLicDSeman,
            H00F03_A1610ConveLicDLim, H00F03_A1458ConveBasePlus
            }
         }
      );
      AV18Pgmname = "Convenio_base_calculoGeneral" ;
      /* GeneXus formulas. */
      AV18Pgmname = "Convenio_base_calculoGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte wcpOA1454ConveBaseClaseLeg ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1454ConveBaseClaseLeg ;
   private byte A1611ConveLicDSeman ;
   private byte A1612ConveLicDMes ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1564CliPaiConve ;
   private short A1564CliPaiConve ;
   private short wbEnd ;
   private short wbStart ;
   private short A1610ConveLicDLim ;
   private short A1613ConveLicDSemes ;
   private short A1614ConveLicDAnual ;
   private short A1465ConveBasePromCnt1 ;
   private short A1466ConveBasePromCnt2 ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int AV13CliCod ;
   private int edtConveBaseCod1_Visible ;
   private int edtConveBaseCod1_Enabled ;
   private int edtConveBaseCod2_Visible ;
   private int edtConveBaseCod2_Enabled ;
   private int edtConveBasePlus_Visible ;
   private int edtConveBasePlus_Enabled ;
   private int edtConveLicDLim_Visible ;
   private int edtConveLicDLim_Enabled ;
   private int edtConveLicDSeman_Visible ;
   private int edtConveLicDSeman_Enabled ;
   private int edtConveLicDSemes_Visible ;
   private int edtConveLicDSemes_Enabled ;
   private int edtConveLicDAnual_Visible ;
   private int edtConveLicDAnual_Enabled ;
   private int edtConveBasePromCnt1_Enabled ;
   private int edtConveBasePromCnt2_Enabled ;
   private int A2060ConveBaseRelSec ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtCliPaiConve_Visible ;
   private int edtCliConvenio_Visible ;
   private int gxdynajaxindex ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private java.math.BigDecimal A1458ConveBasePlus ;
   private String wcpOA1565CliConvenio ;
   private String wcpOA1455ConveBaseTipo ;
   private String wcpOA1456ConveBaseCod1 ;
   private String wcpOA1457ConveBaseCod2 ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A1565CliConvenio ;
   private String A1455ConveBaseTipo ;
   private String A1456ConveBaseCod1 ;
   private String A1457ConveBaseCod2 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String divConvebasecod1_cell_Internalname ;
   private String divConvebasecod1_cell_Class ;
   private String edtConveBaseCod1_Internalname ;
   private String edtConveBaseCod1_Jsonclick ;
   private String divConvebasecod2_cell_Internalname ;
   private String divConvebasecod2_cell_Class ;
   private String edtConveBaseCod2_Internalname ;
   private String edtConveBaseCod2_Jsonclick ;
   private String divConvebaseplus_cell_Internalname ;
   private String divConvebaseplus_cell_Class ;
   private String edtConveBasePlus_Internalname ;
   private String edtConveBasePlus_Jsonclick ;
   private String divConvelicdlim_cell_Internalname ;
   private String divConvelicdlim_cell_Class ;
   private String edtConveLicDLim_Internalname ;
   private String edtConveLicDLim_Jsonclick ;
   private String divConvelicdseman_cell_Internalname ;
   private String divConvelicdseman_cell_Class ;
   private String edtConveLicDSeman_Internalname ;
   private String edtConveLicDSeman_Jsonclick ;
   private String divConvelicdmes_cell_Internalname ;
   private String divConvelicdmes_cell_Class ;
   private String divConvelicdsemes_cell_Internalname ;
   private String divConvelicdsemes_cell_Class ;
   private String edtConveLicDSemes_Internalname ;
   private String edtConveLicDSemes_Jsonclick ;
   private String divConvelicdanual_cell_Internalname ;
   private String divConvelicdanual_cell_Class ;
   private String edtConveLicDAnual_Internalname ;
   private String edtConveLicDAnual_Jsonclick ;
   private String divConvelicadju_cell_Internalname ;
   private String divConvelicadju_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String divConvelicadjuobl_cell_Internalname ;
   private String divConvelicadjuobl_cell_Class ;
   private String divConvelicnecaut_cell_Internalname ;
   private String divConvelicnecaut_cell_Class ;
   private String divConvelicingmot_cell_Internalname ;
   private String divConvelicingmot_cell_Class ;
   private String divConvelicmotobl_cell_Internalname ;
   private String divConvelicmotobl_cell_Class ;
   private String edtConveBasePromCnt1_Internalname ;
   private String edtConveBasePromCnt1_Jsonclick ;
   private String edtConveBasePromCnt2_Internalname ;
   private String edtConveBasePromCnt2_Jsonclick ;
   private String A1467ConveBasePromTCnt ;
   private String TempTags ;
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
   private String AV18Pgmname ;
   private String AV17Convebasetipo ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1564CliPaiConve ;
   private String sCtrlA1565CliConvenio ;
   private String sCtrlA1454ConveBaseClaseLeg ;
   private String sCtrlA1455ConveBaseTipo ;
   private String sCtrlA1456ConveBaseCod1 ;
   private String sCtrlA1457ConveBaseCod2 ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A1615ConveLicAdju ;
   private boolean A1616ConveLicAdjuObl ;
   private boolean A1617ConveLicNecAut ;
   private boolean A1618ConveLicIngMot ;
   private boolean A1619ConveLicMotObl ;
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
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private HTMLChoice cmbConveBaseClaseLeg ;
   private HTMLChoice cmbConveBaseTipo ;
   private HTMLChoice cmbConveLicDMes ;
   private ICheckbox chkConveLicAdju ;
   private ICheckbox chkConveLicAdjuObl ;
   private ICheckbox chkConveLicNecAut ;
   private ICheckbox chkConveLicIngMot ;
   private ICheckbox chkConveLicMotObl ;
   private HTMLChoice cmbConveBasePromTCnt ;
   private HTMLChoice dynConveBaseRelSec ;
   private IDataStoreProvider pr_default ;
   private int[] H00F02_A3CliCod ;
   private int[] H00F02_A1885CliRelSec ;
   private String[] H00F02_A1880CliReDTChar ;
   private int[] H00F03_A3CliCod ;
   private short[] H00F03_A1564CliPaiConve ;
   private String[] H00F03_A1565CliConvenio ;
   private byte[] H00F03_A1454ConveBaseClaseLeg ;
   private String[] H00F03_A1455ConveBaseTipo ;
   private String[] H00F03_A1456ConveBaseCod1 ;
   private String[] H00F03_A1457ConveBaseCod2 ;
   private int[] H00F03_A2060ConveBaseRelSec ;
   private String[] H00F03_A1467ConveBasePromTCnt ;
   private short[] H00F03_A1466ConveBasePromCnt2 ;
   private short[] H00F03_A1465ConveBasePromCnt1 ;
   private boolean[] H00F03_A1619ConveLicMotObl ;
   private boolean[] H00F03_A1618ConveLicIngMot ;
   private boolean[] H00F03_A1617ConveLicNecAut ;
   private boolean[] H00F03_A1616ConveLicAdjuObl ;
   private boolean[] H00F03_A1615ConveLicAdju ;
   private short[] H00F03_A1614ConveLicDAnual ;
   private short[] H00F03_A1613ConveLicDSemes ;
   private byte[] H00F03_A1612ConveLicDMes ;
   private byte[] H00F03_A1611ConveLicDSeman ;
   private short[] H00F03_A1610ConveLicDLim ;
   private java.math.BigDecimal[] H00F03_A1458ConveBasePlus ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class convenio_base_calculogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00F02", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00F03", "SELECT CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2, ConveBaseRelSec, ConveBasePromTCnt, ConveBasePromCnt2, ConveBasePromCnt1, ConveLicMotObl, ConveLicIngMot, ConveLicNecAut, ConveLicAdjuObl, ConveLicAdju, ConveLicDAnual, ConveLicDSemes, ConveLicDMes, ConveLicDSeman, ConveLicDLim, ConveBasePlus FROM Convenio_base_calculo WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveBaseClaseLeg = ? and ConveBaseTipo = ( ?) and ConveBaseCod1 = ( ?) and ConveBaseCod2 = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((byte[]) buf[18])[0] = rslt.getByte(19);
               ((byte[]) buf[19])[0] = rslt.getByte(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,4);
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
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
      }
   }

}

