package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paisgeneral_impl extends GXWebComponent
{
   public paisgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paisgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisgeneral_impl.class ));
   }

   public paisgeneral_impl( int remoteHandle ,
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
      chkPaiNacMostrar = UIFactory.getCheckbox(this);
      chkPaiDomMostrar = UIFactory.getCheckbox(this);
      chkPaiFondoCese = UIFactory.getCheckbox(this);
      cmbPaiPerVacDes = new HTMLChoice();
      cmbPaiPerVacHas = new HTMLChoice();
      chkPaiExcVizzoti = UIFactory.getCheckbox(this);
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
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A46PaiCod)});
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
         paCT2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Pais General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paisgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0))}, new String[] {"PaiCod"}) +"\">") ;
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
   }

   public void renderHtmlCloseFormCT2( )
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
      return "PaisGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Pais General", "") ;
   }

   public void wbCT0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.paisgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiCod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiCod_Internalname, httpContext.getMessage( "Cod. Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_PaisGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiNom_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiNom_Internalname, httpContext.getMessage( "Nom. Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiNom_Internalname, A312PaiNom, GXutil.rtrim( localUtil.format( A312PaiNom, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiNom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiNom_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_PaisGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiNacMostrar.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkPaiNacMostrar.getInternalname(), httpContext.getMessage( "Nac Mostrar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiNacMostrar.getInternalname(), GXutil.booltostr( A311PaiNacMostrar), "", httpContext.getMessage( "Nac Mostrar", ""), 1, chkPaiNacMostrar.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiDomMostrar.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkPaiDomMostrar.getInternalname(), httpContext.getMessage( "Dom Mostrar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiDomMostrar.getInternalname(), GXutil.booltostr( A310PaiDomMostrar), "", httpContext.getMessage( "Dom Mostrar", ""), 1, chkPaiDomMostrar.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiReligDefault_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiReligDefault_Internalname, httpContext.getMessage( "Relig Default", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiReligDefault_Internalname, GXutil.rtrim( A1252PaiReligDefault), GXutil.rtrim( localUtil.format( A1252PaiReligDefault, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiReligDefault_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiReligDefault_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PaisGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiFondoCese.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkPaiFondoCese.getInternalname(), httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiFondoCese.getInternalname(), GXutil.booltostr( A1402PaiFondoCese), "", httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", ""), 1, chkPaiFondoCese.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiPerVacDes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbPaiPerVacDes.getInternalname(), httpContext.getMessage( "Periodo de vacaciones desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiPerVacDes, cmbPaiPerVacDes.getInternalname(), GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0)), 1, cmbPaiPerVacDes.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPaiPerVacDes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_PaisGeneral.htm");
         cmbPaiPerVacDes.setValue( GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiPerVacDes.getInternalname(), "Values", cmbPaiPerVacDes.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiPerVacHas.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbPaiPerVacHas.getInternalname(), httpContext.getMessage( "Periodo de vacaciones hasta", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiPerVacHas, cmbPaiPerVacHas.getInternalname(), GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0)), 1, cmbPaiPerVacHas.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPaiPerVacHas.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_PaisGeneral.htm");
         cmbPaiPerVacHas.setValue( GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiPerVacHas.getInternalname(), "Values", cmbPaiPerVacHas.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiFracVacAnt_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiFracVacAnt_Internalname, httpContext.getMessage( "Proporción de días de vacaciones disponibles pendientes de goce del año anterior", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiFracVacAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1814PaiFracVacAnt, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiFracVacAnt_Enabled!=0) ? localUtil.format( A1814PaiFracVacAnt, "9.9999") : localUtil.format( A1814PaiFracVacAnt, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiFracVacAnt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiFracVacAnt_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_PaisGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiExcVizzoti.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkPaiExcVizzoti.getInternalname(), httpContext.getMessage( "Considerar excepción a uso de tope (fallo Vizzoti)", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiExcVizzoti.getInternalname(), GXutil.booltostr( A1736PaiExcVizzoti), "", httpContext.getMessage( "Considerar excepción a uso de tope (fallo Vizzoti)", ""), 1, chkPaiExcVizzoti.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiVizzoti_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiVizzoti_Internalname, httpContext.getMessage( "Proporción de sueldo para evaluar tope (fallo Vizzoti)", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiVizzoti_Internalname, GXutil.ltrim( localUtil.ntoc( A1737PaiVizzoti, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiVizzoti_Enabled!=0) ? localUtil.format( A1737PaiVizzoti, "9.9999") : localUtil.format( A1737PaiVizzoti, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiVizzoti_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiVizzoti_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_PaisGeneral.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11ct1_client"+"'", TempTags, "", 2, "HLP_PaisGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12ct1_client"+"'", TempTags, "", 2, "HLP_PaisGeneral.htm");
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

   public void startCT2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Pais General", ""), (short)(0)) ;
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
            strupCT0( ) ;
         }
      }
   }

   public void wsCT2( )
   {
      startCT2( ) ;
      evtCT2( ) ;
   }

   public void evtCT2( )
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
                              strupCT0( ) ;
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
                              strupCT0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13CT2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupCT0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14CT2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupCT0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15CT2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupCT0( ) ;
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
                              strupCT0( ) ;
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

   public void weCT2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormCT2( ) ;
         }
      }
   }

   public void paCT2( )
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
      A311PaiNacMostrar = GXutil.strtobool( GXutil.booltostr( A311PaiNacMostrar)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A311PaiNacMostrar", A311PaiNacMostrar);
      A310PaiDomMostrar = GXutil.strtobool( GXutil.booltostr( A310PaiDomMostrar)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A310PaiDomMostrar", A310PaiDomMostrar);
      A1402PaiFondoCese = GXutil.strtobool( GXutil.booltostr( A1402PaiFondoCese)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1402PaiFondoCese", A1402PaiFondoCese);
      if ( cmbPaiPerVacDes.getItemCount() > 0 )
      {
         A1521PaiPerVacDes = (byte)(GXutil.lval( cmbPaiPerVacDes.getValidValue(GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1521PaiPerVacDes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1521PaiPerVacDes), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiPerVacDes.setValue( GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiPerVacDes.getInternalname(), "Values", cmbPaiPerVacDes.ToJavascriptSource(), true);
      }
      if ( cmbPaiPerVacHas.getItemCount() > 0 )
      {
         A1522PaiPerVacHas = (byte)(GXutil.lval( cmbPaiPerVacHas.getValidValue(GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1522PaiPerVacHas", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1522PaiPerVacHas), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiPerVacHas.setValue( GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiPerVacHas.getInternalname(), "Values", cmbPaiPerVacHas.ToJavascriptSource(), true);
      }
      A1736PaiExcVizzoti = GXutil.strtobool( GXutil.booltostr( A1736PaiExcVizzoti)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1736PaiExcVizzoti", A1736PaiExcVizzoti);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfCT2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV20Pgmname = "PaisGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfCT2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15CT2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00CT2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1737PaiVizzoti = H00CT2_A1737PaiVizzoti[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1737PaiVizzoti", GXutil.ltrimstr( A1737PaiVizzoti, 6, 4));
            A1736PaiExcVizzoti = H00CT2_A1736PaiExcVizzoti[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1736PaiExcVizzoti", A1736PaiExcVizzoti);
            A1814PaiFracVacAnt = H00CT2_A1814PaiFracVacAnt[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1814PaiFracVacAnt", GXutil.ltrimstr( A1814PaiFracVacAnt, 6, 4));
            A1522PaiPerVacHas = H00CT2_A1522PaiPerVacHas[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1522PaiPerVacHas", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1522PaiPerVacHas), 2, 0));
            A1521PaiPerVacDes = H00CT2_A1521PaiPerVacDes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1521PaiPerVacDes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1521PaiPerVacDes), 2, 0));
            A1402PaiFondoCese = H00CT2_A1402PaiFondoCese[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1402PaiFondoCese", A1402PaiFondoCese);
            A1252PaiReligDefault = H00CT2_A1252PaiReligDefault[0] ;
            n1252PaiReligDefault = H00CT2_n1252PaiReligDefault[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1252PaiReligDefault", A1252PaiReligDefault);
            A310PaiDomMostrar = H00CT2_A310PaiDomMostrar[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A310PaiDomMostrar", A310PaiDomMostrar);
            A311PaiNacMostrar = H00CT2_A311PaiNacMostrar[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A311PaiNacMostrar", A311PaiNacMostrar);
            A312PaiNom = H00CT2_A312PaiNom[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A312PaiNom", A312PaiNom);
            /* Execute user event: Load */
            e14CT2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wbCT0( ) ;
      }
   }

   public void send_integrity_lvl_hashesCT2( )
   {
   }

   public void before_start_formulas( )
   {
      AV20Pgmname = "PaisGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupCT0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13CT2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A312PaiNom = GXutil.upper( httpContext.cgiGet( edtPaiNom_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A312PaiNom", A312PaiNom);
         A311PaiNacMostrar = GXutil.strtobool( httpContext.cgiGet( chkPaiNacMostrar.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A311PaiNacMostrar", A311PaiNacMostrar);
         A310PaiDomMostrar = GXutil.strtobool( httpContext.cgiGet( chkPaiDomMostrar.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A310PaiDomMostrar", A310PaiDomMostrar);
         A1252PaiReligDefault = httpContext.cgiGet( edtPaiReligDefault_Internalname) ;
         n1252PaiReligDefault = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1252PaiReligDefault", A1252PaiReligDefault);
         A1402PaiFondoCese = GXutil.strtobool( httpContext.cgiGet( chkPaiFondoCese.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1402PaiFondoCese", A1402PaiFondoCese);
         cmbPaiPerVacDes.setValue( httpContext.cgiGet( cmbPaiPerVacDes.getInternalname()) );
         A1521PaiPerVacDes = (byte)(GXutil.lval( httpContext.cgiGet( cmbPaiPerVacDes.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1521PaiPerVacDes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1521PaiPerVacDes), 2, 0));
         cmbPaiPerVacHas.setValue( httpContext.cgiGet( cmbPaiPerVacHas.getInternalname()) );
         A1522PaiPerVacHas = (byte)(GXutil.lval( httpContext.cgiGet( cmbPaiPerVacHas.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1522PaiPerVacHas", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1522PaiPerVacHas), 2, 0));
         A1814PaiFracVacAnt = localUtil.ctond( httpContext.cgiGet( edtPaiFracVacAnt_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1814PaiFracVacAnt", GXutil.ltrimstr( A1814PaiFracVacAnt, 6, 4));
         A1736PaiExcVizzoti = GXutil.strtobool( httpContext.cgiGet( chkPaiExcVizzoti.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1736PaiExcVizzoti", A1736PaiExcVizzoti);
         A1737PaiVizzoti = localUtil.ctond( httpContext.cgiGet( edtPaiVizzoti_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1737PaiVizzoti", GXutil.ltrimstr( A1737PaiVizzoti, 6, 4));
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
      e13CT2 ();
      if (returnInSub) return;
   }

   public void e13CT2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paisgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14CT2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais_Update", GXv_boolean5) ;
      paisgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais_Delete", GXv_boolean5) ;
      paisgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV20Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Pais" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15CT2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paisgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
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
      paCT2( ) ;
      wsCT2( ) ;
      weCT2( ) ;
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
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paCT2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "paisgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paCT2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A46PaiCod != wcpOA46PaiCod ) ) )
      {
         setjustcreated();
      }
      wcpOA46PaiCod = A46PaiCod ;
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
      paCT2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsCT2( ) ;
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
      wsCT2( ) ;
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
      weCT2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251395352", true, true);
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
      httpContext.AddJavascriptSource("paisgeneral.js", "?20251395352", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPaiCod_Internalname = sPrefix+"PAICOD" ;
      edtPaiNom_Internalname = sPrefix+"PAINOM" ;
      chkPaiNacMostrar.setInternalname( sPrefix+"PAINACMOSTRAR" );
      chkPaiDomMostrar.setInternalname( sPrefix+"PAIDOMMOSTRAR" );
      edtPaiReligDefault_Internalname = sPrefix+"PAIRELIGDEFAULT" ;
      chkPaiFondoCese.setInternalname( sPrefix+"PAIFONDOCESE" );
      cmbPaiPerVacDes.setInternalname( sPrefix+"PAIPERVACDES" );
      cmbPaiPerVacHas.setInternalname( sPrefix+"PAIPERVACHAS" );
      edtPaiFracVacAnt_Internalname = sPrefix+"PAIFRACVACANT" ;
      chkPaiExcVizzoti.setInternalname( sPrefix+"PAIEXCVIZZOTI" );
      edtPaiVizzoti_Internalname = sPrefix+"PAIVIZZOTI" ;
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
      edtPaiVizzoti_Jsonclick = "" ;
      edtPaiVizzoti_Enabled = 0 ;
      chkPaiExcVizzoti.setEnabled( 0 );
      edtPaiFracVacAnt_Jsonclick = "" ;
      edtPaiFracVacAnt_Enabled = 0 ;
      cmbPaiPerVacHas.setJsonclick( "" );
      cmbPaiPerVacHas.setEnabled( 0 );
      cmbPaiPerVacDes.setJsonclick( "" );
      cmbPaiPerVacDes.setEnabled( 0 );
      chkPaiFondoCese.setEnabled( 0 );
      edtPaiReligDefault_Jsonclick = "" ;
      edtPaiReligDefault_Enabled = 0 ;
      chkPaiDomMostrar.setEnabled( 0 );
      chkPaiNacMostrar.setEnabled( 0 );
      edtPaiNom_Jsonclick = "" ;
      edtPaiNom_Enabled = 0 ;
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 0 ;
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
      chkPaiNacMostrar.setName( "PAINACMOSTRAR" );
      chkPaiNacMostrar.setWebtags( "" );
      chkPaiNacMostrar.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiNacMostrar.getInternalname(), "TitleCaption", chkPaiNacMostrar.getCaption(), true);
      chkPaiNacMostrar.setCheckedValue( "false" );
      chkPaiDomMostrar.setName( "PAIDOMMOSTRAR" );
      chkPaiDomMostrar.setWebtags( "" );
      chkPaiDomMostrar.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiDomMostrar.getInternalname(), "TitleCaption", chkPaiDomMostrar.getCaption(), true);
      chkPaiDomMostrar.setCheckedValue( "false" );
      chkPaiFondoCese.setName( "PAIFONDOCESE" );
      chkPaiFondoCese.setWebtags( "" );
      chkPaiFondoCese.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiFondoCese.getInternalname(), "TitleCaption", chkPaiFondoCese.getCaption(), true);
      chkPaiFondoCese.setCheckedValue( "false" );
      cmbPaiPerVacDes.setName( "PAIPERVACDES" );
      cmbPaiPerVacDes.setWebtags( "" );
      cmbPaiPerVacDes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbPaiPerVacDes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbPaiPerVacDes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbPaiPerVacDes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbPaiPerVacDes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbPaiPerVacDes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbPaiPerVacDes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbPaiPerVacDes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbPaiPerVacDes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbPaiPerVacDes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbPaiPerVacDes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbPaiPerVacDes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbPaiPerVacDes.getItemCount() > 0 )
      {
      }
      cmbPaiPerVacHas.setName( "PAIPERVACHAS" );
      cmbPaiPerVacHas.setWebtags( "" );
      cmbPaiPerVacHas.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbPaiPerVacHas.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbPaiPerVacHas.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbPaiPerVacHas.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbPaiPerVacHas.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbPaiPerVacHas.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbPaiPerVacHas.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbPaiPerVacHas.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbPaiPerVacHas.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbPaiPerVacHas.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbPaiPerVacHas.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbPaiPerVacHas.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbPaiPerVacHas.getItemCount() > 0 )
      {
      }
      chkPaiExcVizzoti.setName( "PAIEXCVIZZOTI" );
      chkPaiExcVizzoti.setWebtags( "" );
      chkPaiExcVizzoti.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiExcVizzoti.getInternalname(), "TitleCaption", chkPaiExcVizzoti.getCaption(), true);
      chkPaiExcVizzoti.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A311PaiNacMostrar',fld:'PAINACMOSTRAR',pic:''},{av:'A310PaiDomMostrar',fld:'PAIDOMMOSTRAR',pic:''},{av:'A1402PaiFondoCese',fld:'PAIFONDOCESE',pic:''},{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11CT1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12CT1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A312PaiNom = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1252PaiReligDefault = "" ;
      A1814PaiFracVacAnt = DecimalUtil.ZERO ;
      A1737PaiVizzoti = DecimalUtil.ZERO ;
      TempTags = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV20Pgmname = "" ;
      scmdbuf = "" ;
      H00CT2_A46PaiCod = new short[1] ;
      H00CT2_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CT2_A1736PaiExcVizzoti = new boolean[] {false} ;
      H00CT2_A1814PaiFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00CT2_A1522PaiPerVacHas = new byte[1] ;
      H00CT2_A1521PaiPerVacDes = new byte[1] ;
      H00CT2_A1402PaiFondoCese = new boolean[] {false} ;
      H00CT2_A1252PaiReligDefault = new String[] {""} ;
      H00CT2_n1252PaiReligDefault = new boolean[] {false} ;
      H00CT2_A310PaiDomMostrar = new boolean[] {false} ;
      H00CT2_A311PaiNacMostrar = new boolean[] {false} ;
      H00CT2_A312PaiNom = new String[] {""} ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisgeneral__default(),
         new Object[] {
             new Object[] {
            H00CT2_A46PaiCod, H00CT2_A1737PaiVizzoti, H00CT2_A1736PaiExcVizzoti, H00CT2_A1814PaiFracVacAnt, H00CT2_A1522PaiPerVacHas, H00CT2_A1521PaiPerVacDes, H00CT2_A1402PaiFondoCese, H00CT2_A1252PaiReligDefault, H00CT2_n1252PaiReligDefault, H00CT2_A310PaiDomMostrar,
            H00CT2_A311PaiNacMostrar, H00CT2_A312PaiNom
            }
         }
      );
      AV20Pgmname = "PaisGeneral" ;
      /* GeneXus formulas. */
      AV20Pgmname = "PaisGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1521PaiPerVacDes ;
   private byte A1522PaiPerVacHas ;
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
   private int edtPaiCod_Enabled ;
   private int edtPaiNom_Enabled ;
   private int edtPaiReligDefault_Enabled ;
   private int edtPaiFracVacAnt_Enabled ;
   private int edtPaiVizzoti_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private java.math.BigDecimal A1814PaiFracVacAnt ;
   private java.math.BigDecimal A1737PaiVizzoti ;
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
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String edtPaiNom_Internalname ;
   private String edtPaiNom_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtPaiReligDefault_Internalname ;
   private String A1252PaiReligDefault ;
   private String edtPaiReligDefault_Jsonclick ;
   private String edtPaiFracVacAnt_Internalname ;
   private String edtPaiFracVacAnt_Jsonclick ;
   private String edtPaiVizzoti_Internalname ;
   private String edtPaiVizzoti_Jsonclick ;
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
   private String AV20Pgmname ;
   private String scmdbuf ;
   private String sCtrlA46PaiCod ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A311PaiNacMostrar ;
   private boolean A310PaiDomMostrar ;
   private boolean A1402PaiFondoCese ;
   private boolean A1736PaiExcVizzoti ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1252PaiReligDefault ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A312PaiNom ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private ICheckbox chkPaiNacMostrar ;
   private ICheckbox chkPaiDomMostrar ;
   private ICheckbox chkPaiFondoCese ;
   private HTMLChoice cmbPaiPerVacDes ;
   private HTMLChoice cmbPaiPerVacHas ;
   private ICheckbox chkPaiExcVizzoti ;
   private IDataStoreProvider pr_default ;
   private short[] H00CT2_A46PaiCod ;
   private java.math.BigDecimal[] H00CT2_A1737PaiVizzoti ;
   private boolean[] H00CT2_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] H00CT2_A1814PaiFracVacAnt ;
   private byte[] H00CT2_A1522PaiPerVacHas ;
   private byte[] H00CT2_A1521PaiPerVacDes ;
   private boolean[] H00CT2_A1402PaiFondoCese ;
   private String[] H00CT2_A1252PaiReligDefault ;
   private boolean[] H00CT2_n1252PaiReligDefault ;
   private boolean[] H00CT2_A310PaiDomMostrar ;
   private boolean[] H00CT2_A311PaiNacMostrar ;
   private String[] H00CT2_A312PaiNom ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class paisgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00CT2", "SELECT PaiCod, PaiVizzoti, PaiExcVizzoti, PaiFracVacAnt, PaiPerVacHas, PaiPerVacDes, PaiFondoCese, PaiReligDefault, PaiDomMostrar, PaiNacMostrar, PaiNom FROM Pais WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,4);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
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
               return;
      }
   }

}

