package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class operandogeneral_impl extends GXWebComponent
{
   public operandogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public operandogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( operandogeneral_impl.class ));
   }

   public operandogeneral_impl( int remoteHandle ,
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
      cmbidOperando = new HTMLChoice();
      chkOpeEsCant = UIFactory.getCheckbox(this);
      chkOpeAliEs = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
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
               A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A74idOperando = httpContext.GetPar( "idOperando") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A74idOperando", A74idOperando);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A46PaiCod),A74idOperando});
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
               gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
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
         pa9P2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Operando General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.operandogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(A74idOperando))}, new String[] {"PaiCod","idOperando"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA46PaiCod", GXutil.ltrim( localUtil.ntoc( wcpOA46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA74idOperando", GXutil.rtrim( wcpOA74idOperando));
   }

   public void renderHtmlCloseForm9P2( )
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
      return "OperandoGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Operando General", "") ;
   }

   public void wb9P0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.operandogeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbidOperando.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbidOperando.getInternalname(), httpContext.getMessage( "Cálculo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbidOperando, cmbidOperando.getInternalname(), GXutil.rtrim( A74idOperando), 1, cmbidOperando.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbidOperando.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_OperandoGeneral.htm");
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbidOperando.getInternalname(), "Values", cmbidOperando.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpeCodFormula_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtOpeCodFormula_Internalname, httpContext.getMessage( "Fórmula", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCodFormula_Internalname, GXutil.rtrim( A473OpeCodFormula), GXutil.rtrim( localUtil.format( A473OpeCodFormula, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCodFormula_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOpeCodFormula_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_OperandoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpeDescripcion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtOpeDescripcion_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtOpeDescripcion_Internalname, A474OpeDescripcion, "", "", (short)(0), 1, edtOpeDescripcion_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_OperandoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOpeEsCant.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkOpeEsCant.getInternalname(), httpContext.getMessage( "Determina cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOpeEsCant.getInternalname(), GXutil.booltostr( A932OpeEsCant), "", httpContext.getMessage( "Determina cantidad", ""), 1, chkOpeEsCant.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOpeAliEs.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkOpeAliEs.getInternalname(), httpContext.getMessage( "Es alícuota", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOpeAliEs.getInternalname(), GXutil.booltostr( A1032OpeAliEs), "", httpContext.getMessage( "Es alícuota", ""), 1, chkOpeAliEs.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
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
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e119p1_client"+"'", TempTags, "", 2, "HLP_OperandoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 41,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnDefault" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e129p1_client"+"'", TempTags, "", 2, "HLP_OperandoGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_OperandoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start9P2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Operando General", ""), (short)(0)) ;
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
            strup9P0( ) ;
         }
      }
   }

   public void ws9P2( )
   {
      start9P2( ) ;
      evt9P2( ) ;
   }

   public void evt9P2( )
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
                              strup9P0( ) ;
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
                              strup9P0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e139P2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup9P0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e149P2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup9P0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e159P2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup9P0( ) ;
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
                              strup9P0( ) ;
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

   public void we9P2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm9P2( ) ;
         }
      }
   }

   public void pa9P2( )
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
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A74idOperando", A74idOperando);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbidOperando.getInternalname(), "Values", cmbidOperando.ToJavascriptSource(), true);
      }
      A932OpeEsCant = GXutil.strtobool( GXutil.booltostr( A932OpeEsCant)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A932OpeEsCant", A932OpeEsCant);
      A1032OpeAliEs = GXutil.strtobool( GXutil.booltostr( A1032OpeAliEs)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1032OpeAliEs", A1032OpeAliEs);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf9P2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "OperandoGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf9P2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e159P2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H009P2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1032OpeAliEs = H009P2_A1032OpeAliEs[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1032OpeAliEs", A1032OpeAliEs);
            A932OpeEsCant = H009P2_A932OpeEsCant[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A932OpeEsCant", A932OpeEsCant);
            A474OpeDescripcion = H009P2_A474OpeDescripcion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A474OpeDescripcion", A474OpeDescripcion);
            A473OpeCodFormula = H009P2_A473OpeCodFormula[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A473OpeCodFormula", A473OpeCodFormula);
            /* Execute user event: Load */
            e149P2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb9P0( ) ;
      }
   }

   public void send_integrity_lvl_hashes9P2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "OperandoGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup9P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e139P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA74idOperando = httpContext.cgiGet( sPrefix+"wcpOA74idOperando") ;
         /* Read variables values. */
         A473OpeCodFormula = httpContext.cgiGet( edtOpeCodFormula_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A473OpeCodFormula", A473OpeCodFormula);
         A474OpeDescripcion = httpContext.cgiGet( edtOpeDescripcion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A474OpeDescripcion", A474OpeDescripcion);
         A932OpeEsCant = GXutil.strtobool( httpContext.cgiGet( chkOpeEsCant.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A932OpeEsCant", A932OpeEsCant);
         A1032OpeAliEs = GXutil.strtobool( httpContext.cgiGet( chkOpeAliEs.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1032OpeAliEs", A1032OpeAliEs);
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
      e139P2 ();
      if (returnInSub) return;
   }

   public void e139P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      operandogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e149P2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWOperando_Update", GXv_boolean5) ;
      operandogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWOperando_Delete", GXv_boolean5) ;
      operandogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Calculo" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e159P2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      operandogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A74idOperando = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A74idOperando", A74idOperando);
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
      pa9P2( ) ;
      ws9P2( ) ;
      we9P2( ) ;
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
      sCtrlA46PaiCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlA74idOperando = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa9P2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "operandogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa9P2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A74idOperando = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A74idOperando", A74idOperando);
      }
      wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA74idOperando = httpContext.cgiGet( sPrefix+"wcpOA74idOperando") ;
      if ( ! GetJustCreated( ) && ( ( A46PaiCod != wcpOA46PaiCod ) || ( GXutil.strcmp(A74idOperando, wcpOA74idOperando) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA46PaiCod = A46PaiCod ;
      wcpOA74idOperando = A74idOperando ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA46PaiCod = httpContext.cgiGet( sPrefix+"A46PaiCod_CTRL") ;
      if ( GXutil.len( sCtrlA46PaiCod) > 0 )
      {
         A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA46PaiCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A46PaiCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA74idOperando = httpContext.cgiGet( sPrefix+"A74idOperando_CTRL") ;
      if ( GXutil.len( sCtrlA74idOperando) > 0 )
      {
         A74idOperando = httpContext.cgiGet( sCtrlA74idOperando) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A74idOperando", A74idOperando);
      }
      else
      {
         A74idOperando = httpContext.cgiGet( sPrefix+"A74idOperando_PARM") ;
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
      pa9P2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws9P2( ) ;
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
      ws9P2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A46PaiCod_PARM", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA46PaiCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A46PaiCod_CTRL", GXutil.rtrim( sCtrlA46PaiCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A74idOperando_PARM", GXutil.rtrim( A74idOperando));
      if ( GXutil.len( GXutil.rtrim( sCtrlA74idOperando)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A74idOperando_CTRL", GXutil.rtrim( sCtrlA74idOperando));
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
      we9P2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202032221", true, true);
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
      httpContext.AddJavascriptSource("operandogeneral.js", "?202412202032221", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbidOperando.setInternalname( sPrefix+"IDOPERANDO" );
      edtOpeCodFormula_Internalname = sPrefix+"OPECODFORMULA" ;
      edtOpeDescripcion_Internalname = sPrefix+"OPEDESCRIPCION" ;
      chkOpeEsCant.setInternalname( sPrefix+"OPEESCANT" );
      chkOpeAliEs.setInternalname( sPrefix+"OPEALIES" );
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtPaiCod_Internalname = sPrefix+"PAICOD" ;
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
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      chkOpeAliEs.setEnabled( 0 );
      chkOpeEsCant.setEnabled( 0 );
      edtOpeDescripcion_Enabled = 0 ;
      edtOpeCodFormula_Jsonclick = "" ;
      edtOpeCodFormula_Enabled = 0 ;
      cmbidOperando.setJsonclick( "" );
      cmbidOperando.setEnabled( 0 );
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
      cmbidOperando.setName( "IDOPERANDO" );
      cmbidOperando.setWebtags( "" );
      cmbidOperando.addItem("[antiguedad]", httpContext.getMessage( "Antiguedad en años", ""), (short)(0));
      cmbidOperando.addItem("[antiguedad_indemnizacion]", httpContext.getMessage( "Antig. fracción 3 meses = 1 año", ""), (short)(0));
      cmbidOperando.addItem("{concepto}", httpContext.getMessage( "Concepto", ""), (short)(0));
      cmbidOperando.addItem("{conceptos}", httpContext.getMessage( "Conceptos", ""), (short)(0));
      cmbidOperando.addItem("[dias_mes]", httpContext.getMessage( "Cantidad de dias del mes. Si el parámetro \"Todos los meses tienen 30 dias\" está en \"Si\", devuelve el valor 30, si no devuelve la cantidad de días del mes reales.", ""), (short)(0));
      cmbidOperando.addItem("[dias_semestre]", httpContext.getMessage( "Cantidad de dias del semestre. Tiene en cuenta el parámetro \"Todos los meses tienen 30 días\" para calcular la cantidad de días del semestre.", ""), (short)(0));
      cmbidOperando.addItem("[dias_trabajados_mes]", httpContext.getMessage( "Cantidad de dias trabajados de forma normal en el mes. Es la cantidad de días del mes menos los días de licencia y los días feriados trabajados (que se liquidan aparte), contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbidOperando.addItem("[dias_remunerados_semestre]", httpContext.getMessage( "Cantidad de dias remunerados en el semestre. Es la cantidad de días del semestre menos las ausencias injustificadas, contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbidOperando.addItem("[plan_medico]", httpContext.getMessage( "Plan Médico", ""), (short)(0));
      cmbidOperando.addItem("[remu_var]", httpContext.getMessage( "Remuneraciones Variables", ""), (short)(0));
      cmbidOperando.addItem("[basico_mensual]", httpContext.getMessage( "Sueldo Básico Mensual", ""), (short)(0));
      cmbidOperando.addItem("[contr_OS_ali]", httpContext.getMessage( "Alícuota para contribución patronal destinada a obra social", ""), (short)(0));
      cmbidOperando.addItem("[contr_FSR_ali]", httpContext.getMessage( "Alìcuota para contribuciòn patronal destinada a FSR (ex ANSSAL)", ""), (short)(0));
      cmbidOperando.addItem("[apo_Dif]", httpContext.getMessage( "Total No Remunerativos que tributan a  aporte de Régimenes Diferenciales", ""), (short)(0));
      cmbidOperando.addItem("[tipoLiq]", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
      cmbidOperando.addItem("[mes_Periodo]", httpContext.getMessage( "Mes Periodo", ""), (short)(0));
      cmbidOperando.addItem("[novedad_cantidad]", httpContext.getMessage( "Cantidad de horas (jornalizados) o días (mensualizados) informadas en agenda de novedades", ""), (short)(0));
      cmbidOperando.addItem("[novedad_importe]", httpContext.getMessage( "Importe informado en agenda de novedades", ""), (short)(0));
      cmbidOperando.addItem("[ART_ali]", httpContext.getMessage( "Alícuota de Contribución Patronal ART según Empresa", ""), (short)(0));
      cmbidOperando.addItem("[gan_cuotas]", httpContext.getMessage( "Ganancias - Cantidad de cuotas faltantes", ""), (short)(0));
      cmbidOperando.addItem("[con_discapacidad]", httpContext.getMessage( "Legajo con Discapacidad", ""), (short)(0));
      cmbidOperando.addItem("[sexo]", httpContext.getMessage( "Legajo Sexo", ""), (short)(0));
      cmbidOperando.addItem("[motivo_egreso]", httpContext.getMessage( "Legajo Motivo de Egreso", ""), (short)(0));
      cmbidOperando.addItem("[area]", httpContext.getMessage( "Legajo Area", ""), (short)(0));
      cmbidOperando.addItem("[categoria]", httpContext.getMessage( "Legajo Categoria", ""), (short)(0));
      cmbidOperando.addItem("[convenio]", httpContext.getMessage( "Legajo Convenio", ""), (short)(0));
      cmbidOperando.addItem("[clase]", httpContext.getMessage( "Legajo Clase", ""), (short)(0));
      cmbidOperando.addItem("[sindicato]", httpContext.getMessage( "Legajo Sindicato", ""), (short)(0));
      cmbidOperando.addItem("[obraSocial]", httpContext.getMessage( "Obra Social_", ""), (short)(0));
      cmbidOperando.addItem("[edad]", httpContext.getMessage( "Edad", ""), (short)(0));
      cmbidOperando.addItem("[monto_siradig]", httpContext.getMessage( "Importes de items ingresados en SIRADIG al 100% para el concepto. En el caso de deducciones generales anuales el importe se aplicará en el mes de diciembre o en liquidación final.", ""), (short)(0));
      cmbidOperando.addItem("[hora_basica]", httpContext.getMessage( "Valor hora básico", ""), (short)(0));
      cmbidOperando.addItem("[horas_extras_exentas]", httpContext.getMessage( "Horas extras exentas.", ""), (short)(0));
      cmbidOperando.addItem("[exentas]", httpContext.getMessage( "Ganancias - remuneraciones totalmente exentas.", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_ley_ganancias]", httpContext.getMessage( "Ganancias - Descuentos de ley sobre remuneración bruta", ""), (short)(0));
      cmbidOperando.addItem("[deduce_conyuge]", httpContext.getMessage( "Ganancias - Deduce conyuge", ""), (short)(0));
      cmbidOperando.addItem("[cant_hijos]", httpContext.getMessage( "Cantidad de hijos menores a 18 años, no incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[cant_hijos_incap]", httpContext.getMessage( "Cantidad de hijos incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[prc_ded_hijos]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos no incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[prc_ded_hijos_incap]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[ded_esp_inc]", httpContext.getMessage( "Deduccion especial incrementada", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_anticipo_sac]", httpContext.getMessage( "Descuentos de ley sobre anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[pagos_a_cuenta_anteriores]", httpContext.getMessage( "Pagos a cuenta actualizados. Se recorren las liquidaciones de periodos anteriores para tomar los valores actualizados de pagos a cuenta considerando la carga al día de SIRADIG", ""), (short)(0));
      cmbidOperando.addItem("[alicuota_ley]", httpContext.getMessage( "Alicuota total descuentos de ley según legajo", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_bruto_promedio]", httpContext.getMessage( "Sueldo Bruto Promedio Anual. Este valor es recalculado de forma retroactiva para siempre reflejar el promedio más actualizado", ""), (short)(0));
      cmbidOperando.addItem("[nro_cuota]", httpContext.getMessage( "Número de cuota para ganancias. En liquidaciones de egreso en donde el empleado no continua relación con otro empleador el valor equivale a la cantidad de cuotas totales del año.", ""), (short)(0));
      cmbidOperando.addItem("[agente_retencion]", httpContext.getMessage( "Empresa es agente de retención para el empleado", ""), (short)(0));
      cmbidOperando.addItem("[mni_zona]", httpContext.getMessage( "Deducción [Artículo 30, inciso a)] Mínimo no imponible. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_hijo_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_hijo_incap_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo incapacitado para el trabajo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_cony_zona]", httpContext.getMessage( "Deducción [Art. 30] Cónyuge / unión convivencial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_especial_zona]", httpContext.getMessage( "Deducción [Art. 30, inc c, A. 2] Especial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[cant_cuotas]", httpContext.getMessage( "Cantidad de cuotas a retener ganancias", ""), (short)(0));
      cmbidOperando.addItem("[f1357_saldo]", httpContext.getMessage( "Saldo de F1357 del año anterior. Aplica en el mes de abril.", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_retencion]", httpContext.getMessage( "Descuentos de Ley más descuentos sobre anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[os_cantidad_adherentes]", httpContext.getMessage( "Cantidad de adherentes adicionales a la obra social", ""), (short)(0));
      cmbidOperando.addItem("[horas_mes]", httpContext.getMessage( "Horas del mes según categoría, o en su defecto el valor de la variable de horas mes default", ""), (short)(0));
      cmbidOperando.addItem("[os_apo_adic]", httpContext.getMessage( "Aporte adicional obra social", ""), (short)(0));
      cmbidOperando.addItem("[horas_jornal]", httpContext.getMessage( "Horas por día que trabaja el empleado", ""), (short)(0));
      cmbidOperando.addItem("[dias_vacaciones]", httpContext.getMessage( "Cantidad de días de vacaciones del periodo", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_licencia]", httpContext.getMessage( "Càlculo de remuneraciòn por la licencia paga", ""), (short)(0));
      cmbidOperando.addItem("[viaticos]", httpContext.getMessage( "Total de viáticos. Incluye importes de otros empleos informado en siradig para el periodo", ""), (short)(0));
      cmbidOperando.addItem("[materiales_didacticos]", httpContext.getMessage( "Total de materiales didácticos de personal docente. Incluye importes de otros empleos informados en siradig para el periodo", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_sobre_gravados]", httpContext.getMessage( "Descuentos de ley sobre impuesto gravado", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_vacaciones_no_gozadas]", httpContext.getMessage( "Mismo cálculo que se realiza para vacaciones, pero la cantidad de días es la que corresponde por ley según años de antiguedad, siempre y cuando el empleado no se haya tomado ya las vacaciones.", ""), (short)(0));
      cmbidOperando.addItem("[tope_indemnizatorio]", httpContext.getMessage( "Tope Indemnizatorio del convenio", ""), (short)(0));
      cmbidOperando.addItem("[alicuota_sindical]", httpContext.getMessage( "Alícuota de cuota sindical", ""), (short)(0));
      cmbidOperando.addItem("[adelanto_retencion]", httpContext.getMessage( "Adelanto de retencion de ganancias", ""), (short)(0));
      cmbidOperando.addItem("[adicional_convenio]", httpContext.getMessage( "Adicional por convenio", ""), (short)(0));
      cmbidOperando.addItem("[horas_jornada_completa]", httpContext.getMessage( "Cantidad de horas de la jornada completa", ""), (short)(0));
      cmbidOperando.addItem("[valor_categoria]", httpContext.getMessage( "Sueldo Categoria", ""), (short)(0));
      cmbidOperando.addItem("{feriado_trabajado_horas}", httpContext.getMessage( "Horas feriado trabajado", ""), (short)(0));
      cmbidOperando.addItem("[feriados_no_trabajados]", httpContext.getMessage( "Feriados no trabajados", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_5]", httpContext.getMessage( "Base imponible 5 -Aportes INSSJYP", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_2]", httpContext.getMessage( "Base imponible 2 - CONTRIBUCIONES SIPA E INSSJYP", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_3]", httpContext.getMessage( "base Imponible 3 - ONTRIBUCIONES FNE, AAFF, Y RENATRE", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_4]", httpContext.getMessage( "Base imponible 4 - APORTES OS Y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_dif_apo_OS_FSR]", httpContext.getMessage( "base Diferencial - Aportes OS y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_dif_con_OS_FSR]", httpContext.getMessage( "Base diferencial - Contribuciones OS y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_8]", httpContext.getMessage( "base Imponible 8  -  CONTRIBUCIONES OS Y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_9]", httpContext.getMessage( "base Imponible 9 - CONTRIBUCIONES LRT", ""), (short)(0));
      cmbidOperando.addItem("[importe_a_detraer]", httpContext.getMessage( "Importe a detraer", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_6]", httpContext.getMessage( "Base imponible 6 - APORTES DIFERENCIALES", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_7]", httpContext.getMessage( "base Imponible 7 - APORTES ESPECIALES", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_adelanto_vacaciones]", httpContext.getMessage( "Remuneracion adelanto de vacaciones", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_bruto]", httpContext.getMessage( "Sueldo Bruto", ""), (short)(0));
      cmbidOperando.addItem("[descuento_adelanto]", httpContext.getMessage( "Descuento por adelanto", ""), (short)(0));
      cmbidOperando.addItem("[dias_proporcionar_tope]", httpContext.getMessage( "Días para proporcionar tope para cálculo de máximo imponible de sueldo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_1_sueldo]", httpContext.getMessage( "Tope para base imponible 1 sueldo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_sac]", httpContext.getMessage( "Tope para base imponible para SAC", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_adelantoVac]", httpContext.getMessage( "Tope para base imponible para adelanto de vacaciones de mes próximo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_1]", httpContext.getMessage( "Base imponible 1 - Aportes SIPA", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_basico]", httpContext.getMessage( "Sueldo básico", ""), (short)(0));
      cmbidOperando.addItem("[calculo_sac]", httpContext.getMessage( "Cálculo SAC", ""), (short)(0));
      cmbidOperando.addItem("[haberes_sac]", httpContext.getMessage( "Haberes Sac", ""), (short)(0));
      cmbidOperando.addItem("[anticipo_sac]", httpContext.getMessage( "Anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[sac_estimado]", httpContext.getMessage( "Estimación de próximo SAC", ""), (short)(0));
      cmbidOperando.addItem("[total_exentos_sin_sac]", httpContext.getMessage( "Total Exentos Sin Sac", ""), (short)(0));
      cmbidOperando.addItem("[cuotas_prorrateo]", httpContext.getMessage( "Cuotas prorrateos", ""), (short)(0));
      cmbidOperando.addItem("[prorrateables]", httpContext.getMessage( "Prorrateables", ""), (short)(0));
      cmbidOperando.addItem("[exento_concepto]", httpContext.getMessage( "Cálculo exento", ""), (short)(0));
      cmbidOperando.addItem("[deduccion]", httpContext.getMessage( "Calculo Deduccion", ""), (short)(0));
      cmbidOperando.addItem("[retencion_ganancias]", httpContext.getMessage( "Retención ganancias", ""), (short)(0));
      cmbidOperando.addItem("[empresa_antiguedad]", httpContext.getMessage( "Importe o alícuota para antiguedad por empresa (fuera de convenio)", ""), (short)(0));
      cmbidOperando.addItem("[empresa_presentismo]", httpContext.getMessage( "Importe o alícuota para presentismo por empresa (fuera de convenio)", ""), (short)(0));
      cmbidOperando.addItem("[asistencia_perfecta]", httpContext.getMessage( "Flag de asistencia perfecta. Si se registran faltas injustificadas o llegadas tarde es 0, caso contrario es 1", ""), (short)(0));
      cmbidOperando.addItem("[es_primera_quincena]", httpContext.getMessage( "Es primera quincena", ""), (short)(0));
      cmbidOperando.addItem("[ART_fijo]", httpContext.getMessage( "Importe fijo de ART", ""), (short)(0));
      cmbidOperando.addItem("[contr_jub_ali]", httpContext.getMessage( "Alìcuota de contribuciòn dej ubilaciòn", ""), (short)(0));
      cmbidOperando.addItem("[contr_inssjyp_ali]", httpContext.getMessage( "Alìcuota de contribución PAMI", ""), (short)(0));
      cmbidOperando.addItem("[contr_aaff_ali]", httpContext.getMessage( "Alìcuota de contribuciòn asignaciones familiares", ""), (short)(0));
      cmbidOperando.addItem("[contr_fne_ali]", httpContext.getMessage( "Alìcuota de contribuciòn fondo nacional de empleo", ""), (short)(0));
      cmbidOperando.addItem("[obligacion]", httpContext.getMessage( "Obligación", ""), (short)(0));
      cmbidOperando.addItem("[liquidar_sac]", httpContext.getMessage( "liquidar_sac", ""), (short)(0));
      cmbidOperando.addItem("[plus_vacacional]", httpContext.getMessage( "Plus Vacacional", ""), (short)(0));
      cmbidOperando.addItem("[no_laborables]", httpContext.getMessage( "Días no laborables no trabajados", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_descuento]", httpContext.getMessage( "Ausencias injustificadas", ""), (short)(0));
      cmbidOperando.addItem("[dias_proporcionar_sac]", httpContext.getMessage( "Cantidad de días para proporcionar SAC", ""), (short)(0));
      cmbidOperando.addItem("[hora_normal]", httpContext.getMessage( "Valor de hora normal", ""), (short)(0));
      cmbidOperando.addItem("[extra]", httpContext.getMessage( "Aumento de hora extra sobre hora normal", ""), (short)(0));
      cmbidOperando.addItem("[recargo]", httpContext.getMessage( "Recargo por tipo de trabajo (por ejemplo nocturno)", ""), (short)(0));
      cmbidOperando.addItem("[jubilacion]", httpContext.getMessage( "Jubilación", ""), (short)(0));
      cmbidOperando.addItem("[obra_social]", httpContext.getMessage( "Obra Social", ""), (short)(0));
      cmbidOperando.addItem("[ley_19032]", httpContext.getMessage( "Ley 19032", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_accidente_empresa]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de la empresa", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_accidente_ART]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de ART", ""), (short)(0));
      cmbidOperando.addItem("[ultimo_dia_mes]", httpContext.getMessage( "Ultimo día del mes", ""), (short)(0));
      cmbidOperando.addItem("[dia_fecha_egreso]", httpContext.getMessage( "Día de fecha de egreso", ""), (short)(0));
      cmbidOperando.addItem("[indemnizacion_antiguedad]", httpContext.getMessage( "Indemnización por antiguedad", ""), (short)(0));
      cmbidOperando.addItem("[proporcion_antiguedad_motivo]", httpContext.getMessage( "Proporción según antiguedad y motivo de egreso definido en el concepto", ""), (short)(0));
      cmbidOperando.addItem("[reintegro_guarderia]", httpContext.getMessage( "Reintegro por gastos de guardería", ""), (short)(0));
      cmbidOperando.addItem("[beneficio_guarderia]", httpContext.getMessage( "Beneficio Guarderia", ""), (short)(0));
      cmbidOperando.addItem("[ultimo_dia_mes_egreso]", httpContext.getMessage( "Ultimo día del mes de egreso", ""), (short)(0));
      cmbidOperando.addItem("[dias_mes_egreso]", httpContext.getMessage( "Cantidad de días del mes de egreso", ""), (short)(0));
      cmbidOperando.addItem("[cuota_sindical]", httpContext.getMessage( "Cuota sindical", ""), (short)(0));
      cmbidOperando.addItem("[obra_social_adherentes]", httpContext.getMessage( "Obra Social Adherentes", ""), (short)(0));
      cmbidOperando.addItem("[antiguedad_importe]", httpContext.getMessage( "Antiguedad importe", ""), (short)(0));
      cmbidOperando.addItem("[presentismo_importe]", httpContext.getMessage( "Presentismo importe", ""), (short)(0));
      cmbidOperando.addItem("{sueldo}", httpContext.getMessage( "Sueldo", ""), (short)(0));
      cmbidOperando.addItem("{hora_completa}", httpContext.getMessage( "Hora básica más adicional", ""), (short)(0));
      cmbidOperando.addItem("{feriados_trabajados}", httpContext.getMessage( "Feriados trabajados", ""), (short)(0));
      cmbidOperando.addItem("[vacaciones_descuento]", httpContext.getMessage( "Descuento por días no trabajados por vacaciones", ""), (short)(0));
      cmbidOperando.addItem("[licencias_descuento]", httpContext.getMessage( "Descuento por días no trabajados por licencias", ""), (short)(0));
      cmbidOperando.addItem("{feriados_no_trabajados_descuento}", httpContext.getMessage( "Descuento por días no trabajados feriados", ""), (short)(0));
      cmbidOperando.addItem("{no_laborables_descuento}", httpContext.getMessage( "Descuento por días no trabajados no laborables", ""), (short)(0));
      cmbidOperando.addItem("{sac}", httpContext.getMessage( "Sueldo anual complementario", ""), (short)(0));
      cmbidOperando.addItem("{sac_proporcional}", httpContext.getMessage( "SAC Proporcional", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_adicional}", httpContext.getMessage( "Sueldo Adicional", ""), (short)(0));
      cmbidOperando.addItem("{vacaciones_no_gozadas_ant}", httpContext.getMessage( "Vacaciones no gozadas de año anterior", ""), (short)(0));
      cmbidOperando.addItem("{egreso_descuento}", httpContext.getMessage( "Descuento por días no trabajados por egreso", ""), (short)(0));
      cmbidOperando.addItem("{obra_social_diferencial}", httpContext.getMessage( "Obra social diferencial", ""), (short)(0));
      cmbidOperando.addItem("{dias_HastaFinSemestre}", httpContext.getMessage( "Dias faltantes hasta el fin del semestre", ""), (short)(0));
      cmbidOperando.addItem("{tratamiento_exencion}", httpContext.getMessage( "Cálculo exento por tratamiento de exención de IIGG", ""), (short)(0));
      cmbidOperando.addItem("{horas_nocturnas}", httpContext.getMessage( "Adicional por horas nocturna", ""), (short)(0));
      cmbidOperando.addItem("{extras_al_50}", httpContext.getMessage( "Horas extras al 50%", ""), (short)(0));
      cmbidOperando.addItem("{extras_nocturnas_al_50}", httpContext.getMessage( "Horas extras nocturnas al 50%", ""), (short)(0));
      cmbidOperando.addItem("{extras_nocturnas_al_100}", httpContext.getMessage( "Horas extras nocturnas al 100%", ""), (short)(0));
      cmbidOperando.addItem("{extras_al_100}", httpContext.getMessage( "Horas extras al 100%", ""), (short)(0));
      cmbidOperando.addItem("{retroactivo}", httpContext.getMessage( "Recálculo de liquidaciones anteriores para calcular valores retroactivos", ""), (short)(0));
      cmbidOperando.addItem("{fondo_cese}", httpContext.getMessage( "Fondo de cese laboral", ""), (short)(0));
      cmbidOperando.addItem("{plus_licencia}", httpContext.getMessage( "Plus Licencia", ""), (short)(0));
      cmbidOperando.addItem("{redondeo}", httpContext.getMessage( "Redondeo", ""), (short)(0));
      cmbidOperando.addItem("{leg_prop_adi}", httpContext.getMessage( "Propiedad adicional de legajo", ""), (short)(0));
      cmbidOperando.addItem("{ded_art_30}", httpContext.getMessage( "Deducciones artículo 30", ""), (short)(0));
      cmbidOperando.addItem("{devolucion_ganancias}", httpContext.getMessage( "Devolución ganancias", ""), (short)(0));
      cmbidOperando.addItem("{ded_gen_men}", httpContext.getMessage( "Deducciones generales mensuales", ""), (short)(0));
      cmbidOperando.addItem("{ded_gen_anu}", httpContext.getMessage( "Deducciones generales anuales", ""), (short)(0));
      cmbidOperando.addItem("{rem_gravada_gan}", httpContext.getMessage( "Remuneración gravada en ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gan_neta}", httpContext.getMessage( "Ganancia neta para impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gnsi_sin_dei}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias, menos deducción especial incrementada", ""), (short)(0));
      cmbidOperando.addItem("{gnsi}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gan_neta_topes}", httpContext.getMessage( "Ganancia neta para calcular topes de deducciones de impuestos a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{calculo_iigg_neto}", httpContext.getMessage( "Cálculo de impuesto a las ganancias menos pagos a cuenta de periodos anteriores e importes pagados en liquidaciones anteriores", ""), (short)(0));
      cmbidOperando.addItem("{importe_iigg}", httpContext.getMessage( "Importe a retener de impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("[calculo_iigg]", httpContext.getMessage( "Cálculo de impuesto a las ganancias usando tabla de escalas de AFIP", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_bruto_ganancias}", httpContext.getMessage( "Sueldo Bruto más sueldo bruto de otros empleos", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_bruto_menos_ley}", httpContext.getMessage( "Sueldo bruto menos descuentos de ley", ""), (short)(0));
      cmbidOperando.addItem("{alcanza_ganancias}", httpContext.getMessage( "Empleado es alcanzado por impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_jubilacion}", httpContext.getMessage( "Contribución jubilación", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_inssjp}", httpContext.getMessage( "Contribución  ley 19032", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_aaff}", httpContext.getMessage( "Contribución asignaciones familiares", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_fne}", httpContext.getMessage( "Contribución FNE", ""), (short)(0));
      cmbidOperando.addItem("{grossing_up}", httpContext.getMessage( "Grossing up", ""), (short)(0));
      if ( cmbidOperando.getItemCount() > 0 )
      {
      }
      chkOpeEsCant.setName( "OPEESCANT" );
      chkOpeEsCant.setWebtags( "" );
      chkOpeEsCant.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkOpeEsCant.getInternalname(), "TitleCaption", chkOpeEsCant.getCaption(), true);
      chkOpeEsCant.setCheckedValue( "false" );
      chkOpeAliEs.setName( "OPEALIES" );
      chkOpeAliEs.setWebtags( "" );
      chkOpeAliEs.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkOpeAliEs.getInternalname(), "TitleCaption", chkOpeAliEs.getCaption(), true);
      chkOpeAliEs.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'cmbidOperando'},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e119P1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'cmbidOperando'},{av:'A74idOperando',fld:'IDOPERANDO',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e129P1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'cmbidOperando'},{av:'A74idOperando',fld:'IDOPERANDO',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_IDOPERANDO","{handler:'valid_Idoperando',iparms:[]");
      setEventMetadata("VALID_IDOPERANDO",",oparms:[]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[]");
      setEventMetadata("VALID_PAICOD",",oparms:[]}");
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
      wcpOA74idOperando = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A74idOperando = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A473OpeCodFormula = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A474OpeDescripcion = "" ;
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
      H009P2_A46PaiCod = new short[1] ;
      H009P2_A74idOperando = new String[] {""} ;
      H009P2_A1032OpeAliEs = new boolean[] {false} ;
      H009P2_A932OpeEsCant = new boolean[] {false} ;
      H009P2_A474OpeDescripcion = new String[] {""} ;
      H009P2_A473OpeCodFormula = new String[] {""} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA46PaiCod = "" ;
      sCtrlA74idOperando = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.operandogeneral__default(),
         new Object[] {
             new Object[] {
            H009P2_A46PaiCod, H009P2_A74idOperando, H009P2_A1032OpeAliEs, H009P2_A932OpeEsCant, H009P2_A474OpeDescripcion, H009P2_A473OpeCodFormula
            }
         }
      );
      AV17Pgmname = "OperandoGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "OperandoGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA46PaiCod ;
   private short A46PaiCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtOpeCodFormula_Enabled ;
   private int edtOpeDescripcion_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtPaiCod_Visible ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String wcpOA74idOperando ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A74idOperando ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtOpeCodFormula_Internalname ;
   private String A473OpeCodFormula ;
   private String edtOpeCodFormula_Jsonclick ;
   private String edtOpeDescripcion_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String TempTags ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String sCtrlA46PaiCod ;
   private String sCtrlA74idOperando ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A932OpeEsCant ;
   private boolean A1032OpeAliEs ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A474OpeDescripcion ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private HTMLChoice cmbidOperando ;
   private ICheckbox chkOpeEsCant ;
   private ICheckbox chkOpeAliEs ;
   private IDataStoreProvider pr_default ;
   private short[] H009P2_A46PaiCod ;
   private String[] H009P2_A74idOperando ;
   private boolean[] H009P2_A1032OpeAliEs ;
   private boolean[] H009P2_A932OpeEsCant ;
   private String[] H009P2_A474OpeDescripcion ;
   private String[] H009P2_A473OpeCodFormula ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class operandogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H009P2", "SELECT PaiCod, idOperando, OpeAliEs, OpeEsCant, OpeDescripcion, OpeCodFormula FROM calculo WHERE PaiCod = ? and idOperando = ( ?) ORDER BY PaiCod, idOperando ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

