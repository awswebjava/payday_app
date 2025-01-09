package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresageneral_impl extends GXWebComponent
{
   public empresageneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresageneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresageneral_impl.class ));
   }

   public empresageneral_impl( int remoteHandle ,
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
      dynTipEmpleCod = new HTMLChoice();
      dynARTSec = new HTMLChoice();
      chkEmpLiqFer = UIFactory.getCheckbox(this);
      chkEmpLiqFerJor = UIFactory.getCheckbox(this);
      chkEmpLiqGan = UIFactory.getCheckbox(this);
      cmbEmpTipoExp = new HTMLChoice();
      cmbEmpPromDesde = new HTMLChoice();
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
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1EmpCod)});
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
         pa4Y2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Empresa General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empresageneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0))}, new String[] {"CliCod","EmpCod"}) +"\">") ;
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
   }

   public void renderHtmlCloseForm4Y2( )
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
      return "EmpresaGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Empresa General", "") ;
   }

   public void wb4Y0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.empresageneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpNom_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpNom_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpNom_Internalname, A2EmpNom, GXutil.rtrim( localUtil.format( A2EmpNom, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpNom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpNom_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpCUIT_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpCUIT_Internalname, httpContext.getMessage( "CUIT", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCUIT_Internalname, GXutil.ltrim( localUtil.ntoc( A177EmpCUIT, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCUIT_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A177EmpCUIT), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A177EmpCUIT), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCUIT_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCUIT_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtActDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtActDescrip_Internalname, httpContext.getMessage( "Actividad (SICOSS)", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtActDescrip_Internalname, A108ActDescrip, GXutil.rtrim( localUtil.format( A108ActDescrip, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtActDescrip_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtActDescrip_Enabled, 0, "text", "", 80, "chr", 1, "row", 150, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynTipEmpleCod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynTipEmpleCod.getInternalname(), httpContext.getMessage( "Tipo de Empleador", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynTipEmpleCod, dynTipEmpleCod.getInternalname(), GXutil.rtrim( A45TipEmpleCod), 1, dynTipEmpleCod.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynTipEmpleCod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_EmpresaGeneral.htm");
         dynTipEmpleCod.setValue( GXutil.rtrim( A45TipEmpleCod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynTipEmpleCod.getInternalname(), "Values", dynTipEmpleCod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpZonDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpZonDescrip_Internalname, httpContext.getMessage( "Zona", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtEmpZonDescrip_Internalname, A518EmpZonDescrip, "", "", (short)(0), 1, edtEmpZonDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLogo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpLogo_Internalname, httpContext.getMessage( "Logo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         ClassString = "Attribute" ;
         StyleString = "" ;
         edtEmpLogo_Filename = A956EmpLogoNom ;
         edtEmpLogo_Filetype = "" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLogo_Internalname, "Filetype", edtEmpLogo_Filetype, true);
         edtEmpLogo_Filetype = A957EmpLogoExt ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLogo_Internalname, "Filetype", edtEmpLogo_Filetype, true);
         if ( ! (GXutil.strcmp("", A955EmpLogo)==0) )
         {
            gxblobfileaux.setSource( A955EmpLogo );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtEmpLogo_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtEmpLogo_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A955EmpLogo = gxblobfileaux.getURI() ;
               n955EmpLogo = false ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A955EmpLogo", A955EmpLogo);
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLogo_Internalname, "URL", httpContext.getResourceRelative(A955EmpLogo), true);
               edtEmpLogo_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLogo_Internalname, "Filetype", edtEmpLogo_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLogo_Internalname, "URL", httpContext.getResourceRelative(A955EmpLogo), true);
         }
         web.GxWebStd.gx_blob_field( httpContext, edtEmpLogo_Internalname, GXutil.rtrim( A955EmpLogo), httpContext.getResourceRelative(A955EmpLogo), ((GXutil.strcmp("", edtEmpLogo_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtEmpLogo_Filetype)==0) ? A955EmpLogo : edtEmpLogo_Filetype)) : edtEmpLogo_Contenttype), true, "", edtEmpLogo_Parameters, 0, edtEmpLogo_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtEmpLogo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+"", "", "", "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpFirma_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpFirma_Internalname, httpContext.getMessage( "Firma", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         ClassString = "Attribute" ;
         StyleString = "" ;
         edtEmpFirma_Filename = A959EmpFirmaNom ;
         edtEmpFirma_Filetype = "" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpFirma_Internalname, "Filetype", edtEmpFirma_Filetype, true);
         edtEmpFirma_Filetype = A960EmpFirmaExt ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpFirma_Internalname, "Filetype", edtEmpFirma_Filetype, true);
         if ( ! (GXutil.strcmp("", A958EmpFirma)==0) )
         {
            gxblobfileaux.setSource( A958EmpFirma );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtEmpFirma_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtEmpFirma_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A958EmpFirma = gxblobfileaux.getURI() ;
               n958EmpFirma = false ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A958EmpFirma", A958EmpFirma);
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpFirma_Internalname, "URL", httpContext.getResourceRelative(A958EmpFirma), true);
               edtEmpFirma_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpFirma_Internalname, "Filetype", edtEmpFirma_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpFirma_Internalname, "URL", httpContext.getResourceRelative(A958EmpFirma), true);
         }
         web.GxWebStd.gx_blob_field( httpContext, edtEmpFirma_Internalname, GXutil.rtrim( A958EmpFirma), httpContext.getResourceRelative(A958EmpFirma), ((GXutil.strcmp("", edtEmpFirma_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtEmpFirma_Filetype)==0) ? A958EmpFirma : edtEmpFirma_Filetype)) : edtEmpFirma_Contenttype), true, "", edtEmpFirma_Parameters, 0, edtEmpFirma_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtEmpFirma_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+"", "", "", "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpAntiguedad_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpAntiguedad_Internalname, httpContext.getMessage( "Antiguedad para empleados fuera de convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpAntiguedad_Internalname, GXutil.ltrim( localUtil.ntoc( A1140EmpAntiguedad, (byte)(14), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpAntiguedad_Enabled!=0) ? localUtil.format( A1140EmpAntiguedad, "ZZZZZZZZ9.9999") : localUtil.format( A1140EmpAntiguedad, "ZZZZZZZZ9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpAntiguedad_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpAntiguedad_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpPresentismo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpPresentismo_Internalname, httpContext.getMessage( "Presentismo para empleados fuera de convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpPresentismo_Internalname, GXutil.ltrim( localUtil.ntoc( A1141EmpPresentismo, (byte)(14), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpPresentismo_Enabled!=0) ? localUtil.format( A1141EmpPresentismo, "ZZZZZZZZ9.9999") : localUtil.format( A1141EmpPresentismo, "ZZZZZZZZ9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpPresentismo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpPresentismo_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynARTSec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynARTSec.getInternalname(), httpContext.getMessage( "ART", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynARTSec, dynARTSec.getInternalname(), GXutil.trim( GXutil.str( A1151ARTSec, 4, 0)), 1, dynARTSec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynARTSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_EmpresaGeneral.htm");
         dynARTSec.setValue( GXutil.trim( GXutil.str( A1151ARTSec, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynARTSec.getInternalname(), "Values", dynARTSec.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLiqFer.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkEmpLiqFer.getInternalname(), httpContext.getMessage( "Liquidar días feriados", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLiqFer.getInternalname(), GXutil.booltostr( A1524EmpLiqFer), "", httpContext.getMessage( "Liquidar días feriados", ""), 1, chkEmpLiqFer.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpGuarEdadMin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpGuarEdadMin_Internalname, httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpGuarEdadMin_Internalname, GXutil.ltrim( localUtil.ntoc( A1556EmpGuarEdadMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpGuarEdadMin_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1556EmpGuarEdadMin), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1556EmpGuarEdadMin), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpGuarEdadMin_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpGuarEdadMin_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpGuarEdadMax_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpGuarEdadMax_Internalname, httpContext.getMessage( "Edad máxima del hijo/hija hasta la que puede gozar el beneficio de guardería", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpGuarEdadMax_Internalname, GXutil.ltrim( localUtil.ntoc( A1557EmpGuarEdadMax, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpGuarEdadMax_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1557EmpGuarEdadMax), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1557EmpGuarEdadMax), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpGuarEdadMax_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpGuarEdadMax_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtActComDescripcion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtActComDescripcion_Internalname, httpContext.getMessage( "actividadcomercial", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtActComDescripcion_Internalname, A904ActComDescripcion, "", "", (short)(0), 1, edtActComDescripcion_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLiqFerJor.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkEmpLiqFerJor.getInternalname(), httpContext.getMessage( "Liquidar dìas feriados", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLiqFerJor.getInternalname(), GXutil.booltostr( A1750EmpLiqFerJor), "", httpContext.getMessage( "Liquidar dìas feriados", ""), 1, chkEmpLiqFerJor.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLiqGan.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkEmpLiqGan.getInternalname(), httpContext.getMessage( "Liquida ganancias", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLiqGan.getInternalname(), GXutil.booltostr( A1787EmpLiqGan), "", httpContext.getMessage( "Liquida ganancias", ""), 1, chkEmpLiqGan.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpTipoExp.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbEmpTipoExp.getInternalname(), httpContext.getMessage( "Tipo de exposición para clase mensual", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpTipoExp, cmbEmpTipoExp.getInternalname(), GXutil.trim( GXutil.str( A1792EmpTipoExp, 1, 0)), 1, cmbEmpTipoExp.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbEmpTipoExp.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_EmpresaGeneral.htm");
         cmbEmpTipoExp.setValue( GXutil.trim( GXutil.str( A1792EmpTipoExp, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpTipoExp.getInternalname(), "Values", cmbEmpTipoExp.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpPromDesde.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbEmpPromDesde.getInternalname(), httpContext.getMessage( "Calcular promedio de remuneraciones anteriores variables desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpPromDesde, cmbEmpPromDesde.getInternalname(), GXutil.rtrim( A1802EmpPromDesde), 1, cmbEmpPromDesde.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEmpPromDesde.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_EmpresaGeneral.htm");
         cmbEmpPromDesde.setValue( GXutil.rtrim( A1802EmpPromDesde) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpPromDesde.getInternalname(), "Values", cmbEmpPromDesde.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpFracVacAnt_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmpFracVacAnt_Internalname, httpContext.getMessage( "Proporción de días de vacaciones disponibles pendientes de goce del año anterior", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpFracVacAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1813EmpFracVacAnt, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpFracVacAnt_Enabled!=0) ? localUtil.format( A1813EmpFracVacAnt, "9.9999") : localUtil.format( A1813EmpFracVacAnt, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpFracVacAnt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpFracVacAnt_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_EmpresaGeneral.htm");
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
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e114y1_client"+"'", TempTags, "", 2, "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 111,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e124y1_client"+"'", TempTags, "", 2, "HLP_EmpresaGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpresaGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_EmpresaGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start4Y2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Empresa General", ""), (short)(0)) ;
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
            strup4Y0( ) ;
         }
      }
   }

   public void ws4Y2( )
   {
      start4Y2( ) ;
      evt4Y2( ) ;
   }

   public void evt4Y2( )
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
                              strup4Y0( ) ;
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
                              strup4Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e134Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e144Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e154Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Y0( ) ;
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
                              strup4Y0( ) ;
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

   public void we4Y2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm4Y2( ) ;
         }
      }
   }

   public void pa4Y2( )
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

   public void gxdlaartsec4Y1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaartsec_data4Y1( ) ;
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

   public void gxaartsec_html4Y1( )
   {
      short gxdynajaxvalue;
      gxdlaartsec_data4Y1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynARTSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynARTSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynARTSec.getItemCount() > 0 )
      {
         A1151ARTSec = (short)(GXutil.lval( dynARTSec.getValidValue(GXutil.trim( GXutil.str( A1151ARTSec, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
      }
   }

   protected void gxdlaartsec_data4Y1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H004Y2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H004Y2_A1151ARTSec[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H004Y2_A1152ARTNom[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlatipemplecod4Y1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlatipemplecod_data4Y1( ) ;
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

   public void gxatipemplecod_html4Y1( )
   {
      String gxdynajaxvalue;
      gxdlatipemplecod_data4Y1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynTipEmpleCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynTipEmpleCod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynTipEmpleCod.getItemCount() > 0 )
      {
         A45TipEmpleCod = dynTipEmpleCod.getValidValue(A45TipEmpleCod) ;
         n45TipEmpleCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A45TipEmpleCod", A45TipEmpleCod);
      }
   }

   protected void gxdlatipemplecod_data4Y1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H004Y3 */
      pr_default.execute(1);
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H004Y3_A45TipEmpleCod[0]));
         gxdynajaxctrldescr.add(H004Y3_A339TipEmpleDescri[0]);
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
         dynARTSec.setName( "ARTSEC" );
         dynARTSec.setWebtags( "" );
         dynARTSec.removeAllItems();
         /* Using cursor H004Y4 */
         pr_default.execute(2);
         while ( (pr_default.getStatus(2) != 101) )
         {
            dynARTSec.addItem(GXutil.trim( GXutil.str( H004Y4_A1151ARTSec[0], 4, 0)), H004Y4_A1152ARTNom[0], (short)(0));
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( dynARTSec.getItemCount() > 0 )
         {
            A1151ARTSec = (short)(GXutil.lval( dynARTSec.getValidValue(GXutil.trim( GXutil.str( A1151ARTSec, 4, 0))))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
         }
         dynTipEmpleCod.setName( "TIPEMPLECOD" );
         dynTipEmpleCod.setWebtags( "" );
         dynTipEmpleCod.removeAllItems();
         /* Using cursor H004Y5 */
         pr_default.execute(3);
         while ( (pr_default.getStatus(3) != 101) )
         {
            dynTipEmpleCod.addItem(H004Y5_A45TipEmpleCod[0], H004Y5_A339TipEmpleDescri[0], (short)(0));
            pr_default.readNext(3);
         }
         pr_default.close(3);
         if ( dynTipEmpleCod.getItemCount() > 0 )
         {
            A45TipEmpleCod = dynTipEmpleCod.getValidValue(A45TipEmpleCod) ;
            n45TipEmpleCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A45TipEmpleCod", A45TipEmpleCod);
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynTipEmpleCod.getItemCount() > 0 )
      {
         A45TipEmpleCod = dynTipEmpleCod.getValidValue(A45TipEmpleCod) ;
         n45TipEmpleCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A45TipEmpleCod", A45TipEmpleCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynTipEmpleCod.setValue( GXutil.rtrim( A45TipEmpleCod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynTipEmpleCod.getInternalname(), "Values", dynTipEmpleCod.ToJavascriptSource(), true);
      }
      if ( dynARTSec.getItemCount() > 0 )
      {
         A1151ARTSec = (short)(GXutil.lval( dynARTSec.getValidValue(GXutil.trim( GXutil.str( A1151ARTSec, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynARTSec.setValue( GXutil.trim( GXutil.str( A1151ARTSec, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynARTSec.getInternalname(), "Values", dynARTSec.ToJavascriptSource(), true);
      }
      A1524EmpLiqFer = GXutil.strtobool( GXutil.booltostr( A1524EmpLiqFer)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1524EmpLiqFer", A1524EmpLiqFer);
      A1750EmpLiqFerJor = GXutil.strtobool( GXutil.booltostr( A1750EmpLiqFerJor)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1750EmpLiqFerJor", A1750EmpLiqFerJor);
      A1787EmpLiqGan = GXutil.strtobool( GXutil.booltostr( A1787EmpLiqGan)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1787EmpLiqGan", A1787EmpLiqGan);
      if ( cmbEmpTipoExp.getItemCount() > 0 )
      {
         A1792EmpTipoExp = (byte)(GXutil.lval( cmbEmpTipoExp.getValidValue(GXutil.trim( GXutil.str( A1792EmpTipoExp, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1792EmpTipoExp", GXutil.str( A1792EmpTipoExp, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpTipoExp.setValue( GXutil.trim( GXutil.str( A1792EmpTipoExp, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpTipoExp.getInternalname(), "Values", cmbEmpTipoExp.ToJavascriptSource(), true);
      }
      if ( cmbEmpPromDesde.getItemCount() > 0 )
      {
         A1802EmpPromDesde = cmbEmpPromDesde.getValidValue(A1802EmpPromDesde) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1802EmpPromDesde", A1802EmpPromDesde);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpPromDesde.setValue( GXutil.rtrim( A1802EmpPromDesde) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEmpPromDesde.getInternalname(), "Values", cmbEmpPromDesde.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf4Y2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "EmpresaGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf4Y2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e154Y2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H004Y6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A43ActCodigo = H004Y6_A43ActCodigo[0] ;
            n43ActCodigo = H004Y6_n43ActCodigo[0] ;
            A903ActComCodigo = H004Y6_A903ActComCodigo[0] ;
            A44EmpZonCod = H004Y6_A44EmpZonCod[0] ;
            n44EmpZonCod = H004Y6_n44EmpZonCod[0] ;
            A959EmpFirmaNom = H004Y6_A959EmpFirmaNom[0] ;
            n959EmpFirmaNom = H004Y6_n959EmpFirmaNom[0] ;
            edtEmpFirma_Filename = A959EmpFirmaNom ;
            A956EmpLogoNom = H004Y6_A956EmpLogoNom[0] ;
            n956EmpLogoNom = H004Y6_n956EmpLogoNom[0] ;
            edtEmpLogo_Filename = A956EmpLogoNom ;
            A960EmpFirmaExt = H004Y6_A960EmpFirmaExt[0] ;
            n960EmpFirmaExt = H004Y6_n960EmpFirmaExt[0] ;
            edtEmpFirma_Filetype = A960EmpFirmaExt ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpFirma_Internalname, "Filetype", edtEmpFirma_Filetype, true);
            A957EmpLogoExt = H004Y6_A957EmpLogoExt[0] ;
            n957EmpLogoExt = H004Y6_n957EmpLogoExt[0] ;
            edtEmpLogo_Filetype = A957EmpLogoExt ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLogo_Internalname, "Filetype", edtEmpLogo_Filetype, true);
            A1813EmpFracVacAnt = H004Y6_A1813EmpFracVacAnt[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1813EmpFracVacAnt", GXutil.ltrimstr( A1813EmpFracVacAnt, 6, 4));
            A1802EmpPromDesde = H004Y6_A1802EmpPromDesde[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1802EmpPromDesde", A1802EmpPromDesde);
            A1792EmpTipoExp = H004Y6_A1792EmpTipoExp[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1792EmpTipoExp", GXutil.str( A1792EmpTipoExp, 1, 0));
            A1787EmpLiqGan = H004Y6_A1787EmpLiqGan[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1787EmpLiqGan", A1787EmpLiqGan);
            A1750EmpLiqFerJor = H004Y6_A1750EmpLiqFerJor[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1750EmpLiqFerJor", A1750EmpLiqFerJor);
            A904ActComDescripcion = H004Y6_A904ActComDescripcion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A904ActComDescripcion", A904ActComDescripcion);
            A1557EmpGuarEdadMax = H004Y6_A1557EmpGuarEdadMax[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1557EmpGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1557EmpGuarEdadMax), 2, 0));
            A1556EmpGuarEdadMin = H004Y6_A1556EmpGuarEdadMin[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1556EmpGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1556EmpGuarEdadMin), 2, 0));
            A1524EmpLiqFer = H004Y6_A1524EmpLiqFer[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1524EmpLiqFer", A1524EmpLiqFer);
            A1151ARTSec = H004Y6_A1151ARTSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
            A1141EmpPresentismo = H004Y6_A1141EmpPresentismo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1141EmpPresentismo", GXutil.ltrimstr( A1141EmpPresentismo, 14, 4));
            A1140EmpAntiguedad = H004Y6_A1140EmpAntiguedad[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1140EmpAntiguedad", GXutil.ltrimstr( A1140EmpAntiguedad, 14, 4));
            A958EmpFirma = H004Y6_A958EmpFirma[0] ;
            n958EmpFirma = H004Y6_n958EmpFirma[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A958EmpFirma", A958EmpFirma);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpFirma_Internalname, "URL", httpContext.getResourceRelative(A958EmpFirma), true);
            A955EmpLogo = H004Y6_A955EmpLogo[0] ;
            n955EmpLogo = H004Y6_n955EmpLogo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A955EmpLogo", A955EmpLogo);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpLogo_Internalname, "URL", httpContext.getResourceRelative(A955EmpLogo), true);
            A518EmpZonDescrip = H004Y6_A518EmpZonDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A518EmpZonDescrip", A518EmpZonDescrip);
            A45TipEmpleCod = H004Y6_A45TipEmpleCod[0] ;
            n45TipEmpleCod = H004Y6_n45TipEmpleCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A45TipEmpleCod", A45TipEmpleCod);
            A108ActDescrip = H004Y6_A108ActDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A108ActDescrip", A108ActDescrip);
            A177EmpCUIT = H004Y6_A177EmpCUIT[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A177EmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A177EmpCUIT), 11, 0));
            A2EmpNom = H004Y6_A2EmpNom[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2EmpNom", A2EmpNom);
            A108ActDescrip = H004Y6_A108ActDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A108ActDescrip", A108ActDescrip);
            A904ActComDescripcion = H004Y6_A904ActComDescripcion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A904ActComDescripcion", A904ActComDescripcion);
            A518EmpZonDescrip = H004Y6_A518EmpZonDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A518EmpZonDescrip", A518EmpZonDescrip);
            /* Execute user event: Load */
            e144Y2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
         wb4Y0( ) ;
      }
   }

   public void send_integrity_lvl_hashes4Y2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "EmpresaGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup4Y0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e134Y2 ();
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
         /* Read variables values. */
         A2EmpNom = GXutil.upper( httpContext.cgiGet( edtEmpNom_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2EmpNom", A2EmpNom);
         A177EmpCUIT = localUtil.ctol( httpContext.cgiGet( edtEmpCUIT_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A177EmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A177EmpCUIT), 11, 0));
         A108ActDescrip = httpContext.cgiGet( edtActDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A108ActDescrip", A108ActDescrip);
         dynTipEmpleCod.setValue( httpContext.cgiGet( dynTipEmpleCod.getInternalname()) );
         A45TipEmpleCod = httpContext.cgiGet( dynTipEmpleCod.getInternalname()) ;
         n45TipEmpleCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A45TipEmpleCod", A45TipEmpleCod);
         A518EmpZonDescrip = httpContext.cgiGet( edtEmpZonDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A518EmpZonDescrip", A518EmpZonDescrip);
         A955EmpLogo = httpContext.cgiGet( edtEmpLogo_Internalname) ;
         n955EmpLogo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A955EmpLogo", A955EmpLogo);
         A958EmpFirma = httpContext.cgiGet( edtEmpFirma_Internalname) ;
         n958EmpFirma = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A958EmpFirma", A958EmpFirma);
         A1140EmpAntiguedad = localUtil.ctond( httpContext.cgiGet( edtEmpAntiguedad_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1140EmpAntiguedad", GXutil.ltrimstr( A1140EmpAntiguedad, 14, 4));
         A1141EmpPresentismo = localUtil.ctond( httpContext.cgiGet( edtEmpPresentismo_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1141EmpPresentismo", GXutil.ltrimstr( A1141EmpPresentismo, 14, 4));
         dynARTSec.setValue( httpContext.cgiGet( dynARTSec.getInternalname()) );
         A1151ARTSec = (short)(GXutil.lval( httpContext.cgiGet( dynARTSec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
         A1524EmpLiqFer = GXutil.strtobool( httpContext.cgiGet( chkEmpLiqFer.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1524EmpLiqFer", A1524EmpLiqFer);
         A1556EmpGuarEdadMin = (byte)(localUtil.ctol( httpContext.cgiGet( edtEmpGuarEdadMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1556EmpGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1556EmpGuarEdadMin), 2, 0));
         A1557EmpGuarEdadMax = (byte)(localUtil.ctol( httpContext.cgiGet( edtEmpGuarEdadMax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1557EmpGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1557EmpGuarEdadMax), 2, 0));
         A904ActComDescripcion = httpContext.cgiGet( edtActComDescripcion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A904ActComDescripcion", A904ActComDescripcion);
         A1750EmpLiqFerJor = GXutil.strtobool( httpContext.cgiGet( chkEmpLiqFerJor.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1750EmpLiqFerJor", A1750EmpLiqFerJor);
         A1787EmpLiqGan = GXutil.strtobool( httpContext.cgiGet( chkEmpLiqGan.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1787EmpLiqGan", A1787EmpLiqGan);
         cmbEmpTipoExp.setValue( httpContext.cgiGet( cmbEmpTipoExp.getInternalname()) );
         A1792EmpTipoExp = (byte)(GXutil.lval( httpContext.cgiGet( cmbEmpTipoExp.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1792EmpTipoExp", GXutil.str( A1792EmpTipoExp, 1, 0));
         cmbEmpPromDesde.setValue( httpContext.cgiGet( cmbEmpPromDesde.getInternalname()) );
         A1802EmpPromDesde = httpContext.cgiGet( cmbEmpPromDesde.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1802EmpPromDesde", A1802EmpPromDesde);
         A1813EmpFracVacAnt = localUtil.ctond( httpContext.cgiGet( edtEmpFracVacAnt_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1813EmpFracVacAnt", GXutil.ltrimstr( A1813EmpFracVacAnt, 6, 4));
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
      e134Y2 ();
      if (returnInSub) return;
   }

   public void e134Y2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV11CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      empresageneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV11CliCod = GXt_int1 ;
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

   protected void e144Y2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      GXt_boolean4 = AV14TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_Update", GXv_boolean5) ;
      empresageneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV14TempBoolean = GXt_boolean4 ;
      if ( ! ( AV14TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV14TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_Delete", GXv_boolean5) ;
      empresageneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV14TempBoolean = GXt_boolean4 ;
      if ( ! ( AV14TempBoolean ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV7TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV17Pgmname );
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV10HTTPRequest.getScriptName()+"?"+AV10HTTPRequest.getQuerystring() );
      AV7TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Empresa" );
      AV9Session.setValue("TrnContext", AV7TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e154Y2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV11CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      empresageneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV11CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
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
      pa4Y2( ) ;
      ws4Y2( ) ;
      we4Y2( ) ;
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
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa4Y2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "empresageneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa4Y2( ) ;
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
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1EmpCod != wcpOA1EmpCod ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1EmpCod = A1EmpCod ;
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
      pa4Y2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws4Y2( ) ;
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
      ws4Y2( ) ;
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
      we4Y2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025139343071", true, true);
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
      httpContext.AddJavascriptSource("empresageneral.js", "?2025139343071", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtEmpNom_Internalname = sPrefix+"EMPNOM" ;
      edtEmpCUIT_Internalname = sPrefix+"EMPCUIT" ;
      edtActDescrip_Internalname = sPrefix+"ACTDESCRIP" ;
      dynTipEmpleCod.setInternalname( sPrefix+"TIPEMPLECOD" );
      edtEmpZonDescrip_Internalname = sPrefix+"EMPZONDESCRIP" ;
      edtEmpLogo_Internalname = sPrefix+"EMPLOGO" ;
      edtEmpFirma_Internalname = sPrefix+"EMPFIRMA" ;
      edtEmpAntiguedad_Internalname = sPrefix+"EMPANTIGUEDAD" ;
      edtEmpPresentismo_Internalname = sPrefix+"EMPPRESENTISMO" ;
      dynARTSec.setInternalname( sPrefix+"ARTSEC" );
      chkEmpLiqFer.setInternalname( sPrefix+"EMPLIQFER" );
      edtEmpGuarEdadMin_Internalname = sPrefix+"EMPGUAREDADMIN" ;
      edtEmpGuarEdadMax_Internalname = sPrefix+"EMPGUAREDADMAX" ;
      edtActComDescripcion_Internalname = sPrefix+"ACTCOMDESCRIPCION" ;
      chkEmpLiqFerJor.setInternalname( sPrefix+"EMPLIQFERJOR" );
      chkEmpLiqGan.setInternalname( sPrefix+"EMPLIQGAN" );
      cmbEmpTipoExp.setInternalname( sPrefix+"EMPTIPOEXP" );
      cmbEmpPromDesde.setInternalname( sPrefix+"EMPPROMDESDE" );
      edtEmpFracVacAnt_Internalname = sPrefix+"EMPFRACVACANT" ;
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
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
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      edtEmpFracVacAnt_Jsonclick = "" ;
      edtEmpFracVacAnt_Enabled = 0 ;
      cmbEmpPromDesde.setJsonclick( "" );
      cmbEmpPromDesde.setEnabled( 0 );
      cmbEmpTipoExp.setJsonclick( "" );
      cmbEmpTipoExp.setEnabled( 0 );
      chkEmpLiqGan.setEnabled( 0 );
      chkEmpLiqFerJor.setEnabled( 0 );
      edtActComDescripcion_Enabled = 0 ;
      edtEmpGuarEdadMax_Jsonclick = "" ;
      edtEmpGuarEdadMax_Enabled = 0 ;
      edtEmpGuarEdadMin_Jsonclick = "" ;
      edtEmpGuarEdadMin_Enabled = 0 ;
      chkEmpLiqFer.setEnabled( 0 );
      dynARTSec.setJsonclick( "" );
      dynARTSec.setEnabled( 0 );
      edtEmpPresentismo_Jsonclick = "" ;
      edtEmpPresentismo_Enabled = 0 ;
      edtEmpAntiguedad_Jsonclick = "" ;
      edtEmpAntiguedad_Enabled = 0 ;
      edtEmpFirma_Jsonclick = "" ;
      edtEmpFirma_Parameters = "" ;
      edtEmpFirma_Contenttype = "" ;
      edtEmpFirma_Filetype = "" ;
      edtEmpFirma_Enabled = 0 ;
      edtEmpLogo_Jsonclick = "" ;
      edtEmpLogo_Parameters = "" ;
      edtEmpLogo_Contenttype = "" ;
      edtEmpLogo_Filetype = "" ;
      edtEmpLogo_Enabled = 0 ;
      edtEmpZonDescrip_Enabled = 0 ;
      dynTipEmpleCod.setJsonclick( "" );
      dynTipEmpleCod.setEnabled( 0 );
      edtActDescrip_Jsonclick = "" ;
      edtActDescrip_Enabled = 0 ;
      edtEmpCUIT_Jsonclick = "" ;
      edtEmpCUIT_Enabled = 0 ;
      edtEmpNom_Jsonclick = "" ;
      edtEmpNom_Enabled = 0 ;
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
      dynTipEmpleCod.setName( "TIPEMPLECOD" );
      dynTipEmpleCod.setWebtags( "" );
      dynTipEmpleCod.removeAllItems();
      /* Using cursor H004Y7 */
      pr_default.execute(5);
      while ( (pr_default.getStatus(5) != 101) )
      {
         dynTipEmpleCod.addItem(H004Y7_A45TipEmpleCod[0], H004Y7_A339TipEmpleDescri[0], (short)(0));
         pr_default.readNext(5);
      }
      pr_default.close(5);
      if ( dynTipEmpleCod.getItemCount() > 0 )
      {
      }
      dynARTSec.setName( "ARTSEC" );
      dynARTSec.setWebtags( "" );
      dynARTSec.removeAllItems();
      /* Using cursor H004Y8 */
      pr_default.execute(6);
      while ( (pr_default.getStatus(6) != 101) )
      {
         dynARTSec.addItem(GXutil.trim( GXutil.str( H004Y8_A1151ARTSec[0], 4, 0)), H004Y8_A1152ARTNom[0], (short)(0));
         pr_default.readNext(6);
      }
      pr_default.close(6);
      if ( dynARTSec.getItemCount() > 0 )
      {
      }
      chkEmpLiqFer.setName( "EMPLIQFER" );
      chkEmpLiqFer.setWebtags( "" );
      chkEmpLiqFer.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLiqFer.getInternalname(), "TitleCaption", chkEmpLiqFer.getCaption(), true);
      chkEmpLiqFer.setCheckedValue( "false" );
      chkEmpLiqFerJor.setName( "EMPLIQFERJOR" );
      chkEmpLiqFerJor.setWebtags( "" );
      chkEmpLiqFerJor.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLiqFerJor.getInternalname(), "TitleCaption", chkEmpLiqFerJor.getCaption(), true);
      chkEmpLiqFerJor.setCheckedValue( "false" );
      chkEmpLiqGan.setName( "EMPLIQGAN" );
      chkEmpLiqGan.setWebtags( "" );
      chkEmpLiqGan.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkEmpLiqGan.getInternalname(), "TitleCaption", chkEmpLiqGan.getCaption(), true);
      chkEmpLiqGan.setCheckedValue( "false" );
      cmbEmpTipoExp.setName( "EMPTIPOEXP" );
      cmbEmpTipoExp.setWebtags( "" );
      cmbEmpTipoExp.addItem("1", httpContext.getMessage( "Prorratear sueldo a días trabajados, liquidar vacaciones/licencia/feriado sin plus incluido, y exponer el plus en concepto explícito", ""), (short)(0));
      cmbEmpTipoExp.addItem("2", httpContext.getMessage( "No prorratear sueldo a días trabajados, liquidar vacaciones/licencia/feriado con plus incluido  y exponer el plus de manera implícita restando por días no trabajados", ""), (short)(0));
      if ( cmbEmpTipoExp.getItemCount() > 0 )
      {
      }
      cmbEmpPromDesde.setName( "EMPPROMDESDE" );
      cmbEmpPromDesde.setWebtags( "" );
      cmbEmpPromDesde.addItem("actual", httpContext.getMessage( "Mes Actual", ""), (short)(0));
      cmbEmpPromDesde.addItem("anterior", httpContext.getMessage( "Mes anterior", ""), (short)(0));
      if ( cmbEmpPromDesde.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'dynARTSec'},{av:'A1151ARTSec',fld:'ARTSEC',pic:'ZZZ9'},{av:'dynTipEmpleCod'},{av:'A45TipEmpleCod',fld:'TIPEMPLECOD',pic:''},{av:'A1524EmpLiqFer',fld:'EMPLIQFER',pic:''},{av:'A1750EmpLiqFerJor',fld:'EMPLIQFERJOR',pic:''},{av:'A1787EmpLiqGan',fld:'EMPLIQGAN',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e114Y1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e124Y1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
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
      A2EmpNom = "" ;
      A108ActDescrip = "" ;
      A45TipEmpleCod = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A518EmpZonDescrip = "" ;
      edtEmpLogo_Filename = "" ;
      A956EmpLogoNom = "" ;
      A957EmpLogoExt = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A955EmpLogo = "" ;
      edtEmpFirma_Filename = "" ;
      A959EmpFirmaNom = "" ;
      A960EmpFirmaExt = "" ;
      A958EmpFirma = "" ;
      A1140EmpAntiguedad = DecimalUtil.ZERO ;
      A1141EmpPresentismo = DecimalUtil.ZERO ;
      A904ActComDescripcion = "" ;
      A1802EmpPromDesde = "" ;
      A1813EmpFracVacAnt = DecimalUtil.ZERO ;
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
      H004Y2_A1151ARTSec = new short[1] ;
      H004Y2_A1152ARTNom = new String[] {""} ;
      H004Y3_A45TipEmpleCod = new String[] {""} ;
      H004Y3_n45TipEmpleCod = new boolean[] {false} ;
      H004Y3_A339TipEmpleDescri = new String[] {""} ;
      H004Y4_A1151ARTSec = new short[1] ;
      H004Y4_A1152ARTNom = new String[] {""} ;
      H004Y5_A45TipEmpleCod = new String[] {""} ;
      H004Y5_n45TipEmpleCod = new boolean[] {false} ;
      H004Y5_A339TipEmpleDescri = new String[] {""} ;
      AV17Pgmname = "" ;
      H004Y6_A43ActCodigo = new String[] {""} ;
      H004Y6_n43ActCodigo = new boolean[] {false} ;
      H004Y6_A903ActComCodigo = new String[] {""} ;
      H004Y6_A44EmpZonCod = new String[] {""} ;
      H004Y6_n44EmpZonCod = new boolean[] {false} ;
      H004Y6_A3CliCod = new int[1] ;
      H004Y6_A1EmpCod = new short[1] ;
      H004Y6_A959EmpFirmaNom = new String[] {""} ;
      H004Y6_n959EmpFirmaNom = new boolean[] {false} ;
      H004Y6_A956EmpLogoNom = new String[] {""} ;
      H004Y6_n956EmpLogoNom = new boolean[] {false} ;
      H004Y6_A960EmpFirmaExt = new String[] {""} ;
      H004Y6_n960EmpFirmaExt = new boolean[] {false} ;
      H004Y6_A957EmpLogoExt = new String[] {""} ;
      H004Y6_n957EmpLogoExt = new boolean[] {false} ;
      H004Y6_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004Y6_A1802EmpPromDesde = new String[] {""} ;
      H004Y6_A1792EmpTipoExp = new byte[1] ;
      H004Y6_A1787EmpLiqGan = new boolean[] {false} ;
      H004Y6_A1750EmpLiqFerJor = new boolean[] {false} ;
      H004Y6_A904ActComDescripcion = new String[] {""} ;
      H004Y6_A1557EmpGuarEdadMax = new byte[1] ;
      H004Y6_A1556EmpGuarEdadMin = new byte[1] ;
      H004Y6_A1524EmpLiqFer = new boolean[] {false} ;
      H004Y6_A1151ARTSec = new short[1] ;
      H004Y6_A1141EmpPresentismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004Y6_A1140EmpAntiguedad = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004Y6_A958EmpFirma = new String[] {""} ;
      H004Y6_n958EmpFirma = new boolean[] {false} ;
      H004Y6_A955EmpLogo = new String[] {""} ;
      H004Y6_n955EmpLogo = new boolean[] {false} ;
      H004Y6_A518EmpZonDescrip = new String[] {""} ;
      H004Y6_A45TipEmpleCod = new String[] {""} ;
      H004Y6_n45TipEmpleCod = new boolean[] {false} ;
      H004Y6_A108ActDescrip = new String[] {""} ;
      H004Y6_A177EmpCUIT = new long[1] ;
      H004Y6_A2EmpNom = new String[] {""} ;
      A43ActCodigo = "" ;
      A903ActComCodigo = "" ;
      A44EmpZonCod = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV7TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10HTTPRequest = httpContext.getHttpRequest();
      AV9Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1EmpCod = "" ;
      H004Y7_A45TipEmpleCod = new String[] {""} ;
      H004Y7_n45TipEmpleCod = new boolean[] {false} ;
      H004Y7_A339TipEmpleDescri = new String[] {""} ;
      H004Y8_A1151ARTSec = new short[1] ;
      H004Y8_A1152ARTNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresageneral__default(),
         new Object[] {
             new Object[] {
            H004Y2_A1151ARTSec, H004Y2_A1152ARTNom
            }
            , new Object[] {
            H004Y3_A45TipEmpleCod, H004Y3_A339TipEmpleDescri
            }
            , new Object[] {
            H004Y4_A1151ARTSec, H004Y4_A1152ARTNom
            }
            , new Object[] {
            H004Y5_A45TipEmpleCod, H004Y5_A339TipEmpleDescri
            }
            , new Object[] {
            H004Y6_A43ActCodigo, H004Y6_n43ActCodigo, H004Y6_A903ActComCodigo, H004Y6_A44EmpZonCod, H004Y6_n44EmpZonCod, H004Y6_A3CliCod, H004Y6_A1EmpCod, H004Y6_A959EmpFirmaNom, H004Y6_n959EmpFirmaNom, H004Y6_A956EmpLogoNom,
            H004Y6_n956EmpLogoNom, H004Y6_A960EmpFirmaExt, H004Y6_n960EmpFirmaExt, H004Y6_A957EmpLogoExt, H004Y6_n957EmpLogoExt, H004Y6_A1813EmpFracVacAnt, H004Y6_A1802EmpPromDesde, H004Y6_A1792EmpTipoExp, H004Y6_A1787EmpLiqGan, H004Y6_A1750EmpLiqFerJor,
            H004Y6_A904ActComDescripcion, H004Y6_A1557EmpGuarEdadMax, H004Y6_A1556EmpGuarEdadMin, H004Y6_A1524EmpLiqFer, H004Y6_A1151ARTSec, H004Y6_A1141EmpPresentismo, H004Y6_A1140EmpAntiguedad, H004Y6_A958EmpFirma, H004Y6_n958EmpFirma, H004Y6_A955EmpLogo,
            H004Y6_n955EmpLogo, H004Y6_A518EmpZonDescrip, H004Y6_A45TipEmpleCod, H004Y6_n45TipEmpleCod, H004Y6_A108ActDescrip, H004Y6_A177EmpCUIT, H004Y6_A2EmpNom
            }
            , new Object[] {
            H004Y7_A45TipEmpleCod, H004Y7_A339TipEmpleDescri
            }
            , new Object[] {
            H004Y8_A1151ARTSec, H004Y8_A1152ARTNom
            }
         }
      );
      AV17Pgmname = "EmpresaGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "EmpresaGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1556EmpGuarEdadMin ;
   private byte A1557EmpGuarEdadMax ;
   private byte A1792EmpTipoExp ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1151ARTSec ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int edtEmpNom_Enabled ;
   private int edtEmpCUIT_Enabled ;
   private int edtActDescrip_Enabled ;
   private int edtEmpZonDescrip_Enabled ;
   private int edtEmpLogo_Enabled ;
   private int edtEmpFirma_Enabled ;
   private int edtEmpAntiguedad_Enabled ;
   private int edtEmpPresentismo_Enabled ;
   private int edtEmpGuarEdadMin_Enabled ;
   private int edtEmpGuarEdadMax_Enabled ;
   private int edtActComDescripcion_Enabled ;
   private int edtEmpFracVacAnt_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtEmpCod_Visible ;
   private int gxdynajaxindex ;
   private int AV11CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private long A177EmpCUIT ;
   private java.math.BigDecimal A1140EmpAntiguedad ;
   private java.math.BigDecimal A1141EmpPresentismo ;
   private java.math.BigDecimal A1813EmpFracVacAnt ;
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
   private String edtEmpNom_Internalname ;
   private String edtEmpNom_Jsonclick ;
   private String edtEmpCUIT_Internalname ;
   private String edtEmpCUIT_Jsonclick ;
   private String edtActDescrip_Internalname ;
   private String edtActDescrip_Jsonclick ;
   private String A45TipEmpleCod ;
   private String edtEmpZonDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtEmpLogo_Internalname ;
   private String edtEmpLogo_Filename ;
   private String edtEmpLogo_Filetype ;
   private String A957EmpLogoExt ;
   private String edtEmpLogo_Contenttype ;
   private String edtEmpLogo_Parameters ;
   private String edtEmpLogo_Jsonclick ;
   private String edtEmpFirma_Internalname ;
   private String edtEmpFirma_Filename ;
   private String edtEmpFirma_Filetype ;
   private String A960EmpFirmaExt ;
   private String edtEmpFirma_Contenttype ;
   private String edtEmpFirma_Parameters ;
   private String edtEmpFirma_Jsonclick ;
   private String edtEmpAntiguedad_Internalname ;
   private String edtEmpAntiguedad_Jsonclick ;
   private String edtEmpPresentismo_Internalname ;
   private String edtEmpPresentismo_Jsonclick ;
   private String edtEmpGuarEdadMin_Internalname ;
   private String edtEmpGuarEdadMin_Jsonclick ;
   private String edtEmpGuarEdadMax_Internalname ;
   private String edtEmpGuarEdadMax_Jsonclick ;
   private String edtActComDescripcion_Internalname ;
   private String A1802EmpPromDesde ;
   private String edtEmpFracVacAnt_Internalname ;
   private String edtEmpFracVacAnt_Jsonclick ;
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
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV17Pgmname ;
   private String A43ActCodigo ;
   private String A903ActComCodigo ;
   private String A44EmpZonCod ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1EmpCod ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean n955EmpLogo ;
   private boolean n958EmpFirma ;
   private boolean A1524EmpLiqFer ;
   private boolean A1750EmpLiqFerJor ;
   private boolean A1787EmpLiqGan ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n45TipEmpleCod ;
   private boolean n43ActCodigo ;
   private boolean n44EmpZonCod ;
   private boolean n959EmpFirmaNom ;
   private boolean n956EmpLogoNom ;
   private boolean n960EmpFirmaExt ;
   private boolean n957EmpLogoExt ;
   private boolean returnInSub ;
   private boolean AV14TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A955EmpLogo ;
   private String A958EmpFirma ;
   private String A2EmpNom ;
   private String A108ActDescrip ;
   private String A518EmpZonDescrip ;
   private String A956EmpLogoNom ;
   private String A959EmpFirmaNom ;
   private String A904ActComDescripcion ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV10HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private HTMLChoice dynTipEmpleCod ;
   private HTMLChoice dynARTSec ;
   private ICheckbox chkEmpLiqFer ;
   private ICheckbox chkEmpLiqFerJor ;
   private ICheckbox chkEmpLiqGan ;
   private HTMLChoice cmbEmpTipoExp ;
   private HTMLChoice cmbEmpPromDesde ;
   private IDataStoreProvider pr_default ;
   private short[] H004Y2_A1151ARTSec ;
   private String[] H004Y2_A1152ARTNom ;
   private String[] H004Y3_A45TipEmpleCod ;
   private boolean[] H004Y3_n45TipEmpleCod ;
   private String[] H004Y3_A339TipEmpleDescri ;
   private short[] H004Y4_A1151ARTSec ;
   private String[] H004Y4_A1152ARTNom ;
   private String[] H004Y5_A45TipEmpleCod ;
   private boolean[] H004Y5_n45TipEmpleCod ;
   private String[] H004Y5_A339TipEmpleDescri ;
   private String[] H004Y6_A43ActCodigo ;
   private boolean[] H004Y6_n43ActCodigo ;
   private String[] H004Y6_A903ActComCodigo ;
   private String[] H004Y6_A44EmpZonCod ;
   private boolean[] H004Y6_n44EmpZonCod ;
   private int[] H004Y6_A3CliCod ;
   private short[] H004Y6_A1EmpCod ;
   private String[] H004Y6_A959EmpFirmaNom ;
   private boolean[] H004Y6_n959EmpFirmaNom ;
   private String[] H004Y6_A956EmpLogoNom ;
   private boolean[] H004Y6_n956EmpLogoNom ;
   private String[] H004Y6_A960EmpFirmaExt ;
   private boolean[] H004Y6_n960EmpFirmaExt ;
   private String[] H004Y6_A957EmpLogoExt ;
   private boolean[] H004Y6_n957EmpLogoExt ;
   private java.math.BigDecimal[] H004Y6_A1813EmpFracVacAnt ;
   private String[] H004Y6_A1802EmpPromDesde ;
   private byte[] H004Y6_A1792EmpTipoExp ;
   private boolean[] H004Y6_A1787EmpLiqGan ;
   private boolean[] H004Y6_A1750EmpLiqFerJor ;
   private String[] H004Y6_A904ActComDescripcion ;
   private byte[] H004Y6_A1557EmpGuarEdadMax ;
   private byte[] H004Y6_A1556EmpGuarEdadMin ;
   private boolean[] H004Y6_A1524EmpLiqFer ;
   private short[] H004Y6_A1151ARTSec ;
   private java.math.BigDecimal[] H004Y6_A1141EmpPresentismo ;
   private java.math.BigDecimal[] H004Y6_A1140EmpAntiguedad ;
   private String[] H004Y6_A958EmpFirma ;
   private boolean[] H004Y6_n958EmpFirma ;
   private String[] H004Y6_A955EmpLogo ;
   private boolean[] H004Y6_n955EmpLogo ;
   private String[] H004Y6_A518EmpZonDescrip ;
   private String[] H004Y6_A45TipEmpleCod ;
   private boolean[] H004Y6_n45TipEmpleCod ;
   private String[] H004Y6_A108ActDescrip ;
   private long[] H004Y6_A177EmpCUIT ;
   private String[] H004Y6_A2EmpNom ;
   private String[] H004Y7_A45TipEmpleCod ;
   private boolean[] H004Y7_n45TipEmpleCod ;
   private String[] H004Y7_A339TipEmpleDescri ;
   private short[] H004Y8_A1151ARTSec ;
   private String[] H004Y8_A1152ARTNom ;
   private com.genexus.webpanels.WebSession AV9Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV7TrnContext ;
}

final  class empresageneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004Y2", "SELECT ARTSec, ARTNom FROM ART ORDER BY ARTNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004Y3", "SELECT TipEmpleCod, TipEmpleDescri FROM TipoEmpleador ORDER BY TipEmpleDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004Y4", "SELECT ARTSec, ARTNom FROM ART ORDER BY ARTNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004Y5", "SELECT TipEmpleCod, TipEmpleDescri FROM TipoEmpleador ORDER BY TipEmpleDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004Y6", "SELECT T1.ActCodigo, T1.ActComCodigo, T1.EmpZonCod AS EmpZonCod, T1.CliCod, T1.EmpCod, T1.EmpFirmaNom, T1.EmpLogoNom, T1.EmpFirmaExt, T1.EmpLogoExt, T1.EmpFracVacAnt, T1.EmpPromDesde, T1.EmpTipoExp, T1.EmpLiqGan, T1.EmpLiqFerJor, T3.ActComDescripcion, T1.EmpGuarEdadMax, T1.EmpGuarEdadMin, T1.EmpLiqFer, T1.ARTSec, T1.EmpPresentismo, T1.EmpAntiguedad, T1.EmpFirma, T1.EmpLogo, T4.ZonDescrip AS EmpZonDescrip, T1.TipEmpleCod, T2.ActDescrip, T1.EmpCUIT, T1.EmpNom FROM (((Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) INNER JOIN actividadcomercial T3 ON T3.ActComCodigo = T1.ActComCodigo) LEFT JOIN Zona T4 ON T4.ZonCod = T1.EmpZonCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004Y7", "SELECT TipEmpleCod, TipEmpleDescri FROM TipoEmpleador ORDER BY TipEmpleDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004Y8", "SELECT ARTSec, ARTNom FROM ART ORDER BY ARTNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((short[]) buf[6])[0] = rslt.getShort(5);
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(10,4);
               ((String[]) buf[16])[0] = rslt.getString(11, 20);
               ((byte[]) buf[17])[0] = rslt.getByte(12);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(14);
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((byte[]) buf[21])[0] = rslt.getByte(16);
               ((byte[]) buf[22])[0] = rslt.getByte(17);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(18);
               ((short[]) buf[24])[0] = rslt.getShort(19);
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(20,4);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(21,4);
               ((String[]) buf[27])[0] = rslt.getBLOBFile(22, rslt.getString(8, 20), rslt.getVarchar(6));
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getBLOBFile(23, rslt.getString(9, 20), rslt.getVarchar(7));
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 4);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((long[]) buf[35])[0] = rslt.getLong(27);
               ((String[]) buf[36])[0] = rslt.getVarchar(28);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

